package demo.objectrepository;

public interface OR_NewMAC {
    String newMacLable = "xpath=(//h1[@class='panel-title'])[1]";
    String nameTxt = "xpath=//input[@id='quote[name]']";
    String requestedInstallDateTxt = "xpath=//input[@id='quote_cstm[requested_install_date_c]']";
    String tktIdTxt = "xpath=//input[@id='quote[ticket_id]']";
    String notesTxt = "xpath=//textarea[@id='quote[description]']";
    String authorizedBySelect = "xpath=//select[@id='quote[AuthorizedBy]']";
    String assignedToSelect = "xpath=//select[@name='quote_cstm[project_manager_c]']";
    String addNewProdBtn = "xpath=//a[@onclick='addRow();']";
    String prodTxt = "xpath=//span[@class='twitter-typeahead']/input[2]";
    String macSaveBtn = "xpath=//button[text()=' Save']";
    String prodDropDown = "xpath=//span[@class='tt-dropdown-menu']/div";
    String approveAndEmailBtn = "xpath=//button[@onclick='lockAndEmail();']";
    String sendToBillingBtn = "xpath=//button[@onclick='lockAndEmail();']/../a";

}