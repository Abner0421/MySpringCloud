package com.zsc.springcloud.service;

import java.util.List;

import org.springframework.stereotype.Component;

import com.zsc.springcloud.bean.Items;

import feign.hystrix.FallbackFactory;

@Component //不要忘记添加！！不要忘记添加！！
public class CommonClientServiceFallBackFactory implements FallbackFactory<CommonClientService>{

	@Override
	public CommonClientService create(Throwable throwable) {
		return new CommonClientService() 
		{
			@Override
			public boolean add(Items items) {
				return false;
			}

			@Override
			public Items get(Integer id) {
				return new Items().setId(id).setItemsName("该ID:" + id + "没有对应的信息,Consumer客户端提供了降级信息,此刻服务Provider已经关闭")
						   .setDataSource("no this database in MySQL");
			}

			@Override
			public List<Items> list() {
				return null;
			}

			@Override
			public Object discovery() {
				return null;
			}
		};
	}

}
