package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.MenuDao;
import com.shop.entity.Menu;
import com.shop.entity.User;
import com.shop.util.DbUtil;

public class MenuDaoImpl implements MenuDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rst;
	
	@Override
	public List<Menu> findMenuByUser(User user) throws Exception {
		List<Menu> menuList = new ArrayList<>();
		conn = DbUtil.createConnection();
		String sqlStr = "select * from Menu where u_level = ?";
		pstmt = conn.prepareStatement(sqlStr);
		pstmt.setInt(1, user.getUlevel());
		rst = pstmt.executeQuery();
		while(rst.next()){
			Menu menu = new Menu();
			menu.setMid(rst.getInt("m_id"));
			menu.setMname(rst.getString("m_name"));
			menu.setUlevel(rst.getInt("u_level"));
			menu.setAddress(rst.getString("m_address"));
			menuList.add(menu);
		}
		return menuList;
	}

}
