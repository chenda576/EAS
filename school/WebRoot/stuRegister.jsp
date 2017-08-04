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
    
    <title>学生注册页面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="../../dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="../../dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="css/myCSS.css">
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
	<s:head />
	<sx:head />
	<s:set name="dlist" value="#{1:'计算机学院',2:'通信学院',3:'数学系'}"/>
  </head>
  
  <body>
    <s:form action="stuRegister" method="post" cssClass="dark-matter" theme="simple">
    	<h1>学生注册
    		<span>请如实填写以下内容</span>
    	</h1>
    	<label>
    	<span>学生学号：</span>
    		<s:textfield name="stu.stuNo" label="学生学号" placeholder="学生学号"></s:textfield>
    	</label>
    	<label>
		<span>学生姓名：</span>
    		<s:textfield name="stu.name" label="学生姓名" placeholder="学生姓名"></s:textfield>
    	</label>
		<label>
		<span>密码：</span>
    		<s:password name="stu.password" label="密码" placeholder="密码"></s:password>
    	</label>
		<label>
		<span>性别：</span>
			<input type="radio" name="stu.gender" value='1'>男
			<input type="radio" name="stu.gender" value='2'>女
    	</label>
    	<label>
		<span>生日：</span>
    		<sx:datetimepicker name="stu.birth" displayFormat="yyyy-MM-dd" ></sx:datetimepicker>
    	</label>
    	<label>
		<span>选择你的学院</span>
    		<s:select list="dlist" name="stu.d.deptNo" listKey="key" listValue="value"/>
    	</label>
    	<button class="btn bg-navy margin">注册</button>
    </s:form>
  </body>
</html>
