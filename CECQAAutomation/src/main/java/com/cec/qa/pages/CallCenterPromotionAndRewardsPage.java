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


public class CallCenterPromotionAndRewardsPage extends BaseTest{

	public  final static String currentPropDir = System.getProperty("user.dir");

	static String IEdriverPath = currentPropDir + "\\src\\main\\drivers\\IEDriverServer_Win32_3.14.0\\IEDriverServer.exe";

	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//	 					CALL CENTER LOCATORS START	
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$
	//$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$

	//******************************Main Menu **************************************************

	@FindBy(xpath="//a[@title='Promotion / Reward']")
	WebElement promotionMenuLnk;

	//******************************Promotion Menus **************************************************
	@FindBy(xpath="//a[@title='Search']")
	WebElement searchMenuLnk;

	@FindBy(xpath="//a[@title='New']")
	WebElement newMenuLnk;

	@FindBy(xpath="//a[@title='Reward']")
	WebElement rewardsMenuLnk;

	//New - Promotion

	@FindBy(xpath="//select[@id='ListStoreGroupsIncludeAvailable']/option")
	List<WebElement> selectGroupInPromo;

	@FindBy(id="addStoreGroupsInclude")
	WebElement groupAddBtnInPromo;

	@FindBy(id="Name")
	WebElement promotionName;

	@FindBy(id="Title")
	WebElement promotionTitle;

	@FindBy(id="Description")
	WebElement promotionDescription;

	@FindBy(id="Priority")
	WebElement promotionPriority;

	@FindBy(id="StartDate")
	WebElement promotionStartDate;

	@FindBy(id="EndDate")
	WebElement promotionEndDate;

	@FindBy(id="selImageAN")
	WebElement promotionSelectImage;

	@FindBy(xpath="//div[@id='addActImgAN']/div/div[1]")
	WebElement promotionPickImage;

	@FindBy(id="okClickAN")
	WebElement promotionOkbtn;

	@FindBy(id="btnSave")
	WebElement saveBtn;

	@FindBy(id="btnReset")
	WebElement resetBtn;

	@FindBy(id="InterceptorLinkedId")
	WebElement interceptorLinkeddrpdown;

	@FindBy(id="InterceptorCategoryType_2")
	WebElement InterceptorCategoryTyperadioBtn;

	@FindBy(id="ItemToAddInCartId")
	WebElement ItemToAddInCartIdDrpdown;

	@FindBy(id="ItemToAddQuantity")
	WebElement ItemToAddQuantityDrpdown;

	@FindBy(id="errorMsg")
	WebElement promoConfirmMsg;


	//Search - Promotion
	@FindBy(id="txtName")
	WebElement promotionNameSearch;

	@FindBy(id="btnSearch")
	WebElement promotionSearch;

	@FindBy(id="btnReset")
	WebElement promotionReset;

	@FindBy(xpath="//table/tbody/tr/td[4]")
	WebElement promotionNameInTable;

	@FindBy(id="delete")
	WebElement promoDelete;
	
	
	@FindBy(xpath="//button[@class='btn btn-primary']")
	WebElement promoDeleteOkBtn;
	
	//New - Rewards

	//	@FindBy(xpath="//a[@title='Create New Reward']")
	//	WebElement CreateNewRewardLnk;

	@FindBy(partialLinkText="Create New Reward")
	WebElement createNewRewardLnk;


	@FindBy(id="reward_RewardName")
	WebElement reward_RewardName;

	@FindBy(id="reward_RewardTitle")
	WebElement reward_RewardTitle;

	@FindBy(id="reward_RewardDescription")
	WebElement reward_RewardDescription;

	@FindBy(id="reward_OptionalPartyItemID")
	WebElement reward_OptionalPartyItemID;

	@FindBy(id="reward_DisplaySequence")
	WebElement reward_DisplaySequence;

	@FindBy(id="reward_ActiveStartOn")
	WebElement reward_ActiveStartOn;

	@FindBy(id="reward_ActiveEndOn")
	WebElement reward_ActiveEndOn;

	@FindBy(name="reward.RewardTypeId")
	List<WebElement> reward_RewardType;

	@FindBy(name="reward.EligibleReservationTypeID")
	List<WebElement> reward_ReservationType;

	@FindBy(name="reward.EligibleReservationApplication")
	List<WebElement> reward_Clientapp;

	@FindBy(id="reward_EligibleStartOn")
	WebElement reward_EligibleStartOn;

	@FindBy(id="reward_EligibleEndOn")
	WebElement reward_EligibleEndOn;

	@FindBy(id="btnSave")
	WebElement reward_SaveBtn;

	@FindBy(id="btnReset")
	WebElement reward_ResetBtn;

