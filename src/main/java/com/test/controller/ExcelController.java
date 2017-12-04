package com.test.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/ex")
public class ExcelController {
	
	
	
	@RequestMapping("/file.do")
	@ResponseBody
	public String excelWrite(String stime,String otime) {
		System.out.println(stime+"---"+otime);
		return "OK";
	}

}
