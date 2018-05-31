<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-4-16
  Time: 14:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    body {
        background-color: #F9F9F9;
    }

    div.homeContent {
        width: 99%;
        height: 600px;
        position: absolute;
        top: 10%;
    }

    div.homeContent-page {
        width: 850px;
        height: 550px;
        /*border:2px solid black;*/
        margin: 0px auto;
        background-color: #FFFFFF;
    }

    div.homeContent-page .szpt_logo {
        text-align: center;
        padding-top: 20px;
    }

    div.homeContent-page table {
        margin: 60px auto;
        width: 300px;
        height: 40px;
        font-size: 12px;
        color: gray;
    }

    div.homeContent-page table tr {
        height: 100px;
        /*border:1px solid black;*/
        text-align: center;
    }

    div.homeContent-page table #title {
        font-size: 30px;
        text-align: center;
        color: black;
    }
</style>

<script>
    $(function () {
        <c:if test="${!empty msg}">
        $("span.errorMessage").html("${msg}");
        </c:if>
    });
</script>

<div class="homeContent">
    <div class="homeContent-page">
        <div class="szpt_logo">
            <img src="img/fore/szpt_logo.jpg" width="50px" height="50px"/>
        </div>
        <table>
            <tr id="title">
                <td>登录失败</td>
            </tr>
            <tr>
                <td><span class="errorMessage"></span></td>
            </tr>
            <tr>
                <td><a href="forehome">
                    <button type="button" class="btn btn-block" style="background-color:#DA251C;color:white">返回主页
                    </button>
                </a></td>
            </tr>
        </table>
    </div>
</div>
