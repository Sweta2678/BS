package com.ihg.brandstandards.scheduler;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdate;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.FlagStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.SpreadSheetAttributeUpdateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.report.FieldMapping;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.service.AttributeRequestService;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageListener;
import com.liferay.portal.kernel.messaging.MessageListenerException;
import com.liferay.portal.kernel.util.Base64;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;

public class AttributeUpdateSchedular implements MessageListener
{

    private static final Log LOG = LogFactoryUtil.getLog(AttributeUpdateSchedular.class);
    private static final String EXCELSHEET_DATA = "Master Data";
    private static final String STD_ID_COLUMN = "STD ID";
    private volatile static boolean IS_PROCESS_IN_PROGRESS = false;
    private static final int TOTAL_DAYS = 7;
    private static final String TYPE_GUIDELINE = "Guideline";
    private static final String STD_TYPE = "Type";
    private static final String STD_REGION = "Region";
    //Quality Attributes template
    private static final String TEMPLATE_QUALITY = "108";
    /**
     * @param message Message object
     * @author Chintan Akhani
     */
    public void receive(Message message) throws MessageListenerException
    {
        updateAttributes();

    }
    
    /**
     * Scheduler will invoke this method to update standard flags
     */
    public static void receive() {
    	try {
	    	if (!IS_PROCESS_IN_PROGRESS) {
	    		if (LOG.isDebugEnabled()) {
	    			LOG.debug("No process is in progress :");
	    		}
	    		IS_PROCESS_IN_PROGRESS = true;
	    		// Update flag reference in database
	    		updateAttributes();
	    		IS_PROCESS_IN_PROGRESS = false;
	    	} else {
	    		if (LOG.isDebugEnabled()) {
	    			LOG.debug("other process is in progress :");
	    		}
	    	} 
    	} catch (Exception e) {
    		LOG.error(e.getMessage(), e);
    		IS_PROCESS_IN_PROGRESS = false;
    	}
    	
    }

