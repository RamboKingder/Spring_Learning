package com.lxl.service;

import com.lxl.exception.MyException;

import java.io.FileNotFoundException;

public interface DemoService {
    void show1();
    void show2();
    void show3() throws FileNotFoundException;
    void show4() throws MyException;
    void show5() throws MyException;
}
