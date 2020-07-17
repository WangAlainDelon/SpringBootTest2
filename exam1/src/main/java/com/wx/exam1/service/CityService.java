package com.wx.exam1.service;

import com.wx.exam1.domain.City;

import java.util.List;

public interface CityService {
    /**
     * 根据city的id查询所属的city
     * @param id
     * @return
     */
    List<City> selectByCountryId(String id);

}
