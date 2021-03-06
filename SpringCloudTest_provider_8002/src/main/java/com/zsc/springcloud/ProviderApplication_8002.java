package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进Eureka服务中心内
@EnableDiscoveryClient //服务发现
public class ProviderApplication_8002 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(ProviderApplication_8002.class, args);
	}

}
