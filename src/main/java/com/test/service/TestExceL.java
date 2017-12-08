package com.test.service;

import java.io.FileInputStream;
import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;

public class TestExceL {
	
	
	
	public static void main(String[] args) throws Exception{
		
		FileInputStream fs=new FileInputStream("d://test.xls"); //��ȡd://test.xls  
		POIFSFileSystem ps=new POIFSFileSystem(fs);//ʹ��POI�ṩ�ķ����õ�excel����Ϣ  
		HSSFWorkbook wb=new HSSFWorkbook(ps);    
		HSSFSheet sheet=wb.getSheetAt(0); //��ȡ����������Ϊһ��excel�����ж��������  
		HSSFRow row=sheet.getRow(0); //��ȡ��һ�У�excel�е���Ĭ�ϴ�0��ʼ�����������Ϊʲô��һ��excel�������ֶ���ͷ���������ֶ���ͷ�����ڸ�ֵ  
		//System.out.println(row);
		//System.out.println(sheet.getLastRowNum()+" "+row.getLastCellNum());
		
		FileOutputStream out=new FileOutputStream("d://test.xls");  
		row=sheet.createRow((short)(sheet.getLastRowNum()+1)); //�������кź�׷������  
        row.createCell(0).setCellValue("һ1������"); //���õ�һ������0��ʼ����Ԫ�������  
        row.createCell(1).setCellValue(24);//���õڶ�������0��ʼ����Ԫ�������  
        
        out.flush();  
        wb.write(out);    
        out.close();
		
		
		
	}
	
	
	

}
