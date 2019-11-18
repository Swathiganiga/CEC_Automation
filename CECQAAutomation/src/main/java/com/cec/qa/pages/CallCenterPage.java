package com.cec.qa.pages;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

import org.json.JSONException;
import org.json.JSONObject;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.events.EventFiringWebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.cec.qa.data.CallCenterLocators;
import com.cec.qa.data.CallCenterUserData;
import com.cec.qa.data.CallCenterXLReader;
import com.cec.qa.data.CallCenterMethods;
import com.google.common.base.Function;

import io.qameta.allure.Step;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.equalTo;

public class CallCenterPage extends CallCenterMethods{
//	public CEC_Login(WebDriver driver) {
//		super();
//	}

	public static final String currentPropDir = System.getProperty("user.dir");
	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";

	public static Properties AppText = new Properties();
	public static Properties Repository = new Properties();
	public static String TestData;
	public static WebDriver driver;
	public static WebElement element;
	public static String webElement;
	CallCenterLocators page = PageFactory.initElements(driver, CallCenterLocators.class);
	
	static SoftAssert sa=new SoftAssert();
	
	@Step("Set system property for webdriver, open Chrome and launch App")
	public static WebDriver initBrowser(String browser) throws IOException {
		
		if (browser=="GC")
		{
			System.out.println("Initializing GC driver"); 
			System.setProperty("webdriver.chrome.driver","C://Users//maneeshap//eclipse-workspace//drivers//chromedriver.exe");
			driver = new ChromeDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Driver initialized, URL being called");
			driver.get(CallCenterUserData.CEC_BaseURL);
			System.out.println("Driver initialized, URL");
			//return "Pass";
//			this.driver = driver;
			return driver;
		}
		else if(browser=="FF")
		{
			System.out.println("Initializing FF driver"); 
	    	System.setProperty("webdriver.gecko.driver", "C://Users//maneeshap//eclipse-workspace//drivers//geckodriver.exe");
			driver = new FirefoxDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			System.out.println("Driver initialized, URL being called");
			driver.get(CallCenterUserData.CEC_BaseURL);
//			this.driver = driver;
			return driver;
		}	
		else if(browser=="IE")
		{
			System.out.println("Initializing IE driver"); 
			System.setProperty("webdriver.ie.driver", IEdriverPath);
			driver = new InternetExplorerDriver();
			driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
			driver.manage().window().maximize();
			System.out.println("Driver initialized, URL being called");
			driver.get(CallCenterUserData.CEC_BaseURL);
			System.out.println("URL Launched");
//			this.driver = driver;
			return driver;
		}
		return driver;	
	}

	@Step("Select CallCenter login, enter Password and sign-in")
	public static String RobotLogin() throws IOException {
		try {
		System.out.println("RobotLogin function called");
		System.out.println("Driver is"+driver);
		//Thread.sleep(5000);
		// create robot for keyboard operations
		Robot rb = new Robot();
		Thread.sleep(5000);
		StringSelection pwd = new StringSelection(CallCenterUserData.CEC_Password);
		Toolkit.getDefaultToolkit().getSystemClipboard().setContents(pwd, null);
		rb.keyPress(KeyEvent.VK_CONTROL);
		rb.keyPress(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_V);
		rb.keyRelease(KeyEvent.VK_CONTROL);
		// press enter
		rb.keyPress(KeyEvent.VK_ENTER);
		rb.keyRelease(KeyEvent.VK_ENTER);
		Thread.sleep(3000);
		//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
	} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}
	
	@Step("Change Button Functionality")
	public static String ChangeButtonFunctionality() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnReviewMenu.click();
				
			selectDrpDwnByText(HomePage.ReservationTypeId, "Birthday");
			System.out.println("User selected the ReservationType from the dropdown");
			wait(3);
				
			validateText(HomePage.txtReservationBirthday);
			wait(4);
				
			HomePage.btnSearch.click();
			wait(4);
			selectDrpDwnByIndex(HomePage.drpDwnReservations,1);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(5);
				
			scrollDown(driver);
			wait(3);
				
			HomePage.btnChange.isDisplayed();
			System.out.println("Change button is available on the Reservation Review Page");
			HomePage.btnChange.click();
				
			explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
				
			wait(2);
			getFirstSelectedOption(HomePage.selectReservationsType);
			//Assert.assertEquals(getFirstSelectedOption(HomePage.selectReservationsType), "Birthday");
			wait(2);
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			selectRdoBtn(HomePage.selectTimeSlot,1);
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			System.out.println("Able to edit all the fields");
			
