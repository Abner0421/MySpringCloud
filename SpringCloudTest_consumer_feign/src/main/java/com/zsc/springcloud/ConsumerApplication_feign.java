package com.zsc.springcloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@EnableEurekaClient
//在启动该微服务的时候就能去加载我们的自定义Ribbon配置类，从而使配置生效
//@RibbonClient(name="SPRINGCLOUDTEST",configuration=MyselfRule.class)
@EnableFeignClients(basePackages = {"com.zsc.springcloud"})
@ComponentScan("com.zsc.springcloud")
public class ConsumerApplication_feign 
{
	
	public static void main(String[] args) 
	{
		SpringApplication.run(ConsumerApplication_feign.class, args);
	}

}
