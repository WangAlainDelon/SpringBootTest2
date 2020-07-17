package com.wx.design_pattern.chainresponsibility;

import java.util.Arrays;
import java.util.Date;

/**
 * User: Mr.Wang
 * Date: 2020/1/28
 */
public class Test1 {
    public static void main(String[] args) {
//        ManagerApprovalHandler managerApprovalHandler = new ManagerApprovalHandler();
//        GroupLeaderApprovalHandler groupLeaderApprovalHandler = new GroupLeaderApprovalHandler();
//        groupLeaderApprovalHandler.setNext(managerApprovalHandler);

        //把链式调用的关系进行封装

        Chain chain = new Chain(Arrays.asList(
                new ManagerApprovalHandler(),
                new GroupLeaderApprovalHandler()
        ));

        HolidayApplication holidayApplication = new HolidayApplication();
        holidayApplication.setApplierName("Mr.Wang");
        holidayApplication.setReason("回家耍");
        holidayApplication.setStartTime(new Date());
        holidayApplication.setEndTime(new Date());

        chain.execute(holidayApplication);


    }
}
