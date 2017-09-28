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
    	var price =parseFloat($(this).attr("title"));
        var t=$(this).parent().find('input[class*=text_box]'); 
        t.val(parseInt(t.val())+1)
        var count = t.val();
        setTotal(price,count); 
    }) 
    $(".min").click(function(){ 
    	var price =parseFloat($(this).attr("title"));
        var t=$(this).parent().find('input[class*=text_box]'); 
        t.val(parseInt(t.val())-1) 
        if(parseInt(t.val())<0){ 
        t.val(0); 
    }
        var count = t.val();
        setTotal(price,count);  
}) 
function setTotal(price,count){ 
        var s=price*count; 
        $("#total2").html(s.toFixed(2)); 
        } 
       /*  setTotal();  */
    }) 
</script>
</head>
<body>
	<h2>购物车商品列表</h2>
	<div class="bookDiv">
		<div class="bookmsg">
			<table id="tab">
				<tr>
					<td>商品名字</td>
					<td>商品图片</td>
					<td>商品单价</td>
					<td>购买数量</td>
					<td>商品总价</td>
				</tr>
				<c:forEach var="car" items="${carItemMap}" varStatus="i">
					<tr id="sum">
						<td>${car.value.food.food_name }</td>
						<td>商品图片</td>
						<td class="price">${car.value.food.food_price}</td>
						<td><input class="min" name="11${i}" type="button" value="-"
							title="${car.value.food.food_price}" /> <input class="text_box"
							name="" type="text" value="${car.value.count }" /> <input
							class="add" name="12${i}" type="button" value="+"
							title="${car.value.food.food_price}" /></td>
						<td id="total" class="${i}">0</td>
					</tr>
					<%-- <c:set var="total" value="${total+car.value.food.food_price * car.value.count}"></c:set> --%>
				</c:forEach>
			</table>

		</div>
	</div>
	<hr />
</body>
</html>