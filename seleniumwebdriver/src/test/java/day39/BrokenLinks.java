package day39;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class BrokenLinks {

	public static void main(String[] args) {

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("http://www.deadlinkcity.com/");
		driver.manage().window().maximize();
		
		List<WebElement> links=driver.findElements(By.tagName("a"));
		System.out.println("No. of links:"+links.size());
		
		int noOfBrokenLinks=0;
		
		for(WebElement linkElement:links)
		{
			String hrefattValue=linkElement.getAttribute("href");
			if(hrefattValue==null||hrefattValue.isEmpty())
			{
				System.out.println("href attribute value is null or empty so not possible to check.");
				continue;
			}
			//hit the URL
			try {
				URL linkURL= new URL(hrefattValue); 	//convert href value from string to URL format
				HttpURLConnection connlinkURL=(HttpURLConnection) linkURL.openConnection(); 	//open connection to the server
				connlinkURL.connect(); 	//connect to server and sent request to the server
				
				if(connlinkURL.getResponseCode()>=400)
				{
					System.out.println(hrefattValue+"=====>Broken link");
					noOfBrokenLinks++;
				}
				else
				{
					System.out.println(hrefattValue+"====>Not a broken link.");
				}
			}
			catch(Exception e)
			{
				
			}
		}
		System.out.println("No. of broken links:"+noOfBrokenLinks);
	}

}
