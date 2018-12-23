package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class TC_1_70_Admin_Recon_Mac_Mapping extends MediatorClass {
	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${CDRConfig}
	 * @Date ${}
	 * @Modified ${12/08/2018}
	 */
	/**
	 * TestCase Description:Verify if user is able to add, edit and delete an
	 * existing Recon MAC Product Mapping
	 */
	@Test(alwaysRun = true, enabled = true)
	public void tC_1_70_Admin_Recon_Mac_Mapping(ITestContext context)
			throws Throwable {

		// * Below variables written to get input data from excel
		// sheet-Testdata.xlsx and and configuration file -
		// LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String subject = "Automation test" + randomString(2);
		String description = "Auto test " + randomString(3);
		String modifiedSubject = "Automation Modified " + randomString(3);
		String excustomerid = randomNum(4);
		String excustomerquoteid = randomNum(4);
		String excustomercaseid = randomNum(4);
		String advnaceContactSearchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String reconSearchTxt = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);

		// * logger method for report starting from here
		logger = extent.startTest("1.70 Test ID : 17956 - Verify if user is able to add, edit and delete an existing Recon MAC Product Mapping").assignCategory("Admin");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:Verify if user is able to add, edit and delete an existing Recon MAC Product Mapping");
		// * Below Code written to verify login
		login(zUserName, zPassword);

		setBrowserTo80Size();
		waitForElementPresent(admin_menu, 300);
		click(admin_menu, "Admin menu");
		click(admin_menu_reconcilation, "reconcilation");
		aJSClick(admin_menu_reconcilation_reconmac_mapping,
				"reconcilation_reconmac_mapping");

		// Add Mapping
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping, 300);
		aJSClick(admin_menu_reconcilation_reconmac_mapping_addmapping,"Reconcilation - addmapping");
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield,	300);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield,subject, "reconcilation name");

		// String
		// selectedText=getText(reports_projectBtPM_projectViewEditPage_addTask_taskSelection_DD_searchBox_result);
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD,300);
		actionsClick(admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD,"Reconcilation-addmapping-pactname-DD");
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD_searchtextfield,300);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD_searchtextfield,advnaceContactSearchTxt, "PCAT entered");
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_pactname_DD_searchtextfield,"", Keys.ENTER);
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_save, 300);
		JSClick(admin_menu_reconcilation_reconmac_mapping_addmapping_save,"Reconcilation-addmapping-save");
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_ok, 300);
		click(admin_menu_reconcilation_reconmac_mapping_addmapping_ok,"Addmapping-Ok");
		Thread.sleep(8000);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_search_field,subject, "Search ");
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_search_field,"", Keys.ENTER);
		click(admin_menu_reconcilation_recoeNameTable, "Addmapping-Ok");
		verifyTextInColumnClickOtherColumn(admin_menu_reconcilation_recoeNameTable,admin_menu_reconcilation_editIconTable, subject);

		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield,
				300);

		clearText(admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_Reconname_textfield,modifiedSubject, "recon name entered");
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_save, 300);
		click(admin_menu_reconcilation_reconmac_mapping_addmapping_save, "save");
		Thread.sleep(6000);
		JSClick(admin_menu_reconcilation_reconmac_mapping_addmapping_ok,"AddMapping-Ok");
		logPass("Reconcilation Add mapping done successfully");
		waitForElementPresent(admin_menu_reconcilation_reconmac_mapping_addmapping_search_field,300);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_search_field,modifiedSubject, "Search");
		System.out.println(subject);
		System.out.println(modifiedSubject);
		type(admin_menu_reconcilation_reconmac_mapping_addmapping_search_field,"", Keys.ENTER);
		waitForElementPresent(admin_menu_reconcilation_recoeNameTable, 300);
		verifyTextInColumnClickOtherColumn(admin_menu_reconcilation_recoeNameTable,admin_menu_reconcilation_deleteIconTable, modifiedSubject);
		logInfo("Added mapping present in the table");

		Thread.sleep(5000);
		waitForElementPresentE(admin_menu_reconcilation_deleteMapping, 300);
		JSClick(admin_menu_reconcilation_deleteMapping, "Delete Mapping");

		waitForElementPresent(admin_menu_reconcilation_successMsg, 300);
		isassert = verifyText(admin_menu_reconcilation_successMsg, reconSearchTxt, "reconSearchTxt");
		softassert.assertEquals(isassert, true,"Verified customer id reconSearchTxt in customer table");

		logPass("Reconcilation MAC Product Mapping was successfully deleted");

		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
