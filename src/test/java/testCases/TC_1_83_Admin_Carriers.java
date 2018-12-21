package testCases;

import static org.testng.Assert.assertTrue;

import javax.accessibility.AccessibleRelationSet;

import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;
import ru.yandex.qatools.ashot.util.JsCoords;

public class TC_1_83_Admin_Carriers extends MediatorClass {
	String engineering_carriers_viewAllCarrierAcs = "xpath=//a[@href='/carrier/listAllAccounts/']";
	String engineering_carriers_addCarrier = "xpath=//a[@href='/carrier/add/']";
	String engineering_carriers_addCarrier_carrier_Name ="id=name";
	String engineering_carriers_addCarrier_carrier_notes = "id=notes";
	String engineering_carriers_addCarrier_saveBtn = "xpath=(//button[@type=\"submit\"])[2]";
	// engineering_carriers_addCarrier_details_saveBtn="xpath=//button[@class='btn
	// btn-primary pull-right btn-sm']";
	String engineering_carriers_carrierNames_table = "xpath=//*[@id='carrier_table']/tbody/tr/td[2]";
	String engineering_carriers_carrierNames_magnifier = "//*[@id='carrier_table']/tbody/tr/td[%s]";
	// carrier section locators
	  String engineering_carriers_carrieradd = "xpath=//a[@href='/carrier/add/']";
	String engineering_carriers_carrierSection_saveBtn = "xpath=(//button[@type=\"submit\"])[3]";
	String engineering_carriers_carrierSection_carrierState_DD = "id=carrier_state_id";
	String engineering_carriers_carrierSection_carrier_note = "id=carrier_note";
	String engineering_carriers_carrierSection_manageVLANs = "xpath=//a[starts-with(@href,'/carrier/listVlan/carrier_id')]";
	String engineering_carriers_carrierSection_successPopup = "xpath=//button[@class='btn btn-default center-block']";

	String engineering_carriers_carrierSection_carrierAccountsHeadLine = "xpath=//table[@class='table table-striped table-condensed table-hover']/caption";
	String engineering_carriers_carrierSection_carrierAccounts_tableHeadings = "xpath=//table[@class='table table-striped table-condensed table-hover']/thead/tr/th";
  
