package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.ihg.brandstandards.bridge.util.BridgeQueryUtils;
import com.ihg.brandstandards.custom.gem.model.QualityLeadModel;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.liferay.portal.kernel.util.StringPool;

/**
 * This class will have jUnit test methods for all QueryUtils.
 * @author LMummanedi
 */
public class QueryUtilsTest
{
    
    @Test
    public final void testGetActiveLangsByRegion()
    {
        System.out.println(BridgeQueryUtils.getMyPublicationQuery("EX", "2", "AMER", null));
    }
    
    @Test
    public final void testGetActiveSecondLangsByRegion()
    {
        System.out.println(QueryUtils.getActiveSecondLangsByRegion("AMER"));
    }
    
    @Test
    public final void testGetTranslationProgressQuery()
    {
        String publishId = "18111";
        String regionCd = "AMEA";
        String regionId = "3";
        String translationProgress = "";//BridgeQueryUtils.getTranslationProgressQuery(false);
        System.out.println("Actual:"+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:"+translationProgress);
    }
    
    @Test
    public final void allRegionsTranslationProgressQuery()
    {
        String publishId = "18111";
        String translationProgress = "";//BridgeQueryUtils.getTranslationProgressQuery(true);
        System.out.println("All Regions Count Actual:"+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("All Regions Count Executable:"+translationProgress);
    }
    
    @Test
    public final void testGetCMSAllIndexQuery(){
        System.out.println(BridgeQueryUtils.getCMSAllIndexQuery());
    }
       
    @Test
    public final void testGetUnpublishStandardsQuery()
    {
        System.out.println(BridgeQueryUtils.getUnpublishStandardsQuery(31250, 3, "HI", "AMEA", StringPool.BLANK));
    }
    
    @Test
    public final void testUpdateUnpublishedToPublishedRecords()
    {
        System.out.println(BridgeQueryUtils.updateUnpublishedToPublishedRecords(70030, "UL", 3, "mummanl", "416554"));
    }
    
    @Test
    public final void getLockOrUnLockQuery(){
    	String chainCode = "HI";
    	String stdIds = "23466,23564,23565,23566,23567,23568,23569,23667,23675,23676,10";
    	StringBuffer lockQuery  = new StringBuffer("DECLARE l_std_ids CLOB := ?; BEGIN ");
        lockQuery.append(" UPDATE STD SET STAT_DESC='");
        lockQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	lockQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, STAGE_STD ss, CHAIN_STD cs WHERE");
    	lockQuery.append(" ss.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='STAGING' AND CHAIN_CD='");
    	lockQuery.append(chainCode);
    	lockQuery.append("') AND s.STD_ID=ss.STD_ID AND s.STD_ID=cs.STD_ID AND s.STAT_DESC!='DELETED' AND cs.CHAIN_CD='");
    	lockQuery.append(chainCode);
    	lockQuery.append("' AND s.STD_ID IN (SELECT COLUMN_VALUE AS STD_ID FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_std_ids)))); COMMIT;");
    	lockQuery.append(" END;");
     	String query = lockQuery.toString().replace("?", "&&");
     	query = query.replaceFirst("&&", "'"+stdIds+"'");
     	System.out.println("Lock Query: "+query);
     	
     	StringBuffer unLockQuery  = new StringBuffer("DECLARE l_std_ids CLOB := ?; BEGIN ");
    	unLockQuery.append(" UPDATE STD SET STAT_DESC='");
    	unLockQuery.append(BSCommonConstants.AVAILABLE_STATUS);
    	unLockQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, STAGE_STD ss, CHAIN_STD cs WHERE");
    	unLockQuery.append(" ss.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='STAGING' AND CHAIN_CD='");
    	unLockQuery.append(chainCode);
    	unLockQuery.append("') AND s.STD_ID=ss.STD_ID AND s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
    	unLockQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	unLockQuery.append("' AND cs.CHAIN_CD='");
    	unLockQuery.append(chainCode);
    	unLockQuery.append("' AND s.STD_ID IN (SELECT COLUMN_VALUE AS STD_ID FROM TABLE(brandstandardspublish.delimclob_to_num_table(l_std_ids)))); COMMIT;");
    	unLockQuery.append(" END;");
    	query = unLockQuery.toString().replace("?", "&&");
     	query = query.replaceFirst("&&", "'"+stdIds+"'");
    	System.out.println("UnLock Query: "+query);
    	
    	StringBuffer lockedCountQuery  = new StringBuffer("SELECT COUNT(s.STD_ID) FROM STD s, STAGE_STD ss, CHAIN_STD cs WHERE");
        lockedCountQuery.append(" ss.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='STAGING' AND CHAIN_CD='");
        lockedCountQuery.append(chainCode);
        lockedCountQuery.append("') AND s.STD_ID=ss.STD_ID AND s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
        lockedCountQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
        lockedCountQuery.append("' AND cs.CHAIN_CD='");
        lockedCountQuery.append(chainCode);
        lockedCountQuery.append("'");
        System.out.println("Locked Count Query: "+lockedCountQuery.toString());
        
        StringBuffer releaseAllLocksQuery  = new StringBuffer("UPDATE STD SET STAT_DESC='");
    	releaseAllLocksQuery.append(BSCommonConstants.AVAILABLE_STATUS);
    	releaseAllLocksQuery.append("' WHERE STD_ID IN (SELECT s.STD_ID FROM STD s, STAGE_STD ss, CHAIN_STD cs WHERE");
    	releaseAllLocksQuery.append(" ss.PUBLISH_ID=(SELECT PUBLISH_ID FROM PUBLISH WHERE PUBLISH_STAT_CD='ACTIVE' AND PUBLISH_ENVIRONMENT_NM='STAGING' AND CHAIN_CD='");
    	releaseAllLocksQuery.append(chainCode);
    	releaseAllLocksQuery.append("') AND s.STD_ID=ss.STD_ID AND s.STD_ID=cs.STD_ID AND s.STAT_DESC='");
    	releaseAllLocksQuery.append(BSCommonConstants.PUBLISH_LOCK_STATUS);
    	releaseAllLocksQuery.append("' AND cs.CHAIN_CD='");
    	releaseAllLocksQuery.append(chainCode);
    	releaseAllLocksQuery.append("')");
    	System.out.println("Release All Lockeds: "+releaseAllLocksQuery.toString());
    }

    @Test
    public final void getMyPublicationIssuesCountQuery(){
    	String publishId = "31204";
        String regionId = "3";
        String vldStatusExclude = "GLBLMST,";
        StringBuffer issueCountQuery  = new StringBuffer("SELECT COUNT(BRIDGE_PUBLICATION_IMPORT_ID) AS ISSUE_COUNT FROM BRIDGE_PUBLISH_IMPORT WHERE PUBLISH_ID=");
    	issueCountQuery.append(publishId);
    	issueCountQuery.append(" AND RGN_ID=");
    	issueCountQuery.append(regionId);
    	issueCountQuery.append(" AND VLD_STAT_CD NOT IN (");
    	int counter = 0;
    	for(String excludeStatus : vldStatusExclude.split(StringPool.COMMA)){
    		if(counter > 0){
    			issueCountQuery.append(StringPool.COMMA);
    		}
    		issueCountQuery.append("'");
    		issueCountQuery.append(excludeStatus);
    		issueCountQuery.append("'");
    		counter++;
    	}
    	issueCountQuery.append(")");
        System.out.println(issueCountQuery.toString());
    }

    @Test
    public final void getMustPublishStandardsByIdsAndBrandQuery(){
    	String stdIdsByCommaSeprated = "280";
    	String brand = "CV";
    	
    	System.out.println("Must Not Publish Listing Query: "+BridgeQueryUtils.getMustPublishStandardsByIdsOrBrandQuery(null, brand));
    	System.out.println("Must Not Publish Listing Query: "+BridgeQueryUtils.getMustNotPublishStandardsByIdsOrBrandQuery(null, brand));
    	
    	System.out.println("Find By Id Must Publish Query: "+BridgeQueryUtils.getMustPublishStandardsByIdsOrBrandQuery(stdIdsByCommaSeprated, brand));
    	System.out.println("Find By Id Must Not Publish Query: "+BridgeQueryUtils.getMustNotPublishStandardsByIdsOrBrandQuery(stdIdsByCommaSeprated, brand));
    }

    @Test
    public final void getIssueCountForMustPublishQuery()
    {
    	System.out.println("Global Must Publish Issue Count Query: "+BridgeQueryUtils.getIssueCountForMustPublishQuery("Y", 31251, "CP"));
    }

    @Test
    public final void getGlobalMustPublishImportProcedure()
    {
        String publishId = "31173";
        String chainCd = "CP";
        String screenName= "mummanl";
        String stdIds ="10,18,20";
        String mustImportQuery = BridgeQueryUtils.getGlobalMustPublishImportProcedure();
        System.out.println("Actual:  "+mustImportQuery);
        mustImportQuery = mustImportQuery.replace("?", "&&");
        mustImportQuery = mustImportQuery.replaceFirst("&&", publishId);
        mustImportQuery = mustImportQuery.replaceFirst("&&", "'"+screenName+"'");
        mustImportQuery = mustImportQuery.replaceFirst("&&", "'"+chainCd+"'");
        mustImportQuery = mustImportQuery.replaceFirst("&&", "'"+stdIds+"'");
        //mustImportQuery = mustImportQuery.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+mustImportQuery);
    }

    @Test
    public final void getAddByImportProcedure()
    {
    	String publishId = "53034";
        String chainCd = "IN";
        String regionId = "3";
        String screenName= "mummanl";
        String stdIds ="57696,78017,78018,78019";
        String addByImportQuery = BridgeQueryUtils.getAddByImportProcedure();
        System.out.println("Actual:  "+addByImportQuery);
        addByImportQuery = addByImportQuery.replace("?", "&&");
        addByImportQuery = addByImportQuery.replaceFirst("&&", publishId);
        addByImportQuery = addByImportQuery.replaceFirst("&&", regionId);
        addByImportQuery = addByImportQuery.replaceFirst("&&", "'"+chainCd+"'");
        addByImportQuery = addByImportQuery.replaceFirst("&&", "'"+screenName+"'");
        addByImportQuery = addByImportQuery.replaceFirst("&&", "'"+stdIds+"'");
        System.out.println("Executable:  "+addByImportQuery);
    }
    
    @Test
    public final void getAddByImportIssuesCount()
    {
    	long publishId = 31185;
    	long regionId = 2;
        String vldStatusExclude = "GLBLMST,UNPUBLISH";
        
        System.out.println("Add By Import Issue Count Query:  "+BridgeQueryUtils.getAddByImportIssuesCount(publishId, regionId, vldStatusExclude));
    }

    @Test
    public final void addToMyPublicationQuery()
    {
    	long bridgePublishId = 53034;
    	long prodPublishId = 54056;
    	long regionId = 3;
    	String brandCode = "IN";
    	String screenName = "mummanl";
    	System.out.println("Add To My Publication Query:  "+BridgeQueryUtils.updateBridgePublishAndCountryFromImport(bridgePublishId, prodPublishId, brandCode, regionId, screenName));
    }
    
    @Test
    public final void getCreateManualsQuery(){
    	long publishQueueId = 290; 
    	long publishId = 51004;
    	String emailAddress = "debi.allen@ihg.com";
    	String userName = "Debi Allen";
    	System.out.println("Create Manuals Query:  "+BridgeQueryUtils.createManuals(publishQueueId, publishId, emailAddress, userName));
    }
    
    @Test
    public final void getGemScoringQuery(){
    	long publishDeptId = 350012; //GEM_PUBLISH_DEPT_ID SELECT gem_publish_dept_id FROM gem_publish_dept WHERE publish_id=116012;
    	long parentPublishId = 113001; //Bridge PUBLISH ID
    	long publishId = 116012; //PUBLISH_ID
    	long seTemplateId = 490031; 
    	long regionId = 5;
    	String userName = "mummanl";
    	
    	System.out.println("Gem Scoring Query:  "+GemQueryUtils.getGemScoringQuery(publishDeptId, parentPublishId, publishId, seTemplateId, regionId, userName));
    }
    
    @Test
    public final void getGemSaveQuery(){
    	long publishDeptId = 150001;
    	long bridgePublishId = 88001;
    	long gemPublishId = 91001;
    	long regionId = 2;
    	String userName = "mummanl";
    	List<QualityLeadModel> records = new ArrayList<QualityLeadModel>();
    	QualityLeadModel model = new QualityLeadModel();
    	model.setBucketDesc("Crisis and Incident");
    	model.setBucketId(10601);
    	model.setCategoryDesc("Back Office");
    	model.setCategoryId(4);
    	model.setComplDueId(14);
    	model.setDuplicateInd("Y");
    	model.setGlobalMust("N");
    	model.setGlobalOrRegional("AMER");
    	model.setId(1520137);
    	model.setInPublication(1);
    	model.setParentStdId(19471);
    	model.setPrntQltyLeadRrptId(1491177);
    	model.setPublishId(91001);
    	model.setSeSquence("6.000");
    	model.setSeverityDesc("Important");
    	model.setSeverityId(1);
    	model.setStdCategory("Regional");
    	model.setStdId(19471);
    	model.setStdManualType("258");
    	model.setStdType("STD");
    	model.setTriggerDesc("");
    	model.setTriggerId(0);
    	records.add(model);
    	
    	model = new QualityLeadModel();
    	model.setBucketDesc("Crisis and Incident");
    	model.setBucketId(10601);
    	model.setCategoryDesc("Back Office");
    	model.setCategoryId(4);
    	model.setComplDueId(14);
    	model.setDuplicateInd("Y");
    	model.setGlobalMust("N");
    	model.setGlobalOrRegional("AMER");
    	model.setId(1520139);
    	model.setInPublication(1);
    	model.setParentStdId(19471);
    	model.setPrntQltyLeadRrptId(1520137);
    	model.setPublishId(91001);
    	model.setSeSquence("6.000");
    	model.setSeverityDesc("");
    	model.setSeverityId(0);
    	model.setStdCategory("Regional");
    	model.setStdId(19473);
    	model.setStdManualType("258");
    	model.setStdType("SPEC");
    	model.setTriggerDesc("");
    	model.setTriggerId(0);
    	records.add(model);
    	
    	model = new QualityLeadModel();
    	model.setBucketDesc("Crisis and Incident");
    	model.setBucketId(10601);
    	model.setCategoryDesc("Back Office");
    	model.setCategoryId(4);
    	model.setComplDueId(14);
    	model.setDuplicateInd("Y");
    	model.setGlobalMust("N");
    	model.setGlobalOrRegional("AMER");
    	model.setId(1520140);
    	model.setInPublication(1);
    	model.setParentStdId(19471);
    	model.setPrntQltyLeadRrptId(1520137);
    	model.setPublishId(91001);
    	model.setSeSquence("6.000");
    	model.setSeverityDesc("");
    	model.setSeverityId(0);
    	model.setStdCategory("Regional");
    	model.setStdId(19472);
    	model.setStdManualType("258");
    	model.setStdType("SPEC");
    	model.setTriggerDesc("");
    	model.setTriggerId(0);
    	records.add(model);
    	
    	System.out.println("Create Manuals Query:  "+GemQueryUtils.getGemSaveQuery(records, publishDeptId, bridgePublishId, gemPublishId, regionId, userName, true, false));
    }
    
    @Test
    public final void getGemQLFormRecordsQuery(){
    	long gemPublishId = 91001;
    	long bridgePublishId = 88001;
    	long regionId = 2;
    	String regionCd = "AMER";
    	String brandCd = "VN";
    	String stdIdLst = "590551";
    	String stdStatus = null;
    	String stdOwner = null;
    	long seCategory = 0;
    	String stdRegion = null;
    	String seMnlTypeConfig = GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE;
    	String filterRules = null;//"[{\"field\":\"mnlType\",\"op\":\"equal\",\"value\":\"258\"},{\"field\":\"glblRgn\",\"op\":\"equal\",\"value\":\"AMER\"}]";
    	System.out.println("GET QL FROM REcords:"+GemQueryUtils.getGemQLFormRecordsQuery(bridgePublishId, gemPublishId, regionId, regionCd, brandCd, seMnlTypeConfig, filterRules));
    }
    
    @Test
    public final void getGemQLDuplicatesRecordsQuery(){
    	long gemPublishId = 86082;
    	long bridgePublishId = 94001;
    	long regionId = 2;
    	String brandCd = "IN";
    	String stdIdLst = null;//"590551";
    	System.out.println("GET Duplicates:"+GemQueryUtils.getGemQLDuplicatesRecordsQuery(bridgePublishId, gemPublishId, regionId, brandCd, stdIdLst));
    }
    
    @Test
    public final void syncBridgeGEMQlReport()
    {
    	long actvGemDeptId = 10003;
    	long actvGemPublishDeptId = 40004;
    	long brdgPublishId = 68013;
    	long actvGemPublishId = 70023;
		long regionId = 2;
		String regionCd = "AMER";
		String brandCd = "HI";
		String screenName = "mummanl";
		String userName = "Lakshminarayana";
		String seMnlType = GemConstants.MANUAL_TYPE_FULL_BUILD_OPERATE;
		String saMnlType = GemConstants.MANUAL_TYPE_BUILD_OPERATE;
		String wrMnlType = GemConstants.MANUAL_TYPE_BUILD_OPERATE;
		
		System.out.println("GEM Sync Query:  "+GemQueryUtils.syncBridgeGEMQlReport(actvGemDeptId, actvGemPublishDeptId, brdgPublishId, actvGemPublishId, 
				regionId, regionCd, brandCd, screenName, userName, seMnlType, saMnlType, wrMnlType));
    }

    @Test
    public final void getUpdateGlobalRegionalStdCountriesQuery()
    {
        long publishId = 31173;
        String screenName = "kryvora";
        long cmsRegionId = 1;
        long stdId = 20;
        String query = BridgeQueryUtils.getUpdateGlobalRegionalStdCountriesQuery(publishId, stdId, cmsRegionId, screenName);
        System.out.println("Update Global Regional Std Countries Query:  " + query);
    }

    @Test
    public final void getUpdateStdCountriesStateQuery()
    {
        long publishId = 31173;
        String screenName = "kryvora";
        long cmsRegionId = 2;
        long stdId = 20;
        String query = BridgeQueryUtils.getUpdateStdCountriesStateQuery(publishId, stdId, cmsRegionId, screenName);
        System.out.println("Update Std Countries State Query:  " + query);
    }
    
    @Test
    public final void getMyPublicationQuery () {
    	String query = BridgeQueryUtils.getMyPublicationQuery("EX", "2", "AMER", null);
    	System.out.println(query);
    }

    @Test
    public final void getStandardsCompliance(){
    	String ids = "63262";
    	String fromDate = null;
        String toDate = null;
        String brandCd = "IC";
        String regionCode = "GC";
        String environment = "BRIDGE";
    	List<Long> stdIds = null;
        if (ids != null && !ids.isEmpty())
        {
            String[] idArr = ids.trim().split("\\s+");
            stdIds = new ArrayList<Long>();
            for (String id : idArr)
            {
                stdIds.add(Long.parseLong(id));
            }
        }
    	String query = BridgeQueryUtils.getStandardsCompliance(stdIds, null, environment, brandCd, regionCode, fromDate, toDate);
    	System.out.println("Bridge View Compliance Query-->"+query);
    }
    
    @Test
    public final void getStandardComplianceDetails(){
    	long stdId = 5683;
        String brandCd = "SB";
        String regionCode = "AMER";
        String environment = "BRIDGE";
    	String query = BridgeQueryUtils.getStandardComplianceDetails(stdId, environment, brandCd, regionCode);
    	System.out.println("Bridge View Compliance Contry Detail Query-->"+query);
    }

    @Test
    public final void getApplicableBrandsByStdId(){    	
		System.out.println("Query=\n"+GemQueryUtils.getApplicableBrandsByStdId(101, 3384, 3));		
	}
}
