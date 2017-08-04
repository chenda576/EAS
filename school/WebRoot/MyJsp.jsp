<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<%@ taglib uri="/struts-dojo-tags" prefix="sx" %>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>注册界面</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.4.0/css/font-awesome.min.css">
    <link rel="stylesheet" href="https://code.ionicframework.com/ionicons/2.0.1/css/ionicons.min.css">
    <link rel="stylesheet" href="register/dist/css/AdminLTE.min.css">
    <link rel="stylesheet" href="register/dist/css/skins/_all-skins.min.css">
	<link rel="stylesheet" href="css/myCSS.css">
	<s:head/>
	<sx:head/>
	<script type="text/javascript">
		var msg="<s:property value="msg"/>";
		if(msg!=""){
			alert(msg);
		}
	</script>
  </head>
  
  <body>
    <s:form action="register" method="post" cssClass="dark-matter" >
    	<h1>用户注册</h1>
    	<label>
    	<span>昵称</span>
    		<s:textfield name="user.nickName" placeholder="请输入昵称" maxlength="25"></s:textfield>
    	</label>
    	<label>
		<span>密码</span>
    		<input name="user.password" type="text"/>
    	</label>
		<label>
		<span>性别</span>
			<input type="radio" name="user.gender" value='1'>男
			<input type="radio" name="user.gender" value='0'>女
    	</label>
    	<label>
    	<span>手机号</span>
    		<s:textfield name="user.mobile" label="手机号码" placeholder="请输入手机号码"></s:textfield>
    	</label>
    	<button class="btn bg-navy margin">注册</button>
    </s:form>
  </body>
</html>
