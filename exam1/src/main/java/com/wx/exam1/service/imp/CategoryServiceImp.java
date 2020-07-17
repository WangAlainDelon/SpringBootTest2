package com.wx.exam1.service.imp;

import com.wx.exam1.dao.CategoryMapper;
import com.wx.exam1.domain.Category;
import com.wx.exam1.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
@Service
public class CategoryServiceImp implements CategoryService {

    @Resource
    private CategoryMapper categoryMapper;
    @Override
    public Category selectCategoryById(Byte id) {
        return categoryMapper.selectByPrimaryKey(id);
    }
}
