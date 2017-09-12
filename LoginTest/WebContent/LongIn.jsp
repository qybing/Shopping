<%@page import="com.jovan.entity.Users"%>
<%@page import="com.jovan.service.UserService"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<style type="text/css">
body{
     background: url(images/bg.jpeg);
     background-repeat:no repeat;
     background-size:100% 100%;
     background-attachment:fixed;
  /*    -webkit-filter: blur(15px);
     -moz-filter: blur(15px);
     -o-filter: blur(15px);
     -ms-filter: blur(15px);
     filter: blur(15px);  */
}
.Userlogin{
     width:300px;
     height:180px;
     margin:200px 500px 10px 900px; 
     font-size: 30px;
     color: red;
}
#user_id,#user_pwd{
    width: 160px;
    height: 28px;
    background-color: transparent;

}
button {
		font-size: 20px;
		background-color: transparent;
	
}
</style>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>用户登录</title>
</head>
<body>
 <%
   String user_id = request.getParameter("user_id");
   String user_pwd = request.getParameter("user_pwd");
   UserService us = new UserService();
   Users u = us.Login(user_id, user_pwd);
   if (u!=null){
	   //把当前的登录用户对象，存储在会话中
	   session.setAttribute("user", u);
	   System.out.println(u);
	   response.sendRedirect("index.jsp");
   }
 %>
<div class="Userlogin">
 <form action="LongIn.jsp" method="post">
	账号：<input type="text" id="user_id" name="user_id" placeholder="请输入你的账号">
	<br>
	密码：<input type="password" id="user_pwd" name="user_pwd" placeholder="请输入你的密码">
	<br><br>
	&nbsp &nbsp<button type="submit">登录</button>
	&nbsp &nbsp &nbsp &nbsp &nbsp &nbsp &nbsp<button type="button" value="注册"><a href="login.jsp">注册</a></button>
 </form>
</div>
</body>
</html>