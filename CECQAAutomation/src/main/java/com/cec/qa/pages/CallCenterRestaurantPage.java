package com.cec.qa.pages;

import java.awt.AWTException;
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

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.cec.qa.base.BaseTest;
import com.cec.qa.data.CallCenterLocators;
import com.cec.qa.data.CallCenterUserData;


import io.qameta.allure.Step;


public class CallCenterRestaurantPage extends BaseTest{

	public  final static String currentPropDir = System.getProperty("user.dir");



	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";
	
	//###################################################################################################################
	//########################################### Restaurant Messages ###################################################
	String restaurantUpdateMsg = "Restaurant information updated successfully.";



	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//******************************Main Menu **************************************************

	@FindBy(xpath="//a[@title='Restaurant']")
	WebElement restaurantMenuLnk;

	//******************************Restaurant Menu **************************************************

	//@FindBy(xpath="//a[contains(text(),'New Restaurant')]")

	@FindBy(xpath="//a[@title='New Restaurant']")
	WebElement NewReservationMenuLnk;

	@FindBy(xpath="//a[@title='Review']")
	WebElement SearchRMenuLnk;

	@FindBy(xpath="//a[@title='FAQ']")
	WebElement SetGroupRMenuLnk;

	@FindBy(xpath="//a[@title='Restaurant']")
	WebElement SeatingRMenuLnk;

	@FindBy(xpath="//a[@title='Party']")
	WebElement SchedulingMenuLnk;

	@FindBy(xpath="//a[@title='Minimum Children Setup']")
	WebElement MinChildSetupMenuLink;

	@FindBy(xpath="//a[@title='Party Duration']")
	WebElement PartyDurationMenuLnk;

	//New - Restaurant

	@FindBy(id="StoreNumber")
	WebElement storeNumberInRestaurant;

	@FindBy(id="StoreName")
	WebElement storeStoreNameInRestaurant;

	@FindBy(id="City")
	WebElement storeCityInRestaurant;

	@FindBy(id="State")
	WebElement storeStateInRestaurant;

	@FindBy(id="drpCountry")
	WebElement storeCountryListBoxInRestaurant;

	@FindBy(id="ZipCode")
	WebElement storeZipCodeInRestaurant;

	@FindBy(id="Address")
	WebElement storeAddressInRestaurant;

	@FindBy(id="ManagerName")
	WebElement storeManagerNameInRestaurant;

	@FindBy(id="IsPlayPass")
	WebElement storeIsPlayPassCheckBoxInRestaurant;

	@FindBy(id="IsStoreOverbook")
	WebElement storeIsStoreOverbookInRestaurant;

	@FindBy(id="PublishedNumber")
	WebElement storePublishedNumberInRestaurant;

	@FindBy(id="IVRNumber")
	WebElement storeIVRNumberInRestaurant;

	@FindBy(id="PhoneNumber")
	WebElement storePhoneNumberInRestaurant;

	@FindBy(id="FaxNumber")
	WebElement storeFaxNumberInRestaurant;

	@FindBy(id="Modem")
	WebElement storeModemInRestaurant;

	@FindBy(id="AlternateStoreIds")
	WebElement storeAlternateStoreIdsListBoxInRestaurant;

	@FindBy(id="PaymentGatewayId")
	WebElement storePaymentTypeListBoxInRestaurant;

	@FindBy(id="ProcessorId")
	WebElement storeProcessNameListBoxInRestaurant;

	@FindBy(id="PaymentOption_3")
	WebElement storeInStorePaymentRadioBtnInRestaurant;

	@FindBy(id="PaymentOption_4")
	WebElement storeNoDepositPaymentRadioBtnInRestaurant;

	@FindBy(id="btnSave")
	WebElement storeSaveBtnInRestaurant;

	@FindBy(xpath = "//a[text()='Reset']")
	WebElement storeResetBtnInRestaurant;

	@FindBy(id="errMsg")
	WebElement storeErrMsg;

