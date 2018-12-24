package testCases;

import static org.testng.Assert.assertTrue;

import javax.accessibility.AccessibleRelationSet;

import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;
import ru.yandex.qatools.ashot.util.JsCoords;
import utils.AssertSoftly;

public class TC_1_83_Admin_Carriers extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:In CDRConfig Page Verify On/Off Buttons And Add
	 * Link_Manage_SFTP_Credentials Account
	 */

	@Test(alwaysRun = true, enabled = true)
	public void tC_1_83_Admin_Carriers(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx and and configuration file - LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String verifytext1 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 1);
		String tyepTxt1 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 2);
		String activeTxt = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 3);
		String inActiveTxt = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 4);
		String tyepTxt2 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 5);
		String verifytext2 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 6);
		String verifytext3 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 7);
		String verifytext4 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 8);
		String verifytext5 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 9);
		String verifytext6 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 10);
		String verifytext7 = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 11);
		String carrierNameTxt = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 12);
		String accountNumberTxt = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 13);
		String listElements = getTestData(this.getClass().getSimpleName()
				.substring(0, 8), 14);
		String carrierName = carrierNameTxt + randomString(3);
		String accountNumber = randomNum(5);
		String description = accountNumberTxt + randomString(3);

		// * logger method for report starting from here
		logger = extent.startTest(
				"1.83 Test ID : 15244 - ZEUS-ADMIN-24_Admin_Carriers")
				.assignCategory("Admin", "Regression test");
		logInfo("TestCase Description:Admin select Engineering and select Carriers,now Verify view all carrier accounts and Add Carrier,Add carrier account,Add circuit type and verify");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(adminLInk, 300);
		actionsClick(adminLInk, "Admin LInk");
		mouseHoverMove(engineering, "Engineering", engineering_carriers,
				"Carriers");

		waitForElementToBeClickable(engineering_carriers_viewAllCarrierAcs);
//		Thread.sleep(60000);
		waitForElementPresent(engineering_carriers_viewAllCarrierAcs, 300);

		isassert = verifyText(engineering_carriers_viewAllCarrierAcs,
				verifytext1, "View All Carrier Accounts");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext1);

		waitForElementPresent(engineering_carriers_addCarrier, 300);
		actionsClick(engineering_carriers_addCarrier, "Add Carrier");
//		Thread.sleep(60000);

		waitForElementPresent(engineering_carriers_addCarrier_carrier_Name, 300);
		type(engineering_carriers_addCarrier_carrier_Name, carrierName,
				"Carrier name ");
		type(engineering_carriers_addCarrier_carrier_notes, tyepTxt1,
				"Carrier notes");
		waitForElementPresent(engineering_carriers_addCarrier_saveBtn, 300);
		actionsClick(engineering_carriers_addCarrier_saveBtn, "save");
//		Thread.sleep(1000);
		waitForElementPresent(adminLInk, 300);
		actionsClick(adminLInk, "Admin LInk");
		mouseHoverMove(engineering, "Engineering", engineering_carriers,
				"Carriers");

