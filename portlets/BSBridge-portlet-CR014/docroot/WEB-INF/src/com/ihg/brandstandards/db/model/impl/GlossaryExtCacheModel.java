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

import com.ihg.brandstandards.db.model.GlossaryExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

/**
 * The cache model class for representing GlossaryExt in entity cache.
 *
 * @author Mummanedi
 * @see GlossaryExt
 * @generated
 */
public class GlossaryExtCacheModel implements CacheModel<GlossaryExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{glossaryId=");
		sb.append(glossaryId);
		sb.append(", activeInd=");
		sb.append(activeInd);
		sb.append(", glossaryTermText=");
		sb.append(glossaryTermText);
		sb.append(", glossaryTermDesc=");
		sb.append(glossaryTermDesc);
		sb.append(", glossaryRegions=");
		sb.append(glossaryRegions);
		sb.append(", glossaryChains=");
		sb.append(glossaryChains);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public GlossaryExt toEntityModel() {
		GlossaryExtImpl glossaryExtImpl = new GlossaryExtImpl();

		glossaryExtImpl.setGlossaryId(glossaryId);

		if (activeInd == null) {
			glossaryExtImpl.setActiveInd(StringPool.BLANK);
		}
		else {
			glossaryExtImpl.setActiveInd(activeInd);
		}

		if (glossaryTermText == null) {
			glossaryExtImpl.setGlossaryTermText(StringPool.BLANK);
		}
		else {
			glossaryExtImpl.setGlossaryTermText(glossaryTermText);
		}

		if (glossaryTermDesc == null) {
			glossaryExtImpl.setGlossaryTermDesc(StringPool.BLANK);
		}
		else {
			glossaryExtImpl.setGlossaryTermDesc(glossaryTermDesc);
		}

		if (glossaryRegions == null) {
			glossaryExtImpl.setGlossaryRegions(StringPool.BLANK);
		}
		else {
			glossaryExtImpl.setGlossaryRegions(glossaryRegions);
		}

		if (glossaryChains == null) {
			glossaryExtImpl.setGlossaryChains(StringPool.BLANK);
		}
		else {
			glossaryExtImpl.setGlossaryChains(glossaryChains);
		}

		glossaryExtImpl.resetOriginalValues();

		return glossaryExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		glossaryId = objectInput.readLong();
		activeInd = objectInput.readUTF();
		glossaryTermText = objectInput.readUTF();
		glossaryTermDesc = objectInput.readUTF();
		glossaryRegions = objectInput.readUTF();
		glossaryChains = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(glossaryId);

		if (activeInd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(activeInd);
		}

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

		if (glossaryRegions == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryRegions);
		}

		if (glossaryChains == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(glossaryChains);
		}
	}

	public long glossaryId;
	public String activeInd;
	public String glossaryTermText;
	public String glossaryTermDesc;
	public String glossaryRegions;
	public String glossaryChains;
}