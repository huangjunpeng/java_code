package com.alex.controller;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class IndexController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException, IOException {
        // TODO Auto-generated method stub
        System.out.println("处理Get请求。。。。。");
        PrintWriter out = response.getWriter();
        out.println("Hello Servlet-Get");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // TODO Auto-generated method stub
        System.out.println("处理Post请求。。。。。");
        PrintWriter out = response.getWriter();
        out.println("Hello Servlet-Post");
    }
}
