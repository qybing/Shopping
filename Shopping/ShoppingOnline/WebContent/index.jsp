<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page import="java.util.*" %>
<%@ page import="com.newcapect.eshop.service.*" %>
<%@ page import="com.newcapect.eshop.entity.*" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<title>物联网技术14-2班的</title>
<style type="text/css">
    body{
    
    background: url("images/背景.jpg") ;
    background-size: 100%;
    }
	*{margin:0px;border:none;padding:0px}
	section{
	float:left;
	margin-left: 20px;
	margin-top: 50px;
	}
	.cls-title{
	 font-size: 16px;font-style: normal;font-weight: normal;
	 margin: 5px;
	}
	
	.sbox{border: 2px #FF2832 solid;width: 200px;height: 40px;}
	.sbtn{border: 0px #FF2832 solid;width: 63px;height: 52px;background-image: url(images/sbtn.png);cursor: pointer;} 
    #login{
    float: right;
    color: #FF0000;
    }
</style>
<script src="js/jquery.min.js"></script>
<script type="text/javascript">
 function search() {
	 var wd = $(".sbox").val();
	 $("#sform").submit();
}
</script>
</head>
<body>
<div id="login">
  <a href="login.jsp">登陆</a>
  <a href="register.jsp">注册</a>
</div>
<form  action="index.jsp" method="get" id="sform">
   <div class="po">
            请输入商品关键字:<input class="sbox" type="text" id="swd" name="swd">
               <input class="sbtn" type="button" value=" " onclick="search()">
    </div>
 </form>
<% 
	String gname=request.getParameter("swd");
	GoodsService gs = new GoodsService();
	List<Goods> list = gs.findGoodsByTitle(gname);
	for(int i=0;i<list.size();i++){
		Goods g=list.get(i);
 %>
<section>
		<a href="detail.jsp?gcode=<%=g.getGcode()%>">
			<img alt=" " src="<%=g.getGpic() %>" width="200" height="200" >
		</a>
		<a href="detail.jsp?gcode=<%=g.getGcode()%>">
			<h3 class="cls-title"><%=g.getGname()%></h3>
		</a>
		<a href="shop.jsp?gcode=<%=g.getGcode()%>">放入购物车</a>
</section>
<% } 
%>
</body>
<html>
