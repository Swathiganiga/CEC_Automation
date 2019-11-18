package com.cec.qa.tests;

import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.APIPage;
import com.cec.qa.util.ExcelUtil;

/**
 * 
 * @author : Lankala HariKrishna Date : 19 - 02 -2019
 *
 */
public class APINewBranndSiteTest extends BaseTest {

	public APINewBranndSiteTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("BRANDAPI"), "");
	}

	// ################################# StaticContent -- Start
	// ####################################################################################
	// Test case: GET - StaticContent
	@Test(enabled=false)
	public void getRequest_StaticContent_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StaticContent");
		System.out.println("Passing GET Request to API");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode", null, null, "", "");
		System.out.println("StaticContent StatusCode :" + resCode);
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	@Test(enabled=false)
	public void getRequest_StaticContent_ParametersValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StaticContent");
		System.out.println("Passing GET Request to API");
		String resStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "StaticContent", "Male", "FeMale", "",
				"");
		System.out.println("StaticContent Param :" + resStatus);
		boolean status = false;
		if (resStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "StaticContent Are Valid and Founded");
		} else {
			Assert.assertFalse(status, "StaticContent Are Not Found");
		}
	}

	@Test(enabled=false)
	public void getRequest_StaticContent_JsonValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StaticContent");
		System.out.println("Passing GET Request to API");
		String resStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "JsonStaticContent", "", "", "", "");
		System.out.println("StaticContent JsonValidation :" + resStatus);
		boolean status = false;
		if (resStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "StaticContent Are Valid and Founded");
		} else {
			Assert.assertFalse(status, "StaticContent Are Not Found");
		}
	}

	// ################################# ReservationData -- Start
	// ####################################################################################
	// Test case: GET - ReservationData

	@Test(enabled=false)
	public void getRequest_ReservationData_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationData");
		System.out.println("Passing GET Request to API");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode", null, null, "", "");
		System.out.println("StaticContent StatusCode :" + resCode);
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	@Test(enabled=false)
	public void getRequest_ReservationData_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationData");
		System.out.println("Passing GET Request to API");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "ReservationDataNegative", "Message", null,
				"", "");
		System.out.println("ReservationData resCode :" + resCode);
		boolean status = false;
		if (resCode == "true") {
			status = true;
			Assert.assertEquals(status, true, "ReservationDataNegative Founded");
		} else {
			Assert.assertNotSame(status, "ReservationDataNegative Not Found");
		}
	}

	@Test(enabled=false)
	public void getRequest_ReservationData_ParameterValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationData");
		System.out.println("Passing GET Request to API");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "ReservationData", "Message", "Store", "","Reservation");
		System.out.println("ReservationData resCode :" + resCode);
		boolean status = false;
		if (resCode == "true") {
			status = true;
			Assert.assertEquals(status, true, "ReservationData Founded");
		} else {
			Assert.assertNotEquals(status,true, "ReservationData Not Found");
		}
	}

	// ################################# TimeSlots -- Start
	// ####################################################################################
	// Test case: GET - TimeSlots

	@Test(enabled=false)
	public void postRequest_TimeSlots_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("TimeSlots");
		System.out.println("Passing POST Request to API");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "statuscode", "", "BrandSiteURL");
		System.out.println("StaticContent StatusCode :" + resCode);
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	@Test(enabled=false)
	public void postRequest_TimeSlots_ParametersValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("TimeSlots");
		System.out.println("Passing POST Request to API");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, "TimeSlots", "", "BrandSiteURL");
		boolean status = false;
		if (resCode == "true") {
			status = true;
			Assert.assertEquals(resCode, "true", "TimeSlots Founded");
		} else {
			Assert.assertFalse(status, "ReservationByConfirmation Not Found");
		}
	}
	
	// ################################# SFContent -- Start
		// ####################################################################################
		// Test case: POST - SFContent


	@Test(enabled=false)
	public void postRequest_SFContent_StatusCode_API() throws Exception {

		ExcelUtil.setExcelFileSheet("SFContent");
		System.out.println("Passing POST Request to API");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, "SFContent", "", "BrandSiteURL");
		Assert.assertEquals(resCode, 200, "StatusCode Mismatch");
	}
		
	// ################################# Request -- Start
		// ####################################################################################
		// Test case: POST - Request

	@Test(enabled=false)
	public void postRequest_Request_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("Request");
		System.out.println("Passing POST Request to API");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "statuscode", "", "BrandSiteURL");
		System.out.println("StaticContent StatusCode :" + resCode);
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}
	

	@AfterMethod
	public void tearDown() {
		// driver.quit();
	}
}
