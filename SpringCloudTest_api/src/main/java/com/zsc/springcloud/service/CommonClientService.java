package com.zsc.springcloud.service;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.zsc.springcloud.bean.Items;

//@FeignClient(value="SPRINGCLOUDTEST")
@FeignClient(value="SPRINGCLOUDTEST",fallbackFactory=CommonClientServiceFallBackFactory.class)
public interface CommonClientService {

	@RequestMapping(value = "/items/add",method = RequestMethod.POST)
	public boolean add(Items items);
	
	@RequestMapping(value = "/items/get/{id}",method = RequestMethod.GET)
	public Items get(Integer id);
	
	@RequestMapping(value = "/items/list",method = RequestMethod.GET)
	public List<Items> list();
	
	@RequestMapping(value = "/items/discovery",method = RequestMethod.GET)
	public Object discovery();
}
