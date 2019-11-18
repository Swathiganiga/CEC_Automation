package com.cec.qa.stepdefinations;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.BrandBookingBirthdayPage;
import com.cec.qa.pages.KidsGroupEventPage;
import com.cec.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KidsEventStepDefinitions extends BaseTest {
	
	KidsGroupEventPage kidsGroupEventPage=new KidsGroupEventPage();
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;
	boolean partyLink=false;
  private static boolean flag=false;
  String kidCount =null;
	String adultsCount=null;
	double packagePrice;
	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

		int bookingdate = TestUtil.tubookingDate; //Defining booking date at TestUtil -- enter date days 0 for today and 1,2,3..N for future days.
		int tubookingDateFor90thday = TestUtil.tubookingDateFor90days;
		int tubookingDateForSunday = TestUtil.tubookingDateForSunday;
		int todaysDate = TestUtil.todaysDate;
		boolean errMsg=false;
		public KidsEventStepDefinitions() {
			super();
		}
		
	@Given("^User enter event location$")
	public void user_enter_event_location() throws Throwable {
		
		kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		kidsGroupEventPage.validateSelectStore();
	
		
	}

	@When("^User select (\\d+)min package$")
	public void user_select_min_package(int arg1) throws Throwable {
		kidsGroupEventPage.validateChoosePackage("90min");
	}

	
	@Then("^Minimum children \"([^\"]*)\" and maximum children \"([^\"]*)\" should be available in dropdown select$")
	public void minimum_children_and_maximum_children_should_be_available_in_dropdown_select(int arg1, int arg2) throws Throwable {
		boolean checkResult = kidsGroupEventPage.validateMinMaxChildren(arg1, arg2);
		Assert.assertEquals(checkResult, true,"Found issue in Min Max check");
	}

	@Then("^Minimum adult \"([^\"]*)\" and maximum adult \"([^\"]*)\" should be available in dropdown select$")
	public void minimum_adult_and_maximum_adult_should_be_available_in_dropdown_select(int arg1, int arg2) throws Throwable {
		boolean checkResult2 = kidsGroupEventPage.validateMinMaxAdult(arg1, arg2);
		Assert.assertEquals(checkResult2, true,"Found issue in Min Max check");
	}

	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////SCENARIO 2////////////////////////////////////////////////////////////////////////////////////


@Then("^User enter children number \"([^\"]*)\" more than available seats in store$")
public void user_enter_children_number_more_than_available_seats_in_store(String arg1) throws Throwable {
	kidsGroupEventPage.validateChildrenAdultDateEvent_BDD(arg1,"100");
}

@Then("^\"([^\"]*)\" Message displays For Group Event$")
public void message_displays_For_Group_Event(String arg1) throws Throwable {
 boolean timeslotblockMsg = kidsGroupEventPage.validateNoTimeSlotAvailableMsgs();	
	Assert.assertEquals(timeslotblockMsg,true,"no alert found");
}

///////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////SCENARIO 3///////////////////////////////////////
@Given("^User select package$")
public void user_select_package() throws Throwable {
	kidsGroupEventPage.validateChoosePackage("90min");
}

@Given("^User enter number of children, adult attending including party date and time$")
public void user_enter_number_of_children_adult_attending_including_party_date_and_time() throws Throwable {
	kidsGroupEventPage.validateChildrenAdultDateEvent("7","8");
	kidsGroupEventPage.selectPackage("60min");
}

@Then("^payment/deposit details should not display while booking a event$")
public void payment_deposit_details_should_not_display_while_booking_a_event() throws Throwable {
	boolean paymentOption = kidsGroupEventPage.validateNoPayment("NO");
	Assert.assertEquals(paymentOption, false,"Payment option present");
}


/////////////////////////////////////////////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////SCENARIO 4///////////////////
@Given("^User is on conatact page$")
public void user_is_on_conatact_page() throws Throwable {
	if(flag==false) {
        flag=true;
	kidsGroupEventPage=new KidsGroupEventPage();
	kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
	//If Test case is not location specific enter blank as: "" 
	kidsGroupEventPage.validateSelectStore();
	kidsGroupEventPage.validateChoosePackage("60min");
	kidsGroupEventPage.validateChildrenAdultDateEvent("7","8");
	kidsGroupEventPage.selectPackage("60min");
}
}
@When("^User enter \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" by keeping any one field as blank$")
public void user_enter_by_keeping_any_one_field_as_blank(String arg1, String arg2, String arg3, String arg4, String arg5, String arg6) throws Throwable {
	kidsGroupEventPage=new KidsGroupEventPage();
	errMsg = kidsGroupEventPage.validateGroupEventContactInformationPageFields_BDD(arg1, arg2, arg3, arg4, arg5, arg6);
}

@Then("^Error message should be displayed$")
public void error_message_should_be_displayed() throws Throwable {
	try {
	Assert.assertEquals(errMsg, true,"No alert danger is present");
	}
	finally {
		 driver.navigate().refresh();
	 }
}

////////////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////////SCENARIO 5/////////////////////////////////////////////////////
@When("^User select (\\d+)minutes package$")
public void user_select_minutes_package(int arg1) throws Throwable {
	kidsGroupEventPage.validateChoosePackage("60min");
}
@When("^User enter organisation and contact details$")
public void user_enter_organisation_and_contact_details() throws Throwable {
	kidsGroupEventPage.validateGroupPartyInformation_BDD();
	kidsGroupEventPage.validateContactInformation_BDD("");//Checking Duplicate if YES? enter "YES", if NO? enter ""
	
}

@Then("^confirmation number for group event should be generated$")
public void confirmation_number_for_group_event_should_be_generated() throws Throwable {
	String cf = kidsGroupEventPage.validateGetConfirmationNumber();
	System.out.println("cf"+cf);
	if(cf.length()==14){
		System.out.println("1");
		Assert.assertEquals(true, true);
	}else{
		System.out.println("2");
		Assert.assertEquals(true, false,"Confirmation number not found as expected");
	}

	//kidsGroupEventPage.validateCancelBooking("confirmCancel");
}

////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////SCENARIO 6/////////////////////////////////////////////////////////
@Then("^Confirmation number is generated$")
public void confirmation_number_is_generated() throws Throwable {
	kidsGroupEventPage.validateGetConfirmationNumber();
}

@When("^User enter organisation info and contact details$")
public void user_enter_organisation_info_and_contact_details() throws Throwable {
	gcontactName = getSaltString();
	gcontactPhone = getSaltNumber();
	gcontactEmail = getSaltEmail();
	kidsGroupEventPage.validateGroupPartyInformation_BDD();
	kidsGroupEventPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail);//Checking Duplicate if YES? enter "YES", if NO? enter ""
	
}

@When("^User book an event with same contact details$")
public void user_book_an_event_with_same_contact_details() throws Throwable {
	Thread.sleep(2000);
	driver.navigate().to(propv.getProperty("NBE"));
	kidsGroupEventPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
	//If Test case is not location specific enter blank as: "" 
	kidsGroupEventPage.validateSelectStore();
	kidsGroupEventPage.validateChoosePackage("60min");
	kidsGroupEventPage.validateChildrenAdultDateEvent("7","8");
	kidsGroupEventPage.selectPackage("60min");
	kidsGroupEventPage.validateGroupPartyInformation_BDD();
	kidsGroupEventPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail);
}

