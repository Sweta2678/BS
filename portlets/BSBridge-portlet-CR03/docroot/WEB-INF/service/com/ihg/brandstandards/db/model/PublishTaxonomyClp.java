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
import com.ihg.brandstandards.db.service.PublishTaxonomyLocalServiceUtil;

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
public class PublishTaxonomyClp extends BaseModelImpl<PublishTaxonomy>
	implements PublishTaxonomy {
	public PublishTaxonomyClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return PublishTaxonomy.class;
	}

	@Override
	public String getModelClassName() {
		return PublishTaxonomy.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _publishTaxId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setPublishTaxId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _publishTaxId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("publishTaxId", getPublishTaxId());
		attributes.put("publishId", getPublishId());
		attributes.put("taxId", getTaxId());
		attributes.put("publishParentId", getPublishParentId());
		attributes.put("title", getTitle());
		attributes.put("desc", getDesc());
		attributes.put("imageLoc", getImageLoc());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("position", getPosition());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long publishTaxId = (Long)attributes.get("publishTaxId");

		if (publishTaxId != null) {
			setPublishTaxId(publishTaxId);
		}

		Long publishId = (Long)attributes.get("publishId");

		if (publishId != null) {
			setPublishId(publishId);
		}

		Long taxId = (Long)attributes.get("taxId");

		if (taxId != null) {
			setTaxId(taxId);
		}

		Long publishParentId = (Long)attributes.get("publishParentId");

		if (publishParentId != null) {
			setPublishParentId(publishParentId);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String desc = (String)attributes.get("desc");

		if (desc != null) {
			setDesc(desc);
		}

		String imageLoc = (String)attributes.get("imageLoc");

		if (imageLoc != null) {
			setImageLoc(imageLoc);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		Long position = (Long)attributes.get("position");

		if (position != null) {
			setPosition(position);
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
	public long getPublishTaxId() {
		return _publishTaxId;
	}

	@Override
	public void setPublishTaxId(long publishTaxId) {
		_publishTaxId = publishTaxId;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishTaxId", long.class);

				method.invoke(_publishTaxonomyRemoteModel, publishTaxId);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishId", long.class);

				method.invoke(_publishTaxonomyRemoteModel, publishId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaxId() {
		return _taxId;
	}

	@Override
	public void setTaxId(long taxId) {
		_taxId = taxId;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxId", long.class);

				method.invoke(_publishTaxonomyRemoteModel, taxId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPublishParentId() {
		return _publishParentId;
	}

	@Override
	public void setPublishParentId(long publishParentId) {
		_publishParentId = publishParentId;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setPublishParentId", long.class);

				method.invoke(_publishTaxonomyRemoteModel, publishParentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTitle() {
		return _title;
	}

	@Override
	public void setTitle(String title) {
		_title = title;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_publishTaxonomyRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDesc() {
		return _desc;
	}

	@Override
	public void setDesc(String desc) {
		_desc = desc;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setDesc", String.class);

				method.invoke(_publishTaxonomyRemoteModel, desc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImageLoc() {
		return _imageLoc;
	}

	@Override
	public void setImageLoc(String imageLoc) {
		_imageLoc = imageLoc;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setImageLoc", String.class);

				method.invoke(_publishTaxonomyRemoteModel, imageLoc);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_publishTaxonomyRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getPosition() {
		return _position;
	}

	@Override
	public void setPosition(long position) {
		_position = position;

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setPosition", long.class);

				method.invoke(_publishTaxonomyRemoteModel, position);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_publishTaxonomyRemoteModel, creatorId);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_publishTaxonomyRemoteModel, createdDate);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_publishTaxonomyRemoteModel, updatedBy);
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

		if (_publishTaxonomyRemoteModel != null) {
			try {
				Class<?> clazz = _publishTaxonomyRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_publishTaxonomyRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getPublishTaxonomyRemoteModel() {
		return _publishTaxonomyRemoteModel;
	}

	public void setPublishTaxonomyRemoteModel(
		BaseModel<?> publishTaxonomyRemoteModel) {
		_publishTaxonomyRemoteModel = publishTaxonomyRemoteModel;
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

		Class<?> remoteModelClass = _publishTaxonomyRemoteModel.getClass();

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

		Object returnValue = method.invoke(_publishTaxonomyRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			PublishTaxonomyLocalServiceUtil.addPublishTaxonomy(this);
		}
		else {
			PublishTaxonomyLocalServiceUtil.updatePublishTaxonomy(this);
		}
	}

	@Override
	public PublishTaxonomy toEscapedModel() {
		return (PublishTaxonomy)ProxyUtil.newProxyInstance(PublishTaxonomy.class.getClassLoader(),
			new Class[] { PublishTaxonomy.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		PublishTaxonomyClp clone = new PublishTaxonomyClp();

		clone.setPublishTaxId(getPublishTaxId());
		clone.setPublishId(getPublishId());
		clone.setTaxId(getTaxId());
		clone.setPublishParentId(getPublishParentId());
		clone.setTitle(getTitle());
		clone.setDesc(getDesc());
		clone.setImageLoc(getImageLoc());
		clone.setCreatedBy(getCreatedBy());
		clone.setPosition(getPosition());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(PublishTaxonomy publishTaxonomy) {
		long primaryKey = publishTaxonomy.getPrimaryKey();

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

		if (!(obj instanceof PublishTaxonomyClp)) {
			return false;
		}

		PublishTaxonomyClp publishTaxonomy = (PublishTaxonomyClp)obj;

		long primaryKey = publishTaxonomy.getPrimaryKey();

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
		StringBundler sb = new StringBundler(27);

		sb.append("{publishTaxId=");
		sb.append(getPublishTaxId());
		sb.append(", publishId=");
		sb.append(getPublishId());
		sb.append(", taxId=");
		sb.append(getTaxId());
		sb.append(", publishParentId=");
		sb.append(getPublishParentId());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", desc=");
		sb.append(getDesc());
		sb.append(", imageLoc=");
		sb.append(getImageLoc());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", position=");
		sb.append(getPosition());
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
		StringBundler sb = new StringBundler(43);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.PublishTaxonomy");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>publishTaxId</column-name><column-value><![CDATA[");
		sb.append(getPublishTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishId</column-name><column-value><![CDATA[");
		sb.append(getPublishId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxId</column-name><column-value><![CDATA[");
		sb.append(getTaxId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>publishParentId</column-name><column-value><![CDATA[");
		sb.append(getPublishParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>desc</column-name><column-value><![CDATA[");
		sb.append(getDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageLoc</column-name><column-value><![CDATA[");
		sb.append(getImageLoc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>position</column-name><column-value><![CDATA[");
		sb.append(getPosition());
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

	private long _publishTaxId;
	private long _publishId;
	private long _taxId;
	private long _publishParentId;
	private String _title;
	private String _desc;
	private String _imageLoc;
	private String _createdBy;
	private long _position;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _publishTaxonomyRemoteModel;
}