package testCases;

import java.io.File;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.ITestContext;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class SearchDropDown extends MediatorClass {

	/**
	 * @author ${Priyanka}
	 *
	 * @Test Case name ${Billing_A_contract}
	 * @Date ${}
	 * @Modified ${12/18/2018}
	 */

	/**
	 * TestCase Description:Verify all menu's under the Search Dropdown and perform
	 * search functinolity with respective data
	 */

	@Test(alwaysRun = true, enabled = true)
	public void searchDropDown(ITestContext context) throws Throwable {

		// * Below variables written to get input data from excel sheet-Testdata.xlsx
		// and and configuration file -LoginCredentails.properties
		boolean isassert;
		String[] loginDetails;
		loginDetails = getCredentails(context);
		AssertSoftly softassert = new AssertSoftly();
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		String Customer = getTestData(this.getClass().getSimpleName().substring(0, 8), 1);
		String circuit = getTestData(this.getClass().getSimpleName().substring(0, 8), 2);
		String Contact = getTestData(this.getClass().getSimpleName().substring(0, 8), 3);
		String Contract = getTestData(this.getClass().getSimpleName().substring(0, 8), 4);
		String Device = getTestData(this.getClass().getSimpleName().substring(0, 8), 5);
		String Dispatch = getTestData(this.getClass().getSimpleName().substring(0, 8), 6);
		String IP = getTestData(this.getClass().getSimpleName().substring(0, 8), 7);
		String Inventory = getTestData(this.getClass().getSimpleName().substring(0, 8), 8);
		String Number = getTestData(this.getClass().getSimpleName().substring(0, 8), 9);
		String Project = getTestData(this.getClass().getSimpleName().substring(0, 8), 10);
		String Ticket = getTestData(this.getClass().getSimpleName().substring(0, 8), 11);
		String inventory_number = "(276) 622-3678";
		String inventory_number1 = "(330) 617-4014";
		String inventory_number2 = "(605) 956-4188";
		String inventory_number3 = "(276) 622-3680";
		String inventory_number4 = "(330) 617-4015";
		String inventory_number5 = "(605) 956-4195";
		String portability_number = "609-201";

		// * logger method for report starting from here
		logger = extent.startTest("Search DropDown").assignCategory("Search", "Regression test");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description: Verify all menu's under the Search Dropdown and perform search functinolity with respective data");

		// * Below Code written to verify login
		login(zUserName, zPassword);

		waitForElementPresent(srchDd, 300);
		click(srchDd, "Search");
		click(customerLnk, "Customer");
		waitForElementPresent(srchTxt, 300);
//		refreshBrowser();
		type(srchTxt, Customer, "Search box");
		type(srchTxt, "Search for TNL Test Broadsoft V17", Keys.ENTER);
		isassert = verifyText(customerNamefromTable, "TNL Test Broadsoft V17", "Customer Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_circuit, "circuit ");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, circuit, "Search box");
		type(srchTxt, "Search for 69.KXFS.000669..ACSO", Keys.ENTER);

		isassert = verifyText(circuit_tableName, "Circuits", "Verifying Circuits");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_contact, "Contact");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, Contact, "Search box");
		type(srchTxt, "Search for 7323162848", Keys.ENTER);
		waitForElementPresent(numberSearch_active_code_info_table, 200);

		isassert = verifyText(numberSearch_active_code_info_table, "NPA/NXX Active Code (NNACL) Information",
				"numberSearch_active_code_info_table");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_contract, "Contract");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, Contract, "Search box");
		type(srchTxt, "Search 379582", Keys.ENTER);
		waitForElementPresent(orderNumberValue, 150);

		isassert = verifyText(orderNumberValue, "379582", "orderNumber Value");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifyText(createdByValue, "Phani Chigurupati", "createdBy Value");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		isassert = verifyText(typeValue, "MACD - MINOR MOVES, ADDS, CHANGES, AND DELETES", "Order Type");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_device, "Device");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, Device, "Search box");
		type(srchTxt, "Search box", Keys.ENTER);

		isassert = verifyText(deviceTableName, "Devices", "device Table Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_dispatch, "Dispatch");
		waitForElementPresent(srchTxt, 50);
		type(srchTxt, Dispatch, "Search box");
		type(srchTxt, "Search 123", Keys.ENTER);

		isassert = verifyText(dispatchTableName, "Dispatche", "Dispatche Table Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_ip, "IP");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, IP, "Search box");
		type(srchTxt, "Search 10.23.240.111", Keys.ENTER);

		click(srchDd, "Search");
		click(search_inventory, "Inventory");
		waitForElementPresent(search_inventorySearchbox, 300);
		type(search_inventorySearchbox, Inventory, "Search box");
		type(search_inventorySearchbox, "Search 0004F26A67C4", Keys.ENTER);

		isassert = verifyText(inventoryTableName, "Inventory", "Inventory Table Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_number, "Number");
		waitForElementPresent(srchTxt, 30);
		type(srchTxt, Number, "Search box");
		type(srchTxt, "Search 7323162848", Keys.ENTER);
		waitForElementPresent(numberSearch_active_code_info_table, 200);

		isassert = verifyText(numberSearch_active_code_info_table, "NPA/NXX Active Code (NNACL) Information",
				"numberSearch_active_code_info_table");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		// PortabilityMultisearch
		actionsClick(search_number_portabilitySearch, "Portability Search");
		isassert = verifyText(pageHeader, "Portability Multi-Search", "");
		logInfo("User has landed onto 'Portability Multi-Search' page");
		type(search_number_inventorySearch_searchTextBox, portability_number, "Number Search box");
		actionsClick(search_number_inventorySearch_searchBtn, "Search button");
		int tableRecords = getAllElements(search_number_PortabilitySearch_table_NPA).size();
		for (int i = 1; i <= tableRecords; i++) {
			String no = getText(String.format(search_number_PortabilitySearch_table_NPA_parametarised, i)) + "-"
					+ getText(String.format(search_number_PortabilitySearch_table_NXX_parametarised, i));
			if (no.equalsIgnoreCase(portability_number)) {
				logPass("Portability Multisearch functionality has been verified with " + portability_number);
				break;
			}
		}
		// inventory Search
		click(srchDd, "Search");
		click(search_number, "Number");
		actionsClick(search_number_inventorySearch, "Inventory Multi-Search");

		isassert = verifyText(pageHeader, "Inventory Multi-Search", "");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		logInfo("User has landed onto 'Inventory Multi-Search' page");

		type(search_number_inventorySearch_searchTextBox, inventory_number1, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number1", Keys.ENTER);
		type(search_number_inventorySearch_searchTextBox, inventory_number2, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number2", Keys.ENTER);
		type(search_number_inventorySearch_searchTextBox, inventory_number3, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number3", Keys.ENTER);
		type(search_number_inventorySearch_searchTextBox, inventory_number4, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number4", Keys.ENTER);
		type(search_number_inventorySearch_searchTextBox, inventory_number5, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number5", Keys.ENTER);
		type(search_number_inventorySearch_searchTextBox, inventory_number, "Number Search box");
		type(search_number_inventorySearch_searchTextBox, "inventory_number", Keys.ENTER);

		actionsClick(search_number_inventorySearch_searchBtn, "Search button");

		isassert = verifyTextPresentInList(search_number_inventorySearch_tableNumbers, inventory_number);
		softassert.assertEquals(isassert, true, "Verify text on page ");

		logPass("Portability Multisearch functionality has been verified with " + inventory_number
				+ " the respective customer displayed on the table is "
				+ verifyTextInColumnGetOtherColumnText(search_number_inventorySearch_tableNumbers,
						search_number_inventorySearch_customerParametarised, inventory_number));

		click(srchDd, "Search");
		click(search_project, "Project");
		waitForElementPresent(srchTxt, 300);
		type(srchTxt, Project, "Search box");
		type(srchTxt, "Search 15148", Keys.ENTER);

		isassert = verifyText(projectTableName, "Projects", "Project Table Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");

		click(srchDd, "Search");
		click(search_ticket, "Ticket");
		type(srchTxt, Ticket, "Search box");
		type(srchTxt, "Search 288140", Keys.ENTER);
		waitForElementPresent(ticketTableName, 300);
		isassert = verifyText(ticketTableName, "Tickets", "Ticket Table Name");
		softassert.assertEquals(isassert, true, "Verify text on page ");
		softassert.assertAll();

		// Below method writtent to do logout from application
		logOut();
	}

}
