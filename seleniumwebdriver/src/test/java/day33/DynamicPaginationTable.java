package day33;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DynamicPaginationTable {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		
		int pages=driver.findElements(By.xpath("//ul[@id='pagination']/li")).size();
		System.out.println("Total No. of Pages:"+pages);
		//clicking on the pages
		for(int p=1;p<=pages;p++)
		{	
			 if(p>1)
			 {
				 driver.findElement(By.xpath("//ul[@id='pagination']//li["+p+"]")).click();
				 Thread.sleep(3000);
			 }
			//reading data from the page
			 int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
				
			 for(int r=1; r<=rows;r++)
			 {
				String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[2]")).getText();
				String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[3]")).getText();
				System.out.println(name+"\t"+price);
					
				//Clicking checkbox
				driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[4]/input[@type='checkbox']")).click();
			 }
			 System.out.println("Page "+p+" data");
		}
		/*
		//reading data from the page
		int rows=driver.findElements(By.xpath("//table[@id='productTable']//tbody/tr")).size();
		
		for(int r=1; r<=rows;r++)
		{
			String name=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[2]")).getText();
			String price=driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[3]")).getText();
			System.out.println(name+"\t"+price);
			
			//Clicking checkbox
			driver.findElement(By.xpath("//table[@id='productTable']//tbody/tr["+r+"]/td[4]/input[@type='checkbox']")).click();
		}
		*/
		
		
	}

}