@Then("^Duplicate popup should be appear$")
public void duplicate_popup_should_be_appear() throws Throwable {
	String DupMessage= kidsGroupEventPage.validateDuplidateBookingWarningWindow("Message"); //Parameters can be: "NewReservation" or "OldReservation" or "CloseWindow" or "Message"
	Assert.assertEquals(DupMessage, "We have found potential duplicate bookings. Please review the parties below before proceeding","Message text Mismatch");
	 kidsGroupEventPage.validateDuplidateBookingWarningWindow("NewReservation");
	 kidsGroupEventPage.validateGetConfirmationNumber();
	 kidsGroupEventPage.validateCancelBooking("confirmCancel");
	 

}
//////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////////////Scenario 7/////////////////////////////////////////////
@When("^User edits the number of children increased more than available seats in location and Attendees section$")
public void user_edits_the_number_of_children_increased_more_than_available_seats_in_location_and_Attendees_section() throws Throwable {
	kidsGroupEventPage.editNumOfChildrenInformationEvent("188");
}


///////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////////////////SCENARIO 8////////////////////////////////////////////////////////
@Given("^User select \"([^\"]*)\"$")
public void user_select(String arg1) throws Throwable {
	kidsGroupEventPage.validateChoosePackage(arg1);
}

@Given("^User enter number of \"([^\"]*)\" \"([^\"]*)\" attending including party date and time$")
public void user_enter_number_of_attending_including_party_date_and_time(String kids, String adults) throws Throwable {
      kidCount = kids;
	 adultsCount = adults;
	kidsGroupEventPage.validateChildrenAdultDateEvent(kids,adults);
}

