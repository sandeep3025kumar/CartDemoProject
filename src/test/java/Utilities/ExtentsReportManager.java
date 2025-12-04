package Utilities;

import java.awt.Desktop;
import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import TestBase.BaseClass;


public class ExtentsReportManager implements ITestListener{
	
	public ExtentSparkReporter sparkReport;
	public ExtentReports extent;
	public ExtentTest test;

	public String reportName;

	public void onStart(ITestContext testContext) {

		/*
		 * SimpleDateFormat df = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss"); Date dt =
		 * new Date(); String currentDateTimeStamp=df.format(dt);
		 */

		String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
		reportName = "Test-Report-" + timeStamp + ".html";
		sparkReport = new ExtentSparkReporter(".\\reports\\" + reportName);

		sparkReport.config().setDocumentTitle("Opencart Automtion Report");
		sparkReport.config().setReportName("opencart Funtional Testing");
		sparkReport.config().setTheme(Theme.STANDARD);

		extent = new ExtentReports();
		extent.attachReporter(sparkReport);
		extent.setSystemInfo("Appliation", "openCart");
		extent.setSystemInfo("Module", "Admin");
		extent.setSystemInfo("SubModule", "Customer");
		extent.setSystemInfo("User", System.getProperty("user.name"));
		extent.setSystemInfo("Environment", "QA");

		String os = testContext.getCurrentXmlTest().getParameter("os");
		extent.setSystemInfo("Operating System", "os");

		String browser = testContext.getCurrentXmlTest().getParameter("browser");
		extent.setSystemInfo("Browser", "browser");

		List<String> includeGrioups = testContext.getCurrentXmlTest().getIncludedGroups();
		if (!includeGrioups.isEmpty()) {
			extent.setSystemInfo("Groups", includeGrioups.toString());
		}

	}

	public void onTestSuccess(ITestResult result) {

		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to display the groups in report.
		test.log(Status.PASS, result.getName() + "got successfully executed");

	}

	public void onTestFail(ITestResult result) {

		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());// to display the groups in report.
		test.log(Status.FAIL, result.getName() + "got failed");
		test.log(Status.INFO, result.getThrowable().getMessage());
		
		try{
			String imgPath=new BaseClass().captureScreenShort(result.getName());
			test.addScreenCaptureFromPath(imgPath);
		} catch(Exception e1) {
			e1.printStackTrace();
		}

	}

	public void onSkipped(ITestResult result) {
		test = extent.createTest(result.getClass().getName());
		test.assignCategory(result.getMethod().getGroups());
		test.log(Status.SKIP, result.getName() + "got skipped");
		test.log(Status.INFO, result.getThrowable().getMessage());
	}

	public void onFinish(ITestContext testContext) {
		extent.flush();
		
		String pathOfExtentReport=System.getProperty("user.dir") + "\\reports\\" +reportName;
		File extentReport=new File(pathOfExtentReport);
		
		try {
			Desktop.getDesktop().browse(extentReport.toURI());
			
		}catch(IOException e1) {
			e1.printStackTrace();
		}
		

	}

}
