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

package com.ihg.brandstandards.db.service;

import com.ihg.brandstandards.db.model.AttachmentsStandardsClp;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountryClp;
import com.ihg.brandstandards.db.model.BrandTaxonomyClp;
import com.ihg.brandstandards.db.model.BrandTaxonomyTranslateClp;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishClp;
import com.ihg.brandstandards.db.model.BridgeGlobalPublishCountryClp;
import com.ihg.brandstandards.db.model.BridgeProgressCategoryClp;
import com.ihg.brandstandards.db.model.BridgeProgressDiscrepancyClp;
import com.ihg.brandstandards.db.model.BridgeProgressSubCategoryClp;
import com.ihg.brandstandards.db.model.BridgePublishClp;
import com.ihg.brandstandards.db.model.BridgePublishCountryClp;
import com.ihg.brandstandards.db.model.BridgePublishCountryStateExClp;
import com.ihg.brandstandards.db.model.BridgePublishImportClp;
import com.ihg.brandstandards.db.model.BridgePublishLangClp;
import com.ihg.brandstandards.db.model.BridgePublishPreviewClp;
import com.ihg.brandstandards.db.model.BridgePublishStateExClp;
import com.ihg.brandstandards.db.model.BridgePublishStatusClp;
import com.ihg.brandstandards.db.model.BusImpactAssmtClp;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandardsClp;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandardsClp;
import com.ihg.brandstandards.db.model.ChainStandardsClp;
import com.ihg.brandstandards.db.model.CountryStandardsClp;
import com.ihg.brandstandards.db.model.CountryStandardsExtClp;
import com.ihg.brandstandards.db.model.DepartmentClp;
import com.ihg.brandstandards.db.model.ErrNotificationClp;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsClp;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountryClp;
import com.ihg.brandstandards.db.model.FlagCategoryClp;
import com.ihg.brandstandards.db.model.FlagStandardsClp;
import com.ihg.brandstandards.db.model.GEMCategoryClp;
import com.ihg.brandstandards.db.model.GEMChainMeasurementClp;
import com.ihg.brandstandards.db.model.GEMCodeClp;
import com.ihg.brandstandards.db.model.GEMGeneratedReportClp;
import com.ihg.brandstandards.db.model.GEMGeneratedReportValClp;
import com.ihg.brandstandards.db.model.GEMManagementBucketClp;
import com.ihg.brandstandards.db.model.GEMManagementIdClp;
import com.ihg.brandstandards.db.model.GEMMeasurementBucketChainClp;
import com.ihg.brandstandards.db.model.GEMMeasurementClp;
import com.ihg.brandstandards.db.model.GEMMeasurementFormulaClp;
import com.ihg.brandstandards.db.model.GEMMeasurementFormulaValueClp;
import com.ihg.brandstandards.db.model.GEMMeasurementTypeClp;
import com.ihg.brandstandards.db.model.GEMQlReportClp;
import com.ihg.brandstandards.db.model.GEMRoleClp;
import com.ihg.brandstandards.db.model.GEMScoringValueClp;
import com.ihg.brandstandards.db.model.GEMSeverityClp;
import com.ihg.brandstandards.db.model.GEMStdCategoryClp;
import com.ihg.brandstandards.db.model.GEMTemplateCategoryClp;
import com.ihg.brandstandards.db.model.GEMTemplateClp;
import com.ihg.brandstandards.db.model.GEMTemplateColumnClp;
import com.ihg.brandstandards.db.model.GEMTemplateReferenceClp;
import com.ihg.brandstandards.db.model.GEMTemplateValuesClp;
import com.ihg.brandstandards.db.model.GEMTriggerClp;
import com.ihg.brandstandards.db.model.GEMUniqueGroupClp;
import com.ihg.brandstandards.db.model.GEMUniqueGroupCountryClp;
import com.ihg.brandstandards.db.model.GEMUniqueGroupStandardClp;
import com.ihg.brandstandards.db.model.GlossaryClp;
import com.ihg.brandstandards.db.model.GlossaryExtClp;
import com.ihg.brandstandards.db.model.GlossaryRegionNavClp;
import com.ihg.brandstandards.db.model.GlossaryTranslateClp;
import com.ihg.brandstandards.db.model.HistManualAttachmentClp;
import com.ihg.brandstandards.db.model.HistManualChainClp;
import com.ihg.brandstandards.db.model.HistManualRegionClp;
import com.ihg.brandstandards.db.model.HistManualsClp;
import com.ihg.brandstandards.db.model.ImageClp;
import com.ihg.brandstandards.db.model.JobQueueClp;
import com.ihg.brandstandards.db.model.MustPublishClp;
import com.ihg.brandstandards.db.model.PublicationClp;
import com.ihg.brandstandards.db.model.PublishCountryStandardClp;
import com.ihg.brandstandards.db.model.PublishDeptClp;
import com.ihg.brandstandards.db.model.PublishExtStdClp;
import com.ihg.brandstandards.db.model.PublishParmClp;
import com.ihg.brandstandards.db.model.PublishQueueClp;
import com.ihg.brandstandards.db.model.PublishStandardsExtClp;
import com.ihg.brandstandards.db.model.PublishStdClp;
import com.ihg.brandstandards.db.model.PublishTaxonomyClp;
import com.ihg.brandstandards.db.model.PublishTaxonomyExtClp;
import com.ihg.brandstandards.db.model.PublishedPdfListClp;
import com.ihg.brandstandards.db.model.SpecialWordDictionaryClp;
import com.ihg.brandstandards.db.model.SpreadSheetAttributeUpdateClp;
import com.ihg.brandstandards.db.model.StandardTagClp;
import com.ihg.brandstandards.db.model.StandardsAuthorsClp;
import com.ihg.brandstandards.db.model.StandardsChainImagesClp;
import com.ihg.brandstandards.db.model.StandardsClp;
import com.ihg.brandstandards.db.model.StandardsComplianceClp;
import com.ihg.brandstandards.db.model.StandardsComplianceExtClp;
import com.ihg.brandstandards.db.model.StandardsCountryChainClp;
import com.ihg.brandstandards.db.model.StandardsCountryClp;
import com.ihg.brandstandards.db.model.StandardsCountryExtClp;
import com.ihg.brandstandards.db.model.StandardsCountryImagesClp;
import com.ihg.brandstandards.db.model.StandardsCrossReferenceClp;
import com.ihg.brandstandards.db.model.StandardsDisplayOrderClp;
import com.ihg.brandstandards.db.model.StandardsDisplayOrderExtClp;
import com.ihg.brandstandards.db.model.StandardsExtClp;
import com.ihg.brandstandards.db.model.StandardsHistoricalManualClp;
import com.ihg.brandstandards.db.model.StandardsImagesClp;
import com.ihg.brandstandards.db.model.StandardsLocaleClp;
import com.ihg.brandstandards.db.model.StandardsRegionChainClp;
import com.ihg.brandstandards.db.model.StandardsRegionClp;
import com.ihg.brandstandards.db.model.StandardsRegionLocaleClp;
import com.ihg.brandstandards.db.model.StandardsStatusClp;
import com.ihg.brandstandards.db.model.StandardsTranslateClp;
import com.ihg.brandstandards.db.model.TaxonomyClp;
import com.ihg.brandstandards.db.model.TaxonomyExtClp;
import com.ihg.brandstandards.db.model.TaxonomyStandardsClp;
import com.ihg.brandstandards.db.model.TaxonomyTranslateClp;
import com.ihg.brandstandards.db.model.TreeXMLClp;
import com.ihg.brandstandards.db.model.UIElementClp;
import com.ihg.brandstandards.db.model.UIElementTranslateClp;
import com.ihg.brandstandards.db.model.UniqueGroupClp;
import com.ihg.brandstandards.db.model.UniqueGroupCountryClp;
import com.ihg.brandstandards.db.model.UniqueGroupStandardClp;
import com.ihg.brandstandards.db.model.UserPreferenceClp;
import com.ihg.brandstandards.db.model.UserSearchCriteriaClp;
import com.ihg.brandstandards.db.model.WorkflowClp;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayInputStream;
import com.liferay.portal.kernel.io.unsync.UnsyncByteArrayOutputStream;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ClassLoaderObjectInputStream;
import com.liferay.portal.kernel.util.PropsUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.model.BaseModel;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

import java.lang.reflect.Method;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Mummanedi
 */
public class ClpSerializer {
	public static String getServletContextName() {
		if (Validator.isNotNull(_servletContextName)) {
			return _servletContextName;
		}

		synchronized (ClpSerializer.class) {
			if (Validator.isNotNull(_servletContextName)) {
				return _servletContextName;
			}

			try {
				ClassLoader classLoader = ClpSerializer.class.getClassLoader();

				Class<?> portletPropsClass = classLoader.loadClass(
						"com.liferay.util.portlet.PortletProps");

				Method getMethod = portletPropsClass.getMethod("get",
						new Class<?>[] { String.class });

				String portletPropsServletContextName = (String)getMethod.invoke(null,
						"BSBridge-portlet-deployment-context");

				if (Validator.isNotNull(portletPropsServletContextName)) {
					_servletContextName = portletPropsServletContextName;
				}
			}
			catch (Throwable t) {
				if (_log.isInfoEnabled()) {
					_log.info(
						"Unable to locate deployment context from portlet properties");
				}
			}

			if (Validator.isNull(_servletContextName)) {
				try {
					String propsUtilServletContextName = PropsUtil.get(
							"BSBridge-portlet-deployment-context");

					if (Validator.isNotNull(propsUtilServletContextName)) {
						_servletContextName = propsUtilServletContextName;
					}
				}
				catch (Throwable t) {
					if (_log.isInfoEnabled()) {
						_log.info(
							"Unable to locate deployment context from portal properties");
					}
				}
			}

			if (Validator.isNull(_servletContextName)) {
				_servletContextName = "BSBridge-portlet";
			}

			return _servletContextName;
		}
	}

