package com.shansong.cookie;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CookieValue;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ShanSong
 * @Date 2024/4/14 -15:44
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@Controller
@RequestMapping("cookie")
@ResponseBody
public class CookieController {

    @RequestMapping("data")
    public String data(@CookieValue("cookieName") String value) {
        System.out.println(value);
        return value;
    }

    @GetMapping("save")
    public String save(HttpServletResponse response) {
        Cookie cookie = new Cookie("cookieName", "root");
        response.addCookie(cookie);
        return "save cookie";
    }
}
