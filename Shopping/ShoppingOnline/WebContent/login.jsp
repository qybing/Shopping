<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.newcapect.eshop.service.*" %>
<%@ page import="com.newcapect.eshop.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物联网技术14-2班的</title>
<style type="text/css">
	*{margin:0px;border:none;padding:0px;}
	div input{border: 2px #E6E6E6 solid;}
	#logninDIV input {border: 2px #E6E6E6E6 solid;margin: 15px 0;}
	#logninDIV{
	width: 300px;
	margin-top: 100px;
	margin-left: 600px;
	margin-right: auto;}

	.loginbtn{
	       width:150px;
		   background-color: #FF2832;
           font-size: 20px;
           color: #FFF;
           }
     body{
     background: url("images/登陆.png");
     }
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
 <%
   String userid = request.getParameter("userid");
   String password = request.getParameter("userpwd");
   UserService us = new UserService();
   Users u = us.login(userid,password);
   if (u!=null){
	   //把当前的登录用户对象，存储在会话中
	   session.setAttribute("user", u);
	   System.out.println(u);
	   response.sendRedirect("index.jsp");
   }
 %>
    	<div id="logninDIV">
    		<form action="login.jsp" method="post">
	    		<p>登录名：</p>
	    		<p><input type="text" name="userid"></p>
	    		<p>密码：</p>
	    		<p><input type="password" name="userpwd"></p>
	    		<p><input class="loginbtn" type="submit" value="快速登录"></p>
	    	</form>
		 </div>
</body>
<html>
