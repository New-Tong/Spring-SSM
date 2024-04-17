package com.shansong.controller;

import com.shansong.pojo.User;
import jakarta.ws.rs.Path;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/15 -17:51
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@RestController
@RequestMapping("user")
@ResponseBody
public class UserController {

    @GetMapping
    public List<User> selectUserByPage(@RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                       @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        List<User> list = new ArrayList<>();
        return list;
    }

    @PostMapping
    public String saveUser(@RequestBody User user) {
        System.out.println(user);
        return user.toString();
    }

    @GetMapping("{id}")
    public User selectUser(@PathVariable int id) {
        User user = new User();
        user.setId(id);
        return user;
    }

    @PutMapping
    public User updateUser(@RequestBody User user) {
        return user;
    }

    @DeleteMapping("{id}")
    public String deleteUser(@PathVariable int id) {
        System.out.println("id为" + id + "的用户已经删除");
        return ("id为" + id + "的用户已经删除");
    }

    @GetMapping("search")
    public User selectUserByPageAndMo(String keyword,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") int page,
                                      @RequestParam(value = "size", required = false, defaultValue = "10") int size) {
        User user = new User();
        return user;
    }
}
