package demo.objectrepository;


public interface OR_LoginPage {

    String userNameTxt = "css=input[name='user']";   
    String passTxt = "css=input[name='pass']";
    String submitBtn = "css=button[type='submit']";

    String usernameTextBox = "xpath=//input[@name='user']";
    String passwordTextBox = "xpath=//input[@name='pass']";
    String loginButton = "xpath=//button[@type='submit']";
    String lognFailed = "xpath=//*[@class='alert alert-danger']";
    
    // common xpath for all the pages
    
    String srchDd="id=dd-Search";
    String srchTxt = "css=input#search";



}
