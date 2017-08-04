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
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
	<s:head />
	<sx:head />
  </head>
  
  <body>
  
  	<a href="startPage.jsp">返回首页</a>
  	&nbsp;&nbsp;&nbsp;
    <a href="stuRegister.jsp">学生注册</a><br><br>
    <s:form action="stuLogin" method="post">
    	<s:textfield name="no" label="学生学号"></s:textfield>
		<s:password  name="password" label="密码"></s:password>
    	<s:submit value="登录"></s:submit>
    </s:form>
  </body>
</html>
