<%@page import="java.util.HashMap"%>
<%@page import="java.util.Map"%>
<%@page import="com.jovan.entity.Food"%>
<%@page import="com.jovan.biz.impl.FoodBizImpl"%>
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
	//购物车功能
	//1-创建编码格式
	request.setCharacterEncoding("utf-8");

	//2-获取页面值
	int food_id = Integer.parseInt(request.getParameter("food_id"));	
	int food_num =  1;
	//3-业务方法
	FoodBizImpl foodBizImpl = new FoodBizImpl();
	Food food = foodBizImpl.findFoodsById(food_id);
	Map<Integer,CartItem> carItemMap  = null;
	//4-1判断购物车是否存在，如果没有则创建一个购物车
	if(session.getAttribute("carItemMap")==null){
		carItemMap = new HashMap<>();
	}else{
		carItemMap = (Map<Integer,CartItem>)session.getAttribute("carItemMap");
	}
	//购物车存在，判断是否含有本商品，如果有怎么数量加1
	//如果不存在的，怎么创建一个商品的信息添加到Map里去
	if(carItemMap.containsKey(food.getId())){
		CartItem carItem = carItemMap.get(food.getId());
		carItem.setCount(carItem.getCount()+1);
	}else{
		CartItem cartItem = new CartItem();
		cartItem.setFood(food);
		cartItem.setCount(1);
		carItemMap.put(food.getId(), cartItem);
	}
	// 3保存购物车
	session.setAttribute("carItemMap", carItemMap);
// 跳转页面
response.sendRedirect("buyFood.jsp");
	
// 	CartItemBizImpl cartItemBizImpl = new CartItemBizImpl();
// 	List<CartItem> cartItemList = cartItemBizImpl.addFoods(Integer.parseInt(food_id), food_num);
// 	session.setAttribute("cartItemList", cartItemList);
// 	request.getRequestDispatcher("shopping.jsp").forward(request, response);
%>
</body>
</html>