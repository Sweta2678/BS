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

import com.ihg.brandstandards.db.model.TreeXML;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing TreeXML in entity cache.
 *
 * @author Mummanedi
 * @see TreeXML
 * @generated
 */
public class TreeXMLCacheModel implements CacheModel<TreeXML>, Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(13);

		sb.append("{ID=");
		sb.append(ID);
		sb.append(", XMLLOB=");
		sb.append(XMLLOB);
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
	public TreeXML toEntityModel() {
		TreeXMLImpl treeXMLImpl = new TreeXMLImpl();

		treeXMLImpl.setID(ID);

		if (XMLLOB == null) {
			treeXMLImpl.setXMLLOB(StringPool.BLANK);
		}
		else {
			treeXMLImpl.setXMLLOB(XMLLOB);
		}

		if (creatorId == null) {
			treeXMLImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			treeXMLImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			treeXMLImpl.setCreatedDate(null);
		}
		else {
			treeXMLImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			treeXMLImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			treeXMLImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			treeXMLImpl.setUpdatedDate(null);
		}
		else {
			treeXMLImpl.setUpdatedDate(new Date(updatedDate));
		}

		treeXMLImpl.resetOriginalValues();

		return treeXMLImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		ID = objectInput.readLong();
		XMLLOB = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(ID);

		if (XMLLOB == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(XMLLOB);
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

	public long ID;
	public String XMLLOB;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}