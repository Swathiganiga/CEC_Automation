package com.cec.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;

public class RVAdminPage extends BaseTest{


	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					RV ADMIN LOCATORS AND METHDOS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//************************************************************************************************
	//***********************************RV ADMIN LOCATORS  ******************************************
	//************************************************************************************************

	@FindBy(xpath="//a[text()='Reservation Admin']")
	WebElement rootHeading;

	@FindBy(xpath="//a[contains(text(),'Reporting')]")
	WebElement reportingMainMenu;

	@FindBy(xpath="//a[contains(text(),'Item Group Report')]")
	WebElement reportingItemGroupReportSubMenu;

	@FindBy(xpath="//a[contains(text(),'Item Groups')]")
	WebElement reportingItemGroupSubMenu;

	@FindBy(id="Search_FromPartyDate")
	WebElement partyDateFrom;

	@FindBy(id="Search_ToPartyDate")
	WebElement partyDateTo;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement searchButton;

	@FindBy(xpath="(//table[@id='example']//tr[@class='webgrid-row-style webgrid-alternating-row odd']//td)[1]")
	WebElement firstRowDataValue;

	@FindBy(xpath="(//table[@id='example']//tr[@class='odd']/td)[1]")
	WebElement ItemGroupsParentValue;

	@FindBy(xpath="(//table[@id='example']//tr[@class='odd']/td)[2]")
	WebElement ItemGroupsGroupValue;

	@FindBy(id="Group_GroupName")
	WebElement ItemGroupsGroupNameInputBox;

	@FindBy(xpath="//input[@class='btn btn-primary']")
	WebElement ItemGroupsSaveBtn;


	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************

	public RVAdminPage(){
		PageFactory.initElements(driver, this);
	}

	//************************************************************************************************
	//*********************Methods of R V ADMIN ******************************************************
	//************************************************************************************************


	//************************************************************************************************
	//*********************Methods to validate Login to RV Admin  ************************************
	//************************************************************************************************
	public String validateLoginToRVAdmin() throws IOException, AWTException, InterruptedException {
		String rvTitle = null;
		try{
			Thread.sleep(1000);
			enterDataUsingRobot(propv.getProperty("username"));
			Robot robo = new Robot();
			Thread.sleep(1000);
			robo.keyPress(KeyEvent.VK_TAB);
			robo.keyRelease(KeyEvent.VK_TAB);
			enterDataUsingRobot(propv.getProperty("userpwd"));
			Thread.sleep(1000);
			// press enter
			robo.keyPress(KeyEvent.VK_ENTER);
			robo.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			if(rootHeading.isDisplayed()){
				rvTitle = driver.getTitle();
			}else{
				rvTitle = "Found Issue with Login";
			}
			System.out.println("LOGIN SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			System.out.println("Login to RV Admin Failed");
			rvTitle = "Failed to Login to RV Admin";
			e.printStackTrace();
		}
		return rvTitle;
	}

	//************************************************************************************************
	//*********************Methods to validate Reporting Menu Select**********************************
	//************************************************************************************************
	public String validateReportingMenuSelect(String rOption) throws InterruptedException, AWTException {
		String result = null;
		try{
			waitAndClick(reportingMainMenu);
			if(rOption.equals("Item Group Report")){
				waitAndClick(reportingItemGroupReportSubMenu);
			}else if(rOption.equals("Item Groups")){
				waitAndClick(reportingItemGroupSubMenu);
			}
			System.out.println("REPORTING OPTION SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found  Issue in Menu Selection");
			result = "";
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validate Date Entry  *******************************************
	//************************************************************************************************
	public String validateDateEntry(String fromDate, String toDate) throws InterruptedException, AWTException {
		Thread.sleep(10000);
		fromDate = fromDate.replace("/", "");
		toDate = toDate.replace("/", "");

		String fromDay = fromDate.substring(0,2);
		String fromMonth = fromDate.substring(2,4);
		String fromYear = fromDate.substring(4,8);

		String toDay = toDate.substring(0,2);
		String toMonth = toDate.substring(2,4);
		String toYear = toDate.substring(4,8);

		String result= null;
		try{

			partyDateFrom.click();
			enterDataUsingRobot(fromDay);
			Thread.sleep(200);
			enterDataUsingRobot(fromMonth);
			Thread.sleep(200);
			enterDataUsingRobot(fromYear);
			Thread.sleep(200);

			partyDateTo.click();
			enterDataUsingRobot(toDay);
			Thread.sleep(200);
			enterDataUsingRobot(toMonth);
			Thread.sleep(200);
			enterDataUsingRobot(toYear);
			Thread.sleep(200);

			waitAndClick(searchButton);
			result = waitAndGetText(firstRowDataValue);
			System.out.println("SEARCH SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found  Issue with Search");
			result = "";
		}
		return result;
	}

	//************************************************************************************************
	//*********************Methods to validate Item Group Edit ***************************************
	//************************************************************************************************
	public String validateItemGroupEdit() throws InterruptedException, AWTException {
		String result=null;
		String itemGroupsGroupNameNew=null;
		try{
			String itemGroupName = "Chuck E Cheese";
			WebElement ele = driver.findElement(By.partialLinkText(itemGroupName));
			itemGroupName = ele.getText();
			ele.click();
			if(itemGroupName.substring(itemGroupName.length()-8).equals("UVUVUVUV")){
				itemGroupsGroupNameNew = itemGroupName.substring(0,itemGroupName.length()-8);
			}else{
				itemGroupsGroupNameNew = itemGroupName+"UVUV";
			}
			ItemGroupsGroupNameInputBox.clear();
			ItemGroupsGroupNameInputBox.sendKeys(itemGroupsGroupNameNew);
			ItemGroupsSaveBtn.click();
			Thread.sleep(5000);
			WebElement eleUpdated = driver.findElement(By.partialLinkText(itemGroupsGroupNameNew));
			String itemGroupsGroupNameUpdated = eleUpdated.getText();
			if(itemGroupsGroupNameUpdated.equals(itemGroupsGroupNameNew)){
				result = itemGroupsGroupNameNew;
			}else{
				result = "Found Issue in Updating Item Group";
			}

			System.out.println("EDIT AND SAVE SUCCESS......................................................................!!!!!!!!!!!");
			return result;
		}catch(Exception e){
			System.out.println("Found Issue in Updating Item Group");
			e.printStackTrace();
			return "Found Issue in Updating Item Group";
		}
	}

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					RV ADMIN LOCATORS AND METHDOS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//		 					STORE APP LOCATORS AND METHDOS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	StoreAppPage storeAppPage;
	//************************************************************************************************
	//*********************Methods to Search Specific Item *******************************************
	//************************************************************************************************
	public String validateSpecificItemSearch(String itemName) throws InterruptedException, AWTException{
		driver.navigate().to(propv.getProperty("SAP"));
		Thread.sleep(10000);
		storeAppPage = new StoreAppPage();
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp("IRVING, TX, USA");
		storeAppPage.validateItemReportTabSelect();
		storeAppPage.validateItemReportSearch(getFutureDateInYYYYMMDD(-30),getFutureDateInYYYYMMDD(0));//Presently not sending any date From: and To: dates as default date getting results
		if(itemName.equals("")){
			itemName = "Chuck E Cheese";
		}
		String specifiItemSearchFound = storeAppPage.validateItemReportSpecificItemSearch(itemName);
		return specifiItemSearchFound;
	}

	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//		 					STORE APP LOCATORS AND METHDOS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$




}



