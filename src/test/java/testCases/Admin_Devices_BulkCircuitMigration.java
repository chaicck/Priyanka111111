package testCases;

import java.io.File;
import java.io.FileReader;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Paths;

import org.apache.commons.io.FilenameUtils;
import org.openqa.selenium.Keys;
import org.testng.Assert;
import org.testng.annotations.Test;

import com.opencsv.CSVReader;

import demo.businesslogic.MediatorClass;

public class Admin_Devices_BulkCircuitMigration extends MediatorClass {
	
      
	
	
	 String fs= File.separator;
	    String rtfFilePath=System.getProperty("user.dir")+fs+"TestData"+fs+"test.rtf";
	 @Test(alwaysRun=true,enabled=true, dataProvider = "Authentication")
	public void bulkmigrate(String zUserName, String zPassword) throws Throwable {
		logger = extent.startTest("Bulk_migrate").assignCategory("Admin");
	        logInfo("Currently Running on -- "+getCurrentUrl());
		logInfo("TestCase Description:Bulk Migrate Circuits page");
		type(userNameTxt, zUserName, "User name");
		type(passTxt, zPassword, "Password");
		click(submitBtn, "Submit button");
		Verify(devices,"Devices", device_bulk_circuit_migration, "Bulk Circuit Migration", device_subMenu_headline,
				"Select a Device Name that is tied to a Circuit that you want to export:");
		String device_dropDown = "id=device_chosen";
		String device_dropDown_search = "xpath=//div[@class='chosen-search']/input";
		String export = "id=export";
		actionsClick(device_dropDown);
		type(device_dropDown_search, "a", "Product text box");
		Thread.sleep(2000);
		type(device_dropDown_search, "device_dropDown_search", Keys.ARROW_DOWN, Keys.ARROW_DOWN, Keys.ENTER);
		actionsClick(export,"Export");
		Thread.sleep(15000);
		File getLatestFile = getLatestFilefromDir(loc);
		System.out.println("getLatestFile-" + getLatestFile);
		String fileName = getLatestFile.getName();
		String ext = FilenameUtils.getExtension(fileName);
		System.out.println("File Downloaded" + fileName);
		System.out.println("Extension of File Downloaded" + ext);
		// Assert.assertTrue(ext.contains("csv"));
		String fileLocation = loc + "\\" + fileName;
		try {
			// Create an object of filereader
			// class with CSV file as a parameter.
			FileReader filereader = new FileReader(fileLocation);
			// create csvReader object passing
			// file reader as a parameter
			@SuppressWarnings("resource")
			CSVReader csvReader = new CSVReader(filereader);
			String[] nextRecord;
			// we are going to read data line by line
		while ((nextRecord = csvReader.readNext()) != null) {
				for (String cell : nextRecord) {
					System.out.print(cell + "\t");
				}
				System.out.println(nextRecord[1]);
				System.out.println(nextRecord[2]);
				System.out.println(nextRecord[3]);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}

		System.out.println("*********");
		try (Reader reader = Files.newBufferedReader(Paths.get(fileLocation));
				CSVReader csvReader = new CSVReader(reader);) {
			// Reading Records One by One in a String array
			String[] nextRecord;
			int line = 0;
			while ((nextRecord = csvReader.readNext()) != null) {
				if (line == 0) {
					Assert.assertTrue(nextRecord[0].contains("From Device"));
					Assert.assertTrue(nextRecord[1].contains("From Interface"));
					Assert.assertTrue(nextRecord[2].contains("To Device"));
					Assert.assertTrue(nextRecord[3].contains("To Interface"));
					Assert.assertTrue(nextRecord[4].contains("Customer Id"));
					Assert.assertTrue(nextRecord[5].contains("Circuit Id"));
					logPass("Headers are verified in downloaded file");
					line++;
					continue;
				}
				System.out.println("from Device : " + nextRecord[0]);
				Assert.assertTrue(nextRecord[2].contains(""));
				Assert.assertTrue(nextRecord[3].contains(""));
				logPass("To Device & To Interface fields were empty in downloaded file");
				System.out.println("To Device : " + nextRecord[2]);
				System.out.println("To Interface : " + nextRecord[3]);

			}
		}

		String fileLocation1 = System.getProperty("user.dir") + "\\TestData\\ar1.den3_export.csv";
		String fileLocation2 = System.getProperty("user.dir") + "\\TestData\\ar1.den3_exportCopy.csv";
		// export without checking dry run
		actionsClick(importt, "import");

		// verifying error message without selectiong any file for import
		actionsClick(importt, "import");
		Thread.sleep(1000);
		verifyText(importError, "Please select a csv file to import.", "");

		updateCSV(fileLocation1, "", 1, 2);
		updateCSV(fileLocation1, "", 1, 3);
		uploadAndVerifyDryRun(fileLocation1, "missing");
		actionsClick(BulkMigrate_header,"Bulk Migrate Header");

		updateCSV(fileLocation2, "", 1, 2);
		updateCSV(fileLocation2, "", 1, 3);
		updateCSV(fileLocation2, "ar1.atl1", 1, 2);
		updateCSV(fileLocation2, "eth", 1, 3);
		uploadAndWithoutVerifyDryRun(fileLocation2);

		updateCSV(fileLocation1, "ar1.atl1", 1, 2);
		updateCSV(fileLocation1, "eth", 1, 3);
		actionsClick(BulkMigrate_header, "Bulk Migrate Header");
		uploadAndVerifyDryRun(fileLocation1, "valid");
		actionsClick(BulkMigrate_header,"Bulk Migrate Header");

		updateCSV(fileLocation2, "ar1.atl199", 1, 2);
		updateCSV(fileLocation2, "eth", 1, 3);
		uploadAndVerifyDryRun(fileLocation2, "invalid");
		updateCSV(fileLocation2, "", 1, 2);
		updateCSV(fileLocation2, "", 1, 3);

		actionsClick(BulkMigrate_header,"Bulk Migrate Header");

		updateCSV(fileLocation2, "32!@#!#.", 1, 2);
		updateCSV(fileLocation2, "@$#%W$$ggdf", 1, 3);
		uploadAndVerifyDryRun(fileLocation2, "invalid");
		updateCSV(fileLocation2, "", 1, 2);
		updateCSV(fileLocation2, "", 1, 3);

		// logOut();

	}

	private void uploadAndVerifyDryRun(String fileLocation1, String type) throws Throwable {
		// upload a file
		actionsClick(upload, "Upload");
		// actionsClick(attachments_uploadAdditionalDocuments_chooseFile);
		String location = System.getProperty("user.dir") + "\\Drivers\\uploadFileDynamicPath.exe";
		Thread.sleep(2000);
		Runtime.getRuntime().exec(location + " " + fileLocation1);
		Thread.sleep(10000);
		actionsClick(dryRun, "Dry Run");
		Thread.sleep(1000);
		verifyText(dryRun_msg, "Dry run will only generate report and will not make the changes.", "");
		actionsClick(importt, "import");
		waitForElementPresentE(dryRun_warningMsg, 10);
		verifyText(dryRun_warningMsg, "This is a dry run, changes won't take effect.", "");
		actionsClick(dry_run, "Dry Run");

		Thread.sleep(1000);

		int lineNumber = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(fileLocation1));
				CSVReader csvReader = new CSVReader(reader);) {
			// Reading Records One by One in a String array
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				if (lineNumber == 0) {
					lineNumber++;
					continue;
				}

				verifyText(name, nextRecord[0], "");
				verifyText(fromInterface, nextRecord[1], "");
				System.out.println("to device******" + getText(toDevice));
				System.out.println("to device**from file**" + nextRecord[2]);
				verifyText(toDevice, nextRecord[2], "");
				System.out.println("to device******" + getText(toInterface));
				System.out.println("to device**from file**" + nextRecord[3]);
				verifyText(toInterface, nextRecord[3], "");
				verifyText(customerId, nextRecord[4], "");
				verifyText(circuitId, nextRecord[5], "");

				lineNumber++;

			}
		}
		String import_tableSuccessMsg = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[7]";
		Thread.sleep(3000);
		if (type.equals("valid")) {
			verifyText(import_tableSuccessMsg, "SUCCESS:", "success message");
		}
		if (type.equals("invalid")) {
			verifyText(import_tableSuccessMsg, "ERROR:", "error message");
		}
		if (type.equals("missing")) {
			verifyText(import_tableSuccessMsg, "value missing", "missing message");
		}

	}

	private void uploadAndWithoutVerifyDryRun(String fileLocation1) throws Throwable {
		// upload a file
		actionsClick(upload, "Upload");
		// actionsClick(attachments_uploadAdditionalDocuments_chooseFile);
		String location = System.getProperty("user.dir") + "\\Drivers\\uploadFileDynamicPath.exe";
		Thread.sleep(2000);
		Runtime.getRuntime().exec(location + " " + fileLocation1);
		Thread.sleep(10000);

		actionsClick(importt, "import");

		Thread.sleep(1000);

		int lineNumber = 0;
		try (Reader reader = Files.newBufferedReader(Paths.get(fileLocation1));
				CSVReader csvReader = new CSVReader(reader);) {
			// Reading Records One by One in a String array
			String[] nextRecord;
			while ((nextRecord = csvReader.readNext()) != null) {
				if (lineNumber == 0) {
					lineNumber++;
					continue;
				}
				System.out.println("name----->"+getText(name)+"     "+nextRecord[0]);
				verifyText(name, nextRecord[0], "");
				verifyText(fromInterface, nextRecord[1], "");
				System.out.println("to device******" + getText(toDevice));
				System.out.println("to device**from file**" + nextRecord[2]);
				verifyText(toDevice, nextRecord[2], "");
				System.out.println("to device******" + getText(toInterface));
				System.out.println("to device**from file**" + nextRecord[3]);
				verifyText(toInterface, nextRecord[3], "");
				verifyText(customerId, nextRecord[4], "");
				verifyText(circuitId, nextRecord[5], "");

				lineNumber++;

			}

		}
		verifyText(Bulkcircuitprocessheader, "THIS ONLY UPDATES MONITORING!", "verified bulkcircuit");

		actionsClick(Bulkcircuite_process, "Bulk Circuit Process");
		String import_tableSuccessMsg = "xpath=//*[@id='define_columns']/table/tbody/tr[2]/td[7]";
		Thread.sleep(3000);

		verifyText(import_tableSuccessMsg, "SUCCESS:", "success message");

	}

	private File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	private void Verify(String menu,String menuName, String submenu,String SubMenuName, String textElement, String text) throws Throwable {
		setBrowserTo80Size();
		JSClick(adminLInk,"Admin");
		actionsClick(menu, menuName);
		JSClick(submenu, SubMenuName);
		waitForElementPresent(textElement, 200);
		verifyText(textElement, text, "Verifying HeadLine text");
	}

}
