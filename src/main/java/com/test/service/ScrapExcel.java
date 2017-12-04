package com.test.service;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.springframework.stereotype.Service;

@Service
public class ScrapExcel {
	
	String[] excelHeader = { "开始日期", "结束日期"};
	
	public HSSFWorkbook exportSC(List<String> ls){
		System.out.println(ls);
		HSSFWorkbook scwb = new HSSFWorkbook();
		HSSFSheet sheet = scwb.createSheet("数据");
		HSSFRow row = sheet.createRow((int) 0);		 
		HSSFCellStyle style = scwb.createCellStyle();
		
		for (int i = 0; i < excelHeader.length; i++){
			 HSSFCell cell = row.createCell(i);
			 cell.setCellValue(excelHeader[i]);    
	         cell.setCellStyle(style);    
	         sheet.autoSizeColumn(i, true);	         	         
		 }
		
		
		for (int i = 0; i < ls.size(); i++){
			row = sheet.createRow(i + 1);
			
			row.createCell(0).setCellValue(ls.get(0));
			row.createCell(1).setCellValue(ls.get(1));
			
			
		}
		
		return scwb;
		
	}

}