			GetCalendarInstance();
				
			
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
		}	

	@Step("Confirm Button Functionality")
	public static String ConfirmButtonFunctionality() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnReviewMenu.click();
				
			selectDrpDwnByIndex(HomePage.ReservationTypeId,3);
			System.out.println("User selected the ReservationType from the dropdown");
			CallCenterMethods.wait(3);
				
			getText(HomePage.txtReservationOrganizational);
			wait(4);
				
			HomePage.btnSearch.click();
				
			selectDrpDwnByIndex(HomePage.drpDwnReservations,11);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(5);
				
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,450)", "");
			wait(3);
				
			validateText(HomePage.txtOrganizational);
			String txtOrganizational = HomePage.txtOrganizational.getText();
			
			assertEquals(txtOrganizational, "Organizational", "The Reservationb Type does not match");
			wait(2);
			
			String Actualstatus= HomePage.txtStateNameID.getText();
			System.out.println("Before clicking Confirm button the status is as: " + Actualstatus);
			
			HomePage.btnConfirm.isDisplayed();
			System.out.println("Confirm button is available on the Reservation Review Page");
			HomePage.btnConfirm.click();
			//HomePage.txtOrderConfirmed.isDisplayed();
			if(HomePage.txtOrderConfirmed.isDisplayed())
			{
				System.out.println("Order has been confirmed. is shown");
			}
			else
			{
				System.out.println("Order has been confirmed. is not shown");
			}
			System.out.println("User successfully clicked Confirm Button ");
		}	
		catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}
	
	@Step("New Button Functionality")
	public static String NewButtonFunctionality() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnReviewMenu.click();
				
			selectDrpDwnByIndex(HomePage.ReservationTypeId,2);
			System.out.println("User selected the ReservationType from the dropdown");
			wait(3);
				
			validateText(HomePage.txtReservationFundRaising);
			wait(4);
				
			HomePage.btnSearch.click();
				
			selectDrpDwnByIndex(HomePage.drpDwnReservations,2);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(5);
				
			JavascriptExecutor jse = (JavascriptExecutor) driver;
			jse.executeScript("window.scrollBy(0,450)", "");
			wait(3);
				
			validateText(HomePage.txtFundRaising);
			String actualtype = HomePage.txtFundRaising.getText();
			
			
			System.out.println(" The Resevation type under partyInfo is :" + actualtype);
			assertEquals(actualtype, "Fund Raising", "The Reservationb Type does not match");
			wait(2);
			
			/*element = HomePage.txtStateNameID;
			String Actualstatus= element.getText();
			System.out.println("Before clicking Confirm button the status is as: " + Actualstatus);*/
			
			HomePage.btnNew.isDisplayed();
			System.out.println("New button is available on the Reservation Review Page");
			HomePage.btnNew.click();
			if(HomePage.txtstorenumb.isDisplayed())
			{ System.out.println("txtstorenumb is shown"); }
			else
			{ System.out.println("txtstorenumb is not shown"); }
			System.out.println(" User successfully clicked New Button ");
			
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
		}	
	
	@Step("enter all the details and verify Add New Party Type Category")
	public static String AddNewPartyTypeCategory() throws IOException {
	//public static String AddNewPartyTypeCategory(String Name, String DisplayTitle, String Description) throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnPartyMenu.click();
			
			HomePage.btnPartyTypeCategory.click(); //HomePage.btnPartyTypeCategoryXpath.click();
			System.out.println("Party Type Category link clicked");
			wait(2);
			
			HomePage.txtName.sendKeys("@@@@" + Keys.TAB);
			System.out.println(getText(HomePage.txtAlphanumeric));
			wait(3);
			
			HomePage.txtName.clear();
			//HomePage.txtName.sendKeys("Name" + Keys.TAB);
			HomePage.txtName.sendKeys(CallCenterUserData.AddNewPartyTypeCategory_Name + Keys.TAB);
			System.out.println("Entered the Name");

			HomePage.txtDisplayName.sendKeys("@@@@" + Keys.TAB);
			System.out.println(getText(HomePage.txtAlphanumeric));
			wait(3);
			
			HomePage.txtDisplayName.clear();
			wait(2);
			//HomePage.txtDisplayName.sendKeys("DisplayTitle" + Keys.TAB);
			HomePage.txtDisplayName.sendKeys(CallCenterUserData.AddNewPartyTypeCategory_DisplayTitle + Keys.TAB);
			System.out.println("Entered the Display Title");
			
			//HomePage.txtDescription.sendKeys("Description");
			HomePage.txtDescription.sendKeys(CallCenterUserData.AddNewPartyTypeCategory_Description);
			System.out.println("Entered the Description");
			
			selectDrpDwnByText(HomePage.drpReservationType,"Birthday");
			
			selectDrpDwnByText(HomePage.drpCallOutOption,"Most Popular");
			
			selectDrpDwnByText(HomePage.drpCallOutColor,"Red");
		
			JavascriptExecutor js = (JavascriptExecutor) driver;
			js.executeScript("window.scrollBy(0,350)", "");
				
			
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
		}		
	
	@Step("Update Party Type Category")
	public static String UpdatePartyTypeCategory() throws IOException {
	//public static String AddNewPartyTypeCategory(String Name, String DisplayTitle, String Description) throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnPartyMenu.click();
			
			HomePage.btnPartyTypeCategory.click(); //HomePage.btnPartyTypeCategoryXpath.click();
			System.out.println("Party Type Category link clicked");
			wait(2);
			
			selectLastElement(HomePage.drpselectLastElement);
			
			HomePage.txtDescription.click();
			HomePage.txtDescription.clear();
			HomePage.txtDescription.sendKeys(CallCenterUserData.UpdatePartyTypeCategory_Description);
			
			scrollDown(driver);
			HomePage.btnUpdate.click();
			scrollUp(driver);
			
			validateText(HomePage.txtUpdatePartyTypeCategoryErrorMsg);
			wait(3);
			
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
		}	
	
	@Step("Delete Party Type Category")
	public static String DeletePartyTypeCategory() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
				
			HomePage.btnPartyMenu.click();
			wait(3);
			HomePage.btnPartyTypeCategory.click(); //HomePage.btnPartyTypeCategoryXpath.click();
			System.out.println("Party Type Category link clicked");
			wait(3);
			selectLastElement(HomePage.drpselectLastElement);
			
			scrollDown(driver);
			HomePage.btnDeletePartyTypeCategory.click();
			HomePage.btnOkDeletePartyTypeCategory.click();
			
			System.out.println(getText(HomePage.txtUpdatePartyTypeCategoryErrorMsg));
			wait(3);
			wait(3);
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
		}	
	
	@Step("Login Successfully To Call Center As Admin")
	public static String LoginSuccessfullyToCallCenterAsAdmin() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			if(HomePage.txtStoreInformation.isDisplayed())
			{ System.out.println("User is in home page"); }
			else
			{ System.out.println("User is not in home page"); }
			wait(2);
			
			if(HomePage.btnRestaurantMenu.isDisplayed())
			{ System.out.println("Restaurant Link is present on page"); }
			else
			{ System.out.println("Restaurant Link is not present on page"); }
			wait(2);
			//0045
			if(HomePage.btnPartyMenu.isDisplayed())
			{ System.out.println("Party Link is present on page"); }
			else
			{ System.out.println("Party Link is not present on page"); }
			wait(2);
			
			if(HomePage.btnPromotionMenu.isDisplayed())
			{ System.out.println("Promotion/Upsell Link is present on page"); }
			else
			{ System.out.println("Promotion/Upsell Link is not present on page"); }
			wait(2);
			
			if(HomePage.btnConfigurationMenu.isDisplayed())
			{ System.out.println("Config Link is present on page"); }
			else
			{ System.out.println("Config Link is not present on page"); }
			wait(2);
			
			if(HomePage.btnUserMenu.isDisplayed())
			{ System.out.println("User Link is present on page"); }
			else
			{ System.out.println("User Link is not present on page"); }
			wait(2);
			
			if(HomePage.btnReportMenu.isDisplayed())
			{ System.out.println("Reports Link is present on page"); }
			else
			{ System.out.println("Reports Link is not present on page"); }
			wait(2);
	} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}
	
	@Step("verify Changing Birthday Reservation to Organisation And Generate Confirmation ID")
	public static String verifyChangingBirthdayReservationtoOrganisationAndGenerateConfirmationID() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(5);
			
			//HomePage.txtstorenumb.click();
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByText(HomePage.selectReservationsType,"Birthday");
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("selected date");
			selectRdoBtn(HomePage.selectTimeSlot,1);
			System.out.println("selected time");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			
			jsClick(driver, HomePage.btnNextHomePage);
			wait(3);
			HomePage.txtGuestName.sendKeys(CallCenterUserData.guestName);
			HomePage.txtage.sendKeys(CallCenterUserData.age);
			System.out.println("guest name and age entered");
			
			wait(3);
			
			HomePage.btnA̲dd.click();
			wait(2);
			
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactInfoName);
			System.out.println("customer info entered");
			HomePage.txtPhone1.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("customer contactPhone entered");
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println("customer Email entered");
			HomePage.txtExt1.sendKeys(CallCenterUserData.extention);
			System.out.println("customer extention entered");
			wait(5);
			scrollDown(driver);
			HomePage.btnText.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			//System.out.println(" User clicked the pop up for Duplicate entries ");
			//HomePage.btnText.click();
			
			wait(5);
			scrollDown(driver);
			HomePage.btnBook.click();
			//jsClick(driver, HomePage.btnBook);
			wait(3);
			
			validateText(HomePage.btnlblBookCNFNo);
			String BookCNFNo = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
			HomePage.btnfinish.click();
			wait(3);
			HomePage.btnReviewMenu.click();
			wait(3);
			HomePage.txtConfirmationNumber.click();
			HomePage.txtConfirmationNumber.sendKeys(BookCNFNo);
			
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpDwnReservations,0);
			wait(2);
			scrollDown(driver);
			wait(1);
			
			validateText(HomePage.txtconfID);
			String confID = HomePage.txtconfID.getText();
			Assert.assertEquals(confID, BookCNFNo, "The confirmation ID is not same ");
			scrollDown(driver);
			
			HomePage.btnChange.click();
			wait(5);
			selectDrpDwnByText(HomePage.selectReservationsType, "Organizational");
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			selectRdoBtn(HomePage.selectTimeSlot,2);
			selectRdoBtn(HomePage.selectPkg,1);
			
			HomePage.btnNext.click();
			wait(5);
			
			//HomePage.btnNext.click();
			
			HomePage.txtOrganizationName.sendKeys(CallCenterUserData.OrgName);
			System.out.println("Entered the Organization Name");
			HomePage.txtOrganizationPhone.sendKeys(CallCenterUserData.OrgPhone);
			System.out.println("Entered the Organization phone details ");
			
			scrollDown(driver);
			HomePage.btnText.click();
			wait(5);
			checkVisibilityOfWebElement(HomePage.btnClose);
			HomePage.btnText.click();
			scrollDown(driver);
			
			HomePage.btnBook.click();
			wait(5);
			validateText(HomePage.btnlblBookCNFNo);
			wait(3);
		
	} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}
	
	@Step("Verify Changing Organisation Reservation To Birthday And Generate Confirmation Id")
	public static String VerifyChangingOrganisationReservationToBirthdayAndGenerateConfirmationId() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByText(HomePage.selectReservationsType,"Organizational");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,1);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(5);
			
			HomePage.btnNext.click();
			
			HomePage.txtOrganizationName.sendKeys(CallCenterUserData.OrgName);			
			System.out.println("Entered the Organization Name");
			
			HomePage.txtOrganizationPhone.sendKeys(CallCenterUserData.OrgPhone);
			System.out.println("Entered the Organization phone details ");
			
			HomePage.txtCustomerName.sendKeys(CallCenterUserData.CustomerName);
			System.out.println(" Entered Contact Information Name ");
			
			HomePage.txtContactphone.sendKeys(CallCenterUserData.contactphone);
			System.out.println(" Entered the Customer Phone number ");
			wait(3);
			
			scrollDown(driver);
			
			HomePage.btnText.click();
			wait(2);
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			wait(2);	
			
			HomePage.btnBook.click();
			wait(3);
			
			validateText(HomePage.btnlblBookCNFNo);
			String BookCNFNo = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
			HomePage.btnfinish.click();
			wait(3);
			HomePage.btnReviewMenu.click();
			wait(3);
			HomePage.txtConfirmationNumber.sendKeys(BookCNFNo);
			
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpDwnReservations,0);
			wait(2);
			scrollDown(driver);
			wait(1);
			
			validateText(HomePage.txtconfID);
			String confID = HomePage.txtconfID.getText();
			Assert.assertEquals(confID, BookCNFNo, "The confirmation ID is not same ");
			scrollDown(driver);
			
			HomePage.btnChange.click();
			wait(5);
			selectDrpDwnByText(HomePage.selectReservationsType, "Birthday");
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			selectRdoBtn(HomePage.selectTimeSlot,2);
			selectRdoBtn(HomePage.selectPkg,1);
			
			scrollDown(driver);
			HomePage.btnNext.click();
			wait(5);
			
			//HomePage.btnNext.click();
			
			HomePage.txtGuestName.sendKeys(CallCenterUserData.guestName);
			HomePage.txtage.sendKeys(CallCenterUserData.age);
			wait(3);
			
			HomePage.btnA̲dd.click();
			wait(2);
			
