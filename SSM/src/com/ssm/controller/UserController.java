package com.ssm.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.ssm.service.ItemsService;

@Controller
public class UserController {
	@Resource
	private ItemsService itemsService;
	public ItemsService getItemsService() {
		return itemsService;
	}
	public void setItemsService(ItemsService itemsService) {
		this.itemsService = itemsService;
	}
	@RequestMapping("list")
	public String list(){
		System.out.println("½øÐÐÀ´ÀÕ£¡"+itemsService.getAllItems().size());
		return "/index.jsp";
	}
}
