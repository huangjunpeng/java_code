package com.alex.domain;

public class UserFectory {
    static public User createUser() {
        return  new User("张三", 21, 1);
    }

    public User createUser2() {
        return  new User("李四", 25, 0);
    }
}