/*			HomePage.btnCustomerName.sendKeys(UserVars.contactInfoName);
			HomePage.txtPhone1.sendKeys(UserVars.contactPhone);
			HomePage.txtEmail.sendKeys(UserVars.Email);
			HomePage.txtExt1.sendKeys(UserVars.extention);
			wait(5);*/
			
			scrollDown(driver);
			HomePage.btnText.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			scrollDown(driver);
			
			HomePage.btnBook.click();	
			wait(5);
			validateText(HomePage.btnlblBookCNFNo);
			wait(3);
			
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
			return "Pass";
	}			
			
	@Step("Verify Clicking Add Button functionality After Entering All The Required Fields For A Party Type")
	public static String VerifyClickingAddButtonfunctionalityAfterEnteringAllTheRequiredFieldsForAPartyType() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.btnPartyMenu.click();
			
			//HomePage.btnPartyTypeCategory.click(); //HomePage.btnPartyTypeCategoryXpath.click();
			HomePage.btnPartyType.click(); 
			System.out.println("Party Type link clicked");
			wait(2);
			
			HomePage.btnPartyTypeTitle.sendKeys(CallCenterUserData.partytitle);
			wait(3);
			
			HomePage.txtPrice.sendKeys(CallCenterUserData.partyPrice);
			HomePage.btnPromotionCategory.click();
			scrollDown(driver);
			
			HomePage.btnTypeCategory.click();
			
			if(HomePage.chkIsActive.isSelected())
			{
				System.out.println("IsActive checkbox is checked");
			}
			else
			{
				HomePage.chkIsActive.click();
				System.out.println("IsActive checkbox is checked");
			}
			scrollDown(driver);
			HomePage.btnAdd.click();
			System.out.println("Add button clicked");
			
			validateText(HomePage.txtErrMsgPType);
			String actualmessage = HomePage.txtErrMsgPType.getText();
			assertEquals(actualmessage, "Record saved successfully");
			wait(2);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}	
	
	@Step("Verify Cofirmation Number Generated On Booking Birthday Party Through Call Center")
	public static String VerifyCofirmationNumberGeneratedOnBookingBirthdayPartyThroughCallCenter() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByIndex(HomePage.selectReservationsType,1);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,0);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,0);
			System.out.println("Package got selected");
			wait(5);
			scrollDown(driver);
			
			HomePage.btnNext.click();
			
			HomePage.txtGuestName.sendKeys(CallCenterUserData.guestName);
			HomePage.txtage.sendKeys(CallCenterUserData.age);
			wait(3);
			
			HomePage.btnA̲dd.click();
			wait(2);
			
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactInfoName);
			System.out.println("Entered contact InfoName");
			HomePage.txtPhone1.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("Entered contact Phone");
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println("Entered  Email");
			HomePage.txtExt1.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered  extention");
			HomePage.txtAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered  Address");
			HomePage.txtPhone2.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("Entered  Phone");
			HomePage.txtExt2.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered  extention");
			HomePage.txtCity.sendKeys(CallCenterUserData.City);
			System.out.println("Entered  City");
			HomePage.txtState.sendKeys(CallCenterUserData.State);
			System.out.println("Entered  State");
			HomePage.txtZipCode.sendKeys(CallCenterUserData.zip);
			System.out.println("Entered  zip");
			scrollDown(driver);
			wait(4);
			HomePage.txtCustomerComments.sendKeys(CallCenterUserData.CustomerComments);
			HomePage.txtAgentComments.sendKeys(CallCenterUserData.AgentComments);
			
			scrollDown(driver);
			HomePage.btnText.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			scrollDown(driver);
			
			HomePage.btnBook.click();
			wait(4);
			
			scrollDown(driver);
			validateText(HomePage.txtconfID);
			String confirmationID = HomePage.txtconfID.getText();
			wait(2);
			
			scrollDown(driver);
			HomePage.btnfinish.click();
			wait(3);
			
			HomePage.btnReviewMenu.click();
			wait(2);
			HomePage.txtConfirmationNumber.sendKeys(confirmationID);
			HomePage.btnSearch.click();
			wait(2);
			
			selectDrpDwnByIndex(HomePage.drpReservationType,0);
			scrollDown(driver);
			wait(2);
			scrollDown(driver);
			validateText(HomePage.txtconfID);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	@Step("verify Confirmation Number Generated On Booking Non Profit Fundraisers Party")
	public static String verifyConfirmationNumberGeneratedOnBookingNonProfitFundraisersParty() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByIndex(HomePage.selectReservationsType,2);
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			//HomePage.txtChildren.sendKeys(UserVars.children);
			//HomePage.txtAdults.sendKeys(UserVars.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,0);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);
			scrollDown(driver);
			
			HomePage.btnNext.click();
			wait(4);
			
			HomePage.txtFundRaisingGuestDetailsSchoolName.sendKeys(CallCenterUserData.organizationName);
			System.out.println("Entered School Name");
			HomePage.txtFundRaisingGuestDetailsPhone.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("Entered phone no");
