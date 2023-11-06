package com.ihg.brandstandards.custom.report; 

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.List;

import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.xml.bind.JAXBException;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.bridge.portlet.EditStatesPortlet;
import com.ihg.brandstandards.db.model.BridgePublishPreview;
import com.ihg.brandstandards.db.model.BridgePublishStateEx;
import com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgePublishStateExLocalServiceUtil;
import com.ihg.brandstandards.bridge.model.BadCell;
import com.ihg.brandstandards.bridge.model.Record;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.util.PortalUtil;

/**
 * Class is mainly user for Glossary Action. 
 * All the logic of actions implmented here and call from controller i.e. Glossary.java
 * @author ketan.savaliya
 *
 */
public class ReportProcessor
{
    private static final Log LOG = LogFactoryUtil.getLog(EditStatesPortlet.class); 
    
    /**
     * Private construction.
     */
    private ReportProcessor()
    {
    } 

    /**
     * Export : serveResource call.
     * @param resourceRequest  resourceRequest.
     * @param resourceResponse resourceResponse.
     */
    public static void exportPreview(ResourceRequest resourceRequest,  ResourceResponse resourceResponse)
    {
       String chainCd = (String) resourceRequest.getAttribute("chainCd");
       String regionCd = (String) resourceRequest.getAttribute("regionCd");
       final Workbook workbook =  new HSSFWorkbook();
       try
       {
           List<BridgePublishPreview> defaultPreviewList =  BridgePublishPreviewLocalServiceUtil.getBridgePublishPreviewByRegionBrand(chainCd, Long.valueOf(regionCd)); 
           Sheet sheet = createSheet(workbook, ReportUtil.REPORT_TYPE_PREVIEW, ReportUtil.PREVIEW_HEADERS);
           int cellIncrement = 0;
           int rowCount = 1; 
           for (BridgePublishPreview defaultPreview : defaultPreviewList)
           {
               cellIncrement = 0;
               Row row1  =  sheet.createRow(rowCount++); 
               row1.createCell(cellIncrement++).setCellValue(defaultPreview.getStdId());
               row1.createCell(cellIncrement++).setCellValue(defaultPreview.getType());
               row1.createCell(cellIncrement++).setCellValue(defaultPreview.getTitle());
               row1.createCell(cellIncrement++).setCellValue(defaultPreview.getCurrentTitle());
               
           }
           for (int column = 0;  column < cellIncrement;  column++)
           {
               sheet.autoSizeColumn(column); 
           }
       } 
       catch (Exception e)
       {
           LOG.error(e.getMessage(), e); 
       }
       exportOutput(resourceRequest, resourceResponse, workbook, "UpdatePreview.xls");     
    }

    /**
     * Import : serveResource Call.
     * @param resourceRequest resourceRequest.
     * @param resourceResponse resourceResponse.
     * @throws IOException IOException.
     * @throws PortalException  PortalException.
     */
    public static void importState(ResourceRequest resourceRequest,  ResourceResponse resourceResponse) throws IOException 
    {
        PrintWriter out =  resourceResponse.getWriter(); 
        JSONObject recordsjsonObject  =   JSONFactoryUtil.createJSONObject(); 
        String json = StringPool.BLANK;
        try
        {
            try
            {
                HttpServletRequest request  =  PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest)); 
                final boolean isMultipart  =  PortletFileUpload.isMultipartContent(new ServletRequestContext(request)); 
                UploadPortletRequest uploadRequest  =  null; 
                if (isMultipart)
                {
                    uploadRequest  =  PortalUtil.getUploadPortletRequest(resourceRequest); 
                    recordsjsonObject  =  readExcelFile(uploadRequest,  resourceRequest, resourceResponse); 
                }
            } 
            catch (NullPointerException e)
            {
                json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - :" + e.getMessage() + "\"}";
                out.print(json); 
                out.flush(); 
                out.close(); 
                LOG.info(e.getMessage(),e);
            }
            catch (ClassCastException e)
            {
                json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - :" + e.getMessage() + "\"}"; 
                out.print(json); 
                out.flush(); 
                out.close(); 
                LOG.error(e.getMessage(),e); 
            }
            catch (SystemException e)
            {
                json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception -:" + e.getMessage() + "\"}"; 
                out.print(json); 
                out.flush(); 
                out.close(); 
                LOG.error(e.getMessage(),e);
            }   
            catch (PortalException e) 
            {
                json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception -:" + e.getMessage() + "\"}"; 
                out.print(json); 
                out.flush(); 
                out.close(); 
                LOG.error(e.getMessage(),e);
            } 
            
