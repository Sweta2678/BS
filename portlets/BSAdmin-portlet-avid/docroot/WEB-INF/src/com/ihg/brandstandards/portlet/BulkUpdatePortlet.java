package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Map;
import java.util.TimeZone;

import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class BulkUpdatePortlet
 */
public class BulkUpdatePortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(BulkUpdatePortlet.class);

    /**
     * Overwrite method 
     */
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        try
        {
        	String chainCode = StringPool.BLANK;
            User user = PortalUtil.getUser(renderRequest);
            Preferences preferences = getPreferences(renderRequest);
            Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
            boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
            String regionCode = getRegionCode(preferences, user, isSuperAdmin);
            Role authorRole = null;
            Role busOwnersRole = null;
            List<User> authors = new ArrayList<User>();
            List<User> owners = new ArrayList<User>();
            if (isSuperAdmin) 
            {
            	// Authors    
                authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRoleForSuperAdmin(regionCode));
                authors = StandardsUtil.getRoleUsersSorted(authorRole.getRoleId());
                //Owners
                busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRoleForSuperAdmin(regionCode));
                owners = StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId());
            }
            else
            {
            	// Authors    
                authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRole(user));
                authors = StandardsUtil.getRoleUsersSorted(authorRole.getRoleId());
                
                //Owners
                busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRole(user));
                owners = StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId());
            }
            if (preferences != null)
            {
            	chainCode = preferences.getBrand();
            }
            
           
            renderRequest.setAttribute("preferedBrand", chainCode);
            renderRequest.setAttribute("authors", authors);
            renderRequest.setAttribute("owners", owners);
            renderRequest.setAttribute("chnCdMap", chnCdMap);
            renderRequest.setAttribute("regionCode", regionCode);
        }
        catch (PortalException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        catch (SystemException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
        
        final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(viewTemplate);
        reqDisp.include(renderRequest, renderResponse);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException, PortletException
    {
    	try 
    	{
    		final String resourceID = resourceRequest.getResourceID();
    		User user = PortalUtil.getUser(resourceRequest);
    		Preferences preferences = getPreferences(resourceRequest);
    		boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
    		String regionCode = getRegionCode(preferences, user, isSuperAdmin);
    		String currAuthorOrOwner = resourceRequest.getParameter("currUser");
    	    String newAuthorOrOwner = resourceRequest.getParameter("newUser");
    	    String stdIds = resourceRequest.getParameter("stdIds");
    	    
    		if ("updatePrimaryAuthor".equals(resourceID))
            {
    			 updatePrimaryAuthor(user, currAuthorOrOwner, newAuthorOrOwner, stdIds, regionCode);
            }
            else if ("updateOtherAuthor".equals(resourceID))
            {
            	updateOtherAuthor(user, currAuthorOrOwner, newAuthorOrOwner, stdIds, regionCode);
            }
            else if ("deleteOtherAuthor".equals(resourceID))
            {
            	deleteOtherAuthor(user, currAuthorOrOwner, stdIds, regionCode);
            }
            else if ("updateOwner".equals(resourceID))
            {
            	 updateOwner(user, currAuthorOrOwner, newAuthorOrOwner, stdIds, regionCode);
            }
            else if ("updateBrandStatus".equals(resourceID))
            {
            	updateBrandStatus(user, regionCode, preferences, resourceRequest);
            }
            else
            {
                LOG.error("Unknown Resource ID: " + resourceID);
            }
    		
    		resourceResponse.setContentType(ContentTypes.APPLICATION_TEXT);
		} 
    	catch (PortalException e) 
    	{
			LOG.error("Invalid User "+ StackTraceUtil.getStackTrace(e));
		} catch (SystemException e) 
		{
			LOG.error("Unknown User "+ StackTraceUtil.getStackTrace(e));
		}
    	
    	
        
    }
    
    /**
     *  Update Primary Author.
     *  
     * @param user
     * @param currAuthorOrOwner
     * @param newAuthorOrOwner
     * @param stdIds
     * @param regionCode
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public static void updatePrimaryAuthor(User user, String currAuthorOrOwner, String newAuthorOrOwner, String stdIds, String regionCode) throws SystemException, PortalException
    {
    	if (BrandStandardsUtil.IsNullOrBlank(stdIds))
        {
        	 updateAuthor(user, currAuthorOrOwner, newAuthorOrOwner, "Y", regionCode);
        }
        else
        {
        	updateAuthorByStdIds(user, newAuthorOrOwner, "Y", stdIds, regionCode);	
        }
    }
    
    /**
     * Update Other Author.
     * @param user
     * @param currAuthorOrOwner
     * @param newAuthorOrOwner
     * @param stdIds
     * @param regionCode
     * @return
     * @throws SystemException
     * @throws PortalException
     */
    public static void updateOtherAuthor(User user, String currAuthorOrOwner, String newAuthorOrOwner, String stdIds, String regionCode) throws SystemException, PortalException
    {
       
        if (BrandStandardsUtil.IsNullOrBlank(stdIds))
        {
        	updateAuthor(user, currAuthorOrOwner, newAuthorOrOwner, "N", regionCode);
        }
        else
        {
        	addUpdateOtherAuthorByStdIds(user, currAuthorOrOwner, newAuthorOrOwner, "N", stdIds, regionCode);
        }
        
    }
    
    /**
     * Add Or update other author for passed std ids.
     * @param user
     * @param currentAuthor
     * @param newAuthor
     * @param primaryInd
     * @param stdIds
     * @param regionCode
     * @throws PortalException
     * @throws SystemException
     */
    public static void addUpdateOtherAuthorByStdIds(User user, String currentAuthor, String newAuthor, String primaryInd, String stdIds, String regionCode) throws PortalException, SystemException
    {
    	
        if (!BrandStandardsUtil.IsNullOrBlank(stdIds) && !BrandStandardsUtil.IsNullOrBlank(newAuthor))
        {
            List<Long> stdIdLists = getStandardsIds(stdIds);
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            String comments = StringPool.BLANK;
            for (Long stdId : stdIdLists) 
            {
            	Standards std = StandardsLocalServiceUtil.getStandards(stdId);
            	if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode))
            	{	
	            	List<StandardsAuthors> authorList = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, primaryInd);
	            	if (!BrandStandardsUtil.IsNullOrBlank(authorList) && authorList.size() > 0 )
		            {
	            		currentAuthor = "";
	            		for (StandardsAuthors standardsAuthor : authorList) 
			            {
	            			currentAuthor = 
	            					currentAuthor.length() == 0 ? standardsAuthor.getAuthorName() : 
	            						currentAuthor.concat(StringPool.COMMA + standardsAuthor.getAuthorName());
	            					
	            			StandardsAuthorsLocalServiceUtil.deleteStandardsAuthors(standardsAuthor);
			            }
	            		StandardsAuthors primAuthors = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, "Y").get(0);
            			String updatedAuthor = primAuthors.getAuthorName()+","+newAuthor;
	            		if (addUpdateOtherAuthor(user, newAuthor, calendar, stdId))
	            		{
	            			comments = "Other Author was updated from " + currentAuthor + " to " + newAuthor; 
	            			LOG.info("Current Author ----->" + currentAuthor);	
	            			updateAuthorOnStd(std, user, currentAuthor, updatedAuthor, comments, true);
	            		}
		            }
	            	else
		            {
	            		if (addUpdateOtherAuthor(user, newAuthor, calendar, stdId))
	            		{
	            			comments = "Other Author was added as "+ newAuthor; 
	            			updateAuthorOnStd(std, user, currentAuthor, newAuthor, comments, false);
	            		}	
		            }
	            }
            }
        }
   }
    
    /**
     * Add or update other author.
     * @param user
     * @param newAuthor
     * @param calendar
     * @param stdId
     * @return
     * @throws SystemException
     */
    public static boolean addUpdateOtherAuthor(User user, String newAuthor, Calendar calendar, long stdId) throws SystemException
    {
    	// find primary author for the standard
    	boolean checkPrimary = false;
    	if (!StandardsUtil.isNullOrBlank(StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, "Y")))
    	{
    		StandardsAuthors primAuthors = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, "Y").get(0);
    		if (!newAuthor.equals(primAuthors.getAuthorName()))
    		{
    			addAuthor(user, newAuthor, calendar, stdId);
    			checkPrimary = true;
    		}
    	}
    	return checkPrimary;
	}
    
    /**
     * Add new other author.
     * @param user
     * @param newAuthor
     * @param calendar
     * @param stdId
     * @throws SystemException
     */
    public static void addAuthor(User user, String newAuthor, Calendar calendar, long stdId ) throws SystemException
    {
    	final long stdAuthorId = CounterLocalServiceUtil.increment(StandardsAuthors.class.getName());
        final StandardsAuthors author = StandardsAuthorsLocalServiceUtil.createStandardsAuthors(stdAuthorId);
    	
        author.setAuthorName(newAuthor);
    	author.setStdId(stdId);
    	author.setIsPrimary("N");
        author.setCreatorId(user.getScreenName());
        author.setCreatedDate(calendar.getTime());
        author.setUpdatedBy(user.getScreenName());
        author.setUpdatedDate(calendar.getTime());
        
        StandardsAuthorsLocalServiceUtil.addStandardsAuthors(author);
    }
    
    /**
     * Delete Other Author.
     * @param actionRequest request
     * @param actionResponse response
     * @throws SystemException exception
     * @throws PortalException exception
     */
    public static void deleteOtherAuthor(User user, String currAuthorOrOwner, String stdIds, String regionCode) throws SystemException, PortalException
    {
        if (!BrandStandardsUtil.IsNullOrBlank(stdIds) && !BrandStandardsUtil.IsNullOrBlank(currAuthorOrOwner) )
        {
        	List<Long> stdIdLists = getStandardsIds(stdIds);
        	boolean deleteAuthor = true;
        	List<Standards> deleteStandards = new ArrayList<Standards>();
        	for (Long stdId : stdIdLists) 
            {
        		Standards std = StandardsLocalServiceUtil.getStandards(stdId);
        		if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode))
            	{
	        		List<StandardsAuthors> authorList = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, "N");
	        		for (StandardsAuthors standardsAuthor : authorList) 
	        		{
	        			if (currAuthorOrOwner.equals(standardsAuthor.getAuthorName()))
	        			{	
	        				deleteAuthor(deleteAuthor, standardsAuthor);
	        			}	
					}
	        		deleteStandards.add(std);
            	}	
            }
        	deleteStdAuthor(deleteStandards, user, currAuthorOrOwner);
        }
        else
        {
        	List<Long> stdIdLists = new ArrayList<Long>(); 
            List<Long> delStdIds = new ArrayList<Long>(); 
            List<Standards> stdList = new ArrayList<Standards>();
            List<StandardsAuthors> authorList = StandardsAuthorsLocalServiceUtil.getStandardsAuthorsByAuthor(currAuthorOrOwner, "N");

            for (StandardsAuthors authors : authorList)
            {
                boolean deleteAuthor = isUpdateAuthor(stdIdLists, stdList, delStdIds, authors.getStdId());
                deleteAuthor(deleteAuthor, authors);
            }
            
            deleteStdAuthor(stdList, user, currAuthorOrOwner);
        }
    }
    
    /**
     * Update Owner.
     * @param actionRequest request
     * @param actionResponse response
     * @throws SystemException exception
     * @throws PortalException exception
     */
    public static void updateOwner(User user, String currAuthorOrOwner, String newAuthorOrOwner, String stdIds, String regionCode) throws SystemException, PortalException
    {
        
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        if (!BrandStandardsUtil.IsNullOrBlank(currAuthorOrOwner) && !BrandStandardsUtil.IsNullOrBlank(newAuthorOrOwner) )
        {
        	
            List<Standards> stdList = StandardsLocalServiceUtil.getStandardsByOwner(currAuthorOrOwner);
            for (Standards std : stdList)
            {
                std.setBusinessOwner(newAuthorOrOwner);
                std.setUpdatedBy(user.getScreenName());
                std.setUpdatedDate(calendar.getTime());
                StandardsLocalServiceUtil.updateStandards(std);
                String comments = "Owner was updated from " + currAuthorOrOwner + " to " + newAuthorOrOwner;
                updateWorkflow(user, std, comments);
            }
        }
        else if(!BrandStandardsUtil.IsNullOrBlank(stdIds) && !BrandStandardsUtil.IsNullOrBlank(newAuthorOrOwner) )
        {
        	List<Long> stdIdLists = getStandardsIds(stdIds);
        	for (Long stdId : stdIdLists) 
        	{
        		Standards std = StandardsLocalServiceUtil.getStandards(stdId);
        		if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode))
            	{
        			String oldOwner = std.getBusinessOwner();
	        		std.setBusinessOwner(newAuthorOrOwner);
	                std.setUpdatedBy(user.getScreenName());
	                std.setUpdatedDate(calendar.getTime());
	                StandardsLocalServiceUtil.updateStandards(std);
	                String comments = "Owner was updated from "+oldOwner+" to " + newAuthorOrOwner;
	                updateWorkflow(user, std, comments);
            	}
        	}
        }
    }
    
    /**
     * Update Brand status by std passing stdId.
     * @param actionRequest request
     * @param actionResponse response
     * @throws SystemException exception
     * @throws PortalException exception
     */
    public static void  updateBrandStatus(User user, String regionCode, Preferences preferences, ResourceRequest resourceRequest) throws SystemException, PortalException
    {
    	List<Long> stdIds = getStandardsIds(resourceRequest.getParameter("updateStdIds"));
        List<String> chainStatuses = Arrays.asList(resourceRequest.getParameter("selectedBrandsStatus").split(StringPool.UNDERLINE));
        if (!BrandStandardsUtil.IsNullOrBlank(stdIds))
        {
        	for (Long stdId : stdIds) 
        	{
        		Standards std = StandardsLocalServiceUtil.getStandards(stdId);
        		if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode))
            	{
        			 updateChains(user, stdId, chainStatuses);
            	}
			}
        }
    }
    
    /**
     * Update Author by Standards ids.
     * @param user
     * @param currAuthor
     * @param newAuthor
     * @param primaryInd
     * @throws SystemException
     * @throws PortalException
     */
    private static void updateAuthorByStdIds(User user, String newAuthor, String primaryInd, String stdIds, String regionCode) throws SystemException, PortalException
    {
        if (!BrandStandardsUtil.IsNullOrBlank(stdIds) && !BrandStandardsUtil.IsNullOrBlank(newAuthor))
        {
            List<Long> stdIdLists = getStandardsIds(stdIds);
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            boolean updateAuthor = true;
            String currentAuthor = StringPool.BLANK;
            String comments = StringPool.BLANK;
            for (Long stdId : stdIdLists) 
            {
            	Standards std = StandardsLocalServiceUtil.getStandards(stdId);
            	if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode))
            	{	
	            	List<StandardsAuthors> authorList = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, primaryInd);
	            	for (StandardsAuthors standardsAuthor : authorList) 
	            	{
	            		currentAuthor = standardsAuthor.getAuthorName();
	            		comments = "Primary Author was updated from " + currentAuthor + " to " + newAuthor;
	            		updateAuthor(user, newAuthor, updateAuthor, calendar, standardsAuthor, primaryInd);
	            		updateAuthorOnStd(std, user, currentAuthor, newAuthor, comments, false);
	            	}
            	}
            }
            adjustOtherAuthors(newAuthor, primaryInd, stdIdLists, regionCode);
        }
    }
    
    /**
     * Get List of stdIds by passing string of stdIds.
     * 
     * @param stdIds
     * @return
     */
    public static List<Long> getStandardsIds(String stdIds) 
    {
    	
    	String[] standardsIds = stdIds.split(" |,");
    	LOG.info("Length if Std IDs  "+ standardsIds.length);
    	List<Long> stdLists = new ArrayList<Long>();
    	for (String string : standardsIds) 
    	{
			if (!BrandStandardsUtil.IsNullOrBlank(string))
				stdLists.add(GetterUtil.getLong(string, 0));
		}
    	 
    	return stdLists;
    }
    
    /**
     * Update Author on STD_AUTHOR table.
     * @param user User
     * @param currAuthor current author
     * @param newAuthor new author
     * @param primaryInd Y/N primary author indicator
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void updateAuthor(User user, String currAuthor, String newAuthor, String primaryInd, String regionCode) throws SystemException, PortalException
    {
    	if (!BrandStandardsUtil.IsNullOrBlank(currAuthor) && !BrandStandardsUtil.IsNullOrBlank(newAuthor))
        {
            List<Long> stdIds = new ArrayList<Long>(); 
            List<Long> delStdIds = new ArrayList<Long>(); 
            List<Standards> stdList = new ArrayList<Standards>();
            String comments = StringPool.BLANK;
            List<StandardsAuthors> authorList = StandardsAuthorsLocalServiceUtil.getStandardsAuthorsByAuthor(currAuthor, primaryInd);
            Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
            for (StandardsAuthors authors : authorList)
            {
                boolean updateAuthor = isUpdateAuthor(stdIds, stdList, delStdIds, authors.getStdId());
                updateAuthor(user, newAuthor, updateAuthor, calendar, authors, primaryInd);
            }
            
            adjustOtherAuthors(newAuthor, primaryInd, stdIds, regionCode);
            if ("Y".equals(primaryInd))
            {
                comments = "Primary Author was updated from " + currAuthor + " to " + newAuthor;
            }
            else 
            {
                comments = "Other Author was updated from " + currAuthor + " to " + newAuthor;
            }
            updateStandardsAuthor(user, currAuthor, newAuthor, stdList, comments);
        }
    }

    /**
     * Update Author on List of Standards.
     * @param user User
     * @param currAuthor current author
     * @param newAuthor new author
     * @param stdList list of Standards
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void updateStandardsAuthor(User user, String currAuthor, String newAuthor, List<Standards> stdList, String comments) throws SystemException, PortalException
    {
        for (Standards std : stdList)
        {
            updateAuthorOnStd(std, user, currAuthor, newAuthor, comments, false);
        }
    }

    /**
     * Adjust Other Author.
     * @param primAuthor primary author
     * @param stdIds standard id
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void adjustOtherAuthors(String primAuthor, String primaryInd, List<Long> stdIds, String regionCode) throws SystemException, PortalException
    {
        if ("Y".equals(primaryInd))
        {
            adjustOtherAuthors(primAuthor, stdIds, regionCode);
        }
    }

    /**
     * Execute update on StdAuthor.
     * @param user user
     * @param newAuthor new author
     * @param updateAuthor true/false
     * @param calendar calendar
     * @param authors standard author object
     * @throws SystemException exception
     */
    private static void updateAuthor(User user, String newAuthor, boolean updateAuthor, Calendar calendar, StandardsAuthors authors, String primaryInd)
            throws SystemException
    {
        if (updateAuthor)
        {
            if ("N".equals(primaryInd))
            {
                // find primary author for the standard 
                if (!StandardsUtil.isNullOrBlank(StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(authors.getStdId(), "Y")))
                {
                    StandardsAuthors obj = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(authors.getStdId(), "Y").get(0);
                    if (newAuthor.equals(obj.getAuthorName()))
                    {
                        StandardsAuthorsLocalServiceUtil.deleteStandardsAuthors(authors);
                    }
                    else 
                    {
                        updateAuthor(user, newAuthor, calendar, authors);
                    }
                }
                else 
                {
                    updateAuthor(user, newAuthor, calendar, authors);
                }
            }
            else 
            {
                updateAuthor(user, newAuthor, calendar, authors);
            }
        }
    }

    /**
     * Execute update on StdAuthor.
     * @param user user
     * @param newAuthor new author
     * @param calendar calendar
     * @param authors standard author object
     * @throws SystemException exception
     */
    private static void updateAuthor(User user, String newAuthor, Calendar calendar, StandardsAuthors authors) throws SystemException
    {
        authors.setAuthorName(newAuthor);
        authors.setUpdatedBy(user.getScreenName());
        authors.setUpdatedDate(calendar.getTime());
        StandardsAuthorsLocalServiceUtil.updateStandardsAuthors(authors);
    }

    /**
     * Verify is Standard has Other Author same as Primary Author and if so, delete Other Author.
     * @param primAuthor primary author
     * @param stdIds standard id
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void adjustOtherAuthors(String primAuthor, List<Long> stdIds, String regionCode) throws SystemException, PortalException
    {
        for (Long stdId : stdIds)
        {
            // find other authors for the standard 
        	Standards std = StandardsLocalServiceUtil.getStandards(stdId);
        	if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equals(regionCode)) 
        	{
	            List<StandardsAuthors> otherAuthors = StandardsAuthorsLocalServiceUtil.getAuthorStdIdPrimary(stdId, "N");
	            for (StandardsAuthors author : otherAuthors)
	            {
	                if (primAuthor.equals(author.getAuthorName()))
	                {
	                    StandardsAuthorsLocalServiceUtil.deleteStandardsAuthors(author);
	                }
	            }
        	}    
        }
    }

    /**
     * Find out if system should update Author.
     * @param stdIds list of standards ids for Standards to be updated
     * @param stdList list of Standards to be updated
     * @param delStdIds list of deleted standard ids
     * @param stdId current standard id
     * @return true/false
     */
    private static boolean isUpdateAuthor(List<Long> stdIds, List<Standards> stdList, List<Long> delStdIds, long stdId)
    {
        boolean updateAuthor = true;
        if (!stdIds.contains(stdId) && !delStdIds.contains(stdId))
        {
            Standards std = null;
            try
            {
                std = StandardsLocalServiceUtil.getStandards(stdId);
            }
            catch (PortalException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            catch (SystemException e)
            {
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            if (std != null && !"DELETED".equals(std.getStatus()))
            {
                stdList.add(std);
                stdIds.add(stdId);
                updateAuthor = true;
            }
            else 
            {
                delStdIds.add(stdId);
                updateAuthor = false;
            }
        }
        else if (delStdIds.contains(stdId))
        {
            updateAuthor = false;
        }
        return updateAuthor;
    }

    /**
     * Update Author on STD table.
     * @param std standard 
     * @param user User
     * @param currAuthor current author
     * @param newAuthor new author
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void updateAuthorOnStd(Standards std, User user, String currAuthor, String newAuthor, String comments, boolean isOtherAuthor) throws SystemException, PortalException
    {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        String current = std.getAuthor();
        String author = newAuthor;
        if (current != null && !current.isEmpty())
        {
        	if (!isOtherAuthor)
        	{
	            if (current.contains("," + newAuthor))
	            {
	                author = current.replace(currAuthor + ",", "");
	            }
	            else if (current.contains(newAuthor + ","))
	            {
	                author = current.replace("," + currAuthor, "");
	            }
	            else 
	            {
	                author = currAuthor.length() == 0 ? current.concat(","+newAuthor) : current.replace(currAuthor, newAuthor);
	            }
        	}
        	else
        	{
        		author = newAuthor;
        	}
        }
        
        std.setAuthor(author);
        std.setUpdatedBy(user.getScreenName());
        std.setUpdatedDate(calendar.getTime());
        StandardsLocalServiceUtil.updateStandards(std);
        
        updateWorkflow(user, std, comments);
    }
    
   
    /**
     * Execute update on StdAuthor.
     * @param deleteAuthor true/false
     * @param authors standard author object
     * @throws SystemException exception
     */
    private static void deleteAuthor(boolean deleteAuthor, StandardsAuthors authors) throws SystemException
    {
        if (deleteAuthor)
        {
            StandardsAuthorsLocalServiceUtil.deleteStandardsAuthors(authors);
        }
    }

    /**
     * Update Author on STD table.
     * @param user User
     * @param currAuthor current author
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void deleteStdAuthor(List<Standards> stdList, User user, String currAuthor) throws SystemException, PortalException
    {
        for (Standards std : stdList)
        {
            deleteStdAuthor(std, user, currAuthor);
        }
    }
        
    /**
     * Update Author on STD table.
     * @param std standard 
     * @param user User
     * @param delAuthor author to be deleted
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void deleteStdAuthor(Standards std, User user, String delAuthor) throws SystemException, PortalException
    {
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        String currAuthor = std.getAuthor();
        String author = "";
        if (currAuthor != null && !currAuthor.isEmpty())
        {
            if (currAuthor.contains("," + delAuthor))
            {
                author = currAuthor.replace("," + delAuthor, "");
            }
            else if (currAuthor.contains(delAuthor + ","))
            {
                author = currAuthor.replace(delAuthor + ",", "");
            }
            else 
            {
                author = "";
            }
        }
        std.setAuthor(author);
        std.setUpdatedBy(user.getScreenName());
        std.setUpdatedDate(calendar.getTime());
        StandardsLocalServiceUtil.updateStandards(std);
        String comments = "The " + delAuthor + " Other Author was removed";
        updateWorkflow(user, std, comments);
    }
    
   
   /**
     * Update Chain status for passed standards id.
     * 
     * @param user
     * @param stdId
     * @param chainStatuses
     * @throws SystemException
     * @throws PortalException
     */
    private static void updateChains(User user, long stdId, List<String> chainStatuses)
    	    throws SystemException, PortalException
    {
    	final Date currDate = new Date();
    	String chain = StringPool.BLANK;
    	String status = StringPool.BLANK;
    	String prevStatus = StringPool.BLANK;
    	String newStatus = StringPool.BLANK;
    	for (String chainStatus : chainStatuses)
    	{
    		ChainStandards chnStd = null;
    		String[] split = chainStatus.split(StringPool.DASH);
    		chain = split[0];
    		status = split[1];
    		if (chainExists(chain, stdId))
    		{
    			chnStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(stdId,chain); 
    			prevStatus =  StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getTitle();
    			chnStd.setChainCode(chain);
    			chnStd.setUpdatedBy(String.valueOf(user.getUserId()));
    			chnStd.setUpdatedDate(currDate);
    			if (!StandardsUtil.IsNullOrBlank(status.trim()) && !status.equals("NA")) 
    			{
    				chnStd.setStatusId(Long.valueOf(status));
        		}
        	}
    		if (!BrandStandardsUtil.IsNullOrBlank(chnStd)) 
    		{	
    			Standards std = StandardsLocalServiceUtil.getStandards(stdId);
    			ChainStandardsLocalServiceUtil.updateChainStandards(chnStd);
    			newStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getTitle();
    			String comments = "Status has updated from "+ prevStatus +" to "+ newStatus ;
    			updateWorkflowForBrand(user, std, comments, chnStd);
    		}  
    	}
    	ChainStandardsLocalServiceUtil.clearCache();	
    }
    
    /**
     * Verify if chain linked to a Standard.
     * 
     * @param chain - chain code
     * @param stdId - Standard Id
     * @return - true/false
     * @throws SystemException - exception
     */
    public static boolean chainExists(final String chain, final long stdId) throws SystemException
    {
        boolean exists = false;
        if (stdId > 0)
        {
            try
            {
                ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId, chain);
                exists = true;
            }
            catch (PortalException exc)
            {
                exists = false;
            }
        }
        return exists;
    }
    
    
    /**
     * Update Audit log.
     * 
     * @param user - user
     * @param std - record
     * @param comments - comments
     * @throws SystemException - exception on addWorkflow.
     * @throws PortalException 
     */
    private static void updateWorkflow(final User user, Standards std, final String comments)
            throws SystemException, PortalException
    {
        List<ChainStandards> brands = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(std.getStdId());
        
        if (!StandardsUtil.IsNullOrBlank(brands))
        {
            for (ChainStandards chnStd : brands)
            {
                String brandCd = chnStd.getChainCode();
                Workflow lastLog = WorkflowLocalServiceUtil.getLastLogBySTDObjectId(std.getStdId(), brandCd);
                addAuditLog(user, std, comments, lastLog, brandCd, chnStd);
            }
        }
        else 
        {
            Workflow lastLog = WorkflowLocalServiceUtil.getLastLogBySTDObjectId(std.getStdId());
            addAuditLog(user, std, comments, lastLog, null, null);
        }
    }

    /**
     * Update Audit log.
     * 
     * @param user - user
     * @param std - record
     * @param comments - comments
     * @throws SystemException - exception on addWorkflow.
     * @throws PortalException 
     */
    private static void updateWorkflowForBrand(final User user, Standards std, final String comments, ChainStandards chnStds)
            throws SystemException, PortalException
    {
        if (!StandardsUtil.IsNullOrBlank(chnStds))
        {
            String brandCd = chnStds.getChainCode();
            Workflow lastLog = WorkflowLocalServiceUtil.getLastLogBySTDObjectId(std.getStdId(), brandCd);
            addAuditLog(user, std, comments, lastLog, brandCd, chnStds);
        }
    }

    
    /**
     * Create Audit log entry
     * @param user user
     * @param std standard
     * @param comments comments
     * @param lastLog last log entry
     * @param brandCd brand
     * @throws SystemException exception
     * @throws PortalException 
     */
    private static void addAuditLog(final User user, Standards std, final String comments, Workflow lastLog, String brandCd, ChainStandards chnStd) throws SystemException, PortalException
    {
        final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
        final Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
        String newStatus = StringPool.BLANK;
        String prevStatus = StringPool.BLANK;
        String chainCd;
        
        if (StandardsUtil.IsNullOrBlank(lastLog))
        {
            newStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
            chainCd = brandCd;
            prevStatus = newStatus;
        }
        else
        {
            if (!StandardsUtil.IsNullOrBlank(chnStd))
            {
            	newStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getStatusCode();
            }
            else
            {
            	newStatus = lastLog.getStatus();
            }
            prevStatus = lastLog.getStatus();
            chainCd = lastLog.getChainCode();
        }
        workflow.setStatus(newStatus);
        workflow.setPrevStatus(prevStatus);
        workflow.setObjectId(std.getStdId());
        workflow.setObjectType(std.getStdTyp());
        workflow.setCreatedBy(user.getScreenName());
        workflow.setUpdatedBy(String.valueOf(user.getUserId()));
        Calendar calendar = new GregorianCalendar(TimeZone.getTimeZone("GMT"));
        workflow.setUpdatedDate(calendar.getTime());
        workflow.setCreatedDate(calendar.getTime());
        workflow.setCreatorId(String.valueOf(user.getUserId()));
        workflow.setComment(comments);
        workflow.setChainCode(chainCd);
        if (std.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
        {
            workflow.setTitle(std.getDescription());
        }
        else
        {
            workflow.setTitle(std.getTitle());
        }
        
        WorkflowLocalServiceUtil.addWorkflow(workflow);
    }
    
    /**
     * Get preferences by passing request for common request.
     * @param portletRequest
     * @return
     */
    public static Preferences getPreferences(PortletRequest portletRequest)
    {
    	 final HttpServletRequest hsrw = PortalUtil.getHttpServletRequest(portletRequest);
         final HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(hsrw);
         return  (Preferences)httpRequest.getSession().getAttribute("Preferences");
    }
    
    /**
     * Get region code based on login user.
     * @param preferences
     * @param user
     * @param isSuperAdmin
     * @return
     * @throws SystemException
     */
    public static String getRegionCode(Preferences preferences, User user, boolean isSuperAdmin) throws SystemException
    {
    	String regionCode = StringPool.BLANK;
    	if (!BrandStandardsUtil.IsNullOrBlank(preferences))
    	{
    		if (isSuperAdmin) 
    	
	        {
	        	regionCode = preferences.getRegionCode();
	        }
	    	else
	    	{
	    		regionCode  = StandardsController.getRegionCodeFromUserRole(user.getRoles());
	    	}
    	}
    	return regionCode;
    }
}
