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
import com.ihg.brandstandards.db.service.PublishedPdfListLocalServiceUtil;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.DateUtil;
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
public class PublishedPdfListClp extends BaseModelImpl<PublishedPdfList>
	implements PublishedPdfList {
	public PublishedPdfListClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishedPdfList.class;
	}

	@Override
	public String getModelClassName() {
		return PublishedPdfList.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _pdfId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPdfId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _pdfId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("pdfId", getPdfId());
		attributes.put("pdfChainCode", getPdfChainCode());
		attributes.put("pdfCtryCode", getPdfCtryCode());
		attributes.put("pdfBuildType", getPdfBuildType());
		attributes.put("pdfYearNumber", getPdfYearNumber());
		attributes.put("pdfLocaleCode", getPdfLocaleCode());
		attributes.put("pdfVersionNumber", getPdfVersionNumber());
		attributes.put("pdfFileName", getPdfFileName());
		attributes.put("pdfFileURLText", getPdfFileURLText());
		attributes.put("publishId", getPublishId());
		attributes.put("pageSizeOrientationType", getPageSizeOrientationType());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long pdfId = (Long)attributes.get("pdfId");

		if (pdfId != null) {
			setPdfId(pdfId);
		}

		String pdfChainCode = (String)attributes.get("pdfChainCode");

		if (pdfChainCode != null) {
			setPdfChainCode(pdfChainCode);
		}

		String pdfCtryCode = (String)attributes.get("pdfCtryCode");

		if (pdfCtryCode != null) {
			setPdfCtryCode(pdfCtryCode);
		}

		String pdfBuildType = (String)attributes.get("pdfBuildType");

		if (pdfBuildType != null) {
			setPdfBuildType(pdfBuildType);
		}

		Integer pdfYearNumber = (Integer)attributes.get("pdfYearNumber");

		if (pdfYearNumber != null) {
			setPdfYearNumber(pdfYearNumber);
		}

		String pdfLocaleCode = (String)attributes.get("pdfLocaleCode");

		if (pdfLocaleCode != null) {
			setPdfLocaleCode(pdfLocaleCode);
		}

		Long pdfVersionNumber = (Long)attributes.get("pdfVersionNumber");

		if (pdfVersionNumber != null) {
			setPdfVersionNumber(pdfVersionNumber);
		}

		String pdfFileName = (String)attributes.get("pdfFileName");

		if (pdfFileName != null) {
			setPdfFileName(pdfFileName);
		}

		String pdfFileURLText = (String)attributes.get("pdfFileURLText");

		if (pdfFileURLText != null) {
			setPdfFileURLText(pdfFileURLText);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		String pageSizeOrientationType = (String)attributes.get(
				"pageSizeOrientationType");

		if (pageSizeOrientationType != null) {
			setPageSizeOrientationType(pageSizeOrientationType);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
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
	public long getPdfId() {
		return _pdfId;
	}

	@Override
	public void setPdfId(long pdfId) {
		_pdfId = pdfId;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfId", long.class);

				method.invoke(_publishedPdfListRemoteModel, pdfId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfChainCode() {
		return _pdfChainCode;
	}

	@Override
	public void setPdfChainCode(String pdfChainCode) {
		_pdfChainCode = pdfChainCode;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfChainCode", String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfChainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfCtryCode() {
		return _pdfCtryCode;
	}

	@Override
	public void setPdfCtryCode(String pdfCtryCode) {
		_pdfCtryCode = pdfCtryCode;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfCtryCode", String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfCtryCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfBuildType() {
		return _pdfBuildType;
	}

	@Override
	public void setPdfBuildType(String pdfBuildType) {
		_pdfBuildType = pdfBuildType;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfBuildType", String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfBuildType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public int getPdfYearNumber() {
		return _pdfYearNumber;
	}

	@Override
	public void setPdfYearNumber(int pdfYearNumber) {
		_pdfYearNumber = pdfYearNumber;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfYearNumber", int.class);

				method.invoke(_publishedPdfListRemoteModel, pdfYearNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfLocaleCode() {
		return _pdfLocaleCode;
	}

	@Override
	public void setPdfLocaleCode(String pdfLocaleCode) {
		_pdfLocaleCode = pdfLocaleCode;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfLocaleCode", String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfLocaleCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPdfVersionNumber() {
		return _pdfVersionNumber;
	}

	@Override
	public void setPdfVersionNumber(long pdfVersionNumber) {
		_pdfVersionNumber = pdfVersionNumber;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfVersionNumber",
						long.class);

				method.invoke(_publishedPdfListRemoteModel, pdfVersionNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfFileName() {
		return _pdfFileName;
	}

	@Override
	public void setPdfFileName(String pdfFileName) {
		_pdfFileName = pdfFileName;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfFileName", String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfFileName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPdfFileURLText() {
		return _pdfFileURLText;
	}

	@Override
	public void setPdfFileURLText(String pdfFileURLText) {
		_pdfFileURLText = pdfFileURLText;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPdfFileURLText",
						String.class);

				method.invoke(_publishedPdfListRemoteModel, pdfFileURLText);
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

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishedPdfListRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPageSizeOrientationType() {
		return _pageSizeOrientationType;
	}

	@Override
	public void setPageSizeOrientationType(String pageSizeOrientationType) {
		_pageSizeOrientationType = pageSizeOrientationType;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setPageSizeOrientationType",
						String.class);

				method.invoke(_publishedPdfListRemoteModel,
					pageSizeOrientationType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCreatedBy() {
		return _createdBy;
	}

	@Override
	public void setCreatedBy(String createdBy) {
		_createdBy = createdBy;

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_publishedPdfListRemoteModel, createdBy);
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

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publishedPdfListRemoteModel, createdDate);
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

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publishedPdfListRemoteModel, updatedBy);
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

		if (_publishedPdfListRemoteModel != null) {
			try {
				Class<?> clazz = _publishedPdfListRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publishedPdfListRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishedPdfListRemoteModel() {
		return _publishedPdfListRemoteModel;
	}

	public void setPublishedPdfListRemoteModel(
		BaseModel<?> publishedPdfListRemoteModel) {
		_publishedPdfListRemoteModel = publishedPdfListRemoteModel;
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

		Class<?> remoteModelClass = _publishedPdfListRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishedPdfListRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishedPdfListLocalServiceUtil.addPublishedPdfList(this);
		}
		else {
			PublishedPdfListLocalServiceUtil.updatePublishedPdfList(this);
		}
	}

	@Override
	public PublishedPdfList toEscapedModel() {
		return (PublishedPdfList)ProxyUtil.newProxyInstance(PublishedPdfList.class.getClassLoader(),
			new Class[] { PublishedPdfList.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishedPdfListClp clone = new PublishedPdfListClp();

		clone.setPdfId(getPdfId());
		clone.setPdfChainCode(getPdfChainCode());
		clone.setPdfCtryCode(getPdfCtryCode());
		clone.setPdfBuildType(getPdfBuildType());
		clone.setPdfYearNumber(getPdfYearNumber());
		clone.setPdfLocaleCode(getPdfLocaleCode());
		clone.setPdfVersionNumber(getPdfVersionNumber());
		clone.setPdfFileName(getPdfFileName());
		clone.setPdfFileURLText(getPdfFileURLText());
		clone.setPublishId(getPublishId());
		clone.setPageSizeOrientationType(getPageSizeOrientationType());
		clone.setCreatedBy(getCreatedBy());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(PublishedPdfList publishedPdfList) {
		int value = 0;

		value = DateUtil.compareTo(getUpdatedDate(),
				publishedPdfList.getUpdatedDate());

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

		if (!(obj instanceof PublishedPdfListClp)) {
			return false;
		}

		PublishedPdfListClp publishedPdfList = (PublishedPdfListClp)obj;

		long primaryKey = publishedPdfList.getPrimaryKey();

		if (getPrimaryKey() == primaryKey) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return (int)getPrimaryKey();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(31);

		sb.append("{pdfId=");
		sb.append(getPdfId());
		sb.append(", pdfChainCode=");
		sb.append(getPdfChainCode());
		sb.append(", pdfCtryCode=");
		sb.append(getPdfCtryCode());
		sb.append(", pdfBuildType=");
		sb.append(getPdfBuildType());
		sb.append(", pdfYearNumber=");
		sb.append(getPdfYearNumber());
		sb.append(", pdfLocaleCode=");
		sb.append(getPdfLocaleCode());
		sb.append(", pdfVersionNumber=");
		sb.append(getPdfVersionNumber());
		sb.append(", pdfFileName=");
		sb.append(getPdfFileName());
		sb.append(", pdfFileURLText=");
		sb.append(getPdfFileURLText());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", pageSizeOrientationType=");
		sb.append(getPageSizeOrientationType());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
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
		StringBundler sb = new StringBundler(49);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishedPdfList");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>pdfId</column-name><column-value><![CDATA[");
		sb.append(getPdfId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfChainCode</column-name><column-value><![CDATA[");
		sb.append(getPdfChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfCtryCode</column-name><column-value><![CDATA[");
		sb.append(getPdfCtryCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfBuildType</column-name><column-value><![CDATA[");
		sb.append(getPdfBuildType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfYearNumber</column-name><column-value><![CDATA[");
		sb.append(getPdfYearNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfLocaleCode</column-name><column-value><![CDATA[");
		sb.append(getPdfLocaleCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfVersionNumber</column-name><column-value><![CDATA[");
		sb.append(getPdfVersionNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfFileName</column-name><column-value><![CDATA[");
		sb.append(getPdfFileName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pdfFileURLText</column-name><column-value><![CDATA[");
		sb.append(getPdfFileURLText());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>pageSizeOrientationType</column-name><column-value><![CDATA[");
		sb.append(getPageSizeOrientationType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
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

	private long _pdfId;
	private String _pdfChainCode;
	private String _pdfCtryCode;
	private String _pdfBuildType;
	private int _pdfYearNumber;
	private String _pdfLocaleCode;
	private long _pdfVersionNumber;
	private String _pdfFileName;
	private String _pdfFileURLText;
	private long _publishId;
	private String _pageSizeOrientationType;
	private String _createdBy;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publishedPdfListRemoteModel;
}