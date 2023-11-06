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

package com.ihg.brandstandards.db.model;

import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.StandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsExtPK;

import com.liferay.portal.kernel.bean.AutoEscapeBeanHandler;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.util.ProxyUtil;
import com.liferay.portal.kernel.util.StringBundler;
import com.liferay.portal.model.BaseModel;
import com.liferay.portal.model.impl.BaseModelImpl;

import java.io.Serializable;

import java.lang.reflect.Method;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @author Mummanedi
 */
public class StandardsExtClp extends BaseModelImpl<StandardsExt>
	implements StandardsExt {
	public StandardsExtClp() {
	}

	@Override
	public Class<?> getModelClass() {
		return StandardsExt.class;
	}

	@Override
	public String getModelClassName() {
		return StandardsExt.class.getName();
	}

	@Override
	public StandardsExtPK getPrimaryKey() {
		return new StandardsExtPK(_stdId, _auditLogId, _stdManual,
			_stdCorporateDepartment, _stdBrandCd, _biImpactAssmntId,
			_stdCountryCd);
	}

	@Override
	public void setPrimaryKey(StandardsExtPK primaryKey) {
		setStdId(primaryKey.stdId);
		setAuditLogId(primaryKey.auditLogId);
		setStdManual(primaryKey.stdManual);
		setStdCorporateDepartment(primaryKey.stdCorporateDepartment);
		setStdBrandCd(primaryKey.stdBrandCd);
		setBiImpactAssmntId(primaryKey.biImpactAssmntId);
		setStdCountryCd(primaryKey.stdCountryCd);
	}

	@Override
	public Serializable getPrimaryKeyObj() {
		return new StandardsExtPK(_stdId, _auditLogId, _stdManual,
			_stdCorporateDepartment, _stdBrandCd, _biImpactAssmntId,
			_stdCountryCd);
	}

	@Override
	public void setPrimaryKeyObj(Serializable primaryKeyObj) {
		setPrimaryKey((StandardsExtPK)primaryKeyObj);
	}

	@Override
	public Map<String, Object> getModelAttributes() {
		Map<String, Object> attributes = new HashMap<String, Object>();

		attributes.put("stdId", getStdId());
		attributes.put("auditLogId", getAuditLogId());
		attributes.put("stdManual", getStdManual());
		attributes.put("stdCorporateDepartment", getStdCorporateDepartment());
		attributes.put("stdBrandCd", getStdBrandCd());
		attributes.put("biImpactAssmntId", getBiImpactAssmntId());
		attributes.put("stdCountryCd", getStdCountryCd());
		attributes.put("stdPrntId", getStdPrntId());
		attributes.put("stdOrigStdId", getStdOrigStdId());
		attributes.put("stdPubStatCd", getStdPubStatCd());
		attributes.put("stdType", getStdType());
		attributes.put("stdTitle", getStdTitle());
		attributes.put("stdDescription", getStdDescription());
		attributes.put("stdBusinessOwner", getStdBusinessOwner());
		attributes.put("stdStatus", getStdStatus());
		attributes.put("stdAuthor", getStdAuthor());
		attributes.put("stdCategory", getStdCategory());
		attributes.put("stdGlobal", getStdGlobal());
		attributes.put("stdRegionCode", getStdRegionCode());
		attributes.put("stdFramework", getStdFramework());
		attributes.put("stdChange", getStdChange());
		attributes.put("stdCreatedBy", getStdCreatedBy());
		attributes.put("stdUpdatedDate", getStdUpdatedDate());
		attributes.put("stdImageCount", getStdImageCount());
		attributes.put("stdImageTitle", getStdImageTitle());
		attributes.put("stdInternalReference", getStdInternalReference());
		attributes.put("stdOrderNumber", getStdOrderNumber());
		attributes.put("indexId", getIndexId());
		attributes.put("indexOrigId", getIndexOrigId());
		attributes.put("indexPrntId", getIndexPrntId());
		attributes.put("indexTitle", getIndexTitle());
		attributes.put("indexLevel", getIndexLevel());
		attributes.put("indexLevelSortOrder", getIndexLevelSortOrder());
		attributes.put("indexPath", getIndexPath());
		attributes.put("auditLogComments", getAuditLogComments());
		attributes.put("auditLogTitle", getAuditLogTitle());
		attributes.put("auditLogDate", getAuditLogDate());
		attributes.put("auditLogStatus", getAuditLogStatus());
		attributes.put("auditLogPrevStatus", getAuditLogPrevStatus());
		attributes.put("histManualDesc", getHistManualDesc());
		attributes.put("secLangIndexTitle", getSecLangIndexTitle());
		attributes.put("secLangIndexDesc", getSecLangIndexDesc());
		attributes.put("secLangIndexImgPath", getSecLangIndexImgPath());
		attributes.put("secLangStdTitle", getSecLangStdTitle());
		attributes.put("secLangStdDesc", getSecLangStdDesc());
		attributes.put("biChangeTypeCd", getBiChangeTypeCd());
		attributes.put("biRegionCd", getBiRegionCd());
		attributes.put("biProfileLossImpactCd", getBiProfileLossImpactCd());
		attributes.put("biCapExpenseImpactCd", getBiCapExpenseImpactCd());
		attributes.put("biImplTimeScaleCd", getBiImplTimeScaleCd());
		attributes.put("biComments", getBiComments());
		attributes.put("biBrandCd", getBiBrandCd());
		attributes.put("stdCrossReferences", getStdCrossReferences());
		attributes.put("auditBrand", getAuditBrand());
		attributes.put("globalRule", getGlobalRule());
		attributes.put("ameaRule", getAmeaRule());
		attributes.put("amerRule", getAmerRule());
		attributes.put("euroRule", getEuroRule());
		attributes.put("gcRule", getGcRule());
		attributes.put("expires", getExpires());

		return attributes;
	}

	@Override
	public void setModelAttributes(Map<String, Object> attributes) {
		Long stdId = (Long)attributes.get("stdId");

		if (stdId != null) {
			setStdId(stdId);
		}

		Long auditLogId = (Long)attributes.get("auditLogId");

		if (auditLogId != null) {
			setAuditLogId(auditLogId);
		}

		String stdManual = (String)attributes.get("stdManual");

		if (stdManual != null) {
			setStdManual(stdManual);
		}

		String stdCorporateDepartment = (String)attributes.get(
				"stdCorporateDepartment");

		if (stdCorporateDepartment != null) {
			setStdCorporateDepartment(stdCorporateDepartment);
		}

		String stdBrandCd = (String)attributes.get("stdBrandCd");

		if (stdBrandCd != null) {
			setStdBrandCd(stdBrandCd);
		}

		Long biImpactAssmntId = (Long)attributes.get("biImpactAssmntId");

		if (biImpactAssmntId != null) {
			setBiImpactAssmntId(biImpactAssmntId);
		}

		String stdCountryCd = (String)attributes.get("stdCountryCd");

		if (stdCountryCd != null) {
			setStdCountryCd(stdCountryCd);
		}

		Long stdPrntId = (Long)attributes.get("stdPrntId");

		if (stdPrntId != null) {
			setStdPrntId(stdPrntId);
		}

		Long stdOrigStdId = (Long)attributes.get("stdOrigStdId");

		if (stdOrigStdId != null) {
			setStdOrigStdId(stdOrigStdId);
		}

		String stdPubStatCd = (String)attributes.get("stdPubStatCd");

		if (stdPubStatCd != null) {
			setStdPubStatCd(stdPubStatCd);
		}

		String stdType = (String)attributes.get("stdType");

		if (stdType != null) {
			setStdType(stdType);
		}

		String stdTitle = (String)attributes.get("stdTitle");

		if (stdTitle != null) {
			setStdTitle(stdTitle);
		}

		String stdDescription = (String)attributes.get("stdDescription");

		if (stdDescription != null) {
			setStdDescription(stdDescription);
		}

		String stdBusinessOwner = (String)attributes.get("stdBusinessOwner");

		if (stdBusinessOwner != null) {
			setStdBusinessOwner(stdBusinessOwner);
		}

		String stdStatus = (String)attributes.get("stdStatus");

		if (stdStatus != null) {
			setStdStatus(stdStatus);
		}

		String stdAuthor = (String)attributes.get("stdAuthor");

		if (stdAuthor != null) {
			setStdAuthor(stdAuthor);
		}

		String stdCategory = (String)attributes.get("stdCategory");

		if (stdCategory != null) {
			setStdCategory(stdCategory);
		}

		String stdGlobal = (String)attributes.get("stdGlobal");

		if (stdGlobal != null) {
			setStdGlobal(stdGlobal);
		}

		String stdRegionCode = (String)attributes.get("stdRegionCode");

		if (stdRegionCode != null) {
			setStdRegionCode(stdRegionCode);
		}

		String stdFramework = (String)attributes.get("stdFramework");

		if (stdFramework != null) {
			setStdFramework(stdFramework);
		}

		String stdChange = (String)attributes.get("stdChange");

		if (stdChange != null) {
			setStdChange(stdChange);
		}

		String stdCreatedBy = (String)attributes.get("stdCreatedBy");

		if (stdCreatedBy != null) {
			setStdCreatedBy(stdCreatedBy);
		}

		Date stdUpdatedDate = (Date)attributes.get("stdUpdatedDate");

		if (stdUpdatedDate != null) {
			setStdUpdatedDate(stdUpdatedDate);
		}

		Long stdImageCount = (Long)attributes.get("stdImageCount");

		if (stdImageCount != null) {
			setStdImageCount(stdImageCount);
		}

		String stdImageTitle = (String)attributes.get("stdImageTitle");

		if (stdImageTitle != null) {
			setStdImageTitle(stdImageTitle);
		}

		String stdInternalReference = (String)attributes.get(
				"stdInternalReference");

		if (stdInternalReference != null) {
			setStdInternalReference(stdInternalReference);
		}

		Long stdOrderNumber = (Long)attributes.get("stdOrderNumber");

		if (stdOrderNumber != null) {
			setStdOrderNumber(stdOrderNumber);
		}

		Long indexId = (Long)attributes.get("indexId");

		if (indexId != null) {
			setIndexId(indexId);
		}

		Long indexOrigId = (Long)attributes.get("indexOrigId");

		if (indexOrigId != null) {
			setIndexOrigId(indexOrigId);
		}

		Long indexPrntId = (Long)attributes.get("indexPrntId");

		if (indexPrntId != null) {
			setIndexPrntId(indexPrntId);
		}

		String indexTitle = (String)attributes.get("indexTitle");

		if (indexTitle != null) {
			setIndexTitle(indexTitle);
		}

		Long indexLevel = (Long)attributes.get("indexLevel");

		if (indexLevel != null) {
			setIndexLevel(indexLevel);
		}

		Long indexLevelSortOrder = (Long)attributes.get("indexLevelSortOrder");

		if (indexLevelSortOrder != null) {
			setIndexLevelSortOrder(indexLevelSortOrder);
		}

		String indexPath = (String)attributes.get("indexPath");

		if (indexPath != null) {
			setIndexPath(indexPath);
		}

		String auditLogComments = (String)attributes.get("auditLogComments");

		if (auditLogComments != null) {
			setAuditLogComments(auditLogComments);
		}

		String auditLogTitle = (String)attributes.get("auditLogTitle");

		if (auditLogTitle != null) {
			setAuditLogTitle(auditLogTitle);
		}

		Date auditLogDate = (Date)attributes.get("auditLogDate");

		if (auditLogDate != null) {
			setAuditLogDate(auditLogDate);
		}

		String auditLogStatus = (String)attributes.get("auditLogStatus");

		if (auditLogStatus != null) {
			setAuditLogStatus(auditLogStatus);
		}

		String auditLogPrevStatus = (String)attributes.get("auditLogPrevStatus");

		if (auditLogPrevStatus != null) {
			setAuditLogPrevStatus(auditLogPrevStatus);
		}

		String histManualDesc = (String)attributes.get("histManualDesc");

		if (histManualDesc != null) {
			setHistManualDesc(histManualDesc);
		}

		String secLangIndexTitle = (String)attributes.get("secLangIndexTitle");

		if (secLangIndexTitle != null) {
			setSecLangIndexTitle(secLangIndexTitle);
		}

		String secLangIndexDesc = (String)attributes.get("secLangIndexDesc");

		if (secLangIndexDesc != null) {
			setSecLangIndexDesc(secLangIndexDesc);
		}

		String secLangIndexImgPath = (String)attributes.get(
				"secLangIndexImgPath");

		if (secLangIndexImgPath != null) {
			setSecLangIndexImgPath(secLangIndexImgPath);
		}

		String secLangStdTitle = (String)attributes.get("secLangStdTitle");

		if (secLangStdTitle != null) {
			setSecLangStdTitle(secLangStdTitle);
		}

		String secLangStdDesc = (String)attributes.get("secLangStdDesc");

		if (secLangStdDesc != null) {
			setSecLangStdDesc(secLangStdDesc);
		}

		String biChangeTypeCd = (String)attributes.get("biChangeTypeCd");

		if (biChangeTypeCd != null) {
			setBiChangeTypeCd(biChangeTypeCd);
		}

		String biRegionCd = (String)attributes.get("biRegionCd");

		if (biRegionCd != null) {
			setBiRegionCd(biRegionCd);
		}

		String biProfileLossImpactCd = (String)attributes.get(
				"biProfileLossImpactCd");

		if (biProfileLossImpactCd != null) {
			setBiProfileLossImpactCd(biProfileLossImpactCd);
		}

		String biCapExpenseImpactCd = (String)attributes.get(
				"biCapExpenseImpactCd");

		if (biCapExpenseImpactCd != null) {
			setBiCapExpenseImpactCd(biCapExpenseImpactCd);
		}

		String biImplTimeScaleCd = (String)attributes.get("biImplTimeScaleCd");

		if (biImplTimeScaleCd != null) {
			setBiImplTimeScaleCd(biImplTimeScaleCd);
		}

		String biComments = (String)attributes.get("biComments");

		if (biComments != null) {
			setBiComments(biComments);
		}

		String biBrandCd = (String)attributes.get("biBrandCd");

		if (biBrandCd != null) {
			setBiBrandCd(biBrandCd);
		}

		String stdCrossReferences = (String)attributes.get("stdCrossReferences");

		if (stdCrossReferences != null) {
			setStdCrossReferences(stdCrossReferences);
		}

		String auditBrand = (String)attributes.get("auditBrand");

		if (auditBrand != null) {
			setAuditBrand(auditBrand);
		}

		Long globalRule = (Long)attributes.get("globalRule");

		if (globalRule != null) {
			setGlobalRule(globalRule);
		}

		Long ameaRule = (Long)attributes.get("ameaRule");

		if (ameaRule != null) {
			setAmeaRule(ameaRule);
		}

		Long amerRule = (Long)attributes.get("amerRule");

		if (amerRule != null) {
			setAmerRule(amerRule);
		}

		Long euroRule = (Long)attributes.get("euroRule");

		if (euroRule != null) {
			setEuroRule(euroRule);
		}

		Long gcRule = (Long)attributes.get("gcRule");

		if (gcRule != null) {
			setGcRule(gcRule);
		}

		String expires = (String)attributes.get("expires");

		if (expires != null) {
			setExpires(expires);
		}
	}

	@Override
	public long getStdId() {
		return _stdId;
	}

	@Override
	public void setStdId(long stdId) {
		_stdId = stdId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdId", long.class);

				method.invoke(_standardsExtRemoteModel, stdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAuditLogId() {
		return _auditLogId;
	}

	@Override
	public void setAuditLogId(long auditLogId) {
		_auditLogId = auditLogId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogId", long.class);

				method.invoke(_standardsExtRemoteModel, auditLogId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdManual() {
		return _stdManual;
	}

	@Override
	public void setStdManual(String stdManual) {
		_stdManual = stdManual;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdManual", String.class);

				method.invoke(_standardsExtRemoteModel, stdManual);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdCorporateDepartment() {
		return _stdCorporateDepartment;
	}

	@Override
	public void setStdCorporateDepartment(String stdCorporateDepartment) {
		_stdCorporateDepartment = stdCorporateDepartment;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdCorporateDepartment",
						String.class);

				method.invoke(_standardsExtRemoteModel, stdCorporateDepartment);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdBrandCd() {
		return _stdBrandCd;
	}

	@Override
	public void setStdBrandCd(String stdBrandCd) {
		_stdBrandCd = stdBrandCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdBrandCd", String.class);

				method.invoke(_standardsExtRemoteModel, stdBrandCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getBiImpactAssmntId() {
		return _biImpactAssmntId;
	}

	@Override
	public void setBiImpactAssmntId(long biImpactAssmntId) {
		_biImpactAssmntId = biImpactAssmntId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiImpactAssmntId",
						long.class);

				method.invoke(_standardsExtRemoteModel, biImpactAssmntId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdCountryCd() {
		return _stdCountryCd;
	}

	@Override
	public void setStdCountryCd(String stdCountryCd) {
		_stdCountryCd = stdCountryCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdCountryCd", String.class);

				method.invoke(_standardsExtRemoteModel, stdCountryCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdPrntId() {
		return _stdPrntId;
	}

	@Override
	public void setStdPrntId(long stdPrntId) {
		_stdPrntId = stdPrntId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdPrntId", long.class);

				method.invoke(_standardsExtRemoteModel, stdPrntId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdOrigStdId() {
		return _stdOrigStdId;
	}

	@Override
	public void setStdOrigStdId(long stdOrigStdId) {
		_stdOrigStdId = stdOrigStdId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdOrigStdId", long.class);

				method.invoke(_standardsExtRemoteModel, stdOrigStdId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdPubStatCd() {
		return _stdPubStatCd;
	}

	@Override
	public void setStdPubStatCd(String stdPubStatCd) {
		_stdPubStatCd = stdPubStatCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdPubStatCd", String.class);

				method.invoke(_standardsExtRemoteModel, stdPubStatCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdType() {
		return _stdType;
	}

	@Override
	public void setStdType(String stdType) {
		_stdType = stdType;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdType", String.class);

				method.invoke(_standardsExtRemoteModel, stdType);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdTitle() {
		return _stdTitle;
	}

	@Override
	public void setStdTitle(String stdTitle) {
		_stdTitle = stdTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdTitle", String.class);

				method.invoke(_standardsExtRemoteModel, stdTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdDescription() {
		return _stdDescription;
	}

	@Override
	public void setStdDescription(String stdDescription) {
		_stdDescription = stdDescription;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdDescription",
						String.class);

				method.invoke(_standardsExtRemoteModel, stdDescription);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdBusinessOwner() {
		return _stdBusinessOwner;
	}

	@Override
	public void setStdBusinessOwner(String stdBusinessOwner) {
		_stdBusinessOwner = stdBusinessOwner;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdBusinessOwner",
						String.class);

				method.invoke(_standardsExtRemoteModel, stdBusinessOwner);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdStatus() {
		return _stdStatus;
	}

	@Override
	public void setStdStatus(String stdStatus) {
		_stdStatus = stdStatus;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdStatus", String.class);

				method.invoke(_standardsExtRemoteModel, stdStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdAuthor() {
		return _stdAuthor;
	}

	@Override
	public void setStdAuthor(String stdAuthor) {
		_stdAuthor = stdAuthor;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdAuthor", String.class);

				method.invoke(_standardsExtRemoteModel, stdAuthor);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdCategory() {
		return _stdCategory;
	}

	@Override
	public void setStdCategory(String stdCategory) {
		_stdCategory = stdCategory;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdCategory", String.class);

				method.invoke(_standardsExtRemoteModel, stdCategory);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdGlobal() {
		return _stdGlobal;
	}

	@Override
	public void setStdGlobal(String stdGlobal) {
		_stdGlobal = stdGlobal;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdGlobal", String.class);

				method.invoke(_standardsExtRemoteModel, stdGlobal);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdRegionCode() {
		return _stdRegionCode;
	}

	@Override
	public void setStdRegionCode(String stdRegionCode) {
		_stdRegionCode = stdRegionCode;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdRegionCode", String.class);

				method.invoke(_standardsExtRemoteModel, stdRegionCode);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdFramework() {
		return _stdFramework;
	}

	@Override
	public void setStdFramework(String stdFramework) {
		_stdFramework = stdFramework;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdFramework", String.class);

				method.invoke(_standardsExtRemoteModel, stdFramework);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdChange() {
		return _stdChange;
	}

	@Override
	public void setStdChange(String stdChange) {
		_stdChange = stdChange;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdChange", String.class);

				method.invoke(_standardsExtRemoteModel, stdChange);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdCreatedBy() {
		return _stdCreatedBy;
	}

	@Override
	public void setStdCreatedBy(String stdCreatedBy) {
		_stdCreatedBy = stdCreatedBy;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdCreatedBy", String.class);

				method.invoke(_standardsExtRemoteModel, stdCreatedBy);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getStdUpdatedDate() {
		return _stdUpdatedDate;
	}

	@Override
	public void setStdUpdatedDate(Date stdUpdatedDate) {
		_stdUpdatedDate = stdUpdatedDate;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdUpdatedDate", Date.class);

				method.invoke(_standardsExtRemoteModel, stdUpdatedDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdImageCount() {
		return _stdImageCount;
	}

	@Override
	public void setStdImageCount(long stdImageCount) {
		_stdImageCount = stdImageCount;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdImageCount", long.class);

				method.invoke(_standardsExtRemoteModel, stdImageCount);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdImageTitle() {
		return _stdImageTitle;
	}

	@Override
	public void setStdImageTitle(String stdImageTitle) {
		_stdImageTitle = stdImageTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdImageTitle", String.class);

				method.invoke(_standardsExtRemoteModel, stdImageTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdInternalReference() {
		return _stdInternalReference;
	}

	@Override
	public void setStdInternalReference(String stdInternalReference) {
		_stdInternalReference = stdInternalReference;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdInternalReference",
						String.class);

				method.invoke(_standardsExtRemoteModel, stdInternalReference);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getStdOrderNumber() {
		return _stdOrderNumber;
	}

	@Override
	public void setStdOrderNumber(long stdOrderNumber) {
		_stdOrderNumber = stdOrderNumber;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdOrderNumber", long.class);

				method.invoke(_standardsExtRemoteModel, stdOrderNumber);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexId() {
		return _indexId;
	}

	@Override
	public void setIndexId(long indexId) {
		_indexId = indexId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexId", long.class);

				method.invoke(_standardsExtRemoteModel, indexId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexOrigId() {
		return _indexOrigId;
	}

	@Override
	public void setIndexOrigId(long indexOrigId) {
		_indexOrigId = indexOrigId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexOrigId", long.class);

				method.invoke(_standardsExtRemoteModel, indexOrigId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexPrntId() {
		return _indexPrntId;
	}

	@Override
	public void setIndexPrntId(long indexPrntId) {
		_indexPrntId = indexPrntId;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexPrntId", long.class);

				method.invoke(_standardsExtRemoteModel, indexPrntId);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexTitle() {
		return _indexTitle;
	}

	@Override
	public void setIndexTitle(String indexTitle) {
		_indexTitle = indexTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexTitle", String.class);

				method.invoke(_standardsExtRemoteModel, indexTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexLevel() {
		return _indexLevel;
	}

	@Override
	public void setIndexLevel(long indexLevel) {
		_indexLevel = indexLevel;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexLevel", long.class);

				method.invoke(_standardsExtRemoteModel, indexLevel);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getIndexLevelSortOrder() {
		return _indexLevelSortOrder;
	}

	@Override
	public void setIndexLevelSortOrder(long indexLevelSortOrder) {
		_indexLevelSortOrder = indexLevelSortOrder;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexLevelSortOrder",
						long.class);

				method.invoke(_standardsExtRemoteModel, indexLevelSortOrder);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getIndexPath() {
		return _indexPath;
	}

	@Override
	public void setIndexPath(String indexPath) {
		_indexPath = indexPath;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setIndexPath", String.class);

				method.invoke(_standardsExtRemoteModel, indexPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuditLogComments() {
		return _auditLogComments;
	}

	@Override
	public void setAuditLogComments(String auditLogComments) {
		_auditLogComments = auditLogComments;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogComments",
						String.class);

				method.invoke(_standardsExtRemoteModel, auditLogComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuditLogTitle() {
		return _auditLogTitle;
	}

	@Override
	public void setAuditLogTitle(String auditLogTitle) {
		_auditLogTitle = auditLogTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogTitle", String.class);

				method.invoke(_standardsExtRemoteModel, auditLogTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public Date getAuditLogDate() {
		return _auditLogDate;
	}

	@Override
	public void setAuditLogDate(Date auditLogDate) {
		_auditLogDate = auditLogDate;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogDate", Date.class);

				method.invoke(_standardsExtRemoteModel, auditLogDate);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuditLogStatus() {
		return _auditLogStatus;
	}

	@Override
	public void setAuditLogStatus(String auditLogStatus) {
		_auditLogStatus = auditLogStatus;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogStatus",
						String.class);

				method.invoke(_standardsExtRemoteModel, auditLogStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuditLogPrevStatus() {
		return _auditLogPrevStatus;
	}

	@Override
	public void setAuditLogPrevStatus(String auditLogPrevStatus) {
		_auditLogPrevStatus = auditLogPrevStatus;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditLogPrevStatus",
						String.class);

				method.invoke(_standardsExtRemoteModel, auditLogPrevStatus);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getHistManualDesc() {
		return _histManualDesc;
	}

	@Override
	public void setHistManualDesc(String histManualDesc) {
		_histManualDesc = histManualDesc;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setHistManualDesc",
						String.class);

				method.invoke(_standardsExtRemoteModel, histManualDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecLangIndexTitle() {
		return _secLangIndexTitle;
	}

	@Override
	public void setSecLangIndexTitle(String secLangIndexTitle) {
		_secLangIndexTitle = secLangIndexTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSecLangIndexTitle",
						String.class);

				method.invoke(_standardsExtRemoteModel, secLangIndexTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecLangIndexDesc() {
		return _secLangIndexDesc;
	}

	@Override
	public void setSecLangIndexDesc(String secLangIndexDesc) {
		_secLangIndexDesc = secLangIndexDesc;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSecLangIndexDesc",
						String.class);

				method.invoke(_standardsExtRemoteModel, secLangIndexDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecLangIndexImgPath() {
		return _secLangIndexImgPath;
	}

	@Override
	public void setSecLangIndexImgPath(String secLangIndexImgPath) {
		_secLangIndexImgPath = secLangIndexImgPath;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSecLangIndexImgPath",
						String.class);

				method.invoke(_standardsExtRemoteModel, secLangIndexImgPath);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecLangStdTitle() {
		return _secLangStdTitle;
	}

	@Override
	public void setSecLangStdTitle(String secLangStdTitle) {
		_secLangStdTitle = secLangStdTitle;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSecLangStdTitle",
						String.class);

				method.invoke(_standardsExtRemoteModel, secLangStdTitle);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getSecLangStdDesc() {
		return _secLangStdDesc;
	}

	@Override
	public void setSecLangStdDesc(String secLangStdDesc) {
		_secLangStdDesc = secLangStdDesc;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setSecLangStdDesc",
						String.class);

				method.invoke(_standardsExtRemoteModel, secLangStdDesc);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiChangeTypeCd() {
		return _biChangeTypeCd;
	}

	@Override
	public void setBiChangeTypeCd(String biChangeTypeCd) {
		_biChangeTypeCd = biChangeTypeCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiChangeTypeCd",
						String.class);

				method.invoke(_standardsExtRemoteModel, biChangeTypeCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiRegionCd() {
		return _biRegionCd;
	}

	@Override
	public void setBiRegionCd(String biRegionCd) {
		_biRegionCd = biRegionCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiRegionCd", String.class);

				method.invoke(_standardsExtRemoteModel, biRegionCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiProfileLossImpactCd() {
		return _biProfileLossImpactCd;
	}

	@Override
	public void setBiProfileLossImpactCd(String biProfileLossImpactCd) {
		_biProfileLossImpactCd = biProfileLossImpactCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiProfileLossImpactCd",
						String.class);

				method.invoke(_standardsExtRemoteModel, biProfileLossImpactCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiCapExpenseImpactCd() {
		return _biCapExpenseImpactCd;
	}

	@Override
	public void setBiCapExpenseImpactCd(String biCapExpenseImpactCd) {
		_biCapExpenseImpactCd = biCapExpenseImpactCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiCapExpenseImpactCd",
						String.class);

				method.invoke(_standardsExtRemoteModel, biCapExpenseImpactCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiImplTimeScaleCd() {
		return _biImplTimeScaleCd;
	}

	@Override
	public void setBiImplTimeScaleCd(String biImplTimeScaleCd) {
		_biImplTimeScaleCd = biImplTimeScaleCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiImplTimeScaleCd",
						String.class);

				method.invoke(_standardsExtRemoteModel, biImplTimeScaleCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiComments() {
		return _biComments;
	}

	@Override
	public void setBiComments(String biComments) {
		_biComments = biComments;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiComments", String.class);

				method.invoke(_standardsExtRemoteModel, biComments);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getBiBrandCd() {
		return _biBrandCd;
	}

	@Override
	public void setBiBrandCd(String biBrandCd) {
		_biBrandCd = biBrandCd;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setBiBrandCd", String.class);

				method.invoke(_standardsExtRemoteModel, biBrandCd);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getStdCrossReferences() {
		return _stdCrossReferences;
	}

	@Override
	public void setStdCrossReferences(String stdCrossReferences) {
		_stdCrossReferences = stdCrossReferences;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setStdCrossReferences",
						String.class);

				method.invoke(_standardsExtRemoteModel, stdCrossReferences);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getAuditBrand() {
		return _auditBrand;
	}

	@Override
	public void setAuditBrand(String auditBrand) {
		_auditBrand = auditBrand;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAuditBrand", String.class);

				method.invoke(_standardsExtRemoteModel, auditBrand);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGlobalRule() {
		return _globalRule;
	}

	@Override
	public void setGlobalRule(long globalRule) {
		_globalRule = globalRule;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGlobalRule", long.class);

				method.invoke(_standardsExtRemoteModel, globalRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAmeaRule() {
		return _ameaRule;
	}

	@Override
	public void setAmeaRule(long ameaRule) {
		_ameaRule = ameaRule;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAmeaRule", long.class);

				method.invoke(_standardsExtRemoteModel, ameaRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getAmerRule() {
		return _amerRule;
	}

	@Override
	public void setAmerRule(long amerRule) {
		_amerRule = amerRule;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setAmerRule", long.class);

				method.invoke(_standardsExtRemoteModel, amerRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getEuroRule() {
		return _euroRule;
	}

	@Override
	public void setEuroRule(long euroRule) {
		_euroRule = euroRule;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setEuroRule", long.class);

				method.invoke(_standardsExtRemoteModel, euroRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public long getGcRule() {
		return _gcRule;
	}

	@Override
	public void setGcRule(long gcRule) {
		_gcRule = gcRule;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setGcRule", long.class);

				method.invoke(_standardsExtRemoteModel, gcRule);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public String getExpires() {
		return _expires;
	}

	@Override
	public void setExpires(String expires) {
		_expires = expires;

		if (_standardsExtRemoteModel != null) {
			try {
				Class<?> clazz = _standardsExtRemoteModel.getClass();

				Method method = clazz.getMethod("setExpires", String.class);

				method.invoke(_standardsExtRemoteModel, expires);
			}
			catch (Exception e) {
				throw new UnsupportedOperationException(e);
			}
		}
	}

	@Override
	public void setAuditStatus(java.lang.String auditStatus) {
		try {
			String methodName = "setAuditStatus";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { auditStatus };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public long getIndexOrder() {
		try {
			String methodName = "getIndexOrder";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			Long returnObj = (Long)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStdManualBuild(java.lang.String stdManualBuild) {
		try {
			String methodName = "setStdManualBuild";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { stdManualBuild };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setFlags(java.util.List<java.lang.Long> flags) {
		try {
			String methodName = "setFlags";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.List.class };

			Object[] parameterValues = new Object[] { flags };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setIndexOrder(long indexOrder) {
		try {
			String methodName = "setIndexOrder";

			Class<?>[] parameterTypes = new Class<?>[] { long.class };

			Object[] parameterValues = new Object[] { indexOrder };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.List<java.lang.Long> getFlags() {
		try {
			String methodName = "getFlags";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.List<java.lang.Long> returnObj = (java.util.List<java.lang.Long>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getAuditStatus() {
		try {
			String methodName = "getAuditStatus";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStdManualBuild() {
		try {
			String methodName = "getStdManualBuild";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setStdManualOperate(java.lang.String stdManualOperate) {
		try {
			String methodName = "setStdManualOperate";

			Class<?>[] parameterTypes = new Class<?>[] { java.lang.String.class };

			Object[] parameterValues = new Object[] { stdManualOperate };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public void setCountryChngStat(
		java.util.Map<java.lang.String, java.lang.String> countryChngStat) {
		try {
			String methodName = "setCountryChngStat";

			Class<?>[] parameterTypes = new Class<?>[] { java.util.Map.class };

			Object[] parameterValues = new Object[] { countryChngStat };

			invokeOnRemoteModel(methodName, parameterTypes, parameterValues);
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.lang.String getStdManualOperate() {
		try {
			String methodName = "getStdManualOperate";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.lang.String returnObj = (java.lang.String)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	@Override
	public java.util.Map<java.lang.String, java.lang.String> getCountryChngStat() {
		try {
			String methodName = "getCountryChngStat";

			Class<?>[] parameterTypes = new Class<?>[] {  };

			Object[] parameterValues = new Object[] {  };

			java.util.Map<java.lang.String, java.lang.String> returnObj = (java.util.Map<java.lang.String, java.lang.String>)invokeOnRemoteModel(methodName,
					parameterTypes, parameterValues);

			return returnObj;
		}
		catch (Exception e) {
			throw new UnsupportedOperationException(e);
		}
	}

	public BaseModel<?> getStandardsExtRemoteModel() {
		return _standardsExtRemoteModel;
	}

	public void setStandardsExtRemoteModel(BaseModel<?> standardsExtRemoteModel) {
		_standardsExtRemoteModel = standardsExtRemoteModel;
	}

	public Object invokeOnRemoteModel(String methodName,
		Class<?>[] parameterTypes, Object[] parameterValues)
		throws Exception {
		Object[] remoteParameterValues = new Object[parameterValues.length];

		for (int i = 0; i < parameterValues.length; i++) {
			if (parameterValues[i] != null) {
				remoteParameterValues[i] = ClpSerializer.translateInput(parameterValues[i]);
			}
		}

		Class<?> remoteModelClass = _standardsExtRemoteModel.getClass();

		ClassLoader remoteModelClassLoader = remoteModelClass.getClassLoader();

		Class<?>[] remoteParameterTypes = new Class[parameterTypes.length];

		for (int i = 0; i < parameterTypes.length; i++) {
			if (parameterTypes[i].isPrimitive()) {
				remoteParameterTypes[i] = parameterTypes[i];
			}
			else {
				String parameterTypeName = parameterTypes[i].getName();

				remoteParameterTypes[i] = remoteModelClassLoader.loadClass(parameterTypeName);
			}
		}

		Method method = remoteModelClass.getMethod(methodName,
				remoteParameterTypes);

		Object returnValue = method.invoke(_standardsExtRemoteModel,
				remoteParameterValues);

		if (returnValue != null) {
			returnValue = ClpSerializer.translateOutput(returnValue);
		}

		return returnValue;
	}

	@Override
	public void persist() throws SystemException {
		if (this.isNew()) {
			StandardsExtLocalServiceUtil.addStandardsExt(this);
		}
		else {
			StandardsExtLocalServiceUtil.updateStandardsExt(this);
		}
	}

	@Override
	public StandardsExt toEscapedModel() {
		return (StandardsExt)ProxyUtil.newProxyInstance(StandardsExt.class.getClassLoader(),
			new Class[] { StandardsExt.class }, new AutoEscapeBeanHandler(this));
	}

	@Override
	public Object clone() {
		StandardsExtClp clone = new StandardsExtClp();

		clone.setStdId(getStdId());
		clone.setAuditLogId(getAuditLogId());
		clone.setStdManual(getStdManual());
		clone.setStdCorporateDepartment(getStdCorporateDepartment());
		clone.setStdBrandCd(getStdBrandCd());
		clone.setBiImpactAssmntId(getBiImpactAssmntId());
		clone.setStdCountryCd(getStdCountryCd());
		clone.setStdPrntId(getStdPrntId());
		clone.setStdOrigStdId(getStdOrigStdId());
		clone.setStdPubStatCd(getStdPubStatCd());
		clone.setStdType(getStdType());
		clone.setStdTitle(getStdTitle());
		clone.setStdDescription(getStdDescription());
		clone.setStdBusinessOwner(getStdBusinessOwner());
		clone.setStdStatus(getStdStatus());
		clone.setStdAuthor(getStdAuthor());
		clone.setStdCategory(getStdCategory());
		clone.setStdGlobal(getStdGlobal());
		clone.setStdRegionCode(getStdRegionCode());
		clone.setStdFramework(getStdFramework());
		clone.setStdChange(getStdChange());
		clone.setStdCreatedBy(getStdCreatedBy());
		clone.setStdUpdatedDate(getStdUpdatedDate());
		clone.setStdImageCount(getStdImageCount());
		clone.setStdImageTitle(getStdImageTitle());
		clone.setStdInternalReference(getStdInternalReference());
		clone.setStdOrderNumber(getStdOrderNumber());
		clone.setIndexId(getIndexId());
		clone.setIndexOrigId(getIndexOrigId());
		clone.setIndexPrntId(getIndexPrntId());
		clone.setIndexTitle(getIndexTitle());
		clone.setIndexLevel(getIndexLevel());
		clone.setIndexLevelSortOrder(getIndexLevelSortOrder());
		clone.setIndexPath(getIndexPath());
		clone.setAuditLogComments(getAuditLogComments());
		clone.setAuditLogTitle(getAuditLogTitle());
		clone.setAuditLogDate(getAuditLogDate());
		clone.setAuditLogStatus(getAuditLogStatus());
		clone.setAuditLogPrevStatus(getAuditLogPrevStatus());
		clone.setHistManualDesc(getHistManualDesc());
		clone.setSecLangIndexTitle(getSecLangIndexTitle());
		clone.setSecLangIndexDesc(getSecLangIndexDesc());
		clone.setSecLangIndexImgPath(getSecLangIndexImgPath());
		clone.setSecLangStdTitle(getSecLangStdTitle());
		clone.setSecLangStdDesc(getSecLangStdDesc());
		clone.setBiChangeTypeCd(getBiChangeTypeCd());
		clone.setBiRegionCd(getBiRegionCd());
		clone.setBiProfileLossImpactCd(getBiProfileLossImpactCd());
		clone.setBiCapExpenseImpactCd(getBiCapExpenseImpactCd());
		clone.setBiImplTimeScaleCd(getBiImplTimeScaleCd());
		clone.setBiComments(getBiComments());
		clone.setBiBrandCd(getBiBrandCd());
		clone.setStdCrossReferences(getStdCrossReferences());
		clone.setAuditBrand(getAuditBrand());
		clone.setGlobalRule(getGlobalRule());
		clone.setAmeaRule(getAmeaRule());
		clone.setAmerRule(getAmerRule());
		clone.setEuroRule(getEuroRule());
		clone.setGcRule(getGcRule());
		clone.setExpires(getExpires());

		return clone;
	}

	@Override
	public int compareTo(StandardsExt standardsExt) {
		StandardsExtPK primaryKey = standardsExt.getPrimaryKey();

		return getPrimaryKey().compareTo(primaryKey);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}

		if (!(obj instanceof StandardsExtClp)) {
			return false;
		}

		StandardsExtClp standardsExt = (StandardsExtClp)obj;

		StandardsExtPK primaryKey = standardsExt.getPrimaryKey();

		if (getPrimaryKey().equals(primaryKey)) {
			return true;
		}
		else {
			return false;
		}
	}

	@Override
	public int hashCode() {
		return getPrimaryKey().hashCode();
	}

	@Override
	public String toString() {
		StringBundler sb = new StringBundler(121);

		sb.append("{stdId=");
		sb.append(getStdId());
		sb.append(", auditLogId=");
		sb.append(getAuditLogId());
		sb.append(", stdManual=");
		sb.append(getStdManual());
		sb.append(", stdCorporateDepartment=");
		sb.append(getStdCorporateDepartment());
		sb.append(", stdBrandCd=");
		sb.append(getStdBrandCd());
		sb.append(", biImpactAssmntId=");
		sb.append(getBiImpactAssmntId());
		sb.append(", stdCountryCd=");
		sb.append(getStdCountryCd());
		sb.append(", stdPrntId=");
		sb.append(getStdPrntId());
		sb.append(", stdOrigStdId=");
		sb.append(getStdOrigStdId());
		sb.append(", stdPubStatCd=");
		sb.append(getStdPubStatCd());
		sb.append(", stdType=");
		sb.append(getStdType());
		sb.append(", stdTitle=");
		sb.append(getStdTitle());
		sb.append(", stdDescription=");
		sb.append(getStdDescription());
		sb.append(", stdBusinessOwner=");
		sb.append(getStdBusinessOwner());
		sb.append(", stdStatus=");
		sb.append(getStdStatus());
		sb.append(", stdAuthor=");
		sb.append(getStdAuthor());
		sb.append(", stdCategory=");
		sb.append(getStdCategory());
		sb.append(", stdGlobal=");
		sb.append(getStdGlobal());
		sb.append(", stdRegionCode=");
		sb.append(getStdRegionCode());
		sb.append(", stdFramework=");
		sb.append(getStdFramework());
		sb.append(", stdChange=");
		sb.append(getStdChange());
		sb.append(", stdCreatedBy=");
		sb.append(getStdCreatedBy());
		sb.append(", stdUpdatedDate=");
		sb.append(getStdUpdatedDate());
		sb.append(", stdImageCount=");
		sb.append(getStdImageCount());
		sb.append(", stdImageTitle=");
		sb.append(getStdImageTitle());
		sb.append(", stdInternalReference=");
		sb.append(getStdInternalReference());
		sb.append(", stdOrderNumber=");
		sb.append(getStdOrderNumber());
		sb.append(", indexId=");
		sb.append(getIndexId());
		sb.append(", indexOrigId=");
		sb.append(getIndexOrigId());
		sb.append(", indexPrntId=");
		sb.append(getIndexPrntId());
		sb.append(", indexTitle=");
		sb.append(getIndexTitle());
		sb.append(", indexLevel=");
		sb.append(getIndexLevel());
		sb.append(", indexLevelSortOrder=");
		sb.append(getIndexLevelSortOrder());
		sb.append(", indexPath=");
		sb.append(getIndexPath());
		sb.append(", auditLogComments=");
		sb.append(getAuditLogComments());
		sb.append(", auditLogTitle=");
		sb.append(getAuditLogTitle());
		sb.append(", auditLogDate=");
		sb.append(getAuditLogDate());
		sb.append(", auditLogStatus=");
		sb.append(getAuditLogStatus());
		sb.append(", auditLogPrevStatus=");
		sb.append(getAuditLogPrevStatus());
		sb.append(", histManualDesc=");
		sb.append(getHistManualDesc());
		sb.append(", secLangIndexTitle=");
		sb.append(getSecLangIndexTitle());
		sb.append(", secLangIndexDesc=");
		sb.append(getSecLangIndexDesc());
		sb.append(", secLangIndexImgPath=");
		sb.append(getSecLangIndexImgPath());
		sb.append(", secLangStdTitle=");
		sb.append(getSecLangStdTitle());
		sb.append(", secLangStdDesc=");
		sb.append(getSecLangStdDesc());
		sb.append(", biChangeTypeCd=");
		sb.append(getBiChangeTypeCd());
		sb.append(", biRegionCd=");
		sb.append(getBiRegionCd());
		sb.append(", biProfileLossImpactCd=");
		sb.append(getBiProfileLossImpactCd());
		sb.append(", biCapExpenseImpactCd=");
		sb.append(getBiCapExpenseImpactCd());
		sb.append(", biImplTimeScaleCd=");
		sb.append(getBiImplTimeScaleCd());
		sb.append(", biComments=");
		sb.append(getBiComments());
		sb.append(", biBrandCd=");
		sb.append(getBiBrandCd());
		sb.append(", stdCrossReferences=");
		sb.append(getStdCrossReferences());
		sb.append(", auditBrand=");
		sb.append(getAuditBrand());
		sb.append(", globalRule=");
		sb.append(getGlobalRule());
		sb.append(", ameaRule=");
		sb.append(getAmeaRule());
		sb.append(", amerRule=");
		sb.append(getAmerRule());
		sb.append(", euroRule=");
		sb.append(getEuroRule());
		sb.append(", gcRule=");
		sb.append(getGcRule());
		sb.append(", expires=");
		sb.append(getExpires());
		sb.append("}");

		return sb.toString();
	}

	@Override
	public String toXmlString() {
		StringBundler sb = new StringBundler(184);

		sb.append("<model><model-name>");
		sb.append("com.ihg.brandstandards.db.model.StandardsExt");
		sb.append("</model-name>");

		sb.append(
			"<column><column-name>stdId</column-name><column-value><![CDATA[");
		sb.append(getStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogId</column-name><column-value><![CDATA[");
		sb.append(getAuditLogId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdManual</column-name><column-value><![CDATA[");
		sb.append(getStdManual());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdCorporateDepartment</column-name><column-value><![CDATA[");
		sb.append(getStdCorporateDepartment());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdBrandCd</column-name><column-value><![CDATA[");
		sb.append(getStdBrandCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biImpactAssmntId</column-name><column-value><![CDATA[");
		sb.append(getBiImpactAssmntId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdCountryCd</column-name><column-value><![CDATA[");
		sb.append(getStdCountryCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdPrntId</column-name><column-value><![CDATA[");
		sb.append(getStdPrntId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdOrigStdId</column-name><column-value><![CDATA[");
		sb.append(getStdOrigStdId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdPubStatCd</column-name><column-value><![CDATA[");
		sb.append(getStdPubStatCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdType</column-name><column-value><![CDATA[");
		sb.append(getStdType());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdTitle</column-name><column-value><![CDATA[");
		sb.append(getStdTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdDescription</column-name><column-value><![CDATA[");
		sb.append(getStdDescription());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdBusinessOwner</column-name><column-value><![CDATA[");
		sb.append(getStdBusinessOwner());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdStatus</column-name><column-value><![CDATA[");
		sb.append(getStdStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdAuthor</column-name><column-value><![CDATA[");
		sb.append(getStdAuthor());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdCategory</column-name><column-value><![CDATA[");
		sb.append(getStdCategory());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdGlobal</column-name><column-value><![CDATA[");
		sb.append(getStdGlobal());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdRegionCode</column-name><column-value><![CDATA[");
		sb.append(getStdRegionCode());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdFramework</column-name><column-value><![CDATA[");
		sb.append(getStdFramework());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdChange</column-name><column-value><![CDATA[");
		sb.append(getStdChange());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdCreatedBy</column-name><column-value><![CDATA[");
		sb.append(getStdCreatedBy());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdUpdatedDate</column-name><column-value><![CDATA[");
		sb.append(getStdUpdatedDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdImageCount</column-name><column-value><![CDATA[");
		sb.append(getStdImageCount());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdImageTitle</column-name><column-value><![CDATA[");
		sb.append(getStdImageTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdInternalReference</column-name><column-value><![CDATA[");
		sb.append(getStdInternalReference());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdOrderNumber</column-name><column-value><![CDATA[");
		sb.append(getStdOrderNumber());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexId</column-name><column-value><![CDATA[");
		sb.append(getIndexId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexOrigId</column-name><column-value><![CDATA[");
		sb.append(getIndexOrigId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexPrntId</column-name><column-value><![CDATA[");
		sb.append(getIndexPrntId());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexTitle</column-name><column-value><![CDATA[");
		sb.append(getIndexTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexLevel</column-name><column-value><![CDATA[");
		sb.append(getIndexLevel());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexLevelSortOrder</column-name><column-value><![CDATA[");
		sb.append(getIndexLevelSortOrder());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>indexPath</column-name><column-value><![CDATA[");
		sb.append(getIndexPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogComments</column-name><column-value><![CDATA[");
		sb.append(getAuditLogComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogTitle</column-name><column-value><![CDATA[");
		sb.append(getAuditLogTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogDate</column-name><column-value><![CDATA[");
		sb.append(getAuditLogDate());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogStatus</column-name><column-value><![CDATA[");
		sb.append(getAuditLogStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditLogPrevStatus</column-name><column-value><![CDATA[");
		sb.append(getAuditLogPrevStatus());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>histManualDesc</column-name><column-value><![CDATA[");
		sb.append(getHistManualDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secLangIndexTitle</column-name><column-value><![CDATA[");
		sb.append(getSecLangIndexTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secLangIndexDesc</column-name><column-value><![CDATA[");
		sb.append(getSecLangIndexDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secLangIndexImgPath</column-name><column-value><![CDATA[");
		sb.append(getSecLangIndexImgPath());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secLangStdTitle</column-name><column-value><![CDATA[");
		sb.append(getSecLangStdTitle());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>secLangStdDesc</column-name><column-value><![CDATA[");
		sb.append(getSecLangStdDesc());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biChangeTypeCd</column-name><column-value><![CDATA[");
		sb.append(getBiChangeTypeCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biRegionCd</column-name><column-value><![CDATA[");
		sb.append(getBiRegionCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biProfileLossImpactCd</column-name><column-value><![CDATA[");
		sb.append(getBiProfileLossImpactCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biCapExpenseImpactCd</column-name><column-value><![CDATA[");
		sb.append(getBiCapExpenseImpactCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biImplTimeScaleCd</column-name><column-value><![CDATA[");
		sb.append(getBiImplTimeScaleCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biComments</column-name><column-value><![CDATA[");
		sb.append(getBiComments());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>biBrandCd</column-name><column-value><![CDATA[");
		sb.append(getBiBrandCd());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>stdCrossReferences</column-name><column-value><![CDATA[");
		sb.append(getStdCrossReferences());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>auditBrand</column-name><column-value><![CDATA[");
		sb.append(getAuditBrand());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>globalRule</column-name><column-value><![CDATA[");
		sb.append(getGlobalRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>ameaRule</column-name><column-value><![CDATA[");
		sb.append(getAmeaRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>amerRule</column-name><column-value><![CDATA[");
		sb.append(getAmerRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>euroRule</column-name><column-value><![CDATA[");
		sb.append(getEuroRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>gcRule</column-name><column-value><![CDATA[");
		sb.append(getGcRule());
		sb.append("]]></column-value></column>");
		sb.append(
			"<column><column-name>expires</column-name><column-value><![CDATA[");
		sb.append(getExpires());
		sb.append("]]></column-value></column>");

		sb.append("</model>");

		return sb.toString();
	}

	private long _stdId;
	private long _auditLogId;
	private String _stdManual;
	private String _stdCorporateDepartment;
	private String _stdBrandCd;
	private long _biImpactAssmntId;
	private String _stdCountryCd;
	private long _stdPrntId;
	private long _stdOrigStdId;
	private String _stdPubStatCd;
	private String _stdType;
	private String _stdTitle;
	private String _stdDescription;
	private String _stdBusinessOwner;
	private String _stdStatus;
	private String _stdAuthor;
	private String _stdCategory;
	private String _stdGlobal;
	private String _stdRegionCode;
	private String _stdFramework;
	private String _stdChange;
	private String _stdCreatedBy;
	private Date _stdUpdatedDate;
	private long _stdImageCount;
	private String _stdImageTitle;
	private String _stdInternalReference;
	private long _stdOrderNumber;
	private long _indexId;
	private long _indexOrigId;
	private long _indexPrntId;
	private String _indexTitle;
	private long _indexLevel;
	private long _indexLevelSortOrder;
	private String _indexPath;
	private String _auditLogComments;
	private String _auditLogTitle;
	private Date _auditLogDate;
	private String _auditLogStatus;
	private String _auditLogPrevStatus;
	private String _histManualDesc;
	private String _secLangIndexTitle;
	private String _secLangIndexDesc;
	private String _secLangIndexImgPath;
	private String _secLangStdTitle;
	private String _secLangStdDesc;
	private String _biChangeTypeCd;
	private String _biRegionCd;
	private String _biProfileLossImpactCd;
	private String _biCapExpenseImpactCd;
	private String _biImplTimeScaleCd;
	private String _biComments;
	private String _biBrandCd;
	private String _stdCrossReferences;
	private String _auditBrand;
	private long _globalRule;
	private long _ameaRule;
	private long _amerRule;
	private long _euroRule;
	private long _gcRule;
	private String _expires;
	private BaseModel<?> _standardsExtRemoteModel;
}