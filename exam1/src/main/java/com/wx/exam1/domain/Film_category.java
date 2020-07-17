package com.wx.exam1.domain;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Table(name = "film_category")
public class Film_category implements Serializable {
    private static final long serialVersionUID = -19896209447L;

    @Id
    @GeneratedValue
    private Short film_id;

    private Byte category_id;

    private Date last_update;
    @Transient
    private List<Film> film;
    @Transient
    private Category category;

    public List<Film> getFilm() {
        return film;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setFilm(List<Film> film) {
        this.film = film;
    }

    public Short getFilm_id() {
        return film_id;
    }

    public void setFilm_id(Short film_id) {
        this.film_id = film_id;
    }

    public Byte getCategory_id() {
        return category_id;
    }

    public void setCategory_id(Byte category_id) {
        this.category_id = category_id;
    }

    public Date getLast_update() {
        return last_update;
    }

    public void setLast_update(Date last_update) {
        this.last_update = last_update;
    }
}