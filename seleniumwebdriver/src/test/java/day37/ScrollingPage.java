package day37;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ScrollingPage {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize();
		JavascriptExecutor js=(JavascriptExecutor)driver;
		
		//1) Scroll down the page by pixel number
		//js.executeScript("window.scrollBy(0,1500)","");
		//System.out.println(js.executeScript("return window.pageYOffset;")); 	//return the position where the scroll stops. 
		
		//2) Scroll down the page till element is visible
		//Sometimes the element on which we want to perform action can't be located and it throws nosuchelement exception as it is at last of the page and not visible as soon as the browser is launched then in that case we can use this approach.
		/*
		WebElement ele=	driver.findElement(By.xpath("//h2[normalize-space()='Community poll']"));
		js.executeScript("arguments[0].scrollIntoView();", ele);
		System.out.println(js.executeScript("return window.pageYOffset;"));
		*/
		
		//3)Scroll down to last of the page
		js.executeScript("window.scrollBy(0, document.body.scrollHeight)");
		System.out.println(js.executeScript("return window.pageYOffset;"));
		Thread.sleep(5000);
		
		//Scrolling up to initial position
		js.executeScript("window.scrollBy(0,-document.body.scrollHeight)");
		
		
		//if we want to handle horizontal scrollbar then same method will be used just we will use the X axis. 
		//js.executeScript("window.scrollBy(0, document.body.scrollWidth)");
		//System.out.println(js.executeScript("return window.pageXOffset;"));
	}

}
