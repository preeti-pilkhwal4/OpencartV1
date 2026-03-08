package day26;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ConditionalMethods {

	public static void main(String[] args) throws InterruptedException {

		WebDriver driver= new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/register");
		driver.manage().window().maximize();
		
		//1. isDisplayed()
		//WebElement logo=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']"));
		//System.out.println("Display status of Logo:"+logo.isDisplayed());
		
		//boolean status=driver.findElement(By.xpath("//img[@alt='nopCommerce demo store']")).isDisplayed();
		//System.out.println(status);
		
		//2. isEnabled()
		
		//boolean status= driver.findElement(By.xpath("//input[@id='FirstName']")).isEnabled();
		//System.out.println("Enable Status:"+status);
		
		//3. isSelected()
		
		WebElement male_rd=driver.findElement(By.xpath("//input[@id='gender-male']"));
		WebElement female_rd=driver.findElement(By.xpath("//input[@id='gender-female']"));
		System.out.println("Before Selection:");
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("After Selecting male radio button:");
		male_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		System.out.println("After Selecting female radio button:");
		female_rd.click();
		System.out.println(male_rd.isSelected());
		System.out.println(female_rd.isSelected());
		
		boolean newletterstatus=driver.findElement(By.xpath("//input[@id='NewsLetterSubscriptions_0__IsActive']")).isSelected();
		System.out.println(newletterstatus);
		
		
	}

}
