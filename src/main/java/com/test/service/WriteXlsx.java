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
 * д��xlsx�ļ�
 * @author xueyuchi
 *
 */
public class WriteXlsx {
	
	public static void main(String[] args) {
		
		
		try {
			String filePath="D:\\test.xlsx";
			InputStream is = new FileInputStream(filePath);
			// ���� XSSFWorkbook ����strPath �����ļ�·�� 
            XSSFWorkbook xwb = new XSSFWorkbook(is); 
            // ��ȡ��һ�±������ 
            XSSFSheet sheet = xwb.getSheetAt(0); 
            
            
            
            
            //��ӱ�ͷ  
            Row row = sheet.createRow(0);
            Cell cell = row.createCell(0);
            
            
            row = sheet.createRow(1);    //�����ڶ���
            cell=row.createCell(1);
            cell.setCellValue("��������");
           
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
