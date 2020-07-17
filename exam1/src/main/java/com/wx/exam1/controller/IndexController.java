package com.wx.exam1.controller;

import com.alibaba.fastjson.JSON;
import com.google.gson.Gson;

import com.wx.exam1.domain.*;
import com.wx.exam1.service.*;
import com.wx.exam1.domain.Page;
import net.sf.json.JSONObject;
import net.sf.json.JsonConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import java.net.InetAddress;
import java.util.List;

@Controller
public class IndexController {
    private static Short id = 0;
    private final Logger logger = LoggerFactory.getLogger(getClass());
    @Autowired
    private CityService cityService;
    @Autowired
    private UserService userService;
    @Autowired
    private CustomerService customerService;

    @Autowired
    private FilmService filmService;
    @Autowired
    private CategoryService categoryService;

    /***
     * 访问数据库使用logback打印日志测试
     * @param model
     * @param id
     * @return
     */
    @RequestMapping("/index")
    @ResponseBody
    public String index(Model model, String id) {
        System.out.println(id);
        List<City> cities = cityService.selectByCountryId(id);
        Gson gson = new Gson();
        String json = gson.toJson(cities);
        System.out.println(json);
        logger.debug("记录debug日志");
        logger.info("访问了index方法");
        logger.error("记录了error错误日志");
        return json;
    }

    @RequestMapping("/hostname")
    @ResponseBody
    public ResponseEntity<String> getHostname() {
        String canonicalHostName = "";
        try {
            canonicalHostName = InetAddress.getLocalHost().getCanonicalHostName();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return ResponseEntity.ok("容器的hostname为：" + canonicalHostName);
    }


    /***手动分页查询电影的数据  curl 发起Get请求
     * 查询film 列表，/GET 请求，通过curl 传入pageSize 和page。方法上使用Page对象接收
     *  curl 192.168.10.24:8080/page?pageSize=10&page=2
     */
    @GetMapping("/page")
    @ResponseBody
    public String list(Page page) throws Exception {
        Page<Film> pagedResult = filmService.query(page.getPageSize(), page.getPag());
        return toJson(pagedResult);
    }

    /***
     * 测试通用Mapper的根据主键查询的方法
     *SpringBoot+Mybatis整合通用Mapper成功
     */
    @RequestMapping("/getCategory")
    @ResponseBody
    public String getCategory(Byte category_id) {
        Category category = categoryService.selectCategoryById(category_id);
        return toJson(category);
    }

    private static String toJson(Object pagedResult) {
        JSONObject jsonObj = null;
        if (pagedResult != null) {
            JsonConfig jsonConfig = new JsonConfig();
            jsonObj = JSONObject.fromObject(pagedResult, jsonConfig);
            jsonObj.element("isError", false);
            jsonObj.element("errorMsg", "");
        }
        return jsonObj.toString();
    }
    /**
     * 自己写一个解析器，实现前端的参数绑定到Page对象
     */

}
