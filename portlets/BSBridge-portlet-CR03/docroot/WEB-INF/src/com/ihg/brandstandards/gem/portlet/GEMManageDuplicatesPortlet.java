package com.ihg.brandstandards.gem.portlet;

import com.ihg.brandstandards.custom.gem.model.QualityLeadModel;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchPublishDeptException;
import com.ihg.brandstandards.db.model.GEMManagementBucket;
import com.ihg.brandstandards.db.model.GEMQlReport;
import com.ihg.brandstandards.db.model.GEMTemplate;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.service.GEMQlReportLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.ihg.brandstandards.gem.util.GemConstants;
import com.ihg.brandstandards.gem.util.GemQueryUtils;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

public class GEMManageDuplicatesPortlet extends BrandStandardsGemPortlet {

	private static final Log LOG = LogFactoryUtil
			.getLog(GEMManageDuplicatesPortlet.class);
	private static final String DUPLICATE_VALUE_YES = "Y";
	private static final String DUPLICATE_VALUE_NO = "N";
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
		Preferences userPreferences = getGEMUserPreferences(renderRequest);
		String brandCode = userPreferences.getBrand();
		// USe GEM Publish Id
		Publication publish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
		if (publish != null) {
			long gemPublishId = publish.getPublishId();
		
			long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
			long seTemplateId = getTemplateId(gemPublishId, regionId, GemConstants.TEMPLATE_TYPE_SE);
			renderRequest.setAttribute("seTemplateId", seTemplateId);
			renderRequest.setAttribute("gemPublishId", gemPublishId);
			renderRequest.setAttribute("activeGemPublish", true);
		} else {
			renderRequest.setAttribute("activeGemPublish", false);
		}

