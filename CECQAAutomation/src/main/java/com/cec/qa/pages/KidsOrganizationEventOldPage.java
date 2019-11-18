package com.cec.qa.pages;
import java.awt.AWTException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cec.qa.base.BaseTest;

public class KidsOrganizationEventOldPage extends BaseTest{
	//************************************************************************************************
	//*********************PARTY SIZE - SELECT CHILD,ADULT & DATE*************************************
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
	//*********************SHOW CALANDER - SELECT DATE & TIME SLOT************************************
	//************************************************************************************************

	@FindBy(xpath = "//a[@title='Next']")
	WebElement nextmonthLink;

	//************************************************************************************************
	//*********************PARTY PACKAGES - SELECT PACKAGE *******************************************
	//************************************************************************************************

	@FindBy(xpath="(//button[@title='Choose the 60 Minutes of All You Can Play  Package'])")
	WebElement selectPackage60minBtn;

	@FindBy(xpath="(//button[@title='Choose the 90 Minutes of All You Can Play  Package'])")
	WebElement selectPackage90minBtn;

	@FindBy(xpath="(//button[@title='Choose the 120 Minutes of All You Can Play  Package'])")
	WebElement selectPackage120Btn;

	@FindBy(xpath="(//div[@id='btnOk'and contains(text(),'Upgrade')])[2]")
	WebElement upgradeBtn;

	@FindBy(xpath="//span[@id='btnCancel']")
	WebElement nothanksBtn;

	String noThanksXpath="//span[@id='btnCancel']";

	@FindBy(id="Back")
	WebElement backBtn;

	@FindBy(id="NEXT")
	WebElement nextBtn;

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$7.99')])[1]")
	WebElement _60min_price;

	@FindBy(xpath="(//span[@class='spanPackagePrice' and contains(text(),'$9.99')])[1]")
	WebElement _90min_price;

	@FindBy(xpath="(//div[@class='packageInner bckBlue']//span[@class='spanPackagePrice'])[1]")
	WebElement _120min_price;

	//************************************************************************************************
	//*********************CONTACT INFORMATION - Contact Info*****************************************
	//************************************************************************************************

	@FindBy(id="OrganizationName")
	WebElement organizationNameTextBox;

	@FindBy(id="OrganizationPhone")
	WebElement organizationPhoneTextBox;

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

	@FindBy(id="NEXT")
	WebElement booknowBtn;

	@FindBy(id="reservation_ReservationGuestDetails_OrganizationType")
	WebElement reservationTypeDropdown;


	//************************************************************************************************
	//*********************Confirmation Page *********************************************************
	//************************************************************************************************

	//@FindBy(xpath="(//p[contains(text(),'Your reservation is confirmed.')])[1]")
	//WebElement confirmationNumber;

	@FindBy(xpath="(//p[contains(text(),'Your reservation is confirmed.')])/span[1]")
	WebElement confirmationNumber;

	@FindBy(id = "btnForward")
	WebElement forwardconfirmation;

	@FindBy(xpath = "//a[contains(text(),'Modify Reservation')]")
	WebElement modifyReservation;

	//************************************************************************************************
	//*********************RESERVATION SUMMARY *******************************************************
	//************************************************************************************************

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[1]")
	WebElement editDateandTimeLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[2]")
	WebElement editPartySizeLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[3]")
	WebElement editPartyPackageLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[6]")
	WebElement editContactNameLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[7]")
	WebElement editEmailIdLink;

	@FindBy(xpath="(//a[@class='edit fa fa-pencil'])[8]")
	WebElement editPhoneNumberLink;

	@FindBy(xpath="//label[@id='totalPriceReviewPage']")
	WebElement totalAmount;

	@FindBy(xpath="//dd[@class='package' and contains(text(),'120min')]")
	WebElement validatePackage;

	//************************************************************************************************
	//*********************ERROR MESSAGES ************************************************************
	//************************************************************************************************


	@FindBy(id="errMsgChild")
	WebElement childAlertMsg;


	@FindBy(id="errMsgAdult")
	WebElement adultAlertMsg;

	@FindBy(xpath="//div[@id='errMsgChild' and contains(text(),'Minimum 6 children required.')]")
	WebElement minchildAlertMsg;

	@FindBy(xpath="//div[@id='errMsgAdult' and contains(text(),'Minimum 1 guest required.')]")
	WebElement minadultAlertMsg;

	@FindBy(xpath="//div[contains(text(),'Due to the increase of children/adults the time you originally selected is no longer available. To move forward with the same time slot, reduce the children/adults?')]")
	WebElement overBookErrorMsg;

	//************************************************************************************************
	//*********************Header link****************************************************************
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

