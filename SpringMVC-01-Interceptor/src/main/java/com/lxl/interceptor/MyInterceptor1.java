package com.lxl.interceptor;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class MyInterceptor1 implements HandlerInterceptor {
    @Override
    // 在目标方法show()执行之前 执行       这个用得最多
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("preHandle()在进入show()方法之前执行......");
        String param = request.getParameter("param");
        if("yes".equals(param)){
            return true;
        }else {
            request.getRequestDispatcher("/error.jsp").forward(request, response);
            return false; // 返回true代表放行，返回false代表不放行
        }
    }

    @Override
    // 在进入目标方法之后，视图返回之前 执行              ModelAndView是从show()方法中获取的，拿到之后可以进行修改
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        modelAndView.addObject("name", "在拦截器的postHandle()方法中我通过ModelAndView把name改成了这句话");
        System.out.println("postHandle()在进入show()方法之后，return 视图之前执行......");
    }

    @Override
    // 在整个流程都执行完毕后执行，即show()方法执行之后  用得比较少
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion()在整个show()方法执行完毕之后执行......");
    }
}
