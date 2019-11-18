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

public class CallCenterPartyPage extends BaseTest{

	public  final static String currentPropDir = System.getProperty("user.dir");
	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//******************************Main Menu **************************************************

	@FindBy(xpath="//a[@title='Party']")
	WebElement partyMenuLnk;

	//Sub Menus party

	@FindBy(xpath="//a[@title='Upsell Category']")
	WebElement UpsellCategory;

	@FindBy(xpath="//a[@title='Item Page']")
	WebElement itemPageBtn;

	@FindBy(xpath="//a[@title='Item Category Group']")
	WebElement itemCategorygroupBtn;

	@FindBy(xpath="//a[@title='Item Group']")
	WebElement itemGroupBtn;

	@FindBy(xpath="//a[@title='Item Category']")
	WebElement itemCategoryBtn;

	@FindBy(xpath="//a[@title='Party Item']")
	WebElement partyItemBtn;

	@FindBy(xpath="//a[@title='Party Type Category']")
	WebElement partyTypeCategoryBtn;

	@FindBy(xpath="//a[@title='Party Type']")
	WebElement partyTypeBtn;

	@FindBy(xpath="//a[@title='Party Package']")
	WebElement partyPackageBtn;

	@FindBy(xpath="//a[@title='Party Theme']")
	WebElement partyThemeBtn;

	@FindBy(xpath="//a[@title='Party Type Category Theme']")
	WebElement partyTypeCategoryThemeBtn;

	//ItemPage

	@FindBy(id="ItemPage_ItemPageName")
	WebElement itemPageNameInputBox;

	@FindBy(id="ItemPage_ItemPageDescription")
	WebElement itemPageDescriptionInputBox;

	@FindBy(id="ItemPage_IsActive")
	WebElement itemPageIsActiveCheckBox;

	@FindBy(id="btnSave")
	WebElement itemPageAddBtn;

	@FindBy(id="btnUpdate")
	WebElement itemPageUpdateBtn;

	@FindBy(id="btnReset")
	WebElement itemPageResetBtn;

	@FindBy(id="OptionalCategoryItems")
	WebElement itemPageOptionalCategoryItemsList;

	@FindBy(id="ItemPage_ItemPageName-error")
	WebElement itemPageNameErrorMsg;

	@FindBy(id="ItemPage_ItemPageDescription-error")
	WebElement itemPageDescErrorMsg;

	@FindBy(id="errorMsg") //	Record saved successfully //	Record updated successfully
	WebElement itemPageconfirmMsg;
	
	@FindBy(xpath="//select[@id='OptionalCategoryItems']/option[@style='background-color:MistyRose;background:MistyRose;'][1]")
	WebElement deactiveItem;
	

	//Item Category Group

	@FindBy(id="PromotionCategoryGroup_Title")
	WebElement itemCategoryGroupTitleInputBox;

	@FindBy(id="PromotionCategoryGroup_Name")
	WebElement itemCategoryGroupNameInputBox;

	@FindBy(id="PromotionCategoryGroup_Description")
	WebElement itemCategoryGroupDescriptionInputBox;

	@FindBy(id="PromotionCategoryGroup_IsActive")
	WebElement itemCategoryGroupIsActiveCheckBox;

	@FindBy(id="btnSave")
	WebElement itemCategoryGroupAddBtn;

	@FindBy(id="btnUpdate")
	WebElement itemCategoryGroupUpdateBtn;

	@FindBy(id="btnReset")
	WebElement itemCategoryGroupResetBtn;

	@FindBy(xpath="//select[@id='CategoryGroupList']/option")
	WebElement itemCategoryGroupOptionalCategoryItemsList;

	//ItemGroup

	@FindBy(id="txtName")
	WebElement itemGroupNameInputBox;

	@FindBy(id="txtDescription")
	WebElement itemGroupDescriptionInputBox;

	@FindBy(id="ItemGroup_IsActive")
	WebElement itemGroupIsActiveCheckBox;

	@FindBy(id="btnSave")
	WebElement itemGroupAddBtn;

	@FindBy(id="btnUpdate")
	WebElement itemGroupUpdateBtn;

	@FindBy(id="btnReset")
	WebElement itemGroupResetBtn;

	@FindBy(id="errorMsg") //	Record saved successfully //	Record updated successfully
	WebElement itemGroupconfirmMsg;

	//Item Category 

	@FindBy(id="ItemCategory_PromotionCategoryGroupID")
	WebElement itemCategorygroupDropdown;

	@FindBy(id="ItemCategory_ItemGroupID")
	WebElement itemgroupDropdown;

	@FindBy(id="ItemCategory_ItemPageID")
	WebElement itempageDropdown;

	@FindBy(id="ItemCategory_ItemCategoryName")
	WebElement itemCategoryNameInputBox;

	@FindBy(id="ItemCategory_ItemCategoryDescription")
	WebElement itemCategoryDescriptionInputBox;

	@FindBy(id="ItemCategory_IsActive")
	WebElement itemCategoryIsActiveCheckBox;

	@FindBy(id="btnSave")
	WebElement itemCategoryAddBtn;

	@FindBy(id="btnUpdate")
	WebElement itemCategoryUpdateBtn;

	@FindBy(id="btnReset")
	WebElement itemCategoryResetBtn;

	@FindBy(id="ItemCategoryList")
	WebElement itemCategoryList;

	@FindBy(id="errorMsg")
	WebElement itemCategoryconfirmMsg;

	@FindBy(id="okClickSelectImageAN")
	WebElement itemCategoryokBtn;

	//Party Item 

	@FindBy(id="optionalPartyItemList")
	WebElement optionalPartyItemList;

	@FindBy(id="txtTitle")
	WebElement itemNameInputBox;

	@FindBy(id="itemtype")
	WebElement itemtyperadioBox;

	@FindBy(id="txtOptPrice")
	WebElement priceInputBox;

	@FindBy(id="OptionalPartyItem_PromotionCategoryID")
	WebElement itemcatagoryDropdown;

	@FindBy(id="OptionalPartyItem_IsPlayPass")
	WebElement playPassCheckbox;

	@FindBy(id="btnSave")
	WebElement partyItemAddBtn;

	@FindBy(id="btnUpdate")
	WebElement partyItemUpdateBtn;

	@FindBy(id="btnReset")
	WebElement partyItemResetBtn;

	//Party Type Category

	@FindBy(id="txtdisplayName")
	WebElement partyTypeCategoryTitleInputBox;

	@FindBy(id="txtName")
	WebElement partyTypeCategoryNameInputBox;

