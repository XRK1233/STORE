package com.ssm.service;

import java.util.List;

import com.ssm.pojo.Items;

public interface ItemsService {
	//获取所有的商品信息
	List<Items> getAllItems();
	//根据id查询某个商品并回显
	Items getItemsById(int id);
}
