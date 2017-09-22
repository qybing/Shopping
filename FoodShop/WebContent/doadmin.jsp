<%@page import="java.util.List"%>
<%@page import="com.jovan.entity.UserType"%>
<%@page import="com.jovan.biz.impl.UserTypeBizImpl"%>
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
	request.setCharacterEncoding("utf-8");
	//获取用户的信息
	Users users = (Users)session.getAttribute("users");
	UserTypeBizImpl usertypeBiz = new UserTypeBizImpl();
	List<UserType> usertypelist = usertypeBiz.findUserType(users);
	session.setAttribute("usertypelist", usertypelist);
	request.getRequestDispatcher("admin.jsp").forward(request, response);
%>
</body>
</html>