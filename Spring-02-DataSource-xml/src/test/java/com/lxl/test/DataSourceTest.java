package com.lxl.test;

import com.alibaba.druid.pool.DruidDataSource;
import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;

public class DataSourceTest {

    @Test
    // 测试容器产生C3P0数据源对象 (连接需要的四个参数手动配置在xml中了，而不是让xml去读去properties文件)
    public void test03() throws SQLException {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        DataSource dataSource = (DataSource) app.getBean("dataSource");
        Connection connection = dataSource.getConnection();
        System.out.println(connection);
        connection.close();
    }

    @Test
    // 测试手动创建C3P0数据源 (加载properties文件的形式)
    public void test02() throws PropertyVetoException, SQLException {

        // 路径在resources下，且不需要文件的扩展名
        ResourceBundle rb = ResourceBundle.getBundle("jdbc");
        String driver = rb.getString("jdbc.driver");
        String url = rb.getString("jdbc.url");
        String username = rb.getString("jdbc.username");
        String password = rb.getString("jdbc.password");

        ComboPooledDataSource dataSource = new ComboPooledDataSource();
        dataSource.setDriverClass(driver);
        dataSource.setJdbcUrl(url);
        dataSource.setUser(username);
        dataSource.setPassword(password);
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }

    @Test
    // 测试手动创建Druid数据源 并且数据源的参数直接在代码中写"字符串"
    public void test01() throws PropertyVetoException, SQLException {
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/test_db");
        dataSource.setUsername("LongXiaolan");
        dataSource.setPassword("rootpassword");
        Connection conn = dataSource.getConnection();
        System.out.println(conn);
        conn.close();
    }
}
