package com.shop.test;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.shop.biz.BookBiz;
import com.shop.biz.MenuBiz;
import com.shop.biz.UserBiz;
import com.shop.biz.impl.BookBizImpl;
import com.shop.biz.impl.MenuBizImpl;
import com.shop.biz.impl.UserBizImpl;
import com.shop.entity.Book;
import com.shop.entity.Menu;
import com.shop.entity.User;

public class test {
	private static UserBiz userBiz = new UserBizImpl();
	private static MenuBiz menuBiz = new MenuBizImpl();
	private static BookBiz bookBiz = new BookBizImpl();
	
	public static void main(String[] args) {
		try {
//			findUser();
//			findMenus();
			findBooks();
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

	}
	public static User findUser() throws Exception{
		String uname = "admin";
		String upwd = "123456";
		
		User user = userBiz.findUser(uname, upwd);
		if(user==null){
			System.out.println("”√ªß√˚ªÚ√‹¬Î¥ÌŒÛ");
			return null;
		}
		return user;	
	}
	
	public static void findMenus() throws Exception{
		User user = findUser();
		List<Menu> menuList = menuBiz.findMenuByUser(user); 
		for(Menu m : menuList){
			System.out.println(m.getMname());
		}
	}
	
	public static void findBooks() throws Exception{
		Book book = new Book();
		book.setMinPrice(30);
		book.setMaxPrice(50);
		List<Book> bookList = bookBiz.findBooks(1,book);
		for(Book b: bookList)
			System.out.println(b.getBname());
	}
	
	public static void mapTest(){
		Map<Integer, String> maps = new HashMap<>();
		maps.put(1, "Œ‚“‡∑≤");
		maps.put(2, "¡ı”¢ø°");
		maps.put(3, "Œ‚—Â◊Ê");
		
		
	}
}
