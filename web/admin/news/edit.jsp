<%@ page import="com.zhaojunlike.bean.News" %><%--
  Created by IntelliJ IDEA.
  User: zhaojun
  Date: 2016/6/16
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java" %>
<html>
<head>
    <title>新闻-编辑</title>
    <!--import  u-->
    <%@include file="/admin/public/head.jsp" %>
</head>
<body>
<%@include file="/admin/public/header.jsp" %>

<%
    News news = (News) request.getAttribute("news");
%>
<div class="container">
    <div class="row">
        <h4>新闻添加</h4>
        <!-- 加载编辑器的容器 -->
        <form action="/admin/news" method="post">
            <!--编辑模式-->
            <input type="hidden" name="act" value="edit">
            <!--id-->
            <input type="hidden" name="id" value="<%=news.getId()%>">
            <div class="form-group">
                <label class="control-label">新闻标题</label>
                <input name="title" value="<%=news.getTitle()%>" class="form-control">
            </div>
            <div class="form-group">
                <label class="control-label">描述</label>
                <input name="desc" value="<%=news.getDesc()%>" class="form-control">
            </div>

            <div class="form-group">
                <label class="control-label">访问量</label>
                <input name="view" value="<%=news.getView()%>" class="form-control">
            </div>
            <div class="form-group">
                <label class="control-label">赞</label>
                <input name="zan" value="<%=news.getZan()%>" class="form-control">
            </div>
            <div class="form-group">
                <label class="control-label">状态</label>
                <select class="form-control" name="status">
                    <option value="0">禁用</option>
                    <option value="1">启用</option>
                </select>
            </div>
            <div class="form-group">
                <label class="control-label">新闻内容</label>
                <script id="content_container" name="content" type="text/plain"></script>
            </div>
            <div class="form-group">
                <label class="control-label">新闻分类</label>
                <select name="category">
                    <option class="head" value="0">顶级分类</option>
                    <option class="" value="1">新闻</option>
                </select>
            </div>
            <div class="form-group text-center">
                <button class="btn btn-primary" type="submit">确认添加</button>
                <button class="btn btn-default" type="reset">重置</button>
            </div>
        </form>
    </div>

    <div style="display: none;" id="edit_content" name="edit_content"><%=news.getContent()%>
    </div>
</div>
<!-- 配置文件 -->
<script type="text/javascript"
        src="${pageContext.servletContext.contextPath}/public/ueditor/ueditor.config.js"></script>
<!-- 编辑器源码文件 -->
<script type="text/javascript"
        src="${pageContext.servletContext.contextPath}/public/ueditor/ueditor.all.js"></script>
<!-- 实例化编辑器 -->

<script type="text/javascript">
    var ue = UE.getEditor('content_container');
    ue.ready(function () {
        var html = document.getElementById("edit_content").innerHTML;
        ue.setContent(html);
    });
</script>

</body>
</html>
