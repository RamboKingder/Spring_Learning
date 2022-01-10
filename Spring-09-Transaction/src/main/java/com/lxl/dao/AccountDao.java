package com.lxl.dao;

public interface AccountDao {
    public void in(String inMan, double money);
    public void out(String outMan, double money);
}
