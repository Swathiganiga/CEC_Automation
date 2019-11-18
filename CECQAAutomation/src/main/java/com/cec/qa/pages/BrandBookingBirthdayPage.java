package com.cec.qa.pages;
import java.awt.AWTException;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;


import com.cec.qa.base.BaseTest;
import com.cec.qa.util.TestUtil;
public class BrandBookingBirthdayPage extends BaseTest{

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

	@FindBy(xpath="//*[@id='currentStore']/a/span")
	WebElement commonLocation;
	
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
	
	@FindBy(xpath="//*[@id='stores']/li[1]/div/footer/a")
	WebElement selectFirstStoreBtnMaven;
	

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
	
	@FindBy(xpath="//button[@class='btn btn-link collapsed']")
	WebElement buttonSuper;

	//************************************************************************************************
	//*********************BOOK A BIRTHDAY - SELECT CHILD,ADULT & DATE********************************
	//************************************************************************************************

	@FindBy(xpath="(//select[@class='c-custom-form__textbox ng-untouched ng-pristine ng-valid'])[1]")
	WebElement childrenListBox;

	@FindBy(xpath="//select[@class='c-custom-form__textbox ng-valid ng-touched ng-dirty']/option")
	WebElement childrenDrpdownList;

	@FindBy(xpath="(//select[@class='c-custom-form__textbox ng-untouched ng-pristine ng-valid'])[1]")
	WebElement adultListBox;

	@FindBy(xpath="//select[@class='c-custom-form__textbox ng-valid ng-dirty ng-touched']")
	WebElement adultDrpdownList;

	@FindBy(xpath="//select[@class='c-custom-form__textbox ng-valid ng-dirty ng-touched']/option[2]")
	WebElement minChildrenListItem;

	@FindBy(xpath="//select[@class='c-custom-form__textbox ng-valid ng-dirty ng-touched']/option[197]")
	WebElement maxChildrenListItem;

	@FindBy(xpath="//select[@class='c-custom-form__textbox ng-untouched ng-pristine ng-valid']/option[200]")
	WebElement maxAdultListItem;
	
	@FindBy(xpath="//*[@id='head']/div[1]/div/div[3]/div[2]/div[1]/form/my-date-picker/div/div[1]/input")
	WebElement selectPartyDate;
	

	@FindBy(xpath="//span[@class='mydpicon icon-mydpcalendar']")
	WebElement datePicker;

	@FindBy(xpath="//button[@class='headerbtn mydpicon icon-mydpright headerbtnenabled']")
	WebElement nextMonthdate;
	
	@FindBy(xpath="//*[@id='head']/div[1]/div/div[3]/div[2]/div[2]/div/select")
	WebElement PartyTime;
	//select[@class='c-custom-form__textbox ng-untouched ng-pristine ng-valid']
	
	@FindBy(xpath="//*[@id='select_time_entryPage']")
	WebElement timeslotListItem;

	@FindBy(xpath="//button[@class='btn--primary btn--purple']")
	WebElement seeAvailablity;
	
	@FindBy(xpath="//div[@class='alert-warning alert custom']") ////////ADDED BDDD
	WebElement noTimeSlot;

	@FindBy(xpath="//*[@id='head']/div[1]/div/div[3]/div[1]/div[1]/div[1]/select")  ///ADDED BDD
	WebElement selectChildren;  
	
	@FindBy(xpath="//select[@id='select_children_entryPage']")
	WebElement selectKids;
	
	@FindBy(xpath="//*[@id='head']/div[1]/div/div[3]/div[1]/div[2]/div[1]/select")///ADDED BDD
	WebElement selectAdult;
	//************************************************************************************************
	//*********************SELECT A DATE & TIME - SELECT PACKAGE OR TIME SLOT*************************
	//************************************************************************************************

	@FindBy(xpath="(//a[@class='c-blog-card__link' and text()='Book this package'])[1]")
	WebElement selectPackageStar;

	@FindBy(xpath="(//a[@class='c-blog-card__link' and text()='Book this package'])[2]")
	WebElement selectPackageSuperStar;

	@FindBy(xpath="(//a[@class='c-blog-card__link' and text()='Book this package'])[3]")
	WebElement selectPackageMegaStar;

	@FindBy(xpath="(//a[@class='c-blog-card__link' and text()='Book this package'])[4]")
	WebElement selectPackageUltimateMegaStar;

	@FindBy(xpath="(//a[@class='c-blog-card__link' and text()='Book this package'])")
	WebElement selectPackageVIPMegaStar;

	//Up sell pop-up

	@FindBy(xpath="//button[text()='No Thanks']")
	WebElement upSellNoThanks;
	
	@FindBy(xpath="//*[@id='upsellModal']/div/button[2]")
	WebElement upSellNoThankss;
	

	String upSellNoThanksXpath = "//button[text()='No Thanks']";

	String upSellNoThanksXpaths= "//*[@id='upsellModal']/div/button[2]";
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
	
	@FindBy(xpath="//*[@id='phone']")
	WebElement phoneNumber;
	
	
	@FindBy(xpath="//*[@id='email']")
	WebElement email;

	@FindBy(xpath="//input[@id='email']")
	WebElement adultEmail;

	@FindBy(xpath="//textarea[@id='SpecialInstructions']")
	WebElement specialInstructions;

	@FindBy(xpath="//label[text()='In store within 48 hours']")
	WebElement inStoreRadioBtn;

	@FindBy(xpath="//div[@class='col-sm-12']/input")
	WebElement offLineCheckBox;

	//@FindBy(xpath="//button[@class='btn--primary btn--purple book-party bookParty']") //alternative for complete reservations locator.
	@FindBy(xpath="//button[@class='btn--primary btn--purple book-party bookParty']") ////div[text()='Complete Reservation']
	WebElement completeReservation;

	@FindBy(xpath="//h3[text()='Payment Information']")
	WebElement justToClickOnPageBeforeScroll;

	@FindBy(xpath="(//div[@class='c-info-card__package'])[2]")
	WebElement yourPackage;

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
	
	//reservationSummury
	@FindBy(xpath="//div[@id='slick-slide00']//div[@class='menu__wrapper']//div[@class='menu__content']//div[@class='item__inventory clearfix']//div//span[@class='price']")
	WebElement priceOfAdditionalItem;  ///BDDDDDDDDDDDDDDDDDDDDDDDDDDDDDD
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[2]/span/span")
	WebElement depositDue;
	
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[6]/span[4]/span")
	WebElement totalPriceOfAdditionalItem;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[6]/span[1]/span")
	WebElement childrenTotalAmount;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[6]/span[2]/span")
	WebElement AdultTotalAmount;
	
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[6]/span[2]/span")
	WebElement adultTotalAmount;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[7]/div[7]/span[1]/span")
	WebElement estimatedTotal;
	
	@FindBy(xpath="//div[contains(@class,'c-info-card')]//div//a[contains(@class,'c-info-card__link')][contains(text(),'Update Contact or Birthday Star Information')] ")
	WebElement updateContactORBirthdayInfo;
	
