package com.ihg.brandstandards.util;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ResourceRequest;
import javax.xml.bind.JAXBException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

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
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.db.model.BrandTaxonomy;
import com.ihg.brandstandards.db.model.BrandTaxonomyTranslate;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.TaxonomyExt;
import com.ihg.brandstandards.db.model.TaxonomyTranslate;
import com.ihg.brandstandards.db.model.TreeXML;
import com.ihg.brandstandards.db.service.BrandTaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.BrandTaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.TaxonomyTranslatePK;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.repository.model.FileEntry;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.DuplicateFileException;
import com.liferay.portlet.documentlibrary.NoSuchFileEntryException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;

public class IndexTranslationUtil extends BrandStandardsUtil 
{
    private static final Log LOG = LogFactoryUtil.getLog(IndexTranslationUtil.class);

    public static final String CMD = "COMMAND";

    public static final String CMD_UPLOAD_EXCEL_PAGE = "UPLOAD_EXCEL_PAGE";

    public static final String CMD_UPLOAD_IMAGE_PAGE = "UPLOAD_IMAGEL_PAGE";

    public static final String TAXONOMY_ID = "TAXONOMY_ID";

    public static final String SELECTED_LOCALE = "SELECTED_LOCALE";
    
    public static final String SELECTED_BRAND = "SELECTED_BRAND";
    
    public static final String IMPORT_ID_IMAGE = "IMPORT_ID_IMAGE";
    
    public static final String IMPORT_ID_EXCEL = "IMPORT_ID_EXCEL";

    public static final String DEFAULT_LOCALE = "en_GB";

    public static void addUpdateExcelTaxonomyTranslations(final ResourceRequest request, List<Record> recordList, String localeCd,ProgressTracker progressTracker)
            throws InvalidFormatException, IOException, JAXBException, SystemException
    {
        final long userId = PortalUtil.getUserId(request);
        int percentage=50;
        int oldPercentage=50;
        int i=0;
        for (com.ihg.brandstandards.bsadmin.model.Record record : recordList)
        {
        	/*BrandTaxonomyTranslate brandTaxonomyTranslate = null;
        	brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getBrandTaxonomyTranslate(brandTaxonomyTranslatePK)
        	*/
        	
        	
            TaxonomyTranslate taxonomyTranslation = null;
            taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(
                    (long) Double.parseDouble(record.getId()), localeCd);
            if (taxonomyTranslation == null)
            {
                TaxonomyTranslatePK pk = new TaxonomyTranslatePK((long) Double.parseDouble(record.getId()), localeCd);
                taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxonomyTranslateObject();
                taxonomyTranslation.setPrimaryKey(pk);
                taxonomyTranslation.setTaxId((long) Double.parseDouble(record.getId()));
                taxonomyTranslation.setLocaleCode(localeCd);
                taxonomyTranslation.setCreatorId(String.valueOf(userId));
                taxonomyTranslation.setCreatedDate(new Date());
            }

            List<Record> cells = record.getFields().get("TaxonomyTranslation");
            for (com.ihg.brandstandards.bsadmin.model.Record cell : cells)
            {
                if (cell.getFieldName().equalsIgnoreCase("title"))
                    taxonomyTranslation.setTitle((String) cell.getValue());
                if (cell.getFieldName().equalsIgnoreCase("desc"))
                {
                    if ((cell.getValue() != null) && (!cell.getValue().equals("")))
                        taxonomyTranslation.setDesc((String) cell.getValue());
                }

            }
            taxonomyTranslation.setUpdatedBy(String.valueOf(userId));
            taxonomyTranslation.setUpdatedDate(new Date());

            TaxonomyTranslateLocalServiceUtil.addTaxonomyTranslation(taxonomyTranslation);
            
            percentage = Math.min(50 + (i * 50) / recordList.size(), 100);
            if(!(oldPercentage==percentage))
            progressTracker.setPercent(percentage);
            oldPercentage=percentage;
            i++;
        }
    }

    public static void addUpdateTaxonomyTranslation(final ResourceRequest request) throws InvalidFormatException, IOException,
            JAXBException, SystemException
    {
        final long userId = PortalUtil.getUserId(request);
        String localeCd = request.getParameter("localecd");
        String taxId = request.getParameter("id");
        String brand = request.getParameter("chainCd");
        TaxonomyTranslate taxonomyTranslation = null;
        
        taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(taxId), localeCd);
        if (taxonomyTranslation == null)
        {
            TaxonomyTranslatePK pk = new TaxonomyTranslatePK(Long.parseLong(taxId), localeCd);
            taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxonomyTranslateObject();
            taxonomyTranslation.setPrimaryKey(pk);
            taxonomyTranslation.setCreatorId(String.valueOf(userId));
            taxonomyTranslation.setCreatedDate(new Date());
        }