//			HomePage.txtFundRaisingGuestDetailsPrincipalName.sendKeys(UserVars.PrincipalName);
//			System.out.println("Entered Principal Name");
			HomePage.txtFundRaisingGuestDetailsPhoneExt.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered ext");
			HomePage.txtFundRaisingGuestDetailsAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered the address");
			HomePage.txtFundRaisingGuestDetails_NumberOfStudents.sendKeys(CallCenterUserData.NumberOfStudents);
			System.out.println("Entered the participants count");
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactName);
			System.out.println("Entered Contact Information Name");
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println(" Entered the Contact Information EmailID ");
			HomePage.txtAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered the Contact address");
			HomePage.txtContactphone.sendKeys(CallCenterUserData.contactphone);
			System.out.println("Entered the Contact Information Phone number");
			HomePage.txtExt1.sendKeys(CallCenterUserData.Ext1);
			System.out.println("Entered the Contact Information Phone number");
			HomePage.txtPhone2.sendKeys(CallCenterUserData.txtPhone2);
			System.out.println("Entered the Contact Information number2");
			HomePage.txtExt2.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered the Contact Information extension2 number");
			HomePage.txtCity.sendKeys(CallCenterUserData.City);
			System.out.println("Entered the City");
			HomePage.txtState.sendKeys(CallCenterUserData.State);
			System.out.println("Entered the State");
			HomePage.txtZipCode.sendKeys(CallCenterUserData.zip);
			System.out.println("Entered the zip");
			
			scrollDown(driver);
			wait(4);
			HomePage.txtCustomerComments.sendKeys(CallCenterUserData.CustomerComments);
			HomePage.txtAgentComments.sendKeys(CallCenterUserData.AgentComments);
			scrollDown(driver);
			HomePage.btnText.click();
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			scrollDown(driver);
			
			HomePage.btnfundBook.click();
			wait(3);
			validateText(HomePage.txtlblfundCNFNo);
			String txtlblfundCNFNo = HomePage.txtlblfundCNFNo.getText();
			scrollDown(driver);
			
			HomePage.btnfundFinish.click();
			
			HomePage.btnReviewMenu.click();
			HomePage.txtConfirmationNumber.sendKeys(txtlblfundCNFNo);
			wait(3);
			HomePage.btnSearch.click();
			
			wait(2);
			selectDrpDwnByIndex(HomePage.drpReservationType, 0);
			scrollDown(driver);
			
			validateText(HomePage.txtconfID);
			//String txtconfID = HomePage.txtconfID.getText();
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}	
	
	@Step("verify Confirmation Number Generated On Booking Organization party")
	public static String verifyConfirmationNumberGeneratedOnBookingOrganizationparty_397() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByValue(HomePage.selectReservationsType,"3");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,0);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);
			
			HomePage.btnNext.click();
			
			wait(4);
			HomePage.txtOrganizationName.sendKeys(CallCenterUserData.organizationName);
			System.out.println("Entered organization Name");
			HomePage.txtOrganizationPhone.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("Entered phone no");
			HomePage.txtOrgPhoneExt.sendKeys(CallCenterUserData.orgext);
			System.out.println("Entered Principal orgext");
			HomePage.txtCustomerName.sendKeys(CallCenterUserData.CustomerName);
			System.out.println("Entered CustomerName");
			HomePage.txtReservationEmail.sendKeys(CallCenterUserData.orgEmail);
			System.out.println("Entered the email");
			HomePage.txtReservationAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered the Address");
			HomePage.txtContactphone.sendKeys(CallCenterUserData.Contactphone);
			System.out.println("Entered Contact phone");
			HomePage.txtReservationExt1.sendKeys(CallCenterUserData.reservationExt1);
			System.out.println(" Entered the reservation Ext1");
			HomePage.txtReservationPhone2.sendKeys(CallCenterUserData.reservationPhone2);
			System.out.println("Entered the reservation Phone 2");
			HomePage.txtReservationExt2.sendKeys(CallCenterUserData.reservationExt2);
			System.out.println("Entered the reservation Ext2");
			HomePage.txtReservationCity.sendKeys(CallCenterUserData.ReservationCity);
			System.out.println("Entered the Reservation City");
			HomePage.txtReservationState.sendKeys(CallCenterUserData.ReservationState);
			System.out.println("Entered the Reservation State");
			HomePage.txtReservationZipCode.sendKeys(CallCenterUserData.ReservationZipCode);
			System.out.println("Entered the Reservation Zip Code");
			
			scrollDown(driver);
			wait(4);
			HomePage.txtCustomerComments.sendKeys(CallCenterUserData.CustomerComments);
			HomePage.txtAgentComments.sendKeys(CallCenterUserData.AgentComments);
			scrollDown(driver);
			HomePage.btnText.click();
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			wait(4);
			
			scrollDown(driver);
			HomePage.btnBook.click();
			
			wait(3);
			validateText(HomePage.btnlblBookCNFNo);
			String lblBookCNFNo = HomePage.btnlblBookCNFNo.getText();
			scrollDown(driver);
			
			HomePage.btnfinish.click();
			wait(3);
			
			HomePage.btnReviewMenu.click();
			HomePage.txtConfirmationNumber.sendKeys(lblBookCNFNo);
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpReservationType, 0);
			scrollDown(driver);
			
			validateText(HomePage.txtconfID);
			//String txtconfID = HomePage.txtconfID.getText();
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}	
	
	@Step("Verify Confirmation Number generated On Booking School Fundraiser Party")
	public static String VerifyConfirmationNumbergeneratedOnBookingSchoolFundraiserParty_398() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByText(HomePage.selectReservationsType,"Fund Raising");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
