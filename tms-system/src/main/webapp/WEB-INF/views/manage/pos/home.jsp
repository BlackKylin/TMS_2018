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
    <title>TMS | 综合管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../../include/css.jsp"%>
    <link rel="stylesheet" href="/static/plugins/treegrid/css/jquery.treegrid.css">
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
        <jsp:param name="active" value="pos"/>
    </jsp:include>

    <%--右边栏--%>
    <div class="content-wrapper">
        <section class="content-header">
            <h1>销售点管理</h1>
        </section>
        <!-- Main content -->
        <section class="content">

            <div class="box">
                <div class="box-header">

                    <h3 class="box-title">销售点列表</h3>
                    <c:if test="${not empty message}">
                        <p class="login-box-msg text-danger">${message}</p>
                    </c:if>
                    <%--<shiro:hasPermission name="system:addpos">--%>
                        <a href="/manage/pos/add" class="btn btn-success pull-right fa fa-plus" >添加销售点</a>
                   <%-- </shiro:hasPermission>--%>
                </div>
                <div class="box-body">

                    <table class="table tree">
                        <thead>
                        <tr>
                            <th>销售点名称</th>
                            <th>销售点地址</th>
                            <th>经营者姓名</th>
                            <th>联系电话</th>
                            <th>#</th>
                        </tr>
                        </thead>
                        <tbody>
                        <c:forEach items="${posList}" var="pos">

                             <tr>
                                 <td>${pos.posName}</td>
                                 <th>${pos.posSite}</th>
                                 <th>${pos.ownerName}</th>
                                 <th>${pos.posNumber}</th>
                                 <th>
                                     <shiro:hasPermission name="pos:update">
                                        <a href="/manage/pos/${pos.id}/update">修改</a>
                                     </shiro:hasPermission>
                                     <shiro:hasPermission name="pos:delete">
                                        <a href="/manage/pos/${pos.id}/delete">删除</a>
                                     </shiro:hasPermission>
                                 </th>
                             </tr>
                        </c:forEach>
                        </tbody>
                    </table>
                </div>
            </div>
        </section>
    </div>
</div>
<!-- ./wrapper -->

<%@include file="../../include/js.jsp"%>

<script src="/static/plugins/treegrid/js/jquery.treegrid.min.js"></script>
<script src="/static/plugins/treegrid/js/jquery.treegrid.bootstrap3.js"></script>

<script>
    $(function () {
        $('.tree').treegrid();
    });

</script>
</body>

</html>