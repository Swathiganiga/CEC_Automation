package com.cec.qa.tests;

import java.awt.AWTException;
import java.io.IOException;
import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.StoreAppPage;
import com.cec.qa.util.TestUtil;

import net.bytebuddy.description.modifier.SynchronizationState;

public class StoreAppTest extends BaseTest{

	StoreAppPage storeAppPage;
	public String gconfirmationNumber=null;
	public String gpizzaCount = null;
	public String gpackageName = null;
	public String gguestName = null;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;
	public String gbLocation = TestUtil.bLocation;
	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public StoreAppTest() {
		super();
	}
	//************************************************************************************************
	//*********************@BeforeClass **************************************************************
	//************************************************************************************************
	
	@BeforeClass
	public void preRequisite() throws Exception{
		System.out.println("@BeforeClass Start.................................................!!!");
		initialization(propv.getProperty("GUI"),propv.getProperty("SAP"));
		storeAppPage = new StoreAppPage();
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("","",getFutureDateInMMDDYYYY(2), getFutureDateInMMDDYYYY(30),"", "", "", "Birthday", "","","");
		String[] resInfo = storeAppPage.searchAndGetReservationInfo();
		System.out.println("Reservation Information collected from Existing Reservation..........................!!!");
		System.out.println("gguestName");
		System.out.println(resInfo[6]);
		this.gguestName = resInfo[6];
		System.out.println("gcontactName");
		System.out.println(resInfo[1]);
		this.gcontactName = resInfo[1];
		System.out.println("gcontactPhone");
		System.out.println(resInfo[2]);
		this.gcontactPhone = resInfo[2];
		System.out.println("gcontactEmail");
		System.out.println(resInfo[4]);
		this.gcontactEmail = resInfo[4];
		System.out.println("gbLocation");
		System.out.println(TestUtil.bLocation);
		this.gbLocation = TestUtil.bLocation;
		System.out.println("gconfirmationNumber");
		System.out.println(resInfo[8]);
		this.gconfirmationNumber = resInfo[8];
		System.out.println("gpizzaCount");
		System.out.println("2");
		this.gpizzaCount = "2";
		
		String availablePackage = resInfo[13];
		System.out.println("availablePackage");
		System.out.println(resInfo[13]);
		System.out.println("Reservation Information collected from Existing Reservation..........................!!!");
		if(availablePackage.contains("SUPER STAR")){
			this.gpackageName = "MEGA SUPER STAR";
		}else if(availablePackage.contains("MEGA SUPER STAR")){
			this.gpackageName = "SUPER STAR";
		}else if(availablePackage.contains("STAR")){
			this.gpackageName = "SUPER STAR";
		}
		driver.quit();
		System.out.println("@BeforeClass End...................................................!!!");
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("@BeforeMethod Start................................................!!!");
		initialization(propv.getProperty("GUI"),propv.getProperty("SAP"));
		storeAppPage = new StoreAppPage();
		System.out.println("@BeforeMethod End..................................................!!!");
	}
	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************
	
