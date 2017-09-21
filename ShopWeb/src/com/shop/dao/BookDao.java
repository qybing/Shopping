package com.shop.dao;

import java.util.List;

import com.shop.entity.Book;

public interface BookDao {
	
	// 根据条件查询所有图书
	public List<Book> findBooks(int page,Book book) throws Exception;
	
	public int findBooksPages(Book book) throws Exception;

	
}	
