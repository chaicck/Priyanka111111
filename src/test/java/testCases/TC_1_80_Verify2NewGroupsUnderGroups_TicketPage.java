package testCases;

import java.util.Collections;
import java.util.List;




import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.MediatorClass;

public class TC_1_80_Verify2NewGroupsUnderGroups_TicketPage extends MediatorClass{
	
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
    public void tC_1_80_Verify2NewGroupsUnderGroups_TicketPage(String zUserName, String zPassword) throws Throwable {
    	
    	
        logger = extent.startTest("1.80 Test ID : 16691 - Verify that there must be two new groups under Groups on the tickets page").assignCategory("Ticket");
         logInfo("Currently Running on -- "+getCurrentUrl());
	    logInfo("TestCase Description:Go to ticekts Queue in main menu Test that two new groups under 'Groups' on the 'Tickets'  "
        		+ "list: 'Group – Broadsoft TS' and 'Group – Broadsoft SS'  and Verified if user is able to sort the results by clicking on column titles");
        type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
        click(submitBtn, "Submit button");
        logInfo("Logged into Zeus successfully");
        waitForElementPresent(ticketsMenu, 300);
        JSClick(ticketsMenu,"Tickets-Menu");
        waitForElementPresent(tickets_groupsMenu, 200);
        scrollElementIntoView(tickets_group_BroadSoft_SS);
        JSClick(tickets_group_BroadSoft_SS,"Tickets-GroupBroadSoft_SS");
        //verifying headers
        waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
        scrollElementIntoView(tickets_group_BroadSoftTableColumnHeaders);
       
        scrollUp();
        Thread.sleep(9000);
	    List<String>list= getAllTheText(tickets_group_BroadSoftTableTicketIds);
        System.out.println("list-"+list);
        Collections.sort(list);
        System.out.println("List after sorting by complaier ascending order "+list);
        Collections.reverse(list);
        scrollUp();
        waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
        actionsClick(tickets_group_BroadSoftTableColumnHeaders, "BroadSoftTable-ColumnTitle");
        Thread.sleep(10000);
        List<String>list_sorted= getAllTheText(tickets_group_BroadSoftTableTicketIds);
        System.out.println("list-sorted-java"+list);
        System.out.println("list-sorted-application"+list_sorted);
        logInfo("Verifying sort functionality by clicking on BroadSoftTable-ColumnTitle");
        System.out.println(list.equals(list_sorted));
        Thread.sleep(15000);
        Assert.assertTrue(list.equals(list_sorted));
        
        verifyAllListValuesInOrder(tickets_group_BroadSoftTableColumnHeaders, AddElementsIntoList("ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update"));
        scrollElementIntoView(tickets_group_BroadSoft_TS);
        JSClick(tickets_group_BroadSoft_TS, "tickets_group_BroadSoft_TS");
        waitForElementPresent(tickets_group_BroadSoftTableColumnHeaders, 300);
        scrollUp();
        scrollElementIntoView(tickets_group_BroadSoftTableColumnHeaders);        
        verifyAllListValuesInOrder(tickets_group_BroadSoftTableColumnHeaders, AddElementsIntoList("ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update"));
        logInfo("Verified the table Headers - ID;Priority;Customer;Subject;State;Assigned To;Ticket Age;Last Update");
        
    }      
}
