	package com.ihg.me2.brandstandards.custom.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ihg.me2.brandstandards.custom.pojo.StandardsSearchCriteria;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.ihg.me2.brandstandards.custom.util.WCOQueryUtil;

public class SearchQueryTest
{
    @Test
    public final void testGenerateSearchQuery()
    {
        StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        List<String> searchCriteria = new ArrayList<String>();
        //searchCriteria.add("Facade");
        //searchCriteria.add("a la carte");
        
        List<String> replacedSearchCriteria = new ArrayList<String>();
        //replacedSearchCriteria.add("Façade");
        //replacedSearchCriteria.add("à la carte");
        
        List<String> idSearchCriteria = new ArrayList<String>();
        idSearchCriteria.add("548551");
        idSearchCriteria.add("548550");
        
        criteria.setTextSearchType("all");
        //criteria.setTextSearchType("exact");
        //criteria.setTextSearchType("any");
        
        //criteria.setTextSearch("Facade");
        //criteria.setReplacedTextSearch("Façade");
        //criteria.setTextSearch("a la carte");
        //criteria.setReplacedTextSearch("à la carte");
        
        criteria.setSearchCriteria(searchCriteria);
        criteria.setReplacedSearchCriteria(replacedSearchCriteria);
        criteria.setIdSearchCriteria(idSearchCriteria);
        System.out.println(QueryUtils.generateSearchQuery(74037, "en_GB", "USA", criteria));
        //System.out.println(QueryUtils.generateSearchQuery(53021, "en_GB", "USA", criteria));
    }
   
    @Test
    public final void testGenerateSearchQueryStaging()
    {
        StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        List<String> searchCriteria = new ArrayList<String>();
        //searchCriteria.add("colleague");
        //searchCriteria.add("must");
        //searchCriteria.add("be");
        List<String> replacedSearchCriteria = new ArrayList<String>();
        //replacedSearchCriteria.add("Façade");
        //replacedSearchCriteria.add("à la carte");
        
        List<String> idSearchCriteria = new ArrayList<String>();
        //idSearchCriteria.add("19471");
        //idSearchCriteria.add("23667");
        criteria.setTextSearchType("all");
        //criteria.setTextSearch("colleague must be");
        criteria.setSearchCriteria(searchCriteria);
        criteria.setIdSearchCriteria(idSearchCriteria);
        criteria.setReplacedSearchCriteria(replacedSearchCriteria);
        System.out.println(QueryUtils.generateSearchQueryStaging(53021, "en_GB", "USA", criteria));
        //System.out.println(QueryUtils.generateSearchQueryStaging(53021, "en_GB", "VN", "USA", criteria));
    }
    
    @Test
    public final void testGetWCOSearchQueryProd()
    {
    	StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        criteria.setFilterByNew(true);
        criteria.setFilterByTextUpdate(true);
        criteria.setFilterByComplianceUpdate(true);
        criteria.setFilterByLifecycleUpdate(true);
        criteria.setFilterByRemoved(true);
        
        List<String> searchCriteria = new ArrayList<String>();
        //searchCriteria.add("combustible");
        //searchCriteria.add("materials");
        //searchCriteria.add("one");
        List<String> idSearchCriteria = new ArrayList<String>();
        //idSearchCriteria.add("66904");
        //idSearchCriteria.add("500048");
        criteria.setTextSearchType("all");
        //criteria.setTextSearch("colleague must be");
        criteria.setSearchCriteria(searchCriteria);
        criteria.setIdSearchCriteria(idSearchCriteria);
        
        List<String> arlHotelLocations = new ArrayList<String>();
        //arlHotelLocations.add("244");
        criteria.setLocHotel(arlHotelLocations);
        
        List<String> arlGuestJourney = new ArrayList<String>();
        //arlGuestJourney.add("187");
        criteria.setSpecialism(arlGuestJourney);
        
        System.out.println(WCOQueryUtil.getWCOSearchQueryProd("en_GB", "IC", "CHN", criteria, "72002", "61035"));
        System.out.println(";");
        System.out.println(WCOQueryUtil.getWCORemovedSearchQueryProd("en_GB", "IC", "CHN", criteria, "72002", "61035"));
        System.out.println(";");
        
        /*System.out.println(WCOQueryUtil.getWCOSearchQueryProd("en_GB", "HI", "CHN", criteria, "61037", "53026"));
        System.out.println(";");
        System.out.println(WCOQueryUtil.getWCORemovedSearchQueryProd("en_GB", "HI", "CHN", criteria, "61037", "53026"));
        System.out.println(";");
        
        System.out.println(WCOQueryUtil.getWCOSearchQueryProd("en_GB", "CW", "USA", criteria, "74016", "74011"));
        System.out.println(";");
        System.out.println(WCOQueryUtil.getWCORemovedSearchQueryProd("en_GB", "CW", "USA", criteria, "74016", "74011"));
        System.out.println(";");*/
    }
   
