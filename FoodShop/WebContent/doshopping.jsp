<%@page import="com.jovan.entity.CartItem"%>
<%@page import="java.util.List"%>
<%@page import="com.jovan.biz.impl.CartItemBizImpl"%>
<%@page import="com.jovan.biz.CartItemBiz"%>
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
	String food_id = request.getParameter("food_id");	
	int food_num =  1;
	
	CartItemBizImpl cartItemBizImpl = new CartItemBizImpl();
	List<CartItem> cartItemList = cartItemBizImpl.addFoods(Integer.parseInt(food_id), food_num);
	session.setAttribute("cartItemList", cartItemList);
	request.getRequestDispatcher("shopping.jsp").forward(request, response);
%>
</body>
</html>