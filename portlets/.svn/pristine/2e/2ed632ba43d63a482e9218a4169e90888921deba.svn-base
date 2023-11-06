package com.ihg.brandstandards.util;

import java.io.StringWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.PropertyException;

import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsExt;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsChainImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsChainImagesPK;
import com.ihg.brandstandards.xml.metadata.FieldType;
import com.ihg.brandstandards.xml.metadata.Metadata;
import com.ihg.brandstandards.xml.metadata.MetadataValidationEventHandler;
import com.ihg.brandstandards.xml.metadata.ObjectFactory;
import com.ihg.brandstandards.xml.metadata.ParamList;
import com.ihg.brandstandards.xml.metadata.ParamType;
import com.ihg.brandstandards.xml.metadata.Search;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;

/**
 * All constants and util methods goes here.
 * 
 * @author KhandeN
 */

public class StandardsListUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsListUtil.class);

    public static final String COLUMN_TYPE_NUMBER_START = " = ";
    public static final String COLUMN_TYPE_NUMBER_END = "";

    public static final String COLUMN_TYPE_STRING_MATCH_START = " like '%";
    public static final String COLUMN_TYPE_STRING_MATCH_END = "%'";
    
    public static final String COLUMN_TYPE_STRING_EXACT_MATCH_START = "'(^|\\s)";
    public static final String COLUMN_TYPE_STRING_EXACT_MATCH_END = "(\\s|,|\\.|$)'";

    public static final String COLUMN_TYPE_STRING_EXACT_START = " = '";
    public static final String COLUMN_TYPE_STRING_EXACT_END = "'";

    public static final String COMPLY_RULE_REPORT = "Compliance Rule";

    private static final String DELIMS = " ,;+";
    private static final int INIT_BUFFER_SIZE = 50;


    /**
     * Extract values for specified parameter from HTTP Servlet request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - Render Request flag
     * @param paramName - parameter name
     * @param renderParamName - parameter name when isRenderRequest is true
     * @return - list of values
     */
    public static List<String> getParamFromRequest(final HttpServletRequest request, final boolean isRenderRequest,
            final String paramName, final String renderParamName)
    {
        final List<String> paramValues = new ArrayList<String>();
        try
        {
        	String[] values;
            if (isRenderRequest)
            {
                values = request.getParameterValues(paramName);
            }
            else
            {
                values = request.getParameterValues(renderParamName);
            }
            if (values != null && values.length > 0)
            {
                paramValues.addAll(Arrays.asList(values));
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return paramValues;
    }

    /**
     * Extract values for specified parameter from HTTP Servlet request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - Render Request flag
     * @param paramName - parameter name
     * @param renderParamName - parameter name when isRenderRequest is true
     * @return - list of values
     */
    private static List<String> getSingleParamFromRequest(final HttpServletRequest request, final boolean isRenderRequest,
            final String paramName, final String renderParamName)
    {
        final List<String> paramValues = new ArrayList<String>();
        try
        {
            String values;
            if (isRenderRequest)
            {
                values = request.getParameter(paramName);
            }
            else
            {
                values = request.getParameter(renderParamName);
            }
            if (values != null && values.length() > 0)
            {
                paramValues.add(values);
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return paramValues;
    }

    /**
     * Get Brands from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - Render Request flag
     * @return list of Brands
     */
    public static List<String> getBrandsFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "brand", "brand[]");
    }

    /**
     * Get Audit Log Brands from request
     */

    public static List<String> getAuditLogBrandsFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "auditLog_brand", "auditLog_brand[]");
    }

    /**
     * Get Countries from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - Render Request flag
     * @return list of Countries
     */
    public static List<String> getCountriesFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "selectedcountries", "selectedcountries[]");
    }

    /**
     * Get Criteria from request.
     * 
     * @param request - RenderRequest
     * @return list of Criteria
     */
    public static List<String> getCriteriaFromRequest(final RenderRequest request)
    {
        final List<String> arlCriteria = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "filterText");
            LOG.debug("value of filter text is " + criteria);
            if (criteria != null)
            {
                final StringTokenizer strTok = new StringTokenizer(criteria, DELIMS);
                while (strTok.hasMoreTokens())
                {
                    arlCriteria.add(strTok.nextToken());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlCriteria;
    }

    /**
     * Get Criteria from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - Render Request flag
     * @return list of Criteria
     */
    public static List<String> getCriteriaFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlCriteria = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "filterText");
            String textSearchType = ParamUtil.getString(request, "searchOptions");
            LOG.debug("value of filter text is " + criteria);
            if (criteria != null)
            {
                if ("all".equals(textSearchType) || "any".equals(textSearchType))
                {
                    final StringTokenizer strTok = new StringTokenizer(criteria, DELIMS);
                    while (strTok.hasMoreTokens())
                    {
                        arlCriteria.add(strTok.nextToken());
                    }
                }
                else
                {
                    arlCriteria.add(criteria);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlCriteria;
    }

    /**
     * Get Rationale Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @return list of Rationale
     */
    public static List<String> getRationaleFromRequest(final RenderRequest request)
    {
        return getRationaleFromRequest(PortalUtil.getHttpServletRequest(request), false);
    }

    /**
     * Get Rationale Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Rationale
     */
    public static List<String> getRationaleFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlCriteria = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "filterRationale");
            LOG.debug("value of rationale is " + criteria);
            if (criteria != null)
            {
                final StringTokenizer strTok = new StringTokenizer(criteria, DELIMS);
                while (strTok.hasMoreTokens())
                {
                    arlCriteria.add(strTok.nextToken());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlCriteria;
    }

    /**
     * Get Impact Comments Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of comments
     */
    public static List<String> getImpactCommentsFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlCriteria = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "impactComments");
            LOG.debug("value of impactComments is " + criteria);
            if (criteria != null)
            {
                final StringTokenizer strTok = new StringTokenizer(criteria, DELIMS);
                while (strTok.hasMoreTokens())
                {
                    arlCriteria.add(strTok.nextToken());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlCriteria;
    }

    /**
     * Get Status Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Status
     */
    public static List<String> getStatusFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "searchStatus", "status[]");
    }

    /**
     * Get Technical Writer Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Technical Writer
     */
    public static List<String> getTechWriterFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "techWriter", "techWriter[]");
    }

    /**
     * Get Owner Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Owner
     */
    public static List<String> getStdOwnerFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "stdOwner", "stdOwner[]");
    }

    /**
     * Get Category list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Category
     */
    public static List<String> getCategoryFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "category", "category[]");
    }

    /**
     * Get Department Applicability list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Department Applicability
     */
    public static List<String> getDeptApplicabilityFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "deptApplicability", "deptApp[]");
    }

    /**
     * Get Importance list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Importance
     */
    public static List<String> getImportanceFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "importance", "importance[]");
    }

    public static List<String> getDesignDisciplineFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "designDiscipline", "designDiscipline[]");
    }

    public static List<String> getRiskFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "risk", "risk[]");
    }

    public static List<String> getMeasurementFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "measurement", "measurement[]");
    }

    public static List<String> getGemReportCategoryFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "gemReportCategory", "gemReportCategory[]");
    }

    public static List<String> getAreaForMeasurementFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "areaForMeasurement", "areaForMeasurement[]");
    }

    /**
     * Get Guest Journey list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Guest Journey
     */
    public static List<String> getGuestJourneyFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "guestJourney", "guestJourney[]");
    }

    /**
     * Get Outside of Guest Journey list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Guest Journey
     */
    public static List<String> getOutsideGuestJourneyFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getSingleParamFromRequest(request, isRenderRequest, "outsideofGuestJourney", "outsideofGuestJourney");
    }

    /**
     * Get Locations within hotel list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Locations within hotel
     */
    public static List<String> getLocHotelFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "locHotel", "locHotel[]");
    }

    /**
     * Get Manual list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Manual
     */
    public static List<String> getManualFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlManual = new ArrayList<String>();
        try
        {
            final String manual = ParamUtil.getString(request, "manual");
            final String[] arrMmanual = request.getParameterValues("manual[]");

            if (manual != null && !manual.isEmpty())
            {
                arlManual.add(manual);
            }
            if (arrMmanual != null && arrMmanual.length > 0)
            {
                arlManual.addAll(Arrays.asList(arrMmanual));
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlManual;
    }

    /**
     * Get Corporate Department list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Corporate Department
     */
    public static List<String> getCorpDeptFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "corpDept", "corpDept[]");
    }

    /**
     * Get Wheel Quadrant list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Wheel Quadrant
     */
    public static List<String> getWheelQuadrantFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "wheelQuadrant", "wheelQuad[]");
    }

    /**
     * Get Ownership Type list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Ownership Type
     */
    public static List<String> getOwnershipTypeFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "ownershipType", "ownerType[]");
    }

    /**
     * Get P&L Impact from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Manual
     */
    public static List<String> getProfitLossImpactFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "plImpact", "plImpact[]");
    }

    /**
     * Get CapEx Impact from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of CapEx Impact
     */
    public static List<String> getCapExImpactFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "capExImpact", "capExImpact[]");
    }

    /**
     * Get Implementation Impact from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Implementation Impact
     */
    public static List<String> getImplImpactFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "implementationImpact", "implementationImpact[]");
    }

    /**
     * Get Attachment Type list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Attachment Types
     */
    public static List<String> getAttachTypeFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "attachmentType", "attachType[]");
    }

    /**
     * Get Change Type list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of Change Types
     */
    public static List<String> getChangeTypeFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "changeType", "changeType[]");
    }

    /**
     * Get flags list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of flags
     */
    public static List<String> getFlagsList(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlFlags = new ArrayList<String>();
        final List<String> arlCorpDept = getCorpDeptFromRequest(request, isRenderRequest);
        final List<String> arlDeptApplicability = getDeptApplicabilityFromRequest(request, isRenderRequest);
        final List<String> arlGuestJourney = getGuestJourneyFromRequest(request, isRenderRequest);
        final List<String> arlOutsideGuestJourney = getOutsideGuestJourneyFromRequest(request, isRenderRequest);
        final List<String> arlImportance = getImportanceFromRequest(request, isRenderRequest);
        final List<String> arlLocHotel = getLocHotelFromRequest(request, isRenderRequest);
        final List<String> arlWheelQuad = getWheelQuadrantFromRequest(request, isRenderRequest);
        final List<String> arlManual = getManualFromRequest(request, isRenderRequest);
        final List<String> arlOwnershipType = getOwnershipTypeFromRequest(request, isRenderRequest);
        final List<String> arlMeasurement = getMeasurementFromRequest(request, isRenderRequest);
        final List<String> arlGemReportCat = getGemReportCategoryFromRequest(request, isRenderRequest);
        final List<String> arlAreaMeasurement = getAreaForMeasurementFromRequest(request, isRenderRequest);
        //final List<String> arlHotelLifecycle = getParamFromRequest(request, isRenderRequest, "hotellifecycle", "hotellifecycle[]");
        final List<String> arlHotelLifecycle = getHotelLifeCycleParam(ParamUtil.getString(request, "hotellifecycle"));
        
        final List<String> arlSpecialistArea = getParamFromRequest(request, isRenderRequest, "specialistarea", "specialistarea[]");
        final List<String> arlDigital = getParamFromRequest(request, isRenderRequest, "digital", "digital[]");
        final List<String> arlBrandSafetyStandards = getParamFromRequest(request, isRenderRequest, "brandsafetystandards", "brandsafetystandards[]");
        final List<String> arlRisk = getRiskFromRequest(request, isRenderRequest);
        final List<String> arlDesignDiscipline = getDesignDisciplineFromRequest(request, isRenderRequest);

        if (!isNullOrBlank(arlDeptApplicability))
        {
            arlFlags.addAll(arlDeptApplicability);
        }
        if (!isNullOrBlank(arlImportance))
        {
            arlFlags.addAll(arlImportance);
        }
        if (!isNullOrBlank(arlGuestJourney))
        {
            arlFlags.addAll(arlGuestJourney);
        }
        if (!isNullOrBlank(arlOutsideGuestJourney))
        {
            arlFlags.addAll(arlOutsideGuestJourney);
        }
        if (!isNullOrBlank(arlLocHotel))
        {
            arlFlags.addAll(arlLocHotel);
        }
        if (!isNullOrBlank(arlCorpDept))
        {
            arlFlags.addAll(arlCorpDept);
        }
        if (!isNullOrBlank(arlWheelQuad))
        {
            arlFlags.addAll(arlWheelQuad);
        }
        if (!isNullOrBlank(arlOwnershipType))
        {
            arlFlags.addAll(arlOwnershipType);
        }
        if (!isNullOrBlank(arlManual))
        {
            arlFlags.addAll(arlManual);
        }
        if (!isNullOrBlank(arlDesignDiscipline))
        {
            arlFlags.addAll(arlDesignDiscipline);
        }
        if (!isNullOrBlank(arlRisk))
        {
            arlFlags.addAll(arlRisk);
        }
        if (!isNullOrBlank(arlMeasurement))
        {
            arlFlags.addAll(arlMeasurement);
        }
        if (!isNullOrBlank(arlGemReportCat))
        {
            arlFlags.addAll(arlGemReportCat);
        }
        if (!isNullOrBlank(arlAreaMeasurement))
        {
            arlFlags.addAll(arlAreaMeasurement);
        }
        if (!isNullOrBlank(arlHotelLifecycle))
        {
            arlFlags.addAll(arlHotelLifecycle);
        }
        if (!isNullOrBlank(arlSpecialistArea))
        {
            arlFlags.addAll(arlSpecialistArea);
        }
        if (!isNullOrBlank(arlDigital))
        {
            arlFlags.addAll(arlDigital);
        }
        if (!isNullOrBlank(arlBrandSafetyStandards))
        {
            arlFlags.addAll(arlBrandSafetyStandards);
        }
        return arlFlags;
    }

    /**
     * Get Impact Assessment list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of flags
     */
    public static List<String> getImpactAssessmentListList(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> impact = new ArrayList<String>();
        final List<String> arlPlImpact = getProfitLossImpactFromRequest(request, isRenderRequest);
        final List<String> arlCapExImpact = getCapExImpactFromRequest(request, isRenderRequest);
        final List<String> arlImplImpact = getImplImpactFromRequest(request, isRenderRequest);
        final List<String> arlChangeFromRegImpact = getChangeFromRegionalFromRequest(request, isRenderRequest);

        if (!isNullOrBlank(arlPlImpact))
        {
            impact.addAll(arlPlImpact);
        }
        if (!isNullOrBlank(arlCapExImpact))
        {
            impact.addAll(arlCapExImpact);
        }
        if (!isNullOrBlank(arlImplImpact))
        {
            impact.addAll(arlImplImpact);
        }
        if (!isNullOrBlank(arlChangeFromRegImpact))
        {
            impact.addAll(arlChangeFromRegImpact);
        }
        return impact;
    }

    /**
     * Get Change from Regional list from request.
     * 
     * @param request - HTTP Servlet request
     * @param isRenderRequest - is render request flag
     * @return list of flags
     */
    public static List<String> getChangeFromRegionalFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        return getParamFromRequest(request, isRenderRequest, "changeFromRegional", "changeFromRegional[]");
    }

    public static List<String> getAuthorsFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        List<String> arlAuthor = new ArrayList<String>();
        final ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        long companyId = themeDisplay.getCompanyId();
        HttpSession session = request.getSession(true);
        String brandCode = "";
        String regionCode = "";
        String discontFilter = "";
        try
        {
        	Preferences preferences = (Preferences)session.getAttribute("Preferences");
            if(preferences!=null)
            {
            	brandCode = preferences.getBrand();
            	regionCode = preferences.getRegionCode();
            	discontFilter = preferences.getDiscontinuedFilter();
            }
            String strUser = ParamUtil.getString(request, "logCreatedBy");
            String[] arrUser = request.getParameterValues("logCreatedBy[]");

            if (StandardsListUtil.IsNullOrBlank(strUser))
            {
                if (arrUser != null && arrUser.length > 0)
                {
                    strUser = arrUser[0];
                }
            }
            if ("ALL".equals(strUser))
            {
                arlAuthor = arlAuthor == null ? new ArrayList<String>() : arlAuthor;
            }
            else if ("GLBL".equals(strUser))
            {
                Role role = RoleLocalServiceUtil.getRole(companyId, AUTHORS_GLOBAL_ROLE);
                arlAuthor = getAuthorsUserIdList(companyId, role);
            }
            else if ("AMER".equals(strUser))
            {
                Role role = RoleLocalServiceUtil.getRole(companyId, AUTHORS_AMER_ROLE);
                arlAuthor = getAuthorsUserIdList(companyId, role);
            }
            else if ("AMEA".equals(strUser))
            {
                Role role = RoleLocalServiceUtil.getRole(companyId, AUTHORS_AMEA_ROLE);
                arlAuthor = getAuthorsUserIdList(companyId, role);
            }
            else if ("EURO".equals(strUser))
            {
                Role role = RoleLocalServiceUtil.getRole(companyId, AUTHORS_EUROPE_ROLE);
                arlAuthor = getAuthorsUserIdList(companyId, role);
            }
            else if ("GC".equals(strUser))
            {
                Role role = RoleLocalServiceUtil.getRole(companyId, AUTHORS_GC_ROLE);
                arlAuthor = getAuthorsUserIdList(companyId, role);
            }
            else if(strUser.equals("SUPER"))
            {
            	Role role = RoleLocalServiceUtil.getRole(companyId, BRND_STND_SUPER_ADMIN);
                arlAuthor = getAuthorsUserIdList(companyId, role);
                
            }
            else if (!StandardsListUtil.IsNullOrBlank(strUser))
            {
                LOG.debug("inside users for loop value is " + strUser);
                arlAuthor.add(strUser);
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlAuthor;
    }

    public static List<String> getAuthorsUserIdList(long companyId, Role role)
    {
        List<String> arlAuthor = new ArrayList<String>();
        List<User> arlUsers = new ArrayList<User>();

        try
        {
            arlUsers = UserLocalServiceUtil.getRoleUsers(role.getRoleId());
            for (User user : arlUsers)
            {
                arlAuthor.add(String.valueOf(user.getUserId()));
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlAuthor;
    }

    public static String getLogDateFromRequest(HttpServletRequest request, boolean isRenderRequest)
    {
        String date = new String();
        try
        {
            String logCriteria = ParamUtil.getString(request, "logRelativeCriteria");
            LOG.debug("inside getLogDateFromRequest " + logCriteria);
            if (!IsNullOrBlank(logCriteria))
            {
                if ("lastDay".equals(logCriteria))
                {
                    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
                    Calendar calendar = Calendar.getInstance();
                    calendar.add(Calendar.HOUR_OF_DAY, -24);
                    date = df.format(calendar.getTime());
                }
                else if ("since".equals(logCriteria))
                {

                    String strDate = ParamUtil.getString(request, "auditLogDate");
                    DateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
                    Date effDate = (Date) formatter.parse(strDate);
                    DateFormat df = new SimpleDateFormat("dd-MMM-yyyy");
                    date = df.format(effDate);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return date;
    }

    public static String getToLogDate()
    {
        String date = new String();

        try
        {
            DateFormat df = new SimpleDateFormat("dd-MMM-yyyy hh:mm:ss aaa");
            Date currentDate = new Date(System.currentTimeMillis());
            date = df.format(currentDate);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return date;
    }

    /**
     * Get where clause lower case.
     * 
     * @param values - list of values
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @return - where clause.
     */
    public static StringBuilder getWhereClause(final List<String> values, final String columnName, final String expressionStart,
            final String expressionEnd)
    {
        return getWhereClause(values, columnName, expressionStart, expressionEnd, false);
    }

    /**
     * Get where clause.
     * 
     * @param values - list of values
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - where clause.
     */
    public static StringBuilder getWhereClause(final List<String> values, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" or ");
            }
            clause.append(getWhereClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    /**
     * Add exact word to the clause.
     * @param values list of values
     * @param columnName column
     * @param expressionStart start expression
     * @param expressionEnd end expression
     * @param upperCase flag
     * @return 
     */
    public static StringBuilder getWhereClauseForExactWords(final List<String> values, final String columnName,
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    public static StringBuilder getWhereClauseForStatus(final List<String> values, final String columnName,
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        List<Long> valuesInLong = convertStringToLong(values);
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" or ");
            }
            clause.append(getWhereClause(valuesInLong.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    public static List<Long> convertStringToLong(final List<String> values)
    {
        List<Long> longList = new ArrayList<Long>();
        for (String value : values)
        {
            longList.add(Long.parseLong(value));
        }
        return longList;
    }

    public static StringBuilder getWhereClause(final Long value, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder();
        clause.append(columnName).append(expressionStart).append(value).append(expressionEnd);
        return clause;
    }

    public static StringBuilder getWhereClauseForAllWords(final List<String> values, final String columnName,
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder("( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" and ");
            }
            clause.append(getWhereClause(values.get(i), columnName, expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )");
        return clause;
    }

    /**
     * Search for image title and description all words to the clause.
     * @param values list of values
     * @param columnName column
     * @param expressionStart start expression
     * @param expressionEnd end expression
     * @param upperCase flag
     * @return 
     */
    public static StringBuilder getWhereClauseForImageAllWords(final List<String> values, String stdIdColumnName, 
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder(" ").append(stdIdColumnName).append(" IN ( ");
        clause.append("SELECT DISTINCT std_id FROM std_image si, image im WHERE si.image_id = im.image_id AND (( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(") AND (");
            }
            clause.append(getWhereClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd, upperCase));
            clause.append(" OR ");
            clause.append(getWhereClause(values.get(i), "upper(im.image_desc)", expressionStart, expressionEnd, upperCase));
        }
        clause.append(" ))) ");
        return clause;
    }

    /**
     * Search for image title and description exact word to the clause.
     * @param values list of values
     * @param columnName column
     * @param expressionStart start expression
     * @param expressionEnd end expression
     * @param upperCase flag
     * @return 
     */
    public static StringBuilder getWhereClauseForImageExactWords(final List<String> values, String stdIdColumnName, 
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder(" ").append(stdIdColumnName).append(" IN ( ");
        clause.append("SELECT DISTINCT std_id FROM std_image si, image im WHERE si.image_id = im.image_id AND ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd, upperCase));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), 
                    "upper(replace(replace(replace(replace(replace(im.image_desc, CHR(13), ' '), CHR(10), ' '), CHR(9), ' '), '   ', ' '), '  ', ' '))", 
                    expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )) ");
        return clause;
    }

    /**
     * Search for image title and description any word to the clause.
     * @param values list of values
     * @param columnName column
     * @param expressionStart start expression
     * @param expressionEnd end expression
     * @param upperCase flag
     * @return 
     */
    public static StringBuilder getWhereClauseForImageAnyWords(final List<String> values, String stdIdColumnName, 
            final String expressionStart, final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder(" ").append(stdIdColumnName).append(" IN ( ");
        clause.append("SELECT DISTINCT std_id FROM std_image si, image im WHERE si.image_id = im.image_id AND ( ");
        for (int i = 0; i < values.size(); i++)
        {
            if (i != 0)
            {
                clause.append(" OR ");
            }
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_title_txt)", expressionStart, expressionEnd, upperCase));
            clause.append(" OR ");
            clause.append(getWhereExactClause(values.get(i), "upper(im.image_desc)", expressionStart, expressionEnd, upperCase));
        }
        clause.append(" )) ");
        return clause;
    }

    /**
     * Get where clause lower case.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd)
    {
        return getWhereClause(value, columnName, expressionStart, expressionEnd, false);
    }

    /**
     * Get where clause.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder();
        String newVal = escapeStringSql(value);
        if (upperCase)
        {
            newVal = newVal.toUpperCase();
        }
        clause.append(columnName).append(expressionStart).append(newVal).append(expressionEnd);
        return clause;
    }

    /**
     * Get where exact clause.
     * 
     * @param value - value
     * @param columnName - column name
     * @param expressionStart - expression start
     * @param expressionEnd - expression end
     * @param upperCase - is upper case
     * @return - condition for where clause.
     */
    public static StringBuilder getWhereExactClause(final String value, final String columnName, final String expressionStart,
            final String expressionEnd, final boolean upperCase)
    {
        final StringBuilder clause = new StringBuilder();
        String newVal = escapeStringSql(value);
        if (upperCase)
        {
            newVal = newVal.toUpperCase();
        }
        clause.append("regexp_instr(");
        clause.append(columnName).append(",");
        clause.append(expressionStart).append(newVal).append(expressionEnd).append(") > 0");
        return clause;
    }

    /**
     * Escape QSL reserved characters.
     * 
     * @param string source
     * @return escaped string
     */
    public static String escapeStringSql(String string)
    {
        String escStr = StringUtils.replace(string, "'", "''");
        escStr = StringUtils.replace(escStr, "&", "' || chr(38) || '");
        return escStr;
    }

    /**
     * Get date on where clause.
     * 
     * @param date1 - date from
     * @param date2 - date to
     * @param columnName - column
     * @return - date condition
     */
    public static StringBuilder getWhereClauseDate(final String date1, final String date2, final String columnName)
    {
        String dateFrom = date1;
        String dateTo = date2;
        if (StandardsListUtil.IsNullOrBlank(date1))
        {
            dateFrom = "01-JAN-90";
        }
        if (StandardsListUtil.IsNullOrBlank(date2))
        {
            dateTo = "01-JAN-49";
        }
        final StringBuilder clause = new StringBuilder(INIT_BUFFER_SIZE);
        clause.append(columnName).append(" between '").append(dateFrom).append("' and '").append(dateTo).append("' ");
        return clause;
    }

    /**
     * Build query for specified tables and clauses.
     * 
     * @param selectQuery - query
     * @param tables - list of tables
     * @param clauses - list of clauses
     * @return query
     */
    public static String buildQuery(StringBuilder selectQuery, final List<StringBuilder> tables, final List<StringBuilder> clauses)
    {
        StringBuilder sqlQuery = selectQuery;
        sqlQuery.append(" from ");
        boolean appendComma = false;
        for (StringBuilder table : tables)
        {
            if (appendComma)
            {
                sqlQuery.append(" ,");
            }
            appendComma = true;
            sqlQuery.append(" ").append(table);
        }
        if (!clauses.isEmpty())
        {
            sqlQuery.append(" where ");
            boolean appendAnd = false;
            for (StringBuilder clause : clauses)
            {
                if (appendAnd)
                {
                    sqlQuery.append(" and ");
                }
                appendAnd = true;
                sqlQuery.append(" ").append(clause);
            }
        }
        return selectQuery.toString();
    }

    public static List<String> getStandardsIdsFromRequest(final RenderRequest request)
    {
        final List<String> arlIds = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "recordId");
            String token = " ";
            if (criteria != null)
            {
                final StringTokenizer strTok = new StringTokenizer(criteria, token);
                while (strTok.hasMoreTokens())
                {
                    arlIds.add(strTok.nextToken());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlIds;
    }

    public static List<String> getStandardsIdsFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final List<String> arlIds = new ArrayList<String>();
        try
        {
            final String criteria = ParamUtil.getString(request, "recordId");
            String token = " ";
            if (criteria != null)
            {
                final StringTokenizer strTok = new StringTokenizer(criteria, token);
                while (strTok.hasMoreTokens())
                {
                    arlIds.add(strTok.nextToken());
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return arlIds;
    }

    /**
     * Get image id and title from request.
     * 
     * @param request HttpServletRequest
     * @param isRenderRequest is request coming from render?
     * @return map of image data
     */
    public static Map<String, String> getImageFromRequest(final HttpServletRequest request, final boolean isRenderRequest)
    {
        final Map<String, String> images = new HashMap<String, String>();
        try
        {
            String[] values = null;
            if (isRenderRequest)
            {
                final String imgStr = ParamUtil.getString(request, REQUEST_PARAM_HIDDEN_IMAGES);
                if (imgStr != null)
                {
                    values = imgStr.split("~~~~");
                }
            }
            else
            {
                values = request.getParameterValues(REQUEST_PARAM_HIDDEN_IMAGES + "[]");
            }
            if (values != null && values.length > 0)
            {
                for (String val : values)
                {
                    if (!val.isEmpty())
                    {
                        String[] mapVal = val.split("===");
                        images.put(mapVal[0], mapVal[1]);
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        return images;
    }
    
    /**
     * This methid will build list from comm-seperated value.
     * @param request
     * @param paramName
     * @return
     */
    public static List<String> getHotelLifeCycleParam(final String paramName)
    {
        final List<String> paramValues = new ArrayList<String>();
        try
        {
        	if (Validator.isNotNull(paramName)) 
        	{	
	        	String[] values;
	            values = paramName.split(",");
	            
	            if (values != null && values.length > 0)
	            {
	                paramValues.addAll(Arrays.asList(values));
	            }
        	}
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
      
    	return paramValues;
    }

    /**
     * Get hotel lifecycle attribute in reverse order.
    * @param flagCategoryId
    * @return
    * @throws NoSuchFlagCategoryException
    * @throws SystemException
    */
    public static List<FlagCategory> getReverseHotleLifecycle(long flagCategoryId) throws NoSuchFlagCategoryException,
            SystemException
    {

        List<FlagCategory> reverseFlagLists = new CopyOnWriteArrayList<FlagCategory>( FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(flagCategoryId));
        Collections.reverse(reverseFlagLists);
        return reverseFlagLists;
    }
}
