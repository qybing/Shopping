package com.newcapect.eshop.service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.newcapect.eshop.entity.DbUtil;
import com.newcapect.eshop.entity.Order;
import com.newcapect.eshop.entity.OrderItem;
public class OrderService {
	public int placeOrder(Order order,List<OrderItem> items){
	int rows = 0;
	int ocode = 0;
	Connection con = null;
	PreparedStatement stmt = null;
	try {
		con = DbUtil.getConnection();
		/*
		 * ��Ĭ����Ϊ��������ִ���κ�һ���޸Ĳ��������Ὺ��һ������
		 * �����޸Ľ������ύ����
		 * setAutoCommit���ܹر�Ĭ������
		 * 
		 */
		con.setAutoCommit(false);
		String sql = "insert into t_orders(ucode,uname,rname,rtel,raddr,odate,amount) values(?,?,?,?,?,?,?)";
		stmt = con.prepareStatement(sql,PreparedStatement.RETURN_GENERATED_KEYS);
		stmt.setInt(1, order.getOcode());
		stmt.setString(2, order.getUname());
		stmt.setString(3, order.getRname());
		stmt.setString(4, order.getRtel());
		stmt.setString(5, order.getRaddr());
		stmt.setDate(6, order.getOdate());
		stmt.setDouble(7, order.getAmount());
		rows += stmt.executeUpdate();
		// �õ��Զ������Ķ������
		ResultSet keys = stmt.getGeneratedKeys();
		keys.next();
		ocode = keys.getInt(1);
		System.out.println("���飺"+ocode);
		stmt.close();
//		if (rows>0){
//			throw new Exception("���ݲ����쳣");
//		}
		for(OrderItem item:items){
		sql = "insert into t_oitems(ocode,gcode,gname,gprice,gcount) values(?,?,?,?,?)";
		stmt = con.prepareStatement(sql);
		stmt.setInt(1, ocode);
		stmt.setInt(2, item.getGcode());
		stmt.setString(3, item.getGname());
		stmt.setDouble(4, item.getGprice());
		stmt.setInt(5, item.getGcount());
		rows += stmt.executeUpdate();
		}
		con.commit();
	} catch (Exception e) {
		try {
			con.rollback();
		} catch (SQLException e1) {
			e1.printStackTrace();
		}
		e.printStackTrace();
	}finally{
	try {
		con.close();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
	return rows; 
}
}
