<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" src="js/jquery-1.8.0.min.js"></script>
<script> 
$(function(){ 
    $(".add").click(function(){ 
        var t=$(this).parent().find('input[class*=text_box]'); 
        t.val(parseInt(t.val())+1) 
        setTotal(); 
    }) 
    $(".min").click(function(){ 
        var t=$(this).parent().find('input[class*=text_box]'); 
        t.val(parseInt(t.val())-1) 
        if(parseInt(t.val())<0){ 
        t.val(0); 
    } 
    setTotal(); 
}) 
function setTotal(){ 
        var s=0; 
        $(".sum").each(function(){ 
        s+=parseInt($(this).find('input[class*=text_box]').val())*parseFloat($(this).find('span[class*=price]').text()); 
        }); 
        
        $("#total").html(s.toFixed(2)); 
        } 
        setTotal(); 
    }) 
</script>
<style type="text/css">
.bookDiv {
	height: 300px;
	width: 100%;
}

.bookmsg {
	float: left;
	padding-left: 50px;
	font-size: 40px;
}
</style>
</head>
<body>
	<h2>购物车商品列表</h2>
	<div class="bookDiv">
		<div class="bookmsg">
			<table id="tab" border="1">
				<tr>
					<td>商品名字</td>
					<td>商品图片</td>
					<td>商品单价</td>
					<td>购买数量</td>
					<td>商品总价</td>
				</tr>
				<c:forEach var="car" items="${carItemMap}">
					<tr>
						<td>${car.value.food.food_name }</td>
						<td>商品图片</td>
						<td>${car.value.food.food_price }</td>
						<td>${car.value.count }</td>
						<td>${car.value.food.food_price * car.value.count}</td>
					</tr>
					<c:set var="total"
						value="${total+car.value.food.food_price * car.value.count}"></c:set>
				</c:forEach>
				<tr>
					<td>购物总价：</td>
					<td colspan="5">${total}</td>
				</tr>
			</table>

		</div>
	</div>
	<hr />
</body>
</html>