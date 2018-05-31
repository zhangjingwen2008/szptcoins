<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-4-17
  Time: 15:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<style>
    body {
        background-color: #F9F9F9;
    }

    div.personal-Page {
        position: absolute;
        top: 20%;
        width: 99%;
        height: 700px;
    }

    /*CSS状态栏*/
    div.personal-Page .status-bar {
        width: 1000px;
        height: 50px;
        margin: 0px auto;
        /*border:1px dashed black;*/
    }

    div.personal-Page .status-bar div {
        width: 100px;
        margin-left: 50px;
        height: 50px;
        float: left;
        text-align: center;
        font-weight: bold;
        line-height: 40px;
        /*position:relative;*/
    }

    div.personal-Page .status-bar #personalTab:hover, #walletTab:hover {
        color: #DA251C;
        cursor: pointer;
    }

    div.personal-Page .status-bar #imgTab {
        width: 100px;
        height: 100px;
        border: 1px solid #e6e6e6;
        float: right;
        position: relative;
        top: -10px;
        right: 60px;
        border-radius: 50%;
        background-color: white;
    }

    div.personal-Page .status-bar #imgTab div {
        width: 90%;
        height: 90%;
        margin: 5px;
        border-radius: 50%;
        background-size: 100%;
        background-image: url("img/fore/szpt_logo.jpg");
    }

    /*CSS个人信息*/
    div.personal-Page .personal-Content {
        width: 1000px;
        height: 500px;
        margin: 0px auto;
        background-color: white;
        border: 1px solid #e6e6e6;
        border-radius: 20px;
    }

    div.personal-Page .personal-Content .base-information {
        width: 500px;
        height: 500px;
        margin: 0px auto;
        padding-top: 50px;
        position: relative;
        left: 80px;
        top: 10px;
    }

    div.personal-Page .personal-Content .base-information .edit {
        float: right;
        position: relative;
        bottom: 1px;
        font-size: 14px;
    }

    div.personal-Page .personal-Content .base-information tbody {
        font-size: 14px;
        color: gray;
    }

    div.personal-Page .personal-Content .base-information tbody tr {
        height: 40px;
    }

    h3 {
        float: left;
    }

    div.personal-Page .personal-Content .personanl-image {
        width: 100px;
        height: 150px;
        /*border:1px dashed black;*/
        float: left;
        position: relative;
        left: 130px;
        top: 170px;
    }

    div.personal-Page .personal-Content .personanl-image #img {
        display: block;
        width: 100px;
        height: 100px;
        border: 1px solid #e6e6e6;
        border-radius: 5px;
    }

    div.personal-Page .personal-Content .personanl-image #img div {
        width: 90%;
        height: 90%;
        margin: 5px;
        border-radius: 5px;
        border: 1px dashed #e6e6e6;
        background-size: 100%;
        background-image: url("img/fore/no_pic.jpg");

    }

    div.personal-Page .personal-Content .personanl-image #set {
        display: block;
        height: 50px;
        line-height: 50px;
        text-align: center;
        /*border:1px solid black;*/
    }

    /*CSS校币钱包*/
    div.personal-Page .wallet {
        width: 1000px;
        height: 600px;
        margin: 0px auto;
        background-color: white;
        border: 1px solid #e6e6e6;
        border-radius: 20px;
        display: none;
        padding: 50px;
    }
    div.personal-Page .wallet table td {
        line-height: 50px;
    }

    div.personal-Page .wallet table h3 {
        font-weight: bold;
    }

    div.personal-Page .wallet table span {
        color: #DA251C;
        margin-right: 25px;
    }

    div.personal-Page .wallet table #address{
        color:#5BADE4;
    }
    div.personal-Page .wallet table #hash160{
        color:#5BADE4;
    }
    div.personal-Page .wallet table .keySelect{
        display: inline-block;
        width:160px;
        align-content: center;
    }
    div.personal-Page .wallet table .keySelect select option{
        align-content: center;
    }
    div.personal-Page .wallet table .privateKey{
        color:#808080;
        /*border:1px solid black;*/
        width:530px;
        height:30px;
        display: inline-block;
    }
    div.personal-Page .wallet table .publicKey{
        color:#808080;
    }
    div.personal-Page .wallet table .public{
        /*border:1px solid black;*/
        display: inline-block;
        overflow: hidden;
        width:900px;
        table-layout:fixed;
        word-break:break-all;
    }

        /*CSS个人信息编辑模态窗口*/

    div#editModalPersonal span.errorMsg {
        height: 20px;
        line-height: 33px;
        /*border:1px solid black;*/
    }

