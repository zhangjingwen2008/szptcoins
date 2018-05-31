<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018-5-8
  Time: 10:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<script src="js/jquery/2.0.0/jquery.min.js"></script>
<link href="css/bootstrap/3.3.6/bootstrap.min.css" rel="stylesheet">
<script src="js/bootstrap/3.3.6/bootstrap.min.js"></script>

<h1>This is Test Page</h1>

<div class="btn-group">
    <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown">
        default
        <span class="caret"></span>
    </button>

    <ul class="dropdown-menu" role="menu">
        <li>
            <a href="#">WIF</a>
        </li>
        <li>
            <a href="#">WIF-Compressed</a>
        </li>
        <li>
            <a href="#">Base58</a>
        </li>
        <li>
            <a href="#">原始私钥</a>
        </li>
    </ul>
</div>