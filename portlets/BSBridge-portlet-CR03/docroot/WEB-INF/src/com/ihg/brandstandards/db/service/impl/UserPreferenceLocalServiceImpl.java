/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
 *
 * This library is free software; you can redistribute it and/or modify it under
 * the terms of the GNU Lesser General Public License as published by the Free
 * Software Foundation; either version 2.1 of the License, or (at your option)
 * any later version.
 *
 * This library is distributed in the hope that it will be useful, but WITHOUT
 * ANY WARRANTY; without even the implied warranty of MERCHANTABILITY or FITNESS
 * FOR A PARTICULAR PURPOSE. See the GNU Lesser General Public License for more
 * details.
 */

package com.ihg.brandstandards.db.service.impl;

import com.ihg.brandstandards.db.NoSuchUserPreferenceException;
import com.ihg.brandstandards.db.model.UserPreference;
import com.ihg.brandstandards.db.service.base.UserPreferenceLocalServiceBaseImpl;
import com.ihg.brandstandards.db.service.persistence.UserPreferenceFinderUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;

/**
 * The implementation of the user preference local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.UserPreferenceLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.UserPreferenceLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil
 */
public class UserPreferenceLocalServiceImpl extends UserPreferenceLocalServiceBaseImpl
{
    private static final Log LOG = LogFactoryUtil.getLog(UserPreferenceLocalServiceImpl.class);
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.UserPreferenceLocalServiceUtil} to access the user preference local service.
     */
    public void clearCache()
    {
        try
        {
            userPreferencePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
    
    public UserPreference getUserPreferencesByUserId(long userId, String moduleName) throws SystemException
    {
        UserPreference userPreferences = null;

        /*DynamicQuery dynamicQuery = DynamicQueryFactoryUtil.forClass(UserPreference.class, PortletClassLoaderUtil.getClassLoader());
        Criterion userCriterion = RestrictionsFactoryUtil.eq("userId", userId);
        Criterion moduleCriterion = RestrictionsFactoryUtil.eq("moduleName", moduleName);
        dynamicQuery.add(userCriterion);
        dynamicQuery.add(moduleCriterion);

        @SuppressWarnings("unchecked")
        List<UserPreference> arlUserPreferences = (List<UserPreference>) UserPreferenceLocalServiceUtil
                .dynamicQuery(dynamicQuery);
        for (UserPreference userPrefs : arlUserPreferences)
        {
            userPreferences = userPrefs;
        }*/
        try
        {
            userPreferences = userPreferencePersistence.findByUserIdAndModule(userId, moduleName);
        }
        catch (NoSuchUserPreferenceException e)
        {
            LOG.error("No User preferences exist for the userId:"+userId +" and moduleName:"+moduleName);
        }
        return userPreferences;
    }

    public long getUserPreferencePK() throws SystemException
    {
        long userPreferenceId = 0;
        try
        {
            userPreferenceId = UserPreferenceFinderUtil.getUserPreferencePK();
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return userPreferenceId;
    }
}