	@FindBy(id="txtDescription")
	WebElement partyTypeCategoryDescriptionInputBox;

	@FindBy(id="reservationTypeID")
	WebElement reservationTypeDropdown;

	@FindBy(id="CallOutOptionID")
	WebElement callOutOptionIDDropdown;

	@FindBy(id="CallOutColorID")
	WebElement callOutColorIDDropdown;

	@FindBy(id="selImageAN")
	WebElement selectImagebtn;

	@FindBy(xpath="(//*[@id='ImgTag'])[1]")
	WebElement selectImage;

	@FindBy(id="okClickAN")
	WebElement partyTypeCategoryOkbtn;

	@FindBy(id="PromotionCategoryItems")
	WebElement PartyTypeCategoryItems;

	@FindBy(id="btnSave")
	WebElement partyTypeCategoryAddBtn;

	@FindBy(id="btnUpdate")
	WebElement partyTypeCategoryUpdateBtn;

	@FindBy(id="NameError")
	WebElement partyTypeCategoryTitlerequiredFieldError;

	@FindBy(id="DisplyNameError")
	WebElement partyTypeCategoryNamerequiredFieldError;

	@FindBy(id="DescriptionError")
	WebElement partyTypeCategoryDescrequiredFieldError;

	@FindBy(id="CallOutOptionError")
	WebElement partyTypeCategoryCallOutOptionrequiredFieldError;

	@FindBy(id="CallOutColorError")
	WebElement partyTypeCategoryCallOutColorrequiredFieldError;

	@FindBy(id="errorMsg")
	WebElement partyPageCategoryconfirmMsg;

	@FindBy(id="btnReset")
	WebElement partyTypeCategoryResetBtn;

	@FindBy(id="btnDelete")
	WebElement partyTypeCategoryDeleteBtn;

	@FindBy(xpath="//button[@class='bootbox-close-button close']")
	WebElement partyPageCategoryDeletePopup;


	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement partyPageCategoryDeleteOkBtn;

	//Party Type

	@FindBy(id="optRadio")
	WebElement partyTypeBookingModelRadio;

	@FindBy(id="PartyTypeTitle")
	WebElement partyTypeNameInputBox;

	@FindBy(id="Price")
	WebElement partyTypePriceInputBox;

	@FindBy(id="PromotionCategoryID")
	WebElement promotionCategoryDropdown;

	@FindBy(id="StartOn")
	WebElement partyTypeStartdateInputBox;

	@FindBy(id="TypeCategory")
	List<WebElement> partyTypecategoryradioBtn;

	@FindBy(id="PartyTypesDtoList")
	WebElement partyTypesDtoList;

	@FindBy(name="Create")
	WebElement partyTypeaddBtn;

	@FindBy(name="Edit")
	WebElement partyTypeUpdateBtn;

	@FindBy(id="btnReset")
	WebElement partyTypeResetBtn;

	@FindBy(name="Delete")
	WebElement partyTypeDeleteBtn;

	@FindBy(name="Delete")
	WebElement partyTypedeleteMsg;

	@FindBy(id="PromotionCategoryID-error")
	WebElement requiredFieldError;

	@FindBy(id="errMsgPType")
	WebElement partyTypeconfirmMsg;

	//Package

	@FindBy(id="PackageTitle")
	WebElement packageTitleInputBox;

	@FindBy(id="PackageDescription")
	WebElement packageDescriptionInputBox;

	@FindBy(id="IsActive")
	WebElement packageIsActiveCheckBox;

	@FindBy(xpath="(//input[@value='Add'])")
	WebElement packageAddBtn;

	@FindBy(xpath="(//input[@name='command'])[3]")
	WebElement packageUpdateBtn;

	@FindBy(xpath="(//input[@name='command'])[5]")
	WebElement packageResetBtn;

	@FindBy(id="PartyTypes")
	WebElement PartyTypesList;

	@FindBy(id="errMsgPType")
	WebElement partyPackageconfirmMsg;

	@FindBy(id="PackageTitle-error")
	WebElement packageTitlerequiredFieldError;

	@FindBy(id="PackageDescription-error")
	WebElement packageDescriptionrequiredFieldError;


	//Party Theme

	@FindBy(id="PartyTheme_Name")
	WebElement partyThemeNameInputBox;

	@FindBy(id="PartyTheme_Description")
	WebElement partyThemeDescriptionInputBox;

	@FindBy(id="PartyTheme_IsActive")
	WebElement partyThemeIsActiveCheckBox;


	@FindBy(id="okClickAN")
	WebElement partyThemeOkBtn;

	@FindBy(id="btnSave")
	WebElement partyThemeAddBtn;

	@FindBy(id="btnUpdate")
	WebElement partyThemeUpdateBtn;

	@FindBy(id="btnReset")
	WebElement partyThemeResetBtn;

	@FindBy(id="PartyTheme_EffectiveFrom")
	WebElement effectFromInputBox;

	@FindBy(id="PartyTheme_EffectiveTo")
	WebElement effectToInputBox;

	@FindBy(id="errorMsg") //	Record saved successfully //	Record updated successfully
	WebElement partyThemeconfirmMsg;

	@FindBy(xpath="//select[@id='PartyThemesList']/option")
	WebElement partyThemeList;

	//Party Type Category Theme

	@FindBy(id="PartyTypeCategoryList")
	WebElement partyTypeCategoryListdropdown;

	@FindBy(id="AvailablePartyThemes")
	WebElement availablePartyThemesList;

	@FindBy(id="SelectedPartyThemes")
	WebElement selectedPartyThemesList;

	@FindBy(id="addItems")
	WebElement partyTypeCategoryThemeAddBtn;

	@FindBy(id="removeItems")
	WebElement partyTypeCategoryThemeRemoveBtn;

	@FindBy(name="Edit")
	WebElement partyTypeCategoryThemeUpdateBtn;

	@FindBy(id="btnReset")
	WebElement partyTypeCategoryThemeResetBtn;

	@FindBy(xpath="//Select[@id='AvailablePartyThemes']/option[1]")
	WebElement newpartyThemeInpartyThemePage;

