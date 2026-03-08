package day42;

import org.testng.annotations.Test;

/*
 * 1) Open App
 * 2) Login
 * 3) Logout
 */
public class FirstTestCase {
	//TestNG execute the test cases in alphabetic order.
	@Test(priority=1)
	void openapp()
	{
		System.out.println("Opening Application...");
	}
	
	@Test(priority=2)
	void login()
	{
		System.out.println("Login To Application...");
	}
	
	@Test(priority=3)
	void logout()
	{
		System.out.println("Logout from Application...");
	}

}
