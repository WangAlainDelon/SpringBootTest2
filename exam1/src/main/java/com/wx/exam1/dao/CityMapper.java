package com.wx.exam1.dao;

import com.wx.exam1.domain.City;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CityMapper {

    List<City> selectByCountryId(@Param("id") String id);
    List<City> findCityAndContry(City city);
}
