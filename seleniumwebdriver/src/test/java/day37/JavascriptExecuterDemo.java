package day37;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavascriptExecuterDemo {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		//ChromeDriver driver= new ChromeDriver(); 		//needs upcasting to javascriptExceutor
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		//driver.findElement(By.xpath("//input[@id='name']")).sendKeys("John"); 	// input text using sendKEys()
		
		WebElement inputbox=driver.findElement(By.xpath("//input[@id='name']"));
		
		//Passing text into inputBox- alternative of sendKeys()
		JavascriptExecutor js=(JavascriptExecutor)driver; 	//upcasting driver here, child class object we are storing into parent class variable
		//JavascriptExceutor js=driver;
		js.executeScript("arguments[0].setAttribute('value', 'John')", inputbox); 		//it will set the value of inputbox to John-->> first it'll assign inputbox to arguments[0] and then the attribute will be set to the passed value.
		
		
		//clicking on element -alternative of click()
		//driver.findElement(By.xpath("//input[@id='male']")).click(); 	//click radio button using click()
		WebElement radiobtn=driver.findElement(By.xpath("//input[@id='male']"));
		js.executeScript("arguments[0].click()", radiobtn); 	//click() method here is from javascript
	
	
	
	}

}
