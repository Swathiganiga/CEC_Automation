package com.cec.qa.pages;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import java.awt.AWTException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import org.codehaus.groovy.ast.stmt.TryCatchStatement;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;
public class KidsGroupEventPage extends BaseTest {

	//************************************************************************************************
	//*********************Brand site menu locators***************************************************
	//************************************************************************************************

	@FindBy(xpath="//a[contains(text(),'   Events')]")
	WebElement mainMenuEvent;

	@FindBy(xpath="//ul[@class='dropdown-menu fade']/li/a[text()='Kids Group Events']")
	WebElement subMenuBKidsGroupEvents;

	//************************************************************************************************
	//*********************CHANGE LOCATION************************************************************
	//************************************************************************************************

	//@FindBy(xpath="//span[text()='Choose a location']")  //Common   //a[text()='Change location']
	//WebElement changeLocationLink;
	@FindBy(xpath="//*[@id='currentStore']/a/span")
	WebElement commonLocation;
	
	@FindBy(xpath="//span[text()='Choose a location']")
	WebElement changeLocationLink1;

	@FindBy(xpath="//span[text()='Change location']")
	WebElement changeLocationLink2;

	@FindBy(xpath="//form[@id='locationSearch']/input[@name='location']") //Common
	WebElement locationSearchBox;

	@FindBy(xpath="//button[@id='locationSubmit']") //Common
	WebElement searchIcon;

	@FindBy(xpath="(//address)[1]")
	WebElement firstStoreAddressText;

	@FindBy(xpath="//h3[@id='noSearchResults']")
	WebElement noSearchResults;

	//************************************************************************************************
	//*********************CHANGE LOCATION - SELECT STORE*********************************************
	//************************************************************************************************

	@FindBy(xpath="(//a[text()='Select Store'])[1]") //Common
	WebElement selectFirstStoreBtn;

	//************************************************************************************************
	//*********************A Package to Fit Every Event and Budget - SELECT PACKAGE*******************
	//************************************************************************************************

	@FindBy(xpath="//a[@id='tabbedContent-CTA3']/span[text()='Book This Package']")
	WebElement bookNow120minBtn;

	@FindBy(xpath="//a[@id='tabbedContent-CTA2']/span[text()='Book This Package']")
	WebElement bookNow90minBtn;

	@FindBy(xpath="//a[@id='tabbedContent-CTA1']/span[text()='Book This Package']")
	WebElement bookNow60minBtn;

	//************************************************************************************************
	//*********************BOOK A GROUP EVENT - SELECT CHILD,ADULT & DATE********************************
	//************************************************************************************************

	@FindBy(xpath="//input[@id='numberOfKids']")
	WebElement childrenInputBox;

	@FindBy(xpath="//select[@id='numberOfAdults']") //Common
	WebElement adultListBox;

	@FindBy(xpath="//select[@id='numberOfAdults']/option[contains(text(),'10 Adults')]") //Common
	WebElement tenAdultListItem;

	@FindBy(xpath="//select[@id='numberOfAdults']/option[text()='1 Adult ']")
	WebElement oneAdultListItem;

	@FindBy(xpath="//select[@id='numberOfAdults']/option[contains(text(),'50 Adults')]")
	WebElement fiftyAdultListItem;
	
	@FindBy(xpath="//select[@id='numberOfAdults']/option[contains(text(),'180')]")
	WebElement oneHundredEightyAdultListItem;

	@FindBy(xpath="//input[@id='partyDate']") //Common
	WebElement dateInputbox;

	@FindBy(xpath="//button[@class='btn--primary btn--purple']") //Common
	WebElement seeAvailablity;

	//Validate Book A Group Event missing alert message
	@FindBy(xpath="(//*[contains(text(),'Please fill out this field')])")
	WebElement childrenAlertMsg;

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement adultAlertMsg;

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement partydateAlertMsg;

	//************************************************************************************************
	//*********************SELECT A DATE & TIME - SELECT PACKAGE OR TIME SLOT*************************
	//************************************************************************************************
    
	@FindBy(xpath="(//button[@title='Select Package'])[1]")
	WebElement selectPackage60min;

	@FindBy(xpath="(//button[@title='Select Package'])[2]")
	WebElement selectPackage90min;

	@FindBy(xpath="(//button[@title='Select Package'])[3]")
	WebElement selectPackage120min;

	@FindBy(xpath="(//button[@title='Select Package'])[28]")
	WebElement selectPackage60min1;

	@FindBy(xpath="//button[@title='Remove Child']") //Common
	WebElement removeChild;

	@FindBy(xpath="//button[@title='Add Child']") //Common
	WebElement addChild;

	@FindBy(xpath="//button[@title='Remove Adult']") //Common
	WebElement removeAdult;

	@FindBy(xpath="//button[@title='Add Adult']") //Common
	WebElement addAdult;

	@FindBy(xpath="//a[contains(text(),'Apply changes')]") //Common
	WebElement applyChanges;

	@FindBy(xpath="(//h2[text()='This Time Slot Is No Longer Available'])[1]")
	WebElement timeSlotNoLongerAvailableMsg;

	@FindBy(xpath="(//button[@title='Select Package'])[33]")
	WebElement selectPackage120min33;

	@FindBy(xpath="//ul[@class='calendar-select']/li[2]")
	WebElement currentSelectDatePlusOne;	

	//*****************************************************************************
	//Default Party items
	@FindBy(xpath="//*[@id=\"calendarStep\"]/div[2]/div[2]/div[2]/div/div/ul/li[3]")
	WebElement partyitem;
	//*****************************************************************************
	//Up sell pop-up

	@FindBy(xpath="//button[text()='No Thanks']") //Common
	WebElement upSellNoThanks;

	String upSellNoThanksXpath = "//button[text()='No Thanks']"; //Common

	@FindBy(xpath="//*[contains(text(),'Upgrade!')]") //Common
	WebElement upSellUpgrade;

	String upSellUpgradeXpath="//*[contains(text(),'Upgrade!')]"; //Common

	//**************************************************************************

	// Payment verification //- Vijei Balaji 

	@FindBy(xpath="//p[contains(text(),'Children')]")
	WebElement Childrens_count;

	@FindBy(xpath="(//div[@data-type='60 Minutes of All You Can Play '] //span[@class='price'])[1]")
	WebElement _60min_price;

	@FindBy(xpath="(//div[@data-type='90 Minutes of All You Can Play '] //span[@class='price'])[1]")
	WebElement _90min_price;

	@FindBy(xpath="(//div[@data-type='120 Minutes of All You Can Play '] //span[@class='price'])[1]")
	WebElement _120min_price;
	//************************************************************************************************
	//*********************CONTACT INFORMATION - Group Party Information and Contact Info*************
	//************************************************************************************************

	//Group Party Information

	@FindBy(xpath="//input[@id='organizationName']")
	WebElement organizationName;

	@FindBy(xpath="//input[@id='organizationPhone']")
	WebElement organizationPhone;

	@FindBy(xpath="//input[@id='organizationExtension']")
	WebElement organizationExtension;

	
	@FindBy(xpath="//*[@id='OrgGroup']")
	WebElement orgType;
	
