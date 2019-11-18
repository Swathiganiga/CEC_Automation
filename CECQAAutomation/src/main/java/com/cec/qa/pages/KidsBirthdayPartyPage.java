package com.cec.qa.pages;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;
public class KidsBirthdayPartyPage extends BaseTest{

	//************************************************************************************************
	//*********************Brand site menu locators***************************************************
	//************************************************************************************************

	@FindBy(xpath="//a[contains(text(),'   Birthday')]")
	WebElement mainMenuBirthday;

	@FindBy(xpath="//ul[@class='dropdown-menu fade']/li/a[text()='Kids Birthday Parties']")
	WebElement subMenuBKidsBirthdayParty;

	//************************************************************************************************
	//*********************CHANGE LOCATION************************************************************
	//************************************************************************************************

	//@FindBy(xpath="//span[text()='Choose a location']")
	//WebElement changeLocationLink;

	@FindBy(xpath="//span[text()='Choose a location']")
	WebElement changeLocationLink1;

	@FindBy(xpath="//span[text()='Change location']")
	WebElement changeLocationLink2;

	@FindBy(xpath="//form[@id='locationSearch']/input[@name='location']")
	WebElement locationSearchBox;

	@FindBy(xpath="//button[@id='locationSubmit']")
	WebElement searchIcon;

	@FindBy(xpath="//h3[@id='noSearchResults']")
	WebElement noSearchResults;

	@FindBy(xpath="//input[@id='locationInput']")
	WebElement findALocation;

	@FindBy(xpath="//div[contains(@class, 'address')]")
	WebElement locationAddress;

	//************************************************************************************************
	//*********************CHANGE LOCATION - SELECT STORE*********************************************
	//************************************************************************************************

	@FindBy(xpath="(//a[text()='Select Store'])[1]")
	WebElement selectFirstStoreBtn;

	@FindBy(xpath="(//address)[1]")
	WebElement firstStoreAddressText;
	//************************************************************************************************
	//*********************A Package to Fit Every Party and Budget - SELECT PACKAGE*******************
	//************************************************************************************************

	@FindBy(xpath="//a[@id='tabbedContent-CTA3']/span[text()='Book Now']")
	WebElement bookNowStarBtn;

	@FindBy(xpath="//a[@id='tabbedContent-CTA2']/span[text()='Book Now']")
	WebElement bookNowSuperStarBtn;

	@FindBy(xpath="//a[@id='tabbedContent-CTA1']/span[text()='Book Now']")
	WebElement bookNowMegaStarBtn;

	//************************************************************************************************
	//*********************BOOK A BIRTHDAY - SELECT CHILD,ADULT & DATE********************************
	//************************************************************************************************

	@FindBy(xpath="//select[@id='select_children_entryPage']")
	WebElement childrenListBox;

	@FindBy(xpath="//select[@id='select_children_entryPage']//option[@id='children_10_entryPage']")
	WebElement tenChildrenListItem;

	@FindBy(xpath="//select[@id='select_children_entryPage']//option[@id='children_4_entryPage']")
	WebElement fourChildrenListItem;

	@FindBy(xpath="//select[@id='select_children_entryPage']//option[@id='children_100_entryPage']")
	WebElement hundredChildrenListItem;

	@FindBy(xpath="//select[@id='select_adult_entryPage']")
	WebElement adultListBox;


	@FindBy(xpath="//select[@id='select_adult_entryPage']//option[@id='adult_10_entryPage']")
	WebElement tenAdultListItem;

	@FindBy(xpath="//select[@id='select_adult_entryPage']//option[@id='adult_1_entryPage']")
	WebElement oneAdultListItem;

	@FindBy(xpath="//select[@id='select_adult_entryPage']//option[@id='adult_50_entryPage']")
	WebElement fiftyAdultListItem;

	@FindBy(xpath=" //input[@id='date_inputfield_entryPage']")
	WebElement dateInputbox;

	@FindBy(xpath="//button[@class='btn--primary btn--purple']")
	WebElement seeAvailablity;

	//Validate Book A Birthday missing alert message
	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement childrenAlertMsg;

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement adultAlertMsg;

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement partydateAlertMsg;

	//************************************************************************************************
	//*********************SELECT A DATE & TIME - SELECT PACKAGE OR TIME SLOT*************************
	//************************************************************************************************

	@FindBy(xpath="(//button[@title='Select Package'])[1]")
	WebElement selectPackageStar;

	@FindBy(xpath="(//button[@title='Select Package'])[2]")
	WebElement selectPackageSuperStar;

	@FindBy(xpath="(//button[@title='Select Package'])[3]")
	WebElement selectPackageMegaStar;

	@FindBy(xpath="(//div[@class='price__inner is-vip'])[1]")
	WebElement selectVIPMegaStarSlot;

	@FindBy(xpath="(//button[@title='Select Package'])[1]")
	WebElement selectPackageVIPMegaStar;

	@FindBy(xpath="(//div[@class='SUPER'])[1]")
	WebElement selectSuperStarPackage;
	
	@FindBy(xpath="(//div[@class='col-sm-12 SUPER'])")
	WebElement updateSuperStarPackage;

	@FindBy(xpath="//button[@title='Remove Child']")
	WebElement removeChild;

	@FindBy(xpath="//button[@title='Add Child']")
	WebElement addChild;

	@FindBy(xpath="//button[@title='Remove Adult']")
	WebElement removeAdult;

	@FindBy(xpath="//button[@title='Add Adult']")
	WebElement addAdult;

	@FindBy(xpath="//a[contains(text(),'Apply changes')]")
	WebElement applyChanges;

	@FindBy(xpath="(//h2[text()='This Time Slot Is No Longer Available'])[1]")
	WebElement timeSlotNoLongerAvailableMsg;

	@FindBy(xpath="//ul[@class='calendar-select']/li[2]")
	WebElement currentSelectDatePlusOne;	

	@FindBy(xpath="(//button[@title='Select Package'])[33]")
	WebElement selectPackageMegaStar1;

	@FindBy(xpath="(//div[@class='price__inner'])[29]")
	WebElement selectSuperStarPackage1;

	@FindBy(xpath="(//button[@title='Select Package'])[29]")
	WebElement selectPackageSuperStar1;

	//*****************************************************************************
	//Default Party items
	@FindBy(xpath="//*[@id=\"calendarStep\"]/div[2]/div[2]/div[2]/div/div/ul/li[3]")
	WebElement partyitem;

	//Up sell pop-up

	@FindBy(xpath="//button[text()='No Thanks']")
	WebElement upSellNoThanks;

	String upSellNoThanksXpath = "//button[text()='No Thanks']";

	@FindBy(xpath="//*[contains(text(),'Upgrade!')]")
	WebElement upSellUpgrade;

	String upSellUpgradeXpath="//*[contains(text(),'Upgrade!')]";

	//************************************************************************************************
	//*********************CONTACT INFORMATION - Birthday Star and Contact Info***********************
	//************************************************************************************************

	//BirthDay Star

	@FindBy(xpath="//input[@id='guestName-0']")
	WebElement childName;

	@FindBy(xpath="//input[@id='age-0']")
	WebElement childAge;

	@FindBy(xpath="//select[@id='gender-0']")
	WebElement genderListBox;

	@FindBy(xpath="//select[@id='gender-0']/option[contains(text(),'Male')]")
	WebElement genderMale;

	@FindBy(xpath="//select[@id='gender-0']/option[contains(text(),'Female')]")
	WebElement genderFemale;

	//Additional BirthDay Star

	@FindBy(xpath="//*[@id=\"addStar\"]/div")
	WebElement AdditionalchildLink;

	@FindBy(xpath="//input[@id='guestName-1']")
	WebElement childName1;

	@FindBy(xpath="//input[@id='age-1']")
	WebElement childAge1;

