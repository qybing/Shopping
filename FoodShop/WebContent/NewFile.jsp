<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title></title> 
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
    $("#sum").each(function(){ 
    s+=parseInt($(this).find('input[class*=text_box]').val())*parseFloat($(this).find('span[class*=price]').text()); 
    }); 
    
    $("#total").html(s.toFixed(2)); 
    } 
    setTotal(); 
}) 
</script> 
</head> 
<body> 
<table id="tab"> 
	<tr> 
		<td id="sum"> 
			<span>单价:</span><span class="price">1.50</span> 
			<input class="min" name="" type="button" value="-" /> 
			<input class="text_box" name="" type="text" value="1" /> 
			<input class="add" name="" type="button" value="+" /> 
		</td> 
	</tr> 


</table> 
<p>总价：<label id="total"></label></p> 
</body> 
</html> 