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

import com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;

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
public class BusImpactAssmtClp extends BaseModelImpl<BusImpactAssmt>
	implements BusImpactAssmt {
	public BusImpactAssmtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return BusImpactAssmt.class;
	}

	@Override
	public String getModelClassName() {
		return BusImpactAssmt.class.getName();
	}

	@Override
	public long getPrimaryKey() {
		return _busImpactAssmtId;
	}

	@Override
	public void setPrimaryKey(long primaryKey) {
		setBusImpactAssmtId(primaryKey);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return _busImpactAssmtId;
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey(((Long)primaryKeyObj).longValue());
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("busImpactAssmtId", getBusImpactAssmtId());
		attributes.put("stdId", getStdId());
		attributes.put("chain", getChain());
		attributes.put("region", getRegion());
		attributes.put("profileLossImpact", getProfileLossImpact());
		attributes.put("CapExpenseImpact", getCapExpenseImpact());
		attributes.put("ImplTimeScale", getImplTimeScale());
		attributes.put("changeFromRegional", getChangeFromRegional());
		attributes.put("biaComments", getBiaComments());
		attributes.put("creatorId", getCreatorId());
		attributes.put("createdDate", getCreatedDate());
		attributes.put("updatedBy", getUpdatedBy());
		attributes.put("updatedDate", getUpdatedDate());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long busImpactAssmtId = (Long)attributes.get("busImpactAssmtId");

		if (busImpactAssmtId != null) {
			setBusImpactAssmtId(busImpactAssmtId);
		}

		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		String chain = (String)attributes.get("chain");

		if (chain != null) {
			setChain(chain);
		}

		String region = (String)attributes.get("region");

		if (region != null) {
			setRegion(region);
		}

		String profileLossImpact = (String)attributes.get("profileLossImpact");

		if (profileLossImpact != null) {
			setProfileLossImpact(profileLossImpact);
		}

		String CapExpenseImpact = (String)attributes.get("CapExpenseImpact");

		if (CapExpenseImpact != null) {
			setCapExpenseImpact(CapExpenseImpact);
		}

		String ImplTimeScale = (String)attributes.get("ImplTimeScale");

		if (ImplTimeScale != null) {
			setImplTimeScale(ImplTimeScale);
		}

		String changeFromRegional = (String)attributes.get("changeFromRegional");

		if (changeFromRegional != null) {
			setChangeFromRegional(changeFromRegional);
		}

		String biaComments = (String)attributes.get("biaComments");

		if (biaComments != null) {
			setBiaComments(biaComments);
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
	public long getBusImpactAssmtId() {
		return _busImpactAssmtId;
	}

	@Override
	public void setBusImpactAssmtId(long busImpactAssmtId) {
		_busImpactAssmtId = busImpactAssmtId;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setBusImpactAssmtId",
						long.class);

				method.invoke(_busImpactAssmtRemoteModel, busImpactAssmtId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_busImpactAssmtRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChain() {
		return _chain;
	}

	@Override
	public void setChain(String chain) {
		_chain = chain;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setChain", String.class);

				method.invoke(_busImpactAssmtRemoteModel, chain);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getRegion() {
		return _region;
	}

	@Override
	public void setRegion(String region) {
		_region = region;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setRegion", String.class);

				method.invoke(_busImpactAssmtRemoteModel, region);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getProfileLossImpact() {
		return _profileLossImpact;
	}

	@Override
	public void setProfileLossImpact(String profileLossImpact) {
		_profileLossImpact = profileLossImpact;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setProfileLossImpact",
						String.class);

				method.invoke(_busImpactAssmtRemoteModel, profileLossImpact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getCapExpenseImpact() {
		return _CapExpenseImpact;
	}

	@Override
	public void setCapExpenseImpact(String CapExpenseImpact) {
		_CapExpenseImpact = CapExpenseImpact;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setCapExpenseImpact",
						String.class);

				method.invoke(_busImpactAssmtRemoteModel, CapExpenseImpact);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getImplTimeScale() {
		return _ImplTimeScale;
	}

	@Override
	public void setImplTimeScale(String ImplTimeScale) {
		_ImplTimeScale = ImplTimeScale;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setImplTimeScale", String.class);

				method.invoke(_busImpactAssmtRemoteModel, ImplTimeScale);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getChangeFromRegional() {
		return _changeFromRegional;
	}

	@Override
	public void setChangeFromRegional(String changeFromRegional) {
		_changeFromRegional = changeFromRegional;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setChangeFromRegional",
						String.class);

				method.invoke(_busImpactAssmtRemoteModel, changeFromRegional);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiaComments() {
		return _biaComments;
	}

	@Override
	public void setBiaComments(String biaComments) {
		_biaComments = biaComments;

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiaComments", String.class);

				method.invoke(_busImpactAssmtRemoteModel, biaComments);
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

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatorId", String.class);

				method.invoke(_busImpactAssmtRemoteModel, creatorId);
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

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setCreatedDate", Date.class);

				method.invoke(_busImpactAssmtRemoteModel, createdDate);
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

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedBy", String.class);

				method.invoke(_busImpactAssmtRemoteModel, updatedBy);
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

		if (_busImpactAssmtRemoteModel != null) {
			try {
				Class<?> clazz = _busImpactAssmtRemoteModel.getClass();

				Method method = clazz.getMethod("setUpdatedDate", Date.class);

				method.invoke(_busImpactAssmtRemoteModel, updatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setChainName(java.lang.String chainName) {
		try {
			String methodName = "setChainName";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { chainName };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getChainName() {
		try {
			String methodName = "getChainName";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getBusImpactAssmtRemoteModel() {
		return _busImpactAssmtRemoteModel;
	}

	public void setBusImpactAssmtRemoteModel(
		BaseModel<?> busImpactAssmtRemoteModel) {
		_busImpactAssmtRemoteModel = busImpactAssmtRemoteModel;
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

		Class<?> remoteModelClass = _busImpactAssmtRemoteModel.getClass();

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

		Object returnValue = method.invoke(_busImpactAssmtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			BusImpactAssmtLocalServiceUtil.addBusImpactAssmt(this);
		}
		else {
			BusImpactAssmtLocalServiceUtil.updateBusImpactAssmt(this);
		}
	}

	@Override
	public BusImpactAssmt toEscapedModel() {
		return (BusImpactAssmt)ProxyUtil.newProxyInstance(BusImpactAssmt.class.getClassLoader(),
			new Class[] { BusImpactAssmt.class },
			new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		BusImpactAssmtClp clone = new BusImpactAssmtClp();

		clone.setBusImpactAssmtId(getBusImpactAssmtId());
		clone.setStdId(getStdId());
		clone.setChain(getChain());
		clone.setRegion(getRegion());
		clone.setProfileLossImpact(getProfileLossImpact());
		clone.setCapExpenseImpact(getCapExpenseImpact());
		clone.setImplTimeScale(getImplTimeScale());
		clone.setChangeFromRegional(getChangeFromRegional());
		clone.setBiaComments(getBiaComments());
		clone.setCreatorId(getCreatorId());
		clone.setCreatedDate(getCreatedDate());
		clone.setUpdatedBy(getUpdatedBy());
		clone.setUpdatedDate(getUpdatedDate());

		return clone;
	}

	@Override
	public int compareTo(BusImpactAssmt busImpactAssmt) {
		long primaryKey = busImpactAssmt.getPrimaryKey();

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

		if (!(obj instanceof BusImpactAssmtClp)) {
			return false;
		}

		BusImpactAssmtClp busImpactAssmt = (BusImpactAssmtClp)obj;

		long primaryKey = busImpactAssmt.getPrimaryKey();

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

		sb.append("{busImpactAssmtId=");
		sb.append(getBusImpactAssmtId());
		sb.append(", stdId=");
		sb.append(getStdId());
		sb.append(", chain=");
		sb.append(getChain());
		sb.append(", region=");
		sb.append(getRegion());
		sb.append(", profileLossImpact=");
		sb.append(getProfileLossImpact());
		sb.append(", CapExpenseImpact=");
		sb.append(getCapExpenseImpact());
		sb.append(", ImplTimeScale=");
		sb.append(getImplTimeScale());
		sb.append(", changeFromRegional=");
		sb.append(getChangeFromRegional());
		sb.append(", biaComments=");
		sb.append(getBiaComments());
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
		sb.append("com.ihg.brandstandards.db.model.BusImpactAssmt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>busImpactAssmtId</column-name><column-value><![CDATA[");
		sb.append(getBusImpactAssmtId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>chain</column-name><column-value><![CDATA[");
		sb.append(getChain());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>region</column-name><column-value><![CDATA[");
		sb.append(getRegion());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>profileLossImpact</column-name><column-value><![CDATA[");
		sb.append(getProfileLossImpact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>CapExpenseImpact</column-name><column-value><![CDATA[");
		sb.append(getCapExpenseImpact());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ImplTimeScale</column-name><column-value><![CDATA[");
		sb.append(getImplTimeScale());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>changeFromRegional</column-name><column-value><![CDATA[");
		sb.append(getChangeFromRegional());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biaComments</column-name><column-value><![CDATA[");
		sb.append(getBiaComments());
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

	private long _busImpactAssmtId;
	private long _stdId;
	private String _chain;
	private String _region;
	private String _profileLossImpact;
	private String _CapExpenseImpact;
	private String _ImplTimeScale;
	private String _changeFromRegional;
	private String _biaComments;
	private String _creatorId;
	private Date _createdDate;
	private String _updatedBy;
	private Date _updatedDate;
	private BaseModel<?> _busImpactAssmtRemoteModel;
}