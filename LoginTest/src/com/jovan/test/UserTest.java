package com.jovan.test;

import com.jovan.service.UserService;

public class UserTest {
	public static void main(String[] args) {
		String user_id="1";
		String user_pwd="1";
		UserService user = new UserService();
		System.out.println(user.Login(user_id, user_pwd));
	}

}