	@FindBy(xpath="//select[@id='gender-1']")
	WebElement genderListBox1;

	@FindBy(xpath="//select[@id='gender-1']/option[contains(text(),'Male')]")
	WebElement genderMale1;

	@FindBy(xpath="//select[@id='gender-1']/option[contains(text(),'Female')]")
	WebElement genderFemale1;

	@FindBy(xpath="//input[@id='guestName-2']")
	WebElement childName2;

	@FindBy(xpath="//input[@id='age-2']")
	WebElement childAge2;

	@FindBy(xpath="//select[@id='gender-2']")
	WebElement genderListBox2;

	@FindBy(xpath="//select[@id='gender-2']/option[contains(text(),'Male')]")
	WebElement genderMale2;

	@FindBy(xpath="//select[@id='gender-2']/option[contains(text(),'Female')]")
	WebElement genderFemale2;

	//Contact Information page

	@FindBy(xpath="//input[@name='adultName']")
	WebElement adultName;

	@FindBy(xpath="//label[text()='Phone']")
	WebElement adultPhone;

	@FindBy(xpath="//input[@id='email']")
	WebElement adultEmail;

	@FindBy(xpath="//textarea[@id='SpecialInstructions']")
	WebElement specialInstructions;

	@FindBy(xpath="//label[text()='In store within 48 hours']")
	WebElement inStoreRadioBtn;

	@FindBy(xpath="//div[@class='col-sm-12']/input")
	WebElement offLineCheckBox;

	//@FindBy(xpath="//div[text()='Complete Reservation']")
	//WebElement completeReservation;

	@FindBy(xpath="//*[@id='Layer_1']") //alternative for complete reservations locator.
	WebElement completeReservation;

	@FindBy(xpath="//h3[text()='Payment Information']")
	WebElement justToClickOnPageBeforeScroll;

	@FindBy(xpath="//div[@class='summary__package clearfix']/p")
	WebElement yourPackage;

	@FindBy(xpath="//p[contains(text(),'Additional Birthday Star')]")
	WebElement additionalBirthdayStar;

	//Contact Information page - Credit Card Details


	@FindBy(xpath="//label[text()='With my debit/credit card']")
	WebElement creditCardRadioBtn;

	@FindBy(xpath="//input[@id='billName']")
	WebElement billerName;

	@FindBy(xpath="//input[@id='billAddress']")
	WebElement billerAddress;

	@FindBy(xpath="//input[@id='billCity']")
	WebElement billerCity;

	@FindBy(xpath="//input[@id='billState']")
	WebElement billerState;

	@FindBy(xpath="//input[@id='billZip']")
	WebElement billerZipCode;

	@FindBy(xpath="//input[@id='billCard']")
	WebElement creditCardNumber;

	@FindBy(xpath="//input[@id='billExp']")
	WebElement creditCardExpiryDate;

	@FindBy(xpath="//input[@id='billCVV']")
	WebElement creditcardCvvNumber;

	//************************************************************************************************
	//*********************YOUR RESERVATION SUMMARY - Conf/Cancel/Update/Upsell***********************
	//************************************************************************************************

	//Validate Contact info missing alert message
	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement childNameAgeAndGenderAlertMsg;


	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement adultNameAlertMsg;


	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement phoneNumberAlertMsg;


	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement emailIdAlertMsg;


	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement instoreCheckBoxAlertMsg;


	//*****************************************************************************	
	//Your reservation summary page

	@FindBy(xpath="(//p[contains(text(),'Confirmation #')])[2]")
	WebElement confirmationNumber;

	String confirmationNumberXPath = "(//p[contains(text(),'Confirmation #')])[2]";

	//Final Upsell Popup Window

	@FindBy(xpath="//a[@class='upsell-close closeUpsellAllYouCanPlay']")
	WebElement closeFinalUpSellPopUpWindow;

	//Update Upsell Quantity

	@FindBy(xpath="//div[@id='slick-slide00']//button[@title='Item Increase']")
	WebElement addQuantityForPizza;

	@FindBy(xpath="//div[@id='slick-slide00']//button[@title='Item Decrease']")
	WebElement removeQuantityForPizza;

	@FindBy(xpath="//div[@id='slick-slide00']//a[contains(text(),' Update Cart ')]")
	WebElement updateQuantity;

	//Update Child and Adult

	@FindBy(xpath="//button[@title='Child Decrease']")
	WebElement decreaseChild;

	@FindBy(xpath="//button[@title='Child Increase']")
	WebElement increaseChild;

	@FindBy(xpath="//button[@title='Adult Decrease']")
	WebElement decreaseAdult;

	@FindBy(xpath="//button[@title='Adult Increase']")
	WebElement increaseAdult;

	//Update Booking

	@FindBy(xpath="//a[text()='Change location']")
	WebElement changeLocation; 

	@FindBy(xpath="//a[text()=' Update Contact or Birthday Star Information']")
	WebElement updateContactOrBirthdayStarInfo; 

	@FindBy(xpath="//a[text()='Update Contact Information']")
	WebElement updateContactInfoLink;

	@FindBy(xpath="//a[text()='Edit Time and/or Date']")
	WebElement updatedateandtimeLink;

	@FindBy(xpath="//a[text()='Change/Upgrade']")
	WebElement changePackageLink;

	@FindBy(xpath="//a[text()='Send Free Party Invitations']")
	WebElement sendPartyInvitationsLink;

	@FindBy(xpath="//img[@class='logo']")
	WebElement sendInvitationsLogo;

	@FindBy(xpath="//div[@class='summary__partyDate']/p")
	WebElement dateInConfirmationPage;

	//Reservation Summary validate Info
	@FindBy(xpath="//p[contains(text(),'John (6 yrs)')]")
	WebElement bstarinfo;

	@FindBy(xpath="//p[contains(text(),'SUPER STAR')]")
	WebElement modifiedPackageName;

	@FindBy(xpath="//div[@class='summary__partyDate']/p")
	WebElement modifiedDate;

	//Cancel Booking

	@FindBy(xpath="//a[@class='cancel-close']")
	WebElement closeCancelPopupWindow;

	@FindBy(xpath="//a[text()='Cancel Reservation']")
	WebElement cancelReservationLink;

	@FindBy(xpath="//button[@class='btn--primary btn--purple cancelRes']")
	WebElement confirmConcelReservationBtn;

	@FindBy(xpath="//h3[text()='You have successfully cancelled your reservation']")
	WebElement cancelConfirmationMsg;

	@FindBy(xpath="//h3[text()='Are you sure you want to cancel this reservation?']")
	WebElement cancelWindowTitle;

	@FindBy(xpath="//p/a[text()='here']")
	WebElement clickHereToHomePageLink;

	//Duplicate check Window Locators

	@FindBy(xpath="//h3[text()='Potential Duplicates']")
	WebElement duplicateHeader;

	@FindBy(xpath="//button[@class='btn--primary btn--purple duplicateSubmit']")
	WebElement duplicateWindowNewReservationBtn;

	@FindBy(xpath="//a[@class='duplicate-close']")
	WebElement duplicateWindowClose;

	@FindBy(xpath="//strong[contains(text(),'#')]")
	WebElement duplicateConfirmationNumber;

	@FindBy(xpath="//strong[containt(text(),'-')]")
	WebElement duplicateDate;

	@FindBy(xpath="//p[contains(text(),'We have found potential duplicate bookings. Please review the parties below before proceeding')]")
	WebElement duplicateMessageWindowText;


	//************************************************************************************************
	//*********************Header and Footer link ****************************************************
	//************************************************************************************************

	//Header and Footer link

	@FindBy(xpath="/html/body/div[1]/nav/a/img")
	WebElement cecLogo;

	@FindBy(xpath="//a[text()='Terms & Privacy | ']")
	WebElement footerlink;

	//**************************************************
	//Error Message
	//

