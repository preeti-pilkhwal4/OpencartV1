package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
/*
Actions is a predefined class provided in Selenium
1. Mouse hover----moveToElement(element)
2. right click---contextClick(element)
3. double click--doubleClick(element)
4. drag and drop--dragAndDrop(source,target)
build- create the action
perform- complete the action
*/

public class MouseHoverAction {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();	
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement pointme=driver.findElement(By.xpath("//button[@class='dropbtn']"));
		WebElement laptops=driver.findElement(By.xpath("//div[@class='dropdown-content']/a[2]"));
		
		//creating object of actions class
		Actions act=new Actions(driver); 	//Actions constructor needs driver as a parameter
		
		//Mouse hover
		//act.moveToElement(pointme).moveToElement(laptops).click().build().perform(); 		//want to mouse hover on desktops and then mac, chaining the methods here.
		act.moveToElement(pointme).moveToElement(laptops).click().perform(); 	// if used only perform() then it is capable of creating an action, no need of build(). If we want to do immediate action then we can only use this but if we want to create an action but want to perform the action later then we have to use build() and later perform().
		
		/*
		act.moveToElement(pointme).perform();
		Thread.sleep(5000);
		act.moveToElement(laptops).perform();
		Thread.sleep(5000);
		*/
	}

}
