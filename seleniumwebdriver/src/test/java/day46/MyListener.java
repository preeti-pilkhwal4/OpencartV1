package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener implements ITestListener {

	//Executed before starting all the tests. Executed only once.
	public void onStart(ITestContext context) {
	 
		System.out.println("Test execution is started..");
	}
	
	//Executed before every test
	public void onTestStart(ITestResult result) {

		System.out.println("Test started..");
	}
	

	public void onTestSuccess(ITestResult result) {
	   
		System.out.println("Test passed..");
	
	}
	
	public void onTestFailure(ITestResult result) {
	
		System.out.println("Test failed..");
	
	}
	
	public void onTestSkipped(ITestResult result) {
	    
		System.out.println("Test skipped..");
	}
	
}
