package com.ihg.brandstandards.spreadsheet;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBException;

import org.apache.commons.lang.time.DateUtils;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ihg.brandstandards.bsadmin.model.BadCell;
import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.spreadsheet.mapping.XLSRecordMappingFactory;
import com.ihg.brandstandards.spreadsheet.mapping.XlsFieldMapping;
import com.ihg.brandstandards.spreadsheet.mapping.XlsRecordMapping;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.bsadmin.model.XlsModelData;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ProgressTracker;

public class ProcessXlsFile
{
    private static final Log LOG = LogFactoryUtil.getLog(ProcessXlsFile.class);
    private char[] alpha = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};
    private List<String> invalidRecordId;
    private List<Integer> invalidRow;
    private List<String> taxonomyIds;
  //  private AbstractXlsPersistenceDataSource dataSource;

    public ProcessXlsFile()
    {
    }

  /*  public AbstractXlsPersistenceDataSource getDataSource()
    {
        return dataSource;
    }

    public void setDataSource(AbstractXlsPersistenceDataSource dataSource)
    {
        this.dataSource = dataSource;
    }
*/
    public List<Record> processXls(File xlsFile,ProgressTracker progressTracker,List<String> taxonomyObjIds) throws InvalidFormatException,IOException,JAXBException
	{
		List<Record> records =null;
		ClassLoader classLoader=getClass().getClassLoader();
	    InputStream inputStream=classLoader.getResourceAsStream("resources/xls_standards_mapping.xml");
	    progressTracker.setPercent(progressTracker.getPercent() + 10);
	    taxonomyIds=taxonomyObjIds;
	    records =process(xlsFile, inputStream,progressTracker);
	    printReport(records);
	    return records;
	}
    
    
    public List<Record> process(File xlsFileName, InputStream inpurtStream,ProgressTracker progressTracker)
            throws InvalidFormatException, IOException, JAXBException
    {
        invalidRecordId = new ArrayList<String>();
        invalidRow = new ArrayList<Integer>();
        List<String> requiredHeader=new ArrayList<String>();
        XlsRecordMapping mapping = XLSRecordMappingFactory.getMapping(inpurtStream, "TaxonomyTranslation");
        List<XlsFieldMapping> fieldsMapping = mapping.getXlsField();
        for (XlsFieldMapping xlsFldNameMap : fieldsMapping)
        {
        	requiredHeader.add(xlsFldNameMap.getXlsName());
        }
        XlsSheetIterator xlsIterator = new XlsSheetIterator(xlsFileName);
       
        List<XlsModelData> data = xlsIterator.processSpreadsheet(requiredHeader,progressTracker);
        XlsModelData xlsHeader = getXlsHeader(data);
        // we don't need header any more
        data.remove(xlsHeader);
        List<Record> recordList = createRecords(mapping, data, xlsHeader,progressTracker);

       /* if (dataSource != null)
        {
            dataSource.persist(recordList);
        }
        else
        {*/
            printDataSourceHelp();
       // }
        return recordList;
    }

    protected List<Record> createRecords(Map<String, XlsRecordMapping> mapping, List<XlsModelData> data, XlsModelData xlsHeader,ProgressTracker progressTracker)
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

    protected List<Record> createRecords(XlsRecordMapping map, List<XlsModelData> data, XlsModelData xlsHeader,ProgressTracker progressTracker)
    {
        List<Record> recordList = new ArrayList<Record>();
        int percentage=25;
        int oldPercentage=25;
        int i=0;
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
            percentage = Math.min(25 + (i * 50) / data.size(), 50);
            if(!(oldPercentage==percentage))
            progressTracker.setPercent(percentage);
            oldPercentage=percentage;
            i++;
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

    private void validateField(XlsFieldMapping mapping, XlsModelData xlsRec, Record field, Record record, int colIndx)
    {
        boolean isRequired = field.isRequired();
        Object val = field.getValue();
        String errMsg = null;

        if (isRequired && val == null)
        {
            field.setValid(false);
            if(LOG.isDebugEnabled()){
                LOG.debug("Required field-============>>>>>"+record.getId());
            }
            errMsg = "Required field is missing value for record type=" + record.getType() + " id=" + record.getId();
                   // + " parent id=" + record.getParentId();
        }
        
        if (field.getColumnName().contains("Index ID")&& val !=null)
        {
            if(!taxonomyIds.contains(val))
            {
            field.setValid(false);
            if(LOG.isDebugEnabled()){
                LOG.debug("Required field-============>>>>>"+record.getId());
            }
            errMsg = "Index ID does not exist in database for id=" + record.getId();
            }
        }
        
        else if ("Date".equals(field.getType()))
        {
            String[] pattern = { "MM-dd-yyyy", "MM/dd/yyyy", "dd MMM yyyy", "yyyy-MM-dd", "yyyyMMdd" };
            try
            {
                DateUtils.parseDate(val.toString(), pattern);
            }
            catch (ParseException e)
            {
                field.setValid(false);
                if(LOG.isDebugEnabled()){
                    LOG.debug("Invalid date=-============>>>>>"+record.getId());
                }
                errMsg = "Invalid date format = " + val.toString() + "  for record type=" + record.getType() + " id="
                        + record.getId() + " parent id=" + record.getParentId();
            }
        }

        if (field.isValid() && !record.getParentId().equals("0"))
        {
            if (invalidRecordId.contains(record.getParentId()))
            {
                field.setValid(false);
                if(LOG.isDebugEnabled()){
                    LOG.debug("Parent record=-============>>>>>"+record.getId());
                }
                errMsg = "Parent record is invalid for type=" + record.getType() + " id=" + record.getId() + " parent id="
                        + record.getParentId();
            }
        }

        if (!field.isValid() && !invalidRow.contains(xlsRec.getRow()))
        {
            record.setValid(false);
            BadCell badCell = new BadCell(xlsRec.getWorksheet(), xlsRec.getRow(), colIndx, field.getValue(), field.getColumnName(), errMsg);
            record.addBadCell(badCell);
            if (record.getParentId().equals("0") && !invalidRecordId.contains(record.getId()))
            {
                invalidRecordId.add(record.getId());
            }
            invalidRow.add(xlsRec.getRow());
        }
    }

    protected XlsModelData getXlsHeader(List<XlsModelData> data) throws InvalidFormatException
    {
        XlsModelData xlsHeader = null;
        if (BSAdminConstants.XLS_HEADER_TYPE.equals(data.get(0).getType()))
        {
            xlsHeader = data.get(0);
        }
        else
        {
            for (XlsModelData record : data)
            {
                if (BSAdminConstants.XLS_HEADER_TYPE.equals(record.getType()))
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

    public void printReport(List<Record> recordList)
    {
        for (Record rec : recordList)
        {
            if (!rec.isValid())
            {
                if(LOG.isDebugEnabled()){
                    LOG.debug("Invalid XLS record: ");
                }
                List<BadCell> cells = rec.getBadCell();
                for (BadCell cell : cells)
                {
                    if(LOG.isDebugEnabled()){
                        LOG.debug("Row=" + cell.getRow() + 
                            "' column name='" + cell.getColumnName() + 
                            "' worksheet='" + cell.getWorksheet() + 
                            "' error message='" + cell.getErrorMessage() + 
                            "' value='" + cell.getValue() + "'");
                    }
                }
            }
        }
    }
    
    public List<Record> getBadRows(List<Record> recordList)
    {
    	List<Record> badRecords=new ArrayList<Record>();
        for (Record rec : recordList)
        {
            if (!rec.isValid())
            {
                badRecords.add(rec);
            }
        }
        return badRecords;
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

    private void printDataSourceHelp()
    {
        LOG.debug("AbstractXlsPersistenceDataSource was NOT set!!! Please configure Spring bean to set Data Source.");
        LOG.debug("Example: \n");
        StringBuilder builder = new StringBuilder();
        builder.append("<bean id=\"brandstandDataSourceTarget\" class=\"com.liferay.portal.spring.jndi.JndiObjectFactoryBean\" lazy-init=\"true\"> \n");
        builder.append("    <property name=\"jndiName\"> \n");
        builder.append("        <value>brandstandDataSource</value> \n");
        builder.append("    </property> \n");
        builder.append("</bean> \n");
        builder.append("<bean id=\"brandstandDataSource\" class=\"org.springframework.jdbc.datasource.LazyConnectionDataSourceProxy\" lazy-init=\"true\"> \n");
        builder.append("    <property name=\"targetDataSource\"> \n");
        builder.append("        <ref bean=\"brandstandDataSourceTarget\" /> \n");
        builder.append("    </property> \n");
        builder.append("</bean> \n");
        builder.append("\n");
        builder.append("<bean id=\"xlsProcess\" class=\"com.ihg.spreadsheet.process.ProcessXlsFile\"> \n");
        builder.append("    <property name=\"dataSource\" ref=\"brandstandDataSource\" /> \n");
        builder.append("</bean> \n");
        LOG.debug(builder);
    }
    
    /**
     * This method is use to set/initialization for invalidRecordId.
     * Method is used for Glossary Import
     * @param invalidRecordIdList
     */
    protected void setInvalidRecordId(List<String> invalidRecordIdList)
    {
    	invalidRecordId = invalidRecordIdList;
    }
    
    /**
     * This method is use to set/initialization for invalidRowList.
     * Method is used for Glossary Import
     * @param invalidRecordIdList
     */
    protected void setInvalidRow(List<Integer> invalidRowList)
    {
    	invalidRow = invalidRowList;
    }
}
