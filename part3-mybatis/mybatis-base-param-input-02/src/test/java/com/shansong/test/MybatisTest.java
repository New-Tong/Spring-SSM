package com.shansong.test;

import com.shansong.EmployeeMapper;
import com.shansong.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/11 -14:52
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
public class MybatisTest {
    @Test
    public void testMybatis() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            Employee employee = mapper.queryById(1);
            System.out.println(employee);
            List<Employee> employees = mapper.queryBySalary(200.33);
            for (Employee emp : employees) {
                System.out.println(emp);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Test
    public void testQueryAll() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
            EmployeeMapper mapper = sqlSession.getMapper(EmployeeMapper.class);
            List<Employee> employees = mapper.queryAll();
            for (Employee employee : employees) {
                System.out.println(employee);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
