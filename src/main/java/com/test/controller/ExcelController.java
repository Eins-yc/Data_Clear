package com.test.controller;

import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.test.service.ScrapExcel;

@Controller
@RequestMapping("/ex")
public class ExcelController {
	@Autowired
	ScrapExcel scrapExcel;
	
	
	@RequestMapping("/file.do")
	@ResponseBody
	public void excelWrite(HttpServletRequest request, HttpServletResponse response,String stime,String otime) {
		//System.out.println(stime+"---"+otime);
		try{
			List<String> list=new ArrayList<String>();
			list.add(stime);
			list.add(otime);
		
			HSSFWorkbook scwb=scrapExcel.exportSC(list);
			//HSSFWorkbook scwb=scrapExcel.exportSC(list);
			response.setContentType("application/vnd.ms-excel");
			response.setCharacterEncoding("utf-8"); 
			response.setHeader("Content-disposition", "attachment;filename=ScrapData.xls");
			OutputStream ouputStream = response.getOutputStream();    
			scwb.write(ouputStream);
			ouputStream.flush();    
			ouputStream.close();
			}catch(Exception e){
				e.printStackTrace();
			}
		
		}

	
	
}
