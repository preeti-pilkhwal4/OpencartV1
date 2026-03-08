package day35;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class RightClickAction {

	public static void main(String[] args) throws InterruptedException {
		
		WebDriver driver= new ChromeDriver();
		
		driver.get("https://vinothqaacademy.com/mouse-event/");
		driver.manage().window().maximize();
		
		WebElement button=driver.findElement(By.xpath("//button[@id='rightclick']"));
		Actions act=new Actions(driver);
		
		//contextClick(element)
		act.contextClick(button).perform(); 	//right clicking
		
		//clicking any options after right clicking
		driver.findElement(By.xpath("//div[@id='myDiv']//a[contains(text(),'Registration Form')]")).click();
		Thread.sleep(5000);
		driver.navigate().back();
		
	}

}
