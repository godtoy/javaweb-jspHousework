package com.zhaojunlike.admin;

import com.zhaojunlike.bean.Admin;
import com.zhaojunlike.bean.News;
import com.zhaojunlike.dao.NewsDao;
import org.apache.catalina.connector.Request;
import org.apache.catalina.connector.Response;
import org.apache.catalina.mbeans.MBeanUtils;
import org.apache.commons.beanutils.BeanUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;
import java.io.PrintWriter;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojun on 2016/6/16.
 */
public class NewsServlet extends AdminServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html");
        NewsDao dao = new NewsDao();
        String act = "";
        act = req.getParameter("act");
        if (act == null) {
            act = "";
        }
        switch (act) {
            case "list":
                //获取列表
                List<News> list = new ArrayList<>();
                list = dao.select("", 10);//获取10条数据
                System.out.println("新闻列表数据:" + list.size());
                for (int i = 0; i < list.size(); i++) {
                    System.out.println("ID:" + list.get(i).getId());
                }
                req.setAttribute("newsList", list);
                req.getRequestDispatcher("/admin/news/list.jsp").forward(req, resp);
                break;
            case "search":
                //文章检索
                break;


            case "edit":
                List<News> listSI = new ArrayList<>();
                String editID = req.getParameter("id");
                if (editID == null) {
                    resp.getWriter().write("<script>alert('请选择要编辑的文章');window.location.href='/admin/news?act=list';</script>");
                    return;
                }
                listSI = dao.select("and `id`='" + editID + "'", 1);//获取10条数据
                if (listSI.size() != 1) {
                    resp.getWriter().write("<script>alert('系统错误，请检查程序');window.location.href='/admin/news?act=list';</script>");
                    return;
                }
                req.setAttribute("news", listSI.get(0));//获取弟一个就ok了
                req.getRequestDispatcher("/admin/news/edit.jsp").forward(req, resp);
                //编辑
                break;
            case "del":
                //ToDo
                //这里是直接get请求，不是post
                try {
                    String id = req.getParameter("id");
                    if (id == null) {
                        resp.getWriter().write("<script>alert('请选择删除的文章的ID');window.history.back();</script>");
                    } else {
                        System.out.println("删除ID=" + id);
                        if (dao.del(Integer.parseInt(id)) >= 1) {
                            resp.getWriter().write("<script>alert('删除成功');window.location.href='/admin/news?act=list';</script>");
                        } else {
                            resp.getWriter().write("<script>alert('删除失败');window.location.href='/admin/news?act=list';</script>");
                        }
                    }
                } catch (Exception ex) {


                }
                break;
            case "add":
                //添加
                req.getRequestDispatcher("/admin/news/add.jsp").forward(req, resp);
                break;
            default:
                PrintWriter printWriter = resp.getWriter();
                printWriter.write("<script>alert('No input Action!');window.history.back();</script>");
                break;
        }

        System.out.println();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter printWriter = resp.getWriter();
        String act = req.getParameter("act");
        if (act == null) {
            act = "";
        }
        System.out.println("POST-ACT:" + act);
        NewsDao dao = new NewsDao();
        switch (act) {
            case "add": {
                News news = new News();
                String title = req.getParameter("title");
                String desc = req.getParameter("desc");
                String content = req.getParameter("content");
                String view = req.getParameter("view");
                String zan = req.getParameter("zan");
                String status = req.getParameter("status");
                try {
                    news.setTitle(title);
                    news.setDesc(desc);
                    news.setContent(content);
                    news.setStatus(Integer.parseInt(status));
                    news.setZan(Integer.parseInt(zan));
                    news.setView(Integer.parseInt(view));
                    int isAdd = dao.add(news);
                    if (isAdd <= 0) {
                        throw new Exception("对不起添加失败");
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    printWriter.write("<meta charset='utf8'><script>alert('对不起添加失败!');window.history.back();</script>");
                    return;
                }
                printWriter.write("<meta charset='utf8'><script>alert('添加成功!');window.location.href='/admin/news?act=list';</script>");
            }
            break;
            case "del":
                String id = req.getParameter("id");
                if (id == null) {
                    resp.getWriter().write("{\"status\":0,\"msg\":\"del error\"}");
                } else {
                    System.out.println("删除ID=" + id);
                    if (dao.del(Integer.parseInt(id)) >= 1) {
                        resp.getWriter().write("{\"status\":1,\"msg\":\"del success\"}");
                        return;
                    } else {
                        resp.getWriter().write("{\"status\":0,\"msg\":\"del error\"}");
                        return;
                    }
                }
                break;
            case "edit":
                editAction(req, resp);
                break;
            default:
                printWriter.write("<script>alert('No input Action!');window.history.back();</script>");
                break;
        }
        return;
    }

    private void editAction(HttpServletRequest req, HttpServletResponse response) throws IOException {
        PrintWriter printWriter = response.getWriter();
        News news = new News();
        String id = req.getParameter("id");
        String title = req.getParameter("title");
        String desc = req.getParameter("desc");
        String content = req.getParameter("content");
        String view = req.getParameter("view");
        String zan = req.getParameter("zan");
        String status = req.getParameter("status");
        NewsDao dao = new NewsDao();
        try {
            news.setId(Integer.parseInt(id));
            news.setTitle(title);
            news.setDesc(desc);
            news.setContent(content);
            news.setStatus(Integer.parseInt(status));
            news.setZan(Integer.parseInt(zan));
            news.setView(Integer.parseInt(view));
            int isAdd = dao.update(news);
            if (isAdd <= 0) {
                throw new Exception("对不起修改失败");
            }
        } catch (Exception ex) {
            ex.printStackTrace();
            printWriter.write("<meta charset='utf8'><script>alert('对不起修改失败!');window.history.back();</script>");
            return;
        }
        printWriter.write("<meta charset='utf8'><script>alert('修改成功!');window.location.href='/admin/news?act=list';</script>");
    }
}
