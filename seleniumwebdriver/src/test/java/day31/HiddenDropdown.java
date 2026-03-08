package day31;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class HiddenDropdown {

	public static void main(String[] args) throws InterruptedException {

		
		WebDriver driver= new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php");
		driver.manage().window().maximize();
		
		//login to orangehrm
		driver.findElement(By.name("username")).sendKeys("Admin");
		driver.findElement(By.name("password")).sendKeys("admin123");
		driver.findElement(By.xpath("//button[normalize-space()='Login']")).click();
		driver.findElement(By.xpath("//span[normalize-space()='PIM']")).click();
		
		//Clicked on drop down
		driver.findElement(By.xpath("//body/div[@id='app']/div[@class='oxd-layout orangehrm-upgrade-layout']/div[@class='oxd-layout-container']/div[@class='oxd-layout-context']/div[@class='orangehrm-background-container']/div[@class='oxd-table-filter']/div[@class='oxd-table-filter-area']/form[@class='oxd-form']/div[@class='oxd-form-row']/div[@class='oxd-grid-4 orangehrm-full-width-grid']/div[6]/div[1]/div[2]/div[1]/div[1]")).click();
		Thread.sleep(5000); 		//takes time to load the options tha's why we will get 0 size 
		
		//Select Single option
		//driver.findElement(By.xpath("//span[normalize-space()='Finance Manager']")).click();
		
		//Count no. of options 		
		List <WebElement> options=driver.findElements(By.xpath("//div[@role='listbox']//span")); 		//common xpath for all the options
		System.out.println(options.size());
		
		//printing options
		for(WebElement op:options)
		{
			System.out.println(op.getText());
		}
		
		
		
	}

}
