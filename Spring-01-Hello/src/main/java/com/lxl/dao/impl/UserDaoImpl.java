package com.lxl.dao.impl;

import com.lxl.dao.UserDao;
import com.lxl.domain.User;

import java.util.List;
import java.util.Map;
import java.util.Properties;

public class UserDaoImpl implements UserDao {

    // 使用set方法注入集合类
    private List<String> stringList;
    private Map<String, User> userMap;
    private Properties properties;

    public void setStringList(List<String> stringList) {
        this.stringList = stringList;
    }

    public void setUserMap(Map<String, User> userMap) {
        this.userMap = userMap;
    }

    public void setProperties(Properties properties) {
        this.properties = properties;
    }

    // 用set方法注入基本数据类型
    private String username;
    private int age;

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public UserDaoImpl(){
       System.out.println("创建了一个UserDaoImpl对象");
    }

    public void init(){
       System.out.println("初始化方法......");
    }

    public void destroy(){
       System.out.println("销毁方法......");
    }

    @Override
    public void save() {
        System.out.println("UserDaoImpl对象的save()在这里被调用了：");
        System.out.println("=======================================");
        System.out.println("stringList=" + stringList);
        System.out.println("userMap=" + userMap);
        System.out.println("properties=" + properties);
        System.out.println("username=" + username + " age=" + age);
        System.out.println("save running......");
        System.out.println("=======================================");
    }
}
