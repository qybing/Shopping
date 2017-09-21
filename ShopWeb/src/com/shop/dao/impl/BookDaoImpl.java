package com.shop.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.shop.dao.BookDao;
import com.shop.entity.Book;
import com.shop.util.DbUtil;

public class BookDaoImpl implements BookDao {
	private Connection conn;
	private PreparedStatement pstmt;
	private ResultSet rst;
	
	@Override
	public List<Book> findBooks(int page, Book book) throws Exception {
		List<Book> bookList = new ArrayList<Book>();
		conn = DbUtil.createConnection();
		String sqlStr = "select * from (select b.* from book_info b where 1=1";
		if(book!=null){
			if(book.getBname()!=null)
				sqlStr += " and b_name like '%" + book.getBname() +"%' ";
			if(book.getBtype()!=null)
				sqlStr += " and b_type = " + book.getBtype();
			if(book.getMinPrice()!=null)
				sqlStr += " and b_price >= " + book.getMinPrice();
			if(book.getMaxPrice()!=null)
				sqlStr += " and b_price <= " + book.getMaxPrice();
		}
		sqlStr += ") temp limit ?,6";
		pstmt = conn.prepareStatement(sqlStr);
		pstmt.setInt(1, (page-1)*6);
		rst = pstmt.executeQuery();
		
		while(rst.next()){
			Book b = new Book();
			b.setBid(rst.getInt("b_id"));
			b.setBauthor(rst.getString("b_author"));
			b.setBcomment(rst.getString("b_comment"));
			b.setBname(rst.getString("b_name"));
			b.setBnumber(rst.getInt("b_number"));
			b.setBprice(rst.getDouble("b_price"));
			b.setBtype(rst.getInt("b_type"));
			bookList.add(b);
		}
		return bookList;
	}
	
	@Override
	// ×ÜÒ³Êý
	public int findBooksPages(Book book) throws Exception {
		conn = DbUtil.createConnection();
		String sqlStr = "select count(1) as ts from book_info where 1=1";
		if(book!=null){
			if(book.getBname()!=null)
				sqlStr += " and b_name like '%" + book.getBname() +"%' ";
			if(book.getBtype()!=null)
				sqlStr += " and b_type = " + book.getBtype();
			if(book.getMinPrice()!=null)
				sqlStr += " and b_price >= " + book.getMinPrice();
			if(book.getMaxPrice()!=null)
				sqlStr += " and b_price <= " + book.getMaxPrice();

		}
		pstmt = conn.prepareStatement(sqlStr);
		rst = pstmt.executeQuery();
		int rows = rst.getInt("ts");
		if(rows%6==0)
			return rows/6;
		return rows/6+1;
	}

}
