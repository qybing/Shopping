<%@page import="com.shop.entity.Type"%>
<%@page import="com.shop.biz.impl.TypeBizImpl"%>
<%@page import="com.shop.entity.Book"%>
<%@page import="java.util.List"%>
<%@page import="com.shop.biz.impl.BookBizImpl"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<% 
	request.setCharacterEncoding("utf-8");
	
	int nowpage = 1;  
	String typeId = request.getParameter("typeId");
	String bname = request.getParameter("bname");
	String minprice = request.getParameter("minPrice");
	String maxprice = request.getParameter("maxPrice");
	
	Book book = new Book();
	if(typeId!=null && !typeId.equals("-1"))
		book.setBtype(Integer.parseInt(typeId));
	if(bname!=null && !bname.equals(""))
		book.setBname(bname);
	if(minprice!=null && !minprice.equals(""))
		book.setMinPrice(Integer.parseInt(minprice));
	if(maxprice!=null && !maxprice.equals(""))
		book.setMaxPrice(Integer.parseInt(maxprice));
	
	BookBizImpl bookBiz = new BookBizImpl();
	TypeBizImpl typeBiz = new TypeBizImpl();
	
	List<Book> bookList = bookBiz.findBooks(nowpage, book);
	List<Type> typeList = typeBiz.findTypes();
	
	session.setAttribute("bookList", bookList);
	session.setAttribute("typeList", typeList);
	session.setAttribute("book", book);
	request.getRequestDispatcher("findBooks.jsp").forward(request, response);
%>