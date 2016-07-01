package com.zhaojunlike.dao;

/**
 * Created by zhaojun on 2016/6/16.
 */

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * 基础dao层
 */
public class BaseDao {

    protected Connection m_connection;
    protected Statement m_stmt;
    protected String m_tableName;
    protected String m_tableFix;

    public BaseDao() {
        String DB_CONN = "jdbc:mysql://localhost:3306/jsp_blog";
        String DRIVER_NAME = "com.mysql.jdbc.Driver";
        String DB_USER = "root";
        String DB_PASSWORD = "root";

        try {
            Class.forName(DRIVER_NAME);
            this.m_connection = DriverManager.getConnection(DB_CONN, DB_USER, DB_PASSWORD);
            this.m_stmt = m_connection.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //释放资源
    public void destroy() throws SQLException {

        try {
            if (m_connection.isClosed() == false) {
                this.m_connection.close();
                this.m_connection = null;
            }
            if (this.m_stmt.isClosed() == false) {
                this.m_stmt.close();
                this.m_stmt = null;
            }

        } catch (Exception ex) {
            throw ex;
        }


    }

}
