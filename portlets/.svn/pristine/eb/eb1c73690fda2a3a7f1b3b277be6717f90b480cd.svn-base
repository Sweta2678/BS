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
import java.util.Map;

import com.ihg.brandstandards.db.NoSuchUIElementException;
import com.ihg.brandstandards.db.model.UIElement;
import com.ihg.brandstandards.db.model.impl.UIElementImpl;
import com.ihg.brandstandards.db.service.UIElementLocalServiceUtil;
import com.ihg.brandstandards.db.service.base.UIElementLocalServiceBaseImpl;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;

/**
 * The implementation of the u i element local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.UIElementLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.UIElementLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.UIElementLocalServiceUtil
 */
public class UIElementLocalServiceImpl extends UIElementLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.UIElementLocalServiceUtil} to access the u i element local service.
	 */
    
	public void clearCache()
    {
        try
        {
            uiElementPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public UIElement getUIElementObject(){
        return new UIElementImpl();
    }
    
    public UIElement addNewUIElementKey(UIElement uiElementKey) throws SystemException
    {
        uiElementKey.setElementId(CounterLocalServiceUtil.increment(UIElement.class.getName()));
        uiElementKey.setNew(true);
        return UIElementLocalServiceUtil.addUIElement(uiElementKey);
    }

    public UIElement getByElementKey(String elementKey) throws NoSuchUIElementException, SystemException
    {

        return uiElementPersistence.findByElementKey(elementKey);
    }

    public List<UIElement> getByUsedIn(String moduleName) throws SystemException
    {

        return uiElementPersistence.findByModuleName(moduleName);
    }

    public UIElement getByKeyAndUsedIn(String elementKey, String moduleName) throws NoSuchUIElementException, SystemException
    {

        return uiElementPersistence.findByKeyAndModuleName(elementKey, moduleName);
    }
    
    public List<Object> searchUIElement(String elementValue, String searchLanguage, String elementKey, String secondLanguage,
            String[] usedIn)
    {
        return uiElementFinder.searchUIElement(elementValue, searchLanguage, elementKey, secondLanguage, usedIn);
    }
    
    public Map<String, String> loadUIElements(String localeCode){
        return uiElementFinder.loadUIElements(localeCode);
    }
    
    public Map<String, String> loadUIElements(String localeCode, String moduleUsedIn){
        return uiElementFinder.loadUIElements(localeCode, moduleUsedIn);
    }
    
    public String loadAutoCompleteKeys(String sqlQuery){
        return uiElementFinder.loadAutoCompleteKeys(sqlQuery);
    }
    
    public List<String> getElementsKeyList(String sqlQuery){
        return uiElementFinder.getElementsKeyList(sqlQuery);
    }
}