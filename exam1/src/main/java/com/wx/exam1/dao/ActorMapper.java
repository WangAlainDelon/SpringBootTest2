package com.wx.exam1.dao;

import com.wx.exam1.domain.Actor;
import com.wx.exam1.domain.Film;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ActorMapper {
    List<Actor> findActorAndFilm(Actor actor);
    List<Film> findFilmByCid(Byte actor_id);
}