	@FindBy(id="drpPrtyStyle")
	WebElement partyStyleDropdown;


	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************
	public CallCenterPartyPage(){
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

	public boolean validatePartyMenu() throws InterruptedException, AWTException {
		try {
			waitAndClick(partyMenuLnk);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validatePartyMenu()");
		}
		return false;
	}


	///###############################################################################################
	//                               ITEM PAGE METHODS
	//################################################################################################

	//************************************************************************************************
	//*********************Methods to validate the mandatory fields in Item Page***********************
	//************************************************************************************************

	public boolean validateMandatoryfieldInItemPage() throws InterruptedException, AWTException {
		try {
			boolean itemPageNameErrorMessage=false;
			boolean itemPageDescErrorMessage=false;
			waitAndClick(itemPageBtn);
			waitAndClick(itemPageAddBtn);
			Thread.sleep(2000);
			itemPageNameErrorMessage = itemPageNameErrorMsg.isDisplayed();
			itemPageDescErrorMessage = itemPageDescErrorMsg.isDisplayed();
			System.out.println("Error Message is Displayed......................................................");
			if(itemPageNameErrorMessage==true && itemPageDescErrorMessage==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMandatoryfieldInItemPage()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to Add the item in Item Page***********************
	//************************************************************************************************
	public boolean validateAddInItemPage() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String itemName = "ItemPage"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemPageBtn);
			Thread.sleep(2000);
			itemPageNameInputBox.sendKeys(itemName);
			itemPageDescriptionInputBox.sendKeys(itemName);
			waitAndClick(itemPageAddBtn);
			confmsg = waitAndGetText(itemPageconfirmMsg);

			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='OptionalCategoryItems']/option"));
			for(int i=0;i<ele.size();i++)
			{
				if(itemName.equals(ele.get(i).getText())){
					result2 = true;
					break;
				}
			} 
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInItemPage()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to Update the item in Item Page***********************
	//************************************************************************************************
	public boolean validateUpdateInItemPage() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String itemName = "ItemPage"+getTodaysDateInDay()+getCurrentTimeInSS(); 
		try {
			String confmsg=null;
			waitAndClick(itemPageBtn);
			Thread.sleep(2000);
			itemPageNameInputBox.sendKeys(itemName);
			itemPageDescriptionInputBox.sendKeys(itemName);
			waitAndClick(itemPageAddBtn);
			Thread.sleep(2000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='OptionalCategoryItems']/option"));
			for(int i=0;i<ele.size();i++)
			{
				if(itemName.equals(ele.get(i).getText())){
					Thread.sleep(2000);
					itemPageNameInputBox.clear();
					itemPageNameInputBox.sendKeys(itemName+"U");
					itemPageDescriptionInputBox.clear();
					itemPageDescriptionInputBox.sendKeys(itemName+"U");
					waitAndClick(itemPageUpdateBtn);
					Thread.sleep(2000);
					result2 = true;
					break;
				}
			} 

			confmsg = waitAndGetText(itemGroupconfirmMsg);
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
			}

			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item Group is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInItemPage()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to Reset the fields in Item Page***********************
	//************************************************************************************************
	public boolean validateResetInItemPage() throws InterruptedException, AWTException {
		try {
			boolean validateaddbtn,validateitemPageName,validateaitemPageDescription=false;
			waitAndClick(itemPageBtn);
			Thread.sleep(2000);
			itemPageOptionalCategoryItemsList.click();
			waitAndClick(itemPageResetBtn);
			validateaddbtn=itemPageAddBtn.isEnabled();
			validateitemPageName=itemPageNameInputBox.getText().isEmpty();
			validateaitemPageDescription=itemPageDescriptionInputBox.getText().isEmpty();
			System.out.println("Item is Reset ...................................................................");
			if(validateaddbtn==true && validateitemPageName==true && validateaitemPageDescription==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateResetInItemPage()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to Update the item in Item Page***********************
	//************************************************************************************************
	public boolean validateItemInactiveItemPage() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String itemName = "ItemPage"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemPageBtn);
			Thread.sleep(2000);
			itemPageNameInputBox.sendKeys(itemName);
			itemPageDescriptionInputBox.sendKeys(itemName);
			Thread.sleep(2000);
			itemPageIsActiveCheckBox.click();
			waitAndClick(itemPageAddBtn);
			confmsg = waitAndGetText(itemPageconfirmMsg);
			System.out.println("confmsg : "+confmsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			//waitAndClick(partyMenuLnk);
			Thread.sleep(2000);
			
					WebElement itemInActiveColor = driver.findElement(By.xpath("//option[text()='"+itemName+"']"));
			String itemColor = itemInActiveColor.getCssValue("background-color");
			String itemInActiveColorHex = Color.fromString(itemColor).asHex();
			System.out.println("item InActive color : "+itemInActiveColorHex);
			//  "#ffe4e1" means "light pink" color(item Inactive color) #ffe4e1
			if (itemInActiveColor.isDisplayed() && itemInActiveColorHex.equals("#3399ff")) {
				result2=true;
			}
			
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item is added and it is inactive in list...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateItemInactiveItemPage()");
			return false;
		}
	}



	///###############################################################################################
	//                               ITEM GROUP METHODS
	//################################################################################################
	//************************************************************************************************
	//*********************Methods to Add the item in Item Group***********************
	//************************************************************************************************

	public boolean validateAddInItemGroup() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String groupName = "ItemGroup"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemGroupBtn);
			Thread.sleep(2000);
				itemGroupNameInputBox.sendKeys(groupName);
				itemGroupDescriptionInputBox.sendKeys(groupName);
						waitAndClick(itemGroupAddBtn);
			Thread.sleep(2000);
			confmsg=waitAndGetText(itemGroupconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='CategoryGroupList']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(groupName.equals(ele.get(i).getText())){
					result2 = true;
					break;
				}
			} 
			
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item Group is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInItemGroup()");
			return false;
		}

	}

	//************************************************************************************************
	//*********************Methods to Update the item in Item Group***********************
	//************************************************************************************************
	public boolean validateUpdateInItemGroup() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String groupName = "ItemGroup"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemGroupBtn);
			Thread.sleep(2000);
			itemGroupNameInputBox.sendKeys(groupName);
			itemGroupDescriptionInputBox.sendKeys(groupName);
			waitAndClick(itemGroupAddBtn);
			Thread.sleep(2000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='CategoryGroupList']/option"));
			for(int i=0;i<ele.size();i++)
			{

				Thread.sleep(1000);
				if(groupName.equals(ele.get(i).getText())){
					Thread.sleep(2000);
					itemGroupNameInputBox.clear();
					itemGroupDescriptionInputBox.clear();
					itemGroupNameInputBox.sendKeys(groupName+"U");
					itemGroupDescriptionInputBox.sendKeys(groupName+"U");
					waitAndClick(itemGroupUpdateBtn);
					Thread.sleep(2000);
					result2 = true;
					break;
				}
			} 
			confmsg=waitAndGetText(itemGroupconfirmMsg);
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
			}

			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item Group is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInItemGroup()");
			return false;
		}

	}
	//************************************************************************************************
	//*********************Methods to Reset the fields in Item Group***********************
	//************************************************************************************************
	public boolean validateResetInItemGroup() throws InterruptedException, AWTException {
		try {
			boolean validateaddbtn,validateitemGroupName,validateaitemGroupDesc=false;
			waitAndClick(itemGroupBtn);
			Thread.sleep(2000);
			itemCategoryGroupOptionalCategoryItemsList.click();
			waitAndClick(itemGroupResetBtn);
			validateaddbtn=itemGroupAddBtn.isEnabled();
			validateitemGroupName=itemGroupNameInputBox.getText().isEmpty();
			validateaitemGroupDesc=itemGroupDescriptionInputBox.getText().isEmpty();
			System.out.println("Item is Reset ...................................................................");
			if(validateaddbtn==true && validateitemGroupName==true && validateaitemGroupDesc==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateResetInItemGroup()");
		}
		return false;
	}


	//************************************************************************************************
		//*********************Methods to Add the item in Item Group***********************
		//************************************************************************************************

		public boolean validateItemGroupInactive() throws InterruptedException, AWTException {
			boolean result1 = false;
			boolean result2 = false;
			String groupName = "ItemGroup"+getTodaysDateInDay()+getCurrentTimeInSS();
			try {
				String confmsg=null;
				waitAndClick(itemGroupBtn);
				Thread.sleep(2000);
					itemGroupNameInputBox.sendKeys(groupName);
					itemGroupDescriptionInputBox.sendKeys(groupName);
					itemGroupIsActiveCheckBox.click();
				
				waitAndClick(itemGroupAddBtn);
				Thread.sleep(2000);
				confmsg=waitAndGetText(itemGroupconfirmMsg);
				if(confmsg.equals("Record saved successfully")) {
					result1 = true;
				}
								
				WebElement itemInActiveColor = driver.findElement(By.xpath("//option[text()='"+groupName+"']"));
		String itemColor = itemInActiveColor.getCssValue("background-color");
		String itemInActiveColorHex = Color.fromString(itemColor).asHex();
		System.out.println("item InActive color : "+itemInActiveColorHex);
		//  "#ffe4e1" means "light pink" color(item Inactive color) #ffe4e1
		if (itemInActiveColor.isDisplayed() && itemInActiveColorHex.equals("#3399ff")) { //#ffe4e1
			result2=true;
		}
				Thread.sleep(15000);
				if(result1 && result2) {
					System.out.println("Item Group is added and displayed in list Successfully...................................................................");
					return true;
				}else {
					return false;
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.out.println("Issue with Method: validateItemGroupInactive()");
				return false;
			}

		}


	///###############################################################################################
	//                               PARTY TYPE CATEGORY METHODS
	//################################################################################################

	//************************************************************************************************
	//*********************Methods to validate the mandatory fields in Party Type Category Page*******
	//************************************************************************************************

	public boolean validateMandatoryfieldInPartyTypeCategory() throws InterruptedException, AWTException {
		try {
			boolean partyTypeCategoryTitleErrorMessage,partyTypeCategoryNameErrorMessage,partyTypeCategoryDescriptionErrorMessage,partyTypeCategoryCallOutOptionErrorMessage,partyTypeCategoryCallOutColorErrorMessage=false;
			waitAndClick(partyTypeCategoryBtn);
			waitAndClick(partyTypeCategoryAddBtn);
			Thread.sleep(2000);
			partyTypeCategoryTitleErrorMessage = partyTypeCategoryTitlerequiredFieldError.isDisplayed();
			partyTypeCategoryNameErrorMessage = partyTypeCategoryNamerequiredFieldError.isDisplayed();
			partyTypeCategoryDescriptionErrorMessage = partyTypeCategoryDescrequiredFieldError.isDisplayed();
			partyTypeCategoryCallOutOptionErrorMessage =partyTypeCategoryCallOutOptionrequiredFieldError.isDisplayed();
			partyTypeCategoryCallOutColorErrorMessage =partyTypeCategoryCallOutColorrequiredFieldError.isDisplayed();
			System.out.println("Required field Error Msg displayed...................................................................");
			if(partyTypeCategoryTitleErrorMessage==true && partyTypeCategoryNameErrorMessage==true && partyTypeCategoryDescriptionErrorMessage==true && partyTypeCategoryCallOutOptionErrorMessage==true && partyTypeCategoryCallOutColorErrorMessage==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMandatoryfieldInPartyTypeCategory()");

		}
		return false;
	}
	//************************************************************************************************
	//*********************Methods to Add the item in Party Type Category Page***********************
	//************************************************************************************************
	public boolean validateAddInPartyTypeCategory() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyTypeCategoryName = "PartyTypeCategory"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyTypeCategoryBtn);
			Thread.sleep(2000);
			partyTypeCategoryNameInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryTitleInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryDescriptionInputBox.sendKeys(partyTypeCategoryName);
			selectDrpDwnByIndex(reservationTypeDropdown,0);
			selectDrpDwnByIndex(callOutOptionIDDropdown,1);
			selectDrpDwnByIndex(callOutColorIDDropdown,1);
			Thread.sleep(2000);
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			waitAndClick(selectImage);
			waitAndClick(partyTypeCategoryOkbtn);
			waitAndClick(partyTypeCategoryAddBtn);
			Thread.sleep(3000);

			confmsg=waitAndGetText(partyPageCategoryconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PromotionCategoryItems']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyTypeCategoryName.equals(ele.get(i).getText())){
					result2 = true;
					break;
				}
			} 
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party Type Category is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInPartyTypeCategory()");
			return false;
		}

	}


	//************************************************************************************************
	//*********************Methods to Update the item in Party Type Category Page***********************
	//************************************************************************************************
	public boolean validateUpdateInPartyTypeCategory() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyTypeCategoryName = "PartyTypeCategory"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyTypeCategoryBtn);
			Thread.sleep(2000);
			partyTypeCategoryNameInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryTitleInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryDescriptionInputBox.sendKeys(partyTypeCategoryName);
			selectDrpDwnByIndex(reservationTypeDropdown,0);
			selectDrpDwnByIndex(callOutOptionIDDropdown,1);
			selectDrpDwnByIndex(callOutColorIDDropdown,1);
			Thread.sleep(2000);
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			Thread.sleep(2000);
			Thread.sleep(2000);
			selectImage.click();
			waitAndClick(partyTypeCategoryOkbtn);
			waitAndClick(partyTypeCategoryAddBtn);
			scrollDown(driver);
			Thread.sleep(3000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PromotionCategoryItems']/option"));
			for(int i=0;i<ele.size();i++)
			{
				Thread.sleep(3000);
				if(partyTypeCategoryName.equals(ele.get(i).getText())){
					Thread.sleep(2000);
					partyTypeCategoryNameInputBox.clear();
					partyTypeCategoryTitleInputBox.clear();
					partyTypeCategoryDescriptionInputBox.clear();
					Thread.sleep(2000);
					partyTypeCategoryNameInputBox.sendKeys(partyTypeCategoryName+"U");
					partyTypeCategoryTitleInputBox.sendKeys(partyTypeCategoryName+"U");
					partyTypeCategoryDescriptionInputBox.sendKeys(partyTypeCategoryName+"U");
					selectDrpDwnByIndex(reservationTypeDropdown,0);
					selectDrpDwnByIndex(callOutOptionIDDropdown,2);
					selectDrpDwnByIndex(callOutColorIDDropdown,2);
					Thread.sleep(2000);
					scrollDown(driver);
					waitAndClick(partyTypeCategoryUpdateBtn);
					Thread.sleep(2000);
					result2 = true;
					break;
				}
			} 
			confmsg=waitAndGetText(partyPageCategoryconfirmMsg);
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
			}

			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party Type Category is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInPartyTypeCategory()");
			return false;
		}

	}
	//************************************************************************************************
	//*********************Methods to Reset the fields in Party Type Category Page***********************
	//************************************************************************************************
	public boolean validateResetInPartyTypeCategory() throws InterruptedException, AWTException {
		try {
			boolean validateaddbtn,validatepartyTypeCategoryTitle,validatepartyTypeCategoryName,validatepartyTypeCategoryDescription=false;
			waitAndClick(partyTypeCategoryBtn);
			Thread.sleep(2000);
			PartyTypeCategoryItems.click();
			waitAndClick(partyTypeCategoryResetBtn);
			validateaddbtn=partyTypeCategoryAddBtn.isEnabled();
			validatepartyTypeCategoryTitle=partyTypeCategoryTitleInputBox.getText().isEmpty();
			validatepartyTypeCategoryName=partyTypeCategoryNameInputBox.getText().isEmpty();
			validatepartyTypeCategoryDescription=partyTypeCategoryDescriptionInputBox.getText().isEmpty();
			System.out.println("Item is Reset ...................................................................");
			if(validateaddbtn==true && validatepartyTypeCategoryTitle==true && validatepartyTypeCategoryName==true && validatepartyTypeCategoryDescription==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateResetInPartyTypeCategory()");
		}
		return false;
	}
	//************************************************************************************************
	//*********************Methods to Delete the item in Party Type Category Page***********************
	//************************************************************************************************
	public boolean validateDeleteInPartyTypeCategory() throws InterruptedException, AWTException {
		String confmsg=null;
		String partyTypeCategoryName = "PartyTypeCategory"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			waitAndClick(partyTypeCategoryBtn);
			Thread.sleep(2000);
			partyTypeCategoryNameInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryTitleInputBox.sendKeys(partyTypeCategoryName);
			partyTypeCategoryDescriptionInputBox.sendKeys(partyTypeCategoryName);
			selectDrpDwnByIndex(reservationTypeDropdown,0);
			selectDrpDwnByIndex(callOutOptionIDDropdown,1);
			selectDrpDwnByIndex(callOutColorIDDropdown,1);
			Thread.sleep(2000);
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			Thread.sleep(4000);
			selectImage.click();
			waitAndClick(partyTypeCategoryOkbtn);
			waitAndClick(partyTypeCategoryAddBtn);
			scrollDown(driver);
			Thread.sleep(3000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PromotionCategoryItems']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyTypeCategoryName.equals(ele.get(i).getText())){
					Thread.sleep(2000);
					waitAndClick(partyTypeCategoryDeleteBtn);
					Thread.sleep(2000);
					waitAndClick(partyPageCategoryDeleteOkBtn);
					break;	
				}
			} 
			confmsg=waitAndGetText(partyPageCategoryconfirmMsg);
			if(confmsg.equals("Record deleted successfully")) {
				System.out.println("Party Type Category is Deleted and removed from list Successfully..........................................");
				return true;
			}


		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDeleteInPartyTypeCategory()");
		}
		return false;
	}


	///###############################################################################################
	//                               PARTY TYPE METHODS
	//################################################################################################

	//************************************************************************************************
	//*********************Methods to validate the mandatory fields in Party type Page***********************
	//************************************************************************************************
	public boolean validateMandatoryfieldInPartyType() throws InterruptedException, AWTException {
		boolean partyTypeNameErrorMessage,partyTypePriceErrorMessage,promotionCategoryErrorMessage=false;
		try {
			waitAndClick(partyTypeBtn);
			waitAndClick(partyTypeaddBtn);
			Thread.sleep(2000);
			partyTypeNameErrorMessage = requiredFieldError.isDisplayed();
			partyTypePriceErrorMessage = requiredFieldError.isDisplayed();
			promotionCategoryErrorMessage = requiredFieldError.isDisplayed();
			System.out.println("Required field Error Msg displayed...................................................................");
			if(partyTypeNameErrorMessage==true && partyTypePriceErrorMessage==true && promotionCategoryErrorMessage==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMandatoryfieldInPartyType()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to Add the item in Party type Page***********************
	//************************************************************************************************

	public boolean validateAddInPartyType() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyTypeName = "PartyType"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyTypeBtn);
			Thread.sleep(2000);
			partyTypeNameInputBox.sendKeys(partyTypeName);
			partyTypePriceInputBox.sendKeys(partyTypeName);
			selectDrpDwnByIndex(promotionCategoryDropdown,5);
			selectRdoBtn(partyTypecategoryradioBtn,3);
			waitAndClick(partyTypeaddBtn);
			Thread.sleep(2000);
			confmsg=waitAndGetText(partyTypeconfirmMsg);

			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}

			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyTypesDtoList']/option"));
			selectLastElement(ele);
			result2 = true;
			Thread.sleep(5000);
			if(result1 && result2) {
				System.out.println("Party Type is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInPartyType()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to Update the item in Party type Page***********************
	//************************************************************************************************
	public boolean validateUpdateInPartyType() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyTypeName = "PartyType"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyTypeBtn);
			Thread.sleep(2000);
			partyTypeNameInputBox.sendKeys(partyTypeName);
			partyTypePriceInputBox.sendKeys(partyTypeName);
			selectDrpDwnByIndex(promotionCategoryDropdown,3);
			selectRdoBtn(partyTypecategoryradioBtn,2);
			waitAndClick(partyTypeaddBtn);
			Thread.sleep(2000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyTypesDtoList']/option"));
			selectLastElement(ele);
			result2 = true;
			Thread.sleep(2000);
			partyTypeNameInputBox.clear();
			partyTypePriceInputBox.clear();
			Thread.sleep(2000);
			partyTypeNameInputBox.sendKeys(partyTypeName+"U");
			partyTypePriceInputBox.sendKeys(partyTypeName+"U");
			selectDrpDwnByIndex(promotionCategoryDropdown,2);
			waitAndClick(partyTypeUpdateBtn);
			confmsg=waitAndGetText(partyTypeconfirmMsg);
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
			}

			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party type is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInPartyType()");
			return false;
		}
	}
	//************************************************************************************************
	//*********************Methods to Reset the fields in Party type Page***********************
	//************************************************************************************************
	public boolean validateResetInPartyType() throws InterruptedException, AWTException {
		try {
			boolean validateaddbtn,validatepartyTypeName,validateapartyTypePrice=false;
			waitAndClick(partyTypeBtn);
			Thread.sleep(2000);
			partyTypesDtoList.click();
			waitAndClick(partyTypeResetBtn);
			validateaddbtn=partyTypeaddBtn.isEnabled();
			validatepartyTypeName=partyTypeNameInputBox.getText().isEmpty();
			validateapartyTypePrice=partyTypePriceInputBox.getText().isEmpty();
			System.out.println("Item is Reset ...................................................................");
			if(validateaddbtn==true && validatepartyTypeName==true && validateapartyTypePrice==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateResetInPartyType()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to Delete the item in Party type Page***********************
	//************************************************************************************************
	public boolean validateDeleteInPartyType() throws InterruptedException, AWTException {
		try {
			boolean validatedeleteMsg=false;
			waitAndClick(partyTypeBtn);
			Thread.sleep(2000);
			partyTypesDtoList.click();
			waitAndClick(partyTypeDeleteBtn);
			Thread.sleep(2000);
			validatedeleteMsg=partyTypedeleteMsg.isDisplayed();

			System.out.println("Item is Deleted ...................................................................");
			if(validatedeleteMsg) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateDeleteInPartyType()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to validate the mandatory fields in Party Package Page*************
	//************************************************************************************************
	public boolean validateMandatoryfieldInPartyPackage() throws InterruptedException, AWTException {
		try {
			boolean packageTitleErrorMessage,packageDescriptionErrorMessage=false;
			waitAndClick(partyPackageBtn);
			Thread.sleep(4000);
			scrollDown(driver);
			waitAndClick(packageAddBtn);
			System.out.println("Add button clicked...................................................................");
			Thread.sleep(5000);
			packageTitleErrorMessage = packageTitlerequiredFieldError.isDisplayed();
			packageDescriptionErrorMessage = packageDescriptionrequiredFieldError.isDisplayed();
			System.out.println("Required Error Msg displayed...................................................................");
			if(packageTitleErrorMessage==true && packageDescriptionErrorMessage==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateMandatoryfieldInPartyPackage()");
		}
		return false;
	}

	//************************************************************************************************
	//*********************Methods to Add the item in Party Package Page***********************
	//************************************************************************************************
	public boolean validateAddInPartyPackage() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyPackageName = "PartyPackage"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyPackageBtn);
			Thread.sleep(2000);
			packageTitleInputBox.sendKeys(partyPackageName);
			packageDescriptionInputBox.sendKeys(partyPackageName);
			Thread.sleep(2000);
			scrollDown(driver);
			waitAndClick(packageAddBtn);
			Thread.sleep(2000);

			confmsg=waitAndGetText(partyPackageconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='AllPartyPackages']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyPackageName.equals(ele.get(i).getText())){
					result2 = true;
					break;
				}
			} 
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party Package is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInPartyPackage()");
			return false;
		}

	}

	//************************************************************************************************
	//*********************Methods to Add the item in Item Category Page***********************
	//************************************************************************************************
	public boolean validateAddInItemcategory() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String itemcategoryName = "Itemcategory"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemCategoryBtn);
			Thread.sleep(2000);
			selectDrpDwnByIndex(itemCategorygroupDropdown,1);
			selectDrpDwnByIndex(itemgroupDropdown,1);
			itemCategoryNameInputBox.sendKeys(itemcategoryName);
			itemCategoryDescriptionInputBox.sendKeys(itemcategoryName);
			selectDrpDwnByIndex(itempageDropdown,1);
			waitAndClick(selectImagebtn);
			Thread.sleep(3000);
			selectImage.click();
			waitAndClick(itemCategoryokBtn);
			waitAndClick(itemCategoryAddBtn);
			Thread.sleep(2000);

			confmsg=waitAndGetText(itemCategoryconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}

			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='ItemCategoryList']/option"));
			for(int i=0;i<ele.size();i++)
			{
				String itemcat=ele.get(i).getText();
				if(itemcat.contains(itemcategoryName)){
					String itemres[]=itemcat.split("-");
					if((itemres[2].trim()).equals(itemcategoryName)){
						result2 = true;
						break;
					}
				} 
			}	
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item category is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInItemcategory()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to Update the item Category Page***********************
	//************************************************************************************************
	public boolean validateUpdateInItemcategory() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String itemcategoryName = "Itemcategory"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(itemCategoryBtn);
			selectDrpDwnByIndex(itemCategorygroupDropdown,1);
			selectDrpDwnByIndex(itemgroupDropdown,1);
			itemCategoryNameInputBox.sendKeys(itemcategoryName);
			itemCategoryDescriptionInputBox.sendKeys(itemcategoryName);
			selectDrpDwnByIndex(itempageDropdown,1);
			waitAndClick(selectImagebtn);
			Thread.sleep(3000);
			selectImage.click();
			waitAndClick(itemCategoryokBtn);
			waitAndClick(itemCategoryAddBtn);
			Thread.sleep(2000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='ItemCategoryList']/option"));
			for(int i=0;i<ele.size();i++)
			{
				String itemcat=ele.get(i).getText();
				if(itemcat.contains(itemcategoryName)){
					String itemres[]=itemcat.split("-");
					if((itemres[2].trim()).equals(itemcategoryName)){
						itemCategoryNameInputBox.clear();
						itemCategoryDescriptionInputBox.clear();
						Thread.sleep(2000);
						itemCategoryNameInputBox.sendKeys(itemcategoryName+"U");
						itemCategoryDescriptionInputBox.sendKeys(itemcategoryName+"U");
						waitAndClick(itemCategoryUpdateBtn);
					}
					result2 = true;
					break;
				}
			} 


			confmsg=waitAndGetText(itemCategoryconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}

			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Item Category is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInItemcategory()");
			return false;
		}

	}


	//************************************************************************************************
	//*********************Methods to Add the theme in Party theme Page***********************
	//************************************************************************************************
	public boolean validateAddInPartyTheme(String effectiveDate) throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyThemeName = "PartyTheme"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyThemeBtn);
			Thread.sleep(2000);
			partyThemeNameInputBox.sendKeys(partyThemeName);
			partyThemeDescriptionInputBox.sendKeys(partyThemeName);
			waitAndClick(partyThemeIsActiveCheckBox);
			if(effectiveDate=="YES") {
				effectFromInputBox.sendKeys("05/15/2019");
				effectToInputBox.sendKeys("05/15/2020");
			}else if(effectiveDate=="NO") {
				effectFromInputBox.sendKeys("05/15/2019");
				effectToInputBox.sendKeys("05/18/2019");
			}
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			Thread.sleep(3000);
			selectImage.click();
			waitAndClick(partyThemeOkBtn);
			waitAndClick(partyThemeAddBtn);
			Thread.sleep(2000);

			confmsg=waitAndGetText(partyThemeconfirmMsg);
			if(confmsg.equals("Record saved successfully")) {
				result1 = true;
			}
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyThemesList']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyThemeName.equals(ele.get(i).getText())){
					result2 = true;
					break;
				}
			} 
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party theme is added and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateAddInPartyTheme()");
			return false;
		}

	}

	//************************************************************************************************
	//*********************Methods to Update the theme in Party theme Page***********************
	//************************************************************************************************
	public boolean validateUpdateInPartyTheme() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyThemeName = "PartyTheme"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyThemeBtn);
			Thread.sleep(2000);
			partyThemeNameInputBox.sendKeys(partyThemeName);
			partyThemeDescriptionInputBox.sendKeys(partyThemeName);
			waitAndClick(partyThemeIsActiveCheckBox);
			effectFromInputBox.sendKeys("05/15/2019");
			effectToInputBox.sendKeys("05/15/2020");
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			Thread.sleep(3000);
			selectImage.click();
			waitAndClick(partyThemeOkBtn);
			waitAndClick(partyThemeAddBtn);
			Thread.sleep(2000);
			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyThemesList']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyThemeName.equals(ele.get(i).getText())){
					Thread.sleep(2000);
					partyThemeNameInputBox.clear();
					partyThemeDescriptionInputBox.clear();
					Thread.sleep(2000);
					partyThemeNameInputBox.sendKeys(partyThemeName);
					partyThemeDescriptionInputBox.sendKeys(partyThemeName);
					scrollDown(driver);
					waitAndClick(partyThemeUpdateBtn);
					Thread.sleep(2000);
					result2 = true;
					break;
				}
			} 

			confmsg=waitAndGetText(partyThemeconfirmMsg);
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
			}
			Thread.sleep(15000);
			if(result1 && result2) {
				System.out.println("Party theme is Updated and displayed in list Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInPartyTheme()");
			return false;
		}
	}

	//************************************************************************************************
	//*********************Methods to Reset the fields in Party theme***********************
	//************************************************************************************************
	public boolean validateResetInPartyTheme() throws InterruptedException, AWTException {
		try {
			boolean validateaddbtn,validatepartyThemeName,validatepartyThemeDescription,validatepartyThemeeffectFrom,validatepartyThemeeffectTo=false;
			waitAndClick(partyThemeBtn);	
			waitAndClick(partyThemeList);
			scrollDown(driver);
			waitAndClick(partyThemeResetBtn);
			Thread.sleep(2000);
			validateaddbtn=partyThemeAddBtn.isEnabled();
			validatepartyThemeName=partyThemeNameInputBox.getText().isEmpty();
			validatepartyThemeDescription=partyThemeDescriptionInputBox.getText().isEmpty();
			validatepartyThemeeffectFrom=effectFromInputBox.getText().isEmpty();
			validatepartyThemeeffectTo=effectToInputBox.getText().isEmpty();

			System.out.println("Party theme fields are Reset ...................................................................");
			if(validateaddbtn==true && validatepartyThemeName==true && validatepartyThemeDescription==true && validatepartyThemeeffectFrom==true && validatepartyThemeeffectTo==true) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateResetInPartyTheme()");
		}
		return false;
	}

	//Party Type Catagory theme
	//************************************************************************************************
	//*********************Methods to Update the theme in Party Type Category theme Page***********************
	//************************************************************************************************
	public boolean validateUpdateInPartyTypeCatagoryTheme() throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String confmsg=null;
		String partyThemeName = "PTC"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
						waitAndClick(partyTypeCategoryThemeBtn);
			Thread.sleep(2000);
			selectDrpDwnByIndex(partyTypeCategoryListdropdown,1);
			Thread.sleep(2000);
			String xpathOfAvailablePartyThemes = "//select[@id='AvailablePartyThemes']/option[contains(text(),"+partyThemeName+")]";
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement AvailablePartyTheme = driver.findElement(By.xpath(xpathOfAvailablePartyThemes));
			waitAndClick(AvailablePartyTheme);
			if(partyThemeName.equals(waitAndGetText(newpartyThemeInpartyThemePage))) {
				result1 = true;
				System.out.println("New party Theme is found");
			}
			if(partyTypeCategoryThemeAddBtn.isEnabled()) {
				waitAndClick(partyTypeCategoryThemeAddBtn);
			}
			waitAndClick(partyTypeCategoryThemeUpdateBtn);
			Thread.sleep(15000);
			confmsg=partyThemeconfirmMsg.getText();
			if(confmsg.equals("Record updated successfully")) {
				result2 = true;		
			}
			if(result1==true && result2==true) {
				System.out.println("Party category theme is added in Selected Party Themes Successfully...................................................................");
				return true;
			}
			
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInPartyTypeCatagoryTheme()");
			return false;
		}
		return true;
	}
	

	//************************************************************************************************
	//*********************Methods to Update the theme in Party Type Category theme Page***********************
	//************************************************************************************************
