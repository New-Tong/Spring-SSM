package com.shansong.test;

import com.shansong.EmployeeMapper;
import com.shansong.pojo.Employee;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * @author ShanSong
 * @Date 2024/4/13 -11:32
 * 包名:多单词组成时所有字母都小写:xxxyyyzzz
 * 类名、接口名:多单词组成时，所有单词的首字母大写:XxxYyyZzz
 * 变量名、方法名:多单词组成时，第一个单词首字母小写，
 * 第二个单词开始每个单词首字母大写: xxxYyyZzZ
 * 常量名:所有字母都大写。多单词时每个单词用下划线连接:XXx_YW_zzz
 * @Description
 */
public class EmployeeMapperTest {
    private SqlSession sqlSession;

    @BeforeEach
    public void init() throws IOException {
        sqlSession = new SqlSessionFactoryBuilder().build(
                Resources.getResourceAsStream("mybatis-config.xml")
        ).openSession(true);
    }

    @Test
    public void testQuery() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.query();
        for (Employee employee : employeeList) {
            System.out.println(employee);
        }
    }

    @Test
    public void testQueryChoose() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employeeList = employeeMapper.queryChoose(null, 200.33);
        System.out.println(employeeList);
    }

    @Test
    public void testQueryBatch() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        integers.add(4);
        integers.add(5);
        List<Employee> employeeList = employeeMapper.queryBatch(integers);
        System.out.println(employeeList);
    }

    @Test
    public void testInsertBatch() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Employee> employees = new ArrayList<>();
//        employees.add(new Employee("stark", 8999.6));
//        employees.add(new Employee("parker", 9999.99));
//        employees.add(new Employee("banner", 7899.6));
//        employees.add(new Employee("sour", 8599.9));
        int count = employeeMapper.insertBatch(employees);
        System.out.println(count + "行受到影响");
    }


    @Test
    public void testUpdateBatch() {
        EmployeeMapper employeeMapper = sqlSession.getMapper(EmployeeMapper.class);
        List<Integer> integers = new ArrayList<>();
        integers.add(1);
        integers.add(2);
        integers.add(3);
        List<Employee> employees = employeeMapper.queryBatch(integers);
        for (int i = 0; i < employees.size(); i++) {
            Employee employee = employees.get(i);
            employee.setEmpSalary(888.88);
            employees.set(i, employee);
        }
        int count = employeeMapper.updateBatch(employees);
        System.out.println(count + "行受到影响");
    }

    @AfterEach
    public void closeSqlSession() {
        sqlSession.close();
    }
}
