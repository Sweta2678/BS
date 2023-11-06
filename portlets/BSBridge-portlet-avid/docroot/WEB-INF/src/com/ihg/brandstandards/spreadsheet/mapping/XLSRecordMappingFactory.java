package com.ihg.brandstandards.spreadsheet.mapping;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class XLSRecordMappingFactory
{
    private static final String SPREADSHEET_MAPPING_PACKAGE = "com.ihg.brandstandards.spreadsheet.mapping";
    private static final int KEY_TYPE_RECORD_NAME = 1;
    private static final int KEY_TYPE_RECORD_TYPE = 2;
    

    public static XlsRecordMapping getMapping(InputStream stream, String recordName) throws UnsupportedMappingException, JAXBException
    {
        Map<String, XlsRecordMapping> recordMap = createMapping(stream);

        if (recordMap == null || recordMap.isEmpty() || !recordMap.containsKey(recordName))
        {
            throw new UnsupportedMappingException("Mapping does not exist for record name " + recordName);
        }

        return recordMap.get(recordName);
    }

    public static XlsRecordMapping getMapping(String filePath, String recordName) throws UnsupportedMappingException, FileNotFoundException, JAXBException
    {
        Map<String, XlsRecordMapping> recordMap = createMapping(filePath);

        if (recordMap == null || recordMap.isEmpty() || !recordMap.containsKey(recordName))
        {
            throw new UnsupportedMappingException("Mapping does not exist for record name " + recordName);
        }

        return recordMap.get(recordName);
    }

    public static XlsRecordMapping getMappingByRecordType(String filePath, String recordType) throws UnsupportedMappingException, FileNotFoundException, JAXBException
    {
        Map<String, XlsRecordMapping> recordMap = createMapping(filePath);
        
        if (recordMap == null || recordMap.isEmpty())
        {
            throw new UnsupportedMappingException("Mapping is empty");
        }
        
        XlsRecordMapping record = null;
        for (String key : recordMap.keySet())
        {
            XlsRecordMapping mapping = recordMap.get(key);
            if (mapping.getType().equals(recordType))
            {
                record = mapping;
                break;
            }
        }

        if (record == null)
        {
            throw new UnsupportedMappingException("Mapping does not exist for record type " + recordType);
        }

        return record;
    }

    public static Map<String, XlsRecordMapping> createMappingByRecordType(String filePath) throws FileNotFoundException, JAXBException
    {
        Map<String, XlsRecordMapping> recordMapping = null;
        FileInputStream fstream = new FileInputStream(filePath);
        recordMapping = createMapping(fstream, KEY_TYPE_RECORD_TYPE);
        return recordMapping;
    }

    public static Map<String, XlsRecordMapping> createMapping(String filePath) throws FileNotFoundException, JAXBException
    {
        Map<String, XlsRecordMapping> recordMapping = null;
        FileInputStream fstream = new FileInputStream(filePath);
        recordMapping = createMapping(fstream);
        return recordMapping;
    }

    public static Map<String, XlsRecordMapping> createMapping(InputStream stream) throws JAXBException
    {
        return createMapping(stream, KEY_TYPE_RECORD_NAME);
    }
    
    private static Map<String, XlsRecordMapping> createMapping(InputStream stream, int keyType) throws JAXBException
    {
        Map<String, XlsRecordMapping> xlsMapping = null;
        JAXBContext jaxbContext = JAXBContext.newInstance(SPREADSHEET_MAPPING_PACKAGE);
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setEventHandler(new MappingValidationEventHandler());
        JAXBElement<XlsRecordListMapping> recordMappingElement = (JAXBElement<XlsRecordListMapping>) unmarshaller.unmarshal(stream);
        XlsRecordListMapping mapping = recordMappingElement.getValue();
        xlsMapping = getXlsMapping(mapping, keyType);
        return xlsMapping;
    }

    private static Map<String, XlsRecordMapping> getXlsMapping(XlsRecordListMapping mapping, int keyType)
    {
        Map<String, XlsRecordMapping> xlsMapping = null;
        if (mapping != null && mapping.getXlsRecord() != null && !mapping.getXlsRecord().isEmpty())
        {
            xlsMapping = new HashMap<String, XlsRecordMapping>();
            List<XlsRecordMapping> recordList = mapping.getXlsRecord();
            for (XlsRecordMapping record : recordList)
            {
                if (keyType == KEY_TYPE_RECORD_NAME)
                    xlsMapping.put(record.getName(), record);
                else
                    xlsMapping.put(record.getType(), record);
            }
        }
        return xlsMapping;
    }
}