	//Edit Party Information

	@FindBy(xpath="(//button[@class='btn--primary btn--purple'])[1]")
	WebElement updateBtn;

	//Update Booking

	@FindBy(xpath="//a[text()='Change location']")
	WebElement changeLocation; 

	@FindBy(xpath="(//a[text()='Update Contact or Birthday Star Information'])[2]")
	WebElement updateContactOrBirthdayStarInfo; 

	@FindBy(xpath="(//a[text()='Edit Party Information'])[2]")
	WebElement editPartyInformationLink;

	@FindBy(xpath="//a[text()='Change/Upgrade']")
	WebElement changePackageLink;

	@FindBy(xpath="//div[@class='c-info-card']//div//a[@class='c-info-card__link'][contains(text(),'Send Free Party Invitations')] ")
	WebElement sendPartyInvitationsLink;

	@FindBy(xpath="//img[@class='logo']")
	WebElement sendInvitationsLogo;

	//Reservation Summary validate Info
	@FindBy(xpath="(//span[contains(text(),'John (6yrs)  ')])[2]")
	WebElement bstarinfo;

	//@FindBy(xpath="//p[contains(text(),'SUPER STAR')]")
	//WebElement modifiedPackageName;

	@FindBy(xpath="(//span[@class='-bold'])[1]")
	WebElement modifiedChild;

	@FindBy(xpath="(//span[@class='-bold'])[2]")
	WebElement modifiedAdult;

	@FindBy(xpath="(//span[@class='-bold'])[3]")
	WebElement modifiedDate;

	@FindBy(xpath="(//span[@class='-bold'])[4]")
	WebElement modifiedTime;

	//Cancel Booking

	@FindBy(xpath="//a[@class='cancel-close']")
	WebElement closeCancelPopupWindow;

	
	
	@FindBy(xpath="(//a[text()='Cancel Reservation'])[2]")
	WebElement cancelReservationLink;

	@FindBy(xpath="//div[@class='c-info-card']//div//a[@class='c-info-card__link'][contains(text(),'Cancel Reservation')]")
	WebElement cancelReservationLink2;
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

	//Validate Book A Birthday or Edit Party missing message
	@FindBy(xpath="//div[@class='alert-danger alert custom']")
	WebElement partydateMsg;//Message! Please select Party date.

	@FindBy(xpath="//div[@class='alert-danger alert custom']")
	WebElement partytimeMsg;//Message! Please select Party date.

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement requiredDataMsg; //Message! Please select all required data

	//@FindBy(xpath="//h4[text()='You cannot book a party more than 90 days in advance']")
	//WebElement errorMsgAt90days;

	@FindBy(xpath="//h4[text()='Your reservation has been updated']")
	WebElement confmsg;

	@FindBy(xpath="//h4[text()='A name for the person responsible for the party has not been set.']")
	WebElement errorMsgAtPaymentsPage;

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement errorMsgAtTimeslot; //Message! The requested package was not found for this time slot

	@FindBy(xpath="(//div[@class='alert-danger'])")
	WebElement errorMsgVIPTimeslotLessAttendees; //Message! This time slot requires a minimum of 10 children to book

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
	
	
	@FindBy(xpath="//*[@id='3510']/div[2]/div/div[1]/div[2]/div/span[1]")
	WebElement STAR_Package_price;

	@FindBy(xpath="//*[@id='3513']/div[1]/div/div[1]/div[2]/div/span[1]")
	WebElement SUPERSTAR_Package_price;

	@FindBy(xpath="//*[@id='3516']/div[2]/div/div[1]/div[2]/div/span[2]")
	WebElement MEGASUPERSTAR_Package_price;

	@FindBy(xpath="//div[@data-type='VIP MEGA SUPER STAR'] //span[@class='price']")
	WebElement VIPMEGASUPERSTAR_Package_price;
	
	////////////////////////////////////BDDD///////////////////////////////////////////////////////////////////
	/**
	 * @author swathi
	 * ModifyPackagePopupPage element locators
	 */

	
	@FindBy(xpath="/html/body/section/app-root/app-reservation-details/div[1]/app-change-package/div/div/div/div[2]/div[1]/div[1]/div[1]/span")
	WebElement starPackage;  
	
	
	@FindBy(xpath="/html/body/section/app-root/app-reservation-details/div[1]/app-change-package/div/div/div/div[2]/div[1]/div[1]/div[2]/span")
	WebElement superStarPackage; 
	
	@FindBy(xpath=" /html/body/section/app-root/app-reservation-details/div[1]/app-change-package/div/div/div/div[2]/div[1]/div[1]/div[3]/span")
	WebElement megaStarPackage;
	
	@FindBy(xpath="/html/body/section/app-root/app-reservation-details/div[1]/app-change-package/div/div/div/div[2]/div[1]/div[1]/div[4]/span")
	WebElement ultimatemegaPackage;
	                
	
	@FindBy(xpath="//button[contains(text(),'Book this package')]")
	WebElement confirmaChange;
	
	@FindBy(xpath="/html/body/section/app-root/app-reservation-details/div[1]/app-change-package/div/div/div/div[1]/span/img")
	WebElement cancelPopUp;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[6]/div[1]")
	WebElement modifiedPackageName;
	
	@FindBy(xpath="//*[@id='reservationFinal']/div/div[2]/div/div[4]/div[2]/app-side-menu/section/div/div[1]/div[6]/div[2] ")
	WebElement modifyPackage; 
	/////EDIT PARTY INFO PAGE///////////////
	
	@FindBy(xpath="//div[@class='c-info-card']//a[@class='c-info-card__link'][contains(text(),'Edit Party Information')]")
	WebElement editPartyInfo;
	
	@FindBy(xpath="//select[@id='select_children_editPage']")
	WebElement editChildren;  
	
	@FindBy(xpath="//select[@id='select_adult_editPage']")
	WebElement editAdult; 
	
	@FindBy(xpath="//div[@class='alert-warning alert custom']")
	WebElement noTimeSlotAvailableEditPage;

	
	@FindBy(xpath=" //option[@id='children_180_editPage']")
	WebElement oneHundredEightyKidsListItem;

	@FindBy(xpath="//div[@class='c-widget selected-highlight']//div[@class='c-widget__container']")
	WebElement highlightedPackage;
	//************************************************************************************************
	//*********************LOCATORS Initialization****************************************************
	//************************************************************************************************

	public BrandBookingBirthdayPage(){
		PageFactory.initElements(driver, this);
	}

