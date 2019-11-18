package com.cec.qa.pages;
import static org.testng.Assert.fail;
import java.io.IOException;
import java.net.UnknownHostException;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.testng.Assert;
import com.cec.qa.base.BaseTest;
import com.cec.qa.util.DateUtil;
import com.cec.qa.util.ExcelUtil;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.RestAssured;
import io.restassured.specification.RequestSpecification;

public class APIPage extends BaseTest {
	public APIPage() throws Exception {
		super();
	}

	public static String responseBody;

	public static void logToReport(String message) {
		System.out.println(message);
	}

	public static String APIgetRequest(XSSFRow requestUrl, int expCode, String apiName, String msgArg, String stoArg,
			String partyArg, String reservationArg)
			throws JsonParseException, JsonMappingException, IOException, UnknownHostException {

		RequestSpecification request = RestAssured.given();
		// read request url from excel, column number 3
		String requestURL = requestUrl.getCell(3).toString();
		System.out.println("Request URL from Excel is :" + requestURL);
		request.header("Content-Type", "application/json");
		request.header("UserID", "19");

		io.restassured.response.Response resp = null;

		String returnStatus = null;
		try {
			resp = request.get(requestURL);
			String respBody = resp.asString();

			if (apiName != null && apiName == "StoreDetails") {

				// Validate the Store Status and Address by passing Message and
				// Store objects
				// from postman response

				boolean status = ExcelUtil.validateStoreDetails(respBody, msgArg, stoArg);

				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "GetReservationSaveByReservation") {
				boolean status = ExcelUtil.validateGetReservationSaveByReservation(respBody, partyArg, reservationArg);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "ForwardReservationConfirmation") {
				boolean status = ExcelUtil.validateForwardReservationConfirmation(respBody);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close
			} else if (apiName != null && apiName == "ReleaseTempBookingSeat") {

				boolean status = ExcelUtil.validateReleaseTempBookingSeat(respBody);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "SaveByReservationid") {
				boolean status = ExcelUtil.validateGetReservationSaveByReservation(respBody, partyArg, reservationArg);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				}

			} else if (apiName != null && apiName == "ReservationByConfirmation") {
				boolean status = ExcelUtil.validateReservationByConfirmation(respBody, partyArg);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "StoreDetailsJsonValidation") {

				boolean jsonStatus = DateUtil.validateJson(respBody, requestUrl.getCell(5).toString());
				System.out.println("jsonStatus:" + jsonStatus);
				if (jsonStatus == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close
			} else if (apiName != null && apiName == "StaticContent") {
				boolean status = ExcelUtil.validateStaticContent(respBody, msgArg, stoArg);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "JsonStaticContent") {
				boolean jsonStatus = DateUtil.validateJson(respBody, requestUrl.getCell(5).toString());
				System.out.println("jsonStatus:" + jsonStatus);
				if (jsonStatus == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if(apiName != null && apiName == "ReservationDataNegative") {
				boolean status = DateUtil.validateReservationNegative(msgArg,"Reservation Not Found",respBody);
				System.out.println("ReservationDataNegative Status:" + status);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close
				
			} else if(apiName != null && apiName == "ReservationData") {
				boolean status = DateUtil.validateReservationData(respBody,msgArg,stoArg,reservationArg);
				System.out.println("ReservationData Status:" + status);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close
			}

			logToReport("Response code is :" + resp.statusCode());
			logToReport("Response body is :" + respBody);
			logToReport("Asserting response code");
		} catch (Exception e) {
			fail("Exception error, please check your URL. Request URL is  : " + requestURL);
		}

		int resCode = resp.statusCode();
		System.out.println("GET Before Return Status Code is:" + String.valueOf(resCode));
		if (apiName != null && apiName == "statuscode") {

			returnStatus = String.valueOf(resCode);
		}
		return returnStatus;
	}

	public static String APIpostRequest(XSSFRow requestData, int expCode, String apiName, String reservationArg, String urlName)
			throws JsonParseException, JsonMappingException, IOException {

		io.restassured.response.Response resp = null;
		String returnStatus = null;
		try {
			String requestDATA = requestData.getCell(4).toString();
			System.out.println("requestDATA:" + requestDATA);
			ObjectMapper mapper = new ObjectMapper();

			Map<String, Object> map = new HashMap<String, Object>();

			if ((apiName != null && apiName == "ReservationSavePayment") || apiName == "SFContent") {

				//add this line to read data
				mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
				mapper.readValue(requestDATA, List.class);
			} else {
				// convert excel JSON value to Map
				map = mapper.readValue(requestDATA, new TypeReference<Map<String, String>>() {
				});

			}
			System.out.println(map);

			String api = requestData.getCell(1).toString();
			if(urlName == "BookAPI") {
				RestAssured.baseURI = propv.getProperty("baseURL");
				System.out.println("BookAPIBaseURL is:"+propv.getProperty("baseURL"));
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				request.header("UserID", "19");
				request.body(map);
				resp = request.post(api);
			}else if(urlName == "BrandSiteURL") {
				RestAssured.baseURI = propv.getProperty("brandsiteBaseURL");
				System.out.println("BrandSiteBaseURL is:"+propv.getProperty("brandsiteBaseURL"));
				RequestSpecification request = RestAssured.given();
				request.header("Content-Type", "application/json");
				request.header("UserID", "19");
				request.body(map);
				resp = request.post(api);
			}

			String respBody = resp.asString();

			if (apiName != null && apiName == "GetAvailableDates") {

				boolean status = DateUtil.validateGetAvailableDates(respBody);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "GetAvailableDatesBetweenSearchFromAndToDate") {

				List<String> listDates = DateUtil.getPartyDateFromJsonBody(requestData.getCell(4).toString());
				System.out.println("listDates Size:" + listDates.size());
				boolean dateStatus = DateUtil.validatePartyAndSearchAndToDates(listDates.get(0), listDates.get(1),
						listDates.get(2), respBody);

				if (dateStatus == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "CheckForDuplicateReservations") {
				boolean status = DateUtil.validateDuplicateReservations(respBody, reservationArg);
				if (status == true) {
					returnStatus = "true";
				} else {
					returnStatus = "false";
				} // inner if - else close

			} else if (apiName != null && apiName == "GetAvailableTimeSlots") {
				boolean status = DateUtil.validateGetAvailableTimeSlots(respBody, requestData.getCell(5).toString());
				if (status == true) {
					Assert.assertEquals(status, true, "GetAvailableTimeSlots Success");
					returnStatus = "true";
				} else {
					Assert.assertEquals(status, true, "GetAvailableTimeSlots Failure");
					returnStatus = "false";
				} // inner if - else close

			} else if(apiName != null && apiName == "TimeSlots") {
				
				boolean status = DateUtil.validateBrandSiteTimeSlots(respBody);
				
				System.out.println("TIMESLOTS");
				if(returnStatus == null) {
					returnStatus = "true";
				}
			}

		} catch (Exception e) {
			System.out.println(e.getMessage());
			logToReport(e.getMessage());
			fail("Exception error, please check error message: " + e.getMessage());
		}
		// String respBody = null;
		int resCode = resp.statusCode();
		/*if (apiName != null && apiName == "statuscode") {

			returnStatus = String.valueOf(resCode);
		}*/
		
		returnStatus = String.valueOf(resCode);
		return returnStatus;

	}

}
