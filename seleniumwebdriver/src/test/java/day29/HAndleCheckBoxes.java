package day29;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HAndleCheckBoxes {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.manage().window().maximize();
		
		//1. select specific checkbox.
		//driver.findElement(By.xpath("//input[@id='sunday']")).click();
		
		//2. Select multiple checkboxes
		//her if we use //input[@class='form-check-input']-->> it is matching with 9 elements but we have only 7 checkboxes so we will write another attribute to filter only checkboxes using and
		List<WebElement> checkboxes=driver.findElements(By.xpath("//input[@class='form-check-input' and @type='checkbox' ]"));
		/*
		for(WebElement box:checkboxes)
		{
			box.click();
		}
		*/
		//using normal for loop-->> less preferable 
		/*
		for(int i=0;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		
		}
		*/
		
		//3. Select last 3 checkboxes
		//total no of checkboxes-how many checkboxes want to select=starting index
		//7-3=4(Starting index-->> using normal for loop as here we are accessing checkboxes via indexes
		/*
		for(int i=4;i<checkboxes.size();i++)
		{
			checkboxes.get(i).click();
		}
		*/
		//4. Select first 3 checkboxes
		/*
		for(int i=0;i<3;i++)
		{
			checkboxes.get(i).click();
		}
		*/
		
		//5. Unselect checkboxes if they are selected.
		
		for(int i=0; i<3;i++)
		{
			checkboxes.get(i).click();
		}
		
		/*
		for(WebElement checkbox:checkboxes)
		{
			checkbox.click();
		}
		*/
		Thread.sleep(5000);
		for(int i=0; i<checkboxes.size();i++)
		{
			if(checkboxes.get(i).isSelected())
			{
				checkboxes.get(i).click();
			}
		}
		

	}
}