//		Thread.sleep(30000);
		waitForElementPresent(engineering_carriers_carrierNames_magnifier1, 300);
		actionsClick(engineering_carriers_carrierNames_magnifier1,
				"Selected any carrier");
		// carrier section
		waitForElementPresent(engineering_carriers_carrierSection_carrierState_DD, 300);

		isassert = verifyDropDownValue(engineering_carriers_carrierSection_carrierState_DD, activeTxt);
		softassert.assertEquals(isassert, true, "Verified text " + activeTxt);

		isassert = verifyDropDownValue(engineering_carriers_carrierSection_carrierState_DD,inActiveTxt);
		softassert.assertEquals(isassert, true, "Verified text " + inActiveTxt);
		
		isassert = verifyElementText(
				engineering_carriers_carrierSection_carrier_note, "");
		softassert.assertEquals(isassert, true, "Verified text "+ engineering_carriers_carrierSection_carrier_note);
		waitForElementToBeClickable(engineering_carriers_carrierSection_manageVLANs);
		waitForElementToBeClickable(engineering_carriers_carrierSection_saveBtn);

		if (selectedOptionDroDown(
				engineering_carriers_carrierSection_carrierState_DD)
				.equalsIgnoreCase(activeTxt)) {
			selectDropDownByVisibleText(
					engineering_carriers_carrierSection_carrierState_DD,
					inActiveTxt);
		}

		selectDropDownByVisibleText(engineering_carriers_carrierSection_carrierState_DD, activeTxt);
		clearText(engineering_carriers_carrierSection_carrier_note);
		waitForElementPresent(engineering_carriers_carrierSection_carrier_note,300);
		type(engineering_carriers_carrierSection_carrier_note, tyepTxt2,"Add carrier state notes");
		waitForElementPresent(engineering_carriers_carrierSection_saveBtn, 300);
		actionsClick(engineering_carriers_carrierSection_saveBtn, "Save");
		waitForElementPresentE(engineering_carriers_carrierSection_successPopup, 200);
		actionsClick(engineering_carriers_carrierSection_successPopup);
		waitForElementPresent(engineering_carriers_carrierSection_carrierAccountsHeadLine,300);

		isassert = verifyText(engineering_carriers_carrierSection_carrierAccountsHeadLine,verifytext2, "");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext2);

		isassert = verifyAllListValuesInOrder(engineering_carriers_carrierSection_carrierAccounts_tableHeadings,AddElementsIntoList(listElements));
		softassert.assertEquals(isassert, true, "Verified text " + listElements);

		Thread.sleep(30000);
		actionsClick(engineering_carriers_carrierSection_AddCarrierAccount,"Add Carrier Account");
		waitForElementPresent(engineering_carriers_carrierSection_AddCarrierAccount_acNumber,300);
		type(engineering_carriers_carrierSection_AddCarrierAccount_acNumber,accountNumber, "Account number");
		type(engineering_carriers_carrierSection_AddCarrierAccount_description,description, "Description");
		waitForElementPresent(engineering_carriers_carrierSection_AddCarrierAccount_addBtn, 300);
		actionsClick(engineering_carriers_carrierSection_AddCarrierAccount_addBtn,"Save");
		Thread.sleep(9000);
		navigateBack();
		Thread.sleep(8000);
		navigateBack();
		Thread.sleep(8000);
		// * carrierCircuitPopUps
		Thread.sleep(8000);
		scrollElementIntoView(engineering_carriers_carrierCircuitPopUps);
		
		isassert = verifyText(engineering_carriers_carrierCircuitPopUps, verifytext3, "Verified circuit popups header Text");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext3);
		
		Thread.sleep(9000);
		scrollElementIntoView(engineering_carriers_carrierCircuitPopUps_TableHeadline_Circuit_Type);
		isassert = verifyText(engineering_carriers_carrierCircuitPopUps_TableHeadline_Circuit_Type, verifytext4, "verified Circuit Type header Text");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext4);
		
		isassert = verifyText(engineering_carriers_carrierCircuitPopUps_TableHeadline_pop,verifytext5, "verified Pop header Text");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext5);
		
		Thread.sleep(30000);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType, 300);
		actionsClick(engineering_carriers_carrierCircuitPopUps_addCircuitType,"Add Circuit Type");
		Thread.sleep(30000);
		
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType_circuitType_DD,200);
		selectDropDownByIndex(engineering_carriers_carrierCircuitPopUps_addCircuitType_circuitType_DD,	2);
		selectDropDownByIndex(engineering_carriers_carrierCircuitPopUps_addCircuitType_pop_DD,2);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_addCircuitType_addBtn,200);
		actionsClick(engineering_carriers_carrierCircuitPopUps_addCircuitType_addBtn,"Add Circuit type account");
		Thread.sleep(3000);
		waitForElementPresent(engineering_carriers_carrierCircuitPopUps_deleteBtn, 200);
		JSClick(engineering_carriers_carrierCircuitPopUps_deleteBtn,"Delete circuit type");
		Thread.sleep(9000);
		acceptAlert();

		Thread.sleep(8000);
		// Log Entries
		scrollElementIntoView(engineering_carriers_logEntriesHeadLine);
		
		isassert = verifyText(engineering_carriers_logEntriesHeadLine,verifytext6, "Verified Log Entries header");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext6);
		
		isassert = verifyText(engineering_carriers_logEntriesHeadLine,verifytext7, "Verified show all header");
		softassert.assertEquals(isassert, true, "Verified text " + verifytext6);

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}

}
