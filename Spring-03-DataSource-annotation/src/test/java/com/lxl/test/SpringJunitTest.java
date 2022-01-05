package com.lxl.test;

import com.lxl.service.UserService;
import config.SpringConfiguration;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.sql.DataSource;
import java.sql.SQLException;

@RunWith(SpringJUnit4ClassRunner.class)
// @ContextConfiguration("classpath:application-context.xml") 如果有配置文件就用这个
@ContextConfiguration(classes = {SpringConfiguration.class})
public class SpringJunitTest {

    @Autowired
    private UserService userService;

    @Test
    public void test(){
        userService.save();
    }

    @Autowired
    private DataSource dataSource;

    @Test
    public void testDataSource() throws SQLException {
        System.out.println("==========测试数据源的连接对象===========");
        System.out.println(dataSource.getConnection());
    }

}
