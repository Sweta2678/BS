package com.ihg.brandstandards.gem.util;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import com.ihg.brandstandards.bridge.model.BadCell;
import com.ihg.brandstandards.bridge.model.Record;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.GEMCategory;
import com.ihg.brandstandards.db.model.GEMMeasurement;
import com.ihg.brandstandards.db.model.GEMStdCategory;
import com.ihg.brandstandards.db.model.GEMTemplateCategory;
import com.ihg.brandstandards.db.service.GEMCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMMeasurementLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMStdCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.gem.process.GEMCategoryProcessXLSFile;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class GemCategoryPortletUtil {
	
	private static final Log LOG = LogFactoryUtil.getLog(GemCategoryPortletUtil.class);

	/**
     * @param file  The XLS File Object
     * @param fileName  The XLS File Name
     * @param creatorId  The user id
     * @throws Exception
     */
    public JSONObject processGEMCategoryExcelSheet(long templateId, String templateType, File file, String fileName, String creatorId, String importType) throws Exception {
        JSONObject recordsjsonObject = null;
        GEMCategoryProcessXLSFile processXlsFile = new GEMCategoryProcessXLSFile();
        List<Record> records = new ArrayList<Record>();
        if("Catgy".equals(importType)){
        	records = processXlsFile.processGEMCategorytXls(file);
        } else {
        	records = processXlsFile.processGEMStdCategorytXls(file);
        }
        List<Record> badRecords = processXlsFile.getBadRows(records);
        if (badRecords.size() > 0) {
            //return it in GUI
            recordsjsonObject = JSONFactoryUtil.createJSONObject();
            JSONArray rowjsonObject = null;
            JSONObject cell = null;
            JSONArray recordsjsonArray = JSONFactoryUtil.createJSONArray();
            recordsjsonObject.put("page", "1");
            double totalPages = Math.ceil(badRecords.size() / (double) BridgeConstants.MAGIC_TEN);
            recordsjsonObject.put("total", String.valueOf(totalPages));
            recordsjsonObject.put("records ", String.valueOf(badRecords.size()));
            if (!badRecords.isEmpty()) {
                for (int i = 0; i < badRecords.size(); i++) {
                    Record record = badRecords.get(i);
                    rowjsonObject = JSONFactoryUtil.createJSONArray();
                    cell = JSONFactoryUtil.createJSONObject();
                    rowjsonObject.put(String.valueOf(record.getId()));
                    List<BadCell> cells = record.getBadCell();
                    for (BadCell cell1 : cells) {
                        LOG.error("Row = " + cell1.getRow() + "' column name = '" + cell1.getColumnName() + "' worksheet = '"
                                + cell1.getWorksheet() + "' error message = '" + cell1.getErrorMessage() + "' value = '"
                                + cell1.getValue() + "'");
                        rowjsonObject.put(String.valueOf(cell1.getRow()));
                        rowjsonObject.put(String.valueOf(cell1.getColumnName()));
                        rowjsonObject.put(String.valueOf(cell1.getValue()));
                        rowjsonObject.put(String.valueOf(cell1.getErrorMessage()));
                    }
                    cell.put("id", String.valueOf(record.getId()));
                    cell.put("cell", rowjsonObject);
                    recordsjsonArray.put(cell);
                }
                recordsjsonObject.put("rows", recordsjsonArray);
            }
        } else {
        	if("Catgy".equals(importType)){
        		updateGemCategories(templateId, records, creatorId);
        		if(GemConstants.TEMPLATE_TYPE_SE.equals(templateType)){
        			try {
						updateMeasurementCategories(templateId, creatorId);
					} catch (Exception e) {
						LOG.error("Failed to Add/Update GEM Measurement Categories");
					}
        		}
        	} else {
        		updateGemStdCategoryMapping("SA", "EX", records, creatorId);
            }
        }
        return recordsjsonObject;
    }
    
    /**
     * 
     * @param recordList
     * @param creatorId
     */
	public void updateGemCategories(long templateId, List<Record> recordList, String creatorId){
		int displayOrderNumber = 1;
		for (Record record : recordList) {
            if (Validator.isNotNull(record.getId())) {
                GEMCategory gemCategory = null;
                String gemCategoryId = record.getId();
                try {
                    try {
                        gemCategory = GEMCategoryLocalServiceUtil.getByGEMCategoryId(gemCategoryId);
                    } catch (Exception e1) {
                        LOG.error("Import: No Category exist with categoryId:" + gemCategoryId);
                    }
                    if (gemCategory == null) {
                        try {
                        	gemCategory = GEMCategoryLocalServiceUtil.createGEMCategory(
                        			GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_CATGY_ID_SEQ"));
                        	for (Record cell : record.getFields().get("GEMCategory")) {
                        		if ("gemCategoryId".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
    	                    		gemCategory.setGemCategoryCode(String.valueOf(cell.getValue()).trim());
                        		} else if("gemPrntCategoryId".equalsIgnoreCase(cell.getFieldName())) {
    	                        	if(Validator.isNotNull(String.valueOf(cell.getValue()).trim())) {
    	                        		gemCategory.setGemPrntCategoryId(String.valueOf(cell.getValue()).trim());
    	                        	} else {
    	                        		gemCategory.setGemPrntCategoryId("-1");
    	                        	}
                        		} else if("categoryName".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
        	                        gemCategory.setCategoryName(String.valueOf(cell.getValue()).trim());
                        		} else if("categoryViewType".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
        	                        gemCategory.setCategoryViewType(String.valueOf(cell.getValue()).trim());
                        		} else if("categoryAnsAll".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
        	                        gemCategory.setCategoryAnsAll(String.valueOf(cell.getValue()).trim());
                        		} else if("duplicatable".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
        	                        gemCategory.setDuplicatable(String.valueOf(cell.getValue()).trim());
                        		} /*else if("gemCategoryId".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
        	                        gemCategory.setOrderNumber(Long.valueOf(String.valueOf(cell.getValue()).trim()));
                        		}*/
                        	}
                    		gemCategory.setDisplayOrderNumber(displayOrderNumber);
                    		gemCategory.setCmsCategoryId(GEMCategoryLocalServiceUtil.getGEMMappingCMSCategoryId(GemConstants.CMS_LOOKUP_CATEGORY_IDS, gemCategory.getCategoryName()));
                        	
                        	gemCategory.setCreatorId(creatorId);
                        	gemCategory.setCreatedDate(new Date());
                        	gemCategory.setUpdatedBy(creatorId);
                        	gemCategory.setUpdatedDate(new Date());
                        	gemCategory = GEMCategoryLocalServiceUtil.updateGEMCategory(gemCategory);
                            if (LOG.isDebugEnabled()) {
                            	LOG.debug("Created Category: categoryId=" + gemCategory.getCategoryId() + " gemCategoryId=" + gemCategory.getGemCategoryCode() 
                                		+ " gemPrntCategoryId="+gemCategory.getGemPrntCategoryId() + " categoryName=" + gemCategory.getCategoryName() );
                            }
                            /** Update template category mapping table. */
                            if(templateId > 0){
                            	GEMTemplateCategory gemTemplateCategory = GEMTemplateCategoryLocalServiceUtil.createGEMTemplateCategory(
                            			GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_TEMPLATE_CATGY_ID_SEQ"));
                            	gemTemplateCategory.setTemplateId(templateId);
                            	gemTemplateCategory.setCategoryId(gemCategory.getCategoryId());
                            	gemTemplateCategory.setCategoryViewType(gemCategory.getCategoryViewType());
                            	gemTemplateCategory.setCategoryAnsAll(gemCategory.getCategoryAnsAll());
                            	if(gemCategory.getDuplicatable().equalsIgnoreCase("yes")){
                            		gemTemplateCategory.setDuplicatable("Y");
                            	} else {
                            		gemTemplateCategory.setDuplicatable("N");
                            	}
                            	gemTemplateCategory.setDisplayOrderNumber(displayOrderNumber);
                            	
                            	gemTemplateCategory.setCreatorId(creatorId);
                            	gemTemplateCategory.setCreatedDate(new Date());
                            	gemTemplateCategory.setUpdatedBy(creatorId);
                            	gemTemplateCategory.setUpdatedDate(new Date());
                            	gemTemplateCategory = GEMTemplateCategoryLocalServiceUtil.updateGEMTemplateCategory(gemTemplateCategory);
                            }
                            displayOrderNumber++;
                        } catch (Exception e) {
                            LOG.error("Failed to create Category", e);
                        }
                    } else {
                    	try
                    	{
	                    	/** Updating Section */
	                    	for (Record cell : record.getFields().get("GEMCategory")) {
	                    		if ("gemCategoryId".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
		                    		gemCategory.setGemCategoryCode(String.valueOf(cell.getValue()).trim());
	                    		} else if("gemPrntCategoryId".equalsIgnoreCase(cell.getFieldName())) {
	                    			if(Validator.isNotNull(String.valueOf(cell.getValue()).trim())) {	
	                    				gemCategory.setGemPrntCategoryId(String.valueOf(cell.getValue()).trim());
		                        	} else {
		                        		gemCategory.setGemPrntCategoryId("-1");
		                        	}
	                    		} else if("categoryName".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
	    	                        gemCategory.setCategoryName(String.valueOf(cell.getValue()).trim());
	                    		} else if("categoryViewType".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
	    	                        gemCategory.setCategoryViewType(String.valueOf(cell.getValue()).trim());
	                    		} else if("categoryAnsAll".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
	    	                        gemCategory.setCategoryAnsAll(String.valueOf(cell.getValue()).trim());
	                    		} else if("duplicatable".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
	    	                        gemCategory.setDuplicatable(String.valueOf(cell.getValue()).trim());
	                    		} /*else if("gemCategoryId".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
	    	                        gemCategory.setOrderNumber(Long.valueOf(String.valueOf(cell.getValue()).trim()));
	                    		}*/
	                    	}
	                		gemCategory.setCmsCategoryId(GEMCategoryLocalServiceUtil.getGEMMappingCMSCategoryId(GemConstants.CMS_LOOKUP_CATEGORY_IDS, gemCategory.getCategoryName()));
	                		
	                        gemCategory.setUpdatedBy(creatorId);
	                        gemCategory.setUpdatedDate(new Date());
	                        GEMCategoryLocalServiceUtil.updateGEMCategory(gemCategory);
	                        if (LOG.isDebugEnabled()) {
	                        	LOG.debug("Updated Category: categoryId=" + gemCategory.getCategoryId() + " gemCategoryId=" + gemCategory.getGemCategoryCode() 
	                            		+ " gemPrntCategoryId="+gemCategory.getGemPrntCategoryId() + " categoryName=" + gemCategory.getCategoryName() );
	                        }
	
	                        /** Update template category mapping table. */
	                        if(templateId > 0){
	                        	GEMTemplateCategory gemTemplateCategory = GEMTemplateCategoryLocalServiceUtil.createGEMTemplateCategory(
	                        			GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_TEMPLATE_CATGY_ID_SEQ"));
	                        	gemTemplateCategory.setTemplateId(templateId);
	                        	gemTemplateCategory.setCategoryId(gemCategory.getCategoryId());
                            	gemTemplateCategory.setCategoryViewType(gemCategory.getCategoryViewType());
                            	gemTemplateCategory.setCategoryAnsAll(gemCategory.getCategoryAnsAll());
                            	if(gemCategory.getDuplicatable().equalsIgnoreCase("yes")){
                            		gemTemplateCategory.setDuplicatable("Y");
                            	} else {
                            		gemTemplateCategory.setDuplicatable("N");
                            	}
	                        	gemTemplateCategory.setDisplayOrderNumber(displayOrderNumber);
	                        	
	                        	gemTemplateCategory.setCreatorId(creatorId);
	                        	gemTemplateCategory.setCreatedDate(new Date());
	                        	gemTemplateCategory.setUpdatedBy(creatorId);
	                        	gemTemplateCategory.setUpdatedDate(new Date());
	                        	gemTemplateCategory = GEMTemplateCategoryLocalServiceUtil.updateGEMTemplateCategory(gemTemplateCategory);
	                        }
	                        displayOrderNumber++;
                    	} catch (Exception e){
                    		LOG.error("Failed to update Category", e);
                    	}
                    }
                }
                catch (Exception e)
                {
                    LOG.error("Failed to create Element and default translation.", e);
                }
            }
        }
	}
	
	public void updateMeasurementCategories(long templateId, String creatorId){
		GEMMeasurement gemMeasurement = null;
		int dispOrderNoCounter = 1;
		//Add/Update Other category first
		try {
			gemMeasurement = GEMMeasurementLocalServiceUtil.getByNameTypeAndTemplateId("Other", "SEVERITY_OTHER", templateId);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		if(gemMeasurement == null) {
			try {
				GEMMeasurementLocalServiceUtil.addGEMMeasurement("Other", "SEVERITY_OTHER", templateId, creatorId, dispOrderNoCounter);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		} else {
			try {
				gemMeasurement.setDisplayOrderNumber(dispOrderNoCounter);
				GEMMeasurementLocalServiceUtil.updateGEMMeasurement(gemMeasurement);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
		dispOrderNoCounter++;
		//Add/Update GEM Categories
		Map<Long, String> qlCategoriesMap = GEMCategoryLocalServiceUtil.getScoringSECategories(templateId);
		for(Entry<Long, String> categoryEntry : qlCategoriesMap.entrySet()) {
			try {
				gemMeasurement = null;
				gemMeasurement = GEMMeasurementLocalServiceUtil.getByNameTypeAndTemplateId(categoryEntry.getValue(), "SEVERITY_OTHER", templateId);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			if(gemMeasurement == null){
				try {
					GEMMeasurementLocalServiceUtil.addGEMMeasurement(categoryEntry.getValue(), "SEVERITY", templateId, creatorId, dispOrderNoCounter);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			} else {
				try {
					gemMeasurement.setDisplayOrderNumber(dispOrderNoCounter);
					GEMMeasurementLocalServiceUtil.updateGEMMeasurement(gemMeasurement);
				} catch (Exception e) {
					LOG.error(e.getMessage());
				}
			}
			dispOrderNoCounter++;
		}
		
		//Add/Update SEVERITY_TRIGGET
		try {
			gemMeasurement = null;
			gemMeasurement = GEMMeasurementLocalServiceUtil.getByNameTypeAndTemplateId("Trigger Q's", "SEVERITY_TRIGGET", templateId);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		if(gemMeasurement == null) {
			try {
				GEMMeasurementLocalServiceUtil.addGEMMeasurement("Trigger Q's", "SEVERITY_TRIGGET", templateId, creatorId, dispOrderNoCounter);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		} else {
			try {
				gemMeasurement.setDisplayOrderNumber(dispOrderNoCounter);
				GEMMeasurementLocalServiceUtil.updateGEMMeasurement(gemMeasurement);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
		dispOrderNoCounter++;
		
		//Add/Update SEVERITY_CMPL_DT
		try {
			gemMeasurement = null;
			gemMeasurement = GEMMeasurementLocalServiceUtil.getByNameTypeAndTemplateId("Future Compliance Date", "SEVERITY_CMPL_DT", templateId);
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		if(gemMeasurement == null) {
			try {
				GEMMeasurementLocalServiceUtil.addGEMMeasurement("Future Compliance Date", "SEVERITY_CMPL_DT", templateId, creatorId, dispOrderNoCounter);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		} else {
			try {
				gemMeasurement.setDisplayOrderNumber(dispOrderNoCounter);
				GEMMeasurementLocalServiceUtil.updateGEMMeasurement(gemMeasurement);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
		}
	}
	
	/**
     * 
     * @param recordList
     * @param userId
     */
	public void updateGemStdCategoryMapping(String templateType, String chainCode, List<Record> recordList, String userId){
		for (Record record : recordList) {
            if (Validator.isNotNull(record.getId())) {
                GEMStdCategory gemStdCategory = null;
                //String gemCategoryId = record.getId();
                try {
                	long stdId = 0;
                	String categoryName = null;
                	for (Record cell : record.getFields().get("GEMCategory")) {
                		if ("stdId".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
                			stdId = Long.parseLong(String.valueOf(cell.getValue()).trim());
                		} else if("categoryName".equalsIgnoreCase(cell.getFieldName()) && Validator.isNotNull(cell.getValue())) {
                			categoryName = String.valueOf(cell.getValue()).trim();
                		}
                	}
                	
                	if(stdId > 0 && Validator.isNotNull(categoryName)){
                    	List<GEMCategory> categoryList = GEMCategoryLocalServiceUtil.getByCategoryName(categoryName);
            			if(categoryList != null && categoryList.size() > 0){
            				for(GEMCategory category : categoryList){
            					try {
									gemStdCategory = GEMStdCategoryLocalServiceUtil.getByStdCatgyMapping(stdId, category.getCategoryId(), templateType, chainCode);
								} catch (Exception e) {
									LOG.error("===================>No Mapping Exist for StdId:"+stdId+" and Category Name:"+categoryName);
								}
            					if(gemStdCategory == null){
            						gemStdCategory = GEMStdCategoryLocalServiceUtil.createGEMStdCategory(
    	                        			GEMTemplateLocalServiceUtil.getSequenceNumber("GEM_STD_CATGY_ID_SEQ"));
            						gemStdCategory.setStdId(stdId);
            						gemStdCategory.setCategoryId(category.getCategoryId());
            						gemStdCategory.setTemplateType(templateType);
            						gemStdCategory.setChainCode(chainCode);
            						
            						gemStdCategory.setCreatorId(userId);
                                	gemStdCategory.setCreatedDate(new Date());
                                	gemStdCategory.setUpdatedBy(userId);
                                	gemStdCategory.setUpdatedDate(new Date());
                                	gemStdCategory = GEMStdCategoryLocalServiceUtil.updateGEMStdCategory(gemStdCategory);
            					}
            					
            				}
            			} else {
            				LOG.error("############################################");
            				LOG.error("No Category Exist with name:"+categoryName+" to maps standard:"+stdId);
            				LOG.error("############################################");
            			}
                	}
                    if (LOG.isDebugEnabled()) {
                    	LOG.debug("Created standard and Category mapping: StdId=" + gemStdCategory.getStdId() + " categoryId=" + gemStdCategory.getCategoryId() 
                        		+ " categoryName=" + categoryName + " TemplateType="+gemStdCategory.getTemplateType() + " ChainCode="+gemStdCategory.getChainCode() );
                    }
                    
                } catch (Exception e) {
                    LOG.error("Failed to import Standard and Category mapping data", e);
                }
            }
        }
	}

}
