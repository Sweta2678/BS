package com.ihg.brandstandards.bridge.util;

import java.io.File;
import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

public class SpreadsheetUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(SpreadsheetUtil.class);

    /**
     * Method will process given request, convert file data entry to List<Long>
     * @param actionRequest
     * @return List<Long>
     * @throws InvalidFormatException
     * @throws IOException
     */
    public static List<Long> getStandardsIdList(ActionRequest actionRequest) throws InvalidFormatException, IOException
    {
        UploadPortletRequest uploadRequest = PortalUtil.getUploadPortletRequest(actionRequest);
        File file = uploadRequest.getFile("file");
        List<Long> stdIds = new ArrayList<Long>();
        XlsSheetIterator xlsSheetIterator = new XlsSheetIterator(file);
        List<XlsModelData> xlsModelDataList = xlsSheetIterator.processSpreadsheet();
        if (xlsModelDataList != null)
        {
            for (XlsModelData data : xlsModelDataList)
            {
                if (!data.getId().isEmpty())
                {
                    stdIds.add(Long.parseLong(data.getId()));
                }
            }
        }
        else
        {
            throw new IOException("Please attach Excel sheet with apt values!");
        }

        return stdIds;
    }
    
    public static Workbook createWorkbookForErrorStdIDs(ResultSet curResultSet, List<Long> std_ids) {
        final Workbook workbook = new HSSFWorkbook();
        CreationHelper creationHelper = workbook.getCreationHelper();
        Sheet sheet = workbook.createSheet("Add By Import Error IDS");

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
        int rowCounter = 0;
        Row dataRow = null;
        if (Validator.isNotNull(std_ids) && std_ids.size() > 0) {
            for (Long id : std_ids) {
                dataRow = sheet.createRow(++rowCounter);
                createCell(dataRow, columnIndexMap.get("STD_ID"), String.valueOf(id), gdlnRowStyle);
            }
        }
        try {
            while (curResultSet.next()) {
                dataRow = sheet.createRow(++rowCounter);
                createCell(dataRow, columnIndexMap.get("STD_ID"), String.valueOf(curResultSet.getLong(1)),
                        gdlnRowStyle);
            }
        } catch (SQLException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
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
}
