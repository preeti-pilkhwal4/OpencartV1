package day31;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class SelectDropDowns {
	
	public static void main(String[] args) {
		
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		
		driver.get("https://testautomationpractice.blogspot.com/");
		driver.manage().window().maximize();
		
		WebElement drpCountryElement=driver.findElement(By.xpath("//select[@id='country']"));
		
		Select drpCountry=new Select(drpCountryElement); 		// object of select type
		
		//Select option from the drop down.
		
		//drpCountry.selectByVisibleText("Canada"); 	//selecting canada by text
		//drpCountry.selectByValue("france");
		//drpCountry.selectByIndex(2);
		
		//capture the options from the drop down.
		
		List<WebElement>options=drpCountry.getOptions(); 	//getOptions will return list of options webelements
		System.out.println(options.size());
		
		//printing options
		/*
		for(int i=0;i<options.size();i++)
		{
			System.out.println(options.get(i).getText());
		}
		*/
		//for...each
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}

	}
	
	
}
