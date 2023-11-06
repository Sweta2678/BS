package com.ihg.brandstandards.custom.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;

import javax.portlet.PortletRequest;
import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import org.apache.commons.lang.BooleanUtils;
import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.util.StandardsListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.util.PortalUtil;

/**
 * Store Search criteria.
 * 
 * @author KryvorA
 * 
 */
public class CMSSearchCriteria implements Serializable, Cloneable
{
    private static final long serialVersionUID = 4256L;

    private static final String HIST_MANUAL_PARAM = "historicalManual";
    private static final String FROM_LAUNCH_DATE_PARAM = "fromLaunchDate";
    private static final String TO_LAUNCH_DATE_PARAM = "toLaunchDate";
    private static final String BRND_HALLMARK_PARAM = "brandHallmark";
    private static final String FROM_COMPL_DATE_PARAM = "fromComplianceDate";
    private static final String TO_COMPL_DATE_PARAM = "toComplianceDate";
    private static final String INDX_HEADING_PARAM = "indexHeading";
    private static final String RECORD_ID_PARAM = "recordId";
    private static final String HAS_LINKS_PARAM = "hasLinks";
    private static final String HAS_GUIDELINE_PARAM = "hasGuidelines";
    private static final String HAS_CROSSREFERENCE_PARAM = "hasCrossReference";
    private static final String INDEX_BRANCH_ONLY_PARAM = "branchOnly";
    private static final String INDEX_BRANCH_SEARCH_PARAM = "branchSearch";
    private static final String FETCH_ALL_SPEC_GDLN_PARAM = "showAllSpecsGuidelines";
    private static final String FLAG_YES_PARAM = "Y";
    private static final String TEXT_SEARCH_TYPE = "searchOptions";
    private static final String HOTEL_LIFE_CYCLE = "hotellifecycle"; 
   
    public static final String DIVIDER_VAL = ":::";
//    private static final String DIVIDER_DATA = ";;; ";
    private static final String DIVIDER_MAP_VAL = "===";
    
    private List<String> brands;
    private List<String> countries;
    private List<String> searchCriteria;
    private List<String> rationale;
    private List<String> status;
    private List<String> techWriter;
    private List<String> category;
    private List<String> changeType;
    private List<String> attachType;
    private List<String> stdOwner;
    private List<String> flags;
    private List<String> corpDept;
    private List<String> deptApplicability;
    private List<String> guestJourney;
    private List<String> importance;
    private List<String> locHotel;
    private List<String> wheelQuad;
    private List<String> manual;
    private List<String> ownershipType;
    private List<String> profitLossImpact;
    private List<String> capExImpact;
    private List<String> implementationImpact;
    private List<String> impact;
    private List<String> changeFromRegionalImpact;
    private List<String> impactComments;
    private List<String> standardsIds;
    private List<String> authors;
    private List<String> designDiscipline;
    private List<String> risk;
    private List<String> measurement;
    private List<String> gemReportCategory;
    private List<String> areaForMeasurement;
    private List<String> hotelLifecycle;
    private List<String> specialistArea;
    private List<String> digital;
    private List<String> brandsafetystandards;
    
    private Map<String, String> image;

    private String searchLog;
    private String logDate;
    private String toLogDate;
    private String logCriteria;
    private String logCreatedBy;
    private String enteredBy;

    private String histManual;
    private String fromLaunchDate;
    private String toLaunchDate;
    private String brandHallmark;
    private String fromCompDate;
    private String toCompDate;
    private String index;
    private String recordId;
    private String textSearchType;
    private String internalReference;

    private boolean hasLinks;
    private boolean hasGuidelines;
    private boolean hasCrossReference;
    private boolean branchOnly;

    private boolean approver;
    private String reportId;
    private boolean fetchAllSpecGuideline;
    private String defaultLangLocaleCd = "en_GB";
    private String secondLangLocaleCd;

    private List<String> auditLogBrands ;
    private String preferedBrand;
    private String publishEnvironment;
    private long publishQueueId;
    private long publishId;
    private String discontFilter;

    /**
     * default constructor.
     */
    public CMSSearchCriteria()
    {
    }

    /**
     * Preferred constructor.
     * 
     * @param request - RenderRequest
     */
    public CMSSearchCriteria(final RenderRequest request)
    {
        init(request, true);
    }

    /**
     * Preferred constructor.
     * 
     * @param request - ResourceRequest
     */
    public CMSSearchCriteria(final ResourceRequest request)
    {
        init(request, false);
    }

    /**
     * Preferred constructor.
     * 
     * @param searchFields map of fields
     */
    public CMSSearchCriteria(final Map<String, String> searchFields)
    {
        init(searchFields);
    }

    /**
     * Fetch data from PortletRequest.
     * 
     * @param request - PortletRequest
     * @param isRenderRequest - is it render request?
     */
    private void init(final PortletRequest request, final boolean isRenderRequest)
    {
        final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);

        this.brands = StandardsListUtil.getBrandsFromRequest(httpRequest, isRenderRequest);
        this.countries = StandardsListUtil.getCountriesFromRequest(httpRequest, isRenderRequest);
        this.searchCriteria = StandardsListUtil.getCriteriaFromRequest(httpRequest, isRenderRequest);
        this.rationale = StandardsListUtil.getRationaleFromRequest(httpRequest, isRenderRequest);
        this.status = StandardsListUtil.getStatusFromRequest(httpRequest, isRenderRequest);
        this.techWriter = StandardsListUtil.getTechWriterFromRequest(httpRequest, isRenderRequest);
        this.category = StandardsListUtil.getCategoryFromRequest(httpRequest, isRenderRequest);
        this.changeType = StandardsListUtil.getChangeTypeFromRequest(httpRequest, isRenderRequest);
        this.attachType = StandardsListUtil.getAttachTypeFromRequest(httpRequest, isRenderRequest);
        this.flags = StandardsListUtil.getFlagsList(httpRequest, isRenderRequest);
        this.impact = StandardsListUtil.getImpactAssessmentListList(httpRequest, isRenderRequest);
        this.standardsIds = StandardsListUtil.getStandardsIdsFromRequest(httpRequest, isRenderRequest);
        this.textSearchType = ParamUtil.getString(request, TEXT_SEARCH_TYPE);
        this.auditLogBrands = StandardsListUtil.getAuditLogBrandsFromRequest(httpRequest, isRenderRequest);
        
