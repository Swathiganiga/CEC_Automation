package com.cec.qa.tests;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.APIPage;
import com.cec.qa.util.ExcelUtil;

/***
 * @author : Lankala HAriKrishna Date : 30-11-2018
 * @param method
 * @return
 * @throws IOException
 * @throws JSONException
 * @throws UnknownHostException
 */

public class APINewBookingFunnelTest extends BaseTest {

	public APINewBookingFunnelTest() {
		super();
	}

	@BeforeMethod
	public void setUp() throws Exception {
		initialization(propv.getProperty("API"),"");
	}
	//################################# StoreDetails ####################################################################################	
	// Test case: GET - StoreDetails
	@Test(enabled=false)
	public void getRequest_StoreDetails_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StoreDetails");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - StoreDetails Negative
	@Test(enabled=false)
	public void getRequest_StoreDetails_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StoreDetails");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "statuscode",null,null,"","");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "StoreDetails NotFound for Negative Mismatch");
	}

	// Test case: GET - StoreDetails Parameters
	@Test(enabled=false)
	public void getRequest_StoreDetails_ParametersValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StoreDetails");
		System.out.println("Passing GET Request to API1");
		String resStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "StoreDetails","Message", "store","","");
		boolean status = false;
		if (resStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "StoreDetails Are Valid and Founded");
		} else {
			Assert.assertFalse(status, "StoreDetails Are Not Found");
		} 
	}

	// Test case: GET - StoreDetails_JsonValidation
	@Test(enabled=false)
	public void getRequest_StoreDetails_JsonValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("StoreDetails");
		System.out.println("Passing GET Request to API1");
		String jsonstatus = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "StoreDetailsJsonValidation",null,null,"","");
		boolean status = false;
		if (jsonstatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "StoreDetailsJsonValidation Success");
		} else {
			Assert.assertFalse(status, "StoreDetailsJsonValidation Failure");
		}
	}			
	//################################# GetReservationSaveByReservation ####################################################################
	// Test case: GET - GetReservationSaveByReservationId_By_StatusCode
	@Test(enabled=false)
	public void getRequest_GetReservationSaveByReservationId_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetReservationSaveByReservation");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - GetReservationSaveByReservationId_Negative)
	@Test(enabled=false)
	public void getRequest_GetReservationSaveByReservationId_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetReservationSaveByReservation");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "statuscode",null,null,"","");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "GetReservationSaveByReservation Negative Mismatch");
	}

	// Test case: GET - GetReservationSaveByReservationId(ParameterValidation)
	@Test(enabled=false)
	public void getRequest_GetReservationSaveByReservationId_ParameterValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetReservationSaveByReservation");
		System.out.println("Passing GET Request to API1");
		String paramStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "GetReservationSaveByReservation",null,null,"PartyType","Reservation");
		boolean status = false;
		if (paramStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "GetReservationSaveByReservationId Founded");
		} else {
			Assert.assertFalse(status, "GetReservationSaveByReservationId Not Found");
		} 
	}

	//################################# ForwardReservationConfirmation ####################################################################
	// Test case: GET - ForwardReservationConfirmationBy_StatusCode
	@Test(enabled=false)
	public void getRequest_ForwardReservationConfirmation_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ForwardReservationConfirmation");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - ForwardReservationConfirmation Negative
	@Test(enabled=false)
	public void getRequest_ForwardReservationConfirmation_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ForwardReservationConfirmation");
		System.out.println("Passing GET Request to API1");
		String parameterStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "ForwardReservationConfirmation",null,null,"","");
		boolean status = false;
		if (parameterStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "ForwardReservationConfirmation Success");
		} else {
			Assert.assertFalse(status,"ForwardReservationConfirmation Failure");
		} 
	}

	//################################# GetAvailableDates #################################################################################
	// Test case: POST - GetAvailableDatesBy_StatusCode
	@Test(enabled=false)
	public void postRequest_GetAvailableDates_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetAvailableDates");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "GetAvailableDates","","BookAPI");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: POST - GetAvailableDates_BetweenSearchFromAndToDate
	@Test(enabled=false)
	public void postRequest_GetAvailableDates_BetweenSearchFromAndToDate_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetAvailableDates");
		String paramStatus = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200,"GetAvailableDatesBetweenSearchFromAndToDate","","BookAPI");
		boolean status = false;
		if (paramStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "GetAvailableDates Between of SearchAndTo Dates");
		} else {
			Assert.assertFalse(status, "GetAvailableDates not Between of SearchAndTo Dates");
		} 
	}

	// Test case: POST -GetAvailableDates_BetweenSearchFromAndToDate_Negative
	@Test(enabled=false)
	public void postRequest_GetAvailableDates_BetweenSearchFromAndToDate_Negative_API()
			throws Exception {
		ExcelUtil.setExcelFileSheet("GetAvailableDates");
		String paramStatus = APIPage.APIpostRequest(ExcelUtil.getRowData(3), 200,"GetAvailableDatesBetweenSearchFromAndToDate","","BookAPI");
		boolean status = false;
		if (paramStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "GetAvailableDates Between of SearchAndTo Dates Negative");
		} else {
			Assert.assertFalse(status, "GetAvailableDates not Between of SearchAndTo Dates Negative");
		} 
	}

	//################################# CheckForDuplicateReservations ######################################################################	
	// Test case: POST - CheckForDuplicateReservationsBy_StatusCode
	@Test(enabled=false)
	public void postRequest_CheckForDuplicateReservations_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("CheckForDuplicateReservations");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(3), 200, "statuscode","","BookAPI");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: POST - CheckForDuplicateReservations
	@Test(enabled=false)
	public void postRequest_CheckForDuplicateReservations_ParamValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("CheckForDuplicateReservations");
		String paramStatus = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "CheckForDuplicateReservations","Reservations","BookAPI");
		boolean status = false;
		if (paramStatus == "true") {
			Assert.assertEquals(status, true, "CheckForDuplicateReservations Success");
		} else {
			Assert.assertFalse(status, "CheckForDuplicateReservations Failure");
		} 
	}

	// Test case: POST - CheckForDuplicateReservations (Negative)
	@Test(enabled=false)
	public void postRequest_CheckForDuplicateReservations_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("CheckForDuplicateReservations");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, null,"Reservations","BookAPI");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "CheckForDuplicateReservations StatusCode Mismatch");
	}

	//################################# ReservationSavePayment ##########################################################################	
	// Test case: POST - ReservationSavePaymentBy_StatusCode
	@Test(enabled=false)
	public void postRequest_ReservationSavePayment_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationSavePayment");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "ReservationSavePayment","","BookAPI");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: POST - ReservationSavePayment Negative
	@Test(enabled=false)
	public void postRequest_ReservationSavePayment_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationSavePayment");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, "ReservationSavePayment","","BookAPI");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "ReservationSavePayment StatusCode Mismatch");
	}

	//################################# ReleaseTempBookingSeat ##########################################################################	
	// Test case: GET - ReleaseTempBookingSeatBy_StatusCode
	@Test(enabled=false)
	public void getRequest_ReleaseTempBookingSeatBy_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReleaseTempBookingSeat");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - ReleaseTempBookingSeatParamValidation
	@Test(enabled=false)
	public void getRequest_ReleaseTempBookingSeat_ParamValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReleaseTempBookingSeat");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "ReleaseTempBookingSeat",null,null,"","");
		boolean status = false;
		if (resCode == "true") {
			Assert.assertEquals(status, true, "ReleaseTempBookingSeat Success");
		} else {
			Assert.assertFalse(status, "ReleaseTempBookingSeat Failure");
		} 
	}
	// Test case: GET - ReleaseTempBookingSeatParamValidationNegative
	@Test(enabled=false)
	public void getRequest_ReleaseTempBookingSeat_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReleaseTempBookingSeat");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "statuscode",null,null,"","");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "ReleaseTempBookingSeat Mismatch Negative");
	}

	//################################# SaveByReservationid ##########################################################################					
	// Test case: GET - SaveByReservationidBy_StatusCode
	@Test(enabled=false)
	public void getRequest_SaveByReservationid_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("SaveByReservationid");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "SaveByReservationid",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - SaveByReservationid Negative
	@Test(enabled=false)
	public void getRequest_SaveByReservationid_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("SaveByReservationid");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "SaveByReservationid",null,null,"","");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: GET - SaveByReservationid ParamValidation
	@Test(enabled=false)
	public void getRequest_SaveByReservationid_ParamValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("SaveByReservationid");
		System.out.println("Passing GET Request to API1");
		String paramStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(3), 200, "SaveByReservationid",null,null,"PartyType","Reservation");
		boolean status = false;
		if (paramStatus == "true") {
			status = true;
			Assert.assertEquals(status, true, "SaveByReservationid Founded");
		} else {
			Assert.assertFalse(status, "SaveByReservationid Not Found");
		} 
	}


	//################################# ReservationByConfirmation #######################################################################					

	// Test case: GET - ReservationByConfirmation
	@Test(enabled=false)
	public void getRequest_ReservationByConfirmation_By_StatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationByConfirmation");
		System.out.println("Passing GET Request to API1");
		String resCode = APIPage.APIgetRequest(ExcelUtil.getRowData(1), 200, "statuscode",null,null,"","");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}
	// Test case: GET - ReservationByConfirmation
	@Test(enabled=false)
	public void getRequest_ReservationByConfirmation_ParameterValidation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("ReservationByConfirmation");
		System.out.println("Passing GET Request to API1");
		String paramStatus = APIPage.APIgetRequest(ExcelUtil.getRowData(2), 200, "ReservationByConfirmation",null,null,"PartyType","");
		boolean status = false;
		if (paramStatus == "true") {
			status = true;
			Assert.assertEquals(paramStatus, true, "ReservationByConfirmation Founded");
		} else {
			Assert.assertFalse(status, "ReservationByConfirmation Not Found");
		}
	}

	//################################# GetAvailableTimeSlots ##########################################################################	
	// Test case: POST - GetAvailableTimeSlotsByStatusCode
	@Test(enabled=false)
	public void postRequest_GetAvailableTimeSlots_ByStatusCode_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetAvailableTimeSlots");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, "","","BookAPI");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: POST - GetAvailableTimeSlots (Negative)
	@Test(enabled=false)
	public void postRequest_GetAvailableTimeSlots_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("GetAvailableTimeSlots");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, "","","BookAPI");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}


	//################################# RequestReservation #############################################################################	
	// Test case: POST - RequestReservation
	@Test(enabled=false)
	public void postRequest_RequestReservation_API() throws Exception {
		ExcelUtil.setExcelFileSheet("RequestReservation");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(1), 200, null,"","BookAPI");
		Assert.assertEquals(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	// Test case: POST - RequestReservation Negative)
	@Test(enabled=false)
	public void postRequest_RequestReservation_Negative_API() throws Exception {
		ExcelUtil.setExcelFileSheet("RequestReservation");
		String resCode = APIPage.APIpostRequest(ExcelUtil.getRowData(2), 200, null,"","BookAPI");
		Assert.assertNotSame(Integer.parseInt(resCode), 200, "StatusCode Mismatch");
	}

	@AfterMethod
	public void tearDown() {
		//driver.quit(); 
	}

}
