package demo.objectrepository;

public interface OR_Tickets {

	String ticketsMenu = "xpath=//a[@href='/ticket/queues/']";
	String tickets_groupsMenu = "xpath=//a[@href='#groups']";
	// String tickets_group_BroadSoft_SS= "link= Group - Broadsoft SS 						";
	String tickets_group_BroadSoft_SS = "xpath=//*[@id='groups']/ul/li[16]/a";
	// String tickets_group_BroadSoft_TS="link= Group - Broadsoft TS 						";
	String tickets_group_BroadSoft_TS = "xpath=//*[@id='groups']/ul/li[17]/a";
	String tickets_group_BroadSoftTableColumnHeaders = "xpath=//*[@id='ticket_table']/thead/tr/th";

	String tickets_group_BroadSoftTableTicketIds = "xpath=//*[@id='ticket_table']/tbody/tr/td[1]/a";
	// verifying in Tickets Menu
	String tickets_search = "xpath=//input[@type='search']";
	String tickets_group_Billing = "xpath=//a[@href='/ticket/queues/?queue_name=Group%20-%20Billing']";
	String ticketsMenu_ticketIds = "xpath=//*[@id='ticket_table']/tbody/tr/td[1]/a";
	String tickets_group_AdvancedTechnical = "xpath=//a[@href='/ticket/queues/?queue_name=Group%20-%20Advanced%20Technical']";

}
