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

import java.util.List;

import com.ihg.brandstandards.db.NoSuchUIElementTranslateException;
import com.ihg.brandstandards.db.model.UIElementTranslate;
import com.ihg.brandstandards.db.model.impl.UIElementTranslateImpl;
import com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.UIElementTranslateLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the u i element translate local service.
 * 
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their
 * definitions into the {@link com.ihg.brandstandards.db.service.UIElementTranslateLocalService} interface.
 * 
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because
 * this service can only be accessed from within the same VM.
 * </p>
 * 
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.UIElementTranslateLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil
 */
public class UIElementTranslateLocalServiceImpl extends UIElementTranslateLocalServiceBaseImpl
{
    /*
     * NOTE FOR DEVELOPERS:
     *
     * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil} to access the u i element translate local service.
     */
    
	public void clearCache()
    {
        try
        {
            uiElementTranslatePersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public UIElementTranslate getUIElementTranslateObject(){
        return new UIElementTranslateImpl();
    }
    
	public UIElementTranslate addNewUIElementData(UIElementTranslate uiElementData) throws SystemException
    {
        uiElementData.setElementId(CounterLocalServiceUtil.increment(UIElementTranslate.class.getName()));
        uiElementData.setNew(true);
        return UIElementTranslateLocalServiceUtil.addUIElementTranslate(uiElementData);
    }

    public List<UIElementTranslate> getByElementId(long elementId) throws SystemException
    {

        return uiElementTranslatePersistence.findByElementId(elementId);
    }

    public List<UIElementTranslate> getByLocaleCode(String localeCode) throws SystemException
    {

        return uiElementTranslatePersistence.findByLocaleCode(localeCode);
    }

    public UIElementTranslate getByIdAndLocaleCode(long elementId, String localeCode) throws SystemException,
            NoSuchUIElementTranslateException
    {

        return uiElementTranslatePersistence.findByIdAndLocaleCode(elementId, localeCode);
    }
}