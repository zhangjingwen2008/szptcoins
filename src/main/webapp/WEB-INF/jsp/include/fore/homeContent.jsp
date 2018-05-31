<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-4-15
  Time: 14:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

<style>
    div.homeContent {
        width: 100%;
        height: 300px;
        /*border:2px solid black;*/
        background-color: #F5F5F5;
    }

    div.homeContent-page {
        width: 1200px;
        height: 300px;
        border: 2px solid black;
        margin: 0px auto;
        background-color: #F5F5F5;
    }

    div.homeContent-page .home-login {
        width: 100%;
        height: 100%;
        font-size: 100px;
    }

    div.box {
        /*border:1px solid black;*/
        width: 200px;
        height: 200px;
        float: left;
        margin-left: 160px;
        margin-top: 65px;
    }

    div.box .circle {
        border: 2px solid #DA251C;
        width: 100px;
        height: 100px;
        border-radius: 50%;
        text-align: center;
        line-height: 98px;
        font-size: 30px;
        color: #DA251C;
        margin:0px 25%;
    }

    div.box span {
        text-align: center;
        display: block;
        line-height: 60px;
    }

    div.box .circle .glyphicon {
        margin-top: 17px;
        margin-left: 2px;
    }

</style>
<script>
</script>
<div class="homeContent">
    <div class="homeContent-page">
        <c:if test="${!empty user}">

            <c:if test="${empty personalInfo}">
                <a href="personalInfo">
                    <button type="button" class="btn btn-block btn-lg btn-danger">Setting Personal Information</button>
                </a>
            </c:if>

            <div class="box">
                <div class="circle">${estate.coins}</div>
                <span>balance</span>
            </div>
            <div class="box">
                <div class="circle">${estate.power}</div>
                <span>power</span>
            </div>
            <%--<div class="box">--%>
                <%--<div class="circle">0</div>--%>
                <%--<span>msg</span>--%>
            <%--</div>--%>
            <div class="box">
                <a href="personalInfo">
                    <div class="circle"><span class="glyphicon glyphicon-cog"></span></div>
                    <span>setting</span>
                </a>
            </div>

        </c:if>


        <c:if test="${empty user}">
            <a href="#nowhere" data-toggle="modal" data-target="#mainModalLogin">
                <button type="button" class="btn btn-success home-login">LOGIN</button>
            </a>
        </c:if>


    </div>
</div>


