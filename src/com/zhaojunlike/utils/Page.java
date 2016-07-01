package com.zhaojunlike.utils;

/**
 * Created by zhaojun on 2016/4/28.
 */

/**
 * 分页操作类
 */
public class Page {


    private int mTotalCount;//总数
    private int mLimitCount;//分页数量
    private String mPageParam = "p";//分页获取名称
    private int currentPage;//当前页面数

    private int pageCount;//分页数量


    public Page(int totalCount) {
        this.mLimitCount = 20;
        this.mTotalCount = totalCount;
        this.initPageCount();
    }

    public Page(int totalCount, int limitCount) {
        this.mLimitCount = limitCount;
        this.mTotalCount = totalCount;
        this.initPageCount();

    }

    private void initPageCount() {
        int totalPage = (int) Math.ceil(mTotalCount / mLimitCount);//向上取整数
        this.mTotalCount = totalPage;
    }


    /*生成一个url*/
    private String createUrl(int pageNum) {

        return "";
    }

    /*分页输出，直接是一个字符串*/
    public String show() {
        StringBuilder builder = new StringBuilder();
        builder.append("<ul style='list-style:none;'>");
        String pageFirst = "<a href='http:localhost:8080/" + 1 + "?p=" + 1 + "'>首页</a>";
        for (int i = 1; i <= this.mTotalCount; i++) {

        }
        builder.append("<ul/>");
        return builder.toString();
    }
}
