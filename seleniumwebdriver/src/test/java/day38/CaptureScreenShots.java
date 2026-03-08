package day38;

import java.io.File;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class CaptureScreenShots {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		Thread.sleep(5000);
		
		//1) Full page screenshot
		/*
		TakesScreenshot ts=(TakesScreenshot)driver; 		//TakesScreenshot is an interface, Up casting needed
		File sourcefile=ts.getScreenshotAs(OutputType.FILE); 		//bytes and base are not understable. file-->> png, img, jpeg //calling from TakesScreenshot interface
		
		//the screenshot is saved somewhere in the memory. here I want to store it in my location. Create a screenshots folder in the project and give the location where the screenshots need to be stored.
		
		//File targetfile=new File("/home/preetipilkhwal/Workspaces/workspace2/seleniumwebdriver/screenshots/fullpage.png"); 	//defined our own path where we want to save the screenshots but it is very long. Suppose I'll move this project to other location, this path will not work. so we will capture the location dynamically. 
		
		//dynamically capturing the location. getProperty() will return the current project location.
		File targetfile=new File(System.getProperty("user.dir")+"//screenshots//fullpage.png"); 		
		sourcefile.renameTo(targetfile); 	//copy sourcefile to targetfile
		//suppose we want to capture multiple screenshots then we have to create multiple File variables. In real time we will create a user defined method and pass location and driver instance.
		*/
		//2) capture the screenshot of the specific section.
		/*
		WebElement featuredProducts=driver.findElement(By.xpath("//section[@class='product-grid home-page-product-grid']"));
		featuredProducts.getScreenshotAs(OutputType.FILE);
		
		File sourcefile=featuredProducts.getScreenshotAs(OutputType.FILE);  	//calling getScreenshotAs() from webelement interface, function works similar to one in TakesScreenshot interface
		File targetfile=new File(System.getProperty("user.dir")+"//screenshots//featuredproducts.png");
		sourcefile.renameTo(targetfile);
		*/
		
		//3) Capture the screenshot of the specific webElement.
		WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		File sourcefile=logo.getScreenshotAs(OutputType.FILE);
		File targetfile=new File(System.getProperty("user.dir")+"/screenshots/logo.png");
		sourcefile.renameTo(targetfile);
		
		driver.quit();
		
	}

}
