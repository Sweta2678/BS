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

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.PublishCountryStandardLocalServiceUtil;

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
public class PublishCountryStandardClp extends BaseModelImpl<PublishCountryStandard>
	implements PublishCountryStandard {
	public PublishCountryStandardClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishCountryStandard.class;
	}

	@Override
	public String getModelClassName() {
		return PublishCountryStandard.class.getName();
	}

	@Override
	public String getPrimaryKey() {
		return _publishCountryStdId;
	}

	@Override
	public void setPrimaryKey(String primaryKey) {
		setPublishCountryStdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishCountryStdId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((String)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishCountryStdId", getPublishCountryStdId());
		attributes.put("publishVerId", getPublishVerId());
		attributes.put("countryCode", getCountryCode());
		attributes.put("expiredRefTxt", getExpiredRefTxt());
		attributes.put("publishStatCode", getPublishStatCode());
		attributes.put("stdComplyDeadlineDate", getStdComplyDeadlineDate());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		String publishCountryStdId = (String)attributes.get(
				"publishCountryStdId");

		if (publishCountryStdId != null) {
			setPublishCountryStdId(publishCountryStdId);
		}

		Long publishVerId = (Long)attributes.get("publishVerId");

		if (publishVerId != null) {
			setPublishVerId(publishVerId);
		}

		String countryCode = (String)attributes.get("countryCode");

		if (countryCode != null) {
			setCountryCode(countryCode);
		}

		String expiredRefTxt = (String)attributes.get("expiredRefTxt");

		if (expiredRefTxt != null) {
			setExpiredRefTxt(expiredRefTxt);
		}

		String publishStatCode = (String)attributes.get("publishStatCode");

		if (publishStatCode != null) {
			setPublishStatCode(publishStatCode);
		}

		Date stdComplyDeadlineDate = (Date)attributes.get(
				"stdComplyDeadlineDate");

		if (stdComplyDeadlineDate != null) {
			setStdComplyDeadlineDate(stdComplyDeadlineDate);
		}

		Long orderNumber = (Long)attributes.get("orderNumber");

		if (orderNumber != null) {
			setOrderNumber(orderNumber);
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
	public String getPublishCountryStdId() {
		return _publishCountryStdId;
	}

	@Override
	public void setPublishCountryStdId(String publishCountryStdId) {
		_publishCountryStdId = publishCountryStdId;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishCountryStdId",
						String.class);

				method.invoke(_publishCountryStandardRemoteModel,
					publishCountryStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishVerId() {
		return _publishVerId;
	}

	@Override
	public void setPublishVerId(long publishVerId) {
		_publishVerId = publishVerId;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishVerId", long.class);

				method.invoke(_publishCountryStandardRemoteModel, publishVerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCountryCode() {
		return _countryCode;
	}

	@Override
	public void setCountryCode(String countryCode) {
		_countryCode = countryCode;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setCountryCode", String.class);

				method.invoke(_publishCountryStandardRemoteModel, countryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpiredRefTxt() {
		return _expiredRefTxt;
	}

	@Override
	public void setExpiredRefTxt(String expiredRefTxt) {
		_expiredRefTxt = expiredRefTxt;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setExpiredRefTxt", String.class);

				method.invoke(_publishCountryStandardRemoteModel, expiredRefTxt);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishStatCode() {
		return _publishStatCode;
	}

	@Override
	public void setPublishStatCode(String publishStatCode) {
		_publishStatCode = publishStatCode;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStatCode",
						String.class);

				method.invoke(_publishCountryStandardRemoteModel,
					publishStatCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStdComplyDeadlineDate() {
		return _stdComplyDeadlineDate;
	}

	@Override
	public void setStdComplyDeadlineDate(Date stdComplyDeadlineDate) {
		_stdComplyDeadlineDate = stdComplyDeadlineDate;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setStdComplyDeadlineDate",
						Date.class);

				method.invoke(_publishCountryStandardRemoteModel,
					stdComplyDeadlineDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getOrderNumber() {
		return _orderNumber;
	}

	@Override
	public void setOrderNumber(long orderNumber) {
		_orderNumber = orderNumber;

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderNumber", long.class);

				method.invoke(_publishCountryStandardRemoteModel, orderNumber);
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

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_publishCountryStandardRemoteModel, creatorId);
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

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publishCountryStandardRemoteModel, createdDate);
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

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publishCountryStandardRemoteModel, updatedBy);
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

		if (_publishCountryStandardRemoteModel != null) {
			try {
				Class<?> clazz = _publishCountryStandardRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publishCountryStandardRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishCountryStandardRemoteModel() {
		return _publishCountryStandardRemoteModel;
	}

	public void setPublishCountryStandardRemoteModel(
		BaseModel<?> publishCountryStandardRemoteModel) {
		_publishCountryStandardRemoteModel = publishCountryStandardRemoteModel;
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

		Class<?> remoteModelClass = _publishCountryStandardRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishCountryStandardRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishCountryStandardLocalServiceUtil.addPublishCountryStandard(this);
		}
		else {
			PublishCountryStandardLocalServiceUtil.updatePublishCountryStandard(this);
		}
	}

	@Override
	public PublishCountryStandard toEscapedModel() {
		return (PublishCountryStandard)ProxyUtil.newProxyInstance(PublishCountryStandard.class.getClassLoader(),
			new Class[] { PublishCountryStandard.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishCountryStandardClp clone = new PublishCountryStandardClp();

		clone.setPublishCountryStdId(getPublishCountryStdId());
		clone.setPublishVerId(getPublishVerId());
		clone.setCountryCode(getCountryCode());
		clone.setExpiredRefTxt(getExpiredRefTxt());
		clone.setPublishStatCode(getPublishStatCode());
		clone.setStdComplyDeadlineDate(getStdComplyDeadlineDate());
		clone.setOrderNumber(getOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(PublishCountryStandard publishCountryStandard) {
		String primaryKey = publishCountryStandard.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublishCountryStandardClp)) {
			return false;
		}

		PublishCountryStandardClp publishCountryStandard = (PublishCountryStandardClp)obj;

		String primaryKey = publishCountryStandard.getPrimaryKey();

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
		StringBundler sb = new StringBundler(23);

		sb.append("{publishCountryStdId=");
		sb.append(getPublishCountryStdId());
		sb.append(", publishVerId=");
		sb.append(getPublishVerId());
		sb.append(", countryCode=");
		sb.append(getCountryCode());
		sb.append(", expiredRefTxt=");
		sb.append(getExpiredRefTxt());
		sb.append(", publishStatCode=");
		sb.append(getPublishStatCode());
		sb.append(", stdComplyDeadlineDate=");
		sb.append(getStdComplyDeadlineDate());
		sb.append(", orderNumber=");
		sb.append(getOrderNumber());
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
		StringBundler sb = new StringBundler(37);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishCountryStandard");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishCountryStdId</column-name><column-value><![CDATA[");
		sb.append(getPublishCountryStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishVerId</column-name><column-value><![CDATA[");
		sb.append(getPublishVerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>countryCode</column-name><column-value><![CDATA[");
		sb.append(getCountryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expiredRefTxt</column-name><column-value><![CDATA[");
		sb.append(getExpiredRefTxt());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatCode</column-name><column-value><![CDATA[");
		sb.append(getPublishStatCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdComplyDeadlineDate</column-name><column-value><![CDATA[");
		sb.append(getStdComplyDeadlineDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>orderNumber</column-name><column-value><![CDATA[");
		sb.append(getOrderNumber());
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

	private String _publishCountryStdId;
	private long _publishVerId;
	private String _countryCode;
	private String _expiredRefTxt;
	private String _publishStatCode;
	private Date _stdComplyDeadlineDate;
	private long _orderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publishCountryStandardRemoteModel;
}