package testCases;

import org.openqa.selenium.Keys;
import org.testng.ITestContext;
import org.testng.annotations.Test;

import utils.AssertSoftly;
import demo.businesslogic.MediatorClass;

public class Number_search extends MediatorClass {

	String mobileNumber;
	String scenario4_beginingNumber;
	String scenario4_endingNumber;

	@Test(alwaysRun = true, enabled = true)
	public void number_search(ITestContext context) throws Throwable {

		// * Below variables written to get input data from
		// LogingCredentails.properties

		String[] loginDetails;
		loginDetails = getCredentails(context);
		String zUserName = loginDetails[0];
		String zPassword = loginDetails[1];
		boolean isassert;
		AssertSoftly softassert = new AssertSoftly();
		
		String customer_id = getTestData(this.getClass().getSimpleName().substring(0, 5), 1);
		String searchBox = getTestData(this.getClass().getSimpleName().substring(0, 5), 2);
		String customerTxt1 = getTestData(this.getClass().getSimpleName().substring(0, 5), 3);
		String customerTxt2 = getTestData(this.getClass().getSimpleName().substring(0, 5), 4);

		// * Below Code written to verify login
		logger = extent.startTest("Voice_Numbers").assignCategory("Voice_Numbers");
		logInfo("Currently Running on -- " + getCurrentUrl());
		logInfo("TestCase Description:: Number search");
		System.out.println("TestCase Description:: Number search");
		
		// * Below Code written to verify login
		login(zUserName, zPassword);

		logInfo("Logged into Zeus successfully");
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, searchBox, Keys.ENTER);
		if (verifyElementText(customerTableHeadline, customerTxt1)) {
			verifyTextInColumnClickOtherColumn(customerIdList, "Customers",customer_id);
		}
		isassert = verifyText(customer_dashboard_name, customerTxt2,"Customer Name");
		softassert.assertEquals(isassert, true);

		click(voiceLnk, "Voice Link");
		click(numbersBtn, "Numbers button");
		actionsClick(voine_numbers_AssignNumbersFrmInventoryBtn,"' Assign Numbers from Inventory'");
		selectDropDownByVisibleText(voine_numbers_AssignNumbersFrmInventoryBtn_state_DD, "Arizona");
		Thread.sleep(2000);
		int dropdownSize = getDropDownValues(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD, "").size();
		for (int i = 1; i < dropdownSize; i++) {
			selectDropDownByIndex(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD, i);
			actionsClick(voine_numbers_AssignNumbersFrmInventoryBtn_search);
			if (verifyElementText(numbers_assignNumbers_tableRows, "")) {
				System.out.println("State "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_state_DD));
				logInfo("State "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_state_DD));
				System.out.println("Rate Center "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD));
				logInfo("Rate Center "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD));
				System.out.println("NPA+NXX value "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD));
				logInfo("NPA+NXX value "+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD));
				logInfo("Total no of records present in the table are "+ getText(numbers_assignNumbers_PhoneNumbersCount));
				int noOfGroups = getAllElements(numbers_assignNumbers_Table_plusIcon).size();
				for (int j = 1; j <= noOfGroups; j++) {
					String countOnGroup = getCount(getText(String.format(numbers_assignNumbers_Table_groupsLevelCount_parametarised,j)));
					if (Integer.parseInt(countOnGroup) >= 2) {
						logPass("Group "+ getText(String.format(numbers_assignNumbers_Table_groupsRanges_parametarised,j)) + " has count "+ countOnGroup);
						actionsClick(numbers_assignNumbers_Table_plusIcon,"Plus Icon");
						actionsClick(phoneNumber_1stcheckBox, "1st check box");
						actionsClick(phoneNumber_2ndcheckBox, "2nd check box");
						break;
					} else {
						logInfo("Cann't perform scenario 3 on group '"+ j+ "', as the group does not contains more than 1 record");
					}

				}

				break;
			}

			else {
				logFail("No mobile Number found in Assign number search");
			}

		}
		
		// * Below method written to logout application
		logOut();
		softassert.assertAll();

	}
}