	//Restaurant-->Search 

	@FindBy(id="Search")
	WebElement storeSearchBtn;

	@FindBy(xpath="//table/tbody/tr/td[1]")
	WebElement storeNumberInTable;

	@FindBy(xpath="//table/tbody/tr/td[2]")
	WebElement storeNameInTable;

	@FindBy(xpath="//table/tbody/tr/td[3]")
	WebElement storeAddressInTable;

	@FindBy(xpath="//table/tbody/tr/td[4]")
	WebElement storeCityInTable;

	@FindBy(xpath="//table/tbody/tr/td[5]")
	WebElement storeStateInTable;

	@FindBy(xpath="//table/tbody/tr/td[6]")
	WebElement storeZipInTable;

	@FindBy(xpath="//table/tbody/tr/td[9]")
	WebElement storeMgrInTable;


	@FindBy(xpath = "//a[@title='Delete']") 
	WebElement storeDeleteIconInRestaurant;

	@FindBy(xpath="//button[text()='OK']")
	WebElement storeDeleteConfirmationOKBtn;

	@FindBy(id="FirstManagerLogIn")
	WebElement storeDeleteFirstMgrLoginInputBox;

	@FindBy(id="SecondManagerLogIn")
	WebElement storeDeleteSecondMgrLoginInputBox;

	@FindBy(xpath = "//input[@value='Delete']")
	WebElement storeFinalDeleteBtn;

	//Minimum Children Setup

	@FindBy(id="radioGlobalLevel")
	WebElement globalLevelRadioBtn;

	@FindBy(id="radioGroupLevel")
	WebElement groupLevelRadioBtn;

	@FindBy(id="radioStoreLevel")
	WebElement storeLevelRadioBtn;

	@FindBy(name="rdoReservationtype")
	List<WebElement> reservationtypeRadioBtn;
	
	//Monday
	
	@FindBy(id="txtStartTime_Monday_0")
	WebElement startTime_Monday_Slot1;

	@FindBy(id="txtEndTime_Monday_0")
	WebElement endTime_Monday_Slot1;

	@FindBy(id="txtMinChild_Monday_0")
	WebElement minchild_Monday_Slot1;

	@FindBy(id="btnMon")
	WebElement addBtn_Monday_Slot1;
	
	//Tuesday

	@FindBy(id="txtStartTime_Tuesday_0")
	WebElement startTime_Tuesday_Slot1;

	@FindBy(id="txtEndTime_Tuesday_0")
	WebElement endTime_Tuesday_Slot1;

	@FindBy(id="txtMinChild_Tuesday_0")
	WebElement minchild_Tuesday_Slot1;

	@FindBy(id="btnTue")
	WebElement addBtn_Tuesday_Slot1;
	
	//Wednesday

		@FindBy(id="txtStartTime_Wednesday_0")
		WebElement startTime_Wednesday_Slot1;

		@FindBy(id="txtEndTime_Wednesday_0")
		WebElement endTime_Wednesday_Slot1;

		@FindBy(id="txtMinChild_Wednesday_0")
		WebElement minchild_Wednesday_Slot1;

		@FindBy(id="btnWed")
		WebElement addBtn_Wednesday_Slot1;
		
		//Thursday

		@FindBy(id="txtStartTime_Thursday_0")
		WebElement startTime_Thursday_Slot1;

		@FindBy(id="txtEndTime_Thursday_0")
		WebElement endTime_Thursday_Slot1;

		@FindBy(id="txtMinChild_Thursday_0")
		WebElement minchild_Thursday_Slot1;

		@FindBy(id="btnThu")
		WebElement addBtn_Thursday_Slot1;
		
		//Friday

		@FindBy(id="txtStartTime_Friday_0")
		WebElement startTime_Friday_Slot1;

		@FindBy(id="txtEndTime_Friday_0")
		WebElement endTime_Friday_Slot1;

