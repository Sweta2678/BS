package com.ihg.brandstandards.custom.report;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.JAXBException;

import org.apache.poi.openxml4j.exceptions.InvalidFormatException;

import com.ihg.brandstandards.bridge.model.BadCell;
import com.ihg.brandstandards.bridge.model.Record;
import com.ihg.brandstandards.bridge.model.XlsModelData;
import com.ihg.brandstandards.spreadsheet.mapping.XLSRecordMappingFactory;
import com.ihg.brandstandards.spreadsheet.mapping.XlsFieldMapping;
import com.ihg.brandstandards.spreadsheet.mapping.XlsRecordMapping;
import com.ihg.brandstandards.spreadsheet.process.ProcessXlsFile;
import com.ihg.brandstandards.spreadsheet.process.XlsSheetIterator;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProgressTracker;

/**
 * This class is use while import  by xls file.
 * @author ketan.savaliya
 *
 */
public class ReportProcessXlsFile extends ProcessXlsFile
{

    public ReportProcessXlsFile()
    {
    }

    /**
     * This method is use to convert xls file recored in list form.
     * @param xlsFileName xlsFileName
     * @param inpurtStream inpurtStream
     * @param progressTracker progressTracker
     * @param mappingFor Which type report
     * @param localCD  localCD
     * @return List<Record> list of recored from xls
     * @throws InvalidFormatException InvalidFormatException
     * @throws IOException IOException
     * @throws JAXBException  JAXBException
     * @throws PortalException PortalException
     * @throws SystemException SystemException
     */
    public List<Record> process(File xlsFileName, InputStream inpurtStream, String mappingFor)
            throws InvalidFormatException, IOException, JAXBException, PortalException, SystemException
    {
    	
    	setInvalidRecordId(new ArrayList<String>());
    	setInvalidRow(new ArrayList<Integer>());
        List<String> requiredHeader = new ArrayList<String>();
        XlsRecordMapping mapping = XLSRecordMappingFactory.getMapping(inpurtStream, ReportUtil.REPORT_TYPE_STATES);
        List<XlsFieldMapping> fieldsMapping = mapping.getXlsField();
        for (XlsFieldMapping xlsFldNameMap : fieldsMapping)
        {
        	requiredHeader.add(xlsFldNameMap.getXlsName());
        }
        XlsSheetIterator xlsIterator = new XlsSheetIterator(xlsFileName);
       
        List<XlsModelData> data = xlsIterator.processSpreadsheet(requiredHeader);
        XlsModelData xlsHeader = getXlsHeader(data);
        // we don't need header any more
        data.remove(xlsHeader);
        List<Record> recordList = createRecords(mapping, data, xlsHeader);
       
        return recordList;
    }
    
