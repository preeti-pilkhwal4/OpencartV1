package day40;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class WritingDynamicDataIntoExcel {

	public static void main(String[] args) throws IOException {
		
		FileOutputStream file=new FileOutputStream(System.getProperty("user.dir")+"/testdata/myfile_dynamic.xlsx");
		XSSFWorkbook workbook=new XSSFWorkbook();
		
		XSSFSheet sheet=workbook.createSheet("DynamicData");
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter number of rows:");
		int Rows=sc.nextInt();
		
		System.out.println("Enter number of comuns:");
		int Cells=sc.nextInt();

		for(int r=0;r<Rows;r++)
		{
			XSSFRow currentRow=sheet.createRow(r);	
			for(int c=0;c<Cells;c++)
			{
				XSSFCell cell=currentRow.createCell(c);
				cell.setCellValue(sc.next()); //as user can enter any type of data so used next()
			}
		}
		workbook.write(file);
		workbook.close();
		file.close();
		
		System.out.println("File is created..");
		
	}

}
