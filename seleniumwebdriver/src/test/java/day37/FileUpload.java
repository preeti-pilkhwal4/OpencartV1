package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class FileUpload {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.get("https://davidwalsh.name/demo/multiple-file-upload.php");
		driver.manage().window().maximize();
		
		//single file upload
		/*driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys("//home/preetipilkhwal/Downloads/Student2Multi_1768907960405.pdf");
		
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li")).getText().equals("Student2Multi_1768907960405.pdf"))
		{
			System.out.println("File is Successfully uploaded....");
		}
		else
		{
			System.out.println("Upload Failed..");
		}
		*/
		
		//Multiple file upload
		String file1="//home/preetipilkhwal/Downloads/Student2Multi_1768907960405.pdf";
		String file2="/home/preetipilkhwal/Downloads/Normalization_Report_2026-01-21T10-33-11.xlsx";
		driver.findElement(By.xpath("//input[@id='filesToUpload']")).sendKeys(file1+"\n"+file2); 	//  \n -->> next line
		
		//validation -->> no.of files
		int NoOfFiles=driver.findElements(By.xpath("//ul[@id='fileList']/li")).size(); 	//returns the number of files uploaded
		
		if(NoOfFiles==2)
		{
			System.out.println("All files uploaded");
		}
		else
		{
			System.out.println("Files not uploaded");
		}
		
		//validate filenames
		if(driver.findElement(By.xpath("//ul[@id='fileList']/li[1]")).getText().equals("Student2Multi_1768907960405.pdf") 
				&&driver.findElement(By.xpath("//ul[@id='fileList']/li[2]")).getText().equals("Normalization_Report_2026-01-21T10-33-11.xlsx"))
		{
			System.out.println("Files are matching");
		}
		else
		{
			System.out.println("Files not matching");
		}
		//isDisplayed() can be used but if the file is not correct it will return true as the file is present it'll not validate the filename.
		
	}

}
