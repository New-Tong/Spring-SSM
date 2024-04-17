package com.shansong.controller;

import com.shansong.pojo.User;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @author ShanSong
 * @Date 2024/4/16 -12:07
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@RestController
@RequestMapping("user")
public class UserController {

    @GetMapping("data")
    public String data() {
        System.out.println("UserController.data");
        return "NullPointerException";
    }

    @GetMapping("data1")
    public String data1() {
        System.out.println("UserController.data1");
        return "ArithmeticException";
    }

    @PostMapping("register")
    public User register(@Validated @RequestBody User user, BindingResult result) {
        System.out.println("user = " + user);
        return user;
    }

}
