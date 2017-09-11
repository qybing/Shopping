<%@ page pageEncoding="utf-8"%>
<%@ page import="java.util.*"%>
<%@ page import="com.newcapect.eshop.service.*"%>
<%@ page import="com.newcapect.eshop.entity.*"%>
<%@ include file="access.jsp"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
*{margin:0px;border:none;padding:0px；}
table,tr,td{
	margin: 5px;
	padding: 5px;
	border: 2px #EBEBEB  solid;
}
table {
	width: 500px;
	margin-left: auto;
	margin-right: auto;
}
input{border: 1px #FF2832 solid;}
</style>
<script type="text/javascript">
 function search() {
	 var wd = $(".sbox").val();
	 $("#sform").submit();
}
</script>
</head>
<%
	Users us = new Users();
    String addr1 = us.getAddr1();
    System.out.println(addr1);


%>
<body>
		<p>收获信息<input type="text" name="addr"></p>
		<p>支付方式：<select>
			<option value="网银">网银</option>
			<option value="支付宝">支付宝</option>
		    <option value="微信">微信</option>
		</select>
		<table >
		<tr>
			<td>商品信息</td>
		    <td>单价</td>
		    <td>数量</td>
		    <td>小计</td>
		</tr>
		<%
		    double sum=0;
			List<CartItem> shc = (List<CartItem>) session.getAttribute("shc");
			for (CartItem i : shc) {
				sum=i.getNum()*i.getGoods().getGprice()+sum;
		%>
	    <tr>
			<td><%=i.getGoods().getGname() %></td>
		    <td><%=i.getGoods().getGprice() %></td>
		    <td><%=i.getNum() %></td>
		    <td id="price" name="price"><%=i.getNum()*i.getGoods().getGprice() %></td>
		</tr>
	    <%} %>
	   <tr>
			<td colspan="1">总价</td>
			<td colspan="3"><%=sum %></td>
		</tr>
	</table>
	<input class="sbtn" type="button" value="支付" onclick="search()">
</body>
</html>