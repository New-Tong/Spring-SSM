package com.shansong.test;

import com.shansong.UserMapper;
import com.shansong.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/12 -18:03
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
public class UserMapperTest {
    @Test
    public void testUserMapper() {
        try {
            InputStream inputStream = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSession sqlSession = new SqlSessionFactoryBuilder().build(inputStream).openSession();
            UserMapper mapper = sqlSession.getMapper(UserMapper.class);
            User user = new User();
            user.setUsername("shansong");
            user.setPassword("123456");
            int userId = mapper.insert(user);
            System.out.println(user);
            user.setPassword("good");
            mapper.update(user);
            user = mapper.selectById(userId);
            System.out.println(user);
            User newUser = new User();
            newUser.setUsername("newTong");
            newUser.setPassword("nice");
            int newUserId = mapper.insert(newUser);
            sqlSession.commit();
            System.out.println("newUserId:"+newUserId);
            List<User> users = mapper.selectAll();
            for (User u : users) {
                System.out.println(u);
            }
            sqlSession.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
