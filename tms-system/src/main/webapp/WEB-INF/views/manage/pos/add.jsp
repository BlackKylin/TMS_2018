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
    <title>TMS | 库存管理</title>
    <!-- Tell the browser to be responsive to screen width -->
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <%@include file="../../include/css.jsp"%>

    <!-- Google Font -->
    <link rel="stylesheet"
          href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,600,700,300italic,400italic,600italic">
    <style>
        .photo {
            width: 100%;
            height: 300px;
            border: 2px dashed #ccc;
            margin-top: 20px;
            text-align: center;
            line-height: 300px;
        }
    </style>
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
    <div class="content-wrapper">
        <section class="content container-fluid">
            <div class="col-md-7">
                <form method="post" id="saveFrom">
                    <legend>新增销售点</legend>
                    <a href="/manage/pos/home" class="btn btn-success  pull-right  fa fa-plus" >返回</a>

                    <div class="form-group">
                        <label>销售点名称</label>
                        <input type="text" class="form-control" name="posName">
                    </div>
                    <div class="form-group">
                        <label>销售点地址</label>
                        <input type="text" class="form-control" name="posSite">
                    </div>
                    <div class="form-group">
                        <label>经营者</label>
                        <input type="text" class="form-control" name="ownerName">
                    </div>
                    <div class="form-group">
                        <label>联系方式</label>
                        <input type="text" class="form-control" name="posNumber">
                    </div>
                    <div class="row">
                        <div class="col-md-6">
                            <div id="picker">请上传经营者身份证照片</div>
                            <div class="photo" id="userPhoto"></div>
                        </div>
                        <div class="col-md-6">
                            <div id="picker2">请上传营业执照照片</div>
                            <div class="photo" id="storePhoto"></div>
                        </div>
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