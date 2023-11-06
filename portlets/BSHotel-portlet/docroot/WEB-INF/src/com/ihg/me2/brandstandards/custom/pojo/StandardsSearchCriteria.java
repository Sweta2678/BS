/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.pojo;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.portlet.RenderRequest;
import javax.portlet.ResourceRequest;
import javax.servlet.http.HttpServletRequest;

import com.ihg.me2.brandstandards.custom.util.StandardsListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;

/**
 * <a href="UserPreferencePortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author KhandeN
 */
public class StandardsSearchCriteria implements Serializable, Cloneable
{
    private static final String SUPPORTING_MATERIAL = "supportingMaterial";
    private List<String> deptApplicability;
    private List<String> guestJourney;
    private List<String> locHotel;
    private List<String> flags;
    private List<String> searchCriteria;
    private List<String> replacedSearchCriteria;
    private List<String> idSearchCriteria;
    private List<String> hotelLifecycle;
    private List<String> specialism;

    private String complianceDeadline;
    private String textSearchType;
    private String textSearch;
    private String replacedTextSearch;
    private String scope;
    private int resultCount;

    private boolean hasLinks;
    private boolean hasAttachments;
    private boolean hasImages;
    private boolean hasTrainingMaterial;
    private boolean hasSOP;
    private boolean search;

    private boolean filterByNew;
    private boolean filterByUpdated;
    private boolean filterByTextUpdate;
    private boolean filterByComplianceUpdate;
    private boolean filterByLifecycleUpdate;
    private boolean filterByRemoved;

    private static final String TEXT_SEARCH_TYPE = "searchOptions";
    private static final String COMPLIANCE_DEADLINE = "compDeadline";
    private static final String FLAG_YES_PARAM = "Y";
    private static final String HAS_LINKS_PARAM = "hasLinks";
    private static final String HAS_ATTACH_PARAM = "hasAttachments";
    private static final String HAS_IMAGES_PARAM = "hasImages";
    private static final String HAS_SOP_PARAM = "hasSOP";
    private static final String HAS_TRAIN_MATERIAL = "hasTrainMaterial";
    private static final String FILTER_BY_NEW = "filterByNew";
    private static final String FILTER_BY_UPDATED = "filterByUpdated";
    private static final String FILTER_BY_REMOVED = "filterByRemoved";
    private static final String FILTER_BY_COMPLIANCE = "filterByComplianceUpdate";
    private static final String FILTER_BY_LIFECYCLE = "filterByLifecycleUpdate";
    private static final String FILTER_BY_TEXT = "filterByTextUpdate";

    /**
     * default constructor.
     */
    public StandardsSearchCriteria()
    {
    }

