package com.wx.design_pattern.abstractfactory;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class DefaultCourseFactory implements CourseFactory {
    @Override
    public <T extends Video> T getVideo(Class<T> aClass) {
        Video video = null;
        try {
            video = (Video) Class.forName(aClass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) video;
    }

    @Override
    public <T extends Article> T getArticle(Class<T> aClass) {
        Article article = null;
        try {
            article = (Article) Class.forName(aClass.getName()).newInstance();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return (T) article;
    }
}
