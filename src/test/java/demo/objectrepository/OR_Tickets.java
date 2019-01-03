package demo.objectrepository;

public interface OR_Tickets {
	
	 String ticketsMenu="xpath=//a[@href='/ticket/queues/']";
     String tickets_groupsMenu="xpath=//a[@href='#groups']";
     //String tickets_group_BroadSoft_SS= "link= Group - Broadsoft SS 						";
     String tickets_group_BroadSoft_SS="xpath=//*[@id='groups']/ul/li[16]/a";
     //String tickets_group_BroadSoft_TS="link= Group - Broadsoft TS 						";
     String tickets_group_BroadSoft_TS="xpath=//*[@id='groups']/ul/li[17]/a";
     String tickets_group_BroadSoftTableColumnHeaders="xpath=//*[@id='ticket_table']/thead/tr/th";
     
     String tickets_group_BroadSoftTableTicketIds="xpath=//*[@id='ticket_table']/tbody/tr/td[1]/a";
     

}