public String validatePartyTypeCatagoryThemeEffectiveDate(String effectiveDate) throws InterruptedException, AWTException {
	String partyThemeName = "PTC"+getTodaysDateInDay()+getCurrentTimeInSS();
	try {
	
		waitAndClick(partyThemeBtn);
		Thread.sleep(2000);
		partyThemeNameInputBox.sendKeys(partyThemeName);
		partyThemeDescriptionInputBox.sendKeys(partyThemeName);
		waitAndClick(partyThemeIsActiveCheckBox);
		if(effectiveDate=="YES") {
			effectFromInputBox.sendKeys("05/15/2019");
			effectToInputBox.sendKeys("05/15/2020");
		}else if(effectiveDate=="NO") {
			effectFromInputBox.sendKeys("05/15/2019");
			effectToInputBox.sendKeys("05/18/2019");
		}
		scrollDown(driver);
		waitAndClick(selectImagebtn);
		Thread.sleep(3000);
		selectImage.click();
		waitAndClick(partyThemeOkBtn);
		waitAndClick(partyThemeAddBtn);

		List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyThemesList']/option"));
		for(int i=0;i<ele.size();i++)
		{

			if(partyThemeName.equals(ele.get(i).getText())){
				break;
			}
		} 

		waitAndClick(partyTypeCategoryThemeBtn);
		Thread.sleep(2000);
		selectDrpDwnByIndex(partyTypeCategoryListdropdown,1);
		Thread.sleep(2000);
		String xpathOfAvailablePartyThemes = "//select[@id='AvailablePartyThemes']/option[contains(text(),"+partyThemeName+")]";
		Thread.sleep(1000);
		scrollDown(driver);
		WebElement AvailablePartyTheme = driver.findElement(By.xpath(xpathOfAvailablePartyThemes));
		waitAndClick(AvailablePartyTheme);
		if(partyThemeName.equals(waitAndGetText(newpartyThemeInpartyThemePage))) {
			System.out.println("New party Theme is found");
		}
		if(partyTypeCategoryThemeAddBtn.isEnabled()) {
			waitAndClick(partyTypeCategoryThemeAddBtn);
		}
		waitAndClick(partyTypeCategoryThemeUpdateBtn);
		Thread.sleep(15000);
		System.out.println("Party category theme is added in Selected Party Themes Successfully...................................................................");
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Issue with Method: validatePartyTypeCatagoryThemeEffectiveDate()");
		partyThemeName = "Issue with Method: validatePartyTypeCatagoryThemeEffectiveDate()";
	}
	return partyThemeName;
}	

