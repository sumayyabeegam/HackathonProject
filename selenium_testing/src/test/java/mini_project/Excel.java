package mini_project;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Excel 

	 {
		 public static String getExcelData() throws IOException {
			 //path of Excel file
			 String s=System.getProperty("user.dir")+"\\Excel"+"\\TESTDATA.xlsx";
			 // creating the FileInputStream to read the Excel file
			 FileInputStream file=new FileInputStream(s);
			 //To create a workbook instance
			 XSSFWorkbook work=new XSSFWorkbook(file);
			 //to access first sheet in workbook
			 XSSFSheet sheet=work.getSheetAt(0);
			 //To access first row
			 XSSFRow row=sheet.getRow(0);
			 //To access first cell
			 XSSFCell cell=row.getCell(0);
			 
			
	String data=cell.toString();
	         return data;
		 }
		

	}


