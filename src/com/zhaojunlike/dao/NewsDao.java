package com.zhaojunlike.dao;

import com.zhaojunlike.bean.News;
import com.zhaojunlike.utils.MySqlHelper;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojun on 2016/6/16.
 */
public class NewsDao extends BaseDao {

    public NewsDao() {
        this.m_tableName = "zj_news";
    }

    /**
     * 查询新闻
     *
     * @param where
     * @param count
     * @return
     */
    public ArrayList<News> select(String where, int count) {
        ArrayList<News> newsList = new ArrayList<News>();
        StringBuilder builder = new StringBuilder();
        builder.append("select *from " + this.m_tableName + " where 1=1 " + where + " limit " + count);
        ResultSet resultSet = MySqlHelper.executeQuery(builder.toString(), new String[]{});
        try {
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setTitle(resultSet.getString("title"));
                news.setDesc(resultSet.getString("desc"));
                news.setContent(resultSet.getString("content"));
                news.setView(resultSet.getInt("view"));
                news.setZan(resultSet.getInt("zan"));
                news.setStatus(resultSet.getInt("status"));
                news.setCreate_time(resultSet.getString("create_time"));
                news.setUpdate_time(resultSet.getString("update_time"));
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }


    /**
     * 组合分页
     *
     * @param endParams
     * @return
     */
    public ArrayList<News> select(String endParams) {
        ArrayList<News> newsList = new ArrayList<News>();
        StringBuilder builder = new StringBuilder();
        builder.append("select *from " + this.m_tableName + " where 1=1 " + endParams);
        ResultSet resultSet = MySqlHelper.executeQuery(builder.toString(), new String[]{});
        try {
            while (resultSet.next()) {
                News news = new News();
                news.setId(resultSet.getInt("id"));
                news.setTitle(resultSet.getString("title"));
                news.setDesc(resultSet.getString("desc"));
                news.setContent(resultSet.getString("content"));
                news.setView(resultSet.getInt("view"));
                news.setZan(resultSet.getInt("zan"));
                news.setStatus(resultSet.getInt("status"));
                news.setCreate_time(resultSet.getString("create_time"));
                news.setUpdate_time(resultSet.getString("update_time"));
                newsList.add(news);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return newsList;
    }


    public int add(News news) {

        String sql = "INSERT INTO " + this.m_tableName + "(`id`,`title`,`desc`,`content`,`view`,`zan`,`status`) VALUES(null,?,?,?,?,?,?)";
        String[] params = new String[]{news.getTitle(), news.getDesc(), news.getContent(), String.valueOf(news.getView()), String.valueOf(news.getZan()), String.valueOf(news.getStatus())};
        return MySqlHelper.executeUpdate(sql, params);
    }

    /**
     * del
     *
     * @param where
     * @return
     */
    public int del(String where) {
        return MySqlHelper.executeUpdate("DELETE FROM " + this.m_tableName + " WHERE id=?", new String[]{String.valueOf(where)});
    }

    /**
     * del
     *
     * @param id
     * @return
     */
    public int del(int id) {
        return MySqlHelper.executeUpdate("DELETE FROM " + this.m_tableName + " WHERE `id`=?", new String[]{String.valueOf(id)});
    }

    public int update(News news) {
        StringBuilder builder = new StringBuilder();
        builder.append("update " + this.m_tableName + " set `title`='" + news.getTitle() + "'");
        builder.append(",`desc`='" + news.getDesc() + "'");
        builder.append(",`content`='" + news.getContent() + "'");
        builder.append(",`view`='" + news.getView() + "'");
        builder.append(",`zan`='" + news.getZan() + "'");
        builder.append(",`status`='" + news.getStatus() + "'");
        builder.append(",`view`='" + news.getView() + "'");
        builder.append(" where `id`='" + news.getId() + "'");
        System.out.println("SQL:" + builder.toString());
        return MySqlHelper.executeUpdate(builder.toString(), new String[]{});
    }


    /**
     * 获取最热
     *
     * @param p
     * @param c
     * @return
     */
    public List<News> getHot(int p, int c) {
        String where = " order by view limit " + c;
        return this.select(where);
    }

    public List<News> getRec(int p, int c) {
        String where = " order by view desc limit " + c;
        return this.select(where);
    }

    public List<News> getNew(int p, int c) {
        String where = " order by create_time limit " + c;
        return this.select(where);
    }

    public List<News> getALL(int p, int c) {
        String where = " order by id desc limit " + c;
        return this.select(where);
    }
}
