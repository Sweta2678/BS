package com.ihg.me2.indexpostprocessor;

import com.ihg.me2.indexpostprocessor.util.CustomIndexerConstant;
import com.ihg.me2.indexpostprocessor.util.CustomIndexerUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.BaseIndexerPostProcessor;
import com.liferay.portal.kernel.search.Document;
import com.liferay.portal.kernel.util.PrefsPropsUtil;
import com.liferay.portal.model.User;


public class UserPostProcessor extends BaseIndexerPostProcessor{
	private static Log _log = LogFactoryUtil.getLog(CustomIndexerUtil.class);

	@Override
	public void postProcessDocument(Document doc, Object obj)
			throws Exception {
		User user = (User) obj;
		doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_SOURCE, PrefsPropsUtil.getString("meta-data-content-source-value"));
		doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_TYPE, PrefsPropsUtil.getString("meta-data-content-type-person"));
		doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_LINK, CustomIndexerConstant.USER_CONTENT_LINK + user.getUserId());
		doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_NAME, CustomIndexerConstant.USER_PARENT);
		doc.addKeyword(CustomIndexerConstant.META_DATA_CONTENT_PARENT_LINK, CustomIndexerConstant.USER_PARENT_LINK);
		
		_log.info("Indexing meta-data field from post processor for user");
		super.postProcessDocument(doc, obj);
	}
}
