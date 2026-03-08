package day29;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class HandleAuthenticatedPopUP {

	public static void main(String[] args) {

		WebDriver driver=new ChromeDriver();
		//driver.get("http://the-internet.herokuapp.com/basic_auth");
		
		//injected username and password
		driver.get("http://admin:admin@the-internet.herokuapp.com/basic_auth");
	}

}