            if ((recordsjsonObject  !=   null) && (recordsjsonObject.length() > 0))
            {
                resourceResponse.getWriter().print(recordsjsonObject.toString()); 
               
            } 
            else
            {
                json  =  "{" + "\"response\": \"Success\", " +"\"message\": \"Record Inserted Successfully.\"}"; 
                out.print(json); 
                out.flush(); 
                out.close(); 
            }
        } 
        catch (IOException iox)
        {
            json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception -:" + iox.getMessage() + "\"}"; 
            out.print(json); 
            out.flush(); 
            out.close(); 
        } 
        catch (JAXBException jax)
        {
            json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - Exception\"}"; // "+e.getMessage()+"\"}"; 
            out.print(json); 
            out.flush(); 
            out.close(); 
        } 
        catch (InvalidFormatException ifx)
        {
            json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Failure - Exception  - Exception\"}"; // "+e.getMessage()+"\"}"; 
            out.print(json); 
            out.flush(); 
            out.close(); 
        }
        

    }
    
    /**
     * Method is use to read xls file and import/update Glossary recored.
     * return JSONObject for success/error message.
     * @param uploadRequest uploadRequest.
     * @param resourceRequest resourceRequest.
     * @param response response.
     * @param progressTracker progressTracker.
     * @throws IOException IOException.
     * @throws InvalidFormatException InvalidFormatException.
     * @throws JAXBException JAXBException.
     * @throws SystemException SystemException.
     * @throws PortalException PortalException.
     * @return JSONObject JSONObject.
     */
    static JSONObject readExcelFile(UploadPortletRequest uploadRequest, ResourceRequest resourceRequest,  ResourceResponse response) 
            throws InvalidFormatException, JAXBException, PortalException, SystemException, IOException 
    {
        JSONObject recordsjsonObject  = null; 
        String fileName  =  uploadRequest.getFileName("file"); 
        if ((fileName  ==  null) || "".equals(fileName))
        {
            throw new IOException("No File is selected.Please browse file again!"); 
        }
        File file  =  uploadRequest.getFile("file"); 
        
        LOG.info(" filename " + fileName + " file " + file); 
        ReportProcessXlsFile processXlsFile  =  new ReportProcessXlsFile(); 
        List<Record> records  =  processXlsFile.editStatesProcessXls(file); 
        List<Record> badRecords  =  null; 
        badRecords  =  processXlsFile.getBadRows(records); 
        if (badRecords.size() > 0)
        {
            //return it in GUI
            recordsjsonObject  =  JSONFactoryUtil.createJSONObject(); 
            JSONArray rowjsonObject  =  null; 
            JSONObject cell  =  null; 
            JSONArray recordsjsonArray  =  JSONFactoryUtil.createJSONArray(); 
            recordsjsonObject.put("page",  "1"); 
            recordsjsonObject.put("records ",  String.valueOf(badRecords.size())); 
            if (!badRecords.isEmpty())
            {
                for (int i  =  0;  i < badRecords.size();  i++)
                {
        
                    Record record  =  badRecords.get(i); 
                    rowjsonObject  =  JSONFactoryUtil.createJSONArray(); 
                    cell  =  JSONFactoryUtil.createJSONObject(); 
                    rowjsonObject.put(String.valueOf(record.getId())); 
                    List<BadCell> cells  =  record.getBadCell(); 
                    for (BadCell cell1 : cells)
                    {
                        LOG.info("Row = " + cell1.getRow() + "' column name = '" + cell1.getColumnName()
                                + "' worksheet = '" + cell1.getWorksheet() + "' error message = '" + cell1.getErrorMessage()
                                + "' value = '" + cell1.getValue() + "'"); 
                        rowjsonObject.put(String.valueOf(cell1.getRow())); 
                        rowjsonObject.put(String.valueOf(cell1.getColumnName())); 
                        rowjsonObject.put(String.valueOf(cell1.getValue())); 
                        rowjsonObject.put(String.valueOf(cell1.getErrorMessage())); 
                    }
        
                    cell.put("id",  String.valueOf(record.getId())); 
                    cell.put("cell",  rowjsonObject); 
                    recordsjsonArray.put(cell); 
                }
                recordsjsonObject.put("rows",  recordsjsonArray); 
            }
        }
        return recordsjsonObject; 
    }
    
    /**
     * Export : serveResource call.
     * @param resourceRequest  resourceRequest.
     * @param resourceResponse resourceResponse.
     */
    public static void exportStates(ResourceRequest resourceRequest,  ResourceResponse resourceResponse)
    {
        String chainCd = (String) resourceRequest.getAttribute("chainCd");
        String regionCd = (String) resourceRequest.getAttribute("regionCd");
        final Workbook workbook =  new HSSFWorkbook();
        try
        {
            List<BridgePublishStateEx> defaultStateExList =  BridgePublishStateExLocalServiceUtil.getBridgePublishStateExByRegionBrand(chainCd, Long.valueOf(regionCd)); 
            Sheet sheet = createSheet(workbook, ReportUtil.REPORT_TYPE_STATES, ReportUtil.STATES_HEADERS);
            int cellIncrement = 0;
            int rowCount = 1; 
            for (BridgePublishStateEx defaultPreview : defaultStateExList)
            {
                cellIncrement = 0;
                Row row1  =  sheet.createRow(rowCount++); 
                row1.createCell(cellIncrement++).setCellValue(defaultPreview.getStdId());
                row1.createCell(cellIncrement++).setCellValue(defaultPreview.getType());
                row1.createCell(cellIncrement++).setCellValue(defaultPreview.getTitle());
                row1.createCell(cellIncrement++).setCellValue(defaultPreview.getStateCd());
            }
            for (int column = 0;  column < cellIncrement;  column++)
            {
                sheet.autoSizeColumn(column); 
            }
        } 
        catch (Exception e)
        {
            LOG.error(e.getMessage(), e); 
        }
        exportOutput(resourceRequest, resourceResponse, workbook, "States.xls");
    }
    
    /**
     * Export : serveResource call.
     * @param resourceRequest  resourceRequest.
     * @param resourceResponse resourceResponse.
     */
    public static void exportOutput(ResourceRequest resourceRequest,  ResourceResponse resourceResponse, Workbook workbook, String fileName)
    {
    	String json  =  ""; 
        final PrintWriter out; 
    	try
    	{
            resourceResponse.setContentType("application/vnd.ms-excel"); 
            resourceResponse.addProperty("Content-Disposition",  "attachment;  filename = " + fileName); 

            final OutputStream out1  =  resourceResponse.getPortletOutputStream(); 
            workbook.write(out1); 
            out1.flush(); 
            out1.close(); 
        } 
    	catch (IOException e)
        {
            try
            {
				out  =  resourceResponse.getWriter(); 
				json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Failure -  Exception - Exception\"}"; 
				out.print(json); 
				out.flush(); 
				out.close(); 
			} 
            catch (IOException e1)
			{
				LOG.error(e.getMessage(), e); 
			}
        }
    }
    
    private static Sheet createSheet(Workbook wb, String name, List<String> headers)
    {
        CreationHelper createHelper  =  wb.getCreationHelper(); 
        Sheet sheet  =  wb.createSheet(name); 

        DataFormat fmt  =  wb.createDataFormat(); 
        CellStyle textStyle  =  wb.createCellStyle(); 
        textStyle.setDataFormat(fmt.getFormat("@")); 
        sheet.setDefaultColumnStyle(2,  textStyle);  
       
        CellStyle style = wb.createCellStyle(); 
        Font boldFont = wb.createFont();  
        boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);  
        style.setFont(boldFont); 
        Row row  =  sheet.createRow(0); 
        createHeader(row,  style,  createHelper, headers);
        return sheet;
    }
    /**
     * Method is use to create Header of xls file while export.
     * @param row row.
     * @param style style.
     * @param createHelper createHelper.
     * @param selectedLocale selectedLocale.
     * @return int int.
     */
    static int createHeader(Row row, CellStyle style, CreationHelper createHelper, List<String> titles)
    {
    	int cellCounter  =  0;
    	for(String title : titles)
    	{
    	    createCell(row,  style,  createHelper,  title,  cellCounter++); 
    	}
        return cellCounter; 
    }
    
    /**
     * Create cell to give Row,  FiledName,  CellIndex.
     * @param row row.
     * @param style style.
     * @param createHelper createHelper.
     * @param headerFieldName headerFieldName.
     * @param cellIndex cellIndex.
     */
    static void createCell(Row row, CellStyle style, CreationHelper createHelper, String headerFieldName, int cellIndex)
    {
    	Cell cell  =  row.createCell(cellIndex); 
        cell.setCellStyle(style); 
        cell.setCellValue(createHelper.createRichTextString(headerFieldName)); 
    }
}