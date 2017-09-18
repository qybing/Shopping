package com.jovan.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.jovan.entity.User;
import com.jovan.util.DbUtil;


public class UserService {
	public User Login(String user_id,String user_pwd){
		Connection con = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		  try {
			  con = DbUtil.getConnection();
			  String sql = "select * from users where user_id=? and user_pwd=?";
			  stmt = con.prepareStatement(sql);
			  stmt.setString(1, user_id);
			  stmt.setString(2, user_pwd);
			  rs = stmt.executeQuery();
			  if(rs.next()){
<<<<<<< HEAD
				  User u = new User(0, rs.getString("user_id"),
						  rs.getString("user_pwd"), 0);
=======
				  Users u = new Users(rs.getString("user_id"),rs.getString("user_pwd"),
						  rs.getString("phone"),rs.getInt("is_admin"));
>>>>>>> 678956727558584da35a1124efadf4707576dad5
				  System.out.println("�û���"+rs.getString("user_id")+"��¼�ɹ�");
//				  System.out.println(rs.getString("user_pwd"));
//				  System.out.println("��¼�ɹ�");
				  return u;
			  }
			  else{
				  System.out.println("��¼ʧ��");
			  }
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		  
		  return null;
	  }
}
