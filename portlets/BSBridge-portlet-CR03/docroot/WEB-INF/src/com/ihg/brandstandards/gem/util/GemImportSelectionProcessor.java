package com.ihg.brandstandards.gem.util;

import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import org.apache.commons.lang.StringUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.gem.portlet.GEMImportSelectionPortlet;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;

public class GemImportSelectionProcessor {
	private static final Log LOGGER = LogFactoryUtil.getLog(GEMImportSelectionPortlet.class);
    private static final String NO_DATA_IN_FIRST_ROW = " does not have any data in first row.";
	private static final String EMPTY_CELL = "Empty Cell";
	private static final String HENCE_IGNORED = ". Hence Ignored.";
	private static final String INVALID_COLUMN = " has invalid column Name:";
	private static final String HAS = " has ";
    private static final String EXCEL_DATE_FORMAT = "dd-MMM-yyyy";
    private static final String DB_DATE_FORMAT = "dd-MMM-yyyy";
    private static final String ROW_END = "</td></tr>";
    private static final String ERROR_ROW_START = "<tr><td><font color=\"red\"> Sheet:";
    private static final String WARN_ROW_START = "<tr><td><font color=\"orange\"> Sheet:";
    private static final String REG_ROW_START = "<tr><td><font color=\"black\"> Sheet:";
    private static final String PROCESS_START = " processing started.</td></tr>";
    private static final String PROCESS_COMPLETE = " processing completed.</td></tr>";
    private static final String SHEET_IGNORED = " is ignored.</td></tr>";
    private static final String STR_ROW = " Row:";
    private static final String STR_STD = " STD ID:";
    private static final String STR_COL = " Column:";
    private static final int BATCH_UPDATE_SIZE = 1000;
    private static final String VALID_HEADERS = "STD ID,STD_ID,Category Heading,Reporting Category,Criticality,Sequence No,Due Date";
    int stdIdCellIndex = -1;
    int categoryHeadingCellIndex = -1;
    int reportingCategoryCellIndex = -1;
    int criticalityCellIndex= -1;
    int seqNoCellIndex = -1;
    int dueDateCellIndex = -1;
    int emptyRowCounter = 0;
    private String sheetName;
  //  private String chainCode;
    List<String> gemImportSelectionQueries = new ArrayList<String>();
    private StringBuffer processLog = new StringBuffer();
	
