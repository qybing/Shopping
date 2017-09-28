<%@page import="com.jovan.dao.impl.UserDaoImpl"%>
<%@page import="com.jovan.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body {
	background: url(images/bg.jpeg);
	background-repeat: no repeat;
	background-size: 100% 100%;
	background-attachment: fixed;
	/*    -webkit-filter: blur(15px);
     -moz-filter: blur(15px);
     -o-filter: blur(15px);
     -ms-filter: blur(15px);
     filter: blur(15px);  */
}

.Userlogin {
	width: 600px;
	height: 400px;
	margin: 50% auto;
	font-size: 70px;
	color: red;
	text-align: center;
}

#user_id, #user_pwd {
	width: 350px;
	height: 68px;
	font-size: 50px;
	background-color: transparent;
}

button {
	font-size: 60px;
	background-color: transparent;
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
	<div class="Userlogin">
		<form action="UserServlet" method="post">
			账号：<input type="text" id="user_id" name="user_id"
				placeholder="请输入你的账号"> <br> 密码：<input type="password"
				id="user_pwd" name="user_pwd" placeholder="请输入你的密码"> <br>${error}<br>
			&nbsp &nbsp
			<button type="submit">登录</button>
			&nbsp &nbsp &nbsp
			<button type="button" value="注册">
				<a href="login.jsp">注册</a>
			</button>
		</form>
	</div>
</body>
</html>