	@FindBy(xpath="//h4[text()='You cannot book a party more than 90 days in advance']")
	WebElement errorMsgAt90days;

	@FindBy(xpath="//h4[text()='Your reservation has been updated']")
	WebElement confmsg;

	@FindBy(xpath="//h4[text()='This time slot does not support your party size']")
	WebElement errorMsgAtConfirmationPage;

	@FindBy(xpath="//h4[text()='This time slot does not support your party size']")
	WebElement errorMsgAtPaymentsPage;

	@FindBy(xpath="//h4[text()='You cannot book a party with less than 10 children']")
	WebElement errorMsgVIPTimeslotLessAttendees;

	@FindBy(xpath="//h4[text()='Could not process the credit card. Check your information and try again.']")
	WebElement errorMsgInvalidCreditcardInformation;

	//***********************************************************************************

	//Cancel Booking at FIND YOUR RESERVATION page

	@FindBy(xpath="//*[@name='confNumber']")  
	WebElement ReservationNumber;

	@FindBy(xpath="//div[@class='col-sm-5']")
	WebElement confNumberLabel;

	@FindBy(xpath="//input[@id='confNumber']")
	WebElement confNumber;


	@FindBy(xpath="//input[@name='contEmail']")
	WebElement confirmationMailID;

	@FindBy(xpath="//*[@name='resDate']")
	WebElement BookingDate;

	@FindBy(xpath="//*[@name='Layer 1']")
	WebElement FindPartyButton;

	//**************************************************************************

	// Payment verification //- Vijei Balaji 

	@FindBy(xpath="//p[contains(text(),'Children')]")
	WebElement Childrens_count;

	@FindBy(xpath="//div[@data-type='STAR'] //span[@class='price']")
	WebElement STAR_price;

	@FindBy(xpath="//div[@data-type='SUPER STAR'] //span[@class='price']")
	WebElement SUPERSTAR_price;

	@FindBy(xpath="//div[@data-type='MEGA SUPER STAR '] //span[@class='price']")
	WebElement MEGASUPERSTAR_price;

	@FindBy(xpath="//div[@data-type='VIP MEGA SUPER STAR'] //span[@class='price']")
	WebElement VIPMEGASUPERSTAR_price;


	//************************************************************************************************
	//*********************LOCATORS Initialization****************************************************
	//************************************************************************************************

	public KidsBirthdayPartyPage(){
		PageFactory.initElements(driver, this);
	}

