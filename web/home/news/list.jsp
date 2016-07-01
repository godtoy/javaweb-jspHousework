<%@ page import="com.zhaojunlike.bean.News" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.Random" %><%--
  Created by IntelliJ IDEA.
  User: zhaojun
  Date: 2016/4/21
  Time: 18:57
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>
        XX科技-<%=(String) request.getAttribute("type")%>
    </title>
    <%@ include file="/home/public/head.jsp" %>
</head>
<body>
<!--包含头部-->
<%@ include file="/home/public/header.jsp" %>
<div class="container">
    <div class="row">
        <div class="blog">
            <h3></h3>
        </div>
    </div>
</div>
<style>
    .news-item {
        padding: 10px;
        cursor: pointer;
    }

    .news:hover {
        box-shadow: 2px 2px 3px 2px silver;
        border: none;
        border-radius: 5px;
    }

    .news-item .news {
        border: 1px solid #dddddd;
        transition: .2s;
    }

    .news-item .news-header {
        padding: 3px 5px;
    }

    .news-item .news-header h4 {

    }

    .news-item .news-header p {
        font-size: 11px;
        min-height: 40px;
        overflow: hidden;
        padding-left: 5px;
    }

    .news-item .news-footer {
        padding: 5px 8px;
        margin-top: 3px;
        margin-bottom: 3px;
    }

    .news-item .news-footer i {
        margin-right: 3px;
    }

    .news-item .news-img img {
        max-height: 250px;
        width: 100%;
    }
</style>
<% List<News> newsList = (List<News>) request.getAttribute("list");%>
<div class="container main-body">
    <div class="row">
        <!--参数时间种子-->
        <% Random random = new Random(System.currentTimeMillis());%>
        <% for (int i = 1; i <= newsList.size(); i++) {%>
        <div class="col-md-3 news-item" data-id="<%=newsList.get(i - 1).getId()%>">
            <div class="news">
                <div class="news-img">
                    <!--随机图片-->
                    <img src="/public/imgs/<%=random.nextInt(4)%>.jpg" class="img-responsive"/>
                </div>
                <div class="news-header">
                    <h4>
                        <%=newsList.get(i - 1).getTitle()%>
                    </h4>
                    <p>
                        <%="" + newsList.get(i - 1).getDesc()%>
                    </p>
                </div>
                <div class="news-footer" style="min-height: 30px">
                    <div class="view pull-left">
                        <i class="glyphicon glyphicon-eye-open"> </i><%=newsList.get(i - 1).getView()%>
                    </div>
                    <div class="time pull-right">
                        <i class="glyphicon glyphicon-screenshot"> </i>2014-06-23 09:21
                    </div>
                </div>
            </div>
        </div>
        <%}%>
    </div>
</div>

<%@include file="/home/public/footer.jsp" %>

<script>
    $(function () {

        $(".news-item").bind('click', function () {
            var id = $(this).attr("data-id");
            window.location.href = "/home/news?a=detail&id=" + id;
        })
    })
</script>
</body>
</html>
