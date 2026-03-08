package day30;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleFrames {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://ui.vision/demo/webtest/frames/");
		driver.manage().window().maximize();
		
		//Frame 1
		//driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome"); 			//throws NOSuchElementException as this element is inside iframe.
		
		//switching to frame
		WebElement myframe1=driver.findElement(By.xpath("//frame[@src='frame_1.html']"));
		driver.switchTo().frame(myframe1); 		// passed frame as a webelement as id, name are not available. Switch to frame1
		
		driver.findElement(By.xpath("//input[@name='mytext1']")).sendKeys("Welcome"); 
		
		//Frame 2 
		//driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Welcome");  	// will throw NoSuchElementException as the driver is focused on frame 1. Can't switch from frame 1 to frame 2
		driver.switchTo().defaultContent(); 	// Go back to the main page. defaultContent() command to shift focus to main page
		
		//switching to frame 2 from main page.
		WebElement myframe2= driver.findElement(By.xpath("//frame[@src='frame_2.html']"));
		driver.switchTo().frame(myframe2); 		//passing frame2 as webelement
		driver.findElement(By.xpath("//input[@name='mytext2']")).sendKeys("Selenium");
		driver.switchTo().defaultContent(); 			// Go back to the main page. defaultContent() command to shift focus to main page
	
		//Frame 3
		WebElement myframe3=driver.findElement(By.xpath("//frame[@src='frame_3.html']"));
		driver.switchTo().frame(myframe3);
		driver.findElement(By.xpath("//input[@name='mytext3']")).sendKeys("Java"); 		
		
		//inner frame- part of frame 3
		driver.switchTo().frame(0); 		//switching to inner frame inside frame 3 using index. we can also use id, nae, webelement if present.
		//driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")).click(); 		//can't locate the element from the main page so navigated to form page to get the exact xpath. 
		//driver.switchTo().defaultContent(); 	//this will come out of the frame. Here no need to write it multiple times for coming out of the inner iframe.
		
		//using javaScript executer-->> sometimes we get Elementinterceptedexception, ElementNotclickablexceptions, etc to handle that we use javscript executer
		WebElement rdbutton=driver.findElement(By.xpath("//div[@id='i9']//div[@class='AB7Lab Id5V1']")); 
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click();", rdbutton);
		driver.switchTo().defaultContent(); 
		
		//assignment
		
		WebElement myframe5=driver.findElement(By.xpath("//frame[@src='frame_5.html']"));
		driver.switchTo().frame(myframe5);
		driver.findElement(By.xpath("//input[@name='mytext5']")).sendKeys("Frame 5");
		driver.findElement(By.xpath("//a[contains(text(),'a9t9')]")).click();
		System.out.println(driver.getCurrentUrl());
		WebElement logo=driver.findElement(By.xpath("//img[contains(@alt,'Ui.Vision by a9t9 software - Image-Driven Automation')]")); 		//   //img[contains(@src,'ui.vision')] , //img[contains(@alt,'UI.Vision')] -->> these xpaths also works

		System.out.println(logo.isDisplayed());
		
		
		
	}

}
