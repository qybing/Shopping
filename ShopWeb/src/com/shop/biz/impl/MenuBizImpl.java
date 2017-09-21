package com.shop.biz.impl;

import java.sql.Connection;
import java.util.List;

import com.shop.biz.MenuBiz;
import com.shop.dao.MenuDao;
import com.shop.dao.impl.MenuDaoImpl;
import com.shop.entity.Menu;
import com.shop.entity.User;
import com.shop.util.DbUtil;

public class MenuBizImpl implements MenuBiz {
	private MenuDao menuDao = new MenuDaoImpl();
	@Override
	public List<Menu> findMenuByUser(User user) throws Exception {
		Connection conn = DbUtil.createConnection();
		List<Menu> menuList = menuDao.findMenuByUser(user);
		DbUtil.close(conn);
		return menuList;
	}

}
