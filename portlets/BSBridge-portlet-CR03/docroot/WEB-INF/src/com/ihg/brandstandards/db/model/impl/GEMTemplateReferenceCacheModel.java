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

import com.ihg.brandstandards.db.model.GEMTemplateReference;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GEMTemplateReference in entity cache.
 *
 * @author Mummanedi
 * @see GEMTemplateReference
 * @generated
 */
public class GEMTemplateReferenceCacheModel implements CacheModel<GEMTemplateReference>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{templateRefId=");
		sb.append(templateRefId);
		sb.append(", templateId=");
		sb.append(templateId);
		sb.append(", publishDeptId=");
		sb.append(publishDeptId);
		sb.append(", regionId=");
		sb.append(regionId);
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
	public GEMTemplateReference toEntityModel() {
		GEMTemplateReferenceImpl gemTemplateReferenceImpl = new GEMTemplateReferenceImpl();

		gemTemplateReferenceImpl.setTemplateRefId(templateRefId);
		gemTemplateReferenceImpl.setTemplateId(templateId);
		gemTemplateReferenceImpl.setPublishDeptId(publishDeptId);
		gemTemplateReferenceImpl.setRegionId(regionId);

		if (creatorId == null) {
			gemTemplateReferenceImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			gemTemplateReferenceImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			gemTemplateReferenceImpl.setCreatedDate(null);
		}
		else {
			gemTemplateReferenceImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			gemTemplateReferenceImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			gemTemplateReferenceImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			gemTemplateReferenceImpl.setUpdatedDate(null);
		}
		else {
			gemTemplateReferenceImpl.setUpdatedDate(new Date(updatedDate));
		}

		gemTemplateReferenceImpl.resetOriginalValues();

		return gemTemplateReferenceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		templateRefId = objectInput.readLong();
		templateId = objectInput.readLong();
		publishDeptId = objectInput.readLong();
		regionId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(templateRefId);
		objectOutput.writeLong(templateId);
		objectOutput.writeLong(publishDeptId);
		objectOutput.writeLong(regionId);

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

	public long templateRefId;
	public long templateId;
	public long publishDeptId;
	public long regionId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}