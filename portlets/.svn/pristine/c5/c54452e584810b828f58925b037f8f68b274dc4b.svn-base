package com.ihg.brandstandards.spreadsheet;

import java.io.File;
import java.io.IOException;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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

import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.bsadmin.model.XlsModelData;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ProgressTracker;

public class XlsSheetIterator
{
    private File fileName;
    private static final Log LOG = LogFactoryUtil.getLog(XlsSheetIterator.class);
    /**
     * Creates a new XLSX -> CSV converter
     * 
     * @param pkg The XLSX package to process
     * @param output The PrintStream to output the CSV to
     */
    public XlsSheetIterator(File fileName)
    {
        this.fileName = fileName;
    }
    
    public List<XlsModelData> processSpreadsheet() throws InvalidFormatException, IOException
    {
        List<XlsModelData> xlsModels = new ArrayList<XlsModelData>();
        Workbook workbook = WorkbookFactory.create(fileName);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        // data should be always on first sheet
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();

        if (workbook instanceof XSSFWorkbook){
            if(LOG.isDebugEnabled()){
                LOG.debug("The XSSFWorkbook was created");
            }
        } else if (workbook instanceof HSSFWorkbook){
            if(LOG.isDebugEnabled()){
                LOG.debug("The HSSFWorkbook was created");
            }
        }

        if(LOG.isDebugEnabled()){
            LOG.debug("PhysicalNumberOfRows is " + rows + " first row number is " + sheet.getFirstRowNum()
                + " last row number is " + sheet.getLastRowNum() + "\n");
        }
        // map header column number to column name
        Row row = sheet.getRow(0);
        if (row != null)
        {
            // grab number of columns from first row - it is header row.
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            XlsModelData model = getXlsHeader(evaluator, row, columnCount);
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
            }
        }
        else
        {
            throw new IOException("Spreadsheet is empty!");
        }
        return xlsModels;
    }


    public List<XlsModelData> processSpreadsheet( List<String> requiredHeader,ProgressTracker progressTracker) throws InvalidFormatException, IOException
    {
        List<XlsModelData> xlsModels = new ArrayList<XlsModelData>();
        int percentage = 10;
        int oldpercentage=10;
        Workbook workbook = WorkbookFactory.create(fileName);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        // data should be always on first sheet
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();

        if (workbook instanceof XSSFWorkbook){
            if(LOG.isDebugEnabled()){
                LOG.debug("The XSSFWorkbook was created");
            }
        } else if (workbook instanceof HSSFWorkbook){
            if(LOG.isDebugEnabled()){
                LOG.debug("The HSSFWorkbook was created");
            }
        }
        if(LOG.isDebugEnabled()){
            LOG.debug("PhysicalNumberOfRows is " + rows + " first row number is " + sheet.getFirstRowNum()
                + " last row number is " + sheet.getLastRowNum() + "\n");
        }
        // map header column number to column name
        Row row = sheet.getRow(0);
        List<String> excelHeaderColNames=new ArrayList<String>();
        if (row != null)
        {
            // grab number of columns from first row - it is header row.
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            XlsModelData model = getXlsHeader(evaluator, row, columnCount);
            
            for (Object values: model.getProperties().values())
            {
            	if(values!=null) 
            	excelHeaderColNames.add(values.toString());
            }
            if(!excelHeaderColNames.containsAll(requiredHeader))
            {
            	throw new IOException("Spreadsheet headers not matched!");
            }
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
                 percentage = Math.min(10 + (rowIndx * 25) / rows, 25);
                 if(!(oldpercentage==percentage))
                 progressTracker.setPercent(percentage);
                 oldpercentage=percentage;
            }
        }
        else
        {
            throw new IOException("Spreadsheet is empty!");
        }
        return xlsModels;
    }

    private XlsModelData getXlsHeader(FormulaEvaluator evaluator, Row row, int columnCount)
    {
        XlsModelData model = getRowData(evaluator, row, columnCount);
        model.setType(BSAdminConstants.XLS_HEADER_TYPE);
        model.setName(BSAdminConstants.COLUMN_NUM_TO_HEADER_MAPPING);
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
            /*else if (c == 1)
            {
                if (value != null)
                {
                    model.setParentId(value.toString());
                }
            }
            else if (c == 2)
            {
                if (value != null)
                {
                    model.setType(value.toString());
                }
            }*/
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
                    LOG.error("Unknown formula cell type" + cell.getCellType());
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
                LOG.error("Unknown cell type" + cellType);
                break;
            }
        }
        return value;
    }
}