	//************************************************************************************************
	//Verify the Title of the STORE APP Website.
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyTitleOfTheStoreApp() throws InterruptedException
	{
		System.out.println("------>>>Verify the Title of the STORE APP Website.");
		storeAppPage.validateLoginToStoreApp();
		String saTitle = driver.getTitle();
		System.out.println("Actual Result:"+saTitle+"Expected Result:- Chuck E. Cheese Store Application");
		if(!gconfirmationNumber.equals(null)){
			Assert.assertEquals(saTitle, "- Chuck E. Cheese Store Application","StoreApp Title Mismatch");
		}else{
			Assert.assertEquals(gconfirmationNumber, "","This is failed due to Pre-requisite test failure, this will skip the execution of all StoreApp Tests");
		}
	}
	//************************************************************************************************
	//227 Store App: Verify min children message displays when user reduce children less than min children setup
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyMinChildErrorMessage_TCID_227() throws Exception
	{
		System.out.println("------>>>227 Store App: Verify min children message displays when user reduce children less than min children setup");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "","","");
		storeAppPage.validateUpdateReservationButtonClick();
		storeAppPage.validateUpdateReservationInfo("", "3", "", "");
		String errorMessage = storeAppPage.validateReservationUpdateErrorMessage();
		System.out.println("Actual Result:"+errorMessage+"Expected Result:Minimum 4 children required");
		Assert.assertEquals(errorMessage,"Minimum 4 children required","Mismatch in Error Message");
	}
	//************************************************************************************************
	//232 Store App: Verify user can  make any changes except minimum children in case of Change of Reservation.
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyUpdateReservation_TCID_232() throws Exception
	{
		System.out.println("------>>>232 Store App: Verify user can  make any changes except minimum children in case of Change of Reservation.");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "","","");
		storeAppPage.validateUpdateReservationButtonClick();
		storeAppPage.validateUpdateReservationInfo("", "", gpackageName, gpizzaCount);
		String packageNameFound = storeAppPage.validatePackageName(gpackageName);
		String upSellValueFound = storeAppPage.validateUpSell();
		System.out.println("Package Name:"+packageNameFound);
		System.out.println("Upsell Value:"+upSellValueFound);
		System.out.println("Actual Result1:"+packageNameFound+"Actual Result2:"+upSellValueFound);
		System.out.println("Expected Result1: [Party Package] : "+gpackageName+"Expected Result2:"+gpizzaCount+" - Large 1 Topping -Pizzas");
		if(packageNameFound.contains("[Party Package] : "+gpackageName) && upSellValueFound.contains("Qty. "+gpizzaCount+" - Large 1 Topping -Pizzas")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//401 Store App: Verify user can generate deposit report using confirmation number
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingConfirmationNumber_TCID_401() throws Exception
	{
		System.out.println("------>>>401 Store App: Verify user can generate deposit report using confirmation number");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "","","","");
		String confNum = storeAppPage.validateConfirmationNumberInDepositPage();
		System.out.println("Actual Result:"+confNum+"Expected Result:"+gconfirmationNumber);
		Assert.assertEquals(confNum, gconfirmationNumber,"Mismatch in Confirmation Number");
	}
	//************************************************************************************************
	//402 Store App: Verify user can generate deposit report using Reservation Type
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS 
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingReservationType_TCID_402() throws Exception
	{
		System.out.println("------>>>402 Store App: Verify user can generate deposit report using Reservation Type");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch(getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0), "","","", "", "", "Organizational", "","","","");
		String contactName = storeAppPage.validateContactNameInDepositPage();
		System.out.println("Actual Result:"+contactName+"Expected Result:NotNull");
		if(!contactName.equals("")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//403 Store App: Verify user can generate deposit report using Reservation Status
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run:  PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingOrderStatus_TCID_403() throws Exception
	{
		System.out.println("------>>>403 Store App: Verify user can generate deposit report using Reservation Status");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch(getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"","","", "", "", "","Cancelled","","","");
		String orderStatus = storeAppPage.validateOrderStatusInDepositPage();
		System.out.println("Actual Result:"+orderStatus+"Expected Result:Cancelled");
		Assert.assertEquals(orderStatus, "Cancelled","Mismatch in Order Status");
	}
	//************************************************************************************************
	//404 Store App: Verify user can generate deposit report using Deposit Payment
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS 
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingDepositPayment_TCID_404() throws Exception
	{
		System.out.println("------>>>404 Store App: Verify user can generate deposit report using Deposit Payment");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch(getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0), "","","", "", "", "", "","","","Unpaid");
		String payType = storeAppPage.validatePayTypeInDepositPage();
		System.out.println("Actual Result:"+payType+"SSSS HARD CODE --> Cash");
		if(payType.equals("Cash")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//405 Store App: Verify user can generate deposit report using Guest Name
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS 
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingGuestName_TCID_405() throws Exception
	{
		System.out.println("------>>>405 Store App: Verify user can generate deposit report using Guest Name");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch("", "", "","",gconfirmationNumber, gguestName, "", "", "","","","");
		String guestNameFound = storeAppPage.validateGuestNameInDepositPage();
		System.out.println("Actual Result:"+guestNameFound+"Expected Result:"+gguestName);
		if(guestNameFound.contains(gguestName)){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//406 Store App: Verify user can generate deposit report using Contact Name
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS 
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyDepositReportUsingContactName_TCID_406() throws Exception
	{
		System.out.println("------>>>406 Store App: Verify user can generate deposit report using Contact Name");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "",gcontactName,"","");
		String contactNameFound = storeAppPage.validateContactNameInDepositPage();
		System.out.println("Actual Result:"+contactNameFound+"Expected Result:"+gcontactName);
		Assert.assertEquals(contactNameFound, gcontactName,"Mismatch in Contact Name");
	}
	//************************************************************************************************
	//407 Store App : Verify that user is able to Cancel a record from the Deposit Due report.
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyCancelReservation_TCID_407() throws Exception
	{
		System.out.println("------>>>407 Store App : Verify that user is able to Cancel a record from the Deposit Due report.");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositDueTabSelect();
		storeAppPage.validateCancelClick();
		String result = storeAppPage.validateCancelReservation(gconfirmationNumber,"EmpXYZ");
		System.out.println("Actual Result:"+result+"Expected Result:Chuck E. Cheese's Deposit Due Report");
		Assert.assertEquals(result, "Chuck E. Cheese's Deposit Due Report","Mismatch found in Cancelling a reservation");
	}
	//************************************************************************************************
	//408 Store App : Verify user can generate reservation report using confirmation number
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyReservationReportUsingConfirmationNumber_TCID_408() throws Exception
	{
		System.out.println("------>>>408 Store App : Verify user can generate reservation report using confirmation number");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "","","");
		String confNumFound = storeAppPage.validateConfirmationNumberInReservationPage();
		System.out.println("Actual Result:"+confNumFound+"Expected Result:"+gconfirmationNumber);
		Assert.assertEquals(confNumFound, gconfirmationNumber,"Mismatch Found in Confirmation Number");
	}
	//************************************************************************************************
	//2024 Store App : Verify  Discretionary Reward displays in reservation report 
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyReservationReportPromotionTextUsingConfirmationNumber_TCID_2024() throws Exception
	{
		System.out.println("------>>>2024 Store App : Verify  Discretionary Reward displays in reservation report");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		storeAppPage.validateReservationPartyInfoSearch("", "", "","",gconfirmationNumber, "", "", "", "","","");
		String promotionTextFound = storeAppPage.validatePromotionTextInReservationPage();
		System.out.println("Actual Result:"+promotionTextFound+"Expected Result:Get 20 Bonus Play Points when you book online.");
		if(promotionTextFound.contains("Get 20 Bonus Play Points when you book online.")||!promotionTextFound.contains("")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//2070 Store: Item Report: Verify generation of report within party date 
	//Created and Reviewed By: Vishnu on 14-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyItemReportByGivingPartyDates_TCID_2070() throws Exception
	{
		System.out.println("------>>>2070 Store: Item Report: Verify generation of report within party date");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateItemReportTabSelect();
		storeAppPage.validateItemReportSearch("","");//Presently not sending any date From: and To: dates as default date getting results
		boolean reportResult = storeAppPage.validateItemReportData();
		System.out.println("Actual Result:"+reportResult+"Expected Result:True");
		Assert.assertEquals(reportResult, true,"Item Report Result Mismatch");
	}
	//************************************************************************************************
	//2084 Store:Item Report- Verify user navigates to Item Report Page on clicking Item Report Menu 
	//Created and Reviewed By: Vishnu on 11-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyItemReportPageHeader_TCID_2084() throws Exception
	{
		System.out.println("------>>>2084 Store:Item Report- Verify user navigates to Item Report Page on clicking Item Report Menu");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateItemReportTabSelect();
		String itemReportHeaderFound = storeAppPage.validateItemReportHeader();
		System.out.println("Actual Result:"+itemReportHeaderFound+"Expected Result:Chuck E. Cheese Item Report");
		Assert.assertEquals(itemReportHeaderFound, "Chuck E. Cheese Item Report","Mismatch in Report Header");
	}
	//************************************************************************************************
	//6681 Add Comments to Cancelled reservaiton and verify the status of the Reservation
	//Created and Reviewed By: Vishnu on 29-Mar-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyAddingCommentsToCancelledReservationAndItsStatus_TCID_6681() throws Exception
	{
		System.out.println("------>>>6681 Add Comments to Cancelled reservaiton and verify the status of the Reservation");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch("","",getFutureDateInMMDDYYYY(-30),getFutureDateInMMDDYYYY(0),"", "", "", "", "Cancelled","","","");
		String confNum = storeAppPage.validateGetConfirmationFromDepositPage();
		storeAppPage.validateDepositTabSelect();
		storeAppPage.validateDepositPartyInfoSearch("","","","",confNum, "", "", "", "Cancelled","","","");
		storeAppPage.validateAddingCommentsToCancelledReservationAndGetStatus();
		storeAppPage.validateDepositPartyInfoSearch("","","","",confNum, "", "", "", "Cancelled","","","");
		String reservationStatus = storeAppPage.validateStatusOfSearchedReservationInDepositPage();
		System.out.println("Actual Result:"+reservationStatus+"Expected Result:Cancelled");
		Assert.assertEquals(reservationStatus, "Cancelled","Mismatch found in Adding Comments to a Cancelled Reservation");
	}
	//************************************************************************************************
	//6924 Verify that 'Return to home page' link is displayed for page/url errors
	//Created and Reviewed By: Vishnu on 11-April-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyReturnToHomePageLink_TCID_6924() throws Exception
	{
		System.out.println("------>>>6924 Verify that 'Return to home page' link is displayed for page/url errors");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateReservationTabSelect();
		String currentUrl = driver.getCurrentUrl();
		String newUrl = currentUrl+"/XYZ";
		driver.navigate().to(newUrl);
		String homePageTextFound = storeAppPage.verifyReturnToHomePageLink();
		System.out.println("Actual Result:"+homePageTextFound+"Expected Result:NOTICE TO EMPLOYEES");
		Assert.assertEquals(homePageTextFound, "NOTICE TO EMPLOYEES","Mismatch found in HomePage");
	}
	//************************************************************************************************
	//6933 Verify whether Seating document open when we click on seating button
	//Created and Reviewed By: Vishnu on 31-May-2019
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifySeatingPDFPage_TCID_6933() throws Exception
	{
		System.out.println("------>>>6933 Verify whether Seating document open when we click on seating button");
		storeAppPage.validateLoginToStoreApp();
		storeAppPage.validateSelectStoreInStoreApp(gbLocation);
		storeAppPage.validateSeatingTabSelect();
		String childWindowURL = storeAppPage.validateSeatingPDFPage();
		if(childWindowURL.contains("pdf")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	//************************************************************************************************
	//*********************@AfterClass ***************************************************************
	//************************************************************************************************
	@AfterClass
	public void reSetAll(){
		gconfirmationNumber=null;
		gpizzaCount = null;
		gpackageName = null;
		gguestName = null;
		gcontactName = null;
		gbLocation = null;
		gcontactEmail = null;
		gcontactPhone = null;
	}
}
