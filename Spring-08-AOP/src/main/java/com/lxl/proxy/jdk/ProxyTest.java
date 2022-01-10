package com.lxl.proxy.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class ProxyTest {
    public static void main(String[] args) {

        // 创建目标对象
        final Target target = new Target();

        // 创建增强对象
        final Advice advice = new Advice();

        // 返回值是动态生成的代理对象 必须使用接口来接收
        TargetInterface proxy = (TargetInterface) Proxy.newProxyInstance(
                target.getClass().getClassLoader(), // 目标对象的类加载器
                target.getClass().getInterfaces(), // 目标对象相同的接口 Class对象数组（因为一个对象可能继承了多个接口）
                new InvocationHandler() {
                    @Override
                    // 调用代理对象的任何方法，它实质执行的都是invoke()方法
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        advice.before(); // 前置增强
                        Object invoke = method.invoke(target, args);// 执行目标方法
                        advice.afterRunning(); // 后置增强
                        return invoke;
                    }
                }
        );

        // 通过代理，既能调用目标对象的service()方法，又实现了功能增强
        proxy.service();
    }
}
