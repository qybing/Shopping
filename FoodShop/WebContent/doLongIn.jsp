<%@page import="com.jovan.biz.impl.UserBizImpl"%>
<%@page import="com.jovan.entity.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
       //获取登录页面账号密码
		String user_id = request.getParameter("user_id");
		String user_pwd = request.getParameter("user_pwd");
       //检查用户是否存在
		Users users = new Users();
		UserBizImpl userbiz = new UserBizImpl();
		users = userbiz.Login(user_id, user_pwd);
		//提示用户信息
		if(users == null){
			request.setAttribute("error", "用户名或密码错误");
			request.getRequestDispatcher("LongIn.jsp").forward(request, response);
		}
		else{
			session.setAttribute("users", users);
			response.sendRedirect("doadmin.jsp");
		}


%>
</body>
</html>