//			HomePage.txtChildren.sendKeys(UserVars.children);
//			HomePage.txtAdults.sendKeys(UserVars.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,0);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,0);
			System.out.println("Package got selected");
			wait(3);
			
			HomePage.btnNext.click();
			
			wait(4);
			HomePage.txtFundRaisingGuestDetailsSchoolName.sendKeys(CallCenterUserData.organizationName);
			System.out.println("Entered School Name");
			HomePage.txtFundRaisingGuestDetailsPhone.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("Entered phone no");
			HomePage.txtFundRaisingGuestDetailsPrincipalName.sendKeys(CallCenterUserData.PrincipalName);
			System.out.println("Entered Principal Name");
			HomePage.txtFundRaisingGuestDetailsPhoneExt.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered ext");
			HomePage.txtFundRaisingGuestDetailsAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered the address");
			HomePage.txtFundRaisingGuestDetails_NumberOfStudents.sendKeys(CallCenterUserData.NumberOfStudents);
			System.out.println("Entered the participants count");
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactName);
			System.out.println("Entered Contact Information Name");	
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println(" Entered the Contact Information EmailID ");
			HomePage.txtAddress.sendKeys(CallCenterUserData.Address);
			System.out.println("Entered the Contact address");
			HomePage.txtContactphone.sendKeys(CallCenterUserData.contactphone);
			System.out.println("Entered the Contact Information Phone number");
			HomePage.txtExt1.sendKeys(CallCenterUserData.Ext1);
			System.out.println("Entered the Contact Information Phone number");
			HomePage.txtPhone2.sendKeys(CallCenterUserData.txtPhone2);
			System.out.println("Entered the Contact Information number2");
			HomePage.txtExt2.sendKeys(CallCenterUserData.extention);
			System.out.println("Entered the Contact Information extension2 number");
			HomePage.txtCity.sendKeys(CallCenterUserData.City);
			System.out.println("Entered the City");
			HomePage.txtState.sendKeys(CallCenterUserData.State);
			System.out.println("Entered the State");
			HomePage.txtZipCode.sendKeys(CallCenterUserData.zip);
			System.out.println("Entered the zip");
			
			scrollDown(driver);
			wait(4);
			HomePage.txtCustomerComments.sendKeys(CallCenterUserData.CustomerComments);
			HomePage.txtAgentComments.sendKeys(CallCenterUserData.AgentComments);
			scrollDown(driver);
			HomePage.btnText.click();
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			scrollDown(driver);
			
			HomePage.btnfundBook.click();
			wait(3);
			validateText(HomePage.txtlblfundCNFNo);
			String txtlblfundCNFNo = HomePage.txtlblfundCNFNo.getText();
			scrollDown(driver);
			
			HomePage.btnfundFinish.click();
			wait(3);
			
			HomePage.btnReviewMenu.click();
			HomePage.txtConfirmationNumber.sendKeys(txtlblfundCNFNo);
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpReservationType, 0);
			scrollDown(driver);
			validateText(HomePage.txtconfID);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}			
	
	@Step("verify Error Message Getting Displayed On Clicking Add Button Without Entering Any Party Type Data")
	public static String verifyErrorMessageGettingDisplayedOnClickingAddButtonWithoutEnteringAnyPartyTypeData_387() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			
			HomePage.btnPartyMenu.click();
			HomePage.btnPartyType.click();
			scrollDown(driver);
			
			HomePage.btnAddParty.click();
			System.out.println("Add button clicked");
			
			scrollUp(driver);
			
			validateText(HomePage.txtRequiredError);
			String actualErrMsg = HomePage.txtRequiredError.getText();
			Assert.assertEquals(actualErrMsg,"Required");
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	@Step("verify Min Children Set up At Store level And Verify Minimum Children Validation Are Triggered On Wave Selection")
	public static String verifyMinChildrenSetupAtStorelevelAndVerifyMinimumChildrenValidationAreTriggeredOnWaveSelection_431() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			
			HomePage.btnRestaurantMenu.click();
			System.out.println("Clicked the link Restaurant");
			wait(5);
			
			HomePage.btnMinimumChildrenSetup.click();
			wait(3);
			
			HomePage.rdoStoreLevel.click();
			selectDrpDwnByValue(HomePage.selectStoreList, "33");
			
			HomePage.txtStartTime_Monday.sendKeys(CallCenterUserData.StartTime_Monday, Keys.TAB);
			wait(1);
			HomePage.txtEndTime_Monday.sendKeys(CallCenterUserData.EndTime_Monday, Keys.TAB);
			wait(1);
			HomePage.txtMinChild_Monday.sendKeys(CallCenterUserData.MinChild_Monday, Keys.TAB);
			wait(1);
			
			scrollDown(driver);
			
			if (HomePage.btnMinChildAdd.isEnabled()) {
				HomePage.btnMinChildAdd.click();
			} else {
				HomePage.btnMinChildAdd.click();
			}
			wait(4);
			
			HomePage.btnBookMenu.click();
			System.out.println("Clicked the link Book");
			
			scrollUp(driver);
			validateText(HomePage.txtRecordSaved);
			
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByValue(HomePage.selectReservationsType,"1");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.txtChildren.sendKeys(CallCenterUserData.MinChild_children);
			HomePage.txtAdults.sendKeys(CallCenterUserData.adults);
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,0);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,0);
			System.out.println("Package got selected");
			wait(3);
			
			HomePage.btnNext.click();
			validateText(HomePage.popUpError);
			
			HomePage.popUpErrorYes.click();
			wait(4);
			validateText(HomePage.txtChildren);
			String childrenSetUp = HomePage.txtChildren.getText();
			
			Assert.assertEquals(CallCenterUserData.MinChild_Monday,childrenSetUp);
			System.out.println("The Child count configured not simiar to entered child count");
			//Assert.assertEquals(UserVars.MinChild_Monday,UserVars.MinChild_children);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	@Step("verify With Valid Basic Restaurant Information Data Saves Properly")
	public static String verifyWithValidBasicRestaurantInformationDataSavesProperly_384() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			
			HomePage.btnRestaurantMenu.click();
			System.out.println("Clicked the link Restaurant");
			wait(5);
			
			HomePage.btnCreateNew.click();
			System.out.println("Clicked New Button");
			wait(3);
			
			
			HomePage.StoreNumber.sendKeys(CallCenterUserData.StoreNumber);
			System.out.println("Store Number Entered");
			HomePage.StoreName.sendKeys(CallCenterUserData.StoreName);
			System.out.println("Store Name Entered");
			HomePage.txtCity.sendKeys(CallCenterUserData.RestaurantCity);
			System.out.println("City Name Entered");
			HomePage.txtState.sendKeys(CallCenterUserData.RestaurantState);
			System.out.println("State Name Entered");
			selectDrpDwnByValue(HomePage.drpCountry, "1");
			System.out.println("Country selected");
			HomePage.txtZipCode.sendKeys(CallCenterUserData.RestaurantZipCode);
			System.out.println("Zip Code entered");
			HomePage.txtAddress.sendKeys(CallCenterUserData.RestaurantAddress);
			System.out.println("Address entered");
			HomePage.txtManagerName.sendKeys(CallCenterUserData.RestaurantManagerName);
			System.out.println("Manager Name entered");
			wait(3);
			HomePage.txtPublishedNumber.sendKeys(CallCenterUserData.RestaurantPublisherNumber);
			System.out.println("Publisher Name entered");
			wait(3);
			HomePage.txtIVRNumber.sendKeys(CallCenterUserData.RestaurantIVRNumber);
			System.out.println("IVR Number entered");
			wait(3);
			HomePage.txtPhoneNumber.sendKeys(CallCenterUserData.RestaurantPhoneNumber);
			System.out.println("Phone Number entered");
			wait(3);
			scrollDown(driver);
			
			selectDrpDwnByIndex(HomePage.selPaymentGatewayId, 3);
			wait(2);
			System.out.println("Payment type selected as Payeezy");
			
			selectDrpDwnByIndex(HomePage.selProcessorId, 3);
			wait(2);
			System.out.println("Processor Name is selected");
			scrollDown(driver);
			
			HomePage.btnSave.click();
			System.out.println("Save button clicked to save the records");
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	@Step("verify Error Message Gets Diplayed Keeping Mandatory Fields Blank")
	public static String verifyErrorMessageGetsDiplayedKeepingMandatoryFieldsBlank_423() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			
			HomePage.btnPartyMenu.click();
			System.out.println("Clicked the link Party");
			wait(5);
			
			HomePage.btnCreateNew.click();
			System.out.println("Clicked New Button");
			wait(3);
			
			validateText(HomePage.btnUpsellCategory);
			validateText(HomePage.btnItemPage);
			validateText(HomePage.btnItemGroup);
			validateText(HomePage.btnItemCategory);
			validateText(HomePage.btnPartyItem);
			validateText(HomePage.btnPartyTypeCategory);
			validateText(HomePage.btnPartyType);
			validateText(HomePage.btnPartyPackage);
			validateText(HomePage.btnSeatingPercentage);
			validateText(HomePage.btnsubmenu10);
			validateText(HomePage.btnsubmenu11);
			
			HomePage.btnPartyTypeCategory.click();
			System.out.println("Party Type Category link clicked");
			
			HomePage.txtDisplayName.sendKeys(CallCenterUserData.DisplayName);
			System.out.println("Entered the Display Title");

			HomePage.txtDescription.sendKeys(CallCenterUserData.Description);
			System.out.println("Entered the Description");
			
			selectDrpDwnByIndex(HomePage.ReservationTypeId, 0);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutOption, 2);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutColor, 3);
			wait(1);
			
			scrollDown(driver);
			
			HomePage.btnSelImageAN.click();
			HomePage.btnImgTag.click();
			HomePage.btnokClickAN.click();
			HomePage.btnSave.click();
			
			scrollDown(driver);
			
			validateText(HomePage.btnNameError);
			scrollDown(driver);
			
			HomePage.btnReset.click();
			wait(4);
			
			HomePage.txtName.sendKeys(CallCenterUserData.Name);
			System.out.println("Entered the Name");
			HomePage.txtDescription.sendKeys(CallCenterUserData.Description);
			System.out.println("Entered the Description");
			
			selectDrpDwnByIndex(HomePage.ReservationTypeId, 0);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutOption, 2);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutColor, 3);
			wait(1);
			
			scrollDown(driver);
			
			HomePage.btnSelImageAN.click();
			HomePage.btnImgTag.click();
			HomePage.btnokClickAN.click();
			HomePage.btnSave.click();
			
			scrollUp(driver);
			
			validateText(HomePage.txtDisplyNameError);
			System.out.println("Name field kept blank hence got the error");
			
			scrollDown(driver);
			HomePage.btnReset.click();
			wait(4);
			
			HomePage.txtName.sendKeys(CallCenterUserData.Name);
			System.out.println("Entered the Name");
			HomePage.txtDisplayName.sendKeys(CallCenterUserData.DisplayName);
			System.out.println("Entered the Description");
			
			selectDrpDwnByIndex(HomePage.ReservationTypeId, 0);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutOption, 2);
			wait(1);
			selectDrpDwnByIndex(HomePage.drpCallOutColor, 3);
			wait(1);
			
			scrollDown(driver);
			HomePage.btnSelImageAN.click();
			HomePage.btnImgTag.click();
			HomePage.btnokClickAN.click();
			HomePage.btnSave.click();
			
			scrollUp(driver);
			validateText(HomePage.txtDisplyNameError);
			
			scrollDown(driver);
			HomePage.btnReset.click();
			wait(5);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	
	@Step("verify That When User Changes The Party Date The Confirmation Number Changes")
	public static String verifyThatWhenUserChangesThePartyDateTheConfirmationNumberChanges_429() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByValue(HomePage.selectReservationsType,"1");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,3);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);
			
			scrollDown(driver);
			HomePage.btnNext.click();
			wait(4);
			
			wait(3);
			HomePage.txtGuestName.sendKeys(CallCenterUserData.guestName);
			HomePage.txtage.sendKeys(CallCenterUserData.age);
			System.out.println("guest name and age entered");
			wait(3);
			
			HomePage.btnA̲dd.click();
			wait(2);
			
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactInfoName);
			System.out.println("customer info entered");
			HomePage.txtPhone1.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("customer contactPhone entered");
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println("customer Email entered");
			HomePage.txtExt1.sendKeys(CallCenterUserData.extention);
			System.out.println("customer extention entered");
			wait(5);
			scrollDown(driver);
			
			selectFirstChkBoxNSendValue("11");
			scrollDown(driver);
			
			HomePage.btnText.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			
			scrollDown(driver);
			
			HomePage.btnBook.click();
			wait(3);

			validateText(HomePage.btnlblBookCNFNo);
			String BookCNFNo = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
			HomePage.btnfinish.click();
			wait(3);
			HomePage.btnReviewMenu.click();
			wait(3);
			HomePage.txtConfirmationNumber.click();
			HomePage.txtConfirmationNumber.sendKeys(BookCNFNo);
			
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpDwnReservations,0);
			wait(2);
			scrollDown(driver);
			wait(1);
			
			//Assert.assertEquals(confID, BookingNumber, "The confirmation ID is nor same ");
			scrollDown(driver);
			
			HomePage.btnChange.click();
			wait(5);
			scrollDown(driver);
			
			ClickAvailableDate(driver,2);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,3);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);
			
			scrollDown(driver);
			HomePage.btnNext.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			
			wait(3);
			HomePage.btnBook.click();
			wait(3);
			
			validateText(HomePage.btnlblBookCNFNo);
			//String BookCNFNoAfterDateChng = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}		
	
	@Step("verify That When User Changes The Party Date The Confirmation Number Changes")
	public static String verifyThatWhenUserChangesTheStoreTheConfirmationNumberChanges_430() throws IOException {
		try {
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumber);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);
			
			selectDrpDwnByValue(HomePage.selectReservationsType,"1");
			System.out.println("User successfully selected the reservation from Reservation LookUp List");
			wait(3);
			
			HomePage.btnShowCalendar.click();
			wait(2);
			scrollDown(driver);
			
			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,3);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);
			
			scrollDown(driver);
			HomePage.btnNext.click();
			wait(4);
			
			wait(3);
			HomePage.txtGuestName.sendKeys(CallCenterUserData.guestName);
			HomePage.txtage.sendKeys(CallCenterUserData.age);
			System.out.println("guest name and age entered");
			wait(3);
			
			HomePage.btnA̲dd.click();
			wait(2);
			
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactInfoName);
			System.out.println("customer info entered");
			HomePage.txtPhone1.sendKeys(CallCenterUserData.contactPhone);
			System.out.println("customer contactPhone entered");
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			System.out.println("customer Email entered");
			HomePage.txtExt1.sendKeys(CallCenterUserData.extention);
			System.out.println("customer extention entered");
			wait(5);
			scrollDown(driver);
			
			selectFirstChkBoxNSendValue("11");
			scrollDown(driver);
			
			HomePage.btnText.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			
			scrollDown(driver);
			
			HomePage.btnBook.click();
			wait(3);

			validateText(HomePage.btnlblBookCNFNo);
			String BookCNFNo = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
			HomePage.btnfinish.click();
			wait(3);
			HomePage.btnReviewMenu.click();
			wait(3);
			HomePage.txtConfirmationNumber.click();
			HomePage.txtConfirmationNumber.sendKeys(BookCNFNo);
			
			HomePage.btnSearch.click();
			wait(3);
			
			selectDrpDwnByIndex(HomePage.drpDwnReservations,0);
			wait(2);
			scrollDown(driver);
			wait(1);
			
			//Assert.assertEquals(confID, BookingNumber, "The confirmation ID is nor same ");
			scrollDown(driver);
			
			HomePage.btnChange.click();
			wait(5);
			//scrollDown(driver);
			
			HomePage.txtstorenumb.clear();
			wait(3);
			HomePage.txtstorenumb.sendKeys(CallCenterUserData.storenumberChange);
			wait(3);
			HomePage.txtstorenumb.sendKeys(Keys.ENTER);
			wait(3);			
			
