package com.newcapect.eshop.test;

import java.util.List;

import com.newcapect.eshop.entity.Goods;
import com.newcapect.eshop.service.GoodsService;

public class GoodsServiceTest {

	public static void main(String[] args) {
		String gname = "╣фещ";
		GoodsService gs = new GoodsService();
		List<Goods> list = gs.findGoodsByTitle(gname);
		for (Goods g : list){
			System.out.println(g.getGname());
			System.out.println(g.getGcode());
		}

	}

}