    /**
     * Preferred constructor.
     * 
     * @param request - RenderRequest
     */
    public StandardsSearchCriteria(RenderRequest request)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        init(httpRequest, true, null);
    }

    /**
     * Preferred constructor.
     * 
     * @param request - ResourceRequest
     */
    public StandardsSearchCriteria(ResourceRequest request)
    {
        HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(request);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
        init(httpRequest, false, null);
    }

    /**
     * @param request - HttpServletRequest
     */
    public StandardsSearchCriteria(HttpServletRequest request, String langCode)
    {
        init(request, false, langCode);
    }

    /**
     * @param httpRequest - HttpServletRequest
     * @param isRenderRequest - boolean
     */
    private void init(HttpServletRequest httpRequest, boolean isRenderRequest, String langCode)
    {
        this.hotelLifecycle = StandardsListUtil.getHotelLifeCycleFromRequest(httpRequest, isRenderRequest);
        this.specialism = StandardsListUtil.getSpecialismFromRequest(httpRequest, isRenderRequest);
        this.deptApplicability = StandardsListUtil.getDeptApplicabilityFromRequest(httpRequest, isRenderRequest);
        this.guestJourney = StandardsListUtil.getGuestJourneyFromRequest(httpRequest, isRenderRequest);
        this.locHotel = StandardsListUtil.getLocHotelFromRequest(httpRequest, isRenderRequest);
        this.flags = StandardsListUtil.getFlagsList(httpRequest, isRenderRequest);
        this.textSearch = ParamUtil.getString(httpRequest, "filterText");
        if(Validator.isNotNull(langCode) && Validator.isNotNull(this.textSearch)){
        	this.replacedTextSearch = StandardsListUtil.getReplacedSearchText(langCode, this.textSearch);
        }
        Map<String, List<String>> hashMap = StandardsListUtil.getCriteriaFromRequest(httpRequest, isRenderRequest, this.replacedTextSearch);

        this.searchCriteria = (List<String>) hashMap.get("arlCriteria");
        this.replacedSearchCriteria = (List<String>) hashMap.get("arlReplaceCriteria");
        this.idSearchCriteria = (List<String>) hashMap.get("arlIdCriteria");
        this.textSearchType = ParamUtil.getString(httpRequest, TEXT_SEARCH_TYPE);
        this.complianceDeadline = ParamUtil.getString(httpRequest, COMPLIANCE_DEADLINE);
        if (ParamUtil.getString(httpRequest, SUPPORTING_MATERIAL).equals(HAS_LINKS_PARAM))
        {
            this.hasLinks = true;
        }
        else if (ParamUtil.getString(httpRequest, SUPPORTING_MATERIAL).equals(HAS_ATTACH_PARAM))
        {
            this.hasAttachments = true;
        }
        else if (ParamUtil.getString(httpRequest, SUPPORTING_MATERIAL).equals(HAS_IMAGES_PARAM))
        {
            this.hasImages = true;
            ;
        }
        else if (ParamUtil.getString(httpRequest, SUPPORTING_MATERIAL).equals(HAS_TRAIN_MATERIAL))
        {
            this.hasTrainingMaterial = true;
        }
        else if (ParamUtil.getString(httpRequest, SUPPORTING_MATERIAL).equals(HAS_SOP_PARAM))
        {
            this.hasSOP = true;
        }
        this.search = true;
        this.filterByNew = ParamUtil.getString(httpRequest, FILTER_BY_NEW).trim().equals(FLAG_YES_PARAM);
        this.filterByUpdated = ParamUtil.getString(httpRequest, FILTER_BY_UPDATED).trim().equals(FLAG_YES_PARAM);
        this.filterByTextUpdate = ParamUtil.getString(httpRequest, FILTER_BY_TEXT).trim().equals(FLAG_YES_PARAM);
        this.filterByComplianceUpdate = ParamUtil.getString(httpRequest, FILTER_BY_COMPLIANCE).trim().equals(FLAG_YES_PARAM);
        this.filterByLifecycleUpdate = ParamUtil.getString(httpRequest, FILTER_BY_LIFECYCLE).trim().equals(FLAG_YES_PARAM);
        this.filterByRemoved = ParamUtil.getString(httpRequest, FILTER_BY_REMOVED).trim().equals(FLAG_YES_PARAM);
        if(!filterByNew && !filterByTextUpdate && !filterByComplianceUpdate	&& !filterByLifecycleUpdate && !filterByRemoved){
        	this.filterByNew = true;
        	this.filterByTextUpdate = true;
        	this.filterByComplianceUpdate = true;
        	this.filterByLifecycleUpdate = true;
        	this.filterByRemoved = true;
        }
    }

    /**
     * clone method.
     * 
     * @return StandardsSearchCriteria
     * @throws CloneNotSupportedException throws CloneNotSupportedException
     */
    public StandardsSearchCriteria clone() throws CloneNotSupportedException
    {
        StandardsSearchCriteria newCriteria = new StandardsSearchCriteria();
        newCriteria.setHotelLifecycle(hotelLifecycle);
        newCriteria.setSpecialism(specialism);
        newCriteria.setDeptApplicability(deptApplicability);
        newCriteria.setGuestJourney(guestJourney);
        newCriteria.setLocHotel(locHotel);
        newCriteria.setFlags(flags);
        newCriteria.setTextSearchType(textSearchType);
        newCriteria.setComplianceDeadline(complianceDeadline);
        newCriteria.setHasLinks(hasLinks);
        newCriteria.setHasAttachments(hasAttachments);
        newCriteria.setHasImages(hasImages);
        newCriteria.setHasSOP(hasSOP);
        newCriteria.setHasTrainingMaterial(hasTrainingMaterial);
        newCriteria.setSearchCriteria(searchCriteria);
        newCriteria.setIdSearchCriteria(idSearchCriteria);
        newCriteria.setTextSearch(textSearch);
        newCriteria.setReplacedTextSearch(replacedTextSearch);
        newCriteria.setScope(scope);
        newCriteria.setSearch(true);
        newCriteria.setFilterByNew(filterByNew);
        newCriteria.setFilterByUpdated(filterByUpdated);
        newCriteria.setFilterByTextUpdate(filterByTextUpdate);
        newCriteria.setFilterByComplianceUpdate(filterByComplianceUpdate);
        newCriteria.setFilterByLifecycleUpdate(filterByLifecycleUpdate);
        newCriteria.setFilterByRemoved(filterByRemoved);
        return newCriteria;
    }

    /**
     * @return List<String>
     */
    public List<String> getDeptApplicability()
    {
        return deptApplicability;
    }

    /**
     * @param deptApplicability - List<String>
     */
    public void setDeptApplicability(List<String> deptApplicability)
    {
        this.deptApplicability = deptApplicability;
    }

    /**
     * @return List<String>
     */
    public List<String> getGuestJourney()
    {
        return guestJourney;
    }

    /**
     * @param guestJourney - List<String>
     */
    public void setGuestJourney(List<String> guestJourney)
    {
        this.guestJourney = guestJourney;
    }

    /**
     * @return List<String>
     */
    public List<String> getLocHotel()
    {
        return locHotel;
    }

    /**
     * @param locHotel - List<String>
     */
    public void setLocHotel(List<String> locHotel)
    {
        this.locHotel = locHotel;
    }

    /**
     * @return List<String>
     */
    public List<String> getFlags()
    {
        return flags;
    }

    /**
     * @param flags - List<String>
     */
    public void setFlags(List<String> flags)
    {
        this.flags = flags;
    }

    /**
     * @return String
     */
    public String getComplianceDeadline()
    {
        return complianceDeadline;
    }

    /**
     * @param complianceDeadline - String
     */
    public void setComplianceDeadline(String complianceDeadline)
    {
        this.complianceDeadline = complianceDeadline;
    }

    /**
     * @return String
     */
    public String getTextSearchType()
    {
        return textSearchType;
    }

    /**
     * @param textSearchType - String
     */
    public void setTextSearchType(String textSearchType)
    {
        this.textSearchType = textSearchType;
    }

    /**
     * @return boolean
     */
    public boolean isHasLinks()
    {
        return hasLinks;
    }

    /**
     * @param hasLinks - boolean
     */
    public void setHasLinks(boolean hasLinks)
    {
        this.hasLinks = hasLinks;
    }

    /**
     * @return boolean
     */
    public boolean isHasAttachments()
    {
        return hasAttachments;
    }

    /**
     * @param hasAttachments - boolean
     */
    public void setHasAttachments(boolean hasAttachments)
    {
        this.hasAttachments = hasAttachments;
    }

    /**
     * @return boolean
     */
    public boolean isHasImages()
    {
        return hasImages;
    }

    /**
     * @param hasImages - boolean
     */
    public void setHasImages(boolean hasImages)
    {
        this.hasImages = hasImages;
    }

    /**
     * @return boolean
     */
    public boolean isHasTrainingMaterial()
    {
        return hasTrainingMaterial;
    }

    /**
     * @param hasTrainingMaterial - boolean
     */
    public void setHasTrainingMaterial(boolean hasTrainingMaterial)
    {
        this.hasTrainingMaterial = hasTrainingMaterial;
    }

    /**
     * 
     * @return boolean
     */
    public boolean isHasSOP()
    {
        return hasSOP;
    }

    /**
     * @param hasSOP - boolean
     */
    public void setHasSOP(boolean hasSOP)
    {
        this.hasSOP = hasSOP;
    }

    /**
     * @return List<String>
     */
    public List<String> getSearchCriteria()
    {
        return searchCriteria;
    }

    /**
     * @param searchCriteria - List<String>
     */
    public void setSearchCriteria(List<String> searchCriteria)
    {
        this.searchCriteria = searchCriteria;
    }

    /**
     * @return List<String>
     */
    public List<String> getIdSearchCriteria()
    {
        return idSearchCriteria;
    }

    /**
     * @param idSearchCriteria - List<String>
     */
    public void setIdSearchCriteria(List<String> idSearchCriteria)
    {
        this.idSearchCriteria = idSearchCriteria;
    }

    /**
     * @return boolean
     */
    public boolean isSearch()
    {
        return search;
    }

    /**
     * @param search - boolean
     */
    public void setSearch(boolean search)
    {
        this.search = search;
    }

    /**
     * @return String
     */
    public String getTextSearch()
    {
        return textSearch;
    }

    /**
     * @param textSearch - String
     */
    public void setTextSearch(String textSearch)
    {
        this.textSearch = textSearch;
    }

    /**
     * @return int
     */
    public int getResultCount()
    {
        return resultCount;
    }

    /**
     * @param resultCount - int
     */
    public void setResultCount(int resultCount)
    {
        this.resultCount = resultCount;
    }

    /**
     * @return boolean
     */
    public boolean isFilterByNew()
    {
        return filterByNew;
    }

    /**
     * @param filterByNew - boolean
     */
    public void setFilterByNew(boolean filterByNew)
    {
        this.filterByNew = filterByNew;
    }

    /**
     * @return boolean
     */
    public boolean isFilterByUpdated()
    {
        return filterByUpdated;
    }

    /**
     * @param filterByUpdated - boolean
     */
    public void setFilterByUpdated(boolean filterByUpdated)
    {
        this.filterByUpdated = filterByUpdated;
    }

    public boolean isFilterByTextUpdate() {
		return filterByTextUpdate;
	}

	public void setFilterByTextUpdate(boolean filterByTextUpdate) {
		this.filterByTextUpdate = filterByTextUpdate;
	}

	public boolean isFilterByComplianceUpdate() {
		return filterByComplianceUpdate;
	}

	public void setFilterByComplianceUpdate(boolean filterByComplianceUpdate) {
		this.filterByComplianceUpdate = filterByComplianceUpdate;
	}

	public boolean isFilterByLifecycleUpdate() {
		return filterByLifecycleUpdate;
	}

	public void setFilterByLifecycleUpdate(boolean filterByLifecycleUpdate) {
		this.filterByLifecycleUpdate = filterByLifecycleUpdate;
	}

	/**
     * @return boolean
     */
    public boolean isFilterByRemoved()
    {
        return filterByRemoved;
    }

    /**
     * @param filterByRemoved - boolean
     */
    public void setFilterByRemoved(boolean filterByRemoved)
    {
        this.filterByRemoved = filterByRemoved;
    }

    /**
     * @return the hotelLifecycle
     */
    public List<String> getHotelLifecycle()
    {
        return hotelLifecycle;
    }

    /**
     * @param hotelLifecycle the hotelLifecycle to set
     */
    public void setHotelLifecycle(List<String> hotelLifecycle)
    {
        this.hotelLifecycle = hotelLifecycle;
    }
    
    /**
     * @return the hotelLifecycle
     */
    public List<String> getHotelLifecycleForQuery()
    {
        if (hotelLifecycle == null || hotelLifecycle.isEmpty())
        {
            return hotelLifecycle;
        }
        else {
        	List<String> lifecycle = new ArrayList<String>();
            lifecycle.addAll(hotelLifecycle);
            return lifecycle;
        }
        /*else if (specialism == null || specialism.isEmpty())
        {
            List<String> lifecycle = new ArrayList<String>();
            lifecycle.addAll(hotelLifecycle);
            lifecycle.add("258");
            lifecycle.add("481");
            lifecycle.add("482");
            lifecycle.add("404");
            lifecycle.add("405");
            lifecycle.add("406");
            lifecycle.add("407");
            lifecycle.add("408");
            lifecycle.add("409");
            lifecycle.add("411");
            return lifecycle;
        }
        else if (specialism.contains("257") || specialism.contains("403") || specialism.contains("401")) 
        {
            List<String> lifecycle = new ArrayList<String>();
            lifecycle.addAll(hotelLifecycle);
            lifecycle.addAll(specialism);
            return lifecycle;
        }
        return null;*/
    }

    /**
     * @return the hotelLifecycle
     */
    public List<String> getHotelLifecycleForDisplay()
    {
        if (specialism != null && (specialism.contains("258") || specialism.contains("481") || specialism.contains("482") || specialism.contains("404") || 
              specialism.contains("405") || specialism.contains("406") || specialism.contains("407") || specialism.contains("408") || 
              specialism.contains("409") || specialism.contains("411")) &&
             !specialism.contains("257") && !specialism.contains("403") && !specialism.contains("401")) 
        {
            return null;
        }
        return hotelLifecycle;
    }

    /**
     * @return the specialism
     */
    public List<String> getSpecialism()
    {
        return specialism;
    }

    /**
     * @param specialism the specialism to set
     */
    public void setSpecialism(List<String> specialism)
    {
        this.specialism = specialism;
    }

	public String getReplacedTextSearch() {
		return replacedTextSearch;
	}

	public void setReplacedTextSearch(String replacedTextSearch) {
		this.replacedTextSearch = replacedTextSearch;
	}

	public List<String> getReplacedSearchCriteria() {
		return replacedSearchCriteria;
	}

	public void setReplacedSearchCriteria(List<String> replacedSearchCriteria) {
		this.replacedSearchCriteria = replacedSearchCriteria;
	}

    /**
     * Verify if user specified search criteria.
     * 
     * @return true when at least one value exists, otherwise false
     */
    public boolean isEmpty()
    {
        return StandardsListUtil.isNullOrBlank(searchCriteria) && StandardsListUtil.isNullOrBlank(hotelLifecycle) &&
                StandardsListUtil.isNullOrBlank(specialism) && StandardsListUtil.isNullOrBlank(deptApplicability) &&
                StandardsListUtil.isNullOrBlank(guestJourney) && StandardsListUtil.isNullOrBlank(locHotel) &&
                StandardsListUtil.isNullOrBlank(idSearchCriteria) && StandardsListUtil.IsNullOrBlank(complianceDeadline) &&
                !hasLinks && !hasAttachments && !hasSOP && !hasTrainingMaterial && !hasImages;
    }

	public String getScope() {
		return scope;
	}

	public void setScope(String scope) {
		this.scope = scope;
	}
}
