<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
</head>
<body>
	<h2>购物车商品列表</h2>
	<c:forEach var="cartItem" items="${cartItemList}">
		<div class="bookDiv">
			<div class="bookmsg">
				<table id="tab"> 
					<tr>
						<td>商品名字</td>
						<td>商品图片</td>
						<td>商品单价</td>
					    <td>购买数量</td>	
					    <td>总价</td>
					</tr>
					<tr class="sum">
						<td>${cartItem.gname}</td>	
						<td>商品图片</td>
						<td><span class="price">${cartItem.gprice}</span></td>
					    <td> 
							<input class="min" name="" type="button" value="-" /> 
							<input class="text_box" name="" type="text" value="1" /> 
							<input class="add" name="" type="button" value="+" /> 
						</td> 
					    <td><p><label id="total"></label></p></td>	
					</tr>
				</table>
				<p>总价：<label id="total"></label></p> 
			</div>
		</div>
		<hr/>
		</c:forEach>
</body>
</html>