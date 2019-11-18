package com.cec.qa.util;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.WebDriver;
import com.cec.qa.base.BaseTest;

public class TestUtil extends BaseTest{

	//Initializations of Booking Date/Store/etc.
	public static int fubookingDate = 8; // Future Booking date.
	public static int fubookingDateforSunday = 7; // Future Booking date.

	public static long PageLoadTimeOut = 90;
	public static long ImplicitTimeOut = 90;
	public static WebDriver driver;
	public static int tubookingDate = getBookingDateForWeekDay(fubookingDate); // This gets coming WeekDate's (count) by excluding FRI/SAT/SUN and stores in - tubookingDate 
	public static int todaysDate = 2;
	public static int tubookingDateFor90days = 90;
	public static int tubookingDateFor180days = 180;
	public static int tubookingDateForSunday = getBookingDateForSunday(fubookingDateforSunday); // This gets coming Sunday's Date(count) and stores in - tubookingDateForSunday
	
	//OLD BOOKING FUNNEL DATE INITILIZATIONS.
	public static int fuOldBookingNextMonthDate = getOldBookingNextMonthDate();
	
	public static int weekDayCount = getBookingDateForWeekDay(fuOldBookingNextMonthDate);
	public static int weekEndSundayCount = getBookingDateForSunday(fuOldBookingNextMonthDate); 
	
	public static int tuOldBookingWeekDayDate = Integer.parseInt(getFutureDateInMMDDYYYY(weekDayCount).substring(3, 5));
	public static int tuOldBookingDateForSundayDate = Integer.parseInt(getFutureDateInMMDDYYYY(weekEndSundayCount).substring(3, 5));
	public static String tuOldBookingStoreNumber="0031";
	public static String tuCallCenterStoreNumber="0033";
	
	// enter tubookingDate days 0 for today, and 1,2,3..N for future days.
	public static String bLocation = "IRVING, TX, USA"; 
	//STORE NAMES: FRESNO, CA, USA     IRVING, TX, USA   NORTH YORK ONTARIO 
	public static String storeNumber = "12"+getCurrentTimeInSS(); //Used in Call Center Test
	public static String mgrName = getTodaysDateInDay()+getCurrentMonth(); //Used in Call Center Testublic static String mgrName = getTodaysDateInDay()+getCurrentMonth(); //Used in Call Center Test
	
	//Method to get future booking date by excluding FRI/SAT/SUN.
	public static int getBookingDateForWeekDay(int fubookingDate){
		String bookingDay=null;
		bookingDay = getGivenDateInDay(fubookingDate);
		//Below block checks and re-initializes right date in that week/next week to be considered as booking date.
		if(bookingDay.equals("FRI")){
			tubookingDate = fubookingDate + 4;
		}else if(bookingDay.equals("SAT")){
			tubookingDate = fubookingDate + 3;
		}else if(bookingDay.equals("SUN")){
			tubookingDate = fubookingDate + 2;
		}else if(bookingDay.equals("MON") || bookingDay.equals("TUE") || bookingDay.equals("WED") || bookingDay.equals("THU")){
			tubookingDate = fubookingDate;
		}
		return tubookingDate;
	}

	//Method to get future booking date by excluding MON/TUE/WED/FRI/SAT.
	public static int getBookingDateForSunday(int fubookingDateforSunday){
		String bookingDay=null;
		bookingDay = getGivenDateInDay(fubookingDateforSunday);
		//Below block checks and re-initializes right date in that week/next week to be considered as booking date.
		if(bookingDay.equals("MON")){
			tubookingDateForSunday = fubookingDateforSunday + 6;
		}else if(bookingDay.equals("TUE")){
			tubookingDateForSunday = fubookingDateforSunday + 5;
		}else if(bookingDay.equals("WED")){
			tubookingDateForSunday = fubookingDateforSunday + 4;
		}else if(bookingDay.equals("THU")){
			tubookingDateForSunday = fubookingDateforSunday + 3;
		}else if(bookingDay.equals("FRI")){
			tubookingDateForSunday = fubookingDateforSunday + 2;
		}else if(bookingDay.equals("SAT")){
			tubookingDateForSunday = fubookingDateforSunday + 1;
		}else if(bookingDay.equals("SUN")){
			tubookingDateForSunday = fubookingDateforSunday;
		}
		return tubookingDateForSunday;
	}


	//Method to get Next Month for booking by comparing with current month.
	public static int getNextMonthForFutureBooking(){
		String currentMonth=getCurrentMonth();
		int nextMonth = 0;
		if(currentMonth.equals("JAN")){
			nextMonth = 2;
		}else if(currentMonth.equals("FEB")){
			nextMonth = 3;
		}else if(currentMonth.equals("MAR")){
			nextMonth = 4;
		}else if(currentMonth.equals("APR")){
			nextMonth = 5;
		}else if(currentMonth.equals("MAY")){
			nextMonth = 6;
		}else if(currentMonth.equals("JUN")){
			nextMonth = 7;
		}else if(currentMonth.equals("JUL")){
			nextMonth = 8;
		}else if(currentMonth.equals("AUG")){
			nextMonth = 9;
		}else if(currentMonth.equals("SEP")){
			nextMonth = 10;
		}else if(currentMonth.equals("OCT")){
			nextMonth = 11;
		}else if(currentMonth.equals("NOV")){
			nextMonth = 12;
		}else if(currentMonth.equals("DEC")){
			nextMonth = 1;
		}
		return nextMonth;
	}


	//Method to get Next Month booking date by excluding FRI/SAT/SUN.
	public static int getOldBookingNextMonthDate(){
		int daysCount=0;
		try {
		//This block gets date of future date of next month.
		int vMonth = TestUtil.getNextMonthForFutureBooking();
		int vYear = Calendar.getInstance().get(Calendar.YEAR);
		String fdateString = String.format("%d-%d-%d", vYear, vMonth, 15);
		Date fDate = new SimpleDateFormat("yyyy-M-d").parse(fdateString);
		String vDay = fDate.toString();
		//System.out.println(vDay.substring(0,3).toUpperCase());

		//This block gets current date of current month. 
		int vDate = Integer.parseInt(getCurrentTimeInDD());
		String cdateString = String.format("%d-%d-%d",vYear,vMonth-1,vDate);
		Date cDate = new SimpleDateFormat("yyyy-M-d").parse(cdateString);


		//This block gets count between current date and future  date.
		SimpleDateFormat myFormat = new SimpleDateFormat("yyyy-M-d");
		Date dateBefore = myFormat.parse(fdateString);
		Date dateAfter = myFormat.parse(cdateString);
		long difference = dateBefore.getTime() - dateAfter.getTime();
		float daysBetween = (difference / (1000*60*60*24));
		daysCount = Math.round(daysBetween);
		//System.out.println(daysCount);
		return daysCount;
	} catch (Exception e) {
		e.printStackTrace();
		System.out.println("Found Issue in Method:getOldBookingNextMonthDateForWeekDay() ");
	}
	return daysCount;
		
	}
	
}
