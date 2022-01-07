package com.lxl.domain;

public class User {
    private String username;
    private int age;

    public void User(){}

    public void setUsername(String username) {
        this.username = username;
    }

    public void setAge(int age){
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "User{" +
                "username='" + username + '\'' +
                ", age=" + age +
                '}';
    }
}
