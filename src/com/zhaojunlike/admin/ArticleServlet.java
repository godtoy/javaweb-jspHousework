package com.zhaojunlike.admin;

import com.sun.net.httpserver.Headers;
import com.sun.net.httpserver.HttpHandler;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by zhaojun on 2016/4/28.
 */
@WebServlet(name = "ArticleServlet")
public class ArticleServlet extends HttpServlet {

    @Override
    public void destroy() {
        super.destroy();
        System.out.println("destroy");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("init");
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        response.setStatus(302);

        //response.sendRedirect("index.jsp");
        //response.setHeader("Location","index.jsp");


        response.setHeader("refresh", "2;http://localhost:8080/index.jsp");

        System.out.println("doGet");


    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("Service");
    }
}
