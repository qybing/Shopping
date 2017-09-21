<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>

<style type="text/css">
html,body,container{
	height: 100%;
	width: 100%;
}
body {
	margin: 0px;
	padding: 0px;
	font-size: 39px;
}
a{
	text-decoration: none;
	color: #000;
}
#headDiv{
	background: red;
	height: 25%;
}
#bodyDiv{
	height: 65%;
}
#h_topDiv{
	background: #03B6A3;
	height: 35%;
}
.h_topDiv{
	float: left;
	text-align: center;
	padding-top:5%;
	width: 33.333%;
	color: #FFF;
}

#b_topDiv{
	height: 16%;
}

.b_Div{
	height: 28%;
	width: 49.7%;
	float:left;
	text-align: center;
	line-height: 800%;
	border: #CCC 1px solid;
	color: #000;
}
.b_1{
	background: #A4CF27;
}
.b_2{
	background: #03BCC6;
}
.b_5{
	background: #019FA8;
}
.b_6{
	background: #00AF84;
}
#footDiv{
	height: 10%;
	background: #52ADE7;
}
.p_Div{
	float: left;
	width: 20%;
	text-align: center;
}

</style>

</head>
<body>
	<div id="headDiv">
		<div id="h_topDiv">
			<div class="h_topDiv">${user.uname }</div>
			<div class="h_topDiv">昵称</div>
			<div class="h_topDiv"><a href="index.jsp">退出</a></div>
		</div>
		<div id="h_bottomDiv">
			
		</div>
	</div>
	<div id="bodyDiv">
		<div id="b_topDiv">
			<div class="p_Div">
				<p>日收入<br/>0.00</p>
			</div>
			<div class="p_Div">
				<p>周收入<br/>0.00</p>
			</div>
			<div class="p_Div">
				<p>月收入<br/>0.00</p>
			</div>
		</div>
		<c:forEach var="i" begin="1" end="6" >
			<div class="b_Div b_${i}">
				<a href="${menuList[i-1].address } ">${menuList[i-1].mname }</a>
			</div>
		</c:forEach>
		
	</div>
	<div id="footDiv">
		<div class="">
		</div>
	</div>
</body>
</html>