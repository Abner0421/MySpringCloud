package com.zsc.springcloud.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
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
		boolean flag = false;
		try {
			flag =  itemsService.add(items);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return flag;
	}
	
	@RequestMapping(value = "/items/get/{id}",method = RequestMethod.GET)
	//一旦调用服务方法失败并抛出了错误信息后，会自动调用@HystrixCommand标注好的fallbackMethod调用类中的指定方法
	@HystrixCommand(fallbackMethod = "processHystrix_Get")
	public Items get(@PathVariable("id") Integer id) 
	{
		Items dept = itemsService.get(id);
		if(dept == null) 
		{
			throw new RuntimeException("该ID:" + id + "没有对应的信息");
		}
		return dept;
	}
	
	@RequestMapping(value = "/items/list",method = RequestMethod.GET)
	public List<Items> list() 
	{
		List<Items> deptList = new ArrayList<Items>();
		try {
			deptList =  itemsService.list();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return deptList;
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
	
	public Items processHystrix_Get(@PathVariable("id") Integer id) 
	{
		return new Items().setId(id).setItemsName("该ID:" + id + "没有对应的信息,null--@HystrixCommand")
				   .setDataSource("no this database in MySQL");
	}
}
