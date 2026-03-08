package day44;

import org.testng.Assert;
import org.testng.annotations.Test;

public class DependencyMethods {

	@Test(priority=1)
	void openapp()
	{
		Assert.assertTrue(true);
	}
	
	//dependsOn method
	@Test(priority=2, dependsOnMethods= {"openapp"})
	void login()
	{
		Assert.assertTrue(true);
	}
	
	@Test(priority=3, dependsOnMethods= {"login"})
	void search()
	{
		Assert.assertTrue(false);
	}
	
	//define n number of dependent methods
	//will be skipped as login is passed but search is failed  
	@Test(priority=4, dependsOnMethods= {"login","search"})
	void advserach()
	{
		Assert.assertTrue(true);
	}
	
	//will run as login is passed
	@Test(priority=5, dependsOnMethods= {"login"})	
	void logout()
	{
		Assert.assertTrue(true);
	}
	
	
}
