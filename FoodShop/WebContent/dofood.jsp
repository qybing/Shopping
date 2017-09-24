<%@page import="com.jovan.entity.Food"%>
<%@page import="java.util.List"%>
<%@page import="com.jovan.biz.impl.FoodBizImpl"%>

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
	int nowPage = 1;
	String nowpage = request.getParameter("page");
	String min_price = request.getParameter("min_price");
	String max_price =  request.getParameter("max_price");
	String food_name = request.getParameter("food_name");
	if(nowpage==null){
		nowPage = 1;
	}
	else{
		nowPage = Integer.parseInt(nowpage);
	}
	Food food = new Food();
	if( min_price != null && !min_price.equals("")){
		food.setMin_price(Integer.parseInt(min_price));
	}
	if( max_price != null && !max_price.equals("")){
		food.setMax_price(Integer.parseInt(max_price));
	}
	if( food_name != null && !food_name.equals("")){
		food.setFood_name(food_name);
	}
	FoodBizImpl foodBizImpl =  new FoodBizImpl();
	/* List<Food> foodList = foodBizImpl.findAllFoods(); */
    int pages_sum = foodBizImpl.findFoodsPages(food);
	/* System.out.print(pages_sum); */ 
	List<Food> foodList = foodBizImpl.findFoods(nowPage,food);
	
	session.setAttribute("foodList", foodList);
	session.setAttribute("food", food);
	session.setAttribute("pages_sum", pages_sum);
	request.getRequestDispatcher("food.jsp").forward(request, response);
%>
</body>
</html>