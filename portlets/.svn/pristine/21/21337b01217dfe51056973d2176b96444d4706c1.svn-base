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

import com.ihg.brandstandards.db.model.StandardTag;
import com.ihg.brandstandards.db.model.impl.StandardTagImpl;
import com.ihg.brandstandards.db.service.base.StandardTagLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;
import java.util.List;

/**
 * The implementation of the standard tag local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardTagLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardTagLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardTagLocalServiceUtil
 */
public class StandardTagLocalServiceImpl extends StandardTagLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardTagLocalServiceUtil} to access the standard tag local service.
	 */
	
	public StandardTag getStandardTagObject(){
		return new StandardTagImpl();
	}
	
	public StandardTag getStandardTagWithStdId(long stdId,String tag) throws SystemException {
		
			return standardTagPersistence.fetchBystdIdWithTag(stdId, tag);
		
		
	}
	public List<StandardTag> getStandardTagsBystdId(long stdId) throws SystemException {
			
			return standardTagPersistence.findBystdId(stdId);
	}
}