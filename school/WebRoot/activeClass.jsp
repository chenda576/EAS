<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>

<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    
    <title>管理员操作页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="css/myCSS.css">
	<s:head />
	<sx:head />
	<s:set name="dlist" value="{'计算机学院','通信学院','数学系'}"/>
	<s:set name="tlist" value="{'15-16夏季学期','16-17秋季学期','16-17冬季学期','16-17春季学期'}" />
  	<s:set name="ddlist" value="#{1:'计算机学院',2:'通信学院',3:'数学系'}"/>
  	<script type="text/javascript">
	var msg="<s:property value="error"/>";
	if(msg!=""){
		alert(msg);
	}
</script>
  </head>
  
  <body class="hold-transition skin-blue sidebar-mini">>
   
   <aside class="main-sidebar">
        <section class="sidebar">
          <div class="user-panel">
            <div class="pull-left image">
              <img src="dist/img/boxed-bg.jpg" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
              <p>欢迎你</p>
              <p><s:property value="stu.name" /></p>
            </div>
          </div>
          <ul class="sidebar-menu">
            <li class="header">管理员操作</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><a href="addNewClass.jsp"><i class="fa fa-link"></i> <span>添加一门新课</span></a></li>
            <li class="active"><a href="findClass.action"><i class="fa fa-link"></i> <span>查看总课程表</span></a></li>
            <li class="active"><a href="findOClass.action"><i class="fa fa-link"></i> <span>查看开课表</span></a></li>
            <li class="active"><a href="activeClass.jsp"><i class="fa fa-link"></i> <span>开课</span></a></li>
          </ul>
        </section>
      </aside>
      <div class="content-wrapper">
        <section class="content-header">
          <h1>
            管理员操作界面
            <small>开课</small>
          </h1>
          <ol class="breadcrumb">
            <li><a href="#"><i class="fa fa-dashboard"></i> Level</a></li>
            <li class="active">Here</li>
          </ol>
        </section>
        <section class="content">
 
	<s:form action="activeClass" method="post" cssClass="dark-matter">
	<h1>开课
    <span>请填写下列表单</span>
    </h1>
    <label>
    <span>课程课号</span>
    <s:textfield cssType="text" name="actp.c.cno" placeholder="课程课号" />
    </label>
    <label>
    <span>授课老师工号</span>
    <s:textfield cssType="text" name="actp.t.tno" placeholder="授课老师工号" />
    </label>
    <label>
    <span>学期</span>
    	<s:select list="#tlist" name="actp.term" label="学期"/>
    </label>
    <label>
    <span>上课时间</span>
    <s:textfield cssType="text" name="act.time" placeholder="上课时间" />
    </label>
    <label>
    <span>上课地点</span>
    <s:textfield cssType="text" name="act.addr" placeholder="上课地点" />
    </label>
    <button class="btn bg-navy margin">添加</button>
    </s:form>
    <hr>
    </section>
      </div>
      <footer class="main-footer">
        <div class="pull-right hidden-xs">
          Anything you want
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2015 <a href="#">Company</a>.</strong> All rights reserved.
      </footer>

      <!-- Control Sidebar -->
      <aside class="control-sidebar control-sidebar-dark">
        <!-- Create the tabs -->
        <ul class="nav nav-tabs nav-justified control-sidebar-tabs">
          <li class="active"><a href="#control-sidebar-home-tab" data-toggle="tab"><i class="fa fa-home"></i></a></li>
          <li><a href="#control-sidebar-settings-tab" data-toggle="tab"><i class="fa fa-gears"></i></a></li>
        </ul>
        <!-- Tab panes -->
        <div class="tab-content">
          <!-- Home tab content -->
          <div class="tab-pane active" id="control-sidebar-home-tab">
            <h3 class="control-sidebar-heading">Recent Activity</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <i class="menu-icon fa fa-birthday-cake bg-red"></i>
                  <div class="menu-info">
                    <h4 class="control-sidebar-subheading">Langdon's Birthday</h4>
                    <p>Will be 23 on April 24th</p>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

            <h3 class="control-sidebar-heading">Tasks Progress</h3>
            <ul class="control-sidebar-menu">
              <li>
                <a href="javascript::;">
                  <h4 class="control-sidebar-subheading">
                    Custom Template Design
                    <span class="label label-danger pull-right">70%</span>
                  </h4>
                  <div class="progress progress-xxs">
                    <div class="progress-bar progress-bar-danger" style="width: 70%"></div>
                  </div>
                </a>
              </li>
            </ul><!-- /.control-sidebar-menu -->

          </div><!-- /.tab-pane -->
          <!-- Stats tab content -->
          <div class="tab-pane" id="control-sidebar-stats-tab">Stats Tab Content</div><!-- /.tab-pane -->
          <!-- Settings tab content -->
          <div class="tab-pane" id="control-sidebar-settings-tab">
            <form method="post">
              <h3 class="control-sidebar-heading">General Settings</h3>
              <div class="form-group">
                <label class="control-sidebar-subheading">
                  Report panel usage
                  <input type="checkbox" class="pull-right" checked>
                </label>
                <p>
                  Some information about this general settings option
                </p>
              </div><!-- /.form-group -->
            </form>
          </div><!-- /.tab-pane -->
        </div>
      </aside><!-- /.control-sidebar -->
      <!-- Add the sidebar's background. This div must be placed
           immediately after the control sidebar -->
      <div class="control-sidebar-bg"></div>
    </div><!-- ./wrapper -->

    <!-- REQUIRED JS SCRIPTS -->

    <!-- jQuery 2.1.4 -->
    <script src="plugins/jQuery/jQuery-2.1.4.min.js"></script>
    <!-- Bootstrap 3.3.5 -->
    <script src="bootstrap/js/bootstrap.min.js"></script>
    <!-- AdminLTE App -->
    <script src="dist/js/app.min.js"></script>
  </body>
</html>
  </body>
</html>
