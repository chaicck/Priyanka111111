package demo.scripts;


import java.io.File;
import java.sql.Driver;

import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import demo.businesslogic.CommonReusables;
import demo.objectrepository.OR_CustInfo;
import demo.objectrepository.OR_FAXMail;
import demo.objectrepository.OR_HomePage;
import demo.objectrepository.OR_NewMAC;
import demo.objectrepository.OR_ProjectManager;
import demo.objectrepository.OR_SearchPage;

public class FAXAddDeleteModify extends CommonReusables implements OR_FAXMail,OR_SearchPage,OR_HomePage, OR_CustInfo,OR_ProjectManager,OR_NewMAC {

    String fs= File.separator;
    String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
    @Test
    public void addDns() throws Throwable {

        logger = extent.startTest("Verify ADD, Delete and modify");
        userlogin("zqa-admin", "Q@eZL9Pw2D");
        type(srchTxt, "40135","Search box");
        type(srchTxt,"Search box", Keys.ENTER);
        click(voiceLnk,"Voice Link");
        click(faxMailLnk,"FaxMail Link");
        click(faxDeleteLnk,"Delete Icon");
        Assert.assertTrue(isAlertPresent());
        dismissAlert();
        click(viewOrEditLnk,"View Or Edit Icon");
        Assert.assertTrue(Driver.getCurrentUrl().toLowerCase().contains("fax"));
        Driver.navigate().back();
        click(addFaxUserBtn,"Add Fax User Button");
        selectDropDownByIndex(numberDd,2);
        String email="leha.kolli"+generateRandomString(5)+"@vonage.com";
        type(recipientsMailTxt,email,"Recipients Mail");
        type(sendersMailTxt,email,"Senders Mail");
        //click(addFaxMailUserBtn,"Add button");
        Driver.navigate().back();
        click(uploadCoverSheetBtn,"Upload Cover SheetB button");
        type(chooseCoverSheetFile,rtfFilePath,"RTF file");
        click(uploadBtn,"Upload button");
        click(successOkBtn,"Ok button");
        logOut();

    }
}
