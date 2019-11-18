
package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.CallCenterBookAndReviewPage;
import com.cec.qa.pages.CallCenterPromotionAndRewardsPage;
import com.cec.qa.util.TestUtil;


public class CallCenterBookAndReviewAgentTest extends BaseTest{
	CallCenterBookAndReviewPage callCenterBookAndReviewPage;
	CallCenterPromotionAndRewardsPage callCenterPromotionAndRewardsPage;
	public String confNum=null;

	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterBookAndReviewAgentTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));
		callCenterBookAndReviewPage = new CallCenterBookAndReviewPage();
		callCenterPromotionAndRewardsPage = new CallCenterPromotionAndRewardsPage();
	}

	//************************************************************************************************
	//*********************TestUtil - DATE Initialization*********************************************
	//************************************************************************************************

	String storeNumber = TestUtil.tuCallCenterStoreNumber; //StoreNumber assignment from TestUtil

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:266:CallCentre:-Agent: Verify agents should not overbook the party when store get changed.
	//Reviewed by: Aditya on 27/05/2019
	//Test Run: FAIL
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyAgentLoginCC() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 266:CallCentre:-Agent: Verify agents should not overbook the party when store get changed.");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0042"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",3);
	}


	//*******************************************************************************************************************************************
	//Test case:348:CallCentre:-Verify agent is not allowed to do New bookings for current day
	//Reviewed by: Aditya on 27/05/2019
	//Test Run: Dependency: login as Agent in CC
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyAgentNewCurrentDate() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 348:CallCentre:-Verify agent is not allowed to do New bookings for current day");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateNewButton();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		boolean checkResult=callCenterBookAndReviewPage.validateCurrentdayForAgent();
		Assert.assertEquals(checkResult,false,"Current Date is enabled for Agent");
	}

	//*******************************************************************************************************************************************
	//Test case:350:Call Center-:Verify agent is not allowed to change the reservation for current date .
	//Reviewed by: Aditya on 27/05/2019
	//Test Run: Dependency: login as Agent in CC
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyAgentChangeCurrentDate() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 350:Call Center-:Verify agent is not allowed to change the reservation for current date .");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		callCenterBookAndReviewPage.validateChangeButton();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		boolean checkResult=callCenterBookAndReviewPage.validateCurrentdayForAgent();
		Assert.assertEquals(checkResult,false,"Current Date is enabled for Agent");
	}

	//*******************************************************************************************************************************************
	//Test case:428:Call Center : Verify an agent  can not do booking on already booked VIP Party wave
	//Reviewed by: Aditya on 27/05/2019
	//Test Run: Dependency: login as Agent in CC
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyAgentVIPBook() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 428:Call Center : Verify  an agent  can not do booking on already booked VIP Party wave");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateStoreNumber("0845"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("VIPBirthday",0); //0 - 1st time slot ex: 08:00/09:00 AM
		callCenterBookAndReviewPage.validatePackage("Birthday","VIPMegaSuperStar");
		callCenterBookAndReviewPage.validateGuestInformation("Birthday");
		callCenterBookAndReviewPage.validateContactInformation("BirthdayOrOrg");
		String confirmationNumber= callCenterBookAndReviewPage.validateGetConfirmationNumber("BirthdayOrOrg");
		String confNumber = callCenterBookAndReviewPage.validateSearchWithConfNumber(confirmationNumber);
		int confNumberLength = confNumber.length();
		if(confNumberLength==14){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}



	//*******************************************************************************************************************************************
	//Test case:2023:Call Center: Verify that Agent cannot add Discretionary Rewards.
	//Reviewed by: Aditya on 27/05/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test(enabled=true,priority=1)
	public void verifyAgentDiscRewards() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2023:Call Center: Verify that Agent cannot add Discretionary Rewards");
		callCenterBookAndReviewPage.validateRobotLogin();
		callCenterBookAndReviewPage.validateReviewMultipleSearchMenu(storeNumber,"",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		boolean DiscRewards=callCenterBookAndReviewPage.validateDiscRewards();
		Assert.assertEquals(DiscRewards,false,"Disc reward button Available");

	}

	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}


