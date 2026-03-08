package day40;

import java.io.FileInputStream;
import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

//Excel File-->>Workbook-->>Sheets-->>Rows-->>Cells
public class ReadingDataFromExcel {

	public static void main(String[] args) throws IOException {

		FileInputStream file=new FileInputStream(System.getProperty("user.dir")+"/testdata/data.xlsx");
		
		XSSFWorkbook workbook=new XSSFWorkbook(file);
		XSSFSheet sheet=workbook.getSheet("Sheet1"); //name of sheet in workbook
		//XSSFSheet sheet=workbook.getSheetAt(0); 		//alternate method
		
		int total=sheet.getLastRowNum(); 	//returns the total number of rows
		int totalCells=sheet.getRow(1).getLastCellNum(); 	//return total number of cells, u can put any row like 1, 2 as it'll return same cells 
		
		System.out.println("Number of Rows:"+total );
		System.out.println("Number of Rows:"+totalCells );
		
		for(int r=0;r<total;r++)
		{
			XSSFRow currentRow=sheet.getRow(r);
			for(int c=0;c<totalCells;c++)
			{
				XSSFCell cell =currentRow.getCell(c);
				System.out.print(cell.toString()+"\t");
			}
			System.out.println();
		}
		
		workbook.close();
		file.close();
		
	}

}
