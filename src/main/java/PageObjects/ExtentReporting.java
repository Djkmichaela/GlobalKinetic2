package PageObjects;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentReporting {
	
	 static ExtentReports extent;
	public static ExtentReports getExtentReport() {
		
		
		String path =	System.getProperty("user.dir")+"\\reports\\index.html";
		ExtentSparkReporter reporter = new ExtentSparkReporter(path);
		reporter.config().setReportName("Global Kinetic Test Results");
		reporter.config().setDocumentTitle("Tests");
		
		extent	 = new ExtentReports();
		extent.attachReporter(reporter);
		extent.setSystemInfo("Tester", "Michael Djamba");
		
	
		return extent;
		
		
	}

}
