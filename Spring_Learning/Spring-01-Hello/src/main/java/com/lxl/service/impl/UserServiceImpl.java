package com.lxl.service.impl;

import com.lxl.dao.UserDao;
import com.lxl.service.UserService;

public class UserServiceImpl implements UserService {

    // UserService通过有参构造器注入了一个userDao对象
    private UserDao userDao;

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserServiceImpl() {}

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void save(){
        userDao.save();
    }
}
