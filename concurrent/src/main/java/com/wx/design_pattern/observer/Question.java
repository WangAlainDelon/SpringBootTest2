package com.wx.design_pattern.observer;

/**
 * User: Mr.Wang
 * Date: 2019/12/19
 */
public class Question {
    private String questName;

    private String usreName;

    public String getUsreName() {
        return usreName;
    }

    public void setUsreName(String usreName) {
        this.usreName = usreName;
    }

    public String getQuestName() {
        return questName;
    }

    public void setQuestName(String questName) {
        this.questName = questName;
    }
}
