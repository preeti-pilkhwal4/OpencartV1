package day28;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleBrowserWindows {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		driver.manage().window().maximize();
		
		driver.findElement(By.xpath("//a[normalize-space()='OrangeHRM, Inc']")).click();
		
		Set <String> windowIds=driver.getWindowHandles();
		
		//Approach1 -->> coverting set to list to retrieve specific element
		List<String> windowlist=new ArrayList(windowIds);
		
		String parentID=windowlist.get(0);
		String childID=windowlist.get(1);
		
		//switch to child window
		driver.switchTo().window(childID);
		//System.out.println(childID); 
		System.out.println(driver.getTitle()); 
		
		//switch to parent window
		driver.switchTo().window(parentID);
		System.out.println(driver.getTitle());
		
		//If we have multiple browser windows then we will use loops
		//Approach2
		
		for(String winID:windowIds)
		{
			String title=driver.switchTo().window(winID).getTitle();
			if(title.equals("OrangeHRM, Inc"))
			{
				System.out.println(driver.getCurrentUrl());
			}
		}
			
		
		
	}

}
