package com.ihg.brandstandards.spreadsheet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

import com.ihg.brandstandards.bsadmin.model.XlsModelData;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * Parse Excel file
 * @author kryvora
 *
 */
public class PublishXlsSheetIterator
{
    private static final Log LOG = LogFactoryUtil.getLog(PublishXlsSheetIterator.class);
    private File fileName;

    /**
     * Creates a new XLSX -> CSV converter
     */
    public PublishXlsSheetIterator()
    {

    }

    /**
     * Preferred constructor.
     * @param fileName
     */
    public PublishXlsSheetIterator(File fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Process Spreadsheet.
     * @return list
     * @throws InvalidFormatException exception
     * @throws IOException exception
     */
    public List<XlsModelData> processSpreadsheet() throws InvalidFormatException, IOException
    {
        List<XlsModelData> xlsModels = new ArrayList<XlsModelData>();
        Workbook workbook = WorkbookFactory.create(fileName);
        FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
        // data should be always on first sheet
        Sheet sheet = workbook.getSheetAt(0);
        int rows = sheet.getPhysicalNumberOfRows();

        // map header column number to column name
        Row row = sheet.getRow(0);
        if (row != null)
        {
            HSSFDataFormatter formatter = new HSSFDataFormatter();
            // grab number of columns from first row - it is header row.
            int columnCount = sheet.getRow(0).getPhysicalNumberOfCells();
            XlsModelData model = getXlsHeader(evaluator, row, columnCount, formatter);

            if (columnCount == 1 && (model.getProperties().containsValue("STD ID") || model.getProperties().containsValue("STD_ID")))
            {
                for (int rowIndx = 1; rowIndx < rows; rowIndx++)
                {
                    row = sheet.getRow(rowIndx);
                    if (row != null)
                    {
                        model = getRowData(evaluator, row, 1, formatter);
                        model.setWorksheet(sheet.getSheetName());
                        model.setRow(rowIndx);
                        xlsModels.add(model);
                    }
                }
            }
            else
            {
                throw new IOException("Spreadsheet does not have STD ID column!");
            }
        }
        else
        {
            throw new IOException("Spreadsheet is empty!");
        }
        return xlsModels;

    }

    private XlsModelData getXlsHeader(FormulaEvaluator evaluator, Row row, int columnCount, HSSFDataFormatter formatter)
    {
        XlsModelData model = getRowData(evaluator, row, columnCount, formatter);
        model.setType(BSAdminConstants.XLS_HEADER_TYPE);
        model.setName(BSAdminConstants.COLUMN_NUM_TO_HEADER_MAPPING);
        model.setId(null);
        model.setParentId(null);
        model.setValid(true);
        model.setRow(0);
        model.setColumnCount(columnCount);
        return model;
    }

    private XlsModelData getRowData(FormulaEvaluator evaluator, Row row, int columnCount, HSSFDataFormatter formatter)
    {
        XlsModelData model = new XlsModelData();
        model.setColumnCount(columnCount);
        for (int c = 0; c < columnCount; c++)
        {
            Cell cell = row.getCell(c);
            Object value = getCellData(evaluator, cell, formatter);
            model.set("c_" + c, value);
            if (c == 0)
            {
                if (value != null)
                {
                    model.setId(value.toString());
                }
            }
            else if (c == 1)
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
            }
        }
        return model;
    }

    private Object getCellData(FormulaEvaluator evaluator, Cell cell, HSSFDataFormatter formatter)
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
                    value = formatter.formatRawCellContents(cell.getNumericCellValue(), 0, "#####################");
                    //value = String.valueOf(cell.getNumericCellValue());

                }
                break;
            case Cell.CELL_TYPE_STRING:
                value = cell.getStringCellValue().trim();

                break;
            case Cell.CELL_TYPE_FORMULA:
                // evaluates a given cell, and returns the new value, without
                // affecting the cell
                // CellValue cellValue = evaluator.evaluate(cell);

                // The value for the formula is saved alongside it, to be
                // displayed in excel. The formula remains in the cell, just
                // with a new value
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
        //value = value.replaceAll(".0", "");

        return value;
    }
}