    /**
     * This method use to create a recored from xls row one by one
     * @param map XlsRecordMapping
     * @param data List<XlsModelData>
     * @param xlsHeader XlsModelData
     * @param progressTracker ProgressTracker
     * @param localCD String
     * @return List<Record>  list of recored from xls
     * @throws PortalException PortalException
     * @throws SystemException SystemException
     */
    protected List<Record> createRecords(XlsRecordMapping map, List<XlsModelData> data, XlsModelData xlsHeader,ProgressTracker progressTracker,String localCD) 
    		throws PortalException, SystemException
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
                Record rec = createRecord(xlsRec, type, xlsHeader, map, localCD);
                recordList.add(rec);
            }
            else
            {
                String errorMessage = "Mapping not found for record type=" +  type +  " row=" +  xlsRec.getRow() +  " id = "
                        +  xlsRec.getId() +  " parent id=" +  xlsRec.getParentId();
                BadCell badCell = new BadCell();
                badCell.setRow(xlsRec.getRow());
                badCell.setWorksheet(xlsRec.getWorksheet());
                badCell.setErrorMessage(errorMessage);
                Record rec = new Record();
                rec.setValid(false);
                rec.addBadCell(badCell);
                recordList.add(rec);
            }
            percentage = Math.min(25 +  (i * 50) / data.size(), 50);
            if(!(oldPercentage==percentage))
            progressTracker.setPercent(percentage);
            oldPercentage=percentage;
            i++;
        }
        return recordList;
    }
    
    /**
     * This method is use to create recored field and validation
     * @param xlsRec XlsModelData
     * @param type String
     * @param xlsHeader XlsModelData
     * @param map XlsRecordMapping
     * @param localCD String
     * @return Record recored creted from xls row
     * @throws PortalException PortalException
     * @throws SystemException SystemException
     */
    protected Record createRecord(XlsModelData xlsRec, String type, XlsModelData xlsHeader, XlsRecordMapping map, String localCD) 
    		throws PortalException, SystemException
    {
        Record rec = new Record();
        rec.setType(type);
        rec.setId(xlsRec.getId());
        rec.setParentId(xlsRec.getParentId() == null ? "0" : xlsRec.getParentId());
        rec.setName(map.getName());
        rec.setClassName(map.getClassName());
        
        validateDuplicate(xlsRec, rec);
        validateById(xlsRec, rec);

        // populate fields for record
        for (int i = 0; i < xlsRec.getColumnCount(); i++)
        {
            String col = ReportUtil.XLS_FIELD_KEY +  i;
            String fieldDesc = (String) xlsHeader.get(col);
            List<XlsFieldMapping> fieldsMapping = map.getXlsField();
            createFields(xlsRec, rec, col, fieldDesc, fieldsMapping, i);
        }

        return rec;
    }

    /**
     * This method is use to process import functionality from given file.
     * @param xlsFile File
     * @param progressTracker ProgressTracker
     * @param localCD String
     * @return List<Record> List of recored
     * @throws InvalidFormatException InvalidFormatException
     * @throws IOException IOException
     * @throws JAXBException JAXBException
     * @throws PortalException PortalException
     * @throws SystemException SystemException
     */
    public List<Record> editStatesProcessXls(File xlsFile) 
    		throws InvalidFormatException,IOException,JAXBException, PortalException, SystemException
    {
        List<Record> records =null;
        ClassLoader classLoader=getClass().getClassLoader();
        InputStream inputStream=classLoader.getResourceAsStream("resources/xls_standards_mapping.xml");
        records = process(xlsFile, inputStream, ReportUtil.REPORT_TYPE_STATES);
        printReport(records);
        return records;
    }
    
    /**
     * This method is use to validate already exist Glossary Term.
     * @param xlsRec XlsModelData
     * @param rec Record
     * @throws SystemException SystemException
     */
    private void validateDuplicate(XlsModelData xlsRec, Record rec) throws SystemException
    {
		if (xlsRec.get(ReportUtil.XLS_FIELD_KEY +  0) == null) 
		{
			Object glossary =  null;// TODO  GlossaryLocalServiceUtil.getGlossaryByTermText((String)xlsRec.get(ReportUtil.XLS_FIELD_KEY +  1));
			if (glossary!= null)
			{
				BadCell badCell = new BadCell(xlsRec.getWorksheet(), xlsRec.getRow()+1, 1, xlsRec.get(ReportUtil.XLS_FIELD_KEY + 1), ReportUtil.XLS_FIELD_TITLE, "Bad Cell");
				rec.addBadCell(badCell);
				rec.setValid(false);
				
			}
		}
    }
    
    /**
     * This method is use to validate Glossary is exist or not by GlossaryId.
     * @param xlsRec XlsModelData
     * @param rec Record
     * @throws SystemException SystemException
     */
    private void validateById(XlsModelData xlsRec, Record rec) throws NumberFormatException, PortalException, SystemException
    {
    	if (xlsRec.get(ReportUtil.XLS_FIELD_KEY +  0) != null)
		{
			// TODO 
//    	    try
//			{
//				GlossaryLocalServiceUtil.getGlossary(Long.valueOf(xlsRec.get(ReportUtil.XLS_FIELD_KEY +  0).toString()));
//			}
//			catch (NoSuchGlossaryException e)
//			{
//				BadCell badCell = new BadCell(xlsRec.getWorksheet(), xlsRec.getRow()+1, 0, xlsRec.get(ReportUtil.XLS_FIELD_KEY + 0), ReportUtil.XLS_FIELD_ID, ReportUtil.MSG_NO_GLOSSARY_FOUND_VALIDATION);
//				rec.addBadCell(badCell);
//				rec.setValid(false);
//			}
		}
    }
    
}
