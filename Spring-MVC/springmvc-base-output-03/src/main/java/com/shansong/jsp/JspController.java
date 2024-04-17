package com.shansong.jsp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author ShanSong
 * @Date 2024/4/15 -15:59
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@Controller
@RequestMapping("jsp")
public class JspController {

    @GetMapping("index")
    public String index(HttpServletRequest request) {
        request.setAttribute("data", "hello jsp");
        System.out.println("JspController.index");
        System.out.println("request = " + request);
        return "index";
    }

}
