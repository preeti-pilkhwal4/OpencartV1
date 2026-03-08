package day24;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class XPathDemo {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.get("https://demo.nopcommerce.com/");
		driver.manage().window().maximize();
		
		//xpath with single attribute
		//driver.findElement(By.xpath("//input[@placeholder=\"Search store\"]")).sendKeys("Tshirts");
		
		//xpath with multiple attributes
		//driver.findElement(By.xpath("//input[@placeholder='Search store'][@name='q']")).sendKeys("Tshirts");
		
		//xpath with 'and' operator
		//driver.findElement(By.xpath("//input[@placeholder='Search store' and @name='q']")).sendKeys("Tshirts");
		
		//xpath with 'or' operator
		//driver.findElement(By.xpath("//input[@placeholder='Search store' or @name='q']")).sendKeys("Tshirts");
				
		//xpath with text() and without attributes-->> inner text
		//driver.findElement(By.xpath("//a[text()='Computers']")).click();
		
		//boolean displaystatus=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).isDisplayed();
		//System.out.println(displaystatus);
		
		//String value=driver.findElement(By.xpath("//h2[text()='Welcome to our store']")).getText(); 		//getText() will return the text of the element 
		//System.out.println(value);
		
		// xpath with contains()
		//driver.findElement(By.xpath("//input[contains(@placeholder,'Sear')]")).sendKeys("Tshirts"); 		//getText() will return the text of the element 
		
		// xpath with starts-with()
		//driver.findElement(By.xpath("//input[starts-with(@placeholder,'Sear')]")).sendKeys("Tshirts"); 		//getText() will return the text of the element 
				
		//Chained xpath
		boolean status=driver.findElement(By.xpath("//div[@class='header-logo']/a/img")).isDisplayed();
		System.out.println(status);
	
	
	
	}

}
