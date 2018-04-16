
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<!--
This is a starter template page. Use this page to start your new project from
scratch. This page gets rid of all links and provides the needed markup only.
-->
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>TMS | 角色管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../include/css.jsp"%>

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%--顶部--%>
    <%@include file="../include/top.jsp"%>

    <!--  左侧边栏 -->
    <jsp:include page="../include/left.jsp">
        <jsp:param name="active" value="roles"/>
    </jsp:include>

    <%--右边栏--%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>账户管理</h1>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
            <div class="container">
                <h3>商品列表</h3>
                <c:if test="${not empty message}">
                    <div class="alert alert-success">${message}</div>
                </c:if>
                <a href="/product/add" class="btn btn-primary pull-right">添加商品</a>
                <table class="table">
                    <thead>
                    <tr>
                        <th>商品名称</th>
                        <th>价格</th>
                        <th>市场价</th>
                        <th>产地</th>
                        <th>所属分类</th>
                        <th>#</th>
                    </tr>
                    </thead>
                    <tbody>
                    <c:forEach items="${pageInfo.list}" var="product">
                        <tr>
                            <td><a href="/product/${product.id}">${product.productName}</a></td>
                            <td>${product.price}</td>
                            <td>${product.marketPrice}</td>
                            <td>${product.place}</td>
                            <td>${product.productType.typeName}</td>
                            <td>
                                <a href="/product/${product.id}/update">编辑</a>
                                <a href="javascript:;" class="delLink" rel="${product.id}">删除</a>
                            </td>
                        </tr>
                    </c:forEach>
                    </tbody>
                </table>
                <ul id="pagination-demo" class="pagination pull-right"></ul>
            </div>

        </section>
    </div>


</div>
<!-- ./wrapper -->
 <%@include file="../include/js.jsp"%>
</html>