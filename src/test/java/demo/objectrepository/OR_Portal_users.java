package demo.objectrepository;

public interface OR_Portal_users {
	
	 	//String homeBtnDd = "css=span[id='notification-home'] span[class='hidden-md hidden-sm hidden-xs']";
	    String portalUsersTotalRecords = "xpath=//table[@id='users_table']/tbody/tr";
	    String portalUsersTr = "xpath=//table[@id='users_table']/tbody/tr[%s]";
	    String userNameTxtPu = "/td[2]";
	    String loginAsBtn = "/td[1]/a[@title='Log In As']";
	    
	    //voonage EnterPrise ( nw UI)
	     String voonage_enterPrise_userName="id=login";
	     String voonage_enterPrise_passWord="name=password";
	     String voonage_enterPrise_loginBtn="xpath=//button[text()='Log In']";
	     String vonage_selectASiteFromListHeadLineNew="xpath=//div[@class='clearfix']";
	     
	    String portalUser_portalUserNamesTable="xpath=//*[@id='users_table']/tbody/tr/td[2]";
		String Home_portalUser_logins_table ="xpath=(//a[@title='Log In As'])[%s]";
		     
		  String voonage_search="xpath=//input[@placeholder='Search']";
	      String voonage_callAnalytics="xpath=(//a[@href='/cdr'])[2]";
	      String voonage_faxMail="xpath=//a[@href='/cdr/faxMailSearch']";
	      String voonage_startdate="id=startDate";
	      String voonage_endDate="id=endDate";
	      String voonage_searchBtn="xpath=//button[@class='btn btn-primary pull-right']";
	      
	      String vonage_dashboard_callAnalytics ="xpath=(//a[@href='/cdr'])[2]";
	      String vonage_dashboard_callAnalytics_migratedReport="xpath=//a[@href='/cdr/cdrReports']";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_Graphs="xpath=(//h3[@class='media-heading'])[1]";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_companyLevelReport="xpath=(//h3[@class='media-heading'])[2]";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_indivisualStationReport="xpath=(//h3[@class='media-heading'])[3]";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_DepartmentLevelReports="xpath=(//h3[@class='media-heading'])[4]";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_CallCenter_HuntGroupLevelReport="xpath=(//h3[@class='media-heading'])[5]";
	      String vonage_dashboard_callAnalytics_CDRreportHeadings_Billing_Charge_Summary_Reporting="xpath=(//h3[@class='media-heading'])[6]";
	  


}
