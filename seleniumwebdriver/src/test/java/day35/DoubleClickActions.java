package day35;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

/* getText() will not get the value in some scenarios asit gets the inner text and if it is not present in the html then it'll return empty string.e.g., for some elements we don't have inner text, if there is inner text available then only we can get text from the element using getText(), if not present we will not be able to capture the text..
*  in this place, we can use getAttribute("value")-->> it'll get the value of attribute which we specified

Difference between getTExt() and getAttribute()

<input id="xyz">welcome</input>
* getText()-->> returns the inner text -->> welcome, if inner text not present then it'll return nothing.
* getAttribute("id")-->> returns the value of the attribute of the element.-->> xyz  ...it can be any attribute value, id, name, type, etc
* 
*
*/
public class DoubleClickActions {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement box1=driver.findElement(By.xpath("//input[@id='field1']"));
		WebElement box2=driver.findElement(By.xpath("//input[@id='field2']"));
		WebElement button=driver.findElement(By.xpath("//button[normalize-space()='Copy Text']"));
		
		//passing value in textfield1
		box1.clear(); 	//clearing text box
		box1.sendKeys("Selenium Testing"); 	//passing values
		
		Actions act=new Actions(driver);
		//act.doubleClick(box2).perform(); 	
		act.doubleClick(button).build().perform(); 	 	//double click
		
		Thread.sleep(3000);
		
		String text=box2.getAttribute("value"); 			
		System.out.println(text);
		if(text.equals("Selenium Testing"))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		
		/*
		//Validation
		if(box1.getText().equals(box2.getText()))
		{
			System.out.println("Test Pass");
		}
		else
		{
			System.out.println("Fail");
		}
		*/
	}

}
