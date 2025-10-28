package task_OrangeHRM;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ExtentReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReporter; // UI of the report
	public ExtentReports extent;	// populate common info of the report
	public ExtentTest test; // creating test case entries and update the status of the methods
	
	
	 public void onStart(ITestContext context) {
		 
		 System.out.println("Test Execution is Started");
		  
		 sparkReporter=new ExtentSparkReporter("C:\\Users\\Rila_Noor\\eclipse-workspace\\OrangeHRM\\reports\\OrangeHRMReports.html");
		  sparkReporter.config().setDocumentTitle("OrangeHRM Automation Report");
		  sparkReporter.config().setReportName("Functional Testing");
		  sparkReporter.config().setTheme(Theme.STANDARD);
		  
		  extent = new ExtentReports();
		  extent.attachReporter(sparkReporter);
		  
		  extent.setSystemInfo("Tester Name", "Ajisha");
		  extent.setSystemInfo("Browser Name", "Chrome");
		  extent.setSystemInfo("OS", "Windows11");
		  extent.setSystemInfo("Environment", "QA");
		  
		  
		  
		  }
	
	
	public void onTestSuccess(ITestResult result) {
		System.out.println("Test Passed");
		
		test=extent.createTest(result.getName()); 
		test.log(Status.PASS, "Name of passed case is "+ result.getName()); 
		
	  }
	
	public void onTestFailure(ITestResult result) {
		
		System.out.println("Test Failed");
		test=extent.createTest(result.getName()); 
		test.log(Status.FAIL, "Name of failed case is "+ result.getName()); 
		test.log(Status.FAIL, "Reason for failure is" + result.getThrowable());
	  }
	
	public void onTestSkipped(ITestResult result) {
		
		System.out.println("Test Skipped");
		test=extent.createTest(result.getName()); 
		test.log(Status.SKIP, "Name of skipped case "+ result.getName()); 
	  }
	
	  public void onFinish(ITestContext context) {
		  System.out.println("Test Execution is Finished");
		  extent.flush();
		  }


}
