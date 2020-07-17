package com.wx.exam1.service.imp;


import com.wx.exam1.dao.UserMapper;
import com.wx.exam1.domain.User;
import com.wx.exam1.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Resource
    private UserMapper userMapper;

    @Override
    public List<User> selectById() {
        return userMapper.selectById();
    }
}
