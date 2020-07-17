package com.wx.exam1.service;

import com.wx.exam1.domain.Address;
import org.apache.ibatis.annotations.Param;

public interface AddressService {
    Address isAddr(String address);
}
