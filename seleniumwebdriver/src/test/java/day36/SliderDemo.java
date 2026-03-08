package day36;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class SliderDemo {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.jqueryscript.net/demo/Price-Range-Slider-jQuery-UI/");
		driver.manage().window().maximize();
		Actions act= new Actions(driver);
		
		//Minimum slider
		
		//capture the location of the element i.e., the coordinates of the point in the webpage.
		WebElement minSlider=driver.findElement(By.xpath("//div[@class='price-range-block']//span[1]"));
		System.out.println("Location of the slider:"+minSlider.getLocation());	//getting the location of the minSlider in the page i.e., the x and y coordinates of the element, where it is located in the webpage. getLocation belongs to webElement	
		
	//	System.out.println(minSlider.getLocation().getX()); 	//gets only X axis 
	//	System.out.println(minSlider.getLocation().getY()); 	//gets only X axis 
		
		act.dragAndDropBy(minSlider,100,249).perform(); 	// as here we have horizontal slider, only x axis will be increased/decreased. If we have vertical slider, we increase/decrease Y axis
		System.out.println("Location of the slider after moving:"+minSlider.getLocation()); 	// 162,250-->> always consider +-5 in the coordinates, the value should be nearby +-5. As it depends on the monitor's screen pixels.
		
		
		//Maximum slider
		WebElement maxSlider=driver.findElement(By.xpath("//div[@id='slider-range']//span[2]"));
		System.out.println("Location of maximum slider"+maxSlider.getLocation());
		act.dragAndDropBy(maxSlider, -100, 247).perform(); 		//decreasing the maxSlider
		System.out.println("Location of maximum slider"+maxSlider.getLocation());
		
		
		
		
	}

}