@Given("^User select \"([^\"]*)\" and verify price$")
public void user_select_and_verify_price(String arg1) throws Throwable {
	 packagePrice = kidsGroupEventPage.validateChoosePackageAndGetPriceEvent_BDD(arg1);
	 kidsGroupEventPage.selectPackage(arg1);
}

@Then("^Estimated total price of the Event are calculated properly on the Reservation Summary Screen$")
public void estimated_total_price_of_the_Event_are_calculated_properly_on_the_Reservation_Summary_Screen() throws Throwable {
	 int kidCounts = Integer.parseInt(kidCount);
	 int adultsCounts = Integer.parseInt(adultsCount);
	
	double calculatedAmt = kidsGroupEventPage.estimatedTotalWithUpsellEvent_BDD(kidCounts, adultsCounts, packagePrice);
	double estimatedValue = kidsGroupEventPage.estimatedTotalEvent();
	Assert.assertEquals(calculatedAmt,estimatedValue,"Total mismatch");
	kidsGroupEventPage.validateCancelBooking("confirmCancel");
}
///////////////////////////////////////////////////////////////////////////////////////////////////////////
////////////////////////SCENARIO 9//////////////////////////////////////////////////////////////////////////

@When("^user does the overbooking in Contact Information page$")
public void user_does_the_overbooking_in_Contact_Information_page() throws Throwable {
	kidsGroupEventPage.overbookingInEvent();
}


///////////////////////////////////////////////////////////////////////////////////////////////////////////////////
///////////////////////////scenario 10////////////////////////////////////////////////////////////////////////

@When("^User does the overbooking in Reservation Summary Page$")
public void user_does_the_overbooking_in_Reservation_Summary_Page() throws Throwable {
	kidsGroupEventPage.overbookingInEvent();
}

@Then("^Appropriate error message should displayed$")
public void appropriate_error_message_should_displayed() throws Throwable {
	 boolean timeslotblockMsg = kidsGroupEventPage.validateNoTimeSlotAvailableMsgs();	
		Assert.assertEquals(timeslotblockMsg,true,"no alert found");
}

///////////////////////////////////////////////////////////////////////////////////////////////
//////////////////Scenario 11///////////////////////////////////////////

@Then("^Confirmation number is generated for booking$")
public void confirmation_number_is_generated_for_booking() throws Throwable{
	String cf = kidsGroupEventPage.validateGetConfirmationNumber();
	System.out.println("cf"+cf);
	if(cf.length()==14){
		System.out.println("1");
		Assert.assertEquals(true, true);
	}else{
		System.out.println("2");
		Assert.assertEquals(true, false,"Confirmation number not found as expected");
	}
}
@When("^User clicks \"([^\"]*)\" link$")
public void user_clicks_link(String arg1) throws Throwable {
	partyLink = kidsGroupEventPage.sendEventPartyInvitation();



	
}

@Then("^It should directed to dashboard page$")
public void it_should_directed_to_dashboard_page() throws Throwable {
	System.out.println("partyLink"+partyLink);
	Assert.assertEquals(true, partyLink,"new party invitation tab not opened");
	kidsGroupEventPage.validateCancelBooking("confirmCancel");
}
//////////////////////////////////////////////////////////////////
//////////////////SCENARIO 12///////////////////////////////////////
@Given("^User enter event location as Fresno Store$")
public void user_enter_event_location_as_Fresno_Store() throws Throwable {
	kidsGroupEventPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
	//If Test case is not location specific enter blank as: "" 
	kidsGroupEventPage.validateSelectStore();
}
////////////////////////////////////////////////////////////////
@Given("^User enter event location as North York, Ontario$")
public void user_enter_event_location_as_North_York_Ontario() throws Throwable {
	kidsGroupEventPage.validateSearchLocation("NORTH YORK ONTARIO");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
	//If Test case is not location specific enter blank as: "" 
	kidsGroupEventPage.validateSelectStore();

}
@Then("^User select 120 minutes package$")
public void user_select_120min_pack() throws Throwable{
	kidsGroupEventPage.validateChoosePackage("120min");
}
/////////////////////////////////////////////////////////////////////////////////////////////////////////
//////////////////////SCENARIO 13//////////////////////////////////////////////
@When("^User enter number of kids and adult attending event$")
public void user_enter_number_of_kids_and_adult_attending_event() throws Throwable {
	kidsGroupEventPage.validateChildrenAdultDateEvent("7","8");
}

@Then("^Upgrade dialog should not be present$")
public void upgrade_dialog_should_not_be_present() throws Throwable {
	boolean title=kidsGroupEventPage.selectPackageEvent("60min");
	Assert.assertEquals(true, title,"conatact page not opened");
}
}
