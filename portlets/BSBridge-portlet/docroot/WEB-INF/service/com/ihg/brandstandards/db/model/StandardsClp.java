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
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;

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
public class StandardsClp extends BaseModelImpl<Standards> implements Standards {
	public StandardsClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return Standards.class;
	}

	@Override
	public String getModelClassName() {
		return Standards.class.getName();
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
		attributes.put("parentId", getParentId());
		attributes.put("stdTyp", getStdTyp());
		attributes.put("title", getTitle());
		attributes.put("description", getDescription());
		attributes.put("author", getAuthor());
		attributes.put("businessOwner", getBusinessOwner());
		attributes.put("effectiveDate", getEffectiveDate());
		attributes.put("implDate", getImplDate());
		attributes.put("waiver", getWaiver());
		attributes.put("status", getStatus());
		attributes.put("category", getCategory());
		attributes.put("createdBy", getCreatedBy());
		attributes.put("change", getChange());
		attributes.put("isGlobal", getIsGlobal());
		attributes.put("regionCode", getRegionCode());
		attributes.put("notes", getNotes());
		attributes.put("framework", getFramework());
		attributes.put("internalReference", getInternalReference());
		attributes.put("orderNumber", getOrderNumber());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());
		attributes.put("statusId", getStatusId());
		attributes.put("regionId", getRegionId());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long parentId = (Long)attributes.get("parentId");

		if (parentId != null) {
			setParentId(parentId);
		}

		String stdTyp = (String)attributes.get("stdTyp");

		if (stdTyp != null) {
			setStdTyp(stdTyp);
		}

		String title = (String)attributes.get("title");

		if (title != null) {
			setTitle(title);
		}

		String description = (String)attributes.get("description");

		if (description != null) {
			setDescription(description);
		}

		String author = (String)attributes.get("author");

		if (author != null) {
			setAuthor(author);
		}

		String businessOwner = (String)attributes.get("businessOwner");

		if (businessOwner != null) {
			setBusinessOwner(businessOwner);
		}

		Date effectiveDate = (Date)attributes.get("effectiveDate");

		if (effectiveDate != null) {
			setEffectiveDate(effectiveDate);
		}

		Date implDate = (Date)attributes.get("implDate");

		if (implDate != null) {
			setImplDate(implDate);
		}

		String waiver = (String)attributes.get("waiver");

		if (waiver != null) {
			setWaiver(waiver);
		}

		String status = (String)attributes.get("status");

		if (status != null) {
			setStatus(status);
		}

		String category = (String)attributes.get("category");

		if (category != null) {
			setCategory(category);
		}

		String createdBy = (String)attributes.get("createdBy");

		if (createdBy != null) {
			setCreatedBy(createdBy);
		}

		String change = (String)attributes.get("change");

		if (change != null) {
			setChange(change);
		}

		String isGlobal = (String)attributes.get("isGlobal");

		if (isGlobal != null) {
			setIsGlobal(isGlobal);
		}

		String regionCode = (String)attributes.get("regionCode");

		if (regionCode != null) {
			setRegionCode(regionCode);
		}

		String notes = (String)attributes.get("notes");

		if (notes != null) {
			setNotes(notes);
		}

		String framework = (String)attributes.get("framework");

		if (framework != null) {
			setFramework(framework);
		}

		String internalReference = (String)attributes.get("internalReference");

		if (internalReference != null) {
			setInternalReference(internalReference);
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

		Long statusId = (Long)attributes.get("statusId");

		if (statusId != null) {
			setStatusId(statusId);
		}

		Long regionId = (Long)attributes.get("regionId");

		if (regionId != null) {
			setRegionId(regionId);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getParentId() {
		return _parentId;
	}

	@Override
	public void setParentId(long parentId) {
		_parentId = parentId;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setParentId", long.class);

				method.invoke(_standardsRemoteModel, parentId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdTyp() {
		return _stdTyp;
	}

	@Override
	public void setStdTyp(String stdTyp) {
		_stdTyp = stdTyp;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStdTyp", String.class);

				method.invoke(_standardsRemoteModel, stdTyp);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setTitle", String.class);

				method.invoke(_standardsRemoteModel, title);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getDescription() {
		return _description;
	}

	@Override
	public void setDescription(String description) {
		_description = description;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setDescription", String.class);

				method.invoke(_standardsRemoteModel, description);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuthor() {
		return _author;
	}

	@Override
	public void setAuthor(String author) {
		_author = author;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setAuthor", String.class);

				method.invoke(_standardsRemoteModel, author);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBusinessOwner() {
		return _businessOwner;
	}

	@Override
	public void setBusinessOwner(String businessOwner) {
		_businessOwner = businessOwner;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setBusinessOwner", String.class);

				method.invoke(_standardsRemoteModel, businessOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getEffectiveDate() {
		return _effectiveDate;
	}

	@Override
	public void setEffectiveDate(Date effectiveDate) {
		_effectiveDate = effectiveDate;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setEffectiveDate", Date.class);

				method.invoke(_standardsRemoteModel, effectiveDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getImplDate() {
		return _implDate;
	}

	@Override
	public void setImplDate(Date implDate) {
		_implDate = implDate;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setImplDate", Date.class);

				method.invoke(_standardsRemoteModel, implDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getWaiver() {
		return _waiver;
	}

	@Override
	public void setWaiver(String waiver) {
		_waiver = waiver;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setWaiver", String.class);

				method.invoke(_standardsRemoteModel, waiver);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatus", String.class);

				method.invoke(_standardsRemoteModel, status);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCategory() {
		return _category;
	}

	@Override
	public void setCategory(String category) {
		_category = category;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCategory", String.class);

				method.invoke(_standardsRemoteModel, category);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedBy", String.class);

				method.invoke(_standardsRemoteModel, createdBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChange() {
		return _change;
	}

	@Override
	public void setChange(String change) {
		_change = change;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setChange", String.class);

				method.invoke(_standardsRemoteModel, change);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIsGlobal() {
		return _isGlobal;
	}

	@Override
	public void setIsGlobal(String isGlobal) {
		_isGlobal = isGlobal;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setIsGlobal", String.class);

				method.invoke(_standardsRemoteModel, isGlobal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegionCode() {
		return _regionCode;
	}

	@Override
	public void setRegionCode(String regionCode) {
		_regionCode = regionCode;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionCode", String.class);

				method.invoke(_standardsRemoteModel, regionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getNotes() {
		return _notes;
	}

	@Override
	public void setNotes(String notes) {
		_notes = notes;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setNotes", String.class);

				method.invoke(_standardsRemoteModel, notes);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getFramework() {
		return _framework;
	}

	@Override
	public void setFramework(String framework) {
		_framework = framework;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setFramework", String.class);

				method.invoke(_standardsRemoteModel, framework);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getInternalReference() {
		return _internalReference;
	}

	@Override
	public void setInternalReference(String internalReference) {
		_internalReference = internalReference;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setInternalReference",
						String.class);

				method.invoke(_standardsRemoteModel, internalReference);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setOrderNumber", long.class);

				method.invoke(_standardsRemoteModel, orderNumber);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_standardsRemoteModel, creatorId);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_standardsRemoteModel, createdDate);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_standardsRemoteModel, updatedBy);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_standardsRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStatusId() {
		return _statusId;
	}

	@Override
	public void setStatusId(long statusId) {
		_statusId = statusId;

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setStatusId", long.class);

				method.invoke(_standardsRemoteModel, statusId);
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

		if (_standardsRemoteModel != null) {
			try {
				Class<?> clazz = _standardsRemoteModel.getClass();

				Method method = clazz.getMethod("setRegionId", long.class);

				method.invoke(_standardsRemoteModel, regionId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public boolean isSearchMatches() {
		try {
			String methodName = "isSearchMatches";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setContextTransExist(boolean isContextTransExist) {
		try {
			String methodName = "setContextTransExist";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isContextTransExist };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isTextTransExist() {
		try {
			String methodName = "isTextTransExist";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setSearchMatches(boolean isSearchMatches) {
		try {
			String methodName = "setSearchMatches";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isSearchMatches };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setTextTransExist(boolean isTextTransExist) {
		try {
			String methodName = "setTextTransExist";

			Class<?>[] parameterTypes = new Class<?>[] { boolean.class };

			Object[] parameterValues = new Object[] { isTextTransExist };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public boolean isContextTransExist() {
		try {
			String methodName = "isContextTransExist";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Boolean returnObj = (Boolean)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getStandardsRemoteModel() {
		return _standardsRemoteModel;
	}

	public void setStandardsRemoteModel(BaseModel<?> standardsRemoteModel) {
		_standardsRemoteModel = standardsRemoteModel;
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

		Class<?> remoteModelClass = _standardsRemoteModel.getClass();

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

		Object returnValue = method.invoke(_standardsRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsLocalServiceUtil.addStandards(this);
		}
		else {
			StandardsLocalServiceUtil.updateStandards(this);
		}
	}

	@Override
	public Standards toEscapedModel() {
		return (Standards)ProxyUtil.newProxyInstance(Standards.class.getClassLoader(),
			new Class[] { Standards.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsClp clone = new StandardsClp();

		clone.setStdId(getStdId());
		clone.setParentId(getParentId());
		clone.setStdTyp(getStdTyp());
		clone.setTitle(getTitle());
		clone.setDescription(getDescription());
		clone.setAuthor(getAuthor());
		clone.setBusinessOwner(getBusinessOwner());
		clone.setEffectiveDate(getEffectiveDate());
		clone.setImplDate(getImplDate());
		clone.setWaiver(getWaiver());
		clone.setStatus(getStatus());
		clone.setCategory(getCategory());
		clone.setCreatedBy(getCreatedBy());
		clone.setChange(getChange());
		clone.setIsGlobal(getIsGlobal());
		clone.setRegionCode(getRegionCode());
		clone.setNotes(getNotes());
		clone.setFramework(getFramework());
		clone.setInternalReference(getInternalReference());
		clone.setOrderNumber(getOrderNumber());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());
		clone.setStatusId(getStatusId());
		clone.setRegionId(getRegionId());

		return clone;
	}

	@Override
	public int compareTo(Standards standards) {
		long primaryKey = standards.getPrimaryKey();

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

		if (!(obj instanceof StandardsClp)) {
			return false;
		}

		StandardsClp standards = (StandardsClp)obj;

		long primaryKey = standards.getPrimaryKey();

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
		StringBundler sb = new StringBundler(53);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", parentId=");
		sb.append(getParentId());
		sb.append(", stdTyp=");
		sb.append(getStdTyp());
		sb.append(", title=");
		sb.append(getTitle());
		sb.append(", description=");
		sb.append(getDescription());
		sb.append(", author=");
		sb.append(getAuthor());
		sb.append(", businessOwner=");
		sb.append(getBusinessOwner());
		sb.append(", effectiveDate=");
		sb.append(getEffectiveDate());
		sb.append(", implDate=");
		sb.append(getImplDate());
		sb.append(", waiver=");
		sb.append(getWaiver());
		sb.append(", status=");
		sb.append(getStatus());
		sb.append(", category=");
		sb.append(getCategory());
		sb.append(", createdBy=");
		sb.append(getCreatedBy());
		sb.append(", change=");
		sb.append(getChange());
		sb.append(", isGlobal=");
		sb.append(getIsGlobal());
		sb.append(", regionCode=");
		sb.append(getRegionCode());
		sb.append(", notes=");
		sb.append(getNotes());
		sb.append(", framework=");
		sb.append(getFramework());
		sb.append(", internalReference=");
		sb.append(getInternalReference());
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
		sb.append(", statusId=");
		sb.append(getStatusId());
		sb.append(", regionId=");
		sb.append(getRegionId());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(82);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.Standards");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>parentId</column-name><column-value><![CDATA[");
		sb.append(getParentId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdTyp</column-name><column-value><![CDATA[");
		sb.append(getStdTyp());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>title</column-name><column-value><![CDATA[");
		sb.append(getTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>description</column-name><column-value><![CDATA[");
		sb.append(getDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>author</column-name><column-value><![CDATA[");
		sb.append(getAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>businessOwner</column-name><column-value><![CDATA[");
		sb.append(getBusinessOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>effectiveDate</column-name><column-value><![CDATA[");
		sb.append(getEffectiveDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>implDate</column-name><column-value><![CDATA[");
		sb.append(getImplDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>waiver</column-name><column-value><![CDATA[");
		sb.append(getWaiver());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>status</column-name><column-value><![CDATA[");
		sb.append(getStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>category</column-name><column-value><![CDATA[");
		sb.append(getCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>createdBy</column-name><column-value><![CDATA[");
		sb.append(getCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>change</column-name><column-value><![CDATA[");
		sb.append(getChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>isGlobal</column-name><column-value><![CDATA[");
		sb.append(getIsGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionCode</column-name><column-value><![CDATA[");
		sb.append(getRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>notes</column-name><column-value><![CDATA[");
		sb.append(getNotes());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>framework</column-name><column-value><![CDATA[");
		sb.append(getFramework());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>internalReference</column-name><column-value><![CDATA[");
		sb.append(getInternalReference());
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
		sb.append(
			"<column><column-name>statusId</column-name><column-value><![CDATA[");
		sb.append(getStatusId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>regionId</column-name><column-value><![CDATA[");
		sb.append(getRegionId());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private long _parentId;
	private String _stdTyp;
	private String _title;
	private String _description;
	private String _author;
	private String _businessOwner;
	private Date _effectiveDate;
	private Date _implDate;
	private String _waiver;
	private String _status;
	private String _category;
	private String _createdBy;
	private String _change;
	private String _isGlobal;
	private String _regionCode;
	private String _notes;
	private String _framework;
	private String _internalReference;
	private long _orderNumber;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private long _statusId;
	private long _regionId;
	private BaseModel<?> _standardsRemoteModel;
}