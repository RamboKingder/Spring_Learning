package com.lxl.controller;

import com.lxl.exception.MyException;
import com.lxl.service.DemoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class DemoController {

    @Autowired
    private DemoService demoService;

    @RequestMapping("/show")
    public String show() throws Exception{
        System.out.println("show running......");
        demoService.show1();
        // demoService.show2();
        // demoService.show3();
        // demoService.show4();
        // demoService.show5();
        return "index";
    }
}
