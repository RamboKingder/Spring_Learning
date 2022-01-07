package com.lxl.test;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jdbc.core.JdbcTemplate;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class JdbcTemplateTest {

    @Test
    // 测试Spring产生的JdbcTemplate对象
    public void test2(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        JdbcTemplate jdbcTemplate = app.getBean(JdbcTemplate.class);

        // 执行操作 ?是占位符 方法的返回值是影响的行数
        int row = jdbcTemplate.update("insert into `account` values(?,?)", "张三", 10000);
        System.out.println("一共有" + row + "行受到影响......");
    }

    @Test
    // 测试JdbcTemplate开发步骤
    public void test1() throws PropertyVetoException, SQLException {

        // 创建数据源对象
        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass("com.mysql.cj.jdbc.Driver");
        dataSource.setJdbcUrl("jdbc:mysql://localhost:3306/JdbcTemplateTest");
        dataSource.setUser("root");
        dataSource.setPassword("rootpassword");
        Connection connection = dataSource.getConnection();

        System.out.println("测试连接是否建立成功：" + connection);

        JdbcTemplate jdbcTemplate = new JdbcTemplate();
        // 首先必须设置数据源，建立数据库连接
        jdbcTemplate.setDataSource(dataSource);

        // 执行操作 ?是占位符 方法的返回值是影响的行数
        int row = jdbcTemplate.update("insert into `account` values(?,?)", "龙哥", 10000);
        System.out.println("一共有" + row + "行受到影响......");

    }
}
