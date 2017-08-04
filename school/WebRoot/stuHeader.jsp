<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html  lang="en">
  <head>
    <base href="<%=basePath%>">
    
    <title>学生个人界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<meta charset="UTF-8">
  	<meta name="Generator" content="EditPlus®">
  	<meta name="Author" content="">
  	<meta name="Keywords" content="">
  	<meta name="Description" content="">
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
    <link rel="stylesheet" href="css/style.css" type="text/css">
    <link rel="stylesheet" href="bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="dist/css/skins/skin-blue.min.css">
	<link rel="stylesheet" href="css/myCSS.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
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
  
  <body class="hold-transition skin-blue sidebar-mini">
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
          <form action="#" method="get" class="sidebar-form">
            <div class="input-group">
              <input type="text" name="q" class="form-control" placeholder="Search...">
              <span class="input-group-btn">
                <button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i></button>
              </span>
            </div>
          </form>
          <ul class="sidebar-menu">
            <li class="header">学生操作</li>
            <!-- Optionally, you can add icons to the links -->
            <li class="active"><s:a href="lookGrade.action?no=%{stu.stuNo}"><i class="fa fa-link"></i> <span>成绩查询</span></s:a></li>
            <li class="active"><s:a href="lookClassTable.action?no=%{stu.stuNo}"><i class="fa fa-link"></i> <span>课程表</span></s:a></li>
            <li class="active"><s:a href="lookClass.action?no=%{stu.stuNo}"><i class="fa fa-link"></i> <span>退课</span></s:a></li>
          </ul>
        </section>
      </aside>
      <div class="content-wrapper">
        <!-- Content Header (Page header) -->
        <section class="content-header">
          <h1>
            学生操作界面
            <small>学生界面</small>
          </h1>
        </section>

        <!-- Main content -->
        <section class="content">
       <left>
    <s:form action="lookOpenClass" method="post" cssClass="dark-matter">
    	<h1>开课查询
    	<span>输入课程号或教师号，支持模糊查询</span>
    	</h1>
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<label>
    	<span>课程号</span>
    	<s:textfield cssType="text" name="xk.c.cno" placeholder="课程号" />
    	</label>
    	<label>
    	<span>教师号</span>
    	<s:textfield cssType="text" name="xk.t.tno" placeholder="教室号" />
    	</label>
    	<button class="btn bg-navy margin">查询</button>
    </s:form>
    </left>
    <br>
    <s:if test="#request.oclist!=null">
    
    	<s:set name="list0" value="#request.oclist" />
    <div id="container">
    <table class="zebra">
    <caption>开课情况表</caption>
    <thead>
    <tr>
    	<th style="text-align:center">课程号</th>
    	<th style="text-align:center">教师号</th>
    	<th style="text-align:center">上课时间</th>
    	<th style="text-align:center">上课地点</th>
    	<th style="text-align:center">操作</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="list0" status="st">
    	<tr>
    		<th style="text-align:center"><s:property value="id.c.cno" /></th>
   			<th style="text-align:center"><s:property value="id.t.tno" /></th>
    		<th style="text-align:center"><s:property value="time" /></th>
    		<th style="text-align:center"><s:property value="addr" /></th>
    		<th style="text-align:center"><s:a href="attendClass.action?no=%{stu.stuNo}&noc=%{id.c.cno}&tn=%{id.t.tno}">选课</s:a></th>
    	</tr>
   	</s:iterator>
   	</tbody>
	</table>
	</div>
    </s:if>
    
    <s:if test="#request.schedule!=null">
    	<s:set name="schedule" value="#request.schedule" />
    	<div id="container"> 
    	<table class="zebra">
    	<caption>课程表</caption>
    	<thead>
    	<tr>
	    	<th style="text-align:center"></th>
	    	<th style="text-align:center">一</th>
	    	<th style="text-align:center">二</th>
	    	<th style="text-align:center">三</th>
	    	<th style="text-align:center">四</th>
	    	<th style="text-align:center">五</th>
	    </tr>
    	</thead>
    	<tbody>
    <s:iterator value="schedule" id="schedule" status="st">
    	<tr>
    		<th style="text-align:center"><s:property value="#st.index+1" /></th>
    		<td style="text-align:center"><s:property value="#schedule[0]" /></td>
   			<td style="text-align:center"><s:property value="#schedule[1]" /></td>
   			<td style="text-align:center"><s:property value="#schedule[2]" /></td>
   			<td style="text-align:center"><s:property value="#schedule[3]" /></td>
   			<td style="text-align:center"><s:property value="#schedule[4]" /></td>
    	</tr>
    </s:iterator>
    </tbody>
	</table>
	</div>
	</s:if>
    
    <s:if test="#request.olist!=null">
    	<s:set name="list1" value="#request.olist" />
    	<div id="container"> 
    	<table class="zebra">
    	<caption>课程列表</caption>
    	<thead>
    	<tr>
	    	<th style="text-align:center">课程名</th>
	    	<th style="text-align:center">教师名</th>
	    	<th style="text-align:center">学分</th>
	    	<th style="text-align:center">上课时间</th>
	    	<th style="text-align:center">上课地点</th>
	    	<th style="text-align:center">操作</th>
	    </tr>
    	</thead>
    	<tbody>
    <s:iterator value="list1" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="#list1[#st.index][1]" /></td>
   			<td style="text-align:center"><s:property value="#list1[#st.index][2]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][3]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][4]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][5]" /></td>
    		<td style="text-align:center"><s:a href="quitClass.action?no=%{stu.stuNo}&noc=%{#list1[#st.index][0]}">退课</s:a></td>
    	</tr>
    </s:iterator>
    </tbody>
	</table>
	</div>
	
    </s:if>
    <br>
    <hr>
    <s:if test="#request.glist!=null">
    	<s:set name="list2" value="#request.glist" />
   <div id="container"> 
    <table class="zebra">
    <caption>成绩表</caption>
    <thead>
    <tr>
    	<th style="text-align:center">课程号</th>
    	<th style="text-align:center">教师</th>
    	<th style="text-align:center">学期</th>
    	<th style="text-align:center">平时分</th>
    	<th style="text-align:center">考试得分</th>
    	<th style="text-align:center">总分</th>
    </tr>
    </thead>
    <tbody>
    <s:iterator value="list2" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="id.c.cno" /></td>
    		<td style="text-align:center"><s:property value="id.t.tno" /></td>
   			<td style="text-align:center"><s:property value="id.term" /></td>
    		<td style="text-align:center"><s:property value="ngrade" /></td>
    		<td style="text-align:center"><s:property value="tgrade" /></td>
    		<td style="text-align:center"><s:property value="fgrade" /></td>
    	</tr>
    </s:iterator>
    </tbody>
	</table>
	</div>
    </s:if>
    
          

        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- Main Footer -->
      <footer class="main-footer">
        <!-- To the right -->
        <div class="pull-right hidden-xs">
        </div>
        <!-- Default to the left -->
        <strong>Copyright &copy; 2016 <a href="#">Company</a>.</strong> All rights reserved.
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
