package com.wx.design_pattern.abstractfactory;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public interface CourseFactory {
    <T extends Video> T getVideo(Class<T> aClass);

    <T extends Article> T getArticle(Class<T> aClass);
}
