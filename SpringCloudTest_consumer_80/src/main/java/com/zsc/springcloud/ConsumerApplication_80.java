package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="SPRINGCLOUDTEST",configuration=MyselfRule.class)
public class ConsumerApplication_80 
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(ConsumerApplication_80.class, args);
	}

}
