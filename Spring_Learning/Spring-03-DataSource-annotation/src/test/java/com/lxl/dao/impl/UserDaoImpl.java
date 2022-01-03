package com.lxl.dao.impl;

import com.lxl.dao.UserDao;
import org.springframework.stereotype.Repository;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

// <bean id="userDao" class="com.lxl.dao.impl.UserDaoImpl"/>
@Repository("userDao") // 里面的字符串相当于bean标签里的id
public class UserDaoImpl implements UserDao {
    @Override
    public void save(){
        System.out.println("UserDaoImpl object.save() method is running......");
    }

    @PostConstruct
    // UserDao的初始化方法
    public void init(){
        System.out.println("UserDaoImpl object is created......");
    }

    @PreDestroy
    // UserDao的销毁方法
    public void destory(){
        System.out.println("UserDaoImpl object is destroyed......");
    }
}
