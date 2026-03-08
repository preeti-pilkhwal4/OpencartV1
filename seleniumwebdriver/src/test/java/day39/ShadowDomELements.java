package day39;

import org.openqa.selenium.By;
import org.openqa.selenium.SearchContext;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class ShadowDomELements {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://books-pwakit.appspot.com/explore?q=I");
		driver.manage().window().maximize();
			
		//driver.findElement(By.cssSelector("#input")).sendKeys("welcome"); 		//Thorws noSuchElementException.
		
		//This Element is inside single shadow DOM.
		
		//String cssSelectorForHost1 = "book-app[apptitle='BOOKS']"; 	//optional statement
		//Thread.sleep(1000);
		SearchContext shadow = driver.findElement(By.cssSelector("book-app[apptitle='BOOKS']")).getShadowRoot(); 		//here we are getting the shadow host and inside it there is nested shadow roots we can pick any shadow root element.
		Thread.sleep(1000);
		//shadow.findElement(By.cssSelector("#input")).clear();
		shadow.findElement(By.cssSelector("#input")).sendKeys("Welcome");
		
		
	}

}
