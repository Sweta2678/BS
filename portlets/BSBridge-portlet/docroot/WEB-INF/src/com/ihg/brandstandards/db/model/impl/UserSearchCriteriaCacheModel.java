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

import com.ihg.brandstandards.db.model.UserSearchCriteria;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing UserSearchCriteria in entity cache.
 *
 * @author Mummanedi
 * @see UserSearchCriteria
 * @generated
 */
public class UserSearchCriteriaCacheModel implements CacheModel<UserSearchCriteria>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(17);

		sb.append("{userSearchId=");
		sb.append(userSearchId);
		sb.append(", searchName=");
		sb.append(searchName);
		sb.append(", searchCriteria=");
		sb.append(searchCriteria);
		sb.append(", creatorId=");
		sb.append(creatorId);
		sb.append(", createdDate=");
		sb.append(createdDate);
		sb.append(", updatedBy=");
		sb.append(updatedBy);
		sb.append(", updatedDate=");
		sb.append(updatedDate);
		sb.append(", moduleName=");
		sb.append(moduleName);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public UserSearchCriteria toEntityModel() {
		UserSearchCriteriaImpl userSearchCriteriaImpl = new UserSearchCriteriaImpl();

		userSearchCriteriaImpl.setUserSearchId(userSearchId);

		if (searchName == null) {
			userSearchCriteriaImpl.setSearchName(StringPool.BLANK);
		}
		else {
			userSearchCriteriaImpl.setSearchName(searchName);
		}

		if (searchCriteria == null) {
			userSearchCriteriaImpl.setSearchCriteria(StringPool.BLANK);
		}
		else {
			userSearchCriteriaImpl.setSearchCriteria(searchCriteria);
		}

		if (creatorId == null) {
			userSearchCriteriaImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			userSearchCriteriaImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			userSearchCriteriaImpl.setCreatedDate(null);
		}
		else {
			userSearchCriteriaImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			userSearchCriteriaImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			userSearchCriteriaImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			userSearchCriteriaImpl.setUpdatedDate(null);
		}
		else {
			userSearchCriteriaImpl.setUpdatedDate(new Date(updatedDate));
		}

		if (moduleName == null) {
			userSearchCriteriaImpl.setModuleName(StringPool.BLANK);
		}
		else {
			userSearchCriteriaImpl.setModuleName(moduleName);
		}

		userSearchCriteriaImpl.resetOriginalValues();

		return userSearchCriteriaImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		userSearchId = objectInput.readLong();
		searchName = objectInput.readUTF();
		searchCriteria = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
		moduleName = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(userSearchId);

		if (searchName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchName);
		}

		if (searchCriteria == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(searchCriteria);
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

		if (moduleName == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(moduleName);
		}
	}

	public long userSearchId;
	public String searchName;
	public String searchCriteria;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
	public String moduleName;
}