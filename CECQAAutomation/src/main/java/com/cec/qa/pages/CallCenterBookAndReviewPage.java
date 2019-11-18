/*
 * 
 * Test Suite: CallCenterBookAndReviewTest
 * Created By: Aditya
 * Updated By: Monalisa
 * Reviewed By: Vishnu
 * Review Date: 11-June-2019
 *  
 */
package com.cec.qa.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.List;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;


public class CallCenterBookAndReviewPage extends BaseTest{
	public String valconfirmationID;
	public String selectedOptionalItemName;
	public String customerComment ="Customer comments is added";
	public String agntComment ="Agent comments is added";

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//******************************Main Menu **************************************************
	@FindBy(xpath="//a[@title='Party Booking']")
	WebElement bookingMenuLnk;

	@FindBy(xpath="//a[@title='Review']")
	WebElement reviewMenuLnk;

	@FindBy(xpath="//a[@title='FAQ']")
	WebElement faqMenuLnk;

	@FindBy(xpath="//a[@title='Restaurant']")
	WebElement restaurantMenuLnk;

	@FindBy(xpath="//a[@title='Party']")
	WebElement partyMenuLnk;

	@FindBy(xpath="////a[@title='Promotion / Reward']")
	WebElement promotionMenuLink;

	@FindBy(xpath="//a[@title='Configuration']")
	WebElement configurationMenuLink;

	@FindBy(xpath="//a[@title='User']")
	WebElement userMenuLink;

	@FindBy(xpath="//a[@id='hlnkParameters']")
	WebElement reportMenuLink;

	//******************************Book Menu**************************************************
	//Select Attendees,Select Date and Timeslot, Package

	@FindBy(xpath="//input[@id='txtstorenumb']")
	WebElement storeNumberBookInputBox;

	@FindBy(id="drpReservType")
	WebElement selectReservationsType;

	@FindBy(id="txtchildren")
	WebElement childrenInputBox;

	@FindBy(id="txtadults")
	WebElement adultInputBox;

	@FindBy(id="btnShowCalendar")
	WebElement showCalendarbtn;

	@FindBy(xpath="//input[@name=' optionalpartyitem.itemtype']")
	List<WebElement> selectTimeSlotRadiobtn;

	@FindBy(xpath="//td[@class=' ui-datepicker-unselectable ui-state-disabled cal-unselect ui-datepicker-today']")
	WebElement selectcalanderDate;

	@FindBy(xpath="(//div[@id=\"timeWithSeat\"])/div/div[3]")
	WebElement select11AMTimeSlotRadiobtn;

	@FindBy(id="0300PM")
	WebElement select3PMTimeSlotRadiobtn;

	@FindBy(id="0800AM")
	WebElement select8PMTimeSlotRadiobtn;

	@FindBy(xpath="//*[@id='dvDatepicker']/div/div[2]/table/tbody/tr[3]/td[3]/a")
	WebElement booth;
	//(//div[@class='ui-datepicker-group ui-datepicker-group-middle']/table[@class='ui-datepicker-calendar'])

	@FindBy(xpath="//div[@class='bootbox-body']")
	WebElement errorMsgMinAttendees;

	@FindBy(name="rdotype")
	List<WebElement> selectPkgRadiobtn;

	@FindBy(id="rdoPackage27")
	WebElement selectschoolPkgRadiobtn;

	@FindBy(id="rdoPackage175")
	WebElement selectNonFundPkgRadiobtn;

	@FindBy(id="btnNext")
	WebElement next1Btn;

	@FindBy(id="reservation_ReservationFundRaisingGuestDetails_SchoolName")
	WebElement schoolNameInputBox;

	@FindBy(id="reservation_ReservationFundRaisingGuestDetails_Phone")
	WebElement schoolPhoneInputBox;

	@FindBy(id="reservation_ReservationFundRaisingGuestDetails_PrincipalName")
	WebElement principalNameInputBox;

	@FindBy(id="reservation_ReservationFundRaisingGuestDetails_Address")
	WebElement schoolAddressInputBox;

	@FindBy(id="reservation_ReservationFundRaisingGuestDetails_NumberOfStudents")
	WebElement numberOfStudentsInputBox;

	//Organization - Contact Information

	@FindBy(id="reservation_ReservationGuestDetails_OrganizationName")
	WebElement organizationNameInputBox;

	@FindBy(id="reservation_ReservationGuestDetails_OrganizationPhone")
	WebElement organizationPhoneInputBox;

	@FindBy(id="reservation_ReservationGuestDetails_OrganizationType")
	WebElement selectOrganizationType;

	@FindBy(id="CustomerName")
	WebElement customerNameInputBox;

	@FindBy(id="Phone1")
	WebElement phonenoInputBox;

	@FindBy(id="Email")
	WebElement emailidInputBox;

	@FindBy(id="Address")
	WebElement addressInputBox;

	//Birthday - Guest Information

	@FindBy(id="name")
	WebElement guestNameInputBox;

	@FindBy(id="age")
	WebElement ageInputBox;

	@FindBy(xpath="//select[@id='drpPrtyStyle']/option")
	WebElement selectTheme;

	@FindBy(id="Add")
	WebElement addBtn;

	@FindBy(id="Remove")
	WebElement removeBtn;

	@FindBy(id="next")
	WebElement next2Btn;

	//Deposit

	@FindBy(id="rdInStore")
	WebElement inStoreRadioBtn;

	@FindBy(id="rdCredit")
	WebElement creditCardRadioBtn;


	@FindBy(id="DueDate")
	WebElement DueDateInputBox;

	//optional item

	@FindBy(xpath="//div[@class='accordion-content default']/div[1]/div/div/input")
	WebElement optionalItemInputBox1;

	@FindBy(xpath="//div[@id='divBooking']/div/fieldset/div[1]/p[15]")
	WebElement optionalItemName;

	//Confirmation page

	@FindBy(id="btnbook")
	WebElement bookBtn;

	@FindBy(id="btnfundBook")
	WebElement bookfundBtn;

	@FindBy(id="lblBookCNFNo")
	WebElement genBirthdayOrgconfID;

	@FindBy(id="lblfundCNFNo")
	WebElement genFundraiserconfID;

	@FindBy(id="btnfinish")
	WebElement finishBtn;

	@FindBy(id="btnfundFinish")
	WebElement fundfinishBtn;

	@FindBy(id="btnCopy")
	WebElement copyBtn;

	//Funcdraiser -School - Error message

	@FindBy(id="errorSchoolName")
	WebElement errorSchoolName;

	@FindBy(id="errorSchoolPhone")
	WebElement errorSchoolPhone;

	@FindBy(id="errorPrincipalName")
	WebElement errorPrincipalName;

	@FindBy(id="errorSchoolAddress")
	WebElement errorSchoolAddress;

