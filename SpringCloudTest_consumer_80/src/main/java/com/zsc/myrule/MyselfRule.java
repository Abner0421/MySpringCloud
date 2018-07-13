package com.zsc.myrule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.netflix.loadbalancer.IRule;
import com.zsc.myrule.RoundRule_ZSC;

@Configuration
public class MyselfRule {

	@Bean
	IRule myRule() 
	{
		return new RoundRule_ZSC(); // 用我们自定义的算法替代默认的轮询算法。
		                            // 我们自定义的算法机制是基于轮询策略，将每个服务机器访问一次改造为每个服务机器器访问5次
	}
}
