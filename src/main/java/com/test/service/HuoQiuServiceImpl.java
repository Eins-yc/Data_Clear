package com.test.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.test.dao.HuoQiuDao;
import com.test.entity.JSON;
@Service
public class HuoQiuServiceImpl implements HuoQiuService {
	
	@Resource
	private HuoQiuDao huoqiuDao;

	public JSON findlist(Integer page, Integer limit) {
		
		JSON json=new JSON();
		page=limit*page-limit;
		try {
			int t=huoqiuDao.findtotal();
			List l=huoqiuDao.findall(page, limit);
			json.setCode(0);
			json.setMsg("查询成功~");
			json.setCount(t);
			json.setData(l);
			return json;
		}catch(Exception e) {
			e.printStackTrace();
			json.setCode(1);
			json.setMsg(e+"");
			return json;
		}
		
		
	}

}
