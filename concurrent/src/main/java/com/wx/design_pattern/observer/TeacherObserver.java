package com.wx.design_pattern.observer;


import java.util.Observable;
import java.util.Observer;

/**
 * User: Mr.Wang
 * Date: 2019/12/19
 */
public class TeacherObserver implements Observer {

    private String name;

    public TeacherObserver(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void update(Observable o, Object arg) {
        CourseObservable courseObservable = (CourseObservable) o;
        Question question = (Question) arg;
        System.out.println(name + "的课程：" + courseObservable.getCourseName()
                + "收到" + question.getUsreName() + "提出的问题:" + question.getQuestName());
    }
}
