package Zeus_healthcheck;

import org.openqa.selenium.Keys;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class Number_search extends MediatorClass {

	String voine_numbers_AssignNumbersFrmInventoryBtn = "xpath=//*[@id='number_table']/caption/a[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_state_DD = "id=state";
	String voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD = "id=npanxx";
	String voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD = "name=rate_center_name";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search = "xpath=(//button[@type='submit'])[2]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn = "xpath=//a[@class='select_numbers']";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_mobileNumber = "xpath=//*[@id='number_table']/tbody/tr[1]/td[4]";
	String voine_numbers_AssignNumbersFrmInventoryBtn_search_playBtn_assign = "xpath=//button[text()='Assign Numbers']";
	String voice_Number_NumerRanges_table_startNumbers = "xpath=//*[@id='number_table']/tbody/tr/td[8]";
	String voice_Number_NumerRanges_table_endNumber = "xpath=//*[@id='number_table']/tbody/tr/td[9]";
	String numbers_assignNumbers_tableRows = "xpath=//tr[@role='row']";
	String numbers_assignNumbers_PhoneNumbersCount = "xpath=//*[@id='number_table']/caption/span";
	String numbers_assignNumbers_tableinfo = "id=number_table_info";
	String numbers_assignNumbers_Table_plusIcon = "xpath=//*[@id='number_table']/tbody/tr/td[1]/i";
	String numbers_assignNumbers_Table_1stIndivisualCheckBox = "xpath=//*[@id='number_table']/tbody/tr[2]/td[2]";
	String numbers_assignNumbers_Table_1stIndivisual_NPA_NXX = "xpath=//*[@id='number_table']/tbody/tr[2]/td[6]";
	String numbers_assignNumbers_Table_1stIndivisual_Number = "xpath=//*[@id='number_table']/tbody/tr[2]/td[7]";
	String numbers_assignNumbers_assignNumbersBtn = "id=assign_numbers_button";
	String numbers_assignNumbers_Table_groups_parametarised = "xpath=(//tr[@class='collapsed group group-start'])[%s]";
	String numbers_assignNumbers_Table_groupsRanges_parametarised = "xpath=(//tr[@class='collapsed group group-start'])[%s]/td[4]";
	String numbers_assignNumbers_Table_groupsLevelChecBox = "xpath=(//tr[@class='collapsed group group-start'])/td[2]//input";
	String numbers_assignNumbers_Table_groupsLevelCount_parametarised = "xpath=(//tr[@class='collapsed group group-start'])[%s]/td[5]";
	String numbers_assignNumbers_Table_groupsLevelRateCenter = "xpath=(//tr[@class='collapsed group group-start'])[1]/td[4]";
	String mobileNumber;
	String scenario4_beginingNumber;
	String scenario4_endingNumber;
	String Customer_Dashboardverify = "xpath=//li[text()='TNL Test BroadsoftRAY V17']";
	String srchDd="id=dd-Search";
	String customerLnk="id=notification-customer";
    String srchTxt = "css=input#search";
    String userNameTxt = "css=input[name='user']";   
    String passTxt = "css=input[name='pass']";
    String submitBtn = "css=button[type='submit']";
    String usernameTextBox = "xpath=//input[@name='user']";
    String passwordTextBox = "xpath=//input[@name='pass']";
    String loginButton = "xpath=//button[@type='submit']";
    String customerTableHeadline="xpath=//*[@id='customer_table']/caption"; //Customers
    String searchTextBox = "xpath=//input[@id='search']";
    String voiceLnk="xpath=(//a[@id='dd-Voice'])[1]";
    String numbersBtn="xpath=(//span[@id='notification-numbers'])[3]";   
    String customer_dashboard_name="css=.panel-heading";
    String customerIdList="xpath=//*[@id='customer_table']/tbody/tr/td[2]";
    
    @Test(alwaysRun=true,enabled=true)
	public void number_search() throws Throwable {

		String customer_id = "39382";
		logger = extent.startTest("Voice_Numbers")
				.assignCategory("Voice_Numbers");
	   type(userNameTxt, "ppundru", "User name");
	    type(passTxt, "Luckylasya1@", "Password"); 
		click(submitBtn, "Submit button");
		logInfo("Logged into Zeus successfully");
		type(searchTextBox, customer_id, "Search Box");
		type(searchTextBox, "search box", Keys.ENTER);
		if (verifyElementText(customerTableHeadline, "Customers")) {
			verifyTextInColumnClickOtherColumn(customerIdList, customerName, customer_id);
		}
		verifyText(customer_dashboard_name, "Customer:", "Customer Name");
		click(voiceLnk, "Voice Link");
		click(numbersBtn, "Numbers button");
		actionsClick(voine_numbers_AssignNumbersFrmInventoryBtn, "' Assign Numbers from Inventory'");
//		navigateToAssignNoFromInventory();
		selectDropDownByVisibleText(voine_numbers_AssignNumbersFrmInventoryBtn_state_DD, "Arizona");
		Thread.sleep(2000);
		int dropdownSize = getDropDownValues(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD, "").size();
		for (int i = 1; i < dropdownSize; i++) {
			selectDropDownByIndex(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD, i);
			actionsClick(voine_numbers_AssignNumbersFrmInventoryBtn_search);
			if (verifyElementText(numbers_assignNumbers_tableRows, "")) {
				System.out.println(
						"State " + getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_state_DD));
				System.out.println("Rate Center "
						+ getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_rateCenterName_DD));
				System.out.println(
						"NPA+NXX value " + getDropdownSelectedValue(voine_numbers_AssignNumbersFrmInventoryBtn_NPA_DD));
				logInfo("Total no of records present in the table are "
						+ getText(numbers_assignNumbers_PhoneNumbersCount));
				int noOfGroups = getAllElements(numbers_assignNumbers_Table_plusIcon).size();
				for (int j = 1; j <= noOfGroups; j++) {
					String countOnGroup = getCount(
							getText(String.format(numbers_assignNumbers_Table_groupsLevelCount_parametarised, j)));
					if (Integer.parseInt(countOnGroup) >= 2) {
						logPass("Group "
								+ getText(String.format(numbers_assignNumbers_Table_groupsRanges_parametarised, j))
								+ " has count " + countOnGroup);
						actionsClick(numbers_assignNumbers_Table_plusIcon, "Plus Icon");
						String phoneNumber_1stcheckBox = "xpath=//*[@id='number_table']/tbody/tr[2]/td[2]";
						String phoneNumber_2ndcheckBox = "xpath=//*[@id='number_table']/tbody/tr[3]/td[2]";
						actionsClick(phoneNumber_1stcheckBox, "1st check box");
						actionsClick(phoneNumber_2ndcheckBox, "2nd check box");
						break;
					} else {
						logInfo("Cann't perform scenario 3 on group '" + j
								+ "', as the group does not contains more than 1 record");
					}

				}

				break;
			}

			else {
				logFail("No mobile Number found in Assign number search");
			}

		}

	}

	private void navigateToAssignNoFromInventory() {
		// TODO Auto-generated method stub
		

	}

	private String getCount(String text) {
		// TODO Auto-generated method stub
		text = text.trim();
		text = text.substring(0, text.length() - 1);
		return text.substring(8, text.length());
	}
}

