package com.shansong.error;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

/**
 * @author ShanSong
 * @Date 2024/4/16 -12:16
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NullPointerException.class)
    public Object handlerNullPointerException(NullPointerException e) {
        System.out.println(e);
        String message = e.getMessage();
        return message;
    }

    @ExceptionHandler(ArithmeticException.class)
    public Object handlerArithmeticException(ArithmeticException e) {
        System.out.println(e);
        String message = e.getMessage();
        return message;
    }

    @ExceptionHandler(Exception.class)
    public Object handlerAllException(Exception e) {
        System.out.println(e);
        String message = e.getMessage();
        return message;
    }
}
