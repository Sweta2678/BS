/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.util;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.PortletRequest;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.db.model.UIElement;
import com.ihg.brandstandards.db.model.UIElementTranslate;
import com.ihg.brandstandards.db.service.UIElementLocalServiceUtil;
import com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil;
import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.bsadmin.model.UIElementData;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="UIElementPortletUtil.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class UIElementPortletUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(UIElementPortletUtil.class);

    public static List<UIElementData> getAllUIElements(String secondLanguage)
    {
        List<UIElementData> uiElementDataList = new ArrayList<UIElementData>();
        try
        {
            List<UIElement> uiElements = UIElementLocalServiceUtil.getUIElements(-1, -1);
            for (UIElement uiElement : uiElements)
            {
                UIElementData elementData = new UIElementData();
                elementData.setElementId(uiElement.getElementId());
                elementData.setElementKey(uiElement.getElementKey());
                elementData.setUsedIn(uiElement.getModuleName());
                List<UIElementTranslate> uiElementTranslations = UIElementTranslateLocalServiceUtil.getByElementId(uiElement
                        .getElementId());
                Map<String, String> elementLangData = new LinkedHashMap<String, String>();
                for (UIElementTranslate translation : uiElementTranslations)
                {
                    elementLangData.put(translation.getLocaleCode(), translation.getElementValue());
                    if (BSAdminConstants.DEFAULT_LANG_CD.equalsIgnoreCase(translation.getLocaleCode()))
                    {
                        elementData.setEnGBValue(translation.getElementValue());
                    }
                    else if (Validator.isNotNull(secondLanguage) && secondLanguage.equalsIgnoreCase(translation.getLocaleCode()))
                    {
                        elementData.setSecondLangValue(translation.getElementValue());
                    }
                }
                elementData.setLanguages(elementLangData);
                uiElementDataList.add(elementData);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        return uiElementDataList;
    }

    public static UIElementData getUIElementById(long elementId)
    {
        UIElementData uiElementData = new UIElementData();
        try
        {
            UIElement uiElement = UIElementLocalServiceUtil.getUIElement(elementId);
            uiElementData.setElementId(uiElement.getElementId());
            uiElementData.setElementKey(uiElement.getElementKey());
            uiElementData.setUsedIn(uiElement.getModuleName());
            List<UIElementTranslate> uiElementTranslations = UIElementTranslateLocalServiceUtil.getByElementId(uiElement
                    .getElementId());
            Map<String, String> elementLangData = new LinkedHashMap<String, String>();
            for (UIElementTranslate data : uiElementTranslations)
            {
                elementLangData.put(data.getLocaleCode(), data.getElementValue());
                if (BSAdminConstants.DEFAULT_LANG_CD.equalsIgnoreCase(data.getLocaleCode()))
                {
                    uiElementData.setEnGBValue(data.getElementValue());
                }
            }
            uiElementData.setLanguages(elementLangData);
        }
        catch (SystemException e)
        {
            LOG.error(e);
        }
        catch (PortalException e)
        {
            LOG.error(e);
        }
        return uiElementData;
    }

    public static List<UIElementData> searchUIElement(String elementValue, String searchLanguage, String elementKey,
            String secondLanguage, String[] usedIn)
    {
        List<UIElementData> searchResults = new ArrayList<UIElementData>();
        try
        {
            //List<Object> result = UIElementFinderUtil.searchUIElement(elementValue, searchLanguage, elementKey, secondLanguage, usedIn);
            List<Object> result = UIElementLocalServiceUtil.searchUIElement(elementValue, searchLanguage, elementKey,
                    secondLanguage, usedIn);
            if (result != null && result.size() > 0)
            {
                Map<String, UIElementData> uiElemMap = new LinkedHashMap<String, UIElementData>();
                Map<String, String> elementLangData = null;
                for (Object element : result)
                {
                    Object[] obj = (Object[]) element;
                    UIElementData uiElementData = uiElemMap.get(((String) obj[1]));
                    if (uiElementData == null)
                    {
                        uiElementData = new UIElementData();
                        uiElementData.setElementId(((BigDecimal) obj[0]).longValue());
                        uiElementData.setElementKey((String) obj[1]);
                        uiElementData.setUsedIn((String) obj[2]);
                        elementLangData = new LinkedHashMap<String, String>();
                    }
                    else
                    {
                        elementLangData = uiElementData.getLanguages();
                    }

                    elementLangData.put((String) obj[3], (String) obj[4]);
                    if (BSAdminConstants.DEFAULT_LANG_CD.equalsIgnoreCase((String) obj[3]))
                    {
                        uiElementData.setEnGBValue((String) obj[4]);
                    }
                    if (Validator.isNotNull(secondLanguage) && secondLanguage.equalsIgnoreCase((String) obj[3]))
                    {
                        uiElementData.setSecondLangValue((String) obj[4]);
                    }
                    
                    uiElementData.setLanguages(elementLangData);
                    uiElemMap.put(uiElementData.getElementKey(), uiElementData);
                }
                for (Entry<String, UIElementData> entry : (Set<Entry<String, UIElementData>>) uiElemMap.entrySet())
                {
                    searchResults.add(entry.getValue());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return searchResults;
    }

    public static Workbook exportUIElements(String secondLangCode, String secondLangName, String[] usedIn, boolean exportUsedIn)
    {
        final Workbook workbook = new HSSFWorkbook();
        try
        {
            CreationHelper createHelper = workbook.getCreationHelper();
            Sheet sheet = workbook.createSheet(secondLangCode + " Translations");
            
            DataFormat fmt = workbook.createDataFormat();
            CellStyle textStyle = workbook.createCellStyle();
            textStyle.setWrapText(true);
            textStyle.setBorderTop((short)1);
            textStyle.setBorderRight((short)1);
            textStyle.setBorderBottom((short)1);
            textStyle.setBorderLeft((short)1);
            textStyle.setDataFormat(fmt.getFormat("@"));
            
            //Setting column style
            if (exportUsedIn)
            {
                sheet.setColumnWidth(0, 9500);
                sheet.setColumnWidth(1, 3500);
                sheet.setColumnWidth(2, 16500);
                sheet.setColumnWidth(3, 16500);
                
                sheet.setDefaultColumnStyle(0, textStyle);
                sheet.setDefaultColumnStyle(1, textStyle);
                sheet.setDefaultColumnStyle(2, textStyle);
                sheet.setDefaultColumnStyle(3, textStyle);
            } else {
                sheet.setColumnWidth(0, 9500);
                sheet.setColumnWidth(1, 18000);
                sheet.setColumnWidth(2, 18000);
                
                sheet.setDefaultColumnStyle(0, textStyle);
                sheet.setDefaultColumnStyle(1, textStyle);
                sheet.setDefaultColumnStyle(2, textStyle);
            }

            CellStyle style = workbook.createCellStyle();
            Font boldFont = workbook.createFont();
            boldFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
            style.setFont(boldFont);

            Row headerRow = sheet.createRow(0);
            Cell cell = headerRow.createCell(0);
            cell.setCellStyle(style);
            cell.setCellValue(createHelper.createRichTextString("Element Key"));
            if (exportUsedIn)
            {
                cell = headerRow.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString("Used In"));
                cell = headerRow.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString("(en_GB)English UK"));
                cell = headerRow.createCell(3);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString("(" + secondLangCode + ")" + secondLangName));
            }
            else
            {
                cell = headerRow.createCell(1);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString("(en_GB)English UK"));
                cell = headerRow.createCell(2);
                cell.setCellStyle(style);
                cell.setCellValue(createHelper.createRichTextString("(" + secondLangCode + ")" + secondLangName));
            }

            List<UIElementData> elementList = searchUIElement(null, null, null, secondLangCode, usedIn);
            int rowCounter = 1;
            for (UIElementData element : elementList)
            {
                Row dataRow = sheet.createRow(rowCounter);
                dataRow.createCell(0).setCellValue(element.getElementKey());
                if (exportUsedIn)
                {
                    dataRow.createCell(1).setCellValue(element.getUsedIn());
                    dataRow.createCell(2).setCellValue(element.getEnGBValue());
                    dataRow.createCell(3).setCellValue(element.getSecondLangValue());
                }
                else
                {
                    dataRow.createCell(1).setCellValue(element.getEnGBValue());
                    dataRow.createCell(2).setCellValue(element.getSecondLangValue());
                }

                rowCounter++;
            }
            //sheet.autoSizeColumn(0);
            //sheet.autoSizeColumn(1);
            //sheet.autoSizeColumn(2);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        return workbook;
    }

    public void updateTranslations(final PortletRequest portletRequest, List<Record> recordList, String localeCode,
            ProgressTracker progressTracker, boolean importUsedInFromExcel, String moduleName)
    {
        boolean autoCreateElements = Boolean.parseBoolean(PortletProps.get("uielement.import.create.missing.keys"));
        ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
        for (Record record : recordList)
        {
            if (Validator.isNotNull(record.getId()))
            {
                UIElement element = null;
                UIElementTranslate elementTranslate = null;
                String elementKey = record.getId();
                try
                {
                    boolean translationExist = false;
                    try
                    {
                        element = UIElementLocalServiceUtil.getByElementKey(elementKey);
                    }
                    catch (Exception e1)
                    {
                        LOG.error("Import: No Element exist with element key:" + elementKey);
                    }
                    if (element == null && autoCreateElements)
                    {
                        if (importUsedInFromExcel)
                        {
                            for (Record cell : record.getFields().get("UIElementTranslation"))
                            {
                                if ("usedIn".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue()))
                                {
                                    try
                                    {
                                        element = UIElementLocalServiceUtil.getUIElementObject();
                                        element.setElementKey(elementKey);
                                        element.setModuleName(String.valueOf(cell.getValue()).trim().toUpperCase());
                                        element.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                                        element.setCreatedDate(new Date());
                                        element.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                        element.setUpdatedDate(new Date());
                                        element = UIElementLocalServiceUtil.addNewUIElementKey(element);
                                    }
                                    catch (Exception e)
                                    {
                                        LOG.error("Failed to create Element", e);
                                    }
                                    break;
                                }
                            }
                        } else {
                            if (!importUsedInFromExcel && Validator.isNotNull(moduleName))
                            {
                                try
                                {
                                    element = UIElementLocalServiceUtil.getUIElementObject();
                                    element.setElementKey(elementKey);
                                    element.setModuleName(moduleName.toUpperCase());
                                    element.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                                    element.setCreatedDate(new Date());
                                    element.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                    element.setUpdatedDate(new Date());
                                    element = UIElementLocalServiceUtil.addNewUIElementKey(element);
                                }
                                catch (Exception e)
                                {
                                    LOG.error("Failed to create Element", e);
                                }
                            }
                        }
                    }

                    if (element != null)
                    {
                        try
                        {
                            elementTranslate = UIElementTranslateLocalServiceUtil.getByIdAndLocaleCode(element.getElementId(),
                                    localeCode);
                            translationExist = true;
                        }
                        catch (Exception e)
                        {
                            LOG.error("Import: No Translation exist with element key:" + elementKey +" and locale code:"+localeCode);
                        }
                        
                        if (elementTranslate == null && !translationExist)
                        {
                            for (Record cell : record.getFields().get("UIElementTranslation"))
                            {
                                if ("translationData".equalsIgnoreCase(cell.getFieldName()))
                                {
                                    try
                                    {
                                        if (Validator.isNotNull(cell.getValue()))
                                        {
                                            UIElementTranslate uiElementTranslate = UIElementTranslateLocalServiceUtil.getUIElementTranslateObject();
                                            uiElementTranslate.setElementId(element.getElementId());
                                            uiElementTranslate.setLocaleCode(localeCode);
                                            uiElementTranslate.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                                            uiElementTranslate.setCreatedDate(new Date());
                                            uiElementTranslate.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                            uiElementTranslate.setUpdatedDate(new Date());
                                            uiElementTranslate.setElementValue(String.valueOf(cell.getValue()).trim());
                                            elementTranslate = UIElementTranslateLocalServiceUtil.addUIElementTranslate(uiElementTranslate);
                                        }
                                    }
                                    catch (Exception e)
                                    {
                                        LOG.error("Failed to add Translation for element key:" + elementKey +" and locale code:"+localeCode, e);
                                    }
                                }
                            }
                        }

                    }

                }
                catch (Exception e)
                {
                    LOG.error("Failed to create Element and default translation.", e);
                }
                
                /** Updating Section */
                if (elementTranslate != null)
                {
                    for (Record cell : record.getFields().get("UIElementTranslation"))
                    {
                        if (importUsedInFromExcel && "usedIn".equalsIgnoreCase(cell.getFieldName()))
                        {
                            try
                            {
                                if (Validator.isNotNull(cell.getValue()))
                                {
                                    element.setModuleName(String.valueOf(cell.getValue()).trim().toUpperCase());
                                    element.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                    element.setUpdatedDate(new Date());
                                    element = UIElementLocalServiceUtil.updateUIElement(element);
                                }
                            }
                            catch (SystemException e)
                            {
                                LOG.error("Failed to update Used In Information for Element Key:"+element.getElementKey(), e);
                            }
                        }
                        else if ("translationData".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue()))
                        {
                            try
                            {
                                elementTranslate.setElementValue(String.valueOf(cell.getValue()).trim());
                                elementTranslate.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                elementTranslate.setUpdatedDate(new Date());
                                UIElementTranslateLocalServiceUtil.updateUIElementTranslate(elementTranslate);
                            }
                            catch (SystemException e)
                            {
                                LOG.error("Failed to update Translation for Element Key:"+element.getElementKey()+" and locale code:"+localeCode, e);
                            }
                        }
                    }
                }
            }
        }
    }
}
