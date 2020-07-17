package com.wx.exam1.domain;

import org.springframework.stereotype.Repository;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;
import java.util.List;

@Repository
@Table(name = "category")
public class Category implements Serializable {
    /**
     * serialVersionUID适用于Java的序列化机制。简单来说，
     * Java的序列化机制是通过判断类的serialVersionUID来验证版本一致性的。
     * 在进行反序列化时，JVM会把传来的字节流中的serialVersionUID与本地相应实体类的serialVersionUID进行比较，
     * 如果相同就认为是一致的，可以进行反序列化，否则就会出现序列化版本不一致的异常
     * ，即是InvalidCastException。
     * <p>
     * 具体的序列化过程是这样的：
     * 序列化操作的时候系统会把当前类的serialVersionUID写入到序列化文件中，
     * 当反序列化时系统会去检测文件中的serialVersionUID，判断它是否与当前类的serialVersionUID一致，
     * 如果一致就说明序列化类的版本与当前类版本是一样的，可以反序列化成功，否则失败。
     */

    private static final long serialVersionUID = -1989674246114209447L;
    //获取数据库自增的主键
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Byte category_id;
    //当这个字段是mysql中的保留字时，这样可以解决
    @Column(name = "`name`")
    private String name;

    private Date last_update;
    private List<Film> films;

    public List<Film> getFilms() {
        return films;
    }

    public void setFilms(List<Film> films) {
        this.films = films;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
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