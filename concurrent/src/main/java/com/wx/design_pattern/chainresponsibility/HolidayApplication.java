package com.wx.design_pattern.chainresponsibility;

import java.util.Date;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public class HolidayApplication {
    private String reason;
    private String applierName;
    private Date startTime;
    private Date endTime;

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public String getApplierName() {
        return applierName;
    }

    public void setApplierName(String applierName) {
        this.applierName = applierName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }
}
