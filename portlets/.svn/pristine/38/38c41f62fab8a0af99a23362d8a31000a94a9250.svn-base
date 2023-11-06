package com.ihg.brandstandards.bridge.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletRequest;

import com.ihg.brandstandards.bridge.thread.ProgressThreadOne;
import com.ihg.brandstandards.custom.model.BridgeProgressCount;
import com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException;
import com.ihg.brandstandards.db.model.BridgeProgressCategory;
import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.service.BridgeProgressCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgeProgressDiscrepancyLocalServiceUtil;
import com.ihg.brandstandards.db.service.BridgeProgressSubCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.NestableException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;

public class ProgressSchedulerUtil {
	
	private static List<BridgeProgressCategory> categorieslist; 
	private static Map<Long,List<BridgeProgressSubCategory>> subCategoryListMap; 
  
	private static final String RGN_CD_LIST[] = {"GLBL", "AMEA", "AMER", "EURO", "GC"};
    private static final Log LOG = LogFactoryUtil.getLog(ProgressSchedulerUtil.class);
	public static void processProgressJob(){
		List<Publication> activePublications = getAllActivePublications();
		List<Long> activePublishIDs = new ArrayList<Long>();
		for(Publication bridgePublication : activePublications){
			processProgressForPublication(bridgePublication);
			activePublishIDs.add(bridgePublication.getPublishId());
		}			
		BridgeProgressDiscrepancyLocalServiceUtil.deleteDeactivatedBridgePublishProgress(activePublishIDs);			
	}
	
	public static void processProgressForPublication(Publication bridgePublication){
		
		if(Validator.isNull(categorieslist)){
			categorieslist = getBridgeProgressCategoryList();
		}
		if(Validator.isNull(subCategoryListMap)){
			subCategoryListMap = getBridgeProgressSubcategoryList(categorieslist);
		}
	
		List<BridgeProgressCount> bridgeProgressCountList = getprogressDiscrepancyListFromCursor(bridgePublication,categorieslist,subCategoryListMap);
		BridgeProgressDiscrepancyLocalServiceUtil.addBridgeProgressValues(bridgeProgressCountList, "SYSTEM");
	}
	private static List<BridgeProgressCount> getprogressDiscrepancyListFromCursor(Publication publish,
			List<BridgeProgressCategory> categorieslist,
			Map<Long, List<BridgeProgressSubCategory>> subCategoryListMap) {
		List<BridgeProgressCount> progressCountList = new ArrayList<BridgeProgressCount>();
		List<BridgeProgressCount> progressCountList1 = new ArrayList<BridgeProgressCount>();
		List<BridgeProgressCount> progressCountList2 = new ArrayList<BridgeProgressCount>();
		List<BridgeProgressCount> progressCountList3 = new ArrayList<BridgeProgressCount>();
		List<BridgeProgressCount> progressCountList4 = new ArrayList<BridgeProgressCount>();
		List<BridgeProgressCount> progressCountList5 = new ArrayList<BridgeProgressCount>();
		//	List<BridgeProgressSubCategory> subCategorylist;
		//	BridgeProgressCount bridgeProgressCount;
		ProgressThreadOne c1=new ProgressThreadOne(RGN_CD_LIST[0], categorieslist, publish, subCategoryListMap, progressCountList1);
		Thread t1=new Thread(c1);
		t1.start();
		ProgressThreadOne c2=new ProgressThreadOne(RGN_CD_LIST[1], categorieslist, publish, subCategoryListMap, progressCountList2);
		Thread t2=new Thread(c2);
		t2.start();
		ProgressThreadOne c3=new ProgressThreadOne(RGN_CD_LIST[2], categorieslist, publish, subCategoryListMap, progressCountList3);
		Thread t3=new Thread(c3);
		t3.start();
		ProgressThreadOne c4=new ProgressThreadOne(RGN_CD_LIST[3], categorieslist, publish, subCategoryListMap, progressCountList4);
		Thread t4=new Thread(c4);
		t4.start();
		ProgressThreadOne c5=new ProgressThreadOne(RGN_CD_LIST[4], categorieslist, publish, subCategoryListMap, progressCountList5);
		Thread t5=new Thread(c5);
		t5.start();
		try {
			t1.join();
			t2.join();
			t3.join();
			t4.join();
			t5.join();
		} catch (InterruptedException e) {
			LOG.error(e.getMessage(),e);
		}
	
		progressCountList.addAll(progressCountList1);
		progressCountList.addAll(progressCountList2);
		progressCountList.addAll(progressCountList3);
		progressCountList.addAll(progressCountList4);
		progressCountList.addAll(progressCountList5);
		return progressCountList;
	}
	private static List<Publication> getAllActivePublications(){ 
		Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
		List<Publication> activePublications = new ArrayList<Publication>();
		Publication publish;
		for(String brandCode : chnCdMap.keySet()){
			publish = getActiveBridgePublication(brandCode);
			if(Validator.isNotNull(publish)){
				activePublications.add(publish);
				LOG.debug("Active Publication for brand "+brandCode+"======>"+publish.getPublishId());
			}
		}		
		return activePublications;
	}
	
