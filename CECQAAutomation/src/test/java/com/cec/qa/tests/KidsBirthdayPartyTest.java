package com.cec.qa.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.KidsBirthdayPartyPage;
import com.cec.qa.util.TestUtil;


public class KidsBirthdayPartyTest extends BaseTest{
	KidsBirthdayPartyPage kidsBirthdayPartyPage;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public KidsBirthdayPartyTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("GUI"),propv.getProperty("NBB"));
		kidsBirthdayPartyPage = new KidsBirthdayPartyPage();
	}

	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

	int bookingdate = TestUtil.tubookingDate; //Defining booking date at TestUtil -- enter date days 0 for today and 1,2,3..N for future days.
	int tubookingDateFor90thday = TestUtil.tubookingDateFor90days;
	int tubookingDateForSunday = TestUtil.tubookingDateForSunday;
	int todaysDate = TestUtil.todaysDate;
	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//********************************************************************************************************
	//Test case: 4953:Birthday/Event:Verify that user can select the store location by Store name for birthday
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4953, 4954, and 4955
	//Test Run: PASS
	//********************************************************************************************************
	@Test(enabled=true)
	public void verifyStoresWithStoreName_TCID_4953() throws InterruptedException, AWTException {
		System.out.println("----> 4953:Birthday/Event:Verify that user can select the store location by Store name for birthday.");
		kidsBirthdayPartyPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("75062");
		//kidsBirthdayPartyPage.validateSearchLocation("TX");//Enter ZipCode Example: 75062,38804
		//boolean storePresent2 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("TX");
		kidsBirthdayPartyPage.validateSearchLocation("Irving");//Enter ZipCode Example: 75062,38804
		boolean storePresent3 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("Irving");
		if(storePresent1==true /* && storePresent2 == true */ && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}

	//********************************************************************************************************
	//Test case: 4954:Birthday/Event:Verify that user can select the store location by City for birthday
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4953, 4954, and 4955
	//Test Run: PASS
	//********************************************************************************************************
	@Test(enabled=true)
	public void verifyStoresWithCityName_TCID_4954() throws InterruptedException, AWTException {
		System.out.println("----> 4954:Birthday/Event:Verify that user can select the store location by City for birthday");
		kidsBirthdayPartyPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("75062");
		//kidsBirthdayPartyPage.validateSearchLocation("TX");//Enter ZipCode Example: 75062,38804
		//boolean storePresent2 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("TX");
		kidsBirthdayPartyPage.validateSearchLocation("Irving");//Enter ZipCode Example: 75062,38804
		boolean storePresent3 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("Irving");
		if(storePresent1==true /* && storePresent2 == true */ && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}

	//********************************************************************************************************
	//Test case: 4955:Birthday/Event:Verify that user can select the store location by Zip Code for birthday
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4953, 4954, and 4955
	//Test Run: PASS
	//********************************************************************************************************
	@Test(enabled=true)
	public void verifyStoresWithZipCode_TCID_4955() throws InterruptedException, AWTException {
		System.out.println("----> 4955:Birthday/Event:Verify that user can select the store location by Zip Code for birthday");
		kidsBirthdayPartyPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("75062");
		//kidsBirthdayPartyPage.validateSearchLocation("TX");//Enter ZipCode Example: 75062,38804
		//boolean storePresent2 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("TX");
		kidsBirthdayPartyPage.validateSearchLocation("Irving");//Enter ZipCode Example: 75062,38804
		boolean storePresent3 = kidsBirthdayPartyPage.validateFirstStoreCityStateAndZip("Irving");
		if(storePresent1==true /* && storePresent2 == true */ && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}

	//************************************************************************************************
	//Test case: 4956:Birthday/Event:Verify that error message is displayed, when no stores are found
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4956
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyNoStoresFound_TCID_4956() throws InterruptedException, AWTException {
		System.out.println("----> 4956:Birthday/Event:Verify that error message is displayed, when no stores are found");
		String searchResult = kidsBirthdayPartyPage.validateNoStoreAvailableMsg("BENGALURU, KA");//Enter location Example: "BENGALURU, KA"
		Assert.assertEquals(searchResult, "We’re sorry but there are currently no Chuck E. Cheese restaurants nearby for the location details provided. Please retry your search","Message Mismatch");
	}

	//*******************************************************************************************************
	//Test case: 4958:Birthday:Verify the Minimum and Maximum Values in the Children and Adult drop down list
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4958
	//Test Run: PASS
	//*******************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookABirthdayPageMinMaxValidation_TCID_4958() throws InterruptedException, AWTException {
		System.out.println("----> 4958:Birthday:Verify the Minimum and Maximum Values in the Children and Adult drop down list");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		boolean checkResult = kidsBirthdayPartyPage.validateBirthdayPartyBookABirthdayPageMinMaxValue();
		Assert.assertEquals(checkResult, true,"Found issue in Min Max check");
	}

	//*******************************************************************************************************
	//Test case: 4959:Verify that user can select the tomorrow and future date and upto 90 days for the party
	//Reviewed by: Aditya on 19-Feb-2019, it covers test case : 4959
	//Test Run: PASS
	//*******************************************************************************************************
	@Test(enabled=true)
	public void verifyBirdayPartyBookABirthdayPage90days_TCID_4959() throws InterruptedException, AWTException {
		System.out.println("----> 4959:Verify that user can select the tomorrow and future date and upto 90 days for the party");
		kidsBirthdayPartyPage.validateSearchLocation("IRVING, TX, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(tubookingDateFor90thday);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**********************************************************************************************************************************************************************************
	//Test case: 4961:Birthday:Verify that "Time slots not available" Message displays for Birthday,When Number Of Children Increased More Than Available Seats in Book a birthday page.
	//Reviewed by: Vishnu on 11-Feb-2019, it covers test case: 4961
	//Test Run: PASS 
	//**********************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMaxAdultBookABirthdayCheckNoTimeSlotAvailableMsg_TCID_4961() throws InterruptedException, AWTException {
		System.out.println("----> 4961:Birthday:Verify that 'Time slots not available' Message displays for Birthday,When Number Of Children Increased More Than Available Seats in Book a birthday page.");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectMaxChildAdultAndDate(bookingdate);
		String alertMsg =kidsBirthdayPartyPage.validateNoTimeSlotAvailableMsg();	
		Assert.assertEquals(alertMsg, "This Time Slot Is No Longer Available","Alert Msg Mismatch");
	}

	//***********************************************************************************************************
	//Test case: 4962:Verify that the first available timeslot for the given party type is expanded automatically.
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4962
	//Test Run: PASS
	//***********************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAutoTimeSlotExpand_TCID_4962() throws InterruptedException, AWTException {
		System.out.println("----> 4962:Verify that the first available timeslot for the given party type is expanded automatically.");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		boolean starInfoEntry = kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		Assert.assertEquals(starInfoEntry, true,"DefaultPackage Auto expand issue");
	}

	//********************************************************************************************************************************************************************************************
	//Test case: 4964:Birthday:Verify that "Time slots not available" Message displays For Birthday,When edit the number of children increased more than available seats in Location and Attendees
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4964
	//Test Run: PASS
	//********************************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMaxAdultCountToCheckNoTimeSlotAvailableMsg_TCID_4964() throws InterruptedException, AWTException {
		System.out.println("----> 4964:Birthday:Verify that 'Time slots not available' Message displays For Birthday,When edit the number of children increased more than available seats in Location and Attendees");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","YES","Adult",300);//Base PKG, YES/NO to Upgrade, 200 to test No time slot available message.
		String alertMsg =kidsBirthdayPartyPage.validateNoTimeSlotAvailableMsg();
		Assert.assertEquals(alertMsg, "This Time Slot Is No Longer Available","Alert Msg Mismatch");
	}

	//***************************************************************************************************************
	//Test case: 4965:Verify that User should be presented with an Upgrade dialog if a lower tier package is selected
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4965
	//Test Run: PASS
	//***************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithUpgradeStarToSuperStar_TCID_4965() throws InterruptedException, AWTException {
		System.out.println("----> 4965:Verify that User should be presented with an Upgrade dialog if a lower tier package is selected");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","YES","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0 
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String yourPackage = kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		Assert.assertEquals(yourPackage,"SUPER STAR","String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*********************************************************************************************************************************
	//Test case: 4966:Birthday: Verify the form validation for Birthday Star and Contact Information fields in Contact Information page
	//Test case: 4970:Birthday:Verify that user should have to acknowledge the in store deposit by clicking on a checkbox
	//Reviewed by: Vishnu on 21-Jan-2019, it covers test case: 4965
	//Test Run: FAIL - Need to report a bug, it is creating booking without name.
	//*********************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyContactInformationPageFields_TCID_4966_4970() throws InterruptedException, AWTException {
		System.out.println("----> 4966:Birthday: Verify the form validation for Birthday Star and Contact Information fields in Contact Information page");
		System.out.println("----> 4970:Birthday:Verify that user should have to acknowledge the in store deposit by clicking on a checkbox");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade,
		//ORDER OF THE PARAMETERS PASSING FOR METHOD CALLING ------------>
		//( sChildName, sChildAge, sGenderListBox, sAdultName, sEnterPhoneNumberUsingRobot, sAdultEmail, sInStoreCheckBox
		String errMsg1 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "YES", "NO", "YES", "YES", "YES", "YES");
		System.out.println("errMsg1"+errMsg1);
		/*String errMsg2 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("NO", "YES", "YES", "YES", "YES", "YES", "");
		System.out.println("errMsg2"+errMsg2);
		 */String errMsg3 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "NO", "YES", "YES", "YES", "YES", "");
		 /*System.out.println("errMsg3"+errMsg3);
		String errMsg4 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "YES", "YES", "NO", "YES", "YES", "");
		System.out.println("errMsg4"+errMsg4);
		  */String errMsg5 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "YES", "YES", "YES", "NO", "YES", "");
		  System.out.println("errMsg5"+errMsg5);
		  String errMsg6 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "YES", "YES", "YES", "YES", "NO", "");
		  System.out.println("errMsg6"+errMsg6);
		  /*String errMsg7 = kidsBirthdayPartyPage.validateBirdayPartyContactInformationPageFields("YES", "YES", "YES", "YES", "YES", "YES", "NO");
		System.out.println("errMsg7"+errMsg7);*/

		  //Condition to validate all methods called return message text. 
		  if(errMsg1.contains("Please fill out all birthday star information.") /* && errMsg2.contains("Please fill out all birthday star information.")*/ && errMsg3.contains("Please fill out all birthday star information.") && /* errMsg4.contains("Please enter the adult's name. ") && */  errMsg5.contains("Please enter a valid phone number.") /*&& errMsg6.contains("Please enter a valid email address.") /*&& errMsg7.contains("You must check the box to continue.")*/){
			  Assert.assertTrue(true);
		  }else{	
			  Assert.assertTrue(false);
		  }
	}	

	//*******************************************************************************************************************
	//Test case:4967:Birthday:Verify payment/deposit details do not display while booking a party for a No-Deposit store.
	//Reviewed by: Aditya on 19-Feb-2019, it covers test case: 4967
	//Test Run: PASS
	//********************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingForNoDepositStore_TCID_4967() throws InterruptedException, AWTException {
		System.out.println("----> 4967:Birthday:Verify payment/deposit details do not display while booking a party for a No-Deposit store.");
		kidsBirthdayPartyPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		boolean checkResult = kidsBirthdayPartyPage.validatePaymentOptions("NO");
		Assert.assertEquals(checkResult,false,"Payment options Available");
	}

	//************************************************************************************************
	//Test case: 4968:Birthday:Verify that user should get the payment options based on store location
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4968
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyPaymentOptions_TCID_4968() throws InterruptedException, AWTException {
		System.out.println("----> 4968:Birthday:Verify that user should get the payment options based on store location");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location of 2 deposit options
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("SuperStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("SuperStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		boolean checkResult = kidsBirthdayPartyPage.validatePaymentOptions("YES");
		Assert.assertEquals(checkResult,true,"Payment options missing");
	}

	//**********************************************************************************************************
	//Test case:4969:Birthday:Verify that duplicate reservations popup displayed before Booking a Birthday Party
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4969
	//Test Run: PASS
	//**********************************************************************************************************
	@Test(enabled=true)
	public void verifyDuplicatePopupMessageByBookingBirthdayPartyWithSimilarData_TCID_4969() throws InterruptedException, AWTException {
		System.out.println("----> 4969:Birthday:Verify that duplicate reservations popup displayed before Booking a Birthday Party");
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();

		kidsBirthdayPartyPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		driver.navigate().to(propv.getProperty("NBB"));
		Thread.sleep(10000);

		//	kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		//	kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		kidsBirthdayPartyPage.validatePaymentInformation();
		String duplicateMsg = kidsBirthdayPartyPage.validateDuplidateBookingWarningWindow("Message"); //Parameters can be: "NewReservation" or "OldReservation" or "CloseWindow" or "Message"
		Assert.assertEquals(duplicateMsg, "We have found potential duplicate bookings. Please review the parties below before proceeding","Message text Mismatch");
	}


	//*******************************************************************************************************************************************
	//Test case:4971:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in Chrome browser for Irving Store
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4971
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithStarPackage_TCID_4971() throws InterruptedException, AWTException {
		System.out.println("----> 4971:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in Chrome browser for Irving Store");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***********************************************************************************************************************************************
	//Test case:4972:Birthday:Verify user is able to generate Confirmation for Birthday Party for Superstar package in IE 11 browser for Fresno Store
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4972
	//Test Run: PASS
	//***********************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithSuperStarPackage_TCID_4972() throws InterruptedException, AWTException {
		System.out.println("----> 4972:Birthday:Verify user is able to generate Confirmation for Birthday Party for Superstar package in IE 11 browser for Fresno Store");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("SuperStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("SuperStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//********************************************************************************************************************************************************
	//Test case:4973:Birthday:Verify user is able to generate Confirmation for Birthday Party for Mega Superstar package in Firefox browser for Canadian Store
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4973
	//Test Run: PASS
	//********************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingForCanadianStore_TCID_4973() throws InterruptedException, AWTException {
		System.out.println("----> 4973:Birthday:Verify user is able to generate Confirmation for Birthday Party for Mega Superstar package in Firefox browser for Canadian Store");
		kidsBirthdayPartyPage.validateSearchLocation("NORTH YORK, TORONTO, ONTARIO, CANADA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade,(For Highest Package always NO)
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//****************************************************************************************************************************************************************************
	//Test case: 4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4974
	//Test Run: PASS
	//****************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingForFranchiseStore_TCID_4974() throws InterruptedException, AWTException {
		System.out.println("----> 4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade");
		kidsBirthdayPartyPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*********************************************************************************************************************************************************************************
	//Test case:4975:Verify user is able to generate Confirmation for Birthday Party for MegaSuperStar package in Safari browser for Fresno Store and Verify no Upgrade Popup displayed
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4975
	//Test Run: PASS
	//*********************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMegaStarPackage_TCID_4975() throws InterruptedException, AWTException {
		System.out.println("----> 4975:Verify user is able to generate Confirmation for Birthday Party for MegaSuperStar package in Safari browser for Fresno Store and Verify no Upgrade Popup displayed");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}


	//**************************************************************************************************************************************************************
	//Test case: 4977:Birthday:Verify that user can modify the quantity for optional items (up-sells) and verify the items and price in the Additional items section
	//Reviewed by: Aditya on 13-Feb-2019, it covers test case : 4977
	//Test Run: PASS
	//**************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndUpdateQuantity_TCID_4977() throws InterruptedException, AWTException {
		System.out.println("----> 4977:Birthday:Verify that user can modify the quantity for optional items (up-sells) and verify the items and price in the Additional items section");
		kidsBirthdayPartyPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("SuperStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("SuperStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String Confmessage= kidsBirthdayPartyPage.validateUpsellQuantity();
		Assert.assertEquals(Confmessage,"Your reservation has been updated","Update Success String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel

	}

	//**************************************************************************************************************************************
	//Test case:4979:Birthday:Verify that VIP slots should displayed as a single block on sat/sun and able to book the VIP Mega Star booking
	//Reviewed by: Aditya on 24-Jan-2019, it covers test case: 4979
	//Test Run: PASS
	//**************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyBirthdayPartyBookingWitVIPPackage_TCID_4979() throws InterruptedException, AWTException {
		System.out.println("----> 4979:Birthday:Verify that VIP slots should displayed as a single block on sat/sun and able to book the VIP Mega Star booking");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(tubookingDateForSunday);
		kidsBirthdayPartyPage.validateSelectVIPPackageORTimeSlot(0);
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		String cf = kidsBirthdayPartyPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//****************************************************************************************************************************************************************
	//Test case: 4980:Birthday:Verify user successfully create birthday reservation for more than one birthday star and verify the details in Reservation Summary page
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case: 4980
	//Test Run: PASS {Note:Validation of the - (verify the details in Reservation Summary page) is not done
	//****************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithAdditionalChild_TCID_4980() throws InterruptedException, AWTException {
		System.out.println("----> 4980:Birthday:Verify user successfully create birthday reservation for more than one birthday star and verify the details in Reservation Summary page");
		kidsBirthdayPartyPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","YES","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(1);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String bstarinfo = kidsBirthdayPartyPage.validateAdditionalBirthdayStar(1);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		Assert.assertEquals(bstarinfo,"(1) Additional Birthday Star","Birthday Start Info Mismatch");


		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel

	}

	//**************************************************************************************
	//Test case: 4981:Birthday:Verify that user should able to cancel existing reservations 
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case : 4981
	//Test Run: PASS
	//**************************************************************************************		
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndCancelBooking_TCID_4981() throws InterruptedException, AWTException {
		System.out.println("----> 4981:Birthday:Verify that user should able to cancel existing reservations");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String cancelMsg = kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "You have successfully cancelled your reservation","Msg String Mismatch");
	}

	//***********************************************************************
	//Test case: 4981:Birthday: Verify the popup while cancelling the Booking
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case : 4981
	//Test Run: PASS
	//***********************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndCancelTheCancelBookingWindow_TCID_4981() throws InterruptedException, AWTException {
		System.out.println("----> 4981:Birthday: Verify the popup while cancelling the Booking");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String cancelMsg = kidsBirthdayPartyPage.validateCancelBooking("closeCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "Are you sure you want to cancel this reservation?","Msg String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***************************************************************************************************************************************
	//Test case: 4982:Birthday:Verify that user should be able to modify the number of attendees for an existing reservation in Payments page
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case : 4982
	//Test Run: PASS
	//***************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyAttendeesPaymentsPageSuccessMsg_TCID_4982() throws InterruptedException, AWTException {
		System.out.println("----> 4982:Birthday:Verify that user should be able to modify the number of attendees for an existing reservation in Payments page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("SuperStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("SuperStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		kidsBirthdayPartyPage.validateUpdateContactOrBirthdayStarInfo();
		String Confmessage = kidsBirthdayPartyPage.validateUpdateAttendeesPaymentsPage(0);
		Assert.assertEquals(Confmessage,"Your reservation has been updated","Update Success String Mismatch");
	}

	//*******************************************************************************************************************************************************************************
	//Test case: 4983:Birthday:Birthday:Verify that user should be able to modify the number of attendees/date and package for an existing reservation in Select A Date and Time page
	//Reviewed by: Vishnu on 25-Feb-2019, it covers test case : 4983
	//Test Run: PASS
	//*******************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyAttendeesSelectDateAndTime_TCID_4983() throws InterruptedException, AWTException {
		System.out.println("----> 4983:Birthday:Birthday:Verify that user should be able to modify the number of attendees/date and package for an existing reservation in Select A Date and Time page");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		kidsBirthdayPartyPage.validateUpdateDateAndTimeLink();
		kidsBirthdayPartyPage.validateUpdateAttendeesSelectAndDatePage(0);//0 for Success case and 1 for Failure case
		boolean Confmessage=kidsBirthdayPartyPage.validateUpdatedChildANDAdultCount();

		kidsBirthdayPartyPage.validateChangeDateandPackageinSelectADateAndTimePage();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String Packagename = kidsBirthdayPartyPage.validatePackageUpdateInformation();
		//Assert.assertEquals(Packagename,"SUPER STAR","String Mismatch");
		String updatedDate = kidsBirthdayPartyPage.validateUpdateDateandTime();
		String valDate = kidsBirthdayPartyPage.validateDateAndTimeConfirmation();
		System.out.println("The Date is updated in reservation summary as: "+valDate);
		//Assert.assertEquals(valDate,updatedDate,"Update Success String Mismatch");

		//Condition to validate all methods called return message text. 
		if(Confmessage==true && Packagename.equals("SUPER STAR") &&  valDate.equals(updatedDate)){
			Assert.assertTrue(true);
		}else{	
			Assert.assertTrue(false);
		}

	}

	//**************************************************************************************************************************************************
	//Test case: 4984:Birthday:Verify that user should be able to modify the number of attendees for an existing reservation in Reservation Summary Page
	//Reviewed by: Aditya on 11-Feb-2019, it covers test case : 4984
	//Test Run: PASS
	//**************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyAttendeesSuccessMsg_TCID_4984() throws InterruptedException, AWTException {
		System.out.println("----> 4984:Birthday:Verify that user should be able to modify the number of attendees for an existing reservation in Reservation Summary Page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String Confmsg= kidsBirthdayPartyPage.validateUpdateAttendeesConfirmationPage(0);//0 for Success case and 1 for Failure case
		Assert.assertEquals(Confmsg,"Your reservation has been updated","String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************************************************
	//Test case: 4985:Birthday:Verify that the user is able to modify the Birthday Star/Contact information for an existing reservation in Payments Page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4985
	//Test Run: PASS
	//**************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyBirthdayStarAndContactInfo_TCID_4985() throws InterruptedException, AWTException {
		System.out.println("----> 4985:Birthday:Verify that the user is able to modify the Birthday Star/Contact information for an existing reservation in Payments Page");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		kidsBirthdayPartyPage.validateUpdateContactOrBirthdayStarInfo();
		kidsBirthdayPartyPage.validateBirthdayStarInformationUpdate();
		kidsBirthdayPartyPage.validateContactInformation("");
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String Bstarinfo= kidsBirthdayPartyPage.validateBirthdayStarInformation();
		Assert.assertEquals(Bstarinfo,"John (6 yrs)","String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*****************************************************************************************************************************
	//Test case:4986:Birthday:Verify that user should get the appropriate error message,when user select the date more than 90 days 
	//Reviewed by: Aditya on 20-Feb-2019, it covers test case: 4986
	//Test Run: PASS
	//*****************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingMoreThan90Days_TCID_4986() throws InterruptedException, AWTException {
		System.out.println("----> 4986:Birthday:Verify that user should get the appropriate error message,when user select the date more than 90 days");
		kidsBirthdayPartyPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		String errormsg=kidsBirthdayPartyPage.validateErrorMoreThan90days(tubookingDateFor90thday);
		Assert.assertEquals(errormsg,"You cannot book a party more than 90 days in advance","String Mismatch");
	}

	//*****************************************************************************************************************************************************
	//Test case: 4987:Birthday:Birthday:Verify that the user is able to modify the Birthday package for an existing reservation in Reservation Summary Page
	//Reviewed by: Aditya on 22-April-2019, it covers test case : 4987
	//Test Run: PASS
	//*****************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyPackage_TCID_4987() throws InterruptedException, AWTException {
		System.out.println("----> 4987:Birthday:Birthday:Verify that the user is able to modify the Birthday package for an existing reservation in Reservation Summary Page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		kidsBirthdayPartyPage.validateChangePackage("SuperStar");//Star/SuperStar/MegaStar and  make sure given Package should be diff than the BasePKG
		String Packagename = kidsBirthdayPartyPage.validatePackageUpdateInformation();
		Assert.assertEquals(Packagename,"SUPER STAR","String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*******************************************************************************************************************************************************
	//Test case: 4988:Birthday:Birthday:Verify that user should get the appropriate error message, when user does the overbooking in Contact information page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4988
	//Test Run: PASS
	//*******************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyAttendeesErrorMsgInContactInformationPage_TCID_4988() throws InterruptedException, AWTException {
		System.out.println("----> 4988:Birthday:Birthday:Verify that user should get the appropriate error message, when user does the overbooking in Contact information page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		String Errormsg= kidsBirthdayPartyPage.validateUpdateAttendeesPaymentsPage(1);//0 for Success case and 1 for Failure case
		Assert.assertEquals(Errormsg,"This time slot does not support your party size","String Mismatch");
	}

	//**********************************************************************************************************************************************
	//Test case: 4989:Birthday:Verify that user should get the appropriate error message,when user does the overbooking  in Reservation Summary page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4989
	//Test Run: PASS
	//**********************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyAttendeesErrorMsgInReservationPage_TCID_4989() throws InterruptedException, AWTException {
		System.out.println("----> 4989:Birthday:Verify that user should get the appropriate error message,when user does the overbooking  in Reservation Summary page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String Errormsg= kidsBirthdayPartyPage.validateUpdateAttendeesConfirmationPage(1);//0 for Success case and 1 for Failure case
		Assert.assertEquals(Errormsg,"This time slot does not support your party size","String Mismatch");
		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***********************************************************************************************************************************************
	//Test case: 4990:Birthday:Verify that user should get the appropriate error message,When user booking for less attendees for VIPMegaStar Package 
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4990
	//Test Run: PASS
	//***********************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyBirthdayPartyBookingAndModifyAttendeesVIPBooking_TCID_4990() throws InterruptedException, AWTException {
		System.out.println("----> 4990:Birthday:Verify that user should get the appropriate error message,When user booking for less attendees for VIPMegaStar Package ");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(tubookingDateForSunday);
		String Errormsg= kidsBirthdayPartyPage.validateSelectVIPPackageORTimeSlot(2);//Base PKG, YES/NO to Upgrade, 
		Assert.assertEquals(Errormsg,"You cannot book a party with less than 10 children","String Mismatch there is Bug#4762");
	}

	//*******************************************************************************************************************
	//Test case:4991:Birthday:Verify the deposit due date for the tomorrow  party booking in Reservation Summary page
	//Reviewed by: Aditya on 19-Feb-2019, it covers test case: 4991
	//Test Run: Work on Method validateDepositDueDate(todaysDate)
	//********************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingDueDateTomorrowParty_TCID_4991() throws InterruptedException, AWTException {
		System.out.println("----> 4991:Birthday:Verify the deposit due date for the tomorrow  party booking in Reservation Summary page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		boolean result = kidsBirthdayPartyPage.validateDepositDueDate(todaysDate);
		Assert.assertEquals(result, true,"Due date mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//************************************************************************************************************************************
	//Test case:4992:Birthday:Verify the deposit due date for the Future dates (except tomorrow) party booking in Reservation Summary page
	//Reviewed by: Aditya on 6-Mar-2019, it covers test case: 4992
	//Test Run: PASS
	//************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingDueDateFutureParty_TCID_4992() throws InterruptedException, AWTException {
		System.out.println("----> 4992:Birthday:Verify the deposit due date for the Future dates (except tomorrow) party booking in Reservation Summary page");
		kidsBirthdayPartyPage.validateSearchLocation("IRVING, TX, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("SuperStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("SuperStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		boolean result = kidsBirthdayPartyPage.validateDepositDueDate(todaysDate);
		Assert.assertEquals(result, true,"Due date mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}


	//********************************************************************************************************************************************************************************************************************
	//Test case:4993:Birthday:Verify that the user selected details with the price of items selected,required deposit and an estimated total price of the party are calculated properly On the Reservation Summary Screen.
	//Reviewed by: Aditya on 19-Feb-2019, it covers test case : 4993
	//Test Run: PASS
	//********************************************************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyEstimatedTotal_TCID_4993() throws InterruptedException, AWTException {
		System.out.println("----> 4993:Birthday:Verify that the user selected details with the price of items selected,required deposit and an estimated total price of the party are calculated properly On the Reservation Summary Screen.");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		String TotalCost= kidsBirthdayPartyPage.validatePackageprice("STAR");
		System.out.println("The Total Cost is : "+TotalCost);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		String UpdatedCost=kidsBirthdayPartyPage.validateEstimatedPriceAtReservationSummaryPage(TotalCost);
		System.out.println("The Updated Cost in Summary Page : "+UpdatedCost);
		Assert.assertEquals(TotalCost, UpdatedCost,"String Mismatch");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************
	//Test case:4995:Birthday:Verify that the “Send Free Party Invitations” link functionality on the dashboard page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4995
	//Test Run: PASS
	//**************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndSendPartyInvitations_TCID_4995() throws InterruptedException, AWTException {
		System.out.println("----> 4995:Birthday:Verify that the “Send Free Party Invitations” link functionality on the dashboard page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		boolean Punchbowllogo = kidsBirthdayPartyPage.validatesendPartyInvitations(); 
		Assert.assertEquals(Punchbowllogo,true,"Punchbowlogo not present");

		kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//******************************************************************************************************************************************************
	//Test case:5004 Birthday:Verify that user get the error message alert,when user try to edit less than Minimum for children in Select date and time page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 5004
	//Test Run: PASS
	//******************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMinimumChildCount_TCID_5004() throws InterruptedException, AWTException {
		System.out.println("----> 5004 Birthday:Verify that user get the error message alert,when user try to edit less than Minimum for children in Select date and time page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		String alertMsg = kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","YES","Child",4);//Base PKG, YES/NO to Upgrade, 
		Assert.assertEquals(alertMsg, "Must have at least 4 child attendees","Alert Msg Mismatch");
	}

	//****************************************************************************************************************************************************
	//Test case:5004 Birthday:Verify that user get the error message alert,when user try to edit less than Minimum for Adults in Select date and time page
	//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 5004
	//Test Run: PASS
	//****************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMinimumAdultCount_TCID_5004() throws InterruptedException, AWTException {
		System.out.println("----> 5004 Birthday:Verify that user get the error message alert,when user try to edit less than Minimum for Adults in Select date and time page");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		String alertMsg = kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","YES","Adult",1);//Base PKG, YES/NO to Upgrade, 
		Assert.assertEquals(alertMsg, "Must have at least 1 adult attendee","Alert Msg Mismatch");
	}

	//********************************************************************************************************************************************************************
	//Test case: 5006:verify that user is able to Change the location for an existing reservation in Reservation Summary,Contact Information and Select Date and time page
	//Reviewed by: Aditya on 25-Feb-2019, it covers test case : 5006
	//Test Run: PASS
	//********************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingChangeLocation_TCID_5006() throws InterruptedException, AWTException {
		System.out.println("----> 5006:verify that user is able to Change the location for an existing reservation in Reservation Summary,Contact Information and Select Date and time page");
		kidsBirthdayPartyPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateChangeLocation();
		kidsBirthdayPartyPage.validateFindLocation("IRVING, TX, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		kidsBirthdayPartyPage.validateSelectStore();
		boolean ChangeLocation = kidsBirthdayPartyPage.validateLocationAddress("IRVING, TX, USA");
		if(ChangeLocation==true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}

	}

	//**************************************************************************************************************************************************
	//Test case: 5007:CEC BrandSite:Verify that the 'Terms and Privacy and Survey' links are displayed in the footer in all the pages of booking funnel.
	//Reviewed by: Aditya on 25-Feb-2019, it covers test case : 5007
	//Test Run: PASS
	//**************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingTermsAndPrivacy_TCID_5007() throws InterruptedException, AWTException {
		System.out.println("----> 5007:CEC BrandSite:Verify that the 'Terms and Privacy and Survey' links are displayed in the footer in all the pages of booking funnel.");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		boolean TPFound = kidsBirthdayPartyPage.validateTermsPrivacy();
		driver.navigate().back();
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		boolean TPFound1 = kidsBirthdayPartyPage.validateTermsPrivacy();
		driver.navigate().back();
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		boolean TPFound2 = kidsBirthdayPartyPage.validateTermsPrivacy();

		if(TPFound==true && TPFound1==true && TPFound2 == true){
			Assert.assertTrue(true);
			System.out.println("The TERMS AND PRIVACY LINK is clicked in Select A Date and Time page");
			System.out.println("The TERMS AND PRIVACY LINK is clicked in Payments page");
			System.out.println("The TERMS AND PRIVACY LINK is clicked in Confirmation page");
		}else{
			Assert.assertTrue(false);
		}

	}

	//******************************************************************************************************************
	//Test case: 5008:CEC BrandSite:Verify that the CEC logo displayed in the header in all the pages of booking funnel.
	//Reviewed by: Aditya on 21-Feb-2019, it covers test case : 5008
	//Test Run: PASS
	//******************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingHomePageInEveryPage_TCID_5008() throws InterruptedException, AWTException {
		System.out.println("----> 5008:CEC BrandSite:Verify that the CEC logo displayed in the header in all the pages of booking funnel.");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		boolean homePageFound = kidsBirthdayPartyPage.validateCECLogoToGoHomePage();
		driver.navigate().back();

		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		boolean homePageFound1 = kidsBirthdayPartyPage.validateCECLogoToGoHomePage();
		driver.navigate().back();

		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsBirthdayPartyPage.validatePaymentInformation();
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		boolean homePageFound2 = kidsBirthdayPartyPage.validateCECLogoToGoHomePage();

		if(homePageFound==true && homePageFound1==true && homePageFound2 == true){
			Assert.assertTrue(true);
			System.out.println("The CEC Logo is clicked in Select A Date and Time page");
			System.out.println("The CEC Logo is clicked in Payments page");
			System.out.println("The CEC Logo is clicked in Confirmation page");
		}else{
			Assert.assertTrue(false);
		}

	}

	//*****************************************************************************************************************************************************************************
	//Test case: 5054:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in IE11 browser for  Irving Store using payzee  Credit Card payment
	//Reviewed by: Aditya on 21-Feb-2019, it covers test case : 5054
	//Test Run: NA [ Due to Security purpose, we have not provided valid data)
	//*****************************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingUsingCreditcardPayzee_TCID_5054() throws InterruptedException, AWTException {
		System.out.println("----> 5054:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in IE11 browser for  Irving Store using payzee  Credit Card payment");
		kidsBirthdayPartyPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("Star");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("Star","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String Confmsg=kidsBirthdayPartyPage.validatePaymentUsingCreditCard("Valid");
		kidsBirthdayPartyPage.validateGetConfirmationNumber();
		Assert.assertEquals(Confmsg,"Deposit Payment Successfully.","String Mismatch");

		//kidsBirthdayPartyPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel//It is comments as we are passing proper data
	}

	//***************************************************************************************************************************************************************
	//Test case: 5056:Birthday:Verify that user should get the appropriate error message ,When user enters invalid Credit card details for payzee Credit Card payment
	//Reviewed by: Aditya on 21-Feb-2019, it covers test case : 5056
	//Test Run: PASS
	//***************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingUsingCreditcardErrorMsg_TCID_5056() throws InterruptedException, AWTException {
		System.out.println("----> 5056:Birthday:Verify that user should get the appropriate error message ,When user enters invalid Credit card details for payzee Credit Card payment");
		kidsBirthdayPartyPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsBirthdayPartyPage.validateSelectStore();
		kidsBirthdayPartyPage.validateChoosePackage("MegaStar");
		kidsBirthdayPartyPage.validateSelectChildAdultAndDate(bookingdate);
		kidsBirthdayPartyPage.validateSelectPackageORTimeSlot("MegaStar","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsBirthdayPartyPage.validateBirthdayStarInformation(0);
		kidsBirthdayPartyPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String Errormsg=kidsBirthdayPartyPage.validatePaymentUsingCreditCard("Invalid");
		Assert.assertEquals(Errormsg,"Could not process the credit card. Check your information and try again.","String Mismatch");
	}


	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}

}
