<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!--  左侧边栏 -->
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">

    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">

        <!-- Sidebar user panel (optional) -->
        <div class="user-panel">
            <div class="pull-left image">
                <img src="/static/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>Alexander Pierce</p>
                <!-- Status -->
                <a href="#"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>

        <!-- Sidebar Menu -->
        <!-- 菜单 -->
        <ul class="sidebar-menu">
            <li class="${param.active == "home" ? 'active':''}"><a href="/home"><i class="fa fa-home"></i> <span>首页</span></a></li>
            <!-- 权限管理 -->
            <li class="${param.active == "permission" ? 'active':''}">

                <a href="/manage/permission/">
                    <i class="fa fa-circle-o"></i> <span>权限管理</span>
                    <span class="pull-right-container">
                    <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
            </li>
            <!-- 角色管理 -->
            <li class="treeview ${param.active == "role" ? 'active':''}">
                <a href="/manage/roles/">
                    <i class="fa fa-circle-o"></i> <span>角色管理</span>
                    <span class="pull-right-container">
                        <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
            </li>
            <!-- 账户管理 -->
            <li class="treeview  ${param.active == "account" ? 'active':''}">
                <a href="/account/home/">
                    <i class="fa fa-circle-o"></i> <span>账户管理</span>
                    <span class="pull-right-container">
                      <i class="fa fa-angle-left pull-right"></i>
                    </span>
                </a>
            </li>

        </ul>
        <!-- /.sidebar-menu -->
    </section>
    <!-- /.sidebar -->
</aside>