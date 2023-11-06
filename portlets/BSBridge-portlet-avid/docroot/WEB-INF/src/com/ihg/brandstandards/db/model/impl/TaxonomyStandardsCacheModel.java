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

import com.ihg.brandstandards.db.model.TaxonomyStandards;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TaxonomyStandards in entity cache.
 *
 * @author Mummanedi
 * @see TaxonomyStandards
 * @generated
 */
public class TaxonomyStandardsCacheModel implements CacheModel<TaxonomyStandards>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", taxId=");
		sb.append(taxId);
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
	public TaxonomyStandards toEntityModel() {
		TaxonomyStandardsImpl taxonomyStandardsImpl = new TaxonomyStandardsImpl();

		taxonomyStandardsImpl.setStdId(stdId);
		taxonomyStandardsImpl.setTaxId(taxId);

		if (creatorId == null) {
			taxonomyStandardsImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			taxonomyStandardsImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			taxonomyStandardsImpl.setCreatedDate(null);
		}
		else {
			taxonomyStandardsImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			taxonomyStandardsImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			taxonomyStandardsImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			taxonomyStandardsImpl.setUpdatedDate(null);
		}
		else {
			taxonomyStandardsImpl.setUpdatedDate(new Date(updatedDate));
		}

		taxonomyStandardsImpl.resetOriginalValues();

		return taxonomyStandardsImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		taxId = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(taxId);

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

	public long stdId;
	public long taxId;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}