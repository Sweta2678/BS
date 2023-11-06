package com.ihg.brandstandards.report;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.xml.bind.JAXBException;

import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * Bean to store Reports configurations.
 * 
 * @author kryvora
 * 
 */
public class ReportConfigLoader
{
    private static final Log LOG = LogFactoryUtil.getLog(ReportConfigLoader.class);
    private static final String DEFAULT_CONF_FILE = "resources/xls_report_config.xml";

    private static Map<String, ReportConfig> reportConfigMap;
    private String fileName;

    /**
     * Default constructor.
     */
    public ReportConfigLoader()
    {
    }

    /**
     * Preferred constructor.
     * 
     * @param fileName file name including path
     */
    public ReportConfigLoader(String fileName)
    {
        this.fileName = fileName;
    }

    /**
     * Load report configurations.
     */
    public void loadConfig()
    {
        loadConfig(fileName);
    }

    /**
     * Load report configurations.
     * 
     * @param fileName file name
     */
    public void loadConfig(String fileName)
    {
        InputStream stream = this.getClass().getClassLoader().getResourceAsStream(fileName);
        loadConfig(stream);
    }

    /**
     * Load report configurations.
     * 
     * @param stream input stream
     */
    public synchronized static void loadConfig(InputStream stream)
    {
        try
        {
            reportConfigMap = ReportConfigFactory.createConfig(stream);
            LOG.debug("config size is " + reportConfigMap.size());
        }
        catch (JAXBException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e) + "\n" + e.getMessage());
        }
    }

    /**
     * Getter for report configurations.
     * 
     * @return the reportConfigMap
     */
    public static Map<String, ReportConfig> getReportConfigMap()
    {
        if (reportConfigMap == null)
        {
            ReportConfigLoader loader = new ReportConfigLoader();
            loader.loadConfig(DEFAULT_CONF_FILE);
        }
        return reportConfigMap;
    }

    /**
     * Get report configurations for specified report id.
     * 
     * @param reportId report id
     * @return ReportConfig
     */
    public static ReportConfig getReportConfig(final String reportId)
    {
        Map<String, ReportConfig> reportConfig = ReportConfigLoader.getReportConfigMap();
        return reportConfig.get(reportId);
    }

    /**
     * Setter for report configurations.
     * 
     * @param reportConfigMap the reportConfigMap to set
     */
    public static void setReportConfigMap(Map<String, ReportConfig> reportConfigMap)
    {
        ReportConfigLoader.reportConfigMap = reportConfigMap;
    }

    /**
     * Get sorted list of report configurations.
     * 
     * @return list of report configurations.
     */
    public static List<ReportConfig> getSortedReportConfig()
    {
        List<ReportConfig> configList = new ArrayList<ReportConfig>();
        
        if (reportConfigMap == null)
        {
            reportConfigMap = getReportConfigMap();
        }
        
        for (Entry<String, ReportConfig> entry : reportConfigMap.entrySet())
        {
            configList.add(entry.getValue());
        }
        sortRecords(configList);

        return configList;
    }

    /**
     * Sort records for report.
     * 
     * @param configList - list of report configurations
     */
    private static void sortRecords(List<ReportConfig> configList)
    {
        Collections.sort(configList, new Comparator<ReportConfig>()
        {
            public int compare(ReportConfig s1, ReportConfig s2)
            {
                return compareLong(Long.parseLong(s1.getId()), Long.parseLong(s2.getId()));
            }

            /**
             * Compare long values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            private int compareLong(long v1, long v2)
            {
                if (v1 > v2)
                {
                    return 1;
                }
                else if (v1 < v2)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }

            /**
             * Compare String values.
             * 
             * @param v1 - value 1
             * @param v2 - value 2
             * @return 1, 0, -1
             */
            /*
                        private int compareString(String v1, String v2)
                        {
                            if (v1 == null && v2 == null)
                            {
                                return 0;
                            }
                            else if (v1 == null)
                            {
                                return -1;
                            }
                            else if (v2 == null)
                            {
                                return 1;
                            }
                            return v1.toLowerCase().compareTo(v2.toLowerCase());
                        }
            */
        });
    }
}
