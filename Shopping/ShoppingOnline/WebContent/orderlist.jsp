<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.newcapect.eshop.service.*" %>
<%@ page import="com.newcapect.eshop.entity.*" %>

<%
  Users user = (Users)session.getAttribute("user");
  if(user == null){
	  response.sendRedirect("login.jsp");
  }
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物联网技术14-2班的</title>
<style type="text/css">
	*{margin:0px;border:none;padding:0px;}
	div input{border: 2px #E6E6E6 solid;}
	#logninDIV input {border: 2px #E6E6E6E6 solid;margin: 15px 0;}
	#logninDIV{
	width: 300px;
	margin-top: 100px;
	margin-left: auto;
	margin-right: auto;}

	.loginbtn{
	       width:150px;
		   background-color: #FF2832;
           font-size: 20px;
           color: #FFF;
           }
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">

</script>
</head>
<body>
    	<div id="logninDIV">
    		<p>订单详情</p>
		 </div>
</body>
<html>
