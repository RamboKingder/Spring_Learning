package com.lxl.test;

import com.lxl.domain.Account;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:applicationContext.xml")
public class JdbcTemplateCRUDTest {

    @Autowired // 要使用什么对象，就用@Autowired注入 Spring容器会去找并帮我们注入对象
    private JdbcTemplate jdbcTemplate;

    @Test // 查询总数
    public void testQueryCount(){
        Long count = jdbcTemplate.queryForObject("select count(*) from `account`", Long.class);
        System.out.println("表中一共有：" + count + "条数据");
    }

    @Test // 查询单个个对象
    public void testQueryOne(){
        Account account = jdbcTemplate.queryForObject("select * from `account` where `name` = ?"
                , new BeanPropertyRowMapper<Account>(Account.class), "龙哥");
        System.out.println(account);
    }

    @Test // 查询多个对象
    public void testQueryAll(){
        // 参数类型是RowMapper<T>的接口，返回的是List<T>
        // 所以我们需要传入一个具体的RowMapper对象告诉它如何进行结果的行映射
        // 这里我们想传入一个BeanPro...要注意在泛型中给出要封装的实体属性
        List<Account> accountList = jdbcTemplate.query("select * from `account`", new BeanPropertyRowMapper<Account>(Account.class));
        System.out.println(accountList);
    }

    @Test
    public void testDelete(){
        int row = jdbcTemplate.update("delete from `account` where `name` = ?", "张三");
        System.out.println("共有：" + row + "行数据受到影响......");
    }

    @Test
    public void testUpdate(){
        int row = jdbcTemplate.update("update `account` set money = ? where `name` = ?", 666, "张三");
        System.out.println("共有：" + row + "行数据受到影响......");
    }
}
