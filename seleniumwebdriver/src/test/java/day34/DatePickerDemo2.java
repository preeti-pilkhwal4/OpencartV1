package day34;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class DatePickerDemo2 {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://dummy-tickets.com/");
		driver.manage().window().maximize();
		
		//input DOB
		String requiredYear="2025";
		String requiredMonth="Jun";
		String requiredDate="15";
		
		
		
		driver.findElement(By.xpath("//input[@name='departure[]']")).click();
		
		//Select month
		WebElement monthdropdown=driver.findElement(By.xpath("//select[@class='ui-datepicker-month']"));
		Select selectMonth=new Select(monthdropdown);
		selectMonth.selectByVisibleText(requiredMonth);
		//Select year
		WebElement yeardropdown=driver.findElement(By.xpath("//select[@class='ui-datepicker-year']"));
		Select selectYear=new Select(yeardropdown);
		selectYear.selectByVisibleText(requiredYear);
		
		List<WebElement> dates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//tbody//td/a"));
		for(WebElement dt:dates)
		{
			if(dt.getText().equals(requiredDate))
			{
				dt.click();
			}
		}
		
		

		
		
		

	}

}
