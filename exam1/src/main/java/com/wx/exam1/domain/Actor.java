package com.wx.exam1.domain;


import org.springframework.beans.factory.BeanNameAware;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
public class Actor implements Serializable {

    private Short actor_id;
    private String first_name;
    private String last_name;
    private Date last_update;
    private List<Film> filmList;

    public Short getActor_id() {
        return actor_id;
    }

    public void setActor_id(Short actor_id) {
        this.actor_id = actor_id;
    }

    public String getFirst_name() {
        return first_name;
    }

    public void setFirst_name(String first_name) {
        this.first_name = first_name;
    }

    public String getLast_name() {
        return last_name;
    }

    public void setLast_name(String last_name) {
        this.last_name = last_name;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }

    public List<Film> getFilmList() {
        return filmList;
    }

    public void setFilmList(List<Film> filmList) {
        this.filmList = filmList;
    }
}