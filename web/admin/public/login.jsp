<%--
  Created by IntelliJ IDEA.
  User: zhaojun
  Date: 2016/4/28
  Time: 8:39
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理员-登陆</title>
    <link rel="stylesheet" href="../public/bootstrap/css/bootstrap.css">
    <style>
        .reg-form {
            margin-top: 50px;
            box-shadow: 2px 2px 3px 0px #1b6d85;
            padding: 30px;
        }
    </style>
</head>
<body>

<div class="container">
    <div class="row">
        <div class="col-md-4 col-md-offset-4 reg-form">
            <h3 class="text-center">zhaojunlike-后台管理</h3>
            <form action="${pageContext.request.contextPath}/admin/public" method="post"
                  class="form-horizontal">
                <input type="hidden" name="act" value="login">
                <div class="form-group">
                    <label class="control-label">用户名：</label>
                    <input class="form-control" name="username">
                </div>

                <div class="form-group">
                    <label class="control-label">密码：</label>
                    <input class="form-control" name="password">
                </div>
                <div class="form-group text-center">
                    <button class="btn btn-primary" type="submit">登录</button>
                </div>
            </form>
        </div>
    </div>
</div>
</body>
</html>