/*			ClickAvailableDate(driver,1);
			System.out.println("Date got selected from calender");
			selectRdoBtn(HomePage.selectTimeSlot,3);
			System.out.println("Time slot got selected");
			selectRdoBtn(HomePage.selectPkg,1);
			System.out.println("Package got selected");
			wait(3);*/
			
			scrollDown(driver);
			HomePage.btnNext.click();
			wait(3);
			
			checkVisibilityOfWebElement(HomePage.btnClose);
			checkVisibilityOfWebElement(HomePage.btnText);
			
			wait(3);
			HomePage.btnBook.click();
			wait(3);
			
			validateText(HomePage.btnlblBookCNFNo);
			//String BookCNFNoAfterDateChng = HomePage.btnlblBookCNFNo.getText();
			wait(3);
			
		} catch (Exception ex) {
		System.out.println("Error in Login Thread: " + ex.getMessage());
		ex.printStackTrace();
	}
		return "Pass";
	}	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	@org.testng.annotations.DataProvider(name = "AddData")
	public Object[][] getDataForP2PFeature() throws Exception {
		CallCenterXLReader reader = new CallCenterXLReader();
		Object[][] params = reader.ReadExcelData("D:\\keywordDrivenFramework-master\\src\\test\\java\\com\\companyname\\projectname\\Data\\DataProvider002.xlsx", 6);
		return params;
	}
	
