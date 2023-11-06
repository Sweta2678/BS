package com.ihg.brandstandards.util;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormatter;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DateUtil;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class WorkBookSpreadSheetUtil {

	private static final Log LOG = LogFactoryUtil.getLog(WorkBookSpreadSheetUtil.class);
	
	public static Workbook createWorkbookForErrorStdIDs(Map<String,String> notAddedIds) {
        final Workbook workbook = new HSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Manage Tags Error IDS");

        CellStyle textStyle = workbook.createCellStyle();
        textStyle.setWrapText(true);
        textStyle.setBorderTop((short) 1);
        textStyle.setBorderRight((short) 1);
        textStyle.setBorderBottom((short) 1);
        textStyle.setBorderLeft((short) 1);

        /** Header Row Style */
        final HSSFFont headerRowFont = (HSSFFont) workbook.createFont();
        headerRowFont.setFontName(HSSFFont.FONT_ARIAL);
        headerRowFont.setColor(HSSFColor.BLACK.index);
        headerRowFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        HSSFCellStyle headerRowStyle = (HSSFCellStyle) workbook.createCellStyle();
        headerRowStyle.setFillForegroundColor(IndexedColors.DARK_BLUE.getIndex());
        headerRowFont.setColor(HSSFColor.WHITE.index);
        headerRowStyle.setFont(headerRowFont);
        headerRowStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        headerRowStyle.setBorderTop((short) 1);
        headerRowStyle.setBorderRight((short) 1);
        headerRowStyle.setBorderBottom((short) 1);
        headerRowStyle.setBorderLeft((short) 1);

        /** Std Row Style */
        Font stdRowFont = workbook.createFont();
        stdRowFont.setBoldweight(Font.BOLDWEIGHT_BOLD);
        CellStyle stdRowStyle = workbook.createCellStyle();
        stdRowStyle.setFont(stdRowFont);
        stdRowStyle.setWrapText(true);
        stdRowStyle.setBorderTop((short) 1);
        stdRowStyle.setBorderRight((short) 1);
        stdRowStyle.setBorderBottom((short) 1);
        stdRowStyle.setBorderLeft((short) 1);

        /** Guideline Row Style */
        CellStyle gdlnRowStyle = workbook.createCellStyle();
        Font gdlnFont = workbook.createFont();
        gdlnFont.setColor(HSSFColor.GREY_40_PERCENT.index);
        gdlnRowStyle.setFont(gdlnFont);
        gdlnRowStyle.setWrapText(true);
        gdlnRowStyle.setBorderTop((short) 1);
        gdlnRowStyle.setBorderRight((short) 1);
        gdlnRowStyle.setBorderBottom((short) 1);
        gdlnRowStyle.setBorderLeft((short) 1);

        Row headerRow = sheet.createRow(0);
        String columnHeader = "STD_ID";
        Cell cell = headerRow.createCell(0);
        cell.setCellStyle(headerRowStyle);
        cell.setCellValue(creationHelper.createRichTextString(columnHeader));
        
        Map<String, Integer> columnIndexMap = new HashMap<String, Integer>();
        columnIndexMap.put(columnHeader, 0);
        
       // Row headerRow1 = sheet.createRow(0);
        String columnHeader1 = "Tags";
        Cell cell1 = headerRow.createCell(1);
        cell1.setCellStyle(headerRowStyle);
        cell1.setCellValue(creationHelper.createRichTextString(columnHeader1));

        columnIndexMap.put(columnHeader1, 1);
        
        
        int rowCounter = 0;
        Row dataRow = null;
        if (Validator.isNotNull(notAddedIds) && notAddedIds.size() > 0) {
            for (Map.Entry<String,String> entry : notAddedIds.entrySet()) {
                dataRow = sheet.createRow(++rowCounter);
                createCell(dataRow, columnIndexMap.get("STD_ID"), entry.getKey(), gdlnRowStyle);
                createCell(dataRow, columnIndexMap.get("Tags"), entry.getValue(), gdlnRowStyle);
            }
        }

        
        return workbook;
    }

    private static void createCell(Row dataRow, int cellIndex, String cellValue, CellStyle style) {
        Cell cell = dataRow.createCell(cellIndex);
        cell.setCellValue(cellValue);

        if (style != null) {
            cell.setCellStyle(style);
        }
    }
    
    public static Object getCellData(FormulaEvaluator evaluator, Cell cell, HSSFDataFormatter formatter)
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

                    LOG.info("Unknown formula cell type" + cell.getCellType());
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

                LOG.info("Unknown cell type" + cellType);
                break;
            }
        }
        //value = value.replaceAll(".0", "");

        return value;
    }
}
