package com.test.controller;


import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import com.test.entity.JSON;
import com.test.service.HuoQiuService;

@Controller
@RequestMapping("/hq")
public class HuoQiuController {
	
	@Resource
	private HuoQiuService huoqiuService;
	
	
	@RequestMapping("/list.do")
	@ResponseBody
	public JSON findall(Integer page,Integer limit) {
		JSON json=huoqiuService.findlist(page, limit);
		return json;
		
	}

}
