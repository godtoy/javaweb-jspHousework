package com.zhaojunlike.admin;

import com.zhaojunlike.dao.UserDao;
import com.zhaojunlike.utils.Functions;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by zhaojun on 2016/4/28.
 */
@WebServlet(name = "PublicServlet")
public class PublicServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("act");
        if (act == null) {
            response.sendRedirect("/admin/public?act=login");
            return;
        }
        /**
         * 设置编码
         */
        request.setCharacterEncoding("UTF-8");
        response.setCharacterEncoding("UTF-8");
        //响应头的contentType
        response.setContentType("text/html");

        switch (act) {
            case "login":
                HttpSession session = request.getSession();
                String uid = (String) session.getAttribute("login_user_id");
                if (uid == null) {
                    //checklogin
                    String username = request.getParameter("username");
                    String password = request.getParameter("password");
                    System.out.println("username=" + username + ",password=" + password);
                    int isLog = Functions.adminLogin(username, password);
                    if (isLog == UserDao.LOGIN_SUCCESS) {
                        //登录成功跳转首页
                        HttpSession httpSession = request.getSession();
                        httpSession.setAttribute("login_admin_true", 1);//这里应该是用户的id
                        response.sendRedirect("/admin/index");
                    } else {
                        String errorMsg = UserDao.getErrorMsg(isLog);
                        String str = "<meta charset='utf8'><script>alert('" + errorMsg + "');window.history.back();</script>";
                        response.getWriter().write(str);
                    }
                }
                break;
        }


    }

    /**
     * Get:
     *
     * @param request
     * @param response
     * @throws ServletException
     * @throws IOException
     */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String act = request.getParameter("act");
        if (act == null) {
            response.sendRedirect("/admin/public?act=login");
            return;
        }

        switch (act) {
            case "login":
                //请求转发
                request.getRequestDispatcher("/admin/public/login.jsp").forward(request, response);
                break;
            case "verify":
                //获取验证码

                break;
            default:
                break;
        }
    }


}
