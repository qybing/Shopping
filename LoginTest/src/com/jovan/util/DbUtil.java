package com.jovan.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.jdbc.PreparedStatement;

public class DbUtil {
	private static String user = "root";
	private static String password = "123456";
	private static String url = "jdbc:mysql://localhost:3306/market?characterEncoding=utf-8";
	public static Connection getConnection(){
		 try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				e.printStackTrace();
			}	
		    Connection conn=null;
		    try {
				conn = DriverManager.getConnection(url,user,password);
			    return conn;
		 } catch (SQLException e) {
				e.printStackTrace();
			}
		    return null;
	}
	public static void closeConn(ResultSet rs,PreparedStatement pstmt,Connection conn){
        
        try {
            if (rs!=null) {//������صĽ����������Ϊ��,�͹ر�����
                rs.close();
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            if (pstmt!=null) {
                pstmt.close();//�ر�Ԥ�������
            }
        } catch (Exception e) {
            
            e.printStackTrace();
        }
        
        try {
            
            if (conn!=null) {
                conn.close();//�رս��������
            }
            
        } catch (Exception e) {
            
            e.printStackTrace();
        }
    }

	public static void setUser(String user) {
			DbUtil.user = user;
		}
	public static void setPassword(String password) {
			DbUtil.password = password;
		}
	public static void setUrl(String url) {
			DbUtil.url = url;
		}
		
	}