	//************************************************************************************************
	//*********************Methods to validate Search Location****************************************
	//************************************************************************************************
	public void validateSearchLocation(String cLocation) throws InterruptedException {
		try{
			Thread.sleep(2000);
			scrollDown(driver);
			scrollDown(driver);
			if(waitAndGetText(changeLocationLink1).contains("Change")){
				waitAndClick(changeLocationLink2);
			}else{
				waitAndClick(changeLocationLink1);
			}
			locationSearchBox.sendKeys(Keys.CONTROL, "a");
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
				locationSearchBox.sendKeys(cLocation);
			}
			Thread.sleep(1000);
			Actions act = new Actions(driver);
			act.moveToElement(searchIcon).click().perform();
			System.out.println("SELECT LOCATION SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with method:  validateSearchLocation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Store*******************************************
	//************************************************************************************************
	public void validateSelectStore() throws InterruptedException {
		try {
			scrollDown(driver);
			selectFirstStoreBtn.click();
			System.out.println("SELECT STORE SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Methods: validateSelectStore()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Store By City,State and Zip Code **********************
	//************************************************************************************************
	public boolean validateFirstStoreCityStateAndZip(String cLocation) throws InterruptedException {
		try{
			boolean x = false;
			String storeAddress = firstStoreAddressText.getText();
			storeAddress = storeAddress.toLowerCase();
			cLocation = cLocation.toLowerCase();
			if(storeAddress.contains(cLocation)) {
				x = true;
			}else {
				x = false;
			}
			System.out.println("Store Address/Location:"+storeAddress);
			System.out.println("FIRST STORE FOUND......................................................................!!!!!!!!!!!");
			return x;

		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateFirstStoreCityStateAndZip()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Find A Location****************************************
	//************************************************************************************************
	public void validateFindLocation(String cLocation) throws InterruptedException {
		try{
			Thread.sleep(2000);
			scrollDown(driver);
			scrollDown(driver);
			findALocation.click();
			locationSearchBox.sendKeys(Keys.CONTROL, "a");
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
				locationSearchBox.sendKeys(cLocation);
			}
			Thread.sleep(1000);
			Actions act = new Actions(driver);
			act.moveToElement(searchIcon).click().perform();
			//click on Search icon by id
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			System.out.println("CHANGE LOCATION SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateFindLocation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Location Address **************************************
	//************************************************************************************************
	public boolean validateLocationAddress(String cLocation) throws InterruptedException {
		try{
			boolean x = false;
			String storeAddress = locationAddress.getText();
			storeAddress = storeAddress.toLowerCase();
			cLocation = cLocation.toLowerCase();
			if(storeAddress.contains(cLocation)) {
				x = true;
			}else {
				x = false;
			}
			System.out.println("Store Address/Location:"+storeAddress);
			System.out.println("Address Matched......................................................................!!!!!!!!!!!");
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateLocationAddress()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate No Store Found Message*************************
	//************************************************************************************************
	public String validateNoStoreAvailableMsg(String cLocation) throws InterruptedException{
		try{
			String locationMsg;
			Thread.sleep(2000);
			scrollDown(driver);
			scrollDown(driver);
			if(waitAndGetText(changeLocationLink1).contains("Change")){
				waitAndClick(changeLocationLink2);
			}else{
				waitAndClick(changeLocationLink1);
			}
			locationSearchBox.sendKeys(Keys.CONTROL, "a");
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
				locationSearchBox.sendKeys(cLocation);
			} 
			Thread.sleep(1000);
			Actions act = new Actions(driver);
			act.moveToElement(searchIcon).click().perform();
			//click on Search icon by id
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			Thread.sleep(3000);
			((JavascriptExecutor)driver).executeScript("document.getElementById('locationSubmit').click();");
			locationMsg = noSearchResults.getText();
			System.out.println("NO SEARCH RESULTS/INVALID LOCATION:"+locationMsg);
			System.out.println("NO STORES FOUND......................................................................!!!!!!!!!!!");
			return locationMsg;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoStoreAvailableMsg()");
			return "Issue with Method: validateNoStoreAvailableMsg()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Choose Package*****************************************
	//************************************************************************************************
	public void validateChoosePackage(String bPackage) throws InterruptedException {
		try{
			Thread.sleep(1000);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			if(bPackage.equals("SuperStar"))
			{
				waitAndClick(bookNowSuperStarBtn);
			}
			else if(bPackage.equals("MegaStar"))
			{

				waitAndClick(bookNowMegaStarBtn);
			}
			else
			{
				waitAndClick(bookNowStarBtn);
			}
			System.out.println("CHOOSE PACKAGE is ");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChoosePackage()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Child, Adult and Date***************************
	//************************************************************************************************
	public void validateSelectChildAdultAndDate(int bookingDate) throws InterruptedException, AWTException {
		try{
			Thread.sleep(3000);
			childrenListBox.click();
			tenChildrenListItem.click();
			adultListBox.click();
			tenAdultListItem.click();
			Thread.sleep(1000);
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			Thread.sleep(1000);
			//New code it check browser, if  its browser it called different robo base method.
			if(propv.getProperty("GUI").equals("chrome")){
				enterDateUsingRobotForChrome(bookingDate);
			}else{
				enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			}
			Thread.sleep(1000);
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Maximum Child, Adult and Date*******************
	//************************************************************************************************
	public void validateSelectMaxChildAdultAndDate(int bookingDate) throws InterruptedException, AWTException {
		try{
			Thread.sleep(3000);
			childrenListBox.click();
			hundredChildrenListItem.click();
			adultListBox.click();
			fiftyAdultListItem.click();
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			//New code it check browser, if  its browser it called different robo base method.
			if(propv.getProperty("GUI").equals("chrome")){
				enterDateUsingRobotForChrome(bookingDate);
			}else{
				enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			}
			Thread.sleep(1000);
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectMaxChildAdultAndDate()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Book A Birthday Minimum and Maximum value fields*******
	//************************************************************************************************
	public boolean validateBirthdayPartyBookABirthdayPageMinMaxValue() throws InterruptedException, AWTException {
		Thread.sleep(2000);
		boolean x = false;
		try{
			childrenListBox.click();
			fourChildrenListItem.click();
			Thread.sleep(2000);
			hundredChildrenListItem.click();
			Thread.sleep(2000);
			adultListBox.click();
			oneAdultListItem.click();
			Thread.sleep(2000);
			fiftyAdultListItem.click();
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			x=true;
		}catch(Exception e){
			System.out.println("Found: Child/Aduilt Min Max List item Issue");
			x=false;
		}
		System.out.println("MIN/MAX OF CHILD/ADULT SUCCESS......................................................................!!!!!!!!!!!");
		System.out.println("MIN/MAX of Child/Adult Check:"+x);
		return x;
	}

	//************************************************************************************************
	//*********************Methods to validate Select Package Or Time slot****************************
	//************************************************************************************************
	public String validateSelectPackageORTimeSlot(String BasePKG, String Upgrade, String person, int cCount) throws InterruptedException {
		try{
			String alertMessage = null;
			if(cCount==0) {
				if(BasePKG.equals("Star")) {
					selectAvailableTimeSlot(BasePKG);
					alertMessage = "true"; //this assignment for test case 4962:Verify that the first available timeslot for the given party type is expanded automatically.
				}else if(BasePKG.equals("SuperStar")) {
					selectAvailableTimeSlot(BasePKG);
				}else if(BasePKG.equals("MegaStar")) {
					selectAvailableTimeSlot(BasePKG);
				}else {
					System.out.println("Invalid PKG entry given at method: validateSelectPackageORTimeSlot");
				}

				Thread.sleep(3000);

				if(Upgrade.equals("YES") && !BasePKG.equals("MegaStar")) 
				{
					chooseUpSellUpgrade(upSellUpgrade,upSellUpgradeXpath); //WebElement and xpath
				}else if(Upgrade.equals("NO") && !BasePKG.equals("MegaStar")) 
				{
					sayNoThanksToUpSell(upSellNoThanks,upSellNoThanksXpath);//WebElement and Xpath
				}else {
					System.out.println("Invalid Option given at Methods: validateSelectPackageORTimeSlot, "
							+ "second parameter should be YES or NO for Upgrade pop-up. "
							+ "OR You might be chosen MegaStar, No Upgrade pop-up expected.");
				}
			}

			//NOTE: IF Part checks min/max count of adullt and child validation given or not, else will continue booking.
			if(person.equals("Child")) {
				if(cCount <= 4)
				{
					addORRemoveChildORAdult(removeChild,7);
				}
				if(cCount >= 100)
				{
					addORRemoveChildORAdult(removeChild,cCount);
				}
				alertMessage = switchToAlertAndAcceptReturnTitle();

			}else if(person.equals("Adult") && !(cCount==300)) {
				if(cCount <= 1)
				{
					addORRemoveChildORAdult(removeAdult,10);
				}
				if(cCount >= 100)
				{
					addORRemoveChildORAdult(removeChild,cCount);
				}

				alertMessage = switchToAlertAndAcceptReturnTitle();
			}else if(cCount == 300){
				addORRemoveChildORAdult(addAdult,300); 
			}else{
				System.out.println("**********VVVVVVVVVVVVVVVVVVVVVVVVV**********");
			}

			System.out.println("SELECT PACKAGE OR TIME-SLOT SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return alertMessage;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectPackageORTimeSlot()");
			return "Issue with Method: validateSelectPackageORTimeSlot()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate VIP Package Or TimeSlot *******************************
	//************************************************************************************************
	public String validateSelectVIPPackageORTimeSlot(int aCount) throws InterruptedException {
		try{
			String x = null;
			Thread.sleep(5000);
			scrollDown(driver);
			waitAndClick(selectVIPMegaStarSlot);
			if(aCount==0) {
				Thread.sleep(5000);
				waitAndClick(selectPackageVIPMegaStar);
			}else if(aCount==1) {
				Thread.sleep(5000);
				addORRemoveChildORAdult(addAdult,200); 
				applyChanges.click();
				x = timeSlotNoLongerAvailableMsg.getText();	
			}else if(aCount==2) {
				Thread.sleep(5000);
				scrollUp(driver);
				addORRemoveChildORAdult(removeChild,2); 
				applyChanges.click();
				Thread.sleep(5000);
				scrollDown(driver);
				waitAndClick(selectPackageVIPMegaStar);
				x = errorMsgVIPTimeslotLessAttendees.getText();
			}
			System.out.println("The Message text displayed as: "+x);
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectVIPPackageORTimeSlot()");
			return "Issue with Method: validateSelectVIPPackageORTimeSlot()";
		}
	} 

	//************************************************************************************************
	//*********************Methods to validate Birthday Star Information******************************
	//************************************************************************************************
	public boolean validateBirthdayStarInformation(int birthdayStar) throws InterruptedException, AWTException {
		try{
			boolean starInfoEntry = false;
			Thread.sleep(2000);
			childName.sendKeys(getSaltString());
			Thread.sleep(1000);
			childAge.sendKeys("10");
			Thread.sleep(1000);
			genderListBox.click();
			Thread.sleep(1000);
			genderMale.click();
			Thread.sleep(1000);
			System.out.println("BIRTHDAY STAR INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			scrollDown(driver);
			//validate Additional Birthday Star Information
			if(birthdayStar>=1) {

				if(birthdayStar==1) {
					Thread.sleep(1000);
					AdditionalchildLink.click();
					childName1.sendKeys(getSaltString());
					Thread.sleep(1000);
					childAge1.sendKeys("10");
					Thread.sleep(1000);
					genderListBox1.click();
					Thread.sleep(1000);
					genderMale1.click();
					Thread.sleep(1000);
				}else if(birthdayStar==2) {
					Thread.sleep(1000);
					AdditionalchildLink.click();
					childName2.sendKeys(getSaltString());
					Thread.sleep(1000);
					childAge2.sendKeys("10");
					Thread.sleep(1000);
					genderListBox2.click();
					Thread.sleep(1000);
					genderMale.click();
				}
				System.out.println("ADDITIONAL KID NAME AGE GENDER SUCCESS...........................................!");
			}
			starInfoEntry = true;
			return starInfoEntry;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayStarInformation()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Additional Birthday Star Information*******************
	//************************************************************************************************	
	public String validateAdditionalBirthdayStar(int birthdayStar) throws InterruptedException, AWTException {
		try{
			String x = null;
			if(birthdayStar>=1) {
				x = additionalBirthdayStar.getText();
			}else if(birthdayStar>=2)  {
				//Not yet designed........
			}
			System.out.println("ADDITIONAL BIRTHDAY STAR INFO VALIDATION SUCCESS......................................................................!!!!!!!!!!!");		
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateAdditionalBirthdayStar()");
			return "Issue with Method: validateAdditionalBirthdayStar()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Contact Information************************************
	//************************************************************************************************
	public void validateContactInformation(String toCheckBooking) throws InterruptedException, AWTException {
		try{
			if(toCheckBooking.equals("YES")){
				adultName.sendKeys(propv.getProperty("bName"));
				Thread.sleep(1000);
				adultName.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot(propv.getProperty("bPhone"));
				Thread.sleep(1000);
				adultEmail.sendKeys(propv.getProperty("bEmail"));
				Thread.sleep(1000);
				specialInstructions.sendKeys(getSaltString());
				Thread.sleep(1000);
				scrollDown(driver);
			}else{
				adultName.sendKeys(getSaltString());
				Thread.sleep(1000);
				adultName.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot("");
				Thread.sleep(1000);
				adultEmail.sendKeys(getSaltEmail());
				Thread.sleep(1000);
				specialInstructions.sendKeys(getSaltString());
				Thread.sleep(1000);
				scrollDown(driver);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validateDynamicContactInformation*******************************
	//************************************************************************************************
	public void  validateDynamicContactInformation() throws InterruptedException, AWTException {
		try{
			adultName.sendKeys(getSaltString());
			Thread.sleep(1000);
			adultName.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(1000);
			adultEmail.sendKeys(getSaltEmail());
			Thread.sleep(3000);
			// Copy the mail id from page by using Keys Chord //
			validateGetTextOfElement(adultEmail);
			Thread.sleep(1000);
			specialInstructions.sendKeys(getSaltString());
			Thread.sleep(1000);
			scrollDown(driver);
			System.out.println("CONTACT INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateDynamicContactInformation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Contact Information for duplicates************************************
	//************************************************************************************************
	public void validateContactInformationForDuplicateCheck(String cName, String cPhone,String cEmail) throws InterruptedException, AWTException {
		try {
			adultName.sendKeys(cName);
			Thread.sleep(1000);
			adultName.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot(cPhone);
			Thread.sleep(1000);
			adultEmail.sendKeys(cEmail);
			Thread.sleep(1000);
			specialInstructions.sendKeys(getSaltString());
			Thread.sleep(1000);
			scrollDown(driver);
			System.out.println("CONTACT INFORMATION FOR DUPLICATE ENTRY SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformationForDuplicateCheck()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Payment Information - In Store ************************
	//************************************************************************************************
	public String validatePaymentInformation() throws InterruptedException, AWTException {
		try{
			String x = null;
			Thread.sleep(1000);
			inStoreRadioBtn.click();
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("document.getElementById(\"cb\").click();");
			Thread.sleep(1000);
			scrollDown(driver);
			x = yourPackage.getText();
			waitAndClick(completeReservation);
			System.out.println("You have selected "+x+" Package");		
			System.out.println("SELECT PACKAGE OR TIME SLOT SUCCESS......................................................................!!!!!!!!!!!");		
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentInformation()");
			return "Issue with Method: validatePaymentInformation()";
		}
	}

	public String validatePaymentInformationwithBirthdaystar(int birthdayStar) throws InterruptedException, AWTException {
		try{
			String x = null;
			Thread.sleep(1000);
			inStoreRadioBtn.click();
			Thread.sleep(1000);
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("document.getElementById(\"cb\").click();");
			Thread.sleep(4000);
			if(birthdayStar>=1) {
				x = additionalBirthdayStar.getText();
			}else {
				x = yourPackage.getText();
			}
			waitAndClick(completeReservation);
			System.out.println("SELECT PACKAGE OR TIME SLOT SUCCESS......................................................................!!!!!!!!!!!");		
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentInformationwithBirthdaystar()");
			return "Issue with Method: validatePaymentInformationwithBirthdaystar()";
		}
	}

	//*************************************************************************************************
	//*********************Methods to validate Payment Information - Credit Card***********************
	//*************************************************************************************************
	public String validatePaymentUsingCreditCard(String CCinfo) throws InterruptedException {
		try{
			String x = null;
			Thread.sleep(2000);
			if(CCinfo=="Invalid") {
				billerName.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerAddress.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerCity.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerState.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerZipCode.sendKeys(getSaltString());
				Thread.sleep(1000);
				creditCardNumber.sendKeys("4455512301012019");
				Thread.sleep(1000);
				creditCardExpiryDate.sendKeys("1219");
				Thread.sleep(1000);
				creditcardCvvNumber.sendKeys("123");
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				waitAndClick(completeReservation);
				x = errorMsgInvalidCreditcardInformation.getText();		
			}else if(CCinfo=="Valid") {
				Thread.sleep(2000);
				billerName.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerAddress.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerCity.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerState.sendKeys(getSaltString());
				Thread.sleep(1000);
				billerZipCode.sendKeys(getSaltString());
				Thread.sleep(1000);
				creditCardNumber.sendKeys("4455512301012019");
				Thread.sleep(1000);
				creditCardExpiryDate.sendKeys("1219");
				Thread.sleep(1000);
				creditcardCvvNumber.sendKeys("123");
				Thread.sleep(1000);
				JavascriptExecutor js = (JavascriptExecutor) driver;
				js.executeScript("window.scrollBy(0,500)");
				waitAndClick(completeReservation);
				x = confmsg.getText();
			}
			System.out.println("Message text displayed as: "+x);
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentUsingCreditCard()");
			return "Issue with Method: validatePaymentUsingCreditCard()";
		}
	} 

	//*************************************************************************************************
	//*********************Methods to validate Payment Information -Payment Options *******************
	//************************************************************************************************
	public boolean validatePaymentOptions(String checkPaymentOptions) throws InterruptedException, AWTException {
		try{
		
			boolean x = false;
			if(checkPaymentOptions.equals("YES")){
				inStoreRadioBtn.isDisplayed();
				creditCardRadioBtn.isDisplayed();
				System.out.println("Payment option displayed.............................!!!!!!!!!!!");	
				x=true;
			}else {
				x=false;
				System.out.println("Payment option Not displayed.............................!!!!!!!!!!!");	
			}
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentOptions()");
			return false;
		}
	}
	//*************************************************************************************************
	//*********************Methods to validate Payment Information - For No Deposit Store *************
	//*************************************************************************************************
	public boolean validateNoDeposit(String checkNoStore) throws InterruptedException, AWTException {
		try{
			boolean x = true;
			Thread.sleep(1000);
			if(checkNoStore.equals("NO")){
				inStoreRadioBtn.isDisplayed();
				creditCardRadioBtn.isDisplayed();
				System.out.println("Payment option present");
				x=true;
			}else {
				x=false;
				System.out.println("Payment option not present");
			}
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoDeposit()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Get Confirmation Information***************************
	//************************************************************************************************	
	public String validateGetConfirmationNumber() throws InterruptedException {
		try{
			try{
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("document.getElementsByClassName(\"duplicateSubmit\")[0].click();");
			}catch(Exception e){
				System.out.println("Duplicate window not found, exception handled");
				e.printStackTrace();
			}
			try{
				if(upSellNoThanks.isDisplayed())
				{
					sayNoThanksToUpSell(upSellNoThanks,upSellNoThanksXpath);
				}
				Thread.sleep(5000);
				if(closeFinalUpSellPopUpWindow.isDisplayed()) {
					closeFinalUpSellPopUpWindow.click();
				}
			}catch(Exception e){
				System.out.println("USER EXCEPTION FOUND:");
				e.printStackTrace();
			}
			String confNum = waitTillVisibleAndGetText(confirmationNumber, confirmationNumberXPath);
			String [] confirmationNumber = confNum.split("#");
			if (confirmationNumber != null && confirmationNumber.length > 1) {
				System.out.println("Here is....."+ confirmationNumber[1]);
				System.out.println("GET CONFIRMATION NUMBER SUCCESS......................................................................!!!!!!!!!!!");		
				confNum = confirmationNumber[1];
			}
			return confNum;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetConfirmationNumber()");
			return "Issue with Method: validateGetConfirmationNumber()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Duplicate booking warning window***********************
	//************************************************************************************************	
	public String validateDuplidateBookingWarningWindow(String duplicateCheck) throws InterruptedException{
		try{
			Thread.sleep(10000);
			String x = null;
			if(duplicateCheck.equals("NewReservation")){
				System.out.println("Block to validate NewReservation");
				//duplicateWindowNewReservationBtn;
			}else if(duplicateCheck.equals("OldReservation")){
				System.out.println("Block to validate OldReservation");
			}else if(duplicateCheck.equals("CloseWindow")){
				System.out.println("Block to validate CloseWindow");		
				//duplicateWindowClose;
			}else if(duplicateCheck.equals("Message")){
				//if(duplicateHeader.getText().contains("Potential Duplicates") && duplicateConfirmationNumber.getText().contains("#") && duplicateDate.getText().contains("-")){
				if(duplicateHeader.getText().contains("Potential Duplicates") ){
					x = duplicateMessageWindowText.getText();
					System.out.println("Found Duplicates window and Message is : "+x);
					return x; 
				}else{
					x = "Missing Popup Window or Message";
					return x;
				}
			}
			System.out.println("Not found Duplicates Message/Window" +x);
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateDuplidateBookingWarningWindow()");
			return "Issue with Method: validateDuplidateBookingWarningWindow()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validateUpdateDateandTime***************************************
	//************************************************************************************************	
	public String validateUpdateDateandTime() throws InterruptedException {
		try{
			Thread.sleep(5000);
			/*	waitAndClick(updatedateandtimeLink);
			Thread.sleep(5000);
			waitAndClick(currentSelectDatePlusOne);
			waitAndClick(selectPackageMegaStar1); 
			Thread.sleep(5000);*/
			String updatedDate=modifiedDate.getText();
			System.out.println("The Modified date is: "+updatedDate);
			return updatedDate;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateDateandTime()");
			return "Issue with Method: validateUpdateDateandTime()";
		}
	}


	//************************************************************************************************
	//*********************Methods to validate Contact Information mandatory fields*******************
	//************************************************************************************************
	public String validateBirdayPartyContactInformationPageFields(String sChildName,String sChildAge,String sGenderListBox,String sAdultName,String sEnterPhoneNumberUsingRobot,String sAdultEmail,String sInStoreCheckBox) throws InterruptedException, AWTException {
		try{
			Thread.sleep(5000);
			String x = null;
			if(sChildName.equals("YES")){
				childName.clear();
				childName.sendKeys(getSaltString());
			}else {
				childName.clear();
				childName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				//Thread.sleep(15000);
				//childName.sendKeys("");
			}
			Thread.sleep(1000);
			if(sChildAge.equals("YES")){
				childAge.clear();
				childAge.sendKeys("10");
			}else {
				childAge.clear();
				childAge.sendKeys("");
			}
			Thread.sleep(1000);
			if(sGenderListBox.equals("YES")){
				genderListBox.click();
				genderMale.click();
			}
			Thread.sleep(1000);
			if(sAdultName.equals("YES")){
				adultName.clear();
				adultName.sendKeys(getSaltString());
			}else {
				adultName.clear();
				adultName.sendKeys("");
			}
			Thread.sleep(1000);
			if(sEnterPhoneNumberUsingRobot.equals("YES")){
				adultName.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot("");
			}else {
				adultName.sendKeys(Keys.TAB);
				enterDeleteUsingRobot();
			}
			Thread.sleep(1000);
			if(sAdultEmail.equals("YES")){
				adultEmail.clear();
				adultEmail.sendKeys(getSaltEmail());
			}else {
				adultEmail.clear();
				adultEmail.sendKeys("");
			}
			Thread.sleep(1000);
			specialInstructions.clear();
			specialInstructions.sendKeys(getSaltString());
			waitAndClick(inStoreRadioBtn);
			if(sInStoreCheckBox.equals("YES")){
				JavascriptExecutor j = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				j.executeScript("document.getElementById(\"cb\").click();"); //In-Store check box.
			}else {
				JavascriptExecutor j = (JavascriptExecutor) driver;
				Thread.sleep(1000);
				j.executeScript("document.getElementById(\"cb\").click();");
				j.executeScript("document.getElementById(\"cb\").click();");//In-Store check box.
			}
			Thread.sleep(1000);
			waitAndClick(completeReservation);
			Thread.sleep(2000);
			if(sChildName.equals("NO") || sChildAge.equals("NO") || sGenderListBox.equals("NO")){
				x = childNameAgeAndGenderAlertMsg.getText();
			}else if(sAdultName.equals("NO")){
				x = adultNameAlertMsg.getText();
			}else if(sEnterPhoneNumberUsingRobot.equals("NO")){
				x = phoneNumberAlertMsg.getText();
			}else if(sAdultEmail.equals("NO")){
				x = emailIdAlertMsg.getText();
			}else if (sInStoreCheckBox.equals("NO")){
				x = instoreCheckBoxAlertMsg.getText();
			}
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirdayPartyContactInformationPageFields()");
			return "Issue with Method: validateBirdayPartyContactInformationPageFields()";
		}
	}	

	//************************************************************************************************
	//*********************Methods to validate sendPartyInvitations link******************************
	//************************************************************************************************	
	public boolean validatesendPartyInvitations() throws InterruptedException {
		try{
			Thread.sleep(5000);
			boolean sendInvitationsLogo=false;
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			waitAndClick(sendPartyInvitationsLink);
			Thread.sleep(5000);
			System.out.println("SEND PARTY INVITATION LINK CLICKED....................................................!!!!!!!!!!!");
			System.out.println("Naviagted to Online Invitations - Punchbowl");
			sendInvitationsLogo = true;
			return sendInvitationsLogo;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatesendPartyInvitations()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate CEC Logo link******************************
	//************************************************************************************************	
	public boolean validateCECLogoToGoHomePage() throws InterruptedException {
		try{
			Thread.sleep(5000);
			waitAndClick(cecLogo);
			Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			boolean x = false;
			if(currentURL.equals("https://qa.chuckecheese.com/")){
				x = true;
			}else{
				x = false;
			}
			System.out.println("CEC LOGO CLICKED....................................................!!!!!!!!!!!");
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateCECLogoToGoHomePage()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Terms and Privacy link******************************
	//************************************************************************************************	
	public boolean validateTermsPrivacy() throws InterruptedException {
		try{
			Thread.sleep(5000);
			waitAndClick(footerlink);
			Thread.sleep(5000);
			String currentURL = driver.getCurrentUrl();
			boolean x = false;
			if(currentURL.equals("https://qa.chuckecheese.com/company/terms-and-privacy")){
				x = true;
			}else{
				x = false;
			}
			System.out.println("TERMS AND PRIVACY LINK CLICKED....................................................!!!!!!!!!!!");
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateTermsPrivacy()");
			return false;
		}
	}

	/*============================ UPDATE AND CANCEL=================================================*/

	//************************************************************************************************
	//*********************Methods to update the Update Quantity**************************************
	//************************************************************************************************		
	public String validateUpsellQuantity() throws InterruptedException {
		try{
			Thread.sleep(5000);
			addORRemoveChildORAdult(addQuantityForPizza,2);
			//addQuantityForPizza.click();
			updateQuantity.click();
			String conMsg = confmsg.getText();
			System.out.println("Message text displayed as:" +conMsg);
			return conMsg;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method:validateUpsellQuantity()");
			return "Issue with Method:validateUpsellQuantity()";
		}
	}

	//************************************************************************************************
	//********Methods to Modify the Contact or Birthday Star Information in Payments Page*************
	//************************************************************************************************
	public void validateUpdateContactOrBirthdayStarInfo() throws InterruptedException {
		try{
			Thread.sleep(5000);
			updateContactOrBirthdayStarInfo.click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateContactOrBirthdayStarInfo()");
		}
	}

	//************************************************************************************************
	//*******Methods to Modify the Date and Time Slot in Select A Date And Time Page *****************
	//************************************************************************************************
	public void validateUpdateDateAndTimeLink() throws InterruptedException {
		try{
			Thread.sleep(5000);
			updatedateandtimeLink.click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateDateAndTimeLink()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Change Location****************************************
	//************************************************************************************************	
	public void validateChangeLocation() throws InterruptedException {
		try{
			Thread.sleep(1000);
			changeLocation.click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangeLocation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Modify the Birthday Package****************************
	//************************************************************************************************	
	public void validateChangePackage(String GivenPKG) throws InterruptedException {
		try{
			changePackageLink.click();
			Thread.sleep(5000);
			if(GivenPKG.equals("Star")){
				//waitAndClick(selectStarPackage);
			}else if(GivenPKG.equals("SuperStar")){
				waitAndClick(selectSuperStarPackage);
				Thread.sleep(1000);
				waitAndClick(updateSuperStarPackage);
			}else if(GivenPKG.equals("MegaStar")){
				//waitAndClick(selectMegaStarPackage);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangePackage()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validateBirthdayPackageInformation*********************************
	//************************************************************************************************
	public void validateChangeDateandPackageinSelectADateAndTimePage() throws InterruptedException, AWTException {
		try{
			Thread.sleep(5000);
			//scrollUp(driver);
			currentSelectDatePlusOne.click();
			Thread.sleep(2000);
			waitAndClick(selectSuperStarPackage1);
			Thread.sleep(2000);
			waitAndClick(selectPackageSuperStar1);	
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangeDateandPackageinSelectADateAndTimePage()");
		}
	}

	//************************************************************************************************
	//*******Method to Update the Birthday Star information ******************************************
	//************************************************************************************************

	public void validateBirthdayStarInformationUpdate() throws InterruptedException, AWTException {
		try {
			Thread.sleep(500);
			childName.clear();
			childName.sendKeys("John");
			childAge.clear();
			childAge.sendKeys("6");
			adultName.clear();
			enterPhoneNumberUsingRobot("");
			adultEmail.clear();
			Thread.sleep(1000);
			System.out.println("BIRTHDAY STAR INFORMATION UPDATED SUCCESS......................................................................!!!!!!!!!!!");

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayStarInformationUpdate()");
		}
	}

	//**************************************************************************************************
	//*********************Methods to validate Update Attendees in Select And Date Page ****************
	//**************************************************************************************************
	public String validateUpdateAttendeesSelectAndDatePage(int aCount) throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(5000);
			if(aCount==1) {
				Thread.sleep(5000);
				addORRemoveChildORAdult(addAdult,200); 
				applyChanges.click();
				x = timeSlotNoLongerAvailableMsg.getText();	
			}else if(aCount==0) {
				Thread.sleep(5000);
				addChild.click();
				Thread.sleep(5000);
				addAdult.click();
				Thread.sleep(5000);
				applyChanges.click();
			}
			System.out.println("Attendees are updated: "+x);
			return x;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesSelectAndDatePage()");
			return "Issue with Method: validateUpdateAttendeesSelectAndDatePage()";
		}
	} 

	public boolean validateUpdatedChildANDAdultCount() throws InterruptedException {
		try {
			boolean result=false;
			String childAttendValue = "(//div[@class='summary__control']/span)[1]";
			String adultAttendValue = "(//div[@class='summary__control']/span)[2]";
			String getchildCount = driver.findElement(By.xpath(childAttendValue)).getText();
			String getadultCount = driver.findElement(By.xpath(adultAttendValue)).getText();
			int childCount = Integer.parseInt(getchildCount);
			int adultCount = Integer.parseInt(getadultCount);
			if(childCount==11 && adultCount==11) {
				result = true;
			}else {
				result = false;
			}
			System.out.println("The Child and Adult Attendees updated Successfully ");
			return result;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdatedChildANDAdultCount()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate No Time slot available message*************************
	//************************************************************************************************
	public String validateNoTimeSlotAvailableMsg(){
		try {
			waitAndClick(applyChanges);
			String noTimeSlotMsg = timeSlotNoLongerAvailableMsg.getText();
			System.out.println("NO TIME SLOT MSG SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("NO TIME SLOT MSG "+noTimeSlotMsg);
			return noTimeSlotMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoTimeSlotAvailableMsg()");
			return "Issue with Method: validateNoTimeSlotAvailableMsg()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Update Attendees in Confirmation Page******************
	//************************************************************************************************
	public String validateUpdateAttendeesConfirmationPage(int aCount) throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(5000);
			//	waitAndClick(updatedateandtimeLink);
			if(aCount==1) {
				Thread.sleep(5000);
				addORRemoveChildORAdult(increaseAdult,200); 
				applyChanges.click();
				x = errorMsgAtConfirmationPage.getText();		
			}else if(aCount==0) {
				Thread.sleep(5000);
				increaseChild.click();
				Thread.sleep(5000);
				increaseAdult.click();
				Thread.sleep(5000);
				applyChanges.click();
				x = confmsg.getText();
			}
			System.out.println("Message text displayed as:" +x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesConfirmationPage()");
			return "Issue with Method: validateUpdateAttendeesConfirmationPage()";
		}
	} 

	//***************************************************************************************************
	//*********************Methods to validate Update Attendees in Payments Page ************************
	//***************************************************************************************************
	public String validateUpdateAttendeesPaymentsPage(int aCount) throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(2000);
			if(aCount==1) {
				Thread.sleep(2000);
				//addORRemoveChildORAdult(addAdult,200); 
				addORRemoveChildORAdult(removeAdult,200); 
				applyChanges.click();
				x = errorMsgAtPaymentsPage.getText();		
			}else if(aCount==0) {
				Thread.sleep(2000);
				addChild.click();
				Thread.sleep(2000);
				addAdult.click();
				Thread.sleep(2000);
				applyChanges.click();
				x = confmsg.getText();
			}
			System.out.println("Message text displayed as: "+x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesPaymentsPage()");
			return "Issue with Method: validateUpdateAttendeesPaymentsPage()";
		}
	} 

	//***************************************************************************************************
	//*********************Methods to validate Cancel Booking********************************************
	//***************************************************************************************************	
	public String validateCancelBooking(String bCancel) throws InterruptedException {
		try {
			Thread.sleep(3000);
			String cancelMsg=null;
			waitAndClick(cancelReservationLink);
			Thread.sleep(3000);
			if(bCancel.equals("closeCancel"))
			{
				cancelMsg = cancelWindowTitle.getText();
				closeCancelPopupWindow.click();
			}

			if(bCancel.equals("confirmCancel")) {
				confirmConcelReservationBtn.click();
				cancelMsg = cancelConfirmationMsg.getText();
			}
			System.out.println("MSG:"+cancelMsg);
			System.out.println("CANCEL FEATURE SUCCESS......................................................................!!!!!!!!!!!");		
			return cancelMsg;	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateCancelBooking()");
			return "Issue with Method: validateCancelBooking()";
		}
	}

	//************************************************************************************************
	//********Methods to validate Birthday StarInformation in Reservation Summary page****************
	//************************************************************************************************
	public String validateBirthdayStarInformation() throws InterruptedException {
		try {
			String BstarInformation = bstarinfo.getText();
			System.out.println("The Birthday Star Name/Age updated as " + BstarInformation);
			return BstarInformation;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayStarInformation()");
			return "Issue with Method: validateBirthdayStarInformation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to Birthday Package Information in Reservation Summary page *******
	//************************************************************************************************
	public String validatePackageUpdateInformation() throws InterruptedException {
		try {
			boolean conMsg=confmsg.isDisplayed();
			System.out.println("ThePackage is updated successfully" + conMsg);
			Thread.sleep(1000);
			String ModifiedPackage = modifiedPackageName.getText();
			System.out.println("The Modified Package is " + ModifiedPackage);
			return ModifiedPackage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackageUpdateInformation()");
			return "Issue with Method: validatePackageUpdateInformation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Date And Time Confirmation*********************************
	//************************************************************************************************
	public String validateDateAndTimeConfirmation() throws InterruptedException {
		try {
			String DateAndTimeconMsg = dateInConfirmationPage.getText();
			return DateAndTimeconMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDateAndTimeConfirmation()");
			return "Issue with Method: validateDateAndTimeConfirmation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validateEstimatedPriceAtReservationSummaryPage******************
	//************************************************************************************************	
	public String validateEstimatedPriceAtReservationSummaryPage(String amount){
		try {
			WebElement Last_price=driver.findElement(By.xpath("//strong[contains(text(),'"+amount+"')]"));
			System.out.println("Last Price is Displayed in the page>>>"+Last_price.isDisplayed());
			System.out.println("Total amount to be paid	:	"+amount);
			return amount;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEstimatedPriceAtReservationSummaryPage()");
			return "Issue with Method: validateEstimatedPriceAtReservationSummaryPage()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Package price******************************************
	//************************************************************************************************	
	// Get the Child price based on the package chosen 
	public String validatePackageprice(String S_price) {
		try {
			double a,b,cost;
			String c = null;
			if(S_price.equals("STAR")) {
				String StarPackagevalue=STAR_price.getText();
				String Price=StarPackagevalue.substring(1);
				System.out.println("The Star Package Child Price is >>"+Price);
				cost = Double.valueOf(Price);			
				System.out.println("The STAR Package Child Price is >>"+cost);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);
			}
			else if (S_price.equals("SUPER STAR")){
				String SUPER_price= SUPERSTAR_price.getText();
				String Price=SUPER_price.substring(1);
				cost = Double.valueOf(Price);			
				System.out.println("The SUPERSTAR Package Child Price is >>"+cost);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);

			}else if (S_price.equals("MEGA SUPER STAR")){
				String MEGA_price= MEGASUPERSTAR_price.getText();
				String Price=MEGA_price.substring(1);
				cost = Double.valueOf(Price);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);
				System.out.println("The MEGASUPERSTAR Package Child Price is >>"+cost);
			}
			else if (S_price.equals("VIP MEGA SUPER STAR")){
				String VIP_price=VIPMEGASUPERSTAR_price.getText();
				String Price=VIP_price.substring(1);
				cost = Double.valueOf(Price);
				a=10;
				b=a*cost;
				System.out.println("The Total amount is >>"+b);
				System.out.println("The VIPMEGASUPERSTAR Package Child Price is >>"+cost);	
			}
			else {
				System.out.println("You are not chosen the right package!!!");
			}
			return c;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackageprice()");
			return "Issue with Method: validatePackageprice()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validateDeposit Due Date******************************************
	//************************************************************************************************	
	public boolean validateDepositDueDate(int todaysDate) throws InterruptedException, AWTException {
		try {
			boolean result = false;
			String dueDate = getDueDateMMDD(todaysDate);

			System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+dueDate);
			try {

				//div[@class='deposit__contianer cleafix']//*[contains(text(),'Deposit due')]03/08:] "+dueDate+":]
				//String dueDateXpath = "//div[@class='deposit__contianer cleafix']//*[contains(text(),'Deposit due')]";

				String dueDateXpath = "//div[@class='deposit__contianer cleafix']//*[contains(text(),'"+dueDate+":')]";

				//div[@class='deposit__contianer cleafix']//*[contains(text(),'03/08:')]

				WebElement ele = driver.findElement(By.xpath(dueDateXpath));
				String dueDateText = ele.getText();
				System.out.println("TTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTTT"+dueDateText);
				if(dueDateText!="")
				{
					result=true;
				}else {
					result = false;
				}
			}catch(Exception e) {
				System.out.println("Found: Due date issue");
				result = false;
			}
			System.out.println("Due date is:"+dueDate);
			System.out.println("Result Status:"+result);
			return result;	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDepositDueDate()");
			return false;
		}
	}

	//************************************************************************************************
	//*****Methods to validate the Error message for Party date more than 90 days*********************
	//************************************************************************************************
	public String validateErrorMoreThan90days(int tubookingDateFor90days) throws InterruptedException, AWTException {
		try {
			String x=null;
			Thread.sleep(3000);
			childrenListBox.click();
			tenChildrenListItem.click();
			adultListBox.click();
			tenAdultListItem.click();
			Thread.sleep(1000);
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			Thread.sleep(1000);
			//New code it check browser, if  its browser it called different robo base method.
			if(propv.getProperty("GUI").equals("chrome")){
				enterDateUsingRobotForChrome(tubookingDateFor90days);
			}else{
				enterDateUsingRobot(tubookingDateFor90days);//0 for todays, 1,2,3,..n for future date.
			}
			Thread.sleep(1000);
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
			Thread.sleep(2000);
			waitAndClick(currentSelectDatePlusOne);
			//Thread.sleep(4000);
			scrollDown(driver);
			waitAndClick(selectPackageMegaStar1);		
			scrollDown(driver);
			Thread.sleep(2000);
			x = errorMsgAt90days.getText();	
			Thread.sleep(1000);
			System.out.println("Message is......................"+x);
			return x;		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateErrorMoreThan90days()");
			return "Issue with Method: validateErrorMoreThan90days()";
		}
	}


	//************************************************************************************************
	//*********************Methods to validateGetTextOfElement****************************************
	//************************************************************************************************	
	// Added for copy  the Element 
	public void validateGetTextOfElement(WebElement Element){
		try {
			Element.sendKeys(Keys.chord(Keys.CONTROL+"a"));
			Element.sendKeys(Keys.chord(Keys.CONTROL+"c"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetTextOfElement()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validatePasteTextOfElement**************************************
	//************************************************************************************************	
	//Added for paste the Element

	public void validatePasteTextOfElement(WebElement Element){
		try {
			Element.sendKeys(Keys.chord(Keys.CONTROL+"v"));
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePasteTextOfElement()");
		}
	}


	//************************************************************************************************
	//*********************Methods to validateReservationWithReservationNo****************************
	//************************************************************************************************	
	public boolean  validateReservationWithReservationNo(String updated_reservation ,int bookingdate ) throws InterruptedException, AWTException {
		try {
			boolean x = false;
			Thread.sleep(5000);
			Robot robot = new Robot(); 
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);
			driver.findElement(By.xpath("//*[@name='confNumber']")).sendKeys(updated_reservation);    
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			//Added Newly to release the key .
			robot.keyRelease(KeyEvent.VK_TAB);
			robot.delay(1000);
			enterDateUsingRobot(bookingdate);
			driver.findElement(By.xpath("//*[@data-name='Layer 1']")).click();
			Thread.sleep(20000);
			String confNumber = confirmationNumber.getText();
			String find_reservation = confNumber.substring(14);
			String confNum = confirmationNumber.getText();
			if(confNum.contains("CONFIRMATION #")) {
				x = true;
			}else { 
				x = false;
			}
			System.out.println("Finding the Reservation is Successfully Done !!!"+x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReservationWithReservationNo()");
			return false;
		}
	}      

	//************************************************************************************************
	//*********************Methods to validateReservationWithEmail************************************
	//************************************************************************************************	
	public boolean validateReservationWithEmail(int bookingdate) throws InterruptedException, AWTException {
		try {
			boolean x = false;
			Thread.sleep(5000);
			Robot robot = new Robot(); 
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			validatePasteTextOfElement(confirmationMailID);
			robot.keyPress(KeyEvent.VK_TAB);
			robot.delay(1000);
			enterDateUsingRobot(bookingdate);
			driver.findElement(By.xpath("//*[@data-name='Layer 1']")).click();
			Thread.sleep(10000);
			String confNum = confirmationNumber.getText();
			if(confNum.contains("CONFIRMATION #")) {
				x = true;
			}else { 
				x = false;
			}
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReservationWithEmail()");
			return false;
		}
	}



}


