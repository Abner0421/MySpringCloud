package com.zsc.springcloud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.zsc.springcloud.bean.Items;

@RestController
public class ConsumerController {
	
	//private static final String REST_URL_PREFIX = "http://localhost:8001";
	private static final String REST_URL_PREFIX = "http://SPRINGCLOUDTEST"; //客户端注册进eureka以后，并通过负载均衡算法，不用再去访问具体的IP和端口了

	@Autowired
	private RestTemplate restTemplate;
	
	@RequestMapping("/consumer/items/add")
	public boolean add(Items items) 
	{
		return restTemplate.postForObject(REST_URL_PREFIX+"/items/add", items, Boolean.class);
	}
	
	@RequestMapping("/consumer/items/get/{id}")
	public Items get(@PathVariable("id") Integer id) 
	{
		return restTemplate.getForObject(REST_URL_PREFIX+"/items/get/"+id,Items.class);
	}
	
	@SuppressWarnings("unchecked")
	@RequestMapping("/consumer/items/list")
	public List<Items> list() 
	{
		return restTemplate.getForObject(REST_URL_PREFIX+"/items/list",List.class);
	}
	
	//测试@EnableDiscoveryClient,消费端可以调用服务发现
	@RequestMapping("/consumer/items/discovery")
	public Object discovery() 
	{
		return restTemplate.getForObject(REST_URL_PREFIX+"/items/discovery", Object.class);
	}
}