	/**
     * Get Active Bridge Publish for a Brand.
     * 
     * @param brandCode brand code
     * @return Active Publish
     */
    private static Publication getActiveBridgePublication(String brandCode)
    {
    	Publication publish = null;
        try
        {
            publish = PublicationLocalServiceUtil.getPublishByStatEnvChainCode(BridgeConstants.PUBLISH_ACTIVE_STATUS_CODE,
                    BridgeConstants.BRIDGE_ENVIRONMENT, brandCode);
        }
        catch (NestableException e)
        {
            LOG.error("No Active Bridge Publish Exist for brand:" + brandCode);
        }
        return publish;
    }
    
    private static void addCategoriesEntries(){
    	LOG.debug("Widget Entries creating in DB ...");
    	Map<Integer,String> WidgetMap = new LinkedHashMap<Integer, String>();
    	WidgetMap.put(1,BridgeConstants.PROGRESS_TYPE_OVERALL);
    	WidgetMap.put(2,BridgeConstants.PROGRESS_TYPE_COMPLIANCE);
    	WidgetMap.put(3,BridgeConstants.PROGRESS_TYPE_NOTIFICATIONS);
    	WidgetMap.put(4,BridgeConstants.PROGRESS_TYPE_INDEX_TRANS);
    	WidgetMap.put(5,BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS);
    	WidgetMap.put(6,BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS);
    	WidgetMap.put(7,BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS);
    	WidgetMap.put(8,BridgeConstants.PROGRESS_TYPE_LINKS_TRANS);
    	BridgeProgressCategory category;
    	 for(Map.Entry<Integer, String> langOpt : WidgetMap.entrySet()) {
		        try {

		        	category = BridgeProgressCategoryLocalServiceUtil.createBridgeProgressCategory(CounterLocalServiceUtil
	                        .increment(BridgeProgressCategory.class.getName()));
		        	category.setProgressCategoryName(langOpt.getValue());
		            category.setDisplayOrderNumber(langOpt.getKey());
		            
		                category.setCreatorId(String.valueOf("SYSTEM"));
		                category.setCreatedDate(new Date());
		                category.setUpdatedBy(String.valueOf("SYSTEM"));
		                category.setUpdatedDate(new Date());
		                BridgeProgressCategoryLocalServiceUtil.updateBridgeProgressCategory(category);
		        }
		        catch (Exception e)
		        {
		            LOG.error(e);
		        } 
    	 }
    }
    
