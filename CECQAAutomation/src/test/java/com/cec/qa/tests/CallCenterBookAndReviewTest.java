/*
 * 
 * Test Suite: CallCenterBookAndReviewTest
 * Created By: Aditya 
 * Reviewed By: Vishnu
 * Review Date: 11-June-2019
 *  
 */
package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.CallCenterBookAndReviewPage;
import com.cec.qa.pages.CallCenterPromotionAndRewardsPage;
import com.cec.qa.util.TestUtil;

public class CallCenterBookAndReviewTest extends BaseTest{
	CallCenterBookAndReviewPage callCenterBookAndReviewPage;
	CallCenterPromotionAndRewardsPage callCenterPromotionAndRewardsPage;
	public String confNum=null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterBookAndReviewTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));
		callCenterBookAndReviewPage = new CallCenterBookAndReviewPage();
		callCenterPromotionAndRewardsPage = new CallCenterPromotionAndRewardsPage();
	}

	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

	String storeNumber = TestUtil.tuCallCenterStoreNumber; //StoreNumber assignment from TestUtil

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:121:Call center:- Call Center : Verify that  School Name, Principal, Address and Phone are mandatory fields in School Fund Raising booking page
	//Reviewed by: Aditya on 29/04/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyErrorOnBookingschoolfundraising_TCID_121() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 121:Call center:- Call Center : Verify that  School Name, Principal, Address and Phone are mandatory fields in School Fund Raising booking page");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0042"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("FundRaiser",0);
		callCenterBookAndReviewPage.validatePackage("Fundraiser","School Fundraisers");
		boolean errormsg = callCenterBookAndReviewPage.validateRequiredMsgFundraiser();
		Assert.assertTrue(errormsg, "Mismatch in Required Fields message");
	}
	//*********************************************************************************************************
	//Test case:393:CallCentre:- Verify confirmation number is generated after book birthday reservation order 
	//Reviewed by: Aditya on 24/05/2019
	//Test Run: PASS
	//*********************************************************************************************************
	@Test
	public void verifyConfirmationNumberGeneratedOnBookingBirthdayParty_TCID_393() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 393:CallCentre:- Verify confirmation number is generated after book birthday reservation order");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",4); //1 - 2nd time slot ex: 12:00 PM
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar"); //  Star/SuperStar/MegaSuperStar/VIPMegaSuperStar
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//**************************************************************************************************************************************************************************
	//Test case:427:Call center:-Verify user can book VIP party wave for selected time slot(Saturday 8:00 AM wave & Sunday 9:00 AM wave) when VIP party type criteria is matched
	//Reviewed by: Aditya on 29/04/2019
	//Test Run: PASS
	//**************************************************************************************************************************************************************************
	@Test
	public void verifyConfirmationNumberGeneratedOnBookingVIPBirthdayParty_TCID_427() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 427:Call center:-Verify user can book VIP party wave for selected time slot(Saturday 8:00 AM wave & Sunday 9:00 AM wave) when VIP party type criteria is matched");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("VIPBirthday",0); //0 - 1st time slot ex: 08:00/09:00 AM
		callCenterBookAndReviewPage.validatePackage("Birthday","VIPMegaSuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:397:CallCentre:- Verify the Review order details, when user book the Organizational Event
	//Reviewed by: Aditya on 24/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyConfirmationNumberGeneratedOnBookingOrganizationEvent_TCID_397() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 397:CallCentre:- Verify the Review order details, when user book the Organizational Event");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Organizational",3);//2 - 3rd time slot ex: 01:00 PM
		callCenterBookAndReviewPage.validatePackage("Organization","120min"); //60min/90min/120min
		callCenterBookAndReviewPage.validateGuestInformation("Organization");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		System.out.println(confirmationNumber);
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:398:CallCentre:-Verify confirmation number generated for school fundraising party and Review order details
	//Reviewed by: Aditya on 24/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyConfirmationNumberGeneratedOnBookingschoolfundraising_TCID_398() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 398:CallCentre:-Verify confirmation number generated for school fundraising party and Review order details");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("FundRaiser",0);// 0 - 1st Timeslot ex: 3:00 PM
		callCenterBookAndReviewPage.validatePackage("Fundraiser","School Fundraisers");
		callCenterBookAndReviewPage.validateGuestInformation("School Fundraiser");
		callCenterBookAndReviewPage.validateContactInformation("Fundraisers");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("Fundraisers");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:399:Call center:- Verify that confirmation number generated for Non-Profit FundRaising party and User can search it on review page
	//Reviewed by: Aditya on 29/04/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyConfirmationNumberGeneratedOnBookingNonProfitFundRaising_TCID_399() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 399:Call center:- Verify that confirmation number generated for Non-Profit FundRaising party and User can search it on review page");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("FundRaiser",0);// 0 - 1st Timeslot ex: 3:00 PM
		callCenterBookAndReviewPage.validatePackage("Fundraiser","NonProfit Fundraisers");
		callCenterBookAndReviewPage.validateGuestInformation("NonProfit Fundraisers");
		callCenterBookAndReviewPage.validateContactInformation("Fundraisers");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("Fundraisers");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:368:Call Center: Verify that optional item displays on Reservation summary and Review page if count is only 1.
	//Reviewed by: Aditya on 07/03/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyBookingBirthdayPartyWithOptionalItem_TCID_368() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 368:Call Center: Verify that optional item displays on Reservation summary and Review page if count is only 1.");
		callCenterBookAndReviewPage.validateRobotLogin();	
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber);
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateOptionalItem();
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String optionalItemName = callCenterBookAndReviewPage.getOptionalItemNameFromSummeryPage();	 
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		boolean optionalItmNameResult = callCenterBookAndReviewPage.validateGetOptionalItemNameFromreviewPage(optionalItemName);
		System.out.println("optionalItemName in cc:: "+optionalItemName);
		System.out.println(optionalItmNameResult);
		Assert.assertEquals(optionalItmNameResult, true,"Found Mismatch in Optional Items Result");
	}
	//*******************************************************************************************************************************************
	//Test case:2261:Call Center:-Verify user is able to book another Org/Fundraising party using Copy button. 
	//Reviewed by: Aditya on 22/05/2019
	//Test Run: PASS 
	//*******************************************************************************************************************************************
	@Test
	public void verifyCopyFunctionality_TCID_2261() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2261:Call Center:-Verify user is able to book another Org/Fundraising party using Copy button. ");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Organizational",4);
		callCenterBookAndReviewPage.validatePackage("Organization","90min");
		callCenterBookAndReviewPage.validateGuestInformation("Organization");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confNum1= callCenterBookAndReviewPage.validateCopyforOrgOrFundraiser("Organization");
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Organizational",3);
		callCenterBookAndReviewPage.validatePackage("Organization","60min");
		callCenterBookAndReviewPage.validateGuestInformation("Organization");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confNum2= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateSearchWithConfNumber(confNum2);
		Assert.assertNotEquals(confNum1, confNum2, "Match in Confirmation number ");	
	}
	//*******************************************************************************************************************************************
	//Test case:2243:Call Center:-Verify changing Birthday reservation to Organization and generate confirmation id
	//Reviewed by: Aditya on 21/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyChangeBirthdaytoOrganizationEvent_TCID_2243() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2243:Call Center:-Verify changing Birthday reservation to Organisation and generate confirmation id");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confNum= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateReviewSearchMenu(confNum);
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Organizational",3);
		callCenterBookAndReviewPage.validatePackage("Organization","120min");
		callCenterBookAndReviewPage.validateGuestInformation("Organization");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:2244:Call Center:-Verify changing Organization reservation to Birthday and generate confirmation id.
	//Reviewed by: Aditya on 21/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyChangeOrganizationEventtoBirthday_TCID_2244() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2244:Call Center:-Verify changing Organisation reservation to Birthday and generate confirmation id.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Organizational",4);
		callCenterBookAndReviewPage.validatePackage("Organization","90min");
		callCenterBookAndReviewPage.validateGuestInformation("Organization");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confNum= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateReviewSearchMenu(confNum);
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",1);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:2262:Call Center:-Verify user is able to complete the booking if Alternate Store is selected on coming back while booking. 
	//Reviewed by: Aditya on 22/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyBookingwithAlternateStore_TCID_2262() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 22262:Call Center:-Verify user is able to complete the booking if Alternate Store is selected on coming back while booking.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0033"); //NOTE: Don't modify storeNum:0033 is dependent for this test case.
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confNum= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateReviewSearchMenu(confNum);
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateAlternateStore(); //NOTE: StoreNum:0033 is dependent for this method.
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",1);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:346:Call Center: Verify that user is able to Save the changes made to Name/Phone/Email fields and Optional Items on Call Center Reservation Review Screen
	//Reviewed by: Aditya on 25/05/2019, Updated by: Vishnu on 15/07/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyEditFieldsReviewPage_TCID_346() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 346:Call Center: Verify that user is able to Save the changes made to Name/Phone/Email fields and Optional Items on Call Center Reservation Review Screen");
			callCenterBookAndReviewPage.validateRobotLogin();
			callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
			callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
			callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
			callCenterBookAndReviewPage.validateGuestInformation("Birthday");
			callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
			String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
			String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
			boolean result = callCenterBookAndReviewPage.validateEditFieldsOnReviewPage(confNumber);
			Assert.assertEquals(result, true,"Mismatch in Edit Contact Info");
	}
	//*******************************************************************************************************************************************
	//Test case:429:Call Center : Verify that when user changes the party date, the confirmation number changes
	//Reviewed by: Aditya on 28/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyChangeinConfNumWhenPartyDateChange_TCID_429() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 429:Call Center : Verify that when user changes the party date, the confirmation number changes");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber1= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber1 = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber1);
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		System.out.println("The Party date is changed");
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber2= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber2 = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber2);
		System.out.println("The Confirmation Number before party date changed is:"+confirmationNumber1);
		System.out.println("The Confirmation Number after party date changed is"+confirmationNumber2);
		Assert.assertEquals(confNumber1, confNumber2, "Confirmation number is changed after party date changed");
	}
	//*******************************************************************************************************************************************
	//Test case:430:CallCentre:- Verify that when user changes the store, the confirmation number changes.
	//Reviewed by: Aditya on 28/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyChangeinConfNumWhenStoreChange_TCID_430() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 430:CallCentre:- Verify that when user changes the store, the confirmation number changes.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0845"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber1= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber1 = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber1);
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateStoreNumber("0031"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber2= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber2 = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber2);
		System.out.println("The Confirmation Number before store changed is:"+confirmationNumber1);
		System.out.println("The Confirmation Number after store changed is"+confirmationNumber2);
		Assert.assertEquals(confNumber1, confNumber2, "Confirmation number is changed after party date changed");
	}


	//*******************************************************************************************************************************************
	//Test case:395:Call Center:-Verify that user is able to make changes to any previously booked reservation.
	//Reviewed by: Aditya on 29/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMakeChangesPreviousBooking_TCID_395() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 395:Call Center:-erify that user is able to make changes to any previously booked reservation.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateStoreNumber("0031"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:392:CallCentre:-Verify functionality of New button on review details reservation screen after selecting reservation
	//Reviewed by: Aditya on 20/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyNewButtonFunctionality_TCID_392() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 392:CallCentre:-Verify functionality of New button on review details reservation screen after selecting reservation");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateNewButton();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:390:CallCentre:-Verify functionality of Change button on review details of reservation
	//Reviewed by: Aditya on 20/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyChangeButtonFunctionality_TCID_390() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 390:CallCentre:-Verify functionality of Change button on review details of reservation");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","MegaSuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:396:Call Center:-Verify that it is possible to book reservation on any previously cancelled reservation
	//Reviewed by: Aditya on 29/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMakeCancelPreviousBooking_TCID_396() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 396:Call Center:-Verify that it is possible to book reservation on any previously cancelled reservation");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu("0033","",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateCancelButton();
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",4);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:339:Call Center :Verify on selecting alternate store from the drop down, the store gets selected and address and phone details display  for the new store.
	//Reviewed by: Aditya on 24/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAlternateStoreAdress_TCID_339() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 339:Call Center :Verify on selecting alternate store from the drop down, the store gets selected and address and phone details display  for the new store");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0031"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		callCenterBookAndReviewPage.validateChangeButton();
		boolean alternatestore=callCenterBookAndReviewPage.validateAlternateStore();
		Assert.assertEquals(alternatestore,false);
	}

	//*******************************************************************************************************************************************
	//Test case:297:Call center:-Verify  comments are getting saved on call Center Reservation review page
	//Reviewed by: Aditya on 20/05/2019
	//Test Run: Work on assertion
	//*******************************************************************************************************************************************
	@Test
	public void verifyCommentsReviewPage_TCID_297() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 297:Call center:-Verify  comments are getting saved on call Center Reservation review page");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",5);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		boolean comments = callCenterBookAndReviewPage.validateCustAndAgentComments();
		Assert.assertTrue(comments);	
	}

	//*******************************************************************************************************************************************
	//Test case:302:Call Center:-Verify customer and agent Comments are getting added  correctly from call Center
	//Reviewed by: Aditya on 20/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddComments_TCID_302() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 302:Call Center:-Verify customer and agent Comments are getting added  correctly from call Center");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",2);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		boolean comments = callCenterBookAndReviewPage.validateCustAndAgentComments();
		Assert.assertTrue(comments);	
	}

	//*******************************************************************************************************************************************
	//Test case:340:Call Center :Call Center: Verify the Item unit based cost, Reservation Total & HLRef number are displayed on the Reservation Review Screen.
	//Reviewed by: Aditya on 25/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyHLRefNumAndTotalCost_TCID_340() throws InterruptedException, AWTException, IOException {
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		boolean hLRefNumAndTotalCost=callCenterBookAndReviewPage.validateTotalAmountAndHLref();
		Assert.assertEquals(hLRefNumAndTotalCost,true);
	}

	//*******************************************************************************************************************************************
	//Test case:342:Call Center:-Verify Manager is not allowed to do New bookings for current day
	//Reviewed by: Aditya on 22/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCurrentday_TCID_342() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 342:Call Center:-Verify Manager is not allowed to do New bookings for current day");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0845"); 
		boolean checkResult=callCenterBookAndReviewPage.validateCurrentday();
		Assert.assertEquals(checkResult,false,"Current Booking is available for manager");
	}	

	//*******************************************************************************************************************************************
	//Test case:343:Call center : Verify current day booking for New and Change reservation for manager
	//Reviewed by: Aditya on 22/05/2019 Covers the Verify current day booking for Change reservation for manager
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCurrentday_Change_TCID_343() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 343:Call center : Verify current day booking for New and Change reservation for manager");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		boolean checkResult=callCenterBookAndReviewPage.validateCurrentday();
		Assert.assertEquals(checkResult,false,"Current Booking is available for manager");
	}	

	//*******************************************************************************************************************************************
	//Test case:343:Call center : Verify current day booking for New and Change reservation for manager
	//Reviewed by: Aditya on 22/05/2019 Covers the Verify current day booking for New reservation for manager
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCurrentday_New_TCID_343() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 343:Call center : Verify current day booking for New and Change reservation for manager");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateNewButton();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		boolean checkResult=callCenterBookAndReviewPage.validateCurrentday();
		Assert.assertEquals(checkResult,false,"Current Booking is available for manager");
	}	

	//*******************************************************************************************************************************************
	//Test case:2263:CallCentre:- Call Center: Verify payment/deposit details do not display while booking a party for a No-Deposit store.
	//Reviewed by: Aditya on 29/04/2019
	//Test Run: FAIL
	//*******************************************************************************************************************************************
	@Test
	public void verifyNoDepositStore_TCID_2263() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2263:CallCentre:- Call Center: Verify payment/deposit details do not display while booking a party for a No-Deposit store.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0042"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		boolean checkResult= callCenterBookAndReviewPage.validateNoDeposit();
		Assert.assertEquals(checkResult, false, "Payment options Available");
	}

	//*******************************************************************************************************************************************
	//Test case:2021:Call Center: Verify that Call Center Manager is able to Add Discretionary Rewards.
	//Test case:2022:Call Center : Discretionary Reward :- Verify using trash icon from reservation review page,reward gets remove.
	//Test case:2040:Call Center: Verify the newly configured Discretionary Reward is getting displayed on Review page
	//Reviewed by: Aditya on 28/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyAddDiscRewards_TCID_2021() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2021:Call Center: Verify that Call Center Manager is able to Add Discretionary Rewards.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		callCenterPromotionAndRewardsPage.validateNewReward(2,1,1); //Discretionary,Birthday,Call center
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu("0081","",getFutureDateInMMDDYYYY(0), getFutureDateInMMDDYYYY(30),"");
		boolean result=callCenterBookAndReviewPage.validateAddDiscRewards();
		Assert.assertTrue(result, "Disc Reward is not addded");

	}
	//*******************************************************************************************************************************************
	//Test case:2020:Call Center:- Discretionary Reward :- Verify duplicate reward should not get added in reservation review page
	//Reviewed by: Aditya on 28/05/2019
	//Test Run: FAIL
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyReviewPageDiscreward_TCID_2020() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Test case:2020:Call Center:- Discretionary Reward :- Verify duplicate reward should not get added in reservation review page");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		callCenterPromotionAndRewardsPage.validateNewReward(2,1,1); //Discretionary,Birthday,Call center
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu("0081","",getFutureDateInMMDDYYYY(0), getFutureDateInMMDDYYYY(30),"");
		callCenterBookAndReviewPage.validateAddDiscRewards();
		boolean reward=callCenterBookAndReviewPage.validateAddDiscRewards();
		Assert.assertTrue(reward, "Disc Reward is not addded");

	}

	//*******************************************************************************************************************************************
	//Test case:400:Call Center: View calender and select date when booking is available at Booth only
	//Reviewed by: Aditya on 30/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyBookingBoothOnly() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 400:Call Center: View calender and select date when booking is available at Booth only");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		boolean result=callCenterBookAndReviewPage.validateSelectChildBoothOnly();
		Assert.assertTrue(result, "Calander not showing booth slot");
	}


	//*******************************************************************************************************************************************
	//Test case:629:CallCentre:-Verify user can add more than 5 birthday star, if the booking is done through call center and all the birthday star display on Online change reservation link correctly
	//Reviewed by: Aditya on 03/07/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyConfirmationNumberGeneratedOnBooking5BirthdayKids_TCID_629() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 629:CallCentre:-Verify user can add more than 5 birthday star, if the booking is done through call center and all the birthday star display on Online change reservation link correctly");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber(storeNumber); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
		callCenterBookAndReviewPage.validatePackage("Birthday","SuperStar");
		callCenterBookAndReviewPage.validateAdditionalBirthday(5);
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		Assert.assertEquals(confirmationNumber, confNumber, "Conf Number Mismatch");
	}
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


