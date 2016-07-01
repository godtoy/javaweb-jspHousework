<%@ page import="com.zhaojunlike.bean.News" %><%--
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
    <title>XX科技-详情</title>
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
    .detail-header, .detail-footer {
        border-bottom: 3px solid #949893;
    }

    .detail-more {
        min-height: 30px;
    }

    .detail-more label {
        margin-right: 15px;
    }

    .detail-header h3 {
        padding-bottom: 30px;
    }

    .detail-content {
        padding-top: 30px;
        min-height: 400px;
    }
</style>
<% News single = (News) request.getAttribute("single");%>
<div class="container main-body">
    <div class="row">
        <div class="detail-header">
            <h3 class="text-center">
                <%=single.getTitle()%>
            </h3>
            <div class="detail-more">
                <div class=" pull-right">
                    <label>发表于：-----</label>
                    <label>发布人：admin</label>
                    <label>发布时间：2016-09-23 23:21</label>
                </div>
            </div>
        </div>
    </div>
    <div class="row">
        <div class="detail-content">
            <%=single.getContent()%>
        </div>
    </div>
    <div class="row">
        <div class="detail-footer">

        </div>
    </div>
</div>


<%@include file="/home/public/footer.jsp" %>
</body>
</html>