	long GEM_PUBLISH_ID;
	long DEPARTMENT_ID;
	//long REGION_ID;
	String REGION_CD;
	long SE_TEMP_ID;
	 public String processImport(String chainCode,String regionCode,long dept,InputStream inputFile, Publication publication,long templateId)throws ImportExcelGeneralException
	 {
		
		// Publication publication =  PublishDeptLocalServiceUtil.getAcitveDepartmentPublication(dept, chainCode);
		                            //PublishDeptLocalServiceUtil.getAcitveDepartmentPublication(departmentId, brandCode);
		 this.GEM_PUBLISH_ID=publication.getPublishId();
		 this.DEPARTMENT_ID=dept;
		 this.REGION_CD= regionCode;
		 this.SE_TEMP_ID= templateId;//getTemplateId(GEM_PUBLISH_ID, StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode), GemConstants.SE_REPORT_TYPE);
		 processLog.append("<br><br><table border=\"1\">");
 	
	 	try {
	 		Workbook workbook = WorkbookFactory.create(inputFile);
	 		FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
				int noOfSheets = workbook.getNumberOfSheets();
				for(int i = 0; i < noOfSheets; i++){
					Sheet sheet = workbook.getSheetAt(i);
				    sheetName = sheet.getSheetName();
				
					if(Validator.isNotNull(chainCode)){
						if(!sheetName.toLowerCase().contains("ignore")){
							LOGGER.debug(sheetName+" processing started.");
							processLog.append(REG_ROW_START).append(sheetName).append(PROCESS_START);
						//	emailProcessLog.append(REG_ROW_START).append(sheetName).append(PROCESS_START);
							processSpreadsheet(sheet, evaluator);
					        LOGGER.debug("sheetName:"+sheetName+" ChainCode:"+chainCode+" rows:"+sheet.getPhysicalNumberOfRows());
					        LOGGER.debug(" No Of CMS Update Queries:"+gemImportSelectionQueries.size());
					        /** Executing Compliance/Expiry Updates on CMS */
					        int queryCounter = 0;
					        StringBuffer sqlProcedure = null;
					        for(String updtQuery : gemImportSelectionQueries){
					        	if(queryCounter == 0){
					        		sqlProcedure = new StringBuffer();
					        		sqlProcedure.append("DECLARE l_ctry_attr_cnt NUMBER := 0; BEGIN ");
					        	}
					        	sqlProcedure.append(updtQuery);
					        	queryCounter++;
					        	
					        	if(queryCounter >= BATCH_UPDATE_SIZE || queryCounter >= gemImportSelectionQueries.size()){
					        		sqlProcedure.append(" COMMIT; END;");
					        		LOGGER.debug("Executing batch of "+ queryCounter +" update statements");
					        		queryCounter = 0;
					        		try {
//TODO:					        			publishStandardDBService.updateComplianceDates(sqlProcedure.toString());
					        			GEMQlReportLocalServiceUtil.executeSelectImportProcedure(sqlProcedure.toString());
					        		} catch(Exception e){
					        			processLog.append("Failed to execute Import selection update statemets on GEM. Error Log:").append(e.getMessage());
					        			processLog.append("Failed GEM Query: ").append(sqlProcedure.toString());
					        	//		emailProcessLog.append("Failed to execute Compliance/Expiry update statemets on CMS. Error Log:").append(e.getMessage());
					        	//TODO:		throw new GenericJobException("Failed to execute Compliance/Expiry update statemets on CMS", e);
					        		}
					        	}
					        }
							processLog.append(REG_ROW_START).append(sheetName).append(PROCESS_COMPLETE);
							//emailProcessLog.append(REG_ROW_START).append(sheetName).append(PROCESS_COMPLETE);
							//emailProcessLog.append(ROW_DIVIDER);
						} else {
							/**Sheet Marked for Ignore*/
							processLog.append(WARN_ROW_START).append(sheetName).append(SHEET_IGNORED);
							//emailProcessLog.append(WARN_ROW_START).append(sheetName).append(SHEET_IGNORED);
							//emailProcessLog.append(ROW_DIVIDER);
						}
					} else {
						processLog.append(ERROR_ROW_START).append(sheetName).append(" has invalid brand code. Hence not processed this sheet.</td></tr>");
						//emailProcessLog.append(ERROR_ROW_START).append(sheetName).append(" has invalid brand code. Hence not processed this sheet.</td></tr>");
						//emailProcessLog.append(ROW_DIVIDER);
					}
				}
			} catch (Exception e) {
				//LOGGER.error("Failed to process Compliance excel sheet", e);
				throw new ImportExcelGeneralException("Failed to process Import selection excel sheet", e);
			} finally{
		        processLog.append("</table>");
				LOGGER.debug("Compliance Import XLS Process Log:::"+processLog.toString());
			}
	   //  emailProcessLog.append("</table>");
	     return processLog.toString();
	 }
	 
	 
	 public void processSpreadsheet(Sheet sheet, FormulaEvaluator evaluator)
	         throws InvalidFormatException, ImportExcelGeneralException {
	 	
	 	gemImportSelectionQueries = new ArrayList<String>();
	 	stdIdCellIndex = -1;
	    categoryHeadingCellIndex = -1;
	    reportingCategoryCellIndex = -1;
	    criticalityCellIndex= -1;
	    seqNoCellIndex = -1;
	    dueDateCellIndex = -1;
	     emptyRowCounter = 0;
	     
	     int noOfRows = sheet.getPhysicalNumberOfRows();
	     Row headerRow = sheet.getRow(0);
	     if (headerRow != null) {
	         int columnCount = headerRow.getPhysicalNumberOfCells();
	         Map<String, String> headerColumns = getXlsHeaderColumns(evaluator, headerRow, columnCount);
	         int noOfColumns = headerColumns.size();
	         boolean hasValidHeaders = validateExcelHeaders(headerColumns);
	        // Map<String, String> compareCompliance = new HashMap<String, String>();
	         if(hasValidHeaders) {
	         	/** Getting all the Compliance/Expiry records exist in the system in a Map to compare before update **/ 
	         //	String compareQuery = new QueryGenerator().getComplianceCompareQuery(chainCode, whereToUpdate, whatToUpdate);
	         //	compareCompliance = standardsDAO.compareComplianceStandards(compareQuery);
	         	
	         	for (int rowIndx = 1; rowIndx < noOfRows; rowIndx++) {
	         		Row dataRow = sheet.getRow(rowIndx);
	         		/** If sheet has 10 empty rows continuously then skip remaining rows assuming remaining rows are empty.*/
	         		if(emptyRowCounter >= 10) {
	         			LOGGER.error("COMPLIANCE IMPORT SHEET IS EMPTY OR MORE THEN 10 ROWS CONTINUOUSLY ARE EMPTY. HENCE SKIPPED PROCESSING REMAINING ROWS ASSUMING THEY WILL BE EMPTY.");
	         			break;
	         		}
	     			if(dataRow != null && !checkIfRowIsEmpty(dataRow)) {
		            	String stdId = getCellData(evaluator, dataRow.getCell(stdIdCellIndex));
	         			String catgryHeading = getCellData(evaluator,dataRow.getCell(categoryHeadingCellIndex));
	         			String reportingCategory = getCellData(evaluator, dataRow.getCell(reportingCategoryCellIndex));
	         			String criticality = getCellData(evaluator, dataRow.getCell(criticalityCellIndex));
	         			int seqNo = GetterUtil.getInteger(getCellData(evaluator, dataRow.getCell(seqNoCellIndex)));
	         			String dueDate = getCellData(evaluator, dataRow.getCell(dueDateCellIndex));
	         			if(Validator.isNotNull(stdId) && Validator.isNotNull(catgryHeading) && Validator.isNotNull(reportingCategory)){
		        			if(Validator.isNull(criticality)){
		        				criticality="0";
		        			}
		        			if(Validator.isNull(seqNo)){
		        				seqNo=0;
		        			}
		        			if(Validator.isNull(dueDate)){
		        				dueDate="01 Month";
		        			}
		        				gemImportSelectionQueries.add(getImportSelctionQuery(stdId, catgryHeading, reportingCategory, criticality, seqNo, dueDate));
	        				
		        		} else {
		        			/** Cell has invalid action value */
		        			processLog.append(WARN_ROW_START).append(sheetName).append(STR_ROW).append(rowIndx).append(STR_STD).append(stdId).append(STR_COL);
		        			//processLog.append((stdIdCellIndex+1)).append(HAS).append(((actionCellValue == null || actionCellValue.isEmpty()) ? EMPTY_CELL : actionCellValue)).append(HENCE_IGNORED).append(ROW_END);
		        		}
	     			}
	             }
	         }else{
	        	 throw new ImportExcelGeneralException("uploaded excel have not valid columns!");
	         }
	     }
	     else
	     {
	     	processLog.append(ERROR_ROW_START).append(sheetName).append(NO_DATA_IN_FIRST_ROW).append(ROW_END);
	         throw new ImportExcelGeneralException("Spreadsheet is empty!");
	     }
	 }
	 