	@FindBy(id="errorNumberofStudents")
	WebElement errorNumberofStudents;

	@FindBy(id="errorcustomerName")
	WebElement errorcustomerName;

	@FindBy(id="errorphone1")
	WebElement errorphone1;

	//Comments

	@FindBy(id="reservation_Comments")
	WebElement customerCommentsInputBox;

	@FindBy(id="reservation_CallCenterComments")
	WebElement agentCommentsInputBox;

	//******************************Review Menu**************************************************
	//Reservation-Search

	@FindBy(id="ReservationTypeId")
	WebElement ReservationTypeId;

	@FindBy(xpath="//select[starts-with(@id,'ReservationTypeId')]//option[text()='Birthday']")
	WebElement reviewBirthdayDrop;

	@FindBy(xpath="//select[starts-with(@id,'ReservationTypeId')]//option[text()='Organizational']")
	WebElement reviewOrganizationalDrop;

	@FindBy(xpath="//select[starts-with(@id,'ReservationTypeId')]//option[text()='Fund Raising']")
	WebElement reviewFundRaiseDrop;

	@FindBy(id="ConfirmationNumber")
	WebElement reviewConfirmationNumberInputBox;

	@FindBy(id="PartyDateFrom")
	WebElement partyDateFromInputBox;

	@FindBy(id="PartyDateTo")
	WebElement partyDateToInputBox;

	@FindBy(id="ReservationTypeId")
	WebElement drpReservationType;

	@FindBy(id="StoreNumber")
	WebElement reviewStoreNumberInputBox;

	@FindBy(id="Search")
	WebElement btnSearch;

	@FindBy(id="Reservations")
	WebElement reservationLookup;

	@FindBy(xpath="//div[@class='col-md-7 col-sm-7 colour-green col-xs-9']")
	WebElement confirmationNumberInReviewPage;

	// Edit Fields in Review Page

	@FindBy(xpath="//a[@class='editName glyphicon glyphicon-edit mar_left_5']")
	WebElement editNameInReviewPage;

	@FindBy(xpath="//a[@class='editphone glyphicon glyphicon-edit mar_left_5']")
	WebElement editPhoneInReviewPage;

	@FindBy(xpath="//a[@class='editEmail glyphicon glyphicon-edit mar_left_5']")
	WebElement editEmailInReviewPage;

	@FindBy(id ="infoName")
	WebElement nameTxtBox;

	@FindBy(id ="infophone")
	WebElement phnTxtBox;

	@FindBy(id ="infoEmail")
	WebElement emailTxtBox;

	@FindBy(xpath ="//a[@class='editName glyphicon glyphicon-edit mar_left_5']")
	WebElement nameEditIcon;

	@FindBy(xpath ="//a[@class='editphone glyphicon glyphicon-edit mar_left_5']")
	WebElement phoneEditIcon;

	@FindBy(xpath ="//a[@class='editEmail glyphicon glyphicon-edit mar_left_5']")
	WebElement emailEditIcon;

	@FindBy(id ="BtnSaveComments")
	WebElement saveChangesBtn;

	@FindBy(id ="infoName")
	WebElement nameValue;

	@FindBy(id ="infophone")
	WebElement phoneValue;

	@FindBy(id ="infoEmail")
	WebElement emailValue;

	@FindBy(xpath ="//button[text()='OK']")
	WebElement recordSavedOKBtn;

	//Credit card

	@FindBy(xpath="(//div[@class='col-md-8 col-sm-5 colour-green col-xs-9'])/span[contains(text(),'HL')]")
	WebElement hotlineRef;


	@FindBy(xpath="//div[@ id='TotalPrice']")
	WebElement totalAmount;

	//Reservation Info

	@FindBy(id="btnNew")
	WebElement newBtn;

	@FindBy(id="btnChange")
	WebElement changeBtn;

	@FindBy(id="BtnCancel")
	WebElement cancelBtn;

	@FindBy(xpath="//input[@class='bootbox-input bootbox-input-text form-control']")
	WebElement cancelreasonInputBox;

	@FindBy(xpath="//button[text()='Cancel']")
	WebElement cancelreasonBtn;

	@FindBy(xpath="//button[text()='OK']")
	WebElement cancelOkBtn;

	@FindBy(id="btnAddDRewards")
	WebElement addDRewardsBtn;

	@FindBy(id="CustomerComments")
	WebElement reviewcustomerComments;

	@FindBy(id="AgentComments")
	WebElement reviewagentComments;

	@FindBy(id="drpAltStore")
	WebElement selectAltStore;

	@FindBy(xpath="//label[@id='lbladdress' and text()='2755 E. Grapevine Mills Pkwy.']")
	WebElement altStoreAdddress;

	@FindBy(xpath="//label[@id='lblphone' and text()='9726913312']")
	WebElement altStorePhoneNumber;

	//DiscretionaryReward fields

	@FindBy(id="ddlDiscretionaryReward")
	WebElement discretionaryRewardDropdown;


	@FindBy(id="btnAddDiscresionaryRewardPopup")
	WebElement addDiscresionaryRewardPopup;

	@FindBy(xpath="(//button[@class='btn_grid display-mode delete-item btn-trans']/span[@class='custom_icon'])[1]")
	WebElement trashicon;

	@FindBy(xpath="//label[text()='Promotion :']")
	WebElement promotionLabel;

	@FindBy(xpath="//span[@id='infoName']")
	WebElement reviwContactName;

	@FindBy(xpath="//a[@class='editName glyphicon glyphicon-edit mar_left_5']")
	WebElement editContactName;

	//User Menu

	@FindBy(id="UserEdit_DomainId")
	WebElement loginNameInputBox;

	@FindBy(id="UserEdit_RoleId")
	WebElement userRoleDropdownList;

	@FindBy(id="UserEdit_AgentID")
	WebElement agentIDInputBox;

	@FindBy(name="command")
	WebElement saveBtn;

	@FindBy(name="lnkLogout")
	WebElement logoutBtn;

	@FindBy(xpath="/html/body/div[7]/div/div/div[2]/button[2]")
	WebElement logoutOKBtn;

