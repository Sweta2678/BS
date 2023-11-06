/**
 * ©2015 IHG. All rights reserved.
 */
package com.ihg.brandstandards.gem.process;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import com.ihg.brandstandards.bridge.model.BadCell;
import com.ihg.brandstandards.bridge.model.Record;
import com.ihg.brandstandards.bridge.model.XlsModelData;
import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.spreadsheet.mapping.XLSRecordMappingFactory;
import com.ihg.brandstandards.spreadsheet.mapping.XlsFieldMapping;
import com.ihg.brandstandards.spreadsheet.mapping.XlsRecordMapping;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * <a href="GEMCategoryProcessXLSFile.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class GEMCategoryProcessXLSFile
{
    private static final Log LOG = LogFactoryUtil.getLog(GEMCategoryProcessXLSFile.class);
    private char[] alpha = { 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T',
            'U', 'V', 'W', 'X', 'Y', 'Z' };
    private List<String> invalidRecordId;
    private List<Integer> invalidRow;

    /**
     * This method will process excel sheet for GEM Category Module.
     * 
     * @param xlsFile
     * @return
     * @throws InvalidFormatException
     * @throws IOException
     * @throws JAXBException
     */
    public List<Record> processGEMCategorytXls(File xlsFile) throws Exception
    {
        List<Record> records = null;
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("resources/xls_standards_mapping.xml");
        invalidRecordId = new ArrayList<String>();
        invalidRow = new ArrayList<Integer>();
        List<String> requiredHeader = new ArrayList<String>();
        XlsRecordMapping mapping = XLSRecordMappingFactory.getMapping(inputStream, "GEMCategory");
        
        for (XlsFieldMapping xlsMapping : mapping.getXlsField())
        {
            requiredHeader.add(xlsMapping.getXlsName());
        }

        List<XlsModelData> data = processSpreadsheet(xlsFile, requiredHeader, "Categories");
        XlsModelData xlsHeader = getXlsHeaderRow(data);
        // we don't need header any more
        data.remove(xlsHeader);
        records = createRecords(mapping, data, xlsHeader);
        return records;
    }
    
    /**
     * This method will process excel sheet for GEM Category Module.
     * 
     * @param xlsFile
     * @return
     * @throws InvalidFormatException
     * @throws IOException
     * @throws JAXBException
     */
    public List<Record> processGEMStdCategorytXls(File xlsFile) throws Exception
    {
        List<Record> records = null;
        ClassLoader classLoader = getClass().getClassLoader();
        InputStream inputStream = classLoader.getResourceAsStream("resources/xls_standards_mapping.xml");
        invalidRecordId = new ArrayList<String>();
        invalidRow = new ArrayList<Integer>();
        List<String> requiredHeader = new ArrayList<String>();
        XlsRecordMapping mapping = XLSRecordMappingFactory.getMapping(inputStream, "GEMStdCategory");
        
        for (XlsFieldMapping xlsMapping : mapping.getXlsField())
        {
            requiredHeader.add(xlsMapping.getXlsName());
        }

        List<XlsModelData> data = processSpreadsheet(xlsFile, requiredHeader, "MASTER");
        XlsModelData xlsHeader = getXlsHeaderRow(data);
        // we don't need header any more
        data.remove(xlsHeader);
        records = createRecords(mapping, data, xlsHeader);
        return records;
    }

    public List<XlsModelData> processSpreadsheet(File xlsFile, List<String> requiredHeader, String sheetName) throws InvalidFormatException, IOException {
        List<XlsModelData> xlsModels = new ArrayList<XlsModelData>();
        Workbook workbook = WorkbookFactory.create(xlsFile);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        // data should be always on first sheet
        //Sheet sheet = workbook.getSheetAt(0);
        Sheet sheet = workbook.getSheet(sheetName);//"Categories");
        int rows = sheet.getPhysicalNumberOfRows();

        if (workbook instanceof XSSFWorkbook)
        {
            //LOG.info("UI Element Import: The XSSFWorkbook was created");
        }
        else if (workbook instanceof HSSFWorkbook)
        {
            //LOG.info("UI Element Import: The HSSFWorkbook was created");
        }
        /*LOG.info("PhysicalNumberOfRows is " + rows + " first row number is " + sheet.getFirstRowNum() + " last row number is "
                + sheet.getLastRowNum());*/

        // map header column number to column name
        Row row = sheet.getRow(0);
        List<String> excelHeaderColNames = new ArrayList<String>();
        if (row != null)
        {
            // grab number of columns from first row - it is header row.
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            XlsModelData model = getXlsHeader(evaluator, row, columnCount);
            
            for (Object values : model.getProperties().values())
            {
                if (values != null){
                    excelHeaderColNames.add(values.toString());
                }
            }
            validateExcelHeaders(requiredHeader, excelHeaderColNames, model);
            xlsModels.add(model);

            for (int rowIndx = 1; rowIndx < rows; rowIndx++)
            {
                row = sheet.getRow(rowIndx);
                if (row != null)
                {
                    model = getRowData(evaluator, row, columnCount);
                    model.setWorksheet(sheet.getSheetName());
                    model.setRow(rowIndx);
                    xlsModels.add(model);
                }
                /*percentage = Math.min(10 + (rowIndx * 25) / rows, 25);
                if (!(oldpercentage == percentage))
                {
                    progressTracker.setPercent(percentage);
                }
                oldpercentage = percentage;*/
            }
        }
        else
        {
            throw new IOException("Spreadsheet is empty!");
        }
        return xlsModels;
    }

    public void validateExcelHeaders(List<String> requiredHeader, List<String> excelHeaderColNames, XlsModelData model) throws IOException 
    {
        if (!excelHeaderColNames.containsAll(requiredHeader))
        {
            throw new IOException("Spreadsheet headers not matched!");
        }
    }

    protected List<Record> createRecords(Map<String, XlsRecordMapping> mapping, List<XlsModelData> data, XlsModelData xlsHeader)
    {
        List<Record> recordList = new ArrayList<Record>();
        for (XlsModelData xlsRec : data)
        {

            String type = xlsRec.getType();
            XlsRecordMapping map = mapping.get(type);
            if (map != null)
            {
                Record rec = createRecord(xlsRec, type, xlsHeader, map);
                recordList.add(rec);
            }
            else
            {
                String errorMessage = "Mapping not found for record type=" + type + " row=" + xlsRec.getRow() + " id = "
                        + xlsRec.getId() + " parent id=" + xlsRec.getParentId();
                BadCell badCell = new BadCell();
                badCell.setRow(xlsRec.getRow());
                badCell.setWorksheet(xlsRec.getWorksheet());
                badCell.setErrorMessage(errorMessage);
                Record rec = new Record();
                rec.setValid(false);
                rec.addBadCell(badCell);
                recordList.add(rec);
            }

        }
        return recordList;
    }

    protected List<Record> createRecords(XlsRecordMapping map, List<XlsModelData> data, XlsModelData xlsHeader)
    {
        List<Record> recordList = new ArrayList<Record>();
        for (XlsModelData xlsRec : data)
        {

            String type = xlsRec.getType();
            if (map != null)
            {
                Record rec = createRecord(xlsRec, type, xlsHeader, map);
                recordList.add(rec);
            }
            else
            {
                String errorMessage = "Mapping not found for record type=" + type + " row=" + xlsRec.getRow() + " id = "
                        + xlsRec.getId() + " parent id=" + xlsRec.getParentId();
                BadCell badCell = new BadCell();
                badCell.setRow(xlsRec.getRow());
                badCell.setWorksheet(xlsRec.getWorksheet());
                badCell.setErrorMessage(errorMessage);
                Record rec = new Record();
                rec.setValid(false);
                rec.addBadCell(badCell);
                recordList.add(rec);
            }
        }
        return recordList;
    }

    protected Record createRecord(XlsModelData xlsRec, String type, XlsModelData xlsHeader, XlsRecordMapping map)
    {
        Record rec = new Record();
        rec.setType(type);
        rec.setId(xlsRec.getId());
        rec.setParentId(xlsRec.getParentId() == null ? "0" : xlsRec.getParentId());
        rec.setName(map.getName());
        rec.setClassName(map.getClassName());

        // populate fields for record
        for (int i = 0; i < xlsRec.getColumnCount(); i++)
        {
            String col = "c_" + i;
            String fieldDesc = (String) xlsHeader.get(col);
            List<XlsFieldMapping> fieldsMapping = map.getXlsField();
            createFields(xlsRec, rec, col, fieldDesc, fieldsMapping, i);
        }

        return rec;
    }

    protected void createFields(XlsModelData xlsRec, Record record, String col, String fieldDesc,
            List<XlsFieldMapping> fieldsMapping, int colIndx)
    {
        for (XlsFieldMapping mapping : fieldsMapping)
        {
            if (mapping.getXlsName().equals(fieldDesc))
            {
                Record field = new Record();
                field.setClassName(mapping.getClassName());
                field.setFieldName(mapping.getClassFieldName());
                field.setName(mapping.getName());
                field.setType(mapping.getType());
                field.setRequired(mapping.isRequired() == null ? false : mapping.isRequired());
                field.setMultivalue(mapping.isMultiValue() == null ? false : mapping.isMultiValue());
                field.setEncodeValue(mapping.isEncodeValue() == null ? false : mapping.isEncodeValue());
                field.setValue(xlsRec.get(col));
                field.setColumnName(formatColumnName(fieldDesc, colIndx));
                field.setRow(xlsRec.getRow());

                record.addField(mapping.getClassName(), field);
                validateField(mapping, xlsRec, field, record, colIndx);
                break;
            }
        }
    }

    protected XlsModelData getXlsHeaderRow(List<XlsModelData> data) throws InvalidFormatException
    {
        XlsModelData xlsHeader = null;
        if (BridgeConstants.XLS_HEADER_TYPE.equals(data.get(0).getType()))
        {
            xlsHeader = data.get(0);
        }
        else
        {
            for (XlsModelData record : data)
            {
                if (BridgeConstants.XLS_HEADER_TYPE.equals(record.getType()))
                {
                    xlsHeader = record;
                    break;
                }
            }

            if (xlsHeader == null)
                throw new InvalidFormatException("Header NOT fount in spreadsheet!");
        }
        return xlsHeader;
    }

    private XlsModelData getXlsHeader(FormulaEvaluator evaluator, Row row, int columnCount)
    {
        XlsModelData model = getRowData(evaluator, row, columnCount);
        model.setType(BridgeConstants.XLS_HEADER_TYPE);
        model.setName(BridgeConstants.COLUMN_NUM_TO_HEADER_MAPPING);
        model.setId(null);
        model.setParentId(null);
        model.setValid(true);
        model.setRow(0);
        model.setColumnCount(columnCount);
        return model;
    }

    private XlsModelData getRowData(FormulaEvaluator evaluator, Row row, int columnCount)
    {
        XlsModelData model = new XlsModelData();
        model.setColumnCount(columnCount);
        for (int c = 0; c < columnCount; c++)
        {
            Cell cell = row.getCell(c);
            Object value = getCellData(evaluator, cell);
            model.set("c_" + c, value);
            if (c == 0)
            {
                if (value != null)
                {
                    model.setId(value.toString());
                }
            }
        }
        return model;
    }

    private Object getCellData(FormulaEvaluator evaluator, Cell cell)
    {
        String value = null;
        if (cell != null)
        {
            int cellType = cell.getCellType();
            switch (cellType)
            {
            case Cell.CELL_TYPE_BLANK:
                value = "";
                break;
            case Cell.CELL_TYPE_NUMERIC:
                if (DateUtil.isCellDateFormatted(cell))
                {
                    Date date = cell.getDateCellValue();
                    value = date.toString();
                }
                else
                {
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
                switch (evaluator.evaluateFormulaCell(cell))
                {
                case Cell.CELL_TYPE_BLANK:
                    value = "";
                    break;
                case Cell.CELL_TYPE_NUMERIC:
                    if (DateUtil.isCellDateFormatted(cell))
                    {
                        Date date = cell.getDateCellValue();
                        value = date.toString();
                    }
                    else
                    {
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
                    LOG.warn("UI Element Import:Unknown formula cell type" + cell.getCellType());
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
                LOG.warn("UI Element Import:Unknown cell type" + cellType);
                break;
            }
        }
        return value;
    }

    public List<Record> getBadRows(List<Record> recordList)
    {
        List<Record> badRecords = new ArrayList<Record>();
        for (Record rec : recordList)
        {
            if (!rec.isValid())
            {
                badRecords.add(rec);
            }
        }
        return badRecords;
    }

    private void validateField(XlsFieldMapping mapping, XlsModelData xlsRec, Record field, Record record, int colIndx)
    {
        boolean isRequired = field.isRequired();
        Object val = field.getValue();
        String errMsg = null;

        if (isRequired && val == null)
        {
            field.setValid(false);
            LOG.error("UI Element Import: Missing Required fieldvalue:" + record.getId());
            errMsg = "Required field is missing value for record type=" + record.getType() + " id=" + record.getId();
            // + " parent id=" + record.getParentId();
        }
        /** Validating Element Key field */
        /*if (field.getColumnName().contains("Element Key") && val != null && !autoCreateElements)
        {
            if (uiElementKeys != null && !uiElementKeys.contains(val))
            {
                field.setValid(false);
                LOG.error("UI Element Import: UI Element does not exist in database for Element Key=" + record.getId());
                errMsg = "UI Element does not exist in database for Element Key:" + record.getId();
            }
        }*/
        
        /** Validating Used In field */
        /*if(field.getColumnName().contains("Used In")){
            if(val == null){
                field.setValid(false);
                LOG.error("UI Element Import: UI Element Used In information is null for Element Key=" + record.getId());
                errMsg = "UI Element Used In information is null for Element Key:" + record.getId();
            } else{
                String values[] = String.valueOf(val).split(",");
                String usedInOptionValues[] = PortletProps.get("bs.usedin.options.values").split(StringPool.COMMA);
                
                for(String value:values){
                    boolean matchOption = false;
                    for(String option:usedInOptionValues){
                        if(option.trim().equalsIgnoreCase(value.trim())){
                            matchOption = true;
                        }
                    }
                    if(!matchOption){
                        field.setValid(false);
                        LOG.error("UI Element Import: Used In information is not matching with the modules available in system for Element Key=" + record.getId());
                        errMsg = "Used In information is not matching with the modules available in system for Element Key:" + record.getId();
                    }
                }
            }
        }*/

        if (field.isValid() && !record.getParentId().equals("0"))
        {
            if (invalidRecordId.contains(record.getParentId()))
            {
                field.setValid(false);
                LOG.error("UI ELement Import: Invalid Parent record:" + record.getId());
                errMsg = "Parent record is invalid for type=" + record.getType() + " id=" + record.getId() + " parent id="
                        + record.getParentId();
            }
        }

        if (!field.isValid() && !invalidRow.contains(xlsRec.getRow()))
        {
            record.setValid(false);
            LOG.error("UI Element Import: Invalid record:"+ colIndx);
            BadCell badCell = new BadCell(xlsRec.getWorksheet(), xlsRec.getRow(), colIndx, field.getValue(),
                    field.getColumnName(), errMsg);
            record.addBadCell(badCell);
            if (record.getParentId().equals("0") && !invalidRecordId.contains(record.getId()))
            {
                invalidRecordId.add(record.getId());
            }
            invalidRow.add(xlsRec.getRow());
        }
    }

    private String formatColumnName(String s, int col)
    {
        if (s == null || s.length() == 0)
        {
            s = "Column";
        }
        return s + " (" + alpha(col) + ")";
    }

    private String alpha(int n)
    {
        int letter = n % 26;
        String s = "" + alpha[letter];
        int count = (n / 26);
        for (int i = 0; i < count; i++)
        {
            s += alpha[letter];
        }
        return s;
    }
}
