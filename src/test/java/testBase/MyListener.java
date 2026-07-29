package testBase;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class MyListener  implements ITestListener {
	
	public void onStart(ITestContext context) {
	   System.out.println("Test Started");
	  }

	
	public void onTestStart(ITestResult result) {
		 System.out.println("Test Execution Started");
	  }
	
	public void onTestSuccess(ITestResult result) {
		    // not implemented
		  }

	public void onTestFailure(ITestResult result) {
		    // not implemented
		  }
	 
	public void onTestSkipped(ITestResult result) {
		    // not implemented
		  }
	 
	public void onFinish(ITestContext context) {
		 System.out.println("Test Finished");
		  }
}