/*@Step("wait till the page gets loaded")
public static String ExplicitWait() throws IOException {
	explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
	return "Pass";
}*/


	public static void 	customerDetails()
	{
		try
		{
			CallCenterLocators HomePage = PageFactory.initElements(driver, CallCenterLocators.class);
			HomePage.btnCustomerName.sendKeys(CallCenterUserData.contactInfoName);
			HomePage.txtPhone1.sendKeys(CallCenterUserData.contactPhone);
			HomePage.txtEmail.sendKeys(CallCenterUserData.Email);
			HomePage.txtExt1.sendKeys(CallCenterUserData.extention);
			HomePage.txtAddress.sendKeys(CallCenterUserData.Address);
			HomePage.txtPhone2.sendKeys(CallCenterUserData.contactPhone);
			HomePage.txtExt2.sendKeys(CallCenterUserData.extention);
			HomePage.txtCity.sendKeys(CallCenterUserData.City);
			HomePage.txtState.sendKeys(CallCenterUserData.State);
			HomePage.txtZipCode.sendKeys(CallCenterUserData.zip);
			scrollDown(driver);
			wait(4);
			HomePage.txtCustomerComments.sendKeys(CallCenterUserData.CustomerComments);
			HomePage.txtAgentComments.sendKeys(CallCenterUserData.AgentComments);
		}
		catch(Exception e)
		{ e.printStackTrace(); }
	}		
	
	
	
	
	
	
public static void 	GetCalendarInstance()
{
	try
	{
	Calendar calendar = Calendar.getInstance();
	Date date = calendar.getTime();
	System.out.println(" Date " + date);
	String snapname323 = " TestCase323_ " + date.toString().replaceAll(":", "-") + ".png";
	//ScreenShotCapture.captureSnap(driver, snapname323);
	}
	catch(Exception e)
	{ e.printStackTrace(); }
}	

	public static String clickWhenReady(By locator, int timeout) {
		WebElement element = null;
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		element = wait.until(ExpectedConditions.elementToBeClickable(locator));
		element.click();
		return "Pass";

	}


	
	public static void closeBrowser(){
		driver.quit();
	}

	public WebDriver getDriver() {
		// TODO Auto-generated method stub
		return null;
	}
	
}
