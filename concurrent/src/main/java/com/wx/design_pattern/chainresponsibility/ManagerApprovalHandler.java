package com.wx.design_pattern.chainresponsibility;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public class ManagerApprovalHandler extends AbstractApprovalHandler{
    @Override
    public void approvalRequest(HolidayApplication holidayApplication) {
        //经理审批请假的原因
        if (!StringUtils.isEmpty(holidayApplication.getReason())) {
            System.out.println("请假的原因为：" + holidayApplication.getReason() + "，经理审批通过");
        } else {
            System.out.println("请假驳回，原因不能为空");
            return;
        }
    }
}
