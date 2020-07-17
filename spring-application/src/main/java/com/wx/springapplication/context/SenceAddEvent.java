package com.wx.springapplication.context;

import org.springframework.boot.context.event.SpringApplicationEvent;
import org.springframework.context.ApplicationEvent;

/**
 * User: Mr.Wang
 * Date: 2019/10/24
 */

/**
 * 景区添加事件
 */
public class SenceAddEvent extends ApplicationEvent {
    private static final long serialVersionUID = -2200062584426915181L;

    private String name;

    public SenceAddEvent(Object source, String name) {
        super(source);
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
