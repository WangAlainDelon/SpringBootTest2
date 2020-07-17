package com.wx.scheduled.domain;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * User: Mr.Wang
 * Date: 2019/10/28
 */
@NoArgsConstructor
@Data
@Table(name = "sys_schedule_lock")
public class ScheduleLock {
    @Id
    @Column(name = "task_id")
    private String taskId;
    private String taskDesc;
    private Date acquireTime;
    private String execIp;
    private int status;

}
