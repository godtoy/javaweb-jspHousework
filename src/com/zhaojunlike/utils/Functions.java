package com.zhaojunlike.utils;

import com.sun.deploy.util.SessionState;
import com.zhaojunlike.dao.UserDao;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;

/**
 * Created by zhaojun on 2016/6/2.
 */
public class Functions {

    public boolean checkUserLogin() {
        boolean tag = false;

        return tag;
    }


    public String timeToDate(int time) {
        String result = "";


        return result;
    }

    public static boolean isAdminLogin(HttpServletRequest request) {
        boolean tag = false;
        HttpSession session = request.getSession();
        int uid = 0;
        try {
            Object sObj = session.getAttribute("login_admin_true");
            if (sObj != null) {
                uid = Integer.parseInt(String.valueOf(sObj));
            }
        } catch (Exception ex) {
            System.err.println(ex.getMessage());
        }
        System.out.println("Session:" + uid);
        if (uid > 0) {
            tag = true;
        }
        return tag;
    }

    public static boolean isUserLogin(HttpServletRequest request) {
        boolean tag = false;
        HttpSession session = request.getSession();
        boolean str = (boolean) session.getAttribute("login_user_true");
        if (str == true) {
            tag = true;
        }
        return tag;
    }

    /**
     * 用户登录
     *
     * @param username
     * @param password
     * @return
     */
    public static boolean userLogin(String username, String password) {
        boolean tag = false;

        return tag;
    }

    /**
     * 后台登陆
     *
     * @param username
     * @param password
     * @return
     */
    public static int adminLogin(String username, String password) {
        UserDao dao = new UserDao();
        //这里需要进行md5 password
        password = Functions.md5Password(password);
        int l_code = dao.login(username, password);
        return l_code;
    }

    /**
     * 加密
     *
     * @param pwd
     * @return
     */
    public static String md5Password(String pwd) {

        return pwd;
    }
}
