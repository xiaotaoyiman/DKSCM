<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=UTF-8"> 
		<meta http-equiv="Pragma" content="no-cache"> 
		<meta http-equiv="Cache-Control" content="no-cache"> 
		<meta http-equiv="Expires" content="0"> 
		<title>后台管理</title>
		<link href="../static/css/login.css" rel="stylesheet" type="text/css" />
	</head>
	<body>
		<div class="login_box">
			<div class="login_l_img"><img src="../static/images/login-img.png" /></div>
		    <div class="login">
		    	<div class="login_logo"><a href="#"><img src="../static/images/login_logo.png" /></a></div>
		       	<div class="login_name">
		        	<p>DKSCM管理系统</p>
		        </div>
		        <form action="login" method="post">
		        	<input name="username" type="text" onfocus="this.value=''" placeholder="请输入手机号码" />
					<input name="password" type="password" id="password" placeholder="请输入登录密码" />
		            <input value="登录" style="width:100%;" type="submit">
		        </form>
		    </div>
		</div>
	</body>
</html>