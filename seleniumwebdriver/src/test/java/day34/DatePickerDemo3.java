package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo3 {
/*
	//user defined method for converting year from string-->> Year object.
	static Year convertMonth(String year)
	{
		HashMap<String, Year> yearMap=new HashMap<String,Year>();
		
		yearMap.put("2020")
		
	}
	*/
	
	public static void main(String[] args) {

			WebDriver driver=new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
			
			driver.get("https://dummy-tickets.com/");
			driver.manage().window().maximize();
			
			//Clicking hotel
			driver.findElement(By.xpath("//a[normalize-space()='Hotel']")).click();
			
			//clicking date picker1
			driver.findElement(By.xpath("//input[@placeholder='Check In Date' and @name='checkin[]']")).click();
			String requiredMonth="Apr", requiredYear="2027", requiredDate="19";
			
			//selecting year
			while(true)
			{
				WebElement currentYear=driver.findElement(By.xpath("//span[@class='ui-datepicker-year']"));
				if(currentYear.getText().equals(requiredYear))
				{
					
					break;
				}
				driver.findElement(By.xpath("//span[@class='ui-icon ui-icon-circle-triangle-e']")).click();
				
			}
						
			//Selecting month from the drop down
			WebElement monthDropdown=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
			Select selectMonth=new Select(monthDropdown) ;
			selectMonth.selectByVisibleText(requiredMonth);
			
			//Select date
			List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));
			for(WebElement dt:dates)
			{
				if(dt.getText().equals(requiredDate))
				{
					dt.click();
					break;
				}
				
			}
	}

}
