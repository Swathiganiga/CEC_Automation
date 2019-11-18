package com.cec.qa.pages;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.lang.reflect.Method;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.qameta.allure.Story;

public class StoreAppPage extends BaseTest{

	public String confirmationNumberUseToAddComments;
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					STORE APP LOCATORS AND METHDOS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//************************************************************************************************
	//***********************************STORE APP LOCATORS ******************************************
	//************************************************************************************************

	@FindBy(xpath="//a[text()='Login Here']")
	WebElement loginBtn;

	@FindBy(id="i0116")
	WebElement userEmailInputBox;

	@FindBy(id="idSIButton9")
	WebElement nextBtn;

	@FindBy(id="passwordInput")
	WebElement pwdInputBox;

	@FindBy(id="submitButton")
	WebElement signInBtn;

	@FindBy(id="idBtn_Back")
	WebElement staySignInNOBtn;

	@FindBy(id="idSIButton9")
	WebElement staySignInYESBtn;

	@FindBy(xpath="//select[@id='CurrentStore_ID']")
	WebElement storeListBox;

	@FindBy(xpath="//select[@id='CurrentStore_ID']/option[text()='0081 - Irving']")
	WebElement irvingListOption;

	@FindBy(id="lblZipCode")
	WebElement zipCodeValue;

	//Store Page
	@FindBy(id="preceed")
	WebElement proceedBtn;

	@FindBy(xpath="//a[@title='Deposit Due']")
	WebElement depositDueTab;

	@FindBy(xpath="//a[@title='Reservation']")
	WebElement reservationTab;

	@FindBy(xpath="//a[@title='Seating']")
	WebElement seatingTab;

	@FindBy(xpath="//a[@title='Deposit']")
	WebElement depositTab;

	@FindBy(xpath="//a[@title='Item Report']")
	WebElement itemReportTab;

	//Reservation Page
	@FindBy(id="OrderDateFrom")
	WebElement orderDateFromInputBox;

	@FindBy(id="OrderDateTo")
	WebElement orderDateToInputBox;

	@FindBy(id="PartyDateFrom")
	WebElement partyDateFromInputBox;

	@FindBy(id="PartyDateTo")
	WebElement partyDateToInputBox;

	@FindBy(id="Search_ConfirmationNumber")
	WebElement confirmationInputBox;

	@FindBy(id="Search_GuestName")
	WebElement guestNameInputBox;

	@FindBy(id="Search_PhoneNumber")
	WebElement  contactPhoneInputBox;

	@FindBy(id="Search_ReportType")
	WebElement reservationTypeListBox;

	@FindBy(xpath="//select[@id='Search_ReportType']/option[text()='Birthday']")
	WebElement reservationTypeListOptionBirthday;

	@FindBy(xpath="//select[@id='Search_ReportType']/option[text()='Fund Raising: School']")
	WebElement reservationTypeListOptionFundRaisingSchool;

	@FindBy(xpath="//select[@id='Search_ReportType']/option[text()='Fund Raising: Non-Profit']")
	WebElement reservationTypeListOptionFundRaisingNonProfit;

	@FindBy(xpath="//select[@id='Search_ReportType']/option[text()='Organizational']")
	WebElement reservationTypeListOptionOrganizational;

	@FindBy(id="Search_Status")
	WebElement reservationStatusListBox;

	@FindBy(xpath="//select[@id='Search_Status']/option[text()='Every Status']")
	WebElement reservationStatusEveryStatus;

	@FindBy(xpath="//select[@id='Search_Status']/option[text()='Active']")
	WebElement reservationStatusActive;

	@FindBy(xpath="//select[@id='Search_Status']/option[text()='Cancelled']")
	WebElement reservationStatusCancelled;

	@FindBy(id="Search_ContactName")
	WebElement contactNameInputBox;

	@FindBy(id="Search_Email")
	WebElement contactEmailInputBox;

	@FindBy(id="btnSearch")
	WebElement searchBtn;

	@FindBy(xpath="//a[@title='Update Reservation']")
	WebElement updateReservation;

	@FindBy(xpath="//table[@id='gridtable']//td[10]")
	WebElement confirmationNumberInReservationPage;

	@FindBy(xpath="@(//table[@id='gridtable']//td)[2]")
	WebElement timeInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[3]")
	WebElement pnInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[4]")
	WebElement orderByNameInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[5]")
	WebElement phoneNumberInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[6]")
	WebElement extInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[7]")
	WebElement contactEmailInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[8]")
	WebElement reservationTypeInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[9]")
	WebElement childInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[10]")
	WebElement webTokInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[11]")
	WebElement confirmationNumberInReservatinPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[12]")
	WebElement orderStatusInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[13]")
	WebElement orderDateInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[14]")
	WebElement takenByInReservationPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[15]")
	WebElement payTypeInReservationPage;

	@FindBy(xpath="(//span[contains(text(),'Promotions')])[1]/../br[1]")
	WebElement bonusTextInReservationPage;

	@FindBy(xpath="(//table[@class='border-none-inner bgbrk webgrid-table']//tr/td[contains(text(),'STAR')])[1]")
	WebElement firstTablesAvailablePackageNameInReservationPage;

