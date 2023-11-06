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

import com.ihg.brandstandards.db.service.BridgePublishPreviewLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class BridgePublishPreviewClp extends BaseModelImpl<BridgePublishPreview>
	implements BridgePublishPreview {
	public BridgePublishPreviewClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BridgePublishPreview.class;
	}

	@Override
	public String getModelClassName() {
		return BridgePublishPreview.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _stdId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setStdId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _stdId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("taxonomyTitle", getTaxonomyTitle());
		attributes.put("title", getTitle());
		attributes.put("path", getPath());
		attributes.put("parentStdId", getParentStdId());
		attributes.put("currentTitle", getCurrentTitle());
		attributes.put("type", getType());
		attributes.put("displayOrder", getDisplayOrder());
		attributes.put("taxonomyId", getTaxonomyId());
		attributes.put("parentTaxonomyId", getParentTaxonomyId());
		attributes.put("indexOrder", getIndexOrder());
		attributes.put("level", getLevel());
		attributes.put("levelSortOrder", getLevelSortOrder());
		attributes.put("status", getStatus());
		attributes.put("imageCount", getImageCount());
		attributes.put("attachmentCount", getAttachmentCount());
		attributes.put("xRefCount", getXRefCount());
		attributes.put("hotelLifeCycle", getHotelLifeCycle());
		attributes.put("complianceCount", getComplianceCount());
		attributes.put("hotelAttributes", getHotelAttributes());
		attributes.put("complianceDate", getComplianceDate());
		attributes.put("stdReference", getStdReference());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String taxonomyTitle = (String)attributes.get("taxonomyTitle");

		if (taxonomyTitle != null) {
			setTaxonomyTitle(taxonomyTitle);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String path = (String)attributes.get("path");

		if (path != null) {
			setPath(path);
		}

		Long parentStdId = (Long)attributes.get("parentStdId");

		if (parentStdId != null) {
			setParentStdId(parentStdId);
		}

		String currentTitle = (String)attributes.get("currentTitle");

		if (currentTitle != null) {
			setCurrentTitle(currentTitle);
		}

		String type = (String)attributes.get("type");

		if (type != null) {
			setType(type);
		}

		Long displayOrder = (Long)attributes.get("displayOrder");

		if (displayOrder != null) {
			setDisplayOrder(displayOrder);
		}

		Long taxonomyId = (Long)attributes.get("taxonomyId");

		if (taxonomyId != null) {
			setTaxonomyId(taxonomyId);
		}

		Long parentTaxonomyId = (Long)attributes.get("parentTaxonomyId");

		if (parentTaxonomyId != null) {
			setParentTaxonomyId(parentTaxonomyId);
		}

		Long indexOrder = (Long)attributes.get("indexOrder");

		if (indexOrder != null) {
			setIndexOrder(indexOrder);
		}

		Long level = (Long)attributes.get("level");

		if (level != null) {
			setLevel(level);
		}

		Long levelSortOrder = (Long)attributes.get("levelSortOrder");

		if (levelSortOrder != null) {
			setLevelSortOrder(levelSortOrder);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		Long imageCount = (Long)attributes.get("imageCount");

		if (imageCount != null) {
			setImageCount(imageCount);
		}

		Long attachmentCount = (Long)attributes.get("attachmentCount");

		if (attachmentCount != null) {
			setAttachmentCount(attachmentCount);
		}

		Long xRefCount = (Long)attributes.get("xRefCount");

		if (xRefCount != null) {
			setXRefCount(xRefCount);
		}

		Long hotelLifeCycle = (Long)attributes.get("hotelLifeCycle");

		if (hotelLifeCycle != null) {
			setHotelLifeCycle(hotelLifeCycle);
		}

		Long complianceCount = (Long)attributes.get("complianceCount");

		if (complianceCount != null) {
			setComplianceCount(complianceCount);
		}

		String hotelAttributes = (String)attributes.get("hotelAttributes");

		if (hotelAttributes != null) {
			setHotelAttributes(hotelAttributes);
		}

		String complianceDate = (String)attributes.get("complianceDate");

		if (complianceDate != null) {
			setComplianceDate(complianceDate);
		}

		String stdReference = (String)attributes.get("stdReference");

		if (stdReference != null) {
			setStdReference(stdReference);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getTaxonomyTitle() {
		return _taxonomyTitle;
	}

	@Override
	public void setTaxonomyTitle(String taxonomyTitle) {
		_taxonomyTitle = taxonomyTitle;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyTitle", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, taxonomyTitle);
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

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getPath() {
		return _path;
	}

	@Override
	public void setPath(String path) {
		_path = path;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setPath", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, path);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentStdId() {
		return _parentStdId;
	}

	@Override
	public void setParentStdId(long parentStdId) {
		_parentStdId = parentStdId;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setParentStdId", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, parentStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCurrentTitle() {
		return _currentTitle;
	}

	@Override
	public void setCurrentTitle(String currentTitle) {
		_currentTitle = currentTitle;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setCurrentTitle", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, currentTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getType() {
		return _type;
	}

	@Override
	public void setType(String type) {
		_type = type;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setType", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, type);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getDisplayOrder() {
		return _displayOrder;
	}

	@Override
	public void setDisplayOrder(long displayOrder) {
		_displayOrder = displayOrder;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setDisplayOrder", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, displayOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getTaxonomyId() {
		return _taxonomyId;
	}

	@Override
	public void setTaxonomyId(long taxonomyId) {
		_taxonomyId = taxonomyId;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setTaxonomyId", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, taxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentTaxonomyId() {
		return _parentTaxonomyId;
	}

	@Override
	public void setParentTaxonomyId(long parentTaxonomyId) {
		_parentTaxonomyId = parentTaxonomyId;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setParentTaxonomyId",
						long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, parentTaxonomyId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexOrder() {
		return _indexOrder;
	}

	@Override
	public void setIndexOrder(long indexOrder) {
		_indexOrder = indexOrder;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrder", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, indexOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevel() {
		return _level;
	}

	@Override
	public void setLevel(long level) {
		_level = level;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setLevel", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, level);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getLevelSortOrder() {
		return _levelSortOrder;
	}

	@Override
	public void setLevelSortOrder(long levelSortOrder) {
		_levelSortOrder = levelSortOrder;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setLevelSortOrder", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, levelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStatus() {
		return _status;
	}

	@Override
	public void setStatus(String status) {
		_status = status;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getImageCount() {
		return _imageCount;
	}

	@Override
	public void setImageCount(long imageCount) {
		_imageCount = imageCount;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setImageCount", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, imageCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAttachmentCount() {
		return _attachmentCount;
	}

	@Override
	public void setAttachmentCount(long attachmentCount) {
		_attachmentCount = attachmentCount;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setAttachmentCount", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, attachmentCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getXRefCount() {
		return _xRefCount;
	}

	@Override
	public void setXRefCount(long xRefCount) {
		_xRefCount = xRefCount;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setXRefCount", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, xRefCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getHotelLifeCycle() {
		return _hotelLifeCycle;
	}

	@Override
	public void setHotelLifeCycle(long hotelLifeCycle) {
		_hotelLifeCycle = hotelLifeCycle;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelLifeCycle", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, hotelLifeCycle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getComplianceCount() {
		return _complianceCount;
	}

	@Override
	public void setComplianceCount(long complianceCount) {
		_complianceCount = complianceCount;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceCount", long.class);

				method.invoke(_bridgePublishPreviewRemoteModel, complianceCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHotelAttributes() {
		return _hotelAttributes;
	}

	@Override
	public void setHotelAttributes(String hotelAttributes) {
		_hotelAttributes = hotelAttributes;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setHotelAttributes",
						String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, hotelAttributes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getComplianceDate() {
		return _complianceDate;
	}

	@Override
	public void setComplianceDate(String complianceDate) {
		_complianceDate = complianceDate;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setComplianceDate",
						String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, complianceDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdReference() {
		return _stdReference;
	}

	@Override
	public void setStdReference(String stdReference) {
		_stdReference = stdReference;

		if (_bridgePublishPreviewRemoteModel != null) {
			try {
				Class<?> clazz = _bridgePublishPreviewRemoteModel.getClass();

				Method method = clazz.getMethod("setStdReference", String.class);

				method.invoke(_bridgePublishPreviewRemoteModel, stdReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	public BaseModel<?> getBridgePublishPreviewRemoteModel() {
		return _bridgePublishPreviewRemoteModel;
	}

	public void setBridgePublishPreviewRemoteModel(
		BaseModel<?> bridgePublishPreviewRemoteModel) {
		_bridgePublishPreviewRemoteModel = bridgePublishPreviewRemoteModel;
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

		Class<?> remoteModelClass = _bridgePublishPreviewRemoteModel.getClass();

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

		Object returnValue = method.invoke(_bridgePublishPreviewRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BridgePublishPreviewLocalServiceUtil.addBridgePublishPreview(this);
		}
		else {
			BridgePublishPreviewLocalServiceUtil.updateBridgePublishPreview(this);
		}
	}

	@Override
	public BridgePublishPreview toEscapedModel() {
		return (BridgePublishPreview)ProxyUtil.newProxyInstance(BridgePublishPreview.class.getClassLoader(),
			new Class[] { BridgePublishPreview.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BridgePublishPreviewClp clone = new BridgePublishPreviewClp();

		clone.setStdId(getStdId());
		clone.setTaxonomyTitle(getTaxonomyTitle());
		clone.setTitle(getTitle());
		clone.setPath(getPath());
		clone.setParentStdId(getParentStdId());
		clone.setCurrentTitle(getCurrentTitle());
		clone.setType(getType());
		clone.setDisplayOrder(getDisplayOrder());
		clone.setTaxonomyId(getTaxonomyId());
		clone.setParentTaxonomyId(getParentTaxonomyId());
		clone.setIndexOrder(getIndexOrder());
		clone.setLevel(getLevel());
		clone.setLevelSortOrder(getLevelSortOrder());
		clone.setStatus(getStatus());
		clone.setImageCount(getImageCount());
		clone.setAttachmentCount(getAttachmentCount());
		clone.setXRefCount(getXRefCount());
		clone.setHotelLifeCycle(getHotelLifeCycle());
		clone.setComplianceCount(getComplianceCount());
		clone.setHotelAttributes(getHotelAttributes());
		clone.setComplianceDate(getComplianceDate());
		clone.setStdReference(getStdReference());

		return clone;
	}

	@Override
	public int compareTo(BridgePublishPreview bridgePublishPreview) {
		long primaryKey = bridgePublishPreview.getPrimaryKey();

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

		if (!(obj instanceof BridgePublishPreviewClp)) {
			return false;
		}

		BridgePublishPreviewClp bridgePublishPreview = (BridgePublishPreviewClp)obj;

		long primaryKey = bridgePublishPreview.getPrimaryKey();

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
		StringBundler sb = new StringBundler(45);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", taxonomyTitle=");
		sb.append(getTaxonomyTitle());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", path=");
		sb.append(getPath());
		sb.append(", parentStdId=");
		sb.append(getParentStdId());
		sb.append(", currentTitle=");
		sb.append(getCurrentTitle());
		sb.append(", type=");
		sb.append(getType());
		sb.append(", displayOrder=");
		sb.append(getDisplayOrder());
		sb.append(", taxonomyId=");
		sb.append(getTaxonomyId());
		sb.append(", parentTaxonomyId=");
		sb.append(getParentTaxonomyId());
		sb.append(", indexOrder=");
		sb.append(getIndexOrder());
		sb.append(", level=");
		sb.append(getLevel());
		sb.append(", levelSortOrder=");
		sb.append(getLevelSortOrder());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", imageCount=");
		sb.append(getImageCount());
		sb.append(", attachmentCount=");
		sb.append(getAttachmentCount());
		sb.append(", xRefCount=");
		sb.append(getXRefCount());
		sb.append(", hotelLifeCycle=");
		sb.append(getHotelLifeCycle());
		sb.append(", complianceCount=");
		sb.append(getComplianceCount());
		sb.append(", hotelAttributes=");
		sb.append(getHotelAttributes());
		sb.append(", complianceDate=");
		sb.append(getComplianceDate());
		sb.append(", stdReference=");
		sb.append(getStdReference());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(70);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.BridgePublishPreview");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyTitle</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>path</column-name><column-value><![CDATA[");
		sb.append(getPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentStdId</column-name><column-value><![CDATA[");
		sb.append(getParentStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>currentTitle</column-name><column-value><![CDATA[");
		sb.append(getCurrentTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>type</column-name><column-value><![CDATA[");
		sb.append(getType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>displayOrder</column-name><column-value><![CDATA[");
		sb.append(getDisplayOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>taxonomyId</column-name><column-value><![CDATA[");
		sb.append(getTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentTaxonomyId</column-name><column-value><![CDATA[");
		sb.append(getParentTaxonomyId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>level</column-name><column-value><![CDATA[");
		sb.append(getLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>levelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getLevelSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>imageCount</column-name><column-value><![CDATA[");
		sb.append(getImageCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>attachmentCount</column-name><column-value><![CDATA[");
		sb.append(getAttachmentCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>xRefCount</column-name><column-value><![CDATA[");
		sb.append(getXRefCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotelLifeCycle</column-name><column-value><![CDATA[");
		sb.append(getHotelLifeCycle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceCount</column-name><column-value><![CDATA[");
		sb.append(getComplianceCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>hotelAttributes</column-name><column-value><![CDATA[");
		sb.append(getHotelAttributes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>complianceDate</column-name><column-value><![CDATA[");
		sb.append(getComplianceDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdReference</column-name><column-value><![CDATA[");
		sb.append(getStdReference());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private String _taxonomyTitle;
	private String _title;
	private String _path;
	private long _parentStdId;
	private String _currentTitle;
	private String _type;
	private long _displayOrder;
	private long _taxonomyId;
	private long _parentTaxonomyId;
	private long _indexOrder;
	private long _level;
	private long _levelSortOrder;
	private String _status;
	private long _imageCount;
	private long _attachmentCount;
	private long _xRefCount;
	private long _hotelLifeCycle;
	private long _complianceCount;
	private String _hotelAttributes;
	private String _complianceDate;
	private String _stdReference;
	private BaseModel<?> _bridgePublishPreviewRemoteModel;
}