    private static void addSubCategoriesEntries(List<BridgeProgressCategory> categorieslist){
    	Map<Long,Map<Integer,String>> categoryMap = new LinkedHashMap<Long,Map<Integer,String>>();
    	Map<Integer,String> subCategoryMap;
    	
    	List<StandardsLocale> localeList;
		try {
			localeList = StandardsLocaleLocalServiceUtil.getStandardsLocales(-1,-1);
	    	for(BridgeProgressCategory cat : categorieslist){
	    		subCategoryMap = new LinkedHashMap<Integer, String>();
	    		if(cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_OVERALL)){
	    			subCategoryMap.put(1, BridgeConstants.COUNT_DISCONTINUED);
	    			subCategoryMap.put(2, BridgeConstants.COUNT_UNATTRIBUTE_BRND);
	    			subCategoryMap.put(3, BridgeConstants.COUNT_UNATTRIBUTE_RGN);
	    			subCategoryMap.put(4, BridgeConstants.COUNT_GLBL_MUST);
	    			subCategoryMap.put(5, BridgeConstants.COUNT_GLBL_NOT_IN_MUST);
	    			subCategoryMap.put(6, BridgeConstants.COUNT_GLBL_MUST_NOT);
	    			subCategoryMap.put(7, BridgeConstants.COUNT_SELECT_STATE);
	    			subCategoryMap.put(8, BridgeConstants.COUNT_OVERRIDDEN);
	    			subCategoryMap.put(9, BridgeConstants.COUNT_MISS_XREF);
	    		}else if(cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_COMPLIANCE)){
	    			subCategoryMap.put(1,BridgeConstants.COUNT_EXPIRED);
	    			subCategoryMap.put(2,BridgeConstants.COUNT_COMPLIANT);
	    		}else if(cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_NOTIFICATIONS)){
	    			subCategoryMap.put(1,BridgeConstants.COUNT_NOTIFICATIONS);
	    		}else if(cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_INDEX_TRANS) ||
	    				cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_ATTACH_TRANS) ||
	    				cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_IMAGE_TRANS) ||
	    				cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_CONTENT_TRANS) ||
	    				cat.getProgressCategoryName().equalsIgnoreCase(BridgeConstants.PROGRESS_TYPE_LINKS_TRANS)){
	    			int index = 0;
	    			for(StandardsLocale localeItem :localeList ) {
	    	    	    if("Y".equalsIgnoreCase(localeItem.getIsActive()))
	    	    	    {
	    	    	    	index++;
	    	    	    	subCategoryMap.put(index++,localeItem.getLocaleCode());
	    	    	    }
	    			}    	    	    
	    		} 
	    		//categoryMap.put(cat.getProgressCategoryId(), subCategoryMap);
	    		BridgeProgressSubCategory subCategory;
	    		 for(Map.Entry<Integer, String> langOpt : subCategoryMap.entrySet()) {
	 		        try {

	 		        	subCategory = BridgeProgressSubCategoryLocalServiceUtil.createBridgeProgressSubCategory(CounterLocalServiceUtil
	 	                        .increment(BridgeProgressSubCategory.class.getName()));
	 		        	subCategory.setCategoryName(langOpt.getValue());
	 		        	subCategory.setDisplayOrderNumber(langOpt.getKey());
	 		        	subCategory.setProgressCategoryId(cat.getProgressCategoryId());
	 		        	
	 		        	subCategory.setCreatorId(String.valueOf("SYSTEM"));
	 		        	subCategory.setCreatedDate(new Date());
	 		        	subCategory.setUpdatedBy(String.valueOf("SYSTEM"));
	 		        	subCategory.setUpdatedDate(new Date());
	 		                BridgeProgressSubCategoryLocalServiceUtil.updateBridgeProgressSubCategory(subCategory);
	 		        }
	 		        catch (Exception e)
	 		        {
	 		            LOG.error(e);
	 		        } 
	    		 }
	    	}
		} catch (SystemException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
            	
    }
    
    private static List<BridgeProgressCategory> getBridgeProgressCategoryList() {
    	try {
    	List<BridgeProgressCategory> categorieslist = BridgeProgressCategoryLocalServiceUtil.getBridgeProgressCategories(-1, -1);
			if(categorieslist.size()==0){
				addCategoriesEntries();
				
					categorieslist =  BridgeProgressCategoryLocalServiceUtil.getBridgeProgressCategories(-1, -1);
				
			}else{
				LOG.debug("Widget fetched from DB...");
			}
			return categorieslist;
    	} catch (SystemException e) {
			LOG.error("getBridgeProgressCategoryList exception  from DB...");
		}
    	return null;
    }
    private static Map<Long,List<BridgeProgressSubCategory>> getBridgeProgressSubcategoryList(List<BridgeProgressCategory> categories){
    	try{
	    	Map<Long,List<BridgeProgressSubCategory>> categorySubCatmap = new LinkedHashMap<Long, List<BridgeProgressSubCategory>>();
	    	
	    	int subCategoryCount = BridgeProgressSubCategoryLocalServiceUtil.getBridgeProgressSubCategoriesCount();
			if(subCategoryCount==0){
				addSubCategoriesEntries(categories);
			}
			List<BridgeProgressSubCategory> subCategorylist;
			for(BridgeProgressCategory category : categories){
				subCategorylist = BridgeProgressSubCategoryLocalServiceUtil.findByprogressCategoryId(category.getProgressCategoryId());
				categorySubCatmap.put(category.getProgressCategoryId(),subCategorylist);
			}
			return categorySubCatmap;
	    } catch (SystemException e) {
			LOG.error("getBridgeProgressCategoryList exception  from DB...");
		}
		return null;
    }
    
    //Get progress report from DB CR09-2018 
  	public static Map<String, Long> getProgressFromDB(PortletRequest portletRequest,long publishId, long regionId,String progressName) 
  	{
	  	Map<String, Long> progress=new LinkedHashMap<String, Long>();
	  	try {
		  	BridgeProgressCategory cat= BridgeProgressCategoryLocalServiceUtil.findByCategoryName(progressName);
		  	Map<Long,String> subCat=ProgressSchedulerUtil.getSubcatoriesInMap(cat.getProgressCategoryId());
		  	List<BridgeProgressDiscrepancy> disList=BridgeProgressDiscrepancyLocalServiceUtil.findDiscrepancyByCatPubReg(publishId, regionId,cat.getProgressCategoryId());
		  	Date lastUpdatedDate = null;
		  	for(BridgeProgressDiscrepancy d:disList){
		  		progress.put(subCat.get(d.getProgressSubCategoryId()),d.getErrorCount());
		  		
		  		if(Validator.isNull(lastUpdatedDate) ||  lastUpdatedDate.before(d.getUpdatedDate())){
		  			lastUpdatedDate = d.getUpdatedDate();
		  		}
		  	}
		  	portletRequest.setAttribute("lastUpdatedTime",lastUpdatedDate);
	  	} catch (NoSuchBridgeProgressCategoryException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
	  	} catch (SystemException e) {
	  	// TODO Auto-generated catch block
	  	e.printStackTrace();
	  	}
  	return progress;

  	}
	
  	public static Map<Long,String> getSubcatoriesInMap(long catId) throws SystemException{
    	
    	Map<Long,String> cat=new HashMap<Long, String>();
    	List<BridgeProgressSubCategory> subList=BridgeProgressSubCategoryLocalServiceUtil.findByprogressCategoryId(catId);
    	for(BridgeProgressSubCategory s:subList){
    		cat.put(s.getProgressSubCategoryId(),s.getCategoryName());
    	}
    	
    	return cat;
    }
  	//
  
}

