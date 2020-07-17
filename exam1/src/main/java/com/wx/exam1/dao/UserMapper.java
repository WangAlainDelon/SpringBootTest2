package com.wx.exam1.dao;

import com.wx.exam1.domain.User;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> selectById();
}
