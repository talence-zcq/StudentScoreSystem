<%--
  Created by IntelliJ IDEA.
  User: 95243
  Date: 2021/7/17
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <% String path=request.getContextPath(); %>
    <meta charset="utf-8" />
    <title>学生成绩管理系统</title>
    <!-- basic styles -->

    <link href="<%=path%>/assets/css/bootstrap.min.css" rel="stylesheet" />
    <link rel="stylesheet" href="<%=path%>/assets/css/font-awesome.min.css" />

    <!--[if IE 7]>
    <link rel="stylesheet" href="<%=path%>/assets/css/font-awesome-ie7.min.css" />
    <![endif]-->

    <!-- page specific plugin styles -->

    <!-- fonts -->

    <link rel="stylesheet" href="http://fonts.useso.com/css?family=Open+Sans:400,300" />

    <!-- ace styles -->

    <link rel="stylesheet" href="<%=path%>/assets/css/ace.min.css" />
    <link rel="stylesheet" href="<%=path%>/assets/css/ace-rtl.min.css" />
    <link rel="stylesheet" href="<%=path%>/assets/css/ace-skins.min.css" />

    <!--[if lte IE 8]>
    <link rel="stylesheet" href="<%=path%>/assets/css/ace-ie.min.css" />
    <![endif]-->

    <!-- inline styles related to this page -->

    <!-- ace settings handler -->

    <script src="<%=path%>/assets/js/ace-extra.min.js"></script>

    <!-- HTML5 shim and Respond.js IE8 support of HTML5 elements and media queries -->

    <!--[if lt IE 9]>
    <script src="<%=path%>/assets/js/html5shiv.js"></script>
    <script src="<%=path%>/assets/js/respond.min.js"></script>
    <![endif]-->
</head>

<body>
<div class="navbar navbar-default" id="navbar">
    <script type="text/javascript">
        try{ace.settings.check('navbar' , 'fixed')}catch(e){}
    </script>

    <div class="navbar-container" id="navbar-container">
        <div class="navbar-header pull-left">
            <a href="#" class="navbar-brand">
                <small>
                    <i class="icon-leaf"></i>
                    学生成绩管理系统
                </small>
            </a><!-- /.brand -->
        </div><!-- /.navbar-header -->

        <div class="navbar-header pull-right" role="navigation">
            <ul class="nav ace-nav">
                <li class="light-blue">
                    <a data-toggle="dropdown" href="#" class="dropdown-toggle">
                        <img class="nav-user-photo" src="<%=path%>/assets/avatars/user.jpg" alt="Jason's Photo" />
                        <span class="user-info">
									<small>欢迎你,</small>
									${kind}
								</span>

                        <i class="icon-caret-down"></i>
                    </a>

                    <ul class="user-menu pull-right dropdown-menu dropdown-yellow dropdown-caret dropdown-close">
                        <li>
                            <a href="#">
                                <i class="icon-cog"></i>
                                个人信息
                            </a>
                        </li>

                        <li>
                            <a href="#">
                                <i class="icon-user"></i>
                                头像上传
                            </a>
                        </li>

                        <li class="divider"></li>

                        <li>
                            <a href="#">
                                <i class="icon-off"></i>
                                注销
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.ace-nav -->
        </div><!-- /.navbar-header -->
    </div><!-- /.container -->
</div>

