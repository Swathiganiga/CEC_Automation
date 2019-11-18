package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.CallCenterBookAndReviewPage;
import com.cec.qa.pages.CallCenterReportsPage;
import com.cec.qa.pages.CallCenterRestaurantPage;
import com.cec.qa.util.TestUtil;


public class CallCenterReportsTest extends BaseTest{
	CallCenterBookAndReviewPage callCenterBookAndReviewPage;
	CallCenterReportsPage callCenterReportsPage;


	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterReportsTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));
		callCenterReportsPage = new CallCenterReportsPage();
	}

	//************************************************************************************************
	//*********************TestUtil - StoreNum/Name Initialization(By Date/Day)***********************
	//************************************************************************************************
	String storeNumber= TestUtil.storeNumber;
	String mgrName = TestUtil.mgrName;

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************


	//**********************************************************************************************************************************
	//Test case:303 Call Center : Verify VIP Party Report in Call Center Reports.
	//Created and Reviewed by: Aditya on 18-June-2019
	//Test Run: PASS
	//**********************************************************************************************************************************
	@Test
	public void verifyVIPPartyReportSearchResult_TCID_303() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 303 Call Center : Verify VIP Party Report in Call Center Reports.");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("VIP Party Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		boolean searchResult = callCenterReportsPage.validateSearchResultInVIPPartyPage();
	Assert.assertTrue(searchResult);
	}

	//***********************************************************************************************************************************
	//Test case:412	Call Center : Verify that  Fundraiser - Booked Yesterday Report is generated when "School" is selected
	//Created and Reviewed by: Aditya on 19-June-2019
	//Test Run: PASS
	//***********************************************************************************************************************************
	@Test
	public void verifyBookYdaySchoolReportSearchResult_TCID_412() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 412	Call Center : Verify that  Fundraiser - Booked Yesterday Report is generated when School is selected");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("Book YesterDay Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"School");
		boolean searchResult = callCenterReportsPage.validateSearchResultInBookYdayPage();
	Assert.assertTrue(searchResult);
	}

	//*******************************************************************************************************************************************
	//Test case:413 Call Center : Verify that  Fundraiser - Booked Yesterday Report is generated when "Non-Profit" is selected
	//Created and Reviewed by: Aditya on 19-June-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyBookYdayNonProfitReportSearchResult_TCID_413() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 413 Call Center : Verify that  Fundraiser - Booked Yesterday Report is generated when Non-Profit is selected");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("Book YesterDay Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"NonProfit");
		boolean searchResult = callCenterReportsPage.validateSearchResultInBookYdayPage();
		Assert.assertTrue(searchResult);
		}

	//*******************************************************************************************************************************************
	//Test case:414	Call Center : Verify that Fundraiser - Yesterday's Parties Report is generated when "Non-Profit" is selected.
	//Created and Reviewed by: Aditya on 19-June-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyYdayPartyNonProfitReportSearchResult_TCID_414() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 414	Call Center : Verify that Fundraiser - Yesterday's Parties Report is generated when Non-Profit is selected.");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("Yesterday Party Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"NonProfit");
		boolean searchResult = callCenterReportsPage.validateSearchResultInYdayPartyPage();
		Assert.assertTrue(searchResult);
	}

	//*******************************************************************************************************************************************
	//Test case:415 Call Center : Verify that the Fund Raiser Daily Mailout Report is generated for a given confirmation number.
	//Created and Reviewed by: Aditya on 19-June-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyDailyMailoutReportSearchResult_TCID_415() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 415 Call Center : Verify that the Fund Raiser Daily Mailout Report is generated for a given confirmation number.");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("Daily MailOut Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"School");
		boolean searchResult = callCenterReportsPage.validateSearchResultInDailyMailoutPage();
		Assert.assertTrue(searchResult);
	}

	//*******************************************************************************************************************************************
	//Test case:422	CallCentre:-Verify CEC Stats Reports should get generated for the given Date Range
	//Created and Reviewed by: Aditya on 18-June-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCECStatsReportSearchResult_TCID_422() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 422	CallCentre:-Verify CEC Stats Reports should get generated for the given Date Range");
		callCenterReportsPage.validateRobotLogin();
		callCenterReportsPage.validateSelectReportMenu("CEC Stats Report",getFutureDateInMMDDYYYY(-30), getFutureDateInMMDDYYYY(0),"");
		boolean searchResult = callCenterReportsPage.validateSearchResultInCECStatsPage();
	Assert.assertTrue(searchResult);
	}


	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
}

