package com.wx.design_pattern.observer;

/**
 * User: Mr.Wang
 * Date: 2019/12/19
 */
public class Test1 {
    public static void main(String[] args) {
        CourseObservable courseObservable = new CourseObservable("权限管理");
        TeacherObserver teacherWang = new TeacherObserver("Mr.Wang");
        TeacherObserver teacherWu = new TeacherObserver("Mr.Wu");
        courseObservable.addObserver(teacherWang);
        courseObservable.addObserver(teacherWu);

        //业务逻辑：学生提出问题 老师收到
        Question question = new Question();
        question.setQuestName("怎么解决循环依赖的问题");
        question.setUsreName("小明");
        courseObservable.productQuestion(question, courseObservable);

    }
}
