package com.ly.spring.spring03.t.service;

import com.ly.spring.spring03.t.dao.BaseDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class BaseService<T> {

	@Autowired
	protected BaseDao<T> baseDao;
	
	public void save() {
		System.out.println("正在保存");
		System.out.println(baseDao);
	}
}
