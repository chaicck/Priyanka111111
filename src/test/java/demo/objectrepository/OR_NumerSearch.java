package demo.objectrepository;

public interface OR_NumerSearch {
	
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

	String phoneNumber_1stcheckBox = "xpath=//*[@id='number_table']/tbody/tr[2]/td[2]";
	String phoneNumber_2ndcheckBox = "xpath=//*[@id='number_table']/tbody/tr[3]/td[2]";
    String customerTableHeadline="xpath=//*[@id='customer_table']/caption"; //Customers
    String searchTextBox = "xpath=//input[@id='search']";
    String voiceLnk="xpath=(//a[@id='dd-Voice'])[1]";
    String numbersBtn="xpath=(//span[@id='notification-numbers'])[3]";   
    String customer_dashboard_name="css=.panel-heading";
    String customerIdList="xpath=//*[@id='customer_table']/tbody/tr/td[2]";
    

}
