package day45;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

//We create another class having data provider so that it can be used across the project.

public class DataProviderDemo {

	WebDriver driver;
	@BeforeClass
	void setup() 
	{
		driver=new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	}
	
	//dataProvider attribute so that test method will know which data provider method is providing data.
	@Test(dataProvider="dp")
	void testLogin(String email, String pwd) throws InterruptedException
	{
		driver.get("https://tutorialsninja.com/demo/index.php?route=account/login");
		driver.manage().window().maximize();
		driver.findElement(By.xpath("//input[@id='input-email']")).sendKeys(email);
		driver.findElement(By.xpath("//input[@id='input-password']")).sendKeys(pwd);
		driver.findElement(By.xpath("//input[@value='Login']")).click();
		Thread.sleep(2000);
		boolean status=driver.findElement(By.xpath("//h2[normalize-space()='My Account']")).isDisplayed();
		if(status==true)
		{
			driver.findElement(By.xpath("//a[@class='list-group-item'][normalize-space()='Logout']")).click();
			Assert.assertTrue(true);
		}
		else
		{
			Assert.fail();
		}
	}
	
	@AfterClass
	void tearDown()
	{
		driver.close();
	}
	
	//creation and returning the date. Here we are hard coding it but in realtime we pick it from excel file and store it in 2d array and then returning data. this method has Object returntype as it returns 2d array which can be string, integer, etc.  
	//DataProvider() annotation
	//indices attribute for returning specific data here {0,1} is not range, it is index numbers.
	@DataProvider(name="dp", indices= {0,1,4})
	Object[][] loginData()
	{
		String data[][]= {
							{"sampledata1@gmail.com","test@123"},
							{"sampledata2@gmail.com","test@123"},
							{"sampledata3@gmail.com","test@123"},
							{"sampledata4@gmail.com","test@123"},
							{"sampledata5@gmail.com","test@123"}
											
						};	
		return data;
	}
}
