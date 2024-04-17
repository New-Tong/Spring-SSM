package com.shansong.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

/**
 * @author ShanSong
 * @Date 2024/4/16 -16:07
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
public class MyInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("MyInterceptor.preHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler);
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("MyInterceptor.postHandle");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", modelAndView = " + modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("MyInterceptor.afterCompletion");
        System.out.println("request = " + request + ", response = " + response + ", handler = " + handler + ", ex = " + ex);
    }
}
