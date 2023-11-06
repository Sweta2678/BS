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

import com.ihg.brandstandards.db.model.StandardsCompliance;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsCompliance in entity cache.
 *
 * @author Mummanedi
 * @see StandardsCompliance
 * @generated
 */
public class StandardsComplianceCacheModel implements CacheModel<StandardsCompliance>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(25);

		sb.append("{stdComplianceId=");
		sb.append(stdComplianceId);
		sb.append(", stdId=");
		sb.append(stdId);
		sb.append(", countryCode=");
		sb.append(countryCode);
		sb.append(", chainCode=");
		sb.append(chainCode);
		sb.append(", complianceExpiryDate=");
		sb.append(complianceExpiryDate);
		sb.append(", complianceExpiryRule=");
		sb.append(complianceExpiryRule);
		sb.append(", complianceRuleMonths=");
		sb.append(complianceRuleMonths);
		sb.append(", RuleDate=");
		sb.append(RuleDate);
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
	public StandardsCompliance toEntityModel() {
		StandardsComplianceImpl standardsComplianceImpl = new StandardsComplianceImpl();

		standardsComplianceImpl.setStdComplianceId(stdComplianceId);
		standardsComplianceImpl.setStdId(stdId);

		if (countryCode == null) {
			standardsComplianceImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setCountryCode(countryCode);
		}

		if (chainCode == null) {
			standardsComplianceImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setChainCode(chainCode);
		}

		if (complianceExpiryDate == Long.MIN_VALUE) {
			standardsComplianceImpl.setComplianceExpiryDate(null);
		}
		else {
			standardsComplianceImpl.setComplianceExpiryDate(new Date(
					complianceExpiryDate));
		}

		if (complianceExpiryRule == null) {
			standardsComplianceImpl.setComplianceExpiryRule(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setComplianceExpiryRule(complianceExpiryRule);
		}

		standardsComplianceImpl.setComplianceRuleMonths(complianceRuleMonths);

		if (RuleDate == null) {
			standardsComplianceImpl.setRuleDate(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setRuleDate(RuleDate);
		}

		if (creatorId == null) {
			standardsComplianceImpl.setCreatorId(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setCreatorId(creatorId);
		}

		if (createdDate == Long.MIN_VALUE) {
			standardsComplianceImpl.setCreatedDate(null);
		}
		else {
			standardsComplianceImpl.setCreatedDate(new Date(createdDate));
		}

		if (updatedBy == null) {
			standardsComplianceImpl.setUpdatedBy(StringPool.BLANK);
		}
		else {
			standardsComplianceImpl.setUpdatedBy(updatedBy);
		}

		if (updatedDate == Long.MIN_VALUE) {
			standardsComplianceImpl.setUpdatedDate(null);
		}
		else {
			standardsComplianceImpl.setUpdatedDate(new Date(updatedDate));
		}

		standardsComplianceImpl.resetOriginalValues();

		return standardsComplianceImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdComplianceId = objectInput.readLong();
		stdId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		complianceExpiryDate = objectInput.readLong();
		complianceExpiryRule = objectInput.readUTF();
		complianceRuleMonths = objectInput.readLong();
		RuleDate = objectInput.readUTF();
		creatorId = objectInput.readUTF();
		createdDate = objectInput.readLong();
		updatedBy = objectInput.readUTF();
		updatedDate = objectInput.readLong();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdComplianceId);
		objectOutput.writeLong(stdId);

		if (countryCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(countryCode);
		}

		if (chainCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(chainCode);
		}

		objectOutput.writeLong(complianceExpiryDate);

		if (complianceExpiryRule == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(complianceExpiryRule);
		}

		objectOutput.writeLong(complianceRuleMonths);

		if (RuleDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(RuleDate);
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

	public long stdComplianceId;
	public long stdId;
	public String countryCode;
	public String chainCode;
	public long complianceExpiryDate;
	public String complianceExpiryRule;
	public long complianceRuleMonths;
	public String RuleDate;
	public String creatorId;
	public long createdDate;
	public String updatedBy;
	public long updatedDate;
}