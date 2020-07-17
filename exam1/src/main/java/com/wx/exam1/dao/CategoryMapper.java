package com.wx.exam1.dao;

import com.wx.exam1.domain.Actor;
import com.wx.exam1.domain.Category;
import com.wx.exam1.domain.Film;
import com.wx.exam1.utils.MapperUtil;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.List;

@Mapper
public interface CategoryMapper extends MapperUtil<Category> {
    List<Category> findCatagoryAndFimlAndAcor(Category category);

    List<Film> findFilmByCid(Byte category_id);

    List<Actor> findActorById(Byte film_id);
}