	@FindBy(id="btnAddDRewards")
	WebElement AddDRewardsBtn;

	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************
	public CallCenterBookAndReviewPage(){
		PageFactory.initElements(driver, this);
	}
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$


	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER METHDOS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//************************************************************************************************
	//*********************Methods to validateLoginToCallCenter  *************************************
	//************************************************************************************************
	public boolean validateLoginToCallCenter() throws IOException {
		boolean result = false;	
		try {
			Thread.sleep(2000);
			Robot rb = new Robot();
			//Thread.sleep(5000);
			StringSelection pwd = new StringSelection(propv.getProperty("userpwd"));
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			// press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
			result = true;
			//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
		} catch (Exception e) {
			result = false;
			System.out.println("Found Issue in Method: validateLoginToCallCenter()");
			e.printStackTrace();
		}
		return result;
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//                                       MANAGER LOGIN 
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//************************************************************************************************
	//********Methods to validateRobotLogin **********************************************************
	//************************************************************************************************
	public void validateRobotLogin() throws IOException {
		try {
			System.out.println("RobotLogin function called");
			Robot rb = new Robot();
			Thread.sleep(5000);
			StringSelection pwd = new StringSelection("June@123");
			Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
			rb.keyPress(KeyEvent.VK_CONTROL);
			rb.keyPress(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_V);
			rb.keyRelease(KeyEvent.VK_CONTROL);
			// press enter
			rb.keyPress(KeyEvent.VK_ENTER);
			rb.keyRelease(KeyEvent.VK_ENTER);
			Thread.sleep(3000);
		} catch (Exception ex) {
			System.out.println("Found Issue in Method: validateRobotLogin()");
			ex.printStackTrace();
		}
	}
	//************************************************************************************************
	//*********************Methods to validateSelectMenu *********************************************
	//************************************************************************************************
	public boolean validateSelectMenu(String menuName) throws IOException {
		boolean result = false;	
		try {
			if(menuName.equals("Book")){
				waitAndClick(bookingMenuLnk);
			}else if(menuName.equals("Review")){
				waitAndClick(reviewMenuLnk);
			}else if(menuName.equals("FAQ")){
				waitAndClick(faqMenuLnk);
			}else if(menuName.equals("Restaurant")){
				waitAndClick(restaurantMenuLnk);
			}else if(menuName.equals("Party")){
				waitAndClick(partyMenuLnk);
			}else if(menuName.equals("Promotion")){
				waitAndClick(promotionMenuLink);
			}else if(menuName.equals("Config")){
				waitAndClick(configurationMenuLink);
			}else if(menuName.equals("User")){
				waitAndClick(userMenuLink);
			}else if(menuName.equals("Reports")){
				waitAndClick(reportMenuLink);
			}
			System.out.println("Menu Click Succes...............!");
			result = true;
		} catch (Exception e) {
			result = false;
			System.out.println("Found Issue with method: validateSelectMenu()");
			e.printStackTrace();
		}
		return result;
	}
	///###############################################################################################
	//                              BOOK MENU METHODS
	//################################################################################################	

	//************************************************************************************************
	//*********************Methods to validateBookMenu  **********************************************
	//************************************************************************************************
	public boolean validateBookMenu() throws InterruptedException, AWTException {
		try {
			Thread.sleep(2000);
			waitAndClick(bookingMenuLnk);
			System.out.println("Booking Menu is clicked");
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBookMenu()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateStoreNumber ********************************************
	//************************************************************************************************
	public void validateStoreNumber(String StoreNumber) throws InterruptedException, AWTException {
		try {
			storeNumberBookInputBox.clear();
			storeNumberBookInputBox.sendKeys(StoreNumber);
			Thread.sleep(2000);
			storeNumberBookInputBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");			
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateStoreNumber()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateSelectChildAdultAndDate  *******************************
	//************************************************************************************************
	public void validateSelectChildAdultAndDate(String ReservationsType,int timeSlot) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("Birthday")){
				selectDrpDwnByIndex(selectReservationsType,1);
				childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				childrenInputBox.sendKeys("5");
				adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				adultInputBox.sendKeys("2");
				System.out.println("Children and Adult Attendees Entered...................................................................");
				waitAndClick(showCalendarbtn);
				waitAndClick(showCalendarbtn);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,TestUtil.tuOldBookingWeekDayDate-1);
				System.out.println("Date got selected from calender...................................................................");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				System.out.println("Time slot got selected..............................................................");
				Thread.sleep(1000);
			}else if(ReservationsType.equals("VIPBirthday")){
				selectDrpDwnByIndex(selectReservationsType,1);
				childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				childrenInputBox.sendKeys("10");
				adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				adultInputBox.sendKeys("2");
				waitAndClick(showCalendarbtn);
				waitAndClick(showCalendarbtn);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,TestUtil.tuOldBookingDateForSundayDate);
				System.out.println("Date got selected from calender..................................................................!");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				System.out.println("Time slot got selected..............................................................!");
				Thread.sleep(1000);		
			}else if(ReservationsType.equals("Organizational")){
				selectDrpDwnByIndex(selectReservationsType,3);
				childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				childrenInputBox.sendKeys("10");
				adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				adultInputBox.sendKeys("2");
				System.out.println("Children and Adult Attendees Entered...................................................................");
				waitAndClick(showCalendarbtn);
				waitAndClick(showCalendarbtn);
				Thread.sleep(1000);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,TestUtil.tuOldBookingWeekDayDate-1);
				System.out.println("Date got selected from calender...................................................................");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				System.out.println("Time slot got selected..............................................................");
				Thread.sleep(1000);
			}else if(ReservationsType.equals("FundRaiser")){
				selectDrpDwnByIndex(selectReservationsType,2);
				waitAndClick(showCalendarbtn);
				waitAndClick(showCalendarbtn);
				System.out.println("Children and Adult Attendees Entered...................................................................");
				Thread.sleep(1000);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,TestUtil.tubookingDate);
				System.out.println("Date got selected from calender...................................................................");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				System.out.println("Time slot got selected..............................................................");
				Thread.sleep(1000);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validatePackage ************************************************
	//************************************************************************************************
	public void validatePackage(String ReservationsType,String Package) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("Birthday")){ 
				if(Package.equals("Star")) {
					selectRdoBtn(selectPkgRadiobtn,0);
				}else if(Package.equals("SuperStar")){
					selectRdoBtn(selectPkgRadiobtn,1);
				}else if(Package.equals("MegaSuperStar")){
					selectRdoBtn(selectPkgRadiobtn,2);
				}else if(Package.equals("VIPMegaSuperStar")){
					selectRdoBtn(selectPkgRadiobtn,0);
				}
			}else if(ReservationsType.equals("Organization")){
				if(Package.equals("60min")){
					selectRdoBtn(selectPkgRadiobtn,0);
				}else if(Package.equals("90min")){
					selectRdoBtn(selectPkgRadiobtn,1);
				}else if(Package.equals("120min")){
					selectRdoBtn(selectPkgRadiobtn,2);
				}		
			}else if(ReservationsType.equals("Fundraiser")){
				if(Package.equals("School Fundraisers")){
					selectRdoBtn(selectPkgRadiobtn,0);
				}else if(Package.equals("NonProfit Fundraisers")){ 
					selectRdoBtn(selectPkgRadiobtn,1);
				}
			}
			System.out.println("Package got selected..........................................................!");
			Thread.sleep(1000);
			scrollDown(driver);
			waitAndClick(next1Btn);
		} 
		catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackage()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateGuestInformation ***************************************
	//************************************************************************************************
	public void validateGuestInformation(String ReservationsType) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("Birthday")){
				guestNameInputBox.clear();
				guestNameInputBox.sendKeys(getSaltString());
				ageInputBox.clear();
				ageInputBox.sendKeys("2");
				selectDrpDwnByIndex(selectTheme,0);
				waitAndClick(addBtn);
				System.out.println("Birthday Guest Information is entered...................................!");
			}else if(ReservationsType.equals("Organization")){
				organizationNameInputBox.clear();
				organizationNameInputBox.sendKeys(getSaltString());
				selectDrpDwnByIndex(selectOrganizationType,2);
				organizationPhoneInputBox.clear();
				organizationPhoneInputBox.sendKeys("9902639713");
				System.out.println("Organization Information is entered......................................!");
			}else if(ReservationsType.equals("School Fundraiser")){
				schoolNameInputBox.clear();
				schoolNameInputBox.sendKeys(getSaltString());
				schoolPhoneInputBox.sendKeys("9902639713");
				principalNameInputBox.clear();
				principalNameInputBox.sendKeys(getSaltString());
				schoolAddressInputBox.clear();
				schoolAddressInputBox.sendKeys(getSaltString());
				numberOfStudentsInputBox.clear();
				numberOfStudentsInputBox.sendKeys("80");
				System.out.println("School Fundraiser Information is entered..................................!");
			}else if(ReservationsType.equals("NonProfit Fundraisers")) {
				schoolNameInputBox.clear();
				schoolNameInputBox.sendKeys(getSaltString());
				schoolPhoneInputBox.sendKeys("9902639713");
				schoolAddressInputBox.clear();
				schoolAddressInputBox.sendKeys(getSaltString());
				numberOfStudentsInputBox.clear();
				numberOfStudentsInputBox.sendKeys("80");
				System.out.println("NonProfit Fundraiser Information is entered...............................!");
			} 
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGuestInformation()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateAdditionalBirthday *************************************
	//************************************************************************************************
	public boolean validateAdditionalBirthday(int birthdayStar) throws InterruptedException, AWTException{
		try{
			if(birthdayStar==5) {
				for(int i=0;i<=5;i++) {
					guestNameInputBox.clear();
					guestNameInputBox.sendKeys(getSaltString());
					ageInputBox.clear();
					ageInputBox.sendKeys("10");
					selectDrpDwnByIndex(selectTheme,0);
					waitAndClick(addBtn);
				}
			}
			System.out.println("Additional Birthday Added Successfully...........................................!");
			return true;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateAdditionalBirthday()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateContactInformation *************************************
	//************************************************************************************************
	public void validateContactInformation(String ReservationsType) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("BirthdayOrOrg")) {
				customerNameInputBox.clear();
				customerNameInputBox.sendKeys(getSaltString());
				emailidInputBox.clear();
				emailidInputBox.sendKeys(getSaltEmail());
				addressInputBox.clear();
				addressInputBox.sendKeys(getSaltString());
				//addressInputBox.sendKeys(Keys.TAB);
				phonenoInputBox.click();
				phonenoInputBox.clear();
				Thread.sleep(3000);
				phonenoInputBox.sendKeys(getSaltNumber());
				//enterPhoneNumberUsingRobot("");
				Thread.sleep(2000);
				scrollDown(driver);
				Thread.sleep(1000);
				System.out.println("Contact Information for Birthday/Organization is entered Successfully......................!");
				customerCommentsInputBox.clear();
				customerCommentsInputBox.sendKeys(customerComment);
				agentCommentsInputBox.clear();
				agentCommentsInputBox.sendKeys(agntComment);
				System.out.println("Customer and Agent comments added Successfully......................!");
				waitAndClick(next2Btn);
				scrollDown(driver);
				System.out.println("Book button is clicked for Birthday/Organization Successfully......................!");
				waitAndClick(bookBtn);
				Thread.sleep(1000);
			}else if(ReservationsType.equals("Fundraisers")) {
				customerNameInputBox.clear();
				customerNameInputBox.sendKeys(getSaltString());
				emailidInputBox.clear();
				emailidInputBox.sendKeys(getSaltEmail());
				addressInputBox.clear();
				addressInputBox.sendKeys(getSaltString());
				//addressInputBox.sendKeys(Keys.TAB);
				phonenoInputBox.click();
				phonenoInputBox.clear();
				Thread.sleep(3000);
				phonenoInputBox.sendKeys(getSaltNumber());
				Thread.sleep(2000);
				scrollDown(driver);
				Thread.sleep(1000);
				System.out.println("Contact Information for Fundraisers is entered Successfully......................!");
				customerCommentsInputBox.clear();
				customerCommentsInputBox.sendKeys(customerComment);
				agentCommentsInputBox.clear();
				agentCommentsInputBox.sendKeys(agntComment);
				System.out.println("Customer and Agent comments added Successfully......................!");
				waitAndClick(next2Btn);
				scrollDown(driver);
				waitAndClick(bookfundBtn);
				System.out.println("Book button is clicked for Fundraisers Successfully......................!");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateOptionalItem *******************************************
	//************************************************************************************************
	public void validateOptionalItem() throws InterruptedException, AWTException {
		try {
			optionalItemInputBox1.clear();
			optionalItemInputBox1.sendKeys("1");
		}catch (Exception e) {
			//String selectedOptionalItemName =null;
			e.printStackTrace();
			System.out.println("Issue with Method: validateOptionalItem()");
		}
	}
	//************************************************************************************************
	//*********************Methods to getOptionalItemNameFromSummeryPage *****************************
	//************************************************************************************************
	//Created By: Monalisa
	public String getOptionalItemNameFromSummeryPage() throws InterruptedException, AWTException {
		try {
			selectedOptionalItemName = optionalItemName.getText();
			System.out.println("optionalItemInputBox1 :: "+selectedOptionalItemName);
			return selectedOptionalItemName;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: getOptionalItemNameFromSummeryPage()");
			selectedOptionalItemName = "Issue with Method: getOptionalItemNameFromSummeryPage()";
		}
		return selectedOptionalItemName;
	}
	//************************************************************************************************
	//*********************Methods to validateGetOptionalItemNameFromreviewPage **********************
	//************************************************************************************************
	//Created By: Monalisa	
	public boolean validateGetOptionalItemNameFromreviewPage(String optionalItem) throws InterruptedException, AWTException {
		boolean result = false;
		try {
			WebElement ele1 = driver.findElement(By.xpath("//div[@class='col-md-8 col-sm-8 colour-green col-xs-9']/ul/li/div/div[1]/span[1]"));
			WebElement ele2 = driver.findElement(By.xpath("//div[@class='col-md-8 col-sm-8 colour-green col-xs-9']/ul/li/div/div[1]/span[2]"));
			String optionalItemName1 = waitAndGetText(ele1);
			String optionalItemName2 = waitAndGetText(ele2);
			System.out.println("Optional item name : "+optionalItemName);
			optionalItemName2 = optionalItemName2.replace("@", "[")+"]";
			String optionalItemName = optionalItemName1+" "+optionalItemName2;
			if(optionalItem.contains(optionalItemName)) {
				result = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetOptionalItemNameFromreviewPage()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateGetBirthdayStarNumFromReviewPage ***********************
	//************************************************************************************************
	//Created By: Monalisa	
	public boolean validateGetBirthdayStarNumFromReviewPage(int strNum) throws InterruptedException, AWTException {
		boolean result = false;
		try {
			WebElement ele = driver.findElement(By.xpath("//*[@id='min_hegt_mob2']/div/div[1]/div[2]/span"));
			String birthdayStarNum = ele.getText();
			System.out.println("birthdayStarNum ::"+birthdayStarNum);
			String[] birthdayStarNumber = birthdayStarNum.trim().split(" ");
			String bdayStrNum = birthdayStarNumber[0].replace("(", "");
			int bStarNum = Integer.valueOf(bdayStrNum)+1;
			System.out.println("bStarNum ::"+bStarNum);
			if (strNum>=5) {
				if(bStarNum>=5) {
					result = true;
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetBirthdayStarNumFromReviewPage()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateGetConfirmationNumber  *********************************
	//************************************************************************************************
	public String validateGetConfirmationNumber(String ReservationsType) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("BirthdayOrOrg")){
				String valconfirmationID =null;
				scrollDown(driver);
				validateText(genBirthdayOrgconfID);
				if(genBirthdayOrgconfID.isDisplayed()) {
					valconfirmationID = genBirthdayOrgconfID.getText();
					System.out.println("Confirmation Number is generated Succesfully...........................!");
				}
				Thread.sleep(1000);
				scrollDown(driver);
				waitAndClick(finishBtn);
				System.out.println("Finish button is clicked for Birthday/Organization Successfully......................!");
				return valconfirmationID;
			}else if(ReservationsType.equals("Fundraisers")) {
				String valconfirmationID =null;
				scrollDown(driver);
				validateText(genFundraiserconfID);
				Thread.sleep(3000);
				if(genFundraiserconfID.isDisplayed()) {
					valconfirmationID = waitAndGetText(genFundraiserconfID);	
					System.out.println(genFundraiserconfID);
					System.out.println("Confirmation Number is generated Succesfully");
				}
				Thread.sleep(3000);
				scrollDown(driver);
				waitAndClick(fundfinishBtn);
				System.out.println("Finish button is clicked for Fundraisers Successfully......................!");
				return valconfirmationID;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetConfirmationNumber()");
			valconfirmationID = "Issue with Method: validateGetConfirmationNumber()";
		}
		return valconfirmationID;
	}
	//************************************************************************************************
	//*********************Methods to validateNoDeposit  *********************************************
	//************************************************************************************************
	public boolean validateNoDeposit() throws InterruptedException, AWTException {
		try{
			boolean result = true;
			Thread.sleep(1000);
			scrollDown(driver);
			//inStoreRadioBtn.isSelected();
			//creditCardRadioBtn.isSelected();
			if(inStoreRadioBtn.isSelected()&&creditCardRadioBtn.isSelected()) {
				System.out.println("Payment options are present");
				result=true;
			}else {
				result=false;
				System.out.println("Payment options not present");
			}
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoDeposit()");
			return false;
		}
	}
	//************************************************************************************************
	//*******Methods to validateCopyforOrgOrFundraiser ***********************************************
	//************************************************************************************************
	public String validateCopyforOrgOrFundraiser(String ReservationsType) throws InterruptedException, AWTException {
		try {
			if(ReservationsType.equals("Organization")) {
				String valconfirmationID =null;
				scrollDown(driver);
				validateText(genBirthdayOrgconfID);
				if(genBirthdayOrgconfID.isDisplayed()) {
					valconfirmationID = genBirthdayOrgconfID.getText();
					System.out.println("Confirmation Number is generated succesfully");
				}
				Thread.sleep(1000);
				scrollDown(driver);
				waitAndClick(copyBtn);
				return valconfirmationID;
			}else if(ReservationsType.equals("Fundraisers")) {
				String valconfirmationID =null;
				scrollDown(driver);
				validateText(genFundraiserconfID);
				if(genFundraiserconfID.isDisplayed()) {
					valconfirmationID = genFundraiserconfID.getText();
					System.out.println("Confirmation Number is generated succesfully");
				}
				Thread.sleep(1000);
				scrollDown(driver);
				waitAndClick(copyBtn);
				return valconfirmationID;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateCopyforOrgOrFundraiser()");
			valconfirmationID = "Issue with Method: validateCopyforOrgOrFundraiser()";
		}
		return valconfirmationID;
	}
	//************************************************************************************************
	//*********************Methods to validateRequiredMsgFundraiser **********************************
	//************************************************************************************************
	public boolean validateRequiredMsgFundraiser() throws InterruptedException, AWTException {
		boolean errorMsg1,errorMsg2,errorMsg3,errorMsg4,errorMsg5,errorMsg6,errorMsg7, result;
		try {
			scrollDown(driver);
			waitAndClick(next2Btn);
			Thread.sleep(1000);
			errorMsg1 = errorSchoolName.isDisplayed();
			errorMsg2 =errorSchoolPhone.isDisplayed();
			errorMsg3 =errorPrincipalName.isDisplayed();
			errorMsg4 =errorSchoolAddress.isDisplayed();
			errorMsg5 =errorNumberofStudents.isDisplayed();
			errorMsg6 =errorcustomerName.isDisplayed();
			errorMsg7 =errorphone1.isDisplayed();
			if(errorMsg1==true && errorMsg2==true && errorMsg3==true && errorMsg4==true && errorMsg5==true && errorMsg6==true && errorMsg7==true)
			{
				System.out.println("Required text displayed");
				result = true;
			}
			else {
				System.out.println("Required not displayed");
				result = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateRequiredMsgFundraiser()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateCurrentday *********************************************
	//************************************************************************************************
	public boolean validateCurrentday() throws InterruptedException, AWTException {
		try {
			boolean currentdayTimeslot= true;
			selectDrpDwnByIndex(selectReservationsType,1);
			childrenInputBox.clear();
			childrenInputBox.sendKeys("5");
			adultInputBox.clear();
			adultInputBox.sendKeys("2");
			waitAndClick(showCalendarbtn);
			Thread.sleep(1000);
			waitAndClick(showCalendarbtn);
			Thread.sleep(1000);
			scrollDown(driver);
			Thread.sleep(3000);
			clickOnAvailableDate(driver,TestUtil.todaysDate);
			System.out.println("Date got selected from calender");
			Thread.sleep(1000);
			select11AMTimeSlotRadiobtn.click();
			Thread.sleep(1000);
			if(select11AMTimeSlotRadiobtn.isSelected()) {
				currentdayTimeslot=true;
				System.out.println("Time slot is enabled for Currentday");
			}else {
				System.out.println("Time slot is disabled for Currentday");
				currentdayTimeslot=false;				
			}
			return currentdayTimeslot;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateCurrentday()");
			return true;
		}
	}
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//                                        REVIEW MENU METHODS
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	//************************************************************************************************
	//*********************Methods to validateReviewSearchMenu ***************************************
	//************************************************************************************************
	public boolean validateReviewSearchMenu(String confNum) throws InterruptedException, AWTException {
		boolean result = false;
		try {
			waitAndClick(reviewMenuLnk);
			reviewConfirmationNumberInputBox.sendKeys(confNum);
			waitAndClick(btnSearch);
			String xpathOfConfNum = "//select[@id='Reservations']/option[contains(text(),'"+confNum+"')]";
			scrollDown(driver);
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement ele = driver.findElement(By.xpath(xpathOfConfNum));
			waitAndClick(ele);
			if(confNum.equals(waitAndGetText(confirmationNumberInReviewPage))) {
				result = true;
				System.out.println("Confirmation number is search in Review page");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReviewSearchMenu()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateSearchWithConfNumber ***********************************
	//************************************************************************************************
	public String validateSearchWithConfNumber(String confNum) throws InterruptedException, AWTException {
		try {
			waitAndClick(reviewMenuLnk);
			reviewConfirmationNumberInputBox.sendKeys(confNum);
			waitAndClick(btnSearch);
			String xpathOfConfNum = "//select[@id='Reservations']/option[contains(text(),'"+confNum+"')]";
			scrollDown(driver);
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement ele = driver.findElement(By.xpath(xpathOfConfNum));
			waitAndClick(ele);
			String confNumber = waitAndGetText(confirmationNumberInReviewPage);
			System.out.println("Confirmation Number is generated : "+confNumber);
			return confNumber;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSearchWithConfNumber()");
			return "Issue with Method: validateSearchWithConfNumber()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateReviewMultipleSearchMenu *******************************
	//************************************************************************************************
	public boolean validateReviewMultipleSearchMenu(String storeNum,String confNum,String partyDateFrom,String partyDateTo,String reservationType) throws InterruptedException, AWTException {
		boolean result = false;
		try {
			waitAndClick(reviewMenuLnk);
			if(!storeNum.equals("")){
				reviewStoreNumberInputBox.sendKeys(storeNum);
			}else{
				reviewStoreNumberInputBox.clear();
				reviewStoreNumberInputBox.sendKeys(Keys.ESCAPE);
			}
			if(!confNum.equals("")){
				reviewConfirmationNumberInputBox.sendKeys(confNum);
			}else{
				reviewConfirmationNumberInputBox.clear();
				reviewConfirmationNumberInputBox.sendKeys(Keys.ESCAPE);
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
			if(!reservationType.equals("")){
				if(reservationType.equals("Birthday")){
					selectDrpDwnByIndex(drpReservationType,0);
				}else if(reservationType.equals("FundRaising")){
					selectDrpDwnByIndex(drpReservationType,1);
				}else if(reservationType.equals("Organizational")){
					selectDrpDwnByIndex(drpReservationType,2);
				}
			}
			waitAndClick(btnSearch);
			String xpathOfConfNum = "//select[@id='Reservations']/option[contains(text(),'"+confNum+"')]";
			scrollDown(driver);
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement ele = driver.findElement(By.xpath(xpathOfConfNum));
			waitAndClick(ele);

			if(confNum.equals(waitAndGetText(confirmationNumberInReviewPage))) {
				result = true;
				System.out.println("Confirmation number is found");
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReviewMultipleSearchMenu()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateNewButton **********************************************
	//************************************************************************************************
	public void validateNewButton() throws InterruptedException, AWTException {
		try {
			waitAndClick(newBtn);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNewButton()");
		}
	}
	//*************************************************************************************************
	//*********************Methods to validateChangeButton ********************************************
	//*************************************************************************************************
	public void validateChangeButton() throws InterruptedException, AWTException {
		try {
			waitAndClick(changeBtn);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangeButton()");
		}	
	}
	//************************************************************************************************
	//*********************Methods to validateCancelButton *******************************************
	//************************************************************************************************
	public boolean validateCancelButton() throws InterruptedException, AWTException {
		boolean cancelBtnonpopup = false;
		boolean cancelstatus=false;
		try {
			waitAndClick(cancelBtn);
			Thread.sleep(3000);
			cancelBtnonpopup=cancelreasonBtn.isEnabled();
			if(cancelBtnonpopup==true) {
				cancelreasonInputBox.sendKeys("Party Postponed");
				waitAndClick(cancelreasonBtn);
				System.out.println("Cancel button is clicked");
				Thread.sleep(2000);
				waitAndClick(cancelOkBtn);
			}
			else {
				System.out.println("Cancel popup not displayed");
			}
			cancelstatus= cancelBtn.isEnabled();
			if(cancelstatus=false)
			{
				System.out.println("Cancel button is enabled");
			}
			else {
				System.out.println("Cancel button is disabled");
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateCancelButton()");
		}	
		return false;
	}
	//************************************************************************************************
	//*********************Methods to validateAddDiscRewards *****************************************
	//************************************************************************************************
	public boolean validateAddDiscRewards() throws InterruptedException, AWTException {
		boolean discRewardBtn,trashiconPresent=false;
		try {
			scrollDown(driver);
			scrollDown(driver);
			discRewardBtn=AddDRewardsBtn.isEnabled();
			if(discRewardBtn==true) {
				System.out.println("Add Disc RewardsBtn is enabled");
				waitAndClick(addDRewardsBtn);
				Thread.sleep(2000);
				selectDrpDwnByIndex(discretionaryRewardDropdown,1);
				waitAndClick(addDiscresionaryRewardPopup);
				System.out.println("Disc Rewards is added successfully");
			}
			else {
				System.out.println("Add Disc RewardsBtn is disabled");
			}		   
			trashiconPresent=trashicon.isDisplayed();
			if(trashiconPresent==true) {
				System.out.println("Trash icon is Present");
			}
			else {
				System.out.println("Trash icon is not Present");
			}	

			if(discRewardBtn==true && trashiconPresent==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddDiscRewards()");
		}	
		return false;
	}
	//************************************************************************************************
	//*********************Methods to validateCustAndAgentComments ***********************************
	//************************************************************************************************
	public boolean validateCustAndAgentComments() throws InterruptedException, AWTException {
		try {
			Thread.sleep(1000);
			boolean custComments = reviewcustomerComments.isDisplayed();
			boolean agentComments = reviewagentComments.isDisplayed();

			if(custComments==true && agentComments==true)
			{
				if(reviewcustomerComments.getText().equals(customerComment) && reviewagentComments.getText().equals(agntComment)) {
					System.out.println("Customer and Agent comments are added");	
					return true;
				}
			}
			else
			{
				System.out.println("Customer and Agent comments are not added");	
				return false;
			}

		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateCustAndAgentComments()");
		}
		return false;	
	}
	//***************************************************************************************************
	//***************Methods to validateTotalAmountAndHLref *********************************************
	//***************************************************************************************************
	public boolean validateTotalAmountAndHLref() throws InterruptedException, AWTException {
		boolean hotlineRefNumber,totalAmt = false;
		try {
			scrollDown(driver);
			Thread.sleep(1000);
			scrollDown(driver);
			hotlineRefNumber=hotlineRef.isDisplayed();
			totalAmt= totalAmount.isDisplayed();
			if(hotlineRefNumber = true) {
				System.out.println("Hotline Ref Number is Displayed");
			}
			if(totalAmt = true) {
				System.out.println("totalAmount is Displayed");
			}
			if(hotlineRefNumber&&totalAmt == true)
			{
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateTotalAmountAndHLref()");
		}
		return false;
	}
	//************************************************************************************************
	//***************Methods to validateAlternateStore ***********************************************
	//************************************************************************************************
	public boolean validateAlternateStore() throws InterruptedException, AWTException {
		boolean result = false;
		try {
			String address=null,phonenumber=null;
			selectDrpDwnByIndex(selectAltStore,1);
			Thread.sleep(1000);
			address=altStoreAdddress.getText();
			phonenumber=altStorePhoneNumber.getText();
			if((address.contains("Grapevine, TX - 76051")) && (phonenumber.contains("9726913312"))) {
				System.out.println("Address and Phone number of alternate store is displayed correctly");
				result = true;
			}
			return result;
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAlternateStore()");
			return result;
		}	
	}
	//************************************************************************************************
	//*********************Methods to validateDupRewards *********************************************
	//************************************************************************************************
	public boolean validateDupRewards(String dup) throws InterruptedException, AWTException {
		boolean discRewardBtn,trashiconPresent=false;
		try {
			scrollDown(driver);
			scrollDown(driver);
			discRewardBtn=AddDRewardsBtn.isEnabled();

			if(discRewardBtn==true) {
				System.out.println("Add Disc RewardsBtn is enabled");
				waitAndClick(addDRewardsBtn);
				Thread.sleep(2000);
				selectDrpDwnByIndex(discretionaryRewardDropdown,1);
				waitAndClick(addDiscresionaryRewardPopup);
				System.out.println("Disc Rewards is added successfully");
			}
			else {
				System.out.println("Add Disc RewardsBtn is disabled");
			}		   
			trashiconPresent=trashicon.isDisplayed();
			if(trashiconPresent==true) {
				System.out.println("Trash icon is Present");
				waitAndClick(addDRewardsBtn);
			}
			else {
				System.out.println("Trash icon is not Present");
			}	
			if(discRewardBtn==true && trashiconPresent==true)
			{
				return true;
			}
			else
			{
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDupRewards()");
			return false;
		}	
	}
	//************************************************************************************************
	//*********************Methods to validatePartyTheme *********************************************
	//************************************************************************************************
	public boolean validatePartyTheme(String Selectedthemename) throws InterruptedException, AWTException {
		boolean result = false;
		try {
			String themeNameXpath = "//select/option[text()='"+Selectedthemename+"']";
			String attributeName = driver.findElement(By.xpath(themeNameXpath)).getAttribute("Selected");
			System.out.println("Attribute: "+attributeName);
			if(attributeName.equals("selectettd")) {
				result = true;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePartyTheme()");
			result = false;
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateMinimumChildError  *************************************
	//************************************************************************************************
	public String validateMinimumChildError(String ReservationsType,int timeSlot) throws InterruptedException, AWTException {
		String result=null;
		try {
			if(ReservationsType.equals("Birthday")) {
				selectDrpDwnByIndex(selectReservationsType,1);
				childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				childrenInputBox.sendKeys("5");
				adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				adultInputBox.sendKeys("2");
				Thread.sleep(2000);
				waitAndClick(showCalendarbtn);
				Thread.sleep(1000);
				waitAndClick(showCalendarbtn);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,TestUtil.tubookingDate);
				System.out.println("Date got selected from calender");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				Thread.sleep(1000);
				result = waitAndGetText(errorMsgMinAttendees);
				System.out.println("Minimum Error message displayed");
				Thread.sleep(1000);
			}else if(ReservationsType.equals("Organizational")) {
				selectDrpDwnByIndex(selectReservationsType,3);
				childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				childrenInputBox.sendKeys("10");
				adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
				adultInputBox.sendKeys("2");
				Thread.sleep(2000);
				waitAndClick(showCalendarbtn);
				Thread.sleep(1000);
				waitAndClick(showCalendarbtn);
				Thread.sleep(1000);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,4);
				System.out.println("Date got selected from calender");
				Thread.sleep(1000);
				selectRdoBtn(selectTimeSlotRadiobtn,timeSlot);
				System.out.println("Time slot got selected");
				Thread.sleep(1000);
			}else if(ReservationsType.equals("FundRaiser")) {
				selectDrpDwnByIndex(selectReservationsType,2);
				Thread.sleep(2000);
				waitAndClick(showCalendarbtn);
				Thread.sleep(1000);
				//waitAndClick(showCalendarbtn);
				//Thread.sleep(1000);
				scrollDown(driver);
				Thread.sleep(1000);
				clickOnAvailableDate(driver,4);
				System.out.println("Date got selected from calender");
				Thread.sleep(1000);
				waitAndClick(select3PMTimeSlotRadiobtn);
				System.out.println("Time slot got selected");
				Thread.sleep(1000);
			}
			System.out.println("Date and time selected...................................................................");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMinimumChildError()");
		}
		return result;
	}
	//************************************************************************************************
	//*********************Methods to validateSelectChildBoothOnly  **********************************
	//************************************************************************************************
	//Created By: Monalisa
	public boolean validateSelectChildBoothOnly() throws InterruptedException, AWTException {
		boolean result=false;
		try {
			selectDrpDwnByIndex(selectReservationsType,1);
			childrenInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
			childrenInputBox.sendKeys("75");
			adultInputBox.sendKeys(Keys.CONTROL,"ac",Keys.DELETE);
			adultInputBox.sendKeys("59");
			Thread.sleep(2000);
			waitAndClick(showCalendarbtn);
			Thread.sleep(1000);
			waitAndClick(showCalendarbtn);
			scrollDown(driver);
			Thread.sleep(1000);
			int selectDate = TestUtil.tuOldBookingWeekDayDate;
			//ClickAvailableDate(driver,selectDate);
			//System.out.println("Date got selected from calender");
			//Thread.sleep(1000);
			List<WebElement> dateNum = driver.findElements(By.xpath("//a[text()='"+selectDate+"']"));
			String boothColor="";
			for(int i=0;i<dateNum.size();i++) {
				boothColor = dateNum.get(i).getCssValue("background-color");
				break;
			}
			System.out.println("color ::"+boothColor);
			String boothHex = Color.fromString(boothColor).asHex();
			System.out.println("booth color : "+boothHex);
			//  "#00bfff" means "sky-blue" color(booth color) #00bfff
			if (boothHex.equals("#00bfff")) {
				result=true;
			}
			if(result==true)
			{
				System.out.println("booking is available for Booth only");
				return result;
			}
			else{
				System.out.println("booking is not available at all booking");
				return result;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildBoothOnly()");
			return result;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateEditFieldsReviewPage  **********************************
	//************************************************************************************************
	//Created By: Monalisa
	public boolean validateEditFieldsReviewPage(String confNum) throws AWTException, InterruptedException {
		boolean result = false;
		try {
			waitAndClick(next1Btn);
			String nameString = getSaltString();
			String emailString = getSaltEmail();
			String addrsString = getSaltString();
			String phoneNum = getSaltNumber();
			System.out.println(nameString);
			System.out.println(emailString);
			System.out.println(addrsString);
			System.out.println(phoneNum);
			customerNameInputBox.clear();
			customerNameInputBox.sendKeys(nameString);
			emailidInputBox.clear();
			emailidInputBox.sendKeys(emailString);
			phonenoInputBox.clear();
			phonenoInputBox.sendKeys(phoneNum);
			waitAndClick(next2Btn);
			scrollDown(driver);
			waitAndClick(bookBtn);
			waitAndClick(reviewMenuLnk);
			reviewConfirmationNumberInputBox.sendKeys(confNum);
			waitAndClick(btnSearch);
			String xpathOfConfNum = "//select[@id='Reservations']/option[contains(text(),'"+confNum+"')]";
			scrollDown(driver);
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement ele = driver.findElement(By.xpath(xpathOfConfNum));
			waitAndClick(ele);
			String nameInReviewPage = nameTxtBox.getText();
			String phnInReviewPage = phnTxtBox.getText();
			String emailInReviewPage = emailTxtBox.getText();
			System.out.println(nameInReviewPage);
			System.out.println(phnInReviewPage);
			System.out.println(emailInReviewPage);
			if (nameString.equals(nameInReviewPage) && phoneNum.equals(phnInReviewPage) && emailString.equals(emailInReviewPage)) {
				result =true;
			} else {
				result = false;
				System.out.println();
				System.out.println("Issue with Method: validateEditFieldsReviewPage()");
			}
			return result;		
		} catch (Exception e) {
			System.out.println("Issue with Method: validateEditFieldsReviewPage()");
			e.printStackTrace();
			return result;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateEditFieldsOnReviewPage  ********************************
	//************************************************************************************************
	//Created By: Vishnu
	public boolean validateEditFieldsOnReviewPage(String confNum) throws AWTException, InterruptedException {
		boolean result = false;
		try {
			String newName = getSaltString();
			String newPhone = getSaltNumber();
			//String newEmail = getSaltEmail();
			waitAndClick(nameEditIcon);
			enterDataUsingRobot(newName);
			waitAndClick(phoneEditIcon);
			enterPhoneNumberUsingRobot(newPhone);
			//waitAndClick(emailEditIcon);
			//enterDataUsingRobot(newEmail);
			waitAndClick(saveChangesBtn);
			Thread.sleep(3000);
			waitAndClick(recordSavedOKBtn);
			String savedName = waitAndGetText(nameValue);
			String savedPhone = waitAndGetText(phoneValue);
			System.out.println("Saved Name: "+savedName+"   Saved Phone: "+savedPhone);
			if(newName.equals(savedName) && newPhone.equals(savedPhone)){
				result = true;		
			}else{
				result = false;
			}
			return result;
		} catch (Exception e) {
			System.out.println("Issue with Method: validateEditFieldsOnReviewPage()");
			e.printStackTrace();
			return result;
		}
	}

	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%
	//                                       AGENT LOGIN RELATED METHODS
	//%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%%

	//************************************************************************************************
	//*********************Methods to validateAgentLogin *********************************************
	//************************************************************************************************
	public void validateAgentLogin() throws InterruptedException, AWTException {
		try {
			waitAndClick(userMenuLink);
			loginNameInputBox.sendKeys("abaliga");
			loginNameInputBox.sendKeys(Keys.ENTER);
			Thread.sleep(1000);
			selectDrpDwnByIndex(userRoleDropdownList,0);
			userRoleDropdownList.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(2000);
			waitAndClick(saveBtn);
			Thread.sleep(2000);
			waitAndClick(logoutBtn);
			Thread.sleep(5000);
			waitAndClick(logoutOKBtn);
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAgentLogin()");
		}	
	}
	//************************************************************************************************
	//*********************Methods to validateDiscRewards ********************************************
	//************************************************************************************************
	public boolean validateDiscRewards() throws InterruptedException, AWTException {
		boolean discRewardBtn;
		try {
			scrollDown(driver);
			scrollDown(driver);
			discRewardBtn=AddDRewardsBtn.isEnabled();
			if(discRewardBtn==true) {
				System.out.println("Add Disc RewardsBtn is enabled");
				return true;
			}else{
				System.out.println("Add Disc RewardsBtn is disabled");
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDiscRewards()");
			return false;
		}	
	}
	//************************************************************************************************
	//*********************Methods to validateCurrentdayForAgent *************************************
	//************************************************************************************************
	public boolean validateCurrentdayForAgent() throws InterruptedException, AWTException {
		try {
			boolean currentdaydate= true;
			selectDrpDwnByIndex(selectReservationsType,1);
			childrenInputBox.clear();
			childrenInputBox.sendKeys("5");
			adultInputBox.clear();
			adultInputBox.sendKeys("2");
			waitAndClick(showCalendarbtn);
			Thread.sleep(1000);
			waitAndClick(showCalendarbtn);
			Thread.sleep(1000);
			scrollDown(driver);
			Thread.sleep(3000);
			if(selectcalanderDate.isSelected()) {
				currentdaydate=true;
				System.out.println("Date is enabled for Currentday");
			}else {
				System.out.println("Date is disabled for Currentday");
				currentdaydate=false;				
			}
			return currentdaydate;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateCurrentdayForAgent()");
			return true;
		}
	}
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER METHODS END	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
}
