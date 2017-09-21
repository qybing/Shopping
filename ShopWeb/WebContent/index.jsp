<%@page import="java.net.URLDecoder"%>
<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport" content="width=device-width,height=device-height,inital-scale=1.0,maximum-scale=1.0,user-scalable=no;">
<meta name="apple-mobile-web-app-capable" content="yes">
<meta name="apple-mobile-web-app-status-bar-style" content="black">
<meta name="format-detection" content="telephone=no">
<title>Insert title here</title>
<style type="text/css">
body{
	margin: 0px auto;
	padding: 0px;
	text-align: center;
}

a{
	color: black;
}

#logoDiv{
	margin: 20%;
}
#bodyDiv{
	
}
#bodyDiv th{
	text-align: right;
}

#bodyDiv tr{
	height: 60px;
}

</style>
</head>
<body>
	<%
		String uname = "";
		String upwd = "";
		Cookie[] cookies = request.getCookies();
		if(cookies!=null){
			for(Cookie c : cookies){
				if(c.getName().equals("uname"))
					uname = URLDecoder.decode(c.getValue(),"utf-8");
				if(c.getName().equals("upwd"))
					upwd = c.getValue();
			}
		}
	%>

	<div id="logoDiv">
		<img src="images/logo.png" />
	</div>
	<div id="bodyDiv">
		<form action="doLogin.jsp" method="post">
			<table style="margin: 0px auto;">
				<tr>
					<th>用户名：</th>
					<td><input type="text" name="uname" value="<%=uname %>" /></td>
				</tr>
				<tr>
					<th>密码：</th>
					<td><input type="password" name="upwd" value="<%=upwd %>" /></td>
				</tr>
				<tr style="height: 2px; color: red; font-size: 12px;">
					<td colspan="2">${msg}</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="checkbox" name="rebpwd" value="save"/>是否记住密码
					</td>
				</tr>
				<tr>
					<td colspan="2">
						<input type="submit" value="登录" />
					</td>
				</tr>
			</table>
		</form>
		<div>
			<a href="register.jsp">还没有用户</a>
		</div>
	</div>
</body>
</html>