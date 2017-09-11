<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.newcapect.eshop.service.*"%>
<%@ page import="com.newcapect.eshop.entity.*"%>
<%@ include file="access.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物联网技术14-2班的</title>
<style type="text/css">
* {
	margin: 0px;
	border: none;
	padding: 0px;
}

table, tr, td {
	margin: 5px;
	padding: 5px;
	border: 2px #EBEBEB solid;
}

table {
	width: 500px;
	margin-left: auto;
	margin-right: auto;
}

h1 {
	text-align: center;
}
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
	
</script>
</head>
<%
	String gcode = request.getParameter("gcode");
   
	List<CartItem> shc = (List<CartItem>) session.getAttribute("shc");
	if (gcode != null) {
		int code = Integer.parseInt(gcode);
		GoodsService gs = new GoodsService();
		Goods g = gs.findGoodsByCode(code);
		//如果购物车集合为空的，说明之前没有购物，属于第一次操作购物车
		if (shc == null) {
			shc = new ArrayList<CartItem>();
			CartItem item = new CartItem();
			item.setGoods(g);
			item.setNum(1);
			item.setSum(g.getGprice());
			shc.add(item);
			session.setAttribute("shc", shc);
		}
		//如果存在的选中商品，增加其购买数量（数量+1）
		boolean exist = false;
		for (CartItem it : shc) {
			if (it.getGoods().getGcode() == code) {
				it.setNum(it.getNum() + 1);
				exist = true;
				break;
			}
		}
		if (!exist) {
			CartItem ci = new CartItem();
			ci.setGoods(g);
			ci.setNum(1);
			ci.setSum(g.getGprice());
			shc.add(ci);
		}
	}
%>
<body>
	<h1>显示购物车商品项</h1>
	<table>
		<tr>
			<td>商品信息</td>
			<td>单价</td>
			<td>数量</td>
			<td>小计</td>
			<td>操作</td>
		</tr>
		<%
			for (CartItem i : shc) {
		%>
		<tr>
			<td><%=i.getGoods().getGname()%></td>
			<td><%=i.getGoods().getGprice()%></td>
			<td><%=i.getNum()%></td>
			<td><%=i.getNum() * i.getGoods().getGprice()%></td>
			<td><a href="delitem.jsp?gcode=<%=i.getGoods().getGcode()%>">删除</a></td>
		</tr>
		<%
			}
		%>
		<tr>
			<td colspan="5"><a href="order.jsp" align="right">结算</a></td>
               
		</tr>
	</table>
</body>
<html>