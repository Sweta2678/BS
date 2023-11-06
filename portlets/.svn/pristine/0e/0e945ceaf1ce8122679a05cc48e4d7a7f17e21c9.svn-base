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

import com.ihg.brandstandards.db.model.Glossary;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing Glossary in entity cache.
 *
 * @author Mummanedi
 * @see Glossary
 * @generated
 */
public class GlossaryCacheModel implements CacheModel<Glossary>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(19);

		sb.append("{glossaryId=");
		sb.append(glossaryId);
		sb.append(", glossaryTermText=");
		sb.append(glossaryTermText);
		sb.append(", glossaryTermDesc=");
		sb.append(glossaryTermDesc);
		sb.append(", activeInd=");
		sb.append(activeInd);
		sb.append(", glossaryOwner=");
		sb.append(glossaryOwner);
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
	public Glossary toEntityModel() {
		GlossaryImpl glossaryImpl = new GlossaryImpl();

		glossaryImpl.setGlossaryId(glossaryId);

		if (glossaryTermText == null) {
			glossaryImpl.setGlossaryTermText(StringPool.BLANK);
		}
		else {
			glossaryImpl.setGlossaryTermText(glossaryTermText);
		}

		if (glossaryTermDesc == null) {
			glossaryImpl.setGlossaryTermDesc(StringPool.BLANK);
		}
		else {
			glossaryImpl.setGlossaryTermDesc(glossaryTermDesc);
		}

		if (activeInd == null) {
			glossaryImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			glossaryImpl.setActiveInd(activeInd);
		}

		glossaryImpl.setGlossaryOwner(glossaryOwner);

		if (creatorId == null) {
			glossaryImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			glossaryImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			glossaryImpl.setCreatedDate(null);
		}
		else {
			glossaryImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			glossaryImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			glossaryImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			glossaryImpl.setUpdatedDate(null);
		}
		else {
			glossaryImpl.setUpdatedDate(new Date(updatedDate));
		}

		glossaryImpl.resetOriginalValues();

		return glossaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		glossaryId = objectInput.readLong();
		glossaryTermText = objectInput.readUTF();
		glossaryTermDesc = objectInput.readUTF();
		activeInd = objectInput.readUTF();
		glossaryOwner = objectInput.readLong();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(glossaryId);

		if (glossaryTermText == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryTermText);
		}

		if (glossaryTermDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryTermDesc);
		}

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
		}

		objectOutput.writeLong(glossaryOwner);

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

	public long glossaryId;
	public String glossaryTermText;
	public String glossaryTermDesc;
	public String activeInd;
	public long glossaryOwner;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}