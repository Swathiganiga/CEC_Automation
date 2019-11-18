package com.cec.qa.data;

import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class CallCenterLocators {
	
	public static WebDriver driver;
	
/*	public static void ObjRep() {
		//super();
	}*/
	
	public static String loginOutlook = "//*[@id=\"Outlook\"]";
	@FindBy(how=How.XPATH, using="//*[@id=\"Outlook\"]")
	public WebElement login_outlook;
	
	@FindBy(how=How.CSS, using="[title='Review']")
	public WebElement btnReviewMenu;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id,'ReservationTypeId')]")
	public WebElement ReservationTypeId;
	
	@FindBy(how=How.XPATH, using="//*[@id='ReservationTypeId']//*[text()='Birthday']")
	public WebElement txtReservationBirthday;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id,'ReservationTypeId')]//*[text()='Organizational']")
	public WebElement txtReservationOrganizational;
	
	@FindBy(how=How.XPATH, using="//*[starts-with(@id,'ReservationTypeId')]//*[text()='Fund Raising']")
	public WebElement txtReservationFundRaising;
	
	@FindBy(how=How.ID, using="Search")
	public WebElement btnSearch;
	
	@FindBy(how=How.ID, using="Reservations")
	public WebElement drpDwnReservations;
	
	@FindBy(how=How.ID, using="btnChange")
	public WebElement btnChange;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Birthday')]")
	public WebElement txtBirthday;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Organizational')]")
	public WebElement txtOrganizational;
	
	@FindBy(how=How.XPATH, using="//div[contains(text(),'Fund Raising')]")
	public WebElement txtFundRaising;
		
	@FindBy(how=How.ID, using="reservationStateNameID")
	public WebElement txtStateNameID;
	
	@FindBy(how=How.ID, using="BtnConfirm")
	public WebElement btnConfirm;
	
	@FindBy(how=How.ID, using="btnNew")
	public WebElement btnNew;
	
	@FindBy(how=How.CSS, using="[title='Party']")
	public WebElement btnPartyMenu;
	
