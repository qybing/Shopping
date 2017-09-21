<%@page import="java.net.URLEncoder"%>
<%@page import="org.apache.tomcat.jni.Local"%>
<%@page import="com.shop.biz.impl.UserBizImpl"%>
<%@page import="com.shop.entity.User"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	int num = 0;
	request.setCharacterEncoding("utf-8");
	// 获取账号密码
	String uname = request.getParameter("uname");
	String upwd = request.getParameter("upwd");
	
	// 查询用户是否存在
	User user = new User();
	UserBizImpl userBiz = new UserBizImpl();
	user = userBiz.findUser(uname, upwd);
	
	// 若用户不存在
	
	if(user == null){
		request.setAttribute("msg", "用户名或密码错误");
		request.getRequestDispatcher("index.jsp").forward(request, response);
		
	}else{
		// 判断用户是否记住密码
		String save = request.getParameter("rebpwd");
		if("save".equals(save)){
			// 创建cookie对象
			Cookie cname = new Cookie("uname",URLEncoder.encode(uname,"utf-8"));
			Cookie cpwd = new Cookie("upwd",upwd);
			// 设置有效时间
			cname.setMaxAge(60);
			cpwd.setMaxAge(60);
			// 利用response传送至客户端
			response.addCookie(cname);
			response.addCookie(cpwd);
		}
		
		session.setAttribute("user", user);
		response.sendRedirect("doMenu.jsp");
		
	}
%>