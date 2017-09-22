<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:forEach var="cartItem" items="${cartItemList}">
		<div class="bookDiv">
			<div class="bookmsg">
				<table>
					<tr>
						<td>商品名字</td>
						<td>商品图片</td>
						<td>商品价格</td>
					    <td>购买数量</td>	
					</tr>
					<tr>
						<td>${cartItem.ganme}</td>
						<td>商品图片</td>
						<td>${cartItem.gprice}</td>
					    <td>${cartItem.num}</td>	
					</tr>
				</table>
			</div>
		</div>
		<hr/>
		</c:forEach>
</body>
</html>