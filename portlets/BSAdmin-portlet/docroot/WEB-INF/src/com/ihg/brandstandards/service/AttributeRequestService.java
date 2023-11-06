package com.ihg.brandstandards.service;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import org.apache.commons.lang.time.DateFormatUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ihg.brandstandards.bsadmin.model.AttributeRequestObject;
import com.ihg.brandstandards.bsadmin.model.StdAttributes;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;
import com.ihg.brandstandards.report.FieldMapping;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.servlet.HttpHeaders;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;


public class AttributeRequestService
{
    private static final Log LOG = LogFactoryUtil.getLog(AttributeRequestService.class);
    private static final String EXPORT_FILE_NAME = "export_report";
    private static final String DOWNLOAD_DIFF_REPORT_NAME = "diff_report";
    private static final String NO_ACCESS_MESSAGE = "You do not have access";

    /**
     * 
     * @param portletRequest PortletRequest object
     * @param portletResponse PortletResponse object
     * @param updateRequests List<SpreadSheetAttributeUpdate> object
     */
    public void setUpdateAttributeRequests(PortletRequest portletRequest, PortletResponse portletResponse,
            List<SpreadSheetAttributeUpdate> updateRequests)
    {
        List<AttributeRequestObject> requests = new ArrayList<AttributeRequestObject>();
        AttributeRequestObject object = null;
        for (SpreadSheetAttributeUpdate request : updateRequests)
        {
            object = new AttributeRequestObject();
            User user = getUserObject(GetterUtil.getLong(request.getCreatorId()));
            if (Validator.isNotNull(request.getCreatorId()) && Validator.isNotNull(user))
            {
                String region = null;
                try
                {
                    region = BrandStandardsUtil.getUserRegionFromUserRole(user.getRoles());
                    if (UserLocalServiceUtil.hasRoleUser(user.getCompanyId(), BSAdminConstants.SUPER_ADMIN_ROLE,
                            user.getUserId(), false)) {
                        region = BSAdminConstants.ACCESS_TO_ALL;
                    }
                }
                catch (SystemException e)
                {
                    LOG.error(e.getMessage(), e);
                }
                catch (PortalException e)
                {
                    LOG.error(e.getMessage(), e);
                }
                object.setRequestId(request.getSpeardSheetId());
                object.setEmailAddress(user.getEmailAddress());
                object.setCreatedDate(request.getCreatedDate());
                object.setUserName(user.getFullName());
                object.setUserId(user.getUserId());
                object.setRequestTitle(request.getRequestTitle());
                object.setStatus(request.getStatus());
                object.setCreatedDate(request.getCreatedDate());
                if (Validator.isNotNull(region))
                {
                    object.setUserRegion(region);
                }
                requests.add(object);
            }

        }
        portletRequest.setAttribute("requestObjects", requests);
    }

    /**
     * 
     * @param portletRequest PortletRequest object
     * @param file File object
     * @return boolean
     */
    public boolean validateAttributeRequest(PortletRequest portletRequest, File file)
    {
        boolean isValid = false;
        //OPCPackage pkg = null;
        try
        {
            ThemeDisplay themeDisplay = (ThemeDisplay) portletRequest.getAttribute(WebKeys.THEME_DISPLAY);
            User user = themeDisplay.getUser();
            //Add "GLBL" for testing purpose
            
            String region = BrandStandardsUtil.getUserRegionFromUserRole(user.getRoles());
            if (LOG.isDebugEnabled()) {
            	LOG.debug("User's region is :"+region);
            }
            Workbook wb = null;
            Sheet xsheet = null;
            Cell firstCell = null;
            if (file != null) {
                wb = WorkbookFactory.create(file);
                if (wb != null) {
                    xsheet = wb.getSheet(BSAdminConstants.MASTER_DATA_SHEET);
                    if (xsheet != null) {
                        firstCell = xsheet.getRow(xsheet.getFirstRowNum()).getCell(0);
                    }
                }
            }
            //xsheet.disableLocking();
            String templateVal = null;
            
            if (Validator.isNotNull(firstCell) && firstCell.getCellType() == Cell.CELL_TYPE_STRING
                    && Validator.isNotNull(firstCell.getStringCellValue()))
            {
                templateVal = xsheet.getRow(xsheet.getFirstRowNum()).getCell(0).getStringCellValue();
            }
            if (Validator.isNotNull(templateVal))
            {
                boolean hasAdminRole = UserLocalServiceUtil.hasRoleUser(themeDisplay.getCompanyId(), BSAdminConstants.SUPER_ADMIN_ROLE,
                        user.getUserId(), false);
                ReportConfig config = ReportConfigLoader
                        .getReportConfig(BSAdminConstants.CONFIGOBJECT_MAP.get(templateVal));
                List<FieldMapping> indexFields = config.getIndex().getField();

                List<Long> stdIds = null;
                List<Long> allIds = new ArrayList<Long>();
                Map<String, List<Long>> stdIdsMap = new HashMap<String, List<Long>>();
                if (hasAdminRole)
                {
                    region = BSAdminConstants.ACCESS_TO_ALL;
                }
                //Cell cell = xsheet.getRow(7).getCell(30);
                for (Row row : xsheet)
                {
                    if (row.getRowNum() > BSAdminConstants.HEADER_ROW_NUM)
                    {

                        long stdId = 0;
                        int counter = 0;
                        for (FieldMapping field : indexFields)
                        {
                            if (BSAdminConstants.ATTR_STD_ID.equals(field.getXlsColumnName()))
                            {
                                break;
                            }
                            counter++;
                        }
                        Cell cell = xsheet.getRow(row.getRowNum()).getCell(counter);

                        if (Validator.isNotNull(cell) && cell.getCellType() == Cell.CELL_TYPE_NUMERIC
                                && Validator.isNotNull(cell.getNumericCellValue()))
                        {
                            stdId = Math.round(cell.getNumericCellValue());
                        }

                        if (stdId != 0)
                        {
                            if (stdIds == null || stdIds.size() % 100 == 0)
                            {
                                if (LOG.isDebugEnabled())
                                {
                                    LOG.info("standardId map size :" + stdIdsMap.size());
                                }
                                stdIds = new ArrayList<Long>();
                                stdIdsMap.put(StringPool.BLANK + stdIdsMap.size(), stdIds);
                            }
                            stdIds.add(stdId);
                            allIds.add(stdId);
                        }
                    }
                }
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Map size :" + stdIdsMap.size());
                }
                if (region != null && !isStandardNotExist(portletRequest, allIds, stdIdsMap, region, user))
                {
                    isValid = true;
                } else if (region == null) {
                	portletRequest.setAttribute("noRegion", BSAdminConstants.NO_ACCESS_MSG);
                }
            } else {
            	portletRequest.setAttribute("templateValue", "false");
            }
           // pkg.close();
        }
        catch (InvalidFormatException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        } 
        if (LOG.isDebugEnabled())
        {
            LOG.debug("Valid :" + isValid);
        }

