package com.wx.exam1.service.imp;

import com.wx.exam1.dao.CityMapper;
import com.wx.exam1.domain.City;
import com.wx.exam1.service.CityService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class CityServiceImp implements CityService {
    @Resource
    private CityMapper cityMapper;

    @Override
    public List<City> selectByCountryId(String id) {
        return cityMapper.selectByCountryId(id);
    }
}
