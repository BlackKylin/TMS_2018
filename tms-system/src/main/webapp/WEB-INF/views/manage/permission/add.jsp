<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
    <title>TMS | 权限管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../../include/css.jsp"%>

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
</head>

<body class="hold-transition skin-blue sidebar-mini">
<div class="wrapper">

    <%--顶部--%>
    <%@include file="../../include/top.jsp"%>

    <!--  左侧边栏 -->
    <jsp:include page="../../include/left.jsp">
        <jsp:param name="active" value="roles"/>
    </jsp:include>

    <%--右边栏--%>
    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">

        <!-- Main content -->
        <section class="content container-fluid">

            <div class="col-md-7">
                <form method="post" id="saveFrom">
                    <legend>新增权限</legend>
                    <a href="/permission/add" class="btn btn-success  pull-right  fa fa-plus" >返回</a>

                    <div class="form-group">
                        <label>权限名称</label>
                        <input type="text" class="form-control" name="permissionName">
                    </div>
                    <div class="form-group">
                        <label>权限代号</label>
                        <input type="text" class="form-control" name="permissionCode">
                    </div>
                    <div class="form-group">
                        <label>地址URL</label>
                        <input type="text" class="form-control" name="url">
                    </div>
                    <div class="form-group">
                        <label>选择分类</label>
                        <select name="permissionType" class="form-control">
                            <option value="菜单">菜单</option>
                            <option value="按钮">按钮</option>
                        </select>
                    </div>
                    <div class="form-group">
                        <label>父权限</label>
                        <select name="parentId" class="form-control">
                            <option value="0">顶级菜单</option>
                            <c:forEach items="${permissionList}" var="permission">
                                <option value="${permission.id}">${permission.permissionName}</option>
                            </c:forEach>
                        </select>
                    </div>
                    <div class="form-group">
                        <button class="btn btn-primary pull-right" id="caveBtn">提交</button>
                    </div>
                </form>
            </div>

        </section>
    </div>
</div>

<%@include file="../../include/js.jsp"%>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveFrom").submit();
        });
    })
</script>


</body>
</html>