package com.cec.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cec.qa.base.BaseTest;
import com.cec.qa.data.CallCenterLocators;
import com.cec.qa.data.CallCenterUserData;
import com.fasterxml.jackson.databind.ser.impl.PropertySerializerMap.SerializerAndMapResult;

import io.qameta.allure.Step;


public class CallCenterReportsPage extends BaseTest{

	public  final static String currentPropDir = System.getProperty("user.dir");



	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";



	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//******************************Main Menu **************************************************

	@FindBy(xpath="//a[@title='Reports']")
	WebElement reportMenuLink;


	@FindBy(id="btnCloseTab")
	WebElement closeButton;

	//******************************Reports Links **************************************************

	//@FindBy(xpath="//a[contains(text(),'CEC Stats Report')]")
	@FindBy(xpath="/html/body/div[2]/div[1]/a")
	WebElement cecStatsReportLink;

	@FindBy(xpath="//a[contains(text(),'VIP Party Report')]")
	WebElement vipPartyReportLink;

	@FindBy(xpath="//a[contains(text(),'Fundraiser - Booked Yesterday Report')]")
	WebElement bookYesterdayReportLink;

	@FindBy(xpath="//a[contains(text(),'Fundraiser - Daily Mailout Report')]")
	WebElement dailyMailoutReportLink;

	@FindBy(xpath="//a[contains(text(),'Fundraiser - Reservation By Party Date Report')]")
	WebElement reservationByPartyDateLink;

	@FindBy(xpath="//a[contains(text(),'Fundraiser - Yesterday')]")
	WebElement yesterdayPartyReportLink; // not working

	//CEC Stats Report

	@FindBy(id="FromDate")
	WebElement cecStatsFromDateInputBox;

	@FindBy(id="ToDate")
	WebElement cecStatsToDateInputBox;

	@FindBy(id="btnShowReport")
	WebElement cecStatsSubmitBtn;

	@FindBy(xpath="(//table[@id='gridtable'])//th/a[contains(text(),'Order Date')]")
	WebElement orderDateIncecStatsPage;

	@FindBy(xpath="(((//table[@id='gridtable'])//tr/td)[1])")
	WebElement searchResultIncecStatsPage;

	//VIP Party Report

	@FindBy(id="FromDate")
	WebElement vipFromDateInputBox;

	@FindBy(id="ToDate")
	WebElement vipToDateInputBox;

	@FindBy(id="btnShowReport")
	WebElement vipSubmitBtn;

	@FindBy(xpath="(//div[@id='content'])//th/a[contains(text(),'Date Booked')]")
	WebElement orderDateInvipPartyPage;
	
	@FindBy(xpath="((//div[@id='content'])//tr/td)[6]")
	WebElement searchResultInvipPartyPage;

	//Fundraiser - Booked Yesterday Report

	@FindBy(id="FromDate")
	WebElement byrFromDateInputBox;

	@FindBy(id="ToDate")
	WebElement byrToDateInputBox;

	@FindBy(id="Search")
	WebElement byrSubmitBtn;

	@FindBy(id="rdbSchool")
	WebElement schoolFundraiser;
	
	@FindBy(id="rdbNonProfit")
	WebElement nonprofitFundraiser;

	@FindBy(id="ConfirmationNo")
	WebElement byrConfirmationNoInputBox;

	@FindBy(id="Update")
	WebElement byrUpdateBtn;

	@FindBy(xpath="(//table[@id='SelectAllWebGrid'])//th/a[contains(text(),'Date')]")
	WebElement orderDateInBookingYdayReportPage;
	
	@FindBy(xpath="((//table[@id='SelectAllWebGrid'])//tr/td)[5]")
	WebElement searchResultInBookingYdayReportPage;

	//Fundraiser - Daily Mailout Report

	@FindBy(id="FromDate")
	WebElement dmrFromDateInputBox;

	@FindBy(id="ToDate")
	WebElement dmrToDateInputBox;

	@FindBy(id="Search")
	WebElement dmrSubmitBtn;

	@FindBy(name="TypeCategory")
	List<WebElement> dmrfundraiserRadioBtn;

	@FindBy(id="ConfirmationNo")
	WebElement dmrConfirmationNoInputBox;

	@FindBy(id="Update")
	WebElement dmrUpdateBtn;

	@FindBy(xpath="(//table[@id='SelectAllWebGrid'])//th/a[contains(text(),'Date')]")
	WebElement orderDateInIndailyMailoutPage;
	
	@FindBy(xpath="((//table[@id='SelectAllWebGrid'])//tr/td)[4]")
	WebElement searchResultInIndailyMailoutPage;

	//Fundraiser - Yesterday's Parties Report'

	@FindBy(id="FromDate")
	WebElement yprFromDateInputBox;

