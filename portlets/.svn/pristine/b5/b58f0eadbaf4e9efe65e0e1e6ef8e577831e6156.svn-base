package com.ihg.brandstandards.bridge.thread;

import com.ihg.brandstandards.bridge.util.ProgressSchedulerUtil;
import com.ihg.brandstandards.custom.model.BridgeProgressCount;
import com.ihg.brandstandards.db.model.BridgeProgressCategory;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategory;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.BridgePublishLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ProgressThreadOne implements Runnable {

	List<BridgeProgressCount> progressCountList ;
	private String regionCd;
	private List<BridgeProgressCategory> categorieslist;
	private Publication publish;
	private Map<Long, List<BridgeProgressSubCategory>> subCategoryListMap;
	List<BridgeProgressSubCategory> subCategorylist;
	BridgeProgressCount bridgeProgressCount;

    public ProgressThreadOne(String regionCd,List<BridgeProgressCategory> categorieslist
    		,Publication publish,Map<Long, List<BridgeProgressSubCategory>> subCategoryListMap,List<BridgeProgressCount> progressCountList) {
        this.regionCd = regionCd;
        this.categorieslist=categorieslist;
        this.publish=publish;
        this.subCategoryListMap=subCategoryListMap;
        this.progressCountList=progressCountList;
    }
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		 long rgnId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCd);
		 Map<String, Long> progressMap = new HashMap<String, Long>();
		 for(BridgeProgressCategory progressCategory :categorieslist ){
			 
			 try {
				progressMap = BridgePublishLocalServiceUtil.getBridgeProgress(publish.getPublishId(), publish.getChainCode(), 
						          publish.getPublishDate(), rgnId, rgnId == 1 ? true : false,progressCategory.getProgressCategoryName());
				LOG.debug(" progress map for Publish "+publish.getPublishId() +" and Region "+rgnId+" for "+progressCategory.getProgressCategoryName()+" : "+progressMap.size());
			 } catch (SystemException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			 subCategorylist = subCategoryListMap.get(progressCategory.getProgressCategoryId());
			 for(BridgeProgressSubCategory subCat : subCategorylist){
				//	System.out.println("-------------------->SubCat Name :"+subCat.getCategoryName());
				if(progressMap.containsKey(subCat.getCategoryName())){
					bridgeProgressCount = new BridgeProgressCount();
					bridgeProgressCount.setCategoryId(subCat.getProgressCategoryId());
					bridgeProgressCount.setSubCategoryId(subCat.getProgressSubCategoryId());
					bridgeProgressCount.setPublishId(publish.getPublishId());
					bridgeProgressCount.setRegionId(rgnId);
					bridgeProgressCount.setErrorCount(progressMap.get(subCat.getCategoryName()));
					
					progressCountList.add(bridgeProgressCount);
				}
			 }
		}
	}
	private static final Log LOG = LogFactoryUtil.getLog(ProgressThreadOne.class);
}
