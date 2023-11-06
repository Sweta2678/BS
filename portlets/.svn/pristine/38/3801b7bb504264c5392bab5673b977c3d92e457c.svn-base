package com.ihg.brandstandards.gem.process.impl;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.GEMTemplateColumn;
import com.ihg.brandstandards.db.model.GEMTemplateReference;
import com.ihg.brandstandards.db.model.impl.GEMTemplateColumnImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateImpl;
import com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceImpl;
import com.ihg.brandstandards.db.service.GEMTemplateColumnLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateReferenceLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTriggerLocalServiceUtil;
import com.ihg.brandstandards.gem.process.Processor;
import com.ihg.brandstandards.gem.util.GemCategoryPortletUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.util.BSCommonUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.User;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

/**
 * 
 * @author AkhaniC
 *
 */
public class TemplateProcessor implements Processor {

	private Log LOG = LogFactoryUtil.getLog(TemplateProcessor.class);
	
	@Override
	public long processTemplate (File file,
			String templateType, String title, long publishId, long publishDepartmentId, long regionId,
			long userId, boolean processValues, int headerColumn) {
		
		boolean isConfigurationAdded = false;
		long templateId = 0;
		InputStream inputStream = null;
		try {
			inputStream = new FileInputStream(file);
			//get template object
			GEMTemplate template = createTemplate(inputStream, templateType, title, publishId, publishDepartmentId, regionId, userId);
			if(GemConstants.TEMPLATE_TYPE_SA.equals(templateType) || GemConstants.TEMPLATE_TYPE_SE.equals(templateType)){
				new GemCategoryPortletUtil().processGEMCategoryExcelSheet(template.getTemplateId(), templateType, file, title, String.valueOf(userId), "Catgy");
			}
			if (Validator.isNotNull(template)) {
				Workbook workbook = WorkbookFactory.create(inputStream);
				inputStream.close();
				Sheet sheet = workbook.getSheetAt(0);
				if (validateTemplate(sheet)) {
					//Add configuration from database
					List<GEMTemplateColumn> columns = processHeader(sheet, template, headerColumn);
					if(processValues)
					{
						processValues(columns, sheet, headerColumn+1, templateType, publishId, publishDepartmentId);
					}
				}
				isConfigurationAdded = true;
				if(isConfigurationAdded){
					return template.getTemplateId();
				}
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		} finally {
			if (inputStream != null) {
				try {
					inputStream.close();
				} catch (IOException e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
		return templateId;
	}
	
	protected List<GEMTemplateColumn> processHeader(Sheet sheet, GEMTemplate template, int headerColumn)
	{
		List<GEMTemplateColumn> columns = new LinkedList<GEMTemplateColumn>();
		Iterator<Cell> columnList = sheet.getRow(headerColumn).cellIterator();
		Cell header = null;
		long displayOrderNumber = 0l;
		while (columnList.hasNext()) {
			header = columnList.next();
			if (Validator.isNotNull(header))  {
				//&& Validator.isNotNull(header.getStringCellValue())
				if (Validator.isNull(header.getStringCellValue())) {
					if (LOG.isDebugEnabled()) {
						LOG.debug("Blank record");
					}
					columns.add(addColumn(template, GemConstants.BLANK_RECORD_VAL, displayOrderNumber));
				} else if (header.getCellType() == Cell.CELL_TYPE_STRING) {
				columns.add(addColumn(template, header.getStringCellValue(), displayOrderNumber));
				}
			}
			displayOrderNumber++;
		}
		return columns;
	}

	/**
	 * 
	 * @param type
	 * @param regionId
	 * @param publishId
	 * @return GEMTemplate
	 */
	protected List<GEMTemplate> findTemplateByTypeAndRegionAndPublication (String type, long regionId, long publishId) {
		List<GEMTemplate> templateList = null;
		try {
			templateList = GEMTemplateLocalServiceUtil.getByTypeAndRegionAndPublicationList(type, regionId, publishId);
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		return templateList;
	}
	
	/**
	 * 
	 * @param inputStream
	 * @param templateType
	 * @param title
	 * @param publishId
	 * @param publishDeptId
	 * @param regionId
	 * @param userId
	 * @return GEMTemplate
	 */
	protected GEMTemplate createTemplate (InputStream inputStream,
			String templateType, String title, long publishId, long publishDeptId, long regionId,
			long userId) {
		GEMTemplate gemTemplate = null;
		List<GEMTemplate> templateList = findTemplateByTypeAndRegionAndPublication(templateType, regionId, publishId);
		if (templateList != null && templateList.size() > 0) {
			for(GEMTemplate template : templateList){
				try {
					//This should be a cascade delete
					GEMTemplateLocalServiceUtil.deleteTemplateConfigurations(template.getTemplateId());
				} catch (Exception e) {
					LOG.error(e.getMessage(), e);
				}
			}
		}
		try {
			//Add template
			gemTemplate = new GEMTemplateImpl();
			gemTemplate.setTemplateId(GEMTemplateLocalServiceUtil.getSequenceNumber(GemConstants.GEM_TEMPLATE_SEQUECNE));
			gemTemplate.setTemplateType(templateType);
			gemTemplate.setTemplateName(title);
			gemTemplate.setRegionId(regionId);
			gemTemplate.setPublishId(publishId);
			gemTemplate.setCreatedDate(new Date());
			gemTemplate.setUpdatedDate(new Date());
			gemTemplate.setCreatorId(StringPool.BLANK+userId);
			gemTemplate.setUpdatedBy(StringPool.BLANK+userId);
			GEMTemplateLocalServiceUtil.addGEMTemplate(gemTemplate);
			if (LOG.isDebugEnabled()) {
				LOG.debug("GEM template added for publish id : "+publishId +" and regionId : "+regionId);
			}
			//Add template reference into Template refrence table.
			GEMTemplateReference gemTemplateReference =  new GEMTemplateReferenceImpl();
			gemTemplateReference.setTemplateRefId(GEMTemplateLocalServiceUtil.getSequenceNumber(GemConstants.GEM_TEMPLATE_REF_SEQUECNE));
			gemTemplateReference.setTemplateId(gemTemplate.getTemplateId());
			gemTemplateReference.setRegionId(regionId);
			gemTemplateReference.setPublishDeptId(publishId);
			gemTemplateReference.setPublishDeptId(publishDeptId);
			gemTemplateReference.setCreatedDate(new Date());
			gemTemplateReference.setCreatorId(StringPool.BLANK+userId);
			gemTemplateReference.setUpdatedDate(new Date());
			gemTemplateReference.setUpdatedBy(StringPool.BLANK+userId);
			GEMTemplateReferenceLocalServiceUtil.addGEMTemplateReference(gemTemplateReference);
			if (LOG.isDebugEnabled()) {
				LOG.debug("GEM template ref added for publis department id :"+gemTemplateReference.getPublishDeptId());
			}
			
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
		}
		
		return gemTemplate;
	}
	
	/**
	 * 
	 * @param columnName
	 * @param template
	 */
	protected GEMTemplateColumn addColumn (GEMTemplate template, String columnName, long columnOrderNumber) 
	{
		GEMTemplateColumn column = null;
		try {
			column = new GEMTemplateColumnImpl();
			column.setColumnId(GEMTemplateLocalServiceUtil.getSequenceNumber(GemConstants.GEM_TEMPLATE_COLUMN_SEQUECNE));
			column.setColumnName(columnName);
			column.setDefaultValue(null);
			column.setDisplayOrderNumber(columnOrderNumber);
			//TODO Just to avoid constraint error 
			column.setIsMandatory(" ");
			column.setTemplateId(template.getTemplateId());
			column.setUpdatedBy(template.getUpdatedBy());
			column.setCreatorId(template.getCreatorId());
			column.setCreatedDate(new Date());
			column.setUpdatedDate(new Date());
			GEMTemplateColumnLocalServiceUtil.addGEMTemplateColumn(column);
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
		return column;
	}
	
	/**
	 * 
	 * @param workbook
	 * @return boolean
	 */
	private boolean validateTemplate (Sheet sheet) {
		boolean isValid = true;
		if (sheet == null) {
			isValid = false;
		}
		return isValid;
	}

	/**
	 * @param template
	 * @return boolean
	 */
	@Override
	public boolean deleteConfiguration(String template) {
		
		return false;
	}
	
	public void processValues(List<GEMTemplateColumn> columns, Sheet sheet, int valueRow, String templateType, 
			long publishId, long publishDepartmentId)
	{
		DataFormatter defaultDataFormat = new DataFormatter();
	    int rows = sheet.getPhysicalNumberOfRows();
	    long displaOrderNumber = 1l;
	    Cell cell = null;
		String cellValue = null;
	    String triggerQuestion = null;
        for (int rowIndx = valueRow; rowIndx < rows; rowIndx++)
        {
			Row row = sheet.getRow(rowIndx);
			cell = null;
			triggerQuestion = null;
			
			for (int i = 0; i < columns.size(); i++) {
				cellValue = null;
				
				GEMTemplateColumn column = columns.get(i);
				//TODO Have added an entry with 0 as primary key into gem_catgy table, instead of 1 we are passing 0 as a default category Id here. If ctegory Id is not required for each value record then we will remove it in phase 2.
				if (row.getCell(i) != null) {
					cell = row.getCell(i);

					if (cell.getCellType() == Cell.CELL_TYPE_BLANK) {
						if (LOG.isDebugEnabled()) {
							LOG.debug("Blank record");
						}
						cellValue = GemConstants.BLANK_RECORD_VAL;
					} else if (cell.getCellType() == Cell.CELL_TYPE_BOOLEAN) {
						cellValue = StringPool.BLANK+cell.getBooleanCellValue();
					} else if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
						cellValue = defaultDataFormat.formatCellValue(cell);
						//cellValue = StringPool.BLANK + cell.getNumericCellValue();
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING
			                && Validator.isNull(cell.getStringCellValue())) {
						if (LOG.isDebugEnabled()) {
							LOG.debug("Blank record");
						}						
						cellValue = GemConstants.BLANK_RECORD_VAL;
					} else if (cell.getCellType() == Cell.CELL_TYPE_STRING
			                && Validator.isNotNull(cell.getStringCellValue())) {
						cellValue = cell.getStringCellValue();
					}
					if(GemConstants.TEMPLATE_TYPE_SE.equals(templateType)){
						//Trigger Question logic to add Trigger Question while importing SE Template
						if(column.getColumnName().equalsIgnoreCase(GemConstants.TEMPLATE_COLUMN_ITEM_TEXT)){
							triggerQuestion = cellValue;
						} else if(column.getColumnName().equalsIgnoreCase(GemConstants.TEMPLATE_COLUMN_TRIGGER) 
								&& !cellValue.equals(GemConstants.BLANK_RECORD_VAL) && Validator.isNotNull(cellValue.trim())){
							//Add/Update Trigger Question to GEM_TRIGGER Table
							try {
								GEMTriggerLocalServiceUtil.addTriggerIfNotExist(publishId, publishDepartmentId, triggerQuestion, column.getCreatorId());
							} catch (SystemException e) {
								LOG.error("Failed to add/Update trigger question");
							}
						}
					}
					addValue (cellValue, column, 0l, displaOrderNumber);
				} else {
					addValue (GemConstants.BLANK_RECORD_VAL, column, 0l, displaOrderNumber);
				}
			}
			displaOrderNumber++;
        }
	}
	
	/**
	 * 
	 * @param columnNames
	 * @param template
	 */
	protected void addValue (String valueString, GEMTemplateColumn column, long categoryId, long orderNum) {
		try {
			GEMTemplateLocalServiceUtil.insertTemplateValueUsingSequence(column.getColumnId(), valueString, categoryId, orderNum, column.getCreatorId());
		} catch (Exception e) {
			LOG.error(e.getMessage(), e);
			LOG.error("Error column :"+column.getColumnId() +" -- category :"+categoryId+"-- display order "+
			orderNum);
		} 
	}

	@Override
	public void addMessageInQueue(String messageType, long publishId, String groupType, String manualType, 
			Preferences preferences, User user) {
		//Get regionId
		long regionId = BrandStandardsUtil.getRegionId(preferences.getRegionCode());
		if (GemConstants.JOB_TYPE_COUNTRY_GROUP.equals(messageType)) {
			createOrUpdateUniqueCountryGroup(publishId, regionId, groupType, manualType, preferences, user);
		}
	}
	
	/**
	 * 
	 * @param publishId
	 * @param preferences
	 * @param user
	 * @return boolean
	 */
	protected void createOrUpdateUniqueCountryGroup (long publishId, long regionId, String groupType, String manualType, 
			Preferences preferences, User user) {
		Message message = new Message();
		message.put("requestType", GemConstants.JOB_TYPE_COUNTRY_GROUP);
		message.put("preferences", preferences);
		message.put("user", user);
		message.put("publishId", publishId);
		message.put("regionId", regionId);
		message.put("groupType", groupType);
		message.put("manualType", manualType);
		MessageBusUtil.sendMessage(GemConstants.GEM_MESSAGE_DESTINATION, message);
	}
	
	/**
     * 
     * @param brandCode
     * @param regionCode
     * @param regionId
     * @param publishId
     * @param userFullName
     * @param screenName
     * @param email
     * @return StringBuilder
     */
	@Override
	public String generateMetadata (String brandCode, String regionCode, long regionId, 
    		long publishId, String groupType, String manualType, String userFullName) {
    	String metadata = null;
		
    		Map<String, String> metadataParams = new LinkedHashMap<String, String>();
    		//Generate Map
    		metadataParams.put(BridgeConstants.METADATA_PARAM_ENVIRONMENT, BridgeConstants.BRIDGE_GROUPS_TYPE.equals(groupType) ? BridgeConstants.BRIDGE_ENVIRONMENT : GemConstants.GEM_ENVIRONMENT);
            metadataParams.put(BridgeConstants.BRIDGE_GROUPS_TYPE.equals(groupType) ? BridgeConstants.METADATA_PARAM_BRIDGE_PUBLISH_ID : BridgeConstants.METADATA_PARAM_GEM_PUBLISH_ID, String.valueOf(publishId));
            metadataParams.put(BridgeConstants.METADATA_PARAM_CHAIN_CD, brandCode);
            metadataParams.put(BridgeConstants.METADATA_PARAM_PUBLISH_CONTENT_TYPE, manualType);
            metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_CD, regionCode);
            metadataParams.put(BridgeConstants.METADATA_PARAM_REGION_ID, String.valueOf(regionId));
            metadataParams.put(BridgeConstants.METADATA_PARAM_GROUP_TYPE, groupType);
            metadataParams.put(BridgeConstants.METADATA_PARAM_USER_NAME, userFullName);
    		metadata = BSCommonUtil.buildJobQueueMetadataXML(GemConstants.JOB_TYPE_COUNTRY_GROUP, 
    					metadataParams, null, null);
    	
		return metadata;
    }
	
}