package demo.objectrepository;

public interface OR_ReconsiliationPage {

    String ReconsiliationNotes="name=notetext";
    String emacCheckBox="xpath=//*[starts-with(@id,'emac_DID')]";
    String billOnly="xpath=//*[starts-with(@id,'bill_DID ')]";
    String reconsileSubmitButton="xpath=//button[@class='btn btn-sm btn-primary']";

    String selectEmailReceipient="css=#authorizedUsers";
    String reconsilationSubmitButtonFix="xpath=//input[@class='btn btn-primary']";

    //Reconsilation Graph

    String startDate="css=#endDate";
    String agingGraphGoBtn="xpath=//button[@class='btn btn-primary']";
    String agingGraphChart="id=chart";
    String agingGraphExport="xpath=//button[@class='btn btn-success btn-default pull-right']";
    
	 String Reconciliation_EMAC_CheckALl="xpath=//input[@type='checkbox']";
	 String Reconciliation_ReconcileBtn ="xpath=(//button[@type='submit'])[3]";
	 String Reconciliation_ReconcileBtn_save="xpath=(//button[@type='submit'])[4]";

}
