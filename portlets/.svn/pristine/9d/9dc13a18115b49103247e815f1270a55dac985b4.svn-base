package com.ihg.brandstandards.report;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

/**
 * Report Configuration Factory.
 * 
 * @author kryvora
 * 
 */
public class ReportConfigFactory
{
    /**
     * Create configuration from specified file.
     * 
     * @param filePath file
     * @return configuration map
     * @throws FileNotFoundException exception
     * @throws JAXBException exception
     */
    public static Map<String, ReportConfig> createConfig(String filePath) throws FileNotFoundException, JAXBException
    {
        FileInputStream fstream = new FileInputStream(filePath);
        return createConfig(fstream);
    }

    /**
     * Create configuration from InputStream.
     * 
     * @param stream InputStream
     * @return configuration map
     * @throws JAXBException jaxb exception
     */
    public static Map<String, ReportConfig> createConfig(InputStream stream) throws JAXBException
    {
        JAXBContext jaxbContext = JAXBContext
                .newInstance(new Class[] { ObjectFactory.class });
        Unmarshaller unmarshaller = jaxbContext.createUnmarshaller();
        unmarshaller.setEventHandler(new ReportConfigValidationEventHandler());
        @SuppressWarnings("unchecked")
        JAXBElement<ReportList> reportListElement = (JAXBElement<ReportList>) unmarshaller.unmarshal(stream);
        ReportList config = reportListElement.getValue();
        return getReportConfig(config);
    }

    /**
     * Create map with report configurations.
     * 
     * @param configs list of report configurations
     * @return map with report configurations.
     */
    private static Map<String, ReportConfig> getReportConfig(ReportList configs)
    {
        Map<String, ReportConfig> reportMap = new HashMap<String, ReportConfig>();
        if (configs != null)
        {
            for (ReportConfig report : configs.getReport())
            {
                if (report.isActive())
                {
                    reportMap.put(report.getId(), report);
                }
            }
        }
        return reportMap;
    }
}