	public KidsOrganizationEventOldPage(){
		PageFactory.initElements(driver, this);
	}
	public static String selectedDate;
	public static String calenderDate;
	public static int i,j,row,col;
	public static String A1=null,A3=null,A5=null;
	public static int A2=0,A4=0;

	//************************************************************************************************
	//*********************Methods to validateSelectStore ********************************************
	//************************************************************************************************
	public String validateSelectStore(String store) {
		try {
			driver.navigate().to("https://test-book.chuckecheese.com/Reservations/PartyDetails?id="+store+"&restype=3");
			return store;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectStore()");
			return "Issue with Method: validateSelectStore()";
		}

	}
	//************************************************************************************************
	//*********************Methods to validateSelectChildAdult ***************************************
	//************************************************************************************************
	public void validateSelectChildAdult() throws InterruptedException, AWTException {
		try {
			childrenTextBox.sendKeys("10");
			adultTextBox.sendKeys("10");
			Thread.sleep(1000);
			pickdateBtn.click();
			Thread.sleep(1000);
			System.out.println("ENTER CHILD AND ADULT SUCCESS......................................................................!!!!!!!!!!!");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectChildAdult()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validate Select Party date and Timeslot**************************
	//************************************************************************************************
	/*public String SelectEventDate(String date, String timeslot) throws InterruptedException{
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
			jsClick(driver,driver.findElement(By.xpath(selectedDate)));
			String A01 = "//*[@data-timeslot='";
			String A02 = timeslot;
			String A03 = "']";
			String selectedTimeSlot = A01+A02+A03;
			//System.out.println("The time slot is selected"+selectedTimeSlot);
			Thread.sleep(2);
			jsClick(driver,driver.findElement(By.xpath(selectedTimeSlot)));		// TimeSlot
			Thread.sleep(2);
			System.out.println("TIME SLOT SELECTED SUCCESS......................................................................!!!!!!!!!!!");
			return selectedTimeSlot;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: SelectEventDate()");
			return "Issue with Method: SelectEventDate()";
		}
	} */

	//************************************************************************************************
	//*********************Methods to validateSelectEventDate ****************************************
	//************************************************************************************************	
	public String validateSelectEventDate(int date, String timeslot) throws InterruptedException{
		try {
			//    clicking NEXT Month
			JavascriptExecutor js = (JavascriptExecutor)driver;
			js.executeScript("arguments[0].click();", nextmonthLink);
			js.executeScript("window.scrollBy(0,250)", "");
			Thread.sleep(4000);	
			String dateXpath = "//a[text()='"+date+"']";
			driver.findElement(By.xpath(dateXpath)).click();
			String A01 = "//*[@data-timeslot='";
			String A02 = timeslot;
			String A03 = "']";
			String selectedTimeSlot = A01+A02+A03;
			System.out.println("The time slot is selected"+selectedTimeSlot);
			Thread.sleep(2);
			jsClick(driver,driver.findElement(By.xpath(selectedTimeSlot)));		// TimeSlot
			Thread.sleep(2);
			return selectedTimeSlot;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateSelectEventDate()");
			return "Issue with Method: validateSelectEventDate()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateSelectPackage ******************************************
	//************************************************************************************************
	public String validateSelectPackage(String basePKG) throws InterruptedException {
		try {
			String alertMessage = null;
			if(basePKG.equals("60min")) {
				waitAndClick(selectPackage60minBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("90min")) {
				waitAndClick(selectPackage90minBtn);
			}else if(basePKG.equals("120min")) {
				waitAndClick(selectPackage120Btn);
			}else {
				System.out.println("Invalid PKG entry");
			}
			Thread.sleep(3000);
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
	//*********************Methods to validateContactInformation *************************************
	//************************************************************************************************
	public boolean validateContactInformation(String toCheckBooking) throws InterruptedException, AWTException {
		try {
			if(toCheckBooking.equals("YES")){
				organizationNameTextBox.sendKeys(propv.getProperty("bName"));
				Thread.sleep(1000);
				organizationNameTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot(propv.getProperty("bPhone"));
				Thread.sleep(1000);
				customerNameTextBox.sendKeys(propv.getProperty("bName"));
				Thread.sleep(1000);
				customerNameTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot(propv.getProperty("bPhone"));
				Thread.sleep(1000);
				emailTextBox.sendKeys(propv.getProperty("bEmail"));
				Thread.sleep(1000);
				Select orgType = new Select(driver.findElement(By.id("reservation_ReservationGuestDetails_OrganizationType")));
				orgType.selectByIndex(2);
				Thread.sleep(1000);
				specinsTextBox.sendKeys(getSaltString());
				Thread.sleep(1000);
				scrollDown(driver);
				waitAndClick(nextBtn);
			}else{
				organizationNameTextBox.sendKeys(getSaltString());
				Thread.sleep(1000);
				organizationNameTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot("");
				Thread.sleep(1000);
				customerNameTextBox.sendKeys(getSaltString());
				Thread.sleep(1000);
				customerNameTextBox.sendKeys(Keys.TAB);
				enterPhoneNumberUsingRobot("");
				Thread.sleep(1000);
				emailTextBox.sendKeys(getSaltEmail());
				Thread.sleep(1000);
				Select orgType = new Select(driver.findElement(By.id("reservation_ReservationGuestDetails_OrganizationType")));
				orgType.selectByIndex(2);
				Thread.sleep(1000);
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
	//*********************Methods to validateDuplidateBookingWarningWindow **************************
	//************************************************************************************************	
	public boolean validateDuplidateBookingWarningWindow() throws InterruptedException{
		boolean result = false;
		try {
			Thread.sleep(10000);
			if(duplicate.isDisplayed() ){
				result = true;
				System.out.println("Found Duplicates window displayed : "+result);
			}else{
				System.out.println("Not found Duplicates Message/Window" +result);
				result = false;
			}
			return result;
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
			organizationNameTextBox.clear();
			Thread.sleep(1000);
			organizationPhoneTextBox.clear();
			Thread.sleep(1000);
			customerNameTextBox.clear();
			Thread.sleep(1000);
			emailTextBox.clear();
			Thread.sleep(1000);
			phonenoTextBox.clear();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateContactInformationClear()");
		}
	}

	//************************************************************************************************
	//*********************Methods to validateContactInformationForDuplicateCheck*********************
	//************************************************************************************************
	public void validateContactInformationForDuplicateCheck(String cName, String cPhone,String cEmail) throws InterruptedException, AWTException {
		try {
			organizationNameTextBox.sendKeys(getSaltString());
			Thread.sleep(1000);
			organizationNameTextBox.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot("");
			Thread.sleep(1000);
			customerNameTextBox.sendKeys(cName);
			Thread.sleep(1000);
			customerNameTextBox.sendKeys(Keys.TAB);
			enterPhoneNumberUsingRobot(cPhone);
			Thread.sleep(1000);
			emailTextBox.sendKeys(cEmail);
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
	//*********************Methods to validateReservationSummary *************************************
	//************************************************************************************************
	public boolean validateReservationSummary() throws IOException, InterruptedException {
		try {
			boolean x = false;
			Thread.sleep(1000);
			waitAndClick(nextBtn);
			return x;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateReservationSummary()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to validateConfirmationNumber *************************************
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
	public String validateEstimatedPriceAtReservationSummaryPage(String Total_price1){
		try {
			WebElement amount = driver.findElement(By.xpath("//label[@id='totalPriceReviewPage']"));
			String totatPrice=amount.getText();
			System.out.println("Total Price displayed in Reservation Summary Page :"+totatPrice);
			return totatPrice;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEstimatedPriceAtReservationSummaryPage()");
			return "Issue with Method: validateEstimatedPriceAtReservationSummaryPage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validatePackagePrice *******************************************
	//************************************************************************************************
	public String validatePackagePrice(String basePKG) throws InterruptedException {
		try {
			String alertMessage = null;
			double childCount,childCost,cost;
			String totalchildCost = null;
			if(basePKG.equals("60min")) {
				String _60minPackagevalue=_60min_price.getText();
				String price1=_60minPackagevalue.replaceAll("[a-zA-Z]", "");
				String price=price1.substring(1);
				System.out.println("The 60min Package Child Price is >>"+price);
				cost = Double.valueOf(price);			
				System.out.println("The 60min Package Child Cost is >>"+cost);
				childCount=10;
				childCost=childCount*cost;
				totalchildCost= childCost+"0";
				System.out.println("The Total Cost is >>"+totalchildCost);
				waitAndClick(selectPackage60minBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("90min")) {
				String _90minPackagevalue= _90min_price.getText();
				String Price=_90minPackagevalue.replaceAll("[a-zA-Z]", "");
				cost = Double.valueOf(Price);			
				System.out.println("The 90min Package Child Price is >>"+cost);
				childCount=10;
				childCost=childCount*cost;
				totalchildCost= childCost+"0";
				System.out.println("The Total Cost is >>"+totalchildCost);
				waitAndClick(selectPackage90minBtn);
				alertMessage = "true"; 
			}else if(basePKG.equals("120min")) {
				String _120minPackagevalue = _120min_price.getText();
				System.out.println("The 120min Package Child is >>"+_120minPackagevalue);
				String Price1=_120minPackagevalue.replaceAll("[a-zA-Z]", "");
				String Price=Price1.substring(1);
				cost = Double.valueOf(Price);
				childCount=10;
				childCost=childCount*cost;
				totalchildCost= childCost+"0";
				System.out.println("120min Package Child Price is >>"+cost);
				System.out.println("The Total Cost is >>"+totalchildCost);
				waitAndClick(selectPackage120Btn);
				alertMessage = "true"; 
			}
			else {
				System.out.println("You are not chosen the right package!!!");
			}
			System.out.println("SELECT PACKAGE SUCCESS......................................................................!!!!!!!!!!!");
			System.out.println("The Alert Message is displayed as: " +alertMessage);
			return totalchildCost;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePackagePrice()");
			return "Issue with Method: validatePackagePrice()";
		}
	}

	//************************************************************************************************
	//*********************Methods to validateUpgradePackage  ****************************************
	//************************************************************************************************
	public String validateUpgradePackage() throws IOException, InterruptedException {
		try {
			String updatedPackage =  null;
			waitAndClick(modifyReservation);
			Thread.sleep(3000);
			updatedPackage = validatePackage.getText();
			return updatedPackage;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpgradePackage()");
			return "Issue with Method: validateUpgradePackage()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateModifyReservation **************************************
	//************************************************************************************************
	public void validateModifyReservation() throws IOException, InterruptedException {
		try {
			Thread.sleep(3000);
			waitAndClick(modifyReservation);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateModifyReservation()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateMinChild ***********************************************
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
	//******Methods to validateEventBookingMandatoryFields  ******************************************
	//************************************************************************************************	
	public String validateEventBookingMandatoryFields(String sChild,String sAdult) throws InterruptedException, AWTException {
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
			System.out.println("The Error Message displayed:"+errorMsg);
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEventBookingMandatoryFields()");
			return "Issue with Method: validateEventBookingMandatoryFields()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateEventBookingMinChildAdult  *****************************
	//************************************************************************************************	
	public String validateEventBookingMinChildAdult(String sChild,String sAdult) throws InterruptedException, AWTException {
		try {
			String errorMsg = null;
			if(sChild.equals("MIN")){
				childrenTextBox.sendKeys("3");
				Thread.sleep(1000);
			}else {
				Thread.sleep(1000);
				childrenTextBox.clear();
				childrenTextBox.sendKeys("6");
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
			System.out.println("The Error Message displayed:"+errorMsg);
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateEventBookingMinChildAdult()");
			return "Issue with Method: validateEventBookingMinChildAdult()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateUpdateEventSize ****************************************
	//************************************************************************************************	
	public void validateUpdateEventSize() throws InterruptedException, AWTException {
		try {
			waitAndClick(editPartySizeLink);
			Thread.sleep(1000);
			childrenTextBox.clear();
			Thread.sleep(1000);
			childrenTextBox.sendKeys("25");
			adultTextBox.clear();
			Thread.sleep(1000);
			adultTextBox.sendKeys("25");
			Thread.sleep(1000);
			pickdateBtn.click();
			Thread.sleep(1000);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateEventSize()");
		}
	}
	//************************************************************************************************
	//*********************Methods to validateOverBookErrorMessge ************************************
	//************************************************************************************************	
	public String validateOverBookErrorMessge(String child) throws InterruptedException, AWTException {
		try {
			String errorMsg = null;
			waitAndClick(editPartySizeLink);
			if(child=="max") {
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
				errorMsg = overBookErrorMsg.getText();
			}
			System.out.println("The error message is: "+errorMsg);
			return errorMsg;
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateOverBookErrorMessge()");
			return "Issue with Method: validateOverBookErrorMessge()";
		}
	}
	//************************************************************************************************
	//*********************Methods to validateEditPartySizeFromCart **********************************
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
	//***********************************************************************************************************************
	//******************** Methods to validateOrganizationTypeDropdownList **************************************************
	//********************* Created by: Monalisa on 05-06-2019 **************************************************************
	//***********************************************************************************************************************	
	public void validateOrganizationTypeDropdownList() { 
		scrollDown(driver);
		List<String> organizationType= new ArrayList<String>();
		organizationType.add("Camp or Daycare");
		organizationType.add("Church");
		organizationType.add("Non-profit organization");
		organizationType.add("Other club");
		organizationType.add("School");
		organizationType.add("Sports Team");
		Select select = new Select(reservationTypeDropdown); 
		List<WebElement> organizationTypeDropdownList = select.getOptions(); 
		for(int i=0;i<organizationTypeDropdownList.size();i++)
		{    
			Assert.assertEquals(organizationTypeDropdownList.get(i).getText(),organizationType.get(i));
		}
	}
	//************************************************************************************************
	//*********************Methods to validateHeaderLink *********************************************
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
	//*************************************************************************************************
	public static void jsClick(WebDriver driver, WebElement el)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].click()", el);
	}	
}
