package com.shop.dao;

import java.util.List;

import com.shop.entity.Type;

public interface TypeDao {
	public List<Type> findTypes() throws Exception;
}
