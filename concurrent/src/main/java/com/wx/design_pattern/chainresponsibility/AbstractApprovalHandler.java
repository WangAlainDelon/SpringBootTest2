package com.wx.design_pattern.chainresponsibility;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public abstract class AbstractApprovalHandler {

    public void process(Chain chain,HolidayApplication holidayApplication) {
        approvalRequest(holidayApplication);
        chain.execute(holidayApplication);
    }


    /**
     * 审批的方法
     */
    public abstract void approvalRequest(HolidayApplication holidayApplication);
}
