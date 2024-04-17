package com.shansong.pojo;

import lombok.Data;

/**
 * @author ShanSong
 * @Date 2024/4/11 -14:38
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
@Data
public class Employee {
    private Integer empId;

    private String empName;

    private Double empSalary;

}

