
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
        <!-- Content Header (Page header) -->
        <section class="content-header">
            <h1>角色管理</h1>
        </section>
        <!-- Main content -->
        <section class="content container-fluid">
            <div class="box">
                <div class="box-header">
                    <h3 class="box-title">角色列表</h3>
                    <a href="/manage/roles/add" class="btn btn-success pull-right btn-group-sm" >添加角色</a>
                </div>
                <div class="box-body">
                    <table class="table tree">
                        <thead>
                            <tr class="bg-blue-gradient">
                               <td><strong>角色名称：</strong>超级管理员</td>
                            </tr>
                            <tr>
                                <td><strong>权限：</strong>权限增加、权限删除、权限修改</td>

                            </tr>
                            <tr class="bg-blue-gradient">
                                <td><strong>角色名称：</strong>管理员</td>
                            </tr>
                            <tr>
                                <td><strong>权限：</strong>权限增加</td>
                            </tr>
                        </thead>
                        <tbody>

                        </tbody>
                    </table>
                </div>
            </div>

        </section>
    </div>

</div>
<!-- ./wrapper -->
 <%@include file="../../include/js.jsp"%>
</html>