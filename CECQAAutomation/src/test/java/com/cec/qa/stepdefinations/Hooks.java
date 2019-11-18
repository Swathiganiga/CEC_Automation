package com.cec.qa.stepdefinations;





import com.cec.qa.base.BaseTest;
import com.cec.qa.pages.BrandBookingBirthdayPage;

import cucumber.api.java.After;
import cucumber.api.java.Before;

public class Hooks extends BaseTest {
		BrandBookingBirthdayPage brandBookingBirthdayPage;
		private static boolean flag = false;
		private static boolean flag1 = false;
	@Before({"@test", "~@test3", "~@event4", "~@event", "~@test16", "~@test18"})
	public void setUp() throws Exception {
		 
		System.out.println("done init");
		initialization(propv.getProperty("GUI"),propv.getProperty("NBB"));
		 
	}
	
	@Before("@test18, @test16")
	public void setup() throws Exception
	{
		System.out.println("test init16");
		initialization(propv.getProperty("GUIE"),propv.getProperty("NBB"));
	}
	@Before("@test3")
	public void setUps() throws Exception {
		  if(flag==false) {
		        flag=true;
		System.out.println("done init2");
		initialization(propv.getProperty("GUI"),propv.getProperty("NBB"));
		 
	}
	}
	@Before("@event4")
	public void setUp2() throws Exception {
		  if(flag1==false) {
		        flag1=true;
		System.out.println("done init3");
		initialization(propv.getProperty("GUI"),propv.getProperty("NBE"));
		 
	}
	}
	@Before({"@event", "~@event4", "~@event12"})
	public void eventsetup() throws Exception
	{
		System.out.println("event init3");
		initialization(propv.getProperty("GUI"),propv.getProperty("NBE"));
	}
	@Before({"@event12"})
	public void eventsetup12() throws Exception
	{
		System.out.println("event init12");
		initialization(propv.getProperty("GUIE"),propv.getProperty("NBE"));
	}
	
	@Before("@test100")
	public void set100() throws Exception{
		initialization(propv.getProperty("GUIM"),propv.getProperty("NBB"),"");
	}
	}