    @Test
    public final void testGetWCOSearchQueryStaging()
    {
        StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        criteria.setFilterByNew(true);
        criteria.setFilterByTextUpdate(true);
        criteria.setFilterByComplianceUpdate(true);
        criteria.setFilterByLifecycleUpdate(true);
        criteria.setFilterByRemoved(true);
        
        List<String> searchCriteria = new ArrayList<String>();
        //searchCriteria.add("colleague");
        //searchCriteria.add("must");
        //searchCriteria.add("be");
        List<String> idSearchCriteria = new ArrayList<String>();
        //idSearchCriteria.add("66904");
        //idSearchCriteria.add("23667");
        criteria.setTextSearchType("all");
        //criteria.setTextSearch("colleague must be");
        criteria.setSearchCriteria(searchCriteria);
        criteria.setIdSearchCriteria(idSearchCriteria);
        
        List<String> arlHotelLocations = new ArrayList<String>();
        arlHotelLocations.add("244");
        criteria.setLocHotel(arlHotelLocations);
        
        List<String> arlGuestJourney = new ArrayList<String>();
        arlGuestJourney.add("187");
        criteria.setSpecialism(arlGuestJourney);
        
        System.out.println(WCOQueryUtil.getWCOSearchQueryStage("en_GB", "EX", "USA", criteria, "71015", "71014"));
        System.out.println(";");
        System.out.println(WCOQueryUtil.getWCORemovedSearchQueryStage("en_GB", "EX", "USA", criteria, "71015", "71014"));
        System.out.println(";");
    }
    
    @Test
    public final void testGetWXOAllIndexQuery(){
        System.out.println(WCOQueryUtil.getWCOAllIndexQueryProd("72005", "61034"));
        System.out.println(WCOQueryUtil.getWCOAllIndexQueryStage("70007", "70006"));
    }

    @Test
    public final void testSearchQueryForAllSupportingMaterial() {
    	StandardsSearchCriteria criteria = new StandardsSearchCriteria();
        List<String> searchCriteria = new ArrayList<String>();
        //searchCriteria.add("Facade");
        searchCriteria.add("a la carte");
        
        List<String> replacedSearchCriteria = new ArrayList<String>();
        //replacedSearchCriteria.add("Façade");
        replacedSearchCriteria.add("à la carte");
        
        List<String> idSearchCriteria = new ArrayList<String>();
        //idSearchCriteria.add("19471");
        //idSearchCriteria.add("23667");
        
        //criteria.setTextSearchType("all");
        criteria.setTextSearchType("exact");
        //criteria.setTextSearchType("any");
        
        //criteria.setTextSearch("Facade");
        //criteria.setReplacedTextSearch("Façade");
        criteria.setTextSearch("a la carte");
        criteria.setReplacedTextSearch("à la carte");
        
        criteria.setSearchCriteria(searchCriteria);
        criteria.setReplacedSearchCriteria(replacedSearchCriteria);
        criteria.setIdSearchCriteria(idSearchCriteria);	
        System.out.println(QueryUtils.generateSearchQueryForStagingSupportingMaterial(61034, "en_GB", "CV", "USA", criteria));
        System.out.println(QueryUtils.generateSearchQueryForAllSupportingMaterial(61034, "en_GB", "CV", "USA", criteria));
    }
    
    @Test
    public final void testSearchQueryForSupportingMaterial() {
    	System.out.println(QueryUtils.getStagingSupportingMaterial(61034, 120914, "en_GB", "USA"));
    	System.out.println(QueryUtils.getSupportingMaterial(61034, 120914, "en_GB", "USA"));
    }
    
}