</style>

<script>

    /*私钥显示方式*/
    function keyForm(){
        var form=document.getElementById("keySe").value;
        document.getElementById("privateKey").innerHTML="";
        if(form=="WIF"){
            document.getElementById("privateKey").innerHTML="${wallet.wif}";
        }else if(form=="WIF-Compressed"){
            document.getElementById("privateKey").innerHTML="${wallet.wifCompressed}";
        }else if(form=="Base58"){
            document.getElementById("privateKey").innerHTML="${wallet.base58}";
        }else{
            document.getElementById("privateKey").innerHTML="${wallet.privateKey}";
        }
    }

    $(function () {

        $("#personalTab").click(function () {
            $(".personal-Content").show();
            $(".wallet").hide();
            $("#walletTab").css("color", "");
            $(this).css("color", "#DA251C");
        });
        $("#walletTab").click(function () {
            $(".wallet").show();
            $(".personal-Content").hide();
            $("#personalTab").css("color", "");
            $(this).css("color", "#DA251C");
        });

        /*个人信息编辑验证*/
        $(".forePersonalInfoEdit").submit(function () {
            if (!$("input[name='name']").val().match(/^[\u4e00-\u9fe5a-zA-Z0-9]{2,8}$/)) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 【昵称】只允许中文字符、字母、数字，且为2-8位");
                $("span.errorMsg").css("color", "#DA251C");
                return false;
            } else {
                $("span.errorMsg").removeClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html("");
            }
            if (!$("input[name='phone']").val().match(/^(13[0-9]|14[5|7]|15[0|1|2|3|5|6|7|8|9]|18[0|1|2|3|5|6|7|8|9])\d{8}$/)) {
                $("span.errorMsg").addClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" 【电话】格式不正确");
                $("span.errorMsg").css("color", "#DA251C");
                return false;
            } else {
                $("span.errorMsg").removeClass("glyphicon glyphicon-warning-sign");
                $("span.errorMsg").html(" ");
            }
            return true;
        });

    });
</script>

