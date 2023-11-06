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

import com.ihg.brandstandards.db.model.GlossaryRegionNav;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing GlossaryRegionNav in entity cache.
 *
 * @author Mummanedi
 * @see GlossaryRegionNav
 * @generated
 */
public class GlossaryRegionNavCacheModel implements CacheModel<GlossaryRegionNav>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(21);

		sb.append("{glossaryRgnNavId=");
		sb.append(glossaryRgnNavId);
		sb.append(", glossaryId=");
		sb.append(glossaryId);
		sb.append(", regionId=");
		sb.append(regionId);
		sb.append(", navItemText=");
		sb.append(navItemText);
		sb.append(", activeInd=");
		sb.append(activeInd);
		sb.append(", chainCode=");
		sb.append(chainCode);
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
	public GlossaryRegionNav toEntityModel() {
		GlossaryRegionNavImpl glossaryRegionNavImpl = new GlossaryRegionNavImpl();

		glossaryRegionNavImpl.setGlossaryRgnNavId(glossaryRgnNavId);
		glossaryRegionNavImpl.setGlossaryId(glossaryId);
		glossaryRegionNavImpl.setRegionId(regionId);

		if (navItemText == null) {
			glossaryRegionNavImpl.setNavItemText(StringPool.BLANK);
		}
		else {
			glossaryRegionNavImpl.setNavItemText(navItemText);
		}

		if (activeInd == null) {
			glossaryRegionNavImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			glossaryRegionNavImpl.setActiveInd(activeInd);
		}

		if (chainCode == null) {
			glossaryRegionNavImpl.setChainCode(StringPool.BLANK);
		}
		else {
			glossaryRegionNavImpl.setChainCode(chainCode);
		}

		if (creatorId == null) {
			glossaryRegionNavImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			glossaryRegionNavImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			glossaryRegionNavImpl.setCreatedDate(null);
		}
		else {
			glossaryRegionNavImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			glossaryRegionNavImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			glossaryRegionNavImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			glossaryRegionNavImpl.setUpdatedDate(null);
		}
		else {
			glossaryRegionNavImpl.setUpdatedDate(new Date(updatedDate));
		}

		glossaryRegionNavImpl.resetOriginalValues();

		return glossaryRegionNavImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		glossaryRgnNavId = objectInput.readLong();
		glossaryId = objectInput.readLong();
		regionId = objectInput.readLong();
		navItemText = objectInput.readUTF();
		activeInd = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(glossaryRgnNavId);
		objectOutput.writeLong(glossaryId);
		objectOutput.writeLong(regionId);

		if (navItemText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(navItemText);
		}

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
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

	public long glossaryRgnNavId;
	public long glossaryId;
	public long regionId;
	public String navItemText;
	public String activeInd;
	public String chainCode;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}