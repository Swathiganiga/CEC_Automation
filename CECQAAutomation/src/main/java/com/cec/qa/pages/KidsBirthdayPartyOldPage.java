/*
 * 
 * Test Page: Old Booking Funnel Kids Birthday Party Booking
 * Created By: Aditya 
 * Reviewed By: Vishnu
 * Review Date: 04-June-2019
 *  
 */

package com.cec.qa.pages;
import java.awt.AWTException;
import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.cec.qa.base.BaseTest;

public class KidsBirthdayPartyOldPage extends BaseTest{
	//************************************************************************************************
	//*********************PARTY SIZE - SELECT CHILD,ADULT & DATE********************************
	//************************************************************************************************

	@FindBy(id="txtChildren")
	WebElement childrenTextBox;

	@FindBy(id="txtAdult")
	WebElement adultTextBox;

	@FindBy(id="btnShowCalender")
	WebElement pickdateBtn;

	@FindBy(id="logo")		
	WebElement ceclogo;

	//************************************************************************************************
	//*********************SHOW CALANDER - SELECT DATE & TIME SLOT*************************
	//************************************************************************************************

	@FindBy(xpath = "//a[@title='Next']")
	WebElement nextmonthLink;


	//************************************************************************************************
	//*********************PARTY PACKAGES - SELECT PACKAGE *************************
	//************************************************************************************************

	@FindBy(xpath="(//button[@title='Choose the STAR Package'])")
	WebElement selectPackageStarBtn;

	@FindBy(xpath="(//button[@title='Choose the SUPER STAR Package'])")
	WebElement selectPackageSuperStarBtn;

	@FindBy(xpath="(//button[@title='Choose the MEGA SUPER STAR  Package'])")
	WebElement selectPackageMegaStarBtn;

	@FindBy(xpath="(//button[@title='Choose the VIP MEGA SUPER STAR Package'])")
	WebElement selectPackageVIPMegaStarBtn;

	@FindBy(xpath="(//div[@id='btnOk'and contains(text(),'Upgrade')])[2]")
	WebElement upgradeBtn;

	String upgradeXpath="(//div[@id='btnOk'and contains(text(),'Upgrade')])[2]";
	//String upgradeXpath="btnOk";

	@FindBy(xpath="//span[@id='btnCancel']")
	WebElement nothanksBtn;

	String noThanksXpath="//span[@id='btnCancel']";

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$15.99')])[1]")
	WebElement STAR_price;

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$20.99')])[1]")
	WebElement SUPERSTAR_price;

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$25.99')])[1]")
	WebElement MEGASUPERSTAR_price;

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$25.99')])[1]")
	WebElement VIPMEGASUPERSTAR_price;


	//************************************************************************************************
	//*********************BIRTHDAY STAR - Birthday Star Info***********************
	//************************************************************************************************

	@FindBy(id="txtFirstName_1")
	WebElement firstName1TextBox;

	@FindBy(id="txtAge_1")
	WebElement age1TextBox;

	@FindBy(xpath="//select[@id='drpGender_1']/option[contains(text(),'Male')]")
	WebElement genderMale1;

	@FindBy(xpath="//select[@id='drpGender_1']/option[contains(text(),'Female')]")
	WebElement genderFemale1;
	
	@FindBy(id="drpThemes_1")
	WebElement themeDropDown1;

	//Additional Kid

	@FindBy(xpath="//select[@id='drpBirthdayStart']/option[contains(text(),'1')]")
	WebElement additionalKid1;

	@FindBy(id="txtFirstName_2")
	WebElement firstName2TextBox;

	@FindBy(id="txtAge_2")
	WebElement age2TextBox;

	@FindBy(xpath="//select[@id='drpGender_2']/option[contains(text(),'Male')]")
	WebElement genderMale2;

	@FindBy(xpath="//select[@id='drpGender_2']/option[contains(text(),'Female')]")
	WebElement genderFemale2;
	
	@FindBy(id="drpThemes_2")
	WebElement themeDropDown2;

	@FindBy(id="Back")
	WebElement backBtn;

	@FindBy(id="NEXT")
	WebElement nextBtn;

	@FindBy(xpath="//p[contains(text(),'Additional Birthday Star')]")
	WebElement additionalBirthdayStar;

	@FindBy(id="btnCancel")
	WebElement upSellNoThanks;


	String upSellNoThanksXpath="btnCancel";


