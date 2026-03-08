package day40;

import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDataIntoExcel {

	public static void main(String[] args) throws IOException {

		FileOutputStream file= new FileOutputStream(System.getProperty("user.dir")+"/testdata/myfile.xlsx"); //file not present but since we have given a name it'll create automatically.
		XSSFWorkbook workbook=new XSSFWorkbook(); //creating workbook
		
		XSSFSheet sheet= workbook.createSheet("Data");
		XSSFRow row1=sheet.createRow(0);
			row1.createCell(0).setCellValue("Java");
			row1.createCell(1).setCellValue("19");
			row1.createCell(1).setCellValue("Automation");
			
		XSSFRow row2=sheet.createRow(0);
		row2.createCell(0).setCellValue("Python");
		row2.createCell(1).setCellValue("19");
		row2.createCell(1).setCellValue("Automation");			
			
		XSSFRow row3=sheet.createRow(0);
		row2.createCell(0).setCellValue("C#");
		row2.createCell(1).setCellValue("19");
		row2.createCell(1).setCellValue("Automation");	
		
		workbook.write(file);
		workbook.close();
		System.out.println("File is created.");
	
	}

}
