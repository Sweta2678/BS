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

import com.ihg.brandstandards.db.service.BridgeProgressDiscrepancyLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.persistence.BridgeProgressDiscrepancyPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class BridgeProgressDiscrepancyClp extends BaseModelImpl<BridgeProgressDiscrepancy>
	implements BridgeProgressDiscrepancy {
	public BridgeProgressDiscrepancyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgeProgressDiscrepancy.class;
	}

	@Override
	public String getModelClassName() {
		return BridgeProgressDiscrepancy.class.getName();
	}

	@Override
	public BridgeProgressDiscrepancyPK getPrimaryKey() {
		return new BridgeProgressDiscrepancyPK(_progressCategoryId,
			_progressSubCategoryId, _publishId, _regionId);
	}

	@Override
	public void setPrimaryKey(BridgeProgressDiscrepancyPK primaryKey) {
		setProgressCategoryId(primaryKey.progressCategoryId);
		setProgressSubCategoryId(primaryKey.progressSubCategoryId);
		setPublishId(primaryKey.publishId);
		setRegionId(primaryKey.regionId);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new BridgeProgressDiscrepancyPK(_progressCategoryId,
			_progressSubCategoryId, _publishId, _regionId);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((BridgeProgressDiscrepancyPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("progressCategoryId", getProgressCategoryId());
		attributes.put("progressSubCategoryId", getProgressSubCategoryId());
		attributes.put("publishId", getPublishId());
		attributes.put("regionId", getRegionId());
		attributes.put("errorCount", getErrorCount());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long progressCategoryId = (Long)attributes.get("progressCategoryId");

		if (progressCategoryId != null) {
			setProgressCategoryId(progressCategoryId);
		}

		Long progressSubCategoryId = (Long)attributes.get(
				"progressSubCategoryId");

		if (progressSubCategoryId != null) {
			setProgressSubCategoryId(progressSubCategoryId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}

		Long errorCount = (Long)attributes.get("errorCount");

		if (errorCount != null) {
			setErrorCount(errorCount);
		}

		String creatorId = (String)attributes.get("creatorId");

		if (creatorId != null) {
			setCreatorId(creatorId);
		}

		Date createdDate = (Date)attributes.get("createdDate");

		if (createdDate != null) {
			setCreatedDate(createdDate);
		}

		String updatedBy = (String)attributes.get("updatedBy");

		if (updatedBy != null) {
			setUpdatedBy(updatedBy);
		}

		Date updatedDate = (Date)attributes.get("updatedDate");

		if (updatedDate != null) {
			setUpdatedDate(updatedDate);
		}
	}

	@Override
	public long getProgressCategoryId() {
		return _progressCategoryId;
	}

	@Override
	public void setProgressCategoryId(long progressCategoryId) {
		_progressCategoryId = progressCategoryId;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressCategoryId",
						long.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel,
					progressCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getProgressSubCategoryId() {
		return _progressSubCategoryId;
	}

	@Override
	public void setProgressSubCategoryId(long progressSubCategoryId) {
		_progressSubCategoryId = progressSubCategoryId;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setProgressSubCategoryId",
						long.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel,
					progressSubCategoryId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getRegionId() {
		return _regionId;
	}

	@Override
	public void setRegionId(long regionId) {
		_regionId = regionId;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getErrorCount() {
		return _errorCount;
	}

	@Override
	public void setErrorCount(long errorCount) {
		_errorCount = errorCount;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setErrorCount", long.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, errorCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatorId() {
		return _creatorId;
	}

	@Override
	public void setCreatorId(String creatorId) {
		_creatorId = creatorId;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, creatorId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getCreatedDate() {
		return _createdDate;
	}

	@Override
	public void setCreatedDate(Date createdDate) {
		_createdDate = createdDate;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, createdDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getUpdatedBy() {
		return _updatedBy;
	}

	@Override
	public void setUpdatedBy(String updatedBy) {
		_updatedBy = updatedBy;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, updatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getUpdatedDate() {
		return _updatedDate;
	}

	@Override
	public void setUpdatedDate(Date updatedDate) {
		_updatedDate = updatedDate;

		if (_bridgeProgressDiscrepancyRemoteModel != null) {
			try {
				Class<?> clazz = _bridgeProgressDiscrepancyRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_bridgeProgressDiscrepancyRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgeProgressDiscrepancyRemoteModel() {
		return _bridgeProgressDiscrepancyRemoteModel;
	}

	public void setBridgeProgressDiscrepancyRemoteModel(
		BaseModel<?> bridgeProgressDiscrepancyRemoteModel) {
		_bridgeProgressDiscrepancyRemoteModel = bridgeProgressDiscrepancyRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _bridgeProgressDiscrepancyRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_bridgeProgressDiscrepancyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgeProgressDiscrepancyLocalServiceUtil.addBridgeProgressDiscrepancy(this);
		}
		else {
			BridgeProgressDiscrepancyLocalServiceUtil.updateBridgeProgressDiscrepancy(this);
		}
	}

	@Override
	public BridgeProgressDiscrepancy toEscapedModel() {
		return (BridgeProgressDiscrepancy)ProxyUtil.newProxyInstance(BridgeProgressDiscrepancy.class.getClassLoader(),
			new Class[] { BridgeProgressDiscrepancy.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgeProgressDiscrepancyClp clone = new BridgeProgressDiscrepancyClp();

		clone.setProgressCategoryId(getProgressCategoryId());
		clone.setProgressSubCategoryId(getProgressSubCategoryId());
		clone.setPublishId(getPublishId());
		clone.setRegionId(getRegionId());
		clone.setErrorCount(getErrorCount());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BridgeProgressDiscrepancy bridgeProgressDiscrepancy) {
		BridgeProgressDiscrepancyPK primaryKey = bridgeProgressDiscrepancy.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof BridgeProgressDiscrepancyClp)) {
			return false;
		}

		BridgeProgressDiscrepancyClp bridgeProgressDiscrepancy = (BridgeProgressDiscrepancyClp)obj;

		BridgeProgressDiscrepancyPK primaryKey = bridgeProgressDiscrepancy.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{progressCategoryId=");
		sb.append(getProgressCategoryId());
		sb.append(", progressSubCategoryId=");
		sb.append(getProgressSubCategoryId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append(", errorCount=");
		sb.append(getErrorCount());
		sb.append(", creatorId=");
		sb.append(getCreatorId());
		sb.append(", createdDate=");
		sb.append(getCreatedDate());
		sb.append(", updatedBy=");
		sb.append(getUpdatedBy());
		sb.append(", updatedDate=");
		sb.append(getUpdatedDate());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(31);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgeProgressDiscrepancy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>progressCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>progressSubCategoryId</column-name><column-value><![CDATA[");
		sb.append(getProgressSubCategoryId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>errorCount</column-name><column-value><![CDATA[");
		sb.append(getErrorCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>creatorId</column-name><column-value><![CDATA[");
		sb.append(getCreatorId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdDate</column-name><column-value><![CDATA[");
		sb.append(getCreatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedBy</column-name><column-value><![CDATA[");
		sb.append(getUpdatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>updatedDate</column-name><column-value><![CDATA[");
		sb.append(getUpdatedDate());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _progressCategoryId;
	private long _progressSubCategoryId;
	private long _publishId;
	private long _regionId;
	private long _errorCount;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _bridgeProgressDiscrepancyRemoteModel;
}