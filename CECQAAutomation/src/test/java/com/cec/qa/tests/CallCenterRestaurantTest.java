package com.cec.qa.tests;
import java.awt.AWTException;
import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.CallCenterBookAndReviewPage;
import com.cec.qa.pages.CallCenterRestaurantPage;
import com.cec.qa.util.TestUtil;


public class CallCenterRestaurantTest extends BaseTest{
	CallCenterBookAndReviewPage callCenterBookAndReviewPage;
	CallCenterRestaurantPage callCenterRestaurantPage;


	//************************************************************************************************
	//*********************Constructor - Initialization***********************************************
	//************************************************************************************************
	public CallCenterRestaurantTest() {
		super();
	}

	//************************************************************************************************
	//*********************@BeforeMethod**************************************************************
	//************************************************************************************************
	@BeforeMethod
	public void setUp() throws Exception {
		initialization("IE",propv.getProperty("CCR"));
		callCenterRestaurantPage = new CallCenterRestaurantPage();
		callCenterBookAndReviewPage = new CallCenterBookAndReviewPage();
	}

	//************************************************************************************************
	//*********************TestUtil - StoreNum/Name Initialization(By Date/Day)***********************
	//************************************************************************************************
	String storeNumber= TestUtil.storeNumber;
	String mgrName = TestUtil.mgrName;

	//************************************************************************************************
	//********************* TEST CASES ***************************************************************
	//************************************************************************************************

