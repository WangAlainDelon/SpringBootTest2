package com.wx.concurrent.test;

/**
 * User: Mr.Wang
 * Date: 2019/11/10
 */
public class User {
    private String name;
    public volatile int old;

    public User(String name, int old) {
        this.name = name;
        this.old = old;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getOld() {
        return old;
    }

    public void setOld(int old) {
        this.old = old;
    }
}
