package com.wx.exam1.dao;

import com.wx.exam1.domain.Country;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CountryMapper {
    List<Country> findCountryAndCity(Country country);
}
