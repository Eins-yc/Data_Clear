package com.test.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * 写入xlsx文件
 * @author xueyuchi
 *
 */
public class WriteXlsx {
	
	public static void main(String[] args) {
		
		
		try {
			String filePath="D:\\test.xlsx";
			InputStream is = new FileInputStream(filePath);
			// 构造 XSSFWorkbook 对象，strPath 传入文件路径 
            XSSFWorkbook xwb = new XSSFWorkbook(is); 
            // 读取第一章表格内容 
            XSSFSheet sheet = xwb.getSheetAt(0); 
            
            
            
            
            //添加表头  
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            
            
            row = sheet.createRow(1);    //创建第二行
            cell=row.createCell(1);
            cell.setCellValue("呜呜呜呜");
           
            sheet.setColumnWidth(1, 20 * 256); 
            
            FileOutputStream out=new FileOutputStream("d://test.xlsx");  
            out.flush();
            
            xwb.write(out); 
            out.close();
            
            
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
