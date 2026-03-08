package day46;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{

	public ExtentSparkReporter sparkReporter; 		//UI of the report
	public ExtentReports extent; 			// populate common info on the report
	public ExtentTest test; 			//creating test case entries in the report and update status of the test methods.
	
	public void onStart(ITestContext context)
	{
		
		sparkReporter=new ExtentSparkReporter(System.getProperty("user.dir")+"/reports/myReport.html"); 		//here we are hardcoding the report name everytime the test is executed new report with the same same will be created. so we will not be able to maintain the history of reports. so to maintain history we generate reports with the timestamps so everytime a new report will be generated.
		sparkReporter.config().setDocumentTitle("Automation Report"); //Title of the report
		sparkReporter.config().setReportName("Functional Report"); //Title of the report
		sparkReporter.config().setTheme(Theme.DARK);
		
		extent=new ExtentReports();
		extent.attachReporter(sparkReporter);
		
		//As of now the details are hardcoded. We will get it dynamically in the framework project.
		extent.setSystemInfo("Computer Name","localhost");
		extent.setSystemInfo("Environment","QA");
		extent.setSystemInfo("Tester Name","Preeti Pilkhwal");
		extent.setSystemInfo("OS","Windows10");
		extent.setSystemInfo("Browser Name","Chrome");
	}
	
	//result parameter contains all the details about the paassed, failed and skipped methods
	public void onTestSuccess(ITestResult result)
	{
		test=extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.PASS,"Test Case PASSED is:"+result.getName()); //update status as passed/failed/skipped
	}
	
	//For failed methods we can also implement taking screenshots this we will implement in framework.
	public void onTestFailure(ITestResult result)
	{
		test=extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.FAIL,"Test Case FAILED is:"+result.getName()); //update status as passed/failed/skipped
		test.log(Status.FAIL, "Test Case FAILED because:"+result.getThrowable());
	}
	
	public void onTestSkipped(ITestResult result)
	{
		test=extent.createTest(result.getName()); //create a new entry in the report
		test.log(Status.SKIP, "Test Case Skipped:"+result.getName());
	}
	
	
	//its mandatory otherwise whatever done above will not be there in the report. We use flush() method, it will update all the things whoch are done above.
	public void onFinish(ITestContext context)
	{
		extent.flush(); 	
	}
	
	//here the report is shwoing only the test method but if we have mutiple methods from different classes its difficult to identify the method belongs to which class so instead of having method name we can have class name along with test case id. this will be implemented in framework.
	
	
	
}
