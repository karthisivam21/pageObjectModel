package com.qa.reports;


import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

public class ExtentManager {
	 private static ExtentReports extent;

	    public static ExtentReports getInstance() {
	        String reportPath = System.getProperty("user.dir") + "/test-output/ExtentReport.html";
	        ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
	        reporter.config().setReportName("Automation Test Report");
	        reporter.config().setDocumentTitle("Test Results");

	        extent = new ExtentReports();
	        extent.attachReporter(reporter);
	        extent.setSystemInfo("Tester", "Your Name");
	        return extent;
	    }

}
