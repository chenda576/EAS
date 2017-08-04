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
    
    <title>学生登录页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	
	<link href="assets/css/bootstrap.css" rel="stylesheet">
    <link href="assets/font-awesome/css/font-awesome.css" rel="stylesheet" />
    <link href="assets/css/style.css" rel="stylesheet">
    <link href="assets/css/style-responsive.css" rel="stylesheet">
	<s:head />
	<sx:head />
	<script type="text/javascript">
	var msg="<s:property value="error"/>";
	if(msg!=""){
		alert(msg);
	}
</script>
  </head>
  
  <body>
  	    <div id="login-page">
	  	<div class="container">
		      <s:form cssClass="form-login" action="Login">
		        <h2 class="form-login-heading">马上登录</h2>
		        <div class="login-wrap">
		            <s:textfield  name="no" cssClass="form-control" placeholder="账号"></s:textfield>
		            <br>
		            <s:password name="password" cssClass="form-control" placeholder="密码"></s:password>
		            <label class="checkbox">
		                <span class="pull-right">
		                    <a data-toggle="modal" href="login.html#myModal"> 忘记密码？</a>		
		                </span>
		            </label>
		           <button class="btn btn-theme btn-block" type="submit"><i class="fa fa-lock"></i> 登录</button>
		            <hr>
		            <div class="registration">
		                	还没有注册请<br/>
		                <a class="" href="stuRegister.jsp">学生注册</a>
		                &nbsp;&nbsp;&nbsp;&nbsp;
		                <a class="" href="tecRegister.jsp">教师注册</a>
		            </div>
		
		        </div>
				          <!-- Modal -->
		          <div aria-hidden="true" aria-labelledby="myModalLabel" role="dialog" tabindex="-1" id="myModal" class="modal fade">
		              <div class="modal-dialog">
		                  <div class="modal-content">
		                      <div class="modal-header">
		                          <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
		                          <h4 class="modal-title">忘记密码？</h4>
		                      </div>
		                      <div class="modal-body">
		                          <p>输入注册时的邮箱，重置密码</p>
		                          <input type="text" name="email" placeholder="Email" autocomplete="off" class="form-control placeholder-no-fix">
		
		                      </div>
		                      <div class="modal-footer">
		                          <button data-dismiss="modal" class="btn btn-default" type="button">取消</button>
		                          <button class="btn btn-theme" type="button">提交</button>
		                      </div>
		                  </div>
		              </div>
		          </div>
		          <!-- modal -->
		
		   </s:form>	  	
	  	</div>
	  </div>

    <!-- js placed at the end of the document so the pages load faster -->
    <script src="assets/js/jquery.js"></script>
    <script src="assets/js/bootstrap.min.js"></script>

    <!--BACKSTRETCH-->
    <!-- You can use an image of whatever size. This script will stretch to fit in any screen size.-->
    <script type="text/javascript" src="assets/js/jquery.backstretch.min.js"></script>
    <script>
        $.backstretch("assets/img/login-bg.jpg", {speed: 500});
    </script>
  </body>
</html>
