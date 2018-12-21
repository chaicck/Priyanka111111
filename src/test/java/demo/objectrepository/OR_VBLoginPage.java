package demo.objectrepository;

public interface OR_VBLoginPage {
    String vbUserNameTxt = "xpath=//input[@name='user']";
    String vbPwdTxt = "xpath=//input[@name='pass']";
    String vbsubmitbtn = "xpath=//button[text()='Log In']";
    String firstSite = "xpath=//table[@id='sites']/tbody/tr[1]/td[1]";
    String callAnalyticsBtn = "xpath=//a[@class='btn btn-primary' and @href='/cdr']";
    String migratedReportsBtn = "xpath=//a[@class='btn btn-primary' and @href='/cdr/cdrReports']";
    String cdrReportsHeadre = "xpath=//h2[text()='CDR Reports Menu']";

    //CDR reports menu
    String cdrReports = "xpath=//h3[text()=' %s']";

}