        return isValid;
    }

    /**
     * 
     * @param userId This is a long type object
     * @return User This method will return User object
     */
    private User getUserObject(long userId)
    {
        User user = null;
        try
        {
            user = UserLocalServiceUtil.getUser(userId);
        }
        catch (Exception e)
        {
            LOG.error(e.getMessage());
        }
        return user;
    }

    /**
     * @param request PortletRequest object
     * @param allIds List<Long> object
     * @param stdIdMap Map <String, List<Long>> object
     * @param region String object
     * @param user User object
     * @return boolean 
     */
    private boolean isStandardNotExist(PortletRequest request, List<Long> allIds, Map<String, List<Long>> stdIdMap,
            String region, User user)
    {
        PortletPreferences portletPreferences = request.getPreferences();
        String environment = portletPreferences.getValue("environment", BSAdminConstants.ENVIRONMENT_CMS);
        String errorMessage = null;
        boolean isStdNotExist = false;
        String userRole = null;
        try {
        	userRole = BrandStandardsUtil.getAuthorRoleFromUserRole(user.getRoles());
        } catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (Validator.isNotNull(userRole)) {
        	errorMessage = SpreadSheetAttributeUpdateLocalServiceUtil.recordsNotAvailable(allIds, stdIdMap, user, region, environment);
        } else {
        	errorMessage = NO_ACCESS_MESSAGE;
        }
        if (Validator.isNotNull(errorMessage)) {
        	isStdNotExist = true;
        	request.setAttribute("stdNotExist", errorMessage);
        }
        return isStdNotExist;
    }


    /**
     * @param flagIds String object
     * @return List<String>
     */
    private List<String> getFlagArray(String flagIds)
    {
        List<String> flagList = new ArrayList<String>();
        Map<String, FlagCategory> flags = StandardsUtil.getFlagCategoryMap();
        String[] flagArray = flagIds.split(",");
        for (String flagId : flagArray)
        {
            if (flags.containsKey(flagId))
            {
                FlagCategory flagCategory = flags.get(flagId);
                flagList.add(flagCategory.getTxtValue());
            }
        }
        return flagList;
    }

    /**
     * 
     * @param ids String[] object
     * @param standardIds List<Long> object 
     * @return List<Long>
     */
    public List<Long> getStandardIds(String[] ids, List<Long> standardIds)
    {
        if (Validator.isNotNull(ids))
        {
            for (String id : ids)
            {
                standardIds.add(GetterUtil.getLong(id));
            }
        }
        return standardIds;
    }

    /**
     * @param results List object
     * @param cellStyle CellStyle object
     * @param headerColumns int object
     * @param xsheet 
     */
    public void createRow(List results, Sheet xsheet, CellStyle cellStyle, int headerColumns)
    {

        List<StdAttributes> attributes = (List<StdAttributes>) results;
        for (int i = 0; i < attributes.size(); i++)
        {

            StdAttributes attribute = attributes.get(i);
            List<String> flagList = null;
            if (Validator.isNotNull(attribute.getFlags()))
            {
                flagList = getFlagArray(attribute.getFlags());
            }
            Row row = xsheet.createRow(4 + i);
            for (int j = 0; j < headerColumns; j++)
            {
                if (Validator.isNotNull(xsheet.getRow(3).getCell(j)))
                {

                    xsheet.getRow(3).getCell(j).setCellType(1);
                    String columnName = xsheet.getRow(3).getCell(j).getStringCellValue();

                    Cell cell = null;
                    if ("Ref No".equalsIgnoreCase(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_NUMERIC, cellStyle, j);
                        cell.setCellValue(attribute.getStdId());
                    }
                    else if ("Type".equalsIgnoreCase(columnName) && j == 3)
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(attribute.getStdType());
                    }
                    else if ("Text".equalsIgnoreCase(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(attribute.getStdTitle());
                    }
                    else if ("Index Title".equalsIgnoreCase(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(attribute.getIndexTitle());
                    }
                    else if ("Index Description".equalsIgnoreCase(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(attribute.getIndexDesc());
                    }
                    else if (Validator.isNotNull(flagList) && flagList.contains(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(BSAdminConstants.SELECTED_ATTR);
                    }
                    else if (Validator.isNotNull(attribute.getBrands()) && attribute.getBrands().contains(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(BSAdminConstants.SELECTED_ATTR);
                    }
                    else if (Validator.isNotNull(attribute.getCountries()) && attribute.getCountries().contains(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(BSAdminConstants.SELECTED_ATTR);
                    }
                    else if (Validator.isNotNull(attribute.getAreaCategory())
                            && attribute.getAreaCategory().equalsIgnoreCase(columnName))
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(BSAdminConstants.SELECTED_ATTR);
                    }
                    else
                    {
                        cell = createCell(row, Cell.CELL_TYPE_STRING, cellStyle, j);
                        cell.setCellValue(BSAdminConstants.NOT_SELECTED_ATTR);
                    }
                }
            }
        }
    }

    /**
     * 
     * @param row Row object
     * @param cellType int object
     * @param cellStyle CellStyle object
     * @param cellNumber int object
     * @return Cell
     */
    private Cell createCell(Row row, int cellType, CellStyle cellStyle, int cellNumber)
    {
        Cell cell = row.createCell(cellNumber);
        cell.setCellType(cellType);
        cell.setCellStyle(cellStyle);
        return cell;
    }

    /**
     * 
     * @param file File object
     * @param userId long object
     * @param title String object
     * @param date Date object
     * @param isNewRecord boolean object
     * @param requestId long object
     * @return boolean
     */
    public boolean createOrUpdateAttributeRequest(File file, long userId, String title, Date date, boolean isNewRecord,
            long requestId)
    {
        boolean attrRequestUpdated = true;
        try
        {

            SpreadSheetAttributeUpdate sheetAttributeUpdate = null;
            if (isNewRecord)
            {
                long spID = CounterLocalServiceUtil.increment();
                sheetAttributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil.createSpreadSheetAttributeUpdate(spID);
                sheetAttributeUpdate.setCreatorId(StringPool.BLANK + userId);
                sheetAttributeUpdate.setCreatedDate(date);
                sheetAttributeUpdate.setStatus(BSAdminConstants.READY_FOR_REVIEW);
            }
            else
            {
                sheetAttributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil.getSpreadSheetAttributeUpdate(requestId);
                if (Validator.isNotNull(sheetAttributeUpdate)
                        && (!BSAdminConstants.IN_PROGRESS.equalsIgnoreCase(sheetAttributeUpdate.getStatus()) && !BSAdminConstants.PROCESSED
                                .equalsIgnoreCase(sheetAttributeUpdate.getStatus())))
                {
                    sheetAttributeUpdate.setStatus(BSAdminConstants.UPDATED_FOR_REVIEW);
                }
                else
                {
                    attrRequestUpdated = false;
                }
            }

            if (attrRequestUpdated)
            {
                sheetAttributeUpdate.setRequestTitle(title);
                if (Validator.isNotNull(file))
                {
                    byte[] bFile = FileUtil.getBytes(file);
                    sheetAttributeUpdate.setSpreadSheet(Base64.objectToString(bFile));
                }
                sheetAttributeUpdate.setUpdatedBy(StringPool.BLANK + userId);
                sheetAttributeUpdate.setUpdatedDate(date);
                SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(sheetAttributeUpdate);
            }

        }
        catch (Exception e)
        {
            attrRequestUpdated = false;
            LOG.error(e.getMessage(), e);
        }
        return attrRequestUpdated;
    }

    /**
     * @param request PortletRequest object
     * @param requestId long object
     */
    public void deleteAttributeRequest(PortletRequest request, long requestId)
    {

        boolean isDeleted = false;
        try
        {
            SpreadSheetAttributeUpdate attributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil
                    .getSpreadSheetAttributeUpdate(requestId);
            if (Validator.isNotNull(attributeUpdate)
                    && (!BSAdminConstants.IN_PROGRESS.equalsIgnoreCase(attributeUpdate.getStatus()) && !BSAdminConstants.PROCESSED
                            .equalsIgnoreCase(attributeUpdate.getStatus())))
            {
                SpreadSheetAttributeUpdateLocalServiceUtil.deleteSpreadSheetAttributeUpdate(requestId);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Attribute request deleted :" + requestId);
                }
                isDeleted = true;
            }
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (!isDeleted)
        {
            request.setAttribute("deleteError", BSAdminConstants.ERROR_OCCURED);
        }
    }

    /**
     * @param request PortletRequest object
     * @param requestId long object
     */
    public void approveAttributeRequest(PortletRequest request, long requestId)
    {

        boolean isApproved = false;
        try
        {
            SpreadSheetAttributeUpdate attributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil
                    .getSpreadSheetAttributeUpdate(requestId);
            if (Validator.isNotNull(attributeUpdate)
                    && (BSAdminConstants.READY_FOR_REVIEW.equalsIgnoreCase(attributeUpdate.getStatus()) || BSAdminConstants.UPDATED_FOR_REVIEW
                            .equalsIgnoreCase(attributeUpdate.getStatus())))
            {
                attributeUpdate.setStatus(BSAdminConstants.APPROVED);
                SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(attributeUpdate);
                isApproved = true;
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Attribute request approved :"+attributeUpdate.getSpeardSheetId());
            }
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (!isApproved)
        {
            request.setAttribute("approveError", BSAdminConstants.ERROR_OCCURED);
        }
    }

    /**
     * @param request PortletRequest object
     * @param requestId long object 
     */
    public void rejectAttributeRequest(PortletRequest request, long requestId)
    {

        boolean isRejected = false;
        try
        {
            SpreadSheetAttributeUpdate attributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil
                    .getSpreadSheetAttributeUpdate(requestId);
            if (Validator.isNotNull(attributeUpdate)
                    && (!BSAdminConstants.IN_PROGRESS.equalsIgnoreCase(attributeUpdate.getStatus()) && !BSAdminConstants.PROCESSED
                            .equalsIgnoreCase(attributeUpdate.getStatus())))
            {
                attributeUpdate.setStatus(BSAdminConstants.REJECTED);
                SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(attributeUpdate);
                isRejected = true;
            }
            if (LOG.isDebugEnabled())
            {
                LOG.debug("Attribute request rejected :"+attributeUpdate.getSpeardSheetId());
            }
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (!isRejected)
        {
            request.setAttribute("rejectError", BSAdminConstants.ERROR_OCCURED);
        }
    }

    /**
     * @param request PortletRequest object
     * @param requestId long object
     */
    public void executeUpdateAttributeRequest(PortletRequest request, long requestId)
    {
        boolean isRecordInProcess = false;
        try
        {
            SpreadSheetAttributeUpdate attributeUpdate = SpreadSheetAttributeUpdateLocalServiceUtil
                    .getSpreadSheetAttributeUpdate(requestId);
            if (Validator.isNotNull(attributeUpdate)
                    && (BSAdminConstants.APPROVED.equalsIgnoreCase(attributeUpdate.getStatus()) || 
                    		hasUserSuperRole(request)))
            {
                attributeUpdate.setStatus(BSAdminConstants.IN_PROGRESS);
                SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(attributeUpdate);
                isRecordInProcess = true;
                request.setAttribute("inProgressMsg", BSAdminConstants.IN_PROGRESS_MSG);
                if (LOG.isDebugEnabled())
                {
                    LOG.debug("Attribute request in progress :"+attributeUpdate.getSpeardSheetId());
                }
            }
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
        if (!isRecordInProcess)
        {
            request.setAttribute("processError", BSAdminConstants.ERROR_OCCURED);
        }
    }

    /**
     * 
     * @param stdCell Cell object
     * @return String
     */
    public String getCellValue(Cell stdCell)
    {
        String stdValue = StringPool.BLANK;
        if (stdCell != null && stdCell.getCellType() == Cell.CELL_TYPE_STRING && Validator.isNotNull(stdCell.getStringCellValue()))
        {
            stdValue = stdCell.getStringCellValue();
        }
        else if (stdCell != null && stdCell.getCellType() == Cell.CELL_TYPE_NUMERIC && Validator.isNotNull(stdCell.getNumericCellValue()))
        {
            long tempValue = Math.round(stdCell.getNumericCellValue());
            stdValue = StringPool.BLANK + tempValue;
        }
        return stdValue;
    }
    
    /**
     * 
     * @param stdCell Cell object
     * @return long
     */
    public long getCellNumericValue(Cell stdCell)
    {
        long stdValue = 0l;
        if (stdCell != null && stdCell.getCellType() == Cell.CELL_TYPE_NUMERIC && Validator.isNotNull(stdCell.getNumericCellValue()))
        {
        	stdValue = Math.round(stdCell.getNumericCellValue());
        }
        return stdValue;
    }

    /**
     * 
     * @param attributeUpdate SpreadSheetAttributeUpdate object
     * @param resourceResponse ResourceResponse object
     */
    public void updateAttributeRequestObject(SpreadSheetAttributeUpdate attributeUpdate, ResourceRequest resourceRequest, 
    		ResourceResponse resourceResponse, User user, String environment)
    {
        InputStream inputStream = null;
        InputStream newInpupStream = null;
        OutputStream out = null;
        try
        {
            LOG.info("start time :"+new Date());
        	inputStream = new ByteArrayInputStream((byte[]) Base64.stringToObject(attributeUpdate.getSpreadSheet()));
            //OPCPackage pkg = OPCPackage.open(inputStream);
            Workbook wb = WorkbookFactory.create(inputStream);
            inputStream.close();
            LOG.info("after wb object creation :"+new Date());
            //pkg.close();
            Sheet xsheet = wb.getSheet(BSAdminConstants.MASTER_DATA_SHEET);
            String templateVal = xsheet.getRow(xsheet.getFirstRowNum()).getCell(0).getStringCellValue();
            String regionVal = null;
            if (Cell.CELL_TYPE_STRING == xsheet.getRow(xsheet.getFirstRowNum()).getCell(1).getCellType()) {
            	regionVal = xsheet.getRow(xsheet.getFirstRowNum()).getCell(1).getStringCellValue();
            }
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Report region :"+regionVal);            	
            }
            if (Validator.isNull(templateVal))
            {
                templateVal = BSAdminConstants.TEMPLATE_NAME;
            }
            String templatePath = BSAdminConstants.TEMPLATES_MAP.get(templateVal);
            
            ReportConfig config = ReportConfigLoader.getReportConfig(BSAdminConstants.CONFIGOBJECT_MAP.get(templateVal));
            List<FieldMapping> records = config.getRecord().getField();
            List<FieldMapping> indexFields = config.getIndex().getField();
            int indexLength = indexFields.size();
            Map<Long,Integer> standardRecords = new LinkedHashMap<Long, Integer>();
            List<Long> stdIds = getStandardIds(xsheet, indexFields, standardRecords);
            if (stdIds.size() <= BSAdminConstants.SMALL_REQUEST_RECORDS) {
            	newInpupStream = getClass().getClassLoader().getResourceAsStream(templatePath);
                Workbook newWB = WorkbookFactory.create(newInpupStream);
                newInpupStream.close();
	            LOG.info("before first query :"+new Date());
	            List<StandardsExt> results = SpreadSheetAttributeUpdateLocalServiceUtil.getStandardDetails(stdIds);
	            Sheet newSheet = newWB.getSheet(BSAdminConstants.MASTER_DATA_SHEET);
	            Map<String, CellStyle> styles = StandardsReportBuilder.getCellStyleMap(newWB);
	            List<Long> flagIds = null;
	            CellStyle cs = newWB.createCellStyle();
	            cs.setFillForegroundColor(IndexedColors.RED.getIndex());
	            cs.setFillPattern(CellStyle.SOLID_FOREGROUND);
	            cs.setAlignment(CellStyle.ALIGN_CENTER);
	            cs.setLocked(false);
	            
	            Cell stdCell = null;
	            String value = null;
	            Cell newCell = null;
	            //Sort standards list
	            LOG.info("diff file creation :"+new Date());
	            for (StandardsExt standard : sortStandards(results))
	            {
	            	flagIds = new LinkedList<Long>();
	                if (standard.getFlags() != null) {
	                    flagIds.addAll(standard.getFlags());
	                }
	                Row newRow = newSheet.createRow(newSheet.getPhysicalNumberOfRows());
	                //newRow.setRowStyle(rowStyle);
	                StandardsReportBuilder.createCellsForAttributes(standard, newRow, styles, indexFields, null, 0);
	                StandardsReportBuilder.createCellsForFlagFields(standard, newRow, styles, records, indexLength, StringPool.BLANK);
	                Row diffRow = newSheet.createRow(newSheet.getPhysicalNumberOfRows());
	                StandardsReportBuilder.createCellsForAttributes(standard, diffRow, styles, indexFields, null, 0);
	                long stdIdVal = getCellNumericValue(newRow.getCell(0));
	                if (stdIdVal != 0l) {
		                Row oldRow = xsheet.getRow(standardRecords.get(stdIdVal));
		
		                int j = indexLength;
		                for (FieldMapping field : records)
		                {
		                    stdCell = oldRow.getCell(j);
		                    value = getCellValue(stdCell);
		                    newCell = diffRow.createCell(j);
							newCell.setCellValue(value);
	
							if (!BSAdminConstants.CELL_TYPE.equals(field.getClassFieldName()) && field.getValue() != null && 
									("GLBL".equals(regionVal) || Validator.isNull(regionVal) || standard.getStdRegionCode().equals(regionVal))) {
		                    	
			                    if (flagIds.contains(field.getValue())
			                            && !BSAdminConstants.SELECTED_ATTR.equals(value))
			                    {
			                    	
			                    	newCell.setCellStyle(cs);
			                    }
			                    else if (!flagIds.contains(field.getValue())
			                            && BSAdminConstants.SELECTED_ATTR.equals(value))
			                    {
			                    	newCell.setCellStyle(cs);
			                    } else {
			              			newCell.setCellStyle(styles.get("Flag"));
			                    }
		                    } else {
		                            newCell.setCellStyle(styles.get("Flag"));
		                    }
		                    
		                    j++;
		                }
	               }
	            }
	            LOG.info("diff file processed :"+new Date());
	            resourceResponse.setContentType("application/vnd.ms-excel");
	            resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
	            StringBuffer fileName = new StringBuffer("attachment; filename=");
	            fileName.append(DOWNLOAD_DIFF_REPORT_NAME).append(StringPool.UNDERLINE);
	            fileName.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd")).append(".xlsm");
	            
	            resourceResponse.addProperty("Content-Disposition", fileName.toString());
	            
	            //resourceResponse.addProperty("Content-Disposition", fileName.toString());
	            //resourceResponse.addProperty("Content-Disposition", "attachment; filename=\"diff_report.xls\"");
	            //resourceResponse.addProperty("Content-type", "xlsx");
				out = resourceResponse.getPortletOutputStream();
	            newWB.write(out);
	            out.flush();
	            out.close();
            } else {
            	if (addRequestToJobQueue(null, user, StringPool.BLANK+attributeUpdate.getSpeardSheetId(), "DiffReport", 
            			user.getEmailAddress(), null, environment, null)) {
            		resourceRequest.setAttribute("largeRequest", BSAdminConstants.REPORT_IN_PROGRESS);
            	} else {
            		resourceRequest.setAttribute("error", BSAdminConstants.ERROR_OCCURED);
            	}
            }
        }
        catch (InvalidFormatException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        } 
        finally {
            try
            {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (newInpupStream != null) {
                    newInpupStream.close();
                }
                if (out != null) {
                    out.close();
                }
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
            if (LOG.isDebugEnabled()) {
            	LOG.debug("File created :::::------"+ new Date());
            }     
        }
    }

    /**
     * 
     * @param standardIds List<Long> object
     * @param template String object
     * @param resourceResponse ResourceResponse object
     */
    public void exportStandardAttributeDetails(List<Long> standardIds, String template, ResourceResponse resourceResponse, String region)
    {
        OutputStream outputStream = null;
        InputStream inputStream = null;
        OPCPackage pkg = null;
        try
        {
        	LOG.info("start time for export req :"+new Date());
            String templatePath = BSAdminConstants.TEMPLATES_MAP.get(template);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Template path :" + templatePath);
                LOG.debug("Template :" + template);
            }
            if (Validator.isNotNull(templatePath)) {
                inputStream = getClass().getClassLoader().getResourceAsStream(templatePath);
            }
            if (Validator.isNotNull(inputStream))
            {
                pkg = OPCPackage.open(inputStream);
                inputStream.close();
                ReportConfig config = ReportConfigLoader.getReportConfig(BSAdminConstants.CONFIGOBJECT_MAP.get(template));
                if (config != null)
                {
                    List results = SpreadSheetAttributeUpdateLocalServiceUtil.getStandardDetails(standardIds);
                    //Sort standard list
                    Workbook workbook = StandardsReportBuilder.createAttributeReport(sortStandards(results), config, pkg, template, region);
                    LOG.info("workbook object created:"+new Date());
                    //FileOutputStream fileOut = new FileOutputStream("C://Others/Projects/IHG/XLSUpdate/XLSUpdate/src/main/resources/CMS Global Standard Attribute Assignment 1.7 Ops Content.xls");
                    resourceResponse.setContentType("application/vnd.ms-excel");
                    resourceResponse.addProperty(HttpHeaders.CACHE_CONTROL, "max-age=3600, must-revalidate");
                    StringBuffer fileName = new StringBuffer("attachment; filename=");
                    fileName.append(EXPORT_FILE_NAME).append(StringPool.UNDERLINE);
                    fileName.append(DateFormatUtils.format(new Date(), "yyyy-MM-dd")).append(".xlsm");
                    resourceResponse.addProperty("Content-Disposition", fileName.toString());
                    outputStream = resourceResponse.getPortletOutputStream();
                    //xsheet.enableLocking();
                    workbook.write(outputStream);
                    LOG.info("data exported :"+new Date());
                    outputStream.flush();
                    outputStream.close();
                    pkg.revert();
                }
            }
        }
        catch (InvalidFormatException e)
        {
            LOG.error(e.getMessage(), e);
        }
        catch (IOException e)
        {
            LOG.error(e.getMessage(), e);
        } finally {
            try
            {
                if (inputStream != null) {
                    inputStream.close();
                }
                if (outputStream != null) {
                    outputStream.close();
                }
                if (pkg != null) {
                    pkg.close();
                }
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
    }

    }
    
    /**
     * 
     * @param standards
     * @return List<StandardsExt>
     */
    private List<StandardsExt> sortStandards (List<StandardsExt> standards) {
    	 sortRecordsByIndex(standards);
         List<StandardsExt> sortedStandards = sortStdRecordsUnderIndex(standards);
         return sortedStandards;
    }
    
    
    /**
     * Sort Standards Under each Index by specified sort order
     */
    public List<StandardsExt> sortStdRecordsUnderIndex(List<StandardsExt> standards)
    {
        Map<Long, Map<Long, List<StandardsExt>>> indexRecords = new LinkedHashMap<Long, Map<Long, List<StandardsExt>>>();

        for (StandardsExt std : standards)
        {
            //LOG.debug("Sort records indxId : " + std.getIndexId() + " index title: " + std.getIndexTitle());

            Map<Long, List<StandardsExt>> indexItem = indexRecords.get(std.getIndexId());
            // no Index found
            if (indexItem == null)
            {
                // create map to store Standard
                indexItem = new LinkedHashMap<Long, List<StandardsExt>>();
                List<StandardsExt> stdItem = new ArrayList<StandardsExt>();
                stdItem.add(std);
                indexItem.put(std.getStdId(), stdItem);
                // create Index item with Standard
                indexRecords.put(std.getIndexId(), indexItem);
                //LOG.debug("Sort records ADDED indxId : " + std.getIndexId() + " index title: " + std.getIndexTitle());
            }
            // found Index; add Standard, Specification or Guideline
            else
            {
                List<StandardsExt> stdItem = indexItem.get(std.getStdPrntId());
                // this is should be Standard. For Specification and Guideline stdItem should NOT be null
                if (stdItem == null)
                {
                    stdItem = new ArrayList<StandardsExt>();
                    indexItem.put(std.getStdId(), stdItem);
                }
                stdItem.add(std);
            }
        }

        List<StandardsExt> sortedList = new ArrayList<StandardsExt>();
        List<StandardsExt> tmpList = new ArrayList<StandardsExt>();
        for (Map.Entry<Long, Map<Long, List<StandardsExt>>> indexEntry : indexRecords.entrySet())
        {
            tmpList.clear();
            // Standards for Index  === <prnt_std_id, list of Records> first records is a Standard
            Map<Long, List<StandardsExt>> stdRecords = indexEntry.getValue();
            for (Map.Entry<Long, List<StandardsExt>> stdEntry : stdRecords.entrySet())
            {
                List<StandardsExt> recordsList = stdEntry.getValue();
                if (recordsList != null && !recordsList.isEmpty())
                {
                    for (StandardsExt rec : recordsList)
                    {
                        //Add Standard or Index with no records
                        if (BSAdminConstants.STD_TYPE.equals(rec.getStdType()) || rec.getStdId() == 0L)
                        {
                            tmpList.add(rec);
                            break;
                        }
                    }
                }
            }

            sortStdBySortOrder(tmpList);
            for (StandardsExt std : tmpList)
            {
                List<StandardsExt> stdItems = stdRecords.get(std.getStdId());
                sortedList.addAll(stdItems);
            }
        }
        return sortedList;
    }
    
    
    /**
     * Sort records by Display order
     */
    private void sortStdBySortOrder(List<StandardsExt> standards)
    {
        Collections.sort(standards, new Comparator<StandardsExt>()
        {
            public int compare(StandardsExt s1, StandardsExt s2)
            {
                return compareLong(s1.getStdOrderNumber(), s2.getStdOrderNumber());
            }

            /**
             * Compare long values.
             *
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

        });
    }
    
    public void sortRecordsByIndex(List<StandardsExt> standards)
    {
        Collections.sort(standards, new Comparator<StandardsExt>()
        {
            public int compare(StandardsExt s1, StandardsExt s2)
            {
                int res = compareLong(s1.getIndexOrder(), s2.getIndexOrder());
                if (res == 0)
                {
                    if (s1.getStdId() == 0 && s2.getStdId() == 0)
                    {
                        return 0;
                    }
                    res = compareLong(s1.getStdPrntId(), s2.getStdPrntId());
                    if (res == 0)
                    {
                        res = compareRecordType(s2.getStdType(), s1.getStdType());
                        if (res == 0)
                        {
                            if (s1.getStdOrderNumber() > 0L || s2.getStdOrderNumber() > 0L)
                            {
                                res = compareLong(s1.getStdOrderNumber(), s2.getStdOrderNumber());
                            }
                            else
                            {
                                res = compareLong(s1.getStdId(), s2.getStdId());
                            }
                            if (res == 0)
                            {
                                // sort descending on Audit Log Date
                                if (s2.getAuditLogDate() != null && s1.getAuditLogDate() != null)
                                {
                                    return compareLong(s2.getAuditLogDate().getTime(), s1.getAuditLogDate().getTime());
                                }
                            }
                        }
                    }
                }
                return res;
            }

            /**
             * Compare long values.
             *
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

            /**
             * Compare long values.
             *
             * @param t1 - record type 1
             * @param t2 - record type 2
             * @return 1, 0, -1
             */
            private int compareRecordType(String t1, String t2)
            {
                if (t1 != null && t2 != null)
                {
                    if (BSAdminConstants.STD_TYPE.equals(t1) && !BSAdminConstants.STD_TYPE.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSAdminConstants.STD_TYPE.equals(t1) && BSAdminConstants.STD_TYPE.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSAdminConstants.STD_TYPE.equals(t1) && BSAdminConstants.STD_TYPE.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSAdminConstants.SPEC_TYPE.equals(t1) && !BSAdminConstants.SPEC_TYPE.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSAdminConstants.SPEC_TYPE.equals(t1) && BSAdminConstants.SPEC_TYPE.equals(t2))
                    {
                        return -1;
                    }
                    else if (BSAdminConstants.SPEC_TYPE.equals(t1) && BSAdminConstants.SPEC_TYPE.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSAdminConstants.GDLN_TYPE.equals(t1) && BSAdminConstants.GDLN_TYPE.equals(t2))
                    {
                        return 0;
                    }
                    else if (BSAdminConstants.GDLN_TYPE.equals(t1) && !BSAdminConstants.GDLN_TYPE.equals(t2))
                    {
                        return 1;
                    }
                    else if (!BSAdminConstants.GDLN_TYPE.equals(t1) && BSAdminConstants.GDLN_TYPE.equals(t2))
                    {
                        return -1;
                    }
                }
                else if (t1 != null && t2 == null)
                {
                    return 1;
                }
                else if (t1 == null && t2 != null)
                {
                    return -1;
                }
                return 0;
            }
        });
    }

    /**
     * @param xsheet Sheet object
     * @param indexFields List<FieldMapping> object
     * @param stdRowNum Map<Long,Integer> object
     * @return List<Long>
     */
    public List<Long> getStandardIds(Sheet xsheet, List<FieldMapping> indexFields, Map<Long,Integer> stdRowNum)
    {
        List<Long> stdIds = new ArrayList<Long>();
        for (Row row : xsheet)
        {
            if (row.getRowNum() > BSAdminConstants.HEADER_ROW_NUM)
            {
                int counter = 0;
                for (FieldMapping field : indexFields)
                {
                    if (BSAdminConstants.ATTR_STD_ID.equals(field.getXlsColumnName()))
                    {
                        Cell cell = xsheet.getRow(row.getRowNum()).getCell(counter);
                        long stdId = 0;
                        if (Validator.isNotNull(cell) && cell.getCellType() == Cell.CELL_TYPE_NUMERIC
                                && Validator.isNotNull(cell.getNumericCellValue()))
                        {
                            stdId = Math.round(cell.getNumericCellValue());
                        }

                        if (stdId != 0)
                        {
                            if (stdRowNum != null) {
                            	stdRowNum.put(stdId, row.getRowNum());
                            }
                        	stdIds.add(stdId);
                        }
                        break;
                    }
                    counter++;

                }
            }
        }
        return stdIds;
    }
    
    /**
     * 
     * @param user
     * @return String
     */
    private String getUserRegion (PortletRequest request) {
        String userRegion = StringPool.BLANK;
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        try
        {
        	User user = themeDisplay.getUser();
            userRegion = BrandStandardsUtil.getUserRegionFromUserRole(user.getRoles());
            boolean hasAdminRole = UserLocalServiceUtil.hasRoleUser(PortalUtil.getDefaultCompanyId(), BSAdminConstants.SUPER_ADMIN_ROLE,
                    user.getUserId(), false);
            if (hasAdminRole)
            {
                userRegion = BSAdminConstants.ACCESS_TO_ALL;
            }
        }
        catch (SystemException e)
        {
           LOG.error(e.getMessage(), e);
        }
        catch (PortalException e)
        {
            LOG.error(e.getMessage(), e);
        };
        return userRegion;
    }
    
    /**
     * 
     * @param request
     * @return boolean
     */
    public boolean hasUserSuperRole (PortletRequest request) {
    	boolean isSuperUser = false;
    	Role role = null;
    	ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
		try
		{
			User user = themeDisplay.getUser();
			role = RoleLocalServiceUtil.getRole(user.getCompanyId(), BSAdminConstants.ATTRIBUTE_UPDATE_ROLE);
			RoleLocalServiceUtil.hasUserRole(user.getUserId(), role.getRoleId());
			isSuperUser = true;
		} catch (PortalException e)
		{
			LOG.error(e.getMessage(), e);
		} catch (SystemException e)
		{
			LOG.error(e.getMessage(), e);
		}
		return isSuperUser;
    }
    
    public boolean addRequestToJobQueue (List<?> stdIds, User user, String attributeId, String reportType, String emailAddress, String usrRegion, 
    		String environment, String template) {
    	
    	boolean isRequestAdded = false;
    	//encode special characters
    	template = StringUtil.replace(template, "&", "&amp;");
    	StringBuilder metadata = new StringBuilder();
        metadata.append("<metadata>");
        metadata.append("<type>").append(reportType).append("</type>");
        metadata.append("<params>");
        if (Validator.isNotNull(stdIds)) {
        	metadata.append("<param name=\"STDIDS\">").append(StringUtil.merge(stdIds,StringPool.COMMA)).append("</param>");
        }
        metadata.append("<param name=\"ATTRID\">").append(attributeId).append("</param>");
        if (Validator.isNotNull(attributeId)) {
        	metadata.append("<param name=\"REQUEST_ID\">").append(attributeId).append("</param>");
        } else {
        	metadata.append("<param name=\"REQUEST_ID\">Download</param>");
        }
        metadata.append("<param name=\"ENVIRONMENT\">").append(environment).append("</param>");
        metadata.append("<param name=\"TEAMPLATE\">").append(template).append("</param>");
        metadata.append("<param name=\"REGION\">").append(usrRegion).append("</param>");
        metadata.append("<param name=\"USER_NAME\">").append(user.getFullName()).append("</param>");
        metadata.append("</params>");
        metadata.append("</metadata>");
        isRequestAdded = SpreadSheetAttributeUpdateLocalServiceUtil.addToJobQueue(user, metadata.toString(), "ATTRIBUTE_UPDATE");
        return isRequestAdded;
    }

}
