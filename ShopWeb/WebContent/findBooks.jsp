<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script language="javascript" src="js/jquery-1.8.0.min.js"></script>
<script language="javascript">
$(function(){
	$("input[name='bname']").blur(function(){
		if($(this).val()==""){
			$(this).val(" 请输入图书名称");
			$(this).css("color","#CCC");
		}
	});
	$("input[name='bname']").focus(function(){
		$(this).val("");
		$(this).css("color","black");
	});
	var clicknum = 0;
	$("#sx").click(function(){
		if(clicknum%2==0)
			$("#b_ssdiv").css("display","block");
		else
			$("#b_ssdiv").css("display","none");
		clicknum++;
	});
	
	$("input[name='ssbtn']").click(function(){
		var bname = $("input[name='bname']").val();
		if(bname==" 请输入图书名称"){
			window.location.href = "doFindBooks.jsp";
			return;
		}
		window.location.href = "doFindBooks.jsp?bname="+bname;
		
	});
});
</script>
<style type="text/css">
html,body,container{
	height: 100%;
	width: 100%;
}
body{
	padding: 0px;
	margin: 0px;
}
a{	
	color: black;
	text-decoration: none;
	
}
#headDiv{
	background: url("images/bg2.jpg");
	height: 15%;
	text-align: center;
}
#h_topDiv{
	line-height:250%;
	height: 60%;
	font-size: 70px;
}
#h_bottomDiv{
	height: 40%;
}
#sxDiv{
	float: left;
	font-size: 35px;
	height: 100%;
	width: 20%;
}
#ssDiv{
	float: left;
	height: 100%; 
	width: 60%;
}

#btmDiv{
	float: left;
	height: 100%;
	width:20%;
}
#sx{
	display: block;
	height: 90%;
	margin-top: 10%;
}
.ss{
	margin-top:2%; 
	height: 60%; 
	width: 80%;
	font-size: 30px;
	color: #CCC;
}
#bodyDiv{
	height: 85%;
}
.bookDiv{
	height: 290px;
	width: 100%;
}
.bookDiv img{
	float: left;
	padding-left:15%;
	padding-top: 1%;
	height: 90%;
	
}
#b_topDiv{
	height: 20px;
}
.bookmsg{
	float:left;
	padding-left: 50px;
	font-size: 40px;
}
.bookmsg dd{
	margin-top: 20px;
}

#moreDiv{
	margin-top:30px;
	text-align: center;
}
#moreBtn{
	font-size: 50px;
	width: 100%;
}
#b_ssdiv{
	display: none;
	width: 100%;
	font-size: 35px;
}
#sxtab{
	width: 100%;
}
#sxtab tr{
	height: 90px;
	font-size: 35px;
}
#sxtab td{
	padding-left:10%;
}
.price{
	border:black 1px solid;
	font-size: 35px;
}
#type{
	font-size: 35px;
}
#queren{
	text-align: center;
}
#queding{
	font-size: 35px;
}
</style>
</head>
<body>
	<div id="headDiv">
		<div id="h_topDiv">
			全部图书
		</div>
		<div id="h_bottomDiv">
			<div id="sxDiv">
				<a href="#" id="sx">筛选</a>
			</div>
			<div id="ssDiv">
				<input type="text" name="bname" class="ss" value=" 请输入图书名称" />
			</div>
			<div id="btmDiv">
				<input type="button" name="ssbtn" value="搜索" class="ss" style=" margin-top: 10%;font-size: 40px;" />
			</div>
		</div>
	</div>
	<div id="bodyDiv">
		<div id="b_ssdiv">
			<form action="doFindBooks.jsp" method="post">
				<input type="hidden" name="name" value="${book.bname }">
				<table id="sxtab">
					<tr>
						<th>图书类型：</th>
						<td>
							<select id="type" name="typeId">
								<option value="-1">选择类型</option>
								<c:forEach var="type" items="${typeList }">
									<option value="${type.tid }">${type.tname }</option>
								</c:forEach>
							</select>
						</td>
					</tr>
					<tr>
						<th>图书价格：</th>
						<td><input class="price" size="4" type="text" name="minPrice"/> — <input class="price" size="4" type="text" name="maxPrice"/>&nbsp;元</td>
					</tr>
					<tr>
						<td colspan="2" id="queren"><input id="queding" type="submit" value="确定"></td>
					</tr>
				</table>
			</form>
		</div>
		<div id="b_topDiv">
		</div>
		<c:forEach var="book" items="${bookList}">
		<div class="bookDiv">
			<img src="images/book_02.jpg" />
			<div class="bookmsg">
				<dl>
					<dt>《${book.bname }》</dt>
					<dd>作者：${book.bauthor }</dd>
					<dd>简介：${book.bcomment }</dd>
				</dl>
			</div>
		</div>
		<hr/>
		</c:forEach>
		
		<div id="moreDiv"><input id="moreBtn" type="button" value="加载更多"/></div>
	</div>
</body>
</html>