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

import com.ihg.brandstandards.db.NoSuchStandardsComplianceException;
import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.impl.StandardsComplianceImpl;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.StandardsComplianceLocalServiceBaseImpl;
import com.liferay.portal.kernel.dao.orm.Criterion;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the standards compliance local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.StandardsComplianceLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.StandardsComplianceLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil
 */
public class StandardsComplianceLocalServiceImpl extends StandardsComplianceLocalServiceBaseImpl {
    
    private static final Log LOG = LogFactoryUtil.getLog(StandardsComplianceLocalServiceImpl.class);
            
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil} to access the standards compliance local service.
	 */
    public void clearCache()
    {
        try
        {
        	standardsCompliancePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
	public void saveStandardCompliance(long stdId, String chainCode, String ruleDate, String complianceExpiry, String stdCompliance) throws SystemException
	{
		standardsComplianceFinder.saveStandardCompliance(stdId, chainCode, ruleDate, complianceExpiry, stdCompliance);
	}
	
	public List<StandardsCompliance> getStandardsComplianceByStdId(long stdId) throws SystemException
	{
		List<StandardsCompliance> arlStdCompliance = new ArrayList<StandardsCompliance>();
		DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(StandardsCompliance.class);
        Criterion criterion = RestrictionsFactoryUtil.eq("stdId", stdId);
        dynamicQuery.add(criterion);
        arlStdCompliance = PublicationLocalServiceUtil.dynamicQuery(dynamicQuery);
        
		return arlStdCompliance;
	}
	
	/**
	 * 
	 * @param stdId
	 * @param chainCode
	 * @return
	 * @throws SystemException
	 */
	public List<StandardsCompliance> getStandardsComplianceByStdIdAndChainCode(long stdId, String chainCode) throws SystemException
	{
		return standardsCompliancePersistence.findByStdChain(stdId, chainCode);
	}
	
	/**
	 * 
	 * @param stdId
	 * @param chainCode
	 * @param countryCode
	 * @return
	 * @throws SystemException
	 */
	public StandardsCompliance getStandardsComplianceByStdIdChainCodeCountryCode(long stdId, String chainCode, String countryCode) throws SystemException
	{
		try {
			return standardsCompliancePersistence.findByStdChainCountry(stdId, chainCode, countryCode);
		} catch (NoSuchStandardsComplianceException e) {
			// e.printStackTrace();
		}
		return null;
	}
	
	public StandardsCompliance createStandardsCompliance() throws SystemException
	{
		StandardsCompliance standardsCompliance = new StandardsComplianceImpl();
		try
		{
			standardsCompliance = standardsComplianceFinder.createOraSequence();
		}
		catch(Exception e)
		{
		    LOG.error(StackTraceUtil.getStackTrace(e));
		}
		return standardsCompliance;
	}
	
	 public void saveStandardsCompliance(StandardsCompliance stdCompliance) throws SystemException
	 {
		 standardsComplianceFinder.saveStandardsCompliance(stdCompliance);
	 }
}