package day23;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class CSSLocators {

	public static void main(String[] args) {
		
		WebDriver driver= new ChromeDriver();			//ctrl+shift+O for importing associated classes
		driver.get("https://demo.nopcommerce.com/");
		
		driver.manage().window().maximize(); 			//maximize the browser
		
		//CSS Selectors-->> 4 options
		// 1. tag   id--->>>tagname#id
		//tag is optional
		//driver.findElement(By.cssSelector("input#small-searchterms")).sendKeys("Tshirts");
		//driver.findElement(By.cssSelector("#small-searchterms")).sendKeys("Tshirts");		// without tag	//if you want to check whether the CSS locator is correct or not then go to inspect section ctrl+F then enter the CSS locator, it'll highlight the element in the web page and also in the code.
		 
		//2. tag class-->> tag.classname
		//driver.findElement(By.cssSelector("input.search-box-text")).sendKeys("Tshirts"); 			//we have to skip the second part in classname as here we have input.search-box-text ui-autocomplete-input we can use only first part. for complete value it will not be able to locate
		//driver.findElement(By.cssSelector(".search-box-text")).sendKeys("Tshirts");  				//without tag

		//3. tag attribute-->> tag[attribute="value"];
		//placeholder attribute
		//driver.findElement(By.cssSelector("input[placeholder=\"Search store\"]")).sendKeys("Tshirts"); 			//can't use double qutes inside double qoutes in java so we use single quotes inside double or we should use \...\
		//name attribute
		//driver.findElement(By.cssSelector("input[name=\"q\"]")).sendKeys("Tshirts");				//used \...\ before double qoutes.
		//driver.findElement(By.cssSelector("[name=\"q\"]")).sendKeys("Tshirts"); 		//without tag 
	
		//4. tag class attribute --->> tag.clasname[attribute="value"]
		//driver.findElement(By.cssSelector("input.search-box-text[placeholder=\"Search store\"]")).sendKeys("Tshirts"); 		//used placeholder attribute
		driver.findElement(By.cssSelector("input.search-box-text[name=\"q\"]")).sendKeys("Tshirts"); 			//used name attribute
		//driver.findElement(By.cssSelector(".search-box-text[name='q']")).sendKeys("Tshirts");  			//without tagname
	}

}