//	@FindBy(how=How.CSS, using="[title='Party Type Category']")
//	public WebElement btnPartyTypeCategory;
	
	@FindBy(how=How.XPATH, using="//*[@title='Party Type Category']")
	public WebElement btnPartyTypeCategoryXpath;
	
	@FindBy(how=How.XPATH, using="//*[@href='/PartyType/Create']")
	public WebElement btnPartyType;
	
	@FindBy(how=How.ID, using="txtName")
	public WebElement txtName;
								
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Enter only alphanumeric')]")
	public WebElement txtAlphanumeric;
	
	@FindBy(how=How.ID, using="txtdisplayName")
	public WebElement txtDisplayName;
	
	@FindBy(how=How.ID, using="txtDescription")
	public WebElement txtDescription;
	
	@FindBy(how=How.ID, using="Reservations")
	public WebElement drpReservationType;
	
	@FindBy(how=How.ID, using="CallOutOptionID")
	public WebElement drpCallOutOption;
	
	@FindBy(how=How.ID, using="CallOutColorID")
	public WebElement drpCallOutColor;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),\"Order has been confirmed.\")]")
	public WebElement txtOrderConfirmed;
	
	@FindBy(how=How.NAME, using="txtstorenumb")
	public WebElement txtstorenumb;
	
	@FindBy(how=How.XPATH, using="//*[@id='PromotionCategoryItems']/option")
	public List<WebElement> drpselectLastElement;
	 
	@FindBy(how=How.ID, using="btnUpdate")
	public WebElement btnUpdate;
	
	@FindBy(how=How.ID, using="errorMsg")
	public WebElement txtUpdatePartyTypeCategoryErrorMsg;
	
	@FindBy(how=How.ID, using="btnDelete")
	public WebElement btnDeletePartyTypeCategory;
	
	@FindBy(how=How.XPATH, using="//button[contains(text(),'OK')]")
	public WebElement btnOkDeletePartyTypeCategory;
	
	@FindBy(how=How.XPATH, using="//legend[contains(text(),'Store Information')]")
	public WebElement txtStoreInformation;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Chuck E. Cheese's Party Reservation')]")
	public WebElement txtTitleOfApp;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Call Center Manager')]")
	public WebElement txtCallCenterManager;
	
	@FindBy(how=How.XPATH, using="html/body/div[3]/div/div[2]/p/span")
	public WebElement txtTitle;	
	
	@FindBy(how=How.XPATH, using="//div[3]/div/div[3]/p[1]/label[2]")
	public WebElement txtUserName;
	
	@FindBy(how=How.XPATH, using="//div[3]/div/div[3]/p[1]/label[4]")
	public WebElement txtUserRole;
	
	@FindBy(how=How.XPATH, using="//a[@title='Restaurant']")
	public WebElement btnRestaurantMenu;
	
	//@FindBy(how=How.XPATH, using="//a[@title='Promotion / Upsell']")
	@FindBy(how=How.XPATH, using="//a[@href='/PromotionUpsells/PromotionUpsell']")
	public WebElement btnPromotionMenu;
	
	@FindBy(how=How.XPATH, using="//a[@title='Configuration']")
	public WebElement btnConfigurationMenu;
	
	@FindBy(how=How.XPATH, using="//a[@title='User']")
	public WebElement btnUserMenu;
	
	@FindBy(how=How.XPATH, using="//a[@id='hlnkParameters']")
	public WebElement btnReportMenu;
	
	@FindBy(how=How.XPATH, using=".//*[@id='txtchildren']")
	public WebElement txtChildren;
	
	@FindBy(how=How.XPATH, using=".//*[@id='txtadults']")
	public WebElement txtAdults;
	
	@FindBy(how=How.XPATH, using=".//*[@id='btnShowCalendar']")
	public WebElement btnShowCalendar;
	
	
	@FindBy(how=How.ID, using="drpReservType")
	public WebElement selectReservationsType;
	
	@FindBy(how=How.NAME, using=" optionalpartyitem.itemtype")
	public List<WebElement> selectTimeSlot;
	
	@FindBy(how=How.NAME, using="rdotype")
	public List<WebElement> selectPkg;
	
	@FindBy(how=How.NAME, using="btnNext")
	public WebElement btnNext;
	
	@FindBy(how=How.NAME, using="reservation.ReservationGuestDetails.OrganizationName")
	public WebElement txtOrganizationName;
	
	@FindBy(how=How.NAME, using="reservation.ReservationGuestDetails.OrganizationPhone")
	public WebElement txtOrganizationPhone;
	
	@FindBy(how=How.NAME, using="reservation.CustomerName")
	public WebElement txtCustomerName;
	
	@FindBy(how=How.NAME, using="reservation.Phone1")
	public WebElement txtContactphone;
	
	@FindBy(how=How.XPATH, using=".//*[@id='next']")
	public WebElement btnText;
	
	@FindBy(how=How.ID, using="btnClose")
	public WebElement btnClose;
	
	@FindBy(how=How.XPATH, using="//td[@class='cal-available']")
	public List<WebElement> availableDats;
	
	@FindBy(how=How.XPATH, using="//*[@id='btnNext']")
	public WebElement btnNextHomePage;
	
	@FindBy(how=How.XPATH, using=".//*[@id='name']")
	public WebElement txtGuestName;
	
	@FindBy(how=How.XPATH, using=".//*[@id='age']")
	public WebElement txtage;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'A̲dd')]")
	public WebElement btnA̲dd;
	
	@FindBy(how=How.XPATH, using=".//*[@id='CustomerName']")
	public WebElement btnCustomerName;
	
	@FindBy(how=How.XPATH, using=".//*[@id='Phone1']")
	public WebElement txtPhone1;
	
	@FindBy(how=How.XPATH, using=".//*[@id='Email']")
	public WebElement txtEmail;
	
	@FindBy(how=How.XPATH, using=".//*[@id='Ext1']")
	public WebElement txtExt1;
	
	@FindBy(how=How.XPATH, using="//*[@id='btnbook']")
	public WebElement btnBook;
	
	@FindBy(how=How.XPATH, using="//*[@id='lblBookCNFNo']")
	public WebElement btnlblBookCNFNo;
	
	@FindBy(how=How.ID, using="btnfinish")
	public WebElement btnfinish;
	
	@FindBy(how=How.ID, using="ConfirmationNumber")
	public WebElement txtConfirmationNumber;
	
	@FindBy(how=How.CSS, using=".col-md-7.col-sm-7.colour-green.col-xs-9")
	public WebElement txtconfID;
	
	@FindBy(how=How.NAME, using="PartyTypeTitle")
	public WebElement btnPartyTypeTitle;
	
	@FindBy(how=How.XPATH, using="//*[@id='Price']")
	public WebElement txtPrice;
	
	@FindBy(how=How.XPATH, using="//*[@id='PromotionCategoryID']/option[@value='1']")
	public WebElement btnPromotionCategory;
	
	@FindBy(how=How.XPATH, using="//*[@id='TypeCategory']")
	public WebElement btnTypeCategory;
	
	@FindBy(how=How.XPATH, using="//*[@id='IsActive']")
	public WebElement chkIsActive;
	
	@FindBy(how=How.XPATH, using="//input[@value='Add']")
	public WebElement btnAdd;
	
	@FindBy(how=How.XPATH, using="//*[@id='errMsgPType']")
	public WebElement txtErrMsgPType;
	
	@FindBy(how=How.XPATH, using="//*[@id='Address']")
	public WebElement txtAddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='Phone2']")
	public WebElement txtPhone2;
	
	@FindBy(how=How.XPATH, using="//*[@id='Ext2']")
	public WebElement txtExt2;
	
	@FindBy(how=How.XPATH, using="//*[@id='City']")
	public WebElement txtCity;
	
	@FindBy(how=How.XPATH, using="//*[@ id='State']")
	public WebElement txtState;

	@FindBy(how=How.XPATH, using="//*[@id='ZipCode']")
	public WebElement txtZipCode;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_Comments']")
	public WebElement txtCustomerComments;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_CallCenterComments']")
	public WebElement txtAgentComments;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_SchoolName']")
	public WebElement txtFundRaisingGuestDetailsSchoolName;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_Phone']")
	public WebElement txtFundRaisingGuestDetailsPhone;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_PrincipalName']")
	public WebElement txtFundRaisingGuestDetailsPrincipalName;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_PhoneExt']")
	public WebElement txtFundRaisingGuestDetailsPhoneExt;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_Address']")
	public WebElement txtFundRaisingGuestDetailsAddress;
	
	@FindBy(how=How.XPATH, using="//*[@id='reservation_ReservationFundRaisingGuestDetails_NumberOfStudents']")
	public WebElement txtFundRaisingGuestDetails_NumberOfStudents;
	
	@FindBy(how=How.XPATH, using="//*[@id='btnfundBook']")
	public WebElement btnfundBook;
	
	@FindBy(how=How.ID, using="lblfundCNFNo")
	public WebElement txtlblfundCNFNo;
	
	@FindBy(how=How.ID, using="btnfundFinish")
	public WebElement btnfundFinish;
	
	@FindBy(how=How.NAME, using="reservation.ReservationGuestDetails.OrgPhoneExt")
	public WebElement txtOrgPhoneExt;
	
	@FindBy(how=How.NAME, using="reservation.Email")
	public WebElement txtReservationEmail;
	
	@FindBy(how=How.NAME, using="reservation.Address")
	public WebElement txtReservationAddress;
	
	@FindBy(how=How.NAME, using="reservation.Ext1")
	public WebElement txtReservationExt1;
	
	@FindBy(how=How.NAME, using="reservation.Phone2")
	public WebElement txtReservationPhone2;
	
	@FindBy(how=How.NAME, using="reservation.Ext2")
	public WebElement txtReservationExt2;
	
	@FindBy(how=How.NAME, using="reservation.City")
	public WebElement txtReservationCity;
	
	@FindBy(how=How.NAME, using="reservation.State")
	public WebElement txtReservationState;
	
	@FindBy(how=How.NAME, using="reservation.ZipCode")
	public WebElement txtReservationZipCode;
	
	@FindBy(how=How.XPATH, using="//input[@value='Add']")
	public WebElement btnAddParty;
	
	@FindBy(how=How.XPATH, using="//span[contains(text(),'Required')]")
	public WebElement txtRequiredError;
	
	@FindBy(how=How.CSS, using="[title='Minimum Children Setup']")
	public WebElement btnMinimumChildrenSetup;
	
	@FindBy(how=How.ID, using="radioStoreLevel")
	public WebElement rdoStoreLevel;
	
	@FindBy(how=How.ID, using="StoreList")
	public WebElement selectStoreList;
	
	@FindBy(how=How.ID, using="txtStartTime_Monday_0")
	public WebElement txtStartTime_Monday;
	
	@FindBy(how=How.ID, using="txtEndTime_Monday_0")
	public WebElement txtEndTime_Monday;
	
	@FindBy(how=How.ID, using="txtMinChild_Monday_0")
	public WebElement txtMinChild_Monday;
	
	@FindBy(how=How.XPATH, using="//input[@id='btnAdd' and @class='btn btn-default']")
	public WebElement btnMinChildAdd;
	
	@FindBy(how=How.XPATH, using="//*[contains(@text(),'Record saved successfully')]")
	public WebElement txtRecordSaved;
	
	@FindBy(how=How.CSS, using="//*[@href='/BookingNewParty']")
	public WebElement btnBookMenu;
	
	@FindBy(how=How.CSS, using="//*[starts-with(@text,'This wave has a minimum children requirement which')]")
	public WebElement popUpError;
	
	@FindBy(how=How.XPATH, using="//*[contains(text(),'Yes')]")
	public WebElement popUpErrorYes;
	
	@FindBy(how=How.XPATH, using="//*[@id='StoreNumber']")
	public WebElement StoreNumber;
	
	@FindBy(how=How.XPATH, using="//*[@id='StoreName']")
	public WebElement StoreName;
	
	@FindBy(how=How.XPATH, using="//*[@id='drpCountry']")
	public WebElement drpCountry;
	
	@FindBy(how=How.XPATH, using="//*[@id='ManagerName']")
	public WebElement txtManagerName;
	
	@FindBy(how=How.XPATH, using="//*[@id='PublishedNumber']")
	public WebElement txtPublishedNumber;
	
	@FindBy(how=How.XPATH, using="//*[@id='IVRNumber']")
	public WebElement txtIVRNumber;
	
	@FindBy(how=How.XPATH, using="//*[@id='PhoneNumber']")
	public WebElement txtPhoneNumber;
	
	@FindBy(how=How.XPATH, using="//a[@href='/StoreConfiguration/Create']")
	public WebElement btnCreateNew;
	
	@FindBy(how=How.XPATH, using="//*[@id='PaymentGatewayId']")
	public WebElement selPaymentGatewayId;
	
	@FindBy(how=How.XPATH, using="//*[@id='ProcessorId']")
	public WebElement selProcessorId;
	
	@FindBy(how=How.XPATH, using="//*[@id='btnSave']")
	public WebElement btnSave;
	
	@FindBy(how=How.XPATH, using="//*[@title='Upsell Category']")
	public WebElement btnUpsellCategory;
	
	@FindBy(how=How.XPATH, using="//*[@title='Item Page']")
	public WebElement btnItemPage;
	
	@FindBy(how=How.XPATH, using="//*[@title='Item Group']")
	public WebElement btnItemGroup;
	
	@FindBy(how=How.XPATH, using="//*[@title='Item Category']")
	public WebElement btnItemCategory;
	
	@FindBy(how=How.XPATH, using="//*[@title='Party Item']")
	public WebElement btnPartyItem;
	
