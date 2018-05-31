<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-4-14
  Time: 13:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>


<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

<style>
    body {

    }

    nav {
        border-radius: 5px;
        width: 1000px;
        height: 30px;
        position: fixed;
        top: 2%;
        left: 18%;
        right: 18%;
        background-color: #F5F5F5;
        opacity: 0.8;
        border-top: 1px solid gray;
        border-left: 1px solid gray;
        border-bottom: 3px solid gray;
        border-right: 3px solid gray;
        z-index: 10;
    }

    nav .foreRight {
        float: right;
        margin-right: 1em;
    }

    nav .foreLeft {
        margin-left: 1em;
    }

    nav .foreLeft .home {
        color: #DA251C;
    }

    nav a {
        font-size: 12px;
        text-decoration: none;
        color: gray;
        display: inline-block;
        padding-top: 5px;
    }

</style>


<nav class="foreTop">

    <span class="foreLeft">
        <a href="forehome" class="home">
            <span class="glyphicon glyphicon-home"></span>
            首页
        </a>
    </span>

    <sapn class="foreRight top">
        <c:if test="${!empty user}">
            <a href="#nowhere">${user.username}</a>
            <a href="forelogout">退出</a>
        </c:if>

        <c:if test="${empty user}">
            <a href="#nowhere" data-toggle="modal" data-target="#mainModalLogin">登录</a>
            <a href="registerPage">注册</a>
        </c:if>
    </sapn>

</nav>

<form action="forelogin" method="post">
    <div class="modal fade" id="mainModalLogin" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
        <div class="modal-dialog">
            <div class="modal-content">

                <div class="modal-header">
                    <button data-dismiss="modal" class="close" type="button">
                        <span aria-hidden="true">×</span>
                        <span class="sr-only">Close</span>
                    </button>
                    <h4>登录</h4>
                </div>

                <div class="modal-body">
                    <p>用户名</p>
                    <input type="text" name="username" class="form-control"/>
                    <p>密码</p>
                    <input type="password" name="password" class="form-control"/>
                </div>


                <div class="modal-footer">
                    <button data-dismiss="modal" class="btn btn-default" type="button">关闭</button>
                    <button class="btn btn-primary" type="submit">提交</button>
                </div>

            </div>
        </div>
    </div>
</form>