package com.shop.dao;

import java.util.List;

import com.shop.entity.Book;

public interface BookDao {
	
	// ����������ѯ����ͼ��
	public List<Book> findBooks(int page,Book book) throws Exception;
	
	public int findBooksPages(Book book) throws Exception;

	
}	
