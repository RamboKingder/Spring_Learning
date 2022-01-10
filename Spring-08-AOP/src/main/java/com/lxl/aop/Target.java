package com.lxl.aop;

public class Target implements TargetInterface {
    @Override
    public void service() {
        System.out.println("Target(目标)对象提供了服务........");
        // int i = 1/0; // 异常抛出
    }
}