        // separate flags
        this.corpDept = StandardsListUtil.getCorpDeptFromRequest(httpRequest, isRenderRequest);
        this.deptApplicability = StandardsListUtil.getDeptApplicabilityFromRequest(httpRequest, isRenderRequest);
        this.guestJourney = StandardsListUtil.getGuestJourneyFromRequest(httpRequest, isRenderRequest);
        this.importance = StandardsListUtil.getImportanceFromRequest(httpRequest, isRenderRequest);
        this.designDiscipline = StandardsListUtil.getDesignDisciplineFromRequest(httpRequest, isRenderRequest);
        this.risk = StandardsListUtil.getRiskFromRequest(httpRequest, isRenderRequest);
        this.measurement = StandardsListUtil.getMeasurementFromRequest(httpRequest, isRenderRequest);
        this.gemReportCategory = StandardsListUtil.getGemReportCategoryFromRequest(httpRequest, isRenderRequest);
        this.areaForMeasurement = StandardsListUtil.getAreaForMeasurementFromRequest(httpRequest, isRenderRequest);
        //this.hotelLifecycle = StandardsListUtil.getParamFromRequest(httpRequest, isRenderRequest, "hotellifecycle", "hotellifecycle[]");
        this.specialistArea = StandardsListUtil.getParamFromRequest(httpRequest, isRenderRequest, "specialistarea", "specialistarea[]");
        this.digital = StandardsListUtil.getParamFromRequest(httpRequest, isRenderRequest, "digital", "digital[]");
        this.brandsafetystandards = StandardsListUtil.getParamFromRequest(httpRequest, isRenderRequest, "brandsafetystandards", "brandsafetystandards[]");
        this.locHotel = StandardsListUtil.getLocHotelFromRequest(httpRequest, isRenderRequest);
        this.wheelQuad = StandardsListUtil.getWheelQuadrantFromRequest(httpRequest, isRenderRequest);
        this.manual = StandardsListUtil.getManualFromRequest(httpRequest, isRenderRequest);
        this.ownershipType = StandardsListUtil.getOwnershipTypeFromRequest(httpRequest, isRenderRequest);
        this.profitLossImpact = StandardsListUtil.getProfitLossImpactFromRequest(httpRequest, isRenderRequest);
        this.capExImpact = StandardsListUtil.getCapExImpactFromRequest(httpRequest, isRenderRequest);
        this.implementationImpact = StandardsListUtil.getImplImpactFromRequest(httpRequest, isRenderRequest);
        this.changeFromRegionalImpact = StandardsListUtil.getChangeFromRegionalFromRequest(httpRequest, isRenderRequest);
        this.impactComments = StandardsListUtil.getImpactCommentsFromRequest(httpRequest, isRenderRequest);
        this.image = StandardsListUtil.getImageFromRequest(httpRequest, isRenderRequest);

        this.stdOwner = StandardsListUtil.getStdOwnerFromRequest(httpRequest, isRenderRequest);
        this.histManual = "0".equals(ParamUtil.getString(request, HIST_MANUAL_PARAM)) ? "" : ParamUtil.getString(request,
                HIST_MANUAL_PARAM);
        this.fromLaunchDate = ParamUtil.getString(request, FROM_LAUNCH_DATE_PARAM);
        this.toLaunchDate = ParamUtil.getString(request, TO_LAUNCH_DATE_PARAM);
        this.brandHallmark = ParamUtil.getString(request, BRND_HALLMARK_PARAM);
        this.fromCompDate = ParamUtil.getString(request, FROM_COMPL_DATE_PARAM);
        this.toCompDate = ParamUtil.getString(request, TO_COMPL_DATE_PARAM);
        this.index = "0".equals(ParamUtil.getString(request, INDX_HEADING_PARAM)) ? "" : ParamUtil.getString(request,
                INDX_HEADING_PARAM);
        this.recordId = ParamUtil.getString(request, RECORD_ID_PARAM);
        this.hasLinks = FLAG_YES_PARAM.equals(ParamUtil.getString(request, HAS_LINKS_PARAM).trim());
        this.hasGuidelines = FLAG_YES_PARAM.equals(ParamUtil.getString(request, HAS_GUIDELINE_PARAM).trim());
        this.hasCrossReference = FLAG_YES_PARAM.equals(ParamUtil.getString(request, HAS_CROSSREFERENCE_PARAM).trim());
        this.branchOnly = INDEX_BRANCH_ONLY_PARAM.equals(ParamUtil.getString(request, INDEX_BRANCH_SEARCH_PARAM).trim());
        this.fetchAllSpecGuideline = FLAG_YES_PARAM.equals(ParamUtil.getString(request, FETCH_ALL_SPEC_GDLN_PARAM).trim());

