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

import com.ihg.brandstandards.db.service.persistence.BrandTaxonomyTranslatePK;

import com.liferay.portal.kernel.bean.AutoEscape;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.CacheModel;
import com.liferay.portal.service.ServiceContext;

import com.liferay.portlet.expando.model.ExpandoBridge;

import java.io.Serializable;

import java.util.Date;

/**
 * The base model interface for the BrandTaxonomyTranslate service. Represents a row in the &quot;BRAND_TAXONOMY_XLAT&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see BrandTaxonomyTranslate
 * @see com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateImpl
 * @see com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateModelImpl
 * @generated
 */
public interface BrandTaxonomyTranslateModel extends BaseModel<BrandTaxonomyTranslate> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a brand taxonomy translate model instance should use the {@link BrandTaxonomyTranslate} interface instead.
	 */

	/**
	 * Returns the primary key of this brand taxonomy translate.
	 *
	 * @return the primary key of this brand taxonomy translate
	 */
	public BrandTaxonomyTranslatePK getPrimaryKey();

	/**
	 * Sets the primary key of this brand taxonomy translate.
	 *
	 * @param primaryKey the primary key of this brand taxonomy translate
	 */
	public void setPrimaryKey(BrandTaxonomyTranslatePK primaryKey);

	/**
	 * Returns the brand tax ID of this brand taxonomy translate.
	 *
	 * @return the brand tax ID of this brand taxonomy translate
	 */
	public long getBrandTaxId();

	/**
	 * Sets the brand tax ID of this brand taxonomy translate.
	 *
	 * @param brandTaxId the brand tax ID of this brand taxonomy translate
	 */
	public void setBrandTaxId(long brandTaxId);

	/**
	 * Returns the locale cd of this brand taxonomy translate.
	 *
	 * @return the locale cd of this brand taxonomy translate
	 */
	@AutoEscape
	public String getLocaleCd();

	/**
	 * Sets the locale cd of this brand taxonomy translate.
	 *
	 * @param localeCd the locale cd of this brand taxonomy translate
	 */
	public void setLocaleCd(String localeCd);

	/**
	 * Returns the title of this brand taxonomy translate.
	 *
	 * @return the title of this brand taxonomy translate
	 */
	@AutoEscape
	public String getTitle();

	/**
	 * Sets the title of this brand taxonomy translate.
	 *
	 * @param title the title of this brand taxonomy translate
	 */
	public void setTitle(String title);

	/**
	 * Returns the desc of this brand taxonomy translate.
	 *
	 * @return the desc of this brand taxonomy translate
	 */
	@AutoEscape
	public String getDesc();

	/**
	 * Sets the desc of this brand taxonomy translate.
	 *
	 * @param desc the desc of this brand taxonomy translate
	 */
	public void setDesc(String desc);

	/**
	 * Returns the image loc of this brand taxonomy translate.
	 *
	 * @return the image loc of this brand taxonomy translate
	 */
	@AutoEscape
	public String getImageLoc();

	/**
	 * Sets the image loc of this brand taxonomy translate.
	 *
	 * @param imageLoc the image loc of this brand taxonomy translate
	 */
	public void setImageLoc(String imageLoc);

	/**
	 * Returns the creator ID of this brand taxonomy translate.
	 *
	 * @return the creator ID of this brand taxonomy translate
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this brand taxonomy translate.
	 *
	 * @param creatorId the creator ID of this brand taxonomy translate
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this brand taxonomy translate.
	 *
	 * @return the created date of this brand taxonomy translate
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this brand taxonomy translate.
	 *
	 * @param createdDate the created date of this brand taxonomy translate
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this brand taxonomy translate.
	 *
	 * @return the updated by of this brand taxonomy translate
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this brand taxonomy translate.
	 *
	 * @param updatedBy the updated by of this brand taxonomy translate
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this brand taxonomy translate.
	 *
	 * @return the updated date of this brand taxonomy translate
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this brand taxonomy translate.
	 *
	 * @param updatedDate the updated date of this brand taxonomy translate
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
	public int compareTo(BrandTaxonomyTranslate brandTaxonomyTranslate);

	@Override
	public int hashCode();

	@Override
	public CacheModel<BrandTaxonomyTranslate> toCacheModel();

	@Override
	public BrandTaxonomyTranslate toEscapedModel();

	@Override
	public BrandTaxonomyTranslate toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}