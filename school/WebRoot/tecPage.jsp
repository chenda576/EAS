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
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<s:head />
	<sx:head />
	<s:set name="tlist" value="{'15-16夏季学期','16-17秋季学期','16-17冬季学期','16-17春季学期'}" />
  </head>
  
  <body>
    欢迎你！
    <a href="startPage.jsp">返回首页</a>
    <s:property value="tec.tname" />

    <s:form action="tecFind" method="post">
    	<s:hidden name="tec.tno"></s:hidden>
    	<s:textfield name="cla.cno" label="课程号"></s:textfield>
    	<s:submit value="打分"></s:submit><br>
    </s:form>
  </body>
</html>
