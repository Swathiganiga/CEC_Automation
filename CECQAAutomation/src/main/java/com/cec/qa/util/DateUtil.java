/***********************************************************************************************************
File	       : DateUtil.java



Author		   : Lankala HariKrishna
Description    : This file contains the common functions for Date and Time  Operation 
Functions      :      
	1. public static String getTodaysDate()
	2. public static String getFutureDateInYYYYMMDD(int bookingDate) 
	3. public static Date getValidDate(String dateValidate)
	4. public static Date stringToDate(String sdob, String format)
	5. public static boolean isValidFormat(String format, String value)
	6. public static void appendJson()
	7. public static String appendSearch(String dummy, String orginal) 
	8. public static String updatePayloadWithDynamicDates(String requestDATA, int eventDay, int searchFromDate,int searchToDate)
	9. public static List<String> getUpdatedFromAndToDates(String updatedPayload)
   10. public static boolean isResponseDatesBetweenRequestedDates(List<String> dateList, String respBody)
   11. private static boolean isDateBetween(String frmDate, String toDate, String respBody)
   12. public static boolean between(Date date, Date dateStart, Date dateEnd) 
   

Change History :
	Date				Changed By					Comments
	29/11/2018			 Lankala HariKrishna		updated 
												
************************************************************************************************************/

package com.cec.qa.util;

