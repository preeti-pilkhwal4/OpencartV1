package day47;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

// without pagefactory
public class LoginPage {
	
	WebDriver driver;
	//constructor-- initiate the driver
	LoginPage(WebDriver driver)
	{
		this.driver=driver;
	}
	
	//locators--all xpaths
	By txt_username_loc=By.xpath("//input[@placeholder='Username']");
	By txt_password_loc=By.xpath("//input[@placeholder='Password']");
	By btn_login_loc=By.xpath("//button[normalize-space()='Login']");


	//Actions methods-- by locating elements through locators we will do the actions
	public void setUserName(String user)
	{
		driver.findElement(txt_username_loc).sendKeys(user);
	}
	public void setPassword(String pwd)
	{
		driver.findElement(txt_password_loc).sendKeys(pwd);
	}
	public void clickLogin()
	{
		driver.findElement(btn_login_loc).click();
	}
}
