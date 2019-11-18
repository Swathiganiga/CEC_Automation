package com.cec.qa.data;

	import static org.testng.Assert.assertEquals;

	import java.awt.Robot;
	import java.awt.Toolkit;
	import java.awt.datatransfer.StringSelection;
	import java.awt.event.KeyEvent;
	import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
	import java.util.Date;
import java.util.HashMap;
import java.util.List;
	import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

	import org.json.JSONException;
	import org.json.JSONObject;
	import org.openqa.selenium.By;
	import org.openqa.selenium.JavascriptExecutor;
	import org.openqa.selenium.WebDriver;
	import org.openqa.selenium.WebElement;
	import org.openqa.selenium.chrome.ChromeDriver;
	import org.openqa.selenium.firefox.FirefoxDriver;
	import org.openqa.selenium.ie.InternetExplorerDriver;
	import org.openqa.selenium.support.PageFactory;
	import org.openqa.selenium.support.events.EventFiringWebDriver;
	import org.openqa.selenium.support.ui.ExpectedCondition;
	import org.openqa.selenium.support.ui.ExpectedConditions;
	import org.openqa.selenium.support.ui.FluentWait;
	import org.openqa.selenium.support.ui.Select;
	import org.openqa.selenium.support.ui.WebDriverWait;
	import org.testng.Assert;
	import org.testng.asserts.SoftAssert;

	import com.google.common.base.Function;

	import io.qameta.allure.Step;
	import static org.hamcrest.CoreMatchers.containsString;
	import static org.hamcrest.MatcherAssert.assertThat;
	import static org.hamcrest.Matchers.is;
	import static org.hamcrest.Matchers.equalTo;

	public class CallCenterMethods{
//		public CEC_Login(WebDriver driver) {
//			super();
//		}

		public static Properties AppText = new Properties();
		public static Properties Repository = new Properties();
		public static String TestData;
		public static WebDriver driver;
		public static WebElement element;
		public static String webElement;
		CallCenterLocators page = PageFactory.initElements(driver, CallCenterLocators.class);
		
		static SoftAssert sa=new SoftAssert();
		
	
	public static void 	GetCalendarInstance()
	{
		try
		{
		Calendar calendar = Calendar.getInstance();
		Date date = calendar.getTime();
		System.out.println(" Date " + date);
		String snapname323 = " TestCase323_ " + date.toString().replaceAll(":", "-") + ".png";
		//ScreenShotCapture.captureSnap(driver, snapname323);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public static void jsClick(WebDriver driver, WebElement el) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", el);
	}
	
	
	
	//checks the visibility of an webElement
	public static void checkVisibilityOfWebElement(WebElement element)
	{
		boolean bflag = false;
		try
		{
			if(element.isDisplayed())
			{
				if(element.isEnabled())
				{
					bflag = true;
					element.click();
				}
				else
				{ 
					bflag = false; 
					System.out.println(element + "the button is not present");
				}
			}
			else
			{ 
				bflag = false; 
				System.out.println(element + "the button is not present");
			}
			Thread.sleep(4000);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}	
	
	
/*	public static List<WebElement> chkDateAvailabilityAndCorrespondingTimeSlot(List<WebElement> webelement)
	{
		boolean bflag = false;
		try
		{
			WebElement element1st = driver.findElement(By.xpath("//*[@class='ui-datepicker-group ui-datepicker-group-first']"));
			WebElement element2nd = driver.findElement(By.xpath("//*[@class='ui-datepicker-group ui-datepicker-group-middle']"));
			WebElement element3rd = driver.findElement(By.xpath("//*[@class='ui-datepicker-group ui-datepicker-group-last']"));
			
			HashMap<WebElement,List<WebElement>> map=new HashMap<WebElement,List<WebElement>>();
			
			map.put(element1st, webelement);
			map.put(element2nd, webelement);
			map.put(element3rd, webelement);
			
			List<WebElement> l = driver.findElements(By.xpath(webelement+"./ancestor::class[starts-with(.,'ui-datepicker-group ui-datepicker-group-'])"));
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		return webelement;
	}*/
	
	//stores all the listed radio button values, need to pass the index of the element we want to pass
	public static List<WebElement> selectRdoBtn(List<WebElement> webelement, int Value)
	{
	try
		{
		for (int i = 0; i < webelement.size(); i++) {
    	webelement.get(Value).click();
        Thread.sleep(3000);
        break;
    }
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	return webelement;
	}
		
	//Click Available Date
	public static void ClickAvailableDate(WebDriver driver,int indexOfDate)
	{
		try
		{
		//driver.findElement(By.id("btnShowCalendar")).click();
		Thread.sleep(1000);
			List<WebElement> NotSelectDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td/span[@class='ui-state-default']"));
			for(WebElement NotToSelect:NotSelectDates)
			{
				String actualAttributeOfNotSelect = NotToSelect.getAttribute("class");
				if(actualAttributeOfNotSelect.contains("ui-state-default"))
				{
					break;
				}
			}
			List<WebElement> NotToSelectDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']//td"));
			for(WebElement NotSelect:NotToSelectDates)
			{
				String actualAttributeOfNotSelect = NotSelect.getAttribute("class");
				if(actualAttributeOfNotSelect.contains("ui-datepicker-week-end undefined") || actualAttributeOfNotSelect.contains("ui-datepicker-today"))
				{
					break;
				}
			}
			List<WebElement> SelectDates=driver.findElements(By.xpath("//table[@class='ui-datepicker-calendar']/tbody/tr/td/a"));
			for(WebElement ToSelect:SelectDates)
			{
				SelectDates.size();
				String actualAttributeOfSelect = ToSelect.getAttribute("class");
				if(actualAttributeOfSelect.contains("ui-state-default") || (actualAttributeOfSelect.contains("ui-state-highlight")))
				{
					SelectDates.get(indexOfDate).click();
					break;
				}
			}
			Thread.sleep(2000);
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
	}	
		
	//	Validate Expected text And Actual Text from webPage
	public static void 	ValidateExpectedAndActualText(String Text, WebElement element)
		{
			try
			{
				String expectedText = Text; 
				String actualText = element.getText();
				System.out.println("The ReservationType selected is: " + expectedText);
				assertEquals(actualText, expectedText, "The Reservation Type does not match");
			}
			catch(Exception e)
			{ e.printStackTrace(); }
		}	

	//scroll down
	public static void scrollDown(WebDriver driver) {
	try {
	JavascriptExecutor jse = (JavascriptExecutor) driver ;
	jse.executeScript("window.scrollBy(0,450)", "");
	}
	catch(Exception e)
	{ e.printStackTrace(); }
	}
	
	//scroll up
	public static void scrollUp(WebDriver driver) {
	try {
	JavascriptExecutor jse = (JavascriptExecutor) driver ;
	jse.executeScript("window.scrollBy(300,0)", "");
	}
	catch(Exception e)
	{ e.printStackTrace(); }
	}
	
	public static void selectFirstChkBoxNSendValue(String Value)
	{
	try
		{
	String element = "//div[@class='accordion-content default']//input[starts-with(@name,'txtOptionalItem')]";
	List<WebElement> chkBox = driver.findElements(By.xpath(element));
	chkBox.size();
    System.out.println("Total element is " + chkBox.size());

    for (int i = 0; i < chkBox.size(); i++) {
    	chkBox.get(0).sendKeys(Value);
    	
        Thread.sleep(2000);
        break;
    }
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	//select the last element in a list 
	public static List<WebElement> selectLastElement(List<WebElement> webelement)
	{
	 try
	 { 
	  //int sizeOfList =  webelement.size();
	  WebElement element = webelement.get(webelement.size()-1);
	  element.click();
	  Thread.sleep(2000);
	  }catch(Exception e)
		{
		e.printStackTrace();
		}
	return webelement;
		
	}

	//Selects elements from dropdown by visible text
	public static void 	selectDrpDwnByText(WebElement element, String Value)
	{
		try
		{
			Select res = new Select(element);	
			res.selectByVisibleText(Value);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	public static String getFirstSelectedOption(WebElement element)
	{
		try
		{
			Select res = new Select(element);	
			String str = res.getFirstSelectedOption().getText();
			System.out.println("the selected option is :-" + str);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		return "Pass";
	}

	//Selects elements from dropdown by value
	public static void 	selectDrpDwnByValue(WebElement element, String Value)
	{
		try
		{
			Select res = new Select(element);	
			res.selectByValue(Value);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}

	//Selects elements from dropdown by index
	public static void 	selectDrpDwnByIndex(WebElement element, int Value)
	{
		try
		{
			Select res = new Select(element);	
			res.selectByIndex(Value);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	//gets the text of webelement
	public static String expectedText;
	public static String getText(WebElement element)
	{
		try
		{	
			expectedText = element.getText();
			System.out.println("The ReservationType selected is: " + expectedText);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		return expectedText;
		
	}
	public static String validateText(WebElement element)
	{
		try
		{	
			String expectedText = element.getText();
			System.out.println("The ReservationType selected is: " + expectedText);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		return expectedText;
	}

	public static String explicitWaitXpathTillVisible(WebDriver driver, String element)
		{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
		return "Pass";
		}
		
	public static WebElement explicitWaitForElementToBeClickable() throws Exception
	{
		WebElement element = getWebElement(webElement);
		try
		{
		WebDriverWait wait = new WebDriverWait(driver,60);
	    wait.until(ExpectedConditions.elementToBeClickable(element));
		}
		catch(Exception e)
		{ e.printStackTrace(); }
		 return element;
	}

	public static String callWaitFunction() throws Exception
	{
		explicitWaitForElementToBeClickable();
		return "Pass";
	}
		
		public static String InputText() {
			boolean bflag=true;
			System.out.println("InputText is called");
			try {
				WebElement element=getWebElement(webElement);
				if(element.isDisplayed())
				{
					if(element.isEnabled())
					{
						bflag=true;
						element.sendKeys(TestData);
					}
					else {
						bflag=false;}
				}
				else {
					bflag=false;}
				sa.assertAll();
				//getWebElement(webElement).sendKeys(TestData);
			}catch (Throwable t) {
				//return "Failed - Element not found "+webElement;
				t.printStackTrace();
			}
			//return bflag;
			return "Failed - Element not found "+webElement;
		}
		
		
		
		public static String ClickOnLink() {
			boolean bflag=true;
			System.out.println("ClickOnLink is called");
			try {
				WebElement element=getWebElement(webElement);
				if(element.isDisplayed())
				{
					if(element.isEnabled())
					{
						bflag=true;
						element.click();
					}
					else {
						bflag=false;}
				}
				else {
					bflag=false;}
				//getWebElement(webElement).click();
			}catch (Throwable t) {
				t.printStackTrace();
				return "Failed - Element not found "+webElement;
			}
			return "Pass";
		}

		public static String VerifyText() {
			System.out.println("VerifyText is called");
			try {
				String ActualText= getWebElement(webElement).getText();
				System.out.println(ActualText);
				
				sa.assertEquals(ActualText, TestData);
			/*	
				if(!ActualText.equals(TestData)) {
					return "Failed - Actual text "+ActualText+" is not equal to to expected text "+TestData;
				}
			*/
			}catch (Throwable t) {
				return "Failed - Element not found "+webElement;
			}
			return "Pass";
		}


		public static String VerifyAppText() {
			System.out.println("VerifyText is called");
			try {
				String ActualText= getWebElement(webElement).getText();
				if(!ActualText.equals(AppText.getProperty(webElement))) {
					return "Failed - Actual text "+ActualText+" is not equal to to expected text "+AppText.getProperty(webElement);
				}
			}catch (Throwable t) {
				return "Failed - Element not found "+webElement;
			}
			return "Pass";
		}
		
		
	   /**
	    * This Method will return web element.
	    * @param locator
	    * @return
	    * @throws Exception
	    */
		public static WebElement getLocator(String locator) throws Exception {
	        String[] split = locator.split(":");
			String locatorType = split[0];
			String locatorValue = split[1];

			if (locatorType.toLowerCase().equals("id"))
				return driver.findElement(By.id(locatorValue));
			else if (locatorType.toLowerCase().equals("name"))
				return driver.findElement(By.name(locatorValue));
			else if ((locatorType.toLowerCase().equals("classname"))|| (locatorType.toLowerCase().equals("class")))
				return driver.findElement(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("tagname"))
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElement(By.tagName(locatorValue));
			else if ((locatorType.toLowerCase().equals("linktext"))
					|| (locatorType.toLowerCase().equals("link")))
				return driver.findElement(By.linkText(locatorValue));
			else if (locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElement(By.partialLinkText(locatorValue));
			else if ((locatorType.toLowerCase().equals("cssselector"))
					|| (locatorType.toLowerCase().equals("css")))
				return driver.findElement(By.cssSelector(locatorValue));
			else if (locatorType.toLowerCase().equals("xpath"))
				return driver.findElement(By.xpath(locatorValue));
			else
				throw new Exception("Unknown locator type '" + locatorType + "'");
		}
		
		public static List<WebElement> getLocators(String locator) throws Exception {
	        String[] split = locator.split(":");
			String locatorType = split[0];
			String locatorValue = split[1];

			if (locatorType.toLowerCase().equals("id"))
				return driver.findElements(By.id(locatorValue));
			else if (locatorType.toLowerCase().equals("name"))
				return driver.findElements(By.name(locatorValue));
			else if ((locatorType.toLowerCase().equals("classname"))
					|| (locatorType.toLowerCase().equals("class")))
				return driver.findElements(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("tagname"))
					|| (locatorType.toLowerCase().equals("tag")))
				return driver.findElements(By.className(locatorValue));
			else if ((locatorType.toLowerCase().equals("linktext"))
					|| (locatorType.toLowerCase().equals("link")))
				return driver.findElements(By.linkText(locatorValue));
			else if (locatorType.toLowerCase().equals("partiallinktext"))
				return driver.findElements(By.partialLinkText(locatorValue));
			else if ((locatorType.toLowerCase().equals("cssselector"))
					|| (locatorType.toLowerCase().equals("css")))
				return driver.findElements(By.cssSelector(locatorValue));
			else if (locatorType.toLowerCase().equals("xpath"))
				return driver.findElements(By.xpath(locatorValue));
			else
				throw new Exception("Unknown locator type '" + locatorType + "'");
		}
		
		public static WebElement getWebElement(String locator) throws Exception{
			System.out.println("locator data:-"+locator+"is---"+Repository.getProperty(locator));
			return getLocator(Repository.getProperty(locator));
		}
		
	/*	public static WebElement getTestData(String testData) throws Exception{
			System.out.println("test data:-"+testData+"is---"+Repository.getProperty(testData));
			return getLocator(Repository.getProperty(testData));
		}*/
		
		public static List<WebElement> getWebElements(String locator) throws Exception{
			return getLocators(Repository.getProperty(locator));
		}
		
		
		public static String expliciteWait(){
	     try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			return "Failed - unable to load the page";
		}
	     return "Pass";
		}
		
		
		public static String clickWhenReady(By locator, int timeout) {
			WebElement element = null;
			WebDriverWait wait = new WebDriverWait(driver, timeout);
			element = wait.until(ExpectedConditions.elementToBeClickable(locator));
			element.click();
			return "Pass";

		}


		
		public static String waitFor() throws InterruptedException {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				return "Failed - unable to load the page";
			}
			return "Pass";
		}
		
		
		
		public static void robotLogIn() throws Exception {
			System.out.println("robotLogIn is called");
			try {
				// wait - increase this wait period if required
				Thread.sleep(5000);
				StringSelection ss = new StringSelection(TestData);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(ss, null);
				Robot rb = new Robot();
				
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);
				//System.out.println("robotLogIn is going on");
				// press enter
				rb.keyPress(KeyEvent.VK_ENTER);
				rb.keyRelease(KeyEvent.VK_ENTER);
				Thread.sleep(2000);
				//System.out.println("robotLogIn is finished");
				
				//rb.keyPress(KeyEvent.VK_ENTER);
				//rb.keyRelease(KeyEvent.VK_ENTER);
				//Thread.sleep(2000);
	/*
				// Enter user name by CTRL-V
				StringSelection username = new StringSelection(sUserName);
				Toolkit.getDefaultToolkit().getSystemClipboard().setContents(username, null);
				rb.keyPress(KeyEvent.VK_CONTROL);
				rb.keyPress(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_V);
				rb.keyRelease(KeyEvent.VK_CONTROL);

				//tab to password entry field
				rb.keyPress(KeyEvent.VK_TAB);
				rb.keyRelease(KeyEvent.VK_TAB);
	*/
			} 
			catch (Exception ex) {
				System.out.println("Error in Login Thread: " + ex.getMessage());
				ex.printStackTrace();
			}
			}
		
		
		public static String LogIn() {
			System.out.println("LogIn is called");
			try {
				robotLogIn();
				}
			catch (Exception e) {
				e.printStackTrace();
				System.out.println("Failed to log in through robotLogIn" );
		}
			return "Pass";
		
		}
		
		public static void wait(int sec) {
			try {
				Thread.sleep(sec * 1000);
			} catch (InterruptedException e) {
				e.printStackTrace(); }
		}
		
		
		public static void closeBrowser(){
			driver.quit();
		}

		public WebDriver getDriver() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}
