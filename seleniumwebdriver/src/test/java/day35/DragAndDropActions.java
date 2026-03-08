package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class DragAndDropActions {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		Actions act=new Actions(driver);
		
		//drag and drop
		WebElement source=driver.findElement(By.xpath("//div[@id='draggable']"));
		WebElement targetsource=driver.findElement(By.xpath("//div[@id='droppable']"));
		
		act.dragAndDrop(source, targetsource).perform();
		Thread.sleep(5000);
		
		
		//WebElement target=driver.findElement(By.xpath("//div[@id='HTML2']"));
		//act.dragAndDrop(source,target).perform();
		
		
	}

}
