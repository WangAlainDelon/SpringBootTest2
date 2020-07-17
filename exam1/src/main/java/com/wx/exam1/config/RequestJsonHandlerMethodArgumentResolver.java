package com.wx.exam1.config;

import com.wx.exam1.annotation.MyBody;
import com.wx.exam1.domain.Category;
import com.wx.exam1.domain.Page;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//定义请求参数解析注解2
@Component
public class RequestJsonHandlerMethodArgumentResolver implements HandlerMethodArgumentResolver {
    /**
     * 判断参数是否是支持的类型,支持则范返回true
     *
     * @param parameter
     * @return
     */
    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //绑定注解
        return parameter.hasParameterAnnotation(MyBody.class);
    }

    //处理参数,进行封装
    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //1.获得参数
        HttpServletResponse response = webRequest.getNativeResponse(HttpServletResponse.class);
        HttpServletRequest request = webRequest.getNativeRequest(HttpServletRequest.class);
        Page pageObj = new Page();
        pageObj.setPag(Integer.parseInt(request.getParameter("page")));
        pageObj.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
        return pageObj;
    }
}
