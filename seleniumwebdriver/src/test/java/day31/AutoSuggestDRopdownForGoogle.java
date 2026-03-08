package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class AutoSuggestDRopdownForGoogle {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.manage().window().maximize();
		
		//clicking search box
		driver.findElement(By.xpath("//textarea[@id='APjFqb']")).sendKeys("selenium webdriver");
		Thread.sleep(5000);
		
		//Get all the values.
		List <WebElement> list=driver.findElements(By.xpath("//ul[@role='listbox']//div[@role='option']"));
		System.out.println(list.size());
		
		//selecting a particular value
		for(WebElement li:list)
		{
			System.out.println(li.getText());
			if(li.getText().equalsIgnoreCase("Selenium Webdriver")) 		//using equalsIgnoreCase() method to ignore upper and lower cases.
			{
				li.click();
			}
		}
		
		
		
	}

}
