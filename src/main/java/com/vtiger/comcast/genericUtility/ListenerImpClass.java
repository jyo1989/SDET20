package com.vtiger.comcast.genericUtility;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.testng.ITestListener;
import org.testng.ITestResult;

public class ListenerImpClass implements ITestListener{
	
	public void onTestFailure(ITestResult result) {
		
		String testScriptName=result.getMethod().getMethodName();
		
		EventFiringWebDriver eDriver=new EventFiringWebDriver(BaseClass.sdriver);
		File srcFile=eDriver.getScreenshotAs(OutputType.FILE);
		
		try {
			FileUtils.copyFile(srcFile, new File("./screenshotshots/"+testScriptName+".png"));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