        this.authors = StandardsListUtil.getAuthorsFromRequest(httpRequest, isRenderRequest);
        this.logDate = StandardsListUtil.getLogDateFromRequest(httpRequest, isRenderRequest);
        this.toLogDate = StandardsListUtil.getToLogDate();
        this.searchLog = ParamUtil.getString(request, "auditLogFilter");
        this.logCriteria = ParamUtil.getString(request, "logRelativeCriteria");
        this.logCreatedBy = ParamUtil.getString(request, "logCreatedBy");
        this.enteredBy = ParamUtil.getString(request, "enteredBy");
        this.internalReference = ParamUtil.getString(request, "internal_reference");
        // CR 50.2 Change
        this.hotelLifecycle = StandardsListUtil.getHotelLifeCycleParam(ParamUtil.getString(request, HOTEL_LIFE_CYCLE));
        
    }

    /**
     * Getter for brands.
     * 
     * @return list
     */
    public List<String> getBrands()
    {
        return brands;
    }

    /**
     * Setter for Brands.
     * 
     * @param brands - list of brands
     */
    public void setBrands(final List<String> brands)
    {
        this.brands = brands;
    }

    /**
     * Getter for countries.
     * 
     * @return list
     */
    public List<String> getCountries()
    {
        return countries;
    }

    /**
     * Setter for for countries.
     * 
     * @param countries - list of countries
     */
    public void setCountries(final List<String> countries)
    {
        this.countries = countries;
    }

    /**
     * Getter for search criteria - Standard, Specification or Guideline text .
     * 
     * @return list
     */
    public List<String> getSearchCriteria()
    {
        return searchCriteria;
    }

    /**
     * Setter for Standard, Specification or Guideline text.
     * 
     * @param searchCriteria - list of search criteria
     */
    public void setSearchCriteria(final List<String> searchCriteria)
    {
        this.searchCriteria = searchCriteria;
    }

    /**
     * Getter Standard, Specification or Guideline text.
     * 
     * @return list
     */
    public List<String> getTitleText()
    {
        return getSearchCriteria();
    }

    /**
     * Setter for Standard, Specification or Guideline text.
     * 
     * @param titleText - Standard, Specification or Guideline text.
     */
    public void setTitleText(final List<String> titleText)
    {
        setSearchCriteria(titleText);
    }

    /**
     * Getter for Rationale.
     * 
     * @return list
     */
    public List<String> getRationale()
    {
        return rationale;
    }

    /**
     * Setter for Rationale.
     * 
     * @param rationale - list of rationale
     */
    public void setRationale(final List<String> rationale)
    {
        this.rationale = rationale;
    }

    /**
     * Getter for status.
     * 
     * @return list
     */
    public List<String> getStatus()
    {
        return status;
    }

    /**
     * Setter for status.
     * 
     * @param status - list of statuses
     */
    public void setStatus(final List<String> status)
    {
        this.status = status;
    }

    /**
     * Getter for Technical Writer.
     * 
     * @return list
     */
    public List<String> getTechWriter()
    {
        return techWriter;
    }

    /**
     * Setter for Technical Writer.
     * 
     * @param techWriter - list of writers
     */
    public void setTechWriter(final List<String> techWriter)
    {
        this.techWriter = techWriter;
    }

    /**
     * Getter for category.
     * 
     * @return list
     */
    public List<String> getCategory()
    {
        return category;
    }

    /**
     * Setter for category.
     * 
     * @param category - list of categories
     */
    public void setCategory(final List<String> category)
    {
        this.category = category;
    }

    /**
     * Getter for change type.
     * 
     * @return list
     */
    public List<String> getChangeType()
    {
        return changeType;
    }

    /**
     * Setter for change type.
     * 
     * @param changeType - list of change types
     */
    public void setChangeType(final List<String> changeType)
    {
        this.changeType = changeType;
    }

    /**
     * Getter for attachment type.
     * 
     * @return list
     */
    public List<String> getAttachType()
    {
        return attachType;
    }

    /**
     * Setter for attachment type.
     * 
     * @param attachType - list of attachment types
     */
    public void setAttachType(final List<String> attachType)
    {
        this.attachType = attachType;
    }

    /**
     * Getter for owner.
     * 
     * @return list
     */
    public List<String> getStdOwner()
    {
        return stdOwner;
    }

    /**
     * Setter for owner.
     * 
     * @param stdOwner - list of owners
     */
    public void setStdOwner(final List<String> stdOwner)
    {
        this.stdOwner = stdOwner;
    }

    /**
     * Getter for flags.
     * 
     * @return list
     */
    public List<String> getFlags()
    {
        return flags;
    }

    /**
     * Setter for flags.
     * 
     * @param flags - list of flags
     */
    public void setFlags(final List<String> flags)
    {
        this.flags = flags;
    }

    /**
     * Get Impact Assessment list.
     * 
     * @return list
     */
    public List<String> getImpact()
    {
        return impact;
    }

    /**
     * Set Impact Assessment.
     * 
     * @param impact - Impact Assessment
     */
    public void setImpact(final List<String> impact)
    {
        this.impact = impact;
    }

    /**
     * Get Change from Regional.
     * 
     * @return the changeFromRegionalImpact
     */
    public List<String> getChangeFromRegionalImpact()
    {
        return changeFromRegionalImpact;
    }

    /**
     * Set Change from Regional.
     * 
     * @param changeFromRegionalImpact the changeFromRegionalImpact to set
     */
    public void setChangeFromRegionalImpact(List<String> changeFromRegionalImpact)
    {
        this.changeFromRegionalImpact = changeFromRegionalImpact;
    }

    /**
     * Getter for Corporate Department.
     * 
     * @return list
     */
    public List<String> getCorpDept()
    {
        return corpDept;
    }

    /**
     * Setter for Corporate Department.
     * 
     * @param corpDept - list of Corporate Departments
     */
    public void setCorpDept(final List<String> corpDept)
    {
        this.corpDept = corpDept;
    }

    /**
     * Getter for department applicability.
     * 
     * @return list
     */
    public List<String> getDeptApplicability()
    {
        return deptApplicability;
    }

    /**
     * Setter for department applicability.
     * 
     * @param deptApplicability - list of department applicability
     */
    public void setDeptApplicability(final List<String> deptApplicability)
    {
        this.deptApplicability = deptApplicability;
    }

    /**
     * Getter for guest journey.
     * 
     * @return list
     */
    public List<String> getGuestJourney()
    {
        return guestJourney;
    }

    /**
     * Setter for guest journey.
     * 
     * @param guestJourney - list of guest journey
     */
    public void setGuestJourney(final List<String> guestJourney)
    {
        this.guestJourney = guestJourney;
    }

    /**
     * Getter for importance.
     * 
     * @return list
     */
    public List<String> getImportance()
    {
        return importance;
    }

    /**
     * Setter for importance.
     * 
     * @param importance - list of importance
     */
    public void setImportance(final List<String> importance)
    {
        this.importance = importance;
    }

    /**
     * Getter for location within hotel.
     * 
     * @return list
     */
    public List<String> getLocHotel()
    {
        return locHotel;
    }

    /**
     * Setter for location within hotel.
     * 
     * @param locHotel - locations within hotel.
     */
    public void setLocHotel(final List<String> locHotel)
    {
        this.locHotel = locHotel;
    }

    /**
     * Getter for wheel quadrant.
     * 
     * @return list
     */
    public List<String> getWheelQuad()
    {
        return wheelQuad;
    }

    /**
     * Setter for wheel quadrant.
     * 
     * @param wheelQuad - list of wheel quadrants
     */
    public void setWheelQuad(final List<String> wheelQuad)
    {
        this.wheelQuad = wheelQuad;
    }

    /**
     * Getter for manual.
     * 
     * @return list
     */
    public List<String> getManual()
    {
        return manual;
    }

    /**
     * Setter for manual.
     * 
     * @param manual - manuals
     */
    public void setManual(final List<String> manual)
    {
        this.manual = manual;
    }

    /**
     * Getter for ownership type.
     * 
     * @return list
     */
    public List<String> getOwnershipType()
    {
        return ownershipType;
    }

    /**
     * Setter for ownership type.
     * 
     * @param ownershipType - ownership types
     */
    public void setOwnershipType(final List<String> ownershipType)
    {
        this.ownershipType = ownershipType;
    }

    /**
     * Getter for Historical Manual.
     * 
     * @return String
     */
    public String getHistManual()
    {
        return histManual;
    }

    /**
     * Get P&L Impact.
     * 
     * @return list
     */
    public List<String> getProfitLossImpact()
    {
        return profitLossImpact;
    }

    /**
     * Set P&L Impact.
     * 
     * @param profitLossImpact - P&L Impact
     */
    public void setProfitLossImpact(final List<String> profitLossImpact)
    {
        this.profitLossImpact = profitLossImpact;
    }

    /**
     * Get CapEx Impact.
     * 
     * @return list
     */
    public List<String> getCapExImpact()
    {
        return capExImpact;
    }

    /**
     * Set CapEx Impact.
     * 
     * @param capExImpact - CapEx Impact
     */
    public void setCapExImpact(final List<String> capExImpact)
    {
        this.capExImpact = capExImpact;
    }

    /**
     * Get Implementation Impact.
     * 
     * @return - list
     */
    public List<String> getImplementationImpact()
    {
        return implementationImpact;
    }

    /**
     * Set Implementation Impact.
     * 
     * @param implementationImpact - Implementation Impact
     */
    public void setImplementationImpact(final List<String> implementationImpact)
    {
        this.implementationImpact = implementationImpact;
    }

    /**
     * Get Impact Comments.
     * 
     * @return the impactComments
     */
    public List<String> getImpactComments()
    {
        return impactComments;
    }

    /**
     * Set Impact Comments.
     * 
     * @param impactComments the impactComments to set
     */
    public void setImpactComments(List<String> impactComments)
    {
        this.impactComments = impactComments;
    }

    /**
     * Setter for historical manual.
     * 
     * @param histManual - historical manuals
     */
    public void setHistManual(final String histManual)
    {
        this.histManual = histManual;
    }

    /**
     * Getter for From Launch Date.
     * 
     * @return String
     */
    public String getFromLaunchDate()
    {
        return fromLaunchDate;
    }

    /**
     * Setter for From Launch Date.
     * 
     * @param fromLaunchDate - From Launch Date
     */
    public void setFromLaunchDate(final String fromLaunchDate)
    {
        this.fromLaunchDate = fromLaunchDate;
    }

    /**
     * Getter for to launch date.
     * 
     * @return String
     */
    public String getToLaunchDate()
    {
        return toLaunchDate;
    }

    /**
     * Setter for to launch date.
     * 
     * @param toLaunchDate - to Launch Date
     */
    public void setToLaunchDate(final String toLaunchDate)
    {
        this.toLaunchDate = toLaunchDate;
    }

    /**
     * Getter for Brand Hallmark.
     * 
     * @return String
     */
    public String getBrandHallmark()
    {
        return brandHallmark;
    }

    /**
     * Setter for Brand Hallmark.
     * 
     * @param brandHallmark - Brand Hallmark
     */
    public void setBrandHallmark(final String brandHallmark)
    {
        this.brandHallmark = brandHallmark;
    }

    /**
     * Getter for from compliance deadline.
     * 
     * @return String
     */
    public String getFromCompDate()
    {
        return fromCompDate;
    }

    /**
     * Setter for from compliance deadline.
     * 
     * @param fromCompDate - from compliance deadline
     */
    public void setFromCompDate(final String fromCompDate)
    {
        this.fromCompDate = fromCompDate;
    }

    /**
     * Getter for to compliance deadline.
     * 
     * @return String
     */
    public String getToCompDate()
    {
        return toCompDate;
    }

    /**
     * Setter for to compliance deadline.
     * 
     * @param toCompDate - to compliance deadline
     */
    public void setToCompDate(final String toCompDate)
    {
        this.toCompDate = toCompDate;
    }

    /**
     * Getter for Index.
     * 
     * @return String
     */
    public String getIndex()
    {
        return index;
    }

    /**
     * Setter for Index.
     * 
     * @param index - taxonomy index
     */
    public void setIndex(final String index)
    {
        this.index = index;
    }

    /**
     * Getter for record id.
     * 
     * @return the recordId
     */
    public String getRecordId()
    {
        return recordId;
    }

    /**
     * Setter for record id.
     * 
     * @param recordId the recordId to set
     */
    public void setRecordId(String recordId)
    {
        this.recordId = recordId;
    }

    /**
     * Getter for Text Search.
     * 
     * @return text search string.
     */
    public String getTextSearchType()
    {
        return textSearchType;
    }

    /**
     * Setter for Text Search.
     * 
     * @param textSearchType
     */
    public void setTextSearchType(String textSearchType)
    {
        this.textSearchType = textSearchType;
    }

    /**
     * Getter for has links.
     * 
     * @return String
     */
    public boolean isHasLinks()
    {
        return hasLinks;
    }

    /**
     * Setter for has links.
     * 
     * @param hasLinks - has links
     */
    public void setHasLinks(final boolean hasLinks)
    {
        this.hasLinks = hasLinks;
    }

    /**
     * Getter for has guidelines.
     * 
     * @return String
     */
    public boolean isHasGuidelines()
    {
        return hasGuidelines;
    }

    /**
     * Setter for has guidelines.
     * 
     * @param hasGuidelines - flag for has guidelines
     */
    public void setHasGuidelines(final boolean hasGuidelines)
    {
        this.hasGuidelines = hasGuidelines;
    }

    /**
     * @return the hasCrossReference
     */
    public boolean isHasCrossReference()
    {
        return hasCrossReference;
    }

    /**
     * @param hasCrossReference the hasCrossReference to set
     */
    public void setHasCrossReference(final boolean hasCrossReference)
    {
        this.hasCrossReference = hasCrossReference;
    }

    /**
     * Getter for search on selected branch only.
     * 
     * @return the branchOnly
     */
    public boolean isBranchOnly()
    {
        return branchOnly;
    }

    /**
     * Setter for search on selected branch only.
     * 
     * @param branchOnly the branchOnly to set
     */
    public void setBranchOnly(boolean branchOnly)
    {
        this.branchOnly = branchOnly;
    }

    /**
     * Flag for fetch all Spec and Guideline records.
     * 
     * @return the fetchAllSpecGuideline
     */
    public boolean isFetchAllSpecGuideline()
    {
        return fetchAllSpecGuideline;
    }

    /**
     * Setter for flag for fetch all Spec and Guideline records.
     * 
     * @param fetchAllSpecGuideline the fetchAllSpecGuideline to set
     */
    public void setFetchAllSpecGuideline(boolean fetchAllSpecGuideline)
    {
        this.fetchAllSpecGuideline = fetchAllSpecGuideline;
    }

    /**
     * Setter for flag for fetch all Spec and Guideline records from request.
     * 
     * @param request ResourceRequest
     */
    public void setFetchAllSpecGuideline(final ResourceRequest request)
    {
        this.fetchAllSpecGuideline = FLAG_YES_PARAM.equals(ParamUtil.getString(request, FETCH_ALL_SPEC_GDLN_PARAM).trim());
    }

    /**
     * Verify if user specified search criteria.
     * 
     * @return true when at least one value exists, otherwise false
     */
    public boolean isEmpty()
    {
        return StandardsListUtil.isNullOrBlank(brands) && StandardsListUtil.isNullOrBlank(countries)
                && StandardsListUtil.isNullOrBlank(searchCriteria) && StandardsListUtil.isNullOrBlank(rationale)
                && StandardsListUtil.isNullOrBlank(status) && StandardsListUtil.isNullOrBlank(techWriter)
                && StandardsListUtil.isNullOrBlank(category) && StandardsListUtil.isNullOrBlank(changeType)
                && StandardsListUtil.isNullOrBlank(attachType) && StandardsListUtil.isNullOrBlank(stdOwner)
                && StandardsListUtil.isNullOrBlank(flags) && StandardsListUtil.IsNullOrBlank(histManual)
                && StandardsListUtil.IsNullOrBlank(fromLaunchDate) && StandardsListUtil.IsNullOrBlank(toLaunchDate)
                && StandardsListUtil.IsNullOrBlank(brandHallmark) && StandardsListUtil.IsNullOrBlank(fromCompDate)
                && StandardsListUtil.IsNullOrBlank(toCompDate) && StandardsListUtil.IsNullOrBlank(index)
                && StandardsListUtil.IsNullOrBlank(recordId) && StandardsListUtil.isNullOrBlank(image) && !hasLinks
                && !hasGuidelines && !branchOnly && !hasCrossReference && StandardsListUtil.isNullOrBlank(impact)
                && StandardsListUtil.isNullOrBlank(changeFromRegionalImpact) && StandardsListUtil.isNullOrBlank(impactComments)
                && StandardsListUtil.isNullOrBlank(standardsIds) && StandardsListUtil.isNullOrBlank(authors)
                && StandardsListUtil.IsNullOrBlank(logDate) && StandardsListUtil.IsNullOrBlank(searchLog)
                && StandardsListUtil.IsNullOrBlank(enteredBy) && StandardsListUtil.isNullOrBlank(designDiscipline)
                && StandardsListUtil.isNullOrBlank(risk) && StandardsListUtil.isNullOrBlank(measurement) && StandardsListUtil.isNullOrBlank(hotelLifecycle) 
                && StandardsListUtil.isNullOrBlank(gemReportCategory) && StandardsListUtil.isNullOrBlank(areaForMeasurement)
                && StandardsListUtil.isNullOrBlank(specialistArea) && StandardsListUtil.isNullOrBlank(digital)&& StandardsListUtil.isNullOrBlank(brandsafetystandards)
                && StandardsListUtil.IsNullOrBlank(internalReference);
    }

    /**
     * If user has Approver Role.
     * 
     * @return true/false
     */
    public boolean isApprover()
    {
        return approver;
    }

    /**
     * Set approver Role flag.
     * 
     * @param approver - true/false
     */
    public void setApprover(final boolean approver)
    {
        this.approver = approver;
    }

    /**
     * Getter for Report Id.
     * 
     * @return the reportId
     */
    public String getReportId()
    {
        return reportId;
    }

    /**
     * Setter for Report Id.
     * 
     * @param reportId the reportId to set
     */
    public void setReportId(String reportId)
    {
        this.reportId = reportId;
    }

    /**
     * Getter for default report language locale code.
     * 
     * @return the defaultLangLocaleCd
     */
    public String getDefaultLangLocaleCd()
    {
        return defaultLangLocaleCd;
    }

    /**
     * Setter for default report language locale code.
     * 
     * @param defaultLangLocaleCd the defaultLangLocaleCd to set
     */
    public void setDefaultLangLocaleCd(String defaultLangLocaleCd)
    {
        this.defaultLangLocaleCd = defaultLangLocaleCd;
    }

    /**
     * Setter for second report language locale code.
     * 
     * @return the secondLangLocaleCd
     */
    public String getSecondLangLocaleCd()
    {
        return secondLangLocaleCd;
    }

    /**
     * Getter for second report language locale code.
     * 
     * @param secondLangLocaleCd the secondLangLocaleCd to set
     */
    public void setSecondLangLocaleCd(String secondLangLocaleCd)
    {
        this.secondLangLocaleCd = secondLangLocaleCd;
    }

    /**
     * Get list of Standard Ids.
     * 
     * @return List of Standard Ids.
     */
    public List<String> getStandardsIds()
    {
        return standardsIds;
    }

    /**
     * Setter for Standard Ids.
     * 
     * @param standardsIds
     */
    public void setStandardsIds(List<String> standardsIds)
    {
        this.standardsIds = standardsIds;
    }

    /**
     * Getter for image id/image name.
     * 
     * @return Map of the image id/image name.
     */
    public Map<String, String> getImage()
    {
        return image;
    }

    /**
     * Getter for image ids.
     * 
     * @return list of the image ids.
     */
    public List<String> getImageId()
    {
        List<String> imgId = new ArrayList<String>();
        if (!StandardsListUtil.isNullOrBlank(image))
        {
            for (Entry<String, String> entry : image.entrySet())
            {
                imgId.add(entry.getKey());
            }
        }
        return imgId;
    }

    /**
     * Setter for image ids.
     * 
     * @param image the image to set
     */
    public void setImage(Map<String, String> image)
    {
        this.image = image;
    }

    /**
     * Getter for Authors.
     * 
     * @return list of Authors
     */
    public List<String> getAuthors()
    {
        return authors;
    }

    /**
     * Setter for Authors.
     * 
     * @param authors list of Authors
     */
    public void setAuthors(List<String> authors)
    {
        this.authors = authors;
    }

    public String getLogDate()
    {
        return logDate;
    }

    public void setLogDate(String logDate)
    {
        this.logDate = logDate;
    }

    public String getSearchLog()
    {
        return searchLog;
    }

    public void setSearchLog(String searchLog)
    {
        this.searchLog = searchLog;
    }

    public String getToLogDate()
    {
        return toLogDate;
    }

    public void setToLogDate(String toLogDate)
    {
        this.toLogDate = toLogDate;
    }

    public String getLogCriteria()
    {
        return logCriteria;
    }

    public void setLogCriteria(String logCriteria)
    {
        this.logCriteria = logCriteria;
    }

    public String getLogCreatedBy()
    {
        return logCreatedBy;
    }

    public void setLogCreatedBy(String logCreatedBy)
    {
        this.logCreatedBy = logCreatedBy;
    }

    public String getEnteredBy()
    {
        return enteredBy;
    }

    public void setEnteredBy(String enteredBy)
    {
        this.enteredBy = enteredBy;
    }

    /**
     * (non-Javadoc).
     * 
     * @see java.lang.Object#clone()
     */
    public CMSSearchCriteria clone() throws CloneNotSupportedException
    {
        CMSSearchCriteria newCriteria = new CMSSearchCriteria();
        newCriteria.setBrands(brands);
        newCriteria.setCountries(countries);
        newCriteria.setSearchCriteria(searchCriteria);
        newCriteria.setRationale(rationale);
        newCriteria.setStatus(status);
        newCriteria.setTechWriter(techWriter);
        newCriteria.setCategory(category);
        newCriteria.setChangeType(changeType);
        newCriteria.setAttachType(attachType);
        newCriteria.setStdOwner(stdOwner);
        newCriteria.setFlags(flags);
        newCriteria.setCorpDept(corpDept);
        newCriteria.setDeptApplicability(deptApplicability);
        newCriteria.setGuestJourney(guestJourney);
        newCriteria.setImportance(importance);
        newCriteria.setLocHotel(locHotel);
        newCriteria.setWheelQuad(wheelQuad);
        newCriteria.setManual(manual);
        newCriteria.setOwnershipType(ownershipType);
        newCriteria.setProfitLossImpact(profitLossImpact);
        newCriteria.setCapExImpact(capExImpact);
        newCriteria.setImplementationImpact(implementationImpact);
        newCriteria.setImpact(impact);
        newCriteria.setChangeFromRegionalImpact(changeFromRegionalImpact);
        newCriteria.setImpactComments(impactComments);
        newCriteria.setHistManual(histManual);
        newCriteria.setFromLaunchDate(fromLaunchDate);
        newCriteria.setToLaunchDate(toLaunchDate);
        newCriteria.setBrandHallmark(brandHallmark);
        newCriteria.setFromCompDate(fromCompDate);
        newCriteria.setToCompDate(toCompDate);
        newCriteria.setIndex(index);
        newCriteria.setHasLinks(hasLinks);
        newCriteria.setHasGuidelines(hasGuidelines);
        newCriteria.setHasCrossReference(hasCrossReference);
        newCriteria.setApprover(approver);
        newCriteria.setReportId(reportId);
        newCriteria.setStandardsIds(standardsIds);
        newCriteria.setTextSearchType(textSearchType);
        newCriteria.setFetchAllSpecGuideline(fetchAllSpecGuideline);
        newCriteria.setAuthors(authors);
        newCriteria.setLogDate(logDate);
        newCriteria.setStandardsIds(standardsIds);
        newCriteria.setSearchLog(searchLog);
        newCriteria.setToLogDate(toLogDate);
        newCriteria.setLogCriteria(logCriteria);
        newCriteria.setLogCreatedBy(logCreatedBy);
        newCriteria.setEnteredBy(enteredBy);
        newCriteria.setImage(image);
        newCriteria.setDesignDiscipline(designDiscipline);
        newCriteria.setRisk(risk);
        newCriteria.setMeasurement(measurement);
        newCriteria.setGemReportCategory(gemReportCategory);
        newCriteria.setAreaForMeasurement(areaForMeasurement);
        newCriteria.setInternalReference(internalReference);
        newCriteria.setAuditLogBrands(auditLogBrands);
        newCriteria.setPreferedBrand(preferedBrand);
        newCriteria.setPublishEnvironment(publishEnvironment);
        newCriteria.setPublishId(publishId);
        newCriteria.setPublishQueueId(publishQueueId);
        newCriteria.setDiscontFilter(discontFilter);
        return newCriteria;
    }

    public List<String> getDesignDiscipline()
    {
        return designDiscipline;
    }

    public void setDesignDiscipline(List<String> designDiscipline)
    {
        this.designDiscipline = designDiscipline;
    }

    public List<String> getRisk()
    {
        return risk;
    }

    public void setRisk(List<String> risk)
    {
        this.risk = risk;
    }

    public List<String> getMeasurement()
    {
        return measurement;
    }

    public void setMeasurement(List<String> measurement)
    {
        this.measurement = measurement;
    }

    
    /**
     * Getter for GEM Report Category.
     * @return the gemReportCategory
     */
    public List<String> getGemReportCategory()
    {
        return gemReportCategory;
    }

    /**
     * Setter for GEM Report Category.
     * @param gemReportCategory the gemReportCategory to set
     */
    public void setGemReportCategory(List<String> gemReportCategory)
    {
        this.gemReportCategory = gemReportCategory;
    }

    /**
     * Getter for Area within Hotel for Measurement.
     * @return the areaForMeasurement
     */
    public List<String> getAreaForMeasurement()
    {
        return areaForMeasurement;
    }

    /**
     * Setter for Area within Hotel for Measurement.
     * @param areaForMeasurement the areaForMeasurement to set
     */
    public void setAreaForMeasurement(List<String> areaForMeasurement)
    {
        this.areaForMeasurement = areaForMeasurement;
    }

    public String getInternalReference()
    {
        return internalReference;
    }

    public void setInternalReference(String internalReference)
    {
        this.internalReference = internalReference;
    }

    /**
     * Getter.
     * @return the preferedBrand
     */
    public String getPreferedBrand()
    {
        return preferedBrand;
    }

    /** 
     * Setter.
     * @param preferedBrand the preferedBrand to set
     */
    public void setPreferedBrand(String preferedBrand)
    {
        this.preferedBrand = preferedBrand;
    }

    public List<String> getAuditLogBrands()
    {
        return auditLogBrands;
    }

    public void setAuditLogBrands(List<String> auditLogBrands)
    {
        this.auditLogBrands = auditLogBrands;
    }

    /**
     * Getter for Publish Environment.
     * @return the publishEnvironment
     */
    public String getPublishEnvironment()
    {
        return publishEnvironment;
    }

    /**
     * Setter for Publish Environment.
     * @param publishEnvironment the publishEnvironment to set
     */
    public void setPublishEnvironment(String publishEnvironment)
    {
        this.publishEnvironment = publishEnvironment;
    }

    /**
     * Getter for PublishQueueId.
     * @return the publishQueueId
     */
    public long getPublishQueueId()
    {
        return publishQueueId;
    }

    /**
     * Setter for PublishQueueId.
     * @param publishQueueId the publishQueueId to set
     */
    public void setPublishQueueId(long publishQueueId)
    {
        this.publishQueueId = publishQueueId;
    }

    /**
     * Getter for PublishId.
     * @return the publishId
     */
    public long getPublishId()
    {
        return publishId;
    }

    /**
     * Setter for PublishId.
     * @param publishId the publishId to set
     */
    public void setPublishId(long publishId)
    {
        this.publishId = publishId;
    }

    /**
     * Getter for discontinued filter.
     * @return the discontFilter
     */
    public String getDiscontFilter()
    {
        return discontFilter;
    }

    /**
     * Setter for discontinued filter.
     * @param discontFilter the discontFilter to set
     */
    public void setDiscontFilter(String discontFilter)
    {
        this.discontFilter = discontFilter;
    }
    
    /**
     * Add field for the search field map.
     * @param searchFields map
     * @param fieldName field name
     * @param fieldValue field value
     */
    private void addSearchField(Map<String, String> searchFields, String fieldName, List<String> fieldValue)
    {
        if (fieldValue != null && !fieldValue.isEmpty())
        {
            searchFields.put(fieldName, StringUtils.join(fieldValue, DIVIDER_VAL));
        }
    }
    
    /**
     * Add field for the search field map.
     * @param searchFields map
     * @param fieldName field name
     * @param fieldValue field value
     */
    private void addSearchField(Map<String, String> searchFields, String fieldName, Map<String, String> fieldValue)
    {
        if (fieldValue != null && !fieldValue.isEmpty())
        {
            List<String> images = new ArrayList<String>();
            for (Entry<String, String> entry : image.entrySet())
            {
                images.add(entry.getKey() + DIVIDER_MAP_VAL + entry.getValue());
            }
            searchFields.put(fieldName, StringUtils.join(images, DIVIDER_VAL));
        }
    }
    
    /**
     * Add field for the search field map.
     * @param searchFields map
     * @param fieldName field name
     * @param fieldValue field value
     */
    private void addSearchField(Map<String, String> searchFields, String fieldName, String fieldValue)
    {
        if (fieldValue != null && !fieldValue.isEmpty())
        {
            searchFields.put(fieldName, fieldValue);
        }
    }
    
    /**
     * Add field for the search field map.
     * @param searchFields map
     * @param fieldName field name
     * @param fieldValue field value
     */
    private void addSearchField(Map<String, String> searchFields, String fieldName, boolean fieldValue)
    {
        if (fieldValue)
        {
            searchFields.put(fieldName, String.valueOf(fieldValue));
        }
    }
    
    /**
     * Add field for the search field map.
     * @param searchFields map
     * @param fieldName field name
     * @param fieldValue field value
     */
    private void addSearchField(Map<String, String> searchFields, String fieldName, long fieldValue)
    {
        if (fieldValue > 0)
        {
            searchFields.put(fieldName, String.valueOf(fieldValue));
        }
    }
    
    /**
     * Create Search Criteria XML.
     * @return XML string
     */
    public Map<String, String> getSearchCriteriaFields()
    {
        Map<String, String> searchFields = new LinkedHashMap<String, String>();
        addSearchField(searchFields, "brands", brands);
        addSearchField(searchFields, "countries", countries);
        addSearchField(searchFields, "search", searchCriteria);
        addSearchField(searchFields, "rationale", rationale);
        addSearchField(searchFields, "status", status);
        addSearchField(searchFields, "techWriter", techWriter);
        addSearchField(searchFields, "category", category);
        addSearchField(searchFields, "changeType", changeType);
        addSearchField(searchFields, "attachType", attachType);
        addSearchField(searchFields, "stdOwner", stdOwner);
        addSearchField(searchFields, "flags", flags);
        addSearchField(searchFields, "corpDept", corpDept);
        addSearchField(searchFields, "deptApplicability", deptApplicability);
        addSearchField(searchFields, "guestJourney", guestJourney);
        addSearchField(searchFields, "importance", importance);
        addSearchField(searchFields, "locHotel", locHotel);
        addSearchField(searchFields, "wheelQuad", wheelQuad);
        addSearchField(searchFields, "manual", manual);
        addSearchField(searchFields, "ownershipType", ownershipType);
        addSearchField(searchFields, "profitLossImpact", profitLossImpact);
        addSearchField(searchFields, "capExImpact", capExImpact);
        addSearchField(searchFields, "implementationImpact", implementationImpact);
        addSearchField(searchFields, "impact", impact);
        addSearchField(searchFields, "changeFromRegionalImpact", changeFromRegionalImpact);
        addSearchField(searchFields, "impactComments", impactComments);
        addSearchField(searchFields, "standardsIds", standardsIds);
        addSearchField(searchFields, "authors", authors);
        addSearchField(searchFields, "designDiscipline", designDiscipline);
        addSearchField(searchFields, "risk", risk);
        addSearchField(searchFields, "measurement", measurement);
        addSearchField(searchFields, "gemReportCategory", gemReportCategory);
        addSearchField(searchFields, "areaForMeasurement", areaForMeasurement);
        addSearchField(searchFields, "hotelLifecycle", hotelLifecycle);
        addSearchField(searchFields, "specialistArea", specialistArea);
        addSearchField(searchFields, "digital", digital);
        addSearchField(searchFields, "auditLogBrands", auditLogBrands);
        
        addSearchField(searchFields, "searchLog", searchLog);
        addSearchField(searchFields, "logDate", logDate);
        addSearchField(searchFields, "toLogDate", toLogDate);
        addSearchField(searchFields, "logCriteria", logCriteria);
        addSearchField(searchFields, "logCreatedBy", logCreatedBy);
        addSearchField(searchFields, "enteredBy", enteredBy);
        addSearchField(searchFields, "histManual", histManual);
        addSearchField(searchFields, "fromLaunchDate", fromLaunchDate);
        addSearchField(searchFields, "toLaunchDate", toLaunchDate);
        addSearchField(searchFields, "brandHallmark", brandHallmark);
        addSearchField(searchFields, "fromCompDate", fromCompDate);
        addSearchField(searchFields, "toCompDate", toCompDate);
        addSearchField(searchFields, "index", index);
        addSearchField(searchFields, "recordId", recordId);
        addSearchField(searchFields, "textSearchType", textSearchType);
        addSearchField(searchFields, "internalReference", internalReference);
        addSearchField(searchFields, "reportId", reportId);
        addSearchField(searchFields, "defaultLangLocaleCd", defaultLangLocaleCd);
        addSearchField(searchFields, "secondLangLocaleCd", secondLangLocaleCd);
        addSearchField(searchFields, "preferedBrand", preferedBrand);
        addSearchField(searchFields, "publishEnvironment", publishEnvironment);
        addSearchField(searchFields, "discontFilter", discontFilter);
        
        addSearchField(searchFields, "hasLinks", hasLinks);
        addSearchField(searchFields, "hasGuidelines", hasGuidelines);
        addSearchField(searchFields, "hasCrossReference", hasCrossReference);
        addSearchField(searchFields, "branchOnly", branchOnly);
        addSearchField(searchFields, "approver", approver);
        addSearchField(searchFields, "fetchAllSpecGuideline", fetchAllSpecGuideline);
        
        addSearchField(searchFields, "image", image);
        
        addSearchField(searchFields, "publishQueueId", publishQueueId);
        addSearchField(searchFields, "publishId", publishId);
        
        return searchFields;
    }
    
    /**
     * Initialize fields from fields map.
     * @param searchFields field value name pair
     */
    private void init(final Map<String, String> searchFields)
    {
        for (Entry<String, String> entry : searchFields.entrySet())
        {
            setValue(entry.getKey(), entry.getValue());
        }
    }
    
    /**
     * Set field value base on field name.
     * @param fieldName
     * @param fieldValue
     */
    private void setValue(String fieldName, String fieldValue)
    {
        if ("brands".equals(fieldName))
        {
            brands = toList(fieldValue);
        }
        else if ("countries".equals(fieldName))
        {
            countries = toList(fieldValue);
        }
        else if ("search".equals(fieldName))
        {
            searchCriteria = toList(fieldValue);
        }
        else if ("rationale".equals(fieldName))
        {
            rationale = toList(fieldValue);
        }
        else if ("status".equals(fieldName))
        {
            status = toList(fieldValue);
        }
        else if ("techWriter".equals(fieldName))
        {
            techWriter = toList(fieldValue);
        }
        else if ("category".equals(fieldName))
        {
            category = toList(fieldValue);
        }
        else if ("changeType".equals(fieldName))
        {
            changeType = toList(fieldValue);
        }
        else if ("attachType".equals(fieldName))
        {
            attachType = toList(fieldValue);
        }
        else if ("stdOwner".equals(fieldName))
        {
            stdOwner = toList(fieldValue);
        }
        else if ("flags".equals(fieldName))
        {
            flags = toList(fieldValue);
        }
        else if ("corpDept".equals(fieldName))
        {
            corpDept = toList(fieldValue);
        }
        else if ("deptApplicability".equals(fieldName))
        {
            deptApplicability = toList(fieldValue);
        }
        else if ("guestJourney".equals(fieldName))
        {
            guestJourney = toList(fieldValue);
        }
        else if ("importance".equals(fieldName))
        {
            importance = toList(fieldValue);
        }
        else if ("locHotel".equals(fieldName))
        {
            locHotel = toList(fieldValue);
        }
        else if ("wheelQuad".equals(fieldName))
        {
            wheelQuad = toList(fieldValue);
        }
        else if ("manual".equals(fieldName))
        {
            manual = toList(fieldValue);
        }
        else if ("ownershipType".equals(fieldName))
        {
            ownershipType = toList(fieldValue);
        }
        else if ("profitLossImpact".equals(fieldName))
        {
            profitLossImpact = toList(fieldValue);
        }
        else if ("capExImpact".equals(fieldName))
        {
            capExImpact = toList(fieldValue);
        }
        else if ("implementationImpact".equals(fieldName))
        {
            implementationImpact = toList(fieldValue);
        }
        else if ("impact".equals(fieldName))
        {
            impact = toList(fieldValue);
        }
        else if ("changeFromRegionalImpact".equals(fieldName))
        {
            changeFromRegionalImpact = toList(fieldValue);
        }
        else if ("impactComments".equals(fieldName))
        {
            impactComments = toList(fieldValue);
        }
        else if ("standardsIds".equals(fieldName))
        {
            standardsIds = toList(fieldValue);
        }
        else if ("authors".equals(fieldName))
        {
            authors = toList(fieldValue);
        }
        else if ("designDiscipline".equals(fieldName))
        {
            designDiscipline = toList(fieldValue);
        }
        else if ("risk".equals(fieldName))
        {
            risk = toList(fieldValue);
        }
        else if ("measurement".equals(fieldName))
        {
            measurement = toList(fieldValue);
        }
        else if ("gemReportCategory".equals(fieldName))
        {
            gemReportCategory = toList(fieldValue);
        }
        else if ("areaForMeasurement".equals(fieldName))
        {
            areaForMeasurement = toList(fieldValue);
        }
        else if ("hotelLifecycle".equals(fieldName))
        {
            hotelLifecycle = toList(fieldValue);
        }
        else if ("specialistArea".equals(fieldName))
        {
            specialistArea = toList(fieldValue);
        }
        else if ("digital".equals(fieldName))
        {
            digital = toList(fieldValue);
        }
        else if ("auditLogBrands".equals(fieldName))
        {
            auditLogBrands = toList(fieldValue);
        }
        else if ("searchLog".equals(fieldName))
        {
            searchLog = fieldValue;
        }
        else if ("logDate".equals(fieldName))
        {
            logDate = fieldValue;
        }
        else if ("toLogDate".equals(fieldName))
        {
            toLogDate = fieldValue;
        }
        else if ("logCriteria".equals(fieldName))
        {
            logCriteria = fieldValue;
        }
        else if ("logCreatedBy".equals(fieldName))
        {
            logCreatedBy = fieldValue;
        }
        else if ("enteredBy".equals(fieldName))
        {
            enteredBy = fieldValue;
        }
        else if ("histManual".equals(fieldName))
        {
            histManual = fieldValue;
        }
        else if ("fromLaunchDate".equals(fieldName))
        {
            fromLaunchDate = fieldValue;
        }
        else if ("toLaunchDate".equals(fieldName))
        {
            toLaunchDate = fieldValue;
        }
        else if ("brandHallmark".equals(fieldName))
        {
            brandHallmark = fieldValue;
        }
        else if ("fromCompDate".equals(fieldName))
        {
            fromCompDate = fieldValue;
        }
        else if ("toCompDate".equals(fieldName))
        {
            toCompDate = fieldValue;
        }
        else if ("index".equals(fieldName))
        {
            index = fieldValue;
        }
        else if ("recordId".equals(fieldName))
        {
            recordId = fieldValue;
        }
        else if ("textSearchType".equals(fieldName))
        {
            textSearchType = fieldValue;
        }
        else if ("internalReference".equals(fieldName))
        {
            internalReference = fieldValue;
        }
        else if ("reportId".equals(fieldName))
        {
            reportId = fieldValue;
        }
        else if ("defaultLangLocaleCd".equals(fieldName))
        {
            defaultLangLocaleCd = fieldValue;
        }
        else if ("secondLangLocaleCd".equals(fieldName))
        {
            secondLangLocaleCd = fieldValue;
        }
        else if ("preferedBrand".equals(fieldName))
        {
            preferedBrand = fieldValue;
        }
        else if ("publishEnvironment".equals(fieldName))
        {
            publishEnvironment = fieldValue;
        }
        else if ("discontFilter".equals(fieldName))
        {
            discontFilter = fieldValue;
        }
        else if ("hasLinks".equals(fieldName))
        {
            hasLinks = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("hasGuidelines".equals(fieldName))
        {
            hasGuidelines = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("hasCrossReference".equals(fieldName))
        {
            hasCrossReference = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("branchOnly".equals(fieldName))
        {
            branchOnly = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("approver".equals(fieldName))
        {
            approver = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("fetchAllSpecGuideline".equals(fieldName))
        {
            fetchAllSpecGuideline = BooleanUtils.toBoolean(fieldValue);
        }
        else if ("image".equals(fieldName))
        {
            image = toMap(fieldValue);
        }
        else if ("publishQueueId".equals(fieldName))
        {
            publishQueueId = Long.parseLong(fieldValue);
        }
        else if ("publishId".equals(fieldName))
        {
            publishId = Long.parseLong(fieldValue);
        }
    }

    /**
     * Convert String to List.
     * @param fieldValue string of separated values
     * @return list
     */
    private List<String> toList(String fieldValue)
    {
        // Arrays.asList returns a fixed-size List backed by the array. 
        // If you want a normal mutable java.util.ArrayList you need to do this:
//        return new ArrayList<String>(Arrays.asList(fieldValue.split(DIVIDER_VAL)));
        
        // Arrays.asList returns a fixed-size List backed by the array.
        return Arrays.asList(fieldValue.split(DIVIDER_VAL));
    }

    /**
     * Convert String to Map.
     * @param fieldValue string of separated values
     * @return map
     */
    private Map<String, String> toMap(String fieldValue)
    {
        Map<String, String> images = new HashMap<String, String>(); 
        List<String> dataItems = Arrays.asList(fieldValue.split(DIVIDER_MAP_VAL));
        for (String item : dataItems)
        {
            String[] val = item.split(DIVIDER_VAL);
            if (val.length >= 2)
            {
                images.put(val[0], val[1]);
            }
        }
        return images;
    }
}
