package com.zsc.springcloud.service;

import java.util.List;

import com.zsc.springcloud.bean.Items;

public interface ItemsService {

    public boolean add(Items items);
	
    public Items get(Integer id);
    
    public List<Items> list();
}
