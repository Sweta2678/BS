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

package com.ihg.grs.common.model.impl;

import com.ihg.grs.common.model.Glossary;

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
 * @author gulam.vora
 * @see Glossary
 * @generated
 */
public class GlossaryCacheModel implements CacheModel<Glossary>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{glossaryId=");
		sb.append(glossaryId);
		sb.append(", term=");
		sb.append(term);
		sb.append(", description=");
		sb.append(description);
		sb.append(", activeIndicator=");
		sb.append(activeIndicator);
		sb.append(", createUserId=");
		sb.append(createUserId);
		sb.append(", createdate=");
		sb.append(createdate);
		sb.append(", lastUpdateUserId=");
		sb.append(lastUpdateUserId);
		sb.append(", updatedate=");
		sb.append(updatedate);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public Glossary toEntityModel() {
		GlossaryImpl glossaryImpl = new GlossaryImpl();

		glossaryImpl.setGlossaryId(glossaryId);

		if (term == null) {
			glossaryImpl.setTerm(StringPool.BLANK);
		}
		else {
			glossaryImpl.setTerm(term);
		}

		if (description == null) {
			glossaryImpl.setDescription(StringPool.BLANK);
		}
		else {
			glossaryImpl.setDescription(description);
		}

		if (activeIndicator == null) {
			glossaryImpl.setActiveIndicator(StringPool.BLANK);
		}
		else {
			glossaryImpl.setActiveIndicator(activeIndicator);
		}

		if (createUserId == null) {
			glossaryImpl.setCreateUserId(StringPool.BLANK);
		}
		else {
			glossaryImpl.setCreateUserId(createUserId);
		}

		if (createdate == Long.MIN_VALUE) {
			glossaryImpl.setCreatedate(null);
		}
		else {
			glossaryImpl.setCreatedate(new Date(createdate));
		}

		if (lastUpdateUserId == null) {
			glossaryImpl.setLastUpdateUserId(StringPool.BLANK);
		}
		else {
			glossaryImpl.setLastUpdateUserId(lastUpdateUserId);
		}

		if (updatedate == Long.MIN_VALUE) {
			glossaryImpl.setUpdatedate(null);
		}
		else {
			glossaryImpl.setUpdatedate(new Date(updatedate));
		}

		glossaryImpl.resetOriginalValues();

		return glossaryImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		glossaryId = objectInput.readInt();
		term = objectInput.readUTF();
		description = objectInput.readUTF();
		activeIndicator = objectInput.readUTF();
		createUserId = objectInput.readUTF();
		createdate = objectInput.readLong();
		lastUpdateUserId = objectInput.readUTF();
		updatedate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeInt(glossaryId);

		if (term == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(term);
		}

		if (description == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(description);
		}

		if (activeIndicator == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeIndicator);
		}

		if (createUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(createUserId);
		}

		objectOutput.writeLong(createdate);

		if (lastUpdateUserId == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(lastUpdateUserId);
		}

		objectOutput.writeLong(updatedate);
	}

	public int glossaryId;
	public String term;
	public String description;
	public String activeIndicator;
	public String createUserId;
	public long createdate;
	public String lastUpdateUserId;
	public long updatedate;
}