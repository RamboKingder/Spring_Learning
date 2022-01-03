package com.lxl.demo;

import com.lxl.dao.UserDao;
import com.lxl.dao.impl.UserDaoImpl;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class UserDaoDemo {
    public static void main(String[] args) {
        ApplicationContext app = new ClassPathXmlApplicationContext("applicationContext.xml");
        // id是"UserDao"而已，实际上拿到的是UserDaoImpl类，然后将用UserDao接口引用来使用它
        UserDao userDao = (UserDao) app.getBean("UserDao");
        userDao.save();
    }
}
