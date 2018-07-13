package com.zsc.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zsc.springcloud.bean.Items;

@Mapper
public interface ItemsMapper {
	
	boolean insert(Items items);
	
    Items selectByPrimaryKey(Integer id);
    
    List<Items> getAllItems();
}

