package day44;

import org.testng.annotations.Test;

public class SignUpTests {

	@Test(priority=1, groups= {"regression"})
	void signupByEmail()
	{
		System.out.println("This is signup by email..");
	}
	
	@Test(priority=2, groups= {"regression"})
	void signupByfacebook()
	{
		System.out.println("This is signup by facebook..");
	}
	
	@Test(priority=3, groups= {"regression"})
	void signupByTwitter()
	{
		System.out.println("This is signup by Twitter..");
	}
	
}
