package com.shansong.test;

import com.shansong.CustomerMapper;
import com.shansong.OrderMapper;
import com.shansong.pojo.Customer;
import com.shansong.pojo.Order;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/13 -10:37
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
public class MybatisTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml")
        ).openSession();
    }

    @AfterEach
    public void closeSqlSession() {
        sqlSession.close();
    }

    @Test
    public void testOrderMapper() {
        OrderMapper orderMapper = sqlSession.getMapper(OrderMapper.class);
        Order order = orderMapper.queryOrderById(1);
        System.out.println(order);
    }

    @Test
    public void testCustomerMapper() {
        CustomerMapper customerMapper = sqlSession.getMapper(CustomerMapper.class);
        List<Customer> customers = customerMapper.queryAll();
        for (Customer customer : customers) {
            System.out.println(customer);
        }
    }
}
