package com.alex.service;

import com.alex.entity.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:application-context.xml"})
public class UserService {
    @Autowired
    private User user;

    public UserService() {
    }

    /*@Override
    public String toString() {
        return "UserService{" +
                "user=" + user +
                '}';
    }*/

    @Test
    public void TestUser() {
        System.out.println("12");
    }

}
