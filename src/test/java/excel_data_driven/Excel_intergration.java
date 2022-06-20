package excel_data_driven;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.Test;

import com.google.common.collect.Table.Cell;

public class Excel_intergration extends base.Baseclass_amazon{
	
	
	public static Workbook  book;
	public static Sheet sheet;
	
	
	public static Object[][] Exceldata (String sheetno) throws EncryptedDocumentException, IOException{
		
		FileInputStream file=null;
		try {
			file= new FileInputStream("C:\\Users\\Preet\\eclipse-workspace\\Amazon_Website\\src\\test\\java\\excel_data_driven\\AMAZON.xlsx");
		} 
		catch (FileNotFoundException e) {
	    e.printStackTrace();
		}
		
	Workbook  book = WorkbookFactory.create(file);
	
    Sheet sheet =   book.getSheet(sheetno);
		           
    
   Object data [][] = new Object[sheet.getLastRowNum()][sheet.getRow(0).getLastCellNum()];
  
   for (int i =0; i<sheet.getLastRowNum(); i++) {
	   
	              //  XSSFRow row=(XSSFRow) sheet.getRow(i);
	   for (int j=0; j<sheet.getRow(0).getLastCellNum();j++) {
		   
			/*
			 * XSSFCell cell = row.getCell(j);
			 * 
			 * 
			 * switch(cell.getCellType()) { case STRING : cell.getStringCellValue(); break;
			 * case NUMERIC :cell.getNumericCellValue(); break; case BOOLEAN :
			 * cell.getBooleanCellValue(); break; }
			 */
		          data[i][j]= sheet.getRow(i+1).getCell(j).toString();
		   
	
		   
	   }
 
   }
	
		return data;
		
	}
public static Object[][] Exceldataupdated (String sheetno) throws EncryptedDocumentException, IOException{
		
		FileInputStream file=null;
		try {
			file= new FileInputStream("C:\\Users\\Preet\\eclipse-workspace\\Amazon_Website\\src\\test\\java\\excel_data_driven\\AMAZON.xlsx");
		} 
		catch (FileNotFoundException e) {
	    e.printStackTrace();
		}
		
	Workbook  book = WorkbookFactory.create(file);
	
    Sheet sheet =   book.getSheet(sheetno);
		           
    int row = sheet.getLastRowNum();
    int cell = sheet.getRow(0).getLastCellNum();
    
   Object data [][] = new Object[row][cell];
  
   for (int i =0; i<row; i++) {
	   
	              //  XSSFRow row=(XSSFRow) sheet.getRow(i);
	   for (int j=0; j<cell ;j++) {
		   
		       String celldata =   sheet.getRow(i+1).getCell(j).toString();
		       data[i][j]= celldata;
	
	   
	   }
 
	   
	   
   }
	
	
		return data;
		
	}

}
