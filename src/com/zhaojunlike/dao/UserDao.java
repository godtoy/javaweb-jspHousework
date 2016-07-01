package com.zhaojunlike.dao;

import sun.security.provider.MD5;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Created by zhaojun on 2016/6/16.
 */
public class UserDao extends BaseDao {

    public static final int LOGIN_ERR_NONE = 5;//没有用户
    public static final int LOGIN_ERR_PASS_ERROR = 6;//密码错误
    public static final int LOGIN_SUCCESS = 1;//登陆成功

    /**
     * 登陆用户
     *
     * @param username
     * @param password
     * @return 登陆代码
     */
    public int login(String username, String password) {
        try {
            StringBuilder sqlBuilder = new StringBuilder();
            sqlBuilder.append("select *from zj_admin where `username`='" + username + "' limit 1;");
            ResultSet resultSet = this.m_stmt.executeQuery(sqlBuilder.toString());

            int count = 0;
            while (resultSet.next()) {
                count++;
                int id = (int) resultSet.getObject("id");
                String db_pwd = (String) resultSet.getObject("password");
                if (password.equals(db_pwd)) {
                    return LOGIN_SUCCESS;
                } else {
                    return LOGIN_ERR_PASS_ERROR;
                }
            }
            if (count <= 0) {
                return LOGIN_ERR_NONE;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }


        return UserDao.LOGIN_SUCCESS;
    }

    /**
     * 获取异常登录代码
     *
     * @param e_code
     * @return 错误异常的信息
     */
    public static String getErrorMsg(int e_code) {
        String msg = "";
        switch (e_code) {
            case UserDao.LOGIN_ERR_NONE:
                msg = "用户名错误";
                break;
            case UserDao.LOGIN_ERR_PASS_ERROR:
                msg = "密码错误";
                break;
            case UserDao.LOGIN_SUCCESS:
                msg = "登陆成功";
                break;
            default:
                break;
        }
        return msg;
    }
}