	@FindBy(xpath="//*[@id='OrgGroup']/option[contains(text(),'School')]")
	WebElement school;
	//Contact Information page

	@FindBy(xpath="//input[@name='adultName']")  //Common
	WebElement adultName;
	@FindBy(xpath="//*[@id='phone']")
	WebElement phoneNumber;
	
	@FindBy(xpath="//div[@class='c-info-card']//a[@class='c-info-card__link'][contains(text(),'Edit Party Information')]")
	WebElement editPartyInfo;
	
	@FindBy(xpath="//select[@id='select_children_editPage']")
	WebElement editChildren;  
	
	@FindBy(xpath="//select[@id='select_adult_editPage']")
	WebElement editAdult;
	
	@FindBy(xpath="//input[@placeholder='Date of Party*']")
	WebElement datePickertEditPage;
	
	
	@FindBy(xpath=" //option[@id='children_180_editPage']")
	WebElement oneHundredEightyKidsListItem;
	
	@FindBy(xpath="//option[@id='adult_180_editPage']")
	WebElement oneHundredEightyAdultsListItem;
	
	
	
	@FindBy(xpath="//label[text()='Phone']") //Common
	WebElement adultPhone;

	@FindBy(xpath="//input[@id='email']") //Common
	WebElement adultEmail;

	@FindBy(xpath="//textarea[@id='SpecialInstructions']") //Common
	WebElement specialInstructions;

	@FindBy(xpath="//label[text()='In store within 48 hours']")
	WebElement inStoreRadioBtn;

	@FindBy(xpath="//label[text()='With my debit/credit card']")
	WebElement creditCardRadioBtn;

	@FindBy(xpath="//*[@id='Layer_1']")
	WebElement completeReservation;

	@FindBy(xpath="//h3[text()='Payment Information']") //unused
	WebElement justToClickOnPageBeforeScroll;

	@FindBy(xpath="//div[@class='summary__package clearfix']/p") //Common
	WebElement yourPackage;

	//Validate Contact info missing alert message
	@FindBy(xpath="//div[contains(text(),'Please fill out all organization information.')]")
	WebElement orgNameAlertMsg;

	@FindBy(xpath="//div[contains(text(),'Please enter a valid phone number.')]")
	WebElement orgPhoneAlertMsg;

	@FindBy(xpath="//div[contains(text(),'Please enter the adult's name.')]")
	WebElement adultNameAlertMsg;

	@FindBy(xpath="//div[contains(text(),'Please enter a valid phone number.')]")
	WebElement phoneNumberAlertMsg;

	@FindBy(xpath="//div[contains(text(),'Please enter a valid email address.')]")
	WebElement emailIdAlertMsg;

	//Duplicate check Window Locators

	@FindBy(xpath="//h3[text()='Potential Duplicates']")
	WebElement duplicateHeader;

	@FindBy(xpath="//*[@id='duplicateModal']/div/button")
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
	//*********************YOUR RESERVATION SUMMARY - Conf/Cancel/Update/Upsell***********************
	//************************************************************************************************

	@FindBy(xpath="(//p[contains(text(),'Confirmation #')])[2]") //Common
	WebElement confirmationNumber;

	String confirmationNumberXPath = "(//p[contains(text(),'Confirmation #')])[2]";
	//Final Upsell Popup Window

	@FindBy(xpath="//a[@class='upsell-close closeUpsellAllYouCanPlay']") //Not for birthday
	WebElement closeFinalUpSellPopUpWindow;

	//Update Child and Adult in Reservation summary 

	@FindBy(xpath="//button[@title='Child Decrease']") //Common
	WebElement decreaseChild;

	@FindBy(xpath="//button[@title='Child Increase']") //Common
	WebElement increaseChild;

	@FindBy(xpath="//button[@title='Adult Decrease']") //Common
	WebElement decreaseAdult;

	@FindBy(xpath="//button[@title='Adult Increase']") //Common
	WebElement increaseAdult;

	//Update Booking

	@FindBy(xpath="//a[text()=' Update Contact or Group party Information']")  
	WebElement updateContactInfoLink;

	@FindBy(xpath="//a[text()='Edit Time and/or Date']") //Common
	WebElement updatedateandtimeLink;

	@FindBy(xpath="//a[text()='Send Free Party Invitations']") //Common
	WebElement sendPartyInvitations;

	@FindBy(xpath="//div[@class='summary__partyDate']/p")
	WebElement dateInConfirmationPage;

	@FindBy(xpath="//a[text()='Change/Upgrade']")
	WebElement changePackageLink;

	@FindBy(xpath="(//div[@class='SUPER'])[1]")
	WebElement select90minPackage;

	@FindBy(xpath="(//div[@class='col-sm-12 SUPER'])")
	WebElement update90minPackage;
	
	@FindBy(xpath="//p[contains(text(),'90 Minutes of All You Can Play ')]")
	WebElement modifiedPackageName;

	@FindBy(xpath="//p[contains(text(),'Genisys')]")
	WebElement orgNameinfo;

	@FindBy(xpath="//div[@class='summary__partyDate']/p")
	WebElement modifiedDate;

	//Cancel Booking

	@FindBy(xpath="//a[@class='cancel-close']") //Common
	WebElement closeCancelPopupWindow;

	@FindBy(xpath="//a[text()='Cancel Reservation']") //Common
	WebElement cancelReservationLink;
	
	@FindBy(xpath="//div[@class='c-info-card']//div//a[@class='c-info-card__link'][contains(text(),'Cancel Reservation')]")
	WebElement cancelReservationLink2;

	@FindBy(xpath="//button[@class='btn--primary btn--purple cancelRes']") //Common
	WebElement confirmConcelReservationBtn;

	@FindBy(xpath="//h3[text()='You have successfully cancelled your reservation']") //Common
	WebElement cancelConfirmationMsg;

	@FindBy(xpath="//h3[text()='Are you sure you want to cancel this reservation?']") //Common
	WebElement cancelWindowTitle;

	@FindBy(xpath="//p/a[text()='here']") //Common
	WebElement clickHereToHomePageLink;

	//Error messages

	//Confirmation Page -An error occurred saving your reservation
	@FindBy(xpath="//*[@id=\"applicationMessage\"]/comment()")
	WebElement errormsg;

	//This time slot does not support your party size
	@FindBy(xpath="//*[@id=\"applicationMessage\"]")
	WebElement errormsg1;

	//************************************************************************************************
	//*********************Header and Footer link ****************************************************
	//************************************************************************************************

	@FindBy(xpath="//a[text()='Terms & Privacy | ']")
	WebElement footerlink;

	//**************************************************
	//Error Message
	//
	@FindBy(xpath="//h4[text()='Your reservation has been updated']")
	WebElement confmsg;

		@FindBy(xpath="//h4[text()='This time slot does not support your party size']")
	WebElement errorMsgAtConfirmationPage;

	@FindBy(xpath="//h4[text()='You cannot book a party more than 365 days in advance.']")
	WebElement errorMsgAt180days;

