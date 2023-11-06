package com.ihg.brandstandards.custom.report;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashSet;
import java.util.List;

public class ReportUtil 
{
    
    public static final String DEFAULT_LOCALE = "en_GB";
    
    public static final String XLS_FIELD_ID =  "STD_ID";

    public static final String XLS_FIELD_TYPE = "Type";

    public static final String XLS_FIELD_TITLE  =  "Title"; 

    public static final String XLS_FIELD_CURRENT_TITLE = "Current Title";
    
    public static final String REPORT_TYPE_PREVIEW =  "BridgePublishPreview";
    
    public static final String REPORT_TYPE_STATES =  "BridgePublishState";
    
    public static final List<String> PREVIEW_HEADERS = new ArrayList<String>(Arrays.asList("STD_ID","TYPE", "TITLE", "CURRENT_TITLE"));
    
    public static final List<String> STATES_HEADERS = new ArrayList<String>(Arrays.asList("STD_ID","TYPE", "TITLE", "STATE"));
    
    public static final String XLS_FIELD_KEY = "c_";
    
    /**
     * Remove duplicate string from passed string.
    
     * @param regionId Region id.
     * @return String of region name.
     */
    public static String deleteDuplicate(String s) 
    {
        return new LinkedHashSet<String>(Arrays.asList(s.split(", "))).toString().replaceAll("(^\\[|\\]$)", "");
    }
}
