package day28;

import java.time.Duration;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Assignment {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.findElement(By.xpath("//input[@id='Wikipedia1_wikipedia-search-input']")).sendKeys("Selenium");
		driver.findElement(By.xpath("//input[@class='wikipedia-search-button']")).click();
		
		List <WebElement> searchlinks=driver.findElements(By.xpath("//a[contains(text(),'Selenium')]"));
		System.out.println(searchlinks.size());
		
		for(WebElement links:searchlinks)
		{
			//String linktext=links.getText();
			//WebElement element=driver.findElement(By.xpath("//a[text()='"+linktext+"']"));
			links.click();
			//System.out.println("Opened Page"+driver.getTitle());
			
		}
		
		Set <String> WindowIDs=driver.getWindowHandles();
		for(String winid:WindowIDs)
		{
			String title=driver.switchTo().window(winid).getTitle();
			System.out.println(title);
			if(title.equals("Selenium in biology - Wikipedia"))
			{
				driver.close();
			}
		}
		
		
		
		
	}

}
