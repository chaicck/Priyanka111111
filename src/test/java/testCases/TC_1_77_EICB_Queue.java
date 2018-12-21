package testCases;

import org.testng.annotations.Test;


import demo.businesslogic.MediatorClass;


public class TC_1_77_EICB_Queue extends MediatorClass{

	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tc_1_77_eICB_Queue(String zUserName, String zPassword) throws Throwable  {
		
            logger = extent.startTest("1.77 Test ID : 18719 - Verify that service delivery approved EICBs must display within the EICB Queue").assignCategory("Queue");
           logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Go to Queues and then select Engineering ICB queue and Verify that service delivery approved EICBs must display within the EICB Queue");
            type(userNameTxt, zUserName, "User name");
    		type(passTxt, zPassword, "Password");
	        click(submitBtn, "Submit button");
	        logInfo("Logged into Zeus successfully");
	        waitForElementPresent(Queues, 300);
	        JSClick(Queues,"Queues");
	        actionsClick(Queues_enganeering_ICB,"Queues_enganeering_ICB");
	        waitForElementPresent(Queues_enganeering_ICB_search, 300);
	        type(Queues_enganeering_ICB_search, "Service Delivery Approved", "Searched Service Delivery Approved");
	        waitForElementPresent(Queues_enganeering_ICB_search_servicedeliver_aprproved, 300);
	        verifyText(Queues_enganeering_ICB_search_servicedeliver_aprproved, "service-delivery-approved", "searched service-delivery-approved");
	        waitForElementPresent(Queues_enganeering_ICB_search_inactive, 300);
	        actionsClick(Queues_enganeering_ICB_search_inactive,"Queues_enganeering_ICB_search_inactive");
	        waitForElementPresent(Queues_enganeering_ICB_search_inactive_rejected, 300);
	        verifyText(Queues_enganeering_ICB_search_inactive_rejected, "rejected", "");
	        waitForElementPresent(Queues_enganeering_ICB_search, 300);
	        type(Queues_enganeering_ICB_search, "Service Delivery Approved", "Search Box");
	        waitForElementPresent(Queues_enganeering_ICB_search_inactive_result, 300);
	        verifyText(Queues_enganeering_ICB_search_inactive_result, "Showing 0 to 0 of 0 entries", "Showing 0 to 0 of 0 entries");	
		
}
}
