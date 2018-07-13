package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class ConsumerApplication_Hystrix_Dashboard 
{

	public static void main(String[] args) 
	{
		SpringApplication.run(ConsumerApplication_Hystrix_Dashboard.class, args);
	}

}
