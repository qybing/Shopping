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
	Users user = (Users) session.getAttribute("user");
	if(user == null){
<<<<<<< HEAD
		response.sendRedirect("index.jsp");
=======
		response.sendRedirect("LongIn.jsp");
>>>>>>> 678956727558584da35a1124efadf4707576dad5
	}
%>

</body>
</html>