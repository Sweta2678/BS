package com.ihg.brandstandards.spreadsheet; 

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;

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

import com.ihg.brandstandards.bsadmin.model.BadCell;
import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.db.NoSuchGlossaryException;
import com.ihg.brandstandards.db.NoSuchGlossaryTranslateException;
import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsCacheUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.GlossaryUtil;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.ProgressTrackerThreadLocal;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * Class is mainly user for Glossary Action. 
 * All the logic of actions implmented here and call from controller i.e. Glossary.java
 * @author ketan.savaliya
 *
 */
public class GlossaryReportProcessor
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryReportProcessor.class); 
    
    /**
     * Private construction.
     */
    private GlossaryReportProcessor()
    {
    } 
    /**
     * Export : serveResource call.
     * @param resourceRequest  resourceRequest.
     * @param resourceResponse resourceResponse.
     */
    public static void exportGlossary(ResourceRequest resourceRequest,  ResourceResponse resourceResponse)
    {
    	 String json  =  ""; 
         final PrintWriter out; 
    	try
    	{
            String selectedLocale  =  resourceRequest.getParameter("SELECTED_LOCALE"); 
            final Workbook workbook  =  xmlExcelExportGlossary(selectedLocale, resourceRequest); 

            resourceResponse.setContentType("application/vnd.ms-excel"); 
            resourceResponse.addProperty("Content-Disposition",  "attachment;  filename = Glossary.xls"); 
            final OutputStream xlsFileStream  =  resourceResponse.getPortletOutputStream(); 
            workbook.write(xlsFileStream); 
            xlsFileStream.flush(); 
            xlsFileStream.close(); 
        } 
    	catch (Exception e)
        {
            try
            {
				out  =  resourceResponse.getWriter(); 
				json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Failure -  Exception - Exception\"}"; 
				out.print(json); 
				out.flush(); 
				out.close(); 
			} 
            catch (Exception exp)
			{
				LOG.error(exp.getMessage(), exp); 
			}
        }
    }
    
    /**
     * Import : serveResource Call.
     * @param resourceRequest resourceRequest.
     * @param resourceResponse resourceResponse.
     * @throws IOException IOException.
     * @throws PortalException  PortalException.
     */
    public static void importGlossary(ResourceRequest resourceRequest,  ResourceResponse resourceResponse) throws IOException 
    {
        PrintWriter out =  resourceResponse.getWriter(); 
        JSONObject recordsjsonObject  =   JSONFactoryUtil.createJSONObject(); 
        ProgressTracker progressTracker = null; 
        String locale = StringPool.BLANK;
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
                	locale  =  ParamUtil.getString(uploadRequest,  "localeCd"); 
                	
                	String importProgressId  =  ParamUtil.getString(uploadRequest,  "importProgressId");  
                	progressTracker  =  new ProgressTracker(importProgressId); 
                	ProgressTrackerThreadLocal.setProgressTracker(progressTracker); 
                	progressTracker.start(resourceRequest); 
                	recordsjsonObject  =  readExcelFile(uploadRequest,  resourceRequest, resourceResponse, progressTracker); 
                }
            } 
            catch (NullPointerException e)
            {
            	json  =  "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - :" + e.getMessage() + "\"}";
            	out.print(json); 
                out.flush(); 
                out.close(); 
                e.printStackTrace();
            	LOG.error(e.getMessage(), e);
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
            
            finally
            {
            	if ( progressTracker != null)
            	{
            		progressTracker.finish(resourceRequest);
            	}
            }
            if ((recordsjsonObject  !=   null) && (recordsjsonObject.length() > 0))
            {
                resourceResponse.getWriter().print(recordsjsonObject.toString()); 
               
            } 
            else
            {
                json  =  "{" + "\"response\": \"Success\", " + "\"locale\": \"" + locale + "\", " + "\"message\": \"Record Inserted Successfully.\"}"; 
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
     * Import/Update Glossary data based on give xls file while import Glossary.
     * @param request request.
     * @param recordList recordList.
     * @param localeCd localeCd.
     * @param progressTracker progressTracker.
     * @throws SystemException  SystemException.
     * @throws PortalException PortalException.
     */
    static void addUpdateExcelGlossaryTranslations(final ResourceRequest request,  List<Record> recordList,  String localeCd, ProgressTracker progressTracker) 
    		throws SystemException, PortalException
            
    {
        int percentage = GlossaryUtil.MAGIC_FIFTY; 
        ThemeDisplay themeDisplay  =  (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY); 
        int oldPercentage = GlossaryUtil.MAGIC_FIFTY; 
        int i = 0; 
        GlossaryTranslate glossaryTranslation  =  null; 
        Glossary glossary  =  null; 
        List<GlossaryRegionNav> glossaryRegionNav  =  null; 
        boolean isGlossaryTranslateChange; 
        boolean isGlossaryChange ;
        Map<String,  StandardsRegion> regionList = BrandStandardsCacheUtil.getAllRegion(); 
        for (com.ihg.brandstandards.bsadmin.model.Record record : recordList)
        {
        	boolean newGlossary = false;
        	glossaryRegionNav  =  new ArrayList<GlossaryRegionNav>(); 
        	long glossaryId  =  (long) Double.parseDouble(record.getId() !=  null ? record.getId() : "0"); 
        	if (!localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE))
        	{
        		glossaryTranslation = getTranslationByGlossaryIdAndlocale(glossaryId, localeCd, themeDisplay);
        	}
            isGlossaryTranslateChange  =  false; 
            isGlossaryChange  =  false; 
            List<Record> cells  =  localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE) ? record.getFields().get(GlossaryUtil.REPORT_TYPE_GLOSSARY_BASE) 
            					:  record.getFields().get(GlossaryUtil.REPORT_TYPE_GLOSSARY_TRANSLATION); 
            String glossaryTitle =  StringPool.BLANK; 
            for (com.ihg.brandstandards.bsadmin.model.Record cell : cells)
        	{
                if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_TITLE_TERM) && !localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE))
                {
                	if (!glossaryTranslation.getGlossaryTermText().equalsIgnoreCase( (String) cell.getValue()))
                	{
                		isGlossaryTranslateChange  =  true; 
                		glossaryTranslation.setGlossaryTermText(BrandStandardsUtil.IsNullOrBlank( (String) cell.getValue()) ? StringPool.SPACE : (String) cell.getValue()); 
                		if (BrandStandardsUtil.IsNullOrBlank((String) cell.getValue()))
                		{
                			glossaryTranslation.setIsValidTermTxt(GlossaryUtil.DEFAULT_NO); 
                		} 
                		else
                		{
                			glossaryTranslation.setIsValidTermTxt(GlossaryUtil.DEFAULT_YES); 
                		}
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_DESC_TERM) && !localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE))
                {
                    if (!glossaryTranslation.getGlossaryTermDesc().equalsIgnoreCase( (String) cell.getValue()))
                    {
                        glossaryTranslation.setGlossaryTermDesc( (String) cell.getValue()); 
                        isGlossaryTranslateChange  =  true; 
                        if (BrandStandardsUtil.IsNullOrBlank((String) cell.getValue()))
                        {
                			glossaryTranslation.setIsValidDescTxt(GlossaryUtil.DEFAULT_NO); 
                		} 
                        else
                		{
                			glossaryTranslation.setIsValidDescTxt(GlossaryUtil.DEFAULT_YES); 
                		}
                    }
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_ID))
                {
                	try
                	{
                		glossary  =  GlossaryLocalServiceUtil.getGlossary( Long.valueOf(( (String) cell.getValue()) !=  null ? (String) cell.getValue() : "0")); 
                	} 
                	catch (NoSuchGlossaryException ex)
                	{
                		glossary  =  getDefaultGlossary(themeDisplay.getUserId()); 
                		newGlossary = true;
                	} 
                	catch (NumberFormatException e)
                	{
                        LOG.error("Number format exception in update glossary"); 
                        glossary  =  getDefaultGlossary(themeDisplay.getUserId());
                        newGlossary= true;
                    }
                	glossaryId  =  glossary.getGlossaryId(); 
                	if (!localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE))
                	{
                		glossaryTranslation.setGlossaryId(glossary.getGlossaryId()); 
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_PUBLISHED) && ( localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE) || newGlossary ))
                {
                	if (!glossary.getActiveInd().equalsIgnoreCase((String) cell.getValue()))
                	{
                		glossary.setActiveInd((String) cell.getValue()); 
                		isGlossaryChange  =  true;  
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_OWNER) && newGlossary)
                {
                	
                    long ownerId = getStandardRegionFromMap(regionList, (String) cell.getValue()).getRegionId();
                	if (glossary.getGlossaryOwner() != ownerId)
                	{
                		glossary.setGlossaryOwner(ownerId); 
                		isGlossaryChange  =  true;  
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_TITLE))
                {
                	glossaryTitle  =  (String) cell.getValue(); 
                	if (!glossary.getGlossaryTermText().equalsIgnoreCase((String) cell.getValue()))
                	{
                		glossary.setGlossaryTermText((String) cell.getValue()); 
                		isGlossaryChange  =  true;  
                		updateTranslationIndicator(glossaryId, GlossaryUtil.CONFIGURE_FIELD_TITLE, localeCd);
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_DESC))
                {
                	if (!glossary.getGlossaryTermDesc().equalsIgnoreCase((String) cell.getValue()))
                	{
                		glossary.setGlossaryTermDesc((String) cell.getValue()); 
                		isGlossaryChange  =  true; 
                		updateTranslationIndicator(glossaryId, GlossaryUtil.CONFIGURE_FIELD_DESC, localeCd);
                	}
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_GC))
                {
                	importGlossaryRegionNavigation((String) cell.getValue(),  themeDisplay.getUserId(),  glossaryId,  getStandardRegionFromMap(regionList, GlossaryUtil.XLS_FIELD_GC).getRegionId(), 
                			glossaryTitle, glossary.getActiveInd(), glossaryRegionNav); 
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_EUROPE))
                {
                	importGlossaryRegionNavigation((String) cell.getValue(),  themeDisplay.getUserId(),  glossaryId,  getStandardRegionFromMap(regionList, GlossaryUtil.XLS_FIELD_EUROPE).getRegionId(), 
                			glossaryTitle, glossary.getActiveInd(), glossaryRegionNav); 
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_AMEA))
                {
                	importGlossaryRegionNavigation((String) cell.getValue(),  themeDisplay.getUserId(),  glossaryId,  getStandardRegionFromMap(regionList, GlossaryUtil.XLS_FIELD_AMEA).getRegionId(), 
                			glossaryTitle, glossary.getActiveInd(), glossaryRegionNav); 
                } 
                else if (cell.getFieldName().equalsIgnoreCase(GlossaryUtil.CONFIGURE_FIELD_AMER))
                {
                	importGlossaryRegionNavigation((String) cell.getValue(),  themeDisplay.getUserId(),  glossaryId,  getStandardRegionFromMap(regionList, GlossaryUtil.XLS_FIELD_AMER).getRegionId(), 
                			glossaryTitle, glossary.getActiveInd(), glossaryRegionNav); 
                }
            }

            if (isGlossaryChange)
            {
            	GlossaryLocalServiceUtil.updateGlossary(glossary); 
            }
            if (isGlossaryTranslateChange && !localeCd.equalsIgnoreCase(GlossaryUtil.DEFAULT_LOCALE))
            {
            	GlossaryTranslateLocalServiceUtil.updateGlossaryTranslate(glossaryTranslation); 
            }
            
            for (GlossaryRegionNav regionNav : glossaryRegionNav)
            {
            	GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav); 
            }
            
            percentage  =  Math.min(GlossaryUtil.MAGIC_FIFTY + (i * GlossaryUtil.MAGIC_FIFTY) / recordList.size(),  GlossaryUtil.MAGIC_HUNDRED); 
            if (oldPercentage != percentage)
            {
            	progressTracker.setPercent(percentage); 
            }
            oldPercentage = percentage; 
            i++; 
        }
    }
    
    static void updateTranslationIndicator(long glossaryId,
			String configureFieldTitle, String localeCd) throws SystemException {
		List<GlossaryTranslate> translationList = GlossaryTranslateLocalServiceUtil.getGlossarriesByGlossaryId(glossaryId);
		for (GlossaryTranslate  translation : translationList )
		{
			if (!localeCd.equalsIgnoreCase(translation.getLangCode()))
			{
				if (GlossaryUtil.CONFIGURE_FIELD_TITLE.equals(configureFieldTitle))
				{
					translation.setIsValidTermTxt(GlossaryUtil.DEFAULT_NO);
				}
				else
				{
					translation.setIsValidDescTxt(GlossaryUtil.DEFAULT_NO);
				}
			}
			
			GlossaryTranslateLocalServiceUtil.updateGlossaryTranslate(translation);
		}
		
	}
	/**
     * Create WorkBook (XLS) file while export Glossary.
     * @return Workbook Workbook.
     * @param selectedLocale selectedLocale.
     * @param resourceRequest resourceRequest.
     */
    static Workbook xmlExcelExportGlossary(String selectedLocale, ResourceRequest resourceRequest)
    {
        final Workbook wb  =  new HSSFWorkbook(); 
        try
        {
            CreationHelper createHelper  =  wb.getCreationHelper(); 
            Sheet sheet  =  wb.createSheet(selectedLocale.equals(GlossaryUtil.DEFAULT_LOCALE) ? GlossaryUtil.REPORT_TYPE_GLOSSARY_BASE : GlossaryUtil.REPORT_TYPE_GLOSSARY_TRANSLATION); 
            List<Glossary> defaultGlossaryList ; 
            if (!UserPreferencesUtil.getUserpreferences(resourceRequest).equals(BSAdminConstants.ALL_BRAND))
            {
            	defaultGlossaryList  =  GlossaryLocalServiceUtil.getGlossaryIdByBrandCode(UserPreferencesUtil.getUserpreferences(resourceRequest)); 
            	
            } 
            else
            {
            
            	defaultGlossaryList  =  GlossaryLocalServiceUtil.getGlossaries(-1,  -1); 
            }
            DataFormat fmt  =  wb.createDataFormat(); 
            CellStyle textStyle  =  wb.createCellStyle(); 
            textStyle.setDataFormat(fmt.getFormat("@")); 
            sheet.setDefaultColumnStyle(2,  textStyle);  
           
            CellStyle style = wb.createCellStyle(); 
            Font boldFont = wb.createFont();  
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);  
            style.setFont(boldFont); 
            int rowCount = 0; 
            int columnCount = 0; 
            Row row  =  sheet.createRow((short) rowCount++); 
            columnCount  =  createHeader(row,  style,  createHelper,  selectedLocale); 
            Map<String,  StandardsRegion> regionList  =  BrandStandardsCacheUtil.getAllRegion(); 
            for (Glossary defaultGlossary : defaultGlossaryList)
            {
                	  	int cellIncrement = 0; 
                        Row row1  =  sheet.createRow(rowCount++); 
                        Cell cell1  =  row1.createCell(cellIncrement++); 
                        cell1.setCellValue(defaultGlossary.getGlossaryId()); 
                        GlossaryTranslate selectedLocaleGlossary  =  null; 
                        row1.createCell(cellIncrement++).setCellValue(defaultGlossary.getGlossaryTermText()); 
                        if (!selectedLocale.equals(GlossaryUtil.DEFAULT_LOCALE))
                        {
                        	try
                        	{
	                        	selectedLocaleGlossary  = GlossaryTranslateLocalServiceUtil.getByGlossaryIdLocaleCode(defaultGlossary.getGlossaryId(),  selectedLocale); 
                        	} 
                        	catch (NoSuchGlossaryTranslateException ex)
                        	{
                        		LOG.error(ex.getMessage(),ex);
                        	}
                        	if ( BrandStandardsUtil.IsNullOrBlank(selectedLocaleGlossary))
                        	{
                        		selectedLocaleGlossary  =  GlossaryTranslateLocalServiceUtil.getGlossaryTranslateObject(); 
                        	}
                        	row1.createCell(cellIncrement++).setCellValue(selectedLocaleGlossary.getGlossaryTermText()); 
                        }
                        row1.createCell(cellIncrement++).setCellValue(defaultGlossary.getGlossaryTermDesc()); 
                        if (!selectedLocale.equals(GlossaryUtil.DEFAULT_LOCALE) && selectedLocaleGlossary !=  null)
                        {
                        	row1.createCell(cellIncrement++).setCellValue(selectedLocaleGlossary.getGlossaryTermDesc()); 
                        }
                        row1.createCell(cellIncrement++).setCellValue( GlossaryUtil.getRegionById( defaultGlossary.getGlossaryOwner())); 
                        row1.createCell(cellIncrement++).setCellValue(defaultGlossary.getActiveInd()); 
                        row1.createCell(cellIncrement++).setCellValue(GlossaryUtil.getBrandsByGlossary(defaultGlossary.getGlossaryId(),  regionList.get(GlossaryUtil.XLS_FIELD_AMEA).getRegionId())); 
                        row1.createCell(cellIncrement++).setCellValue(GlossaryUtil.getBrandsByGlossary(defaultGlossary.getGlossaryId(),  regionList.get(GlossaryUtil.XLS_FIELD_AMER).getRegionId())); 
                        row1.createCell(cellIncrement++).setCellValue(GlossaryUtil.getBrandsByGlossary(defaultGlossary.getGlossaryId(),  regionList.get(GlossaryUtil.XLS_FIELD_EUROPE).getRegionId())); 
                        row1.createCell(cellIncrement++).setCellValue(GlossaryUtil.getBrandsByGlossary(defaultGlossary.getGlossaryId(),  regionList.get(GlossaryUtil.XLS_FIELD_GC).getRegionId())); 
            }
            for (int column = 0;  column < columnCount ;  column++)
            {
            	sheet.autoSizeColumn(column); 
            }
        } 
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e); 
        }
        return wb; 
    }
    
    /**
     * Import/Update data in GlossaryRegionNavigation.
     * @param xlsBrand xlsBrand.
     * @param userId userId.
     * @param glossaryId glossaryId.
     * @param regionId regionId.
     * @param glossaryTitle glossaryTitle.
     * @param reginoNavList reginoNavList.
     */
    static void importGlossaryRegionNavigation(String xlsBrand, long userId, long glossaryId, long regionId, String glossaryTitle, 
    		String activeInd, List<GlossaryRegionNav> reginoNavList) {
    	try {
	    	String dbBrand  =  GlossaryRegionNavLocalServiceUtil.getRegionCodesByglossaryIdAndRegionId(glossaryId,  regionId); 
	        	List<String> dataBaseBrands  =  new ArrayList<String>(); 
	        	if (!BrandStandardsUtil.IsNullOrBlank(dbBrand)) {
	        		dataBaseBrands  =  Arrays.asList(dbBrand.split(GlossaryUtil.REGION_BARND_SPLIT)); 
	        	}
        	
	    		List<String> xlsBrands  =  new ArrayList<String>(); 
	    		if (!BrandStandardsUtil.IsNullOrBlank(xlsBrand)) {
	    			xlsBrands  =  Arrays.asList(xlsBrand.split(GlossaryUtil.REGION_BARND_SPLIT)); 
	        	}
	    		
	    		List<String> union  =  new ArrayList<String> (dataBaseBrands); 
	    		union.addAll(xlsBrands); 
	    		
	    		List<String> intersection  =  new ArrayList<String>(dataBaseBrands); 
	    		intersection.retainAll(xlsBrands); 
	    		
	    		List<String> deleteBrands  =  new ArrayList<String>(dataBaseBrands); 
	    		deleteBrands.removeAll(intersection); 
	    		
	    		List<String> addBrands  =  new ArrayList<String>(xlsBrands); 
	    		addBrands.removeAll(intersection); 
	    		
	    		for (String chainCode : intersection) {
	    			GlossaryRegionNav regionNav = GlossaryRegionNavLocalServiceUtil.getGlossaryRegionNavByGlossaryIdRegionIdChainCode(glossaryId, regionId, chainCode);
	    			if (regionNav != null && !regionNav.getNavItemText().equalsIgnoreCase(glossaryTitle.substring(0, 1))) {
	    				regionNav.setNavItemText(glossaryTitle.substring(0, 1).toUpperCase());
	    				regionNav.setActiveInd(activeInd);
	    				regionNav.setUpdatedBy(String.valueOf(userId));
	    				regionNav.setUpdatedDate(new Date());
	    				GlossaryRegionNavLocalServiceUtil.removeByGlossaryIdRegionIdChainCode(glossaryId,  regionId,  chainCode);
	    				GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav);
	    			} else if (Validator.isNotNull(regionNav) && Validator.isNotNull(activeInd)) {
	    				regionNav.setActiveInd(activeInd);
	    				regionNav.setUpdatedBy(String.valueOf(userId));
	    				regionNav.setUpdatedDate(new Date());
	    				GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav);
	    			}
	        	}
	        	
	        	for (String chainCode : deleteBrands) {
						GlossaryRegionNavLocalServiceUtil.removeByGlossaryIdRegionIdChainCode(glossaryId,  regionId,  chainCode); 
	        	}
	        	
	        	for (String chainCode : addBrands) {
	        			GlossaryRegionNav regionNav; 
						regionNav  =  GlossaryRegionNavLocalServiceUtil.createGlossaryRegionNav(CounterLocalServiceUtil.increment(GlossaryRegionNav.class.getName())); 
						regionNav.setChainCode(chainCode); 
						regionNav.setActiveInd(activeInd); 
						regionNav.setCreatorId(String.valueOf(userId)); 
						regionNav.setGlossaryId(glossaryId); 
						regionNav.setNavItemText(glossaryTitle.substring(0, 1).toUpperCase()); 
						regionNav.setRegionId(regionId); 
						regionNav.setUpdatedBy(String.valueOf(userId)); 
						regionNav.setUpdatedDate(new Date()); 
						regionNav.setCreatedDate(new Date()); 
						reginoNavList.add(regionNav); 
						//GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav, true); 
	        	}
		} catch (Exception e) {
			LOG.error(e.getMessage(),  e); 
		}
    }
    
    /**
     * Dummy Glossary Object with default value.
     * @param userId userId.
     * @return Glossary Glossary.
     */
    static Glossary getDefaultGlossary(long userId)
    {
    	Glossary glossary; 
		try
		{
			glossary  =  GlossaryLocalServiceUtil.createGlossary(CounterLocalServiceUtil.increment(Glossary.class.getName())); 
			glossary.setActiveInd(GlossaryUtil.DEFAULT_YES); 
			glossary.setUpdatedBy(String.valueOf(userId)); 
			glossary.setCreatorId(String.valueOf(userId)); 
			glossary.setCreatedDate(new Date()); 
			glossary.setUpdatedDate(new Date()); 
			return glossary; 
		} 
		catch (SystemException e)
		{
			LOG.error("Error while get glossasry while import : " + e.getMessage(),  e); 
		}
		return null; 
    }
    
    /**
     * Method is use to create Header of xls file while export.
     * @param row row.
     * @param style style.
     * @param createHelper createHelper.
     * @param selectedLocale selectedLocale.
     * @return int int.
     */
    static int createHeader(Row row, CellStyle style, CreationHelper createHelper, String selectedLocale)
    {
    	int cellCounter  =  0; 
    	createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_ID,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_TITLE,  cellCounter++); 
        if (!selectedLocale.equals(GlossaryUtil.DEFAULT_LOCALE))
        {
        	createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_TITLE_TERM,  cellCounter++); 
        }
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_DESC,  cellCounter++); 
        if (!selectedLocale.equals(GlossaryUtil.DEFAULT_LOCALE))
        {
        	createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_DESC_TERM,  cellCounter++); 
        }
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_OWNER,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_PUBLISHED,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_AMEA,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_AMER,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_EUROPE,  cellCounter++); 
        createCell(row,  style,  createHelper,  GlossaryUtil.XLS_FIELD_GC,  cellCounter++); 
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
    static JSONObject readExcelFile(UploadPortletRequest uploadRequest, ResourceRequest resourceRequest,  ResourceResponse response, ProgressTracker progressTracker) 
    		throws InvalidFormatException, JAXBException, PortalException, SystemException, IOException 
    {
		String localeCd  =   ParamUtil.getString(uploadRequest,  "localeCd"); 
	    JSONObject recordsjsonObject  = null; 
	    String fileName  =  uploadRequest.getFileName("file"); 
	    if ((fileName  ==  null) || "".equals(fileName))
	    {
	        throw new IOException("No File is selected.Please browse file again!"); 
	    }
	    String description  =  ParamUtil.getString(uploadRequest,  "description",  fileName); 
	    File file  =  uploadRequest.getFile("file"); 
	    
	    if (LOG.isDebugEnabled()) {
            LOG.debug(" filename " + fileName + " description " + description + " file " + file);
	    }
	    GlossaryProcessXlsFile processXlsFile  =  new GlossaryProcessXlsFile(); 
	    List<Record> records  =  processXlsFile.glossaryProcessXls(file, progressTracker, localeCd); 
	    List<Record> badRecords  =  null; 
	    badRecords  =  processXlsFile.getBadRows(records); 
	    if (badRecords.size() > 0)
	    {
	        //return it in GUI
	        recordsjsonObject  =  JSONFactoryUtil.createJSONObject(); 
	        int percentage = GlossaryUtil.MAGIC_FIFTY;
	        int oldPercentage = GlossaryUtil.MAGIC_FIFTY; 
	        JSONArray rowjsonObject  =  null; 
	        JSONObject cell  =  null; 
	        JSONArray recordsjsonArray  =  JSONFactoryUtil.createJSONArray(); 
	        recordsjsonObject.put("page",  "1"); 
	        double totalPages  =  Math.ceil(badRecords.size() / (double) GlossaryUtil.MAGIC_TEN); 
	        recordsjsonObject.put("total",  String.valueOf(totalPages)); 
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
	                    LOG.error("Row = " + cell1.getRow() + "' column name = '" + cell1.getColumnName()
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
	                percentage  =  Math.min(GlossaryUtil.MAGIC_FIFTY + (i * GlossaryUtil.MAGIC_HUNDRED ) / badRecords.size(),  GlossaryUtil.MAGIC_HUNDRED); 
	                if (oldPercentage !=  percentage)
                	{
	                	progressTracker.setPercent(percentage); 
	                }
	                oldPercentage = percentage; 
	            }
	            recordsjsonObject.put("rows",  recordsjsonArray); 
	        }
	    }
	    else
	    {
	    	addUpdateExcelGlossaryTranslations(resourceRequest,  records,  localeCd, progressTracker); 
	    }
	    return recordsjsonObject; 
	}
    
    static GlossaryTranslate getTranslationByGlossaryIdAndlocale(long glossaryId, String localeCd,ThemeDisplay themeDisplay) throws SystemException
    {
    	GlossaryTranslate glossaryTranslation=null;
    	try
        {
			glossaryTranslation  =  GlossaryTranslateLocalServiceUtil.getByGlossaryIdLocaleCode(glossaryId, localeCd);
        } 
        catch (NoSuchGlossaryTranslateException ex)
        {
        	LOG.error(ex.getMessage(),ex);
        }
    	
    	if ( BrandStandardsUtil.IsNullOrBlank(glossaryTranslation))
    	{
    		glossaryTranslation  =  GlossaryTranslateLocalServiceUtil.createGlossaryTranslate(CounterLocalServiceUtil.increment(GlossaryTranslate.class.getName())); 
        	glossaryTranslation.setLangCode(localeCd); 
        	glossaryTranslation.setUpdatedBy(String.valueOf(themeDisplay.getUserId())); 
        	glossaryTranslation.setCreatorId(String.valueOf(themeDisplay.getUserId())); 
        	glossaryTranslation.setCreatedDate(new Date()); 
        	glossaryTranslation.setUpdatedDate(new Date()); 
        	glossaryTranslation.setIsValidDescTxt(GlossaryUtil.DEFAULT_NO); 
        	glossaryTranslation.setIsValidTermTxt(GlossaryUtil.DEFAULT_NO); 
    	}
    	return  glossaryTranslation;
    }
    
    static StandardsRegion getStandardRegionFromMap(Map<String,  StandardsRegion> regionList,String key)
    {
    	StandardsRegion standardsRegion = regionList.get(key);
    	if (BrandStandardsUtil.IsNullOrBlank(standardsRegion) )
    	{
    		throw new NullPointerException("Owner region does not match");
    	}
    	return standardsRegion;
    }
    
}