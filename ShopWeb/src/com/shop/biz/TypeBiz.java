package com.shop.biz;

import java.util.List;

import com.shop.entity.Type;

public interface TypeBiz {
	public List<Type> findTypes() throws Exception;
}