	@FindBy(xpath="(//div[@class='SumoSelect sumo_drpdownQty_419'])/select[@class='SlectBox SumoUnder']/option[2]")
	WebElement optionalitem1;
	
	@FindBy(xpath="(//div[@class='SumoSelect sumo_drpdownQty_235'])/select[@class='SlectBox SumoUnder']/option[3]")
	WebElement optionalitem2;

	@FindBy(xpath="(//div[@class='SumoSelect sumo_drpdownQty_575'])/select[@class='SlectBox SumoUnder']/option[4]")
	WebElement optionalitem3;

	//************************************************************************************************
	//*********************CONTACT INFORMATION - Contact Info***********************
	//************************************************************************************************

	@FindBy(id="CustomerName")
	WebElement customerNameTextBox;

	@FindBy(id="Email")
	WebElement emailTextBox;

	@FindBy(id="Phone1")
	WebElement phonenoTextBox;

	@FindBy(id="reservation_Comments")
	WebElement specinsTextBox;

	@FindBy(id="upsell1")
	WebElement duplicateRecord;

	@FindBy(xpath="//div[@class='interrupt-closer']")
	WebElement duplicate;

	//************************************************************************************************
	//*********************PAYMENT INFORMATION - INSTORE***********************
	//************************************************************************************************

	@FindBy(id="InStore")
	WebElement instoreLink;

	@FindBy(id="No")
	WebElement noOnlineDepositLink;

	@FindBy(xpath="//label[@for='PrivacyPolicyAndTermsOfUse']")
	WebElement offlinecheckBox;

	@FindBy(id="NEXT")
	WebElement booknowBtn;

	//@FindBy(xpath="(//p[contains(text(),'Your reservation is confirmed.')])[1]")
	//WebElement confirmationNumber;

	@FindBy(xpath="(//p[contains(text(),'Your reservation is confirmed.')])/span[1]")
	WebElement confirmationNumber;


	@FindBy(id = "btnForward")
	WebElement forwardconfirmation;

	@FindBy(xpath = "//a[contains(text(),'Modify Reservation')]")
	WebElement modifyReservation;

	//************************************************************************************************
	//*********************RESERVATION SUMMARY *************************
	//************************************************************************************************

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[1]")
	WebElement editDateandTimeLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[2]")
	WebElement editPartySizeLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[3]")
	WebElement editPartyPackageLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[4]")
	WebElement editOptionalItemsLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[5]")
	WebElement editBirthdayStarLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[6]")
	WebElement editContactNameLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[7]")
	WebElement editEmailIdLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[8]")
	WebElement editPhoneNumberLink;

	@FindBy(xpath="//label[@id='totalPriceReviewPage']")
	WebElement totalAmount;

	@FindBy(xpath="//dd[@class='package' and contains(text(),'MEGA SUPER STAR')]")
	WebElement validatePackage;

	//************************************************************************************************
	//*********************ERROR MESSAGES *************************
	//************************************************************************************************
	@FindBy(xpath="//div[contains(text(),'The party time you selected has a minimum requirement of 10 children.  Would you like to increase your number of children to 10?')]")
	WebElement vipMinBookingMsg;

	@FindBy(xpath="//div[contains(text(),'Due to the increase of children/adults the time you originally selected is no longer available. To move forward with the same time slot, reduce the children/adults?')]")
	WebElement vipMaxBookingMsg;

	@FindBy(xpath="//div[@id='errMsgChild' and contains(text(),'Children required.')]")
	WebElement childAlertMsg;

	@FindBy(xpath="//div[@id='errMsgAdult' and contains(text(),'Adults required.')]")
	WebElement adultAlertMsg;

	@FindBy(xpath="//div[@id='errMsgChild' and contains(text(),'Minimum 4 children required.')]")
	WebElement minchildAlertMsg;

	@FindBy(xpath="//div[@id='errMsgAdult' and contains(text(),'Minimum 1 guest required.')]")
	WebElement minadultAlertMsg;

	//************************************************************************************************
	//*********************Header link*************************
	//************************************************************************************************

	@FindBy(xpath="(//a[@class='custom_a_partyinfo'])[1]")
	WebElement header1;

	@FindBy(xpath="(//a[@class='custom_a_partyinfo'])[2]")
	WebElement header2;

	@FindBy(xpath="(//a[@class='custom_a_partyinfo'])[3]")
	WebElement header3;