<div class="personal-Page">

    <%--状态栏--%>
    <div class="status-bar">
        <div id="personalTab">个人信息</div>
        <div id="walletTab">校币钱包</div>
        <div id="imgTab">
            <div></div>
        </div>
    </div>

    <%--个人信息--%>
    <div class="personal-Content">

        <%--上传图片--%>
        <div class="personanl-image">
            <a id="img">
                <c:if test="${!empty personalInfo.img}">
                    <div style="background-image:url(${personalInfo.img});
                            background-repeat: no-repeat;
                            background-size:100% 100%;
                            border:1px solid white">

                            <%--<img width="100%" height="100%" src="${personalInfo.img}"/>--%>
                    </div>
                </c:if>
                <c:if test="${empty personalInfo.img}">
                    <div></div>
                </c:if>
            </a>
            <a id="set" data-toggle="modal" data-target="#imgModal">设置头像</a>
        </div>

        <div class="base-information">

            <%--个人基础信息--%>
            <table class="table table-hover">
                <thead>
                <tr>
                    <td>
                        <h3>基础信息</h3>
                        <a href="#nowhere" data-toggle="modal" data-target="#editModalPersonal" class="edit"><span
                                class="glyphicon glyphicon-wrench"></span> 编辑</a>
                    </td>
                </tr>
                </thead>
                <c:if test="${!empty personalInfo}">
                    <tbody>
                    <tr>
                        <td>昵称：${personalInfo.name}</td>
                    </tr>
                    <tr>
                        <td>电话：${personalInfo.phone}</td>
                    </tr>
                    <tr>
                        <td>邮箱：${personalInfo.mail}</td>
                    </tr>
                    <tr>
                        <td>学号：${personalInfo.stuNum}</td>
                    </tr>
                    <tr>
                        <td>年级：${degree}</td>
                    </tr>
                    <tr>
                        <td>学院：${academy}</td>
                    </tr>
                    <tr>
                        <td>专业：${major}</td>
                    </tr>
                    </tbody>
                </c:if>
            </table>
        </div>
    </div>

    <%--钱包--%>
    <div class="wallet">
        <table class="table table-hover">
            <thead>
            <tr>
                <td>
                    <h3>个人钱包</h3>
                </td>
            </tr>
            </thead>
            <tbody>
            <tr>
                <td><span class="glyphicon glyphicon-bitcoin"></span>深职币：${estate.coins}</td>
            </tr>
            <tr>
                <td><span class="glyphicon glyphicon-pencil"></span>学力：${estate.power}</td>
            </tr>
            <tr>
                <td><span class="glyphicon glyphicon-user"></span>地址：<span id="address">${wallet.address}</span></td>
            </tr>
            <tr>
                <td><span class="glyphicon glyphicon-eye-open"></span>Hash 160：<span id="hash160">${wallet.hash160}</span></td>
            </tr>
            <tr>
                <td>
                    <span class="glyphicon glyphicon-eye-close"></span>
                    私钥：
                    <span class="privateKey" id="privateKey">${wallet.wif}</span>

                    <div class="keySelect">
                        <select class="form-control" id="keySe" onchange="keyForm()">
                            <option>WIF</option>
                            <option>WIF-Compressed</option>
                            <option>Base58</option>
                            <option>原始私钥</option>
                        </select>
                    </div>

                </td>
            </tr>
            <tr>
                <td class="public"><span class="glyphicon glyphicon-eye-close" ></span>原始公钥：<span class="publicKey">${wallet.publicKey}</span></td>
            </tr>
            </tbody>
        </table>
    </div>

    <%--模态编辑窗口--%>
    <form action="forePersonalInfoEdit" method="post" class="forePersonalInfoEdit">
        <input type="hidden" name="username" value="${user.username}"/>
        <div class="modal fade" id="editModalPersonal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">
                            <span aria-hidden="true">×</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4>编辑基础资料</h4>
                    </div>

                    <div class="modal-body">
                        <p>昵称：</p>
                        <input type="text" name="name" class="form-control" value="${personalInfo.name}"/>
                        <p>电话：</p>
                        <input type="text" name="phone" class="form-control" value="${personalInfo.phone}"/>
                        <span class="errorMsg"></span>
                    </div>

                    <div class="modal-footer">
                        <button type="submit" class="btn btn-lg btn-block btn-danger">提交</button>
                    </div>

                </div>
            </div>
        </div>
    </form>

    <%--模态上传图片窗口--%>
    <form action="forePersonalImageEdit" method="post" enctype="multipart/form-data">
        <input type="hidden" name="id" value="${user.id}"/>
        <input type="hidden" name="username" value="${user.username}"/>
        <div class="modal fade" id="imgModal" tabindex="-1" role="dialog" aria-labelledby="myModalLabel">
            <div class="modal-dialog">
                <div class="modal-content">

                    <div class="modal-header">
                        <button data-dismiss="modal" class="close" type="button">
                            <span aria-hidden="true">×</span>
                            <span class="sr-only">Close</span>
                        </button>
                        <h4>设置头像</h4>
                    </div>

                    <div class="modal-body">
                        <input type="file" name="image" accept="image/*" class="file"/>
                        <button type="submit">提交</button>
                    </div>

                </div>
            </div>
        </div>
    </form>


</div>


