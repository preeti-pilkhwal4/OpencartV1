package day47;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

// without pagefactory
public class LoginPage2 {
	
	WebDriver driver;
	//constructor-- initiate the driver
	LoginPage2(WebDriver driver)
	{
		this.driver=driver;
		PageFactory.initElements(driver, this); 	//mandatory
	}
	
	//locators--all xpaths
	
	//@FindBy(xpath="//input[@placeholder='Username']") 
	//WebElement txtUserName;
	
	//another way for finding elements
	@FindBy(how=How.XPATH,using="//input[@placeholder='Username']")
	WebElement txtUserName;
	
	@FindBy(xpath="//input[@placeholder='Password']") 
	WebElement txt_password;
	
	@FindBy(xpath="//button[normalize-space()='Login']") 
	WebElement btn_login;
	
	@FindBy(tagName="a") 
	List<WebElement> links;
	
	//Actions methods-- by locating elements through locators we will do the actions
	public void setUserName(String user)
	{
		txtUserName.sendKeys(user);
	}
	public void setPassword(String pwd)
	{
		txt_password.sendKeys(pwd);
	}
	public void clickLogin()
	{
		btn_login.click();
	}
}