	@FindBy(xpath="//select[@id='GroupExclude']/option[5]")
	List<WebElement> selectGroupInReward;

	@FindBy(id="addStoreGroups")
	WebElement groupAddBtnInReward;

	@FindBy(id="addStoreGroups")
	WebElement rewardNameInTable;


	//Not required

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



	@FindBy(xpath = "//input[@value='Delete']")
	WebElement storeFinalDeleteBtn;

	//************************************************************************************************
	//********************* ALL LOCATORS Initialization***********************************************
	//************************************************************************************************
	public CallCenterPromotionAndRewardsPage(){
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
			StringSelection pwd = new StringSelection(propv.getProperty("April@123"));
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
			Thread.sleep(7000);
			//explicitWaitXpathTillVisible(driver, "//legend[contains(text(),'Store Information')]");
		} catch (Exception ex) {
			System.out.println("Error in Login Thread: " + ex.getMessage());
			ex.printStackTrace();
		}
		return IEdriverPath;
	}


	//****************************************************************************************************
	//*********************Methods to validate Promotion Menu  ******************************************
	//****************************************************************************************************
	public boolean validateSelectPromotionMenu() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(promotionMenuLnk);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateSelectPromotionMenu()");
			result = false;
		}
		return result;
	}
	//****************************************************************************************************
	//*********************Methods to validateClickOnNewMenu**********************************************
	//****************************************************************************************************

	public boolean validateCreateNewPromotion() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(newMenuLnk);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateClickOnNewPromotionMenu()");
			result = false;
		}
		return result;
	}

	//****************************************************************************************************
	//*********************Methods to validate New Promotion Creation*********************************
	//****************************************************************************************************

	public boolean validateNewPromotion(String promoPriority,String promoStartDate,String promoEndDate) throws IOException {
		boolean result1=false;
		boolean result2=false;	
		String promoName = "Promo"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			String promoConfMsg=null;
			selectLastElement(selectGroupInPromo);
			Thread.sleep(2000);
			waitAndClick(groupAddBtnInPromo);
			promotionName.sendKeys(promoName);
			promotionTitle.sendKeys(promoName);
			promotionDescription.sendKeys(promoName);
			promotionPriority.sendKeys(promoPriority);
			promotionStartDate.sendKeys(promoStartDate);
			promotionEndDate.sendKeys(promoEndDate);
			selectDrpDwnByIndex(interceptorLinkeddrpdown,1);
			selectDrpDwnByIndex(ItemToAddInCartIdDrpdown,1);
			selectDrpDwnByIndex(ItemToAddQuantityDrpdown,1);
			Thread.sleep(2000);
			waitAndClick(promotionSelectImage);
			Thread.sleep(2000);
			Thread.sleep(2000);
			waitAndClick(promotionPickImage);
			Thread.sleep(5000);
			waitAndClick(promotionOkbtn);
			Thread.sleep(2000);
			waitAndClick(saveBtn);
			promoConfMsg=waitAndGetText(promoConfirmMsg);
			if(promoConfMsg.equals("Record saved successfully")){
				result1 = true;
			}else{
				result1 = false;
			}
			waitAndClick(searchMenuLnk);	
			Thread.sleep(2000);
			promotionNameSearch.sendKeys(promoName);
			waitAndClick(promotionSearch);
			if(promoName.equals(waitAndGetText(promotionNameInTable))){
				result2 = true;
			}else{
				result2 = false;
			}
			if(result1 && result2) {
				System.out.println("Promotion is created and displayed in search result Successfully...................................................................");
				return true;
			}else {
				return false;
			}
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateNewPromotion()");
			return false;
		}
	
	}

	//****************************************************************************************************
	//*********************Methods to validate Promotion Search ************************************************
	//****************************************************************************************************

	public void validatePromotionDelete() throws IOException, InterruptedException {
		try {
		waitAndClick(promoDelete);
		Thread.sleep(1000);
		waitAndClick(promoDeleteOkBtn);
	/*	boolean result1 = false;
		String promoName = "Promo"+getTodaysDateInDay()+getCurrentTimeInSS();
		
			promotionNameSearch.sendKeys(promoName);
			waitAndClick(promotionSearch);
			if(promoName.equals(promotionNameInTable.getText())){
				promoDelete.click();
				result1 = true;
			}else{
				result1 = false;
			}
*/
		} catch (Exception e) {
			System.out.println("Found Issue with method: validatePromotionDelete()");
			e.printStackTrace();
		}

	}

	//****************************************************************************************************
	//*********************Methods to validate Promotion Menu  ******************************************
	//****************************************************************************************************
	public boolean validateSelectRewardMenu() throws IOException {
		boolean result = false;	
		try {
			waitAndClick(rewardsMenuLnk);
			result = true;
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateSelectRewardMenu()");
			result = false;
		}
		return result;
	}
	//****************************************************************************************************
	//*********************Methods to validate New Reward Creation*********************************
	//****************************************************************************************************


	public boolean validateNewReward(int rewardType,int reservationType,int clientapp) throws IOException {
		boolean result = false;	
		String rewardName = "Reward"+getTodaysDateInDay()+getCurrentTimeInSS();
		try {
			waitAndClick(createNewRewardLnk);
			Thread.sleep(5000);
			reward_RewardName.sendKeys(rewardName);
			reward_RewardTitle.sendKeys(rewardName);
			reward_RewardDescription.sendKeys(rewardName);
			selectDrpDwnByIndex(reward_OptionalPartyItemID,2);
			selectRdoBtn(reward_RewardType,rewardType);
			Thread.sleep(2000);
			selectRdoBtn(reward_ReservationType,reservationType);
			Thread.sleep(2000);
			selectRdoBtn(reward_Clientapp,clientapp);
			/*reward_DisplaySequence.sendKeys(displaySeq);
				reward_ActiveStartOn.sendKeys(rewardActiveStartOn);
				reward_ActiveEndOn.sendKeys(rewardActiveEndOn);

				reward_EligibleStartOn.sendKeys(rewardEligibleStartOn);
				reward_EligibleEndOn.sendKeys(rewardEligibleEndOn);*/

			Thread.sleep(2000);
			waitAndClick(promotionSelectImage);
			Thread.sleep(5000);
			waitAndClick(promotionPickImage);
			Thread.sleep(5000);
			waitAndClick(promotionOkbtn);
			Thread.sleep(4000);

			selectLastElement(selectGroupInReward);
			waitAndClick(groupAddBtnInReward);
			waitAndClick(reward_SaveBtn);
			Thread.sleep(2000);
			String xPathForRewardName = "//tbody/tr/td[contains(text(),'"+rewardName+"')]";
			WebElement ele = driver.findElement(By.xpath(xPathForRewardName));		

			if(rewardName.equals(ele.getText())){
				System.out.println("Reward is created successfully");
				result = true;
			}else{
				System.out.println("Reward is not created");
				result = false;
			}

		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Found Issue with Method: validateNewReward()");
		}
		return result;
	}


	 //****************************************************************************************************
		//*********************Methods to validate New Reward Creation****************************************
		//****************************Created bY monalisa*****************************************************
		public String validateAddNewReward(int rewardType,int reservationType,int clientapp) throws IOException {
				boolean result = false;	
				String rewardName = "Reward"+getTodaysDateInDay()+getCurrentTimeInSS();
				try {
					waitAndClick(createNewRewardLnk);
					Thread.sleep(5000);
					reward_RewardName.sendKeys(rewardName);
					reward_RewardTitle.sendKeys(rewardName);
					reward_RewardDescription.sendKeys(rewardName);
					selectDrpDwnByIndex(reward_OptionalPartyItemID,2);
					selectRdoBtn(reward_RewardType,rewardType);
					Thread.sleep(2000);
					selectRdoBtn(reward_ReservationType,reservationType);
					Thread.sleep(2000);
					selectRdoBtn(reward_Clientapp,clientapp);
					
					
					
					/*reward_DisplaySequence.sendKeys(displaySeq);
					reward_ActiveStartOn.sendKeys(rewardActiveStartOn);
					reward_ActiveEndOn.sendKeys(rewardActiveEndOn);

					reward_EligibleStartOn.sendKeys(rewardEligibleStartOn);
					reward_EligibleEndOn.sendKeys(rewardEligibleEndOn);*/

					Thread.sleep(2000);
					waitAndClick(promotionSelectImage);
					Thread.sleep(4000);
					waitAndClick(promotionPickImage);
					Thread.sleep(5000);
					waitAndClick(promotionOkbtn);
					Thread.sleep(4000);
					selectLastElement(selectGroupInReward);
					//waitAndClick(groupAddBtnInReward);
					waitAndClick(reward_SaveBtn);
					Thread.sleep(2000);
					String xPathForRewardName = "//tbody/tr/td[contains(text(),'"+rewardName+"')]";
					WebElement ele = driver.findElement(By.xpath(xPathForRewardName));		

					if(rewardName.equals(ele.getText())){
						System.out.println("Reward is created successfully");
						result = true;
					}else{
						System.out.println("Reward is not created");
						result = false;
					}

				}catch(Exception e){
					e.printStackTrace();
					System.err.println("Found Issue with Method: validateNewReward()");
				}
				if(result==true) {
					return rewardName;
				} else {
					return "Reward is not created";
				}
			}


	}

	






