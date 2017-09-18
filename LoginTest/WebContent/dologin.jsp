<%@page import="com.jovan.entity.User"%>
<%@page import="com.jovan.biz.impl.UserBizImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	 //第一步：设置编码格式
      request.setCharacterEncoding("UTF-8");
      //第二步：获取页面信息（获取用户输入的账号，密码）
      String account = request.getParameter("user_id");
	  String pwd = request.getParameter("user_pwd");
	  //检查用户
	 //第三步：调用业务类。
	  UserBizImpl userbizimpl = new  UserBizImpl();
	  User user = userbizimpl.login(account, pwd);
	  //第四：跳转页面。
	  if(user==null){
		  session.setAttribute("error", "用户账号或密码错误");
		  request.getRequestDispatcher("login.jsp").forward(request, response);
	  }
	  else{
		   session.setAttribute("user", user);
		  /*  System.out.println(user); */
		   response.sendRedirect("doadmin.jsp");
	  }

%>
