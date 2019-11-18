package com.cec.qa.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.json.JSONArray;
import org.json.JSONObject;

import com.cec.qa.base.BaseTest;
import com.fasterxml.jackson.core.JsonProcessingException;

/**
 * Created by obaskirt on 28-Oct-17. Modified By HariKrishna on 20 - 11 - 2018
 */
public class ExcelUtil extends BaseTest {
	public ExcelUtil() throws Exception {
		super();
		// TODO Auto-generated constructor stub
	}

	// Main Directory of the project
	public static final String currentDir = System.getProperty("user.dir");

	// Location of Test data excel file
	// public static String testDataExcelPath =
	public static String testDataExcelPath = null;
	public static final String testDataExcelFileName = "BookingAPIData.xlsx";
	public static final String brandSiteDataExcelFileName = "BrandSiteAPIData.xlsx";
	// Excel WorkBook
	private static XSSFWorkbook excelWBook;

	// Excel Sheet
	private static XSSFSheet excelWSheet;

	// Excel cell
	private static XSSFCell cell;

	// Excel row
	private static XSSFRow row;

	// Row Number
	public static int rowNumber;

	// Column Number
	public static int columnNumber;

	public static String address;
	
	public boolean fileStatus = false;
	

	// Setter and Getters of row and columns
	public static void setRowNumber(int pRowNumber) {
		rowNumber = pRowNumber;
	}

	public static int getRowNumber() {
		return rowNumber;
	}

	public static void setColumnNumber(int pColumnNumber) {
		columnNumber = pColumnNumber;
	}

	public static int getColumnNumber() {
		return columnNumber;
	}

	/**
	 * @author     : HariKrishna
	 * UpdatedDate : 05/03/2019
	 * @param sheetName
	 * @throws Exception
	 */
	
	public static void setExcelFileSheet(String sheetName) throws Exception {

		// MAC or Windows Selection for excel path
		System.out.println("Excel SheetName is:"+sheetName);
		System.out.println("Current dir is :" + currentDir);
		System.out.println("Current platform  is :" + System.getProperty("os.name"));
		
		try {
			// Just read ExcelSheet based on SheetName
			excelWSheet = excelWBook.getSheet(sheetName);
		} catch (Exception e) {
			System.out.println("Exception:"+e.getMessage());
		}
	}

	/**
	 * @author     : HariKrishna
	 * UpdatedDate : 05/03/2019
	 * @param apiName
	 * @throws Exception
	 */
	
