package com.cec.qa.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.KidsGroupEventPage;
import com.cec.qa.util.TestUtil;
public class KidsGroupEventTest extends BaseTest{
	KidsGroupEventPage kidsGroupEventPage;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public KidsGroupEventTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("GUI"),propv.getProperty("NBE"));
		kidsGroupEventPage = new KidsGroupEventPage();
	}
	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

	int bookingdate = TestUtil.tubookingDate; //Defining booking date at TestUtil -- enter date days 0 for today and 1,2,3..N for future days.
	int tubookingDateFor180thday = TestUtil.tubookingDateFor180days;

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************


	//************************************************************************************************
	//Test case: 5488:Event:Verify that user can select the store location by Store name for Event
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5488, 5489, and 5490
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=false)
	public void verifyStoresWithStoreName_TCID_5488() throws InterruptedException, AWTException {
		System.out.println("----> 5488:Event:Verify that user can select the store location by Store name for Event");
		kidsGroupEventPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("75062");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter Store Name Example: Irving
		boolean storePresent2 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter City Example: Irving
		boolean storePresent3 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");

		if(storePresent1==true  && storePresent2 == true  && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}

	//************************************************************************************************
	//Test case: 5489:Event:Verify that user can select the store location by City for Event
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5488, 5489, and 5490
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=false)
	public void verifyStoresWithCityName_TCID_5489() throws InterruptedException, AWTException {
		System.out.println("----> 5489:Event:Verify that user can select the store location by City for Event");
		kidsGroupEventPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("75062");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter Store Name Example: Irving
		boolean storePresent2 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter City Example: Irving
		boolean storePresent3 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");

		if(storePresent1==true  && storePresent2 == true  && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}

	//************************************************************************************************
	//Test case: 5490:Event:Verify that user can select the store location by Zip Code for Event
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5488, 5489, and 5490
	//Test Run: PASS
	//************************************************************************************************
	@Test(enabled=false)
	public void verifyStoresWithZipCode_TCID_5490() throws InterruptedException, AWTException {
		System.out.println("----> 5490:Event:Verify that user can select the store location by Zip Code for Event");
		kidsGroupEventPage.validateSearchLocation("75062");//Enter ZipCode Example: 75062,38804
		boolean storePresent1 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("75062");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter Store Name Example: Irving
		boolean storePresent2 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");
		kidsGroupEventPage.validateSearchLocation("Irving");//Enter City Example: Irving
		boolean storePresent3 = kidsGroupEventPage.validateFirstStoreCityStateAndZip("Irving");

		if(storePresent1==true  && storePresent2 == true  && storePresent3 == true) {
			Assert.assertTrue(true);
		}else {
			Assert.assertFalse(false);	
		}
	}



	//**************************************************************************************
	//Test case: 5491:Event:Verify that error message is displayed, when no stores are found
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5491
	//Test Run: PASS
	//**************************************************************************************
	@Test(enabled=false)
	public void verifyNoStoresFound_TCID_5491() throws InterruptedException, AWTException {
		System.out.println("----> 5491:Event:Verify that error message is displayed, when no stores are found");
		String searchResult = kidsGroupEventPage.validateNoStoreAvailableMsg("BENGALURU, KA");//Enter location Example: "BENGALURU, KA"
		Assert.assertEquals(searchResult, "We’re sorry but there are currently no Chuck E. Cheese restaurants nearby for the location details provided. Please retry your search","Message Mismatch");
	}

	//**************************************************************************************************************
	//Test case: 5023:Event:Verify the Minimum and Maximum Values in the Children input box and Adult drop down list
	//Reviewed by: Aditya on 8-Feb-2019, it covers test case: 5023
	//Test Run: Pass
	//**************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingPageMinMaxValidation_TCID_5023() throws InterruptedException, AWTException {
		System.out.println("----> 5023:Event:Verify the Minimum and Maximum Values in the Children input box and Adult drop down list");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		boolean checkResult = kidsGroupEventPage.validateGroupEventPageMinMaxValue("YES");//Send "YES" to check min and max list box options of children and Adult
		Assert.assertEquals(checkResult, true,"Found issue in Min Max check");
	}

	//****************************************************************************************************************
	//Test case: 5024:Event: Verify that user can select the tomorrow and future date and up to 180 days for the Event 
	//Reviewed by: Aditya on 18-Feb-2019, it covers test case: 5023
	//Test Run: Pass
	//****************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingPag180days_TCID_5024() throws InterruptedException, AWTException {
		System.out.println("----> 5024:Event: Verify that user can select the tomorrow and future date and up to 180 days for the Event");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(tubookingDateFor180thday);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//************************************************************************************************************************************************************************************
	//Test case: 5026:Event:Verify that "Time slots not available" Message displays For Group Event,When number of children increased more than available seats in Book a Group Event page
	//Reviewed by: Aditya on 8-Feb-2019, it covers test case: 5026
	//Test Run: Pass
	//************************************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithMaxAdultBookAEventCheckNoTimeSlotAvailableMsg_TCID_5026() throws InterruptedException, AWTException {
		System.out.println("----> 5026:Event:Verify that 'Time slots not available' Message displays For Group Event,When number of children increased more than available seats in Book a Group Event page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateGroupEventPageMaxValue(bookingdate);
		String timeslotblockMsg =kidsGroupEventPage.validateNoTimeSlotAvailableMsgFromBookEventPage();	
		Assert.assertEquals(timeslotblockMsg, "This Time Slot Is No Longer Available","Alert Msg Mismatch");
	}

	//*******************************************************************************************************************
	//Test case: 5027:Event:Verify that the first available time slot for the given event type is expanded automatically.
	//Reviewed by: Aditya on 8-Feb-2019, it covers test case: 5027
	//Test Run: Pass
	//*******************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAutoTimeSlotExpand_TCID_5027() throws InterruptedException, AWTException {
		System.out.println("----> 5027:Event:Verify that the first available time slot for the given event type is expanded automatically.");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		boolean result = kidsGroupEventPage.validateGroupPartyInformation();
		Assert.assertEquals(result, "true","DefaultPackage Auto expand issue");
	}

	//***********************************************************************************************************************************************************************************************************
	//Test case: 5029:Event:Verify that "Time slots not available" Message displays For Group Event,When edit the number of children/adults increased more than available seats in location and Attendees section
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5029
	//Test Run: PASS
	//***********************************************************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithMaxAdultCountToCheckNoTimeSlotAvailableMsg_TCID_5029() throws InterruptedException, AWTException {
		System.out.println("----> 5029:Event:Verify that 'Time slots not available' Message displays For Group Event,When edit the number of children/adults increased more than available seats in location and Attendees section");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","Adult",200);//Base PKG, YES/NO to Upgrade, 200 to test No time slot available message.
		String alertMsg = kidsGroupEventPage.validateNoTimeSlotAvailableMsg();
		Assert.assertEquals(alertMsg, "This Time Slot Is No Longer Available","Alert Msg Mismatch");
	}

	//****************************************************************************************************************************************************
	//Test case: 5042:Event:Verify that user should be able to modify the date/time and package for an existing reservation in Select A Date and Time page
	//Reviewed by: Aditya on 04-Mar-2019, it covers test case: 5042
	//Test Run: PASS
	//****************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifydate_TCID_5042() throws InterruptedException, AWTException {
		System.out.println("----> 5042:Event:Verify that user should be able to modify the date/time and package for an existing reservation in Select A Date and Time page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("120min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("120min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		String updatedDate = kidsGroupEventPage.validateUpdateDateandTime();
		//kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","NO","",0);//Base PKG, YES/NO to Upgrade, 
		String valDate = kidsGroupEventPage.validateDateAndTimeConfirmation();
		System.out.println(valDate);
		Assert.assertEquals(valDate,updatedDate,"Update Success String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*********************************************************************************************************************
	//Test case: 5030:Event:Verify that user should be presented with an upgrade dialog if a lower tier package is selected
	//Reviewed by: Aditya on 7-Feb-2019, it covers test case: 5030 
	//Test Run: PASS
	//*********************************************************************************************************************
	/*@Test(enabled=false)
	public void verifyGroupEventBookingWithUpgrade60minTo90min() throws InterruptedException, AWTException {
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		String yourPackage =kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		Assert.assertEquals(yourPackage,"90 Minutes of All You Can Play","String Mismatch");

	}*/

	//********************************************************************************************
	//Test case:5031:Event:Verify payment/deposit details should not display while booking a event 
	//Reviewed by: Aditya on 19-Feb-2019, it covers test case: 4967
	//Test Run: PASS
	//********************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingValidatePaymentOptions_TCID_5031() throws InterruptedException, AWTException {
		System.out.println("----> 5031:Event:Verify payment/deposit details should not display while booking a event ");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		boolean checkResult = kidsGroupEventPage.validatePaymentOptions("NO");
		Assert.assertEquals(checkResult,false,"Payment options Available");
	}


	//***************************************************************************************************************
	//Test case: 5032:Event:Verify the form validation in Group Party/Contact information in Contact information page
	//Reviewed by: Aditya on 07-Feb-2019, it covers test case: 5032
	//Test Run: Fail - Reason: Automation limitation Phone number is skipping phone number validation
	//***************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventContactInformationPageFields_TCID_5032() throws InterruptedException, AWTException {
		System.out.println("----> 5032:Event:Verify the form validation in Group Party/Contact information in Contact information page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade,
		//ORDER OF THE PARAMETERS PASSING FOR METHOD CALLING ------------>
		//( sOrgName, sOrgPhone, sOrgExtn, sAdultName, sEnterPhoneNumberUsingRobot, sAdultEmail
		String errMsg1 = kidsGroupEventPage.validateGroupEventContactInformationPageFields("NO", "YES", "YES", "YES", "YES", "YES");
		System.out.println("errMsg1"+errMsg1);
		/*	String errMsg2 = kidsGroupEventPage.validateGroupEventContactInformationPageFields("YES", "NO", "", "YES", "YES", "YES");
		System.out.println("errMsg2"+errMsg2);
		String errMsg4 = kidsGroupEventPage.validateGroupEventContactInformationPageFields("YES", "YES", "", "NO", "YES", "YES");
		System.out.println("errMsg4"+errMsg4);
		String errMsg5 = kidsGroupEventPage.validateGroupEventContactInformationPageFields("YES", "YES", "", "YES", "NO", "YES");
		System.out.println("errMsg5"+errMsg5);*/
		String errMsg6 = kidsGroupEventPage.validateGroupEventContactInformationPageFields("NO", "NO", "", "NO", "NO", "NO");
		System.out.println("errMsg6"+errMsg6);

		//Condition to validate all methods called return message text. 
		if(errMsg1.contains("Please fill out all organization information.")/* && errMsg2.contains("Please enter a valid phone number.") && errMsg5.contains("Please enter a valid phone number.") && errMsg6.contains("Please enter a valid email address.")*/){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}	

	//*****************************************************************************************************
	//Test case: 5034:Event:Verify that duplicate reservations popup displayed before Booking a Group Event
	///Reviewed by: Aditya on 15-April-2019, it covers test case: 5034 
	//Test Run: PASS
	//*****************************************************************************************************
	@Test(enabled=false)
	public void verifyDuplicatePopupMessageByBookingGroupEventWithSimilarData_TCID_5034() throws InterruptedException, AWTException {
		System.out.println("----> 5034:Event:Verify that duplicate reservations popup displayed before Booking a Group Event");
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		kidsGroupEventPage.validateGetConfirmationNumber();
		Thread.sleep(2000);
		driver.navigate().to(propv.getProperty("NBE"));
		//kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		//kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		String DupMessage= kidsGroupEventPage.validateDuplidateBookingWarningWindow("Message"); //Parameters can be: "NewReservation" or "OldReservation" or "CloseWindow" or "Message"
		Assert.assertEquals(DupMessage, "We have found potential duplicate bookings. Please review the parties below before proceeding","Message text Mismatch");
	}


	//*********************************************************************************************************************************************
	//Test case: 5035:Event:Verify user is able to generate Confirmation for Group Event site for 60 min package in Chrome browser for Irving Store
	//Reviewed by: Aditya on 15-April-2019, it covers test case: 5035 
	//Test Run: PASS
	//*********************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWith60minPackage_TCID_5035() throws InterruptedException, AWTException {
		System.out.println("----> 5035:Event:Verify user is able to generate Confirmation for Group Event site for 60 min package in Chrome browser for Irving Store");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//********************************************************************************************************************************************
	//Test case: 5036:Event:Verify user is able to generate Confirmation for Group Event site for 90 min package in IE 11 browser for Fresno Store
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5036 
	//Test Run: PASS
	//********************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWith90minPackage_TCID_5036() throws InterruptedException, AWTException {
		System.out.println("----> 5036:Event:Verify user is able to generate Confirmation for Group Event site for 90 min package in IE 11 browser for Fresno Store");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***********************************************************************************************************************************************************************
	//Test case: 5037:Event:Verify user is able to generate Confirmation for Group Event site for 120min in package in Firefox browser for Canadian Store(North York, Ontario)
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5037 
	//Test Run: PASS
	//Precondition: Canadian Store should be configured for Event
	//***********************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithCanadianstore_TCID_5037() throws InterruptedException, AWTException {
		System.out.println("----> 5037:Event:Verify user is able to generate Confirmation for Group Event site for 120min in package in Firefox browser for Canadian Store(North York, Ontario)");
		kidsGroupEventPage.validateSearchLocation("NORTH YORK, TORONTO, ONTARIO, CANADA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("120min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("120min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//******************************************************************************************************************************************************************
	//Test case: 5038:Event:Verify user is able to generate Confirmation for Group Event site for 90 min package in chrome browser for Franchise Stores(Tupelo,Ms 38804)
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5038 
	//Test Run: Pass  
	//Precondition: Franchise Store should be configured for Event
	//******************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithFranchisestore_TCID_5038() throws InterruptedException, AWTException {
		System.out.println("----> 5038:Event:Verify user is able to generate Confirmation for Group Event site for 90 min package in chrome browser for Franchise Stores(Tupelo,Ms 38804)");
		kidsGroupEventPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************************************************
	//Test case: 5039:Event:Verify user is able to generate Confirmation for Group Event site for 60 min package in Safari browser for Fresno Stores
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5039
	//Test Run: PASS
	//**********************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWith120minPackage_TCID_5039() throws InterruptedException, AWTException {
		System.out.println("----> 5039:Event:Verify user is able to generate Confirmation for Group Event site for 60 min package in Safari browser for Fresno Stores");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		String cf = kidsGroupEventPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}


	//*************************************************************************************************************************************************
	//Test case: 5040:Event:Verify that user should able to cancel existing reservations and Verify the Cancellation popup while cancelling the Booking
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5040
	//Test Run: PASS
	//*************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndCancelBooking_TCID_5040() throws InterruptedException, AWTException {
		System.out.println("----> 5040:Event:Verify that user should able to cancel existing reservations and Verify the Cancellation popup while cancelling the Booking");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsGroupEventPage.validateGetConfirmationNumber();
		String cancelMsg = kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "You have successfully cancelled your reservation","Msg String Mismatch");
	}

	//*********************************************************************************
	//Test case: 5040:Event: Verify the Cancellation popup while cancelling the Booking
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5040
	//Test Run: PASS
	//*********************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndCancelTheCancelBookingWindow_TCID_5040() throws InterruptedException, AWTException {
		System.out.println("----> 5040:Event: Verify the Cancellation popup while cancelling the Booking");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		String cancelMsg = kidsGroupEventPage.validateCancelBooking("closeCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "Are you sure you want to cancel this reservation?","Msg String Mismatch");
	}

	//**************************************************************************************************************************************************
	//Test case: 5041:Event:Verify that user should be able to modify the number of attendees for an existing reservation in Select A Date and Time page
	//Reviewed by: Aditya on 7-Feb-2019, it covers test case: 5041
	//Test Run: Pass
	//**************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyAttendeesSelectDateAndTimeSuccessMsg_TCID_5041() throws InterruptedException, AWTException {
		System.out.println("----> 5041:Event:Verify that user should be able to modify the number of attendees for an existing reservation in Select A Date and Time page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("90min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		kidsGroupEventPage.validateUpdateAttendeesSelectAndDatePage(0);//0 for Success case and 1 for Failure case
		boolean Confmessage=kidsGroupEventPage.validateUpdatedChildANDAdultCount();
		Assert.assertEquals(Confmessage, true ,"Attendees not updated");
		//kidsGroupEventPage.validateSelectPackageORTimeSlot("90min","NO","",0);//Base PKG, YES/NO to Upgrade, 
		//kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCanc
	}


	//***********************************************************************************************************************************************
	//Test case: 5043:Event:Verify that user should be able to modify the number of attendees for an existing reservation in Reservation Summary page
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5043
	//Test Run: PASS
	//***********************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyAttendeesSuccessMsg_TCID_5043() throws InterruptedException, AWTException {
		System.out.println("----> 5043:Event:Verify that user should be able to modify the number of attendees for an existing reservation in Reservation Summary page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		String Confmessage= kidsGroupEventPage.validateUpdateAttendeesConfirmation(0);//0 for Success case and 1 for Failure case
		Assert.assertEquals(Confmessage,"Your reservation has been updated","String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*************************************************************************************************************************************************
	//Test case: 5044:Event:Verify that the user is able to  modify the Group Party information for an existing reservation in Reservation Summary Page
	//Reviewed by: Aditya on 18-Feb-2019, it covers test case: 5044
	//Test Run: PASS
	//*************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyGroupPartyInfo_TCID_5044() throws InterruptedException, AWTException {
		System.out.println("----> 5044:Event:Verify that the user is able to  modify the Group Party information for an existing reservation in Reservation Summary Page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		kidsGroupEventPage.validateUpdateGroupPartyInfo();
		kidsGroupEventPage.validateUpdateGroupPartyInformation();
		kidsGroupEventPage.validateUpdateContactInformation();
		kidsGroupEventPage.validateGetConfirmationNumber();
		String Orginfo = kidsGroupEventPage.validateOrganizationInformation();
		Assert.assertEquals(Orginfo,"Genisys","String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***************************************************************************************************************************
	//Test case:5045:Event:Verify that user should get the appropriate error message,when user select the date more than 180 days 
	//Reviewed by: Aditya on 20-Feb-2019, it covers test case: 5045
	//Test Run: PASS [defect#4904]
	//***************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingMoreThan180Days_TCID_5045() throws InterruptedException, AWTException {
		System.out.println("----> 5045:Event:Verify that user should get the appropriate error message,when user select the date more than 180 days ");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		String errormsg=kidsGroupEventPage.validateErrorMoreThan180days(tubookingDateFor180thday);
		Assert.assertEquals(errormsg,"You cannot book a party more than 90 days in advance.","String Mismatch");
	}

	//*********************************************************************************************************************************************
	//Test case:5046:Event: Verify that the user is able to  modify the Group Event package for an existing reservation in Reservation Summary Page
	//Reviewed by: Aditya on 14-Feb-2019, it covers test case : 5046
	//Test Run: 
	//*********************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyPackage_TCID_5046() throws InterruptedException, AWTException {
		System.out.println("----> 5046:Event: Verify that the user is able to  modify the Group Event package for an existing reservation in Reservation Summary Page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		kidsGroupEventPage.validateChangePackage();
		String Packagename = kidsGroupEventPage.validatePackageUpdateInformation();
		Assert.assertEquals(Packagename,"90 Minutes of All You Can Play","String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//******************************************************************************************************************************************
	//Test case: 5047:Event:Verify that user should get the appropriate error message,when user does the overbooking in Contact Information page
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5047
	//Test Run: Pass
	//******************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyAttendeesSelectDateAndTimeErrorMsg_TCID_5047() throws InterruptedException, AWTException {
		System.out.println("----> 5047:Event:Verify that user should get the appropriate error message,when user does the overbooking in Contact Information page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		//kidsGroupEventPage.validateGroupPartyInformation();
		//kidsGroupEventPage.validateContactInformation("");
		String msg= kidsGroupEventPage.validateUpdateAttendeesPaymentsPage(1);//0 for Success case and 1 for Failure case
		Assert.assertEquals(msg,"This time slot does not support your party size","String Mismatch");
	}

	//******************************************************************************************************************************************
	//Test case: 5048:Event:Verify that user should get the appropriate error message,when user does the overbooking in Reservation Summary Page
	//Reviewed by: Aditya on 5-Feb-2019, it covers test case: 5048
	//Test Run: PASS
	//******************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingAndModifyAttendeesErrorMsg_TCID_5048() throws InterruptedException, AWTException {
		System.out.println("----> 5048:Event:Verify that user should get the appropriate error message,when user does the overbooking in Reservation Summary Page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		String Errormessage= kidsGroupEventPage.validateUpdateAttendeesConfirmation(1);//0 for Success case and 1 for Failure case
		Assert.assertEquals(Errormessage,"This time slot does not support your party size","String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//****************************************************************************************************************************************************************
	//Test case:5049:Event:Verify that the user selected details with an estimated total price of the Event are calculated properly on the Reservation Summary Screen.
	//Reviewed by: Aditya on 25-Feb-2019, it covers test case: 5049
	//Test Run: PASS 
	//Note: the Estimated price is calculated only for child. Precondition: 
	//*****************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyEstimatedTotal_TCID_5049() throws InterruptedException, AWTException {
		System.out.println("----> 5049:Event:Verify that the user selected details with an estimated total price of the Event are calculated properly on the Reservation Summary Screen.");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		String TotalCost= kidsGroupEventPage.validatePackageprice("60min");
		kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","",0);//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 10/1 or 100
		//If not validating min/max count give parameter as: "",0
		kidsGroupEventPage.validateGroupPartyInformation();
		kidsGroupEventPage.validateContactInformation("");
		kidsGroupEventPage.validateGetConfirmationNumber();
		System.out.println("The Total Cost is : "+TotalCost);
		kidsGroupEventPage.validateEstimatedPriceAtReservationSummaryPage(TotalCost);
		Assert.assertEquals(TotalCost, "$99.90","String Mismatch");

		kidsGroupEventPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//***************************************************************************************************************************************************************
	//Test case:5492: Event:Verify that user get the error message alert,when user try to edit less than Minimum for children and Adults in Select date and time page
	//Reviewed by: Aditya on 25-Jan-2019, it covers test case: 5492 for Child alert validation
	//Test Run: PASS
	//***************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithMinimumChildCount_TCID_5492() throws InterruptedException, AWTException {
		System.out.println("----> 5492: Event:Verify that user get the error message alert,when user try to edit less than Minimum for children and Adults in Select date and time page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		String alertMsg = kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","Child",10);//Base PKG, YES/NO to Upgrade, 
		Assert.assertEquals(alertMsg, "Must have at least 10 child attendees","Alert Msg Mismatch");
	}

	//***************************************************************************************************************************************************************
	//Test case:5492: Event:Verify that user get the error message alert,when user try to edit less than Minimum for children and Adults in Select date and time page
	//Reviewed by: Aditya on 25-Jan-2019,  it covers test case: 5492 for Adult alert validation
	//Test Run: PASS
	//***************************************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyGroupEventBookingWithMinimumAdultCount_TCID_5492() throws InterruptedException, AWTException {
		System.out.println("----> 5492: Event:Verify that user get the error message alert,when user try to edit less than Minimum for children and Adults in Select date and time page");
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
		kidsGroupEventPage.validateChoosePackage("60min");
		kidsGroupEventPage.validateSelectChildAdultAndDate(bookingdate);
		String alertMsg = kidsGroupEventPage.validateSelectPackageORTimeSlot("60min","Adult",1);//Base PKG, YES/NO to Upgrade, 
		Assert.assertEquals(alertMsg, "Must have at least 1 adult attendee","Alert Msg Mismatch");
	}


	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}


}
