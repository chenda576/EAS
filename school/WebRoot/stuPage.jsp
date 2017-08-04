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
    
    <title>学生个人界面</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	
	<s:head />
	<sx:head />
	
	<s:set name="tlist" value="{'15-16夏季学期','16-17秋季学期','16-17冬季学期','16-17春季学期'}" />
	
	
	
	
  </head>
  
  <body>
  <a href="startPage.jsp">返回首页</a>
  	 欢迎你！
    <s:property value="stu.name" /><br>
    查询课程：
    <s:form action="lookOpenClass" method="post">
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<s:textfield name="xk.c.cno" label="课程号"></s:textfield>
    	<s:textfield name="xk.t.tno" label="教师号"></s:textfield>
    	<s:submit value="选择"></s:submit><br>
    </s:form>
    <br>
    <s:if test="#request.oclist==null">
    	暂无结果
    </s:if>
    <s:else>
    	<s:set name="list0" value="#request.oclist" />
    <table>
    <tr>
    	<td style="text-align:center">课程号</td>
    	<td style="text-align:center">课程号</td>
    	<td style="text-align:center">上课时间</td>
    	<td style="text-align:center">上课地点</td>
    </tr> 
    <s:iterator value="list0" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="id.c.cno" /></td>
   			<td style="text-align:center"><s:property value="id.t.tno" /></td>
    		<td style="text-align:center"><s:property value="time" /></td>
    		<td style="text-align:center"><s:property value="addr" /></td>
    	</tr>
   	</s:iterator>
	</table>
    </s:else>
    <br>
    <hr>
    选课：
    <s:form action="attendClass" method="post">
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<s:textfield name="xk.c.cno" label="课程号"></s:textfield>
    	<s:textfield name="xk.t.tno" label="教师号"></s:textfield>
    	<s:submit value="选择"></s:submit><br>
    </s:form>
    <br>
    <hr>
    退课：
    <s:form action="quitClass" method="post">
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<s:textfield name="tk.c.cno" label="课程号"></s:textfield>
    	<s:submit value="退课"></s:submit><br>
    </s:form>
    <br>
    <hr>
    课程表：
    <s:form action="lookClass" >
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<s:submit value="查看"></s:submit><br>
    </s:form>
    <s:if test="#request.olist==null">
    	暂无结果
    </s:if>
    <s:else>
    	<s:set name="list1" value="#request.olist" />
    <table>
    <tr>
    	<td style="text-align:center">课程名</td>
    	<td style="text-align:center">教师名</td>
    	<td style="text-align:center">学分</td>
    	<td style="text-align:center">上课时间</td>
    	<td style="text-align:center">上课地点</td>
    </tr> 
    <s:iterator value="list1" status="st">
    	<tr>
    		<td style="text-align:center"><s:property value="#list1[#st.index][0]" /></td>
   			<td style="text-align:center"><s:property value="#list1[#st.index][1]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][2]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][3]" /></td>
    		<td style="text-align:center"><s:property value="#list1[#st.index][4]" /></td>
    	</tr>
   	</s:iterator>
	</table>
    </s:else>
    <br>
    <hr>
    成绩：
    <s:form action="lookGrade" method="post">
    	<s:hidden name="stu.stuNo"></s:hidden>
    	<s:select list="#tlist" name="gra.term" label="学期"/><br><br>
    	<s:submit value="查看"></s:submit><br>
    </s:form>
    <s:if test="#request.glist==null">
    	无结果
    </s:if>
    <s:else>
    	<s:set name="list2" value="#request.glist" />
    <table>
    <tr>
    	<td style="text-align:center">课程号</td>
    	<td style="text-align:center">教师</td>
    	<td style="text-align:center">学期</td>
    	<td style="text-align:center">平时分</td>
    	<td style="text-align:center">考试得分</td>
    	<td style="text-align:center">总分</td>
    </tr>
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
	</table>
    </s:else>
  </body>
</html>