	 public Map<String, String> getXlsHeaderColumns(FormulaEvaluator evaluator, Row row, int columnCount)
	    {
	    	Map<String, String> headerColumns = new LinkedHashMap<String, String>();
	        for (int colIndex = 0; colIndex < columnCount; colIndex++)
	        {
	            Cell cell = row.getCell(colIndex);
	            String value = getCellData(evaluator, cell);
	            headerColumns.put(String.valueOf(colIndex), value);
	            if(value.equalsIgnoreCase("STD_ID") || value.equalsIgnoreCase("STD ID")){
	            	this.stdIdCellIndex = colIndex;
	            }
	            if(value.equalsIgnoreCase("Category Heading")){
	            	this.categoryHeadingCellIndex = colIndex;
	            }
	            if(value.equalsIgnoreCase("Reporting Category")){
	            	this.reportingCategoryCellIndex = colIndex;
	            }
	            if(value.equalsIgnoreCase("Criticality")){
	            	this.criticalityCellIndex = colIndex;
	            }
	            if(value.equalsIgnoreCase("Sequence No")){
	            	this.seqNoCellIndex = colIndex;
	            }
	            if(value.equalsIgnoreCase("Due Date")){
	            	this.dueDateCellIndex = colIndex;
	            }
	        }
	        
	        
	        return headerColumns;
	    }
	    
