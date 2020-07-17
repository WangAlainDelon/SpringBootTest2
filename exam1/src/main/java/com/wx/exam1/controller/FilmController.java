package com.wx.exam1.controller;

import com.wx.exam1.annotation.MyBody;
import com.wx.exam1.domain.Film;
import com.wx.exam1.domain.Page;
import com.wx.exam1.service.FilmService;

import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping("/v1/film")
public class FilmController {
    private static final Logger logger = LoggerFactory.getLogger(FilmController.class);
    @Autowired
    private FilmService filmService;
    /**ResponseEntity是一种泛型类型。因此，我们可以使用任何类型作为响应主体：*/
    /**
     * 插入一条电影数据，返回了他的自增ID，这里只有四个个字段，film_id，title，description，language_id
     * 并且对电影的title做了非空的校验
     *
     * @param film
     * @return
     */
    //@RequestBody
    //作用： 
    //  i) 该注解用于读取Request请求的body部分数据，使用系统默认配置的HttpMessageConverter进行解析，
    //       然后把相应的数据绑定到要返回的对象上；
    //  ii) 再把HttpMessageConverter返回的对象数据绑定到 controller中方法的参数上。
    //根据输入对象查询时，可以不使用@RequestBody，
    //根据输入对象插入或修改时，最好使用@RequestBody
    //@RequestBody 只能接收JSON字符串
    @RequestMapping(method = RequestMethod.POST)
    public ResponseEntity<String> createFilm(@Valid @RequestBody Film film) {
        try {
            filmService.insertFilm(film);
            return ResponseEntity.ok("New Film ID：" + film.getFilm_id());
        } catch (Exception e) {
            logger.info(" Instert Film Exceprtion   " + film + "  Data Exception " + e.getMessage(), e);
            return ResponseEntity.status(500).body(null);
        }
    }

    /**
     * 插件电影的分页查询
     */
    @PostMapping("/list")
    @ResponseBody
    public String list(@MyBody("page") Page page) throws Exception {
        Page<Film> pagedResult = filmService.queryByPage(page.getPag(), page.getPageSize());
        return toJson(pagedResult);
    }

    private static String toJson(Object pagedResult) {
        JSONObject jsonObj = null;
        if (pagedResult != null) {
            JsonConfig jsonConfig = new JsonConfig();
            jsonObj = JSONObject.fromObject(pagedResult, jsonConfig);
            jsonObj.element("isError", false);
            jsonObj.element("errorMsg", "");
        }
        return jsonObj.toString();
    }
}
