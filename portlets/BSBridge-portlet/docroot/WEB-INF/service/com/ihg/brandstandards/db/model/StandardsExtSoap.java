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

import com.ihg.brandstandards.db.service.persistence.StandardsExtPK;

import java.io.Serializable;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * This class is used by SOAP remote services.
 *
 * @author Mummanedi
 * @generated
 */
public class StandardsExtSoap implements Serializable {
	public static StandardsExtSoap toSoapModel(StandardsExt model) {
		StandardsExtSoap soapModel = new StandardsExtSoap();

		soapModel.setStdId(model.getStdId());
		soapModel.setAuditLogId(model.getAuditLogId());
		soapModel.setStdManual(model.getStdManual());
		soapModel.setStdCorporateDepartment(model.getStdCorporateDepartment());
		soapModel.setStdBrandCd(model.getStdBrandCd());
		soapModel.setBiImpactAssmntId(model.getBiImpactAssmntId());
		soapModel.setStdCountryCd(model.getStdCountryCd());
		soapModel.setStdPrntId(model.getStdPrntId());
		soapModel.setStdOrigStdId(model.getStdOrigStdId());
		soapModel.setStdPubStatCd(model.getStdPubStatCd());
		soapModel.setStdType(model.getStdType());
		soapModel.setStdTitle(model.getStdTitle());
		soapModel.setStdDescription(model.getStdDescription());
		soapModel.setStdBusinessOwner(model.getStdBusinessOwner());
		soapModel.setStdStatus(model.getStdStatus());
		soapModel.setStdAuthor(model.getStdAuthor());
		soapModel.setStdCategory(model.getStdCategory());
		soapModel.setStdGlobal(model.getStdGlobal());
		soapModel.setStdRegionCode(model.getStdRegionCode());
		soapModel.setStdFramework(model.getStdFramework());
		soapModel.setStdChange(model.getStdChange());
		soapModel.setStdCreatedBy(model.getStdCreatedBy());
		soapModel.setStdUpdatedDate(model.getStdUpdatedDate());
		soapModel.setStdImageCount(model.getStdImageCount());
		soapModel.setStdImageTitle(model.getStdImageTitle());
		soapModel.setStdInternalReference(model.getStdInternalReference());
		soapModel.setStdOrderNumber(model.getStdOrderNumber());
		soapModel.setIndexId(model.getIndexId());
		soapModel.setIndexOrigId(model.getIndexOrigId());
		soapModel.setIndexPrntId(model.getIndexPrntId());
		soapModel.setIndexTitle(model.getIndexTitle());
		soapModel.setIndexLevel(model.getIndexLevel());
		soapModel.setIndexLevelSortOrder(model.getIndexLevelSortOrder());
		soapModel.setIndexPath(model.getIndexPath());
		soapModel.setAuditLogComments(model.getAuditLogComments());
		soapModel.setAuditLogTitle(model.getAuditLogTitle());
		soapModel.setAuditLogDate(model.getAuditLogDate());
		soapModel.setAuditLogStatus(model.getAuditLogStatus());
		soapModel.setAuditLogPrevStatus(model.getAuditLogPrevStatus());
		soapModel.setHistManualDesc(model.getHistManualDesc());
		soapModel.setSecLangIndexTitle(model.getSecLangIndexTitle());
		soapModel.setSecLangIndexDesc(model.getSecLangIndexDesc());
		soapModel.setSecLangIndexImgPath(model.getSecLangIndexImgPath());
		soapModel.setSecLangStdTitle(model.getSecLangStdTitle());
		soapModel.setSecLangStdDesc(model.getSecLangStdDesc());
		soapModel.setBiChangeTypeCd(model.getBiChangeTypeCd());
		soapModel.setBiRegionCd(model.getBiRegionCd());
		soapModel.setBiProfileLossImpactCd(model.getBiProfileLossImpactCd());
		soapModel.setBiCapExpenseImpactCd(model.getBiCapExpenseImpactCd());
		soapModel.setBiImplTimeScaleCd(model.getBiImplTimeScaleCd());
		soapModel.setBiComments(model.getBiComments());
		soapModel.setBiBrandCd(model.getBiBrandCd());
		soapModel.setStdCrossReferences(model.getStdCrossReferences());
		soapModel.setAuditBrand(model.getAuditBrand());
		soapModel.setGlobalRule(model.getGlobalRule());
		soapModel.setAmeaRule(model.getAmeaRule());
		soapModel.setAmerRule(model.getAmerRule());
		soapModel.setEuroRule(model.getEuroRule());
		soapModel.setGcRule(model.getGcRule());
		soapModel.setExpires(model.getExpires());

		return soapModel;
	}

