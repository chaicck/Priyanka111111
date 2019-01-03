package demo.objectrepository;

public interface OR_FAXMail {

    String faxDeleteLnk ="css=a.faxDelete";
    String viewOrEditLnk ="xpath=(//a[@title='View/Edit'])[1]";
    String recipientsMailTxt ="id=inbound_email";
    String sendersMailTxt ="id=outbound_email";
    String saveFaxBtn ="id=saveFaxMailUser";
    String numberDd ="id=tn_id";
    String addFaxMailUserBtn ="id=addFaxMailUser";
    String addFaxUserBtn ="xpath=//a[contains(@href,'/fax/add/customer')]";
    String uploadCoverSheetBtn ="xpath=//a[@href='#upload_coversheet_modal']";
    String uploadCoverSheetBtn_close ="xpath=//button[@class='close']";
    String chooseCoverSheetFile ="id=coversheet_file";
    String uploadBtn ="xpath=(//button[@type='submit'])[2]";
    String successOkBtn ="xpath=//div[@class='alert alert-success']/button";
    
	
 

    String faxmail_btn = "id=notification-faxmail";
    String Verifytext_faxmail_user = "xpath=//caption[text()='FaxMail Users ']";
    String Verify_faxmail_table = "xpath=//div[@class='col-sm-12']";


}
