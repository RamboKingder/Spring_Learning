package com.lxl.service.impl;

import com.lxl.dao.UserDao;
import com.lxl.service.UserService;

public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Override
    public void save() {
        System.out.print("In UserServiceImpl object, we call its userDao.save():");
        userDao.save();
    }
}
