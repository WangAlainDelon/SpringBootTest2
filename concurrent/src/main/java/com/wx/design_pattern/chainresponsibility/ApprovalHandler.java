package com.wx.design_pattern.chainresponsibility;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public abstract class ApprovalHandler {
    protected ApprovalHandler approvalHandler;

    /**
     * 设置下一个处理者是谁
     */
    public void setNext(ApprovalHandler next) {
        this.approvalHandler = next;
    }

    /**
     * 审批的方法
     */
    public abstract void approvalRequest(HolidayApplication holidayApplication);


}
