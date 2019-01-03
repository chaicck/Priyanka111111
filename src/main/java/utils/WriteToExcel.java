package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;



public class WriteToExcel {
	static String filelocation;
	static FileInputStream inputStream ;
	static Workbook workbook ;
	static Sheet sheet;
	static int i;
	
	
	public static void intialiseExcel(String filePath) throws EncryptedDocumentException, InvalidFormatException, IOException{
		filelocation=filePath;
    inputStream = new FileInputStream(new File(filePath));
     workbook = WorkbookFactory.create(inputStream);    
     sheet = workbook.createSheet(toDaysdate()); 
    }
	
	
	public static void writeExcel( String data) {
		
		 String[]texts = data.split(";");
		 System.out.println(texts[0]);
		 System.out.println(texts[1]);
		 
		 sheet.createRow(i).createCell(0).setCellValue(texts[0]);
		 sheet.getRow(i).createCell(1).setCellValue(texts[1]);
		 i=(i+1);
		 
	      
	}
	
	
	public static void closeExcelConnection() throws IOException{
		
		inputStream.close();
	    
	    FileOutputStream outputStream = new FileOutputStream(filelocation);
	    workbook.write(outputStream);
	    workbook.close();
	    outputStream.close();

	}
    
	public static String toDaysdate(){		
		String pattern = "ddMMyyyy_HH_mm_ss";
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat(pattern);
		String date = simpleDateFormat.format(new Date());
		return date;
	}
}

