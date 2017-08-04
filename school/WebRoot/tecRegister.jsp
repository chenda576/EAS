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
    
    <title>教师注册页面</title>
    
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
	<s:head />
	<sx:head />
	<s:set name="dlist" value="#{1:'计算机学院',2:'通信学院',3:'数学系'}"/>
  </head>
  
  <body>
  <a href="startPage.jsp">返回首页</a>
    <s:form action="tecRegister" method="post" cssClass="dark-matter" theme="simple">
    	<h1>教师注册
    		<span>请如实填写以下内容</span>
    	</h1>
    	<label>
    	<span>教师工号</span>
    	<s:textfield cssType="text" name="tec.tno" placeholder="教师工号" />
    	</label>
    	<label>
    	<span>教师姓名</span>
    	<s:textfield cssType="text" name="tec.tname" placeholder="教师姓名" />
    	</label>
    	<label>
    	<span>密码</span>
    	<s:password name="tec.password" placeholder="密码"></s:password>
    	</label>
    	<label>
    	<span>选择你的学院</span>
    	<s:select list="dlist" name="tec.d.deptNo" listKey="key" listValue="value"/>
    	</label>
		<label>
    	<span>选择你的学院</span>
    	<s:textfield cssType="text" name="tec.addr" label="地址"></s:textfield>
    	</label>
    	<input type="button" class="button" value="注册" />
    </s:form>
  </body>
</html>
