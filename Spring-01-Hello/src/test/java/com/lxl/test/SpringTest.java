package com.lxl.test;

import com.lxl.dao.UserDao;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringTest {

    @Test
    // 测试scope属性
    public void test(){
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // id是"UserDao"而已，实际上拿到的是UserDaoImpl类，然后将用UserDao接口引用来使用它
        UserDao userDao1 = (UserDao) app.getBean("UserDao");

        // hashCode()其实就是@后面的十六进制转成10进制后的值
        System.out.println(userDao1);


    }
}
