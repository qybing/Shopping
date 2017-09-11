package com.newcapect.eshop.test;

import com.newcapect.eshop.service.UserService;

public class UserTset {

	public static void main(String[] args) {
		UserService us =new UserService();
		int id = 1 ;
		String old = "123321";
		String first = "admin";
		String second ="admin";
		int rs=us.changePassword(id, old, first, second);
		if(rs > 0){
			System.out.println("ÃÜÂëĞŞ¸Ä³É¹¦£¡");
		}
		

	}

}
