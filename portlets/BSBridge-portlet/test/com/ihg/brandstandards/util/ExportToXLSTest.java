package com.ihg.brandstandards.util;

import java.io.FileOutputStream;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
//import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;

import com.liferay.portal.kernel.util.Validator;

public class ExportToXLSTest {
	
	public static void main(String[] args) {
		String text = "Design Reference for Door Vinyl Graphics:::/documents/5958717/15563680/image.png";
		if(Validator.isNotNull(text)) {
			String attachments[] = text.split(";;; ");
			if (attachments != null && attachments.length > 0) {
				for (String attachment : attachments) {
                	String attachmentData[] = attachment.split(":::");
                    if (attachmentData.length >= 2) {
                    	System.out.println(attachmentData[0]);
                    }
                }
			} else {
				System.out.println(text);
			}
		}
	}
	
	@Test
    public final void testExportToXLSTest() {
		int columnCounter = 0;
		int rowCounter = 1;
		int columnWidths[] = null;
		String headerTitles[] = null;
		String reportLocaleCode = "fr_FR";
		String reportType = "LinkTranslationView";
		if("AttachmentTranslationView".equals(reportType)){
			columnWidths = new int[]{4000, 10000, 2000, 2000, 10000, 3000, 3000, 8500, 8500, 5000};
			headerTitles = new String[]{"Global/Regional", "Path", "STD ID", "Type", "Text", "Category", "Manual", "Supporting Document Title (en_GB)", "Supporting Document Title ("+reportLocaleCode+")", "Action"};
		} else if("LinkTranslationView".equals(reportType)){
			columnWidths = new int[]{4000, 10000, 2000, 2000, 10000, 3000, 3000, 5000, 5000, 5000, 10000};
			headerTitles = new String[]{"Global/Regional", "Path", "STD ID", "Type", "Text", "Category", "Manual", "Link Title (en_GB)", "Link Title ("+reportLocaleCode+")", "Action", "Link"};
		} else if("ImageTranslationView".equals(reportType)){
			columnWidths = new int[]{4000, 10000, 2000, 2000, 10000, 3000, 3000, 6500, 6500, 5000};
			headerTitles = new String[]{"Global/Regional", "Path", "STD ID", "Type", "Text", "Category", "Manual", "Mandatory Image (en_GB)", "Mandatory Image ("+reportLocaleCode+")", "Action"};
		} 
		final Workbook workbook = new HSSFWorkbook();
        try {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet("ExportToXLSTest");
            
            //DataFormat fmt = workbook.createDataFormat();
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
            //textStyle.setDataFormat(fmt.getFormat("@"));
            
            /*Setting column style*/
            for (int width : columnWidths)
            {
            	sheet.setColumnWidth(columnCounter, width);
            	sheet.setDefaultColumnStyle(columnCounter, textStyle);
            	columnCounter++;
            }

            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            boldFont.setColor(HSSFColor.WHITE.index);
            style.setFont(boldFont);
            style.setBorderTop((short)1);
            style.setBorderRight((short)1);
            style.setBorderBottom((short)1);
            style.setBorderLeft((short)1);
            style.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
            style.setFillForegroundColor(HSSFColor.BLUE_GREY.index);
            style.setFillBackgroundColor(HSSFColor.BLUE_GREY.index);//new HSSFColor.BLUE().getIndex());

            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : headerTitles)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }

            for (int i=0; i < 10; i++)
            {
        		Row dataRow = sheet.createRow(rowCounter);
                dataRow.createCell(0).setCellValue(i);
                dataRow.createCell(1).setCellValue("Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing Testing "+i);
                dataRow.createCell(2).setCellValue(i);
	            dataRow.createCell(3).setCellValue(i);
	            dataRow.createCell(4).setCellValue("IHG's trademarks, including IHG owned graphic symbols, logos or icons must not be used in a manner that would imply IHG’s, affiliation with or endorsement, sponsorship or support of a third party product or service, without express written permission from amerglobaltrademarkadministration@ihg.com.");
                rowCounter++;
            }
            FileOutputStream outPutFile = new FileOutputStream("ExportToXLSTest.xls");
            workbook.write(outPutFile);
            outPutFile.flush();
            outPutFile.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
	}
}
