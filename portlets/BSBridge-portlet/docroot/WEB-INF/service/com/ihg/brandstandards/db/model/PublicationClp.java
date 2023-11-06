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
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;

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
public class PublicationClp extends BaseModelImpl<Publication>
	implements Publication {
	public PublicationClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Publication.class;
	}

	@Override
	public String getModelClassName() {
		return Publication.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishId", getPublishId());
		attributes.put("publishVerId", getPublishVerId());
		attributes.put("publishStatCd", getPublishStatCd());
		attributes.put("chainCode", getChainCode());
		attributes.put("publishEnvName", getPublishEnvName());
		attributes.put("publishLocaleList", getPublishLocaleList());
		attributes.put("publishDate", getPublishDate());
		attributes.put("publishContentType", getPublishContentType());
		attributes.put("parentPublishId", getParentPublishId());
		attributes.put("validateTranslation", getValidateTranslation());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long publishVerId = (Long)attributes.get("publishVerId");

		if (publishVerId != null) {
			setPublishVerId(publishVerId);
		}

		String publishStatCd = (String)attributes.get("publishStatCd");

		if (publishStatCd != null) {
			setPublishStatCd(publishStatCd);
		}

		String chainCode = (String)attributes.get("chainCode");

		if (chainCode != null) {
			setChainCode(chainCode);
		}

		String publishEnvName = (String)attributes.get("publishEnvName");

		if (publishEnvName != null) {
			setPublishEnvName(publishEnvName);
		}

		String publishLocaleList = (String)attributes.get("publishLocaleList");

		if (publishLocaleList != null) {
			setPublishLocaleList(publishLocaleList);
		}

		Date publishDate = (Date)attributes.get("publishDate");

		if (publishDate != null) {
			setPublishDate(publishDate);
		}

		String publishContentType = (String)attributes.get("publishContentType");

		if (publishContentType != null) {
			setPublishContentType(publishContentType);
		}

		Long parentPublishId = (Long)attributes.get("parentPublishId");

		if (parentPublishId != null) {
			setParentPublishId(parentPublishId);
		}

		String validateTranslation = (String)attributes.get(
				"validateTranslation");

		if (validateTranslation != null) {
			setValidateTranslation(validateTranslation);
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
	public long getPublishId() {
		return _publishId;
	}

	@Override
	public void setPublishId(long publishId) {
		_publishId = publishId;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publicationRemoteModel, publishId);
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

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishVerId", long.class);

				method.invoke(_publicationRemoteModel, publishVerId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishStatCd() {
		return _publishStatCd;
	}

	@Override
	public void setPublishStatCd(String publishStatCd) {
		_publishStatCd = publishStatCd;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishStatCd", String.class);

				method.invoke(_publicationRemoteModel, publishStatCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChainCode() {
		return _chainCode;
	}

	@Override
	public void setChainCode(String chainCode) {
		_chainCode = chainCode;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setChainCode", String.class);

				method.invoke(_publicationRemoteModel, chainCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishEnvName() {
		return _publishEnvName;
	}

	@Override
	public void setPublishEnvName(String publishEnvName) {
		_publishEnvName = publishEnvName;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishEnvName",
						String.class);

				method.invoke(_publicationRemoteModel, publishEnvName);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishLocaleList() {
		return _publishLocaleList;
	}

	@Override
	public void setPublishLocaleList(String publishLocaleList) {
		_publishLocaleList = publishLocaleList;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishLocaleList",
						String.class);

				method.invoke(_publicationRemoteModel, publishLocaleList);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getPublishDate() {
		return _publishDate;
	}

	@Override
	public void setPublishDate(Date publishDate) {
		_publishDate = publishDate;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishDate", Date.class);

				method.invoke(_publicationRemoteModel, publishDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPublishContentType() {
		return _publishContentType;
	}

	@Override
	public void setPublishContentType(String publishContentType) {
		_publishContentType = publishContentType;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishContentType",
						String.class);

				method.invoke(_publicationRemoteModel, publishContentType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentPublishId() {
		return _parentPublishId;
	}

	@Override
	public void setParentPublishId(long parentPublishId) {
		_parentPublishId = parentPublishId;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setParentPublishId", long.class);

				method.invoke(_publicationRemoteModel, parentPublishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getValidateTranslation() {
		return _validateTranslation;
	}

	@Override
	public void setValidateTranslation(String validateTranslation) {
		_validateTranslation = validateTranslation;

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setValidateTranslation",
						String.class);

				method.invoke(_publicationRemoteModel, validateTranslation);
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

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_publicationRemoteModel, creatorId);
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

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publicationRemoteModel, createdDate);
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

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publicationRemoteModel, updatedBy);
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

		if (_publicationRemoteModel != null) {
			try {
				Class<?> clazz = _publicationRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publicationRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublicationRemoteModel() {
		return _publicationRemoteModel;
	}

	public void setPublicationRemoteModel(BaseModel<?> publicationRemoteModel) {
		_publicationRemoteModel = publicationRemoteModel;
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

		Class<?> remoteModelClass = _publicationRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publicationRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublicationLocalServiceUtil.addPublication(this);
		}
		else {
			PublicationLocalServiceUtil.updatePublication(this);
		}
	}

	@Override
	public Publication toEscapedModel() {
		return (Publication)ProxyUtil.newProxyInstance(Publication.class.getClassLoader(),
			new Class[] { Publication.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublicationClp clone = new PublicationClp();

		clone.setPublishId(getPublishId());
		clone.setPublishVerId(getPublishVerId());
		clone.setPublishStatCd(getPublishStatCd());
		clone.setChainCode(getChainCode());
		clone.setPublishEnvName(getPublishEnvName());
		clone.setPublishLocaleList(getPublishLocaleList());
		clone.setPublishDate(getPublishDate());
		clone.setPublishContentType(getPublishContentType());
		clone.setParentPublishId(getParentPublishId());
		clone.setValidateTranslation(getValidateTranslation());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(Publication publication) {
		long primaryKey = publication.getPrimaryKey();

		if (getPrimaryKey() < primaryKey) {
			return -1;
		}
		else if (getPrimaryKey() > primaryKey) {
			return 1;
		}
		else {
			return 0;
		}
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof PublicationClp)) {
			return false;
		}

		PublicationClp publication = (PublicationClp)obj;

		long primaryKey = publication.getPrimaryKey();

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
		StringBundler sb = new StringBundler(29);

		sb.append("{publishId=");
		sb.append(getPublishId());
		sb.append(", publishVerId=");
		sb.append(getPublishVerId());
		sb.append(", publishStatCd=");
		sb.append(getPublishStatCd());
		sb.append(", chainCode=");
		sb.append(getChainCode());
		sb.append(", publishEnvName=");
		sb.append(getPublishEnvName());
		sb.append(", publishLocaleList=");
		sb.append(getPublishLocaleList());
		sb.append(", publishDate=");
		sb.append(getPublishDate());
		sb.append(", publishContentType=");
		sb.append(getPublishContentType());
		sb.append(", parentPublishId=");
		sb.append(getParentPublishId());
		sb.append(", validateTranslation=");
		sb.append(getValidateTranslation());
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
		StringBundler sb = new StringBundler(46);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.Publication");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishVerId</column-name><column-value><![CDATA[");
		sb.append(getPublishVerId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishStatCd</column-name><column-value><![CDATA[");
		sb.append(getPublishStatCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chainCode</column-name><column-value><![CDATA[");
		sb.append(getChainCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishEnvName</column-name><column-value><![CDATA[");
		sb.append(getPublishEnvName());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishLocaleList</column-name><column-value><![CDATA[");
		sb.append(getPublishLocaleList());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishDate</column-name><column-value><![CDATA[");
		sb.append(getPublishDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishContentType</column-name><column-value><![CDATA[");
		sb.append(getPublishContentType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentPublishId</column-name><column-value><![CDATA[");
		sb.append(getParentPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>validateTranslation</column-name><column-value><![CDATA[");
		sb.append(getValidateTranslation());
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

	private long _publishId;
	private long _publishVerId;
	private String _publishStatCd;
	private String _chainCode;
	private String _publishEnvName;
	private String _publishLocaleList;
	private Date _publishDate;
	private String _publishContentType;
	private long _parentPublishId;
	private String _validateTranslation;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publicationRemoteModel;
}