package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
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
import com.ihg.brandstandards.custom.model.Standard;
import com.ihg.brandstandards.db.NoSuchChainStandardsException;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalService;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
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
    private static HashSet<Long> failedBrandListSet= new HashSet<Long>();
    //private static  Map<Long,String> reCheckBrandListSet = new HashMap<Long,String>();
    private static  Map<Long,List<String>> reCheckBrandListSet = new HashMap<Long,List<String>>();
    private static  List<String> chainList = new ArrayList<String>();
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
            	 	JSONObject json = JSONFactoryUtil.createJSONObject();
	        	 	List<Standards> childStandards = new ArrayList<Standards>();
	        	 	Map<String,List<ChainStandards>> chaineStandardsMap = new HashMap<String,List<ChainStandards>>();
	        	 	List<ChainStandards> parentChainstandards = new ArrayList<ChainStandards>();
				if (reCheckBrandListSet.size() > 0) {
					for (Entry<Long, List<String>> entry : reCheckBrandListSet.entrySet()) {
						int i = 0;
						Standards std = StandardsLocalServiceUtil.getStandards(entry.getKey());
						ChainStandards cs = null;
						try {
							for (String ch : entry.getValue()) {
								i++;
								cs = ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(std.getParentId(), ch);
								if (cs != null) {
							if (failedBrandListSet.size() > 0) {
								parentChainstandards = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(std.getStdId());
								chaineStandardsMap.put("parentChainMap",parentChainstandards);
								childStandards = StandardsLocalServiceUtil.getStandardsByParent(std.getStdId());
								chaineStandardsMap = getChildstandardsList(childStandards,chaineStandardsMap);
								Map<List<List<Long>>, Map<String, Boolean>> failedattriStdsCheck = failedattriStdsCheck(chaineStandardsMap,	std.getStdId(),BSAdminConstants.CHAIN_ATTRIBUTE,ch);
							 if (failedattriStdsCheck.size() > 0) {
								for (Entry<List<List<Long>>, Map<String, Boolean>> etry : failedattriStdsCheck.entrySet()) {
							    for (Entry<String, Boolean> entry1 : etry.getValue().entrySet()) {
							 if (entry1.getValue() == true) {
								Iterator<Long> ite = failedBrandListSet.iterator();
							    while (ite.hasNext()) {
								Long value = ite.next();
								if (entry.getKey().compareTo(value) == 0) {
									if (i == entry.getValue()
											.size()) {
										ite.remove();
									}
									attributeAndUnAttribute(ch,std.getStdId(),BSAdminConstants.CHAIN_ATTRIBUTE,std,user);
									}
								}
								      }
								  }
									          }

							     }

							       }
								      }
						     }

						} catch (Exception e) {
							failedBrandListSet.add(entry.getKey());
							e.printStackTrace();
						}
					}
				}
            	    if(failedBrandListSet.size() > 0){
                 	   	json.put("failedBrandListSet", failedBrandListSet.toString());
            	    }
            	    resourceResponse.getWriter().write(json.toString());
              	    resourceResponse.setContentType("application/json");
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
    public void updateBrandStatus(User user, String regionCode, Preferences preferences, ResourceRequest resourceRequest)
    {
    	List<Long> stdIds = getStandardsIds(resourceRequest.getParameter("updateStdIds"));
        List<String> chainStatuses = Arrays.asList(resourceRequest.getParameter("selectedBrandsStatus").split(StringPool.UNDERLINE));
        boolean isSuperAdmin = false;
		try {
			isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
		} catch (SystemException e1) {
			LOG.error(StackTraceUtil.getStackTrace(e1));
		}
        if (!BrandStandardsUtil.IsNullOrBlank(stdIds))
        {
        	
        	for (Long stdId : stdIds) 
        	{
        		try {
					Standards std = StandardsLocalServiceUtil.getStandards(stdId);
					 attributeUnAttributeChain(user, stdId, chainStatuses,isSuperAdmin,resourceRequest,regionCode);
					 
					if (!BrandStandardsUtil.IsNullOrBlank(std) && std.getRegionCode().equalsIgnoreCase(regionCode))
					{
						updateChains(user, stdId, chainStatuses);
					}
        		  }catch (PortalException e) 
			    	{
        			    failedBrandListSet.add(stdId);
						LOG.error("Invalid User "+ StackTraceUtil.getStackTrace(e));
					} catch (SystemException e) 
					{
						 failedBrandListSet.add(stdId);
						LOG.error("Unknown User "+ StackTraceUtil.getStackTrace(e));
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
    	failedBrandListSet= new HashSet<Long>();
    	reCheckBrandListSet = new HashMap<Long,List<String>>();
    	 chainList = new ArrayList<String>();
    	String[] standardsIds = stdIds.split(" |,");
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
    	 if(!(status.equalsIgnoreCase(BSAdminConstants.CHAIN_UN_ATTRIBUTE) || status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE))){			
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
    	}
    	ChainStandardsLocalServiceUtil.clearCache();	
    }
    
    /**
     * Attribute chain to standard if new chain selected else unAttribute from standard.
     * 
     * @param chain - chain code
     * @param stdId - Standard Id
     * @param User -  user Obj
     * @param ChainStandards - chnStd Obj
     * @param status - status 
     */
    
    public void attributeUnAttributeChain(User user, long stdId, List<String> chainStatuses, boolean isSuperAdmin,ResourceRequest resourceRequest,String regionCode) 
    { 
    	
    	String chain = StringPool.BLANK;
    	String status = StringPool.BLANK;
    	String prevStatus = StringPool.BLANK;
    	String newStatus = StringPool.BLANK;
    	String superAdminregionCode = StringPool.BLANK;
    	List<String> chainList = new ArrayList<String>();
    	Preferences preferences = getPreferences(resourceRequest);
    	boolean flag = false;
    	boolean attrFailedStdsChk = false;
        Standards std = null;
        boolean isSuccess= false;
        boolean isparent= false;
        boolean hasParentHasBrand= false;
      
        Map<String,List<ChainStandards>> chaineStandardsMap = new HashMap<String,List<ChainStandards>>();
        List<ChainStandards> parentChainstandards = new ArrayList<ChainStandards>();
        ChainStandards unAttrichainstnds = null;
        List<Standards> childStandards = new ArrayList<Standards>();
		try {
			std = StandardsLocalServiceUtil.getStandards(stdId);
			
			if(std.getStdId() == std.getParentId()){
				isparent= true;
			}
			for (String chainStatus : chainStatuses)
	    	{
	    		ChainStandards chnStd = null;
	    		String[] split = chainStatus.split(StringPool.DASH);
	    		chain = split[0];
	    		status = split[1];
	    		 if(status.equalsIgnoreCase(BSAdminConstants.CHAIN_UN_ATTRIBUTE) || status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE)){		
	    		  
		    		   if(regionCode.equalsIgnoreCase("GLBL")){
		    			  parentChainstandards = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(std.getStdId());
		    			  chaineStandardsMap.put("parentChainMap", parentChainstandards);
		    			  childStandards = StandardsLocalServiceUtil.getStandardsByParent(std.getStdId());
			    		  chaineStandardsMap = getChildstandardsList(childStandards,chaineStandardsMap);
						  isSuccess = true;
		    		    }else if(std.getRegionCode().equalsIgnoreCase(regionCode) || getRegionCode(preferences, user, isSuperAdmin).equalsIgnoreCase(std.getRegionCode())){
		    		    	parentChainstandards = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(std.getStdId());
		    			    chaineStandardsMap.put("parentChainMap", parentChainstandards);
		    			    childStandards = StandardsLocalServiceUtil.getByRegionCodeAndParentId(std.getRegionCode(), std.getParentId());
		    			    chaineStandardsMap = getChildstandardsList(childStandards,chaineStandardsMap);
						   isSuccess = true; 
		    			 }
		    		   
		    		   if(!(isparent) && status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE)){
		    			   try {
							 ChainStandards cs =  ChainStandardsLocalServiceUtil.getChainStandardsByChainCode(std.getParentId(), chain);
							 hasParentHasBrand = true;
						} catch (Exception e) {
							if(!(hasParentHasBrand)){
							    chainList.add(chain);
								reCheckBrandListSet.put(std.getStdId(), chainList);
			    			    isSuccess = false;
			    		   }
							 LOG.error(StackTraceUtil.getStackTrace(e));
						}
		    			  
			    	      }
		    		   
	    		 if(isSuccess){
	    			  if(status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE)){
	    				  Map<List<List<Long>>,Map<String,Boolean>>failedattriStdsCheck= failedattriStdsCheck(chaineStandardsMap, stdId,"Attribute",chain); 
		       				 if(failedattriStdsCheck.size() >0){
		       				 for(Entry<List<List<Long>>, Map<String, Boolean>> entry :failedattriStdsCheck.entrySet()){
		       				 for(Entry<String, Boolean> entry1 :entry.getValue().entrySet()){
			       				 if(entry1.getValue() == true){
			       				 attributeAndUnAttribute(chain,std.getStdId(),status, std, user); 
		       				 }else{
		       					if(entry.getKey().size() > 0){
		       					for(List<Long> attr :entry.getKey()){
		       						if(attr.size() > 0){
		       						for(Long d :attr){
		       							failedBrandListSet.add(d);
		       						}
		       						}
		       					}
		       					}
		       				 }
		       			  }
		       				 }
		       				 }
	    			  }else{
	    				  Map<List<List<Long>>,Map<String,Boolean>>failedUnattriStdsCheck= failedattriStdsCheck(chaineStandardsMap, stdId,"UnAttribute",chain); 
		       			     if(failedUnattriStdsCheck.size() >0){
			       				 for(Entry<List<List<Long>>, Map<String, Boolean>> entry :failedUnattriStdsCheck.entrySet()){
			       				 for(Entry<String, Boolean> entry1 :entry.getValue().entrySet()){
				       				 if(entry1.getValue() == true){
				       				  List<ChainStandards> cSt = ChainStandardsLocalServiceUtil.getChainStandardsByStdIdAll(stdId);
				       				 if(cSt.size()>1){ 
				       				 if(entry1.getKey().equalsIgnoreCase("AllParentsAndChild")){
				       					 attributeAndUnAttribute(chain,std.getStdId(),status, std, user);
				       					if(chaineStandardsMap.size() > 0){
				       						for(Map.Entry<String,List<ChainStandards>> enty :chaineStandardsMap.entrySet()){
				       						if(enty.getValue() != null){	
				       						for(ChainStandards chainStandards : enty.getValue()){
				       						if(enty.getKey().equalsIgnoreCase("childChainMap")){
				       						 if(chainStandards.getChainCode().equalsIgnoreCase(chain)){
				       							 attributeAndUnAttribute(chain,chainStandards.getStdId(),status, std, user);
				       						 }
				       						    }
				       				}
				       						}
				       						}
				       					}
				       				 }else if(entry1.getKey().equalsIgnoreCase("OnlyChild")){
				       					if(chaineStandardsMap.size() > 0){  
				       						for(Map.Entry<String,List<ChainStandards>> enty :chaineStandardsMap.entrySet()){
				       						if(enty.getValue() != null){	
				       						for(ChainStandards chainStandards : enty.getValue()){
				       						if(enty.getKey().equalsIgnoreCase("childChainMap")){
				       						 if(chainStandards.getChainCode().equalsIgnoreCase(chain)){
				       							 attributeAndUnAttribute(chain,chainStandards.getStdId(),status, std, user);
				       						 }
				       						   
				       						    }
				       						}
				       				     		 }
				       						}
				       					}
				       					
				       				 }else if(entry1.getKey().equalsIgnoreCase("OnlyParent")){
				       					if(chaineStandardsMap.size() > 0){  
				       						for(Map.Entry<String,List<ChainStandards>> enty :chaineStandardsMap.entrySet()){
				       						if(enty.getValue() != null){	
				       						for(ChainStandards chainStandards : enty.getValue()){
				       						if(enty.getKey().equalsIgnoreCase("parentChainMap")){
				       						 if(chainStandards.getChainCode().equalsIgnoreCase(chain)){
				       							 attributeAndUnAttribute(chain,chainStandards.getStdId(),status, std, user);
				       						 }
				       						   
				       						    }
				       						}
				       					    	 }
				       						}
				       					}
				       					
				       				 }
				       				 }else{
				       					failedBrandListSet.add(stdId); 
				       				 }
			       				 }else{
			       					if(entry.getKey().size() > 0){
				       					for(List<Long> attr :entry.getKey()){
				       						if(attr.size() > 0){
				       						for(Long d :attr){
				       							failedBrandListSet.add(d);
				       						}
				       						}
				       					}
			       					}
				       				 }
			       				 }
			       			  }
	    			  }
	    			  }
	    		 }else{
	    			 failedBrandListSet.add(std.getStdId());
	    		 }
	    	}
	    		 
	    	} 
	    	 } catch (PortalException e) {
	    			 LOG.error(StackTraceUtil.getStackTrace(e));
			} catch (SystemException e) {
				 LOG.error(StackTraceUtil.getStackTrace(e));
			 }
		
		   ChainStandardsLocalServiceUtil.clearCache();
    }
    
    /**
     * Get ChildstandardsList for Standards
     * @param childStandards
     * @param chaineStandardsMap
     * @return
     */
    public Map<String,List<ChainStandards>> getChildstandardsList(List<Standards> childStandards,Map<String,List<ChainStandards>> chaineStandardsMap){
    	  List<ChainStandards> childchainstnds = null;
          List<List<ChainStandards>> chstnds = new ArrayList<List<ChainStandards>>();
    	try {
			if(childStandards.size() > 0){
				  for(Standards chainStnds : childStandards){
					  if(chainStnds.getStdId() != chainStnds.getParentId()){
					  childchainstnds = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(chainStnds.getStdId());
					  chstnds.add(childchainstnds);
					  }
				  }
				  if(chstnds.size() > 0){
				  childchainstnds = new ArrayList<ChainStandards>(); 
				  for(List<ChainStandards> chstnd : chstnds){
					  for(ChainStandards chtd : chstnd){
						  childchainstnds.add(chtd);  
					  }
				  }
				  }
				  chaineStandardsMap.put("childChainMap", childchainstnds);
			  }
			
		} catch (SystemException e) {
			 LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	
    	return chaineStandardsMap;
    }
    /**
     * AttributeAndUnAttribute Standards
     * @param chain
     * @param stdId
     * @param status
     * @param std
     * @param user
     */
    public void attributeAndUnAttribute(String chain,long stdId,String status,Standards std,User user){
    	final Date currDate = new Date();
    	List<ExternalLinkStandards>externalLinkStandards = new ArrayList<ExternalLinkStandards>();
    	List<ChainExternalLinkStandards>chainExternalLinkStandards = new ArrayList<ChainExternalLinkStandards>();
    	List<ExternalLinkStandardsCountry> externalLinkStandardsCountry = new ArrayList<ExternalLinkStandardsCountry>();
    	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
    	try {
		  if (chainExists(chain, stdId)){
			    ChainStandards chnStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId, chain);
			    if(chnStd.getIsActive().equalsIgnoreCase("N")){
			       chnStd.setStatusId(StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getStatusId());	
			     }
			    chnStd.setIsActive(BSAdminConstants.CHAIN_IS_ACTIVE);
			    chnStd.setUpdatedBy(String.valueOf(user.getUserId()));
			    chnStd.setUpdatedDate(currDate);
			    ChainStandardsLocalServiceUtil.updateChainStandards(chnStd);
			    if(status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE)){
			    /*for attribute */
		 			String attributeComments = chnCdMap.get(chain)+" brand is attributed and status updated to "+ StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getTitle();
		 			updateWorkflowForBrand(user, std, attributeComments, chnStd);
			    }
			    if(status.equalsIgnoreCase(BSAdminConstants.CHAIN_UN_ATTRIBUTE)){
				    chnStd.setUpdatedBy(String.valueOf(user.getUserId()));
				    chnStd.setUpdatedDate(currDate);
				    /*for un attribute */
	    			String unAttributeComments = chnCdMap.get(chain)+" brand is Un-attributed for "+chnCdMap.get(chain)+" from status"+ StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getTitle();
		 			updateWorkflowForBrand(user, std, unAttributeComments, chnStd);
				    ChainStandards cs = ChainStandardsLocalServiceUtil.deleteChainStandards(chnStd);
			    }
		  }else{
			
			 if(status.equalsIgnoreCase(BSAdminConstants.CHAIN_ATTRIBUTE)){ 
				 ChainStandards chainStandards = ChainStandardsLocalServiceUtil.getChainStandardsObject();
				 chainStandards.setStdId(stdId);
				 chainStandards.setChainCode(chain);
				 chainStandards.setStatusId(StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getStatusId());	
				 chainStandards.setIsActive(BSAdminConstants.CHAIN_IS_ACTIVE);
				 chainStandards.setCreatedDate(currDate);
				 chainStandards.setCreatorId(String.valueOf(user.getUserId()));
				 chainStandards.setUpdatedBy(String.valueOf(user.getUserId()));
				 chainStandards.setUpdatedDate(currDate);
				 ChainStandardsLocalServiceUtil.addChainStandards(chainStandards);
				 /*for attribute */
	 			 String attributeComments = chnCdMap.get(chain)+" brand is attributed and Status updated to "+ StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getTitle();
	 			 updateWorkflowForBrand(user, std, attributeComments, chainStandards);
			  }
		  }
	} catch (NoSuchChainStandardsException e) {
		 LOG.error("No such ChainStandards Exits with "+ chain + "for" + stdId);
	} catch (SystemException e) {
		 LOG.error(StackTraceUtil.getStackTrace(e));
	} catch (PortalException e) {
		 LOG.error(StackTraceUtil.getStackTrace(e));
		}
	  
	ChainStandardsLocalServiceUtil.clearCache();	
    }
    
    /**
     * Retrieve Failed standardIds for Attribute and Unattribute
     * @param chainStandardsMap
     * @param stdId
     * @param type
     * @param chain
     * @return
     */
    public  Map<List<List<Long>>,Map<String,Boolean>> failedattriStdsCheck(Map<String,List<ChainStandards>> chainStandardsMap,long stdId,String type,String chain){
    	Map<List<List<Long>>,Map<String,Boolean>> failedStdMap = new HashMap<List<List<Long>>,Map<String,Boolean>>();
    	Map<String,Boolean> decidingMap =  new HashMap<String,Boolean>();
    	 List<String> standardsStatus = new ArrayList<String>();
    	  boolean failedStdsChk = false;
    	  List<Long> parentattributeFailedIds = new ArrayList<Long>();
    	  List<Long> childattributeFailedIds = new ArrayList<Long>();
    	  List<List<Long>> attributeFailedIds = new ArrayList<List<Long>>();
    	  String decidingFactor = null;
    	  
    	  try {
			  String status = StandardsStatusLocalServiceUtil.getStandardsStatus(1).getTitle();
				if(chainStandardsMap.size() > 0){  
				for(Map.Entry<String,List<ChainStandards>> entry :chainStandardsMap.entrySet()){
				if(entry.getValue()!=null){
				for(ChainStandards chainStandards : entry.getValue()){
					standardsStatus= getStandardsDisConStatusList();
					StandardsStatus standStusByChainStatId = StandardsStatusLocalServiceUtil.getStandardsStatus(chainStandards.getStatusId());
					String chainStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chainStandards.getStatusId()).getTitle();
					if(entry.getKey().equalsIgnoreCase("parentChainMap")){
						if(type.equalsIgnoreCase("Attribute")){
							if(standardsStatus.contains(standStusByChainStatId.getStatusCode())){
			    			    parentattributeFailedIds.add(stdId);
			    		}
						}else{
							if(chainStandardsMap.get("parentChainMap").size() > 1){
			    			  if(chainStandards.getChainCode().equalsIgnoreCase(chain) && !(chainStatus.equalsIgnoreCase(status))){
			    				  parentattributeFailedIds.add(stdId);
			    			  }  
							}
						}
					}if(entry.getKey().equalsIgnoreCase("childChainMap")){
						if(type.equalsIgnoreCase("Attribute")){
							if(standardsStatus.contains(standStusByChainStatId.getStatusCode())){
			        			childattributeFailedIds.add(stdId);
			        		}
						}else{
							if(chainStandardsMap.get("childChainMap").size() > 1){
								 if(chainStandards.getChainCode().equalsIgnoreCase(chain) && !(chainStatus.equalsIgnoreCase(status))){
			    				  childattributeFailedIds.add(stdId);
			    			  }
							}
						}
			    		}
				}
				}
				}
				attributeFailedIds.add(parentattributeFailedIds);
				attributeFailedIds.add(childattributeFailedIds);
				}
				
				
			if(type.equalsIgnoreCase("Attribute")){
					failedStdsChk = true;
					decidingFactor = "All";
				if(chainStandardsMap.get("parentChainMap")!= null){//All Parent ID brands are discontinued
					if(parentattributeFailedIds.size() == childattributeFailedIds.size()){
						Standards s = StandardsLocalServiceUtil.getStandards(stdId);
					if(s.getStdId() != s.getParentId()){
					List<Long> csPListId = new ArrayList<Long>();
					List<ChainStandards> sList = ChainStandardsLocalServiceUtil.getChainStandardsByStdIdAll(s.getParentId());
					boolean allPD = false;
					if(sList.size() > 0){
						for(ChainStandards chs : sList){
							StandardsStatus standStusByChainStatId = StandardsStatusLocalServiceUtil.getStandardsStatus(chs.getStatusId());
							if(standardsStatus.contains(standStusByChainStatId.getStatusCode())){
								csPListId.add(chs.getStdId());
							}
						}
						if(csPListId.size() == sList.size()){
							allPD = true;
							childattributeFailedIds.add(stdId);
						    attributeFailedIds.add(childattributeFailedIds);
						}
						if(allPD){
							   failedStdsChk = false;
						       decidingFactor = null;
						       
						}
					}
					  }
					}
				if(parentattributeFailedIds.size() == chainStandardsMap.get("parentChainMap").size()){
					List<ChainStandards> csList = ChainStandardsLocalServiceUtil.getChainStandardsByStdIdAll(stdId); 
					List<Long> csListId = new ArrayList<Long>();//All Parent ID brands are discontinued
					boolean allN = false;
					if(csList.size() > 0){
						for(ChainStandards cst : csList){
							if(cst.getIsActive().equalsIgnoreCase("N")){
								csListId.add(cst.getStdId());
							}
						}
						if(csListId.size() == csList.size()){
							allN = true;
						}
					}
					if(allN){
					       failedStdsChk = true;
					       decidingFactor = null;
					}else{
						   failedStdsChk = false;
					       decidingFactor = null;
					}
				       
				if(chainStandardsMap.get("childChainMap") != null){
					if(childattributeFailedIds.size() > 0 && childattributeFailedIds.size() == chainStandardsMap.get("childChainMap").size()){
						failedStdsChk = false;
						decidingFactor = null;
					}
				}}}else if(chainStandardsMap.get("parentChainMap")!= null && chainStandardsMap.get("childChainMap")!= null){//Parent one brand is disc And all child's are disc
						if(parentattributeFailedIds.size() > 0 && parentattributeFailedIds.size() < chainStandardsMap.get("parentChainMap").size() 
								&& childattributeFailedIds.size() == chainStandardsMap.get("childChainMap").size()){
							failedStdsChk = false;
							decidingFactor = null;
						}
				}else if(chainStandardsMap.get("childChainMap")!= null){
				if(parentattributeFailedIds.size() == 0 && childattributeFailedIds.size() == chainStandardsMap.get("childChainMap").size()){//Parent is not disc And all child's are disc
						failedStdsChk = false;
						decidingFactor = null;
					}
				}
			}else{
				if(parentattributeFailedIds.size() > 0 && chainStandardsMap.get("childChainMap") == null || (parentattributeFailedIds.size() > 0 && childattributeFailedIds.size() == 0)){//parent Id not in initial load
					failedStdsChk = false;
					decidingFactor = null;
				}else if(parentattributeFailedIds.size() == 0  && childattributeFailedIds.size() == 0 ){
						Standards stn = StandardsLocalServiceUtil.getStandards(stdId);
						ChainStandards ctn= null;
						 boolean brndIsP = false;
						 boolean brndN = false;
						 List<Standards> stnds = null;
						 ChainStandards chStnd = null;
                     if(stn.getStdId()==stn.getParentId()){
                    	 brndIsP = true;
                    	 stnds = StandardsLocalServiceUtil.getByParentId(stn.getParentId());
                     }
                     if(brndIsP){
                     if(stnds.size()> 0){
                     List<Long>csUnListId = new ArrayList<Long>();
                     for(Standards st :stnds){
					 ChainStandards csl = null;
					try {
						  csl = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(st.getStdId(), chain);
						  StandardsStatus standStusByChainStatId = StandardsStatusLocalServiceUtil.getStandardsStatus(csl.getStatusId());
						  if(csl.getChainCode().equalsIgnoreCase(chain) && csl.getIsActive().equalsIgnoreCase("N")){
							 ctn = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId, chain);
							 if(ctn.getChainCode().equalsIgnoreCase(chain) && ctn.getIsActive().equalsIgnoreCase("N")){
								 csUnListId =  new ArrayList<Long>();
							 }
							}else{
								if(csl.getChainCode().equalsIgnoreCase(chain) && !(standStusByChainStatId.getTitle().equalsIgnoreCase(status))){
									csUnListId.add(csl.getStdId());
								}
								
							}
					} catch (Exception e) {
						 LOG.error(StackTraceUtil.getStackTrace(e));
					}
					   if(csUnListId.size() > 0){
							brndN = true;
							childattributeFailedIds.add(stdId);
							attributeFailedIds.add(childattributeFailedIds);
						}
                    }
                     }
				   }
					 if(brndN){
						    failedStdsChk = false;
							decidingFactor = null;
							
					 }else{
						    failedStdsChk = true;
							decidingFactor = "AllParentsAndChild";
					 }
					 
				}else if(parentattributeFailedIds.size() == 0 &&  childattributeFailedIds.size() > 0){// parent Id is in initial load but not children
					 failedStdsChk = false;
					 decidingFactor = null;
				}else if(parentattributeFailedIds.size() > 0 &&  childattributeFailedIds.size() == 0){ // parent Id is not in initial load but children is in initial load
					failedStdsChk = true;
					decidingFactor = "OnlyChild";
				}
			}
			
			 decidingMap.put(decidingFactor, failedStdsChk);
			 failedStdMap.put(attributeFailedIds, decidingMap);
		} catch (NoSuchChainStandardsException e) {
			 LOG.error("No such ChainStandards Exits with "+ chain + "for" + stdId);
		} catch (SystemException e) {
			 LOG.error(StackTraceUtil.getStackTrace(e));
		} catch (PortalException e) {
			 LOG.error(StackTraceUtil.getStackTrace(e));
		}
    	 return failedStdMap;
    }
    /**
     * Get StandardsDisContinue StatusList
     * @return
     */
    public List<String> getStandardsDisConStatusList(){
    	 List<String> standardsStatus = new ArrayList<String>();
    	 try {
			 standardsStatus.add(StandardsStatusLocalServiceUtil.getStandardsStatus(2).getStatusCode());
			 standardsStatus.add(StandardsStatusLocalServiceUtil.getStandardsStatus(3).getStatusCode());
			 standardsStatus.add(StandardsStatusLocalServiceUtil.getStandardsStatus(4).getStatusCode());
			 standardsStatus.add(StandardsStatusLocalServiceUtil.getStandardsStatus(30).getStatusCode());
		} catch (PortalException e) {
			 LOG.error(StackTraceUtil.getStackTrace(e));
		} catch (SystemException e) {
			 LOG.error(StackTraceUtil.getStackTrace(e));
		}
    		
    	 return standardsStatus;
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
