<%@page import="com.newcapect.eshop.service.GoodsService"%>
<%@page import="com.newcapect.eshop.entity.Goods"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>Insert title here</title>
<style type="text/css">
 *{margin: 0px;padding: 0px;border: 0px;}
  div{margin: 10px}
  #left{width: 30%}
  #right{width: 50%}
  #left,#right{float:left;}
</style>
</head>
	  <%
		String gcode = request.getParameter("gcode");
		int code = Integer.parseInt(gcode);
		GoodsService gs = new GoodsService();
		Goods g = gs.findGoodsByCode(code);
		%>
<body>
	<div id="header"><img alt="" src="images/header.png">
	<div id="content">
	     <div id="left"><img alt="" src="images/left.png"></div>
	     <div id="right"><img alt="" src="images/right.png">
	     <h2></h2>
	     </div>
	</div>
	<div id="footer"><img alt="" src="images/footer.png"></div>
	
	
	
	</div>
</body>
</html>