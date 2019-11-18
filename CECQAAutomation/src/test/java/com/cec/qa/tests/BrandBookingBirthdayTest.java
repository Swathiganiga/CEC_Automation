package com.cec.qa.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.BrandBookingBirthdayPage;
import com.cec.qa.util.TestUtil;


public class BrandBookingBirthdayTest extends BaseTest{
	BrandBookingBirthdayPage brandBookingBirthdayPage;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public BrandBookingBirthdayTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("GUI"),propv.getProperty("NBB"));
		brandBookingBirthdayPage = new BrandBookingBirthdayPage();
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


	//*******************************************************************************************************************************************
	//Test case:4972:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in IE 11 browser for Fresno Store
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4972
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithStarPackage_TCID_4972() throws InterruptedException, AWTException {
		System.out.println("----> 4971:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in Chrome browser for Irving Store");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*******************************************************************************************************************************************
	//Test case:4973:Birthday:Verify user is able to generate Confirmation for Birthday Party for Superstar package in Firefox browser for Canadian Store
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4973
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithSuperStarPackage_TCID_4973() throws InterruptedException, AWTException {
		System.out.println("----> 4972:Verify user is able to generate Confirmation for Birthday Party for SuperStar package in IE 11 browser for Fresno Store");
		brandBookingBirthdayPage.validateSearchLocation("North York, Ontario");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*******************************************************************************************************************************************
	//Test case:4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for Mega Superstar package in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4974
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithMegaSuperStarPackage_TCID_4974() throws InterruptedException, AWTException {
		System.out.println("----> 4973:Verify user is able to generate Confirmation for Birthday Party for MegaSuperStar package in Firefox browser for Canadian Store(North York, Ontario)");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("MegaStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("MegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*******************************************************************************************************************************************
	//Test case:4971:Birthday:Verify user is able to generate Confirmation for Birthday Party for Ultimate Superstar package in Chrome browser for Irving Store
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4971
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithSuperStarPackage_TCID_4974() throws InterruptedException, AWTException {
		System.out.println("----> 4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for SuperStar package  in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("MegaStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("UltimateMegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//*******************************************************************************************************************************************
		//Test case:5:Birthday:Verify user is able to generate Confirmation for Birthday Party for VIP Megastar package 
		//Reviewed by: Aditya on 08-July-2019, it covers test case: 4971
		//Test Run: Fail
		//*******************************************************************************************************************************************
		@Test(enabled=true)
		public void verifyBirthdayPartyBookingWithVIPMegaStarPackage_TCID_4974() throws InterruptedException, AWTException {
			System.out.println("----> 4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for SuperStar package  in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade");
			brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
			//If Test case is not location specific enter blank as: "" 
			brandBookingBirthdayPage.validateSelectStore();
			brandBookingBirthdayPage.validateChoosePackage("MegaStar");
			brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
			brandBookingBirthdayPage.validateSelectPackage("VIPMegaStar","NO");//Base PKG, YES/NO to Upgrade, 
			//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
			//If not validating min/max count give parameter as: "",0
			brandBookingBirthdayPage.validateBirthdayStarInformation(0);
			brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
			brandBookingBirthdayPage.validatePaymentInformation();
			String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
			if(cf.length()==14){
				Assert.assertEquals(true, true);
			}else{
				Assert.assertEquals(true, false,"Confirmation number not found as expected");
			}
			brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
		}
	
	
	//***************************************************************************************************************
	//Test case: 4965:Birthday:Verify that User should be presented with an Upgrade dialog if a lower tier package is selected
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4965
	//Test Run: PASS
	//***************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithUpgradeStarToSuperStar_TCID_4965() throws InterruptedException, AWTException {
		System.out.println("----> 4965:Verify that User should be presented with an Upgrade dialog if a lower tier package is selected");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","YES");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0 
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String yourPackage = brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		Assert.assertEquals(yourPackage,"SUPER STAR","String Mismatch");

		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**********************************************************************************************************
	//Test case:4969:Birthday:Verify that duplicate reservations popup displayed before Booking a Birthday Party
	//Reviewed by: Aditya on 19-Sep-2019, it covers test case: 4969
	//Test Run: PASS
	//**********************************************************************************************************
	@Test(enabled=true)
	public void verifyDuplicatePopupMessageByBookingBirthdayPartyWithSimilarData_TCID_4969() throws InterruptedException, AWTException {
		System.out.println("----> 4969:Birthday:Verify that duplicate reservations popup displayed before Booking a Birthday Party");
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();

		brandBookingBirthdayPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","YES");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		driver.navigate().to(propv.getProperty("NBB"));
		Thread.sleep(10000);

		//	brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		//	brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		brandBookingBirthdayPage.validatePaymentInformation();
		String duplicateMsg = brandBookingBirthdayPage.validateDuplidateBookingWarningWindow("Message"); //Parameters can be: "NewReservation" or "OldReservation" or "CloseWindow" or "Message"
		Assert.assertEquals(duplicateMsg, "We have found potential duplicate bookings. Please review the parties below before proceeding","Message text Mismatch");
	}


	//****************************************************************************************************************************************************************
	//Test case: 4980:Birthday:Verify user successfully create birthday reservation for more than one birthday star and verify the details in Reservation Summary page
	//Reviewed by: Aditya on 15-July-2019
	//Test Run: PASS {Note:Validation of the - (verify the details in Reservation Summary page) is not done
	//****************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingWithAdditionalChild_TCID_4980() throws InterruptedException, AWTException {
		System.out.println("----> 4974:Birthday:Verify user is able to generate Confirmation for Birthday Party for SuperStar package  in IE 11 browser Franchise Stores(Tupelo,Ms 38804) with No Upgrade");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("MegaStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("MegaStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(1);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************************************************************
	//Test case: 9:Birthday:Verify that user can modify the quantity for optional items (up-sells) and verify the items and price in the Additional items section
	//Reviewed by: Aditya on 15-July-2019, it covers test case : 4977
	//Test Run: PASS
	//**************************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndUpdateQuantity_TCID_4977() throws InterruptedException, AWTException {
		System.out.println("----> 4977:Birthday:Verify that user can modify the quantity for optional items (up-sells) and verify the items and price in the Additional items section");
		brandBookingBirthdayPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);// enter 0 for no additional birthday start, enter 1 or 2 if there is more than one birthday star.
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		String Confmessage= brandBookingBirthdayPage.validateUpsellQuantity();
		Assert.assertEquals(Confmessage,"Your reservation has been updated","Update Success String Mismatch");
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel

	}


	//**************************************************************************************
	//Test case: 4981:Birthday:Birthday:Verify that user should able to cancel existing reservations and Verify the popup while cancelling the Booking 
	//Reviewed by: Aditya on 15-July-2019, it covers test case : 4981
	//Test Run: PASS
	//**************************************************************************************		
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndCancelBooking_TCID_4981() throws InterruptedException, AWTException {
		System.out.println("----> 4981:Birthday:Verify that user should able to cancel existing reservations");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("MegaStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		String cancelMsg = brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "You have successfully cancelled your reservation","Msg String Mismatch");
	}

	//***********************************************************************
	//Test case: 4981:Birthday:Birthday:Verify that user should able to cancel existing reservations and Verify the popup while cancelling the Booking 
	//Reviewed by: Aditya on 15-July-2019, it covers test case : 4981
	//Test Run: PASS
	//***********************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndCancelTheCancelBookingWindow_TCID_4981() throws InterruptedException, AWTException {
		System.out.println("----> 4981:Birthday: Verify the popup while cancelling the Booking");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("MegaStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		String cancelMsg = brandBookingBirthdayPage.validateCancelBooking("closeCancel"); // Accepts String: closeCancel or confirmCancel
		Assert.assertEquals(cancelMsg, "Are you sure you want to cancel this reservation?","Msg String Mismatch");

		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************************************************
	//Test case: 4985:Birthday:Verify that the user is able to modify the Birthday Star information and Contact information for an existing reservation in Payments Page
	//Reviewed by: Aditya on 15-July-2019, it covers test case : 4985
	//Test Run: PASS
	//**************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyBirthdayStarAndContactInfo_TCID_4985() throws InterruptedException, AWTException {
		System.out.println("----> 4985:Birthday:Verify that the user is able to modify the Birthday Star/Contact information for an existing reservation in Payments Page");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");;
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		brandBookingBirthdayPage.validateUpdateContactOrBirthdayStarInfo();
		brandBookingBirthdayPage.validateBirthdayStarInformationUpdate();
		brandBookingBirthdayPage.validateContactInformation("");
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		String Bstarinfo= brandBookingBirthdayPage.validateBirthdayStarInformation();
		Assert.assertEquals(Bstarinfo,"John (6 yrs)","String Mismatch");

		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}

	//**************************************************************************************************************************************************
	//Test case:13 :Birthday:Verify that the user is able to modify the Date/time information for an existing reservation in Reservation summary Page
	//Reviewed by: Aditya on 15-July-2019, it covers test case : 4985
	//Test Run: PASS
	//**************************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyBirthdayPartyBookingAndModifyPartyInformationTCID_() throws InterruptedException, AWTException {
		System.out.println("----> 4985:Birthday:Verify that the user is able to modify the Birthday Star/Contact information for an existing reservation in Payments Page");
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");;
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate/Bookings if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber();
		brandBookingBirthdayPage.validateEditPartyInformationLink();
		brandBookingBirthdayPage.validateUpdateDateandTime("success");
		//Assert.assertTrue(msg, "Date not modified");

		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	}
	
	//**************************************************************************************************************************************************
		//Test case:14 :Birthday:Verify the error while modify the Date/time information for an existing reservation in Payments Page
		//Reviewed by: Aditya on 12-Feb-2019, it covers test case : 4985
		//Test Run: PASS
		//**************************************************************************************************************************************************
		@Test(enabled=true)
		public void verifyErrorMsgForModifyPartyInformationTCID_() throws InterruptedException, AWTException {
			System.out.println("----> 4985:Birthday:Verify that the user is able to modify the Birthday Star/Contact information for an existing reservation in Payments Page");
			brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
			//If Test case is not location specific enter blank as: "" 
			brandBookingBirthdayPage.validateSelectStore();
			brandBookingBirthdayPage.validateChoosePackage("SuperStar");
			brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");;
			brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
			//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
			//If not validating min/max count give parameter as: "",0
					brandBookingBirthdayPage.validateEditPartyInformationLink();
			String confMsg= brandBookingBirthdayPage.validateUpdateDateandTime("noTimeslot");
			Assert.assertEquals(confMsg,"","String Mismatch");
		}
	
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
/*	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	}*/

}