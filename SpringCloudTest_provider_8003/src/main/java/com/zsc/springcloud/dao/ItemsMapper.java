package com.zsc.springcloud.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.zsc.springcloud.bean.Items;

@Mapper
public interface ItemsMapper {
	
	boolean insert(Items items)throws Exception;
	
    Items selectByPrimaryKey(Integer id) throws Exception;
    
    List<Items> getAllItems() throws Exception;
}