	    private boolean validateExcelHeaders(Map<String, String> headerColumns)
	    {
	    	boolean checkValidColumns = false;
	    	boolean hasValidHeaders = true;
	    	for(Entry<String, String> entry : headerColumns.entrySet()){
	    		if(checkValidColumns){
	    			if(!VALID_HEADERS.contains(entry.getValue())){
	    				processLog.append(ERROR_ROW_START).append(sheetName).append(INVALID_COLUMN).append(entry.getValue()).append(ROW_END);
	    				hasValidHeaders = false;
	    			}
	    		}
	    		if(entry.getValue().equalsIgnoreCase("STD ID") || entry.getValue().equalsIgnoreCase("STD_ID"))
	    		{
	    			checkValidColumns = true;
	    		}
	    	}
	    	return hasValidHeaders;
		}
	 
	    private String getCellData(FormulaEvaluator evaluator, Cell cell)
	    {
	        String value = null;
	        if (cell != null) {
	            int cellType = cell.getCellType();
	            switch (cellType) {
		            case Cell.CELL_TYPE_BLANK:
		            	value = "";
		                break;
		            case Cell.CELL_TYPE_NUMERIC:
		                if (DateUtil.isCellDateFormatted(cell)) {
		                    Date date = cell.getDateCellValue();
		                    value = date.toString();
		                } else {
		                    value = String.valueOf(new BigDecimal(cell.getNumericCellValue()));
		                }
		                break;
		            case Cell.CELL_TYPE_STRING:
		                value = cell.getStringCellValue().trim();
		                break;
		            case Cell.CELL_TYPE_FORMULA:
		                // evaluates a given cell, and returns the new value, without affecting the cell
		                // CellValue cellValue = evaluator.evaluate(cell);
		                // The value for the formula is saved alongside it, to be displayed in excel. The formula remains in the cell, just with a new value
		                switch (evaluator.evaluateFormulaCell(cell)) {
		                	case Cell.CELL_TYPE_BLANK:
		                		value = "";
		                		break;
		                	case Cell.CELL_TYPE_NUMERIC:
		                		if (DateUtil.isCellDateFormatted(cell)) {
		                			Date date = cell.getDateCellValue();
		                			value = date.toString();
		                		} else {
		                			value = String.valueOf(cell.getNumericCellValue());
		                		}
		                		break;
		                	case Cell.CELL_TYPE_STRING:
		                		value = cell.getStringCellValue().trim();
		                		break;
				                // CELL_TYPE_FORMULA will never happen
				                case Cell.CELL_TYPE_FORMULA:
				                    break;
				                case Cell.CELL_TYPE_BOOLEAN:
				                    value = String.valueOf(cell.getBooleanCellValue());
				                    break;
				                case Cell.CELL_TYPE_ERROR:
				                    value = "";
				                    break;
				                default:
				                    value = "";
				                    LOGGER.warn("Compliance Import:Unknown formula cell type" + cell.getCellType());
				                    break;
		                }
		                break;
		            case Cell.CELL_TYPE_BOOLEAN:
		                value = String.valueOf(cell.getBooleanCellValue());
		                break;
		            case Cell.CELL_TYPE_ERROR:
		                value = "";
		                break;
		            default:
		                value = "";
		                LOGGER.warn("UI Element Import:Unknown cell type" + cellType);
		                break;
	            }
	        }
	        return value;
	    }
	    private boolean checkIfRowIsEmpty(Row row) {
	        if (row == null) {
	            return true;
	        }
	        if (row.getLastCellNum() <= 0) {
	            return true;
	        }
	        boolean isEmptyRow = true;
	        for (int cellNum = row.getFirstCellNum(); cellNum < row.getLastCellNum(); cellNum++) {
	            Cell cell = row.getCell(cellNum);
	            if (cell != null && cell.getCellType() != Cell.CELL_TYPE_BLANK && StringUtils.isNotBlank(cell.toString())) {
	                isEmptyRow = false;
	            }
	        }
	        /** If continuously has empty rows then only increment counter */
	        if(isEmptyRow){
	        	emptyRowCounter++;
	        } else {
	        	emptyRowCounter = 0;
	        }
	        return isEmptyRow;
	    }

