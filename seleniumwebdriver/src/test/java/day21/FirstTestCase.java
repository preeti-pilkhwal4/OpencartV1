package day21;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

import org.openqa.selenium.WebDriver;
/*
 * Test Case
 * 1. Launch Chrome browser
 * 2. Open URL https://automationexercise.com/
 * 3. Validate title should be "Automation Exercise".
 * 4. Close browser.
 * 
 */
public class FirstTestCase {

	public static void main(String[] args) {

		//1. Launch the browser(chrome)
		ChromeDriver driver=new ChromeDriver();		//internally it'll invoke the ChromeDriver constructor and that constructor will launch the chrome.
		//WebDriver driver=new ChromeDriver(); 			//valid as webdriver is parent of Chormedriver, upcasting-->> preferred as here we can store any type of object like chromedriver object or firefoxdiver object, etc but if used first approach we can duse only chrome.
		//WebDriver driver=new EdgeDriver(); 			//microsoft edge
		//WebDriver driver=new FirefoxDriver();  		//Firefox
		//WebDriver driver=new SafariDriver();  		//Safari
				
		//2. Open URL https://demo.opencart.com/
		
		driver.get("https://automationexercise.com/"); 		//get method will accept the URL as a parameter and open this URL in the launched URL.
		
		//3. Validate title should be "Automation Exercise". Every page has different title.
		
		String actual_title=driver.getTitle(); 		//this get method will automatically return the title of the actual web page.
		//Comparing actual tile and expected title
		
		if(actual_title.equals("Automation Exercise"))
		{
			System.out.println("Test Passed");
		}
		else
		{	
			System.out.println("Test Failed");
		}
		
		
		//4. Close browser.-->> 2 approaches-->> close() and quit()
		 driver.close();
		 //driver.quit();
		 
	}

}
