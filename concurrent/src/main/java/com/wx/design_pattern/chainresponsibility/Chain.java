package com.wx.design_pattern.chainresponsibility;

import java.util.List;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public class Chain {
    private List<AbstractApprovalHandler> abstractApprovalHandlers;
    private int index = 0;


    public Chain(List<AbstractApprovalHandler> abstractApprovalHandlers) {
        this.abstractApprovalHandlers = abstractApprovalHandlers;
    }

    //根据下表链式执行
    public void execute(HolidayApplication holidayApplication) {
        if (index >= abstractApprovalHandlers.size()) {
            return;
        }
        abstractApprovalHandlers.get(index++).process(this, holidayApplication);
    }
}
