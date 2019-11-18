package com.cec.qa.stepdefinations;

import static org.testng.Assert.assertTrue;

import org.testng.Assert;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.BrandBookingBirthdayPage;
import com.cec.qa.util.TestUtil;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class KidsBirthdayStepDefination extends BaseTest{
	BrandBookingBirthdayPage brandBookingBirthdayPage= new BrandBookingBirthdayPage();
	public String gcontactName = null;
	public String gcontactEmail = null;
	public String gcontactPhone = null;
	String errMsgInfo=null;
	double packagePrice;
	String childrenCount;
	double calculatedAmt;
	double totalEstimatedAmount;
	String Confmessage=null;
	boolean errMsgs=true;
	String adultCount;
	boolean partyLink=false;
	private static boolean flag=false;
	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

		int bookingdate = TestUtil.tubookingDate; //Defining booking date at TestUtil -- enter date days 0 for today and 1,2,3..N for future days.
		int tubookingDateFor90thday = TestUtil.tubookingDateFor90days;
		int tubookingDateForSunday = TestUtil.tubookingDateForSunday;
		int todaysDate = TestUtil.todaysDate;
		
		public KidsBirthdayStepDefination() {
			super();
		}
		
	//////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////////////////////////SCENARIO 1/////////////////////////////////////////////////
	@Given("^User entered location details$")
	public void user_entered_location_details() throws Throwable {
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
	}

	@When("^user choose star package$")
	public void user_choose_star_package() throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage("Star");
	}

	@When("^user enter children adult party date and time$")
	public void user_enter_children_adult_party_date_and_time() throws Throwable {
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("7", "1");
		brandBookingBirthdayPage.validateSelectPackage("Star","NO");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0	
	}

	@When("^user enter contact and payment details$")
	public void user_enter_contact_and_payment_detailss() throws Throwable {
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
	}

	@Then("^user verifying confirmation number generated for star booking$")
	public void user_verifying_confirmation_number_generated_for_star_booking() throws Throwable {
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		System.out.println("cf"+cf);
		System.out.println("length"+cf.length());
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	 
	}
	
    //////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////SCENARIO 2/////////////////////////////////////////////////
	@Given("^User is on the contact and payment info page$")
	public void user_is_on_the_contact_and_payment_info_page() throws Throwable {
		
		gcontactName = getSaltString();
		gcontactPhone = getSaltNumber();
		gcontactEmail = getSaltEmail();

		brandBookingBirthdayPage.validateSearchLocation("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("7", "1");
		//brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","YES");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		//brandBookingBirthdayPage.validateBirthdayStarInformation(0);
	
	}
	
	@When("^User entered contact and payment details$")
	public void user_entered_contact_and_payment_details() throws Throwable {
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		brandBookingBirthdayPage.validatePaymentInformation();
	}

	@Then("^Confirmation number should be generated$")
	public void confirmation_number_should_be_generated() throws Throwable {
		brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
	}

	@When("^User entered same contact and payment details twice$")
	public void user_entered_same_contact_and_payment_details_twice() throws Throwable {
		driver.navigate().to(propv.getProperty("NBB"));
		Thread.sleep(1000);

		//	brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		//If Test case is not location specific enter blank as: "" 
		//	brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		//brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("7", "1");
		brandBookingBirthdayPage.validateSelectPackage("Star","NO");
		
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
        brandBookingBirthdayPage.validateContactInformationForDuplicateCheck(gcontactName,gcontactPhone,gcontactEmail); 
		brandBookingBirthdayPage.validatePaymentInformation();
		
	
	}

	@Then("^duplicate reservations popup displayed$")
	public void duplicate_reservations_popup_displayed() throws Throwable {
		String duplicateMsg = brandBookingBirthdayPage.validateDuplidateBookingWarningWindow("Message"); //Parameters can be: "NewReservation" or "OldReservation" or "CloseWindow" or "Message"
		Assert.assertEquals(duplicateMsg, "We have found potential duplicate bookings. Please review the parties below before proceeding","Message text Mismatch");
	   
	}
	
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
    ///////////////////////////////////////SCENARIO 3/////////////////////////////////////////////////
	
	@Given("^User is on the contact and payment page$")
	public void user_is_on_the_contact_and_payment_page() throws Throwable {
		if(flag==false) {
	        flag=true;
		brandBookingBirthdayPage = new BrandBookingBirthdayPage();
		brandBookingBirthdayPage.validateSearchLocation("");//Enter location Example: "North York, Ontario" or "".
		//If Test case is not location specific enter blank as: "" 
		brandBookingBirthdayPage.validateSelectStore();
		brandBookingBirthdayPage.validateChoosePackage("Star");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("7", "1");
		//brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectPackage("Star","YES");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0
		//brandBookingBirthdayPage.validateBirthdayStarInformation(0);
	}

}

	@When("^User entered \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" keeping any one field as blank$")
	public void user_entered_keeping_any_one_field_as_blank(String cname, String age, String gender, String aname, String phone, String email, String instore) throws Throwable {
		
		brandBookingBirthdayPage = new BrandBookingBirthdayPage();
		
		 errMsgs = brandBookingBirthdayPage.validateBirdayPartyContactInformationPageFields(cname, age, gender, aname, phone, email, instore);
	}

	@Then("^alert message should be displayed$")
	public void alert_message_should_be_displayed() throws Throwable {
		 try {
		Assert.assertEquals(errMsgs,true,"alert not displayed");
	
		 }catch(Exception e)
		 {
			 e.printStackTrace();
			 throw new AssertionError("A clear description of the failure", e);
		 }finally {
			 driver.navigate().refresh();
		 }
	}

	
	///////////////////////////////////////////////////////////////////////////////////////////////
   ///////////////////////////Scenario4////////////////////////////////////////////////////////////
	@Given("^User select non deposit store location$")
	public void user_select_non_deposit_store_location() throws Throwable {
		brandBookingBirthdayPage = new BrandBookingBirthdayPage();
		brandBookingBirthdayPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		brandBookingBirthdayPage.validateSelectStore();
	}

	

	@When("^User choose star package$")
	public void User_choose_star_package() throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage("Star");
	}

	@When("^User enter children adult party date and time$")
	public void User_enter_children_adult_party_date_and_time() throws Throwable {
		//brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("6","2");
		brandBookingBirthdayPage.validateSelectPackage("Star","NO");//Base PKG, YES/NO to Upgrade, 
		 
	}


	@Then("^payment/deposit details do not display in payment page$")
	public void payment_deposit_details_do_not_display_in_payment_page() throws Throwable {
		boolean checkResult = brandBookingBirthdayPage.validateNoDeposit_BDD("NO");
		Assert.assertEquals(checkResult,false,"Payment options Available");
		
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////Scenario 5////////////////////////////////////////////
	@Given("^User select \"([^\"]*)\" location$")
	public void user_select_location(String arg1) throws Throwable {
	    brandBookingBirthdayPage = new BrandBookingBirthdayPage();
		brandBookingBirthdayPage.validateSearchLocation(arg1);//Enter location Example: "North York, Ontario" or "".
		brandBookingBirthdayPage.validateSelectStore();
	}

	@Then("^payment options should be displayed is \"([^\"]*)\"$")
	public void payment_options_should_be_displayed_is(String arg2) throws Throwable {
		boolean checkResult = brandBookingBirthdayPage.validateNoDeposit_BDD(arg2);
		System.out.println("checkResult"+checkResult);
		try {
		if(arg2.equals("YES"))
		{
		Assert.assertEquals(checkResult,true,"Payment options missing");
		}
		else
		{
		Assert.assertEquals(checkResult,false,"Payment options present");
		}
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
		}
		
		
	}
/////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////SCENARIO 6//////////////////////////////////////
	@When("^User select maximum children and adult$")
	public void user_select_maximum_children_and_adult() throws Throwable {
		brandBookingBirthdayPage.validateSelectMaxChildAdultAndDate_BDD(bookingdate);
	}

	@Then("^\"([^\"]*)\" Message displays for Birthday$")
	public void message_displays_for_Birthday(String arg1) throws Throwable {
		 boolean alertMsg = brandBookingBirthdayPage.validateNoTimeSlotAvailableMsg();	
		System.out.println("alertMsg is"+alertMsg);
		Assert.assertEquals(alertMsg,true,"No available timeslot. Select different date");
		
	}
	
	////////////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	///////////////////SCENARIO 7////////////////////////////////////////////////////////////////////////////////
    

	
	@Given("^User select the  lower \"([^\"]*)\"$")
	public void user_select_the_lower(String arg1) throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage(arg1);
		//brandBookingBirthdayPage.validateSelectChildAdultAndDate(bookingdate,"10:00 AM - 12:00 PM");
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("7", "1");
		brandBookingBirthdayPage.validateSelectPackage(arg1,"YES");//Base PKG, YES/NO to Upgrade, 
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If you are validation min/max count give person = Child/Adult and cCount 4/1 or 100
		//If not validating min/max count give parameter as: "",0 
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); 
	}
	@Then("^selected package should be upgraded to \"([^\"]*)\"$")
	public void selected_package_should_be_upgraded_to(String upgrade) throws Throwable {
		String yourPackage = brandBookingBirthdayPage.validatePaymentInformation();
		brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		System.out.println("alertMsg is"+yourPackage);
		Assert.assertEquals(yourPackage,upgrade,"String Mismatch");

		brandBookingBirthdayPage.validateCancelBooking("confirmCancel");

	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////////////SCENARIO8///////////////////////////////////////////////

@Given("^User entered location detailss$")
public void user_entered_location_detailss() throws Throwable {
	brandBookingBirthdayPage = new BrandBookingBirthdayPage();
	
	System.out.println("----> 4971:Birthday:Verify user is able to generate Confirmation for Birthday Party for Star package in Chrome browser for Irving Store");
	brandBookingBirthdayPage.validateSearchLocations("Tupelo,Ms 38804");//Enter location Example: "North York, Ontario" or "".
	//If Test case is not location specific enter blank as: "" 
	brandBookingBirthdayPage.validateSelectStore();
	
}

	@When("^User choose MegaSuperStar package$")
	public void user_choose_MegaSuperStar_package() throws Throwable {
		brandBookingBirthdayPage.validateChoosePackageAndroid("SuperStar");
	}

	@When("^User enter contact and payment details$")
	public void user_enter_contact_and_payment_details() throws Throwable {
        brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		brandBookingBirthdayPage.validatePaymentInformation();
	}

	@Then("^User verifying confirmation number generated for MegaSuperStar booking$")
	public void user_verifying_confirmation_number_generated_for_MegaSuperStar_booking() throws Throwable {
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
	 
	}
	///////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////scenario 8/////////////////////////////////

       @When("^User modify the quantity for optional items$")
        public void user_modify_the_quantity_for_optional_items() throws Throwable {
    	   brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
    	    Confmessage= brandBookingBirthdayPage.validateUpsellQuantity_BDD(2);
   		
      }

          @Then("^price and items should be updated;$")
        public void price_and_items_should_be_updated() throws Throwable {
        	  Assert.assertEquals(Confmessage,"Your reservation has been updated","Update Success String Mismatch");
         		brandBookingBirthdayPage.validateCancelBooking("confirmCancel"); // Accepts String: closeCancel or confirmCancel
       }


	////////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////SCENARIO 09//////////////////////////////////////////////////////////////////
	@When("^User choose \"([^\"]*)\"$")
	public void user_choose(String arg1) throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage(arg1);
	}

	
	
	@When("^User enter number of \"([^\"]*)\" \"([^\"]*)\" including party date and time details$")
	public void user_enter_number_of_including_party_date_and_time_details(String childrenNum, String adultNum) throws Throwable {
        childrenCount=childrenNum;
	    adultCount = adultNum;
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD(childrenNum,adultNum);
	}

	@Then("^User verify the selected \"([^\"]*)\" price$")
	public void user_verify_the_selected_price(String arg1) throws Throwable {
		packagePrice = brandBookingBirthdayPage.validateChoosePackageAndGetPrice_BDD(arg1);
		brandBookingBirthdayPage.validateSelectPackage_BDD(arg1,"NO");
		
	}

	@Then("^User add the additional item$")
	public void user_add_the_additional_item() throws Throwable {
		 brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		 int childrenCounts = Integer.parseInt(childrenCount);
		 int adultCounts = Integer.parseInt(adultCount);
		 calculatedAmt = brandBookingBirthdayPage.estimatedTotalWithUpsell_BDD(childrenCounts, adultCounts,packagePrice, 2);
	}

	@Then("^User verify total price of the party are calculated properly On the Reservation Summary Screen$")
	public void user_verify_total_price_of_the_party_are_calculated_properly_On_the_Reservation_Summary_Screen() throws Throwable {
		double totalEstimatedAmount = brandBookingBirthdayPage.estimatedTotalAmount();
		System.out.println("calculatedAmt"+calculatedAmt);
		System.out.println("totalEstimatedAmount"+totalEstimatedAmount);
		Assert.assertEquals(calculatedAmt,totalEstimatedAmount,"total mismatch");
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel");

	}
  //////////////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////////////////////Scenario10/////////////////////////////////////////////////
	@When("^User Edit the Birthday Star information in payments page$")
	public void user_Edit_the_Birthday_Star_information_in_payments_page() throws Throwable {
		brandBookingBirthdayPage.updateContactBirthdayStarInfo();
		brandBookingBirthdayPage.validateBirthdayStarInformation_BDD(0);
		  //brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		  brandBookingBirthdayPage.validatePaymentInformation();
	}

	@Then("^ConfirmationNumber will be generated$")
	public void confirmationnumber_will_be_generated() throws Throwable {
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
	}
	
	@Then("^cancel the booking$")
	public void cancel_the_booking() throws Throwable{
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel");

	}
	//////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////Scenario 11/////////////////////
	@When("^User modify the Contact information for an existing reservation in Reservation Summary Page$")
	public void user_modify_the_Contact_information_for_an_existing_reservation_in_Reservation_Summary_Page() throws Throwable {
		brandBookingBirthdayPage.updateContactBirthdayStarInfo();
	     brandBookingBirthdayPage.validateContactInformation(""); //Checking Duplicate if YES? enter "YES", if NO? enter ""
		  brandBookingBirthdayPage.validatePaymentInformation();
	}
	
	///////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////Scenario 12////////////////////////////////////////////////////////
	@When("^User change  selected \"([^\"]*)\" to \"([^\"]*)\" package$")
	public void user_change_selected_to_package(String arg1, String arg2) throws Throwable {
		brandBookingBirthdayPage.validateChangePackage_BDD(arg2);
	}

	@Then("^User validate the \"([^\"]*)\" package$")
	public void user_validate_the_package(String arg1) throws Throwable {
		String modifiedPackageName = brandBookingBirthdayPage.validatePackageUpdateInformation_BDD();
		Assert.assertEquals(arg1, modifiedPackageName,"package not modified");
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel");
	}
	
	
	///////////////////////////scenario 13//////////////
	//////////////////////////////////////////////////////////
	@When("^User edit the number of children increased more than available seats in Location and Attendees$")
	public void user_edit_the_number_of_children_increased_more_than_available_seats_in_Location_and_Attendees() throws Throwable {
		brandBookingBirthdayPage.editNumOfChildrenInformation("190");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////////////
	/////////////////////////SCENARIO 14//////////////////////////////////////////
	@When("^User entered \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"  and acknowledge the  \"([^\"]*)\" deposit by clicking on a checkbox$")
	public void user_entered_and_acknowledge_the_deposit_by_clicking_on_a_checkbox(String cname, String age, String gender, String aname, String phone, String email, String instore) throws Throwable {
		brandBookingBirthdayPage.validateBirdayPartyContactInformationPageFields2(cname, age, gender, aname, phone, email, instore);
	}
	/////////////////////////////////////////////////try///////////////////////////////////////////////////////
	
	@Given("^user is full$")
	public void user_is_full() throws Throwable {
		

	}
////////////////////////////////////////////////////////////////////////////////////////////////////
	////////////////////SCENARIO 15//////////////////////////////////////////////////////////
	@When("^User clicks Send Free Party Invitations link$")
	public void user_clicks_Send_Free_Party_Invitations_link() throws Throwable {
		 partyLink = brandBookingBirthdayPage.sendBdayPartyInvitation();
	}

	@Then("^New tab of invitation should be open$")
	public void new_tab_of_invitation_should_be_open() throws Throwable {
		System.out.println("partyLink"+partyLink);
		Assert.assertEquals(true, partyLink,"new party invitation tab not opened");
		brandBookingBirthdayPage.validateCancelBooking("confirmCancel");
	}
////////////////////////////////////////////////////////////////////////////////////////
	//////////////////SCENARIO 16////
	@Given("^User entered location details as Fresno Store$")
	public void user_entered_location_details_as_Fresno_Store() throws Throwable {
		brandBookingBirthdayPage.validateSearchLocation("FRESNO, CA, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		brandBookingBirthdayPage.validateSelectStore();
	}

	@Given("^User choose Superstar package$")
	public void user_choose_Superstar_package() throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
	}
	
	@When("^User enter birthday star info and contact details$")
	public void user_enter_birthday_star_info_and_contact_details() throws Throwable {
		brandBookingBirthdayPage.validateBirthdayStarInformation(0);
		brandBookingBirthdayPage.validateContactInformation("");
		brandBookingBirthdayPage.validatePaymentInformationIE();
	}
	
	@When("^User enter number of kids and adult attending for the party$")
	public void user_enter_number_of_kids_and_adult_attending_for_the_party() throws Throwable{
		brandBookingBirthdayPage.validateSelectChildAdultAndDateIE("7","2");
		brandBookingBirthdayPage.validateSelectPackage("SuperStar","NO");//Base PKG, YES/NO to Upgrade, 
		 
	}
	
	///////////////////////////////////////////////////////
	///////////////SCENARIO 17/////////////////
	@Given("^User entered location details as Tupelo,Ms$")
	public void user_entered_location_details_as_Tupelo_Ms() throws Throwable {
		brandBookingBirthdayPage.validateSearchLocation("TUPELO, MS, USA");//Enter location Example: "North York, Ontario" or "IRVING, TX, USA".
		brandBookingBirthdayPage.validateSelectStore();
	}

	@Given("^User choose package$")
	public void user_choose_package() throws Throwable {
		brandBookingBirthdayPage.validateChoosePackage("SuperStar");
	}

	@Given("^ConfirmationNumber will be generated for \"([^\"]*)\"$")
	public void confirmationnumber_will_be_generated_for(String arg1) throws Throwable {
		String cf = brandBookingBirthdayPage.validateGetConfirmationNumber_BDD();
		if(cf.length()==14){
			Assert.assertEquals(true, true);
		}else{
			Assert.assertEquals(true, false,"Confirmation number not found as expected");
		}
		String modifiedPackageName = brandBookingBirthdayPage.validatePackageUpdateInformation_BDD();
		Assert.assertEquals(arg1, modifiedPackageName,"package name modified");
	}
	////////////////////////////////////////////////////////////////////
	//////////////////////////////////////////////////////////////////////
	@Then("^Selected \"([^\"]*)\" is highlighted in PackInfo Page$")
	public void selected_is_highlighted_in_PackInfo_Page(String arg1) throws Throwable {
		 boolean packageName = brandBookingBirthdayPage.highlightedPackageName(arg1);
		Assert.assertEquals(true, packageName,"package name modified");
	}
	
	@Then("^User enter number of kids and adult attending party$")
	public void user_enter_number_of_kids_and_adult_attending_party()  throws Throwable {
		brandBookingBirthdayPage.validateSelectChildAdultAndDate_BDD("6","2");
	}
	
	//////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////scenario 18/////////////////////////////////////

@Then("^Minimum children \"([^\"]*)\" and maximum children \"([^\"]*)\" should be available in dropdown select option$")
public void minimum_children_and_maximum_children_should_be_available_in_dropdown_select_option(int arg1, int arg2) throws Throwable {
	    boolean checkKidsResult = brandBookingBirthdayPage.validateMinMaxChildrenBirthday(arg1, arg2);
	    Assert.assertEquals(true, checkKidsResult,"Found issue in MIN and MAX kids Vlaue");
}

@Then("^Minimum adult \"([^\"]*)\" and maximum adult \"([^\"]*)\" should be available in dropdown select option$")
public void minimum_adult_and_maximum_adult_should_be_available_in_dropdown_select_option(int arg1, int arg2) throws Throwable {
	 boolean checkAdultResult=brandBookingBirthdayPage.validateMinMaxAdultBirthday(arg1, arg2);
	 Assert.assertEquals(true, checkAdultResult,"Found issue in MIN and MAX adult Vlaue");
}
//////////////////////////////////////////////////////////////////////
/////////////////////////////////////////////////////////////////////
@When("^User does the overbooking in Payments page$")
public void user_does_the_overbooking_in_Payments_page() throws Throwable {
	brandBookingBirthdayPage.overbookingInBirthday();
	}
	}