    /**
	 *@author Chintan Akhani 
	 */
    private static void updateAttributes()
    {
        List<SpreadSheetAttributeUpdate> spreadSheetList = SpreadSheetAttributeUpdateLocalServiceUtil
                .getAttributeRequestList(BSAdminConstants.IN_PROGRESS);
        for (SpreadSheetAttributeUpdate attributeUpdate : spreadSheetList)
        {
            if (LOG.isDebugEnabled()) {
            	LOG.debug("-- attribute title --" + attributeUpdate.getRequestTitle());
            }
            InputStream inputStream = null;
            try
            {
                inputStream = new ByteArrayInputStream((byte[]) Base64.stringToObject(attributeUpdate.getSpreadSheet()));
                //OPCPackage pkg = OPCPackage.open(inputStream);
                Workbook wb = WorkbookFactory.create(inputStream);
                Sheet sheet = wb.getSheet(EXCELSHEET_DATA);
                //sheet.disableLocking();
                processAttributeObject(attributeUpdate, sheet);
                //sheet.enableLocking();
                inputStream.close();
                //pkg.close();
                SpreadSheetAttributeUpdate attrUpdated = SpreadSheetAttributeUpdateLocalServiceUtil.updateSpreadSheetAttributeUpdate(attributeUpdate);
                if (BSAdminConstants.PROCESSED.equalsIgnoreCase(attrUpdated.getStatus())) {
                	SpreadSheetAttributeUpdateLocalServiceUtil.sendEmailNotification(Long.parseLong(attributeUpdate.getCreatorId()),
                			BSAdminConstants.ENVIRONMENT_PRODUCTION, BSAdminConstants.ATTRIBUTE_EMAIL_NOTIFICATION_SUCCESS,
                			null, null, StringPool.BLANK+attributeUpdate.getSpeardSheetId());
                } else if (BSAdminConstants.STATUS_FAIL.equalsIgnoreCase(attrUpdated.getStatus())) {
                	SpreadSheetAttributeUpdateLocalServiceUtil.sendEmailNotification(Long.parseLong(attributeUpdate.getCreatorId()),
                			BSAdminConstants.ENVIRONMENT_PRODUCTION, BSAdminConstants.ATTRIBUTE_EMAIL_NOTIFICATION_FAIL,
                			BSAdminConstants.ATTRIBUTE_EMAIL_NOTIFICATION_FAIL_MSG, null, StringPool.BLANK+attributeUpdate.getSpeardSheetId());
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
            catch (SystemException e)
            {
            	SpreadSheetAttributeUpdateLocalServiceUtil.sendEmailNotification(Long.parseLong(attributeUpdate.getCreatorId()),
            			BSAdminConstants.ENVIRONMENT_PRODUCTION, BSAdminConstants.ATTRIBUTE_EMAIL_SUPPORT_NOTIFICATION_FAIL,
            			e.toString(), e.toString(), StringPool.BLANK+attributeUpdate.getSpeardSheetId());
            	LOG.error(e.getMessage(), e);
            } catch (Exception e) {
            	LOG.error(e.getMessage(), e);
            }
            finally {
                try
                {
                    if (inputStream != null) {
                        inputStream.close();
                    }
                }
                catch (IOException e)
                {
                    LOG.error(e.getMessage(), e);
                }
            }

        }
    }

    /**
     * 
     * @param attributeUpdate SpreadSheetAttributeUpdate object
     * @param sheet XSSFSheet object
     * @author Chintan Akhani
     */
    private static void processAttributeObject(SpreadSheetAttributeUpdate attributeUpdate, Sheet sheet)
    {
        //Map<String,Long> flags = SpreadSheetAttributeUpdateLocalServiceUtil.getFlagCategories();
        if (sheet.getRow(sheet.getFirstRowNum()).getCell(0) != null
                && sheet.getRow(sheet.getFirstRowNum()).getCell(0).getCellType() == Cell.CELL_TYPE_STRING
                && Validator.isNotNull(sheet.getRow(sheet.getFirstRowNum()).getCell(0).getStringCellValue()))
        {

            AttributeRequestService service = new AttributeRequestService();
            String templateVal = sheet.getRow(sheet.getFirstRowNum()).getCell(0).getStringCellValue();
            String recordId = BSAdminConstants.CONFIGOBJECT_MAP.get(templateVal);
            ReportConfig config = ReportConfigLoader.getReportConfig(BSAdminConstants.CONFIGOBJECT_MAP.get(templateVal));
            List<FieldMapping> index = config.getIndex().getField();
            //TODO get list of standard ids from excelsheet
            List<Long> standardIds = service.getStandardIds(sheet, index, null);
            Map<Long,List<Long>> stdFlagCatgyIds = SpreadSheetAttributeUpdateLocalServiceUtil.getStandardFlagCaterogies(standardIds);
            
            List<FieldMapping> records = config.getRecord().getField();
            int startIndx = config.getIndex().getField().size();
            if (LOG.isDebugEnabled()) {
            	LOG.debug("row count :" + sheet.getPhysicalNumberOfRows());
            }
            String reportRegion = null;
            if (Cell.CELL_TYPE_STRING == sheet.getRow(sheet.getFirstRowNum()).getCell(1).getCellType() && 
            		sheet.getRow(sheet.getFirstRowNum()).getCell(1).getStringCellValue() != null) {
            	reportRegion =  sheet.getRow(sheet.getFirstRowNum()).getCell(1).getStringCellValue();
            }
            
            for (int i = 0; i < sheet.getPhysicalNumberOfRows(); i++)
            {
                if (i > BSAdminConstants.HEADER_ROW_NUM)
                {
                    Row stdRow = sheet.getRow(i);
                    Cell firstCell = null;
                    long stdId = 0l;
                    int indx = 0;
                    String stdType = null;
                    String region = null;
                    
                    for (FieldMapping field : index)
                    {
                        if (STD_ID_COLUMN.equalsIgnoreCase(field.getXlsColumnName()))
                        {
                            firstCell = stdRow.getCell(indx);
                            
                        } else if (STD_TYPE.equalsIgnoreCase(field.getXlsColumnName())) {
                            if (stdRow.getCell(indx) != null) {
                                stdType = stdRow.getCell(indx).getStringCellValue();
                            }
                        } else if (STD_REGION.equals(field.getXlsColumnName()) && stdRow.getCell(indx) != null && 
                        		Cell.CELL_TYPE_STRING == stdRow.getCell(indx).getCellType() && 
                        		stdRow.getCell(indx).getStringCellValue() != null) {
                        	region = stdRow.getCell(indx).getStringCellValue();
                        }
                        if (firstCell != null && stdType != null && region != null) {
                            break;
                        }
                        indx++;
                    }
                    long flagId = 0l;
                    if (Validator.isNotNull(firstCell) && (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                            && Validator.isNotNull(firstCell.getNumericCellValue()) && 
                            (!TYPE_GUIDELINE.equalsIgnoreCase(stdType) || !TEMPLATE_QUALITY.equalsIgnoreCase(recordId)) && 
                            (region.equals(reportRegion) || "GLBL".equals(reportRegion) || Validator.isNull(reportRegion)))
                    {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Standard type :"+stdType+" , template :"+ recordId);
                        }
                        stdId = Math.round(firstCell.getNumericCellValue());
                        
                        List<Long> flagList = stdFlagCatgyIds.get(stdId);//FlagStandardsLocalServiceUtil.getFlagIdsByStdId(stdId);
                        List<Long> flagIds = new LinkedList<Long>();
                        if (flagList != null) {
                            flagIds.addAll(flagList);
                        }
                        int counter = startIndx;
                        for (FieldMapping field : records)
                        {
                            Cell stdCell = stdRow.getCell(counter);
                            String cellValue = null;
                            if (stdCell != null)
                            {
                                cellValue = getCellValue(stdCell);
                            }
                            if (Validator.isNotNull(stdCell) && Validator.isNotNull(cellValue)
                                    && cellValue.equalsIgnoreCase(BSAdminConstants.SELECTED_ATTR))
                            {
                            	if (LOG.isDebugEnabled()) {
                            		LOG.debug("field.getValue() ---" + field.getValue());
                            	}
                            	
                                if (Validator.isNotNull(field.getValue()))
                                {
                                    flagId = field.getValue();

                                    if (flagIds.contains(flagId))
                                    {
                                        if (LOG.isDebugEnabled()) {
                                        	LOG.debug("Flag Id removed:" + flagId);
                                        }
                                        flagIds.remove(flagId);
                                    }
                                    else
                                    {
                                        //flagIds.add(flags.get(columnName));
                                    	FlagStandards flagStandards = FlagStandardsLocalServiceUtil.getFlagStandardsObject();
                                        flagStandards.setStdId(stdId);
                                        flagStandards.setFlagCatId(flagId);
                                        flagStandards.setCreatorId(attributeUpdate.getCreatorId());
                                        flagStandards.setCreatedDate(new Date());
                                        flagStandards.setUpdatedBy(attributeUpdate.getUpdatedBy());
                                        flagStandards.setUpdatedDate(new Date());
                                        try
                                        {
                                            FlagStandardsLocalServiceUtil.addFlagStandards(flagStandards);
                                        }
                                        catch (SystemException e)
                                        {
                                            LOG.error(e.getMessage(), e);
                                        }

                                    }
                                }
                            }
                            counter++;
                        }
                        if (LOG.isDebugEnabled()) {
                        	LOG.debug("flagIds for standard :"+stdId+" : "+ flagIds);
                        }
                        removeFlags(records, flagIds, stdId);
                        //Create an audi log entry for each standard
                        createAudiLog(stdId, attributeUpdate);
                    } else if (Validator.isNotNull(firstCell) && (firstCell.getCellType() == Cell.CELL_TYPE_NUMERIC)
                            && Validator.isNotNull(firstCell.getNumericCellValue())) {
                        if (LOG.isDebugEnabled()) {
                            LOG.debug("Record not processed :"+firstCell.getNumericCellValue());
                        }
                    }
                }
            }
            attributeUpdate.setStatus(BSAdminConstants.PROCESSED);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Record processed ::::");
            }
        }
        else
        {
            attributeUpdate.setStatus(BSAdminConstants.STATUS_FAIL);
            if (LOG.isDebugEnabled()) {
            	LOG.debug("Record failed ::::");
            }
        }
    }
    
    /**
     * 
     * @param stdCell Cell object
     * @return String
     * @author Chintan Akhani
     */
    private static String getCellValue(Cell stdCell)
    {
        String stdValue = StringPool.BLANK;
        if (stdCell.getCellType() == Cell.CELL_TYPE_STRING && Validator.isNotNull(stdCell.getStringCellValue()))
        {
            stdValue = stdCell.getStringCellValue();
        }
        else if (stdCell.getCellType() == Cell.CELL_TYPE_NUMERIC && Validator.isNotNull(stdCell.getNumericCellValue()))
        {
            long tempValue = Math.round(stdCell.getNumericCellValue());
            stdValue = StringPool.BLANK + tempValue;
        }
        return stdValue;
    }

    /**
     * 
     * @param records List object
     * @param flagIds List oject
     * @param stdId Long object
     * @author Chintan Akhani
     */
    private static void removeFlags(List<FieldMapping> records, List<Long> flagIds, long stdId)
    {
        for (FieldMapping field : records)
        {
            if (Validator.isNotNull(field.getValue()) && flagIds.contains(field.getValue()))
            {
                FlagStandards flagListObject = null;
                try
                {
                    flagListObject = FlagStandardsLocalServiceUtil
                            .getFlagStandardByStandardAndCategoryId(stdId, field.getValue());
                    if (Validator.isNotNull(flagListObject))
                    {
                        if (LOG.isDebugEnabled()) {
                        	LOG.debug("Remove flag :" + flagListObject.getFlagCatId());
                        }
                        FlagStandardsLocalServiceUtil.deleteFlagStandards(flagListObject);
                    }
                }
                catch (SystemException e)
                {
                    e.printStackTrace();
                    LOG.error(e.getMessage(), e);
                }
            }
        }
    }
    
    /**
     * 
     * @param stdId Long object
     * @param attributeUpdate SpreadSheetAttributeUpdate object
     * @author Chintan Akhani
     */
    private static void createAudiLog(long stdId, SpreadSheetAttributeUpdate attributeUpdate)
    {
        try
        {
            Standards standards = StandardsLocalServiceUtil.getStandards(stdId);
            long userId = GetterUtil.getLong(attributeUpdate.getUpdatedBy());
            if (Validator.isNotNull(standards) && userId != 0)
            {
                User user = UserLocalServiceUtil.getUser(userId);
                addAuditLogEntry(user, standards, BSAdminConstants.ATTR_UPDATE_COMMENT, null);
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
    }
    
    /**
     * 
     * @param user User object
     * @param standards Standards object
     * @param comments String object
     * @param brandCode String object
     * @return Workflow
     * @author Chintan Akhani
     */
    private static Workflow addAuditLogEntry(final User user, final Standards standards, final String comments,
            final String brandCode)
    {
         Workflow workflow = null;
        try
        {
        	workflow = WorkflowLocalServiceUtil.createWorkflow(CounterLocalServiceUtil.increment(Workflow.class.getName()));
            //workflow.setWorkflowActvtId(workflowId);
            workflow.setObjectId(standards.getStdId());
            workflow.setObjectType(standards.getStdTyp());
            workflow.setStatus(BSAdminConstants.AUDIT_LOG_STATUS);

            workflow.setCreatedBy(user.getScreenName());
            workflow.setUpdatedBy(Long.toString(user.getUserId()));
            workflow.setCreatorId(Long.toString(user.getUserId()));
            workflow.setCreatedDate(new Date());
            workflow.setUpdatedDate(new Date());
            workflow.setComment(comments);
            if (standards.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
            {
                workflow.setTitle(standards.getDescription());
            }
            else
            {
                workflow.setTitle(standards.getTitle());
            }
            if (Validator.isNotNull(brandCode))
            {
                workflow.setChainCode(brandCode);
            }
            WorkflowLocalServiceUtil.addWorkflow(workflow);
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }

        return workflow;
    }
    
    /**
     * Delete processed records
     */
    public static void deleteProcessedRequests () {
        List<SpreadSheetAttributeUpdate> spreadSheetList = SpreadSheetAttributeUpdateLocalServiceUtil
        .getAttributeRequestList(BSAdminConstants.PROCESSED);
        if (LOG.isDebugEnabled()) {
            LOG.debug("Delete attribute scheduler called ::::");
        }
        for (SpreadSheetAttributeUpdate attrUpdate : spreadSheetList) {
            try
            {
                long updatedDate = attrUpdate.getUpdatedDate().getTime();
                long currentTime = new Date().getTime();
                long diff = currentTime - updatedDate;
                long diffDays = diff / (24 * 60 * 60 * 1000);
                if (diffDays >= TOTAL_DAYS) {
                    if (LOG.isDebugEnabled()) {
                        LOG.debug("Delete attribute request :"+attrUpdate.getSpeardSheetId());
                    }
                    SpreadSheetAttributeUpdateLocalServiceUtil.deleteSpreadSheetAttributeUpdate(attrUpdate);
                }
            }
            catch (SystemException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        
    }
}
