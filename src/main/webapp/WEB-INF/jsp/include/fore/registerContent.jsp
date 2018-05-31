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
        height: 650px;
        /*border:2px solid black;*/
        margin: 0px auto;
        background-color: #FFFFFF;
    }

    div.homeContent-page .szpt_logo {
        text-align: center;
        padding-top: 20px;
    }

    div.homeContent-page table {
        margin: 0px auto;
        width: 300px;
        height: 40px;
        font-size: 12px;
        color: gray;
    }

    div.homeContent-page table tr {
        height: 60px;
        /*border:1px dashed black;*/
    }

    div.homeContent-page table #title {
        font-size: 30px;
        text-align: center;
        height: 70px;
        color: black;
    }

    div.homeContent-page table span.errorMsg {
        height: 30px;
        line-height: 20px;
        /*border:1px solid black;*/
    }
</style>

<script>
    $(function () {
        /*用户名验证*/
        $("#username").blur(function () {
            var page = "foreRegistAjax";
            var value = $(this).val();
            if ($(this).val().match(/^[a-zA-Z]\w{3,17}$/)) {
                $.post(
                    page,
                    {"username": value},
                    function (result) {
                        if (result == "success") {
                            $("#usernameMsg").html(" 用户名可以使用");
                            $("#usernameMsg").css("color", "green");
                            $("#usernameMsg").removeClass("glyphicon glyphicon-warning-sign");
                            $("#usernameMsg").addClass("glyphicon glyphicon-check");
                        }
                        if (result == "fail") {
                            $("#usernameMsg").html(" 用户名已存在");
                            $("#usernameMsg").css("color", "#DA251C");
                            $("#usernameMsg").addClass("glyphicon glyphicon-warning-sign");
                        }
                    }
                );
            } else {
                $("#usernameMsg").html(" 用户名格式：首字符必须为字母，可包含横杠和下划线与数字，且为4-18位");
                $("#usernameMsg").css("color", "#DA251C");
                $("#usernameMsg").addClass("glyphicon glyphicon-warning-sign");
            }

        });

        /*学号验证*/

        /*密码验证*/
        $("#password").blur(function () {
            if (!$(this).val().match(/^\w{3,11}$/)) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 密码格式：只允许字母和数字，且为3-11位");
                $("span.errorMsg").css("color", "#DA251C");
            } else {
                $("span.errorMsg").removeClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html("");
            }
        });

        /*提交验证*/
        $(".registForm").submit(function () {
            if ($("#username").val().length == 0) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 请输入用户名");
                $("span.errorMsg").css("color", "#DA251C");
                $("#username").focus();
                return false;
            }
            if (!$("#username").val().match(/^[a-zA-Z]\w{3,17}$/)) {
                $("#usernameMsg").html(" 用户名格式：首字符必须为字母，可包含横杠和下划线与数字，且为4-18位");
                $("#usernameMsg").css("color", "#DA251C");
                $("#usernameMsg").addClass("glyphicon glyphicon-warning-sign");
                return false;
            }
            if ($("#password").val().length == 0) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 请输入密码");
                $("span.errorMsg").css("color", "#DA251C");
                $("#password").focus();
                return false;
            }
            if (!$("#password").val().match(/^\w{3,11}$/)) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 密码格式：只允许字母和数字，且为3-11位");
                $("span.errorMsg").css("color", "#DA251C");
                return false;
            }
            if ($("#repassword").val() != $("#password").val()) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 两次输入密码不一致");
                ;
                $("span.errorMsg").css("color", "#DA251C");
                $("#repassword").focus();
                return false;
            }
            if (!$("input[name='mail']").val().match(/^([a-zA-Z0-9_-])+@([a-zA-Z0-9_-])+((\.[a-zA-Z0-9_-]{2,3}){1,2})$/)) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 邮箱格式不正确");
                $("span.errorMsg").css("color", "#DA251C");
                $("#mail").focus();
                return false;
            } else {
                $("span.errorMsg").removeClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html("");
            }
            return true;
        });
    });

</script>

<form method="post" action="foreregister" class="registForm">
    <div class="homeContent">
        <div class="homeContent-page">

            <%--图片logo--%>
            <div class="szpt_logo">
                <img src="img/fore/szpt_logo.jpg" width="50px" height="50px"/>
            </div>

            <%--表单区域--%>
            <table>
                <tr id="title">
                    <td>深职币注册</td>
                </tr>
                <tr>
                    <td>
                        用户名
                        <input type="text" name="username" class="form-control" id="username"/>
                        <span id="usernameMsg"></span>
                    </td>
                </tr>
                <tr>
                    <td>
                        密码
                        <input type="password" name="password" class="form-control" id="password"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        密码确认
                        <input type="password" name="repassword" class="form-control" id="repassword"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        学号
                        <input type="text" id="stuNum" name="stuNum" class="form-control" disabled="disabled"
                               placeholder="暂不开放"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        学号密码
                        <input type="password" id="stuPass" name="stuPass" class="form-control" disabled="disabled"
                               placeholder="暂不开放"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        邮箱
                        <input type="text" id="mail" name="mail" class="form-control"/>
                    </td>
                </tr>
                <tr>
                    <td>
                        <span class="errorMsg"></span>
                        <button type="submit" class="btn btn-block" style="background-color:#DA251C;color:white">确定
                        </button>
                    </td>
                </tr>
            </table>

        </div>
    </div>
</form>