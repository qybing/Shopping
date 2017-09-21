package com.shop.biz.impl;

import java.sql.Connection;
import java.util.List;

import com.shop.biz.TypeBiz;
import com.shop.dao.TypeDao;
import com.shop.dao.impl.TypeDaoImpl;
import com.shop.entity.Type;
import com.shop.util.DbUtil;

public class TypeBizImpl implements TypeBiz {
	TypeDao typeDao = new TypeDaoImpl();
	
	@Override
	public List<Type> findTypes() throws Exception {
		Connection conn = DbUtil.createConnection();
		List<Type> typeList = typeDao.findTypes();
		DbUtil.close(conn);
		return typeList;
	}

}