import java.io.IOException;
import java.text.ParseException;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.json.JSONArray;
import org.json.JSONObject;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class DateUtil {

	public final static long SECOND_MILLIS = 1000;
	public final static long MINUTE_MILLIS = SECOND_MILLIS * 60;
	public final static long HOUR_MILLIS = MINUTE_MILLIS * 60;
	public final static long DAY_MILLIS = HOUR_MILLIS * 24;
	public final static long YEAR_MILLIS = DAY_MILLIS * 365;

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will return
	 *         current date
	 * @return
	 */

	public static String getTodaysDate() {
		Date myDate = new Date();
		System.out.println(myDate);
		SimpleDateFormat sm = new SimpleDateFormat("MMM dd,yyyy");
		String strDate = sm.format(myDate);
		return strDate;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will return
	 *         future dates based on your selected parameters
	 * @return
	 */

	public static String getFutureDateInYYYYMMDD(int bookingDate) {
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DATE, bookingDate);
		Date fDate = cal.getTime();
		SimpleDateFormat sm = new SimpleDateFormat("yyyy-MM-dd");
		return sm.format(fDate);

	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It should be
	 *         validate the date format
	 * @return
	 */

	public static Date getValidDate(String dateValidate) {
		Date actualDate = null;

		String dateFormats[] = { "dd/MM/yyyy", "MM/dd/yyyy", "yyyy/MM/dd", "dd-MM-yyyy", "MM-dd-yyyy", "yyyy-MM-dd",
				"dd/MMM/yyyy", "dd-MMM-yyyy" };

		try {

			for (int i = 0; i < dateFormats.length; i++) {
				actualDate = stringToDate(dateValidate, dateFormats[i]);
				if (actualDate != null) {
					System.out.println("###### New Date With Format ########" + actualDate);
					return actualDate;
				}
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return actualDate;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will convert
	 *         String Date to java.util.Date class Date
	 * @return
	 */

	public static Date stringToDate(String sdob, String format) {
		Date utildate = null;
		if (!sdob.equalsIgnoreCase("") && !sdob.equalsIgnoreCase(null)) {
			try {
				SimpleDateFormat sdf = new SimpleDateFormat(format);
				utildate = new Date(sdf.parse(sdob).getTime());
			} catch (Exception e) {
				System.out.println(e.toString());
				utildate = null;
			}
		}
		return utildate;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It should be
	 *         validate the selected date format
	 * @return
	 */

	public static boolean isValidFormat(String format, String value) {
		Date date = null;
		try {
			SimpleDateFormat sdf = new SimpleDateFormat(format);
			date = sdf.parse(value);
			if (!value.equals(sdf.format(date))) {
				date = null;
			}
		} catch (ParseException ex) {
			ex.printStackTrace();
		}
		return date != null;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will append
	 *         the new key-value pair object to existing json object .
	 * @return
	 */

	public static void appendJson() {
		String ss = "{\"description\":\"Some Text\", \"machinename\":\"machineA\", \"ipaddress\":\"192.128.0.0\"}";

		System.out.println("JSON string before: " + ss);

		try {
			ObjectMapper mapper = new ObjectMapper();
			Map<String, String> map = (Map<String, String>) mapper.readValue(ss, Map.class);

			map.put("version", "v3");
			ss = mapper.writeValueAsString(map);
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("JSON string after: " + ss);

	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will append
	 *         the new String value with existing String Value.
	 * @return
	 */

	public static String appendSearch(String dummy, String orginal) {

		String s = orginal.substring(10, 24);
		String appStr = dummy + s;

		return appStr;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will update
	 *         the dates dynamically which is selected dates by Tester.
	 * @return : json response
	 */

	public static String updatePayloadWithDynamicDates(String requestDATA, int eventDay, int searchFromDate,
			int searchToDate) {

		String eventDate = getFutureDateInYYYYMMDD(eventDay);
		String frmDate = getFutureDateInYYYYMMDD(searchFromDate);
		String toDate = getFutureDateInYYYYMMDD(searchToDate);

		String jsonData = new String(requestDATA);
		JSONObject obj = null;
		try {

			obj = new JSONObject(jsonData);
			int storeId = obj.getInt("StoreId");

			// Update PartyDate
			String jsonPartyDate = obj.getString("PartyDate");
			String updatePartDate = appendSearch(eventDate, jsonPartyDate);
			obj.remove("PartyDate");
			obj.put("PartyDate", updatePartDate);

			// Update SearchFromDate

			String jsonSearchFromDate = obj.getString("SearchFromDate");
			String updateSearchDate = appendSearch(frmDate, jsonSearchFromDate);
			obj.remove("SearchFromDate");
			obj.put("SearchFromDate", updateSearchDate);

			// Update SearchToDate

			String jsonSearchToDate = obj.getString("SearchToDate");
			String updateSearchToDate = appendSearch(toDate, jsonSearchToDate);
			obj.remove("SearchToDate");
			obj.put("SearchToDate", updateSearchToDate);

			System.out.println("Updated Json File:" + obj.toString());
		} catch (Exception e) {
			System.out.println("updatePayloadWithDynamicDates:" + e.getMessage());
		}

		return obj.toString();
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will fetch
	 *         the dynamic from and to dates and add to ArrayList
	 * @return
	 */

	public static List<String> getUpdatedFromAndToDates(String updatedPayload) {

		List<String> dateList = new ArrayList<String>();

		try {

			String jsonData = new String(updatedPayload);
			JSONObject obj = new JSONObject(jsonData);
			String frmDate = obj.getString("SearchFromDate");
			String toDate = obj.getString("SearchToDate");
			dateList.add(frmDate);
			dateList.add(toDate);

		} catch (Exception e) {

			System.out.println("getUpdatedFromAndToDates:" + e.getMessage());
		}

		return dateList;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will call
	 *         the isDateBetween for validating response dates
	 * @return : status
	 */

	public static boolean isResponseDatesBetweenRequestedDates(List<String> dateList, String respBody) {

		String frmDate = dateList.get(0);
		String toDate = dateList.get(1);
		boolean status = isDateBetween(frmDate, toDate, respBody);
		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will
	 *         validating response dates
	 * @return : status
	 */

	private static boolean isDateBetween(String frmDate, String toDate, String respBody) {

		boolean status = false;
		try {

			Date fromDate = stringToDate(frmDate.substring(0, 10), "yyyy-MM-dd");
			Date tosDate = stringToDate(toDate.substring(0, 10), "yyyy-MM-dd");
			String jsonText = new String(respBody);

			JSONObject obj = new JSONObject(jsonText);
			JSONArray jsonArray = obj.getJSONArray("$values");

			System.out.println("JsonArray Length:" + jsonArray.length());

			for (int i = 0; i < jsonArray.length(); i++) {

				String resCalenderDate = jsonArray.getJSONObject(i).getString("CalenderDate");

				System.out.println("ResponseDate :" + resCalenderDate); // 2018-11-05T12:00:00
				Date resDate = stringToDate(resCalenderDate.substring(0, 10), "yyyy-MM-dd");

				if (resDate != null && resDate.equals(tosDate)) {

					break;
				} else {
					status = between(resDate, fromDate, tosDate);
				}

			}

		} catch (Exception e) {
			System.out.println("isDateBetween:" + e.getMessage());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will compare
	 *         the both party date with before dates and after dates then return
	 *         valid status
	 * @return : status
	 */

	public static boolean between(Date date, Date dateStart, Date dateEnd) {
		if (date != null && dateStart != null && dateEnd != null) {
			if (date.after(dateStart) && date.before(dateEnd)) {
				return true;
			} else {
				return false;
			}
		}
		return false;
	}

	public static void main(String args[]) {
		System.out.println(
				"isValid - dd/MM/yyyy with 25/09/2013 12:13:50 = " + isValidFormat("yyyy-MM-dd", "2018-11-05"));

	}

	/**
	 * @author : Lankala HariKrishna Date : 28 - 12 - 2018 Purpose : It will return
	 *         get the returnd dates from response and get validate the date formate
	 * @return : status
	 */

	public static boolean validateGetAvailableDates(String respBody) {

		boolean status = false;
		try {
			String jsonData = new String(respBody);

			JSONObject obj = new JSONObject(jsonData);
			JSONArray jsonArray = obj.getJSONArray("$values");
			String calDate = null;
			boolean formatStatus = false;
			if (jsonArray != null) {
				for (int i = 0; i < jsonArray.length(); i++) {
					calDate = jsonArray.getJSONObject(i).getString("CalenderDate");
					System.out.println("calDate:" + calDate);
					formatStatus = isValidFormat("yyyy-MM-dd", calDate.substring(0, 10));
				}
			}

			if (calDate != null && formatStatus == true) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 28 - 12 - 2018 Purpose : It will return
	 *         get the returnd dates from response and get validate the date formate
	 * @return : status
	 */

	public static List<String> getPartyDateFromJsonBody(String reqBody) {
		// TODO Auto-generated method stub

		List<String> al = new ArrayList<String>();

		try {

			String jsonData = new String(reqBody);
			JSONObject obj = new JSONObject(jsonData);
			String reqPartyDate = obj.getString("PartyDate");
			String frmDate = obj.getString("SearchFromDate");
			String toDate = obj.getString("SearchToDate");
			al.add(reqPartyDate);
			al.add(frmDate);
			al.add(toDate);

		} catch (Exception e) {
			System.out.println("Exception at getPartyDateFromJsonBody:" + e.getMessage());
		}
		return al;
	}

	/**
	 * @author : Lankala HariKrishna Date : 28 - 12 - 2018 Purpose : It will return
	 *         the validatePartyAndSearchAndToDates status
	 * @return : status
	 */

	public static boolean validatePartyAndSearchAndToDates(String partyDate, String frmDate, String toDate,
			String resBody) {

		return isDateBetween(frmDate, toDate, resBody);
	}

	/**
	 * @author : Lankala HariKrishna Date : 28 - 12 - 2018 Purpose : It will return
	 *         the validatePartyAndSearchAndToDates status
	 * @return : status
	 */

	public static boolean validateDuplicateReservations(String respBody, String ReservationsType) {

		boolean status = false;
		try {
			String jsonData = new String(respBody);

			JSONObject obj = new JSONObject(jsonData);
			JSONObject jsonRoot = obj.getJSONObject(ReservationsType);
			JSONArray jsonArray = jsonRoot.getJSONArray("$values");
			String calDate = null;
			String confId = null;
			boolean formatStatus = false;
			if (jsonArray != null) {
				for (int i = 0; i < jsonArray.length(); i++) {
					calDate = jsonArray.getJSONObject(i).getString("CalenderDate");
					System.out.println("calDate:" + calDate);
					formatStatus = isValidFormat("yyyy-MM-dd", calDate.substring(0, 10));
					confId = jsonArray.getJSONObject(i).getString("ConfirmationID");

				}
			}

			if (calDate != null && formatStatus == true && confId != null) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 28 - 12 - 2018 Purpose : It will compare
	 *         the complete json file object
	 * @return : status
	 * @throws IOException
	 * @throws JsonProcessingException
	 */

	public static boolean validateGetAvailableTimeSlots(String respBodyJson, String excelJson)
			throws JsonProcessingException, IOException {
		ObjectMapper mapper = new ObjectMapper();

		JsonNode tree1 = mapper.readTree(respBodyJson);
		JsonNode tree2 = mapper.readTree(excelJson);

		boolean areTheyEqual = tree1.equals(tree2);
		System.out.println("Status:" + areTheyEqual);

		return areTheyEqual;
	}

	@SuppressWarnings("unchecked")
	public static boolean validateJson(String respBody, String reqJson) {

		// TODO Auto-generated method stub

		boolean status = false;
		ObjectMapper mapper = new ObjectMapper();
		try {
			Map<String, Object> resMap = (mapper.readValue(respBody, Map.class));
			Map<String, Object> reqMap = (mapper.readValue(reqJson, Map.class));
			Map<String, Object> mapRes = getMapDiff(resMap, reqMap);
			if (mapRes != null && mapRes.isEmpty()) {
				status = true;
			} else if (mapRes.size() > 0 && mapRes.size() != 0) {
				status = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		return status;
	}

	public static Map<String, Object> getMapDiff(Map<String, Object> dynamicJson, Map<String, Object> excelJson) {
		Map<String, Object> result = new HashMap<String, Object>();

		for (String key : dynamicJson.keySet()) {
			Object val = dynamicJson.get(key);
			System.out.println("json Val:" + val);

			if (!excelJson.containsKey(key)) {

				result.put(key, dynamicJson.get(key));
			}
		}

		for (String key : excelJson.keySet()) {
			if (!dynamicJson.containsKey(key)) {
				result.put(key, excelJson.get(key));
			}
		}

		return result;
	}

	public static boolean validateBrandSiteTimeSlots(String respBody) {

		boolean status = false;
		try {
			String jsonData = new String(respBody);

			JSONObject obj = new JSONObject(jsonData);
			JSONArray jsonRoot = obj.getJSONArray("AvailabilityDates");
			JSONArray jsonArray = jsonRoot.getJSONArray(0);
			JSONArray innerJsonArray = jsonArray.getJSONArray(1);
			String activeStartDate = null;
			String activeEndDate = null;
			boolean formatStatus = false;
			if (innerJsonArray != null) {
				for (int i = 0; i < innerJsonArray.length(); i++) {
					activeStartDate = jsonArray.getJSONObject(i).getString("ActiveStartOn");
					formatStatus = isValidFormat("yyyy-MM-dd", activeStartDate.substring(0, 10));
					activeEndDate = jsonArray.getJSONObject(i).getString("ActiveEndOn");
					formatStatus = isValidFormat("yyyy-MM-dd", activeStartDate.substring(0, 10));
				}
			}

			if (formatStatus == true) {
				status = true;
			} else {
				status = false;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 3/7/2019
	 * @param msgArg
	 * @param :
	 *            Reservation Not Found
	 * @return : Status
	 */
	public static boolean validateReservationNegative(String msgArg, String reservStatus, String dynamicResponse) {

		boolean status = false;
		try {
			String jsonData = new String(dynamicResponse);
			JSONObject obj = new JSONObject(jsonData);
			JSONObject jobj = obj.getJSONObject(msgArg);
			String errorStatus = jobj.getString("Error");
			String storeStatus = jobj.getString("Status");

			if (errorStatus.equalsIgnoreCase(reservStatus) && storeStatus.equalsIgnoreCase("Error")) {
				status = true;
			} else {
				return status;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;

	}
	
	/**
	 * @author : Lankala HariKrishna Date : 3/7/2019
	 * @param msgArg
	 * @param :
	 *            Reservation Not Found
	 * @return : Status
	 */

	public static boolean validateReservationData(String dynamicResponse, String msgArg, String stoArg,
			String reservationArg) {
		boolean status = false;
		try {
			String jsonData = new String(dynamicResponse);
			JSONObject obj = new JSONObject(jsonData);
			JSONObject jobj = obj.getJSONObject(msgArg);
			String storeStatus = jobj.getString("Status");
			JSONObject reservObj = obj.getJSONObject(reservationArg);
			JSONArray jArray = reservObj.getJSONArray("BirthdayGuestDetails");
			String createDate = null;
			boolean formatStatus = false;
			if (jArray != null) {
				for (int i = 0; i < jArray.length(); i++) {
					createDate = jArray.getJSONObject(i).getString("CreatedOn");
					formatStatus = isValidFormat("yyyy-MM-dd", createDate.substring(0, 10));
				}
			}
			
			JSONArray depositArray = reservObj.getJSONArray("DepositDetails");
			String depositCreateDate = null;
			String depositPaidDate = null;
			String reservationID = "11952644"; // hardcoded from response
			String resReservation = null;
			
			if (depositArray != null) {
				for (int i = 0; i < depositArray.length(); i++) {
					depositCreateDate = depositArray.getJSONObject(i).getString("CreatedOn");
					formatStatus = isValidFormat("yyyy-MM-dd", depositCreateDate.substring(0, 10));
					depositPaidDate = depositArray.getJSONObject(i).getString("PaidOn");
					formatStatus = isValidFormat("yyyy-MM-dd", depositCreateDate.substring(0, 10));
					resReservation = depositArray.getJSONObject(i).getString("ReservationID");
				}
			}
			
			JSONArray historyArray = reservObj.getJSONArray("History");
			String reservationState = null;
			if (historyArray != null) {
				for (int i = 0; i < historyArray.length(); i++) {
					reservationState = historyArray.getJSONObject(i).getString("ReservationState");
					
					
				}
			}
			
			JSONObject storObj = obj.getJSONObject(stoArg);
			String storeAddress = storObj.getString("Address");
			
			JSONArray sArray = storObj.getJSONArray("AlternateStores");
			
			String altStoreName = null;
			String altStoreNum = null;
			if (sArray != null) {
				for (int i = 0; i < sArray.length(); i++) {
					altStoreName = sArray.getJSONObject(i).getString("StoreName");
					altStoreNum = sArray.getJSONObject(i).getString("StoreNumber");
				}
			}
			
			if(formatStatus == true && (resReservation.equalsIgnoreCase(reservationID) &&
				(reservationState.equalsIgnoreCase("Booked")) && storeStatus.equalsIgnoreCase("Ok") &&
				storeAddress != null && altStoreName != null && altStoreNum != null)) {
				
				status = true;
			} else {
				return status;
			}
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;

		
	}

}
