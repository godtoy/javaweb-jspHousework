package com.zhaojunlike.home;

import com.zhaojunlike.bean.News;
import com.zhaojunlike.dao.NewsDao;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zhaojun on 2016/6/2.
 */
public class NewsServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String act = req.getParameter("a");
        String pStr = req.getParameter("p");//分页
        int p = 1;
        if (pStr != null) {
            p = Integer.parseInt(pStr);
        }
        if (act == null) {
            act = "all";//默认是列表页面
        }
        NewsDao dao = new NewsDao();//M层
        List<News> newsList = new ArrayList<>();
        switch (act) {
            case "all":
                newsList = dao.getALL(p, 15);//获取最热
                req.setAttribute("type", "所有新闻");
                req.setAttribute("list", newsList);
                req.getRequestDispatcher("/home/news/list.jsp").forward(req, resp);
                break;
            case "new":
                //请求转发
                newsList = dao.getNew(p, 15);//获取最热
                req.setAttribute("type", "最新");
                req.setAttribute("list", newsList);
                req.getRequestDispatcher("/home/news/list.jsp").forward(req, resp);
                break;
            case "hot":
                //请求转发
                newsList = dao.getHot(p, 15);//获取最热
                req.setAttribute("type", "最热");
                req.setAttribute("list", newsList);
                req.getRequestDispatcher("/home/news/list.jsp").forward(req, resp);
                break;
            case "rec":
                //请求转发
                newsList = dao.getRec(p, 15);//获取最热
                req.setAttribute("type", "推荐");
                req.setAttribute("list", newsList);
                req.getRequestDispatcher("/home/news/list.jsp").forward(req, resp);
                break;
            case "detail":
                String id = req.getParameter("id");
                if (id == null) {
                    resp.getWriter().write("<script>alert('没有选择文章!');window.history.back();</script>");
                    return;
                }
                List<News> news = dao.select("and `id`=" + id + " ", 1);
                if (news.size() <= 0) {
                    resp.getWriter().write("<script>alert('对不起，文章已经被删除!');window.history.back();</script>");
                    return;
                }
                System.out.println("新闻详细，ID=" + id);

                News newsSingle = news.get(0);//获取一个
                req.setAttribute("single", newsSingle);
                req.getRequestDispatcher("/home/news/detail.jsp").forward(req, resp);
                break;
            default:
                break;
        }


    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }
}
