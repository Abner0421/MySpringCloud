package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@SpringCloudApplication
@EnableZuulProxy
public class ZuulGatewayApplication_9527 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(ZuulGatewayApplication_9527.class, args);
	}

}
