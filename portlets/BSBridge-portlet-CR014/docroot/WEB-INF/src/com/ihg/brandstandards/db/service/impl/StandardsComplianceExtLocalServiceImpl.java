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

import java.util.ArrayList;
import java.util.List;

import com.ihg.brandstandards.db.model.StandardsComplianceExt;
import com.ihg.brandstandards.db.service.base.StandardsComplianceExtLocalServiceBaseImpl;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the standards compliance ext local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsComplianceExtLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsComplianceExtLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsComplianceExtLocalServiceUtil
 */
public class StandardsComplianceExtLocalServiceImpl
	extends StandardsComplianceExtLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsComplianceExtLocalServiceUtil} to access the standards compliance ext local service.
	 */
	public void clearCache()
    {
        try
        {
            standardsComplianceExtPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public List<StandardsComplianceExt> getComplianceByRegion(String query, long stdId, String chainCode) throws SystemException
	{
		List<StandardsComplianceExt> arlCompliance = new ArrayList<StandardsComplianceExt>();
		arlCompliance = standardsComplianceExtFinder.getComplianceByRegion(query, stdId, chainCode);
		return arlCompliance;
	}
	public List<Object> getRegionStatus(long stdId, String chainCode) throws SystemException
	{
		return standardsComplianceExtFinder.getRegionStatus(stdId, chainCode);
	}
		
	public List<Object> getRegionCmplyExprCount(long stdId, String chainCd,String rgnName,String cmply_expr_value,String rule_cd) throws SystemException
	{
		return standardsComplianceExtFinder.getRegionCmplyExprCount(stdId, chainCd, rgnName, cmply_expr_value,rule_cd);
	}
}