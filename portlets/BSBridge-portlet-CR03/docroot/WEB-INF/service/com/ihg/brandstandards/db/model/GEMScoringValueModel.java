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
 * The base model interface for the GEMScoringValue service. Represents a row in the &quot;SCORING_VAL&quot; database table, with each column mapped to a property of this class.
 *
 * <p>
 * This interface and its corresponding implementation {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl} exist only as a container for the default property accessors generated by ServiceBuilder. Helper methods and all application logic should be put in {@link com.ihg.brandstandards.db.model.impl.GEMScoringValueImpl}.
 * </p>
 *
 * @author Mummanedi
 * @see GEMScoringValue
 * @see com.ihg.brandstandards.db.model.impl.GEMScoringValueImpl
 * @see com.ihg.brandstandards.db.model.impl.GEMScoringValueModelImpl
 * @generated
 */
public interface GEMScoringValueModel extends BaseModel<GEMScoringValue> {
	/*
	 * NOTE FOR DEVELOPERS:
	 *
	 * Never modify or reference this interface directly. All methods that expect a g e m scoring value model instance should use the {@link GEMScoringValue} interface instead.
	 */

	/**
	 * Returns the primary key of this g e m scoring value.
	 *
	 * @return the primary key of this g e m scoring value
	 */
	public long getPrimaryKey();

	/**
	 * Sets the primary key of this g e m scoring value.
	 *
	 * @param primaryKey the primary key of this g e m scoring value
	 */
	public void setPrimaryKey(long primaryKey);

	/**
	 * Returns the scoring ID of this g e m scoring value.
	 *
	 * @return the scoring ID of this g e m scoring value
	 */
	public long getScoringId();

	/**
	 * Sets the scoring ID of this g e m scoring value.
	 *
	 * @param scoringId the scoring ID of this g e m scoring value
	 */
	public void setScoringId(long scoringId);

	/**
	 * Returns the measurement bucket chain ID of this g e m scoring value.
	 *
	 * @return the measurement bucket chain ID of this g e m scoring value
	 */
	public long getMeasurementBucketChainId();

	/**
	 * Sets the measurement bucket chain ID of this g e m scoring value.
	 *
	 * @param measurementBucketChainId the measurement bucket chain ID of this g e m scoring value
	 */
	public void setMeasurementBucketChainId(long measurementBucketChainId);

	/**
	 * Returns the total measurement of this g e m scoring value.
	 *
	 * @return the total measurement of this g e m scoring value
	 */
	public long getTotalMeasurement();

	/**
	 * Sets the total measurement of this g e m scoring value.
	 *
	 * @param totalMeasurement the total measurement of this g e m scoring value
	 */
	public void setTotalMeasurement(long totalMeasurement);

	/**
	 * Returns the net measurement of this g e m scoring value.
	 *
	 * @return the net measurement of this g e m scoring value
	 */
	public long getNetMeasurement();

	/**
	 * Sets the net measurement of this g e m scoring value.
	 *
	 * @param netMeasurement the net measurement of this g e m scoring value
	 */
	public void setNetMeasurement(long netMeasurement);

	/**
	 * Returns the non compliant measurement of this g e m scoring value.
	 *
	 * @return the non compliant measurement of this g e m scoring value
	 */
	public long getNonCompliantMeasurement();

	/**
	 * Sets the non compliant measurement of this g e m scoring value.
	 *
	 * @param nonCompliantMeasurement the non compliant measurement of this g e m scoring value
	 */
	public void setNonCompliantMeasurement(long nonCompliantMeasurement);

	/**
	 * Returns the non compliant measurement percent of this g e m scoring value.
	 *
	 * @return the non compliant measurement percent of this g e m scoring value
	 */
	public long getNonCompliantMeasurementPercent();

	/**
	 * Sets the non compliant measurement percent of this g e m scoring value.
	 *
	 * @param nonCompliantMeasurementPercent the non compliant measurement percent of this g e m scoring value
	 */
	public void setNonCompliantMeasurementPercent(
		long nonCompliantMeasurementPercent);

	/**
	 * Returns the creator ID of this g e m scoring value.
	 *
	 * @return the creator ID of this g e m scoring value
	 */
	@AutoEscape
	public String getCreatorId();

	/**
	 * Sets the creator ID of this g e m scoring value.
	 *
	 * @param creatorId the creator ID of this g e m scoring value
	 */
	public void setCreatorId(String creatorId);

	/**
	 * Returns the created date of this g e m scoring value.
	 *
	 * @return the created date of this g e m scoring value
	 */
	public Date getCreatedDate();

	/**
	 * Sets the created date of this g e m scoring value.
	 *
	 * @param createdDate the created date of this g e m scoring value
	 */
	public void setCreatedDate(Date createdDate);

	/**
	 * Returns the updated by of this g e m scoring value.
	 *
	 * @return the updated by of this g e m scoring value
	 */
	@AutoEscape
	public String getUpdatedBy();

	/**
	 * Sets the updated by of this g e m scoring value.
	 *
	 * @param updatedBy the updated by of this g e m scoring value
	 */
	public void setUpdatedBy(String updatedBy);

	/**
	 * Returns the updated date of this g e m scoring value.
	 *
	 * @return the updated date of this g e m scoring value
	 */
	public Date getUpdatedDate();

	/**
	 * Sets the updated date of this g e m scoring value.
	 *
	 * @param updatedDate the updated date of this g e m scoring value
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
	public int compareTo(GEMScoringValue gemScoringValue);

	@Override
	public int hashCode();

	@Override
	public CacheModel<GEMScoringValue> toCacheModel();

	@Override
	public GEMScoringValue toEscapedModel();

	@Override
	public GEMScoringValue toUnescapedModel();

	@Override
	public String toString();

	@Override
	public String toXmlString();
}