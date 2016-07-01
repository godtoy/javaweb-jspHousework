package com.zhaojunlike.admin;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by zhaojun on 2016/4/28.
 */
@WebServlet(name = "CategoryServlet")
public class CategoryServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("探索生命周期：" + "doPost");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.service(req, resp);
        System.out.println("探索生命周期：" + "service(HttpServletRequest,HttpServletResponse)");
    }

    @Override
    public void service(ServletRequest req, ServletResponse res) throws ServletException, IOException {
        super.service(req, res);
        System.out.println("探索生命周期：" + "service(ServletRequest,ServletResponse)");

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        PrintWriter printWriter = response.getWriter();
        int i = 1000;
        while (true) {
            printWriter.println("Zhaojunlike");
            printWriter.flush();
            i--;
            if (i <= 0) {
                break;
            }
        }
        System.out.println("探索生命周期：" + "doGet()");
    }

    @Override
    public void init(ServletConfig config) throws ServletException {
        super.init(config);
        System.out.println("探索生命周期：" + "init(config)");
    }

    @Override
    public void init() throws ServletException {
        super.init();
        System.out.println("探索生命周期：" + "init()");


    }
}