	//Deposit Page
	@FindBy(id="ConfirmationNumber")
	WebElement confirmationInputBoxInDepositPage;

	@FindBy(id="GuestName")
	WebElement guestNameInputBoxInDepositPage;

	@FindBy(id="PhoneNumber")
	WebElement  contactPhoneInputBoxInDepositPage;

	@FindBy(id="ReservationTypeId")
	WebElement reservationTypeListBoxInDepositPage;

	@FindBy(xpath="//select[@id='ReservationTypeId']/option[text()='Birthday']")
	WebElement reservationTypeListOptionBirthdayInDepositPage;

	@FindBy(xpath="//select[@id='ReservationTypeId']/option[text()='Fund Raising']")
	WebElement reservationTypeListOptionFundRaisingSchoolInDeporitPage;

	@FindBy(xpath="//select[@id='ReservationTypeId']/option[text()='Organizational']")
	WebElement reservationTypeListOptionOrganizationalInDepositPage;

	@FindBy(id="Status")
	WebElement reservationStatusListBoxInDepositPage;

	@FindBy(xpath="//select[@id='SearchStatus']/option[text()='Every Status']")
	WebElement reservationStatusEveryStatusInDepositPage;

	@FindBy(xpath="//select[@id='SearchStatus']/option[text()='Active']")
	WebElement reservationStatusActiveInDepositPage;

	@FindBy(xpath="//select[@id='SearchStatus']/option[text()='Cancelled']")
	WebElement reservationStatusCancelledInDepositPage;

	@FindBy(id="ContactName")
	WebElement contactNameInputBoxInDepositPage;

	@FindBy(id="Email")
	WebElement contactEmailInputBoxInDepositPage;

	@FindBy(id="DepositStatus")
	WebElement depositStatusListBox;

	@FindBy(xpath="//select[@id='DepositStatus']/option[text()='Every Status']")
	WebElement depositStatusListOptionEveryStatusInDepositPage;

	@FindBy(xpath="//select[@id='DepositStatus']/option[text()='Paid']")
	WebElement depositStatusListOptionPaidInDepositPage;

	@FindBy(xpath="//select[@id='DepositStatus']/option[text()='Unpaid']")
	WebElement depositStatusListOptionUnpaidInDepositPage;

	@FindBy(id="Search")
	WebElement searchBtnInDepositPage;

	@FindBy(xpath="(//table[@id='gridtable']//td)[2]")
	WebElement contactNameInDeporitPage;

	@FindBy(xpath="//table[@id='gridtable']//td[2]")
	WebElement guestNameInDeporitPage;

	@FindBy(xpath="//table[@id='gridtable']//td[3]")
	WebElement contactPhoneInDepositPage;

	@FindBy(xpath="//table[@id='gridtable']//td[7]")
	WebElement confirmationNumberInDepositPage;

	@FindBy(xpath="(//table[@id='gridtable']//td[9])[1]")
	WebElement orderStatusInDepositPage;

	@FindBy(xpath="(//table[@id='gridtable']//td[10])[1]")
	WebElement payTypeInDepositPage;

	@FindBy(id="Update")
	WebElement updateDepositInDepositPage;

	@FindBy(id="Reservation_StoreComments")
	WebElement storeCommentsInputBox;

	@FindBy(id="SaveNotes")
	WebElement storeCommentsSaveBtn;


	//Item Report
	@FindBy(id="Search_FromPartyDate")
	WebElement partyDateFromInItemReport;
	
	@FindBy(id="Search_ToPartyDate")
	WebElement partyDateToInItemReport;

	@FindBy(xpath="//input[@class='btn btn-default']")
	WebElement searchBtnInItemReport;

	@FindBy(xpath="(//th[@class='datatable-header text-center lbl_book_ft'])[1]")
	WebElement headerOfItemReportPage;

	@FindBy(xpath="//td[text()='Cakes']")
	WebElement cakesPartyGroupFirstRowValueInItemReport;

	@FindBy(xpath="//td[text()='Sheet Vanilla']")
	WebElement sheetVenillaGroupFirstRowValueInItemReport;

	@FindBy(id="YetToBuild")
	WebElement YetToBuild;//update right WebElementName  and Xpath after getting build.

	//Update Fields locators after the search
	@FindBy(id="txtChildren")
	WebElement childInputBox;

	@FindBy(id="txtAdult")
	WebElement adultInputBox;

	@FindBy(id="rdoPackage3510")
	WebElement starRadioBtn;

	@FindBy(id="rdoPackage3154")
	WebElement superStarRadioBtn;

	@FindBy(id="rdoPackage3157")
	WebElement megaStarRadioBtn;

	@FindBy(id="txtOptionalItem_416")
	WebElement upSellFirstPizzaInputBox;

	@FindBy(id="btnSaveReservation")
	WebElement savePartyPackagePartyOptionBtn;

	//Values locators after Update
	@FindBy(id="errorMsgReservation")
	WebElement errorMsgText;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[2]")
	WebElement childAdultValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[3]")
	WebElement contactNameValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[4]")
	WebElement contactPhoneValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[5]")
	WebElement contactPhoneExtValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[6]")
	WebElement contactEmailValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[7]")
	WebElement reservationTypeValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[8]")
	WebElement childNameValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[9]")
	WebElement webTokValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[10]")
	WebElement confirmationNumberValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[11]")
	WebElement orderStatusValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[12]")
	WebElement orderDateValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[13]")
	WebElement takenByValue;

