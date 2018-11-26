package com.ssm.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.ssm.mapper.ItemsMapper;
import com.ssm.pojo.Items;
import com.ssm.service.ItemsService;
@Service
public class ItemsServiceImpl implements ItemsService {
	@Resource
	private ItemsMapper itemsMapper;
	public ItemsMapper getItemsMapper() {
		return itemsMapper;
	}
	public void setItemsMapper(ItemsMapper itemsMapper) {
		this.itemsMapper = itemsMapper;
	}
	@Override
	public List<Items> getAllItems() {
		return itemsMapper.getAllItems();
	}
	@Override
	public Items getItemsById(int id) {
		return itemsMapper.getItemsById(id);
	}

}
