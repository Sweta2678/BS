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

package com.ihg.brandstandards.db.model;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the SpecialWordDictionary service. Represents a row in the &quot;SPCL_WORD_DICTIONARY&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see SpecialWordDictionary
 * @see com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryImpl
 * @see com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryModelImpl
 * @generated
 */
public interface SpecialWordDictionaryModel extends BaseModel<SpecialWordDictionary> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a special word dictionary model instance should use the {@link SpecialWordDictionary} interface instead.
	 */

	/**
	 * Returns the primary key of this special word dictionary.
	 *
	 * @return the primary key of this special word dictionary
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this special word dictionary.
	 *
	 * @param primaryKey the primary key of this special word dictionary
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the special word ID of this special word dictionary.
	 *
	 * @return the special word ID of this special word dictionary
	 */
	public long getSpecialWordId();

	/**
	 * Sets the special word ID of this special word dictionary.
	 *
	 * @param specialWordId the special word ID of this special word dictionary
	 */
	public void setSpecialWordId(long specialWordId);

	/**
	 * Returns the replaced word txt of this special word dictionary.
	 *
	 * @return the replaced word txt of this special word dictionary
	 */
	@AutoEscape
	public String getReplacedWordTxt();

	/**
	 * Sets the replaced word txt of this special word dictionary.
	 *
	 * @param replacedWordTxt the replaced word txt of this special word dictionary
	 */
	public void setReplacedWordTxt(String replacedWordTxt);

	/**
	 * Returns the replacement word txt of this special word dictionary.
	 *
	 * @return the replacement word txt of this special word dictionary
	 */
	@AutoEscape
	public String getReplacementWordTxt();

	/**
	 * Sets the replacement word txt of this special word dictionary.
	 *
	 * @param replacementWordTxt the replacement word txt of this special word dictionary
	 */
	public void setReplacementWordTxt(String replacementWordTxt);

	/**
	 * Returns the locale code of this special word dictionary.
	 *
	 * @return the locale code of this special word dictionary
	 */
	@AutoEscape
	public String getLocaleCode();

	/**
	 * Sets the locale code of this special word dictionary.
	 *
	 * @param localeCode the locale code of this special word dictionary
	 */
	public void setLocaleCode(String localeCode);

	/**
	 * Returns the creator ID of this special word dictionary.
	 *
	 * @return the creator ID of this special word dictionary
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this special word dictionary.
	 *
	 * @param creatorId the creator ID of this special word dictionary
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this special word dictionary.
	 *
	 * @return the created date of this special word dictionary
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this special word dictionary.
	 *
	 * @param createdDate the created date of this special word dictionary
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this special word dictionary.
	 *
	 * @return the updated by of this special word dictionary
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this special word dictionary.
	 *
	 * @param updatedBy the updated by of this special word dictionary
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this special word dictionary.
	 *
	 * @return the updated date of this special word dictionary
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this special word dictionary.
	 *
	 * @param updatedDate the updated date of this special word dictionary
	 */
	public void setUpdatedDate(Date updatedDate);

	@Override
	public boolean isNew();

	@Override
	public void setNew(boolean n);

	@Override
	public boolean isCachedModel();

	@Override
	public void setCachedModel(boolean cachedModel);

	@Override
	public boolean isEscapedModel();

	@Override
	public Serializable getPrimaryKeyObj();

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj);

	@Override
	public ExpandoBridge getExpandoBridge();

	@Override
	public void setExpandoBridgeAttributes(BaseModel<?> baseModel);

	@Override
	public void setExpandoBridgeAttributes(ExpandoBridge expandoBridge);

	@Override
	public void setExpandoBridgeAttributes(ServiceContext serviceContext);

	@Override
	public Object clone();

	@Override
	public int compareTo(SpecialWordDictionary specialWordDictionary);

	@Override
	public int hashCode();

	@Override
	public CacheModel<SpecialWordDictionary> toCacheModel();

	@Override
	public SpecialWordDictionary toEscapedModel();

	@Override
	public SpecialWordDictionary toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}