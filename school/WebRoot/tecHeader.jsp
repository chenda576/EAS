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
    
    <title>教师个人界面</title>
    
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
	<link rel="stylesheet" href="css/style.css" type="text/css">
	<link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <!-- Ionicons -->
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
	<s:head />
	<sx:head />
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
              <p><s:property value="tec.tname" /></p>
            </div>
          </div>
          <ul class="sidebar-menu">
            <li class="header">教师操作</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><s:a href="tecFindClass.action?no=%{tec.tno}"><i class="fa fa-link"></i> <span>查看本学期开设班级</span></s:a></li>
          </ul>
        </section>
      </aside>
      <div class="content-wrapper">
        <section class="content-header">
          <h1>
            教师操作界面
          </h1>
        </section>
        <section class="content">
        <s:if test="#request.colist!=null">
    	<s:set name="list0" value="#request.colist" />
    	<div id="container">
    <table class="zebra">
    <caption>本学期开课情况：</caption>
    <thead>
    <tr>
    	<th style="text-align:center">课程号</th>
    	<th style="text-align:center">上课时间</th>
    	<th style="text-align:center">上课地点</th>
    	<th style="text-align:center">操作</th>
    </tr> 
    </thead>
    <tbody>
    <s:iterator value="list0" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="id.c.cno" /></td>
    		<td style="text-align:center"><s:property value="time" /></td>
    		<td style="text-align:center"><s:property value="addr" /></td>
    		<td style="text-align:center"><s:a href="tecFind.action?no=%{tec.tno}&noc=%{id.c.cno}">打分</s:a></td>
    	</tr>
   	</s:iterator>
   	</tbody>
	</table>
	</div>
    </s:if>
    
    <s:if test="#request.clist!=null">
    	<s:set name="list1" value="#request.clist" />
	    <s:form action="gaveGrade" method="post">
	    <div id="container">
	    <table class="zebra">
	    <caption>登分表</caption>
	    <thead>
	    <tr>
	    	<th style="text-align:center">学号</th>
	    	<th style="text-align:center">平时成绩</th>
	    	<th style="text-align:center">考试成绩</th>
	    </tr>
	    </thead>
	    <tbody>
	    <s:iterator value="list1" status="st">
	    	<tr>
	    		<td style="text-align:center"><s:property value="s.stuNo" /></td>
	    		<td style="text-align:center"><s:textfield style="color:red" name="nlist" /></td>
	    		<td style="text-align:center"><s:textfield style="color:red" name="tlist" /></td>
	    	</tr>
	    </s:iterator>
	    </tbody>
		</table>
		</div>
	    <br>
		
	    <s:hidden name="tec.tno"></s:hidden>
	    <s:hidden name="cla.cno"></s:hidden>
	    <button class="btn bg-navy margin">提交</button>
	    </s:form>
    </s:if>
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