	public static StandardsExtSoap[] toSoapModels(StandardsExt[] models) {
		StandardsExtSoap[] soapModels = new StandardsExtSoap[models.length];

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModel(models[i]);
		}

		return soapModels;
	}

	public static StandardsExtSoap[][] toSoapModels(StandardsExt[][] models) {
		StandardsExtSoap[][] soapModels = null;

		if (models.length > 0) {
			soapModels = new StandardsExtSoap[models.length][models[0].length];
		}
		else {
			soapModels = new StandardsExtSoap[0][0];
		}

		for (int i = 0; i < models.length; i++) {
			soapModels[i] = toSoapModels(models[i]);
		}

		return soapModels;
	}

	public static StandardsExtSoap[] toSoapModels(List<StandardsExt> models) {
		List<StandardsExtSoap> soapModels = new ArrayList<StandardsExtSoap>(models.size());

		for (StandardsExt model : models) {
			soapModels.add(toSoapModel(model));
		}

		return soapModels.toArray(new StandardsExtSoap[soapModels.size()]);
	}

	public StandardsExtSoap() {
	}

	public StandardsExtPK getPrimaryKey() {
		return new StandardsExtPK(_stdId, _auditLogId, _stdManual,
			_stdCorporateDepartment, _stdBrandCd, _biImpactAssmntId,
			_stdCountryCd);
	}

	public void setPrimaryKey(StandardsExtPK pk) {
		setStdId(pk.stdId);
		setAuditLogId(pk.auditLogId);
		setStdManual(pk.stdManual);
		setStdCorporateDepartment(pk.stdCorporateDepartment);
		setStdBrandCd(pk.stdBrandCd);
		setBiImpactAssmntId(pk.biImpactAssmntId);
		setStdCountryCd(pk.stdCountryCd);
	}

	public long getStdId() {
		return _stdId;
	}

	public void setStdId(long stdId) {
		_stdId = stdId;
	}

	public long getAuditLogId() {
		return _auditLogId;
	}

	public void setAuditLogId(long auditLogId) {
		_auditLogId = auditLogId;
	}

	public String getStdManual() {
		return _stdManual;
	}

	public void setStdManual(String stdManual) {
		_stdManual = stdManual;
	}

	public String getStdCorporateDepartment() {
		return _stdCorporateDepartment;
	}

	public void setStdCorporateDepartment(String stdCorporateDepartment) {
		_stdCorporateDepartment = stdCorporateDepartment;
	}

	public String getStdBrandCd() {
		return _stdBrandCd;
	}

	public void setStdBrandCd(String stdBrandCd) {
		_stdBrandCd = stdBrandCd;
	}

	public long getBiImpactAssmntId() {
		return _biImpactAssmntId;
	}

	public void setBiImpactAssmntId(long biImpactAssmntId) {
		_biImpactAssmntId = biImpactAssmntId;
	}

	public String getStdCountryCd() {
		return _stdCountryCd;
	}

	public void setStdCountryCd(String stdCountryCd) {
		_stdCountryCd = stdCountryCd;
	}

	public long getStdPrntId() {
		return _stdPrntId;
	}

	public void setStdPrntId(long stdPrntId) {
		_stdPrntId = stdPrntId;
	}

	public long getStdOrigStdId() {
		return _stdOrigStdId;
	}

	public void setStdOrigStdId(long stdOrigStdId) {
		_stdOrigStdId = stdOrigStdId;
	}

	public String getStdPubStatCd() {
		return _stdPubStatCd;
	}

	public void setStdPubStatCd(String stdPubStatCd) {
		_stdPubStatCd = stdPubStatCd;
	}

	public String getStdType() {
		return _stdType;
	}

	public void setStdType(String stdType) {
		_stdType = stdType;
	}

	public String getStdTitle() {
		return _stdTitle;
	}

	public void setStdTitle(String stdTitle) {
		_stdTitle = stdTitle;
	}

	public String getStdDescription() {
		return _stdDescription;
	}

	public void setStdDescription(String stdDescription) {
		_stdDescription = stdDescription;
	}

	public String getStdBusinessOwner() {
		return _stdBusinessOwner;
	}

	public void setStdBusinessOwner(String stdBusinessOwner) {
		_stdBusinessOwner = stdBusinessOwner;
	}

	public String getStdStatus() {
		return _stdStatus;
	}

	public void setStdStatus(String stdStatus) {
		_stdStatus = stdStatus;
	}

	public String getStdAuthor() {
		return _stdAuthor;
	}

	public void setStdAuthor(String stdAuthor) {
		_stdAuthor = stdAuthor;
	}

	public String getStdCategory() {
		return _stdCategory;
	}

	public void setStdCategory(String stdCategory) {
		_stdCategory = stdCategory;
	}

	public String getStdGlobal() {
		return _stdGlobal;
	}

	public void setStdGlobal(String stdGlobal) {
		_stdGlobal = stdGlobal;
	}

	public String getStdRegionCode() {
		return _stdRegionCode;
	}

	public void setStdRegionCode(String stdRegionCode) {
		_stdRegionCode = stdRegionCode;
	}

	public String getStdFramework() {
		return _stdFramework;
	}

	public void setStdFramework(String stdFramework) {
		_stdFramework = stdFramework;
	}

	public String getStdChange() {
		return _stdChange;
	}

	public void setStdChange(String stdChange) {
		_stdChange = stdChange;
	}

	public String getStdCreatedBy() {
		return _stdCreatedBy;
	}

	public void setStdCreatedBy(String stdCreatedBy) {
		_stdCreatedBy = stdCreatedBy;
	}

	public Date getStdUpdatedDate() {
		return _stdUpdatedDate;
	}

	public void setStdUpdatedDate(Date stdUpdatedDate) {
		_stdUpdatedDate = stdUpdatedDate;
	}

	public long getStdImageCount() {
		return _stdImageCount;
	}

	public void setStdImageCount(long stdImageCount) {
		_stdImageCount = stdImageCount;
	}

	public String getStdImageTitle() {
		return _stdImageTitle;
	}

	public void setStdImageTitle(String stdImageTitle) {
		_stdImageTitle = stdImageTitle;
	}

	public String getStdInternalReference() {
		return _stdInternalReference;
	}

	public void setStdInternalReference(String stdInternalReference) {
		_stdInternalReference = stdInternalReference;
	}

	public long getStdOrderNumber() {
		return _stdOrderNumber;
	}

	public void setStdOrderNumber(long stdOrderNumber) {
		_stdOrderNumber = stdOrderNumber;
	}

	public long getIndexId() {
		return _indexId;
	}

	public void setIndexId(long indexId) {
		_indexId = indexId;
	}

	public long getIndexOrigId() {
		return _indexOrigId;
	}

	public void setIndexOrigId(long indexOrigId) {
		_indexOrigId = indexOrigId;
	}

	public long getIndexPrntId() {
		return _indexPrntId;
	}

	public void setIndexPrntId(long indexPrntId) {
		_indexPrntId = indexPrntId;
	}

	public String getIndexTitle() {
		return _indexTitle;
	}

	public void setIndexTitle(String indexTitle) {
		_indexTitle = indexTitle;
	}

	public long getIndexLevel() {
		return _indexLevel;
	}

	public void setIndexLevel(long indexLevel) {
		_indexLevel = indexLevel;
	}

	public long getIndexLevelSortOrder() {
		return _indexLevelSortOrder;
	}

	public void setIndexLevelSortOrder(long indexLevelSortOrder) {
		_indexLevelSortOrder = indexLevelSortOrder;
	}

	public String getIndexPath() {
		return _indexPath;
	}

	public void setIndexPath(String indexPath) {
		_indexPath = indexPath;
	}

	public String getAuditLogComments() {
		return _auditLogComments;
	}

	public void setAuditLogComments(String auditLogComments) {
		_auditLogComments = auditLogComments;
	}

	public String getAuditLogTitle() {
		return _auditLogTitle;
	}

	public void setAuditLogTitle(String auditLogTitle) {
		_auditLogTitle = auditLogTitle;
	}

	public Date getAuditLogDate() {
		return _auditLogDate;
	}

	public void setAuditLogDate(Date auditLogDate) {
		_auditLogDate = auditLogDate;
	}

	public String getAuditLogStatus() {
		return _auditLogStatus;
	}

	public void setAuditLogStatus(String auditLogStatus) {
		_auditLogStatus = auditLogStatus;
	}

	public String getAuditLogPrevStatus() {
		return _auditLogPrevStatus;
	}

	public void setAuditLogPrevStatus(String auditLogPrevStatus) {
		_auditLogPrevStatus = auditLogPrevStatus;
	}

	public String getHistManualDesc() {
		return _histManualDesc;
	}

	public void setHistManualDesc(String histManualDesc) {
		_histManualDesc = histManualDesc;
	}

	public String getSecLangIndexTitle() {
		return _secLangIndexTitle;
	}

	public void setSecLangIndexTitle(String secLangIndexTitle) {
		_secLangIndexTitle = secLangIndexTitle;
	}

	public String getSecLangIndexDesc() {
		return _secLangIndexDesc;
	}

	public void setSecLangIndexDesc(String secLangIndexDesc) {
		_secLangIndexDesc = secLangIndexDesc;
	}

	public String getSecLangIndexImgPath() {
		return _secLangIndexImgPath;
	}

	public void setSecLangIndexImgPath(String secLangIndexImgPath) {
		_secLangIndexImgPath = secLangIndexImgPath;
	}

	public String getSecLangStdTitle() {
		return _secLangStdTitle;
	}

	public void setSecLangStdTitle(String secLangStdTitle) {
		_secLangStdTitle = secLangStdTitle;
	}

	public String getSecLangStdDesc() {
		return _secLangStdDesc;
	}

	public void setSecLangStdDesc(String secLangStdDesc) {
		_secLangStdDesc = secLangStdDesc;
	}

	public String getBiChangeTypeCd() {
		return _biChangeTypeCd;
	}

	public void setBiChangeTypeCd(String biChangeTypeCd) {
		_biChangeTypeCd = biChangeTypeCd;
	}

	public String getBiRegionCd() {
		return _biRegionCd;
	}

	public void setBiRegionCd(String biRegionCd) {
		_biRegionCd = biRegionCd;
	}

	public String getBiProfileLossImpactCd() {
		return _biProfileLossImpactCd;
	}

	public void setBiProfileLossImpactCd(String biProfileLossImpactCd) {
		_biProfileLossImpactCd = biProfileLossImpactCd;
	}

	public String getBiCapExpenseImpactCd() {
		return _biCapExpenseImpactCd;
	}

	public void setBiCapExpenseImpactCd(String biCapExpenseImpactCd) {
		_biCapExpenseImpactCd = biCapExpenseImpactCd;
	}

	public String getBiImplTimeScaleCd() {
		return _biImplTimeScaleCd;
	}

	public void setBiImplTimeScaleCd(String biImplTimeScaleCd) {
		_biImplTimeScaleCd = biImplTimeScaleCd;
	}

	public String getBiComments() {
		return _biComments;
	}

	public void setBiComments(String biComments) {
		_biComments = biComments;
	}

	public String getBiBrandCd() {
		return _biBrandCd;
	}

	public void setBiBrandCd(String biBrandCd) {
		_biBrandCd = biBrandCd;
	}

	public String getStdCrossReferences() {
		return _stdCrossReferences;
	}

	public void setStdCrossReferences(String stdCrossReferences) {
		_stdCrossReferences = stdCrossReferences;
	}

	public String getAuditBrand() {
		return _auditBrand;
	}

	public void setAuditBrand(String auditBrand) {
		_auditBrand = auditBrand;
	}

	public long getGlobalRule() {
		return _globalRule;
	}

	public void setGlobalRule(long globalRule) {
		_globalRule = globalRule;
	}

	public long getAmeaRule() {
		return _ameaRule;
	}

	public void setAmeaRule(long ameaRule) {
		_ameaRule = ameaRule;
	}

	public long getAmerRule() {
		return _amerRule;
	}

	public void setAmerRule(long amerRule) {
		_amerRule = amerRule;
	}

	public long getEuroRule() {
		return _euroRule;
	}

	public void setEuroRule(long euroRule) {
		_euroRule = euroRule;
	}

	public long getGcRule() {
		return _gcRule;
	}

	public void setGcRule(long gcRule) {
		_gcRule = gcRule;
	}

	public String getExpires() {
		return _expires;
	}

	public void setExpires(String expires) {
		_expires = expires;
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
}