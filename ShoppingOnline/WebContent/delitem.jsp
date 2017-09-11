<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.newcapect.eshop.service.*" %>
<%@ page import="com.newcapect.eshop.entity.*" %>
<%@ include file="access.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="utf-8">
<title>物联网专业-新开普实训</title>
<style type="text/css">
</style>
</head>
<%
	String gcode = request.getParameter("gcode");
	if(gcode!=null){
		int code = Integer.parseInt(gcode);
		List<CartItem> shc = (List<CartItem>) session.getAttribute("shc");	
		//如果购物车集合为空，说明之前没有购物，属于第一次操作购物车
		if (shc != null) {
			for(CartItem it : shc){
				if(it.getGoods().getGcode()==code){
					shc.remove(it);
					break;
				}
			}
		}
}
	response.sendRedirect("shop.jsp");
%>
<body>

</body>
</html>