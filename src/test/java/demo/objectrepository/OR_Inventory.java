package demo.objectrepository;

public interface OR_Inventory {
	String bulkEditBtn = "id=bulk_edit_button";
    String chkBoxForAllEntries = "xpath=//table[@id='inventory_table']//div[@class='checkbox ']";
    String chkBox = "xpath=(//table[@id='inventory_table']//div[@class='checkbox '])[%s]";
    String bulkEditForm = "name=bulk_edit_form";
    String locationId = "id=location_id";
    String ownerId = "id=owner_id";
    String saveBtn = "id=bulk_edit_save";
    String emptyInventory = "xpath=//td[@class='dataTables_empty']";
    String assetDetailsLabel = "xpath=//h1[starts-with(text(),'Asset Details')]";
    String changeNoteTxtBox = "css=textarea#note";
    String inventorySaveBtn = "css=button#save-button";
    String successPopUp = "xpath=//div[@class='alert alert-success alert-dismissable']";
    String pencilLink = "xpath=//a[contains(@href,'/inventory/assetSearchAll')]";

}