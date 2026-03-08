package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class GetMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		
		//1. get(url) method--open the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		
		//getTitle() method --returns title of the page
		System.out.println(driver.getTitle());
		
		//getCurrentUrl()-returns URL of the page
		System.out.println(driver.getCurrentUrl());
		
		//getPageSource()-- returns source code of the page
		System.out.println(driver.getPageSource());
		
		//getWindowHandle()--returns id of the single browser window
		
		//String windowID=driver.getWindowHandle();
		//System.out.println("Window ID:"+windowID);
		
		//getWindowHandles()--return IDs of multiple browser windows open.
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); 	//this will open new window
		Set <String> windowids=driver.getWindowHandles(); 			//set is used as window IDs will be unique
		System.out.println(windowids);
		
		
	}

}