	//This time slot does not support your party size
	@FindBy(xpath="//h4[text()='This time slot does not support your party size']")
	WebElement errorMsgAtPaymentsPage;

	
	
	
	
	
	///////////////////////BDD//////////////////////////////////////////
	@FindBy(xpath="//*[@id='select_children_entryPage']")
	WebElement selectChildren;
	
	@FindBy(xpath="//*[@id='select_adult_entryPage']")
	WebElement selectAdult;
	
	@FindBy(xpath="//a[@class='dropdown-item first-item'][contains(text(),'Kids Group Events')]")
	WebElement kidsGroupEvent;
	
	@FindBy(xpath="/html/body/div[2]/nav/ul/li[4]/a")
	WebElement eventTab;
	
	@FindBy(xpath="//span[@class='mydpicon icon-mydpcalendar']")
	WebElement datePicker;
	                //button[@class='headerbtn mydpicon icon-mydpright headerbtnenabled'] 
	@FindBy(xpath="//button[@class='headerbtn mydpicon icon-mydpright headerbtnenabled']")
	WebElement nextMonthdate;
	
	@FindBy(xpath="//div[@class='alert-warning alert custom']") ////////ADDED BDDD
	WebElement noTimeSlot;
	
	@FindBy(xpath="//*[@id='select_time_entryPage']")
	WebElement timeslotListItem;

	@FindBy(xpath="//div[@id='2847']//a[contains(@class,'c-blog-card__link')][contains(text(),'Book this package')] ")
	WebElement book60minPackage;
	
	@FindBy(xpath="//div[contains(@class,'-left')]//a[contains(@class,'c-blog-card__link')][contains(text(),'Book this package')] ")
	WebElement book90minPackage;
	
	@FindBy(xpath="//div[@id='2849']//a[contains(@class,'c-blog-card__link')][contains(text(),'Book this package')] ")
	WebElement book120minPackage;
	
	@FindBy(xpath="//*[@id='applicationMessage']/h4")
	WebElement alertDanger;
	
	@FindBy(xpath="//*[@id='2847']/div[2]/div/div[1]/div[2]/div/span[1]")
	WebElement sixtyminPackPrice;
	
	@FindBy(xpath="//*[@id='2848']/div[1]/div/div[1]/div[2]/div/span[1]")
	WebElement nintyminPackPrice;
	
	@FindBy(xpath="//*[@id='2849']/div[2]/div/div[1]/div[2]/div/span[2]")
	WebElement onetwentyminPackPrice;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[3]/span[1]/span")
	WebElement childrenTotalAmount;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[3]/span[2]/span")
	WebElement AdultTotalAmount;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[4]/span[1]/span")
	WebElement estimatedTotalPrice;
	
	@FindBy(xpath="//div[@class='c-info-card']//div//a[@class='c-info-card__link'][contains(text(),'Send Free Party Invitations')] ")
	WebElement sendPartyInvitationsLink;

	@FindBy(xpath="//img[@class='logo']")
	WebElement sendInvitationsLogo;
	
	@FindBy(xpath="//h3[@class='payment-title']")
	WebElement titlePayment;
	
	//************************************************************************************************
	//*********************LOCATORS Initialization****************************************************
	//************************************************************************************************
	public KidsGroupEventPage(){
		PageFactory.initElements(driver, this);
	}



