package com.zsc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.zsc.springcloud.bean.Items;
import com.zsc.springcloud.service.ItemsService;

@RestController
public class ItemsController {
	
	@Autowired
	private ItemsService itemsService;
	
	@Autowired
	DiscoveryClient discoveryClient;
	
	@RequestMapping(value = "/items/add",method = RequestMethod.POST)
	public boolean add(@RequestBody Items items) 
	{
		return itemsService.add(items);
	}
	
	@RequestMapping(value = "/items/get/{id}",method = RequestMethod.GET)
	public Items get(@PathVariable("id") Integer id) 
	{
		return itemsService.get(id);
	}
	
	@RequestMapping(value = "/items/list",method = RequestMethod.GET)
	public List<Items> list() 
	{
		return itemsService.list();
	}
	
	@RequestMapping(value = "/items/discovery",method = RequestMethod.GET)
	public Object discovery() 
	{
		List<String> list = discoveryClient.getServices();
		System.out.println("*************" + list);
		List<ServiceInstance> serviceList = discoveryClient.getInstances("SPRINGCLOUDTEST");
		for (ServiceInstance serviceInstance : serviceList) {
			System.out.println(serviceInstance.getServiceId() + "\t" + serviceInstance.getHost() + "\t" 
		    + serviceInstance.getPort() + "\t" + serviceInstance.getUri());
		}
		return this.discoveryClient;
	}
}
