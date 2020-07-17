package com.wx.design_pattern.chainresponsibility;

import org.springframework.util.StringUtils;

import java.util.Objects;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public class GroupLeaderApprovalHandler extends AbstractApprovalHandler {
    @Override
    public void approvalRequest(HolidayApplication holidayApplication) {
        //组长检查请假人的姓名不为空
        if (!StringUtils.isEmpty(holidayApplication.getApplierName())) {
            System.out.println("请假者为：" + holidayApplication.getApplierName() + ",组长审批通过");
//            //如果调用链还没结束则继续。
//            if (!Objects.isNull(approvalHandler)) {
//                approvalHandler.approvalRequest(holidayApplication);
//            }
        } else {
            System.out.println("请假驳回，请假者不能为空");
            return;
        }
    }
}
