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

package com.ihg.brandstandards.db.model.impl;

import com.ihg.brandstandards.db.model.GEMTemplate;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTemplate in entity cache.
 *
 * @author Mummanedi
 * @see GEMTemplate
 * @generated
 */
public class GEMTemplateCacheModel implements CacheModel<GEMTemplate>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{templateId=");
		sb.append(templateId);
		sb.append(", templateName=");
		sb.append(templateName);
		sb.append(", publishId=");
		sb.append(publishId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", templateType=");
		sb.append(templateType);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GEMTemplate toEntityModel() {
		GEMTemplateImpl gemTemplateImpl = new GEMTemplateImpl();

		gemTemplateImpl.setTemplateId(templateId);

		if (templateName == null) {
			gemTemplateImpl.setTemplateName(StringPool.BLANK);
		}
		else {
			gemTemplateImpl.setTemplateName(templateName);
		}

		gemTemplateImpl.setPublishId(publishId);
		gemTemplateImpl.setRegionId(regionId);

		if (templateType == null) {
			gemTemplateImpl.setTemplateType(StringPool.BLANK);
		}
		else {
			gemTemplateImpl.setTemplateType(templateType);
		}

		if (creatorId == null) {
			gemTemplateImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTemplateImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTemplateImpl.setCreatedDate(null);
		}
		else {
			gemTemplateImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTemplateImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTemplateImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTemplateImpl.setUpdatedDate(null);
		}
		else {
			gemTemplateImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTemplateImpl.resetOriginalValues();

		return gemTemplateImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateId = objectInput.readLong();
		templateName = objectInput.readUTF();
		publishId = objectInput.readLong();
		regionId = objectInput.readLong();
		templateType = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(templateId);

		if (templateName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateName);
		}

		objectOutput.writeLong(publishId);
		objectOutput.writeLong(regionId);

		if (templateType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(templateType);
		}

		if (creatorId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(creatorId);
		}

		objectOutput.writeLong(createdDate);

		if (updatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(updatedBy);
		}

		objectOutput.writeLong(updatedDate);
	}

	public long templateId;
	public String templateName;
	public long publishId;
	public long regionId;
	public String templateType;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}