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

import com.ihg.brandstandards.db.model.StandardsExt;

import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.CacheModel;

import java.io.Externalizable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;

import java.util.Date;

/**
 * The cache model class for representing StandardsExt in entity cache.
 *
 * @author Mummanedi
 * @see StandardsExt
 * @generated
 */
public class StandardsExtCacheModel implements CacheModel<StandardsExt>,
	Externalizable {
	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{stdId=");
		sb.append(stdId);
		sb.append(", auditLogId=");
		sb.append(auditLogId);
		sb.append(", stdManual=");
		sb.append(stdManual);
		sb.append(", stdCorporateDepartment=");
		sb.append(stdCorporateDepartment);
		sb.append(", stdBrandCd=");
		sb.append(stdBrandCd);
		sb.append(", biImpactAssmntId=");
		sb.append(biImpactAssmntId);
		sb.append(", stdCountryCd=");
		sb.append(stdCountryCd);
		sb.append(", stdPrntId=");
		sb.append(stdPrntId);
		sb.append(", stdOrigStdId=");
		sb.append(stdOrigStdId);
		sb.append(", stdPubStatCd=");
		sb.append(stdPubStatCd);
		sb.append(", stdType=");
		sb.append(stdType);
		sb.append(", stdTitle=");
		sb.append(stdTitle);
		sb.append(", stdDescription=");
		sb.append(stdDescription);
		sb.append(", stdBusinessOwner=");
		sb.append(stdBusinessOwner);
		sb.append(", stdStatus=");
		sb.append(stdStatus);
		sb.append(", stdAuthor=");
		sb.append(stdAuthor);
		sb.append(", stdCategory=");
		sb.append(stdCategory);
		sb.append(", stdGlobal=");
		sb.append(stdGlobal);
		sb.append(", stdRegionCode=");
		sb.append(stdRegionCode);
		sb.append(", stdFramework=");
		sb.append(stdFramework);
		sb.append(", stdChange=");
		sb.append(stdChange);
		sb.append(", stdCreatedBy=");
		sb.append(stdCreatedBy);
		sb.append(", stdUpdatedDate=");
		sb.append(stdUpdatedDate);
		sb.append(", stdImageCount=");
		sb.append(stdImageCount);
		sb.append(", stdImageTitle=");
		sb.append(stdImageTitle);
		sb.append(", stdInternalReference=");
		sb.append(stdInternalReference);
		sb.append(", stdOrderNumber=");
		sb.append(stdOrderNumber);
		sb.append(", indexId=");
		sb.append(indexId);
		sb.append(", indexOrigId=");
		sb.append(indexOrigId);
		sb.append(", indexPrntId=");
		sb.append(indexPrntId);
		sb.append(", indexTitle=");
		sb.append(indexTitle);
		sb.append(", indexLevel=");
		sb.append(indexLevel);
		sb.append(", indexLevelSortOrder=");
		sb.append(indexLevelSortOrder);
		sb.append(", indexPath=");
		sb.append(indexPath);
		sb.append(", auditLogComments=");
		sb.append(auditLogComments);
		sb.append(", auditLogTitle=");
		sb.append(auditLogTitle);
		sb.append(", auditLogDate=");
		sb.append(auditLogDate);
		sb.append(", auditLogStatus=");
		sb.append(auditLogStatus);
		sb.append(", auditLogPrevStatus=");
		sb.append(auditLogPrevStatus);
		sb.append(", histManualDesc=");
		sb.append(histManualDesc);
		sb.append(", secLangIndexTitle=");
		sb.append(secLangIndexTitle);
		sb.append(", secLangIndexDesc=");
		sb.append(secLangIndexDesc);
		sb.append(", secLangIndexImgPath=");
		sb.append(secLangIndexImgPath);
		sb.append(", secLangStdTitle=");
		sb.append(secLangStdTitle);
		sb.append(", secLangStdDesc=");
		sb.append(secLangStdDesc);
		sb.append(", biChangeTypeCd=");
		sb.append(biChangeTypeCd);
		sb.append(", biRegionCd=");
		sb.append(biRegionCd);
		sb.append(", biProfileLossImpactCd=");
		sb.append(biProfileLossImpactCd);
		sb.append(", biCapExpenseImpactCd=");
		sb.append(biCapExpenseImpactCd);
		sb.append(", biImplTimeScaleCd=");
		sb.append(biImplTimeScaleCd);
		sb.append(", biComments=");
		sb.append(biComments);
		sb.append(", biBrandCd=");
		sb.append(biBrandCd);
		sb.append(", stdCrossReferences=");
		sb.append(stdCrossReferences);
		sb.append(", auditBrand=");
		sb.append(auditBrand);
		sb.append(", globalRule=");
		sb.append(globalRule);
		sb.append(", ameaRule=");
		sb.append(ameaRule);
		sb.append(", amerRule=");
		sb.append(amerRule);
		sb.append(", euroRule=");
		sb.append(euroRule);
		sb.append(", gcRule=");
		sb.append(gcRule);
		sb.append(", expires=");
		sb.append(expires);
		sb.append("}");

		return sb.toString();
	}

	@Override
	public StandardsExt toEntityModel() {
		StandardsExtImpl standardsExtImpl = new StandardsExtImpl();

		standardsExtImpl.setStdId(stdId);
		standardsExtImpl.setAuditLogId(auditLogId);

		if (stdManual == null) {
			standardsExtImpl.setStdManual(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdManual(stdManual);
		}

		if (stdCorporateDepartment == null) {
			standardsExtImpl.setStdCorporateDepartment(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdCorporateDepartment(stdCorporateDepartment);
		}

		if (stdBrandCd == null) {
			standardsExtImpl.setStdBrandCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdBrandCd(stdBrandCd);
		}

		standardsExtImpl.setBiImpactAssmntId(biImpactAssmntId);

		if (stdCountryCd == null) {
			standardsExtImpl.setStdCountryCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdCountryCd(stdCountryCd);
		}

		standardsExtImpl.setStdPrntId(stdPrntId);
		standardsExtImpl.setStdOrigStdId(stdOrigStdId);

		if (stdPubStatCd == null) {
			standardsExtImpl.setStdPubStatCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdPubStatCd(stdPubStatCd);
		}

		if (stdType == null) {
			standardsExtImpl.setStdType(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdType(stdType);
		}

		if (stdTitle == null) {
			standardsExtImpl.setStdTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdTitle(stdTitle);
		}

		if (stdDescription == null) {
			standardsExtImpl.setStdDescription(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdDescription(stdDescription);
		}

		if (stdBusinessOwner == null) {
			standardsExtImpl.setStdBusinessOwner(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdBusinessOwner(stdBusinessOwner);
		}

		if (stdStatus == null) {
			standardsExtImpl.setStdStatus(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdStatus(stdStatus);
		}

		if (stdAuthor == null) {
			standardsExtImpl.setStdAuthor(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdAuthor(stdAuthor);
		}

		if (stdCategory == null) {
			standardsExtImpl.setStdCategory(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdCategory(stdCategory);
		}

		if (stdGlobal == null) {
			standardsExtImpl.setStdGlobal(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdGlobal(stdGlobal);
		}

		if (stdRegionCode == null) {
			standardsExtImpl.setStdRegionCode(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdRegionCode(stdRegionCode);
		}

		if (stdFramework == null) {
			standardsExtImpl.setStdFramework(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdFramework(stdFramework);
		}

		if (stdChange == null) {
			standardsExtImpl.setStdChange(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdChange(stdChange);
		}

		if (stdCreatedBy == null) {
			standardsExtImpl.setStdCreatedBy(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdCreatedBy(stdCreatedBy);
		}

		if (stdUpdatedDate == Long.MIN_VALUE) {
			standardsExtImpl.setStdUpdatedDate(null);
		}
		else {
			standardsExtImpl.setStdUpdatedDate(new Date(stdUpdatedDate));
		}

		standardsExtImpl.setStdImageCount(stdImageCount);

		if (stdImageTitle == null) {
			standardsExtImpl.setStdImageTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdImageTitle(stdImageTitle);
		}

		if (stdInternalReference == null) {
			standardsExtImpl.setStdInternalReference(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdInternalReference(stdInternalReference);
		}

		standardsExtImpl.setStdOrderNumber(stdOrderNumber);
		standardsExtImpl.setIndexId(indexId);
		standardsExtImpl.setIndexOrigId(indexOrigId);
		standardsExtImpl.setIndexPrntId(indexPrntId);

		if (indexTitle == null) {
			standardsExtImpl.setIndexTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setIndexTitle(indexTitle);
		}

		standardsExtImpl.setIndexLevel(indexLevel);
		standardsExtImpl.setIndexLevelSortOrder(indexLevelSortOrder);

		if (indexPath == null) {
			standardsExtImpl.setIndexPath(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setIndexPath(indexPath);
		}

		if (auditLogComments == null) {
			standardsExtImpl.setAuditLogComments(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setAuditLogComments(auditLogComments);
		}

		if (auditLogTitle == null) {
			standardsExtImpl.setAuditLogTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setAuditLogTitle(auditLogTitle);
		}

		if (auditLogDate == Long.MIN_VALUE) {
			standardsExtImpl.setAuditLogDate(null);
		}
		else {
			standardsExtImpl.setAuditLogDate(new Date(auditLogDate));
		}

		if (auditLogStatus == null) {
			standardsExtImpl.setAuditLogStatus(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setAuditLogStatus(auditLogStatus);
		}

		if (auditLogPrevStatus == null) {
			standardsExtImpl.setAuditLogPrevStatus(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setAuditLogPrevStatus(auditLogPrevStatus);
		}

		if (histManualDesc == null) {
			standardsExtImpl.setHistManualDesc(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setHistManualDesc(histManualDesc);
		}

		if (secLangIndexTitle == null) {
			standardsExtImpl.setSecLangIndexTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setSecLangIndexTitle(secLangIndexTitle);
		}

		if (secLangIndexDesc == null) {
			standardsExtImpl.setSecLangIndexDesc(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setSecLangIndexDesc(secLangIndexDesc);
		}

		if (secLangIndexImgPath == null) {
			standardsExtImpl.setSecLangIndexImgPath(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setSecLangIndexImgPath(secLangIndexImgPath);
		}

		if (secLangStdTitle == null) {
			standardsExtImpl.setSecLangStdTitle(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setSecLangStdTitle(secLangStdTitle);
		}

		if (secLangStdDesc == null) {
			standardsExtImpl.setSecLangStdDesc(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setSecLangStdDesc(secLangStdDesc);
		}

		if (biChangeTypeCd == null) {
			standardsExtImpl.setBiChangeTypeCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiChangeTypeCd(biChangeTypeCd);
		}

		if (biRegionCd == null) {
			standardsExtImpl.setBiRegionCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiRegionCd(biRegionCd);
		}

		if (biProfileLossImpactCd == null) {
			standardsExtImpl.setBiProfileLossImpactCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiProfileLossImpactCd(biProfileLossImpactCd);
		}

		if (biCapExpenseImpactCd == null) {
			standardsExtImpl.setBiCapExpenseImpactCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiCapExpenseImpactCd(biCapExpenseImpactCd);
		}

		if (biImplTimeScaleCd == null) {
			standardsExtImpl.setBiImplTimeScaleCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiImplTimeScaleCd(biImplTimeScaleCd);
		}

		if (biComments == null) {
			standardsExtImpl.setBiComments(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiComments(biComments);
		}

		if (biBrandCd == null) {
			standardsExtImpl.setBiBrandCd(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setBiBrandCd(biBrandCd);
		}

		if (stdCrossReferences == null) {
			standardsExtImpl.setStdCrossReferences(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setStdCrossReferences(stdCrossReferences);
		}

		if (auditBrand == null) {
			standardsExtImpl.setAuditBrand(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setAuditBrand(auditBrand);
		}

		standardsExtImpl.setGlobalRule(globalRule);
		standardsExtImpl.setAmeaRule(ameaRule);
		standardsExtImpl.setAmerRule(amerRule);
		standardsExtImpl.setEuroRule(euroRule);
		standardsExtImpl.setGcRule(gcRule);

		if (expires == null) {
			standardsExtImpl.setExpires(StringPool.BLANK);
		}
		else {
			standardsExtImpl.setExpires(expires);
		}

		standardsExtImpl.resetOriginalValues();

		return standardsExtImpl;
	}

	@Override
	public void readExternal(ObjectInput objectInput) throws IOException {
		stdId = objectInput.readLong();
		auditLogId = objectInput.readLong();
		stdManual = objectInput.readUTF();
		stdCorporateDepartment = objectInput.readUTF();
		stdBrandCd = objectInput.readUTF();
		biImpactAssmntId = objectInput.readLong();
		stdCountryCd = objectInput.readUTF();
		stdPrntId = objectInput.readLong();
		stdOrigStdId = objectInput.readLong();
		stdPubStatCd = objectInput.readUTF();
		stdType = objectInput.readUTF();
		stdTitle = objectInput.readUTF();
		stdDescription = objectInput.readUTF();
		stdBusinessOwner = objectInput.readUTF();
		stdStatus = objectInput.readUTF();
		stdAuthor = objectInput.readUTF();
		stdCategory = objectInput.readUTF();
		stdGlobal = objectInput.readUTF();
		stdRegionCode = objectInput.readUTF();
		stdFramework = objectInput.readUTF();
		stdChange = objectInput.readUTF();
		stdCreatedBy = objectInput.readUTF();
		stdUpdatedDate = objectInput.readLong();
		stdImageCount = objectInput.readLong();
		stdImageTitle = objectInput.readUTF();
		stdInternalReference = objectInput.readUTF();
		stdOrderNumber = objectInput.readLong();
		indexId = objectInput.readLong();
		indexOrigId = objectInput.readLong();
		indexPrntId = objectInput.readLong();
		indexTitle = objectInput.readUTF();
		indexLevel = objectInput.readLong();
		indexLevelSortOrder = objectInput.readLong();
		indexPath = objectInput.readUTF();
		auditLogComments = objectInput.readUTF();
		auditLogTitle = objectInput.readUTF();
		auditLogDate = objectInput.readLong();
		auditLogStatus = objectInput.readUTF();
		auditLogPrevStatus = objectInput.readUTF();
		histManualDesc = objectInput.readUTF();
		secLangIndexTitle = objectInput.readUTF();
		secLangIndexDesc = objectInput.readUTF();
		secLangIndexImgPath = objectInput.readUTF();
		secLangStdTitle = objectInput.readUTF();
		secLangStdDesc = objectInput.readUTF();
		biChangeTypeCd = objectInput.readUTF();
		biRegionCd = objectInput.readUTF();
		biProfileLossImpactCd = objectInput.readUTF();
		biCapExpenseImpactCd = objectInput.readUTF();
		biImplTimeScaleCd = objectInput.readUTF();
		biComments = objectInput.readUTF();
		biBrandCd = objectInput.readUTF();
		stdCrossReferences = objectInput.readUTF();
		auditBrand = objectInput.readUTF();
		globalRule = objectInput.readLong();
		ameaRule = objectInput.readLong();
		amerRule = objectInput.readLong();
		euroRule = objectInput.readLong();
		gcRule = objectInput.readLong();
		expires = objectInput.readUTF();
	}

	@Override
	public void writeExternal(ObjectOutput objectOutput)
		throws IOException {
		objectOutput.writeLong(stdId);
		objectOutput.writeLong(auditLogId);

		if (stdManual == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdManual);
		}

		if (stdCorporateDepartment == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdCorporateDepartment);
		}

		if (stdBrandCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdBrandCd);
		}

		objectOutput.writeLong(biImpactAssmntId);

		if (stdCountryCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdCountryCd);
		}

		objectOutput.writeLong(stdPrntId);
		objectOutput.writeLong(stdOrigStdId);

		if (stdPubStatCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdPubStatCd);
		}

		if (stdType == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdType);
		}

		if (stdTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdTitle);
		}

		if (stdDescription == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdDescription);
		}

		if (stdBusinessOwner == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdBusinessOwner);
		}

		if (stdStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdStatus);
		}

		if (stdAuthor == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdAuthor);
		}

		if (stdCategory == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdCategory);
		}

		if (stdGlobal == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdGlobal);
		}

		if (stdRegionCode == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdRegionCode);
		}

		if (stdFramework == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdFramework);
		}

		if (stdChange == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdChange);
		}

		if (stdCreatedBy == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdCreatedBy);
		}

		objectOutput.writeLong(stdUpdatedDate);
		objectOutput.writeLong(stdImageCount);

		if (stdImageTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdImageTitle);
		}

		if (stdInternalReference == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdInternalReference);
		}

		objectOutput.writeLong(stdOrderNumber);
		objectOutput.writeLong(indexId);
		objectOutput.writeLong(indexOrigId);
		objectOutput.writeLong(indexPrntId);

		if (indexTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexTitle);
		}

		objectOutput.writeLong(indexLevel);
		objectOutput.writeLong(indexLevelSortOrder);

		if (indexPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(indexPath);
		}

		if (auditLogComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(auditLogComments);
		}

		if (auditLogTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(auditLogTitle);
		}

		objectOutput.writeLong(auditLogDate);

		if (auditLogStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(auditLogStatus);
		}

		if (auditLogPrevStatus == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(auditLogPrevStatus);
		}

		if (histManualDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(histManualDesc);
		}

		if (secLangIndexTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secLangIndexTitle);
		}

		if (secLangIndexDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secLangIndexDesc);
		}

		if (secLangIndexImgPath == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secLangIndexImgPath);
		}

		if (secLangStdTitle == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secLangStdTitle);
		}

		if (secLangStdDesc == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(secLangStdDesc);
		}

		if (biChangeTypeCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biChangeTypeCd);
		}

		if (biRegionCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biRegionCd);
		}

		if (biProfileLossImpactCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biProfileLossImpactCd);
		}

		if (biCapExpenseImpactCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biCapExpenseImpactCd);
		}

		if (biImplTimeScaleCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biImplTimeScaleCd);
		}

		if (biComments == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biComments);
		}

		if (biBrandCd == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(biBrandCd);
		}

		if (stdCrossReferences == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(stdCrossReferences);
		}

		if (auditBrand == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(auditBrand);
		}

		objectOutput.writeLong(globalRule);
		objectOutput.writeLong(ameaRule);
		objectOutput.writeLong(amerRule);
		objectOutput.writeLong(euroRule);
		objectOutput.writeLong(gcRule);

		if (expires == null) {
			objectOutput.writeUTF(StringPool.BLANK);
		}
		else {
			objectOutput.writeUTF(expires);
		}
	}

	public long stdId;
	public long auditLogId;
	public String stdManual;
	public String stdCorporateDepartment;
	public String stdBrandCd;
	public long biImpactAssmntId;
	public String stdCountryCd;
	public long stdPrntId;
	public long stdOrigStdId;
	public String stdPubStatCd;
	public String stdType;
	public String stdTitle;
	public String stdDescription;
	public String stdBusinessOwner;
	public String stdStatus;
	public String stdAuthor;
	public String stdCategory;
	public String stdGlobal;
	public String stdRegionCode;
	public String stdFramework;
	public String stdChange;
	public String stdCreatedBy;
	public long stdUpdatedDate;
	public long stdImageCount;
	public String stdImageTitle;
	public String stdInternalReference;
	public long stdOrderNumber;
	public long indexId;
	public long indexOrigId;
	public long indexPrntId;
	public String indexTitle;
	public long indexLevel;
	public long indexLevelSortOrder;
	public String indexPath;
	public String auditLogComments;
	public String auditLogTitle;
	public long auditLogDate;
	public String auditLogStatus;
	public String auditLogPrevStatus;
	public String histManualDesc;
	public String secLangIndexTitle;
	public String secLangIndexDesc;
	public String secLangIndexImgPath;
	public String secLangStdTitle;
	public String secLangStdDesc;
	public String biChangeTypeCd;
	public String biRegionCd;
	public String biProfileLossImpactCd;
	public String biCapExpenseImpactCd;
	public String biImplTimeScaleCd;
	public String biComments;
	public String biBrandCd;
	public String stdCrossReferences;
	public String auditBrand;
	public long globalRule;
	public long ameaRule;
	public long amerRule;
	public long euroRule;
	public long gcRule;
	public String expires;
}