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
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.FlagCategoryPK;

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
public class FlagCategoryClp extends BaseModelImpl<FlagCategory>
	implements FlagCategory {
	public FlagCategoryClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return FlagCategory.class;
	}

	@Override
	public String getModelClassName() {
		return FlagCategory.class.getName();
	}

	@Override
	public FlagCategoryPK getPrimaryKey() {
		return new FlagCategoryPK(_flagCatId, _activeInd);
	}

	@Override
	public void setPrimaryKey(FlagCategoryPK primaryKey) {
		setFlagCatId(primaryKey.flagCatId);
		setActiveInd(primaryKey.activeInd);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new FlagCategoryPK(_flagCatId, _activeInd);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((FlagCategoryPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("flagCatId", getFlagCatId());
		attributes.put("activeInd", getActiveInd());
		attributes.put("parentCatId", getParentCatId());
		attributes.put("catOrField", getCatOrField());
		attributes.put("txtValue", getTxtValue());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long flagCatId = (Long)attributes.get("flagCatId");

		if (flagCatId != null) {
			setFlagCatId(flagCatId);
		}

		String activeInd = (String)attributes.get("activeInd");

		if (activeInd != null) {
			setActiveInd(activeInd);
		}

		Long parentCatId = (Long)attributes.get("parentCatId");

		if (parentCatId != null) {
			setParentCatId(parentCatId);
		}

		String catOrField = (String)attributes.get("catOrField");

		if (catOrField != null) {
			setCatOrField(catOrField);
		}

		String txtValue = (String)attributes.get("txtValue");

		if (txtValue != null) {
			setTxtValue(txtValue);
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
	public long getFlagCatId() {
		return _flagCatId;
	}

	@Override
	public void setFlagCatId(long flagCatId) {
		_flagCatId = flagCatId;

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setFlagCatId", long.class);

				method.invoke(_flagCategoryRemoteModel, flagCatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getActiveInd() {
		return _activeInd;
	}

	@Override
	public void setActiveInd(String activeInd) {
		_activeInd = activeInd;

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setActiveInd", String.class);

				method.invoke(_flagCategoryRemoteModel, activeInd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentCatId() {
		return _parentCatId;
	}

	@Override
	public void setParentCatId(long parentCatId) {
		_parentCatId = parentCatId;

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setParentCatId", long.class);

				method.invoke(_flagCategoryRemoteModel, parentCatId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCatOrField() {
		return _catOrField;
	}

	@Override
	public void setCatOrField(String catOrField) {
		_catOrField = catOrField;

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCatOrField", String.class);

				method.invoke(_flagCategoryRemoteModel, catOrField);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTxtValue() {
		return _txtValue;
	}

	@Override
	public void setTxtValue(String txtValue) {
		_txtValue = txtValue;

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setTxtValue", String.class);

				method.invoke(_flagCategoryRemoteModel, txtValue);
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

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderNumber", long.class);

				method.invoke(_flagCategoryRemoteModel, orderNumber);
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

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_flagCategoryRemoteModel, creatorId);
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

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_flagCategoryRemoteModel, createdDate);
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

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_flagCategoryRemoteModel, updatedBy);
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

		if (_flagCategoryRemoteModel != null) {
			try {
				Class<?> clazz = _flagCategoryRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_flagCategoryRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getFlagCategoryRemoteModel() {
		return _flagCategoryRemoteModel;
	}

	public void setFlagCategoryRemoteModel(BaseModel<?> flagCategoryRemoteModel) {
		_flagCategoryRemoteModel = flagCategoryRemoteModel;
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

		Class<?> remoteModelClass = _flagCategoryRemoteModel.getClass();

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

		Object returnValue = method.invoke(_flagCategoryRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			FlagCategoryLocalServiceUtil.addFlagCategory(this);
		}
		else {
			FlagCategoryLocalServiceUtil.updateFlagCategory(this);
		}
	}

	@Override
	public FlagCategory toEscapedModel() {
		return (FlagCategory)ProxyUtil.newProxyInstance(FlagCategory.class.getClassLoader(),
			new Class[] { FlagCategory.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		FlagCategoryClp clone = new FlagCategoryClp();

		clone.setFlagCatId(getFlagCatId());
		clone.setActiveInd(getActiveInd());
		clone.setParentCatId(getParentCatId());
		clone.setCatOrField(getCatOrField());
		clone.setTxtValue(getTxtValue());
		clone.setOrderNumber(getOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(FlagCategory flagCategory) {
		int value = 0;

		if (getOrderNumber() < flagCategory.getOrderNumber()) {
			value = -1;
		}
		else if (getOrderNumber() > flagCategory.getOrderNumber()) {
			value = 1;
		}
		else {
			value = 0;
		}

		if (value != 0) {
			return value;
		}

		return 0;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof FlagCategoryClp)) {
			return false;
		}

		FlagCategoryClp flagCategory = (FlagCategoryClp)obj;

		FlagCategoryPK primaryKey = flagCategory.getPrimaryKey();

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
		StringBundler sb = new StringBundler(21);

		sb.append("{flagCatId=");
		sb.append(getFlagCatId());
		sb.append(", activeInd=");
		sb.append(getActiveInd());
		sb.append(", parentCatId=");
		sb.append(getParentCatId());
		sb.append(", catOrField=");
		sb.append(getCatOrField());
		sb.append(", txtValue=");
		sb.append(getTxtValue());
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
		StringBundler sb = new StringBundler(34);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.FlagCategory");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>flagCatId</column-name><column-value><![CDATA[");
		sb.append(getFlagCatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>activeInd</column-name><column-value><![CDATA[");
		sb.append(getActiveInd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentCatId</column-name><column-value><![CDATA[");
		sb.append(getParentCatId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>catOrField</column-name><column-value><![CDATA[");
		sb.append(getCatOrField());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>txtValue</column-name><column-value><![CDATA[");
		sb.append(getTxtValue());
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

	private long _flagCatId;
	private String _activeInd;
	private long _parentCatId;
	private String _catOrField;
	private String _txtValue;
	private long _orderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _flagCategoryRemoteModel;
}