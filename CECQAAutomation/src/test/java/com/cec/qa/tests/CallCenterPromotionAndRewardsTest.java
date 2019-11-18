package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;

import com.cec.qa.pages.CallCenterPromotionAndRewardsPage;



public class CallCenterPromotionAndRewardsTest extends BaseTest{
	CallCenterPromotionAndRewardsPage callCenterPromotionAndRewardsPage;



	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterPromotionAndRewardsTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));

		callCenterPromotionAndRewardsPage = new CallCenterPromotionAndRewardsPage();

	}


	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************


	//*******************************************************************************************************************************************
	//Test case:425:Call center : Verify Promotion (Add) configured for Group Level and Interceptor Category- Optional Party Item. 
	//Reviewed by: Aditya on 28/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddPromotionForGroupLevel_TCID_425() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 425:Call center : Verify Promotion (Add) configured for Group Level and Interceptor Category- Optional Party Item. ");
		callCenterPromotionAndRewardsPage.RobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		boolean result=callCenterPromotionAndRewardsPage.validateNewPromotion("21",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0));
		Assert.assertTrue(result);
		callCenterPromotionAndRewardsPage.validatePromotionDelete();
	}

	//*******************************************************************************************************************************************
	//Test case:2027:	Call Center: Verify Call Center Manager successfully configure a new Discretionary Reward
	//Reviewed by: Aditya on 28/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCreateDiscReward_TCID_2027() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2027:	Call Center: Verify Call Center Manager successfully configure a new Discretionary Reward ");
		callCenterPromotionAndRewardsPage.RobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		boolean result=callCenterPromotionAndRewardsPage.validateNewReward(2,1,1); //Discretionary,Birthday,Call center
		//1-rewardType: 0-Automatic,1-Activity,2-Discretionary;//2-Reservation type: 0-Both,1-Birthday,2-Organization;//3-Client app:0-Both,1-Call center,2-Booksite
		Assert.assertTrue(result, "Reward is not created");
	}

	//*******************************************************************************************************************************************
	//Test case:276	Call Center: Rewards: Verify user is able to create a new Reward and save it using Save button
	//Reviewed by: Aditya on 28/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCreateAutomaticReward_TCID_276() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 276	Call Center: Rewards: Verify user is able to create a new Reward and save it using Save button ");
		callCenterPromotionAndRewardsPage.RobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		boolean result=callCenterPromotionAndRewardsPage.validateNewReward(0,0,1); //Automatic,Both,Call center
		//1-rewardType: 0-Automatic,1-Activity,2-Discretionary;//2-Reservation type: 0-Both,1-Birthday,2-Organization;//3-Client app:0-Both,1-Call center,2-Booksite
		Assert.assertTrue(result, "Reward is not created");
	}

	//*******************************************************************************************************************************************
	//Test case:278	Call Center: Verify Reward configured for only Organisation displays on Call Center
	//Reviewed by: Aditya on 28/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCreateAutomaticRewardForOrg_TCID_278() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 278	Call Center: Verify Reward configured for only Organisation displays on Call Center ");
		callCenterPromotionAndRewardsPage.RobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		boolean result=callCenterPromotionAndRewardsPage.validateNewReward(0,2,1); //Automatic,Organization,Call center
		//1-rewardType: 0-Automatic,1-Activity,2-Discretionary;//2-Reservation type: 0-Both,1-Birthday,2-Organization;//3-Client app:0-Both,1-Call center,2-Booksite
		Assert.assertTrue(result, "Reward is not created");
	}

	//*******************************************************************************************************************************************
	//Test case:280:Call Center: Verify Reward configure for All Reservation Type displaying correctly on Birthday/Organisation on Call center and Book site.
	//Reviewed by: Aditya on 28/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCreateAutomaticRewardAllResvType_TCID_280() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 280:Call Center: Verify Reward configure for All Reservation Type displaying correctly on Birthday/Organisation on Call center and Book site. ");
		callCenterPromotionAndRewardsPage.RobotLogin();
		callCenterPromotionAndRewardsPage.validateSelectPromotionMenu();
		callCenterPromotionAndRewardsPage.validateSelectRewardMenu();
		boolean result=callCenterPromotionAndRewardsPage.validateNewReward(0,0,0); //Automatic,Both,Both
		//1-rewardType: 0-Automatic,1-Activity,2-Discretionary;//2-Reservation type: 0-Both,1-Birthday,2-Organization;//3-Client app:0-Both,1-Call center,2-Booksite
		Assert.assertTrue(result, "Reward is not created");
	}


	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}











