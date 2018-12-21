package demo.objectrepository;

public interface OR_NumRange {

    String tnDetailsPage="xpath=//a[text()='Number Ranges']";
    //String pencilIconNr="xpath=(//i[@class='fa  fa-pencil ']/..)[1]";
    String pencilIcons="xpath=//*[@id='number_table']/tbody/tr/td[1]";
    String cusAndShippingAddressEdit="css=button#customer_edit";
    String cusAndShippingAddressDd="css=div#customer_id_chosen";
    String carrierDd="css=select#carrier_name";
    String sveBtnDid="xpath=//button[text()='Save']";
    String succPopUp="xpath=//div[@class='alert alert-success']";
    String PopUPOk="xpath=//button[@onclick='location.reload();']";
    String descriptionTxt="css=input#description";
//    String PopUPOk="xpath//*[class='chosen-container chosen-container-single chosen-container-active chosen-with-drop']";
}