//Party Type Catagory theme
	//************************************************************************************************
	//*********************Methods to Update the theme in Party Type Category theme Page***********************
	//*******************************Updated by Monalisa****************************************
	public String validateUpdateInPartyTypeCatagoryTheme(String effectiveDate) throws InterruptedException, AWTException {
		boolean result1 = false;
		boolean result2 = false;
		String partyThemeName = "PartyTypeCatagoryTheme"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String confmsg=null;
			waitAndClick(partyThemeBtn);
			Thread.sleep(2000);
			partyThemeNameInputBox.sendKeys(partyThemeName);
			partyThemeDescriptionInputBox.sendKeys(partyThemeName);
			waitAndClick(partyThemeIsActiveCheckBox);
			if(effectiveDate=="YES") {
				effectFromInputBox.sendKeys("05/15/2019");
				effectToInputBox.sendKeys("05/15/2020");
			}else if(effectiveDate=="NO") {
				effectFromInputBox.sendKeys("05/15/2019");
				effectToInputBox.sendKeys("05/18/2019");
			}
			scrollDown(driver);
			waitAndClick(selectImagebtn);
			Thread.sleep(3000);
			selectImage.click();
			waitAndClick(partyThemeOkBtn);
			waitAndClick(partyThemeAddBtn);

			List<WebElement> ele = driver.findElements(By.xpath("//select[@id='PartyThemesList']/option"));
			for(int i=0;i<ele.size();i++)
			{

				if(partyThemeName.equals(ele.get(i).getText())){
					result1 = true;
					break;
				}
			} 

			waitAndClick(partyTypeCategoryThemeBtn);
			Thread.sleep(2000);
			selectDrpDwnByIndex(partyTypeCategoryListdropdown,1);
			Thread.sleep(2000);
			String xpathOfAvailablePartyThemes = "//select[@id='AvailablePartyThemes']/option[contains(text(),"+partyThemeName+")]";
			Thread.sleep(1000);
			scrollDown(driver);
			WebElement AvailablePartyTheme = driver.findElement(By.xpath(xpathOfAvailablePartyThemes));
			waitAndClick(AvailablePartyTheme);
			if(partyThemeName.equals(waitAndGetText(newpartyThemeInpartyThemePage))) {
				result2 = true;
				System.out.println("New party Theme is found");
			}
			if(partyTypeCategoryThemeAddBtn.isEnabled()) {
				waitAndClick(partyTypeCategoryThemeAddBtn);
			}
			waitAndClick(partyTypeCategoryThemeUpdateBtn);
			Thread.sleep(15000);
			confmsg=partyThemeconfirmMsg.getText();
			if(confmsg.equals("Record updated successfully")) {
				result1 = true;
				System.out.println("Party category theme is added in Selected Party Themes Successfully...................................................................");
			}
		}catch (Exception e) {
			e.printStackTrace();
			System.out.println("Issue with Method: validateUpdateInPartyTypeCatagoryTheme()");
			
		}
		return partyThemeName;
	}
	
	//************************************************************************************************
	//*********************Methods to validate newly added Theme in Guest information page*************
	//**************************Created by Monalisa*******************************************	
	public boolean validateNewlyAddedTheme(String themeName) throws InterruptedException, AWTException {
		boolean partyStyleDropdownStatus = false;
		boolean result = false;
		try {
		scrollDown(driver);
		partyStyleDropdownStatus=partyStyleDropdown.isEnabled();

		if(partyStyleDropdownStatus==true) {
			System.out.println("Party Style Dropdown is enabled");
			waitAndClick(partyStyleDropdown);
			Thread.sleep(2000);
			List<WebElement> dropdownValue = getDropdownValue(partyStyleDropdown);
			for(WebElement value : dropdownValue) {
				String v = value.getText();
				if(v.equals(themeName)) {
					result =true;
					break;
				} 
			}
			if(result == true) {
				System.out.println("Newly added party theme is visible in partyStyleDropdown");
			} else {
				System.out.println("Newly added party theme is not visible in partyStyleDropdown");
			} 
						
		} else {
				System.out.println("Party Style Dropdown is disabled");
		}		   	
		} catch (Exception e) {
			    e.printStackTrace();
				System.out.println("Issue with Method: validateNewlyAddedTheme()");
		}	
		return result;
	}

}





