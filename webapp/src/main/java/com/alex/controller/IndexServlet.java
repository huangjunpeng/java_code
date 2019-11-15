package com.alex.controller;

import com.alex.service.UserService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author alex
 */
@Component
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getWriter().write("123");
        ApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");
        UserService us = (UserService)ac.getBean("userservice");
        resp.getWriter().write(us.toString());
    }
}