	public static void readFileSheet(String apiName) throws Exception {

		System.out.println("PropertiesFile API Name:"+apiName);
		
		if (System.getProperty("os.name").toString().toLowerCase().contains("win")) {
			System.out.println("I am on windows machine");
			testDataExcelPath = currentDir + "//src//main//java//com//cec//qa//data";
			System.out.println("windows test data path is :" + testDataExcelPath);
		}
		
		if(apiName == "API") {
			
			try {
				// Load the Excel file
				String FILE_NAME = propv.getProperty("testDataExcelFileName");
				System.out.println("FILE_NAME:" + FILE_NAME);
				FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "//" + FILE_NAME);
				excelWBook = new XSSFWorkbook(ExcelFile);
			} catch (Exception e) {
				try {
					throw (e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		}else if(apiName == "BRANDAPI") {
			try {
				// Load the Excel file
				String FILE_NAME = propv.getProperty("brandSiteDataExcelFileName");
				System.out.println("FILE_NAME:" + FILE_NAME);
				FileInputStream ExcelFile = new FileInputStream(testDataExcelPath + "//" + FILE_NAME);
				excelWBook = new XSSFWorkbook(ExcelFile);
			} catch (Exception e) {
				try {
					throw (e);
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
			
		}
	}

	// This method reads the test data from the Excel cell.
	// We are passing row number and column number as parameters.
	public static String getCellData(int RowNum, int ColNum) throws Exception {
		try {
			cell = excelWSheet.getRow(RowNum).getCell(ColNum);
			DataFormatter formatter = new DataFormatter();
			String cellData = formatter.formatCellValue(cell);
			return cellData;
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method takes row number as a parameter and returns the data of given row
	// number.
	public static XSSFRow getRowData(int RowNum) throws Exception {
		try {
			row = excelWSheet.getRow(RowNum);
			return row;
		} catch (Exception e) {
			throw (e);
		}
	}

	// This method gets excel file, row and column number and set a value to the
	// that cell.
	public static void setCellData(String value, int RowNum, int ColNum) throws Exception {
		try {
			row = excelWSheet.getRow(RowNum);
			cell = row.getCell(ColNum);
			if (cell == null) {
				cell = row.createCell(ColNum);
				cell.setCellValue(value);
			} else {
				cell.setCellValue(value);
			}
			// Constant variables Test Data path and Test Data file name
			FileOutputStream fileOut = new FileOutputStream(
					testDataExcelPath + propv.getProperty("testDataExcelFileName"));
			excelWBook.write(fileOut);
			fileOut.flush();
			fileOut.close();
		} catch (Exception e) {
			try {
				throw (e);
			} catch (IOException e1) {
				e1.printStackTrace();
			}
		}
	}

	/***
	 * @author : Lankala HariKrishna Date : 20 - 11 - 2018
	 * @param fileName
	 * @return
	 * @throws IOException
	 *             Purpose : It will return the json object details
	 */
	public static String readJson(String fileName) throws IOException {

		String address = null;
		try {
			String jsonData = new String(fileName);

			JSONObject obj = new JSONObject(jsonData);
			// int storeId = obj.getInt("$id");
			// Read the Message class object details from json
			// JSONObject jobj = obj.getJSONObject("Message");
			JSONObject arr = obj.getJSONObject("key");
			address = arr.getString("Obj");

			/*
			 * for (int i = 0; i < arr.length(); i++) { address =
			 * arr.getJSONObject(i).getString("Address"); }
			 */
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return address;
	}

	/***
	 * @author : Lankala HariKrishna Date : 27 - 11 - 2018 Purpose : It will
	 *         validate the response
	 * @param responseJson
	 * @return
	 * @throws IOException
	 * @throws JsonProcessingException
	 */
	public static String validateResponseDateFormat(String responseJson, String reqFormate)
			throws JsonProcessingException, IOException {

		// Split the json response
		boolean resCalenderDateFormate = false;
		String subStringDate = null;
		try {

			String jsonText = new String(responseJson);

			JSONObject obj = new JSONObject(jsonText);
			JSONArray jsonArray = obj.getJSONArray("$values");

			System.out.println("JsonArray Length:" + jsonArray.length());

			for (int i = 0; i < jsonArray.length(); i++) {

				String resCalenderDate = jsonArray.getJSONObject(i).getString("CalenderDate");

				System.out.println("ResponseDate :" + resCalenderDate); // 2018-11-05T12:00:00

				subStringDate = resCalenderDate.substring(0, 10);

				System.out.println("subStringDate:" + subStringDate);

				resCalenderDateFormate = DateUtil.isValidFormat(reqFormate, subStringDate);

			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return (resCalenderDateFormate == true) ? reqFormate : null;

	}

	public static String getResponsePartyDate(String respBody) {
		// TODO Auto-generated method stub
		return null;
	}

	/***
	 * 
	 * @param excelUrl
	 * @return
	 */
	public static String getStoreId(String excelUrl) {

		return null;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27-12-2018
	 * @param string
	 * @param string2
	 * @return : status of the storeDetails
	 */

	public static boolean validateStoreDetails(String response, String messageKey, String storeKey) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			String jsonData = new String(response);

			JSONObject obj = new JSONObject(jsonData);
			JSONObject jobj = obj.getJSONObject(messageKey);
			String storeStatus = jobj.getString("Status");
			JSONObject jsonObj = obj.getJSONObject(storeKey);

			if (jsonObj != null) {

				String storeAdd = jsonObj.getString("Address");
				if (storeAdd == null && storeStatus.equalsIgnoreCase("Error")) {
					status = false;
				} else if (storeAdd != null && storeStatus.equalsIgnoreCase("OK")) {
					status = true;
				}
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 27-12-2018
	 * @param string
	 * @param string2
	 * @return : status of the GetReservationSaveByReservation
	 */

	public static boolean validateGetReservationSaveByReservation(String respBody, String PartyTypeKey,
			String ReservationKey) {
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			String jsonData = new String(respBody);

			JSONObject obj = new JSONObject(jsonData);
			JSONObject jobj = obj.getJSONObject(PartyTypeKey);
			JSONObject partyAttList = jobj.getJSONObject("AttributeList");
			JSONArray jsonArray = partyAttList.getJSONArray("$values");
			String AttributeName = null;
			if (jsonArray != null) {
				for (int i = 0; i < jsonArray.length(); i++) {
					AttributeName = jsonArray.getJSONObject(i).getString("Attribute");
					System.out.println("AttributeName:" + AttributeName);
				}
			}

			// Validate the Reservation Details

			JSONObject reseObj = obj.getJSONObject(ReservationKey);
			JSONObject birthDayGuestList = reseObj.getJSONObject("BirthdayGuestDetails");
			JSONArray guestArray = birthDayGuestList.getJSONArray("$values");
			String guestName = null;
			if (guestArray != null) {
				for (int i = 0; i < guestArray.length(); i++) {
					guestName = guestArray.getJSONObject(i).getString("GuestName");
					System.out.println("guestName:" + guestName);
				}
			}

			// Validate the Reservation History Details

			JSONObject historyObj = reseObj.getJSONObject("History");

			JSONArray reseHisArray = historyObj.getJSONArray("$values");
			String reservationStatus = null;
			if (reseHisArray != null) {
				for (int i = 0; i < guestArray.length(); i++) {
					reservationStatus = reseHisArray.getJSONObject(i).getString("ReservationState");
					System.out.println("reservationStatus:" + reservationStatus);
				}
			}

			if (AttributeName != null && guestName != null && reservationStatus != null) {
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
	 * @author : Lankala HariKrishna Date : 27-12-2018
	 * @param string
	 * @return : status of the validateForwardReservationConfirmation
	 */

	public static boolean validateForwardReservationConfirmation(String respBody) {

		return (respBody != null && respBody.equalsIgnoreCase("true")) ? true : false;
	}

	/**
	 * @author : Lankala HariKrishna Date : 02-01-2019
	 * @param string
	 * @return : status of the validateForwardReservationConfirmation
	 */

	public static boolean validateReleaseTempBookingSeat(String respBody) {

		return (respBody != null && respBody.equalsIgnoreCase("true")) ? true : false;
	}

	/**
	 * @author : Lankala HariKrishna Date : 02-01-2019
	 * @param string
	 * @param messageKey
	 * @return : status of the storeDetails
	 */

	public static boolean validateReservationByConfirmation(String respBody, String messageKey) {
		// TODO Auto-generated method stub
		// TODO Auto-generated method stub
		boolean status = false;
		try {
			String jsonData = new String(respBody);

			JSONObject obj = new JSONObject(jsonData);
			JSONObject jobj = obj.getJSONObject(messageKey);
			String storeStatus = jobj.getString("Status");
			boolean errorStatus = jobj.getBoolean("IsError");

			if (errorStatus == false && storeStatus.equalsIgnoreCase("OK")) {
				status = true;
			} else if (errorStatus == true && storeStatus.equalsIgnoreCase("OK")) {
				status = false;
			}

		} catch (Exception ex) {
			System.out.println(ex.toString());
		}

		return status;
	}

	/**
	 * @author : Lankala HariKrishna Date : 19-02-2019
	 * @param string
	 * @param messageKey
	 * @return : status of the StaticContent
	 */

	public static boolean validateStaticContent(String respBody, String mg, String fg) {

		boolean status = false;
		try {
			String jsonData = new String(respBody);
			JSONObject jsonObj = new JSONObject(jsonData);
			JSONArray genderArray = jsonObj.getJSONArray("GenderOptions");
			String gender = null;
			if (genderArray != null) {
				for (int i = 0; i < genderArray.length(); i++) {
					gender = genderArray.getString(i);
					if(gender != null && gender != "" && gender.equalsIgnoreCase(mg) ||
							gender != null && gender != "" && gender.equalsIgnoreCase(fg)	) {
						status = true;
					}else {
						status = false;
					}
					System.out.println("GenderName:" + gender);
				}
			}
			
		} catch (Exception ex) {
			System.out.println(ex.toString());
		}
		return status;
	}

}