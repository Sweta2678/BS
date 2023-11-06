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

import com.ihg.brandstandards.db.model.StandardsComplianceExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsComplianceExt in entity cache.
 *
 * @author Mummanedi
 * @see StandardsComplianceExt
 * @generated
 */
public class StandardsComplianceExtCacheModel implements CacheModel<StandardsComplianceExt>,
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
		sb.append(", regionCode=");
		sb.append(regionCode);
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
		sb.append(", expiryDate=");
		sb.append(expiryDate);
		sb.append(", complianceDateString=");
		sb.append(complianceDateString);
		sb.append(", expiryDateString=");
		sb.append(expiryDateString);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsComplianceExt toEntityModel() {
		StandardsComplianceExtImpl standardsComplianceExtImpl = new StandardsComplianceExtImpl();

		standardsComplianceExtImpl.setStdComplianceId(stdComplianceId);
		standardsComplianceExtImpl.setStdId(stdId);

		if (countryCode == null) {
			standardsComplianceExtImpl.setCountryCode(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setCountryCode(countryCode);
		}

		if (regionCode == null) {
			standardsComplianceExtImpl.setRegionCode(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setRegionCode(regionCode);
		}

		if (chainCode == null) {
			standardsComplianceExtImpl.setChainCode(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setChainCode(chainCode);
		}

		if (complianceExpiryDate == Long.MIN_VALUE) {
			standardsComplianceExtImpl.setComplianceExpiryDate(null);
		}
		else {
			standardsComplianceExtImpl.setComplianceExpiryDate(new Date(
					complianceExpiryDate));
		}

		if (complianceExpiryRule == null) {
			standardsComplianceExtImpl.setComplianceExpiryRule(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setComplianceExpiryRule(complianceExpiryRule);
		}

		standardsComplianceExtImpl.setComplianceRuleMonths(complianceRuleMonths);

		if (RuleDate == null) {
			standardsComplianceExtImpl.setRuleDate(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setRuleDate(RuleDate);
		}

		if (expiryDate == null) {
			standardsComplianceExtImpl.setExpiryDate(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setExpiryDate(expiryDate);
		}

		if (complianceDateString == null) {
			standardsComplianceExtImpl.setComplianceDateString(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setComplianceDateString(complianceDateString);
		}

		if (expiryDateString == null) {
			standardsComplianceExtImpl.setExpiryDateString(StringPool.BLANK);
		}
		else {
			standardsComplianceExtImpl.setExpiryDateString(expiryDateString);
		}

		standardsComplianceExtImpl.resetOriginalValues();

		return standardsComplianceExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdComplianceId = objectInput.readLong();
		stdId = objectInput.readLong();
		countryCode = objectInput.readUTF();
		regionCode = objectInput.readUTF();
		chainCode = objectInput.readUTF();
		complianceExpiryDate = objectInput.readLong();
		complianceExpiryRule = objectInput.readUTF();
		complianceRuleMonths = objectInput.readLong();
		RuleDate = objectInput.readUTF();
		expiryDate = objectInput.readUTF();
		complianceDateString = objectInput.readUTF();
		expiryDateString = objectInput.readUTF();
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

		if (regionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(regionCode);
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

		if (expiryDate == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiryDate);
		}

		if (complianceDateString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(complianceDateString);
		}

		if (expiryDateString == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expiryDateString);
		}
	}

	public long stdComplianceId;
	public long stdId;
	public String countryCode;
	public String regionCode;
	public String chainCode;
	public long complianceExpiryDate;
	public String complianceExpiryRule;
	public long complianceRuleMonths;
	public String RuleDate;
	public String expiryDate;
	public String complianceDateString;
	public String expiryDateString;
}