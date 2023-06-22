package GenericUtilities;

import java.io.IOException;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

public class ListenersImplementation implements ITestListener
{

	ExtentReports report;
	ExtentTest test;

	public void onTestStart(ITestResult result)
	{
		// TODO Auto-generated method stub
		
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution started------");
		test=report.createTest(methodName);
	    test.log(Status.INFO, methodName + " Executuion Started ");


	}

	public void onTestSuccess(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution successfull------");
		
		test.log(Status.PASS, methodName+ " PASS ");
	}

	public void onTestFailure(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println("------Test Execution failed------");

		test.log(Status.FAIL, methodName + "FAIL");
		test.log(Status.WARNING, result.getThrowable());

		//Take Screen shot
        String screenShotName=methodName+ "-" +new JavaUtility().getSystemInFormat();

		WebDriverUtility wLib=new WebDriverUtility();
		try
		{
			String path=wLib.takeScreenShot(BaseClass.sDriver, screenShotName);
			test.addScreenCaptureFromPath(path);
		}
		catch(IOException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public void onTestSkipped(ITestResult result)
	{
		// TODO Auto-generated method stub
		String methodName = result.getMethod().getMethodName();
		System.out.println(methodName+"------Test Execution skipped------");
		System.out.println(result.getThrowable());

		test.log(Status.SKIP, methodName + " SKIPP ");
	}

	public void onTestFailedButWithinSuccessPercentage(ITestResult result)
	{
		// TODO Auto-generated method stub
	}

	public void onTestFailedWithTimeout(ITestResult result)
	{
		// TODO Auto-generated method stub
	}

	public void onStart(ITestContext context)
	{
		// TODO Auto-generated method stub

		System.out.println("------Test Execution started------");

		//Configure the extent
		ExtentSparkReporter html=new ExtentSparkReporter(".\\ExtentReport\\Report- "+ new JavaUtility().getSystemInFormat()+".html");
		html.config().setDocumentTitle("vTiger Execution Report");
		html.config().setReportName("Execution report BuildV2.3.1");
		html.config().setTheme(Theme.DARK);

		report =new ExtentReports();
		report.attachReporter(html);
		report.setSystemInfo("Base Browser", "Chrome");
		report.setSystemInfo("Base URL", "https://TestEnv.com");
		report.setSystemInfo("Base Platform", "Windows-Family");
		report.setSystemInfo("Reporter Name", "Hanamanth");

	}

	public void onFinish(ITestContext context)
	{
		// TODO Auto-generated method stub

		System.out.println("------Test Execution Completed------");
		report.flush();

	}
}
