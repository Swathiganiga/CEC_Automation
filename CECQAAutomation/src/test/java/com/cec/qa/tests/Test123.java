package com.cec.qa.tests;

import java.awt.AWTException;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.KidsBirthdayPartyPage;
import com.cec.qa.util.TestUtil;

public class Test123 extends BaseTest{

    //Test vivek
	@Test
	public void testabc(){

		int vDate = Integer.parseInt(getCurrentTimeInDD());
		System.out.println("$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$"+vDate);
		clickOnAvailableDate(driver,vDate);
		
		String x = "6/15/2019 8:00:00 AM";
		
		System.out.println(x.length());
	}
	
	
}
	
	


