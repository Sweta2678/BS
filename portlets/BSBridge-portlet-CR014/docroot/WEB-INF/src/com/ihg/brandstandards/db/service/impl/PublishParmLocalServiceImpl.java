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

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.PublishParm;
import com.ihg.brandstandards.db.service.base.PublishParmLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.Validator;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * The implementation of the publish parm local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.PublishParmLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.PublishParmLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.PublishParmLocalServiceUtil
 */
public class PublishParmLocalServiceImpl extends PublishParmLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.PublishParmLocalServiceUtil} to access the publish parm local service.
	 */
	
	public PublishParm createPublishParam() throws SystemException
    {
        return publishParmFinder.createPublishParam();
    }
	
	public Map<String, PublishParm> getPublishParmsByPublishId(long publishId) throws SystemException{
		Map<String, PublishParm> manualTypes = null;
		List<PublishParm> publishParms = publishParmPersistence.findByPublishId(publishId);
		if(Validator.isNotNull(publishParms) && publishParms.size() > 0){
			manualTypes = new LinkedHashMap<String, PublishParm>();
			for(PublishParm publishParm : publishParms){
				if(BridgeConstants.SA_MANUAL_TYPE.equalsIgnoreCase(publishParm.getParmName())){
					manualTypes.put(BridgeConstants.SA_MANUAL_TYPE, publishParm);
				}
				else if(BridgeConstants.SE_MANUAL_TYPE.equalsIgnoreCase(publishParm.getParmName())){
					manualTypes.put(BridgeConstants.SE_MANUAL_TYPE, publishParm);
				}
				else if(BridgeConstants.WR_MANUAL_TYPE.equalsIgnoreCase(publishParm.getParmName())){
					manualTypes.put(BridgeConstants.WR_MANUAL_TYPE, publishParm);
				}
			}
		}
		return manualTypes;
	}
}