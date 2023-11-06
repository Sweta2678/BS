package com.ihg.brandstandards.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.ss.usermodel.DataFormat;
import org.apache.poi.ss.usermodel.Font;
import org.apache.poi.ss.usermodel.IndexedColors;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.apache.poi.xssf.usermodel.XSSFRichTextString;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.report.FieldMapping;
import com.ihg.brandstandards.report.ReportConfig;
import com.ihg.brandstandards.report.ReportConfigLoader;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * Create Excel Report.
 * 
 * @author KryvorA
 * 
 */
public final class StandardsReportBuilder
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsReportBuilder.class);

    private static final String CFG_FIELD_NAME_HIST_STAT_DESC = "historicalStatusDesc";
    private static final int WIDTH_MULTIPLIER = 256;
    private static final int XLS_MAX_ROW_CNT = 65536;
    private static final String LANG_TOKEN = "{lang_desc}";
    private static XSSFRichTextString SELECTED_VAL = new XSSFRichTextString("x"); //unicode value of •
    private static XSSFRichTextString NOT_SELECTED_VAL = new XSSFRichTextString(" "); //unicode value of –
    private static final String GLOBAL_REGION = "GLBL";

    /**
     * private constructor.
     */
    private StandardsReportBuilder()
    {
    }

    /**
     * Create Excel report for the Standards.
     * 
     * @param standards - list of standards
     * @return Workbook
     */
    public static Workbook createReport(final List<StandardsExt> standards)
    {
        ReportConfig config = ReportConfigLoader.getReportConfig("1");
        return createReport(standards, config);
    }

    /**
     * 
     * @param standards
     * @param config
     * @param pkg
     * @return Workbook
     * @author Chintan
     */
    public static Workbook createAttributeReport(final List<StandardsExt> standards, final ReportConfig config, OPCPackage pkg,
            String template, String userRegion)
    {

    	if (LOG.isDebugEnabled()) {
    		LOG.debug("create attribute report :::"+config.getFeature());
    	}
        Workbook workbook = null;
        if ("attributes".equals(config.getFeature()))
        {
            try
            {
                workbook = WorkbookFactory.create(pkg);
                Sheet sheet = workbook.getSheet("Master Data");
                if (standards != null && !standards.isEmpty() && standards.size() < XLS_MAX_ROW_CNT)
                {
                    createSheetContent(workbook, sheet, standards, config, userRegion);
                }
            }
            catch (IOException e)
            {
                LOG.error(e.getMessage(), e);
            }
        }
        return workbook;
    }

    /**
     * Create Excel report for the Standards based on configuration.
     * 
     * @param standards - list of standards
     * @param config report configuration
     * @return Workbook
     */
    public static Workbook createReport(final List<StandardsExt> standards, final ReportConfig config)
    {
        if (LOG.isDebugEnabled()) {
            LOG.debug("Begin creating report for config profile " + config.getId() + " name " + config.getName());
        }
        updateHistoricalStatus(config, standards);
        Workbook workbook = null;
        if ("attributes".equalsIgnoreCase(config.getFeature()))
        {
            try
            {
                OPCPackage pkg = OPCPackage.open(StandardsReportBuilder.class.getClassLoader().getResourceAsStream(
                        "/resources/CMS Global Standard Attribute Assignment Template.xlsm"));
                workbook = WorkbookFactory.create(pkg);
                Sheet sheet = workbook.getSheet("Master Data");
                if (standards != null && !standards.isEmpty() && standards.size() < XLS_MAX_ROW_CNT)
                {
                    createSheetContent(workbook, sheet, standards, config, StringPool.BLANK);
                }
                pkg.close();
            }
            catch (InvalidFormatException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            catch (IOException e)
            {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        else
        {
            workbook = new HSSFWorkbook();
            final Sheet sheet = workbook.createSheet("BrandStandards");
            createHeaderRow(workbook, sheet, config);
            if (standards != null && !standards.isEmpty() && standards.size() < XLS_MAX_ROW_CNT)
            {
                createSheetContent(workbook, sheet, standards, config, StringPool.BLANK);
            }
            else if (standards != null && standards.size() >= XLS_MAX_ROW_CNT)
            {
                createNoRecordsRow(sheet, "Report returned more then maximum allowed number of rows (" + XLS_MAX_ROW_CNT
                        + "). Please change search criteria and re-run report.");
            }
            else
            {
                createNoRecordsRow(sheet, "No records found.");
            }
        }
        if (LOG.isDebugEnabled()) {
            LOG.debug("Created report for config profile " + config.getId() + " name " + config.getName());
        }
        return workbook;
    }

    /**
     * Update historical status of log entries.
     * 
     * @param config - report configuration
     * @param standards all records
     */
    private static void updateHistoricalStatus(ReportConfig config, List<StandardsExt> standards)
    {
        if (existsClassFiledName(CFG_FIELD_NAME_HIST_STAT_DESC, config))
        {
            List<Long> stdIds = new ArrayList<Long>();
            for (StandardsExt rec : standards)
            {
                if (stdIds.contains(rec.getStdId()))
                {
                    rec.setAuditStatus("Audit");
                }
                else
                {
                    stdIds.add(rec.getStdId());
                }
            }
        }
    }

    /**
     * Verify if Record Configuration contains specified field name.
     * 
     * @param fieldName field name
     * @param config Report Configuration
     * @return true/false
     */
    private static boolean existsClassFiledName(String fieldName, ReportConfig config)
    {
        boolean found = false;
        for (FieldMapping field : config.getRecord().getField())
        {
            if (fieldName.equals(field.getClassFieldName()))
            {
                found = true;
                break;
            }
        }
        return found;
    }

    /**
     * Create no records found row.
     * 
     * @param sheet current sheet.
     */
    private static void createNoRecordsRow(final Sheet sheet, String msg)
    {
        final Row row = sheet.createRow(1);
        final Cell cell = row.createCell(0);
        cell.setCellValue(new HSSFRichTextString(msg));
    }

    /**
     * Create Header Row.
     * 
     * @param workbook - current workbook
     * @param sheet - the sheet
     * @param config report configuration
     * @return Row - header row
     */
    private static Row createHeaderRow(final Workbook workbook, final Sheet sheet, final ReportConfig config)
    {
        final Row row = sheet.createRow(0);
        createHeaderCells(sheet, workbook, row, config);
        return row;
    }

    /**
     * Create Header cells for Index names and at least one set of Standards names. Header may contains multiple sets of names for
     * Standards.
     * 
     * @param sheet sheet
     * @param workbook current workbook
     * @param row row
     * @param config report configuration
     */
    private static void createHeaderCells(final Sheet sheet, final Workbook workbook, final Row row, final ReportConfig config)
    {
        final HSSFFont font = (HSSFFont) workbook.createFont();
        font.setFontName(HSSFFont.FONT_ARIAL);
        font.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

        HSSFCellStyle style = (HSSFCellStyle) workbook.createCellStyle();
        style.setFont(font);

        int indx = createHeaderCells(sheet, style, row, config.getIndex().getField(), config.getSecLanguage(), 0);

        for (int i = 0; i < config.getRecord().getRecordsOnRowForSameIndex(); i++)
        {
            if (config.getRecord().getRecordsOnRowForSameIndex() > 1)
            {
                style = getCellStyle(workbook, font, i);
            }
            indx = createHeaderCells(sheet, style, row, config.getRecord().getField(), config.getSecLanguage(), indx);
        }
    }

    /**
     * Get cell style.
     * 
     * @param workbook current workbook
     * @param font font
     * @param i index
     * @return style
     */
    private static HSSFCellStyle getCellStyle(final Workbook workbook, final HSSFFont font, int i)
    {
        HSSFCellStyle style;
        if (i == 0)
        {
            style = (HSSFCellStyle) workbook.createCellStyle();
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.BRIGHT_GREEN.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        }
        else if (i % 2 == 0)
        {
            style = (HSSFCellStyle) workbook.createCellStyle();
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.LIGHT_CORNFLOWER_BLUE.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        }
        else if (i % 3 == 0)
        {
            style = (HSSFCellStyle) workbook.createCellStyle();
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.LIGHT_BLUE.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        }
        else
        {
            style = (HSSFCellStyle) workbook.createCellStyle();
            style.setFont(font);
            style.setFillForegroundColor(IndexedColors.YELLOW.getIndex());
            style.setFillPattern(CellStyle.SOLID_FOREGROUND);
        }
        return style;
    }

    /**
     * Create Header cells.
     * 
     * @param sheet sheet
     * @param style HSSFCellStyle
     * @param row row
     * @param fields list of fields
     * @param secLanguage second report language
     * @param startIndx - starting cell index
     * @return last cell index
     */
    private static int createHeaderCells(final Sheet sheet, final HSSFCellStyle style, final Row row,
            final List<FieldMapping> fields, final String secLanguage, final int startIndx)
    {
        int indx = startIndx;

        for (FieldMapping field : fields)
        {
            boolean addTranslatedCell = false;
            String columnName = field.getXlsColumnName();
            if (field.isShowTranslation() && secLanguage != null)
            {
                columnName = field.getXlsColumnName().replace(LANG_TOKEN, secLanguage);
                addTranslatedCell = true;
            }

            if (!field.isShowTranslation() || addTranslatedCell)
            {
                final Cell cell = row.createCell(indx);
                cell.setCellValue(new HSSFRichTextString(columnName));
                cell.setCellStyle(style);
                sheet.setColumnWidth(indx, field.getXlsColumnWidth() * WIDTH_MULTIPLIER);
                indx++;
            }
        }
        return indx;
    }

    /**
     * Populate data on sheet.
     * 
     * @param workbook spreadsheet workbook
     * @param sheet - the sheet
     * @param standards - list of standards
     * @param config report configuration
     */
    private static void createSheetContent(final Workbook workbook, final Sheet sheet, final List<StandardsExt> standards,
            final ReportConfig config, String userRegion)
    {
        if (config.getRecord().getRecordsOnRowForSameIndex() == 1)
        {
            if ("PublishAdmin".equals(config.getFeature()))
            {
                createPublishSheetContent(workbook, sheet, standards, config);
            }
            else if ("attributes".equals(config.getFeature()))
            {
                createAttributeContent(workbook, sheet, standards, config, userRegion);
            }
            else
            {
                List<FieldMapping> fields = new ArrayList<FieldMapping>();
                fields.addAll(config.getIndex().getField());
                fields.addAll(config.getRecord().getField());
                createSheetContent(workbook, sheet, standards, fields, config.getSecLanguage());
            }
        }
        else
        {
            createSheetRepeatedContent(workbook, standards, sheet, config);
        }
    }

    /**
     * 
     * @param workbook
     * @param sheet
     * @param standards
     * @param config
     * @author Chintan
     */
    private static void createAttributeContent(final Workbook workbook, final Sheet sheet, final List<StandardsExt> standards,
            final ReportConfig config, String userRegion)
    {
        List<FieldMapping> index = config.getIndex().getField();
        List<FieldMapping> records = config.getRecord().getField();
        int startIndx = config.getIndex().getField().size();

        int rowNum = sheet.getPhysicalNumberOfRows();
        if (LOG.isDebugEnabled()) {
        	 LOG.debug("Total rows :" + rowNum);
        }
        Map<String, CellStyle> styles = getCellStyleMap(workbook);
        
        sheet.setDefaultColumnStyle(1, styles.get("columnStyle"));
        sheet.setDefaultColumnStyle(2, styles.get("columnStyle"));
        sheet.setDefaultColumnStyle(3, styles.get("columnStyle"));
        sheet.setDefaultColumnStyle(4, styles.get("columnStyle"));
        //Store user region into report
        if (Validator.isNotNull(userRegion)) {
        	sheet.getRow(sheet.getFirstRowNum()).getCell(1).setCellValue(userRegion);
        }
        
        for (StandardsExt std : standards)
        {
            final Row row = sheet.createRow(rowNum);
            createCellsForAttributes(std, row, styles, index, null, 0);
            createCellsForFlagFields(std, row, styles, records, startIndx, userRegion);
            rowNum++;
        }
    }

    /**
     * 
     * @param std
     * @param row
     * @param dateCellStyle
     * @param fields
     * @param startIndx
     * @return int
     * @author Chintan
     */
    public static int createCellsForFlagFields(final StandardsExt std, final Row row, final Map<String, CellStyle> cellStyleMap,
            final List<FieldMapping> fields, final int startIndx, String userRegion)
    {
        int indx = startIndx;
        String stdRegion = StringPool.BLANK;
        if (row.getCell(3) != null && row.getCell(3).getStringCellValue() != null) {
            stdRegion = row.getCell(3).getStringCellValue();
        }
		Cell cell = null;        
		for (FieldMapping field : fields)
        {
        	cell = row.getCell(indx);
        	if (cell == null) {
            	cell = row.createCell(indx);
            }
            if (Validator.isNotNull(field.getValue()) && Validator.isNotNull(std.getFlags())
                    && std.getFlags().contains(field.getValue()))
            {
                cell.setCellValue(SELECTED_VAL);
                cell.setCellStyle(cellStyleMap.get("Flag"));
            }
            else if (BSAdminConstants.CELL_TYPE.equals(field.getClassFieldName()))
            {
                cell.setCellValue("");
                cell.setCellStyle(cellStyleMap.get("category"));
            }
            else
            {
                cell.setCellValue(NOT_SELECTED_VAL);
                cell.setCellStyle(cellStyleMap.get("Flag"));
            }
            // if standard region is different from region user has selected than that standard will be disabled  
            // If user has selected global region while exporting standards, system will not disable any regional standard
            if (Validator.isNotNull(userRegion) && !userRegion.equals(stdRegion) && !GLOBAL_REGION.equals(userRegion)) {
                cell.setCellStyle(cellStyleMap.get("category"));
            }
            indx++;
        }
		//CR70.2 Add parent std id
		Cell parentId = row.getCell(indx);
		if (parentId == null) {
			parentId = row.createCell(indx);
		}
		parentId.setCellValue(std.getStdPrntId());
		parentId.setCellStyle(cellStyleMap.get("hiddenStyle"));
        return indx;
    }

    /**
     * 
     * @param std
     * @param row
     * @param indexStyle
     * @param fields
     * @param secLanguage
     * @param startIndx
     * @return int
     * @author Chintan
     */
    public static int createCellsForAttributes(final StandardsExt std, final Row row, final Map<String, CellStyle> indexStyle,
            final List<FieldMapping> fields, final String secLanguage, final int startIndx)
    {
        int indx = startIndx;
        //        final Map<String, FlagCategory> flags = StandardsUtil.getFlagCategoryMap();

        for (FieldMapping field : fields)
        {
            createCellForAttributeField(std, row, indexStyle, indx, field, secLanguage);
            indx++;
        }
        
        return indx;
    }

    private static void createCellForAttributeField(final StandardsExt std, final Row row,
            final Map<String, CellStyle> indexStyle, int indx, FieldMapping field, final String secLanguage)
    {
        Cell stdType = row.getCell(indx);
        if (stdType == null) {
        	stdType = row.createCell(indx);
        }
        if (BSAdminConstants.ATTR_STD_ID.equals(field.getXlsColumnName()))
        {
            stdType.setCellValue(std.getStdId());
        }
        else if (BSAdminConstants.ATTR_STD_TYPE.equals(field.getXlsColumnName()))
        {
            if (BSAdminConstants.STD_TYPE.equals(std.getStdType()))
            {
                stdType.setCellValue(BSAdminConstants.STD_LABEL);
                stdType.setCellStyle(indexStyle.get(BSAdminConstants.STD_TYPE));
            }
            else if (BSAdminConstants.SPEC_TYPE.equals(std.getStdType()))
            {
                stdType.setCellValue(BSAdminConstants.SPEC_LABEL);
                stdType.setCellStyle(indexStyle.get(BSAdminConstants.SPEC_TYPE));
            }
            else if (BSAdminConstants.GDLN_TYPE.equals(std.getStdType()))
            {
                stdType.setCellValue(BSAdminConstants.GDLN_LABEL);
                stdType.setCellStyle(indexStyle.get(BSAdminConstants.GDLN_TYPE));
            }

        }
        else if (BSAdminConstants.ATTR_STD_TEXT.equals(field.getXlsColumnName()))
        {
        	stdType.setCellValue(std.getStdTitle());
            if (BSAdminConstants.STD_TYPE.equals(std.getStdType()))
            {
                stdType.setCellStyle(indexStyle.get(BSAdminConstants.STD_TYPE_LABEL));
            }
            else if (BSAdminConstants.GDLN_TYPE.equals(std.getStdType()))
            {
                stdType.setCellStyle(indexStyle.get(BSAdminConstants.GDLN_TYPE_LABEL));
            } else {
            	stdType.setCellStyle(indexStyle.get(BSAdminConstants.SPEC_TYPE_LABEL));
            }
            
        }
        else if (BSAdminConstants.ATTR_INDEX_PATH.equals(field.getXlsColumnName()))
        {
            stdType.setCellValue(std.getIndexPath());
            stdType.setCellStyle(indexStyle.get(BSAdminConstants.STD_TYPE_LABEL));
        }
        else if (BSAdminConstants.REGION_LABEL.equals(field.getXlsColumnName())) {
            stdType.setCellValue(std.getStdRegionCode());
        } else if (BSAdminConstants.MANUAL_LABEL.equals(field.getXlsColumnName())) {
            stdType.setCellValue(std.getStdManual());
            stdType.setCellStyle(indexStyle.get("columnStyle"));
        } else if (BSAdminConstants.CELL_TYPE.equals(field.getClassFieldName()))
        {
            stdType.setCellValue(StringPool.BLANK);
        } 
    }

    /**
     * Populate data on sheet.
     * 
     * @param workbook spreadsheet workbook
     * @param sheet - the sheet
     * @param standards - list of standards
     * @param fields report fields
     * @param secLanguage second report language
     */
    private static void createSheetContent(final Workbook workbook, final Sheet sheet, final List<StandardsExt> standards,
            final List<FieldMapping> fields, final String secLanguage)
    {
        int rowNum = 1;
        final CellStyle dateCellStyle = getDateStyle(workbook);

        for (StandardsExt std : standards)
        {
            final Row row = sheet.createRow(rowNum);
            createCells(std, row, fields, dateCellStyle, secLanguage);
            rowNum++;
        }
    }

    /**
     * Populate data on sheet.
     * 
     * @param workbook spreadsheet workbook
     * @param sheet - the sheet
     * @param standards - list of standards
     */
    private static void createPublishSheetContent(final Workbook workbook, final Sheet sheet, final List<StandardsExt> standards,
            final ReportConfig config)
    {
        List<FieldMapping> index = config.getIndex().getField();
        List<FieldMapping> records = config.getRecord().getField();
        int startIndx = config.getIndex().getField().size();

        int rowNum = 1;
        final CellStyle dateCellStyle = getDateStyle(workbook);

        for (StandardsExt std : standards)
        {
            final Row row = sheet.createRow(rowNum);
            createCells(std, row, index, dateCellStyle, null);
            createCellsForCountryFields(std, row, dateCellStyle, records, startIndx);
            rowNum++;
        }

        // populate data per country
        //        for (StandardsExt std : standards)
        //        {
        //            final Row row = sheet.createRow(rowNum);
        //            createCellsForCountryFields(std, row, dateCellStyle, records, startIndx);
        //            rowNum++;
        //        }
    }

    /**
     * Create cells for row.
     * 
     * @param workbook spreadsheet workbook
     * @param standards - list of standards
     * @param sheet - current sheet
     * @param config report configuration
     */
    private static void createSheetRepeatedContent(final Workbook workbook, final List<StandardsExt> standards,
            final Sheet sheet, final ReportConfig config)
    {
        int rowNum = 1;
        CellStyle dateCellStyle = getDateStyle(workbook);
        long lastStdId = 0;
        int cellIndx = 0;
        Row row = null;
        int indexSize = config.getIndex().getField().size();
        int recordSize = config.getRecord().getField().size();
        Iterator<StandardsExt> iterator = standards.iterator();

        while (iterator.hasNext())
        {
            StandardsExt std = iterator.next();
            if (std.getStdId() == 0L)
            {
                row = sheet.createRow(rowNum);
                rowNum++;
                cellIndx = createCellsForIndexOnly(std, row, config.getIndex().getField(), config.getSecLanguage());
            }
            else
            {
                if (lastStdId == std.getStdId())
                {
                    // Operate === record section 1
                    if ("258".equals(std.getStdManual()))
                    {
                        cellIndx = indexSize;
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                    // Build & Refurbishment === record section 2
                    else if ("257".equals(std.getStdManual()))
                    {
                        cellIndx = indexSize + recordSize;
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                    // no Manual code === record section 3
                    else
                    {
                        cellIndx = indexSize + recordSize * 2;
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                }
                else
                {
                    cellIndx = 0;
                    lastStdId = std.getStdId();
                    row = sheet.createRow(rowNum);
                    rowNum++;

                    cellIndx = createCellsForFields(std, row, dateCellStyle, config.getIndex().getField(),
                            config.getSecLanguage(), cellIndx);

                    // Operate === record section 1
                    if ("258".equals(std.getStdManual()))
                    {
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                    // Build & Refurbishment === record section 2
                    else if ("257".equals(std.getStdManual()))
                    {
                        // Workaround for long string on previous column. Create new cell will stop from showing long value across multiple cells.
                        row.createCell(cellIndx).setCellValue("");

                        cellIndx += recordSize;
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                    // no Manual code === record section 3
                    else
                    {
                        // Workaround for long string on previous column. Create new cell will stop from showing long value across multiple cells.
                        row.createCell(cellIndx).setCellValue("");

                        cellIndx += recordSize * 2;
                        cellIndx = createCellsForFields(std, row, dateCellStyle, config.getRecord().getField(),
                                config.getSecLanguage(), cellIndx);
                    }
                }
            }
        }
    }

    /**
     * Create cells for row.
     * 
     * @param std - standard
     * @param row - current row
     * @param fields report fields
     * @param dateCellStyle cell style for Date
     * @param secLanguage second report language
     */
    private static void createCells(final StandardsExt std, final Row row, final List<FieldMapping> fields,
            final CellStyle dateCellStyle, final String secLanguage)
    {
        if (std.getStdId() == 0L)
        {
            createCellsForIndexOnly(std, row, fields, secLanguage);
        }
        else
        {
            createCellsForRecord(std, row, fields, dateCellStyle, secLanguage);
        }
    }

    /**
     * Create cells for Country Fields.
     * 
     * @param std Record
     * @param row current row
     * @param dateCellStyle date style
     * @param fields list of fields
     * @param startIndx starting cell index
     * @return next cell index
     */
    private static int createCellsForCountryFields(final StandardsExt std, final Row row, final CellStyle dateCellStyle,
            final List<FieldMapping> fields, final int startIndx)
    {
        int indx = startIndx;
        final Map<String, FlagCategory> flags = StandardsUtil.getFlagCategoryMap();

        Map<String, String> chngStatus = std.getCountryChngStat();

        for (FieldMapping field : fields)
        {
            createCellForCountryField(chngStatus, row, dateCellStyle, indx, field, flags);
            indx++;
        }
        return indx;
    }

    /**
     * Create cells for Fields.
     * 
     * @param std Record
     * @param row current row
     * @param dateCellStyle date style
     * @param fields list of fields
     * @param startIndx starting cell index
     * @param secLanguage second report language
     * @return next cell index
     */
    private static int createCellsForFields(final StandardsExt std, final Row row, final CellStyle dateCellStyle,
            final List<FieldMapping> fields, final String secLanguage, final int startIndx)
    {
        int indx = startIndx;
        final Map<String, FlagCategory> flags = StandardsUtil.getFlagCategoryMap();

        for (FieldMapping field : fields)
        {
            if (allowAddCell(secLanguage, field))
            {
                createCellForField(std, row, dateCellStyle, indx, field, flags, secLanguage);
                indx++;
            }
        }
        return indx;
    }

    /**
     * Create cell for field.
     * 
     * @param std Standard/Specification/Guideline record
     * @param row current row
     * @param dateCellStyle cell style for Date
     * @param indx cell index
     * @param field field
     * @param flags map of flags. Key is flag id.
     * @param secLanguage language
     */
    private static void createCellForField(final StandardsExt std, final Row row, final CellStyle dateCellStyle, int indx,
            FieldMapping field, final Map<String, FlagCategory> flags, final String secLanguage)
    {
        if ("indexId".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(std.getIndexId());
        }
        else if ("indexLevel".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(std.getIndexLevel());
        }
        else if ("indexTitle".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getIndexTitle()));
        }
        else if (secLanguage != null && "secLangIndexTitle".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getSecLangIndexTitle()));
        }
        else if ("indexPath".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getIndexPath()));
        }
        else if ("stdRegionCode".equals(field.getClassFieldName()))
        {
            String txt = resolveRegionCode(std.getStdRegionCode());
            if (txt != null)
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(txt));
            }
        }
        else if ("stdGlobal".equals(field.getClassFieldName()))
        {
            String txt = resolveGlobalCode(std);
            if (txt != null)
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(txt));
            }
        }
        else if ("stdId".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(std.getStdId());
        }
        else if ("stdOrderNumber".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(std.getStdOrderNumber());
        }
        else if ("stdType".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(getRecordTypeDesc(std.getStdType()));
        }
        else if ("stdTitle".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdTitle()));
        }
        else if (secLanguage != null && "secLangStdTitle".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getSecLangStdTitle()));
        }
        else if ("stdDescription".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdDescription()));
        }
        else if (secLanguage != null && "secLangStdDesc".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getSecLangStdDesc()));
        }
        else if ("stdBusinessOwner".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdBusinessOwner()));
        }
        else if ("stdInternalReference".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdInternalReference()));
        }
        else if ("stdCreatedBy".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdCreatedBy()));
        }
        else if ("stdStatus".equals(field.getClassFieldName()))
        {
            if ("0".equals(std.getStdStatus()))
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString("N/A"));
            }
            else
            {
                row.createCell(indx).setCellValue(
                        new HSSFRichTextString(StandardsStatusUtil.getStatusById(Long.parseLong(std.getStdStatus())).getTitle()));
            }
        }
        else if ("auditLogStatus".equals(field.getClassFieldName()) && !StandardsUtil.IsNullOrBlank(std.getAuditLogStatus()))
        {
            try
            {
                row.createCell(indx).setCellValue(
                        new HSSFRichTextString(StandardsStatusUtil.getStatusDescByCode(std.getAuditLogStatus())));
            }
            catch (Exception e)
            {
                LOG.error("CURRENT STATUS EXCEPTION for : " + std.getStdId() + " status = " + std.getAuditLogStatus());
            }
        }
        else if ("auditLogPrevStatus".equals(field.getClassFieldName())
                && !StandardsUtil.IsNullOrBlank(std.getAuditLogPrevStatus()))
        {
            try
            {
                row.createCell(indx).setCellValue(
                        new HSSFRichTextString(StandardsStatusUtil.getStatusDescByCode(std.getAuditLogPrevStatus())));
            }
            catch (Exception e)
            {
                LOG.error("PREVIOUS STATUS EXCEPTION for : " + std.getStdId() + " status = " + std.getAuditLogStatus());
            }
        }
        else if ("stdCategory".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdCategory()));
        }
        else if ("stdChange".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdChange()));
        }
        else if ("author".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdAuthor()));
        }
        else if ("author".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdAuthor()));
        }
        else if ("auditLogTitle".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getAuditLogTitle()));
        }
        else if ("auditLogComments".equals(field.getClassFieldName()))
        {
            //                row.createCell(indx).setCellValue(new HSSFRichTextString(std.getAuditLogId() + " -- " + std.getAuditLogComments()));
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getAuditLogComments()));
        }
        else if ("auditLogDate".equals(field.getClassFieldName()))
        {
            if (std.getAuditLogDate() != null)
            {
                Cell cell = row.createCell(indx);
                cell.setCellValue(std.getAuditLogDate());
                cell.setCellStyle(dateCellStyle);
            }
            else if ("stdUpdatedDate".equals(field.getDefaultValueFrom()) && std.getStdUpdatedDate() != null)
            {
                Cell cell = row.createCell(indx);
                cell.setCellValue(std.getStdUpdatedDate());
                cell.setCellStyle(dateCellStyle);
            }
        }
        else if ("stdManual".equals(field.getClassFieldName()))
        {
            if (std.getStdManual() == null || std.getStdManual().isEmpty() || "0".equals(std.getStdManual()))
            {
                row.createCell(indx).setCellValue("");
            }
            else
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getStdManual(), flags)));
            }
        }
        else if ("stdManualBuild".equals(field.getClassFieldName()))
        {
            if (std.getStdManualBuild() == null || std.getStdManualBuild().isEmpty() || "0".equals(std.getStdManualBuild()))
            {
                row.createCell(indx).setCellValue("");
            }
            else
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getStdManualBuild(), flags)));
            }
        }
        else if ("stdManualOperate".equals(field.getClassFieldName()))
        {
            if (std.getStdManualOperate() == null || std.getStdManualOperate().isEmpty() || "0".equals(std.getStdManualOperate()))
            {
                row.createCell(indx).setCellValue("");
            }
            else
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getStdManualOperate(), flags)));
            }
        }
        else if ("historicalStatusDesc".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getAuditStatus()));
        }
        else if ("stdCorporateDepartment".equals(field.getClassFieldName()))
        {
            if (!"none".equals(std.getStdCorporateDepartment()))
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdCorporateDepartment()));
            }
        }
        else if ("stdBrandCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(StandardsUtil.decodeChainCode(std.getStdBrandCd())));
        }
        else if ("biRegionCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(StandardsUtil.decodeRegionCode(std.getBiRegionCd())));
        }
        else if ("biChangeTypeCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getBiChangeTypeCd(), flags)));
        }
        else if ("biProfileLossImpactCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getBiProfileLossImpactCd(), flags)));
        }
        else if ("biCapExpenseImpactCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getBiCapExpenseImpactCd(), flags)));
        }
        else if ("biImplTimeScaleCd".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(resolveFlag(std.getBiImplTimeScaleCd(), flags)));
        }
        else if ("biComments".equals(field.getClassFieldName()))
        //        else if ("biComments".equals(field.getClassFieldName()) && std.getBiComments() != null && !std.getBiComments().isEmpty())
        {
            if (std.getBiImpactAssmntId() > 0L)
            {
                //            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getBiImpactAssmntId() + " === " + std.getBiComments()));
                row.createCell(indx).setCellValue(new HSSFRichTextString(std.getBiComments()));
            }
        }
        else if ("stdImageCount".equals(field.getClassFieldName()))
        {
            if (std.getStdImageCount() > 0)
            {
                row.createCell(indx).setCellValue(std.getStdImageCount());
            }
        }
        else if ("stdImageTitle".equals(field.getClassFieldName()))
        {
            if (std.getStdImageCount() > 0)
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdImageTitle()));
            }
        }
        else if ("stdCrossReferences".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(std.getStdCrossReferences()));
        }
        else if ("auditBrand".equals(field.getClassFieldName()))
        {
            Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap(); 
            row.createCell(indx).setCellValue(new HSSFRichTextString(chnCdMap.get(std.getAuditBrand())));
        }
        else if ("globalRule".equals(field.getClassFieldName()))
        {
            if (std.getGlobalRule() != -100)
            {
                row.createCell(indx).setCellValue(std.getGlobalRule());
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("ameaRule".equals(field.getClassFieldName()))
        {
            if (std.getAmeaRule() != -100)
            {
                row.createCell(indx).setCellValue(std.getAmeaRule());
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("amerRule".equals(field.getClassFieldName()))
        {
            if (std.getAmerRule() != -100)
            {
                row.createCell(indx).setCellValue(std.getAmerRule());
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("euroRule".equals(field.getClassFieldName()))
        {
            if (std.getEuroRule() != -100)
            {
                row.createCell(indx).setCellValue(std.getEuroRule());
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("gcRule".equals(field.getClassFieldName()))
        {
            if (std.getGcRule() != -100)
            {
                row.createCell(indx).setCellValue(std.getGcRule());
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("expires".equals(field.getClassFieldName()))
        {
            if (std.getExpires() != null)
            {
                row.createCell(indx).setCellValue(new HSSFRichTextString(std.getExpires()));
            }
            else
            {
                row.createCell(indx).setCellValue("");
            }
        }
        else if ("empty".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue("");
        }
        else
        {
            LOG.info("Found unknown field name " + field.getClassFieldName());
        }
    }

    /**
     * Create cell for Country field.
     * 
     * @param chngStatus change status map
     * @param row current row
     * @param dateCellStyle cell style for Date
     * @param indx cell index
     * @param field field
     * @param flags map of flags. Key is flag id.
     */
    private static void createCellForCountryField(final Map<String, String> chngStatus, final Row row,
            final CellStyle dateCellStyle, int indx, FieldMapping field, final Map<String, FlagCategory> flags)
    {
        String status = chngStatus.get(field.getClassFieldName());

        if ("empty".equals(field.getClassFieldName()))
        {
            row.createCell(indx).setCellValue("");
        }
        else if (status != null)
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString(status));
        }
        else
        {
            row.createCell(indx).setCellValue(new HSSFRichTextString("N/A"));
            //            LOG.info("Found unknown country name " + field.getClassFieldName());
        }
    }

    /**
     * Resolve description for Global column.
     * 
     * @param std StandardsExt
     * @return description
     */
    private static String resolveGlobalCode(final StandardsExt std)
    {
        String globalCd = std.getStdGlobal();
        String frameworkCd = std.getStdFramework();
        String regionCd = std.getStdRegionCode();

        String txt = null;

        if ("GLBL".equals(regionCd))
        {
            if ("G".equals(globalCd))
            {
                if ("Y".equals(frameworkCd))
                {
                    txt = "Global Framework";
                }
                else
                {
                    txt = "Global";
                }
            }
            else
            {
                if ("Y".equals(frameworkCd))
                {
                    txt = "Multi Regional Framework";
                }
                else
                {
                    txt = "Multi Regional";
                }
            }
        }
        else
        {
            txt = getRegionDescription(regionCd);
        }
        return txt;
    }

    /**
     * Resolve code for Global Flag.
     * 
     * @param code code of the flag
     * @return description
     */
    private static String resolveRegionCode(final String code)
    {
        String txt = null;

        if (code != null)
        {
            if ("GLBL".equals(code))
            {
                txt = "Global";
            }
            else
            {
                txt = getRegionDescription(code);
            }
        }
        return txt;
    }

    /**
     * Return Region Description.
     * 
     * @param code Region Code.
     * @return Region Description
     */
    private static String getRegionDescription(final String code)
    {
        String txt;
        Map<String, String> regions = StandardsUtil.getRegions();
        txt = regions.get(code);
        return txt;
    }

    /**
     * Resolve Flag code with description.
     * 
     * @param code flag code
     * @param flags map of all flags
     * @return flag description
     */
    private static String resolveFlag(final String code, final Map<String, FlagCategory> flags)
    {
        FlagCategory flg = flags.get(code);
        return flg != null ? flg.getTxtValue() : code;
    }

    /**
     * Create cells for Index with associated Standard/Specification/Guideline record.
     * 
     * @param std Standard/Specification/Guideline record
     * @param row current row
     * @param fields Report fields configuration
     * @param dateCellStyle date style
     * @param secLanguage second report language
     */
    private static void createCellsForRecord(final StandardsExt std, final Row row, final List<FieldMapping> fields,
            final CellStyle dateCellStyle, final String secLanguage)
    {
        createCellsForFields(std, row, dateCellStyle, fields, secLanguage, 0);
    }

    /**
     * Get Date style.
     * 
     * @param workbook workbook
     * @return cell date style
     */
    private static CellStyle getDateStyle(final Workbook workbook)
    {
        CellStyle dateCellStyle = workbook.createCellStyle();
        CreationHelper createHelper = workbook.getCreationHelper();
        dateCellStyle.setDataFormat(createHelper.createDataFormat().getFormat("yyyy-mm-dd"));
        return dateCellStyle;
    }

    /**
     * Create cells for Index with no Standards associated.
     * 
     * @param std Standard/Specification/Guideline record
     * @param row current row
     * @param fields Report fields configuration
     * @param secLanguage second report language
     * @return next index
     */
    private static int createCellsForIndexOnly(final StandardsExt std, final Row row, final List<FieldMapping> fields,
            final String secLanguage)
    {
        int indx = 0;
        for (FieldMapping field : fields)
        {
            if (allowAddCell(secLanguage, field))
            {
                if ("indexId".equals(field.getClassFieldName()))
                {
                    row.createCell(indx).setCellValue(std.getIndexId());
                }
                else if ("indexLevel".equals(field.getClassFieldName()))
                {
                    row.createCell(indx).setCellValue(std.getIndexLevel());
                }
                else if ("indexTitle".equals(field.getClassFieldName()))
                {
                    row.createCell(indx).setCellValue(new HSSFRichTextString(std.getIndexTitle()));
                }
                else if (secLanguage != null && "secLangIndexTitle".equals(field.getClassFieldName()))
                {
                    row.createCell(indx).setCellValue(new HSSFRichTextString(std.getSecLangIndexTitle()));
                }
                else if ("indexPath".equals(field.getClassFieldName()))
                {
                    row.createCell(indx).setCellValue(new HSSFRichTextString(std.getIndexPath()));
                }
                indx++;
            }
        }
        return indx;
    }

    /**
     * Verify if system should add cell based on language translation and field configuration.
     * 
     * @param secLanguage second language on report
     * @param field the field
     * @return true/false
     */
    private static boolean allowAddCell(final String secLanguage, FieldMapping field)
    {
        return !field.isShowTranslation() || (field.isShowTranslation() && secLanguage != null);
    }

    /**
     * Get Record Type description.
     * 
     * @param type - record type
     * @return type description
     */
    private static HSSFRichTextString getRecordTypeDesc(final String type)
    {
        String desc;
        if ("STD".equals(type))
        {
            desc = "Standard";
        }
        else if ("SPEC".equals(type))
        {
            desc = "Specification";
        }
        else if ("GDLN".equals(type))
        {
            desc = "Guideline";
        }
        else
        {
            desc = "Unknown";
        }
        return new HSSFRichTextString(desc);
    }

    /**
     * 
     * @param workbook
     * @return
     * @author Chintan
     */
    public static Map<String, CellStyle> getCellStyleMap(Workbook workbook)
    {
        CellStyle style = workbook.getCellStyleAt((short) 0);
        Font font = (Font) workbook.createFont();
        font.setFontName("Calibri");
        font.setFontHeightInPoints((short) 9);
        style.setFont(font);
        SELECTED_VAL.applyFont(font);
        NOT_SELECTED_VAL.applyFont(font);

        /********************************* Column style for standard text **************************************/
        CellStyle textStyle = workbook.createCellStyle();
        textStyle.setWrapText(true);
        /*************************************** Standard style object *************************************/
        CellStyle stdStyle = workbook.createCellStyle();
        Font stdFont = (Font) workbook.createFont();
        stdFont.setFontName("Calibri");
        stdFont.setFontHeightInPoints((short) 9);
        stdFont.setColor(IndexedColors.ORANGE.getIndex());
        stdFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        stdStyle.setFont(stdFont);
        stdStyle.setAlignment(CellStyle.ALIGN_LEFT);
        /************************************ Specification style object ********************************/
        CellStyle specStyle = workbook.createCellStyle();
        Font specFont = (Font) workbook.createFont();
        specFont.setFontName("Calibri");
        specFont.setFontHeightInPoints((short) 9);
        specFont.setColor(IndexedColors.BLUE.getIndex());
        specStyle.setFont(specFont);
        specStyle.setAlignment(CellStyle.ALIGN_CENTER);
        /************************************ Guideline style object ********************************/
        CellStyle gdlnStyle = workbook.createCellStyle();
        Font gdlnFont = (Font) workbook.createFont();
        gdlnFont.setFontName("Calibri");
        gdlnFont.setFontHeightInPoints((short) 9);
        gdlnFont.setColor(IndexedColors.GREEN.getIndex());
        gdlnStyle.setFont(gdlnFont);
        gdlnStyle.setAlignment(CellStyle.ALIGN_CENTER);
        /************************************ END *******************************/
        /******************************* STD Text *****************************/
        CellStyle stdTextStyle = workbook.createCellStyle();
        Font stdTextFont = (Font) workbook.createFont();
        stdTextFont.setFontName("Calibri");
        stdTextFont.setFontHeightInPoints((short) 9);
        stdTextFont.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);
        stdTextStyle.setFont(stdTextFont);
        stdTextStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
        stdTextStyle.setWrapText(true);
        //stdTextStyle.setFillBackgroundColor(IndexedColors.LIGHT_ORANGE.getIndex());
        //stdTextStyle.setFillPattern(CellStyle.SOLID_FOREGROUND);
        /******************************* Guideline Text *****************************/
        CellStyle gdlnTextStyle = workbook.createCellStyle();
        Font gdlnTextFont = (Font) workbook.createFont();
        gdlnTextFont.setFontName("Calibri");
        gdlnTextFont.setColor(IndexedColors.GREY_25_PERCENT.getIndex());
        gdlnTextFont.setFontHeightInPoints((short) 9);
        gdlnTextStyle.setFont(gdlnTextFont);
        gdlnTextStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
        gdlnTextStyle.setWrapText(true);
        
        /***************************** Specification style *****************/
        CellStyle specTextStyle = workbook.createCellStyle();
        specTextStyle.setFont(font);
        specTextStyle.setWrapText(true);
        specTextStyle.setVerticalAlignment(CellStyle.VERTICAL_JUSTIFY);
        /***************************** Label Style ******************************/
        CellStyle category = workbook.createCellStyle();
        category.setFont(stdFont);
        category.setLocked(true);
        category.setAlignment(CellStyle.ALIGN_CENTER);
        /******************************* Flag style **********************************/
        CellStyle flagTextStyle = workbook.createCellStyle();
        flagTextStyle.setFont(font);
        flagTextStyle.setLocked(false);
        flagTextStyle.setAlignment(CellStyle.ALIGN_CENTER);
		/********************************** Hidden Cell ******************************/
        CellStyle hiddenCell = workbook.createCellStyle();
        DataFormat format = workbook.createDataFormat(); 
        hiddenCell.setDataFormat(format.getFormat(";;;"));
        
        Map<String, CellStyle> styles = new HashMap<String, CellStyle>();
        styles.put("STD", stdStyle);
        styles.put("SPEC", specStyle);
        styles.put("GDLN", gdlnStyle);
        styles.put("default", style);
        styles.put("STD_TYPE", stdTextStyle);
        styles.put("GDLN_TYPE", gdlnTextStyle);
        styles.put("SPEC_TYPE", specTextStyle);
        styles.put("Flag", flagTextStyle);
        styles.put("category", category);
        styles.put("columnStyle", textStyle);
		styles.put("hiddenStyle", hiddenCell);
        return styles;
    }
}
