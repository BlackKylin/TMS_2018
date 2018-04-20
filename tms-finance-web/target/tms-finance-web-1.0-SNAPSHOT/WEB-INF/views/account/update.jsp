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
    <title>TMS | 编辑账户</title>
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
                <div class="box">
                    <div class="box-header">
                        <h3 class="box-title">编辑账号</h3>
                    </div>
                    <div class="box-body">
                        <form method="post" class="saveForm">
                            <input type="hidden" name="id" value="${account.id}">
                            <div class="form-group">
                                <label>账号</label>
                                <input type="text" class="form-control" name="accountName" value="${account.accountName}">
                            </div>
                            <div class="form-group">
                                <label>手机号码(用于登录)</label>
                                <input type="text" class="form-control" name="accountMobile" value="${account.accountMobile}">
                            </div>
                            <div class="form-group">
                                <label>角色</label>
                                <div>
                                    <c:forEach items="${rolesList}" var="roles">
                                        <c:set var="flag" value="false"/>
                                        <c:forEach items="${accountRolesList}" var="accountRoles">
                                            <c:choose>
                                                <c:when test="${roles.id == accountRoles.id}">
                                                    <c:set var="flag" value="true"/>
                                                </c:when>
                                            </c:choose>
                                        </c:forEach>
                                        <div class="checkbox-inline">
                                            <input type="checkbox" ${flag ? 'checked' : ''} value="${roles.id}" name="rolesIds"> ${roles.rolesName}
                                        </div>
                                    </c:forEach>
                                </div>
                            </div>
                        </form>
                    </div>
                    <div class="box-footer">
                        <button class="btn btn-primary pull-right" id="saveBtn">保存</button>
                    </div>
                </div>
            </section>
            <!-- /.content -->
        </div>
        <!-- /.content-wrapper -->
</div>
<%@include file="../include/js.jsp"%>
<script>
    $(function () {
        $("#saveBtn").click(function () {
            $("#saveFrom").submit();
        });
    })
</script>


</body>
</html>