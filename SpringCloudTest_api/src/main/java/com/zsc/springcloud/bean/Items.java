package com.zsc.springcloud.bean;

import java.io.Serializable;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Accessors(chain=true)
public class Items implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer id;
	private String itemsCode;
	private String itemsName;
	private Integer status;
	private String createDate;
	private String modifyDate;
	private String dataSource;
	
}
