package com.ly.spring.jdbc.test;

import com.ly.spring.jdbc.beans.Department;
import com.ly.spring.jdbc.beans.Employee;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.BeanPropertySqlParameterSource;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.jdbc.core.namedparam.SqlParameterSource;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Author: LiYan
 * @Description:
 * @Date: Created in 21:48 2018/11/26
 * @Modified By:
 */
public class JDBCTest {

    ApplicationContext ioc = new ClassPathXmlApplicationContext("beans-jdbc.xml");

    @Test
    void testJDBC() throws SQLException {
        DataSource dataSource = (DataSource) ioc.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
    }

    // 通用的增删改的方法
    @Test
    void testUpdate(){
        // 获取JdbcTemplate对象
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

        // 写sql语句
        String sql = "insert into employees(last_name,email,salary,dept_id) values (?,?,?,?)";
        jdbcTemplate.update(sql,"李炎", "976417813@qq.com", 12000, 1);
        jdbcTemplate.update(sql, "周茜", "zhouqian@qq.com", 12000, 2);
    }

    // 批处理方法
    @Test
    void testBatchUpdate() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

        String sql = "insert into employees(last_name,email,salary,dept_id) values (?,?,?,?)";

        List<Object[]> batchArgs = new ArrayList<>();

        batchArgs.add(new Object[]{"小明","xiaoming@qq.com",5000,4});
        batchArgs.add(new Object[]{"小红","xiaohong@qq.com",15000,3});
        batchArgs.add(new Object[]{"枫叶","fengye@qq.com",8000,2});

        jdbcTemplate.batchUpdate(sql, batchArgs);
    }

    // 获取一个单一值的方法 调用的是jdbcTemplate中的queryForObject()方法
    @Test
    void testGetSingleValue() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

        String sql = "select count(*) from employees";

        Integer count = jdbcTemplate.queryForObject(sql, Integer.class);

        System.out.println(count);
    }

    /*
     * 获取一个对象的方法 调用的是jdbcTemplate中的queryForObject()
     * RowMapper的实现类使用的是BeanPropertyRowMapper，就相当于BeanHandler
     */
    @Test
    void testGetBean() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");
        String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees where id = ?";
        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);
        Employee employee = jdbcTemplate.queryForObject(sql, rowMapper, 3);
        System.out.println(employee);
    }

    /*
     * 获取一个集合的方法 调用的是jdbcTemplate中的query()方法
     * RowMapper的实现类使用的是BeanPropertyRowMapper，就相当于BeanHandler
     */
    @Test
    void testGetBeanList() {
        JdbcTemplate jdbcTemplate = (JdbcTemplate) ioc.getBean("jdbcTemplate");

        String sql = "select id,last_name lastName,email,salary,dept_id deptId from employees";

        RowMapper<Employee> rowMapper = new BeanPropertyRowMapper<>(Employee.class);

        List<Employee> employees = jdbcTemplate.query(sql, rowMapper);

        for (Employee employee : employees) {
            System.out.println(employee);
        }
    }

    // 使用具名参数之传入Map
    @Test
    void testMap() {
        // 获取NamedParameterJdbcTemplate对象
        NamedParameterJdbcTemplate npjt = (NamedParameterJdbcTemplate) ioc.getBean("namedParameterJdbcTemplate")
                ;
        // 写sql语句
        String sql = "insert into employees(last_name,email,salary,dept_id) values(:lastName,:email,:salary,:deptId)";

        Map<String,Object> paramMap = new HashMap<>();

        paramMap.put("deptId", 2);
        paramMap.put("lastName", "李隆基");
        paramMap.put("email", "llj@yy.com");
        paramMap.put("salary", 500000.00);

        npjt.update(sql, paramMap );
    }

    @Test
    void testSqlParameterSource() {
        // 获取NamedParameterJdbcTemplate对象
        NamedParameterJdbcTemplate npjt = (NamedParameterJdbcTemplate) ioc.getBean("namedParameterJdbcTemplate");

        //传入的参数是SqlParameterSource类型是具名参数必须要与类的属性名保持一致
        String sql = "insert into departments(name) values(:name)";

        //创建Department对象
        Department department = new Department();

        department.setId(7);
        department.setName("文娱部");

        SqlParameterSource paramSource = new BeanPropertySqlParameterSource(department);

        npjt.update(sql, paramSource);
    }

}
