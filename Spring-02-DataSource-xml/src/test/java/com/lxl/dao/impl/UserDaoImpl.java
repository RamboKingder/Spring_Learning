package com.lxl.dao.impl;

import com.lxl.dao.UserDao;

public class UserDaoImpl implements UserDao {
    @Override
    public void save(){
        System.out.println("UserDaoImpl object.save() method is running......");
    }
}