<div class="main-container" id="main-container">
    <script type="text/javascript">
        try{ace.settings.check('main-container' , 'fixed')}catch(e){}
    </script>

    <div class="main-container-inner">
        <a class="menu-toggler" id="menu-toggler" href="#">
            <span class="menu-text"></span>
        </a>

        <div class="sidebar" id="sidebar">
            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'fixed')}catch(e){}
            </script>
            <ul class="nav nav-list">
                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-edit"></i>
                        <span class="menu-text"> 管理员模块 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                学生管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                教师管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                课程管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                班级开课管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                学生成绩管理(仅查看)
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                学院信息管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                专业信息管理
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                班级信息管理
                            </a>
                        </li>
                    </ul>
                </li>

                <li>
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-list"></i>
                        <span class="menu-text"> 教师模块 </span>

                        <b class="arrow icon-angle-down"></b>
                    </a>

                    <ul class="submenu">
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                成绩录入
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                成绩查询
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                任课查询
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/wrong.jsp">
                                <i class="icon-double-angle-right"></i>
                                修改密码
                            </a>
                        </li>
                    </ul>
                </li>

                <li class="active open">
                    <a href="#" class="dropdown-toggle">
                        <i class="icon-file-alt"></i>
                        <span class="menu-text">
                            学生模块
                        </span>
                        <b class="arrow icon-angle-down"></b>
                    </a>
                    <ul class="submenu">
                        <li>
                            <a href="<%=path%>/VIEW/student.jsp">
                                <i class="icon-double-angle-right"></i>
                                成绩查询
                            </a>
                        </li>
                        <li class="active">
                            <a href="<%=path%>/VIEW/student1.jsp">
                                <i class="icon-double-angle-right"></i>
                                课程查询
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/student2.jsp">
                                <i class="icon-double-angle-right"></i>
                                教学计划查询
                            </a>
                        </li>
                        <li>
                            <a href="<%=path%>/VIEW/student3.jsp">
                                <i class="icon-double-angle-right"></i>
                                修改密码
                            </a>
                        </li>
                    </ul>
                </li>
            </ul><!-- /.nav-list -->

            <div class="sidebar-collapse" id="sidebar-collapse">
                <i class="icon-double-angle-left" data-icon1="icon-double-angle-left" data-icon2="icon-double-angle-right"></i>
            </div>

            <script type="text/javascript">
                try{ace.settings.check('sidebar' , 'collapsed')}catch(e){}
            </script>
        </div>

        <div class="main-content">
            <div class="breadcrumbs" id="breadcrumbs">
                <script type="text/javascript">
                    try{ace.settings.check('breadcrumbs' , 'fixed')}catch(e){}
                </script>

                <ul class="breadcrumb">
                    <li>
                        <i class="icon-home home-icon"></i>
                        <a href="#">首页</a>
                    </li>
                    <li>
                        <a href="#">学生模块</a>
                    </li>
                    <li class="active">课程查询</li>
                </ul><!-- .breadcrumb -->

                <div class="nav-search" id="nav-search">
                    <form class="form-search">
								<span class="input-icon">
									<input type="text" placeholder="Search ..." class="nav-search-input" id="nav-search-input" autocomplete="off" />
									<i class="icon-search nav-search-icon"></i>
								</span>
                    </form>
                </div><!-- #nav-search -->
            </div>

            <div class="page-content">
                <div class="row">
                    <div class="col-xs-12">
                        <!-- PAGE CONTENT BEGINS -->
                        <!--表格元素-->
                        <div class="row">
                            <div class="col-xs-12">
                                <h3 class="header smaller lighter blue">课程查询</h3>
                                <form method="POST" class="my-login-validation" novalidate=""
                                      action="/final_database_war_exploded/queryWorkServlet">
                                    <div class="form-group col-xs-12 col-sm-12">
                                        <label>学期：</label>
                                        <input type="text" class="form-control" name="Cterm">
                                    </div>
                                    <div style="text-align: center">
                                        <button class="btn btn-info" type="submit">
                                            查询
                                        </button>
                                    </div>
                                </form>
                                <br>
                                <div class="table-header">
                                    课程列表
                                </div>

                                <div class="table-responsive">
                                    <table id="sample-table-2" class="table table-striped table-bordered table-hover">
                                        <thead>
                                        <tr>
                                            <th>上课学期</th>
                                            <th>课程名称</th>
                                            <th>课程学分</th>
                                            <th>任课教师</th>
                                            <th>考核方式</th>
                                        </tr>
                                        </thead>
                                        <tbody>
                                        <c:forEach var="wor" items="${worlist}">
                                            <tr>
                                                <td><c:out value="${wor.cterm}"/></td>
                                                <td><c:out value="${wor.coursename}"/></td>
                                                <td><c:out value="${wor.credit}"/></td>
                                                <td><c:out value="${wor.tname}"/></td>
                                                <td><c:out value="${wor.assessment}"/></td>
                                            </tr>
                                        </c:forEach>
                                        </tbody>
                                    </table>
                                </div>
                            </div>
                        </div>
                        <!-- PAGE CONTENT ENDS -->
                    </div><!-- /.col -->
                </div><!-- /.row -->
            </div><!-- /.page-content -->
        </div><!-- /.main-content -->

        <div class="ace-settings-container" id="ace-settings-container">
            <div class="btn btn-app btn-xs btn-warning ace-settings-btn" id="ace-settings-btn">
                <i class="icon-cog bigger-150"></i>
            </div>

            <div class="ace-settings-box" id="ace-settings-box">
                <div>
                    <div class="pull-left">
                        <select id="skin-colorpicker" class="hide">
                            <option data-skin="default" value="#438EB9">#438EB9</option>
                            <option data-skin="skin-1" value="#222A2D">#222A2D</option>
                            <option data-skin="skin-2" value="#C6487E">#C6487E</option>
                            <option data-skin="skin-3" value="#D0D0D0">#D0D0D0</option>
                        </select>
                    </div>
                    <span>&nbsp; Choose Skin</span>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-navbar" />
                    <label class="lbl" for="ace-settings-navbar"> Fixed Navbar</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-sidebar" />
                    <label class="lbl" for="ace-settings-sidebar"> Fixed Sidebar</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-breadcrumbs" />
                    <label class="lbl" for="ace-settings-breadcrumbs"> Fixed Breadcrumbs</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-rtl" />
                    <label class="lbl" for="ace-settings-rtl"> Right To Left (rtl)</label>
                </div>

                <div>
                    <input type="checkbox" class="ace ace-checkbox-2" id="ace-settings-add-container" />
                    <label class="lbl" for="ace-settings-add-container">
                        Inside
                        <b>.container</b>
                    </label>
                </div>
            </div>
        </div><!-- /#ace-settings-container -->
    </div><!-- /.main-container-inner -->

    <a href="#" id="btn-scroll-up" class="btn-scroll-up btn btn-sm btn-inverse">
        <i class="icon-double-angle-up icon-only bigger-110"></i>
    </a>
