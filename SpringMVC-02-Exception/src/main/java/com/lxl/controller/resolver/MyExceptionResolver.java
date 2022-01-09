package com.lxl.controller.resolver;

import com.lxl.exception.MyException;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyExceptionResolver implements HandlerExceptionResolver {
    @Override
    // 参数Exception ex是报异常的异常对象，返回值ModelAndView就是要跳转的错误视图的信息
    public ModelAndView resolveException(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) {
        ModelAndView modelAndView = new ModelAndView();
        if(ex instanceof MyException){
            modelAndView.addObject("info", "自定义的异常");
        }else if (ex instanceof ClassCastException){
            modelAndView.addObject("info", "类转换异常");
        }
        modelAndView.setViewName("error");
        return modelAndView;
    }
}
