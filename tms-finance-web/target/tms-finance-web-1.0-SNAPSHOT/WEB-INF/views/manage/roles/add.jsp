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
    <title>TMS | 角色管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">

    <link rel="stylesheet" href="/static/plugins/iCheck/square/blue.css">
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
            <h1>
                增加角色
            </h1>
        </section>

        <!-- Main content -->
        <section class="content container-fluid">

            <div class="col-md-7">
                <form method="post" id="saveFrom">
                    <legend>新增角色 <a href="/manage/roles/" class="btn btn-success  pull-right btn-group-sm" >返回</a></legend>

                    <div class="form-group">
                        <label>角色名称</label>
                        <input type="text" class="form-control" name="rolesName">
                    </div>
                    <div class="form-group">
                        <label>角色代号</label>
                        <input type="text" class="form-control" name="rolesCode">
                    </div>

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>权限名称</th>
                            <th>权限代号</th>
                            <th>权限类型</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${permissionList}" var="permission">
                            <c:choose>
                                <c:when test="${permission.parentId == 0}">
                                    <tr class="treegrid-${permission.id} treegrid-expanded">
                                        <th>
                                            <input type="checkbox" name="permissionId" value="${permission.id}">
                                        </th>
                                        <td>${permission.permissionName}</td>
                                        <th>${permission.permissionCode}</th>
                                        <td>${permission.permissionType}</td>
                                    </tr>
                                </c:when>
                                <c:otherwise>
                                    <tr class="treegrid-${permission.id} treegrid-expanded treegrid-parent-${permission.parentId}">
                                        <th>
                                            <input type="checkbox" name="permissionId" value="${permission.id}">
                                        </th>
                                        <td>${permission.permissionName}</td>
                                        <th>${permission.permissionCode}</th>
                                        <td>${permission.permissionType}</td>
                                    </tr>
                                </c:otherwise>
                            </c:choose>
                        </c:forEach>
                        </tbody>
                    </table>


                    <div class="form-group">
                        <button class="btn btn-primary pull-right" id="caveBtn">提交</button>
                    </div>
                </form>
            </div>

        </section>
        <!-- /.content -->
    </div>

</div>
<!-- ./wrapper -->
    <%@include file="../../include/js.jsp"%>
<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>
<script src="/static/plugins/iCheck/icheck.min.js"></script>

<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveFrom").submit();
        });
    });
    $(function () {
        $('.tree').treegrid();
    });
    $('input[type=checkbox]').iCheck({
        checkboxClass: 'icheckbox_square-blue',
        radioClass: 'iradio_square-blue',
        increaseArea: '20%' /* optional */
    });
</script>

</body>
</html>