		super.doView(renderRequest, renderResponse);
	}

	public String duplicateStandard(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
		String returnMsg ="";
		try {
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			Preferences userPreferences = getGEMUserPreferences(resourceRequest);
			long regionId = BrandStandardsUtil.getRegionId(userPreferences.getRegionCode());
			long stdId = ParamUtil.getLong(resourceRequest, "duplicateStdId");
			long noOfTimes = ParamUtil.getLong(resourceRequest, "noOfTimes");
			long gemPublishId =  ParamUtil.getLong(resourceRequest, "gemPublishId");
			if(Validator.isNotNull(stdId)&& Validator.isNotNull(noOfTimes)) {
				List<GEMQlReport> gemQlReportList = GEMQlReportLocalServiceUtil.getByStdIdDuplicatePublishId(gemPublishId, regionId, stdId,DUPLICATE_VALUE_NO);
				if(Validator.isNotNull(gemQlReportList) && !gemQlReportList.isEmpty()) {
					GEMQlReport gemQlReport = gemQlReportList.get(0);
					List<GEMQlReport> specsGdlnsList = GEMQlReportLocalServiceUtil.getSpecGdlnByStdIdPublishIdDuplicate(gemPublishId, regionId, stdId, DUPLICATE_VALUE_NO,StringPool.BLANK);
					for(int i = 1 ;i<=noOfTimes;i++) {
						GEMQlReport newGemQLReportEntry = GEMQlReportLocalServiceUtil.createGEMQlReport(GEMTemplateLocalServiceUtil.getSequenceNumber("QLTY_LEAD_RPT_ID_SEQ"));
						newGemQLReportEntry.setPublishDeptId(gemQlReport.getPublishDeptId());
						newGemQLReportEntry.setPublishId(gemQlReport.getPublishId());
						newGemQLReportEntry.setStdId(gemQlReport.getStdId());
						newGemQLReportEntry.setBucketId(gemQlReport.getBucketId());
						newGemQLReportEntry.setSeverityId(gemQlReport.getSeverityId());
						newGemQLReportEntry.setMeasurementId(gemQlReport.getMeasurementId());
						newGemQLReportEntry.setTriggerId(gemQlReport.getTriggerId());
						newGemQLReportEntry.setCategoryId(gemQlReport.getCategoryId());
						newGemQLReportEntry.setDisplayOrderNumber(gemQlReport.getDisplayOrderNumber());
						newGemQLReportEntry.setRegionId(gemQlReport.getRegionId());
						newGemQLReportEntry.setComplianceDueDays(gemQlReport.getComplianceDueDays());
						newGemQLReportEntry.setGlblMustMeasure(gemQlReport.getGlblMustMeasure());
						newGemQLReportEntry.setCreatorId(themeDisplay.getUser().getScreenName());
						newGemQLReportEntry.setCreatedDate(new Date());
						newGemQLReportEntry.setUpdatedBy(themeDisplay.getUser().getScreenName());
						newGemQLReportEntry.setUpdatedDate(new Date());
						newGemQLReportEntry.setParentQlReportId(gemQlReport.getQlReportId());
						newGemQLReportEntry.setDuplicate(DUPLICATE_VALUE_YES);
						newGemQLReportEntry= GEMQlReportLocalServiceUtil.updateGEMQlReport(newGemQLReportEntry);
						for(GEMQlReport specGdln:specsGdlnsList) {
							GEMQlReport newSpecGdlnGemQLReportEntry = GEMQlReportLocalServiceUtil.createGEMQlReport(GEMTemplateLocalServiceUtil.getSequenceNumber("QLTY_LEAD_RPT_ID_SEQ"));
							newSpecGdlnGemQLReportEntry.setPublishDeptId(specGdln.getPublishDeptId());
							newSpecGdlnGemQLReportEntry.setPublishId(specGdln.getPublishId());
							newSpecGdlnGemQLReportEntry.setStdId(specGdln.getStdId());
							newSpecGdlnGemQLReportEntry.setBucketId(specGdln.getBucketId());
							newSpecGdlnGemQLReportEntry.setSeverityId(specGdln.getSeverityId());
							newSpecGdlnGemQLReportEntry.setMeasurementId(specGdln.getMeasurementId());
							newSpecGdlnGemQLReportEntry.setTriggerId(specGdln.getTriggerId());
							newSpecGdlnGemQLReportEntry.setCategoryId(specGdln.getCategoryId());
							newSpecGdlnGemQLReportEntry.setDisplayOrderNumber(specGdln.getDisplayOrderNumber());
							newSpecGdlnGemQLReportEntry.setRegionId(specGdln.getRegionId());
							newSpecGdlnGemQLReportEntry.setComplianceDueDays(specGdln.getComplianceDueDays());
							newSpecGdlnGemQLReportEntry.setGlblMustMeasure(specGdln.getGlblMustMeasure());
							newSpecGdlnGemQLReportEntry.setCreatorId(themeDisplay.getUser().getScreenName());
							newSpecGdlnGemQLReportEntry.setCreatedDate(new Date());
							newSpecGdlnGemQLReportEntry.setUpdatedBy(themeDisplay.getUser().getScreenName());
							newSpecGdlnGemQLReportEntry.setUpdatedDate(new Date());
							newSpecGdlnGemQLReportEntry.setParentQlReportId(newGemQLReportEntry.getQlReportId());
							newSpecGdlnGemQLReportEntry.setDuplicate(DUPLICATE_VALUE_YES);
							newSpecGdlnGemQLReportEntry= GEMQlReportLocalServiceUtil.updateGEMQlReport(newSpecGdlnGemQLReportEntry);
						}
					}
					returnMsg = "Success";
				}
			}
		} catch(Exception e){
			LOG.error("Error in adding duplicate standards "+e.getMessage(), e);
			returnMsg = "Failed";
		}
		return returnMsg;
	}

	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException {
		final String resourceID = resourceRequest.getResourceID();
		Preferences userPreferences = getGEMUserPreferences(resourceRequest);
		String brandCode = userPreferences.getBrand();
		// Use GEM Publish Id
		Publication gemPublish = getActiveGEMPublication(userPreferences.getDepartmentId(), brandCode);
		long gemPublishId = gemPublish.getPublishId();

		LOG.debug("resourceID = " + resourceID);
		if ("getStdRecords".equals(resourceID)) {
			try {
				String std = getStdRecords(resourceRequest, userPreferences, gemPublish);
				PrintWriter writer = resourceResponse.getWriter();
				writer.write(std);
			} catch (Exception e) {
				LOG.error(e.getMessage(), e);
			}
		} else if ("stdIdValidation".equals(resourceID)) {
			try {
				JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
				PrintWriter writer = resourceResponse.getWriter();
				long stdId = ParamUtil.getLong(resourceRequest, "stdId");
				String regionCode = userPreferences.getRegionCode();
				long regionId = BrandStandardsUtil.getRegionId(regionCode);
				List<GEMQlReport> gemQlReportList = GEMQlReportLocalServiceUtil.getSpecGdlnByStdIdPublishIdDuplicate(gemPublishId, regionId, stdId, DUPLICATE_VALUE_NO,"STD");
				if(gemQlReportList.size() > 0){
					jsonObject.put("stdIdExist", "true");
				} else{
					jsonObject.put("stdIdExist", "false");
				}
				writer.write(jsonObject.toString());
			} catch (Exception e) {
				LOG.error("Error in checking standardid exist in gem table " + e.getMessage(), e);
			}

		} else if ("deleteDupicateSTD".equals(resourceID)) {
			PrintWriter writer = resourceResponse.getWriter();
			long qlrptId = ParamUtil.getLong(resourceRequest, "qlrptId");
			String returnMsg ="";
			if(Validator.isNotNull(qlrptId)){
				try {
					GEMQlReport duplicateStd = GEMQlReportLocalServiceUtil.getGEMQlReport(qlrptId);
					if(duplicateStd.getDuplicate().equals(DUPLICATE_VALUE_YES)){
						List<GEMQlReport> specsGdlnsList = GEMQlReportLocalServiceUtil.getByPrntQlReportId(duplicateStd.getQlReportId()); 
						
						for(GEMQlReport specGdln :specsGdlnsList){
							GEMQlReportLocalServiceUtil.deleteGEMQlReport(specGdln);
						}
						GEMQlReportLocalServiceUtil.deleteGEMQlReport(duplicateStd);
						 returnMsg= "Success";
					}
				} catch( Exception e) {
					 returnMsg= "Failed";
					LOG.error("Error in deleteing std from GEMQlReport"+ e.getMessage(), e);
				}
			}
			 writer.write(returnMsg);
		} else if ("duplicateStandard".equals(resourceID)) {
			PrintWriter writer = resourceResponse.getWriter();
			String returnMsg = duplicateStandard(resourceRequest,resourceResponse);
			writer.write(returnMsg);
		} else if ("reloadDuplicateList".equals(resourceID)) {
			String searchIds = ParamUtil.getString(resourceRequest, "stdIds");
			PortletRequestDispatcher dispatcher = resourceRequest.getPortletSession().getPortletContext().getRequestDispatcher("/html/GEM/manageDuplicates/duplicates-list.jsp");
			resourceRequest.setAttribute("searchIds", searchIds);
			dispatcher.include(resourceRequest, resourceResponse);
		}
	}

	private String getStdRecords(ResourceRequest resourceRequest,
			Preferences preferences, Publication gemPublish)
			throws NoSuchPublishDeptException, SystemException {
		String searchIds = ParamUtil.getString(resourceRequest, "searchIds");
		if(Validator.isNotNull(searchIds)){
			searchIds = searchIds.replace(" ", ",");
		}
		String regionCode = preferences.getRegionCode();
		long regionId = BrandStandardsUtil.getRegionId(regionCode);
		String brandCode = preferences.getBrand();
		long gemPublishId = gemPublish.getPublishId();
		int pageNo = ParamUtil.get(resourceRequest, "page", 1);
		int itemsPerPage = ParamUtil.get(resourceRequest, "rows", 20);

		String query = GemQueryUtils.getGemQLDuplicatesRecordsQuery(gemPublish.getParentPublishId(), gemPublishId, regionId, brandCode, searchIds);
		List<QualityLeadModel> recs = GEMQlReportLocalServiceUtil.getGEMDuplicatesReport(query);
		List<QualityLeadModel> list = getSortedStandards(recs);

		resourceRequest.getPortletSession().setAttribute(GemConstants.SESN_ATR_STD_LIST, list);

		JSONArray array = JSONFactoryUtil.createJSONArray();
		final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
		if (list != null && !list.isEmpty()) {
			int size = list.size();
			jsonMain.put("total", size);

			List<QualityLeadModel> finalList = new ArrayList<QualityLeadModel>();
			for (int i = ((pageNo - 1) * itemsPerPage); (i < (itemsPerPage * pageNo) && i < size); i++) {
				QualityLeadModel std = list.get(i);
				finalList.add(std);
				for (QualityLeadModel item : std.getSpecifications()) {
					finalList.add(item);
				}
				for (QualityLeadModel item : std.getGuidelines()) {
					finalList.add(item);
				}
			}

			for (QualityLeadModel std : finalList) {
				array.put(std.toJSON());
			}
		} else {
			jsonMain.put("total", 0);
		}
		jsonMain.put("rows", array);

		return jsonMain.toString();
	}

	public List<QualityLeadModel> getSortedStandards(List<QualityLeadModel> arlDisplayResults) {
		if (arlDisplayResults.isEmpty()) {
			return new ArrayList<QualityLeadModel>();
		}
		List<QualityLeadModel> standardsLst = new ArrayList<QualityLeadModel>();
		List<QualityLeadModel> stdSpecGdln = new ArrayList<QualityLeadModel>();
		for (QualityLeadModel qlModel : arlDisplayResults) {
			if (BSCommonConstants.STD_TYPE_STANDARD.equals(qlModel.getStdType())) {
				standardsLst.add(qlModel);
			} else {
				stdSpecGdln.add(qlModel);
			}
		}

		for (QualityLeadModel std : standardsLst) {
			List<QualityLeadModel> specLst = std.getSpecifications();// return an empty ArrayList if no specifications available
			List<QualityLeadModel> gdlnLst = std.getGuidelines();// return an empty ArrayList if no guidelines available
			boolean recAdded = false;
			for (QualityLeadModel item : stdSpecGdln) {
				if(std.getDuplicateInd().equals(DUPLICATE_VALUE_NO) && item.getDuplicateInd().equals(DUPLICATE_VALUE_NO)){
					if (std.getStdId() == item.getParentStdId()) {
						if (BSCommonConstants.STD_TYPE_SPEC.equals(item.getStdType())) {
							specLst.add(item);
						} else if (BSCommonConstants.STD_TYPE_GDLN.equals(item.getStdType())) {
							gdlnLst.add(item);
						}
						recAdded = true;
					}
				}else if(std.getDuplicateInd().equals(DUPLICATE_VALUE_YES) && item.getDuplicateInd().equals(DUPLICATE_VALUE_YES)){
					if (std.getId() == item.getPrntQltyLeadRrptId()) {
						if (BSCommonConstants.STD_TYPE_SPEC.equals(item.getStdType())) {
							specLst.add(item);
						} else if (BSCommonConstants.STD_TYPE_GDLN.equals(item.getStdType())) {
							gdlnLst.add(item);
						}
						recAdded = true;
					}
				}
				
				
			}

			if (recAdded) {
				cleanup(stdSpecGdln, specLst);
				cleanup(stdSpecGdln, gdlnLst);
			}
			Collections.sort(specLst, new SpecsGuidelinesSortBySTDId());
			Collections.sort(gdlnLst, new SpecsGuidelinesSortBySTDId());
		}
		return standardsLst;
	}

	class SpecsGuidelinesSortBySTDId implements Comparator<QualityLeadModel> {
		/**
		 * @param o1
		 *            - Standards objects.
		 * @param o2
		 *            - Standards objects.
		 * @return integer.
		 */
		public int compare(QualityLeadModel o1, QualityLeadModel o2) {
			int res = 0;
			if (o1.getDisplayOrder() > 0L || o2.getDisplayOrder() > 0L) {
				Long object1 = o1.getDisplayOrder();
				Long object2 = o2.getDisplayOrder();
				res = object1.compareTo(object2);
			} else {
				Long object1 = o1.getStdId();
				Long object2 = o2.getStdId();
				res = object1.compareTo(object2);
			}

			return res;
		}
	}

	private void cleanup(List<QualityLeadModel> stdLst,	List<QualityLeadModel> rmStdLst) {
		for (QualityLeadModel item : rmStdLst) {
			stdLst.remove(item);
		}
	}

	private long getTemplateId(long publishId, long regionId, String templType) {
		long templateId = 0;
		try {
			List<GEMTemplate> list = GEMTemplateLocalServiceUtil.getByPublishIdAndRgnIdAndType(publishId, regionId,	GemConstants.TEMPLATE_TYPE_SE);
			if (list != null && !list.isEmpty()) {
				templateId = list.get(0).getTemplateId();
			}
		} catch (SystemException e) {
			LOG.error("Failed to get " + templType + " temlates:" + e);
		}
		return templateId;
	}

	protected String managementBucketToJSONString(List<GEMManagementBucket> buckets) {
		JSONArray array = JSONFactoryUtil.createJSONArray();

		for (GEMManagementBucket bkt : buckets) {
			JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			jsonObject.put("seRptCatgy", bkt.getBucketId());
			jsonObject
					.put("seRptCatgyNm", HtmlUtil.escape(bkt.getBucketName()));
			array.put(jsonObject);
		}
		return array.toString();
	}
}