        if (request.getParameter("translation") != null)
            taxonomyTranslation.setTitle(request.getParameter("translation"));
        taxonomyTranslation.setTaxId(Long.parseLong(taxId));
        taxonomyTranslation.setLocaleCode(localeCd);
        taxonomyTranslation.setUpdatedBy(String.valueOf(userId));
        taxonomyTranslation.setUpdatedDate(new Date());

        TaxonomyTranslateLocalServiceUtil.addTaxonomyTranslation(taxonomyTranslation);

    }

    public static Workbook xmlExcelExportLang(String selectedLocale, String selectedBrand)
    {
        final Workbook wb = new HSSFWorkbook();
        ArrayList<String> nodePath = new ArrayList<String>();
        try
        {
            CreationHelper createHelper = wb.getCreationHelper();
            Sheet sheet = wb.createSheet("new sheet");

            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            
            StringBuffer sb = new StringBuffer();
            TreeXML treeXmlTbl = ActionUtil.getXMLTreeTaxonomy(1L);
            if (treeXmlTbl != null)
            {
                sb.append(treeXmlTbl.getXMLLOB());
            }
            Document document = builder.parse(new ByteArrayInputStream(sb.toString().getBytes()));
            // normalize text representation  
            document.getDocumentElement().normalize();

            DataFormat fmt = wb.createDataFormat();
            CellStyle textStyle = wb.createCellStyle();
            textStyle.setDataFormat(fmt.getFormat("@"));
            sheet.setDefaultColumnStyle(2, textStyle); 
            sheet.setDefaultColumnStyle(3, textStyle); 
            sheet.setDefaultColumnStyle(4, textStyle); 
            sheet.setDefaultColumnStyle(5, textStyle); 
            
            NodeList flList = document.getElementsByTagName("item");
            CellStyle style=wb.createCellStyle();
            Font boldFont=wb.createFont(); 
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD); 
            style.setFont(boldFont);
            
            Row row = sheet.createRow((short) 0);
            Cell cell=null;
            cell = row.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Index ID"));
            cell = row.createCell(1);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Level"));
            cell = row.createCell(2);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Heading"));
            cell = row.createCell(3);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Heading Translation"));
            cell = row.createCell(4);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Description"));
            cell = row.createCell(5);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Description Translation"));
            cell = row.createCell(6);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Path"));
            
            for (int s = 0; s < flList.getLength(); s++)
            {
                String ItemId = flList.item(s).getAttributes().getNamedItem("id").getNodeValue();
                String ItemRel = flList.item(s).getAttributes().getNamedItem("rel").getNodeValue();
                String name = "";
                String desc = "";

                if (!"1".equals(ItemId))
                {
                    Row row1 = sheet.createRow(s);
                    Cell cell1 = row1.createCell(0);

                    Node firstWordNode = flList.item(s);
                    
                    if (firstWordNode.getNodeType() == Node.ELEMENT_NODE)
                    {
                        Element firstWordElement = (Element) firstWordNode;

                        NodeList firstWordList = firstWordElement.getElementsByTagName("name");
                        Element firstWDElement = (Element) firstWordList.item(0);

                        NodeList textWDList = firstWDElement.getChildNodes();
                        name = ((Node) textWDList.item(0)).getNodeValue().trim();
                        
                        NodeList secondWordList = firstWordElement.getElementsByTagName("DESC");
                        Element secondWDElement = (Element) secondWordList.item(0);
                        
                        NodeList textWDListSec = secondWDElement.getChildNodes();
                        if(((Node) textWDListSec.item(0))!=null)
                        desc= ((Node) textWDListSec.item(0)).getNodeValue().trim();
                        
                        int itemlevel = Integer.parseInt(ItemRel) - 2;
                        int actsize = nodePath.size();

                        for (int i = actsize - 1; i >= itemlevel; i--)
                        {
                            nodePath.remove(i);
                        }
                        nodePath.add(itemlevel, name);
                    }
                    cell1.setCellValue(Double.parseDouble(ItemId));
                    row1.createCell(1).setCellValue(Double.parseDouble(ItemRel) - 1);
                    row1.createCell(2).setCellValue(createHelper.createRichTextString(name));
                    row1.createCell(6).setCellValue(createHelper.createRichTextString(getStringVal(nodePath)));
                    
                    BrandTaxonomy brandTaxonomy = null;
                    try {
                    	brandTaxonomy = BrandTaxonomyLocalServiceUtil.getByTaxIdAndChainCd(Long.parseLong(ItemId), selectedBrand);
    				} catch (Exception e) {
    					LOG.error("Brand Exception occured "+e);
    				}
                    
                    if(brandTaxonomy == null)
                    {
                    	row1.createCell(4).setCellValue("No Description Exists");
                    }else
                    {
                    	String textDescription = brandTaxonomy.getDesc();
                    	
                    	if(textDescription == null)
                    	{
                    		row1.createCell(4).setCellValue("No Description Exists");
                    	}else
                    	{
                    		row1.createCell(4).setCellValue(String.valueOf(brandTaxonomy.getDesc()));
                    	}
                    	
                    }
                    
                    if(!selectedLocale.equals(IndexTranslationUtil.DEFAULT_LOCALE))
                    {    
        				TaxonomyTranslate taxTransObject = null;
        				try {
        					taxTransObject = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(ItemId), selectedLocale);
        				}  catch (Exception e) {
        					LOG.error("Exception occured "+e);
        				}
        				
						if (taxTransObject == null) 
						{
							row1.createCell(3).setCellValue("No Translation Found");

						} else 
						{
							String tranTitle = taxTransObject.getTitle();
							
							if (tranTitle == null)
                        	{
                        		 row1.createCell(3).setCellValue("No Translation Found");
                        	}else
                        	{
                        		row1.createCell(3).setCellValue(tranTitle);
                        	}
						}
						
						BrandTaxonomyTranslate brandTaxonomyTranslate = null;
        				try {
        					brandTaxonomyTranslate = BrandTaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(brandTaxonomy.getId(), selectedLocale);
        				}  catch (Exception e) {
        					LOG.error("Brand Taxonomy Exception occured "+e);
        				}
                        if (brandTaxonomyTranslate == null)
                        {
                            row1.createCell(5).setCellValue("No Translation Found");
                        }else
                        {
                        	String tranDesc = brandTaxonomyTranslate.getDesc();
                        	
                        	if (tranDesc == null)
                        	{
                        		 row1.createCell(5).setCellValue("No Translation Found");
                        	}else
                        	{
                        		 row1.createCell(5).setCellValue(tranDesc);
                        	}
                        }
                    }
                    else
                    {
                        row1.createCell(3).setCellValue("");
                        row1.createCell(5).setCellValue("");
                    }
                }
            } //end of for loop with s var
            sheet.autoSizeColumn(2);
            sheet.autoSizeColumn(6);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return wb;
    }

    public static String getStringVal(final List<String> array)
    {
        StringBuilder path = new StringBuilder();
        for (int i = 0; i < array.size(); i++)
        {
            if (i == array.size() - 1)
            {
                path.append(array.get(i));
            }
            else
            {
                path.append(array.get(i)).append(" -> ");
            }
        }
        return path.toString();
    }

    public static DLFileEntry addOrOverwriteFile(final long realUserId, final long groupId, final long folderId,
            final String fileName, final File uploadedFile, TaxonomyTranslate taxTransObj, final String localeCd, final long taxId,ProgressTracker progressTracker)
            throws SystemException, PortalException
    {
        DLFileEntry fileEntry = null;
        DLFileEntry fileEntryOld = null;
        FileEntry tempfileEntry = null;

        ServiceContext serviceContext = new ServiceContext();
        String oldFileName = "";
        String fileExtension = "";
        String fileNameFinal = "";

        try
        {
            progressTracker.setPercent(40);
            int index = fileName.lastIndexOf('.');
            if (index > 0 && index <= fileName.length() - 2)
            {
                String fileNameWthOutExt = fileName.substring(0, index);
                fileExtension = fileName.substring(index, fileName.length());
                fileNameFinal = fileNameWthOutExt + "_" + localeCd + "_" + String.valueOf(taxId) + fileExtension;
            }
            if (taxTransObj != null)
            {
                if (taxTransObj.getImageLoc() != null && !(taxTransObj.getImageLoc()).equalsIgnoreCase(""))
                {
                    String[] strArr = taxTransObj.getImageLoc().split("/");
                    oldFileName = strArr[strArr.length - 1];
                    oldFileName = URLDecoder.decode(oldFileName, "UTF-8");
                }
            }
            progressTracker.setPercent(60);
            serviceContext.setAddGuestPermissions(true);

            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileNameFinal);
            if (fileEntry == null)
            {
                throw new NoSuchFileEntryException();
            }
            //DLFileEntryLocalServiceUtil.deleteFileEntry(groupId, folderId);
            DLAppLocalServiceUtil.deleteFileEntry(fileEntry.getFileEntryId());
            progressTracker.setPercent(70);
            String mimeType = MimeTypesUtil.getContentType(fileNameFinal);

           /* long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;
            fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(realUserId, groupId,
                    groupId, folderId, fileNameFinal, mimeType, fileNameFinal, "", "",
                    fileEntryTypeId, fieldsMap, uploadedFile,null ,uploadedFile.length(), serviceContext);
            */
            tempfileEntry = DLAppLocalServiceUtil.addFileEntry(realUserId, groupId, 
            		folderId, fileNameFinal, mimeType, "", "", "", uploadedFile,  serviceContext);
            fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(tempfileEntry.getFileEntryId());
            progressTracker.setPercent(80);
        }
        catch (NoSuchFileEntryException noSuchFileEntryException)
        {
            //fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, folderId, fileName, FileUtil.stripExtension(fileName), description, extraSettings, file, serviceContext);
            if (oldFileName.length() > 0)
            {
                fileEntryOld = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, oldFileName);
                DLAppLocalServiceUtil.deleteFileEntry(fileEntryOld.getFileEntryId());
            }
            String mimeType = MimeTypesUtil.getContentType(fileNameFinal);

            /*long fileEntryTypeId = -1L;
            Map<String, Fields> fieldsMap = null;
            fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(realUserId, groupId,
                    groupId, folderId, fileNameFinal, mimeType, fileNameFinal, "", "",
                    fileEntryTypeId, fieldsMap, uploadedFile, null, uploadedFile.length(), serviceContext);*/
            tempfileEntry = DLAppLocalServiceUtil.addFileEntry(realUserId, groupId, 
            		folderId, fileNameFinal, mimeType, "", "", "", uploadedFile,  serviceContext);
            fileEntry = DLFileEntryLocalServiceUtil.getDLFileEntry(tempfileEntry.getFileEntryId());
            
            progressTracker.setPercent(98);
            //logger.logException(noSuchFileEntryException);
        }
        catch (DuplicateFileException duplicateFileException)
        {
            //fileEntry = DLFileEntryLocalServiceUtil.addFileEntry(userId, folderId, fileName, FileUtil.stripExtension(fileName), description, extraSettings, file, serviceContext);
            LOG.error(StackTraceUtil.getStackTrace(duplicateFileException));
        }
        catch (UnsupportedEncodingException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return fileEntry;
    }

    public static void updateUrlTaxTranslation(final String taxId, final String localeCd, final String imageURL, final long userId)
            throws NumberFormatException, PortalException, SystemException
    {
        TaxonomyTranslate taxonomyTranslation = null;
        final TaxonomyTranslatePK pk = new TaxonomyTranslatePK((long) Double.parseDouble(taxId), localeCd);
        taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxTransByTaxLangId(Long.parseLong(taxId), localeCd);
        if (taxonomyTranslation == null)
        {
            taxonomyTranslation = TaxonomyTranslateLocalServiceUtil.getTaxonomyTranslateObject();
            taxonomyTranslation.setPrimaryKey(pk);
            taxonomyTranslation.setCreatorId(String.valueOf(userId));
            taxonomyTranslation.setCreatedDate(new Date());
        }

        taxonomyTranslation.setTaxId((long) Double.parseDouble(taxId));
        taxonomyTranslation.setLocaleCode(localeCd);
        taxonomyTranslation.setImageLoc(imageURL);
        taxonomyTranslation.setUpdatedBy(String.valueOf(userId));
        taxonomyTranslation.setUpdatedDate(new Date());

        TaxonomyTranslateLocalServiceUtil.addTaxonomyTranslation(taxonomyTranslation);
    }

    /**
     * Create locale map.
     * 
     * @return locale map
     * @throws SystemException
     */
    public static Map<String, String> localeMap() throws SystemException
    {
        Map<String, String> localeMap = new LinkedHashMap<String, String>();
        List<StandardsLocale> locales = null;
        locales = StandardsLocaleLocalServiceUtil.getBrandStandardsLocale();
        for (StandardsLocale locale : locales)
        {
            //if (!(locale.getLocaleCode().equalsIgnoreCase("en_US")))
            localeMap.put(locale.getLocaleCode(), locale.getLocaleName());
        }
        return localeMap;
    }
    
    public static List<String> taxonomyIds(List<TaxonomyExt> taxonomyObjs) throws SystemException
    {
        List<String> taxList = new ArrayList<String>();
        for (TaxonomyExt tax : taxonomyObjs)
        {
            taxList.add(String.valueOf(tax.getTaxId()));
        }
        return taxList;
    }
}
