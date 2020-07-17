package com.wx.exam1.service.imp;

import com.github.pagehelper.PageHelper;
import com.wx.exam1.dao.FilmMapper;
import com.wx.exam1.domain.Film;
import com.wx.exam1.service.FilmService;
import com.wx.exam1.utils.BeanUtil;
import com.wx.exam1.domain.Page;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class FilmServiceImp implements FilmService {
    @Resource
    private FilmMapper filmMapper;

    /***
     * 插件分页查询
     * @param pageNo
     * @param pageSize
     * @return
     * @throws Exception
     */
    @Override
    public Page<Film> queryByPage(Integer pageNo, Integer pageSize) throws Exception {
        pageNo = pageNo == null ? 1 : pageNo;
        pageSize = pageSize == null ? 10 : pageSize;
        PageHelper.startPage(pageNo, pageSize);  //startPage是告诉拦截器说我要开始分页了。分页参数是这两个。
        List<Film> select = filmMapper.select();
        return BeanUtil.toPagedResult(select);
    }

    @Override
    public void insertFilm(Film film) {
        filmMapper.insertFilm(film);
    }

    @Override
    public Page<Film> query(Integer pageSize, Integer page) {
        Page page1=new Page();
        //查询总的数据条数
        Integer totalCount = filmMapper.totalCount();
        page1.setTotal(totalCount);
        //计算起始索引
        page = page == null ? 1 : page;
        pageSize = pageSize == null ? 10 : pageSize;
        page1.setPag(page);
        page1.setPageSize(pageSize);

        if (totalCount % pageSize == 0) {
            //说明整除，正好每页显示pageSize条数据，没有多余一页要显示少于pageSize条数据的
            page1.setPages(totalCount / pageSize);
        } else {
            //不整除，就要在加一页，来显示多余的数据。
            page1.setPages(totalCount / pageSize + 1);
        }
        //开始索引
        int StartIndex=(page - 1) * pageSize;
        page1.setStartIndex(StartIndex);
        List<Film> list = filmMapper.selectByPage(page1);
        page1.setDataList(list);
        return page1;
    }
}
