package com.cec.qa.base;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Transferable;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchFrameException;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cec.qa.util.ExcelUtil;
import com.cec.qa.util.TestUtil;
import com.cec.qa.util.WebEventListener;
import com.browserstack.local.Local;

public class BaseTest {
	public static WebDriver driver;
	public static Properties propv;
	public static final String currentPropDir = System.getProperty("user.dir");
	String configPropertiesFilePath = currentPropDir + "\\src\\main\\java\\com\\cec\\qa\\config\\config.properties";
	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer32.exe";
	//static String IEdriverPath = "C:\\WebDrivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";
	
	static String ChromeDriverPath = currentPropDir + "\\src\\main\\drivers\\chromedriver_win32\\Chromedriver78.exe";
	static String FFDriverPath = currentPropDir + "\\src\\main\\drivers\\geckodriver-v0.23.0-win64\\geckodriver32.exe";
	JavascriptExecutor js = (JavascriptExecutor) driver;
	public  static EventFiringWebDriver e_driver;
	public static WebEventListener eventListener;

	public static final String USERNAME = "adityabaliga2";
	  public static final String AUTOMATE_KEY = "MubgnFdqKfGvXhmpEFa8";
	  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

	//Browserstack requirements
	////public static final String USERNAME = "vishnuvardhanagc1";
	//public static final String AUTOMATE_KEY = "ZPhoyyy7qd2ajxZg8pkp";
	//public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";
	
	
	//Constructor: to initialize and load properties in prop.
	public BaseTest()  {
		try {
			propv = new Properties();
			FileInputStream fi = new FileInputStream(configPropertiesFilePath);
			propv.load(fi);
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	}
	
	//Method: Initialization of given browser and setting prerequisites of the test browser.
	public static void initialization(String browserName,String url) throws Exception {
		if(browserName.equals("chrome")) {
			killBrowserProcess();
			System.setProperty("webdriver.chrome.driver", ChromeDriverPath);
			driver = new ChromeDriver();
			browserSettingsAndURLEntry(url);
		}else if(browserName.equals("FF")) {
			killBrowserProcess();
			System.setProperty("webdriver.gecko.driver", FFDriverPath);
			driver = new FirefoxDriver();
			browserSettingsAndURLEntry(url);
		}else if(browserName.equals("IE")) {
			killBrowserProcess();
			System.setProperty("webdriver.ie.driver", IEdriverPath);
			driver = new InternetExplorerDriver();
			browserSettingsAndURLEntry(url);
		}else if(browserName.equalsIgnoreCase("API")){
			ExcelUtil.readFileSheet("API");
		}else if(browserName.equalsIgnoreCase("BRANDAPI")) {
			ExcelUtil.readFileSheet("BRANDAPI");
		}
	}

	//Method: Initialization of given browserstack browser and setting prerequisites of the test browser.
		public static void initialization(String browserName,String url,String browserStack) throws Exception {
			//killBrowserProcess();
			
			if(browserName.equals("chrome")) {
				DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", "Chrome");
			    caps.setCapability("browser_version", "74.0 beta");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "7");
			    caps.setCapability("resolution", "1024x768");
			    caps.setCapability("browserstack.local", "true");
			    driver = new RemoteWebDriver(new URL(URL), caps);
				browserSettingsAndURLEntry(url);
			}else if(browserName.equals("FF")) {
				DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", "Firefox");
			    caps.setCapability("browser_version", "67.0 beta");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "7");
			    caps.setCapability("resolution", "1024x768");
			    caps.setCapability("browserstack.local", "true");
			    driver = new RemoteWebDriver(new URL(URL), caps);
				browserSettingsAndURLEntry(url);
			}else if(browserName.equals("Opera")) {
				DesiredCapabilities caps = new DesiredCapabilities();
			    caps.setCapability("browser", "Opera");
			    caps.setCapability("browser_version", "12.16");
			    caps.setCapability("os", "Windows");
			    caps.setCapability("os_version", "7");
			    caps.setCapability("resolution", "1024x768");
			    caps.setCapability("browserstack.local", "true");
			    driver = new RemoteWebDriver(new URL(URL), caps);
				browserSettingsAndURLEntry(url);
			}else if(browserName.equals("android")) {
				 System.out.println("1");
				 DesiredCapabilities caps = new DesiredCapabilities();
			   /* caps.setCapability("browser", "Safari");
			    caps.setCapability("browser_version", "10.0");
			    caps.setCapability("os", "OS X");
			    caps.setCapability("os_version", "Sierra");
			    caps.setCapability("resolution", "1024x768");
			    caps.setCapability("browserstack.local", "true");
			    driver = new RemoteWebDriver(new URL(URL), caps);
				browserSettingsAndURLEntry(url);*/
				
			    //caps.setCapability("os", "OS X");
				 /*capability.setPlatform(Platform.MAC);
				 capability.setBrowserName("Safari");
				 capability.setVersion("10.0");
				 capability.setCapability("browserstack.local", "true");
				 capability.setCapability("browserstack.debug", "true");*/
				// caps.setCapability("browserName", "android");
				   // caps.setCapability("device", "Samsung Galaxy Note 10 Plus");
				    caps.setPlatform(Platform.ANDROID);
				    caps.setCapability("browserName", "android");
				    caps.setCapability("device", "OnePlus 7");
				    caps.setCapability("realMobile", "true");
				    caps.setCapability("os_version", "9.0");
				    //caps.setCapability("realMobile", "true");
				    //caps.setCapability("os_version", "9.0");
				    caps.setCapability("autoGrantPermissions", "true");
				    caps.setCapability("browserstack.local", "true");
				    caps.setCapability("browserstack.debug", "true");
				    ChromeOptions options = new ChromeOptions();
				    Map < String, Object > prefs = new HashMap < String, Object > ();
				    Map < String, Object > profile = new HashMap < String, Object > ();
				    Map < String, Object > contentSettings = new HashMap < String, Object > ();

				    // SET CHROME OPTIONS
				    // 0 - Default, 1 - Allow, 2 - Block
				    contentSettings.put("geolocation", 1);
				    profile.put("managed_default_content_settings", contentSettings);
				    prefs.put("profile", profile);
				    options.setExperimentalOption("prefs", prefs);

				    // SET CAPABILITY
				    caps.setCapability(ChromeOptions.CAPABILITY, options);
			     System.out.println("settings done");
				 // Creatng URL object
				 URL browserStackUrl = new URL(URL);
				 System.out.println("settings done1");
				 driver = new RemoteWebDriver (browserStackUrl, caps);
				 //Implicit wait for 30 seconds
				 System.out.println("settings done2");
				 driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				 // to open url
				 System.out.println("settings done3");
				 driver.get("https://qa.chuckecheese.com/kids-birthday-party");
				  System.out.println("url opened");
				  
			}else if(browserName.equalsIgnoreCase("API")){
				ExcelUtil.readFileSheet("API");
			}else if(browserName.equalsIgnoreCase("BRANDAPI")) {
				ExcelUtil.readFileSheet("BRANDAPI");
			}
		}

	//Method: to maximize, set timeouts, delete cookies from browser and launch url;
	public static void browserSettingsAndURLEntry(String url){
			//Listener initialization 
			e_driver = new EventFiringWebDriver(driver);
			eventListener = new WebEventListener(); 
			e_driver.register(eventListener);
			driver = e_driver;
			//Browser initialization before launch 
			driver.manage().window().maximize();
			driver.manage().timeouts().pageLoadTimeout(TestUtil.PageLoadTimeOut,TimeUnit.SECONDS);
			driver.manage().timeouts().implicitlyWait(TestUtil.ImplicitTimeOut, TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(url);
	}
	
	//Method: to click on main menu and sub menu by using mouse actions
	public void clickOnSubMenu(WebDriver driver, String mainMenuXpath, String subMenuXpath) {
		WebElement tu_mainMenu = driver.findElement(By.xpath(mainMenuXpath));
		WebElement tu_subMenu = driver.findElement(By.xpath(subMenuXpath));

		Actions act = new Actions(driver);
		act.moveToElement(tu_mainMenu).click().build().perform();
		act.click(tu_subMenu).build().perform();
	}

	//Method: select list item as per given list item text
	public void selectSingleDropDownItem(WebDriver driver, WebElement attSelectCustListBox, String custListOption) {
		Select dropDownElement = new Select(attSelectCustListBox);
		dropDownElement.selectByVisibleText(custListOption);
	}
	
	// Methods to get dropdown values
	public List getDropdownValue(WebElement element) {
		Select res = new Select(element);
		List<WebElement> l= res.getOptions();
		
		return l;
	}

	//Method: to get today's date in MMM dd, yyyy format.
	public String getTodaysDate() {
		Date myDate = new Date();
		System.out.println(myDate);
		SimpleDateFormat sm = new SimpleDateFormat("dd MMM,yyyy");
		String strDate = sm.format(myDate);
		return strDate;
	}

	//Method: to get future date in dd/mm/yyyy format based on giving bookingDate inputs.
	//MMDD
	public String getFutureDateInDDMMYYYY(int bookingDate) {
		Calendar cal = Calendar.getInstance();
		// System.out.println("current date: " + cal.getTime()); // Current date
		cal.add(Calendar.DATE, bookingDate);
		// System.out.println("10 days later: " + cal.getTime()); //Future date
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");
		return sm.format(fDate);
	}

	//Method: to get future date in MM/dd/yyyy format based on giving bookingDate inputs.
	//This methods used in Store App to enter date in MMDDYYYY format.
	public static String getFutureDateInMMDDYYYY(int bookingDate) {
		Calendar cal = Calendar.getInstance();
		// System.out.println("current date: " + cal.getTime()); // Current date
		cal.add(Calendar.DATE, bookingDate);
		// System.out.println("10 days later: " + cal.getTime()); //Future date
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");
		return sm.format(fDate);
	}
	//Method: to get future date in yyyy-MM-dd format based on giving bookingDate inputs.
		//This methods used in RV Admin to enter date in yyyy-mm-dd format.
		public String getFutureDateInYYYYMMDD(int bookingDate) {
			Calendar cal = Calendar.getInstance();
			// System.out.println("current date: " + cal.getTime()); // Current date
			cal.add(Calendar.DATE, bookingDate);
			// System.out.println("10 days later: " + cal.getTime()); //Future date
			Date fDate = cal.getTime();
			SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
			return sm.format(fDate);
		}
	
	//Method: to get second SUNDAY after present date in dd-mm-yyyy format.
	public String getSecondFutureSundayDateInDDMMYYYY() {
		Calendar c=Calendar.getInstance();
		c.set(Calendar.DAY_OF_WEEK,Calendar.SUNDAY);
		DateFormat df=new SimpleDateFormat("dd/MM/yyyy");
		c.add(Calendar.DATE,14);
		//System.out.println(df.format(c.getTime()));
		return df.format(c.getTime());
	}

	//Method: to generate Random string with 6 chars.
	protected String getSaltString() {
		String SALTCHARS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 6) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTCHARS.length());
			salt.append(SALTCHARS.charAt(index));
		}
		String saltStr = salt.toString();
		return saltStr;

	}


	//Method: to generate Random number with 10 digits.
	protected String getSaltNumber() {
		String SALTNUM = "1234567890";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 10) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTNUM.length());
			salt.append(SALTNUM.charAt(index));
		}
		String saltNum = salt.toString();
		return saltNum;

	}

	//Method: to generate Random email address.
	protected String getSaltEmail() {
		String SALTEMAIL = "abcdefghijklmnopqrstuvwxyz";
		StringBuilder salt = new StringBuilder();
		Random rnd = new Random();
		while (salt.length() < 4) { // length of the random string.
			int index = (int) (rnd.nextFloat() * SALTEMAIL.length());
			salt.append(SALTEMAIL.charAt(index));
		}
		String saltEMAIL = salt.toString();
		String fullEmail = saltEMAIL+"@"+saltEMAIL+".com";
		return fullEmail;

	}
	
	protected String getSaltAge() {
		   Random rand = new Random(); 
		   
	        // Generate random integers in range 0 to 999 
	        int age = rand.nextInt(100);
	       String rand_age = Integer.toString(age);
			return rand_age; 
	}


	//Method: Click on WebElement in the list of WebElements.
	public static void selectElementByListByTextOfAnElement(List<WebElement> AttAllReportTabNameList, String tabName) {
		int listSize = AttAllReportTabNameList.size();
		for(int i=0;i<listSize;i++)
		{
			if(AttAllReportTabNameList.get(i).getText().contains(tabName)) {
				AttAllReportTabNameList.get(i).click();
			}
		}
	}

	//Method: to switchTo - Child Window, getText of given WebElement and close.
	public String getTextAndCloseChildWindow(WebElement webElement) {
		String x = null;
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String childWindow: allWindows) {
			if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				x = webElement.getText();
				driver.close();
				driver.switchTo().window(mainWindow);
				return x;
			}
		}
		return x;

	}

	//Method: to switchTo - Child Window and close.
	public void closeChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String childWindow: allWindows) {
			if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				driver.close();
				driver.switchTo().window(mainWindow);
			}
		}

	}


	//Method: to switchTo - Child Window get Window title and close.
	public String getTitleAndCloseChildWindow() {
		String x = null;
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String childWindow: allWindows) {
			if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
				x = driver.getTitle();
				driver.close();
				driver.switchTo().window(mainWindow);
				return x;
			}
		}
		return x;
	}


	//Method: to switchTo - Child Window.
	public void switchToChildWindow() {
		String mainWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String childWindow: allWindows) {
			if(!childWindow.equals(mainWindow)) {
				driver.switchTo().window(childWindow);
			}
		}

	}

	//Method: to switchTo - Main Window. [use after using switch to switchToChildWindow()]
	public void switchToMainWindow() {
		String childWindow = driver.getWindowHandle();
		Set<String> allWindows = driver.getWindowHandles();

		for(String mainWindow: allWindows) {
			if(!mainWindow.equals(childWindow)) {
				driver.switchTo().window(mainWindow);
			}
		}

	}

	//Method: to switchTo - ALert()
	public static void switchToAlert() {
		try {
			driver.switchTo().alert();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	//Method: to switchTo - ALert() and Accept.
	public static void switchToAlertAndAccept() {
		try {
			Alert a = driver.switchTo().alert();
			a.accept();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	//Method: to switchTo - ALert() and Dismiss.
	public static void switchToAlertAndDismiss() {
		try {
			Alert a = driver.switchTo().alert();
			a.dismiss();
		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
	}

	//Method: to switchTo - ALert() and Dismiss.
	public String switchToAlertAndAcceptReturnTitle() {
		String alertMessage = null;

		try {
			Alert a = driver.switchTo().alert();
			alertMessage = a.getText();
			a.accept();

		}catch(NoAlertPresentException e) {
			e.printStackTrace();
		}
		return alertMessage;
	}

	//Method: to switchTo - Frame()
	public static void switchToFrame() {
		try {
			driver.switchTo().frame(0);
		}catch(NoSuchFrameException e) {
			e.printStackTrace();
		}
	}

	//Method: getClipboard string (it gives cntr+c data/string in return)
	public String getClipboardText(){
		String x = null;
		try {
			Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
			Transferable contents = clipboard.getContents(null);
			x = (String) contents.getTransferData(DataFlavor.stringFlavor);
			return x;

		}catch(UnsupportedFlavorException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
		return x;
	}

	//Method:clearClipboard string (it set Clipboard as null)
	public void clearClipboardText() {
		StringSelection stringSelection = new StringSelection("");
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(stringSelection, null);
	}


	/*	//Sikuli image click
		public void clickUsingSikuli(String ImageLocation) {
            Screen s = new Screen();

            try{
                    s.click("imgs/win-start.png", 0);
                    s.wait("imgs/spotlight-input.png");
                    s.type(null, "hello world\n", 0);
            }
            catch(FindFailed e){
                    e.printStackTrace();
            }

    }*/

	//Method:Enter date into Date Input box using Robot

	public void enterDateUsingRobot(int bookingDate) throws AWTException {
		String vdate = null;
		if(bookingDate==0){
			vdate = getSecondFutureSundayDateInDDMMYYYY();
		}else{
			vdate = getFutureDateInDDMMYYYY(bookingDate);
		}
		String vdatedigit = vdate.replace("/", "");
		Robot robot = new Robot(); 
		for (char c : vdatedigit.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException(
						"Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.delay(100);
			robot.keyRelease(keyCode);
			robot.delay(100);
			//robot.delay(4000);
		}

	}                              

	//Method:Enter data using Robot [Case sensitive robot method it used child methods needsShift() to check case]
	public void enterDataUsingRobot(String dataValue) throws AWTException {
		Robot robot = new Robot(); 
		for (char c : dataValue.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException(
						"Key code not found for character '" + c + "'");
			}
			if(needsShift(c)){
				robot.keyPress(KeyEvent.VK_SHIFT);
				//robot.delay(30);
			}
			robot.keyPress(keyCode);
			//robot.delay(30);
			robot.keyRelease(keyCode);
			//robot.delay(30);
			if(needsShift(c)){
			    robot.keyRelease(KeyEvent.VK_SHIFT);
			    //robot.delay(30);
			} 
		}
	}
	//Child method to check case of the parent method: enterDataUsingRobot() chars.
	private boolean needsShift(Character c) {
	    return Character.isUpperCase(c);
	}
	
	
	//Method:Enter date into Date Input box using Robot for chrome
	
	public void enterDateUsingRobotForChrome(int bookingDate) throws AWTException {
		String vdate = null;
		if(bookingDate==0){
			vdate = getSecondFutureSundayDateInDDMMYYYY();
		}else{
			vdate = getFutureDateInDDMMYYYY(bookingDate);
		}
		String vdatedigit = vdate.replace("/", "");
		String vdateDDMM = vdatedigit.substring(0,4);
		Robot robot = new Robot(); 
		for (char c : vdateDDMM.toCharArray()) {
			int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
			if (KeyEvent.CHAR_UNDEFINED == keyCode) {
				throw new RuntimeException(
						"Key code not found for character '" + c + "'");
			}
			robot.keyPress(keyCode);
			robot.delay(100);
			robot.keyRelease(keyCode);
			robot.delay(100);
			//robot.delay(4000);
		}

	}               

	//Method: get only Today's date like: 01/31/.. 
	public static String getTodaysDateInDD(){
		String vdate = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("dd/MM/yyyy");
		vdate = sm.format(fDate);
		String vdatedigit = vdate.replace("/", "");
		return vdatedigit.substring(0,2);
	}
	
	//Method: get only Today's day like: MON/TUE/... 
	public static String getTodaysDateInDay(){
		String vDate = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("EEE");
		vDate = sm.format(fDate);
		String vDateDay = vDate.replace("/", "");
		return vDateDay.substring(0,3).toUpperCase();
	}
	//Method: get only Given date in day like: MON/TUE/... 
		public static String getGivenDateInDay(int vdate){
			String vDate = null;
			Calendar cal = Calendar.getInstance();
			cal.add(Calendar.DATE, vdate);
			Date fDate = cal.getTime();
			SimpleDateFormat sm = new SimpleDateFormat("EEE");
			vDate = sm.format(fDate);
			String vDateDay = vDate.replace("/", "");
			return vDateDay.substring(0,3).toUpperCase();
		}
	//Method: get only current month like: JAN/FEB/... 
	public static String getCurrentMonth(){
		String vDate = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("MMM");
		vDate = sm.format(fDate);
		String vMonth = vDate.replace("/", "");
		return vMonth.substring(0,3).toUpperCase();
	}
	
	//Method: get only current Time in Seconds 
	public static String getCurrentTimeInSS(){
		String vSeconds = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("ss");
		vSeconds = sm.format(fDate);
		//String vMonth = vDate.replace(":", "");
		return vSeconds;
	}
	
	//Method: get only current Date in dd 
	public static String getCurrentTimeInDD(){
		String vDate = null;
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, 0);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("dd");
		vDate = sm.format(fDate);
		//String vMonth = vDate.replace(":", "");
		return vDate;
	}
	
	//Method:Enter number into input box using Robot
	public void enterPhoneNumberUsingRobot(String bphone) throws AWTException {
		if(!bphone.equals("")){
			Robot robot = new Robot(); 
			String vnum = bphone;
			for (char c : vnum.toCharArray()) {
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException(
							"Key code not found for character '" + c + "'");
				}
				robot.keyPress(keyCode);
				robot.delay(100);
				robot.keyRelease(keyCode);
				robot.delay(100);
			}	
		}else{
			Robot robot = new Robot(); 
			String vnum = getSaltNumber();
			for (char c : vnum.toCharArray()) {
				int keyCode = KeyEvent.getExtendedKeyCodeForChar(c);
				if (KeyEvent.CHAR_UNDEFINED == keyCode) {
					throw new RuntimeException(
							"Key code not found for character '" + c + "'");
				}
				robot.keyPress(keyCode);
				robot.delay(100);
				robot.keyRelease(keyCode);
				robot.delay(100);
			}

		}
	}

	//Method:Enter number into input box using Robot
	public void enterDeleteUsingRobot() throws AWTException {
		Robot robot = new Robot(); 	
		robot.keyPress(KeyEvent.VK_DELETE);
		robot.delay(100);
		robot.keyRelease(KeyEvent.VK_DELETE); 
		robot.delay(100);
	}	


	//Method: Scroll Down the browser 
	public void scrollDown(WebDriver driver){
		js.executeScript("window.scrollBy(0,400)"); 
	}

	//Method: Scroll Up the browser
	public void scrollUp(WebDriver driver){
		js.executeScript("window.scrollBy(0,-400)"); 
		
	}
	

	//Method: to get current date in dd/mm/yyyy format based on giving bookingDate inputs.
	public String getCurrentDateInDDMMYYYY(int todaysDate) {
		Calendar cal = Calendar.getInstance();
		// System.out.println("current date: " + cal.getTime()); // Current date
		cal.add(Calendar.DATE, todaysDate);
		// System.out.println("10 days later: " + cal.getTime()); //Future date
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("MM/dd/yyyy");
		return sm.format(fDate);
	}

	//Method: to get current date and time.
	public String getCurrentDateAndTime_yyyy_MM_dd_HH_mm_ss() {
		Calendar cal = Calendar.getInstance();
		// System.out.println("current date: " + cal.getTime()); // Current date
		cal.add(Calendar.DATE, 0);
		// System.out.println("10 days later: " + cal.getTime()); //Future date
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		return sm.format(fDate);
	}
	
	/////////////////////////////////////////////////////////////////////////////////////////////////

	//		CALL CENTER GENERIC METHODS

	/////////////////////////////////////////////////////////////////////////////////////////////////	
	public static String expectedText;
	
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
	
	public static void explicitWaitXpathTillVisible(WebDriver driver, String element)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(element)));
	    
	}
	
	public static void getFirstSelectedOption(WebElement element)
	{
		try
		{
			Select res = new Select(element);	
			String str = res.getFirstSelectedOption().getText();
			System.out.println("the selected option is :-" + str);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}
	
	//Click Available Date
	public static void clickOnAvailableDate(WebDriver driver,int indexOfDate)
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
	
	public static void wait(int sec) {
		try {
			Thread.sleep(sec * 1000);
		} catch (InterruptedException e) {
			e.printStackTrace(); }
	}
	
	//scroll down
	public static void scrollDownCC(WebDriver driver) {
	try {
	JavascriptExecutor jse = (JavascriptExecutor) driver ;
	jse.executeScript("window.scrollBy(0,450)", "");
	}
	catch(Exception e)
	{ e.printStackTrace(); }
	}
	
	//scroll up
	public static void scrollUpCC(WebDriver driver) {
	try {
	JavascriptExecutor jse = (JavascriptExecutor) driver ;
	jse.executeScript("window.scrollBy(300,0)", "");
	}
	catch(Exception e)
	{ e.printStackTrace(); }
	}
	
	//gets the text of webelement
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
	
	public static void jsClick(WebDriver driver, WebElement el) {
		JavascriptExecutor executor = (JavascriptExecutor) driver;
		executor.executeScript("arguments[0].click()", el);
	}
	/////////////////////////////////////////////////////////////////////////////////////////////////

	//		PROCESS KILL METHODS

	/////////////////////////////////////////////////////////////////////////////////////////////////
	
	//Process killer variables initialization
	private static final String TASKLIST = "tasklist";
	private static final String KILL = "taskkill /F /IM ";
	//Checks process availability by name
	public static boolean isProcessRunning(String serviceName) throws Exception {
	 Process p = Runtime.getRuntime().exec(TASKLIST);
	 BufferedReader reader = new BufferedReader(new InputStreamReader(
	   p.getInputStream()));
	 String line;
	 while ((line = reader.readLine()) != null) {
	  System.out.println(line);
	  if (line.contains(serviceName)) {
	   return true;
	  }
	 }
	 return false;
	}
	//kills Process by Name
	public static void killProcess(String serviceName) throws Exception {
	  Runtime.getRuntime().exec(KILL + serviceName);
	 }
	//Calling methods to kill process
	public static void killBrowserProcess() throws Exception{
		//Firefox Process
		 String ffProcess = "firefox.exe";
		 String ffDriverprocess = "geckodriver.exe";
		 //Chrome Process
		 String chProcess = "chrome.exe";
		 String chDriverprocess = "chromedriver.exe";
		 //IE Process
		 String ieProcess = "iexplore.exe";
		 String ieDriverprocess = "IEDriverServer.exe";
		 //Conhost Process
		 String conProcess = "conhost.exe";
		if(propv.getProperty("GUI").equals("FF")){
			 if (isProcessRunning(ffProcess)) {
			  killProcess(ffProcess);
			 }
			 if (isProcessRunning(ffDriverprocess)) {
				  killProcess(ffDriverprocess);
			 }
		}else if(propv.getProperty("GUI").equals("chrome")){
			 if (isProcessRunning(chProcess)) {
				  killProcess(chProcess);
				 }
			 if (isProcessRunning(chDriverprocess)) {
				 killProcess(chDriverprocess);
			 }
		}
		else if(propv.getProperty("GUI").equals("IE")){
			 if (isProcessRunning(ieProcess)) {
				  killProcess(ieProcess);
			 }
			 if (isProcessRunning(ieDriverprocess)) {
				  killProcess(ieDriverprocess);
			 }
		}
		 if (isProcessRunning(conProcess)) {
			  killProcess(conProcess);
		 }
	}
		
	
	/////////////////////////////////////////////////////////////////////////////////////////////////

	//		PRODUCT SPECIFIC METHODS

	/////////////////////////////////////////////////////////////////////////////////////////////////

	//Choose NO THANKS in UpSell Pop-up.

	public void sayNoThanksToUpSell(WebElement upSellNoThanks,String upSellNoThanksXpath) throws InterruptedException {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(upSellNoThanksXpath)));
		upSellNoThanks.click();
	}

	//Choose UPGRADE in UpSell Pop-up.

	public void chooseUpSellUpgrade(WebElement upSellUpgrade, String upSellUpgradeXpath) {
		WebDriverWait wait = new WebDriverWait(driver,30);
		wait.until(ExpectedConditions.elementToBeClickable(By.xpath(upSellUpgradeXpath)));
		upSellUpgrade.click();
	}

	//Remove or Add Child or Adult

	public void addORRemoveChildORAdult(WebElement addORRemoveElement, int cCount) {
		for(int i=1;i<=cCount;i++)
		{
			waitAndClick(addORRemoveElement);
		}

	}
	//me
	public void waitUntilElementClickable(WebElement vWebElement) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(vWebElement));
	}

	public void waitUntilElementVisible(WebElement vWebElement) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.visibilityOf(vWebElement));
	}
	//External wait till clickable and click
	public void waitAndClick(WebElement vWebElement) {
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(vWebElement));
		vWebElement.click();
	}

	//External wait: to wait and get text
		public String waitAndGetText(WebElement vWebElement) {
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebDriverWait wait = new WebDriverWait(driver,20);
			wait.until(ExpectedConditions.elementToBeClickable(vWebElement));
			vWebElement.click();
			return vWebElement.getText();
		} 
		
	//External wait till visible and get text
	public static String waitTillVisibleAndGetText(WebElement vWebElement, String eLocator)
	{
		WebDriverWait wait = new WebDriverWait(driver, 20);
		wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath(eLocator)));
		return vWebElement.getText();
	}
	public static void waitForElementClick(WebElement vWebElement)
	{
		driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
		WebDriverWait wait = new WebDriverWait(driver,20);
		wait.until(ExpectedConditions.elementToBeClickable(vWebElement));
		
	}
	//Database query methods - Work in progress....
	public static void selectQuery() throws SQLException, ClassNotFoundException { 
		String dbURL = "jdbc:sqlserver://ipAddress:portNumber/dbName";
		String username = "dbusername";
		String password = "dbpassword";
		//Load MS SQL JDBC Driver
		Class.forName("net.sourceforge.jtds.jdbc.Driver");
		//Creating connection to the database
		Connection con = DriverManager.getConnection(dbURL,username,password);
		//Creating statement object
		Statement st = con.createStatement();
		String selectquery = "SELECT * FROM <tablename> WHERE <condition>";
		//Executing the SQL Query and store the results in ResultSet
		ResultSet rs = st.executeQuery(selectquery);
		//While loop to iterate through all data and print results
		while (rs.next()) {
			System.out.println(rs.getString("transaction_datetime"));
		}
		//Closing DB Connection
		con.close();
	}	


	//Find Available time slot for Birthday and click
	public static void selectAvailableTimeSlot(String BasePKG) throws InterruptedException { 
		Thread.sleep(5000);
		boolean isFound = false;
		int i=0;
		int j=0;
		int k=0;
		int l=0;
		int m=0;
		int n=0;
		if(BasePKG.equals("Star")){
			i=1;
			j=4;
			k=7;
			l=10;
			m=13;
			n=16;
		}else if(BasePKG.equals("SuperStar")){
			i=2;
			j=5;
			k=8;
			l=11;
			m=14;
			n=17;
		}else if(BasePKG.equals("MegaStar")){
			i=3;
			j=6;
			k=9;
			l=12;
			m=15;
			n=18;
		}
		
			try{
				String selectPackageStarXpath = "(//button[@title='Select Package'])["+i+"]";
				WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
				if(ele.isEnabled()){
					ele.click();
					isFound=true;
				}
			}catch(Exception e){
				//e.printStackTrace();
				System.out.println("!!!..........................FIRST TIME SLOT NOT AVAILABLE.....................!!!");
			}

			if(isFound!=true){
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+j+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
						isFound=true;
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................SECOND TIME SLOT NOT AVAILABLE.....................!!!");
				}
			}

			
			if(isFound!=true){
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+k+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................THIRD TIME SLOT NOT AVAILABLE.....................!!!");
				}	
			}

			if(isFound!=true){
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+l+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................FOURTH TIME SLOT NOT AVAILABLE.....................!!!");
				}
			}
			
			if(isFound!=true){
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+m+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................FIFTH TIME SLOT NOT AVAILABLE.....................!!!");
				}	
			}

			if(isFound!=true){
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+n+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................NO TIME SLOT NOT AVAILABLE.....................!!!");
				}	
			}
	}

	//Method: to get the Due date of a booking
		public String getDueDateMMDD(int todaysDate) throws AWTException {
			String vdate = getCurrentDateInDDMMYYYY(todaysDate+2);
			String vdatedigit = vdate.replace("/", "");
			String vdateDDMM = vdatedigit.substring(0,4); 
			String vdateDDMM1 = vdateDDMM.substring(0, 2);
			String vdateDDMM2 = vdateDDMM.substring(2, 4);
			vdateDDMM = vdateDDMM1+"/"+vdateDDMM2;
			return vdateDDMM;
		}
	
		//Find Available time slot for Event and click
		public static void selectEventAvailableTimeSlot(String BasePKG) throws InterruptedException { 
			Thread.sleep(5000);
			boolean isFound = false;
			int i=0;
			int j=0;
			int k=0;
			int l=0;
			int m=0;
			int n=0;
			if(BasePKG.equals("60min")){
				i=1;
				j=4;
				k=7;
				l=10;
				m=13;
				n=16;
			}else if(BasePKG.equals("90min")){
				i=2;
				j=5;
				k=8;
				l=11;
				m=14;
				n=17;
			}else if(BasePKG.equals("120min")){
				i=3;
				j=6;
				k=9;
				l=12;
				m=15;
				n=18;
			}
			
				try{
					String selectPackageStarXpath = "(//button[@title='Select Package'])["+i+"]";
					WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
					if(ele.isEnabled()){
						ele.click();
						isFound=true;
					}
				}catch(Exception e){
					//e.printStackTrace();
					System.out.println("!!!..........................FIRST TIME SLOT NOT AVAILABLE.....................!!!");
				}

				if(isFound!=true){
					try{
						String selectPackageStarXpath = "(//button[@title='Select Package'])["+j+"]";
						WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
						if(ele.isEnabled()){
							ele.click();
							isFound=true;
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("!!!..........................SECOND TIME SLOT NOT AVAILABLE.....................!!!");
					}
				}

				
				if(isFound!=true){
					try{
						String selectPackageStarXpath = "(//button[@title='Select Package'])["+k+"]";
						WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
						if(ele.isEnabled()){
							ele.click();
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("!!!..........................THIRD TIME SLOT NOT AVAILABLE.....................!!!");
					}	
				}

				if(isFound!=true){
					try{
						String selectPackageStarXpath = "(//button[@title='Select Package'])["+l+"]";
						WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
						if(ele.isEnabled()){
							ele.click();
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("!!!..........................FOURTH TIME SLOT NOT AVAILABLE.....................!!!");
					}
				}
				
				if(isFound!=true){
					try{
						String selectPackageStarXpath = "(//button[@title='Select Package'])["+m+"]";
						WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
						if(ele.isEnabled()){
							ele.click();
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("!!!..........................FIFTH TIME SLOT NOT AVAILABLE.....................!!!");
					}	
				}

				if(isFound!=true){
					try{
						String selectPackageStarXpath = "(//button[@title='Select Package'])["+n+"]";
						WebElement ele = driver.findElement(By.xpath(selectPackageStarXpath));
						if(ele.isEnabled()){
							ele.click();
						}
					}catch(Exception e){
						//e.printStackTrace();
						System.out.println("!!!..........................NO TIME SLOT NOT AVAILABLE.....................!!!");
					}	
				}
		}
		
		
		///////////////////////////////////BDD DROPDOWN//////////////
		public void selectUsingValue(WebElement element,String value)
		{
			Select select=new Select(element);
			
			select.selectByValue(value);
		}
		public void selectUsingIndex(WebElement element,int index)
		{
			Select select=new Select(element);
			
			select.selectByIndex(index);
		}
		
		public void ScrollToElement(WebElement element)
		{
		
			js.executeScript("window.scrollTo(arguments[0],arguments[1]",element.getLocation().x,element.getLocation().y);
			element.click();
		}
		
		
		
}
