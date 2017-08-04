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
    
    <title>教师打分页面</title> 
    
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
  </head>
  
  <body>
    欢迎你！
    <s:property value="tec.tname" /><br>
    <s:property value="xla.c.cno" />
    <s:set name="list1" value="#request.clist" />
    
<s:form action="gaveGrade" method="post">
    <table>
    <tr>
    	<td style="text-align:center">学号</td>
    	<td style="text-align:center">平时成绩</td>
    	<td style="text-align:center">考试成绩</td>
    </tr>
    
    <s:iterator value="list1" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="s.stuNo" /></td>
    		<td style="text-align:center"><s:textfield name="nlist" /></td>
    		<td style="text-align:center"><s:textfield name="tlist" /></td>
    	</tr>
    </s:iterator>
	</table>
    <br>
	
    <s:hidden name="tec.tno"></s:hidden>
    <s:hidden name="cla.cno"></s:hidden>
    <s:submit value="提交"></s:submit>
    </s:form>
  </body>
</html>
