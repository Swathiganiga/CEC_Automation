package com.cec.qa.tests;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.KidsOrganizationEventOldPage;
import com.cec.qa.util.TestUtil;


public class KidsOrganizationEventOldTest extends BaseTest{
	KidsOrganizationEventOldPage kidsOrganizationEventOldPage;
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public KidsOrganizationEventOldTest() {
		super();
	}
	//************************************************************************************************
	//*********************Variables - Initialization*************************************************
	//************************************************************************************************
	public int eventDate = TestUtil.tuOldBookingWeekDayDate;
	String storeNumber = TestUtil.tuOldBookingStoreNumber; //StoreNumber assignment from TestUtil

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("GUI"),propv.getProperty("OBE"));
		kidsOrganizationEventOldPage = new KidsOrganizationEventOldPage();
	}
	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:317:Org site : Verify user is able to generate Confirmation for Organizational site on Browser Chrome
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOrganizationEventBookingWith60minPackage_TCID_317() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 317:Org site : Verify user is able to generate Confirmation for Organizational site on Browser Chrome");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsOrganizationEventOldPage.validateReservationSummary();
		String confNumber = kidsOrganizationEventOldPage.validateConfirmationNumber();
		int confNumberLength = confNumber.length();
		if(confNumberLength==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:319:Org site : Verify user is able to generate Confirmation for Organizational site on Browser Mozilla Firefox
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOrganizationEventBookingWith90minPackage_TCID_319() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 319:Org site : Verify user is able to generate Confirmation for Organizational site on Browser Mozilla Firefox");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("90min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsOrganizationEventOldPage.validateReservationSummary();
		String confNumber = kidsOrganizationEventOldPage.validateConfirmationNumber();
		int confNumberLength = confNumber.length();
		if(confNumberLength==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:318:Org site : Verify user is able to generate Confirmation for Organizational site on Browser IE
	//Test case:320:Org site : Verify user is able to generate Confirmation for Organizational site on Safari Desktop browser
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOrganizationEventBookingWith120minPackage_TCID_318() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 318:Org site : Verify user is able to generate Confirmation for Organizational site on Browser IE");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("120min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsOrganizationEventOldPage.validateReservationSummary();
		String confNumber = kidsOrganizationEventOldPage.validateConfirmationNumber();
		int confNumberLength = confNumber.length();
		if(confNumberLength==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:4:Event:Verify user is able to find the Duplicate popup for Similar data in Contact information Page
	//Reviewed by: Aditya on 9-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOrganizationEventBookingWithDuplicates() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 4:Event:Verify user is able to find the Duplicate popup for Similar data in Contact information Page");
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "06:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade,  
		kidsOrganizationEventOldPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		kidsOrganizationEventOldPage.validateReservationSummary();
		kidsOrganizationEventOldPage.validateConfirmationNumber();
		kidsOrganizationEventOldPage.validateSelectStore("0845");
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "05:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		boolean duplicateWindowFound =  kidsOrganizationEventOldPage.validateDuplidateBookingWarningWindow();
		Assert.assertTrue(duplicateWindowFound, "Duplicate window not Found");
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify user is able to verify the Estimated total amount for booking
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOrganizationEventBookingWithEstimatedTotal() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify user is able to verify the Estimated total amount for booking");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		String totalCost= kidsOrganizationEventOldPage.validatePackagePrice("60min");
		System.out.println("The Total Cost is : "+totalCost);
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String totalAmountFound =kidsOrganizationEventOldPage.validateEstimatedPriceAtReservationSummaryPage(totalCost);
		Assert.assertEquals(totalCost, totalAmountFound,"Found Issue: Amount Mismatch");
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify the Form validation in Event Details Page
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyEventDetailsFieldValidation() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify the Form validation in Event Details Page");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		String errMsg1 = kidsOrganizationEventOldPage.validateEventBookingMandatoryFields("NO","NO");
		System.out.println("errMsg1:"+errMsg1);
		String errMsg2 = kidsOrganizationEventOldPage.validateEventBookingMandatoryFields("YES","NO");
		System.out.println("errMsg2:"+errMsg2);
		if(errMsg1.contains("Children required.") && errMsg2.contains("Adults required.")){
			Assert.assertTrue(true);
		}else{	
			Assert.assertTrue(false);
		}
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify the Minimum Attendees error message in Event Details Page
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyEventDetailsMinChildAdult() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify the Minimum Attendees error message in Event Details Page");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		String errMsg1 = kidsOrganizationEventOldPage.validateEventBookingMinChildAdult("MIN","YES");
		System.out.println("errMsg3:"+errMsg1);
		String errMsg2 = kidsOrganizationEventOldPage.validateEventBookingMinChildAdult("YES","MIN");
		System.out.println("errMsg4:"+errMsg2);

		if(errMsg1.contains("Minimum 6 children required.") && errMsg2.contains("Minimum 1 guest required.")){
			Assert.assertTrue(true);
		}else{	
			Assert.assertTrue(false,"Found Issue: Error message text mismatch");
		}
	}
	//*******************************************************************************************************************************************
	//Test case:356:Event:Org  : Verify overbooking pop-up message displays for Organizational site when number of children is increased more than the available seats.
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyOverBookingErrorMsgEvent_TCID_356() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 356:Event:Org  : Verify overbooking pop-up message displays for Organizational site when number of children is increased more than the available seats.");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "11:00 AM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		String overBookErrorMsg = kidsOrganizationEventOldPage.validateOverBookErrorMessge("max");
		Assert.assertEquals(overBookErrorMsg, "Due to the increase of children/adults the time you originally selected is no longer available. To move forward with the same time slot, reduce the children/adults?","Error message is wrong");
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify that user is able to Modify the details of Existing Reservation
	//Reviewed by: Aditya on 29-03-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void validateModifyReservationDetails() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify that user is able to Modify the details of Existing Reservation");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsOrganizationEventOldPage.validateReservationSummary();
		kidsOrganizationEventOldPage.validateConfirmationNumber();
		kidsOrganizationEventOldPage.validateModifyReservation();
		kidsOrganizationEventOldPage.validateUpdateEventSize();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "11:00 AM");
		kidsOrganizationEventOldPage.validateSelectPackage("90min");//Base PKG, YES/NO to Upgrade,  
		kidsOrganizationEventOldPage.validateContactInformationClear();
		boolean reservationUpdateResult =kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		Assert.assertTrue(reservationUpdateResult,"Found Issue: in reservation Update");
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify that user is able to click on header to navigate to respective pages
	//Reviewed by: Aditya on 03-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void verifyEventBookingWithHeaderLink() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify that user is able to click on header to navigate to respective pages");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 
		String header = kidsOrganizationEventOldPage.validateHeaderLink();
		Assert.assertEquals(header, "Who Is Coming To The Event?","Header Text is wrong");
	}
	//*******************************************************************************************************************************************
	//Test case:Event:Verify that user is able to Modify the details of Existing Reservation from Cart
	//Reviewed by: Aditya on 04-04-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void validateModifyReservationDetailsFromCart() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Event:Verify that user is able to Modify the details of Existing Reservation from Cart");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "02:00 PM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");//Base PKG, YES/NO to Upgrade, 	
		kidsOrganizationEventOldPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		kidsOrganizationEventOldPage.validateReservationSummary();
		kidsOrganizationEventOldPage.validateConfirmationNumber();
		kidsOrganizationEventOldPage.validateModifyReservation();
		boolean editPartySize =kidsOrganizationEventOldPage.validateEditPartySizeFromCart();
		Assert.assertTrue(editPartySize);
	}
	//*******************************************************************************************************************************************
	//Test case 6694 :Old booking funnel: Verify that Organization type dropdown list displayed in Contact information page
	//Created by: Monalisa on 05-06-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true)
	public void validateOrganizationTypeDropdownListInContactInfoPage_TCID_6694() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 6694 :Old booking funnel: Verify that Organization type dropdown list displayed in Contact information page");
		kidsOrganizationEventOldPage.validateSelectStore(storeNumber);
		kidsOrganizationEventOldPage.validateSelectChildAdult();
		kidsOrganizationEventOldPage.validateSelectEventDate(eventDate, "11:00 AM");
		kidsOrganizationEventOldPage.validateSelectPackage("60min");
		kidsOrganizationEventOldPage.validateOrganizationTypeDropdownList();
	}
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit(); 
	} 
}