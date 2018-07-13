package com.zsc.springcloud.cfgbean;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ConfigBean {

	@Bean
	//Spring Cloud Ribbon是基于Netflix Ribbon实现的一套客户端   负载均衡工具
	@LoadBalanced  //客户端通过RestTemplate自带负载均衡的去访问服务注册中心（集群环境）
	public RestTemplate getRestTemplate() 
	{
		return new RestTemplate();
	}
	
//	@Bean
//	IRule myRule() 
//	{
//		return new RandomRule(); // 达到的目的，用我们重新选择的随机算法替代默认的轮询算法。
//		//return new RetryRule(); // 达到的目的，用我们重新选择的重试算法替代默认的轮询算法。
//	}
}
