/*
 * 
 * Test Suite: Old Booking Funnel Kids Birthday Party Booking
 * Created By: Aditya 
 * Reviewed By: Vishnu
 * Review Date: 04-June-2019
 *  
 */
		
package com.cec.qa.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import static org.testng.Assert.assertEquals;

import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.KidsBirthdayPartyOldPage;
import com.cec.qa.util.TestUtil;


public class KidsBirthdayPartyOldTest extends BaseTest{
	KidsBirthdayPartyOldPage kidsBirthdayPartyOldPage;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public KidsBirthdayPartyOldTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("GUI"),propv.getProperty("OBB"));
		kidsBirthdayPartyOldPage = new KidsBirthdayPartyOldPage();
	}
	
	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

	String storeNumber = TestUtil.tuOldBookingStoreNumber; //StoreNumber assignment from TestUtil
	String bookingDate = Integer.toString(TestUtil.tuOldBookingWeekDayDate); //Booking Date getting from Util after checking Weekday checks.
	String bookingDateForVIP = Integer.toString(TestUtil.tuOldBookingDateForSundayDate); //Booking date getting from Util after checking WeekEnd Checks.
	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:420:BookSite :Verify Confirmation Number Generated For Birthday Reservations
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithStarPackage_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 420:BookSite :Verify Confirmation Number Generated For Birthday Reservations");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("Star","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:315:Book site : Verify user is able to generate Confirmation for Birthday site on Browser Mozilla Firefox
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithSuperStarPackage_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 315:Book site : Verify user is able to generate Confirmation for Birthday site on Browser Mozilla Firefox");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:306:BookSite_Verify Confirmation Number Generated For Candian Store
	//Test case:314:Book site : Verify user is able to generate Confirmation for Birthday site on Browser IE
	//Test case:419:BookSite_WebsiteSelectingPartyPackage
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithMegaStarPackage_TC_306() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 306:BookSite_Verify Confirmation Number Generated For Candian Store");
		kidsBirthdayPartyOldPage.validateSelectStore("0845");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("MegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:316:Book site : Verify user is able to generate Confirmation for Birthday site on Safari Desktop
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyBirthdayPartyBookingWithVIPMegaStarPackage_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 316:Book site : Verify user is able to generate Confirmation for Birthday site on Safari Desktop");
		kidsBirthdayPartyOldPage.validateSelectStore("0031");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDateForVIP, "09:00 AM");
		kidsBirthdayPartyOldPage.validateSelectPackage("VIPMegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:436:Book Site: Verify that  minimum children confirmation popup message appear when minimum children entered is less than minimum children required for a selected wave
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyMinmumChildErrorMsgVIPParty_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 436:Book Site: Verify that  minimum children confirmation popup message appear when minimum children entered is less than minimum children required for a selected wave");
		kidsBirthdayPartyOldPage.validateSelectStore("0595");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDateForVIP, "09:00 AM");
		kidsBirthdayPartyOldPage.validateSelectPackage("VIPMegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String errorMsgVIPMinChild = kidsBirthdayPartyOldPage.validateVIPErrorMessge("min");
		Assert.assertEquals(errorMsgVIPMinChild, "The party time you selected has a minimum requirement of 10 children. Would you like to increase your number of children to 10?","Error message is wrong");
	}
	//*******************************************************************************************************************************************
	//Test case:299:BookSite_Verify Overbooking PopUp Message Displays For Birthday Site When Number Of Children Increased More Than Available Seats
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyOverBookingErrorMsgVIPParty_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 299:BookSite_Verify Overbooking PopUp Message Displays For Birthday Site When Number Of Children Increased More Than Available Seats");
		kidsBirthdayPartyOldPage.validateSelectStore("0033");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDateForVIP, "09:00 AM");
		kidsBirthdayPartyOldPage.validateSelectPackage("VIPMegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String errorMsgVIPOverBook = kidsBirthdayPartyOldPage.validateVIPErrorMessge("max");
		Assert.assertEquals(errorMsgVIPOverBook, "Due to the increase of children/adults the time you originally selected is no longer available. To move forward with the same time slot, reduce the children/adults?","Error message is wrong");
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify user is able to Upgrade the SuperStar to MegaStar package in Chrome browser for Irving store
	//Reviewed by: Aditya on 03-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithUpgradeSuperStartoMegaStarPackage() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify user is able to Upgrade the SuperStar to MegaStar package in Chrome browser for Irving store");
		kidsBirthdayPartyOldPage.validateSelectStore("0081");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","YES");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		kidsBirthdayPartyOldPage.validateConfirmationNumber();
		String selectedpackage = kidsBirthdayPartyOldPage.validateUpgradePackage();
		Assert.assertEquals(selectedpackage.contains("MEGA SUPER STAR"), true,"Package not upgraded");
	}
	//*******************************************************************************************************************************************
	//Test case:628:Book:- Verify user successfully create birthday reservation for more than one birthday star
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithAdditionalBirthdayStar_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 628:Book:- Verify user successfully create birthday reservation for more than one birthday star");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "03:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(1);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify user is able to generate Confirmation for Birthday Party with OptionalItem
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=3)
	public void verifyBirthdayPartyBookingWithOptionalItems() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify user is able to generate Confirmation for Birthday Party with OptionalItem");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("YES");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		String confNumber = kidsBirthdayPartyOldPage.validateConfirmationNumber();
		int confNumberLenght = confNumber.length();
		if(confNumberLenght==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:7:Birthday:Verify user is able to find the Duplicate popup for Birthday Party
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=3)
	public void verifyBirthdayPartyBookingWithDuplicates() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 7:Birthday:Verify user is able to find the Duplicate popup for Birthday Party");
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		kidsBirthdayPartyOldPage.validateConfirmationNumber();
		kidsBirthdayPartyOldPage.validateSelectStore("0081");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		boolean duplicatePopUpFound =kidsBirthdayPartyOldPage.validateDuplidateBookingWarningWindow();
		Assert.assertEquals(duplicatePopUpFound, true,"Duplicate PopUp window NOT FOUND");
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify user is able to verify the Estimated total amount for booking
	//Reviewed by: Aditya on 03-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=2)
	public void verifyBirthdayPartyBookingWithEstimatedTotal() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify user is able to verify the Estimated total amount for booking");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		String totalCost= kidsBirthdayPartyOldPage.validatePackagePrice("MegaStar","NO");
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		System.out.println("The Total Cost is : "+totalCost);
		String totalAmount = kidsBirthdayPartyOldPage.validatePriceAtReservationSummaryPage();
		System.out.println("The Updated Cost in Summary Page :" +totalAmount);
		Assert.assertEquals(totalCost, totalAmount,"Total Amount Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify the Form validation for Party Details Page
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=3)
	public void verifyPartyDetailsFieldValidation() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify the Form validation for Party Details Page");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		String errMsg1 = kidsBirthdayPartyOldPage.validateBirthdayBookingMandatoryFields("NO","NO");
		System.out.println("errMsg1"+errMsg1);
		String errMsg2 = kidsBirthdayPartyOldPage.validateBirthdayBookingMandatoryFields("YES","NO");
		System.out.println("errMsg2"+errMsg2);
		//Condition to validate all methods called return message text. 
		if(errMsg1.contains("Children required.") && errMsg2.contains("Adults required.")){
			Assert.assertTrue(true);
		}else{	
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify the Min Attendees Error message for Party Details Page
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=3)
	public void verifyPartyDetailsMinChildAdult() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify the Min Attendees Error message for Party Details Page");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		String errMsg1 = kidsBirthdayPartyOldPage.validateBirthdayBookingMinChildAdult("MIN","YES");
		System.out.println("errMsg1"+errMsg1);
		String errMsg2 = kidsBirthdayPartyOldPage.validateBirthdayBookingMinChildAdult("YES","MIN");
		System.out.println("errMsg2"+errMsg2);
		//Condition to validate all methods called return message text. 
		if(errMsg1.contains("Minimum 4 children required.") && errMsg2.contains("Minimum 1 guest required.")){
			Assert.assertTrue(true);
		}else{	
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:307:BookSite : Verify That User Is Able To Create And Update Reservations For Franchise Stores
	//Reviewed by: Aditya on 02-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=4)
	public void validateModifyReservationDetails_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 307:BookSite : Verify That User Is Able To Create And Update Reservations For Franchise Stores");
		kidsBirthdayPartyOldPage.validateSelectStore("3225");
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("MegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation_Tupelo();
		kidsBirthdayPartyOldPage.validateConfirmationNumber();
		kidsBirthdayPartyOldPage.validateModifyReservation();
		kidsBirthdayPartyOldPage.validateUpdatePartySize();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate+1, "11:00 AM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformationClear();
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformationClear();
		boolean result = kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		Assert.assertTrue(result);
	}
	//*******************************************************************************************************************************************
	//Test case:221:Book Site : Verify navigating back  to Who is coming to Party page through number header.
	//Reviewed by: Aditya on 03-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=3)
	public void verifyBirthdayPartyBookingWithHeaderLink_TCID_420() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 221:Book Site : Verify navigating back  to Who is coming to Party page through number header.");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("SuperStar","YES");//Base PKG, YES/NO to Upgrade, 
		String header = kidsBirthdayPartyOldPage.validateHeaderLink();
		Assert.assertEquals(header, "Who Is Coming To The Party?","Header Text is wrong");
	}
	//*******************************************************************************************************************************************
	//Test case:Birthday:Verify that user is able to Modify the details of Existing Reservation from Cart
	//Reviewed by: Aditya on 06-26-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=4)
	public void validateModifyReservationDetailsFromCart() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Birthday:Verify that user is able to Modify the details of Existing Reservation from Cart");
		kidsBirthdayPartyOldPage.validateSelectStore(storeNumber);
		kidsBirthdayPartyOldPage.validateSelectChildAdult();
		kidsBirthdayPartyOldPage.validateSelectPartyDate(bookingDate, "01:00 PM");
		kidsBirthdayPartyOldPage.validateSelectPackage("MegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyOldPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyOldPage.validateSelectOptionalitems("NO");
		kidsBirthdayPartyOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyOldPage.validateReservationSummary();
		kidsBirthdayPartyOldPage.validatePaymentInformation();
		kidsBirthdayPartyOldPage.validateConfirmationNumber();
		kidsBirthdayPartyOldPage.validateModifyReservation();
		boolean editSuccess =kidsBirthdayPartyOldPage.validateEditPartySizeFromCart();
		Assert.assertTrue(editSuccess);
	}
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	} 
}