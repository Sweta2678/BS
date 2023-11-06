package com.ihg.brandstandards.bridge.util;

import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.custom.model.Standard;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ProgressPortletUtil {
	
	private static final Log LOG = LogFactoryUtil.getLog(ProgressPortletUtil.class);
	private ProgressPortletUtil() {
		/** Private Constructor to restrict not to create any object for this call.*/
	}
	
	public static Workbook exportContentDetailStandards(String reportType, String reportLocaleCode, List<Standard> viewDetailsStandards)
    {
		int columnCounter = 0;
		int rowCounter = 1;
		int columnWidths[] = null;
		String headerTitles[] = null;
		
		if(Validator.isNotNull(reportLocaleCode)){
			columnWidths = new int[]{3000, 3000, 16500, 16500, 5000};
			headerTitles = new String[]{"STD_ID", "Type", "Text", "Translation", "Action"};
		} else {
			columnWidths = new int[]{3000, 3000, 16500, 5000};
			headerTitles = new String[]{"STD ID", "Type", "Text", "Action"};
		}
        final Workbook workbook = new HSSFWorkbook();
        try {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(reportType+"Details");
            
            //DataFormat fmt = workbook.createDataFormat();
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
            //textStyle.setDataFormat(fmt.getFormat("@"));
            
            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(boldFont);
            style.setBorderTop((short)1);
            style.setBorderRight((short)1);
            style.setBorderBottom((short)1);
            style.setBorderLeft((short)1);

            /*Setting column style*/
            for (int width : columnWidths)
            {
            	sheet.setColumnWidth(columnCounter, width);
            	sheet.setDefaultColumnStyle(columnCounter, textStyle);
            	columnCounter++;
            }
            
            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : headerTitles)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }

            for (Standard standard : viewDetailsStandards)
            {
        		addContentRowInfo(reportLocaleCode, rowCounter, sheet, standard);
                rowCounter++;
            	
                List<Standard> specList = standard.getSpecifications();
                for (Standard spec : specList)
                {
            		addContentRowInfo(reportLocaleCode, rowCounter, sheet, spec);
                    rowCounter++;
                }
                
                List<Standard> gdlnList = standard.getGuidelines();
                for (Standard gdln : gdlnList)
                {
                	addContentRowInfo(reportLocaleCode, rowCounter, sheet, gdln);
                    rowCounter++;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return workbook;
    }

	private static void addContentRowInfo(String reportLocaleCode,
			int rowCounter, Sheet sheet, Standard standard) {
		Row dataRow = sheet.createRow(rowCounter);
		dataRow.createCell(0).setCellValue(standard.getStdId());
		dataRow.createCell(1).setCellValue(standard.getStdType());
		if("GDLN".equals(standard.getStdType())){
			dataRow.createCell(2).setCellValue(standard.getDescription());
		} else {
			dataRow.createCell(2).setCellValue(standard.getTitle());
		}
		if(Validator.isNotNull(reportLocaleCode)){
			if(Validator.isNotNull(standard.getStdTitleXlat())){
		    	dataRow.createCell(3).setCellValue(standard.getStdTitleXlat());
		    } else {
		    	dataRow.createCell(3).setCellValue("");
		    }
		    dataRow.createCell(4).setCellValue(standard.getStatus());
		} else {
		    dataRow.createCell(3).setCellValue(standard.getStatus());
		}
	}
	
	public static Workbook exportIndexTranslations(String reportType, String reportLocaleCode, List<Standard> viewDetailsStandards)
    {
		int columnCounter = 0;
		int rowCounter = 1;
		int columnWidths[] = new int[]{3000, 3000, 10000, 10000, 10000, 10000, 20000};
		String headerTitles[] = new String[]{"Index ID", "Level", "Heading", "Heading Translation", "Description", "Description Translation", "Path"};
		
        final Workbook workbook = new HSSFWorkbook();
        try
        {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(reportType+"Details ("+reportLocaleCode+")");
            
            //DataFormat fmt = workbook.createDataFormat();
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
            //textStyle.setDataFormat(fmt.getFormat("@"));
            
            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(boldFont);
            style.setBorderTop((short)1);
            style.setBorderRight((short)1);
            style.setBorderBottom((short)1);
            style.setBorderLeft((short)1);

            /*Setting column style*/
            for (int width : columnWidths)
            {
            	sheet.setColumnWidth(columnCounter, width);
            	sheet.setDefaultColumnStyle(columnCounter, textStyle);
            	columnCounter++;
            }
            
            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : headerTitles)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }
          
            for (Standard standard : viewDetailsStandards)
            {
                Row dataRow = sheet.createRow(rowCounter);
                dataRow.createCell(0).setCellValue(standard.getTaxonomyId());
                dataRow.createCell(1).setCellValue(standard.getLevel());
                dataRow.createCell(2).setCellValue(standard.getTaxonomyText());
                dataRow.createCell(3).setCellValue(standard.getIndexTitleXlat());
                dataRow.createCell(4).setCellValue(standard.getTaxonomyDesc());
                dataRow.createCell(5).setCellValue(standard.getIndexDescXlat());
                dataRow.createCell(6).setCellValue(standard.getTaxonomyPath().replaceAll("&#8594;", "->"));
                rowCounter++;
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return workbook;
    }
	
	public static Workbook exportNotifications(String reportType, List<Standard> viewDetailsStandards)
    {
		int columnCounter = 0;
		int rowCounter = 1;
		int columnWidths[] = new int[]{2200, 2000, 13000, 5000, 16000, 3200, 3500};
		String headerTitles[] = new String[]{"STD_ID", "Type", "Text", "Error Title", "Error Description", "Created Date", "Status"};
        final Workbook workbook = new HSSFWorkbook();
        try
        {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(reportType+"Details");
            
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
            
            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(boldFont);
            style.setBorderTop((short)1);
            style.setBorderRight((short)1);
            style.setBorderBottom((short)1);
            style.setBorderLeft((short)1);

            /*Setting column style*/
            for (int width : columnWidths)
            {
            	sheet.setColumnWidth(columnCounter, width);
            	sheet.setDefaultColumnStyle(columnCounter, textStyle);
            	columnCounter++;
            }
            
            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : headerTitles)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }
          
            if(viewDetailsStandards != null && viewDetailsStandards.size() > 0) 
            {
	            for (Standard standard : viewDetailsStandards)
	            {
	                Row dataRow = sheet.createRow(rowCounter);
	                dataRow.createCell(0).setCellValue(standard.getStdId());
	                dataRow.createCell(1).setCellValue(standard.getStdType());
	                dataRow.createCell(2).setCellValue(standard.getTitle());
	                dataRow.createCell(3).setCellValue(standard.getTaxonomyText());
	                dataRow.createCell(4).setCellValue(standard.getTaxonomyDesc());
	                dataRow.createCell(5).setCellValue(standard.getComplDateStr());
	                dataRow.createCell(6).setCellValue(standard.getStatus());
	                rowCounter++;
	            }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return workbook;
    }
	
	public static Workbook exportSupportContentTranslations(String reportType, String reportLocaleCode, List<Standard> viewDetailsStandards)
    {
		int columnCounter = 0;
		int rowCounter = 1;
		int columnWidths[] = null;
		String headerTitles[] = null;
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
        try
        {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(reportType+"Details ("+reportLocaleCode+")");
            
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
            style.setFont(boldFont);

            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : headerTitles)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }
            
            for (Standard standard : viewDetailsStandards)
            {
            	addAttachmentRowInfo(reportType, rowCounter, sheet, standard);
                rowCounter++;
                List<Standard> specList = standard.getSpecifications();
                for (Standard spec : specList)
                {
                	addAttachmentRowInfo(reportType, rowCounter, sheet, spec);
                    rowCounter++;
                }
                
                List<Standard> gdlnList = standard.getGuidelines();
                for (Standard gdln : gdlnList)
                {
                	addAttachmentRowInfo(reportType, rowCounter, sheet, gdln);
                    rowCounter++;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return workbook;
    }

	private static void addAttachmentRowInfo(String reportType, int rowCounter,
			Sheet sheet, Standard standard) {
		String regionText;
		if ("GLBL".equals(standard.getRegionCode())) {
		    if ("G".equals(standard.getIsGlobal())) {
		        if ("Y".equals(standard.getFramework())) {
		        	regionText = "Global Framework";
		        } else {
		        	regionText = "Global";
		        }
		    } else {
		        if ("Y".equals(standard.getFramework())) {
		        	regionText = "Multi Regional Framework";
		        } else {
		        	regionText = "Multi Regional";
		        }
		    }
		} else {
			regionText = standard.getRegionCode();
		}
		
		Row dataRow = sheet.createRow(rowCounter);
		dataRow.createCell(0).setCellValue(regionText);
		dataRow.createCell(1).setCellValue(standard.getTaxonomyPath().replaceAll("&#8594;", "->"));
		dataRow.createCell(2).setCellValue(standard.getStdId());
		dataRow.createCell(3).setCellValue(standard.getStdType());
		dataRow.createCell(4).setCellValue(standard.getTitle());
		dataRow.createCell(5).setCellValue(standard.getCategory());
		dataRow.createCell(6).setCellValue(standard.getManual());
		
		if("AttachmentTranslationView".equals(reportType)){
			if(Validator.isNotNull(standard.getAttachmentList())) {
				String attachments[] = standard.getAttachmentList().split(";;; ");
				if (attachments != null && attachments.length > 0) {
					boolean hasData = false;
					StringBuffer attachmentTitles = new StringBuffer();
					for (String attachment : attachments) {
	                	String attachmentData[] = attachment.split(":::");
	                    if (attachmentData.length >= 2) {
	                    	if(hasData){
	                    		attachmentTitles.append(",\n");
	                    		attachmentTitles.append(attachmentData[0]);
	                    	} else {
	                    		attachmentTitles.append(attachmentData[0]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					dataRow.createCell(7).setCellValue(attachmentTitles.toString());
				} else {
					dataRow.createCell(7).setCellValue(standard.getAttachmentList());
				}
			}
			
			if(Validator.isNotNull(standard.getAttachmentListXlat())) {
				String attachments[] = standard.getAttachmentListXlat().split(";;; ");
				if (attachments != null && attachments.length > 0) {
					boolean hasData = false;
					StringBuffer attachmentTitlesXlat = new StringBuffer();
					for (String attachment : attachments) {
	                	String attachmentData[] = attachment.split(":::");
	                    if (attachmentData.length >= 2) {
	                    	if(hasData){
	                    		attachmentTitlesXlat.append(",\n");
	                    		attachmentTitlesXlat.append(attachmentData[0]);
	                    	} else {
	                    		attachmentTitlesXlat.append(attachmentData[0]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					if(Validator.isNotNull(attachmentTitlesXlat.toString())){
						dataRow.createCell(8).setCellValue(attachmentTitlesXlat.toString());
					} else {
						dataRow.createCell(8).setCellValue("");
					}
				} else {
					dataRow.createCell(8).setCellValue(standard.getAttachmentListXlat());
				}
		    	dataRow.createCell(9).setCellValue(standard.getStatus());
			} else {
				if(Validator.isNotNull(standard.getAttachmentList())) {
			    	dataRow.createCell(8).setCellValue("");
			    	dataRow.createCell(9).setCellValue(standard.getStatus());//"YES");//standard.getStatus());
				}
		    }
			
		} else if("LinkTranslationView".equals(reportType)){
			if(Validator.isNotNull(standard.getLinkList())) {
				String links[] = standard.getLinkList().split(";;; ");
				if (links != null && links.length > 0) {
					boolean hasData = false;
					StringBuffer linkTitles = new StringBuffer();
					StringBuffer linkURLs = new StringBuffer();
					for (String link : links) {
	                	String linkData[] = link.split(":::");
	                    if (linkData.length >= 2) {
	                    	if(hasData){
	                    		linkTitles.append(",\n");
	                    		linkTitles.append(linkData[0]);
	                    		linkURLs.append(",\n");
	                    		linkURLs.append(linkData[1]);
	                    	} else {
	                    		linkTitles.append(linkData[0]);
	                    		linkURLs.append(linkData[1]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					dataRow.createCell(7).setCellValue(linkTitles.toString());
					dataRow.createCell(10).setCellValue(linkURLs.toString());
				} else {
					dataRow.createCell(7).setCellValue(standard.getLinkList());
				}
			}
			
			if(Validator.isNotNull(standard.getLinkListXlat())) {
				String links[] = standard.getLinkListXlat().split(";;; ");
				if (links != null && links.length > 0) {
					boolean hasData = false;
					StringBuffer linkTitlesXlat = new StringBuffer();
					for (String link : links) {
	                	String linkData[] = link.split(":::");
	                    if (linkData.length >= 2) {
	                    	if(hasData){
	                    		linkTitlesXlat.append(",\n");
	                    		linkTitlesXlat.append(linkData[0]);
	                    	} else {
	                    		linkTitlesXlat.append(linkData[0]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					if(Validator.isNotNull(linkTitlesXlat.toString())){
						dataRow.createCell(8).setCellValue(linkTitlesXlat.toString());
					} else {
						dataRow.createCell(8).setCellValue("");
					}
				} else {
					dataRow.createCell(8).setCellValue(standard.getLinkListXlat());
				}
				dataRow.createCell(9).setCellValue(standard.getStatus());
			} else {
				if(Validator.isNotNull(standard.getLinkList())) {
			    	dataRow.createCell(8).setCellValue("");
			    	dataRow.createCell(9).setCellValue(standard.getStatus());
				}
			}
			
		} else if("ImageTranslationView".equals(reportType)){

			if(Validator.isNotNull(standard.getImageList())) {
				String images[] = standard.getImageList().split(";;; ");
				if (images != null && images.length > 0) {
					boolean hasData = false;
					StringBuffer imageTitles = new StringBuffer();
					for (String image : images) {
	                	String imageData[] = image.split(":::");
	                    if (imageData.length >= 2) {
	                    	if(hasData){
	                    		imageTitles.append(",\n");
	                    		imageTitles.append(imageData[0]);
	                    	} else {
	                    		imageTitles.append(imageData[0]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					dataRow.createCell(7).setCellValue(imageTitles.toString());
				} else {
					dataRow.createCell(7).setCellValue(standard.getImageList());
				}
			}
			
			if(Validator.isNotNull(standard.getImageListXlat())) {
				String images[] = standard.getImageListXlat().split(";;; ");
				if (images != null && images.length > 0) {
					boolean hasData = false;
					StringBuffer imageTitlesXlat = new StringBuffer();
					for (String image : images) {
	                	String imageData[] = image.split(":::");
	                    if (imageData.length >= 2) {
	                    	if(hasData){
	                    		imageTitlesXlat.append(",\n");
	                    		imageTitlesXlat.append(imageData[0]);
	                    	} else {
	                    		imageTitlesXlat.append(imageData[0]);
	                    		hasData = true;
	                    	}
	                    }
	                }
					if(Validator.isNotNull(imageTitlesXlat.toString())){
						dataRow.createCell(8).setCellValue(imageTitlesXlat.toString());
					} else {
						dataRow.createCell(8).setCellValue("");
					}
				} else {
					dataRow.createCell(8).setCellValue(standard.getImageListXlat());
				}
		    	dataRow.createCell(9).setCellValue(standard.getStatus());
			} else {
				if(Validator.isNotNull(standard.getImageList())) {
			    	dataRow.createCell(8).setCellValue("");
			    	dataRow.createCell(9).setCellValue(standard.getStatus());
				}
		    }
			
		}
	}
	
	/**
	 * 
	 * @param reportTitle
	 * @param viewDetailsStandards
	 * @return Workbook
	 * This is a My publication drill down report
	 */
	public static Workbook exportStandardsErrorReport(String reportTitle, List<Standard> viewDetailsStandards)
    {
		int columnCounter = 0;
		int rowCounter = 1;
		
        final Workbook workbook = new HSSFWorkbook();
        try {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(reportTitle);
            // Cell style
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
           // Cell style 
            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(boldFont);
            style.setBorderTop((short)1);
            style.setBorderRight((short)1);
            style.setBorderBottom((short)1);
            style.setBorderLeft((short)1);
            /*Setting column style*/
            for (int width : BridgeConstants.COLUMN_WIDTH)
            {
            	sheet.setColumnWidth(columnCounter, width);
            	sheet.setDefaultColumnStyle(columnCounter, textStyle);
            	columnCounter++;
            }
            Row headerRow = sheet.createRow(0);
            columnCounter = 0;
            for (String header : BridgeConstants.HEADER_TITLE)
            {
            	Cell cell = headerRow.createCell(columnCounter);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString(header));
                columnCounter++;
            }
            for (Standard standard : viewDetailsStandards)
            {
            	addStandardRowInfo(rowCounter, sheet, standard);
                rowCounter++;
            	
                List<Standard> specList = standard.getSpecifications();
                for (Standard spec : specList)
                {
                	addStandardRowInfo(rowCounter, sheet, spec);
                    rowCounter++;
                }
                List<Standard> gdlnList = standard.getGuidelines();
                for (Standard gdln : gdlnList)
                {
                	addStandardRowInfo(rowCounter, sheet, gdln);
                    rowCounter++;
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e);
        }
        return workbook;
    }
	
	/**
	 * 
	 * @param rowCounter
	 * @param sheet
	 * @param standard
	 */
	private static void addStandardRowInfo(int rowCounter, Sheet sheet, Standard standard) {
		Row dataRow = sheet.createRow(rowCounter);
		dataRow.createCell(0).setCellValue(standard.getTaxonomyPath().replaceAll("&#8594;", "->"));
		dataRow.createCell(1).setCellValue(standard.getStdId());
		dataRow.createCell(2).setCellValue(standard.getStdType());
		if(BridgeConstants.TYPE_GDLN.equals(standard.getStdType())){
			dataRow.createCell(3).setCellValue(standard.getDescription());
		} else {
			dataRow.createCell(3).setCellValue(standard.getTitle());
		}
		dataRow.createCell(4).setCellValue(standard.getStatus());
	}
	
}
