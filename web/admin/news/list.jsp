<%@ page import="com.zhaojunlike.bean.News" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: zhaojun
  Date: 2016/6/16
  Time: 8:36
  To change this template use File | Settings | File Templates.
--%>
<%@
        page contentType="text/html;charset=UTF-8" pageEncoding="UTF-8" language="java"
%>
<html>
<head>
    <title>新闻-列表</title>
    <!--import  u-->
    <%@include file="/admin/public/head.jsp" %>
</head>
<body>
<%@include file="/admin/public/header.jsp" %>
<div class="container">
    <div class="row">
        <ul class="list-group list-inline">
            <li><a data-action="del" class="btn btn-danger">删除</a></li>
            <li><a data-action="ban" class="btn btn-warning">禁用</a></li>
            <li><a data-action="open" class="btn btn-success">启用</a></li>
            <li><a data-action="recmd" class="btn btn-info">推荐</a></li>
            <li><a data-action="unrecmd" class="btn btn-info">取消推荐</a></li>
        </ul>
    </div>
    <div class="row">

        <table class="table table-bordered table-hover">
            <thead>
            <td><input type="checkbox" class="check-all"></td>
            <td>ID</td>
            <td>标题</td>
            <td>描述</td>
            <td>访问量</td>
            <td>赞</td>
            <td>创建时间</td>
            <td>最后更新</td>
            <td>状态</td>
            <td>操作</td>
            </th>
            </thead>
            <tbody>
            <% List<News> newsList = (List<News>) request.getAttribute("newsList");%>
            <% for (int i = 0; i < newsList.size(); i++) {%>
            <tr class="news-item-<%=newsList.get(i).getId()%>">
                <td><input type="checkbox" class="check-item" data-id="<%=newsList.get(i).getId()%>"></td>
                <td>
                    <%=newsList.get(i).getId()%>
                </td>
                <td>
                    <%=newsList.get(i).getTitle()%>
                </td>

                <td>
                    <%=newsList.get(i).getDesc()%>
                </td>
                <td>
                    <%=newsList.get(i).getView()%>
                </td>
                <td>
                    <%=newsList.get(i).getZan()%>
                </td>
                <td>
                    <%=newsList.get(i).getCreate_time()%>
                </td>
                <td>
                    <%=newsList.get(i).getUpdate_time()%>
                </td>
                <td>
                    
                </td>
                <td>
                    <a href="/admin/news?act=edit&id=<%=newsList.get(i).getId()%>"
                       class="btn btn-sm btn-info">编辑</a>
                    <a data-do="del" data-id="<%=newsList.get(i).getId()%>"
                       href="/admin/news?act=del&id=<%=newsList.get(i).getId()%>"
                       class="btn btn-sm btn-danger">删除</a>
                </td>
            </tr>
            <% }%>
            </tbody>
        </table>
    </div>
    <script>
        $(function () {
            $("a[data-do='del']").bind('click', function (e) {

                var actRet = confirm("确认删除么，行为不可逆!!");
                if (actRet == true) {
                    var id = $(this).attr("data-id");
                    $.post("/admin/news", {'act': 'del', 'id': id}, function (ret) {
                        var de = JSON.parse(ret);
                        //console.log(de);
                        if (de.status == 1) {
                            alert("删除成功");
                            $(".news-item-" + id).remove();//移除
                        } else {
                            alert("删除失败，Message:" + ret['msg']);
                        }
                    });
                }
                e.preventDefault();
                return false;
            });


        });
    </script>
</div>
</body>
</html>
