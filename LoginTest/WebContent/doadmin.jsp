<%@page import="com.jovan.entity.UserType"%>
<%@page import="java.util.List"%>
<%@page import="com.jovan.entity.User"%>
<%@page import="com.jovan.biz.impl.UserTypeBizImpl"%>
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
	request.setCharacterEncoding("UTF-8");
	User user= (User)session.getAttribute("user");
	UserTypeBizImpl userTypeBizImpl = new UserTypeBizImpl();
	List<UserType> userTypeList = userTypeBizImpl.UserAdmin(user);
	session.setAttribute("userTypeList", userTypeList);
	response.sendRedirect("admin.jsp");



%>
</body>
</html>