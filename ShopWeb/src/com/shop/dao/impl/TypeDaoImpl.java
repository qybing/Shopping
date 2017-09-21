package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.TypeDao;
import com.shop.entity.Type;
import com.shop.util.DbUtil;

public class TypeDaoImpl implements TypeDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rst;
	@Override
	public List<Type> findTypes() throws Exception {
		List<Type> typeList = new ArrayList<Type>();
		conn = DbUtil.createConnection();
		String sqlStr = "select * from type";
		pstmt = conn.prepareStatement(sqlStr);
		rst = pstmt.executeQuery();
		while(rst.next()){
			Type type = new Type();
			type.setTid(rst.getInt("t_id"));
			type.setTname(rst.getString("t_name"));
			typeList.add(type);
		}
		DbUtil.close(conn);
		return typeList;
	}

}