	String adminLInk="id=dd-Admin";
	String engineering_carriers_carrierSection_AddCarrierAccount = "xpath=//a[starts-with(@href,'/carrier/addAccount/carrier_id')]";
	String engineering_carriers_carrierSection_AddCarrierAccount_acNumber = "id=carrier_account_number";
	String engineering_carriers_carrierSection_AddCarrierAccount_description = "id=description";
	String engineering_carriers_carrierSection_AddCarrierAccount_addBtn = "xpath=(//button[@type='submit'])[2]";
	String engineering_carriers_carrierAccounts_acNumberTable = "xpath=//table[@class='table table-striped table-condensed table-hover']/tbody/tr/td[2]";
	String engineering_carriers_carrierCircuitPopUps = "xpath=//table[@class='table table-striped table-condensed']/caption";
	String engineering_carriers_carrierCircuitPopUps_TableHeadline_Circuit_Type = "xpath=(//table[@class='table table-striped table-condensed']/thead/tr/th)[1]";
	String engineering_carriers_carrierCircuitPopUps_TableHeadline_pop = "xpath=(//table[@class='table table-striped table-condensed']/thead/tr/th)[3]";
	String engineering_carriers_logEntriesHeadLine = "xpath=(//table[@class='table table-striped table-condensed']/caption)[2]";
	String engineering_carriers_logEntriesTableHeadLines = "xpath=(//table[@class='table table-striped table-condensed']/thead)[2]/tr/th";
	String engineering_carriers_carrierCircuitPopUps_addCircuitType = "xpath=//a[@href='#circuit_type_modal']";
	String engineering_carriers_carrierCircuitPopUps_addCircuitType_circuitType_DD = "id=circuit_type_id";
	String engineering_carriers_carrierCircuitPopUps_addCircuitType_pop_DD = "id=pop_id";
	String engineering_carriers_carrierCircuitPopUps_addCircuitType_addBtn = "xpath=//button[@class='btn btn-primary btn-block btn-sm']";
	String engineering_carriers_carrierCircuitPopUps_deleteBtn = "xpath=//a[@class='carrierCircuitTypeDelete']";
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void tC_1_83_Admin_Carriers(String zUserName, String zPassword) throws Throwable {
		
		logger = extent.startTest("1.83 Test ID : 15244 - ZEUS-ADMIN-24_Admin_Carriers").assignCategory("Admin","Regression test");
		logInfo("TestCase Description:Admin select Engineering and select Carriers,now Verify view all carrier accounts and Add Carrier,Add carrier account,Add circuit type and verify");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		waitForElementPresent(adminLInk, 300);
		actionsClick(adminLInk, "Admin LInk");
		mouseHoverMove(engineering,"Engineering", engineering_carriers,"Carriers");
		// Verify(engineering,engineering_carriers ,engineering_subMenu_headLine,
		// "Carriers");
		String s="className=clearfix";
		System.out.println("**************************************** "+getText(s));
		// verifyText(engineering_subMenu_headLine, "Carriers", "Verifying HeadLine
		// text");

		waitForElementToBeClickable(engineering_carriers_viewAllCarrierAcs);
		Thread.sleep(60000);
		waitForElementPresent(engineering_carriers_viewAllCarrierAcs, 300);
		verifyText(engineering_carriers_viewAllCarrierAcs, "View All Carrier Accounts", "View All Carrier Accounts");
		waitForElementPresent(engineering_carriers_addCarrier, 300);
		actionsClick(engineering_carriers_addCarrier,"Add Carrier");
		Thread.sleep(60000);
		String carrierName = "Priyanka " + randomString(3);
		waitForElementPresent(engineering_carriers_addCarrier_carrier_Name, 300);
		type(engineering_carriers_addCarrier_carrier_Name, carrierName, "Carrier name ");
		type(engineering_carriers_addCarrier_carrier_notes, "test", "Carrier notes");
		waitForElementPresent(engineering_carriers_addCarrier_saveBtn, 300);
		actionsClick(engineering_carriers_addCarrier_saveBtn,"save");
		Thread.sleep(1000);
		waitForElementPresent(adminLInk, 300);
		actionsClick(adminLInk, "Admin LInk");
		mouseHoverMove(engineering,"Engineering", engineering_carriers, "Carriers");
		//Verify(engineering, engineering_carriers, engineering_subMenu_headLine, "Carriers");
		String engineering_carriers_carrierNames_magnifier1 = "xpath=//*[@id='carrier_table']/tbody/tr/td[1]";
		// verifyTextInColumnClickOtherColumnJS(engineering_carriers_carrierNames_table,
		// engineering_carriers_carrierNames_magnifier, carrierName);
		Thread.sleep(30000);
		waitForElementPresent(engineering_carriers_carrierNames_magnifier1, 300);
		actionsClick(engineering_carriers_carrierNames_magnifier1,"Selected any carrier");
		// carrier section
		waitForElementPresent(engineering_carriers_carrierSection_carrierState_DD, 300);
		verifyDropDownValue(engineering_carriers_carrierSection_carrierState_DD, "Active");
		verifyDropDownValue(engineering_carriers_carrierSection_carrierState_DD, "Inactive");
		verifyElementText(engineering_carriers_carrierSection_carrier_note, "");
		waitForElementToBeClickable(engineering_carriers_carrierSection_manageVLANs);
		waitForElementToBeClickable(engineering_carriers_carrierSection_saveBtn);

		if (selectedOptionDroDown(engineering_carriers_carrierSection_carrierState_DD).equalsIgnoreCase("Active")) {
			selectDropDownByVisibleText(engineering_carriers_carrierSection_carrierState_DD, "Inactive");
		} else
			selectDropDownByVisibleText(engineering_carriers_carrierSection_carrierState_DD, "Active");
		clearText(engineering_carriers_carrierSection_carrier_note);
		waitForElementPresent(engineering_carriers_carrierSection_carrier_note, 300);
		type(engineering_carriers_carrierSection_carrier_note, "test edit", "Add carrier state notes");
		waitForElementPresent(engineering_carriers_carrierSection_saveBtn, 300);
		actionsClick(engineering_carriers_carrierSection_saveBtn,"Save");
		waitForElementPresentE(engineering_carriers_carrierSection_successPopup, 200);
		actionsClick(engineering_carriers_carrierSection_successPopup);
		waitForElementPresent(engineering_carriers_carrierSection_carrierAccountsHeadLine, 300);
		verifyText(engineering_carriers_carrierSection_carrierAccountsHeadLine, "Carrier Accounts", "");
		verifyAllListValuesInOrder(engineering_carriers_carrierSection_carrierAccounts_tableHeadings,
				AddElementsIntoList(";Account Number;Description;Bill Day;Active?;Last Invoice"));

;
		Thread.sleep(30000);
		actionsClick(engineering_carriers_carrierSection_AddCarrierAccount,"Add Carrier Account");
		String accountNumber = randomNum(5);
		String description = "test Description " + randomString(3);
		waitForElementPresent(engineering_carriers_carrierSection_AddCarrierAccount_acNumber, 300);
		type(engineering_carriers_carrierSection_AddCarrierAccount_acNumber, accountNumber, "Account number");
		type(engineering_carriers_carrierSection_AddCarrierAccount_description, description, "Description");
		waitForElementPresent(engineering_carriers_carrierSection_AddCarrierAccount_addBtn, 300);
		actionsClick(engineering_carriers_carrierSection_AddCarrierAccount_addBtn,"Save");
		Thread.sleep(9000);
		navigateBack();
		Thread.sleep(8000);
		navigateBack();
		Thread.sleep(8000);
		// carrierCircuitPopUps
		Thread.sleep(8000);
		scrollElementIntoView(engineering_carriers_carrierCircuitPopUps);
		verifyText(engineering_carriers_carrierCircuitPopUps, "Carrier Circuit and Pops for New Circuits", "Verified circuit popups header Text");
        Thread.sleep(9000);
		scrollElementIntoView(engineering_carriers_carrierCircuitPopUps_TableHeadline_Circuit_Type);
		verifyText(engineering_carriers_carrierCircuitPopUps_TableHeadline_Circuit_Type, "Circuit Type", "verified Circuit Type header Text");
		verifyText(engineering_carriers_carrierCircuitPopUps_TableHeadline_pop, "Pop", "verified Pop header Text");
		Thread.sleep(30000);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType, 300);
		actionsClick(engineering_carriers_carrierCircuitPopUps_addCircuitType,"Add Circuit Type");
		Thread.sleep(30000);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType_circuitType_DD, 200);
		selectDropDownByIndex(engineering_carriers_carrierCircuitPopUps_addCircuitType_circuitType_DD, 2);
		selectDropDownByIndex(engineering_carriers_carrierCircuitPopUps_addCircuitType_pop_DD, 2);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType_addBtn, 200);
		actionsClick(engineering_carriers_carrierCircuitPopUps_addCircuitType_addBtn,"Add Circuit type account");
		Thread.sleep(3000);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_deleteBtn, 200);
		JSClick(engineering_carriers_carrierCircuitPopUps_deleteBtn,"Delete circuit type");
		Thread.sleep(9000);
		acceptAlert();
		// checkAll(engineering_carriers_carrierCircuitPopUps_deleteBtn);

		Thread.sleep(8000);
		// Log Entries
		scrollElementIntoView(engineering_carriers_logEntriesHeadLine);
		verifyText(engineering_carriers_logEntriesHeadLine, "Log Entries", "Verified Log Entries header");
		verifyText(engineering_carriers_logEntriesHeadLine, "show all", "Verified show all header");

	}

	
}
