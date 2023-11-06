package com.ihg.brandstandards.util;

import java.util.Calendar;

import org.junit.Test;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.bridge.util.ProgressQueryUtils;

/**
 * This class will have jUnit test methods for all QueryUtils.
 * @author LMummanedi
 */
public class ProgressQueryUtilsTest
{
	/** Progress Count Queries */
	@Test
    public final void getOverallProgressCountQueries()
    {	
    	long publishId = 62008;
    	long regionId = 2;
    	System.out.println(ProgressQueryUtils.getAllRGNOverAllProgressQuery(publishId));
        System.out.println(ProgressQueryUtils.getOverAllProgressQuery(publishId, regionId));
    }
    
    @Test
    public final void getComplianceProgressQuery()
    {	
    	long publishId = 54003;
    	long regionId = 1;
        String chainCd = "EX";
    	Calendar publishDate = Calendar.getInstance();
    	publishDate.set(2015, 10, 18);
    	System.out.println(publishDate.getTime());
        System.out.println(ProgressQueryUtils.getComplianceProgressQuery(publishId, regionId, chainCd, publishDate.getTime(), true));
    }
    
    @Test
    public final void getNotificationsProgressQuery()
    {	
    	long publishId = 62008;
    	long regionId = 1;
        System.out.println(ProgressQueryUtils.getNotificationsProgressQuery(publishId, regionId));
    }
    