	//************************************************************************************************
	//*********************Methods to validate Search Location****************************************
	//************************************************************************************************
	public void validateSearchLocation(String cLocation) throws InterruptedException {  //Common Method
		try {
			Thread.sleep(1000);
			//Actions action=new Actions(driver);
			//action.moveToElement(eventTab).perform();
			//waitAndClick(kidsGroupEvent);
			scrollDown(driver);
			scrollDown(driver);
			/*if(waitAndGetText(commonLocation).contains("Change")){
				waitAndClick(changeLocationLink2);
			}else{
				waitAndClick(changeLocationLink1);
			}*/
			waitAndClick(commonLocation);
			locationSearchBox.sendKeys(Keys.CONTROL, "a");
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
				locationSearchBox.sendKeys(cLocation);
			} 

			Thread.sleep(1000);
			Actions act = new Actions(driver);
			act.moveToElement(searchIcon).click().perform();
			waitAndClick(searchIcon);	
			System.out.println("SELECT LOCATION SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
			//System.out.println("Issue with Method: validateSearchLocation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Store*******************************************
	//************************************************************************************************
	public void validateSelectStore() throws InterruptedException { //Common Method
		try {
			waitAndClick(selectFirstStoreBtn);
			
			System.out.println("SELECT STORE SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectStore()");
			throw new AssertionError("A clear description of the failure", e);
			
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Store*******************************************
	//************************************************************************************************
	public boolean validateFirstStoreCityStateAndZip(String cLocation) throws InterruptedException {
		try {
			boolean x = false;
			String storeAddress = firstStoreAddressText.getText();
			storeAddress = storeAddress.toLowerCase();
			cLocation = cLocation.toLowerCase();
			if(storeAddress.contains(cLocation)) {
				x = true;
			}else {
				x = false;
			}
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateFirstStoreCityStateAndZip()");
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate No Store Found Message*************************
	//************************************************************************************************
	public String validateNoStoreAvailableMsg(String cLocation) throws InterruptedException{
		try {
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
			System.out.println("NO STORES FOUND......................................................................!!!!!!!!!!!");
			return noSearchResults.getText();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoStoreAvailableMsg()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateNoStoreAvailableMsg()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Choose Package*****************************************
	//************************************************************************************************

	public void validateChoosePackage(String bPackage) throws InterruptedException {
		try {
			Thread.sleep(3000);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			Thread.sleep(3000);
			if(bPackage.equals("90min"))
			{
				bookNow90minBtn.click();
			}
			else if(bPackage.equals("120min"))
			{

				bookNow120minBtn.click();
			}
			else
			{
				waitAndClick(bookNow60minBtn);
			}
			Thread.sleep(2000);
			System.out.println("CHOOSE PACKAGE SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateChoosePackage()");
			throw new AssertionError("A clear description of the failure", e);
		}	
	}


	//************************************************************************************************
	//*********************Methods to validate Select Child, Adult and Date***************************
	//************************************************************************************************

	public void validateSelectChildAdultAndDate(int bookingDate) throws InterruptedException, AWTException {
		try {
			Thread.sleep(3000);
			childrenInputBox.clear();
			childrenInputBox.sendKeys("6");
			adultListBox.click();
			tenAdultListItem.click();
			Thread.sleep(1000);
			dateInputbox.sendKeys(Keys.ALT);//Works for Chrome
			Thread.sleep(1000);
			//New code it check browser, if  its browser it called different robo base method.
			/*if(propv.getProperty("GUI").equals("chrome")){
				enterDateUsingRobotForChrome(bookingDate);
			}else{*/
			enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			//}
			Thread.sleep(1000);
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate()");
		}
	}


	/*public String validateBookings180days(int bookingDate) throws InterruptedException, AWTException {
		String x = null;
		Thread.sleep(3000);
		childrenInputBox.sendKeys("10");
		adultListBox.click();
		tenAdultListItem.click();
		dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
		enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
		Thread.sleep(1000);
		seeAvailablity.click();
		System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		Thread.sleep(2000);
		currentSelectDatePlusOne.click();
		x = errorMsgAt180days.getText();	
		Thread.sleep(1000);
		System.out.println("Message is......................"+x);
		return x;
	}*/



	//************************************************************************************************
	//*********************Methods to validate Book An Event Minimum and Maximum value fields*******************
	//************************************************************************************************
	public boolean validateGroupEventPageMinMaxValue(String checkMinMax) throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
			boolean x = false;
			if(checkMinMax.equals("YES")){
				childrenInputBox.sendKeys("0");
				childrenInputBox.sendKeys(Keys.ENTER);
				childrenInputBox.clear();
				Thread.sleep(5000);
				childrenInputBox.sendKeys("50000000000");
				Thread.sleep(5000);
				adultListBox.click();
				oneAdultListItem.click();
				Thread.sleep(5000);
				fiftyAdultListItem.click();
				dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
				x=true;
			}else {
				x=false;//in future, use try catch
			}
			System.out.println("The Minimum and Maximum value is validated successfully");
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupEventPageMinMaxValue()");
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}


	//************************************************************************************************
	//*********************Methods to validate Book A Group Event mandatory fields*******************
	//************************************************************************************************
	public boolean validateGroupEventPageFields() throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
			boolean x = false;
			boolean y = false;
			boolean z = false;
			boolean s = false;
			waitAndClick(seeAvailablity);
			//switchToAlert();
			if(childrenAlertMsg.getText().contains("Please fill out this field.")) {
				x = true;
			}
			childrenInputBox.sendKeys("10");
			waitAndClick(seeAvailablity);
			switchToAlert();
			if(adultAlertMsg.getText().contains("Please select an item in the list.")) {
				y = true;
			}	
			adultListBox.click();
			tenAdultListItem.click();
			waitAndClick(seeAvailablity);
			switchToAlert();
			if(partydateAlertMsg.getText().contains("Please fill out this field.")) {
				z = true;
			}

			if(x==y && y==z) {
				s = true;
			}else {
				s = false;		
			}
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupEventPageFields()");
			return false;
		}
	}	

	//************************************************************************************************
	//*********************Methods to validate Book A Event with Maximum value *******************
	//************************************************************************************************
	public void validateGroupEventPageMaxValue(int bookingDate) throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
			childrenInputBox.sendKeys("300");
			Thread.sleep(5000);
			adultListBox.click();
			fiftyAdultListItem.click();
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			//}
			Thread.sleep(1000);
			seeAvailablity.click();
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupEventPageMaxValue()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Package Or Time slot****************************
	//************************************************************************************************
	public String validateSelectPackageORTimeSlot(String BasePKG, String person, int cCount) throws InterruptedException {
		try {
			String alertMessage = null;
			Thread.sleep(5000);
			if(cCount==0) {
				if(BasePKG.equals("60min")) {
					selectEventAvailableTimeSlot(BasePKG);
					alertMessage = "true"; 
				}else if(BasePKG.equals("90min")) {
					selectEventAvailableTimeSlot(BasePKG);
				}else if(BasePKG.equals("120min")) {
					selectEventAvailableTimeSlot(BasePKG);
				}else {
					System.out.println("Invalid PKG entry given at method: validateSelectPackageORTimeSlot");
				}

				Thread.sleep(2000);
			}

			//NOTE: IF Part checks min/max count of adult and child validation given or not, else will continue booking.
			if(person.equals("Child")) {
				if(cCount <= 10)
				{
					addORRemoveChildORAdult(removeChild,1);
				}
				if(cCount >= 100)
				{
					addORRemoveChildORAdult(removeChild,cCount);
				}
				alertMessage = switchToAlertAndAcceptReturnTitle();

			}else if(person.equals("Adult") && !(cCount==200)) {
				if(cCount <= 1)
				{
					addORRemoveChildORAdult(removeAdult,10);
				}
				if(cCount >= 100)
				{
					addORRemoveChildORAdult(removeChild,cCount);
				}

				alertMessage = switchToAlertAndAcceptReturnTitle();
			}else if(cCount == 200){
				addORRemoveChildORAdult(addAdult,200); 
			}else{
				System.out.println("**********VVVVVVVVVVVVVVVVVVVVVVVVV**********");
			}

			System.out.println("SELECT PACKAGE OR TIME-SLOT SUCCESS......................................................................!!!!!!!!!!!");
			return alertMessage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectPackageORTimeSlot()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateNoStoreAvailableMsg()";
		}

	}

	//************************************************************************************************
	//*********************Methods to validate Group Party Information********************************
	//************************************************************************************************
	public boolean validateGroupPartyInformation() throws InterruptedException, AWTException {
		try {
			boolean x=false;
			Thread.sleep(2000);
			organizationName.sendKeys(getSaltString());
			Thread.sleep(1000);
			organizationName.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(1000);
			organizationPhone.sendKeys("9902639713");
			Thread.sleep(1000);
			//organizationExtension.sendKeys("1443");
			//Thread.sleep(1000);
			Select orgType = new Select(driver.findElement(By.id("OrgGroup")));
			orgType.selectByIndex(2);
			x=true;
			System.out.println("GROUP PARTY INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupPartyInformation()");
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Contact Information mandatory fields*******************
	//************************************************************************************************
	public String validateGroupEventContactInformationPageFields(String sOrgName,String sOrgPhone,String sOrgExtn,String sAdultName,String sEnterPhoneNumberUsingRobot,String sAdultEmail) throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
			String x = null;
			if(sOrgName.equals("YES")){
				organizationName.clear();
				organizationName.sendKeys(getSaltString());
			}else {
				organizationName.clear();
				organizationName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				//childName.sendKeys("");
			}
			Thread.sleep(1000);
			if(sOrgPhone.equals("YES")){
				organizationPhone.clear();
				organizationPhone.sendKeys("9902639713");
			}else {
				organizationPhone.clear();
				organizationPhone.sendKeys("");
			}
			Thread.sleep(1000);
			if(sOrgExtn.equals("YES")){
				organizationExtension.sendKeys("1443");

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

			Thread.sleep(1000);
			waitAndClick(completeReservation);
			Thread.sleep(2000);
			if(sOrgName.equals("NO")){
				x = orgNameAlertMsg.getText();
			}else if(sOrgPhone.equals("NO")){
				x = orgPhoneAlertMsg.getText();
			}else if(sAdultName.equals("NO")){
				x = adultNameAlertMsg.getText();
			}else if(sEnterPhoneNumberUsingRobot.equals("NO")){
				x = phoneNumberAlertMsg.getText();
			}else if(sAdultEmail.equals("NO")){
				x = emailIdAlertMsg.getText();
			}
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupEventContactInformationPageFields()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateGroupEventContactInformationPageFields()";
		}
	}	

	//************************************************************************************************
	//*********************Methods to validate Contact Information************************************
	//************************************************************************************************
	public String validateContactInformation(String toCheckBooking) throws InterruptedException, AWTException {
		try {
			String x = null;
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
				//scrollDown(driver);
				x = yourPackage.getText();
				waitAndClick(completeReservation);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS.................!!!!!!!!!!!");
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
				//scrollDown(driver);
				x = yourPackage.getText();
				waitAndClick(completeReservation);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS.................!!!!!!!!!!!");
			}
			System.out.println("Your Package is: "+x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateContactInformation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Contact Information for duplicates************************************
	//************************************************************************************************
	public void validateContactInformationForDuplicateCheck(String cName, String cPhone,String cEmail) throws InterruptedException, AWTException {
		try {
			Thread.sleep(3000);
			adultName.sendKeys(cName);
			this.phoneNumber.sendKeys(cPhone);
			adultEmail.sendKeys(cEmail);
			Thread.sleep(1000);
			specialInstructions.sendKeys(getSaltString());
			Thread.sleep(2000);
			scrollDown(driver);
			waitAndClick(completeReservation);
			System.out.println("CONTACT INFORMATION FOR DUPLICATE ENTRY SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformationForDuplicateCheck()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}



	public boolean validatePaymentOptions(String checkPaymentOptions) throws InterruptedException, AWTException {
		try {
			Thread.sleep(5000);
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentOptions()");
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Get Confirmation Information***************************
	//************************************************************************************************	
	public String validateGetConfirmationNumber() throws InterruptedException {
		try{
			JavascriptExecutor j = (JavascriptExecutor) driver;
			j.executeScript("document.getElementsByClassName(\"duplicateSubmit\")[0].click();");
		}catch(Exception e){
			System.out.println("Duplicate window not found, exception handled");
			e.printStackTrace();
		}
		
		try{
			WebDriverWait wait= new WebDriverWait(driver, 20);
			WebElement Element= wait.until(ExpectedConditions.elementToBeClickable(upSellNoThanks));
			Element.click();
			
		}catch(Exception e){
			System.out.println("USER EXCEPTION FOUND:");
			e.printStackTrace();
		}

		try {
			String confNum = waitTillVisibleAndGetText(confirmationNumber, confirmationNumberXPath);
			String [] confirmationNumber = confNum.split("#");
			if (confirmationNumber != null && confirmationNumber.length > 1) {
				System.out.println("Here is....."+ confirmationNumber[1]);
				System.out.println("GET CONFIRMATION NUMBER SUCCESS......................................................................!!!!!!!!!!!");		
				confNum = confirmationNumber[1];
			}
			return confNum;
		}catch(Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGetConfirmationNumber()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateGetConfirmationNumber()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Modify the Contact or Group Party Information********
	//************************************************************************************************

	/*
	 public void validateUpdateContactOrGroupPartyInfo() throws InterruptedException {
		Note: UpdateContactOrGroupParty link is missing in confirmation page - defect#
	}
	 */

	//************************************************************************************************
	//*********************Methods to validate Modify the Attendees***********************************
	//************************************************************************************************	
	public String validateUpdateAttendees() throws InterruptedException {
		try {
			Thread.sleep(5000);
			addChild.click();
			addAdult.click();
			applyChanges.click();
			String conMsg = confmsg.getText();
			return conMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendees()");
			return "Issue with Method: validateUpdateAttendees()";
		}
	}	

	//************************************************************************************************
	//*********************Methods to validate Update Attendees Confirmation**************************
	//************************************************************************************************
	public String validateUpdateAttendeesConfirmation() throws InterruptedException {
		try {
			Thread.sleep(5000);
			increaseChild.click();
			Thread.sleep(5000);
			increaseAdult.click();
			Thread.sleep(5000);
			applyChanges.click();
			String emsg = errormsg.getText();
			return emsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesConfirmation()");
			return "Issue with Method: validateUpdateAttendeesConfirmation()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Cancel Booking*****************************************
	//************************************************************************************************	
	public String validateCancelBooking(String bCancel) throws InterruptedException {
		try {
			Thread.sleep(3000);
			String cancelMsg=null;
			new WebDriverWait(driver, 6000).until(ExpectedConditions.visibilityOf(cancelReservationLink2));
			Actions action2=new Actions(driver);
			action2.moveToElement(cancelReservationLink2).click().build().perform();
			if(bCancel.equals("closeCancel"))
			{
				cancelMsg = cancelWindowTitle.getText();
				closeCancelPopupWindow.click();
			}

			if(bCancel.equals("confirmCancel")) {
				confirmConcelReservationBtn.click();
				waitUntilElementVisible(cancelConfirmationMsg);
				cancelMsg = cancelConfirmationMsg.getText();
			}
			System.out.println("MSG:"+cancelMsg);
			System.out.println("CANCEL FEATURE SUCCESS......................................................................!!!!!!!!!!!");		
			return cancelMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateCancelBooking()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateCancelBooking()";
		}	
	}

	//************************************************************************************************
	//********Methods to validate Birthday StarInformation in Reservation Summary page****************
	//************************************************************************************************
	public String validateOrganizationInformation() throws InterruptedException {
		try {
			String OrgNameInformation = orgNameinfo.getText();
			System.out.println("The Organization name is updated as " + OrgNameInformation);
			return OrgNameInformation;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateOrganizationInformation()");
			return "Issue with Method: validateOrganizationInformation()";
		}
	}

	//************************************************************************************************
	//*********************Mouse move Method to validate default Party item images********************
	//************************************************************************************************
	public void validateDefaultPartyItem() throws InterruptedException {
		try {
			partyitem.click();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDefaultPartyItem()");
		}

	}

	//************************************************************************************************
	//*********************Methods to validate Duplicate booking warning window***********************
	//************************************************************************************************	
	public String validateDuplidateBookingWarningWindow(String duplicateCheck) throws InterruptedException{
		try {
			Thread.sleep(10000);
			String x = null;
			if(duplicateCheck.equals("NewReservation")){
				System.out.println("Block to validate NewReservation");
				duplicateWindowNewReservationBtn.click();
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
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDuplidateBookingWarningWindow()");	
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateDuplidateBookingWarningWindow()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validateUpdateDateandTime***************************************
	//************************************************************************************************	
	public String validateUpdateDateandTime() throws InterruptedException {
		try {
			Thread.sleep(5000);
			waitAndClick(updatedateandtimeLink);
			Thread.sleep(5000);
			waitAndClick(currentSelectDatePlusOne);
			waitAndClick(selectPackage120min33); //should be removed
			Thread.sleep(5000);
			String updatedDate=modifiedDate.getText();
			System.out.println(updatedDate);
			return updatedDate;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateDateandTime()");	
			return "Issue with Method: validateUpdateDateandTime()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate No Time slot available message*************************
	//************************************************************************************************
	public String validateNoTimeSlotAvailableMsgFromBookEventPage() throws InterruptedException {
		try {
			String x=null;
			x = timeSlotNoLongerAvailableMsg.getText();
			System.out.println("Time slot block is displaying as: " +x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoTimeSlotAvailableMsgFromBookEventPage()");	
			return "Issue with Method: validateNoTimeSlotAvailableMsgFromBookEventPage()";
		}
	}

	public String validateNoTimeSlotAvailableMsg() throws InterruptedException {
		try {
			waitAndClick(applyChanges);
			String x=null;
			x = timeSlotNoLongerAvailableMsg.getText();
			System.out.println("Time slot block is displaying as: " +x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoTimeSlotAvailableMsg()");	
			//return "Issue with Method: validateNoTimeSlotAvailableMsg()";
			throw new AssertionError("A clear description of the failure", e);
		}
	}

	//************************************************************************************************
	//*********************Methods to validateUpdateAttendeesSelectAndDatePage************************
	//************************************************************************************************	
	public String validateUpdateAttendeesSelectAndDatePage(int aCount) throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(2000);
			waitAndClick(updatedateandtimeLink);
			if(aCount==1) {
				Thread.sleep(5000);
				addORRemoveChildORAdult(addAdult,200); 
				applyChanges.click();
				x = timeSlotNoLongerAvailableMsg.getText();		
			}else if(aCount==0) {
				Thread.sleep(2000);
				addChild.click();
				Thread.sleep(5000);
				addAdult.click();
				Thread.sleep(2000);
				applyChanges.click();
			}
			return x;	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesSelectAndDatePage()");	
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateUpdateAttendeesSelectAndDatePage()";
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
				addORRemoveChildORAdult(removeAdult,400); 
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


	//************************************************************************************************
	//*********************Methods to validateUpdateAttendeesConfirmation*****************************
	//************************************************************************************************	
	public String validateUpdateAttendeesConfirmation(int aCount) throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(5000);
			if(aCount==1) {
				Thread.sleep(5000);
				addORRemoveChildORAdult(increaseAdult,400); 
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
			System.out.println("Child and Adult attendees are modified Successfully......................................................................!!!!!!!!!!!");
			return x;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateAttendeesConfirmation()");
			return "Issue with Method: validateUpdateAttendeesConfirmation()";
		}
	} 
	//************************************************************************************************
	//*********************Methods to validateDateAndTimeConfirmation*********************************
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
	//*********************Methods to validateUpdateAttendeesSelectAndDatePage************************
	//************************************************************************************************	
	public void validateUpdateGroupPartyInfo() throws InterruptedException {
		try {
			Thread.sleep(5000);
			waitAndClick(updateContactInfoLink);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateGroupPartyInfo()");
		}
	} 

	//************************************************************************************************
	//*********************Methods to validate Contact Information************************************
	//************************************************************************************************
	public void validateUpdateContactInformation() throws InterruptedException, AWTException {
		try {
			adultName.clear();			
			adultName.sendKeys("John");
			Thread.sleep(1000);
			adultName.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(1000);
			adultEmail.clear();
			adultEmail.sendKeys("Baliga20@gmail.com");
			Thread.sleep(1000);
			specialInstructions.sendKeys(getSaltString());
			Thread.sleep(1000);
			//scrollDown(driver);
			waitAndClick(completeReservation);
			System.out.println("CONTACT INFORMATION ENTRY SUCCESS.................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateContactInformation()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Group Party Information********************************
	//************************************************************************************************
	public boolean validateUpdateGroupPartyInformation() throws InterruptedException, AWTException {
		try {
			boolean x=false;
			Thread.sleep(2000);
			organizationName.clear();
			organizationName.sendKeys("Genisys");
			Thread.sleep(1000);
			organizationName.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(1000);
			organizationPhone.clear();
			organizationPhone.sendKeys("9902639713");
			Thread.sleep(1000);
			organizationExtension.clear();
			organizationExtension.sendKeys("1443");
			Thread.sleep(1000);
			x=true;
			System.out.println("GROUP PARTY INFORMATION UPDATED SUCCESS......................................................................!!!!!!!!!!!");
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateGroupPartyInformation()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Modify the Group Event Package********
	//************************************************************************************************	
	public void validateChangePackage() throws InterruptedException {
		try {
			Thread.sleep(5000);
			changePackageLink.click();
			Thread.sleep(5000);
			waitAndClick(select90minPackage);
			Thread.sleep(1000);
			waitAndClick(update90minPackage);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangePackage()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validateGroupEventPackageInformation*********************************
	//************************************************************************************************
	public String validatePackageUpdateInformation() throws InterruptedException {
		try {
			boolean conMsg=confmsg.isDisplayed();
			System.out.println("ThePackage is updated successfully" + conMsg);
			String ModifiedPackage = modifiedPackageName.getText();
			System.out.println("The Modified Package is " + ModifiedPackage);
			return ModifiedPackage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackageUpdateInformation()");
			return "Issue with Method: validatePackageUpdateInformation()";
		}
	}

	public String validateErrorMoreThan180days(int tubookingDateFor180days) throws InterruptedException, AWTException {
		try {
			String x=null;
			Thread.sleep(3000);
			childrenInputBox.sendKeys("10");
			adultListBox.click();
			tenAdultListItem.click();
			Thread.sleep(1000);
			dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
			Thread.sleep(1000);
			//New code it check browser, if  its browser it called different robo base method.
			if(propv.getProperty("GUI").equals("chrome")){
				enterDateUsingRobotForChrome(tubookingDateFor180days);
			}else{
				enterDateUsingRobot(tubookingDateFor180days);//0 for todays, 1,2,3,..n for future date.
			}
			Thread.sleep(1000);
			seeAvailablity.click();
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
			Thread.sleep(2000);
			//scrollUp(driver);
			currentSelectDatePlusOne.click();
			Thread.sleep(1000);
			waitAndClick(selectPackage60min1);		
			scrollDown(driver);
			Thread.sleep(1000);
			x = errorMsgAt180days.getText();	
			Thread.sleep(1000);
			System.out.println("Message is......................"+x);
			return x;		
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateErrorMoreThan180days()");
			return "Issue with Method: validateErrorMoreThan180days()";
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
	//*********************Methods to validatePackageprice********************************************
	//************************************************************************************************	
	// Get the Child price based on the package chosen 
	public String validatePackageprice(String S_price) {
		try {
			double a,b,cost;
			String c = null;
			if(S_price.equals("60min")) {
				String _60min_Packagevalue= _60min_price.getText();
				String Price=_60min_Packagevalue.substring(1);
				System.out.println("The 60min Package Child Price is >>"+Price);
				cost = Double.valueOf(Price);			
				System.out.println("The 60min Package Child Price is >>"+cost);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);

			}
			else if (S_price.equals("90min")){
				String _90min_Packagevalue= _90min_price.getText();
				String Price=_90min_Packagevalue.substring(1);
				cost = Double.valueOf(Price);			
				System.out.println("The 90min Package Child Price is >>"+cost);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);

			}else if (S_price.equals("120min")){
				String _120min_Packagevalue= _120min_price.getText();
				String Price=_120min_Packagevalue.substring(1);
				cost = Double.valueOf(Price);
				a=10;
				b=a*cost;
				c= "$"+b+"0";
				System.out.println("The Total amount is >>"+c);
				System.out.println("The MEGASUPERSTAR Package Child Price is >>"+cost);}
			else {System.out.println("You are not chosen the right package!!!");}

			return c;

		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackageprice()");
			return "Issue with Method: validatePackageprice()";
		}
	}
	
	
	/////////////////////////////BDDD////////////////////////////////
	public boolean validateMinMaxChildren(int min, int max)
	{
		try {
		List<WebElement> options = selectChildren.findElements(By.tagName("option"));
		String minChildren = options.get(1).getText();
		String minValue = minChildren.substring(0,1);
		int minDropdownValue = Integer.parseInt(minValue);
		String lastValue = options.get(options.size()-1).getText();
		String maxChildren = lastValue.substring(0,3);
		int maxDropdownValue = Integer.parseInt(maxChildren);
		System.out.println(min);
		System.out.println(minDropdownValue);
		System.out.println(max);
		System.out.println(maxDropdownValue);
		selectUsingValue(selectChildren,minValue);
		Assert.assertEquals(min, minDropdownValue,"Found issue in Minchildren");
		selectUsingValue(selectChildren,maxChildren);
		Assert.assertEquals(max, maxDropdownValue,"Found issue in Maxchildren");
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}
	
	public boolean validateMinMaxAdult(int min, int max)
	{
		try {
		List<WebElement> options = selectAdult.findElements(By.tagName("option"));
		String minAdult = options.get(1).getText();
		String minValue = minAdult.substring(0,1);
		int minDropdownValue = Integer.parseInt(minValue);
		String lastValue = options.get(options.size()-1).getText();
		String maxAdult= lastValue.substring(0,3);
		int maxDropdownValue = Integer.parseInt(maxAdult);
		System.out.println(min);
		System.out.println(minDropdownValue);
		System.out.println(max);
		System.out.println(maxDropdownValue);
		selectUsingValue(selectAdult,minValue);
		Assert.assertEquals(min, minDropdownValue,"Found issue in MinAult");
		selectUsingValue(selectAdult,maxAdult);
		Assert.assertEquals(max, maxDropdownValue,"Found issue in MaxAdult");
		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
			return false;
		}
	}
	
	public void validateChildrenAdultDateEvent(String children, String adult)
	{
		try {
			Thread.sleep(2000);
			waitUntilElementClickable(selectChildren);
			selectUsingValue(selectChildren,children);
			selectUsingValue(selectAdult,adult);
			datePicker.click();
			Thread.sleep(500);
			nextMonthdate.click();
			Thread.sleep(500);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(3000);
			timeslotListItem.click();
			timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			//timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			timeslotListItem.sendKeys(Keys.ENTER);
			Thread.sleep(1000);			
			//timeslotListItem.click();
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS.....");
		}catch(Exception e)
	       {
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
			}
	}

	public boolean validateNoTimeSlotAvailableMsgs(){   //BDD CHANGE
		try {
			//waitAndClick(applyChanges);
			Thread.sleep(2000);
			 boolean noTimeSlotMsg = noTimeSlot.isDisplayed();
			System.out.println("NO TIME SLOT MSG SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("NO TIME SLOT MSG "+noTimeSlotMsg);
			return noTimeSlotMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoTimeSlotAvailableMsg()");
			throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}
	
	public void selectPackage(String pkg)
	{
		if(pkg.equals("60min")) {
			waitAndClick(book60minPackage);
		}
		else if(pkg.equals("90min"))
		{
			waitAndClick(book90minPackage);
		}
		else if(pkg.equals("120min"))
		{
			waitAndClick(book120minPackage);
		}
	}
	
	public boolean validateNoPayment(String checkNoStore) throws InterruptedException, AWTException {
		
		boolean x = true;
		Thread.sleep(1000);
		if(checkNoStore.equals("NO")){
			try {
			boolean var = inStoreRadioBtn.isDisplayed() && creditCardRadioBtn.isDisplayed();
			System.out.println("Payment option present"+var);
			x=var;
		    }
			catch(Exception e)
			{
			System.out.println("Payment option  not present");
			return false;
			}
	
	}
		
		return x;
}
	
	
	public boolean validateGroupEventContactInformationPageFields_BDD(String sOrgName,String sOrgPhone,String sOrgType,String sAdultName,String sEnterPhoneNumberUsingRobot,String sAdultEmail) throws InterruptedException, AWTException {
		try {
			Thread.sleep(2000);
			String x = null;
			if(sOrgName.equals("YES")){
				organizationName.clear();
				organizationName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				organizationName.sendKeys(getSaltString());
			}else {
				organizationName.clear();
				organizationName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				organizationName.sendKeys("");
			}
			
			if(sOrgPhone.equals("YES")){
				organizationPhone.clear();
				organizationPhone.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				organizationPhone.sendKeys(getSaltNumber());
			}else {
				organizationPhone.clear();
				organizationPhone.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				organizationPhone.sendKeys("");
			}
			if(sOrgType.equals("YES")){
				orgType.click();
				school.click();
			}
			else {
				System.out.println("");
			}
			
			if(sAdultName.equals("YES")){
				adultName.clear();
				adultName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultName.sendKeys(getSaltString());
			}else {
				adultName.clear();
				adultName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultName.sendKeys("");
			}
			
			if(sEnterPhoneNumberUsingRobot.equals("YES")){
				phoneNumber.clear();
				phoneNumber.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				this.phoneNumber.sendKeys(getSaltNumber());
			}else {
				phoneNumber.clear();
				phoneNumber.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				this.phoneNumber.sendKeys("");
			}
			;
			if(sAdultEmail.equals("YES")){
				adultEmail.clear();
				adultEmail.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultEmail.sendKeys(getSaltEmail());
			}else {
				adultEmail.clear();
				adultEmail.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultEmail.sendKeys("");
			}
			
			specialInstructions.clear();
			specialInstructions.sendKeys(getSaltString());

			Thread.sleep(1000);
			waitAndClick(completeReservation);
			Thread.sleep(2000);
			boolean var = false;
			var=alertDanger.isDisplayed();
			x=alertDanger.getText();
			System.out.println("alert is"+x);
			return var;
		} catch (Exception e) {
			e.printStackTrace();
		
		System.out.println("Issue with Method: validateGroupEventContactInformationPageFields()");
		throw new AssertionError("A clear description of the failure", e);
			//return false;
		}
	}
	
	public boolean validateGroupPartyInformation_BDD() throws InterruptedException, AWTException {
		try {
			Thread.sleep(3000);
			boolean x=false;
			organizationName.clear();
			organizationName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
			organizationName.sendKeys(getSaltString());
			organizationPhone.clear();
			organizationPhone.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
			organizationPhone.sendKeys(getSaltNumber());
			orgType.click();
			school.click();
			x=true;
			System.out.println("GROUP PARTY INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateGroupPartyInformation()");
			return false;
		}
	}
	
	public String validateContactInformation_BDD(String toCheckBooking) throws InterruptedException, AWTException {
		try {
			String x = null;
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
				//scrollDown(driver);
				
				waitAndClick(completeReservation);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS.................!!!!!!!!!!!");
			}else{
				adultName.clear();
				adultName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultName.sendKeys(getSaltString());
				
				phoneNumber.clear();
				phoneNumber.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				this.phoneNumber.sendKeys(getSaltNumber());
				adultEmail.clear();
				adultEmail.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				adultEmail.sendKeys(getSaltEmail());
				specialInstructions.clear();
				specialInstructions.sendKeys(getSaltString());
				
				waitAndClick(completeReservation);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS.................!!!!!!!!!!!");
			}
			System.out.println("Your Package is: "+x);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
			throw new AssertionError("A clear description of the failure", e);
			//return "Issue with Method: validateContactInformation()";
		}
	}
	
	public void editNumOfChildrenInformationEvent(String children) throws InterruptedException
	{
		Thread.sleep(2000);
		try
		{
			/*
			JavascriptExecutor ex=(JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click()", editPartyInfo);
			//waitForElementClick(editPartyInfo);
			//editPartyInfo.click();
			
			selectUsingValue(editChildren,"9");
			Thread.sleep(2000);
			selectUsingValue(editAdult,"150");
			waitForElementClick(datePickertEditPage);
			datePickertEditPage.click();
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[15]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(2000);
			
			*/
			waitUntilElementClickable(editPartyInfo);
			JavascriptExecutor ex=(JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click()", editPartyInfo);
			//editPartyInfo.click();
			Thread.sleep(3000);
			waitUntilElementClickable(editChildren);
			editChildren.click();
			oneHundredEightyKidsListItem.click();
			Thread.sleep(2000);
		}catch(Exception e) {
			
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
		}
	}
		
		public void overbookingInEvent() throws InterruptedException
		{
			Thread.sleep(2000);
			try
			{

				waitUntilElementClickable(editPartyInfo);
				JavascriptExecutor ex=(JavascriptExecutor)driver;
				ex.executeScript("arguments[0].click()", editPartyInfo);
				//editPartyInfo.click();
				Thread.sleep(3000);
				waitUntilElementClickable(editChildren);
				editChildren.click();
				oneHundredEightyKidsListItem.click();
				Thread.sleep(2000);
				editAdult.click();
				oneHundredEightyAdultsListItem.click();
				Thread.sleep(2000);
				datePicker.click();
				Thread.sleep(500);
				nextMonthdate.click();
				Thread.sleep(500);
				String xpathv1 = "(//div[@class='datevalue currmonth']/span)[15]";
				WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
				ele1.click();
				Thread.sleep(2000);
				
			}catch(Exception e) {
				
				e.printStackTrace();
				throw new AssertionError("A clear description of the failure", e);
			}
				
}
	
	public double validateChoosePackageAndGetPriceEvent_BDD(String bPackage) throws InterruptedException {
		double pacakgePrice = 0;
		try{
			
			Thread.sleep(500);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			if(bPackage.equals("60min"))
			{
				String sixtyPrice = sixtyminPackPrice.getText();
				System.out.println("sixtyminPackPrice"+sixtyPrice);
				String price = sixtyPrice.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("sixtyminPackPrice"+pacakgePrice);
				
				
			}
			else if(bPackage.equals("90min"))
			{
				String nintyminPrice = nintyminPackPrice.getText();
				System.out.println("nintyminPrice"+nintyminPrice);
				String price = nintyminPrice.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("nintyminPrice"+pacakgePrice);
				
			}
			else if(bPackage.equals("120min"))
			{
				String onetwenty = onetwentyminPackPrice.getText();
				System.out.println("onetwenty"+onetwenty);
				String price = onetwenty.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("onetwenty"+pacakgePrice);
				
			}
			System.out.println("CHOOSE PACKAGE is ");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChoosePackageAndGetPrice_BDD()");
		}
		return pacakgePrice;
	}
	
	
	public double estimatedTotalWithUpsellEvent_BDD(int children,int adult,double packagePrice)
	{ 
		double calculatedTotal =0;
		try{
		
		
		double calculatedKidsAmount = children*packagePrice;
		int calculatedAdultAmount = adult*0;
		System.out.println("calculatedKidsAmount "+calculatedKidsAmount);  
		System.out.println("calculatedAdultAmount "+calculatedAdultAmount);  
		
		 
		String childrenAmt = childrenTotalAmount.getText();
		String totalChildrenAmt = childrenAmt.substring(1);
		double totalChildrenAmount = Double.parseDouble(totalChildrenAmt);
		System.out.println("totalChildrenAmount "+totalChildrenAmount);  
		
		String adultAmt = AdultTotalAmount.getText();
		String totalAdultAmt = adultAmt.substring(1);
		double totalAdultAmount = Double.parseDouble(totalAdultAmt);
		System.out.println("totalAdultAmount "+totalAdultAmount);
		
		String estimatedAmt =  estimatedTotalPrice.getText();
		String depositTotalAmt = estimatedAmt.substring(1);
		double totalestimatedAmt = Double.parseDouble(depositTotalAmt);
		System.out.println("totalestimatedAmt "+totalestimatedAmt);
		if(calculatedKidsAmount == totalChildrenAmount)
		{
			System.out.println("1");
			if(calculatedAdultAmount == totalAdultAmount )
			{
				System.out.println("2");
			calculatedTotal = calculatedKidsAmount+calculatedAdultAmount;
			return calculatedTotal;
			}
		}
		
		
		
				
	}catch(Exception e)
	{
		e.printStackTrace();
		throw new AssertionError("A clear description of the failure", e);
	}
		System.out.println("calculatedTotal"+calculatedTotal);
		return calculatedTotal;
	
}
	
	public double estimatedTotalEvent()
	{
		String estimatedAmt =  estimatedTotalPrice.getText();
		String depositTotalAmt = estimatedAmt.substring(1);
		double totalestimatedAmt = Double.parseDouble(depositTotalAmt);
		System.out.println("totalestimatedAmt "+totalestimatedAmt);
		return totalestimatedAmt;
	}
	public void validateChildrenAdultDateEvent_BDD(String children, String adult)
	{
		try {
			Thread.sleep(500);
			selectUsingValue(selectChildren,children);
			selectUsingValue(selectAdult,adult);
			datePicker.click();
			Thread.sleep(500);
			nextMonthdate.click();
			Thread.sleep(500);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(3000);
			
		}catch(Exception e)
	       {
			e.printStackTrace();
			throw new AssertionError("A clear description of the failure", e);
			}
	}
	
	public boolean sendEventPartyInvitation()
	{
		try
		{
			waitUntilElementClickable(sendPartyInvitationsLink);
			JavascriptExecutor ex=(JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click()", sendPartyInvitationsLink);

		switchToChildWindow();
		
		waitUntilElementVisible(sendInvitationsLogo);

		switchToMainWindow();

		return true;
		}catch(Exception e)
		{
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean selectPackageEvent(String pkg)
	{
		boolean var1=false;
	
		try {
		if(pkg.equals("60min")) {
			waitAndClick(book60minPackage);
			 
		}
		else if(pkg.equals("90min"))
		{
			waitAndClick(book90minPackage);
		}
		else if(pkg.equals("120min"))
		{
			waitAndClick(book120minPackage);
		}
		Thread.sleep(3000);
		var1 = titlePayment.isDisplayed();
		 return var1;
	}catch(Exception e)
		{
		e.printStackTrace();
		}
		
		 return var1;
}
}



