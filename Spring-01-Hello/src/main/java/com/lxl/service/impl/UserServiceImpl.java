package com.lxl.service.impl;

import com.lxl.dao.UserDao;
import com.lxl.service.UserService;

public class UserServiceImpl implements UserService {

    // UserService通过有参构造器注入了一个userDao对象
    private UserDao userDao;

    // 通过有参构造器然后使用<constructor-arg标签
    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {}

    // 通过set方法构造的要使用<property标签
    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
}