	@Test
    public final void getIndexTranslationProgressQuery()
    {
        String publishId = "31173";
        String chainCd = "RS";
        String regionCd = "AMEA";
        //String translationProgress = ProgressQueryUtils.getIndexTranslationProgressQuery(true);
        String translationProgress = ProgressQueryUtils.getIndexTranslationProgressQuery(false);
        System.out.println("Actual:  "+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+chainCd+"'");
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+translationProgress);
    }
	
	@Test
    public final void getContentTranslationProgressQuery()
    {
        String publishId = "47018";
        String regionCd = "GLBL"; //AMEA
        String regionId = "1"; //2
        String translationProgress = ProgressQueryUtils.getContentTranslationProgressQuery(false);
        System.out.println("Actual:  "+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+translationProgress);
    }
	
	@Test
    public final void getAttachTranslationProgressQuery()
    {
        String publishId = "29110";
        String regionCd = "AMEA";
        String regionId = "3";
        String chainCd = "HI";
        //String translationProgress = ProgressQueryUtils.getAttachTranslationProgressQuery(true);
        String translationProgress = ProgressQueryUtils.getAttachTranslationProgressQuery(false);
        System.out.println("Actual:  "+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&&", "'"+chainCd+"'");
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+translationProgress);
    }
	
	@Test
    public final void getLinksTranslationProgressQuery()
    {
        String publishId = "29110";
        String regionCd = "AMEA";
        String regionId = "3";
        String chainCd = "HI";
        //String translationProgress = ProgressQueryUtils.getLinksTranslationProgressQuery(true);
        String translationProgress = ProgressQueryUtils.getLinksTranslationProgressQuery(false);
        System.out.println("Actual:  "+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&&", "'"+chainCd+"'");
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+translationProgress);
    }
	
	@Test
    public final void getImageTranslationProgressQuery()
    {
        String publishId = "31224";
        String regionCd = "AMER";
        String regionId = "2";
        String chainCd = "CV";
        //String translationProgress = ProgressQueryUtils.getImageTranslationProgressQuery(true);
        String translationProgress = ProgressQueryUtils.getImageTranslationProgressQuery(false);
        System.out.println("Actual:  "+translationProgress);
        translationProgress = translationProgress.replace("?", "&&");
        translationProgress = translationProgress.replaceFirst("&&", publishId);
        translationProgress = translationProgress.replaceFirst("&&", regionId);
        translationProgress = translationProgress.replaceFirst("&&", "'"+regionCd+"'");
        translationProgress = translationProgress.replaceFirst("&&", "'"+chainCd+"'");
        translationProgress = translationProgress.replaceFirst("&& := l_locale_cnt_out;", "DBMS_OUTPUT.put_line('l_locale_cnt_out = ' || l_locale_cnt_out);");
        
        System.out.println("Executable:  "+translationProgress);
    }
	
    
    /** Overall Progress View Detail Queries */
    @Test
    public final void getProgressDiscontinuedViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressDiscontinuedViewDetail(publishId, regionId, BridgeConstants.STAT_IND_DISCONTINUED));
    }
    
    @Test
    public final void getProgressUnattributeBrandViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressUnattributeBrandViewDetail(publishId, regionId, BridgeConstants.STAT_IND_UNATTRIBUTE_BRAND));
    }
    
    @Test
    public final void getProgressUnattributeRegionViewDetail()
    {
    	long publishId = 62008;
    	long regionId = 2;
        System.out.println(ProgressQueryUtils.getProgressUnattributeRegionViewDetail(publishId, regionId, BridgeConstants.STAT_IND_UNATTRIBUTE_REGION));
    }
    
    @Test
    public final void getProgressGlobalMustViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressGlobalMustViewDetail(publishId, regionId, BridgeConstants.STAT_IND_GLBL_MUST));
    }
    
    @Test
    public final void getProgressGlobalNotInMustViewDetail()
    {
    	long publishId = 62008;
    	long regionId = 2;
        System.out.println(ProgressQueryUtils.getProgressGlobalNotInMustViewDetail(publishId, regionId, BridgeConstants.STAT_IND_GLBL_NOT_IN_MUST));
    }
    
    @Test
    public final void getProgressGlobalMustNotViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressGlobalMustNotViewDetail(publishId, regionId, BridgeConstants.STAT_IND_GLBL_MUST_NOT));
    }
    
    @Test
    public final void getProgressSelectStateViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressSelectStateViewDetail(publishId, regionId, BridgeConstants.STAT_IND_SELECT_STATE));
    }
    
    @Test
    public final void getProgressOverriddenViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressOverriddenViewDetail(publishId, regionId, BridgeConstants.STAT_IND_OVERRIDDEN));
    }
    
    @Test
    public final void getProgressMissingXrefViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressMissingXrefViewDetail(publishId, regionId, BridgeConstants.STAT_IND_MISS_XREF));
    }
    
    /** Compliance Progress View Detail Queries */
    
    @Test
    public final void getProgressComplianceDateViewDetail()
    {
    	long publishId = 54003;
    	long regionId = 1;
        String chainCd = "EX";
        Calendar publishDate = Calendar.getInstance();
        publishDate.set(2015, 10, 18);
        System.out.println(ProgressQueryUtils.getProgressComplianceDateViewDetail(publishId, regionId, chainCd, publishDate.getTime(), BridgeConstants.STAT_IND_COMPLIANCE_DATE));
    }
    
    @Test
    public final void getProgressExpiredDateViewDetail()
    {
    	long publishId = 54003;
    	long regionId = 1;
        String chainCd = "EX";
        Calendar publishDate = Calendar.getInstance();
        publishDate.set(2015, 10, 18);
        System.out.println(ProgressQueryUtils.getProgressExpiredDateViewDetail(publishId, regionId, chainCd, publishDate.getTime(), BridgeConstants.STAT_IND_EXPIRED_DATE));
    }
    
    /** Notification Progress View Detail Queries */
    @Test
    public final void getProgressNotificationViewDetail()
    {	
    	long publishId = 62008;
    	long regionId = 1;
        System.out.println(ProgressQueryUtils.getProgressNotificationViewDetail(publishId, regionId));
    }
    
    @Test
    public final void getProgressAllNotificationViewDetail()
    {	
    	long publishId = 66007;
    	long regionId = 1;
        System.out.println(ProgressQueryUtils.getProgressAllNotificationViewDetail(publishId, regionId));
    }
    
    /** Translation Progress View Detail Queries */
    
    @Test
    public final void getProgressIndexTranslationViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        System.out.println(ProgressQueryUtils.getProgressIndexTranslationViewDetail(publishId, regionId, "ja_JP", BridgeConstants.STAT_IND_MISS_TRANS_INDEX));
    }
    
    @Test
    public final void getProgressContentTranslationViewDetail()
    {
    	long publishId = 47018;
    	long regionId = 1;
        System.out.println(ProgressQueryUtils.getProgressContentTranslationViewDetail(publishId, regionId, "EX", "en_US", BridgeConstants.STAT_IND_MISS_TRANS_CONTENT));
    }
    
    @Test
    public final void getProgressAttachmentTranslationViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        String chainCd = "EX";
        System.out.println(ProgressQueryUtils.getProgressAttachmentTranslationViewDetail(publishId, regionId, chainCd, "ja_JP", BridgeConstants.STAT_IND_MISS_TRANS_ATTACH));
    }
    
    @Test
    public final void getProgressLinksTranslationViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        String chainCd = "EX";
        System.out.println(ProgressQueryUtils.getProgressLinksTranslationViewDetail(publishId, regionId, chainCd, "ja_JP", BridgeConstants.STAT_IND_MISS_TRANS_LINKS));
    }
    
    @Test
    public final void getProgressImagesTranslationViewDetail()
    {
    	long publishId = 48011;
    	long regionId = 3;
        String chainCd = "EX";
        System.out.println(ProgressQueryUtils.getProgressImagesTranslationViewDetail(publishId, regionId, chainCd, "es_ES", BridgeConstants.STAT_IND_MISS_TRANS_IMAGES));
    }
    
}