//	@FindBy(how=How.XPATH, using="//*[@title='Party Type Category']")
//	public WebElement btnPartyTypeCategory;
	
//	@FindBy(how=How.XPATH, using="//*[@title='Party Type']")
//	public WebElement btnPartyType;
	
	@FindBy(how=How.XPATH, using="//*[@title='Party Package']")
	public WebElement btnPartyPackage;
	
	@FindBy(how=How.XPATH, using="//*[@title='Seating Percentage']")
	public WebElement btnSeatingPercentage;
	
	@FindBy(how=How.XPATH, using="//*[@id='submenu']/li[10]/a")
	public WebElement btnsubmenu10;
	
	@FindBy(how=How.XPATH, using="//*[@id='submenu']/li[11]/a")
	public WebElement btnsubmenu11;
	
	@FindBy(how=How.XPATH, using="//a[@href='/PromotionCategories/PartyTypeCategory']")
	public WebElement btnPartyTypeCategory;
	
	@FindBy(how=How.ID, using="selImageAN")
	public WebElement btnSelImageAN;
	
	@FindBy(how=How.ID, using="ImgTag")
	public WebElement btnImgTag;
	
	@FindBy(how=How.ID, using="okClickAN")
	public WebElement btnokClickAN;
	
	@FindBy(how=How.ID, using="NameError")
	public WebElement btnNameError;
	
	@FindBy(how=How.ID, using="btnReset")
	public WebElement btnReset;
	
	@FindBy(how=How.ID, using="DisplyNameError")
	public WebElement txtDisplyNameError;
	

	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	public CallCenterLocators(WebDriver driver)
	{
		this.driver = driver;
	}
	

	
	
	
}