	//*******************************************************************************************************************************************
	//Test case:384	CallCentre:-Verify with valid basic restaurant information data saves properly
	//Created and Reviewed by: Vishnu on 07-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyCreateNewRestaurant_TCID_384() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 384	CallCentre:-Verify with valid basic restaurant information data saves properly");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnNewMenu();
		String result = callCenterRestaurantPage.validateNewRestaurantRecordCreation(storeNumber,"BENGALURU"+storeNumber,"BENGALURU"+storeNumber,"KA",storeNumber+"1",storeNumber+" BSK 1st BENGALURU",mgrName);
		Assert.assertEquals(result, "Restaurant information saved successfully.","Mismatch in New Store Creation");
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateStoreDeleteByStoreNumber(storeNumber);
	}
	//*******************************************************************************************************************************************
	//Test case: 394	Call Center :Verify that manager can search store by Store Number, Store name, City, State, Zip, Address and Manager name
	//Created and Reviewed by: Vishnu on 10-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifySearchRestaurantByAllDataPoints_TCID_394() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 394	Call Center :Verify that manager can search store by Store Number, Store name, City, State, Zip, Address and Manager name");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnNewMenu();
		callCenterRestaurantPage.validateNewRestaurantRecordCreation(storeNumber,"BENGALURU"+storeNumber,"BENGALURU"+storeNumber,"KA",storeNumber+"1",storeNumber+" BSK 1st BENGALURU",mgrName);
		boolean result = callCenterRestaurantPage.validateStoreSearch(storeNumber,"BENGALURU"+storeNumber,"BENGALURU"+storeNumber,"KA",storeNumber+"1",storeNumber+" BSK 1st BENGALURU",mgrName);
		Assert.assertEquals(result, true,"Mismatch in Store Search");
		//callCenterRestaurantPage.validateSelectRestaurantMenu();
		//callCenterRestaurantPage.validateStoreDeleteByStoreNumber(storeNumber);
	}
	//*******************************************************************************************************************************************
	//Test case: Delete Store by StoreNumber
	//Created and Reviewed by: Vishnu on 10-May-2019
	//Test Run: PASS
	//Note: This test case should call at last, if added new cases, need to update priority accordingly.
	//*******************************************************************************************************************************************
	@Test(enabled=false)
	public void verifyDeleteStore() throws InterruptedException, AWTException, IOException {
		System.out.println("----> Delete Store by StoreNumber");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		String successMessage = callCenterRestaurantPage.validateStoreDeleteByStoreNumber(storeNumber);
		Assert.assertEquals(successMessage,"Record is deleted successfully.","Mismatch in Store Delete");
	}

	//*******************************************************************************************************************************************
	//Test case:2754	Call Center: Restaurant : Verify that store details pre-populate on editing and new changes are saved.
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyEditRestaurant_TCID_2754() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 2754	Call Center: Restaurant : Verify that store details pre-populate on editing and new changes are saved.");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnNewMenu();
		callCenterRestaurantPage.validateNewRestaurantRecordCreation(storeNumber,"BENGALURU"+storeNumber,"BENGALURU"+storeNumber,"KA",storeNumber+"1",storeNumber+" BSK 1st BENGALURU",mgrName);
		boolean result = callCenterRestaurantPage.editStoreWithStoreNum(storeNumber,storeNumber+" BSK edited BENGALURU");
		Assert.assertEquals(result, true,"Unable to edit store");
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateStoreDeleteByStoreNumber(storeNumber);
	}

	//*******************************************************************************************************************************************
	//Test case:431	Call center : Verify that minimum children validations are triggered on wave selection
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMinChidrenWhileBooking_TCID_431() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 431	Call center : Verify that minimum children validations are triggered on wave selection");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		callCenterRestaurantPage.validateSetupMinimumChildren("store",1);
		callCenterBookAndReviewPage.validateBookMenu();
		callCenterBookAndReviewPage.validateStoreNumber("0032"); 
		String result=callCenterBookAndReviewPage.validateMinimumChildError("Birthday",0);
		Assert.assertEquals(result, "This wave has a minimum children requirement which is more than the number of children entered by you. If you wish to select this wave, number of children will be raised to 15.","Mismatch in Minimum children Creation");
	}


	//*******************************************************************************************************************************************
	//Test case:432	Call Center :Verify that user is able to setup min children at Global level and the pop up displays on Call Center & Book site when number is less than the configured count.
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMinChidrenGlobalLevel_TCID_432() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 432	Call Center :Verify that user is able to setup min children at Global level and the pop up displays on Call Center & Book site when number is less than the configured count.");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		String result = callCenterRestaurantPage.validateSetupMinimumChildren("global",1);
		Assert.assertEquals(result, "Record saved successfully","Mismatch in Minimum children Creation");
		callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("global");
	}

	//*******************************************************************************************************************************************
	//Test case:433	Call Center :Verify that user is able to setup min children at Group level and the pop up displays on Call Center & Book site when number is less than the configured count.
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMinChidrenGroupLevel_TCID_433() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 433	Call Center :Verify that user is able to setup min children at Group level and the pop up displays on Call Center & Book site when number is less than the configured count.");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		String result = callCenterRestaurantPage.validateSetupMinimumChildren("group",0);
		Assert.assertEquals(result, "Record saved successfully","Mismatch in Minimum children Creation");
		callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("group");
	}

	//*******************************************************************************************************************************************
	//Test case:434	Call Center :Verify that user is able to setup min children at Store level and the pop up displays on Call Center & Book site when number is less than the configured count.
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyMinChidreStoreLevel_TCID_434() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 434	Call Center :Verify that user is able to setup min children at Store level and the pop up displays on Call Center & Book site when number is less than the configured count.");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		String result = callCenterRestaurantPage.validateSetupMinimumChildren("store",2);
		Assert.assertEquals(result, "Record saved successfully","Mismatch in Minimum children Creation");
		callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("store");
	}

	//*******************************************************************************************************************************************
	//Test case:435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyDeleteMinChidrenGlobalLevel_TCID_435_A() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		callCenterRestaurantPage.validateSetupMinimumChildren("global",1);
		String result = callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("global");
		Assert.assertEquals(result, "Record deleted successfully","Mismatch in Minimum children Creation");
	}

	//*******************************************************************************************************************************************
	//Test case:435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyDeleteMinChidrenGroupLevel_TCID_435_B() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		callCenterRestaurantPage.validateSetupMinimumChildren("group",0);
		String result = callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("group");
		Assert.assertEquals(result, "Record deleted successfully","Mismatch in Minimum children Creation");
	}

	//*******************************************************************************************************************************************
	//Test case:435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level
	//Created and Reviewed by: Aditya on 29-May-2019
	//Test Run: PASS
	//*******************************************************************************************************************************************
	@Test
	public void verifyDeleteMinChidrenStoreLevel_TCID_435_C() throws InterruptedException, AWTException, IOException {
		System.out.println("----> 435	Call Center : Min Children Setup:Verify Delete is working at Store, Group and Global Level");
		callCenterRestaurantPage.RobotLogin();
		callCenterRestaurantPage.validateSelectRestaurantMenu();
		callCenterRestaurantPage.validateClickOnMinChildMenu();
		callCenterRestaurantPage.validateSetupMinimumChildren("store",2);
		String result = callCenterRestaurantPage.validateDeleteMinimumChildrenSetup("store");
		Assert.assertEquals(result, "Record deleted successfully","Mismatch in Minimum children Creation");
	}

	//************************************************************************************************
	//*********************@AfterMethod***************************************************************
	//************************************************************************************************		
	@AfterMethod
	public void tearDown() {
		driver.quit();
	}

}