	    private String getImportSelctionQuery(String stdId, String ctryHeading, String reportinCategory, String criticality, int seqNo,String dueDate){
	    	StringBuilder sqlQuery = new StringBuilder();
	    	
	    	
	    	sqlQuery.append(" UPDATE qlty_lead_rpt SET");
	    	sqlQuery.append(" GEM_MGT_BUCKET_ID=(SELECT GEM_MGT_BUCKET_ID FROM GEM_MGT_BUCKET WHERE GEM_BUCKET_NM='");
	    	sqlQuery.append(reportinCategory).append("'  AND GEM_DEPT_ID=").append(DEPARTMENT_ID);
	    	sqlQuery.append(" ),GEM_SEVERITY_ID=(SELECT GEM_SEVERITY_ID FROM GEM_SEVERITY WHERE GEM_SEVERITY_NM='");
	    	sqlQuery.append(criticality);
	    	sqlQuery.append("' ), GEM_CATGY_ID=(SELECT c.GEM_CATGY_ID FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND c.GEM_CATGY_NM='");
	    	sqlQuery.append(ctryHeading);
	    	sqlQuery.append("'),GEM_MSRMNT_ID=(SELECT NVL((SELECT gem_msrmnt_id FROM gem_msrmnt WHERE gem_template_id = ");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND gem_msrmnt_nm=(SELECT c.gem_catgy_nm FROM gem_catgy c, gem_template_catgy tc WHERE c.gem_catgy_id = tc.gem_catgy_id AND tc.duplicatable_ind = 'Y' AND ");
	    	sqlQuery.append(" (c.gem_prnt_catgy_id = (SELECT DISTINCT c1.gem_prnt_catgy_id FROM gem_catgy c1, gem_template_catgy tc1 WHERE tc1.gem_template_id =");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND c1.gem_catgy_id = tc1.gem_catgy_id AND c1.gem_catgy_id = (SELECT c.GEM_CATGY_ID FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc");
	    	sqlQuery.append(" WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND c.GEM_CATGY_NM='");
	    	sqlQuery.append(ctryHeading);
	    	sqlQuery.append("')) OR c.gem_catgy_cd = (SELECT DISTINCT c1.gem_prnt_catgy_id FROM gem_catgy c1, gem_template_catgy tc1 WHERE tc1.gem_template_id = ");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND c1.gem_catgy_id = tc1.gem_catgy_id AND c1.gem_catgy_id = (SELECT c.GEM_CATGY_ID FROM GEM_CATGY c, GEM_TEMPLATE_CATGY tc WHERE c.GEM_CATGY_ID=tc.GEM_CATGY_ID AND tc.GEM_TEMPLATE_ID=");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(" AND c.GEM_CATGY_NM='");
	    	sqlQuery.append(ctryHeading);
	    	sqlQuery.append("'))) AND rownum = 1)), (SELECT gem_msrmnt_id FROM gem_msrmnt WHERE gem_msrmnt_typ_cd = 'SEVERITY_OTHER' AND gem_template_id = ");
	    	sqlQuery.append(SE_TEMP_ID);
	    	sqlQuery.append(")) FROM DUAL),DISP_ORDER_NBR=");
	    	sqlQuery.append(seqNo);
	    	sqlQuery.append(",CMPLY_DUE_DY_QTY=(SELECT NVL((SELECT gem_cd FROM gem_cd WHERE lower(gem_cd_val) = lower('").append(dueDate).append("')), 14) AS GEM_CD FROM DUAL)");
	    	sqlQuery.append(" WHERE publish_id=");
	    	sqlQuery.append(GEM_PUBLISH_ID);
	    	sqlQuery.append(" AND GEM_PUBLISH_DEPT_ID=(SELECT gem_publish_dept_id FROM gem_publish_dept WHERE publish_id=");
	    	sqlQuery.append(GEM_PUBLISH_ID);
	    	sqlQuery.append(") AND rgn_id=(SELECT RGN_ID FROM BRNDSTND_RGN WHERE RGN_CD='");
	    	sqlQuery.append(REGION_CD);
	    	sqlQuery.append("'  AND PRNT_RGN_ID IS NULL) AND STD_ID=");
	    	sqlQuery.append(stdId);
	    	sqlQuery.append(" AND (select std_typ from std where std_id=qlty_lead_rpt.std_id)!='GDLN';");
			return sqlQuery.toString();
	    }
	    private long getTemplateId(long publishId, long regionId, String templType)
	    {
	        long templateId = 0;
	        try
	        {
	            List<GEMTemplate> list = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(publishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
	            if(list != null && !list.isEmpty())
	            {
	                templateId = list.get(0).getTemplateId();
	            }
	        }
	        catch (SystemException e)
	        {
	            LOGGER.error("Failed to get " + templType + " temlates:" + e);
	        }
	        return templateId;
	    }
	    public boolean clearSelection(Publication publication,String regionCode,long dept){
	    	StringBuilder sqlQuery = new StringBuilder();
	    	sqlQuery.append("BEGIN UPDATE qlty_lead_rpt SET");
	    	sqlQuery.append(" GEM_MGT_BUCKET_ID=0, GEM_SEVERITY_ID=0, GEM_CATGY_ID=0, GEM_MSRMNT_ID=0, DISP_ORDER_NBR=0,");
	    	sqlQuery.append(" CMPLY_DUE_DY_QTY=(SELECT gem_cd FROM gem_cd WHERE lower(gem_cd_val) = lower('01 Month'))");
	    	sqlQuery.append(" WHERE publish_id=").append(publication.getPublishId()).append(" AND GEM_PUBLISH_DEPT_ID=(SELECT gem_publish_dept_id FROM gem_publish_dept WHERE publish_id=");
	    	sqlQuery.append(publication.getPublishId()).append(" ) AND rgn_id=(SELECT RGN_ID FROM BRNDSTND_RGN WHERE RGN_CD='");
	    	sqlQuery.append(regionCode).append("' AND PRNT_RGN_ID is null)  AND (select std_typ from std where std_id= qlty_lead_rpt.std_id)!='GDLN'; COMMIT; END;");
	    	return GEMQlReportLocalServiceUtil.executeSelectImportProcedure(sqlQuery.toString());
	    }
}
