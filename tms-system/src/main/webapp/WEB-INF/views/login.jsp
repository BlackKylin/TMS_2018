<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>

<!DOCTYPE html>
<html lang="en" class="no-js">

<head>

    <meta charset="utf-8">
    <title>Fullscreen Login</title>
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta name="description" content="">
    <meta name="author" content="">

    <!-- CSS -->
    <link rel="stylesheet" href="/static/index/css/reset.css">
    <link rel="stylesheet" href="/static/index/css/supersized.css">
    <link rel="stylesheet" href="/static/index/css/style.css">

    <!--[if lt IE 9]>
    <script></script>
    <![endif]-->

</head>

<body style="background:url('/static/index/img/12.jpg')">
      <div class="page-container">
            <h1 align="center"
                style="color:black ; font-size:50px">TMS</h1><h3 align="center" style="color:black ; font-size:30px">年票管理系统</h3>
            <c:if test="${not empty message}">
                <p class="login-box-msg text-danger">${message}</p>
            </c:if>
            <form action="" method="post">
                <input type="text" name="accountNumber" class="accountNumber">
                <input type="password" name="accountPassword" class="accountPassword">
                <button type="submit">登录</button>
            </form>
      </div>
</body>

</html>

