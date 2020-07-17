package com.wx.design_pattern.observer;

import java.util.Observable;

/**
 * User: Mr.Wang
 * Date: 2019/12/19
 */
public class CourseObservable extends Observable {
    private String courseName;

    public CourseObservable(String courseName) {
        this.courseName = courseName;
    }

    /***
     * 问题提出以后被观察者状态就要发生改变,并且通知所有的观察者对象
     * 并且具体要通知什么消息，可以传也可以不传
     * @param question
     * @param course
     */
    public void productQuestion(Question question, CourseObservable course) {
        System.out.println(question.getUsreName() + "在" + course.getCourseName()
                + "提了一个问题：" + question.getQuestName());
        setChanged();
        notifyObservers(question);
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }
}
