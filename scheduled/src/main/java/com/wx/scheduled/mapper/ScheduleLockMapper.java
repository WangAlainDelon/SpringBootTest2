package com.wx.scheduled.mapper;

import com.wx.scheduled.domain.ScheduleLock;
import tk.mybatis.mapper.common.BaseMapper;

import java.util.Map;

/**
 * User: Mr.Wang
 * Date: 2019/10/28
 */
public interface ScheduleLockMapper extends BaseMapper<ScheduleLock> {
    int lock(Map<String, Object> map);

    int unlock(Map<String, Object> map);

//    int batchResetStatus();

    void TurnOffAll();
}
