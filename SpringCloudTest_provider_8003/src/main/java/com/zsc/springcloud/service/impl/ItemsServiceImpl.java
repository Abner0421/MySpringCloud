package com.zsc.springcloud.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.zsc.springcloud.bean.Items;
import com.zsc.springcloud.dao.ItemsMapper;
import com.zsc.springcloud.service.ItemsService;

@Service
public class ItemsServiceImpl implements ItemsService {
	@Autowired
	private ItemsMapper itemsMapper;

	@Override
	public boolean add(Items items) throws Exception {
		return itemsMapper.insert(items);
	}

	@Override
	public Items get(Integer id) throws Exception {
		return itemsMapper.selectByPrimaryKey(id);
	}

	@Override
	public List<Items> list() throws Exception {
		return itemsMapper.getAllItems();
	}

}
