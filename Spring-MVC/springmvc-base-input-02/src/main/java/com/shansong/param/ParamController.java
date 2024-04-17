package com.shansong.param;

import com.shansong.pojo.User;
import lombok.Getter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/14 -11:38
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@Controller
@RequestMapping("param")
public class ParamController {

    @GetMapping("data")
    @ResponseBody
    public String data(String name, int age) {
        System.out.println("name:" + name + ",age:" + age);
        return "name:" + name + ",age:" + age;
    }

    @RequestMapping("data1")
    @ResponseBody
    public String data1(@RequestParam("account") String userName, @RequestParam(required = false, defaultValue = "1") int page) {
        return "userName=" + userName + ", page=" + page;
    }

    @RequestMapping("data2")
    @ResponseBody
    public String data2(@RequestParam("hbs") List<String> hobbies) {
        StringBuilder string = new StringBuilder(new String());
        for (String s : hobbies) {
            string.append(s).append(",");
        }
        System.out.println(string);
        return string.toString();
    }

    @RequestMapping("data3")
    @ResponseBody
    public String data3(User user) {
        return user.toString();
    }

}
