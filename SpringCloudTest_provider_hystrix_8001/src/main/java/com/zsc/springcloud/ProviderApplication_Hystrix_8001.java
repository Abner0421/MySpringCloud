package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;


@SpringBootApplication
@EnableEurekaClient //本服务启动后会自动注册进Eureka服务中心内
@EnableDiscoveryClient //服务发现
@EnableHystrixDashboard
@EnableCircuitBreaker //对Hystrix熔断机制的支持
public class ProviderApplication_Hystrix_8001 
{
	public static void main(String[] args) 
	{
		SpringApplication.run(ProviderApplication_Hystrix_8001.class, args);
	}

}