	public static Object translateInput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(AttachmentsStandardsClp.class.getName())) {
			return translateInputAttachmentsStandards(oldModel);
		}

		if (oldModelClassName.equals(
					AttachmentsStandardsCountryClp.class.getName())) {
			return translateInputAttachmentsStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(BrandTaxonomyClp.class.getName())) {
			return translateInputBrandTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(BrandTaxonomyTranslateClp.class.getName())) {
			return translateInputBrandTaxonomyTranslate(oldModel);
		}

		if (oldModelClassName.equals(BridgeGlobalPublishClp.class.getName())) {
			return translateInputBridgeGlobalPublish(oldModel);
		}

		if (oldModelClassName.equals(
					BridgeGlobalPublishCountryClp.class.getName())) {
			return translateInputBridgeGlobalPublishCountry(oldModel);
		}

		if (oldModelClassName.equals(BridgeProgressCategoryClp.class.getName())) {
			return translateInputBridgeProgressCategory(oldModel);
		}

		if (oldModelClassName.equals(
					BridgeProgressDiscrepancyClp.class.getName())) {
			return translateInputBridgeProgressDiscrepancy(oldModel);
		}

		if (oldModelClassName.equals(
					BridgeProgressSubCategoryClp.class.getName())) {
			return translateInputBridgeProgressSubCategory(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishClp.class.getName())) {
			return translateInputBridgePublish(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishCountryClp.class.getName())) {
			return translateInputBridgePublishCountry(oldModel);
		}

		if (oldModelClassName.equals(
					BridgePublishCountryStateExClp.class.getName())) {
			return translateInputBridgePublishCountryStateEx(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishImportClp.class.getName())) {
			return translateInputBridgePublishImport(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishLangClp.class.getName())) {
			return translateInputBridgePublishLang(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishPreviewClp.class.getName())) {
			return translateInputBridgePublishPreview(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishStateExClp.class.getName())) {
			return translateInputBridgePublishStateEx(oldModel);
		}

		if (oldModelClassName.equals(BridgePublishStatusClp.class.getName())) {
			return translateInputBridgePublishStatus(oldModel);
		}

		if (oldModelClassName.equals(BusImpactAssmtClp.class.getName())) {
			return translateInputBusImpactAssmt(oldModel);
		}

		if (oldModelClassName.equals(
					ChainAttachmentsStandardsClp.class.getName())) {
			return translateInputChainAttachmentsStandards(oldModel);
		}

		if (oldModelClassName.equals(
					ChainExternalLinkStandardsClp.class.getName())) {
			return translateInputChainExternalLinkStandards(oldModel);
		}

		if (oldModelClassName.equals(ChainStandardsClp.class.getName())) {
			return translateInputChainStandards(oldModel);
		}

		if (oldModelClassName.equals(CountryStandardsClp.class.getName())) {
			return translateInputCountryStandards(oldModel);
		}

		if (oldModelClassName.equals(CountryStandardsExtClp.class.getName())) {
			return translateInputCountryStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(DepartmentClp.class.getName())) {
			return translateInputDepartment(oldModel);
		}

		if (oldModelClassName.equals(ErrNotificationClp.class.getName())) {
			return translateInputErrNotification(oldModel);
		}

		if (oldModelClassName.equals(ExternalLinkStandardsClp.class.getName())) {
			return translateInputExternalLinkStandards(oldModel);
		}

		if (oldModelClassName.equals(
					ExternalLinkStandardsCountryClp.class.getName())) {
			return translateInputExternalLinkStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(FlagCategoryClp.class.getName())) {
			return translateInputFlagCategory(oldModel);
		}

		if (oldModelClassName.equals(FlagStandardsClp.class.getName())) {
			return translateInputFlagStandards(oldModel);
		}

		if (oldModelClassName.equals(GEMCategoryClp.class.getName())) {
			return translateInputGEMCategory(oldModel);
		}

		if (oldModelClassName.equals(GEMChainMeasurementClp.class.getName())) {
			return translateInputGEMChainMeasurement(oldModel);
		}

		if (oldModelClassName.equals(GEMCodeClp.class.getName())) {
			return translateInputGEMCode(oldModel);
		}

		if (oldModelClassName.equals(GEMGeneratedReportClp.class.getName())) {
			return translateInputGEMGeneratedReport(oldModel);
		}

		if (oldModelClassName.equals(GEMGeneratedReportValClp.class.getName())) {
			return translateInputGEMGeneratedReportVal(oldModel);
		}

		if (oldModelClassName.equals(GEMManagementBucketClp.class.getName())) {
			return translateInputGEMManagementBucket(oldModel);
		}

		if (oldModelClassName.equals(GEMManagementIdClp.class.getName())) {
			return translateInputGEMManagementId(oldModel);
		}

		if (oldModelClassName.equals(GEMMeasurementClp.class.getName())) {
			return translateInputGEMMeasurement(oldModel);
		}

		if (oldModelClassName.equals(
					GEMMeasurementBucketChainClp.class.getName())) {
			return translateInputGEMMeasurementBucketChain(oldModel);
		}

		if (oldModelClassName.equals(GEMMeasurementFormulaClp.class.getName())) {
			return translateInputGEMMeasurementFormula(oldModel);
		}

		if (oldModelClassName.equals(
					GEMMeasurementFormulaValueClp.class.getName())) {
			return translateInputGEMMeasurementFormulaValue(oldModel);
		}

		if (oldModelClassName.equals(GEMMeasurementTypeClp.class.getName())) {
			return translateInputGEMMeasurementType(oldModel);
		}

		if (oldModelClassName.equals(GEMQlReportClp.class.getName())) {
			return translateInputGEMQlReport(oldModel);
		}

		if (oldModelClassName.equals(GEMRoleClp.class.getName())) {
			return translateInputGEMRole(oldModel);
		}

		if (oldModelClassName.equals(GEMScoringValueClp.class.getName())) {
			return translateInputGEMScoringValue(oldModel);
		}

		if (oldModelClassName.equals(GEMSeverityClp.class.getName())) {
			return translateInputGEMSeverity(oldModel);
		}

		if (oldModelClassName.equals(GEMStdCategoryClp.class.getName())) {
			return translateInputGEMStdCategory(oldModel);
		}

		if (oldModelClassName.equals(GEMTemplateClp.class.getName())) {
			return translateInputGEMTemplate(oldModel);
		}

		if (oldModelClassName.equals(GEMTemplateCategoryClp.class.getName())) {
			return translateInputGEMTemplateCategory(oldModel);
		}

		if (oldModelClassName.equals(GEMTemplateColumnClp.class.getName())) {
			return translateInputGEMTemplateColumn(oldModel);
		}

		if (oldModelClassName.equals(GEMTemplateReferenceClp.class.getName())) {
			return translateInputGEMTemplateReference(oldModel);
		}

		if (oldModelClassName.equals(GEMTemplateValuesClp.class.getName())) {
			return translateInputGEMTemplateValues(oldModel);
		}

		if (oldModelClassName.equals(GEMTriggerClp.class.getName())) {
			return translateInputGEMTrigger(oldModel);
		}

		if (oldModelClassName.equals(GEMUniqueGroupClp.class.getName())) {
			return translateInputGEMUniqueGroup(oldModel);
		}

		if (oldModelClassName.equals(GEMUniqueGroupCountryClp.class.getName())) {
			return translateInputGEMUniqueGroupCountry(oldModel);
		}

		if (oldModelClassName.equals(GEMUniqueGroupStandardClp.class.getName())) {
			return translateInputGEMUniqueGroupStandard(oldModel);
		}

		if (oldModelClassName.equals(GlossaryClp.class.getName())) {
			return translateInputGlossary(oldModel);
		}

		if (oldModelClassName.equals(GlossaryExtClp.class.getName())) {
			return translateInputGlossaryExt(oldModel);
		}

		if (oldModelClassName.equals(GlossaryRegionNavClp.class.getName())) {
			return translateInputGlossaryRegionNav(oldModel);
		}

		if (oldModelClassName.equals(GlossaryTranslateClp.class.getName())) {
			return translateInputGlossaryTranslate(oldModel);
		}

		if (oldModelClassName.equals(HistManualAttachmentClp.class.getName())) {
			return translateInputHistManualAttachment(oldModel);
		}

		if (oldModelClassName.equals(HistManualChainClp.class.getName())) {
			return translateInputHistManualChain(oldModel);
		}

		if (oldModelClassName.equals(HistManualRegionClp.class.getName())) {
			return translateInputHistManualRegion(oldModel);
		}

		if (oldModelClassName.equals(HistManualsClp.class.getName())) {
			return translateInputHistManuals(oldModel);
		}

		if (oldModelClassName.equals(ImageClp.class.getName())) {
			return translateInputImage(oldModel);
		}

		if (oldModelClassName.equals(JobQueueClp.class.getName())) {
			return translateInputJobQueue(oldModel);
		}

		if (oldModelClassName.equals(MustPublishClp.class.getName())) {
			return translateInputMustPublish(oldModel);
		}

		if (oldModelClassName.equals(PublicationClp.class.getName())) {
			return translateInputPublication(oldModel);
		}

		if (oldModelClassName.equals(PublishCountryStandardClp.class.getName())) {
			return translateInputPublishCountryStandard(oldModel);
		}

		if (oldModelClassName.equals(PublishDeptClp.class.getName())) {
			return translateInputPublishDept(oldModel);
		}

		if (oldModelClassName.equals(PublishedPdfListClp.class.getName())) {
			return translateInputPublishedPdfList(oldModel);
		}

		if (oldModelClassName.equals(PublishExtStdClp.class.getName())) {
			return translateInputPublishExtStd(oldModel);
		}

		if (oldModelClassName.equals(PublishParmClp.class.getName())) {
			return translateInputPublishParm(oldModel);
		}

		if (oldModelClassName.equals(PublishQueueClp.class.getName())) {
			return translateInputPublishQueue(oldModel);
		}

		if (oldModelClassName.equals(PublishStandardsExtClp.class.getName())) {
			return translateInputPublishStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(PublishStdClp.class.getName())) {
			return translateInputPublishStd(oldModel);
		}

		if (oldModelClassName.equals(PublishTaxonomyClp.class.getName())) {
			return translateInputPublishTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(PublishTaxonomyExtClp.class.getName())) {
			return translateInputPublishTaxonomyExt(oldModel);
		}

		if (oldModelClassName.equals(SpecialWordDictionaryClp.class.getName())) {
			return translateInputSpecialWordDictionary(oldModel);
		}

		if (oldModelClassName.equals(
					SpreadSheetAttributeUpdateClp.class.getName())) {
			return translateInputSpreadSheetAttributeUpdate(oldModel);
		}

		if (oldModelClassName.equals(StandardsClp.class.getName())) {
			return translateInputStandards(oldModel);
		}

		if (oldModelClassName.equals(StandardsAuthorsClp.class.getName())) {
			return translateInputStandardsAuthors(oldModel);
		}

		if (oldModelClassName.equals(StandardsChainImagesClp.class.getName())) {
			return translateInputStandardsChainImages(oldModel);
		}

		if (oldModelClassName.equals(StandardsComplianceClp.class.getName())) {
			return translateInputStandardsCompliance(oldModel);
		}

		if (oldModelClassName.equals(StandardsComplianceExtClp.class.getName())) {
			return translateInputStandardsComplianceExt(oldModel);
		}

		if (oldModelClassName.equals(StandardsCountryClp.class.getName())) {
			return translateInputStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(StandardsCountryChainClp.class.getName())) {
			return translateInputStandardsCountryChain(oldModel);
		}

		if (oldModelClassName.equals(StandardsCountryExtClp.class.getName())) {
			return translateInputStandardsCountryExt(oldModel);
		}

		if (oldModelClassName.equals(StandardsCountryImagesClp.class.getName())) {
			return translateInputStandardsCountryImages(oldModel);
		}

		if (oldModelClassName.equals(StandardsCrossReferenceClp.class.getName())) {
			return translateInputStandardsCrossReference(oldModel);
		}

		if (oldModelClassName.equals(StandardsDisplayOrderClp.class.getName())) {
			return translateInputStandardsDisplayOrder(oldModel);
		}

		if (oldModelClassName.equals(
					StandardsDisplayOrderExtClp.class.getName())) {
			return translateInputStandardsDisplayOrderExt(oldModel);
		}

		if (oldModelClassName.equals(StandardsExtClp.class.getName())) {
			return translateInputStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(
					StandardsHistoricalManualClp.class.getName())) {
			return translateInputStandardsHistoricalManual(oldModel);
		}

		if (oldModelClassName.equals(StandardsImagesClp.class.getName())) {
			return translateInputStandardsImages(oldModel);
		}

		if (oldModelClassName.equals(StandardsLocaleClp.class.getName())) {
			return translateInputStandardsLocale(oldModel);
		}

		if (oldModelClassName.equals(StandardsRegionClp.class.getName())) {
			return translateInputStandardsRegion(oldModel);
		}

		if (oldModelClassName.equals(StandardsRegionChainClp.class.getName())) {
			return translateInputStandardsRegionChain(oldModel);
		}

		if (oldModelClassName.equals(StandardsRegionLocaleClp.class.getName())) {
			return translateInputStandardsRegionLocale(oldModel);
		}

		if (oldModelClassName.equals(StandardsStatusClp.class.getName())) {
			return translateInputStandardsStatus(oldModel);
		}

		if (oldModelClassName.equals(StandardsTranslateClp.class.getName())) {
			return translateInputStandardsTranslate(oldModel);
		}

		if (oldModelClassName.equals(StandardTagClp.class.getName())) {
			return translateInputStandardTag(oldModel);
		}

		if (oldModelClassName.equals(TaxonomyClp.class.getName())) {
			return translateInputTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(TaxonomyExtClp.class.getName())) {
			return translateInputTaxonomyExt(oldModel);
		}

		if (oldModelClassName.equals(TaxonomyStandardsClp.class.getName())) {
			return translateInputTaxonomyStandards(oldModel);
		}

		if (oldModelClassName.equals(TaxonomyTranslateClp.class.getName())) {
			return translateInputTaxonomyTranslate(oldModel);
		}

		if (oldModelClassName.equals(TreeXMLClp.class.getName())) {
			return translateInputTreeXML(oldModel);
		}

		if (oldModelClassName.equals(UIElementClp.class.getName())) {
			return translateInputUIElement(oldModel);
		}

		if (oldModelClassName.equals(UIElementTranslateClp.class.getName())) {
			return translateInputUIElementTranslate(oldModel);
		}

		if (oldModelClassName.equals(UniqueGroupClp.class.getName())) {
			return translateInputUniqueGroup(oldModel);
		}

		if (oldModelClassName.equals(UniqueGroupCountryClp.class.getName())) {
			return translateInputUniqueGroupCountry(oldModel);
		}

		if (oldModelClassName.equals(UniqueGroupStandardClp.class.getName())) {
			return translateInputUniqueGroupStandard(oldModel);
		}

		if (oldModelClassName.equals(UserPreferenceClp.class.getName())) {
			return translateInputUserPreference(oldModel);
		}

		if (oldModelClassName.equals(UserSearchCriteriaClp.class.getName())) {
			return translateInputUserSearchCriteria(oldModel);
		}

		if (oldModelClassName.equals(WorkflowClp.class.getName())) {
			return translateInputWorkflow(oldModel);
		}

		return oldModel;
	}

	public static Object translateInput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateInput(curObj));
		}

		return newList;
	}

	public static Object translateInputAttachmentsStandards(
		BaseModel<?> oldModel) {
		AttachmentsStandardsClp oldClpModel = (AttachmentsStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAttachmentsStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputAttachmentsStandardsCountry(
		BaseModel<?> oldModel) {
		AttachmentsStandardsCountryClp oldClpModel = (AttachmentsStandardsCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getAttachmentsStandardsCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBrandTaxonomy(BaseModel<?> oldModel) {
		BrandTaxonomyClp oldClpModel = (BrandTaxonomyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBrandTaxonomyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBrandTaxonomyTranslate(
		BaseModel<?> oldModel) {
		BrandTaxonomyTranslateClp oldClpModel = (BrandTaxonomyTranslateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBrandTaxonomyTranslateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgeGlobalPublish(
		BaseModel<?> oldModel) {
		BridgeGlobalPublishClp oldClpModel = (BridgeGlobalPublishClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgeGlobalPublishRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgeGlobalPublishCountry(
		BaseModel<?> oldModel) {
		BridgeGlobalPublishCountryClp oldClpModel = (BridgeGlobalPublishCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgeGlobalPublishCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgeProgressCategory(
		BaseModel<?> oldModel) {
		BridgeProgressCategoryClp oldClpModel = (BridgeProgressCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgeProgressCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgeProgressDiscrepancy(
		BaseModel<?> oldModel) {
		BridgeProgressDiscrepancyClp oldClpModel = (BridgeProgressDiscrepancyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgeProgressDiscrepancyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgeProgressSubCategory(
		BaseModel<?> oldModel) {
		BridgeProgressSubCategoryClp oldClpModel = (BridgeProgressSubCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgeProgressSubCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublish(BaseModel<?> oldModel) {
		BridgePublishClp oldClpModel = (BridgePublishClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishCountry(
		BaseModel<?> oldModel) {
		BridgePublishCountryClp oldClpModel = (BridgePublishCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishCountryStateEx(
		BaseModel<?> oldModel) {
		BridgePublishCountryStateExClp oldClpModel = (BridgePublishCountryStateExClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishCountryStateExRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishImport(
		BaseModel<?> oldModel) {
		BridgePublishImportClp oldClpModel = (BridgePublishImportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishImportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishLang(BaseModel<?> oldModel) {
		BridgePublishLangClp oldClpModel = (BridgePublishLangClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishLangRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishPreview(
		BaseModel<?> oldModel) {
		BridgePublishPreviewClp oldClpModel = (BridgePublishPreviewClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishPreviewRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishStateEx(
		BaseModel<?> oldModel) {
		BridgePublishStateExClp oldClpModel = (BridgePublishStateExClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishStateExRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBridgePublishStatus(
		BaseModel<?> oldModel) {
		BridgePublishStatusClp oldClpModel = (BridgePublishStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBridgePublishStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputBusImpactAssmt(BaseModel<?> oldModel) {
		BusImpactAssmtClp oldClpModel = (BusImpactAssmtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getBusImpactAssmtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputChainAttachmentsStandards(
		BaseModel<?> oldModel) {
		ChainAttachmentsStandardsClp oldClpModel = (ChainAttachmentsStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getChainAttachmentsStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputChainExternalLinkStandards(
		BaseModel<?> oldModel) {
		ChainExternalLinkStandardsClp oldClpModel = (ChainExternalLinkStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getChainExternalLinkStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputChainStandards(BaseModel<?> oldModel) {
		ChainStandardsClp oldClpModel = (ChainStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getChainStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCountryStandards(BaseModel<?> oldModel) {
		CountryStandardsClp oldClpModel = (CountryStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCountryStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputCountryStandardsExt(
		BaseModel<?> oldModel) {
		CountryStandardsExtClp oldClpModel = (CountryStandardsExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getCountryStandardsExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputDepartment(BaseModel<?> oldModel) {
		DepartmentClp oldClpModel = (DepartmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getDepartmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputErrNotification(BaseModel<?> oldModel) {
		ErrNotificationClp oldClpModel = (ErrNotificationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getErrNotificationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputExternalLinkStandards(
		BaseModel<?> oldModel) {
		ExternalLinkStandardsClp oldClpModel = (ExternalLinkStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExternalLinkStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputExternalLinkStandardsCountry(
		BaseModel<?> oldModel) {
		ExternalLinkStandardsCountryClp oldClpModel = (ExternalLinkStandardsCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getExternalLinkStandardsCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlagCategory(BaseModel<?> oldModel) {
		FlagCategoryClp oldClpModel = (FlagCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlagCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputFlagStandards(BaseModel<?> oldModel) {
		FlagStandardsClp oldClpModel = (FlagStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getFlagStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMCategory(BaseModel<?> oldModel) {
		GEMCategoryClp oldClpModel = (GEMCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMChainMeasurement(
		BaseModel<?> oldModel) {
		GEMChainMeasurementClp oldClpModel = (GEMChainMeasurementClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMChainMeasurementRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMCode(BaseModel<?> oldModel) {
		GEMCodeClp oldClpModel = (GEMCodeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMCodeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMGeneratedReport(BaseModel<?> oldModel) {
		GEMGeneratedReportClp oldClpModel = (GEMGeneratedReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMGeneratedReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMGeneratedReportVal(
		BaseModel<?> oldModel) {
		GEMGeneratedReportValClp oldClpModel = (GEMGeneratedReportValClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMGeneratedReportValRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMManagementBucket(
		BaseModel<?> oldModel) {
		GEMManagementBucketClp oldClpModel = (GEMManagementBucketClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMManagementBucketRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMManagementId(BaseModel<?> oldModel) {
		GEMManagementIdClp oldClpModel = (GEMManagementIdClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMManagementIdRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMMeasurement(BaseModel<?> oldModel) {
		GEMMeasurementClp oldClpModel = (GEMMeasurementClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMMeasurementRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMMeasurementBucketChain(
		BaseModel<?> oldModel) {
		GEMMeasurementBucketChainClp oldClpModel = (GEMMeasurementBucketChainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMMeasurementBucketChainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMMeasurementFormula(
		BaseModel<?> oldModel) {
		GEMMeasurementFormulaClp oldClpModel = (GEMMeasurementFormulaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMMeasurementFormulaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMMeasurementFormulaValue(
		BaseModel<?> oldModel) {
		GEMMeasurementFormulaValueClp oldClpModel = (GEMMeasurementFormulaValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMMeasurementFormulaValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMMeasurementType(BaseModel<?> oldModel) {
		GEMMeasurementTypeClp oldClpModel = (GEMMeasurementTypeClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMMeasurementTypeRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMQlReport(BaseModel<?> oldModel) {
		GEMQlReportClp oldClpModel = (GEMQlReportClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMQlReportRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMRole(BaseModel<?> oldModel) {
		GEMRoleClp oldClpModel = (GEMRoleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMRoleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMScoringValue(BaseModel<?> oldModel) {
		GEMScoringValueClp oldClpModel = (GEMScoringValueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMScoringValueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMSeverity(BaseModel<?> oldModel) {
		GEMSeverityClp oldClpModel = (GEMSeverityClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMSeverityRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMStdCategory(BaseModel<?> oldModel) {
		GEMStdCategoryClp oldClpModel = (GEMStdCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMStdCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTemplate(BaseModel<?> oldModel) {
		GEMTemplateClp oldClpModel = (GEMTemplateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTemplateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTemplateCategory(
		BaseModel<?> oldModel) {
		GEMTemplateCategoryClp oldClpModel = (GEMTemplateCategoryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTemplateCategoryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTemplateColumn(BaseModel<?> oldModel) {
		GEMTemplateColumnClp oldClpModel = (GEMTemplateColumnClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTemplateColumnRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTemplateReference(
		BaseModel<?> oldModel) {
		GEMTemplateReferenceClp oldClpModel = (GEMTemplateReferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTemplateReferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTemplateValues(BaseModel<?> oldModel) {
		GEMTemplateValuesClp oldClpModel = (GEMTemplateValuesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTemplateValuesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMTrigger(BaseModel<?> oldModel) {
		GEMTriggerClp oldClpModel = (GEMTriggerClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMTriggerRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMUniqueGroup(BaseModel<?> oldModel) {
		GEMUniqueGroupClp oldClpModel = (GEMUniqueGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMUniqueGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMUniqueGroupCountry(
		BaseModel<?> oldModel) {
		GEMUniqueGroupCountryClp oldClpModel = (GEMUniqueGroupCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMUniqueGroupCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGEMUniqueGroupStandard(
		BaseModel<?> oldModel) {
		GEMUniqueGroupStandardClp oldClpModel = (GEMUniqueGroupStandardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGEMUniqueGroupStandardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGlossary(BaseModel<?> oldModel) {
		GlossaryClp oldClpModel = (GlossaryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGlossaryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGlossaryExt(BaseModel<?> oldModel) {
		GlossaryExtClp oldClpModel = (GlossaryExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGlossaryExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGlossaryRegionNav(BaseModel<?> oldModel) {
		GlossaryRegionNavClp oldClpModel = (GlossaryRegionNavClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGlossaryRegionNavRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputGlossaryTranslate(BaseModel<?> oldModel) {
		GlossaryTranslateClp oldClpModel = (GlossaryTranslateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getGlossaryTranslateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHistManualAttachment(
		BaseModel<?> oldModel) {
		HistManualAttachmentClp oldClpModel = (HistManualAttachmentClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHistManualAttachmentRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHistManualChain(BaseModel<?> oldModel) {
		HistManualChainClp oldClpModel = (HistManualChainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHistManualChainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHistManualRegion(BaseModel<?> oldModel) {
		HistManualRegionClp oldClpModel = (HistManualRegionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHistManualRegionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputHistManuals(BaseModel<?> oldModel) {
		HistManualsClp oldClpModel = (HistManualsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getHistManualsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputImage(BaseModel<?> oldModel) {
		ImageClp oldClpModel = (ImageClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getImageRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputJobQueue(BaseModel<?> oldModel) {
		JobQueueClp oldClpModel = (JobQueueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getJobQueueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputMustPublish(BaseModel<?> oldModel) {
		MustPublishClp oldClpModel = (MustPublishClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getMustPublishRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublication(BaseModel<?> oldModel) {
		PublicationClp oldClpModel = (PublicationClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublicationRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishCountryStandard(
		BaseModel<?> oldModel) {
		PublishCountryStandardClp oldClpModel = (PublishCountryStandardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishCountryStandardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishDept(BaseModel<?> oldModel) {
		PublishDeptClp oldClpModel = (PublishDeptClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishDeptRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishedPdfList(BaseModel<?> oldModel) {
		PublishedPdfListClp oldClpModel = (PublishedPdfListClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishedPdfListRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishExtStd(BaseModel<?> oldModel) {
		PublishExtStdClp oldClpModel = (PublishExtStdClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishExtStdRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishParm(BaseModel<?> oldModel) {
		PublishParmClp oldClpModel = (PublishParmClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishParmRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishQueue(BaseModel<?> oldModel) {
		PublishQueueClp oldClpModel = (PublishQueueClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishQueueRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishStandardsExt(
		BaseModel<?> oldModel) {
		PublishStandardsExtClp oldClpModel = (PublishStandardsExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishStandardsExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishStd(BaseModel<?> oldModel) {
		PublishStdClp oldClpModel = (PublishStdClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishStdRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishTaxonomy(BaseModel<?> oldModel) {
		PublishTaxonomyClp oldClpModel = (PublishTaxonomyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishTaxonomyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputPublishTaxonomyExt(BaseModel<?> oldModel) {
		PublishTaxonomyExtClp oldClpModel = (PublishTaxonomyExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getPublishTaxonomyExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSpecialWordDictionary(
		BaseModel<?> oldModel) {
		SpecialWordDictionaryClp oldClpModel = (SpecialWordDictionaryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSpecialWordDictionaryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputSpreadSheetAttributeUpdate(
		BaseModel<?> oldModel) {
		SpreadSheetAttributeUpdateClp oldClpModel = (SpreadSheetAttributeUpdateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getSpreadSheetAttributeUpdateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandards(BaseModel<?> oldModel) {
		StandardsClp oldClpModel = (StandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsAuthors(BaseModel<?> oldModel) {
		StandardsAuthorsClp oldClpModel = (StandardsAuthorsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsAuthorsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsChainImages(
		BaseModel<?> oldModel) {
		StandardsChainImagesClp oldClpModel = (StandardsChainImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsChainImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCompliance(
		BaseModel<?> oldModel) {
		StandardsComplianceClp oldClpModel = (StandardsComplianceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsComplianceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsComplianceExt(
		BaseModel<?> oldModel) {
		StandardsComplianceExtClp oldClpModel = (StandardsComplianceExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsComplianceExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCountry(BaseModel<?> oldModel) {
		StandardsCountryClp oldClpModel = (StandardsCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCountryChain(
		BaseModel<?> oldModel) {
		StandardsCountryChainClp oldClpModel = (StandardsCountryChainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsCountryChainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCountryExt(
		BaseModel<?> oldModel) {
		StandardsCountryExtClp oldClpModel = (StandardsCountryExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsCountryExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCountryImages(
		BaseModel<?> oldModel) {
		StandardsCountryImagesClp oldClpModel = (StandardsCountryImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsCountryImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsCrossReference(
		BaseModel<?> oldModel) {
		StandardsCrossReferenceClp oldClpModel = (StandardsCrossReferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsCrossReferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsDisplayOrder(
		BaseModel<?> oldModel) {
		StandardsDisplayOrderClp oldClpModel = (StandardsDisplayOrderClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsDisplayOrderRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsDisplayOrderExt(
		BaseModel<?> oldModel) {
		StandardsDisplayOrderExtClp oldClpModel = (StandardsDisplayOrderExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsDisplayOrderExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsExt(BaseModel<?> oldModel) {
		StandardsExtClp oldClpModel = (StandardsExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsHistoricalManual(
		BaseModel<?> oldModel) {
		StandardsHistoricalManualClp oldClpModel = (StandardsHistoricalManualClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsHistoricalManualRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsImages(BaseModel<?> oldModel) {
		StandardsImagesClp oldClpModel = (StandardsImagesClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsImagesRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsLocale(BaseModel<?> oldModel) {
		StandardsLocaleClp oldClpModel = (StandardsLocaleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsLocaleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsRegion(BaseModel<?> oldModel) {
		StandardsRegionClp oldClpModel = (StandardsRegionClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsRegionRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsRegionChain(
		BaseModel<?> oldModel) {
		StandardsRegionChainClp oldClpModel = (StandardsRegionChainClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsRegionChainRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsRegionLocale(
		BaseModel<?> oldModel) {
		StandardsRegionLocaleClp oldClpModel = (StandardsRegionLocaleClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsRegionLocaleRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsStatus(BaseModel<?> oldModel) {
		StandardsStatusClp oldClpModel = (StandardsStatusClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsStatusRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardsTranslate(BaseModel<?> oldModel) {
		StandardsTranslateClp oldClpModel = (StandardsTranslateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardsTranslateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputStandardTag(BaseModel<?> oldModel) {
		StandardTagClp oldClpModel = (StandardTagClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getStandardTagRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTaxonomy(BaseModel<?> oldModel) {
		TaxonomyClp oldClpModel = (TaxonomyClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTaxonomyRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTaxonomyExt(BaseModel<?> oldModel) {
		TaxonomyExtClp oldClpModel = (TaxonomyExtClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTaxonomyExtRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTaxonomyStandards(BaseModel<?> oldModel) {
		TaxonomyStandardsClp oldClpModel = (TaxonomyStandardsClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTaxonomyStandardsRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTaxonomyTranslate(BaseModel<?> oldModel) {
		TaxonomyTranslateClp oldClpModel = (TaxonomyTranslateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTaxonomyTranslateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputTreeXML(BaseModel<?> oldModel) {
		TreeXMLClp oldClpModel = (TreeXMLClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getTreeXMLRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUIElement(BaseModel<?> oldModel) {
		UIElementClp oldClpModel = (UIElementClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUIElementRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUIElementTranslate(BaseModel<?> oldModel) {
		UIElementTranslateClp oldClpModel = (UIElementTranslateClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUIElementTranslateRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUniqueGroup(BaseModel<?> oldModel) {
		UniqueGroupClp oldClpModel = (UniqueGroupClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUniqueGroupRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUniqueGroupCountry(BaseModel<?> oldModel) {
		UniqueGroupCountryClp oldClpModel = (UniqueGroupCountryClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUniqueGroupCountryRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUniqueGroupStandard(
		BaseModel<?> oldModel) {
		UniqueGroupStandardClp oldClpModel = (UniqueGroupStandardClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUniqueGroupStandardRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserPreference(BaseModel<?> oldModel) {
		UserPreferenceClp oldClpModel = (UserPreferenceClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserPreferenceRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputUserSearchCriteria(BaseModel<?> oldModel) {
		UserSearchCriteriaClp oldClpModel = (UserSearchCriteriaClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getUserSearchCriteriaRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInputWorkflow(BaseModel<?> oldModel) {
		WorkflowClp oldClpModel = (WorkflowClp)oldModel;

		BaseModel<?> newModel = oldClpModel.getWorkflowRemoteModel();

		newModel.setModelAttributes(oldClpModel.getModelAttributes());

		return newModel;
	}

	public static Object translateInput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateInput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateInput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Object translateOutput(BaseModel<?> oldModel) {
		Class<?> oldModelClass = oldModel.getClass();

		String oldModelClassName = oldModelClass.getName();

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.AttachmentsStandardsImpl")) {
			return translateOutputAttachmentsStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.AttachmentsStandardsCountryImpl")) {
			return translateOutputAttachmentsStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BrandTaxonomyImpl")) {
			return translateOutputBrandTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BrandTaxonomyTranslateImpl")) {
			return translateOutputBrandTaxonomyTranslate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishImpl")) {
			return translateOutputBridgeGlobalPublish(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgeGlobalPublishCountryImpl")) {
			return translateOutputBridgeGlobalPublishCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgeProgressCategoryImpl")) {
			return translateOutputBridgeProgressCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgeProgressDiscrepancyImpl")) {
			return translateOutputBridgeProgressDiscrepancy(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgeProgressSubCategoryImpl")) {
			return translateOutputBridgeProgressSubCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishImpl")) {
			return translateOutputBridgePublish(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishCountryImpl")) {
			return translateOutputBridgePublishCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishCountryStateExImpl")) {
			return translateOutputBridgePublishCountryStateEx(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishImportImpl")) {
			return translateOutputBridgePublishImport(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishLangImpl")) {
			return translateOutputBridgePublishLang(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishPreviewImpl")) {
			return translateOutputBridgePublishPreview(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishStateExImpl")) {
			return translateOutputBridgePublishStateEx(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BridgePublishStatusImpl")) {
			return translateOutputBridgePublishStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.BusImpactAssmtImpl")) {
			return translateOutputBusImpactAssmt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ChainAttachmentsStandardsImpl")) {
			return translateOutputChainAttachmentsStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ChainExternalLinkStandardsImpl")) {
			return translateOutputChainExternalLinkStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ChainStandardsImpl")) {
			return translateOutputChainStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.CountryStandardsImpl")) {
			return translateOutputCountryStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.CountryStandardsExtImpl")) {
			return translateOutputCountryStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.DepartmentImpl")) {
			return translateOutputDepartment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ErrNotificationImpl")) {
			return translateOutputErrNotification(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsImpl")) {
			return translateOutputExternalLinkStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ExternalLinkStandardsCountryImpl")) {
			return translateOutputExternalLinkStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.FlagCategoryImpl")) {
			return translateOutputFlagCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.FlagStandardsImpl")) {
			return translateOutputFlagStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMCategoryImpl")) {
			return translateOutputGEMCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMChainMeasurementImpl")) {
			return translateOutputGEMChainMeasurement(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMCodeImpl")) {
			return translateOutputGEMCode(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMGeneratedReportImpl")) {
			return translateOutputGEMGeneratedReport(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMGeneratedReportValImpl")) {
			return translateOutputGEMGeneratedReportVal(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMManagementBucketImpl")) {
			return translateOutputGEMManagementBucket(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMManagementIdImpl")) {
			return translateOutputGEMManagementId(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMMeasurementImpl")) {
			return translateOutputGEMMeasurement(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMMeasurementBucketChainImpl")) {
			return translateOutputGEMMeasurementBucketChain(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaImpl")) {
			return translateOutputGEMMeasurementFormula(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMMeasurementFormulaValueImpl")) {
			return translateOutputGEMMeasurementFormulaValue(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMMeasurementTypeImpl")) {
			return translateOutputGEMMeasurementType(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMQlReportImpl")) {
			return translateOutputGEMQlReport(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMRoleImpl")) {
			return translateOutputGEMRole(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMScoringValueImpl")) {
			return translateOutputGEMScoringValue(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMSeverityImpl")) {
			return translateOutputGEMSeverity(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMStdCategoryImpl")) {
			return translateOutputGEMStdCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTemplateImpl")) {
			return translateOutputGEMTemplate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTemplateCategoryImpl")) {
			return translateOutputGEMTemplateCategory(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTemplateColumnImpl")) {
			return translateOutputGEMTemplateColumn(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTemplateReferenceImpl")) {
			return translateOutputGEMTemplateReference(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTemplateValuesImpl")) {
			return translateOutputGEMTemplateValues(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMTriggerImpl")) {
			return translateOutputGEMTrigger(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMUniqueGroupImpl")) {
			return translateOutputGEMUniqueGroup(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMUniqueGroupCountryImpl")) {
			return translateOutputGEMUniqueGroupCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GEMUniqueGroupStandardImpl")) {
			return translateOutputGEMUniqueGroupStandard(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GlossaryImpl")) {
			return translateOutputGlossary(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GlossaryExtImpl")) {
			return translateOutputGlossaryExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GlossaryRegionNavImpl")) {
			return translateOutputGlossaryRegionNav(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.GlossaryTranslateImpl")) {
			return translateOutputGlossaryTranslate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.HistManualAttachmentImpl")) {
			return translateOutputHistManualAttachment(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.HistManualChainImpl")) {
			return translateOutputHistManualChain(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.HistManualRegionImpl")) {
			return translateOutputHistManualRegion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.HistManualsImpl")) {
			return translateOutputHistManuals(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.ImageImpl")) {
			return translateOutputImage(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.JobQueueImpl")) {
			return translateOutputJobQueue(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.MustPublishImpl")) {
			return translateOutputMustPublish(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublicationImpl")) {
			return translateOutputPublication(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishCountryStandardImpl")) {
			return translateOutputPublishCountryStandard(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishDeptImpl")) {
			return translateOutputPublishDept(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishedPdfListImpl")) {
			return translateOutputPublishedPdfList(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishExtStdImpl")) {
			return translateOutputPublishExtStd(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishParmImpl")) {
			return translateOutputPublishParm(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishQueueImpl")) {
			return translateOutputPublishQueue(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishStandardsExtImpl")) {
			return translateOutputPublishStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishStdImpl")) {
			return translateOutputPublishStd(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishTaxonomyImpl")) {
			return translateOutputPublishTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.PublishTaxonomyExtImpl")) {
			return translateOutputPublishTaxonomyExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.SpecialWordDictionaryImpl")) {
			return translateOutputSpecialWordDictionary(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.SpreadSheetAttributeUpdateImpl")) {
			return translateOutputSpreadSheetAttributeUpdate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsImpl")) {
			return translateOutputStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsAuthorsImpl")) {
			return translateOutputStandardsAuthors(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsChainImagesImpl")) {
			return translateOutputStandardsChainImages(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsComplianceImpl")) {
			return translateOutputStandardsCompliance(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsComplianceExtImpl")) {
			return translateOutputStandardsComplianceExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsCountryImpl")) {
			return translateOutputStandardsCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsCountryChainImpl")) {
			return translateOutputStandardsCountryChain(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsCountryExtImpl")) {
			return translateOutputStandardsCountryExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsCountryImagesImpl")) {
			return translateOutputStandardsCountryImages(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsCrossReferenceImpl")) {
			return translateOutputStandardsCrossReference(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderImpl")) {
			return translateOutputStandardsDisplayOrder(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsDisplayOrderExtImpl")) {
			return translateOutputStandardsDisplayOrderExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsExtImpl")) {
			return translateOutputStandardsExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsHistoricalManualImpl")) {
			return translateOutputStandardsHistoricalManual(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsImagesImpl")) {
			return translateOutputStandardsImages(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsLocaleImpl")) {
			return translateOutputStandardsLocale(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsRegionImpl")) {
			return translateOutputStandardsRegion(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsRegionChainImpl")) {
			return translateOutputStandardsRegionChain(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsRegionLocaleImpl")) {
			return translateOutputStandardsRegionLocale(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsStatusImpl")) {
			return translateOutputStandardsStatus(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardsTranslateImpl")) {
			return translateOutputStandardsTranslate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.StandardTagImpl")) {
			return translateOutputStandardTag(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.TaxonomyImpl")) {
			return translateOutputTaxonomy(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.TaxonomyExtImpl")) {
			return translateOutputTaxonomyExt(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.TaxonomyStandardsImpl")) {
			return translateOutputTaxonomyStandards(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.TaxonomyTranslateImpl")) {
			return translateOutputTaxonomyTranslate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.TreeXMLImpl")) {
			return translateOutputTreeXML(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UIElementImpl")) {
			return translateOutputUIElement(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UIElementTranslateImpl")) {
			return translateOutputUIElementTranslate(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UniqueGroupImpl")) {
			return translateOutputUniqueGroup(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UniqueGroupCountryImpl")) {
			return translateOutputUniqueGroupCountry(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UniqueGroupStandardImpl")) {
			return translateOutputUniqueGroupStandard(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UserPreferenceImpl")) {
			return translateOutputUserPreference(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.UserSearchCriteriaImpl")) {
			return translateOutputUserSearchCriteria(oldModel);
		}

		if (oldModelClassName.equals(
					"com.ihg.brandstandards.db.model.impl.WorkflowImpl")) {
			return translateOutputWorkflow(oldModel);
		}

		return oldModel;
	}

	public static Object translateOutput(List<Object> oldList) {
		List<Object> newList = new ArrayList<Object>(oldList.size());

		for (int i = 0; i < oldList.size(); i++) {
			Object curObj = oldList.get(i);

			newList.add(translateOutput(curObj));
		}

		return newList;
	}

	public static Object translateOutput(Object obj) {
		if (obj instanceof BaseModel<?>) {
			return translateOutput((BaseModel<?>)obj);
		}
		else if (obj instanceof List<?>) {
			return translateOutput((List<Object>)obj);
		}
		else {
			return obj;
		}
	}

	public static Throwable translateThrowable(Throwable throwable) {
		if (_useReflectionToTranslateThrowable) {
			try {
				UnsyncByteArrayOutputStream unsyncByteArrayOutputStream = new UnsyncByteArrayOutputStream();
				ObjectOutputStream objectOutputStream = new ObjectOutputStream(unsyncByteArrayOutputStream);

				objectOutputStream.writeObject(throwable);

				objectOutputStream.flush();
				objectOutputStream.close();

				UnsyncByteArrayInputStream unsyncByteArrayInputStream = new UnsyncByteArrayInputStream(unsyncByteArrayOutputStream.unsafeGetByteArray(),
						0, unsyncByteArrayOutputStream.size());

				Thread currentThread = Thread.currentThread();

				ClassLoader contextClassLoader = currentThread.getContextClassLoader();

				ObjectInputStream objectInputStream = new ClassLoaderObjectInputStream(unsyncByteArrayInputStream,
						contextClassLoader);

				throwable = (Throwable)objectInputStream.readObject();

				objectInputStream.close();

				return throwable;
			}
			catch (SecurityException se) {
				if (_log.isInfoEnabled()) {
					_log.info("Do not use reflection to translate throwable");
				}

				_useReflectionToTranslateThrowable = false;
			}
			catch (Throwable throwable2) {
				_log.error(throwable2, throwable2);

				return throwable2;
			}
		}

		Class<?> clazz = throwable.getClass();

		String className = clazz.getName();

		if (className.equals(PortalException.class.getName())) {
			return new PortalException();
		}

		if (className.equals(SystemException.class.getName())) {
			return new SystemException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchAttachmentsStandardsCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBrandTaxonomyException")) {
			return new com.ihg.brandstandards.db.NoSuchBrandTaxonomyException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException")) {
			return new com.ihg.brandstandards.db.NoSuchBrandTaxonomyTranslateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgeGlobalPublishCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgeProgressCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgeProgressDiscrepancyException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgeProgressSubCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishCountryStateExException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishImportException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishImportException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishLangException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishLangException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishPreviewException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishStateExException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishStateExException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBridgePublishStatusException")) {
			return new com.ihg.brandstandards.db.NoSuchBridgePublishStatusException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchBusImpactAssmtException")) {
			return new com.ihg.brandstandards.db.NoSuchBusImpactAssmtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchChainAttachmentsStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchChainExternalLinkStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchChainStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchChainStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchCountryStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchCountryStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchCountryStandardsExtException")) {
			return new com.ihg.brandstandards.db.NoSuchCountryStandardsExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchDepartmentException")) {
			return new com.ihg.brandstandards.db.NoSuchDepartmentException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchErrNotificationException")) {
			return new com.ihg.brandstandards.db.NoSuchErrNotificationException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchExternalLinkStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchExternalLinkStandardsCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchFlagCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchFlagCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchFlagStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchFlagStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMChainMeasurementException();
		}

		if (className.equals("com.ihg.brandstandards.db.NoSuchGEMCodeException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMCodeException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMGeneratedReportException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMGeneratedReportValException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMManagementBucketException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMManagementBucketException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMManagementIdException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMManagementIdException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMMeasurementException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMMeasurementException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMMeasurementBucketChainException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMMeasurementFormulaValueException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMMeasurementTypeException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMQlReportException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMQlReportException();
		}

		if (className.equals("com.ihg.brandstandards.db.NoSuchGEMRoleException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMRoleException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMScoringValueException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMScoringValueException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMSeverityException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMSeverityException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMStdCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMStdCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTemplateException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTemplateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTemplateCategoryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTemplateColumnException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTemplateReferenceException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTemplateValuesException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMTriggerException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMTriggerException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMUniqueGroupException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMUniqueGroupCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException")) {
			return new com.ihg.brandstandards.db.NoSuchGEMUniqueGroupStandardException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGlossaryException")) {
			return new com.ihg.brandstandards.db.NoSuchGlossaryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGlossaryExtException")) {
			return new com.ihg.brandstandards.db.NoSuchGlossaryExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException")) {
			return new com.ihg.brandstandards.db.NoSuchGlossaryRegionNavException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchGlossaryTranslateException")) {
			return new com.ihg.brandstandards.db.NoSuchGlossaryTranslateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchHistManualAttachmentException")) {
			return new com.ihg.brandstandards.db.NoSuchHistManualAttachmentException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchHistManualChainException")) {
			return new com.ihg.brandstandards.db.NoSuchHistManualChainException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchHistManualRegionException")) {
			return new com.ihg.brandstandards.db.NoSuchHistManualRegionException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchHistManualsException")) {
			return new com.ihg.brandstandards.db.NoSuchHistManualsException();
		}

		if (className.equals("com.ihg.brandstandards.db.NoSuchImageException")) {
			return new com.ihg.brandstandards.db.NoSuchImageException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchJobQueueException")) {
			return new com.ihg.brandstandards.db.NoSuchJobQueueException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchMustPublishException")) {
			return new com.ihg.brandstandards.db.NoSuchMustPublishException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublicationException")) {
			return new com.ihg.brandstandards.db.NoSuchPublicationException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishCountryStandardException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishCountryStandardException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishDeptException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishDeptException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishedPdfListException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishedPdfListException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishExtStdException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishExtStdException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishParmException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishParmException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishQueueException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishQueueException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishStandardsExtException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishStandardsExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishStdException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishStdException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishTaxonomyException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishTaxonomyException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException")) {
			return new com.ihg.brandstandards.db.NoSuchPublishTaxonomyExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException")) {
			return new com.ihg.brandstandards.db.NoSuchSpecialWordDictionaryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException")) {
			return new com.ihg.brandstandards.db.NoSuchSpreadSheetAttributeUpdateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsAuthorsException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsAuthorsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsChainImagesException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsChainImagesException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsComplianceException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsComplianceException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsComplianceExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsCountryChainException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsCountryChainException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsCountryExtException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsCountryExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsCountryImagesException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsCrossReferenceException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsDisplayOrderExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsExtException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsHistoricalManualException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsImagesException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsImagesException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsLocaleException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsLocaleException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsRegionException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsRegionException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsRegionChainException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsRegionChainException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsStatusException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsStatusException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardsTranslateException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardsTranslateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchStandardTagException")) {
			return new com.ihg.brandstandards.db.NoSuchStandardTagException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchTaxonomyException")) {
			return new com.ihg.brandstandards.db.NoSuchTaxonomyException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchTaxonomyExtException")) {
			return new com.ihg.brandstandards.db.NoSuchTaxonomyExtException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException")) {
			return new com.ihg.brandstandards.db.NoSuchTaxonomyStandardsException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException")) {
			return new com.ihg.brandstandards.db.NoSuchTaxonomyTranslateException();
		}

		if (className.equals("com.ihg.brandstandards.db.NoSuchTreeXMLException")) {
			return new com.ihg.brandstandards.db.NoSuchTreeXMLException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUIElementException")) {
			return new com.ihg.brandstandards.db.NoSuchUIElementException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUIElementTranslateException")) {
			return new com.ihg.brandstandards.db.NoSuchUIElementTranslateException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUniqueGroupException")) {
			return new com.ihg.brandstandards.db.NoSuchUniqueGroupException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException")) {
			return new com.ihg.brandstandards.db.NoSuchUniqueGroupCountryException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException")) {
			return new com.ihg.brandstandards.db.NoSuchUniqueGroupStandardException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUserPreferenceException")) {
			return new com.ihg.brandstandards.db.NoSuchUserPreferenceException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException")) {
			return new com.ihg.brandstandards.db.NoSuchUserSearchCriteriaException();
		}

		if (className.equals(
					"com.ihg.brandstandards.db.NoSuchWorkflowException")) {
			return new com.ihg.brandstandards.db.NoSuchWorkflowException();
		}

		return throwable;
	}

	public static Object translateOutputAttachmentsStandards(
		BaseModel<?> oldModel) {
		AttachmentsStandardsClp newModel = new AttachmentsStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAttachmentsStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputAttachmentsStandardsCountry(
		BaseModel<?> oldModel) {
		AttachmentsStandardsCountryClp newModel = new AttachmentsStandardsCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setAttachmentsStandardsCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBrandTaxonomy(BaseModel<?> oldModel) {
		BrandTaxonomyClp newModel = new BrandTaxonomyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBrandTaxonomyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBrandTaxonomyTranslate(
		BaseModel<?> oldModel) {
		BrandTaxonomyTranslateClp newModel = new BrandTaxonomyTranslateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBrandTaxonomyTranslateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgeGlobalPublish(
		BaseModel<?> oldModel) {
		BridgeGlobalPublishClp newModel = new BridgeGlobalPublishClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgeGlobalPublishRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgeGlobalPublishCountry(
		BaseModel<?> oldModel) {
		BridgeGlobalPublishCountryClp newModel = new BridgeGlobalPublishCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgeGlobalPublishCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgeProgressCategory(
		BaseModel<?> oldModel) {
		BridgeProgressCategoryClp newModel = new BridgeProgressCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgeProgressCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgeProgressDiscrepancy(
		BaseModel<?> oldModel) {
		BridgeProgressDiscrepancyClp newModel = new BridgeProgressDiscrepancyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgeProgressDiscrepancyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgeProgressSubCategory(
		BaseModel<?> oldModel) {
		BridgeProgressSubCategoryClp newModel = new BridgeProgressSubCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgeProgressSubCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublish(BaseModel<?> oldModel) {
		BridgePublishClp newModel = new BridgePublishClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishCountry(
		BaseModel<?> oldModel) {
		BridgePublishCountryClp newModel = new BridgePublishCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishCountryStateEx(
		BaseModel<?> oldModel) {
		BridgePublishCountryStateExClp newModel = new BridgePublishCountryStateExClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishCountryStateExRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishImport(
		BaseModel<?> oldModel) {
		BridgePublishImportClp newModel = new BridgePublishImportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishImportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishLang(BaseModel<?> oldModel) {
		BridgePublishLangClp newModel = new BridgePublishLangClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishLangRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishPreview(
		BaseModel<?> oldModel) {
		BridgePublishPreviewClp newModel = new BridgePublishPreviewClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishPreviewRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishStateEx(
		BaseModel<?> oldModel) {
		BridgePublishStateExClp newModel = new BridgePublishStateExClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishStateExRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBridgePublishStatus(
		BaseModel<?> oldModel) {
		BridgePublishStatusClp newModel = new BridgePublishStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBridgePublishStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputBusImpactAssmt(BaseModel<?> oldModel) {
		BusImpactAssmtClp newModel = new BusImpactAssmtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setBusImpactAssmtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputChainAttachmentsStandards(
		BaseModel<?> oldModel) {
		ChainAttachmentsStandardsClp newModel = new ChainAttachmentsStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setChainAttachmentsStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputChainExternalLinkStandards(
		BaseModel<?> oldModel) {
		ChainExternalLinkStandardsClp newModel = new ChainExternalLinkStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setChainExternalLinkStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputChainStandards(BaseModel<?> oldModel) {
		ChainStandardsClp newModel = new ChainStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setChainStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCountryStandards(BaseModel<?> oldModel) {
		CountryStandardsClp newModel = new CountryStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCountryStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputCountryStandardsExt(
		BaseModel<?> oldModel) {
		CountryStandardsExtClp newModel = new CountryStandardsExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setCountryStandardsExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputDepartment(BaseModel<?> oldModel) {
		DepartmentClp newModel = new DepartmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setDepartmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputErrNotification(BaseModel<?> oldModel) {
		ErrNotificationClp newModel = new ErrNotificationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setErrNotificationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputExternalLinkStandards(
		BaseModel<?> oldModel) {
		ExternalLinkStandardsClp newModel = new ExternalLinkStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExternalLinkStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputExternalLinkStandardsCountry(
		BaseModel<?> oldModel) {
		ExternalLinkStandardsCountryClp newModel = new ExternalLinkStandardsCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setExternalLinkStandardsCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlagCategory(BaseModel<?> oldModel) {
		FlagCategoryClp newModel = new FlagCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlagCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputFlagStandards(BaseModel<?> oldModel) {
		FlagStandardsClp newModel = new FlagStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setFlagStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMCategory(BaseModel<?> oldModel) {
		GEMCategoryClp newModel = new GEMCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMChainMeasurement(
		BaseModel<?> oldModel) {
		GEMChainMeasurementClp newModel = new GEMChainMeasurementClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMChainMeasurementRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMCode(BaseModel<?> oldModel) {
		GEMCodeClp newModel = new GEMCodeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMCodeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMGeneratedReport(
		BaseModel<?> oldModel) {
		GEMGeneratedReportClp newModel = new GEMGeneratedReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMGeneratedReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMGeneratedReportVal(
		BaseModel<?> oldModel) {
		GEMGeneratedReportValClp newModel = new GEMGeneratedReportValClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMGeneratedReportValRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMManagementBucket(
		BaseModel<?> oldModel) {
		GEMManagementBucketClp newModel = new GEMManagementBucketClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMManagementBucketRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMManagementId(BaseModel<?> oldModel) {
		GEMManagementIdClp newModel = new GEMManagementIdClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMManagementIdRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMMeasurement(BaseModel<?> oldModel) {
		GEMMeasurementClp newModel = new GEMMeasurementClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMMeasurementRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMMeasurementBucketChain(
		BaseModel<?> oldModel) {
		GEMMeasurementBucketChainClp newModel = new GEMMeasurementBucketChainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMMeasurementBucketChainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMMeasurementFormula(
		BaseModel<?> oldModel) {
		GEMMeasurementFormulaClp newModel = new GEMMeasurementFormulaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMMeasurementFormulaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMMeasurementFormulaValue(
		BaseModel<?> oldModel) {
		GEMMeasurementFormulaValueClp newModel = new GEMMeasurementFormulaValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMMeasurementFormulaValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMMeasurementType(
		BaseModel<?> oldModel) {
		GEMMeasurementTypeClp newModel = new GEMMeasurementTypeClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMMeasurementTypeRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMQlReport(BaseModel<?> oldModel) {
		GEMQlReportClp newModel = new GEMQlReportClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMQlReportRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMRole(BaseModel<?> oldModel) {
		GEMRoleClp newModel = new GEMRoleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMRoleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMScoringValue(BaseModel<?> oldModel) {
		GEMScoringValueClp newModel = new GEMScoringValueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMScoringValueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMSeverity(BaseModel<?> oldModel) {
		GEMSeverityClp newModel = new GEMSeverityClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMSeverityRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMStdCategory(BaseModel<?> oldModel) {
		GEMStdCategoryClp newModel = new GEMStdCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMStdCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTemplate(BaseModel<?> oldModel) {
		GEMTemplateClp newModel = new GEMTemplateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTemplateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTemplateCategory(
		BaseModel<?> oldModel) {
		GEMTemplateCategoryClp newModel = new GEMTemplateCategoryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTemplateCategoryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTemplateColumn(BaseModel<?> oldModel) {
		GEMTemplateColumnClp newModel = new GEMTemplateColumnClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTemplateColumnRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTemplateReference(
		BaseModel<?> oldModel) {
		GEMTemplateReferenceClp newModel = new GEMTemplateReferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTemplateReferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTemplateValues(BaseModel<?> oldModel) {
		GEMTemplateValuesClp newModel = new GEMTemplateValuesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTemplateValuesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMTrigger(BaseModel<?> oldModel) {
		GEMTriggerClp newModel = new GEMTriggerClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMTriggerRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMUniqueGroup(BaseModel<?> oldModel) {
		GEMUniqueGroupClp newModel = new GEMUniqueGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMUniqueGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMUniqueGroupCountry(
		BaseModel<?> oldModel) {
		GEMUniqueGroupCountryClp newModel = new GEMUniqueGroupCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMUniqueGroupCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGEMUniqueGroupStandard(
		BaseModel<?> oldModel) {
		GEMUniqueGroupStandardClp newModel = new GEMUniqueGroupStandardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGEMUniqueGroupStandardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGlossary(BaseModel<?> oldModel) {
		GlossaryClp newModel = new GlossaryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGlossaryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGlossaryExt(BaseModel<?> oldModel) {
		GlossaryExtClp newModel = new GlossaryExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGlossaryExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGlossaryRegionNav(BaseModel<?> oldModel) {
		GlossaryRegionNavClp newModel = new GlossaryRegionNavClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGlossaryRegionNavRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputGlossaryTranslate(BaseModel<?> oldModel) {
		GlossaryTranslateClp newModel = new GlossaryTranslateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setGlossaryTranslateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHistManualAttachment(
		BaseModel<?> oldModel) {
		HistManualAttachmentClp newModel = new HistManualAttachmentClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHistManualAttachmentRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHistManualChain(BaseModel<?> oldModel) {
		HistManualChainClp newModel = new HistManualChainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHistManualChainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHistManualRegion(BaseModel<?> oldModel) {
		HistManualRegionClp newModel = new HistManualRegionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHistManualRegionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputHistManuals(BaseModel<?> oldModel) {
		HistManualsClp newModel = new HistManualsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setHistManualsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputImage(BaseModel<?> oldModel) {
		ImageClp newModel = new ImageClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setImageRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputJobQueue(BaseModel<?> oldModel) {
		JobQueueClp newModel = new JobQueueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setJobQueueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputMustPublish(BaseModel<?> oldModel) {
		MustPublishClp newModel = new MustPublishClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setMustPublishRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublication(BaseModel<?> oldModel) {
		PublicationClp newModel = new PublicationClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublicationRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishCountryStandard(
		BaseModel<?> oldModel) {
		PublishCountryStandardClp newModel = new PublishCountryStandardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishCountryStandardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishDept(BaseModel<?> oldModel) {
		PublishDeptClp newModel = new PublishDeptClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishDeptRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishedPdfList(BaseModel<?> oldModel) {
		PublishedPdfListClp newModel = new PublishedPdfListClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishedPdfListRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishExtStd(BaseModel<?> oldModel) {
		PublishExtStdClp newModel = new PublishExtStdClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishExtStdRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishParm(BaseModel<?> oldModel) {
		PublishParmClp newModel = new PublishParmClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishParmRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishQueue(BaseModel<?> oldModel) {
		PublishQueueClp newModel = new PublishQueueClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishQueueRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishStandardsExt(
		BaseModel<?> oldModel) {
		PublishStandardsExtClp newModel = new PublishStandardsExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishStandardsExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishStd(BaseModel<?> oldModel) {
		PublishStdClp newModel = new PublishStdClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishStdRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishTaxonomy(BaseModel<?> oldModel) {
		PublishTaxonomyClp newModel = new PublishTaxonomyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishTaxonomyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputPublishTaxonomyExt(
		BaseModel<?> oldModel) {
		PublishTaxonomyExtClp newModel = new PublishTaxonomyExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setPublishTaxonomyExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSpecialWordDictionary(
		BaseModel<?> oldModel) {
		SpecialWordDictionaryClp newModel = new SpecialWordDictionaryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSpecialWordDictionaryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputSpreadSheetAttributeUpdate(
		BaseModel<?> oldModel) {
		SpreadSheetAttributeUpdateClp newModel = new SpreadSheetAttributeUpdateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setSpreadSheetAttributeUpdateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandards(BaseModel<?> oldModel) {
		StandardsClp newModel = new StandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsAuthors(BaseModel<?> oldModel) {
		StandardsAuthorsClp newModel = new StandardsAuthorsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsAuthorsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsChainImages(
		BaseModel<?> oldModel) {
		StandardsChainImagesClp newModel = new StandardsChainImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsChainImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCompliance(
		BaseModel<?> oldModel) {
		StandardsComplianceClp newModel = new StandardsComplianceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsComplianceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsComplianceExt(
		BaseModel<?> oldModel) {
		StandardsComplianceExtClp newModel = new StandardsComplianceExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsComplianceExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCountry(BaseModel<?> oldModel) {
		StandardsCountryClp newModel = new StandardsCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCountryChain(
		BaseModel<?> oldModel) {
		StandardsCountryChainClp newModel = new StandardsCountryChainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsCountryChainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCountryExt(
		BaseModel<?> oldModel) {
		StandardsCountryExtClp newModel = new StandardsCountryExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsCountryExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCountryImages(
		BaseModel<?> oldModel) {
		StandardsCountryImagesClp newModel = new StandardsCountryImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsCountryImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsCrossReference(
		BaseModel<?> oldModel) {
		StandardsCrossReferenceClp newModel = new StandardsCrossReferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsCrossReferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsDisplayOrder(
		BaseModel<?> oldModel) {
		StandardsDisplayOrderClp newModel = new StandardsDisplayOrderClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsDisplayOrderRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsDisplayOrderExt(
		BaseModel<?> oldModel) {
		StandardsDisplayOrderExtClp newModel = new StandardsDisplayOrderExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsDisplayOrderExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsExt(BaseModel<?> oldModel) {
		StandardsExtClp newModel = new StandardsExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsHistoricalManual(
		BaseModel<?> oldModel) {
		StandardsHistoricalManualClp newModel = new StandardsHistoricalManualClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsHistoricalManualRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsImages(BaseModel<?> oldModel) {
		StandardsImagesClp newModel = new StandardsImagesClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsImagesRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsLocale(BaseModel<?> oldModel) {
		StandardsLocaleClp newModel = new StandardsLocaleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsLocaleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsRegion(BaseModel<?> oldModel) {
		StandardsRegionClp newModel = new StandardsRegionClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsRegionRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsRegionChain(
		BaseModel<?> oldModel) {
		StandardsRegionChainClp newModel = new StandardsRegionChainClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsRegionChainRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsRegionLocale(
		BaseModel<?> oldModel) {
		StandardsRegionLocaleClp newModel = new StandardsRegionLocaleClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsRegionLocaleRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsStatus(BaseModel<?> oldModel) {
		StandardsStatusClp newModel = new StandardsStatusClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsStatusRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardsTranslate(
		BaseModel<?> oldModel) {
		StandardsTranslateClp newModel = new StandardsTranslateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardsTranslateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputStandardTag(BaseModel<?> oldModel) {
		StandardTagClp newModel = new StandardTagClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setStandardTagRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTaxonomy(BaseModel<?> oldModel) {
		TaxonomyClp newModel = new TaxonomyClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTaxonomyRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTaxonomyExt(BaseModel<?> oldModel) {
		TaxonomyExtClp newModel = new TaxonomyExtClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTaxonomyExtRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTaxonomyStandards(BaseModel<?> oldModel) {
		TaxonomyStandardsClp newModel = new TaxonomyStandardsClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTaxonomyStandardsRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTaxonomyTranslate(BaseModel<?> oldModel) {
		TaxonomyTranslateClp newModel = new TaxonomyTranslateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTaxonomyTranslateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputTreeXML(BaseModel<?> oldModel) {
		TreeXMLClp newModel = new TreeXMLClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setTreeXMLRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUIElement(BaseModel<?> oldModel) {
		UIElementClp newModel = new UIElementClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUIElementRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUIElementTranslate(
		BaseModel<?> oldModel) {
		UIElementTranslateClp newModel = new UIElementTranslateClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUIElementTranslateRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUniqueGroup(BaseModel<?> oldModel) {
		UniqueGroupClp newModel = new UniqueGroupClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUniqueGroupRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUniqueGroupCountry(
		BaseModel<?> oldModel) {
		UniqueGroupCountryClp newModel = new UniqueGroupCountryClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUniqueGroupCountryRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUniqueGroupStandard(
		BaseModel<?> oldModel) {
		UniqueGroupStandardClp newModel = new UniqueGroupStandardClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUniqueGroupStandardRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserPreference(BaseModel<?> oldModel) {
		UserPreferenceClp newModel = new UserPreferenceClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserPreferenceRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputUserSearchCriteria(
		BaseModel<?> oldModel) {
		UserSearchCriteriaClp newModel = new UserSearchCriteriaClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setUserSearchCriteriaRemoteModel(oldModel);

		return newModel;
	}

	public static Object translateOutputWorkflow(BaseModel<?> oldModel) {
		WorkflowClp newModel = new WorkflowClp();

		newModel.setModelAttributes(oldModel.getModelAttributes());

		newModel.setWorkflowRemoteModel(oldModel);

		return newModel;
	}

	private static Log _log = LogFactoryUtil.getLog(ClpSerializer.class);
	private static String _servletContextName;
	private static boolean _useReflectionToTranslateThrowable = true;
}