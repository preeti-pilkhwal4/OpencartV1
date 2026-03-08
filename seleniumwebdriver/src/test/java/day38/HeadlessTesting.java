package day38;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class HeadlessTesting {

	public static void main(String[] args) {

		
				ChromeOptions options=new ChromeOptions();			
				options.addArguments("--headless=new");	
				
				WebDriver driver=new ChromeDriver(options);
				driver.get("https://demo.nopcommerce.com/"); 
				
				
				String actual_title=driver.getTitle(); 		
				System.out.println(actual_title);
				if(actual_title.equals("Just a moment..."))
				{
					System.out.println("Test Passed");
				}
				else
				{	
					System.out.println("Test Failed");
				}
				
				
				driver.quit();
				 		
	}

}
