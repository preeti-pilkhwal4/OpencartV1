package day29;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAlerts {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		driver.get("https://the-internet.herokuapp.com/javascript_alerts");
		driver.manage().window().maximize();
		// we can't use findelement for alerts as alert is not a webelement.
		
		//1. Normal JS alert with OK button
		/*
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Alert']")).click();
		Thread.sleep(5000);
		
		//switching driver from page to alert  
		//driver.switchTo().alert().accept(); 		//accept() for clicking on ok
		//if we want to do actions on alert then don't directly use accpet() store in a variable.
		Alert myalert=driver.switchTo().alert(); 
		System.out.println(myalert.getText());
		myalert.accept();
		*/
		
		//2. Confirmation JS alert having OK and cancel
		/*
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Confirm']")).click();
		Thread.sleep(5000);

		//driver.switchTo().alert().accept(); 		//close alert using ok command
		driver.switchTo().alert().dismiss(); 		//close alert using cancel command
		
		*/
		//3. Prompt alert
		driver.findElement(By.xpath("//button[normalize-space()='Click for JS Prompt']")).click();
		Thread.sleep(5000);
		Alert Mypromtalert=driver.switchTo().alert();
		Mypromtalert.sendKeys("Welcome");
		//Mypromtalert.accept();
		Mypromtalert.dismiss();
	
	}

}