	@FindBy(id="ToDate")
	WebElement yprToDateInputBox;

	@FindBy(id="Search")
	WebElement yprSubmitBtn;

	@FindBy(name="TypeCategory")
	List<WebElement> yprfundraiserRadioBtn;

	@FindBy(id="ConfirmationNo")
	WebElement yprConfirmationNoInputBox;

	@FindBy(id="Search")
	WebElement yprUpdateBtn;

	@FindBy(xpath="(//table[@id='gridtable'])//th/a[contains(text(),'Date')]")
	WebElement orderDateInYesterdayPartyPage;

	@FindBy(xpath="((//table[@id='gridtable'])//tr/td)[3]")
	WebElement searchResultInYesterdayPartyPage;


	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************
	public CallCenterReportsPage(){
		PageFactory.initElements(driver, this);
	}


	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER METHDOS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//************************************************************************************************
	//*********************Methods to validate Click Login on CallCenter Page ************************
	//************************************************************************************************
	public boolean validateLoginToCallCenter() throws IOException {
		boolean result = false;	
		try {
			Thread.sleep(2000);
			Robot rb = new Robot();
			//Thread.sleep(5000);
			StringSelection pwd = new StringSelection(propv.getProperty("userpwd"));
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			// press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			result = true;
			//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
		} catch (Exception e) {
			result = false;
			System.out.println("Error Found In Login to Call Center: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String validateRobotLogin() throws IOException {
		try {
			System.out.println("RobotLogin function called");

			//Thread.sleep(5000);
			// create robot for keyboard operations
			Robot rb = new Robot();
			Thread.sleep(5000);
			StringSelection pwd = new StringSelection("June@123");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			// press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
		return IEdriverPath;
	}



	//****************************************************************************************************
	//*********************Methods to validate Report Menu  ******************************************
	//****************************************************************************************************
	public boolean validateSelectReportMenu(String reportName,String fromDate, String toDate,String fundraiser) throws IOException, InterruptedException {
		String url = null;
		boolean result = false;
		try {
			Thread.sleep(3000);
			String mainWindow = driver.getWindowHandle();
			Thread.sleep(2000);
			waitAndClick(reportMenuLink);
			Thread.sleep(7000);
			switchToChildWindow();
			url = driver.getCurrentUrl();
			System.out.println("URL of the Child Window: "+url);
			if(reportName.equals("CEC Stats Report")) {
				driver.manage().window().maximize();
				waitAndClick(cecStatsReportLink);
				result = validateCECStatsReportSearch(fromDate, toDate);
			}else if(reportName.equals("VIP Party Report")) {
				driver.manage().window().maximize();
				waitAndClick(vipPartyReportLink);
				result = validateVIPPartyReportSearch(fromDate, toDate);
			}else if(reportName.equals("Book YesterDay Report")) {
				driver.manage().window().maximize();
				waitAndClick(bookYesterdayReportLink);
				result = validateBookYdayReportSearch(fromDate, toDate, fundraiser);
			}else if(reportName.equals("Yesterday Party Report")) {
				driver.manage().window().maximize();
				waitAndClick(yesterdayPartyReportLink);
				result = validateYdayPartyReportSearch(fromDate, toDate,fundraiser);
			}else if(reportName.equals("Daily MailOut Report")) {
				driver.manage().window().maximize();
				waitAndClick(dailyMailoutReportLink);
				result = validateDailymailoutReportSearch(fromDate, toDate,fundraiser);
			}
			closeChildWindow();
			driver.switchTo().window(mainWindow);

		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Found Issue in Method: validateSelectReportMenu()");
			return false;
		}
		return result;
	}	
		


	//************************************************************************************************
	//*********************Methods to validate VIP Party Search**************************************
	//************************************************************************************************
	public boolean validateVIPPartyReportSearch(String partyDateFrom, String partyDateTo) throws InterruptedException {
		boolean result= false;
		try{	
			if(!partyDateFrom.equals("")){
				vipFromDateInputBox.sendKeys(partyDateFrom);
			}
			Thread.sleep(50);
			if(!partyDateTo.equals("")){
				vipToDateInputBox.sendKeys(partyDateTo);
			}
			Thread.sleep(50);
			waitAndClick(vipSubmitBtn);
			System.out.println("VIP Party Report SEARCH SUCCESS......................................................................!!!!!!!!!!!");
			result  = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateVIPPartyReportSearch()");
			result = false;
		}
		return result;	
	}


	//*********************Methods to validate Search result in VIP Party Page***********************************
		//************************************************************************************************
		public boolean validateSearchResultInVIPPartyPage() throws InterruptedException {
			boolean result1 = false,result2 =false;
			String orderDate = null,searchResult=null;
			try{
				Thread.sleep(1000);
				orderDate= waitAndGetText(orderDateInvipPartyPage);
				if(orderDate.equals("Date Booked")){
					System.out.println("Search Result Found Sucessfully..............................!!!!!!!!!!!");
					result1 = true;
				}
				searchResult= waitAndGetText(searchResultInvipPartyPage);
				System.out.println(searchResult);
				int searchResultLength = searchResult.length(); 
				System.out.println(searchResultLength);
				if(searchResultLength==20){
					System.out.println("The Order Date is found..............................!!!!!!!!!!!");
					result2 = true;
				}	

				if(result1 && result2)
				{
					return true;
				}else {
					return false;
				}
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Found Error in Method: validateSearchResultInVIPPartyPage()");
				return false;
			}
		}

	
	
	
	
	//************************************************************************************************
	//*********************Methods to validate Book yesterDay Report Search**************************************
	//************************************************************************************************
	public boolean validateBookYdayReportSearch(String partyDateFrom, String partyDateTo,String fundRaiserOption) throws InterruptedException {
		boolean result= false;
		try{	
			if(!partyDateFrom.equals("")){
				byrFromDateInputBox.clear();
				byrFromDateInputBox.sendKeys(partyDateFrom);
			}
			Thread.sleep(50);
			if(!partyDateTo.equals("")){
				byrToDateInputBox.clear();
				byrToDateInputBox.sendKeys(partyDateTo);
				byrToDateInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(1000);
			if(fundRaiserOption.equals("School")){
				schoolFundraiser.click();
			}else if(fundRaiserOption.equals("NonProfit")){
				nonprofitFundraiser.click();
			}
			waitAndClick(byrSubmitBtn);
			System.out.println("Book yesterday Report SEARCH SUCCESS......................................................................!!!!!!!!!!!");
			result  = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateBookYdayReportSearch()");
			result = false;
		}
		return result;	
	}

	//************************************************************************************************
		//*********************Methods to validate Book yesterDay Report Search**************************************
		//************************************************************************************************
		public boolean validateYdayPartyReportSearch(String partyDateFrom, String partyDateTo,String fundRaiserOption) throws InterruptedException {
			boolean result= false;
			try{	
				if(!partyDateFrom.equals("")){
					yprFromDateInputBox.clear();
					yprFromDateInputBox.sendKeys(partyDateFrom);
				}
				Thread.sleep(50);
				if(!partyDateTo.equals("")){
					yprToDateInputBox.clear();
					yprToDateInputBox.sendKeys(partyDateTo);
				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				if(fundRaiserOption.equals("School")){
					schoolFundraiser.click();
				}else if(fundRaiserOption.equals("NonProfit")){
					nonprofitFundraiser.click();
				}
				yprConfirmationNoInputBox.sendKeys("");
				waitAndClick(yprSubmitBtn);
				System.out.println("Yesterday Party Report SEARCH SUCCESS......................................................................!!!!!!!!!!!");
				result  = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Found Error in Method: validateYdayPartyReportSearch()");
				result = false;
			}
			return result;	
		}
			
			
			
			

		//************************************************************************************************
		//*********************Methods to validate Daily Mailout Report Search**************************************
		//************************************************************************************************
		public boolean validateDailymailoutReportSearch(String orderDateFrom, String orderDateTo,String fundRaiserOption) throws InterruptedException {
			boolean result= false;
			try{	
				if(!orderDateFrom.equals("")){
					dmrFromDateInputBox.clear();
					dmrFromDateInputBox.sendKeys(orderDateFrom);
				}
				Thread.sleep(50);
				if(!orderDateTo.equals("")){
					dmrToDateInputBox.clear();
					dmrToDateInputBox.sendKeys(orderDateTo);
				}
				Thread.sleep(1000);
				Thread.sleep(1000);
				if(fundRaiserOption.equals("School")){
					schoolFundraiser.click();
				}else if(fundRaiserOption.equals("NonProfit")){
					nonprofitFundraiser.click();
				}
				dmrConfirmationNoInputBox.sendKeys("0081");
				Thread.sleep(50);
				waitAndClick(dmrSubmitBtn);
				System.out.println("Daily Mailout Report SEARCH SUCCESS......................................................................!!!!!!!!!!!");
				result  = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Found Error in Method: validateDailymailoutReportSearch()");
				result = false;
			}
			return result;	
		}

		//************************************************************************************************
		//*********************Methods to validate CEC Stats Report Search**************************************
		//************************************************************************************************
		public boolean validateCECStatsReportSearch(String orderDateFrom, String orderDateTo) throws InterruptedException {
			boolean result= false;
			try{	
				if(!orderDateFrom.equals("")){
					cecStatsFromDateInputBox.sendKeys(orderDateFrom);
				}
				Thread.sleep(50);
				if(!orderDateTo.equals("")){
					cecStatsToDateInputBox.sendKeys(orderDateTo);
				}
				Thread.sleep(50);
				waitAndClick(cecStatsSubmitBtn);
				System.out.println("CEC Stats Report SEARCH SUCCESS......................................................................!!!!!!!!!!!");
				result  = true;
			}catch(Exception e){
				e.printStackTrace();
				System.out.println("Found Error in Method: validateCECStatsReportSearch()");
				result = false;
			}
			return result;	
		}



	//*********************Methods to validate Search result in CEC Stats Page***********************************
	//************************************************************************************************
	public boolean validateSearchResultInCECStatsPage() throws InterruptedException {
		boolean result1 = false,result2 =false;
		String orderDate = null,searchResult=null;
		try{
			Thread.sleep(1000);
			orderDate= waitAndGetText(orderDateIncecStatsPage);
			if(orderDate.equals("Order Date")){
				System.out.println("Search Result Found Sucessfully..............................!!!!!!!!!!!");
				result1 = true;
			}
			searchResult= waitAndGetText(searchResultIncecStatsPage);
			System.out.println(searchResult);
			int searchResultLength = searchResult.length(); 
			System.out.println(searchResultLength);
			if(searchResultLength==14){
				System.out.println("The Order Date is found..............................!!!!!!!!!!!");
				result2 = true;
			}	

			if(result1 && result2)
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateSearchResultInCECStatsPage()");
			return false;
		}

	}

	
	//*********************Methods to validate Search result in BOOK yday Page***********************************
	//************************************************************************************************
	public boolean validateSearchResultInBookYdayPage() throws InterruptedException {
		boolean result1 = false,result2 =false;
		String orderDate = null,searchResult=null;
		try{
			Thread.sleep(1000);
			orderDate= waitAndGetText(orderDateInBookingYdayReportPage);
			if(orderDate.equals("Date")){
				System.out.println("Search Result Found Sucessfully..............................!!!!!!!!!!!");
				result1 = true;
			}

			searchResult= waitAndGetText(searchResultInBookingYdayReportPage);
			System.out.println(searchResult);
			int searchResultLength = searchResult.length(); 
			System.out.println(searchResultLength); 
			if(searchResultLength==19){
				System.out.println("The Order Date is found..............................!!!!!!!!!!!");
				result2 = true;
			}	

			if(result1 && result2)
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateSearchResultInBookYdayPage()");
			return false;
		}
	}

	//*********************Methods to validate Search result in Daily MailoutBOOK yday Page***********************************
	//************************************************************************************************
	public boolean validateSearchResultInDailyMailoutPage() throws InterruptedException {
		boolean result1 = false,result2 =false;
		String orderDate = null,searchResult=null;
		try{
			Thread.sleep(1000);
			orderDate= waitAndGetText(orderDateInIndailyMailoutPage);
			if(orderDate.equals("Date")){
				System.out.println("Search Result Found Sucessfully..............................!!!!!!!!!!!");
				result1 = true;
			}

			searchResult= waitAndGetText(searchResultInIndailyMailoutPage);
			System.out.println(searchResult);
			int searchResultLength = searchResult.length(); 
			System.out.println(searchResultLength);
			if(searchResultLength==19){
				System.out.println("The Order Date is found..............................!!!!!!!!!!!");
				result2 = true;
			}	

			if(result1 && result2)
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateSearchResultInDailyMailoutPage()");
			return false;
		}
	}

	//*********************Methods to validate Search result in Yeseterday Party Page***********************************
	//************************************************************************************************
	public boolean validateSearchResultInYdayPartyPage() throws InterruptedException {
		boolean result1 = false,result2 =false;
		String orderDate = null,searchResult=null;
		try{
			Thread.sleep(1000);
			orderDate= waitAndGetText(orderDateInYesterdayPartyPage);
			if(orderDate.equals("Date")){
				System.out.println("Search Result Found Sucessfully..............................!!!!!!!!!!!");
				result1 = true;
			}

			searchResult= waitAndGetText(searchResultInYesterdayPartyPage);
			System.out.println(searchResult);
			int searchResultLength = searchResult.length(); 
			System.out.println(searchResultLength);
			if(searchResultLength==19){
				System.out.println("The Order Date is found..............................!!!!!!!!!!!");
				result2 = true;
			}	

			if(result1 && result2)
			{
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateSearchResultInBookYdayPage()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate UpDateReservationBtnClick *****************************
	//************************************************************************************************
	public void validateUpdateeBookYdayReport() throws InterruptedException {
		Thread.sleep(3000);
		try{
			scrollDown(driver);
			waitAndClick(byrUpdateBtn);
			System.out.println("UPDATE Book Yesterday Report BUTTON CLICK SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in validateUpdateeBookYdayReport()");
		}
	}


}







