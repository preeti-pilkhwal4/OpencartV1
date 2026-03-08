package day22;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LocatoreDemo {

	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();	 //launch chrome browser
		driver.get("https://tutorialsninja.com/demo/");  	//open URL in launched chrome browser		
		driver.manage().window().maximize(); 		//method to maximize the browser window.
		
		//Locating search bar in art of testing website using id
		//driver.findElement(By.id("fname")).sendKeys("Button");
		
		//locating element by name 
		//driver.findElement(By.name("search")).click();
		
		//locating element by linktext
		driver.findElement(By.linkText("Desktops")).click();
		//driver.findElement(By.partialLinkText("This Is"));
		
		//classname
		//List < WebElement> headerlinks=driver.findElements(By.className("dropdown"));
		//System.out.println(headerlinks.size());
		
		//tagname
		
		List<WebElement> images=driver.findElements(By.tagName("a"));
		System.out.println(images.size());
			
	}

}
