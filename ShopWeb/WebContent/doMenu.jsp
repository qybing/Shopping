<%@page import="com.shop.entity.User"%>
<%@page import="com.shop.entity.Menu"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.biz.impl.MenuBizImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	
	// 获取user参数
	User user = (User)session.getAttribute("user");
	
	MenuBizImpl menuBiz = new MenuBizImpl();
	List<Menu> menuList = menuBiz.findMenuByUser(user);
	session.setAttribute("menuList", menuList);
	request.getRequestDispatcher("menu.jsp").forward(request, response);

%>