	@FindBy(xpath="//tr[@class='webgrid-row-style webgrid-alternating-row']/td[14]")
	WebElement payTypeValue;

	@FindBy(xpath="(//td[contains(text(),' [Party Package] : STAR')])[1]")
	WebElement starPackageValue;

	@FindBy(xpath="(//td[contains(text(),' [Party Package] : SUPER STAR')])[1]")
	WebElement superStarPackageValue;

	@FindBy(xpath="(//td[contains(text(),' [Party Package] : MEGA SUPER STAR')])[1]")
	WebElement megaStarPackageValue;

	//@FindBy(id="txtOptionalItem_416")
	//WebElement upSellPizzaValue;

	@FindBy(xpath="(//td[contains(text(),'Qty.')])[1]")
	WebElement upSellPizzaValue;

	//	@FindBy(xpath="(//table[@class='border-none-inner bgbrk webgrid-table']//br)[1]")
	//	WebElement promotionsText;

	@FindBy(xpath="(//tr[4]/td)[2]")
	WebElement promotionsText;

	//Cancel
	@FindBy(id="drpCancelReason")
	WebElement cancelReasonListBoxInDepositDue;

	@FindBy(xpath="//select[@id='drpCancelReason']/option[text()='Deposit not applied to party']")
	WebElement cancelReasonListOptionDepositNotAppliedToPartyInDepositDue;

	@FindBy(id="txtEmployeeName")
	WebElement employeeNameInDepositDue;

	@FindBy(id="btnCancelReservation")
	WebElement cancelPartyBtn;

	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement confirmationPopUpOKBtn;

	@FindBy(xpath="//div[@class='col-md-6 col-sm-5 col-xs-5 text-center lbl_book_ft']")
	WebElement headerOfDepositDuePage;


	@FindBy(xpath="//a[text()='Return to Store Home Page']")
	WebElement returnToHomePageLink;

	@FindBy(xpath="//b[text()='NOTICE TO EMPLOYEES']")
	WebElement homePageNOTICETOEMPLOYEESText;

	//Deposit Due

	@FindBy(xpath="(//table[@id='gridtable']//td[10])[1]")
	WebElement confirmationNumberInDepositDuePage;
	
	//Seating
	@FindBy(id="hlnkSeating")
	WebElement seatingLinkInSeatingTab;
	
	@FindBy(id="content")
	WebElement pDFPageContentLocator;
	
	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************

	public StoreAppPage(){
		PageFactory.initElements(driver, this);
	}

	//************************************************************************************************
	//*********************Methods of STORE APP ******************************************************
	//************************************************************************************************
	public String[] searchAndGetReservationInfo() throws InterruptedException {
		try{
			String reservationInfo[] = new String[15];
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			System.out.println(orderByNameInReservationPage.getText());
			System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			//String temp = timeInReservationPage.getText();
			//reservationInfo[0]= temp;
			reservationInfo[0]=pnInReservationPage.getText(); 
			reservationInfo[1]=orderByNameInReservationPage.getText(); 
			reservationInfo[2]=phoneNumberInReservationPage.getText(); 
			reservationInfo[3]=extInReservationPage.getText(); 
			reservationInfo[4]=contactEmailInReservationPage.getText(); 
			reservationInfo[5]=reservationTypeInReservationPage.getText(); 
			reservationInfo[6]=childInReservationPage.getText(); 
			reservationInfo[7]=webTokInReservationPage.getText(); 
			reservationInfo[8]=confirmationNumberInReservatinPage.getText(); 
			reservationInfo[9]=orderStatusInReservationPage.getText(); 
			reservationInfo[10]=orderDateInReservationPage.getText(); 
			reservationInfo[11]=takenByInReservationPage.getText(); 
			reservationInfo[12]=payTypeInReservationPage.getText(); 
			reservationInfo[13]=firstTablesAvailablePackageNameInReservationPage.getText();
			reservationInfo[14]=bonusTextInReservationPage.getText(); 
			return reservationInfo;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Issue in Method: searchAndGetReservationInfo()");
		}
		return null;
	}


