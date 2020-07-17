package com.wx.exam1.controller;

import com.alibaba.fastjson.JSON;
import com.wx.exam1.dao.ActorMapper;
import com.wx.exam1.dao.CategoryMapper;
import com.wx.exam1.dao.CityMapper;
import com.wx.exam1.dao.CountryMapper;
import com.wx.exam1.domain.*;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/***
 * 关联查询和懒加载
 */
@Controller
public class QueryController {

    @Autowired
    private SqlSessionFactory sqlSessionFactory;

    /**
     * 查询城市关联他的国家信息
     *
     * @param city
     * @return
     */
    @GetMapping("/findCityAndCountry")
    @ResponseBody
    public String findCity(City city) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CityMapper mapper = sqlSession.getMapper(CityMapper.class);
        List<City> cityAndContry = mapper.findCityAndContry(city);
        return JSON.toJSONString(cityAndContry);
    }

    /***
     * 查询国家关联城市信息
     * @param country
     * @return
     */
    @GetMapping("/findCountryAndCity")
    @ResponseBody
    public String findCountry(Country country) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CountryMapper mapper = sqlSession.getMapper(CountryMapper.class);
        List<Country> countryAndCity = mapper.findCountryAndCity(country);
        return JSON.toJSONString(countryAndCity);
    }

    /***
     * 根据电影的类别，查询电影和电影演员的信息，这儿就最好不要嵌套查询了，因为MyBatis只支持两层嵌套
     */
    @GetMapping("/findFilmAndActor")
    @ResponseBody
    public String getFilmAndACtor(Category category) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        CategoryMapper mapper = sqlSession.getMapper(CategoryMapper.class);
        List<Category> list = mapper.findCatagoryAndFimlAndAcor(category);
        Category category1 = list.get(0);
        List<Film> films = category1.getFilms();
        Film film = films.get(0);
        List<Actor> actors = film.getActors();
        return JSON.toJSONString(list);
    }

    /**
     * 根据演员信息懒加载电影的信息,
     * 添加拦截器打印SQL执行时间后，懒加载失效了
     */
    @GetMapping("/findActorAndFilm")
    @ResponseBody
    public String getActorAndFilm(Actor actor) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        ActorMapper mapper = sqlSession.getMapper(ActorMapper.class);
        List<Actor> actorAndFilm = mapper.findActorAndFilm(actor);
        System.out.println("------------------");
        Actor actor1 = actorAndFilm.get(0);
        List<Film> filmList = actor1.getFilmList();
        for (Film film : filmList) {
            System.out.println(film.getTitle());
        }
        return JSON.toJSONString(actorAndFilm);
    }

}
