/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */

package com.ihg.brandstandards.db.service.impl;

import java.util.Date;
import java.util.List;

import com.ihg.brandstandards.db.NoSuchGEMTriggerException;
import com.ihg.brandstandards.db.model.GEMTrigger;
import com.ihg.brandstandards.db.service.base.GEMTriggerLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the g e m trigger local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.GEMTriggerLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.GEMTriggerLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.GEMTriggerLocalServiceUtil
 */
public class GEMTriggerLocalServiceImpl extends GEMTriggerLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.GEMTriggerLocalServiceUtil} to access the g e m trigger local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(GEMTriggerLocalServiceImpl.class);
	
	public void clearCache(){
		try {
			gemTriggerPersistence.clearCache();
		} catch (Exception e) {
		}
	}
	
	public List<GEMTrigger> getByPublishId(long publishId) throws SystemException{
		return gemTriggerPersistence.findByPublishId(publishId);
	}
	
	public GEMTrigger getByPublishIdAndQuestion(long publishId, String question) throws SystemException, NoSuchGEMTriggerException{
		return gemTriggerPersistence.findByPublishIdAndQuestion(publishId, question);
	}
	
	public GEMTrigger addTriggerIfNotExist(long publishId, long publishDeptId, String question, String creatorId) throws SystemException {
		GEMTrigger gemTrigger = null;
		try{
			gemTrigger = gemTriggerPersistence.findByPublishIdAndQuestion(publishId, question);
		} catch(Exception e){
			LOG.error("No Trigger exist for publication:"+publishId+" with question:"+question);
		}
		if(gemTrigger == null){
			gemTrigger = gemTriggerPersistence.create(gemTemplateFinder.getSequenceNumber("GEM_TRIGGER_ID_SEQ"));
			gemTrigger.setPublishId(publishId);
			//This will be publish department id
			gemTrigger.setPublishDeptId(publishDeptId);
			gemTrigger.setQuestion(question);
			gemTrigger.setCreatorId(creatorId);
			gemTrigger.setCreatedDate(new Date());
			gemTrigger.setUpdatedBy(creatorId);
			gemTrigger.setUpdatedDate(new Date());
			gemTrigger = gemTriggerPersistence.update(gemTrigger);
		}
		return gemTrigger;
	}
}