		@FindBy(id="txtMinChild_Friday_0")
		WebElement minchild_Friday_Slot1;

		@FindBy(id="btnFri")
		WebElement addBtn_Friday_Slot1;

	@FindBy(id="StoreGroupList")
	List<WebElement> groupList;

	@FindBy(id="StoreList")
	List<WebElement> storeList;

	@FindBy(id="btnAdd")
	WebElement minChildAddBtn;

	@FindBy(id="btnUpdate")
	WebElement minChildUpdateBtn;

	@FindBy(id="btnDelete")
	WebElement minChildDeleteBtn;
	
	@FindBy(xpath="//button[text()='OK']")
	WebElement deleteOkBtn;

	@FindBy(id="errorMsg")
	WebElement confirmMsg;
	
	@FindBy(xpath="//table/tbody/tr/td[12]/a[1]")
	WebElement editRestaurant;
	
	@FindBy(xpath="//legend[text()='Name & Address']")
	WebElement nameAndAddressText;

	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************
	public CallCenterRestaurantPage(){
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
	//*********************Methods to validate Click Login on CallCenter Page ************************
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
			System.out.println("Error Found In Login to Call Center: " + e.getMessage());
			e.printStackTrace();
		}
		return result;
	}

	public String RobotLogin() throws IOException {
		try {
			System.out.println("RobotLogin function called");

			//Thread.sleep(5000);
			// create robot for keyboard operations
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
			//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
		return IEdriverPath;
	}


	//****************************************************************************************************
	//*********************Methods to validate Restaurant Menu  ******************************************
	//****************************************************************************************************
	public boolean validateSelectRestaurantMenu() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(restaurantMenuLnk);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateSelectRestaurantMenu()");
			result = false;
		}
		return result;
	}
	//****************************************************************************************************
	//*********************Methods to validateClickOnNewMenu**********************************************
	//****************************************************************************************************

	public boolean validateClickOnNewMenu() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(NewReservationMenuLnk);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateClickOnNewMenu()");
			result = false;
		}
		return result;
	}

	//****************************************************************************************************
		//*********************Methods to validateClickOnSearchMenu**********************************************
		//****************************************************************************************************

		public boolean validateClickOnSearchMenu() throws IOException {
			boolean result = false;	
			try {
				//waitAndClick(SearchRMenuLnk);
				waitAndClick(storeSearchBtn);
				result = true;
			}catch(Exception e){
				e.printStackTrace();
				System.err.println("Found Issue with Method: validateClickOnNewMenu()");
				result = false;
			}
			return result;
		}
	//****************************************************************************************************
	//*********************Methods to validateClickOnMinChildMenu**********************************************
	//****************************************************************************************************

	public boolean validateClickOnMinChildMenu() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(MinChildSetupMenuLink);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateClickOnNewMenu()");
			result = false;
		}
		return result;
	}


	//****************************************************************************************************
	//*********************Methods to validateNewRestaurantRecordCreation*********************************
	//****************************************************************************************************

	public String validateNewRestaurantRecordCreation(String storeNumber,String storeName,String city,String state,String zip,String address,String managerName) throws IOException {
		String result = null;	
		try {

			storeNumberInRestaurant.sendKeys(storeNumber);
			storeStoreNameInRestaurant.sendKeys(storeName);
			storeCityInRestaurant.sendKeys(city);
			storeStateInRestaurant.sendKeys(state);
			selectDrpDwnByIndex(storeCountryListBoxInRestaurant,1);
			storeZipCodeInRestaurant.sendKeys(zip);
			storeAddressInRestaurant.sendKeys(address);
			storeManagerNameInRestaurant.sendKeys(managerName);

			storePublishedNumberInRestaurant.sendKeys("1122334455");
			storeIVRNumberInRestaurant.sendKeys("1234");
			storePhoneNumberInRestaurant.sendKeys("1234554321");

			selectDrpDwnByIndex(storePaymentTypeListBoxInRestaurant,2);
			selectDrpDwnByIndex(storeProcessNameListBoxInRestaurant,2);

			waitAndClick(storeSaveBtnInRestaurant);

			result = waitAndGetText(storeErrMsg);
			return result;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateNewRestaurantRecordCreation()");
			result = "Found Issue with Method: validateNewRestaurantRecordCreation()";
		}
		return result;
	}

	//****************************************************************************************************
	//*********************Methods to validateStoreSearch ************************************************
	//****************************************************************************************************

	public boolean validateStoreSearch(String storeNumber,String storeName,String city,String state,String zip,String address,String managerName) throws IOException {
		boolean result1 = false;
		boolean result2 = false;
		boolean result3 = false;
		boolean result4 = false;
		boolean result5 = false;
		boolean result6 = false;
		boolean result7 = false;
		boolean finalResult = false;
		try {
			//Store Search by StoreNumber
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeNumberInRestaurant.sendKeys(storeNumber);
			waitAndClick(storeSearchBtn);
			Thread.sleep(3000);
			String storeNumInTable = storeNumberInTable.getText();
			if(storeNumber.equals(storeNumInTable)){
				result1 = true;
			} else {
				result1 = false;
				System.out.println("result1 :: "+result1);
			} 
			
			//Store Search by StoreName
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeStoreNameInRestaurant.sendKeys(storeName);
			waitAndClick(storeSearchBtn);
			if(storeName.equals(storeNameInTable.getText())){
				result2 = true;
			}else{
				result2 = false;
			}
			//Store Search by StoreCity
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeCityInRestaurant.sendKeys(city);
			waitAndClick(storeSearchBtn);
			if(city.equals(storeCityInTable.getText())){
				result3 = true;
			}else{
				result3 = false;
			}
			//Store Search by StoreState
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeStateInRestaurant.sendKeys(state);
			waitAndClick(storeSearchBtn);
			if(state.equals(storeStateInTable.getText())){
				result4 = true;
			}else{
				result4 = false;
			}
			//Store Search by StoreZip
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeZipCodeInRestaurant.sendKeys(zip);
			waitAndClick(storeSearchBtn);
			if(zip.equals(storeZipInTable.getText())){
				result5 = true;
			}else{
				result5 = false;
			}
			//Store Search by StoreAddress
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeAddressInRestaurant.sendKeys(address);
			waitAndClick(storeSearchBtn);
			if(address.equals(storeAddressInTable.getText())){
				result6 = true;
			}else{
				result6 = false;
			}
			//Store Search by StoreMgr
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeManagerNameInRestaurant.sendKeys(managerName);
			waitAndClick(storeSearchBtn);
			if(managerName.equals(storeMgrInTable.getText())){
				result7 = true;
			}else{
				result7 = false;
			}
			//Validating all search success/failure to finalize search result
			if(result1==true && result2==true && result3==true && result4==true && result5==true && result6==true && result7==true){
				finalResult = true;
			}else{
				finalResult = false;
			}
			return finalResult;
		} catch (Exception e) {
			System.out.println("Found Issue with method: validateStoreSearch()");
			e.printStackTrace();
			finalResult = false;
		}
		return finalResult;
	}

	//****************************************************************************************************
	//*********************Methods to validateStoreDeleteByStoreNumber************************************
	//****************************************************************************************************

	public String validateStoreDeleteByStoreNumber(String storeNumber) throws IOException {
		String result = null;	
		try {
			storeNumberInRestaurant.sendKeys(storeNumber);
			waitAndClick(storeSearchBtn);
			waitAndClick(storeDeleteIconInRestaurant);
			waitAndClick(storeDeleteConfirmationOKBtn);

			storeDeleteFirstMgrLoginInputBox.sendKeys("vishnuvardhana.gc");
			storeDeleteSecondMgrLoginInputBox.sendKeys("abaliga");
			storeFinalDeleteBtn.click();
			//waitAndClick(storeFinalDeleteBtn);
			Thread.sleep(5000);
			result = waitAndGetText(storeErrMsg);
		} catch (Exception e) {
			System.out.println("Found Issue with method: validateStoreDeleteByStoreNumber()");
			e.printStackTrace();
			result = "Found Issue with method: validateStoreDeleteByStoreNumber()";
		}
		return result;
		// Record is deleted successfully.
	}

	//****************************************************************************************************
	//*********************Methods to validateStoreDeleteByStoreNumber************************************
	//****************************************************************************************************

	public String validateSetupMinimumChildren(String level,int reservationtype) throws IOException {
		String result = null;	
		try {
			if(level.equals("global"))
			{
				globalLevelRadioBtn.click();
				Thread.sleep(1000);
				startTime_Tuesday_Slot1.clear();
				startTime_Tuesday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(1000);
				endTime_Tuesday_Slot1.clear();
				endTime_Tuesday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Tuesday_Slot1.clear();
				minchild_Tuesday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Tuesday_Slot1);
				Thread.sleep(2000);
				selectRdoBtn(reservationtypeRadioBtn, reservationtype);
				waitAndClick(minChildAddBtn);
			}else if(level.equals("group")){
				groupLevelRadioBtn.click();
				Thread.sleep(1000);
				List<WebElement> ele = driver.findElements(By.id("StoreGroupList"));
				selectLastElement(ele);
				Thread.sleep(2000);
				startTime_Tuesday_Slot1.clear();
				startTime_Tuesday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Tuesday_Slot1.clear();
				endTime_Tuesday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Tuesday_Slot1.clear();
				minchild_Tuesday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Tuesday_Slot1);
				Thread.sleep(2000);
				selectRdoBtn(reservationtypeRadioBtn, reservationtype);
				waitAndClick(minChildAddBtn);
			}else if(level.equals("store")){
				storeLevelRadioBtn.click();
				Thread.sleep(2000);
				List<WebElement> ele = driver.findElements(By.id("StoreList"));
				selectLastElement(ele);
				Thread.sleep(2000);
				startTime_Monday_Slot1.clear();
				startTime_Monday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Monday_Slot1.clear();
				endTime_Monday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Monday_Slot1.clear();
				minchild_Monday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Monday_Slot1);
				
				Thread.sleep(2000);
				startTime_Tuesday_Slot1.clear();
				startTime_Tuesday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Tuesday_Slot1.clear();
				endTime_Tuesday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Tuesday_Slot1.clear();
				minchild_Tuesday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Tuesday_Slot1);
				Thread.sleep(2000);
				
				Thread.sleep(2000);
				startTime_Wednesday_Slot1.clear();
				startTime_Wednesday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Wednesday_Slot1.clear();
				endTime_Wednesday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Wednesday_Slot1.clear();
				minchild_Wednesday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Wednesday_Slot1);
				
				Thread.sleep(2000);
				startTime_Thursday_Slot1.clear();
				startTime_Thursday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Thursday_Slot1.clear();
				endTime_Thursday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Thursday_Slot1.clear();
				minchild_Thursday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Thursday_Slot1);
				
				Thread.sleep(2000);
				startTime_Friday_Slot1.clear();
				startTime_Friday_Slot1.sendKeys("10:00 AM");
				Thread.sleep(2000);
				endTime_Friday_Slot1.clear();
				endTime_Friday_Slot1.sendKeys("11:00 AM");
				Thread.sleep(2000);
				minchild_Friday_Slot1.clear();
				minchild_Friday_Slot1.sendKeys("15");
				waitAndClick(addBtn_Friday_Slot1);
				selectRdoBtn(reservationtypeRadioBtn, reservationtype);
				waitAndClick(minChildAddBtn);
			}
			result = waitAndGetText(confirmMsg);
		} catch (Exception e) {
			System.out.println("Found Issue with method: validateSetupMinimumChildren()");
			e.printStackTrace();
			result = "Found Issue with method: validateSetupMinimumChildren()";
		}
		return result;

	}

	public String validateDeleteMinimumChildrenSetup(String level) throws IOException {
		String result = null;	
		try {
			if(level.equals("global"))
			{
				globalLevelRadioBtn.click();
				Thread.sleep(2000);
			scrollDown(driver);
			scrollDown(driver);
				waitAndClick(minChildDeleteBtn);
				Thread.sleep(2000);
						waitAndClick(deleteOkBtn);
			}else if(level.equals("group")){
				groupLevelRadioBtn.click();
				Thread.sleep(2000);
				List<WebElement> ele = driver.findElements(By.id("StoreGroupList"));
				selectLastElement(ele);
				Thread.sleep(2000);

				scrollDown(driver);
				scrollDown(driver);
					waitAndClick(minChildDeleteBtn);
					Thread.sleep(1000);
					waitAndClick(deleteOkBtn);
			}else if(level.equals("store")){
				storeLevelRadioBtn.click();
				Thread.sleep(2000);
				List<WebElement> ele = driver.findElements(By.id("StoreList"));
				selectLastElement(ele);
				Thread.sleep(2000);

				scrollDown(driver);
				scrollDown(driver);
					waitAndClick(minChildDeleteBtn);
					Thread.sleep(2000);
					waitAndClick(deleteOkBtn);
					
			}
			result = waitAndGetText(confirmMsg);
		} catch (Exception e) {
			System.out.println("Found Issue with method: validateSetupMinimumChildren()");
			e.printStackTrace();
			result = "Found Issue with method: validateSetupMinimumChildren()";
		}
		return result;

	}
	
	
	//****************************************************************************************************
	//*********************Methods to validate editStoreWithStoreNum************************************
	//****************************************************************************************************
	public boolean editStoreWithStoreNum(String storeNumber, String newAddress) throws IOException {
		boolean restaurantUpdateMsgStatus = false;
		boolean restaurantUpdateaddrstatus = false;
		boolean finalResult = false;
		
		try {
			//Store Search by StoreNumber
			storeNumberInRestaurant.clear();
			storeStoreNameInRestaurant.clear();
			storeCityInRestaurant.clear();
			storeStateInRestaurant.clear();
			storeZipCodeInRestaurant.clear();
			storeAddressInRestaurant.clear();
			storeManagerNameInRestaurant.clear();

			storeNumberInRestaurant.sendKeys(storeNumber);
			waitAndClick(storeSearchBtn);
			Thread.sleep(3000);
			String storeNumInTable = storeNumberInTable.getText();
			if(storeNumber.equals(storeNumInTable)){
				editRestaurant.click();
				while (storeSearchBtn.isDisplayed()) {
					editRestaurant.click();
					if(storeSaveBtnInRestaurant.isDisplayed()) {
						break;
					}
				}
				Thread.sleep(4000);
				storeAddressInRestaurant.clear();
				storeAddressInRestaurant.sendKeys(newAddress);
				waitAndClick(storeSaveBtnInRestaurant);
				if (restaurantUpdateMsg.equals(storeErrMsg.getText())){
					restaurantUpdateMsgStatus=true;
				} else {
					restaurantUpdateMsgStatus=false;
				}
				
			} else {
				System.out.println("Not able to find store number");
			} 
			
			if(newAddress.equals(storeAddressInTable.getText())) {
				restaurantUpdateaddrstatus=true;
				
			} else {
				restaurantUpdateaddrstatus=false;
			}
			
			//Validating all edit successfull message and new Address.
			if(restaurantUpdateMsgStatus==true && restaurantUpdateaddrstatus==true){
				finalResult = true;
			}else{
				finalResult = false;
			}
			return finalResult;
			
			
		} catch (Exception e) {
			System.out.println("Found Issue with method: validateStoreSearch()");
			e.printStackTrace();
			
		}
		return finalResult;
	}


}





