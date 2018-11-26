package com.ssm.controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.pojo.Items;
import com.ssm.service.ItemsService;

@Controller
@RequestMapping("/items")
public class ItemsController {
	@Resource
	private ItemsService itemsService;

	public ItemsService getItemsService() {
		return itemsService;
	}

	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}

	@RequestMapping("selectAll")
	public String selectAll(Model model) {
		List<Items> list = itemsService.getAllItems();
		model.addAttribute("itemsList", list);
		return "/itemsList.jsp";
	}

	@RequestMapping("edit")
	public String edit(Model model, Integer id) {
		// System.out.println(id);
		Items items = itemsService.getItemsById(id);
		model.addAttribute("item", items);
		return "/editItem.jsp";
	}

	// 修改商品信息
	@RequestMapping("saveOrUpdate")
	public String saveOrUpdate(Items items) {
		System.out.println(items.getDetail());
		return "/itemsList.jsp";
	}
}
