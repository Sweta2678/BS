package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.bsadmin.model.GlossaryView;
import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.GlossaryUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.dao.orm.QueryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ArrayUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * Portlet implementation class GlossaryController.
 */
public class GlossaryController extends MVCPortlet 
{
	private static final Log LOG = LogFactoryUtil.getLog(GlossaryController.class);

	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException 
	{
	    try 
		{
			long userId = PortalUtil.getUserId(renderRequest);
			
			if (userId > 1)
			{
                renderRequest.setAttribute("loggedIn", true);
				final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
                        .getHttpServletRequest(renderRequest));
				String glossaryId  = httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID);
				String visibleChar = httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR);
				
				//Get Standard Region
				List<StandardsRegion> standardRegion = StandardsRegionLocalServiceUtil.getStandardsParentRegionsList();
				renderRequest.setAttribute("standardRegion", standardRegion);
				
				//Get Brands/chain MAP
				Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
				renderRequest.setAttribute("chnCdMap", chnCdMap);
				
				if (BrandStandardsUtil.IsNullOrBlank(glossaryId))
				{
					glossaryId = "-1";
					renderRequest.setAttribute("glossaryId", glossaryId);
					renderRequest.setAttribute("visibleChar", visibleChar);
					final GlossaryView glossaryView = new GlossaryView();
		        	renderRequest.setAttribute("glossaryView", glossaryView);
		        }
				else
				{
		        	final GlossaryView glossaryView = prepareRequest(httpReq, glossaryId);
		        	renderRequest.setAttribute("visibleChar", visibleChar);
		        	renderRequest.setAttribute("glossaryView", glossaryView);
				}
			}
			else
			{
				renderRequest.setAttribute("loggedIn", false);
			}
			
		}
		catch (PortalException e)
		{
			LOG.error(StackTraceUtil.getStackTrace(e));
			renderRequest.setAttribute("errorMessage", e.getMessage());
		}
		catch (SystemException e)
		{
			LOG.error(StackTraceUtil.getStackTrace(e));
			renderRequest.setAttribute("errorMessage", e.getMessage());
		}
		super.doView(renderRequest, renderResponse);
	}
	
	
	/* (non-Javadoc)
	 * @see com.liferay.util.bridges.mvc.MVCPortlet#serveResource(javax.portlet.ResourceRequest, javax.portlet.ResourceResponse)
	 */
	@Override
	public void serveResource(ResourceRequest resourceRequest,
			ResourceResponse resourceResponse) throws IOException,
			PortletException 
	{
		final String resourceID = resourceRequest.getResourceID();
		String message = GlossaryUtil.SUCCESS_MESSAGE;
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        
        if ("SaveGlossary".equals(resourceID))
        {
            final long userId = PortalUtil.getUserId(resourceRequest);
            try 
            {
                processRequest(httpRequest, userId);
            } 
            catch (PortalException exc) 
            {
            	message = exc.getMessage();
                LOG.error(StackTraceUtil.getStackTrace(exc)); 
            }
            catch (SystemException exc)
            {
            	message = exc.getMessage();
                LOG.error(StackTraceUtil.getStackTrace(exc));
            }
            final PrintWriter writer = resourceResponse.getWriter();
            writer.print(message);
        }
	}
	
	/**
	 * Prepare Request from parameter pass in render request and view layer.
	 * 
	 * @param httpRequest Original HttpServletRequest for getting parameter.
	 * @param glossaryId  Glossary Id for getting exsiting object from database.
	 * 
	 * @return glossaryView  Returns GlossaryView object that contains glossary and other object for View layer.
	 * 
	 * @throws PortalException PortalException throws if portal request is fail.
	 * @throws SystemException SystemException throws if system request is fail.
	 */
	
	public GlossaryView prepareRequest(HttpServletRequest httpRequest, String glossaryId) throws PortalException, SystemException 
	{
		GlossaryView glossaryView  = new GlossaryView();
    	Glossary glossary = GlossaryLocalServiceUtil.getGlossary(Long.valueOf(glossaryId));
    	glossaryView.setGlossary(glossary);
    	
    	List<GlossaryRegionNav> glossaryRegionNavs = GlossaryRegionNavLocalServiceUtil.getRegionNavsByGlossaryId(glossary.getGlossaryId());
    	if (Validator.isNotNull(glossaryRegionNavs)) 
    	{
    		glossaryView.setGlossaryRegionNav(glossaryRegionNavs);
    	}
    	return glossaryView;
	}
	
	
	/**
	 * Process Request based on parameter pass in Action request and Add Update Object.
	 * 
	 * @param request Original HttpServletRequest for getting parameter.
	 * @param userId  Login User's Id.
	 * 
	 * @throws PortalException PortalException throws if portal request is fail.
	 * @throws SystemException SystemException throws if system request is fail.
	 */
	public void processRequest(HttpServletRequest request, long userId) throws PortalException, SystemException
	{
		
        long glossaryId = GlossaryUtil.INITIAL_GLOSSARY_ID;
        final Date currDate = new Date();
        Glossary glossary = null;
        String termText = StringPool.BLANK;
        String termDesc = StringPool.BLANK;
        String glossaryOwner = StringPool.BLANK;
        String glossaryPublish = null;
        String oldTermTitle = StringPool.BLANK;
        String oldTermDesc = StringPool.BLANK;
        Map<Long, String[]>  regionBrandMap = new HashMap<Long, String[]>();
        
        //Get ALL Form Values
        if (!GlossaryUtil.IsNullOrBlank(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID))) 
        {
            glossaryId = Long.valueOf(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID));
        }
        if (!GlossaryUtil.IsNullOrBlank(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_TERM_TEXT)))
        {
        	termText = request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_TERM_TEXT).trim();
        }
        if (!GlossaryUtil.IsNullOrBlank(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_DEFINATION_TEXT)))
        {
        	termDesc = request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_DEFINATION_TEXT);
        }
        if (!GlossaryUtil.IsNullOrBlank(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_OWNER)))
        {
        	glossaryOwner = request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_OWNER);
        }
        if (!GlossaryUtil.IsNullOrBlank(request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_PUBLISHED))) 
        {
        	glossaryPublish = request.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_PUBLISHED);
        }
        
        List<StandardsRegion> standardRegion = StandardsRegionLocalServiceUtil.getStandardsRegions(QueryUtil.ALL_POS, QueryUtil.ALL_POS);
        for (StandardsRegion standardsRegion : standardRegion) 
        {
        	String[] chnCodeArray =  request.getParameterValues(standardsRegion.getRegionName());
            regionBrandMap.put(standardsRegion.getRegionId(), chnCodeArray);
        }
        
        glossary = isAvailableGlossaryTxt(glossaryId, termText); 
		if (Validator.isNotNull(glossary))
		{
			throw new PortalException(GlossaryUtil.TERM_EXISTS_ERROR_MSG);	
		}
        if (glossaryId < 0 )
        {
        	addGlossary(userId, currDate, termText, termDesc, glossaryOwner, glossaryPublish, regionBrandMap);
        }
        else
        {
        	glossary = GlossaryLocalServiceUtil.getGlossary(glossaryId);
        	oldTermTitle = glossary.getGlossaryTermText();
        	oldTermDesc = glossary.getGlossaryTermDesc();
        	String oldActiveInd = glossary.getActiveInd();
        	glossary.setGlossaryTermText(termText);
        	glossary.setGlossaryTermDesc(termDesc);
        	glossary.setGlossaryOwner(Long.valueOf(glossaryOwner));
        	if (glossaryPublish != null)
        	{
        		glossary.setActiveInd(glossaryPublish);
        	}
        	else
        	{
        		glossary.setActiveInd("N");
        	}
        	glossary.setUpdatedDate(currDate);
        	glossary.setUpdatedBy(String.valueOf(userId));
        	
        	GlossaryLocalServiceUtil.updateGlossary(glossary);
        	boolean updateText = !termText.equals(oldTermTitle);
        	boolean updateDesc = !termDesc.equals(oldTermDesc);
        	boolean updateInd = !oldActiveInd.equals(glossary.getActiveInd());
        	
        	//Add Glossary Region Nav brand entry if not match with existing or delete 
        	updateGlossaryRegionNav(userId, glossary, updateText, updateInd, regionBrandMap);
        	updateTranslations(updateText, updateDesc, glossary);
        }
    }

	private void updateTranslations(boolean updateText, boolean updateDesc, Glossary glossary) throws SystemException
    {
	    //  Defect 5134 resolutino
        if (updateText || updateDesc)
        {
            List<GlossaryTranslate> glossaryTranslations =  GlossaryTranslateLocalServiceUtil.getGlossarriesByGlossaryId(glossary.getGlossaryId());
            for ( GlossaryTranslate translation : glossaryTranslations)
            {
                boolean isChanged = false;
                if(updateText && "Y".equalsIgnoreCase(translation.getIsValidTermTxt()))
                {
                    translation.setIsValidTermTxt("N");
                    isChanged = true;
                }
                if(updateDesc && "Y".equalsIgnoreCase(translation.getIsValidDescTxt()))
                {
                    translation.setIsValidDescTxt("N");
                    isChanged = true;
                }
                if(isChanged)
                {
                    GlossaryTranslateLocalServiceUtil.updateGlossaryTranslate(translation);
                }
            }
        }
        // END defect 5134 change        
    }


    /**
	 * Add Glossary entry in database with passed parameter.
	 * 
	 * @param userId  Login User's userId.
	 * @param currDate  Current date for adding record in database.
	 * @param termText  Term Text of glossary.
	 * @param termDesc  Term description of glossary.
	 * @param glossaryOwner  Owner value of glossary.
	 * @param glossaryPublish  Glossary is active (published) or not.
	 * @param regionBrandMap  Map of region id and brand code as key-value pair.
	 * 
	 * @throws SystemException  SystemException throws if system request is fail.
	 */
	private void addGlossary(long userId, final Date currDate, String termText,
			String termDesc, String glossaryOwner, String glossaryPublish,
			Map<Long, String[]> regionBrandMap) throws SystemException
	{
		long glossaryId;
		Glossary glossary;
		long glossaryRegionNavId;
		GlossaryRegionNav glossaryRegionNav;

		glossaryId = CounterLocalServiceUtil.increment(Glossary.class.getName());
		glossary = GlossaryLocalServiceUtil.createGlossary(glossaryId);
		        
		glossary.setGlossaryTermText(termText);
		glossary.setGlossaryTermDesc(termDesc);
		glossary.setGlossaryOwner(Long.valueOf(glossaryOwner));
		if (glossaryPublish != null)
		{
			glossary.setActiveInd(glossaryPublish);
		}
		else
		{
			glossary.setActiveInd("N");
		}
		glossary.setCreatorId(String.valueOf(userId));
		glossary.setCreatedDate(currDate);
		glossary.setUpdatedDate(currDate);
		glossary.setUpdatedBy(String.valueOf(userId));
		        
		GlossaryLocalServiceUtil.addGlossary(glossary);
		        
		//Add Glossary Region Nav     
		if (!regionBrandMap.isEmpty())
		{
			String navItemTxt = String.valueOf(termText.charAt(0)).toUpperCase();
		    	   
			for (Map.Entry<Long, String[]> entry : regionBrandMap.entrySet()) 
			{
				String[] chnArray = entry.getValue();
				if (ArrayUtil.isNotEmpty(chnArray))
				{
		    		for (int i = 0; i < entry.getValue().length; i++) 
		    		{
		    			glossaryRegionNavId = CounterLocalServiceUtil.increment(GlossaryRegionNav.class.getName());
		    			glossaryRegionNav = GlossaryRegionNavLocalServiceUtil.createGlossaryRegionNav(glossaryRegionNavId);
			    	            
		    			glossaryRegionNav.setGlossaryId(glossary.getGlossaryId());
		    			glossaryRegionNav.setRegionId(entry.getKey());
		    			glossaryRegionNav.setNavItemText(navItemTxt);
		    			glossaryRegionNav.setActiveInd(glossary.getActiveInd());
		    			glossaryRegionNav.setChainCode(chnArray[i]);
		    			glossaryRegionNav.setCreatorId(String.valueOf(userId));
		    			glossaryRegionNav.setCreatedDate(currDate);
		    			glossaryRegionNav.setUpdatedBy(String.valueOf(userId));
		    			glossaryRegionNav.setUpdatedDate(currDate);
		    			
		    			GlossaryRegionNavLocalServiceUtil.addGlossaryRegionNav(glossaryRegionNav);
		    		}
				}
			}
		}
	}

	/**
	 * Method check Glossary object is already exists with same Term text.
	 * 
	 * @param glossaryId Selected Glossary Id.
	 * @param termText  Glossary Term text  need to check in database.
	 * 
	 * @return glossary Glossary object if alrady in database.
	 * 
	 * @throws PortalException PortalException throws if portal request is fail.
	 * @throws SystemException SystemException throws if system request is fail.
	 */
	public static Glossary isAvailableGlossaryTxt(long glossaryId, String termText) throws PortalException, SystemException 
	{
		Glossary glossary = null;
		if (glossaryId < 0)
		{
			glossary = GlossaryLocalServiceUtil.getGlossaryByTermText(termText);
		}
		else
		{
			Glossary glossaryDB = GlossaryLocalServiceUtil.getGlossary(glossaryId);
			String oldNavText = glossaryDB.getGlossaryTermText();
	       	if (!oldNavText.equalsIgnoreCase(termText))
	       	{
	       		glossary = GlossaryLocalServiceUtil.getGlossaryByTermText(termText);
	       	}	
		} 
		return glossary;
	}
	
	/**
	 * Update Glossary Region Nav entry in database.
	 * 
	 * @param userId  Login User's Id.
	 * @param glossaryId  Glossary Id that need to update.
	 * @param termText  Glossary Term text from request.
	 * @param oldNavText  Glossary Term text that is alrady in database.
	 * @param regionBrandMap  Region and Brand association map. 
	 * 
	 * @throws PortalException PortalException throws if portal request is fail.
	 * @throws SystemException SystemException throws if system request is fail.
	 */
	private void updateGlossaryRegionNav(long userId, Glossary glossary,
			boolean updateText, boolean updateInd,
			Map<Long, String[]> regionBrandMap) throws PortalException, SystemException
	{
		if (!regionBrandMap.isEmpty()) 
		{
			String navItemTxt = String.valueOf(glossary.getGlossaryTermText().charAt(0)).toUpperCase();
				for (Map.Entry<Long, String[]> entry : regionBrandMap.entrySet())
				{
					String[] chnArray = entry.getValue();         		   
			        List<String> selectedBrands = new ArrayList<String>();
					long regionId = entry.getKey();
					String dbBrand = GlossaryRegionNavLocalServiceUtil.getRegionCodesByglossaryIdAndRegionId(glossary.getGlossaryId(), regionId);
					
					List<String> dataBaseBrands = new ArrayList<String>();
					if (!BrandStandardsUtil.IsNullOrBlank(dbBrand))
					{
						dataBaseBrands = Arrays.asList(dbBrand.split(", "));
					}
					
	 				//Unioun Database brand and selected brand and remove database brand if not selected on Edit mode
					if (ArrayUtil.isNotEmpty(chnArray))
					{
						selectedBrands = Arrays.asList(chnArray);
					}
					List<String> union = new ArrayList<String> (dataBaseBrands);
					union.addAll(selectedBrands);
						
					List<String> intersection = new ArrayList<String>(dataBaseBrands);
					intersection.retainAll(selectedBrands);
						
					List<String> deleteBrands = new ArrayList<String>(dataBaseBrands);
					deleteBrands.removeAll(intersection);
						
					List<String> addBrands = new ArrayList<String>(selectedBrands);
					addBrands.removeAll(intersection); 
					
					//Check if Brand match and Glossary Term text is updated then update Region Nav Text
					if (updateText || updateInd)
					{
						for (String chainCode : intersection) 
						{ 
							GlossaryRegionNav regionNav = GlossaryRegionNavLocalServiceUtil.
									getGlossaryRegionNavByGlossaryIdRegionIdChainCode(glossary.getGlossaryId(), regionId, chainCode);
							if (regionNav != null)
							{
								regionNav.setNavItemText(navItemTxt);
								regionNav.setActiveInd(glossary.getActiveInd());
								regionNav.setUpdatedBy(String.valueOf(userId));
								regionNav.setUpdatedDate(new Date());
								GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav);
							}
						}
					}
					//Delete brand that is already in database and also not match with brand selected on Edit mode. and Add New brand that is selected on Edit mode 
					for (String chainCode : deleteBrands)
					{
						GlossaryRegionNavLocalServiceUtil.removeByGlossaryIdRegionIdChainCode(glossary.getGlossaryId(), regionId, chainCode);
					}
			         			   
					for (String chainCode : addBrands)
					{
						GlossaryRegionNav regionNav;
						regionNav = GlossaryRegionNavLocalServiceUtil.createGlossaryRegionNav(CounterLocalServiceUtil.increment(GlossaryRegionNav.class.getName()));
						regionNav.setChainCode(chainCode);
						regionNav.setActiveInd(glossary.getActiveInd());
						regionNav.setCreatorId(String.valueOf(userId));
						regionNav.setGlossaryId(glossary.getGlossaryId());
						regionNav.setNavItemText(navItemTxt);
						regionNav.setRegionId(regionId);
						regionNav.setUpdatedBy(String.valueOf(userId));
						regionNav.setUpdatedDate(new Date());
						regionNav.setCreatedDate(new Date()); 
						
						GlossaryRegionNavLocalServiceUtil.updateGlossaryRegionNav(regionNav);
					}
				}
		}
	}
}
