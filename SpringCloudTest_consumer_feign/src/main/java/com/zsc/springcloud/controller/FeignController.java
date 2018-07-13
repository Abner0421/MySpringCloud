package com.zsc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.zsc.springcloud.bean.Items;
import com.zsc.springcloud.service.CommonClientService;

@RestController
public class FeignController {
	
	@Autowired
	private CommonClientService commonClientService;
	
	@RequestMapping("/consumer/items/add")
	public boolean add(Items items) 
	{
		return commonClientService.add(items);
	}
	
	@RequestMapping("/consumer/items/get/{id}")
	public Items get(@PathVariable("id") Integer id) 
	{
		return commonClientService.get(id);
	}
	
	@RequestMapping("/consumer/items/list")
	public List<Items> list() 
	{
		return commonClientService.list();
	}
	
	//测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping("/consumer/items/discovery")
	public Object discovery() 
	{
		return commonClientService.discovery();
	}
}
