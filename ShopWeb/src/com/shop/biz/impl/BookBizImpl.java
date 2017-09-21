package com.shop.biz.impl;

import java.sql.Connection;
import java.util.List;

import com.shop.biz.BookBiz;
import com.shop.dao.BookDao;
import com.shop.dao.impl.BookDaoImpl;
import com.shop.entity.Book;
import com.shop.util.DbUtil;

public class BookBizImpl implements BookBiz {
	private BookDao bookDao = new BookDaoImpl();
	
	@Override
	public List<Book> findBooks(int page,Book book) throws Exception {
		Connection conn = DbUtil.createConnection();
		List<Book> bookList = bookDao.findBooks(page,book);
		DbUtil.close(conn);
		return bookList;
	}

}
