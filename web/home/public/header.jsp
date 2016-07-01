<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<style>
    a:focus {
        outline: none;
    }

    .navbar {
        border: none;
        background-color: #455a64;
        border-radius: 0px;
        box-shadow: 2px 0px 3px 0px #2b3c46;
    }

    .navbar .navbar-brand {
        color: #fff;
        transition: .3s;
    }

    .navbar .navbar-brand:hover {
        padding-left: 30px;
        padding-right: 30px;
        color: #fff;
    }

    .navbar.navbar-default li a {
        transition: .3s;
        color: #fff;
        opacity: .8;
    }

    .navbar.navbar-default li a:focus {
        color: #fff;
        opacity: 1;
    }

    .navbar.navbar-default li a:hover {
        color: #fff;
        opacity: 1;
    }

    .navbar.navbar-default .dropdown-menu {
        text-align: center;
        background-color: #455a64;

    }

    .navbar.navbar-default .dropdown-menu li a {
        padding: 5px 10px;
    }

    .navbar.navbar-default .dropdown-menu li a i {
        padding-right: 5px;
    }

    .navbar.navbar-default .dropdown-menu li a:hover {
        background-color: #455a64;
    }
</style>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <!-- Brand and toggle get grouped for better mobile display -->
        <div class="navbar-header ">
            <button type="button" class="navbar-toggle collapsed" data-toggle="collapse"
                    data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span class="sr-only">Toggle navigation</span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
                <span class="icon-bar"></span>
            </button>
            <a class="navbar-brand" href="/home/index/index.jsp">首页</a>
        </div>

        <!-- Collect the nav links, forms, and other content for toggling -->
        <div class="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <li><a href="/home/page/info.jsp">公司简介 <span class="sr-only">(current)</span></a></li>
                <li><a href="/home/page/message.jsp">最新资讯</a></li>
                <li><a href="/home/page/direction.jsp">研究方向</a></li>
                <li class="dropdown">
                    <a href="#" class="dropdown-toggle" data-toggle="dropdown" role="button" aria-haspopup="true"
                       aria-expanded="false">企业新闻 <span class="caret"></span></a>
                    <ul class="dropdown-menu">
                        <li><a href="/home/news?a=new"><i class="glyphicon glyphicon-heart"> </i>最新</a></li>
                        <li><a href="/home/news?a=hot"><i class="glyphicon glyphicon-star"> </i>热搜</a></li>
                        <li><a href="/home/news?a=rec"><i class="glyphicon glyphicon-flag"> </i>推荐</a></li>
                    </ul>
                </li>
                <li><a href="/home/page/contact.jsp">联系我们</a></li>
            </ul>

        </div><!-- /.navbar-collapse -->
    </div><!-- /.container-fluid -->
</nav>