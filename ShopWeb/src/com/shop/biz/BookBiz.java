package com.shop.biz;

import java.util.List;

import com.shop.entity.Book;

public interface BookBiz {
	public List<Book> findBooks(int page, Book book) throws Exception;

}
