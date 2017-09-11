<%@page import="com.newcapect.eshop.service.UserService"%>
<%@page import="com.newcapect.eshop.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<style type="text/css">
.register{
 text-align: center
}
  body{
     background: url("images/order.jpg");
      background-size: 100%;
     }
</style>
<script src="js/jquery.min.js"></script>

<script type="text/javascript">
function yanzheng() {
	if(document.memberForm.userpwd.value!=document.memberForm.userpwd1.value){
		window.alert("您两次输入的密码不一致，请重新输入");
		return false;
		}
}

</script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>注册页面</title>
</head>
<body>
	<%
		String op = request.getParameter("op");
		if (op != null && "1".equals(op)) {
			String user_email = request.getParameter("userid");
			String user_password = request.getParameter("userpwd");
			String user_addr1 = request.getParameter("addr1");
			UserService us = new UserService();
			boolean u = us.register(user_email, user_password, user_addr1);
			if (u == true) {
				response.sendRedirect("login.jsp");
			}
		}
	%>
	<div class="register">
		<form action="register.jsp" method="post">
			<input type="hidden" value="1" name="op">
			<p>会员名称：<input type="text" name="userid"></p>
			<p>会员密码：<input type="password" name="userpwd"></p>
			<p>会员密码确认：<input type="password" name="userpwd1"></p>
			<p>真实姓名：<input type="text" name="user_name"></p>
			<p>年龄：&nbsp;&nbsp; &nbsp;&nbsp;<input type="text" name="user_age"></p>
			<p>职业：&nbsp;&nbsp; &nbsp;&nbsp;<input type="text" name="user_work"></p>
			<p>地址：&nbsp;&nbsp; &nbsp;&nbsp;  <input type="text" name="addr1"></p>
			<p>
				<input class="loginbtn" onclick="javascript:yanzheng();" type="submit" value="注册">
			</p>
		</form>

	</div>
</body>
</html>