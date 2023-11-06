package com.ihg.me2.service.indexer.util;

import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.StringPool;
/***
 * 
 * @author vishal kumar
 *
 */
public interface CommunityIndexerConstant {
	/**
	 * META DATA FIELD
	 */
	String META_DATA_CONTENT_SOURCE = "CONTENT_SOURCE";
	String META_DATA_CONTENT_TYPE = "CONTENT_TYPE";
	String META_DATA_CONTENT_LINK = "CONTENT_LINK";
	String META_DATA_CONTENT_PARENT_NAME = "CONTENT_PARENT_NAME";
	String META_DATA_CONTENT_PARENT_LINK = "CONTENT_PARENT_LINK";
	/*String META_DATA_CONTENT_PARENT_NAME_TAG = "Teamspace";*/
	
	String META_DATA_CONTENT_PARENT_NAME_TAG = PropsUtil.get("meta-data-content-type-teamspace");
	
	/**
	 * Constance for string literal
	 */
	String WEB =StringPool.SLASH +"web";
	String HOME = StringPool.SLASH +"home";
	
	
	/**
	 * Indexer Constants
	 */
			
	/*String PARAM_TAG_MERLIN = PrefsPropsUtil.getString("tag-merlin");*/
	
	String PARAM_TAG_MERLIN = PropsUtil.get("tag-merlin");
	String PARAM_TAG_TEAMSPACE = PropsUtil.get("tag-teamspace");
	String FIELD_CONTENT_SOURCE_VALUE = PropsUtil.get("meta-data-content-source-value");
	String FIELD_CONTENT_TYPE = PropsUtil.get("meta-data-content-type-teamspace");
	
	String TEAMSPACE_HOME_PATH="/web/teamspaces/home/";
	
	
}
