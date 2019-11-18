package com.cec.qa.tests;

import static org.testng.Assert.assertEquals;
	import static org.testng.Assert.assertTrue;

	import java.io.IOException;
	import java.lang.reflect.InvocationTargetException;
	import java.lang.reflect.Method;
	import java.util.List;
	import java.util.concurrent.TimeUnit;

	import org.apache.commons.logging.Log;
	import org.json.JSONException;
	import org.openqa.selenium.WebDriver;
	import org.testng.annotations.Listeners;
	import org.testng.annotations.Test;

	import org.json.JSONObject;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.openqa.selenium.support.ui.Select;
	import org.testng.Assert;
	import org.testng.TestListenerAdapter;
	import org.testng.annotations.BeforeClass;
	import org.testng.annotations.BeforeMethod;
	import org.testng.annotations.BeforeTest;
	import org.testng.annotations.DataProvider;


	import com.relevantcodes.extentreports.ExtentReports;
	import com.relevantcodes.extentreports.ExtentTest;

	import io.qameta.allure.Description;
	import io.qameta.allure.Epic;
	import io.qameta.allure.Feature;
	import io.qameta.allure.Severity;
	import io.qameta.allure.SeverityLevel;
	import io.qameta.allure.Step;
	import io.qameta.allure.Story;
	import org.apache.log4j.BasicConfigurator;
import com.cec.qa.pages.CallCenterPage;


	@Epic("Regression Tests")
	@Feature("call center")

	public class CallCenterTest {
	
		public static ExtentTest test;
		public static ExtentReports extent;
		public static WebDriver driver;
		public static String message;

		public WebDriver getDriver() {
	        return driver;
	    }

		@BeforeClass (alwaysRun = true)
		@Step("Login with browser : {0}")
		public WebDriver initiateBrowser() throws IOException
		{
			driver =  CallCenterPage.initBrowser("IE");
			System.out.println("Test Driver is"+driver);
			return driver;
		}

		@Step("{0}") 
		public static void logToReport(String message) {
		    System.out.println(message);
		}	

		@Step("Login to call center")
		@Test(priority = 0, description="Login to call center with a valid Username")
		@Severity(SeverityLevel.BLOCKER)
		@Description("Login to call center with password")
		@Story("call center Verification")
		public static void RobotLogin(Method method) throws IOException
		{
			System.out.println("Inside login test");
			CallCenterPage.RobotLogin();
			System.out.println("login done");
		}
		
		@Step("enter all the info and validate Confirm Button Functionality")
		@Test(enabled = true, priority = 2, description="Confirm Button Functionality")
		@Severity(SeverityLevel.BLOCKER)
		//@Description("Booking Information")
		@Story("call center Verification Of Confirm Button Functionality")
		
		public void VerificationOfConfirmButtonFunctionality_391(Method method) throws IOException
		{
			System.out.println("Confirm Button Functionality called");
			CallCenterPage.VerifyCofirmationNumberGeneratedOnBookingBirthdayPartyThroughCallCenter();
			//logToReport("enter Booking Info called");	
		}
}
	