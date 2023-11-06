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

import com.ihg.brandstandards.db.model.SpecialWordDictionary;
import com.ihg.brandstandards.db.service.base.SpecialWordDictionaryLocalServiceBaseImpl;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;

/**
 * The implementation of the special word dictionary local service.
 *
 * <p>
 * All custom service methods should be put in this class. Whenever methods are added, rerun ServiceBuilder to copy their definitions into the {@link com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalService} interface.
 *
 * <p>
 * This is a local service. Methods of this service will not have security checks based on the propagated JAAS credentials because this service can only be accessed from within the same VM.
 * </p>
 *
 * @author Mummanedi
 * @see com.ihg.brandstandards.db.service.base.SpecialWordDictionaryLocalServiceBaseImpl
 * @see com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalServiceUtil
 */
public class SpecialWordDictionaryLocalServiceImpl
	extends SpecialWordDictionaryLocalServiceBaseImpl {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never reference this interface directly. Always use {@link com.ihg.brandstandards.db.service.SpecialWordDictionaryLocalServiceUtil} to access the special word dictionary local service.
	 */
	private static final Log LOG = LogFactoryUtil.getLog(SpecialWordDictionaryLocalServiceImpl.class);
	
	public void clearCache()
    {
        try
        {
            specialWordDictionaryPersistence.clearCache();
        }
        catch (Exception e)
        {
        }
    }
	
	public SpecialWordDictionary getByReplacedWordTxtAndLocaleCode(String replacedWordTxt, String localeCode) {
		SpecialWordDictionary specialWord = null;
		try {
			specialWordDictionaryPersistence.findByReplacedWordTxtAndLocaleCode(replacedWordTxt, localeCode);
		} catch(Exception e){
			LOG.error("Failed to get Special Word with Word:"+replacedWordTxt+" Locale Code:"+localeCode, e);
		}
		return specialWord;
	}
	
	public List<SpecialWordDictionary> getByReplacementWordTxtAndLocaleCode(String replacementWordTxt, String localeCode) {
		List<SpecialWordDictionary> specialWordList = new ArrayList<SpecialWordDictionary>();
		try {
			specialWordList =specialWordDictionaryPersistence.findByReplacementWordTxtAndLocaleCode(replacementWordTxt, localeCode);
		} catch(Exception e){
			LOG.error("Failed to get Special Word with Actual Word:"+replacementWordTxt+" Locale Code:"+localeCode, e);
		}
		return specialWordList;
	}
	
	public List<SpecialWordDictionary> getByLocaleCode(String localeCode) {
		List<SpecialWordDictionary> specialWordList = new ArrayList<SpecialWordDictionary>();
		
		try {
			specialWordList = specialWordDictionaryPersistence.findByLocaleCode(localeCode);
		} catch(Exception e){
			LOG.error("Failed to get Special Words with Locale Code:"+localeCode, e);
		}
		return specialWordList;
	}
}