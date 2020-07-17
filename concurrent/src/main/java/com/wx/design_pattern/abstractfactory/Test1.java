package com.wx.design_pattern.abstractfactory;

/**
 * User: Mr.Wang
 * Date: 2020/1/27
 */
public class Test1 {
    public static void main(String[] args) {
        DefaultCourseFactory defaultCourseFactory = new DefaultCourseFactory();
        Article javaArticle = defaultCourseFactory.getArticle(JavaArticle.class);
        JavaVideo javaVideo = defaultCourseFactory.getVideo(JavaVideo.class);

        PythonVideo pythonVideo = defaultCourseFactory.getVideo(PythonVideo.class);
        PythonArticle pythonArticle = defaultCourseFactory.getArticle(PythonArticle.class);

        javaArticle.showArticle();
        javaVideo.playVideo();
        pythonVideo.playVideo();
        pythonArticle.showArticle();
    }

}