	//************************************************************************************************
	//*********************Methods to validate Click Login on StoreApp Page **************************
	//************************************************************************************************
	public boolean validateLoginToStoreApp() throws InterruptedException {
		boolean result = false;
		try{
			waitAndClick(loginBtn);
			userEmailInputBox.sendKeys(propv.getProperty("useremail"));
			waitAndClick(nextBtn);
			try{ //This try block helps to re-login using coming catch.
				waitAndClick(pwdInputBox);	
				pwdInputBox.sendKeys(propv.getProperty("userpwd"));
			}catch(Exception e){ 
				System.out.println("Login Page load delay, trying login again........!!!");
				driver.navigate().to(propv.getProperty("url3"));
				waitAndClick(loginBtn);
				userEmailInputBox.sendKeys(propv.getProperty("useremail"));
				waitAndClick(nextBtn);
				waitAndClick(pwdInputBox);	
				pwdInputBox.sendKeys(propv.getProperty("userpwd"));
			}
			waitAndClick(signInBtn);
			waitAndClick(staySignInNOBtn);
			String storeAppTitle = driver.getTitle();
			System.out.println(storeAppTitle);
			System.out.println("LOGIN TO STORE APP SUCCESS......................................................................!!!!!!!!!!!");
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validate login *************************************************
	//************************************************************************************************
	public String validateSelectStoreInStoreApp(String storeName) throws InterruptedException {
		Thread.sleep(2000);
		String result= null;
		try{

			waitAndClick(storeListBox);
			if(storeName.equals("IRVING, TX, USA")){
				waitAndClick(irvingListOption);
				result = zipCodeValue.getText();
			}
			System.out.println("SELECT STORE SUCCESS......................................................................!!!!!!!!!!!");
			Thread.sleep(4000);
			waitAndClick(proceedBtn);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Issue in selecting a store");
			result = "FOUND ERROR in methods:validateSelectStoreInStoreApp()";
		}
		return result;
	}

	//************************************************************************************************
	//*********************Methods to validate Reservation *******************************************
	//************************************************************************************************
	public String validateReservation(String storeName) throws InterruptedException {
		try {
			String result= null;
			waitAndClick(storeListBox);
			if(storeName.equals("Irving")){
				waitAndClick(irvingListOption);
				result = zipCodeValue.getText();
			}
			System.out.println("SELECT STORE SUCCESS......................................................................!!!!!!!!!!!");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Found Issue in Method: validateReservation()");
			return "Found Issue in Method: validateReservation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate DepositDueTab Click ***********************************
	//************************************************************************************************
	public void validateDepositDueTabSelect() throws InterruptedException {
		Thread.sleep(1000);
		try{
			waitAndClick(depositDueTab);
			System.out.println("DEPOSIT DUE TAB SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateDepositDueTabSelect()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validate ReservationTab Click **********************************
	//************************************************************************************************
	public void validateReservationTabSelect() throws InterruptedException {
		Thread.sleep(1000);
		try{
			waitAndClick(reservationTab);
			System.out.println("RESERVATION TAB SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateReservationTabSelect()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate SeatingTab Click **************************************
	//************************************************************************************************
	public void validateSeatingTabSelect() throws InterruptedException {
		Thread.sleep(1000);
		try{
			waitAndClick(seatingTab);
			System.out.println("SEATING TAB SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateSeatingTabSelect()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validate DepositTab Click **************************************
	//************************************************************************************************
	public void validateDepositTabSelect() throws InterruptedException {
		Thread.sleep(1000);
		try{
			waitAndClick(depositTab);
			System.out.println("DEPOSIT TAB SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateDepositTabSelect()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate ItemReportTab Click ***********************************
	//************************************************************************************************
	public void validateItemReportTabSelect() throws InterruptedException {
		Thread.sleep(1000);
		try{
			waitAndClick(itemReportTab);
			System.out.println("ITEM REPORT TAB SELECT SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateItemReportTabSelect()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Reservation Search*************************************
	//************************************************************************************************
	public boolean validateReservationPartyInfoSearch(String orderDateFrom, String orderDateTo, String partyDateFrom, String partyDateTo, String confirmationNumber, String guestName, String contactPhone, String reservationType, String reservationStatus, String contactName, String contactEmail) throws InterruptedException {
		boolean result= false;
		try{	
			if(!orderDateFrom.equals("")){
				orderDateFromInputBox.sendKeys(orderDateFrom);
			}else{
				orderDateFromInputBox.clear();
				orderDateFromInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!orderDateTo.equals("")){
				orderDateToInputBox.sendKeys(orderDateTo);
			}else{
				orderDateToInputBox.clear();
				orderDateToInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!partyDateFrom.equals("")){
				partyDateFromInputBox.click();
				partyDateFromInputBox.sendKeys(Keys.DELETE);
				partyDateFromInputBox.sendKeys(partyDateFrom);
			}else{
				partyDateFromInputBox.clear();
				partyDateFromInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!partyDateTo.equals("")){
				partyDateToInputBox.click();
				partyDateToInputBox.sendKeys(Keys.DELETE);
				partyDateToInputBox.sendKeys(partyDateTo);
			}else{
				partyDateToInputBox.clear();
				partyDateToInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!confirmationNumber.equals("")){
				confirmationInputBox.sendKeys(confirmationNumber);
			}else{
				confirmationInputBox.clear();
				confirmationInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!guestName.equals("")){
				guestNameInputBox.sendKeys(guestName);
			}else{
				guestNameInputBox.clear();
				guestNameInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!contactPhone.equals("")){
				contactPhoneInputBox.sendKeys(contactPhone);
			}else{
				contactPhoneInputBox.clear();
				contactPhoneInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!reservationType.equals("")){
				if(reservationType.equals("Birthday")){
					reservationTypeListOptionBirthday.click();
				}else if(reservationType.equals("Fund Raising: School")){
					reservationTypeListOptionFundRaisingSchool.click();
				}else if(reservationType.equals("Fund Raising: Non-Profit")){
					reservationTypeListOptionFundRaisingNonProfit.click();
				}else if(reservationType.equals("Organizational")){
					reservationTypeListOptionOrganizational.click();
				}
			}else{

			}
			Thread.sleep(100);	
			if(!reservationStatus.equals("")){
				if(reservationStatus.equals("Every Status")){
					reservationStatusEveryStatus.click();
				}else if(reservationStatus.equals("Active")){
					reservationStatusActive.click();
				}else if(reservationStatus.equals("Cancelled")){
					reservationStatusCancelled.click();
				}
			}else{

			}
			Thread.sleep(100);	
			if(!contactName.equals("")){
				contactNameInputBox.sendKeys(contactName);
			}else{
				contactNameInputBox.clear();
				contactNameInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);	
			if(!contactEmail.equals("")){
				contactEmailInputBox.sendKeys(contactEmail);
			}else{
				contactEmailInputBox.clear();
				contactEmailInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);	
			waitAndClick(searchBtn);
			System.out.println("RESERVATION SEARCH SUCCESS......................................................................!!!!!!!!!!!");
			result  = true;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method:validateReservationPartyInfoSearch()");
			result = false;
		}
		return result;	
	}

	//************************************************************************************************
	//*********************Methods to validate Deposit Search ****************************************
	//************************************************************************************************
	public boolean validateDepositPartyInfoSearch(String orderDateFrom, String orderDateTo, String partyDateFrom, String partyDateTo, String confirmationNumber, String guestName, String contactPhone, String reservationType, String reservationStatus, String contactName, String contactEmail, String depositStatus) throws InterruptedException {
		boolean result= false;
		try{	
			if(!orderDateFrom.equals("")){
				orderDateFromInputBox.sendKeys(orderDateFrom);
			}else{
				orderDateFromInputBox.clear();
				orderDateFromInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!orderDateTo.equals("")){
				orderDateToInputBox.sendKeys(orderDateTo);
			}else{
				orderDateToInputBox.clear();
				orderDateToInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!partyDateFrom.equals("")){
				partyDateFromInputBox.click();
				partyDateFromInputBox.sendKeys(Keys.DELETE);
				partyDateFromInputBox.sendKeys(partyDateFrom);
			}else{
				partyDateFromInputBox.clear();
				partyDateFromInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!partyDateTo.equals("")){
				partyDateToInputBox.click();
				partyDateToInputBox.sendKeys(Keys.DELETE);
				partyDateToInputBox.sendKeys(partyDateTo);
			}else{
				partyDateToInputBox.clear();
				partyDateToInputBox.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!confirmationNumber.equals("")){
				confirmationInputBoxInDepositPage.sendKeys(confirmationNumber);
			}else{
				confirmationInputBoxInDepositPage.clear();
				confirmationInputBoxInDepositPage.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!guestName.equals("")){
				guestNameInputBoxInDepositPage.sendKeys(guestName);
			}else{
				guestNameInputBoxInDepositPage.clear();
				guestNameInputBoxInDepositPage.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!contactPhone.equals("")){
				contactPhoneInputBoxInDepositPage.sendKeys(contactPhone);
			}else{
				contactPhoneInputBoxInDepositPage.clear();
				contactPhoneInputBoxInDepositPage.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!reservationType.equals("")){
				if(reservationType.equals("Birthday")){
					reservationTypeListOptionBirthdayInDepositPage.click();
				}else if(reservationType.equals("Fund Raising: School")){
					reservationTypeListOptionFundRaisingSchoolInDeporitPage.click();
				}else if(reservationType.equals("Organizational")){
					reservationTypeListOptionOrganizationalInDepositPage.click();
				}
			}else{

			}
			Thread.sleep(100);	
			if(!reservationStatus.equals("")){
				if(reservationStatus.equals("Every Status")){
					reservationStatusEveryStatusInDepositPage.click();
				}else if(reservationStatus.equals("Active")){
					reservationStatusActiveInDepositPage.click();
				}else if(reservationStatus.equals("Cancelled")){
					reservationStatusCancelledInDepositPage.click();
				}
			}else{

			}
			Thread.sleep(100);	
			if(!contactName.equals("")){
				contactNameInputBoxInDepositPage.sendKeys(contactName);
			}else{
				contactNameInputBoxInDepositPage.clear();
				contactNameInputBoxInDepositPage.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);	
			if(!contactEmail.equals("")){
				contactEmailInputBoxInDepositPage.sendKeys(contactEmail);
			}else{
				contactEmailInputBoxInDepositPage.clear();
				contactEmailInputBoxInDepositPage.sendKeys(Keys.ESCAPE);
			}
			Thread.sleep(50);
			if(!depositStatus.equals("")){
				if(depositStatus.equals("Every Status")){
					depositStatusListOptionEveryStatusInDepositPage.click();
				}else if(depositStatus.equals("Paid")){
					depositStatusListOptionPaidInDepositPage.click();
				}else if(depositStatus.equals("Unpaid")){
					depositStatusListOptionUnpaidInDepositPage.click();
				}
			}else{

			}
			Thread.sleep(50);
			waitAndClick(searchBtnInDepositPage);
			System.out.println("DEPOSIT SEARCH SUCCESS......................................................................!!!!!!!!!!!");
			result  = true;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateDepositPartyInfoSearch()");
			result = false;
		}
		return result;	
	}
	//************************************************************************************************
	//*********************Methods to validate ItemReport Search**************************************
	//************************************************************************************************
	public boolean validateItemReportSearch(String partyDateFrom, String partyDateTo) throws InterruptedException {
		boolean result= false;
		try{	
			if(!partyDateFrom.equals("")){
				partyDateFromInputBox.sendKeys(partyDateFrom);
			}
			Thread.sleep(50);
			if(!partyDateTo.equals("")){
				partyDateToInputBox.sendKeys(partyDateTo);
			}
			Thread.sleep(50);
			waitAndClick(searchBtnInItemReport);
			System.out.println("ITEM REPORT SEARCH SUCCESS......................................................................!!!!!!!!!!!");
			result  = true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateItemReportSearch()");
			result = false;
		}
		return result;	
	}

	//************************************************************************************************
	//*********************Methods to validate UpDateReservationBtnClick *****************************
	//************************************************************************************************
	public void validateUpdateReservationButtonClick() throws InterruptedException {
		Thread.sleep(3000);
		try{
			scrollDown(driver);
			waitAndClick(updateReservation);
			System.out.println("UPDATE RESERVATION BUTTON CLICK SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in method:validateUpdateReservationButtonClick()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate UpDateDepositBtnClick *********************************
	//************************************************************************************************
	public void validateUpdateDepositButtonClick() throws InterruptedException {
		Thread.sleep(3000);
		try{
			scrollDown(driver);
			waitAndClick(updateDepositInDepositPage);
			System.out.println("UPDATE DEPOSIT BUTTON CLICK SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in method: validateUpdateDepositButtonClick()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validate UpDateReservation *************************************
	//************************************************************************************************
	public void validateUpdateReservationInfo(String aduiltCount, String childCount, String packageClass, String pizzaUpSellCount) throws InterruptedException {
		Thread.sleep(5000);
		try{
			scrollDown(driver);
			if(!aduiltCount.equals("")){
				adultInputBox.clear();
				adultInputBox.sendKeys(aduiltCount);
			}
			if(!childCount.equals("")){
				childInputBox.clear();
				childInputBox.sendKeys(childCount);
			}
			if(!packageClass.equals("")){
				if(packageClass.equals("STAR")){
					waitAndClick(starRadioBtn);
				}else if(packageClass.equals("SUPER STAR")){
					waitAndClick(superStarRadioBtn);
				}else if(packageClass.equals("MEGA SUPER STAR")){
					waitAndClick(megaStarRadioBtn);
				}
				Thread.sleep(3000);
			}
			if(!pizzaUpSellCount.equals("")){
				Thread.sleep(1000);
				upSellFirstPizzaInputBox.clear();
				upSellFirstPizzaInputBox.sendKeys(pizzaUpSellCount);
			}
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			Thread.sleep(3000);
			waitAndClick(savePartyPackagePartyOptionBtn);
			System.out.println("UPDATE RESERVATION INFO SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method:validateUpdateReservationInfo()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate ErrorMessage ******************************************
	//************************************************************************************************
	public String validateReservationUpdateErrorMessage() throws InterruptedException {
		Thread.sleep(2000);
		String errorMessage = null;
		try{
			errorMessage = waitAndGetText(errorMsgText);
			System.out.println("UPDATE RESERVATION ERROR MSG SUCCESS......................................................................!!!!!!!!!!!");

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method:validateReservationUpdateErrorMessage()");
			errorMessage = "Issue with Error Message text";
		}
		return errorMessage;
	}

	//************************************************************************************************
	//*********************Methods to validate Package Name*******************************************
	//************************************************************************************************
	public String validatePackageName(String packageClass) throws InterruptedException {
		String packageName=null;
		if(!packageClass.equals("")){
			if(packageClass.equals("STAR")){
				packageName = waitAndGetText(starPackageValue);
			}else if(packageClass.equals("SUPER STAR")){
				packageName = waitAndGetText(superStarPackageValue);
			}else if(packageClass.equals("MEGA SUPER STAR")){
				packageName = waitAndGetText(megaStarPackageValue);
			}
		}
		System.out.println("UPDATE RESERVATION ERROR MSG SUCCESS......................................................................!!!!!!!!!!!");
		return packageName;
	}

	//************************************************************************************************
	//*********************Methods to validate UpSell  ***********************************************
	//************************************************************************************************
	public String validateUpSell() throws InterruptedException {
		String upSellValue = null;
		try{
			upSellValue= waitAndGetText(upSellPizzaValue);
			System.out.println("UPDATE RESERVATION ERROR MSG SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method:validateUpSell()");
			upSellValue =  "Issue with UpSell value";
		}
		return upSellValue;
	}

	//************************************************************************************************
	//*********************Methods to validate ConfirmationInDepositPage******************************
	//************************************************************************************************
	public String validateConfirmationNumberInDepositPage() throws InterruptedException {
		String confNum = null;
		try{
			confNum= waitAndGetText(confirmationNumberInDepositPage);
			System.out.println("CONFIRMATION NUMBER DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateConfirmationNumberInDepositPage()");
			confNum =  "Issue with ConfNum value";
		}
		System.out.println(confNum);
		return confNum;
	}
	//************************************************************************************************
	//*********************Methods to validate ContactNameInDepositPage*******************************
	//************************************************************************************************
	public String validateContactNameInDepositPage() throws InterruptedException {
		String contactName = null;
		try{
			scrollDown(driver);
			contactName= waitAndGetText(contactNameInDeporitPage);
			System.out.println("CONTACT NAME DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateContactNameInDepositPage()");
			contactName =  "Issue with ContactName value";
		}
		System.out.println(contactName);
		return contactName;
	}
	//************************************************************************************************
	//*********************Methods to validate OrderStatusInDepositPage*******************************
	//************************************************************************************************
	public String validateOrderStatusInDepositPage() throws InterruptedException {
		String orderStatus = null;
		try{
			orderStatus= waitAndGetText(orderStatusInDepositPage);
			System.out.println("ORDER STATUS DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateOrderStatusInDepositPage()");
			orderStatus =  "Issue with OrderStatus value";
		}
		System.out.println(orderStatus);
		return orderStatus;
	}
	//************************************************************************************************
	//*********************Methods to validate PayTypeInDepositPage***********************************
	//************************************************************************************************
	public String validatePayTypeInDepositPage() throws InterruptedException {
		String payType = null;
		try{
			Thread.sleep(1000);
			payType= waitAndGetText(payTypeInDepositPage);
			System.out.println("PAY TYPE DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validatePayTypeInDepositPage()");
			payType =  "Issue with PayType value";
		}
		System.out.println(payType);
		return payType;
	}
	//************************************************************************************************
	//*********************Methods to validate GuestNameInDepositPage*********************************
	//************************************************************************************************
	public String validateGuestNameInDepositPage() throws InterruptedException {
		String guestName = null;
		try{
			guestName= waitAndGetText(guestNameInDeporitPage);
			System.out.println("GUEST NAME DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateGuestNameInDepositPage()");
			guestName =  "Issue with GuestName value";
		}
		System.out.println(guestName);
		return guestName;
	}
	//************************************************************************************************
	//*********************Methods to validate ConfirmationInReservationPage**************************
	//************************************************************************************************
	public String validateConfirmationNumberInReservationPage() throws InterruptedException {
		String confNum = null;
		try{
			confNum= waitAndGetText(confirmationNumberInReservationPage);
			System.out.println("CONFIRMATION NUMBER DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateConfirmationNumberInReservationPage()");
			confNum =  "Issue with ConfNum value";
		}
		System.out.println(confNum);
		return confNum;
	}
	//************************************************************************************************
	//*********************Methods to validate ConfirmationInReservationPage**************************
	//************************************************************************************************
	public String validatePromotionTextInReservationPage() throws InterruptedException {
		String promotionText = null;
		try{
			promotionText = waitAndGetText(promotionsText);
			System.out.println("PROMOTION TEST DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validatePromotionTextInReservationPage()");
			promotionText =  "Issue with PromotionText value";
		}
		System.out.println(promotionText);
		return promotionText;
	}
	//************************************************************************************************
	//*********************Methods to validate ItemReport DATA ***************************************
	//************************************************************************************************
	public boolean validateItemReportData() throws InterruptedException {
		boolean result = false;
		try{
			String itemReportData1 = waitAndGetText(cakesPartyGroupFirstRowValueInItemReport);
			String itemReportDate2 = waitAndGetText(sheetVenillaGroupFirstRowValueInItemReport);
			if(itemReportData1.equals("Cakes") && itemReportDate2.equals("Sheet Vanilla")){
				result = true;
			}else{
				result = false;
			}
			System.out.println("ITEM REPORT DATA DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateItemReportData()");
			result = false;
		}
		System.out.println(result);
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validate ItemReportSpecificDataSearch***************************
	//************************************************************************************************
	public String validateItemReportSpecificItemSearch(String searchItem) throws InterruptedException {
		String searchItemFound = null;
		try{
			WebElement ele = driver.findElement(By.partialLinkText(searchItem));
			searchItemFound = ele.getText();
			System.out.println("ITEM REPORT SPECIFIC ITEM SEARCH DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateItemReportSpecificData()");
			searchItemFound = "Found Error in Method: validateItemReportSpecificData()";
		}
		System.out.println(searchItemFound);
		return searchItemFound;
	}
	//************************************************************************************************
	//*********************Methods to validate ItemReport Header *************************************
	//************************************************************************************************
	public String validateItemReportHeader() throws InterruptedException {
		String itemReportHeader = null;
		try{
			itemReportHeader = waitAndGetText(headerOfItemReportPage);
			System.out.println("ITEM REPORT HEADER DISPLAY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateItemReportHeader()");
			itemReportHeader =  "Issue with ItemReport value";
		}
		System.out.println(itemReportHeader);
		return itemReportHeader;
	}
	//************************************************************************************************
	//*********************Methods to validate Cancel Click  *****************************************
	//************************************************************************************************
	public boolean validateCancelClick() throws InterruptedException {
		boolean result = false;
		try{
			String confNum = waitAndGetText(confirmationNumberInDepositDuePage);
			confirmationNumberUseToAddComments = confNum;
			String cancelXpath = "//td[text()='"+confNum+"']/following-sibling::td[3]";
			WebElement cancelBtn = driver.findElement(By.xpath(cancelXpath));
			waitAndClick(cancelBtn);
			result = true;
			System.out.println("CANCEL CLICK SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateCancelClick()");
			result =  false;
		}
		System.out.println(result);
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validate Cancel Reservation ************************************
	//************************************************************************************************
	public String validateCancelReservation(String confNum,String empName) throws InterruptedException {
		String depositDueHeader = null;
		try{
			waitAndClick(cancelReasonListBoxInDepositDue);
			waitAndClick(cancelReasonListOptionDepositNotAppliedToPartyInDepositDue);
			employeeNameInDepositDue.sendKeys(empName);
			waitAndClick(cancelPartyBtn);
			waitAndClick(confirmationPopUpOKBtn);
			//switchToAlertAndAccept();
			depositDueHeader = waitAndGetText(headerOfDepositDuePage);
			System.out.println("CANCEL RESERVATION SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateCancelReservation()");
			depositDueHeader =  "Issue found in Cancel Reservation";
		}
		System.out.println(depositDueHeader);
		return depositDueHeader;
	}
	//************************************************************************************************
	//*********************Methods to Add Comments and Check Status***********************************
	//************************************************************************************************
	public String validateAddingCommentsToCancelledReservationAndGetStatus() throws InterruptedException {
		String reservationStatus = null;
		try{
			waitAndClick(updateDepositInDepositPage);
			waitAndClick(storeCommentsInputBox);
			storeCommentsInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
			storeCommentsInputBox.sendKeys(getSaltString());
			waitAndClick(storeCommentsSaveBtn);
			//switchToAlertAndAccept();
			reservationStatus = waitAndGetText(orderStatusInDepositPage);
			System.out.println("ADDING RESERVATION COMMENTS SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: validateAddingCommentsToCancelledReservationAndGetStatus()");
			reservationStatus =  "Issue found at Adding Comments";
		}
		System.out.println(reservationStatus);
		return reservationStatus;
	}

	//************************************************************************************************
	//*********************Methods to Verify Return To Home Page Link*********************************
	//************************************************************************************************
	public String verifyReturnToHomePageLink() throws InterruptedException {
		String homePageText = null;
		try{
			waitAndClick(returnToHomePageLink);
			homePageText = waitAndGetText(homePageNOTICETOEMPLOYEESText);
			System.out.println("RETURN TO HOME PAGE LINK SUCCESS......................................................................!!!!!!!!!!!");
			return homePageText;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Found Error in Method: verifyReturnToHomePageLink()");
			homePageText =  "Issue found at verifyReturnToHomePageLink()";
		}
		System.out.println(homePageText);
		return homePageText;
	}
	//************************************************************************************************
	//*********************Methods to validate validateGetConfirmationFromDepositPage**************
	//************************************************************************************************
	public String validateGetConfirmationFromDepositPage() throws InterruptedException, AWTException{
		try {
			String confNum;
			confNum = waitAndGetText(confirmationNumberInDepositPage);
			System.out.println(confNum);
			return confNum;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Found Issue in Method: validateGetConfirmationFromDepositPage()");
			return "Found Issue in Method: validateGetConfirmationFromDepositPage()";
		}

	}
	//************************************************************************************************
	//*********************Methods to validate validateGetConfirmationFromDepositPage*****************
	//************************************************************************************************
	public String validateStatusOfSearchedReservationInDepositPage() throws InterruptedException, AWTException{
		try {
			String resStatus;
			resStatus = waitAndGetText(orderStatusInDepositPage);
			System.out.println(resStatus);
			return resStatus;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Found Issue in Method: validateStatusOfSearchedReservationInDepositPage()");
			return "Found Issue in Method: validateStatusOfSearchedReservationInDepositPage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate validateGetConfirmationFromDepositPage*****************
	//************************************************************************************************
	public String validateSeatingPDFPage() throws InterruptedException, AWTException{
		String url = null;
		try {
			String mainWindow = driver.getWindowHandle();
			waitAndClick(seatingLinkInSeatingTab);
			Thread.sleep(7000);
			switchToChildWindow();
			url = driver.getCurrentUrl();
			driver.switchTo().window(mainWindow);
			closeChildWindow();
			System.out.println("URL of the Child Window: "+url);
			return url;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("Found Issue in Method: validateSeatingPDFPage()");
			return "Found Issue in Method: validateSeatingPDFPage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate getBookingInfo in Array  ******************************
	//************************************************************************************************		
	public String[] getBooingInfoInArray() throws Exception{
		initialization(propv.getProperty("GUI"),propv.getProperty("SAP"));
		StoreAppPage storeAppPage = new StoreAppPage();
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(TestUtil.bLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("","",getFutureDateInMMDDYYYY(2), getFutureDateInMMDDYYYY(30),"", "", "", "Birthday", "","","");
		String[] resInfo = storeAppPage.searchAndGetReservationInfo();
		System.out.println("Reservation Information collected from Existing Reservation..........................!!!");
		driver.quit();
		return resInfo;
	}
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					STORE APP LOCATORS AND METHDOS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


}
