<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
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
                <h1>
                    账号管理
                </h1>
            </section>

            <!-- Main content -->
            <section class="content">
                <div class="box no-border">
                    <div class="box-body">
                        <form class="form-inline">
                            <input type="text" name="nameMobile" placeholder="账号 或 手机号码" class="form-control" value="${param.nameMobile}">
                            <select name="rolesId" class="form-control">
                                <option value="">所有角色</option>
                                <c:forEach items="${rolesList}" var="roles">
                                    <option value="${roles.id}" ${param.rolesId == roles.id ? 'selected' : ''}>${roles.rolesName}</option>
                                </c:forEach>
                            </select>
                            <button class="btn btn-default">搜索</button>
                        </form>
                    </div>
                </div>
                <div class="box">
                    <div class="box-header">
                        <div class="box-tools">
              <%--              <shiro:hasPermission name="account:add">--%>
                                <a href="/account/add" class="btn btn-success btn-sm">
                                    <i class="fa fa-plus"></i> 新增账号
                                </a>
                           <%-- </shiro:hasPermission>--%>
                        </div>
                    </div>
                    <div class="box-body">
                        <table class="table">
                            <thead>
                            <tr>
                                <th>账号</th>
                                <th>手机号码</th>
                                <th>角色</th>
                                <th>状态</th>
                                <th>创建时间</th>
                                <th>#</th>
                            </tr>
                            </thead>
                            <tbody>
                            <c:forEach items="${accountList}" var="account">
                                <tr>
                                    <td>${account.accountName}</td>
                                    <td>${account.accountNumber}</td>
                                    <td>
                                        <%--<c:forEach items="${account.rolesList}" var="roles">
                                            ${roles.rolesName}
                                        </c:forEach>--%>
                                    </td>
                                    <td>
                                            ${account.accountState}
                                    </td>
                                    <td>
                                        <fmt:formatDate value="${account.createTime}"/>
                                    </td>
                                    <td>
                                        <%--<shiro:hasPermission name="account:edit">--%>
                                            <a href="/account/${account.id}/update"><i class="fa fa-edit"></i></a>
                                        <%--</shiro:hasPermission>--%>
                                    </td>
                                </tr>
                            </c:forEach>
                            </tbody>
                        </table>
                    </div>
                </div>
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
</div>
<!-- ./wrapper -->
 <%@include file="../include/js.jsp"%>
</html>