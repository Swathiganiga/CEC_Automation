package com.cec.qa.tests;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;
import java.awt.event.KeyEvent;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.RVAdminPage;
import com.cec.qa.pages.StoreAppPage;
import com.cec.qa.util.TestUtil;

public class RVAdminTest extends BaseTest{

	public RVAdminPage rVAdminPage;
	
	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public RVAdminTest() {
		super();
	}
	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		System.out.println("@BeforeMethod Start................................................!!!");
		initialization(propv.getProperty("GUI"),propv.getProperty("RVA"));
		rVAdminPage = new RVAdminPage();
		System.out.println("@BeforeMethod End..................................................!!!");
	}

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************
	
	//************************************************************************************************
	//Verify the Title of the RV Admin Website.
	//Test Run: Pass
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyTitleOfTheRVAdmin() throws InterruptedException, IOException, AWTException
	{
		System.out.println("------>>>Verify the Title of the RV Admin Website.");
		String rvTitle = rVAdminPage.validateLoginToRVAdmin();
		System.out.println("Actual Result:"+rvTitle+"  Expected Result:CEC Reservation Admin - Reservation Admin");
		Assert.assertEquals(rvTitle, "CEC Reservation Admin - Reservation Admin","RV Admin Title Mismatch");
	}
	//************************************************************************************************
	//Test case: 2073 Admin-Report-Verify that Party Date -(in Item Group Report) range Search is working.
	//Created and Reviewed By: Vishnu on 21-Mar-2019
	//Test Run: Pass
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyItemGroupReportSearch() throws InterruptedException, IOException, AWTException
	{
		System.out.println("------>>>2073 Admin-Report-Verify that Party Date -(in Item Group Report) range Search is working.");
		rVAdminPage.validateLoginToRVAdmin();
		Thread.sleep(10000);
		rVAdminPage.validateReportingMenuSelect("Item Group Report");// Enter Menu Option: "Item Group Report" or "Item Groups"
		Thread.sleep(5000);
		String searchResult = rVAdminPage.validateDateEntry(getFutureDateInMMDDYYYY(-1), getFutureDateInMMDDYYYY(0));
		System.out.println("Actual Result:"+searchResult+"  Expected Result:Should Be Not NULL");
		if(!searchResult.equals("")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
	}
	//************************************************************************************************
	//Test case: 2082 Admin:Reporting Groups- Verify user successfully edit the Item groups and save the changes made for Item Group
	//Created and Reviewed By: Vishnu on 22-Mar-2019
	//Test Run: Pass
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyItemGroupEditAndSave() throws InterruptedException, IOException, AWTException
	{
		System.out.println("------>>>2082 Admin:Reporting Groups- Verify user successfully edit the Item groups and save the changes made for Item Group");
		rVAdminPage.validateLoginToRVAdmin();
		Thread.sleep(10000);
		rVAdminPage.validateReportingMenuSelect("Item Groups");// Enter Menu Option: "Item Group Report" or "Item Groups"
		Thread.sleep(5000);
		String result = rVAdminPage.validateItemGroupEdit();
		System.out.println("Actual Result:"+result+"  Expected Result:Should Be Not NULL and Should be a Updated Group Name");
		if(!result.equals("Found Issue in Updating Item Group")){
			Assert.assertTrue(true);
		}else{
			Assert.assertTrue(false);
		}
		
	}
	//************************************************************************************************
	//Test case: 2083 Admin:Reporting Groups-Verify the changes made on Admin Item Reporting Groups are getting reflected correctly on Store App Item Report page  
	//Created and Reviewed By: Vishnu on 22-Mar-2019
	//Test Run: Pass
	//************************************************************************************************
	@Test(enabled=true)
	public void verifyItemGroupUpdateReflectInStoreAppItemReportPage() throws InterruptedException, IOException, AWTException
	{
		System.out.println("------>>>2083 Admin:Reporting Groups-Verify the changes made on Admin Item Reporting Groups are getting reflected correctly on Store App Item Report page ");
		rVAdminPage.validateLoginToRVAdmin();
		Thread.sleep(10000);
		rVAdminPage.validateReportingMenuSelect("Item Groups");// Enter Menu Option: "Item Group Report" or "Item Groups"
		Thread.sleep(5000);
		String rvAdminResult = rVAdminPage.validateItemGroupEdit();
		String saSearchResult = rVAdminPage.validateSpecificItemSearch(rvAdminResult); //SEARCH IN STOREAPP
		System.out.println("Actual Result:"+rvAdminResult+"  Expected Result:"+saSearchResult);
		Assert.assertEquals(rvAdminResult, saSearchResult,"Item Value Mismatch");
	}
	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************	
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}
	
}