	//************************************************************************************************
	//*********************Methods to validate Search Location****************************************
	//************************************************************************************************
	public void validateSearchLocation(String cLocation) throws InterruptedException {
		
		try{
			Thread.sleep(1000);
			scrollDown(driver);
			scrollDown(driver);
			//if(waitAndGetText(commonLocation).contains("Change")){  //changeLocationLink1-----BDDDDD CHANGE
				//waitAndClick(changeLocationLink2);
			//}else{
			//	waitAndClick(changeLocationLink1);//changeLocationLink1-----BDDDDD CHANGE
			//}
			waitAndClick(commonLocation);
			locationSearchBox.sendKeys(Keys.CONTROL, "a");
			
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
			
				locationSearchBox.sendKeys(cLocation);
			}
			Thread.sleep(1000);
			//Actions act = new Actions(driver);
			//act.moveToElement(searchIcon).click().click().perform();
			waitAndClick(searchIcon);	
			System.out.println("SELECT LOCATION SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with method:  validateSearchLocation()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Store*******************************************
	//************************************************************************************************
	public void validateSelectStore() throws InterruptedException {
		try {
			//scrollDown(driver);
			Thread.sleep(3000);
			waitUntilElementVisible(selectFirstStoreBtnMaven);
			waitAndClick(selectFirstStoreBtnMaven);

			System.out.println("SELECT STORE SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Methods: validateSelectStore()");
			throw new AssertionError("A clear description of the failure", e);
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
			Thread.sleep(500);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			
			
			if((bPackage.equals("SuperStar"))|| (bPackage.equals("SUPER STAR")))
			{
				waitAndClick(bookNowSuperStarBtn);
			}
			else if((bPackage.equals("MegaStar")) || (bPackage.equals("MEGA SUPER STAR")))
			{

				waitAndClick(bookNowMegaStarBtn);
			}
			else
			{
				waitAndClick(bookNowStarBtn);
				
			}
			Thread.sleep(3000);
			System.out.println("CHOOSE PACKAGE is ");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChoosePackage()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Child, Adult and Date***************************
	//************************************************************************************************
	public void validateSelectChildAdultAndDate(int bookingDate,String timeslot) throws InterruptedException, AWTException {
		try{
			Thread.sleep(500);
			childrenListBox.click();
			Thread.sleep(500);
			childrenListBox.sendKeys(Keys.ARROW_DOWN);
			//childrenListBox.sendKeys(Keys.ARROW_DOWN);
			childrenListBox.sendKeys(Keys.ENTER);
			//tenChildrenListItem.click();
			Thread.sleep(500);
			adultListBox.click();
			Thread.sleep(500);
			//oneAdultListItem.click();
			adultListBox.sendKeys(Keys.ARROW_DOWN);
			//adultListBox.sendKeys(Keys.ARROW_DOWN);
			adultListBox.sendKeys(Keys.ENTER);
			Thread.sleep(500);
			datePicker.click();
			Thread.sleep(500);
			nextMonthdate.click();
			Thread.sleep(2000);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(3000);
			timeslotListItem.click();
			timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			//timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			timeslotListItem.sendKeys(Keys.ENTER);
			//String xpathv = "//select[@class='c-custom-form__textbox ng-pristine ng-valid ng-touched']/option[4]";
			//WebElement ele = driver.findElement(By.xpath(xpathv));	
			//ele.click();
			//Select time = new Select(ele);
			//time.selectByIndex(3);//10:00 AM - 12:00 PM
			/*10:00 AM - 12:00 PM     
			11:00 AM - 01:00 PM     
			12:00 PM - 02:00 PM     
			01:00 PM - 03:00 PM     
			03:00 PM - 05:00 PM     
			05:00 PM - 07:00 PM    */


			/*int x = ele.size();
			System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			for(int i=0;i<=x;i++) {
				System.out.println(ele.get(i).getText());
			}
			System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				//enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			 */
			Thread.sleep(1000);			
			//timeslotListItem.click();
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate()");
		}
	}

	public void validateSelectChildAdultDateAndTime(int bookingDate,String timeslot) throws InterruptedException, AWTException {
		try{
			Thread.sleep(2000);
			childrenListBox.click();
			Thread.sleep(2000);
			selectDrpDwnByText(childrenDrpdownList,"5 Children");
			Thread.sleep(2000);
			adultListBox.click();
			Thread.sleep(2000);
			selectDrpDwnByText(adultDrpdownList,"2 Adults");
					Thread.sleep(2000);
			datePicker.click();
			Thread.sleep(2000);
			nextMonthdate.click();
			Thread.sleep(2000);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(3000);
			timeslotListItem.click();
			timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			timeslotListItem.sendKeys(Keys.ARROW_DOWN);
			timeslotListItem.sendKeys(Keys.ENTER);
			//String xpathv = "//select[@class='c-custom-form__textbox ng-pristine ng-valid ng-touched']/option[4]";
			//WebElement ele = driver.findElement(By.xpath(xpathv));	
			//ele.click();
			//Select time = new Select(ele);
			//time.selectByIndex(3);//10:00 AM - 12:00 PM
			/*10:00 AM - 12:00 PM     
			11:00 AM - 01:00 PM     
			12:00 PM - 02:00 PM     
			01:00 PM - 03:00 PM     
			03:00 PM - 05:00 PM     
			05:00 PM - 07:00 PM    */


			/*int x = ele.size();
			System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
			for(int i=0;i<=x;i++) {
				System.out.println(ele.get(i).getText());
			}
			System.err.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$");
				//enterDateUsingRobot(bookingDate);//0 for todays, 1,2,3,..n for future date.
			 */
			Thread.sleep(2000);			
			//timeslotListItem.click();
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
			maxChildrenListItem.click();
			adultListBox.click();
			maxAdultListItem.click();
			//dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
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
			minChildrenListItem.click();
			Thread.sleep(2000);
			maxChildrenListItem.click();
			Thread.sleep(2000);
			adultListBox.click();
			//oneAdultListItem.click();
			Thread.sleep(2000);
			maxAdultListItem.click();
			//	dateInputbox.sendKeys(Keys.ENTER);//Works for Chrome
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
	public String validateSelectPackage(String BasePKG, String Upgrade) throws InterruptedException {
		try{
			String alertMessage = null;
			if(BasePKG.equals("Star")) {
				waitAndClick(selectPackageStar);			
			}else if(BasePKG.equals("SuperStar")) {
				waitAndClick(selectPackageSuperStar);
			}else if(BasePKG.equals("MegaStar")) {
				waitAndClick(selectPackageMegaStar);
			
			}else if(BasePKG.equals("UltimateMegaStar")) {
				waitAndClick(selectPackageUltimateMegaStar);
			}else if(BasePKG.equals("VIPMegaStar")) {
				waitAndClick(selectPackageVIPMegaStar);
			}else {
				System.out.println("Invalid PKG entry given at method: validateSelectPackage");
			}

			Thread.sleep(1000);

			if(Upgrade.equals("YES") && !BasePKG.equals("UltimateMegaStar")) 
			{
				chooseUpSellUpgrade(upSellUpgrade,upSellUpgradeXpath); //WebElement and xpath
			}else if(Upgrade.equals("NO") && !BasePKG.equals("UltimateMegaStar")) 
			{
				  
				sayNoThanksToUpSell(upSellNoThanks,upSellNoThanksXpath);//WebElement and Xpath
			}else {
				System.out.println("Invalid Option given at Methods: validateSelectPackage, "
						+ "second parameter should be YES or NO for Upgrade pop-up. "
						+ "OR You might be chosen MegaStar, No Upgrade pop-up expected.");
			}


			//NOTE: IF Part checks min/max count of adullt and child validation given or not, else will continue booking.

			System.out.println("SELECT PACKAGE OR TIME-SLOT SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return alertMessage;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectPackage()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}
	//Need to change
	//************************************************************************************************
	//*********************Methods to validate VIP Package Or TimeSlot *******************************
	//************************************************************************************************

	//************************************************************************************************
	//*********************Methods to validate Birthday Star Information******************************
	//************************************************************************************************
	public boolean validateBirthdayStarInformation(int birthdayStar) throws InterruptedException, AWTException {
		try{
			boolean starInfoEntry = false;
		
			waitUntilElementVisible(childName);
			childName.sendKeys(getSaltString());
			
			childAge.sendKeys("10");
			
			genderListBox.click();
			
			genderMale.click();
			
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
			//return false;
			throw new AssertionError("A clear description of the failure", e);
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Additional Birthday Star Information*******************
	//************************************************************************************************	
	public String validateAdditionalBirthdayStar(int birthdayStar) throws InterruptedException, AWTException {
		try{
			String x = null;
			if(birthdayStar>=1) {
				//			x = additionalBirthdayStar.getText();
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
				if (adultName.getAttribute("value").isEmpty()) {
					adultName.sendKeys(propv.getProperty("bName"));
					}
					else {
						adultName.sendKeys(Keys.CONTROL + "a");
						adultName.sendKeys(Keys.DELETE);
						adultName.sendKeys(propv.getProperty("bName"));
					}
				if (phoneNumber.getAttribute("value").isEmpty()) {
					 this.phoneNumber.sendKeys(propv.getProperty("bPhone"));
					}
					else {
						System.out.println("inside else");
						phoneNumber.sendKeys(Keys.CONTROL + "a");
						phoneNumber.sendKeys(Keys.DELETE);
						 this.phoneNumber.sendKeys(propv.getProperty("bPhone"));
					}

				if (email.getAttribute("value").isEmpty()) {
					email.sendKeys(propv.getProperty("bEmail"));
					}
					else {
						System.out.println("inside else");
						email.sendKeys(Keys.CONTROL + "a");
						email.sendKeys(Keys.DELETE);
						email.sendKeys(propv.getProperty("bEmail"));
					}

				if (specialInstructions.getAttribute("value").isEmpty()) {
					specialInstructions.sendKeys(getSaltString());
					}
					else {
						System.out.println("inside else");
						specialInstructions.sendKeys(Keys.CONTROL + "a");
						specialInstructions.sendKeys(Keys.DELETE);
						specialInstructions.sendKeys(getSaltString());
					}
				scrollDown(driver);
				
			}else{
				
				if (adultName.getAttribute("value").isEmpty()) {
					adultName.sendKeys(getSaltString());
					}
					else {
						adultName.sendKeys(Keys.CONTROL + "a");
						adultName.sendKeys(Keys.DELETE);
						adultName.sendKeys(getSaltString());
					}
				if (phoneNumber.getAttribute("value").isEmpty()) {
					System.out.println("PHONE NUMBER !!!!!!!!!!!!!!!!!!!!"+getSaltNumber());
					 this.phoneNumber.sendKeys(getSaltNumber());
					}
					else {
						System.out.println("inside else");
						System.out.println("PHONE NUMBER !!!!!!!!!!!!!!!!!!!!"+getSaltNumber());
						phoneNumber.sendKeys(Keys.CONTROL + "a");
						phoneNumber.sendKeys(Keys.DELETE);
						 this.phoneNumber.sendKeys(getSaltNumber());
					}
				if (email.getAttribute("value").isEmpty()) {
					email.sendKeys(getSaltEmail());
					}
					else {
						System.out.println("inside else");
						email.sendKeys(Keys.CONTROL + "a");
						email.sendKeys(Keys.DELETE);
						email.sendKeys(getSaltEmail());
					}
				if (specialInstructions.getAttribute("value").isEmpty()) {
					specialInstructions.sendKeys(getSaltString());
					}
					else {
						System.out.println("inside else");
						specialInstructions.sendKeys(Keys.CONTROL + "a");
						specialInstructions.sendKeys(Keys.DELETE);
						specialInstructions.sendKeys(getSaltString());
					}

				
				
				scrollDown(driver);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
			throw new AssertionError("A clear description of the failure", e);
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
			Thread.sleep(1000);
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
			throw new AssertionError("A clear description of the failure", e);
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
			Thread.sleep(1000);
            		
           	System.out.println("You have selected "+x+" Package");		
			System.out.println("SELECT PACKAGE OR TIME SLOT SUCCESS......................................................................!!!!!!!!!!!");		
			return x;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentInformation()");
			throw new AssertionError("A clear description of the failure", e);
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
				//		x = additionalBirthdayStar.getText();
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
				boolean var = inStoreRadioBtn.isDisplayed() && creditCardRadioBtn.isDisplayed();
				//inStoreRadioBtn.isDisplayed();
				//creditCardRadioBtn.isDisplayed();
				System.out.println("Payment option present");
				System.out.println("Payment option present"+var);
				x=var;
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
			Thread.sleep(2000);
			try{
				JavascriptExecutor j = (JavascriptExecutor) driver;
				j.executeScript("document.getElementsByClassName(\"duplicateSubmit\")[0].click();");
			}catch(Exception e){
				System.out.println("Duplicate window not found, exception handled");
				e.printStackTrace();
			}
			try{
				if(upSellNoThankss.isDisplayed())
				{
					//System.out.println("SSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSSS");
					//Actions action2=new Actions(driver);
					//action2.moveToElement(upSellNoThankss).click().build().perform();
					sayNoThanksToUpSell(upSellNoThankss,upSellNoThanksXpaths);
				}
				Thread.sleep(1000);
				if(closeFinalUpSellPopUpWindow.isDisplayed()) {
					System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY");
					//Actions action2=new Actions(driver);
					//action2.moveToElement(closeFinalUpSellPopUpWindow).click().build().perform();
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
	//*********************Methods to validate Contact Information mandatory fields*******************
	//************************************************************************************************
	public boolean validateBirdayPartyContactInformationPageFields(String sChildName,String sChildAge,String sGenderListBox,String sAdultName,String sEnterPhoneNumberUsingRobot,String sAdultEmail,String sInStoreCheckBox) throws InterruptedException, AWTException {
		try{
			Thread.sleep(2000);
			boolean var = false;
			String x = null;
			if(sChildName.equals("YES")){
				childName.clear();
				childName.sendKeys(getSaltString());
			}else {
				childName.clear();
				childName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
				//Thread.sleep(15000);
				childName.sendKeys("");
			}
			
			if(sChildAge.equals("YES")){
				childAge.clear();
				childAge.sendKeys("10");
			}else {
				childAge.clear();
				childAge.sendKeys("");
			}
			
			if(sGenderListBox.equals("YES")){
				genderListBox.click();
				genderMale.click();
			}
			
			if(sAdultName.equals("YES")){
				adultName.clear();
				adultName.sendKeys(getSaltString());
			}else {
				
				adultName.clear();
				adultName.sendKeys("");
			}
			
			if(sEnterPhoneNumberUsingRobot.equals("YES")){
				phoneNumber.clear();
				this.phoneNumber.sendKeys(getSaltNumber());
			}else {
				phoneNumber.clear();
				phoneNumber.sendKeys("");
			}
			
			if(sAdultEmail.equals("YES")){
				adultEmail.clear();
				adultEmail.sendKeys(getSaltEmail());
			}else {
				adultEmail.clear();
				adultEmail.sendKeys("");
			}
			
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
			Thread.sleep(1000);
				var=childNameAgeAndGenderAlertMsg.isDisplayed();
				x = childNameAgeAndGenderAlertMsg.getText();
				System.out.println(x);
			
			return var;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirdayPartyContactInformationPageFields()");
			throw new AssertionError("A clear description of the failure", e);
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
	//*******Methods to Modify the Date and Time Slot in Edit Party Information Page *****************
	//************************************************************************************************
	public void validateEditPartyInformationLink() throws InterruptedException {
		try{
			Thread.sleep(5000);
			editPartyInformationLink.click();
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateeditPartyInformationLink()");
		}
	}

	//Need to change
	//************************************************************************************************
	//*********************Methods to validateUpdateDateandTime***************************************
	//************************************************************************************************	
	public String validateUpdateDateandTime(String message) throws InterruptedException {
		String x=null;
		try{
			if(message=="success") {
			Thread.sleep(2000);
			childrenListBox.click();
			Thread.sleep(2000);
			childrenListBox.sendKeys(Keys.ARROW_DOWN);
			childrenListBox.sendKeys(Keys.ENTER);
			//tenChildrenListItem.click();
			Thread.sleep(2000);
			adultListBox.click();
			Thread.sleep(2000);
			//oneAdultListItem.click();
			adultListBox.sendKeys(Keys.ARROW_DOWN);
			adultListBox.sendKeys(Keys.ENTER);
			Thread.sleep(2000);
			datePicker.click();
			Thread.sleep(2000);
			nextMonthdate.click();
			Thread.sleep(2000);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[10]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(3000);
			timeslotListItem.click();
			timeslotListItem.sendKeys(Keys.ARROW_DOWN);
				timeslotListItem.sendKeys(Keys.ENTER);
				waitAndClick(updateBtn);
				Thread.sleep(1000);
			}
			else if(message=="noTimeslot") {
				Thread.sleep(2000);
				childrenListBox.click();
				String lxpath = "//select[@class='c-custom-form__textbox ng-pristine ng-valid ng-touched']";
				WebElement element = driver.findElement(By.xpath(lxpath));
				
				Select sel = new Select(element);
				sel.selectByValue("100");

				Thread.sleep(12000);
				
				
				Thread.sleep(2000);
				Thread.sleep(3000);
				maxChildrenListItem.click();
				Thread.sleep(2000);
				adultListBox.click();
				Thread.sleep(2000);
				maxAdultListItem.click();
				Thread.sleep(2000);
				datePicker.click();
				Thread.sleep(2000);
				nextMonthdate.click();
				Thread.sleep(2000);
				String xpathv1 = "(//div[@class='datevalue currmonth']/span)[10]";
				WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
				ele1.click();
				Thread.sleep(3000);
				timeslotListItem.click();
				timeslotListItem.sendKeys(Keys.ARROW_DOWN);
					timeslotListItem.sendKeys(Keys.ENTER);
					Thread.sleep(2000);			
					waitAndClick(updateBtn);
					Thread.sleep(1000);
					x=waitAndGetText(errorMsgAtTimeslot);
					if(x.contains("Message! Time Slot Not Bookable"))
					{
					System.out.println("Time slot Not available......................................................................!!!!!!!!!!!");
					}
			}
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate()");
		}
		return x;
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
				//		waitAndClick(selectSuperStarPackage);
				Thread.sleep(1000);
				//		waitAndClick(updateSuperStarPackage);
				//		}else if(GivenPKG.equals("MegaStar")){
				//waitAndClick(selectMegaStarPackage);
			}
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangePackage()");
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




	//************************************************************************************************
	//*********************Methods to validate Update Attendees in Confirmation Page******************
	//************************************************************************************************
	/*public String validateUpdateAttendeesConfirmationPage() throws InterruptedException {
		try {
			String x = null;
			Thread.sleep(5000);

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
	 */
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

				x = errorMsgAtPaymentsPage.getText();		
			}else if(aCount==0) {
				Thread.sleep(2000);
				;
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
			new WebDriverWait(driver, 8000).until(ExpectedConditions.visibilityOf(cancelReservationLink2));
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
			String DateAndTimeconMsg = modifiedDate.getText();
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

///////////////////////////////////////////////////////////////////////////////////////////////////////////////
	//////////////////////////////BDD METHOD///////////////////////////////////////////////////
	public void validateContactInformationForDuplicateCheck_bdd(String cName, String cPhone,String cEmail) throws InterruptedException, AWTException {
		try {
			if (adultName.getAttribute("value").isEmpty()) {
				 this.adultName.sendKeys(cName);
				}
				else {
					System.out.println("inside else");
					adultName.sendKeys(Keys.CONTROL + "a");
					adultName.sendKeys(Keys.DELETE);
					 this.adultName.sendKeys(cName);
				}
			if (adultPhone.getAttribute("value").isEmpty()) {
				 this.adultPhone.sendKeys(cPhone);
				}
				else {
					System.out.println("inside else");
					adultPhone.sendKeys(Keys.CONTROL + "a");
					adultPhone.sendKeys(Keys.DELETE);
					 this.adultPhone.sendKeys(cPhone);
				}
			Thread.sleep(1000);
			if (adultEmail.getAttribute("value").isEmpty()) {
				 this.adultEmail.sendKeys(cEmail);
				}
				else {
					adultEmail.sendKeys(Keys.CONTROL + "a");
					adultEmail.sendKeys(Keys.DELETE);
					 this.adultEmail.sendKeys(cEmail);
				}
			
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
	public boolean validateNoTimeSlotAvailableMsg(){   //BDD CHANGE
		try {
			
			Thread.sleep(2000);
			 boolean noTimeSlotMsg = noTimeSlot.isDisplayed();
			System.out.println("NO TIME SLOT MSG SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("NO TIME SLOT MSG "+noTimeSlotMsg);
			return noTimeSlotMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateNoTimeSlotAvailableMsg()");
			return false;
		}
	}
	public void validateSelectMaxChildAdultAndDate_BDD(int bookingDate) throws InterruptedException, AWTException {
		try{
			Thread.sleep(3000);
			selectUsingValue(selectChildren, "189");
			selectUsingValue(selectAdult, "176");
			datePicker.click();
			Thread.sleep(2000);
			nextMonthdate.click();
			Thread.sleep(2000);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectMaxChildAdultAndDate()");
		}
	}
	
	public String validateUpsellQuantity_BDD(int quantity) throws InterruptedException {
		try{
			
			Thread.sleep(6000);
			addORRemoveChildORAdult(addQuantityForPizza,quantity);
			updateQuantity.click();
			String output = priceOfAdditionalItem.getText();
			String price = output.substring(1,6);
			double actualPrice = Double.parseDouble(price);
			double total = actualPrice*2;
			Thread.sleep(4000);
			String conMsg = confmsg.getText();
			
			String output2 = totalPriceOfAdditionalItem.getText();
			String price2 = output2.substring(1);
			double actualPrice2 = Double.parseDouble(price2);
			Assert.assertEquals(total,actualPrice2,"Additional items total mismatch");
			System.out.println("Message text displayed as:" +conMsg);
			return conMsg;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method:validateUpsellQuantity()");
			return "Issue with Method:validateUpsellQuantity()";
		}
	}
	
	
	public void validateSelectChildAdultAndDate_BDD(String children,String adult) throws InterruptedException, AWTException {
		try{
			Thread.sleep(3000);
			/*int i;
			selectUsingValue(selectChildren, children);
			selectUsingValue(selectAdult, adult);
			Thread.sleep(500);
			datePicker.click();
			Thread.sleep(500);
			nextMonthdate.click();
			Thread.sleep(500);
			String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
			WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
			ele1.click();
			Thread.sleep(500);
			Actions action=new Actions(driver);
			action.moveToElement(selectPartyDate).click().click().build().perform();
			selectPartyDate.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
			System.out.println("ttime1");
			WebDriverWait wait = new WebDriverWait(driver, 10);        
			wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='head']/div[1]/div/div[3]/div[2]/div[2]/div/select"))));
		    WebElement selectDropDown = driver.findElement(By.xpath("//*[@id='head']/div[1]/div/div[3]/div[2]/div[2]/div/select"));
		    Actions actionss=new Actions(driver);
			actionss.moveToElement(selectDropDown).click().build().perform();
			System.out.println("ttime2");
			List<WebElement> options=selectDropDown.findElements(By.tagName("option"));
			for(i=1;i<options.size();i++)
			{
				
			     boolean value = options.get(i).isEnabled();
			     if(value==true)
			     {
			    	 selectUsingIndex(PartyTime, i);
			    	 break;
			    	 
			     }
			     else {
			    	 
			    	 System.out.println("disabled"+i);
			     }
			     
			     }
			waitAndClick(seeAvailablity);
			Thread.sleep(1000);
			System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
		*/
			waitUntilElementVisible(selectChildren);
			selectUsingValue(selectChildren,children);
		    //selectUsingValue(selectKids,children);
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
			}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdultAndDate_BDD()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}
	
	
	public double validateChoosePackageAndGetPrice_BDD(String bPackage) throws InterruptedException {
		double pacakgePrice = 0;
		try{
			
			Thread.sleep(500);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			scrollDown(driver);
			if(bPackage.equals("SuperStar"))
			{
				String superPrice = SUPERSTAR_Package_price.getText();
				System.out.println("superPrice"+superPrice);
				String price = superPrice.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("superStarPrice"+pacakgePrice);
				
				
			}
			else if(bPackage.equals("MegaStar"))
			{
				String megaPrice = MEGASUPERSTAR_Package_price.getText();
				System.out.println("superPrice"+megaPrice);
				String price = megaPrice.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("superStarPrice"+pacakgePrice);
				
			}
			else
			{
				String starPrice = STAR_Package_price.getText();
				System.out.println("superPrice"+starPrice);
				String price = starPrice.substring(1);
				System.out.println("price"+price);
				pacakgePrice = Double.parseDouble(price);
				System.out.println("superStarPrice"+pacakgePrice);
				
			}
			System.out.println("CHOOSE PACKAGE is ");
			
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChoosePackageAndGetPrice_BDD()");
		}
		return pacakgePrice;
	}
	
	
	public double estimatedTotalWithUpsell_BDD(int children,int adult,double packagePrice,int numberOfAdditionalItem)
	{ 
		double calculatedAmt = 0;
		try{
		addORRemoveChildORAdult(addQuantityForPizza,numberOfAdditionalItem);
		updateQuantity.click();
		Thread.sleep(4000);
		String conMsg = confmsg.getText();
		String output = priceOfAdditionalItem.getText();
		String price = output.substring(1,6);
		System.out.println("price"+price);
		double actualPrice = Double.parseDouble(price);
		double total = actualPrice*numberOfAdditionalItem;
		System.out.println("total"+total);
		
		Thread.sleep(500);
		String output2 = totalPriceOfAdditionalItem.getText();
		System.out.println("output"+output2);
		String price2 = output2.substring(1);
		System.out.println("price2 "+price2);
		double actualPrice2 = Double.parseDouble(price2);
		System.out.println("actualPrice2"+actualPrice2);
		Assert.assertEquals(total,actualPrice2,"additional Item Mismatch");
		System.out.println("Message text displayed as:" +conMsg);
		System.out.println("actualPrice2" +actualPrice2);
		
		String childrenAmt = childrenTotalAmount.getText();
		String totalChildrenAmt = childrenAmt.substring(1);
		double totalChildrenAmount = Double.parseDouble(totalChildrenAmt);
		System.out.println("totalChildrenAmount "+totalChildrenAmount);  
		
		String adultAmt = AdultTotalAmount.getText();
		String totalAdultAmt = adultAmt.substring(1);
		double totalAdultAmount = Double.parseDouble(totalAdultAmt);
		System.out.println("totalAdultAmount "+totalAdultAmount);
		
		String depositAmt =  depositDue.getText();
		String depositTotalAmt = depositAmt.substring(1);
		double totalDepositAmount = Double.parseDouble(depositTotalAmt);
		Assert.assertEquals(totalDepositAmount,50.0,"Deposit Mismatch");
		
		
		double totalAmt = children*packagePrice;
		System.out.println("totalAmt"+totalAmt);
		Assert.assertEquals(totalAmt,totalChildrenAmount,"kids Mismatch");
		
		calculatedAmt = totalChildrenAmount+actualPrice2+totalAdultAmount;
		return calculatedAmt;
		
				
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	return calculatedAmt;
	}
	
	public double estimatedTotalAmount()
	{
		String estimatedAmt = estimatedTotal.getText();
		String totalEstimatedAmt = estimatedAmt.substring(1);
		double totalEstimatedAmount = Double.parseDouble(totalEstimatedAmt);
		return totalEstimatedAmount;
	}
	
	public void updateContactBirthdayStarInfo()
	{
		waitAndClick(updateContactORBirthdayInfo);
	}
	public boolean validateBirthdayStarInformation_BDD(int birthdayStar) throws InterruptedException, AWTException {
		try{
			boolean starInfoEntry = false;
            
			 if (childName.getAttribute("value").isEmpty()) {
					childName.sendKeys(getSaltString());
				}
				else {
					childName.sendKeys(Keys.CONTROL + "a");
					childName.sendKeys(Keys.DELETE);
					childName.sendKeys(getSaltString());
				}
			 if (childAge.getAttribute("value").isEmpty()) {
					childAge.sendKeys(getSaltAge());
				}
				else {
					childAge.sendKeys(Keys.CONTROL + "a");
					childAge.sendKeys(Keys.DELETE);
					childAge.sendKeys(getSaltAge());
				}
		
			genderListBox.click();
			genderMale.click();
			System.out.println("BIRTHDAY STAR INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			scrollDown(driver);
			//validate Additional Birthday Star Information
			if(birthdayStar>=1) {

				if(birthdayStar==1) {
					Thread.sleep(1000);
					AdditionalchildLink.click();
					if (childName.getAttribute("value").isEmpty()) {
						childName.sendKeys(getSaltString());
					}
					else {
						childName.sendKeys(Keys.CONTROL + "a");
						childName.sendKeys(Keys.DELETE);
						childName.sendKeys(getSaltString());
					}
				 if (childAge.getAttribute("value").isEmpty()) {
						childAge.sendKeys(getSaltAge());
					}
					else {
						childAge.sendKeys(Keys.CONTROL + "a");
						childAge.sendKeys(Keys.DELETE);
						childAge.sendKeys(getSaltAge());
					}
			
				genderListBox.click();
				genderMale.click();
				}else if(birthdayStar==2) {
					Thread.sleep(1000);
					AdditionalchildLink.click();
					if (childName.getAttribute("value").isEmpty()) {
						childName.sendKeys(getSaltString());
					}
					else {
						childName.sendKeys(Keys.CONTROL + "a");
						childName.sendKeys(Keys.DELETE);
						childName.sendKeys(getSaltString());
					}
				 if (childAge.getAttribute("value").isEmpty()) {
						childAge.sendKeys(getSaltAge());
					}
					else {
						childAge.sendKeys(Keys.CONTROL + "a");
						childAge.sendKeys(Keys.DELETE);
						childAge.sendKeys(getSaltAge());
					}
			
				genderListBox.click();
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
	public void validateChangePackage_BDD(String GivenPKG) throws InterruptedException {
		try{
			waitAndClick(modifyPackage);
			Thread.sleep(500);
			if(GivenPKG.equals("STAR")){
				waitAndClick(starPackage);
			}else if(GivenPKG.equals("SUPER STAR")){
					waitAndClick(superStarPackage);
			}else if(GivenPKG.equals("MEGA SUPER STAR"))
			{
				waitAndClick(megaStarPackage);
			}else if(GivenPKG.equals("ULTIMATE SUPER STAR"))
			{
				waitAndClick(ultimatemegaPackage);
			}
			waitAndClick(confirmaChange);
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateChangePackage()");
		}
	}
	public String validatePackageUpdateInformation_BDD() throws InterruptedException {
		try {
			Thread.sleep(6000);
			String ModifiedPackage = modifiedPackageName.getText();
			System.out.println("The Modified Package is " + ModifiedPackage);
			return ModifiedPackage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackageUpdateInformation()");
			return "Issue with Method: validatePackageUpdateInformation()";
		}
	}
	
	public void editNumOfChildrenInformation(String children) throws InterruptedException
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
		}
		/*try
		{
			waitUntilElementClickable(editPartyInfo);
			JavascriptExecutor ex=(JavascriptExecutor)driver;
			ex.executeScript("arguments[0].click()", editPartyInfo);
			Thread.sleep(3000);
			waitUntilElementClickable(editChildren);
			editChildren.click();
			oneHundredEightyKidsListItem.click();
			Thread.sleep(2000);
			//selectUsingValue(editChildren,children);
			
			
		}
		*/
		catch(Exception e) {
			e.printStackTrace();
		}
		
			
}
	public String validateSelectPackage_BDD(String BasePKG, String Upgrade) throws InterruptedException {
		try{
			String alertMessage = null;
			if(BasePKG.equals("Star")) {
				waitAndClick(selectPackageStar);
				if(Upgrade.equals("YES")){
				chooseUpSellUpgrade(upSellUpgrade,upSellUpgradeXpath);}
				else
				{
				sayNoThanksToUpSell(upSellNoThanks,upSellNoThanksXpath);
				}
			}else if(BasePKG.equals("SuperStar")) {
				waitAndClick(selectPackageSuperStar);
				if(Upgrade.equals("YES")){
					chooseUpSellUpgrade(upSellUpgrade,upSellUpgradeXpath);}
					else
					{
					sayNoThanksToUpSell(upSellNoThanks,upSellNoThanksXpath);
					}
			}else if(BasePKG.equals("MegaStar")) {
				waitAndClick(selectPackageMegaStar);
			
			}else if(BasePKG.equals("UltimateMegaStar")) {
				waitAndClick(selectPackageUltimateMegaStar);
				
			}else if(BasePKG.equals("VIPMegaStar")) {
				waitAndClick(selectPackageVIPMegaStar);
			}else {
				System.out.println("Invalid PKG entry given at method: validateSelectPackage");
			}

			Thread.sleep(500);

			System.out.println("SELECT PACKAGE OR TIME-SLOT SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return alertMessage;
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectPackage()");
			return "Issue with Method: validateSelectPackage()";
		}
	}
	public boolean validateNoDeposit_BDD(String checkNoStore) throws InterruptedException, AWTException {
		
			boolean x = false;
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
			if(checkNoStore.equals("YES")){
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
	
	
	
	
	public String validateGetConfirmationNumber_BDD() throws InterruptedException {
		try{
			Thread.sleep(3000);
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
				Actions action2=new Actions(driver);
				action2.moveToElement(upSellNoThanks).click().build().perform();
				
			}catch(Exception e){
				System.out.println("USER EXCEPTION FOUND:");
				e.printStackTrace();
			}
			/*try{
				
				
				 new WebDriverWait(driver, 1000).until(ExpectedConditions.visibilityOf(upSellNoThanks));
				 driver.findElement(By.xpath("//button[text()='No Thanks']")).click();
					Actions action2=new Actions(driver);
					action2.moveToElement(upSellNoThanks).click().build().perform();
					
					
				}catch(Exception e){
					
				e.printStackTrace();	
				}
				*/
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
			throw new AssertionError("A clear description of the failure", e);
		}
	}
	
	//MAC
public void validateSearchLocations(String cLocation) throws InterruptedException {
		
		try{
			Thread.sleep(500);
			scrollDown(driver);
			scrollDown(driver);
			//if(waitAndGetText(commonLocation).contains("Change")){  //changeLocationLink1-----BDDDDD CHANGE
				//waitAndClick(changeLocationLink2);
			//}else{
			//	waitAndClick(changeLocationLink1);//changeLocationLink1-----BDDDDD CHANGE
			//}
			waitAndGetText(commonLocation);
			
			
			if(cLocation.equals("")){
				locationSearchBox.sendKeys(TestUtil.bLocation);
			}else {
			
				locationSearchBox.sendKeys(cLocation);
			}
			Thread.sleep(1000);
			//Actions act = new Actions(driver);
			//act.moveToElement(searchIcon).click().perform();
			//button[@id='locationSubmit']
			
			JavascriptExecutor executor = (JavascriptExecutor)driver;
			executor.executeScript("arguments[0].click();", searchIcon);
			System.out.println("SELECT LOCATION SUCCESS......................................................................!!!!!!!!!!!");
		}catch(Exception e){
			e.printStackTrace();
			System.out.println("Issue with method:  validateSearchLocation()");
			throw new AssertionError("A clear description of the failure", e);
		}
	}
public void validateSelectChildAdultAndDate_BDDs(String children,String adult) throws InterruptedException, AWTException {
	try{
		/*int i;
		Thread.sleep(3000);;
		selectUsingValue(selectChildren, children);
	
		selectUsingValue(selectAdult, adult);
		Thread.sleep(500);
		datePicker.click();
		Thread.sleep(500);
		nextMonthdate.click();
		Thread.sleep(500);
		String xpathv1 = "(//div[@class='datevalue currmonth']/span)[9]";
		WebElement ele1 = driver.findElement(By.xpath(xpathv1));			
		ele1.click();
		Thread.sleep(500);
		Actions action=new Actions(driver);
		action.moveToElement(selectPartyDate).click().click().build().perform();
		selectPartyDate.sendKeys(Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER);
		System.out.println("ttime1");
		WebDriverWait wait = new WebDriverWait(driver, 10);        
		wait.until(ExpectedConditions.elementToBeClickable(driver.findElement(By.xpath("//*[@id='head']/div[1]/div/div[3]/div[2]/div[2]/div/select"))));
	    WebElement selectDropDown = driver.findElement(By.xpath("//*[@id='head']/div[1]/div/div[3]/div[2]/div[2]/div/select"));
	    Actions actionss=new Actions(driver);
		actionss.moveToElement(selectDropDown).click().build().perform();
		System.out.println("ttime2");
		List<WebElement> options=selectDropDown.findElements(By.tagName("option"));
		for(i=1;i<options.size();i++)
		{
			
		     boolean value = options.get(i).isEnabled();
		     if(value==true)
		     {
		    	 selectUsingIndex(PartyTime, i);
		    	 break;
		    	 
		     }
		     else {
		    	 
		    	 System.out.println("disabled"+i);
		     }
		     
		     }
		waitAndClick(seeAvailablity);
		Thread.sleep(1000);
		System.out.println("SEE AVAILABILITY SUCCESS......................................................................!!!!!!!!!!!");
	*/
		Thread.sleep(2000);
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
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("Issue with Method: validateSelectChildAdultAndDate_BDD()");
		throw new AssertionError("A clear description of the failure", e);
	}
}
public boolean sendBdayPartyInvitation()
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
	}
	catch(Exception e)
	{
		e.printStackTrace();
		
	}
	return false;
	
}
public void validateSelectChildAdultAndDateIE(String children,String adult) throws InterruptedException, AWTException {
	try{
		Thread.sleep(3000);
		
		waitUntilElementVisible(selectChildren);
		
		//selectUsingValue(selectChildren,children);
	    selectUsingValue(selectKids,children);
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
		}catch(Exception e){
		e.printStackTrace();
		System.out.println("Issue with Method: validateSelectChildAdultAndDate_BDD()");
		throw new AssertionError("A clear description of the failure", e);
	}
}

public void validatePaymentInformationIE() throws InterruptedException, AWTException {
	try {
	boolean var = inStoreRadioBtn.isDisplayed() && creditCardRadioBtn.isDisplayed();
	if(var == true) {
		throw new AssertionError("payment option should not present");
	    }
	else
	{
		System.out.println("inside else");
	}
		waitAndClick(completeReservation);
	}
		catch(Exception e)
	{
	
	System.out.println("inside catch");
	waitAndClick(completeReservation);
	}
}


public void validateBirdayPartyContactInformationPageFields2(String sChildName,String sChildAge,String sGenderListBox,String sAdultName,String sEnterPhoneNumberUsingRobot,String sAdultEmail,String sInStoreCheckBox) throws InterruptedException, AWTException {
	try{
		Thread.sleep(2000);
		boolean var = false;
		String x = null;
		if(sChildName.equals("YES")){
			childName.clear();
			childName.sendKeys(getSaltString());
		}else {
			childName.clear();
			childName.sendKeys(Keys.CONTROL,"a", Keys.DELETE);
			//Thread.sleep(15000);
			childName.sendKeys("");
		}
		
		if(sChildAge.equals("YES")){
			childAge.clear();
			childAge.sendKeys("10");
		}else {
			childAge.clear();
			childAge.sendKeys("");
		}
		
		if(sGenderListBox.equals("YES")){
			genderListBox.click();
			genderMale.click();
		}
		
		if(sAdultName.equals("YES")){
			adultName.clear();
			adultName.sendKeys(getSaltString());
		}else {
			
			adultName.clear();
			adultName.sendKeys("");
		}
		
		if(sEnterPhoneNumberUsingRobot.equals("YES")){
			phoneNumber.clear();
			this.phoneNumber.sendKeys(getSaltNumber());
		}else {
			phoneNumber.clear();
			phoneNumber.sendKeys("");
		}
		
		if(sAdultEmail.equals("YES")){
			adultEmail.clear();
			adultEmail.sendKeys(getSaltEmail());
		}else {
			adultEmail.clear();
			adultEmail.sendKeys("");
		}
		
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
		Thread.sleep(1000);
		
		
		
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Issue with Method: validateBirdayPartyContactInformationPageFields()");
		throw new AssertionError("A clear description of the failure", e);
	}
}	



public void validateChoosePackageAndroid(String bPackage) throws InterruptedException {
	try{
		
		Thread.sleep(4000);
		waitUntilElementVisible(buttonSuper);
		waitAndClick(buttonSuper);
		
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
		Thread.sleep(3000);
		System.out.println("CHOOSE PACKAGE is ");
	}catch(Exception e){
		e.printStackTrace();
		System.out.println("Issue with Method: validateChoosePackage()");
		throw new AssertionError("A clear description of the failure", e);
	}
}

public boolean highlightedPackageName(String pack) {
	try
	{
	waitUntilElementVisible(highlightedPackage);
	String highlightedPackageName = highlightedPackage.getText();
	System.out.println("highlightedPackageName"+highlightedPackageName);
	if(highlightedPackageName.contains(pack))
	{
	return true;
	}
	else
	{
		return false;
	}
}catch(Exception e)
	{
	e.printStackTrace();
	throw new AssertionError("A clear description of the failure", e);
	}
}


public boolean validateMinMaxChildrenBirthday(int min, int max)
{
	try {
		waitUntilElementVisible(selectChildren);
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

public boolean validateMinMaxAdultBirthday(int min, int max)
{
	try {
		waitUntilElementVisible(selectAdult);
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

public void overbookingInBirthday() throws InterruptedException
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
		//oneHundredEightyAdultsListItem.click();
		selectUsingValue(editAdult,"180");
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


}

	
