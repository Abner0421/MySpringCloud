package com.zsc.springcloud.service;

import java.util.List;

import com.zsc.springcloud.bean.Items;

public interface ItemsService {

    public boolean add(Items items)throws Exception;
	
    public Items get(Integer id) throws Exception;
    
    public List<Items> list() throws Exception;
}
