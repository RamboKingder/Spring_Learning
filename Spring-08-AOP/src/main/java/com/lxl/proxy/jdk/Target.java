package com.lxl.proxy.jdk;

public class Target implements TargetInterface{
    @Override
    public void service() {
        System.out.println("Target(目标)对象提供了服务........");
    }
}
