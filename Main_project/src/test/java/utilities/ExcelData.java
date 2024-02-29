package utilities;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelData {
	public static void write(String sheetName, int rowno, int colno, String data) throws IOException{
		FileInputStream file = new FileInputStream(System.getProperty("user.dir")+"\\ExcelSheet\\output.xlsx");
		XSSFWorkbook book = new XSSFWorkbook(file);
		//Creating the sheet if it does not exist
		if(book.getSheetIndex(sheetName)==-1) {
			book.createSheet(sheetName);
		}
		XSSFSheet sheet = book.getSheet(sheetName);
		if(sheet.getRow(rowno)==null) {
			sheet.createRow(rowno);
		}
		XSSFRow row = sheet.getRow(rowno);
		XSSFCell cell = row.createCell(colno);
		cell.setCellValue(data);
		FileOutputStream fo = new FileOutputStream(System.getProperty("user.dir")+"\\ExcelSheet\\output.xlsx");
		book.write(fo);
		book.close();
		file.close();
		fo.close();
	}
 
		
	}
