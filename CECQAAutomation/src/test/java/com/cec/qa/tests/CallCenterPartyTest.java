
package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.CallCenterPartyPage;
import com.cec.qa.pages.CallCenterBookAndReviewPage;

public class CallCenterPartyTest extends BaseTest{
	CallCenterPartyPage callCenterPartyPage;
	CallCenterBookAndReviewPage callCenterBookAndReviewPage;


	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterPartyTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));
		callCenterPartyPage = new CallCenterPartyPage();
		callCenterBookAndReviewPage = new CallCenterBookAndReviewPage();

	}


	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:387	Call Center: Verify  validation message displays when not entered mandatory fields data while adding  Item page.
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMandatoryFields_ItemPage_TCID_387() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 387 Call Center: Verify  validation message displays when not entered mandatory fields data while adding  Item page.");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean errormsg=callCenterPartyPage.validateMandatoryfieldInItemPage();
		Assert.assertTrue(errormsg);
	}

	//*******************************************************************************************************************************************
	//Test case:329	Call center :  Verify functionality and Impact of Add, Reset button from Item Page 
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_ItemPage_TCID_329_A() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 329 Call center : Verify functionality and Impact of Add, Reset button from Item Page ");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInItemPage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:Callcenter: Verify the functionality for Updating Item Page
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdateItem_ItemPage() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Callcenter: Verify the functionality for Updating Item Page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInItemPage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:329	Call center :  Verify functionality and Impact of Add, Reset button from Item Page 
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyResetItem_ItemPage_TCID_329_B() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 329 Call center : Verify functionality and Impact of Add, Reset button from Item Page ");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateResetInItemPage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:2063  Call Center: Verify functionality and impact of in-active Item Page
	//Reviewed by: Aditya on 3/7/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyinActive_ItemPage_TCID_2063() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2063  Call Center: Verify functionality and impact of in-active Item Page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateItemInactiveItemPage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:328	Call center :  Verify the functionality for Adding Item Group
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_ItemGroup_TCID_328() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 328	Call center : Verify the functionality for Adding Item Group");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInItemGroup();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:364	Callcenter: Verify the functionality for Updating Item Group Page
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdateItem_ItemGroup_TCID_364() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 364	Callcenter: Verify the functionality for Updating Item Group Page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInItemGroup();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:366	Call Center: Verify the functionality of Reset for Item Group Page
	//Reviewed by: Aditya on 14/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyResetItem_ItemGroup_TCID_366() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 366	Call Center: Verify the functionality of Reset for Item Group Page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateResetInItemGroup();
		Assert.assertTrue(result);

	}

	//*******************************************************************************************************************************************
	//Test case:423	CallCentre:- Verify the error message getting displayed when user leaves the mandatory field as blank on Party Type Category page
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMandatoryFields_PartyTypeCategory_TCID_423() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 423	CallCentre:- Verify the error message getting displayed when user leaves the mandatory field as blank on Party Type Category page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateMandatoryfieldInPartyTypeCategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:360	CallCentre:- Verify Call Centre Manager Successfully able to Add a new PartyType Category
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAdd_PartyTypeCategory_TCID_360() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 360	CallCentre:- Verify Call Centre Manager Successfully able to Add a new PartyType Category");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInPartyTypeCategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:361	CallCentre:- Verify Call Centre Manager successfully able to Update Party Type Category
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdate_PartyTypeCategory_TCID_361() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 361	CallCentre:- Verify Call Centre Manager successfully able to Update Party Type Category");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInPartyTypeCategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:362	CallCentre:- Verify Call Centre Manager Successfully able to Delete Party Type Category
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyDelete_PartyTypeCategory_TCID_362() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 362	CallCentre:- Verify Call Centre Manager Successfully able to Delete Party Type Category");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateDeleteInPartyTypeCategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:388	CallCentre:- Verify by clicking on "Add" button after entering all the required fields for a Party Type
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMandatoryFields_PartyType_TCID_388() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 388	CallCentre:- Verify by clicking on \"Add\" button after entering all the required fields for a Party Type");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateMandatoryfieldInPartyType();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:424	Call center : Verify user can create Party Type for VIP Party
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS 
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_PartyType_TCID_424() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 424	Call center : Verify user can create Party Type for VIP Party");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInPartyType();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:426	Call Center : Verify the selected party type gets updated after clicking on "Update" button
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdateItem_PartyType_TCID_426() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 426	Call Center : Verify the selected party type gets updated after clicking on \"Update\" button");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInPartyType();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:385	Call Center: Verify Add button functionality of party package page without entering any data.
	//Reviewed by: Aditya on 16/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMandatoryFields_PartyPackage_TCID_385() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 385	Call Center: Verify Add button functionality of party package page without entering any data");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateMandatoryfieldInPartyPackage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:386	Call Center:- Verify Call Center Manager able to create new party package	
	//Reviewed by: Aditya on 16/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_PartyPackage_TCID_386() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 386	Call Center:- Verify Call Center Manager able to create new party package");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInPartyPackage();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:332	Call Center : Verify adding new  Item category which display on Book site.	
	//Reviewed by: Aditya on 15/5/2019 covered :Test case:332	Call Center : Verify adding new  Item category which display on Book site
	//Test Run: PASS 
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_Itemcategory_TCID_332() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 332	Call Center : Verify adding new  Item category which display on Book site.");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInItemcategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:334	Call Center :  Verify user is able to Update Item Category in Callcenter ,Inactive categories should activate on updating.
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS 
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdateItem_Itemcategory_TCID_334() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 334	Call Center :  Verify user is able to Update Item Category in Callcenter ,Inactive categories should activate on updating.");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInItemcategory();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:491	Call Center: Verify Add and Reset button functionality on Party Theme page
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyAddItem_PartyTheme_TCID_491_A() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 491	Call Center: Verify Add and Reset button functionality on Party Theme page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateAddInPartyTheme("YES");
		Assert.assertTrue(result);
	}
	//*******************************************************************************************************************************************
	//Test case:493	Call Center: Verify user successfully update existing party theme
	//Reviewed by: Aditya on 15/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyUpdateItem_PartyTheme_TCID_493() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 493	Call Center: Verify user successfully update existing party theme");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateUpdateInPartyTheme();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:491	Call Center: Verify Add and Reset button functionality on Party Theme page	
	//Reviewed by: Aditya on 16/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyResetItem_PartyTheme_TCID_491_B() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 491	Call Center: Verify Add and Reset button functionality on Party Theme page");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateResetInPartyTheme();
		Assert.assertTrue(result);
	}

	//*******************************************************************************************************************************************
	//Test case:489	Call center: Verify party theme display in call center when the Created/Current date falls in Effective date range .
	//Reviewed by: Aditya on 12/7/2019
	//Test Run:PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyPartyThemeEffectivedate_TCID_489() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 489	Call center: Verify party theme display in call center when the Created/Current date falls in Effective date range ");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		String themeName = callCenterPartyPage.validateUpdateInPartyTypeCatagoryTheme("YES");
		System.out.println("ThemeName : "+themeName);
		callCenterBookAndReviewPage.validateBookMenu();
		callCenterBookAndReviewPage.validateStoreNumber("0033"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",1);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		boolean themeVisibleStatus = callCenterPartyPage.validateNewlyAddedTheme(themeName);
		Assert.assertEquals(themeVisibleStatus, true, "Newly added Party theme is Not found");
	}

	//*******************************************************************************************************************************************
	//Test case:492	Call Center: Verify party theme doesn't display on Call Center when the Created/Current date Doesn't fall in Effective date range .
	//Reviewed by: Aditya on 12/7/2019
		//Test Run:PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyPartyThemeNonEffectivedate_TCID_492() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 492	Call Center: Verify party theme doesn't display on Call Center when the Created/Current date Doesn't fall in Effective date range .");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		String themeName = callCenterPartyPage.validateUpdateInPartyTypeCatagoryTheme("NO");
		System.out.println("ThemeName : "+themeName);
		callCenterBookAndReviewPage.validateBookMenu();
		callCenterBookAndReviewPage.validateStoreNumber("0081"); 
		callCenterBookAndReviewPage.validateSelectChildAdultAndDate("Birthday",1);
		callCenterBookAndReviewPage.validatePackage("Birthday","Star");
		boolean themeVisibleStatus = callCenterPartyPage.validateNewlyAddedTheme(themeName);
		Assert.assertEquals(themeVisibleStatus, false, "Newly added Party theme found");
		 
	}



	//*******************************************************************************************************************************************
	//Test case:365	Call Center/Booksite: Verify user is able to activate or deactivate Item group & changes made reflect on Book site & Callcenter
	//Reviewed by: Aditya on 22/5/2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyactivate_deactivate_ItemGroup_TCID_365() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 365	Call Center/Booksite: Verify user is able to activate or deactivate Item group & changes made reflect on Book site & Callcenter");
		callCenterPartyPage.RobotLogin();
		callCenterPartyPage.validatePartyMenu();
		boolean result=callCenterPartyPage.validateItemGroupInactive();
		Assert.assertTrue(result);
	}

	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}