</div><!-- /.main-container -->

<!-- basic scripts -->

<!--[if !IE]> -->

<script src="http://ajax.useso.com/ajax/libs/jquery/2.0.3/jquery.min.js"></script>

<!-- <![endif]-->

<!--[if IE]>
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.10.2/jquery.min.js"></script>
<![endif]-->

<!--[if !IE]> -->

<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=path%>/assets/js/jquery-2.0.3.min.js'>"+"<"+"/script>");
</script>

<!-- <![endif]-->

<!--[if IE]>
<script type="text/javascript">
    window.jQuery || document.write("<script src='<%=path%>/assets/js/jquery-1.10.2.min.js'>"+"<"+"/script>");
</script>
<![endif]-->

<script type="text/javascript">
    if("ontouchend" in document) document.write("<script src='<%=path%>/assets/js/jquery.mobile.custom.min.js'>"+"<"+"/script>");
</script>
<script src="<%=path%>/assets/js/bootstrap.min.js"></script>
<script src="<%=path%>/assets/js/typeahead-bs2.min.js"></script>

<!-- page specific plugin scripts -->
<script src="<%=path%>/assets/js/jquery.dataTables.min.js"></script>
<script src="<%=path%>/assets/js/jquery.dataTables.bootstrap.js"></script>
<!-- ace scripts -->

<script src="<%=path%>/assets/js/ace-elements.min.js"></script>
<script src="<%=path%>/assets/js/ace.min.js"></script>

<!-- inline scripts related to this page -->
<script type="text/javascript">
    jQuery(function($) {
            var oTable1 = $('#sample-table-2').dataTable( {
                "aoColumns": [
                    null, null,null, null,null
                ] } );


            $('table th input:checkbox').on('click' , function(){
                var that = this;
                $(this).closest('table').find('tr > td:first-child input:checkbox')
                    .each(function(){
                        this.checked = that.checked;
                        $(this).closest('tr').toggleClass('selected');
                    });

            });


            $('[data-rel="tooltip"]').tooltip({placement: tooltip_placement});
            function tooltip_placement(context, source) {
                var $source = $(source);
                var $parent = $source.closest('table')
                var off1 = $parent.offset();
                var w1 = $parent.width();

                var off2 = $source.offset();
                var w2 = $source.width();

                if( parseInt(off2.left) < parseInt(off1.left) + parseInt(w1 / 2) ) return 'right';
                return 'left';
            }
        }
    )
</script>
<!-- inline scripts related to this page -->
<div style="display:none"><script src='http://v7.cnzz.com/stat.php?id=155540&web_id=155540' language='JavaScript' charset='gb2312'></script></div>
</body>
</html>

