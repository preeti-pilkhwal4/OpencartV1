package day26;

import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrowserMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		
		//1. get(url) method--open the url on the browser
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(5000);
		driver.findElement(By.linkText("OrangeHRM, Inc")).click(); 	//this will open new window
		
		Thread.sleep(5000);
		//driver.close(); 	// close single browser window wherever the browser is focused. Usually the driver is focused on the launched url only i.e., first url not the second url of the window which gets open after clicking on a link
		
		driver.quit();   //close all the browser windows
	}

}