	@FindBy(xpath="(//a[@class='custom_a_partyinfo'])[4]")
	WebElement header4;
	
	@FindBy(xpath="//h1[contains(text(),'Who Is')]")
	 WebElement header1HeaderText;

	//************************************************************************************************
	//*********************Item Cart******************************************************************
	//************************************************************************************************

	@FindBy(xpath="//a[@class='cart-launch']")
	WebElement cartLaunch;

	@FindBy(xpath="(//a[@class='edit cartView fa fa-pencil'])[2]")
	WebElement cartPartySize;

	//************************************************************************************************
	//*********************LOCATORS Initialization****************************************************
	//************************************************************************************************
	public KidsBirthdayPartyOldPage(){
		PageFactory.initElements(driver, this);
	}
	//************************************************************************************************
	//*********************Variable Initialization****************************************************
	//************************************************************************************************
	public static String selectedDate;
	public static String calenderDate;
	public static int i,j,row,col;
	public static String A1=null,A3=null,A5=null;
	public static int A2=0,A4=0;
	//************************************************************************************************
	//*********************Methods to get the URL based on store ***************************
	//************************************************************************************************
	public String validateSelectStore(String store) {
		try{
			driver.navigate().to("https://test-book.chuckecheese.com/Reservations/PartyDetails?id="+store+"&restype=1");
			System.out.println("STORE SELECT SUCCESS......................................................................!!!!!!!!!!!");
			return "Store Access Successful";
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectStore()");
			return "Store Access Unsuccessful, Issue with Method: validateSelectStore()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Select Child, Adult***************************
	//************************************************************************************************
	public void validateSelectChildAdult() throws InterruptedException, AWTException {
		try {
			waitAndClick(childrenTextBox);
			childrenTextBox.sendKeys("10");
			adultTextBox.sendKeys("2");
			waitAndClick(pickdateBtn);
			Thread.sleep(1000);
			System.out.println("ENTER CHILD AND ADULT SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdult()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Party date and Timeslot***************************
	//************************************************************************************************
	public String validateSelectPartyDate(String date, String timeslot) throws InterruptedException{
        try {
               JavascriptExecutor js = (JavascriptExecutor)driver;
               js.executeScript("arguments[0].click();", nextmonthLink);
               js.executeScript("window.scrollBy(0,250)", "");
               Thread.sleep(4000);
               String partyDate = date;
               for(i=1;i<=6;i++)
               {
                     for(j=1;j<=7;j++)
                     {
                            String A1= "//table/tbody/tr[";
                            int A2= i;
                            String A3= "]/td[";
                            int A4= j;
                            String A5= "]";
                            selectedDate=A1+A2+A3+A4+A5;
                            System.out.println("The date is Selected"+selectedDate);
                            System.out.println(driver.findElement(By.xpath(selectedDate)).getText());
                            String calenderDate = driver.findElement(By.xpath(selectedDate)).getText();
                            if(calenderDate.equals(partyDate))
                            {
                                   System.out.println("Party Date Matching...");
                                   row =i;
                                   col=j;        
                                   break;
                            }      
                            if(j==col) break;
                     }
                     if(i==row) break;
               }
               //System.out.println("Row : "+row+"Col : "+col);
               System.out.println("PARTY DATE SELECTED SUCCESS......................................................................!!!!!!!!!!!");
            	String dateXpath = "//a[text()='"+date+"']";
			WebElement ele = driver.findElement(By.xpath(dateXpath));
			waitAndClick(ele);
               String A01 = "//*[@data-timeslot='";
               String A02 = timeslot;
               String A03 = "']";
               String selectedTimeSlot = A01+A02+A03;
               //System.out.println("The time slot is selected"+selectedTimeSlot);
               Thread.sleep(2);
               jsClick(driver,driver.findElement(By.xpath(selectedTimeSlot)));            // TimeSlot
               Thread.sleep(2);
               System.out.println("TIME SLOT SELECTED SUCCESS......................................................................!!!!!!!!!!!");
               return selectedTimeSlot;
        } catch (Exception e) {
               e.printStackTrace();
               System.out.println("Issue with Method: validateSelectPartyDate()");
               return "Issue with Method: validateSelectPartyDate()";
        }
 }

	//************************************************************************************************
	//*********************Methods to validate Select Package****************************
	//************************************************************************************************
	public String validateSelectPackage(String basePKG, String upgrade) throws InterruptedException {
		try {
			String alertMessage = null;
			if(basePKG.equals("Star")) {
				scrollDown(driver);
				waitAndClick(selectPackageStarBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("SuperStar")) {
				scrollDown(driver);
				waitAndClick(selectPackageSuperStarBtn);
			}else if(basePKG.equals("MegaStar")) {
				scrollDown(driver);
				waitAndClick(selectPackageMegaStarBtn);
			}else if(basePKG.equals("VIPMegaStar")) {
				scrollDown(driver);
				waitAndClick(selectPackageVIPMegaStarBtn);
			}else {
				System.out.println("Invalid PKG entry");
			}

			Thread.sleep(3000);

			if(upgrade.equals("YES") && !basePKG.equals("MegaStar") && !basePKG.equals("VIPMegaStar")) 
			{
				Thread.sleep(5000);
				boolean upgradebut = upgradeBtn.isDisplayed();
				System.out.println(upgradebut);
				waitAndClick(upgradeBtn);
			}else if(upgrade.equals("NO") && !basePKG.equals("MegaStar") && !basePKG.equals("VIPMegaStar")) 
			{
				waitAndClick(nothanksBtn);
			}else if(upgrade.equals(""))
			{
				pressEnter(Keys.ENTER);
			}else {
				System.out.println("Invalid Option given at Methods: validateSelectPackage, "
						+ "second parameter should be YES or NO for Upgrade pop-up. "
						+ "OR You might be chosen MegaStar, No Upgrade pop-up expected.");
			}
			System.out.println("SELECT PACKAGE SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return alertMessage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectPackage()");
			return "Issue with Method: validateSelectPackage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Birthday Star Information******************************
	//************************************************************************************************
	public boolean validateBirthdayStarInformation(int birthdayStar) throws InterruptedException, AWTException {
		try {
			boolean starInfoEntry = false;
			Thread.sleep(1000);
			firstName1TextBox.sendKeys(getSaltString());
			Thread.sleep(1000);
			age1TextBox.sendKeys("10");
			Thread.sleep(1000);
			genderMale1.click();
			Thread.sleep(1000);
			if(themeDropDown1.isDisplayed()) {
				selectDrpDwnByIndex(themeDropDown1, 1);
			}
			System.out.println("BIRTHDAY STAR INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
			//validate Additional Birthday Star Information
			if(birthdayStar>=1) {
				if(birthdayStar==1) {
					Thread.sleep(1000);
					additionalKid1.click();
					firstName2TextBox.sendKeys(getSaltString());
					Thread.sleep(1000);
					age2TextBox.sendKeys("10");
					Thread.sleep(1000);
					genderMale2.click();
					Thread.sleep(1000);
					if(themeDropDown2.isDisplayed()) {
						selectDrpDwnByIndex(themeDropDown2, 1);
					}
					/*}else if(birthdayStar==2) {
							Thread.sleep(1000);
							AdditionalchildLink.click();
							childName2.sendKeys(getSaltString());
							Thread.sleep(1000);
							childAge2.sendKeys("10");
							Thread.sleep(1000);
							genderListBox2.click();
							Thread.sleep(1000);
							genderMale.click(); */
				}
				System.out.println("ADDITIONAL KID NAME AGE GENDER SUCCESS...........................................!");
			}
			starInfoEntry = true;
			return starInfoEntry;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayStarInformation()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateBirthdayStarInformationClear ***************************
	//************************************************************************************************	
	public void validateBirthdayStarInformationClear() throws InterruptedException, AWTException {
		try {
			Thread.sleep(1000);
			firstName1TextBox.clear();
			Thread.sleep(1000);
			age1TextBox.clear();
			Thread.sleep(1000);
			System.out.println("BIRTHDAY STAR INFORMATION CLEAR SUCCESS......................................................................!!!!!!!!!!!");	
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayStarInformationClear()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Additional Birthday Star Information*******************
	//************************************************************************************************	
	public String validateAdditionalBirthdayStar(int birthdayStar) throws InterruptedException, AWTException {
		try {
			String x = null;
			if(birthdayStar>=1) {
				x = additionalBirthdayStar.getText();
			}else if(birthdayStar>=2)  {
				//Not yet designed........
			}
			System.out.println("ADDITIONAL BIRTHDAY STAR INFO VALIDATION SUCCESS......................................................................!!!!!!!!!!!");		
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAdditionalBirthdayStar()");
			return "Issue with Method: validateAdditionalBirthdayStar()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Contact Information************************************
	//************************************************************************************************
	public boolean validateContactInformation(String toCheckBooking) throws InterruptedException, AWTException {
		try {
			if(toCheckBooking.equals("YES")){
				customerNameTextBox.sendKeys(propv.getProperty("bName"));
				Thread.sleep(1000);
				emailTextBox.sendKeys(propv.getProperty("bEmail"));
				Thread.sleep(1000);
				emailTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot(propv.getProperty("bPhone"));
				Thread.sleep(1000);
				scrollDown(driver);
				waitAndClick(nextBtn);
			}else{
				customerNameTextBox.sendKeys(getSaltString());
				Thread.sleep(1000);
				emailTextBox.sendKeys(getSaltEmail());
				Thread.sleep(2000);
				emailTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot("");
				Thread.sleep(2000);
				specinsTextBox.sendKeys(getSaltString());
				Thread.sleep(1000);
				scrollDown(driver);
				System.out.println("CONTACT INFORMATION ENTRY SUCCESS......................................................................!!!!!!!!!!!");
				waitAndClick(nextBtn);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformation()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Duplicate booking warning window***********************
	//************************************************************************************************	
	public boolean validateDuplidateBookingWarningWindow() throws InterruptedException{
		try {
			Thread.sleep(10000);
			boolean result = false;
			if(duplicate.isDisplayed() ){
				result = true;
				System.out.println("Found Duplicates window displayed : "+result);
				return result; 
			}else{
				result = false;
				System.out.println("Not found Duplicates Message/Window" +result);
				return result;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDuplidateBookingWarningWindow()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateContactInformationClear ********************************
	//************************************************************************************************	
	public void validateContactInformationClear() throws InterruptedException, AWTException {
		try {
			customerNameTextBox.clear();
			Thread.sleep(1000);
			emailTextBox.clear();
			Thread.sleep(1000);
			emailTextBox.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(2000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformationClear()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Contact Information for duplicates************************************
	//************************************************************************************************
	public void validateContactInformationForDuplicateCheck(String cName, String cPhone,String cEmail) throws InterruptedException, AWTException {
		try {
			customerNameTextBox.sendKeys(cName);
			Thread.sleep(1000);
			emailTextBox.sendKeys(cEmail);
			Thread.sleep(1000);
			emailTextBox.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot(cPhone);
			Thread.sleep(1000);
			specinsTextBox.sendKeys(getSaltString());
			Thread.sleep(1000);
			scrollDown(driver);
			waitAndClick(nextBtn);
			System.out.println("CONTACT INFORMATION FOR DUPLICATE ENTRY SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformationForDuplicateCheck()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Payment Information************************************
	//************************************************************************************************
	public boolean validateReservationSummary() throws IOException, InterruptedException {
		try {
			scrollDown(driver);
			scrollDown(driver);
			waitAndClick(nextBtn);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReservationSummary()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Payment Information************************************
	//************************************************************************************************
	public void validatePaymentInformation() throws IOException, InterruptedException {
		try {
			Thread.sleep(1000);
			//Click Instore option for payment
			instoreLink.click();
			Thread.sleep(3000);
			if(noOnlineDepositLink.isDisplayed()==true) {
				noOnlineDepositLink.click();
				Thread.sleep(5000);
				offlinecheckBox.click();
				Thread.sleep(3000);
			}
			else if(noOnlineDepositLink.isDisplayed()==false) {
				noOnlineDepositLink.click();
				Thread.sleep(5000);
				offlinecheckBox.click();
				Thread.sleep(3000);
			}
			waitAndClick(booknowBtn);
			Thread.sleep(7000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentInformation()");
		}
	}
	
	public void validatePaymentInformation_Tupelo() throws IOException, InterruptedException {
		try {
			Thread.sleep(1000);
			//Click Instore option for payment
			instoreLink.click();
			Thread.sleep(3000);
				offlinecheckBox.click();
				Thread.sleep(3000);
			waitAndClick(booknowBtn);
			Thread.sleep(7000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePaymentInformation_Tupelo()");
		}
	}
	
	//************************************************************************************************
	//*********************Methods to Select Optional Items ************************************
	//************************************************************************************************
	public void validateSelectOptionalitems(String optionItems) throws IOException, InterruptedException {  	
		try {
			if(optionItems.equals("NO")){
				Thread.sleep(1000);
				scrollDown(driver);
				scrollDown(driver);
				waitAndClick(nextBtn);
				System.out.println("First optional Item NEXT Executed !!");
				try{
					Thread.sleep(2000);
					if(upSellNoThanks.isDisplayed())
					{
						waitAndClick(upSellNoThanks);
					}
				}catch(Exception e){
					System.out.println("USER EXCEPTION FOUND:");
					e.printStackTrace();
				}
				scrollDown(driver);
				scrollDown(driver);
				waitAndClick(nextBtn);
				System.out.println("Second optional Item NEXT Executed !!");
			/*	try{
					Thread.sleep(500);
					if(upSellNoThanks.isDisplayed())
					{
						waitAndClick(upSellNoThanks);
					}
				}catch(Exception e){
					System.out.println("USER EXCEPTION FOUND:");
					e.printStackTrace();
				}*/
				scrollDown(driver);
				scrollDown(driver);
				waitAndClick(nextBtn);
				System.out.println("Third optional Item NEXT Executed !!");
				/*try{
					Thread.sleep(500);
					if(upSellNoThanks.isDisplayed())
					{
						waitAndClick(upSellNoThanks);
					}
									}catch(Exception e){
					System.out.println("USER EXCEPTION FOUND:");
					e.printStackTrace();
				}*/
					
			}
			else if(optionItems.equals("YES")){
				Thread.sleep(3000);
				scrollDown(driver);
				scrollDown(driver);
				optionalitem1.click();
				System.out.println("Quantity 1 is selected");
				Thread.sleep(3000);
				waitAndClick(nextBtn);
				System.out.println("First optional Item NEXT Executed !!");
				try{
					Thread.sleep(5000);
					if(upSellNoThanks.isDisplayed())
					{
						waitAndClick(upSellNoThanks);
					}

				}catch(Exception e){
					System.out.println("USER EXCEPTION FOUND:");
					e.printStackTrace();
				}
				scrollDown(driver);
				scrollDown(driver);
				optionalitem2.click();
				System.out.println("Quantity 2 is selected");
				Thread.sleep(1200);
				waitAndClick(nextBtn);
				System.out.println("Second optional Item NEXT Executed !!");
				scrollDown(driver);
				optionalitem3.click();
				System.out.println("Quantity 3 is selected");
				Thread.sleep(1200);
				waitAndClick(nextBtn);
				System.out.println("Third optional Item NEXT Executed !!");
				Thread.sleep(1200);
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: SelectOptionalitems()");
		}
	}	
	//************************************************************************************************
	//*********************Methods to validate Confirmation Number************************************
	//************************************************************************************************
	public String validateConfirmationNumber() throws IOException, InterruptedException {
		try {
			String confNumber = waitAndGetText(confirmationNumber);
			System.out.println("Confirmation Number is generated : "+confNumber);
			return confNumber;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateConfirmationNumber()");
			return "Issue with Method: validateConfirmationNumber()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateEstimatedPriceAtReservationSummaryPage******************
	//************************************************************************************************	
	public String validatePriceAtReservationSummaryPage(){
		try {
			WebElement ele = driver.findElement(By.xpath("//label[@id='totalPriceReviewPage']"));
			String totalPrice = ele.getText();
			System.out.println("Total Price displayed in Reservation Summary Page :"+totalPrice);
			return totalPrice;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEstimatedPriceAtReservationSummaryPage()");
			return "Issue with Method: validateEstimatedPriceAtReservationSummaryPage()";
		}
	}



	//************************************************************************************************
	//*********************Methods to validate Select Package****************************
	//************************************************************************************************
	public String validatePackagePrice(String basePKG, String upgrade) throws InterruptedException {
		try {
			String alertMessage = null;
			double childCount,childCost,cost;
			String totalCost = null;
			if(basePKG.equals("Star")) {
				String StarPackagevalue=STAR_price.getText();
				String Price1=StarPackagevalue.replaceAll("[a-zA-Z]", "");
				String Price=Price1.substring(1);
				System.out.println("The Star Package Child Price is >>"+Price);
				cost = Double.valueOf(Price);			
				System.out.println("The Star Package Child Cost is >>"+cost);
				childCount=10;
				childCost=childCount*cost;
				totalCost= childCost+"0";
				System.out.println("The Total amount is >>"+totalCost);
				waitAndClick(selectPackageStarBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("SuperStar")) {
				String SUPER_price= SUPERSTAR_price.getText();
				String Price1=SUPER_price.replaceAll("[a-zA-Z]", "");
				String Price=Price1.substring(1);
				cost = Double.valueOf(Price);			
				System.out.println("The SupeerStar Package Child Price is >>"+cost);
				System.out.println("The Total amount is >>"+totalCost);
				childCount=10;
				childCost=childCount*cost;
				totalCost= childCost+"0";
				System.out.println("The Total amount is >>"+totalCost);
				waitAndClick(selectPackageSuperStarBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("MegaStar")) {
				String MEGA_price= MEGASUPERSTAR_price.getText();
				System.out.println("The Mega SupeerStar Package Child is >>"+MEGA_price);
				String Price1=MEGA_price.replaceAll("[a-zA-Z]", "");
				String Price=Price1.substring(1);
				cost = Double.valueOf(Price);
				childCount=10;
				childCost=childCount*cost;
				totalCost= childCost+"0";
				System.out.println("The Mega SupeerStar Package Child is >>"+cost);
				System.out.println("The Total amount is >>"+totalCost);
				waitAndClick(selectPackageMegaStarBtn);
				alertMessage = "true"; 
			}
			else {
				System.out.println("You are not chosen the right package!!!");
			}

			if(upgrade.equals("YES") && !basePKG.equals("MegaStar")) 
			{
				Thread.sleep(5000);
				boolean upgradebut = upgradeBtn.isDisplayed();
				System.out.println(upgradebut);
				waitAndClick(upgradeBtn);
			}else if(upgrade.equals("NO") && !basePKG.equals("MegaStar")) 
			{
				waitAndClick(nothanksBtn);
			}else if(upgrade.equals(""))
			{
				pressEnter(Keys.ENTER);
			}else {
				System.out.println("Invalid Option given at Methods: validateSelectPackage, "
						+ "second parameter should be YES or NO for Upgrade pop-up. "
						+ "OR You might be chosen 120min, No Upgrade pop-up expected.");
			}
			System.out.println("SELECT PACKAGE SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return totalCost;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackage_Price()");
			return "Issue with Method: validatePackage_Price()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Upgrade package****************************************
	//************************************************************************************************
	public String validateUpgradePackage() throws IOException, InterruptedException {
		try {
			String updatedPackage =  null;
			waitAndClick(modifyReservation);
			Thread.sleep(3000);
			updatedPackage = validatePackage.getText();
			System.out.println("The package selected is:"+updatedPackage);
			return updatedPackage; 
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpgradePackage()");
			return "Issue with Method: validateUpgradePackage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Modify Reservation*************************************
	//************************************************************************************************
	public void validateModifyReservation() throws IOException, InterruptedException {
		try {
			waitAndClick(modifyReservation);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateModifyReservation()");
		}
	}


	//************************************************************************************************
	//*********************Methods to validate Select Child, Adult***************************
	//************************************************************************************************
	public void validateMinChild() throws InterruptedException, AWTException {
		try {
			childrenTextBox.sendKeys("3");
			adultTextBox.sendKeys("1");
			Thread.sleep(1000);
			pickdateBtn.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMinChild()");
		}

	}

	//************************************************************************************************
	//*********************Methods to validate Minimum children Error Message for VIP booking ********
	//************************************************************************************************	
	public String validateVIPErrorMessge(String child) throws InterruptedException, AWTException {
		try {
			String errorMsg = null;
			waitAndClick(editPartySizeLink);
			if(child=="min") {
				Thread.sleep(1000);
				childrenTextBox.clear();
				Thread.sleep(1000);
				childrenTextBox.sendKeys("7");
				adultTextBox.clear();
				Thread.sleep(1000);
				adultTextBox.sendKeys("1");
				Thread.sleep(1000);
				pickdateBtn.click();
				Thread.sleep(1000);
				errorMsg = vipMinBookingMsg.getText();
			}else if(child=="max") {
				Thread.sleep(1000);
				childrenTextBox.clear();
				Thread.sleep(1000);
				childrenTextBox.sendKeys("300");
				adultTextBox.clear();
				Thread.sleep(1000);
				adultTextBox.sendKeys("10");
				Thread.sleep(1000);
				pickdateBtn.click();
				Thread.sleep(1000);
				errorMsg = vipMaxBookingMsg.getText();
			}
			System.out.println("The error message is: "+errorMsg);
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateVIPErrorMessge()");
			return "Issue with Method: validateVIPErrorMessge()";
		}
	}
	//************************************************************************************************
	//******Methods to validate the Error Message for the Mandatory fields in Party Size page ********
	//************************************************************************************************	
	public String validateBirthdayBookingMandatoryFields(String sChild,String sAdult) throws InterruptedException, AWTException {
		try {
			String errorMsg = null;
			if(sChild.equals("YES")){
				childrenTextBox.sendKeys("6");
			}else {
				childrenTextBox.sendKeys("");
			}
			Thread.sleep(1000);
			if(sAdult.equals("YES")){
				adultTextBox.sendKeys("1");
			}else {
				adultTextBox.sendKeys("");
			}
			waitAndClick(pickdateBtn);
			Thread.sleep(1000);
			if(sChild.equals("NO") && sAdult.equals("NO")) {
				errorMsg = childAlertMsg.getText();
			}if(sChild.equals("YES") && sAdult.equals("NO")) {
				errorMsg = adultAlertMsg.getText();
			}
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayBookingMandatoryFields()");
			return "Issue with Method: validateBirthdayBookingMandatoryFields()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Minimum children/Adult Error Message  ********
	//************************************************************************************************	
	public String validateBirthdayBookingMinChildAdult(String sChild,String sAdult) throws InterruptedException, AWTException {
		try {
			String errorMsg = null;
			if(sChild.equals("MIN")){
				childrenTextBox.sendKeys("3");
				Thread.sleep(1000);
			}else {
				Thread.sleep(1000);
				childrenTextBox.clear();
				childrenTextBox.sendKeys("4");
			}
			Thread.sleep(1000);
			if(sAdult.equals("MIN")){
				adultTextBox.clear();
				adultTextBox.sendKeys("0");
			}else {
				Thread.sleep(1000);
				adultTextBox.sendKeys("1");
			}
			Thread.sleep(1000);
			waitAndClick(pickdateBtn);
			Thread.sleep(2000);
			if(sChild.equals("MIN") && sAdult.equals("YES")) {
				errorMsg = minchildAlertMsg.getText();
			}if(sChild.equals("YES") && sAdult.equals("MIN")) {
				errorMsg = minadultAlertMsg.getText();
			}
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateBirthdayBookingMinChildAdult()");
			return "Issue with Method: validateBirthdayBookingMinChildAdult()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Minimum children Error Message for VIP booking ********
	//************************************************************************************************	
	public void validateUpdatePartySize() throws InterruptedException, AWTException {
		try {
			waitAndClick(editPartySizeLink);
			Thread.sleep(1000);
			childrenTextBox.clear();
			Thread.sleep(1000);
			childrenTextBox.sendKeys("15");
			adultTextBox.clear();
			Thread.sleep(1000);
			adultTextBox.sendKeys("15");
			Thread.sleep(1000);
			pickdateBtn.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdatePartySize()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Edit the cart item ********
	//************************************************************************************************	
	public boolean validateEditPartySizeFromCart() throws InterruptedException, AWTException {
		try {
			waitAndClick(cartLaunch);
			Thread.sleep(1000);
			waitAndClick(cartPartySize);
			childrenTextBox.clear();
			Thread.sleep(1000);
			childrenTextBox.sendKeys("15");
			adultTextBox.clear();
			Thread.sleep(1000);
			adultTextBox.sendKeys("15");
			Thread.sleep(1000);
			pickdateBtn.click();
			Thread.sleep(1000);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEditPartySizeFromCart()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validate Header link click Functionality ***********************
	//************************************************************************************************	
	public String validateHeaderLink() throws InterruptedException, AWTException {
		try {
			waitAndClick(header1);
			System.out.println("Clicked on header 1 Successfully");
			String headertext=waitAndGetText(header1HeaderText);
			return headertext;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateHeaderLink()");
			return "Issue with Method: validateHeaderLink()";
		}
	}
	//************************************************************************************************
	//*********************Methods to jsClick ********************************************************
	//************************************************************************************************	
	public static void jsClick(WebDriver driver, WebElement el)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", el);
	}	
	//************************************************************************************************
	//*********************Methods to pressEnter *****************************************************
	//************************************************************************************************	
	private void pressEnter(Keys tab) {
		// used above as: pressEnter(Keys.ENTER);

	}
}
