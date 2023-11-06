package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.ExternalLinkStandardsCountryPK;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;

public class StandardsLinkUtil extends StandardsUtil
{
    
    public static final int URL_TOCKENS_NUM = 7;

    public static final int EXTERNAL_LINK_ID_INDX = 0;

    public static final int EXTERNAL_LINK_URL_INDX = 1;

    public static final int EXTERNAL_LINK_TITLE_INDX = 2;
    
    private static final Log LOG = LogFactoryUtil.getLog(StandardsLinkUtil.class);
    
    /**
     * Persist External Links into database.
     * 
     * @param request - request
     * @param stdId - Standard Id
     * @param userId - user Id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void processExternalLinks(final HttpServletRequest request, final long stdId, final long userId)
            throws PortalException, SystemException
    {
        final String urlLinks = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_URL_LINKS);
        final String editLinks = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_URL_EDIT_LINKS);
        final String urlDelLinks = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_URL_DEL_LINKS);
        if (!StandardsUtil.IsNullOrBlank(urlLinks) || !StandardsUtil.IsNullOrBlank(urlDelLinks))
        {
            final Map<ExternalLinkStandards, List<List>> newUrl = getNewUrl(urlLinks, stdId, userId);
            final List<Long> deleteUrl = getDeleteUrl(urlDelLinks, stdId);
            persistUrls(deleteUrl, newUrl);
        }
        if (!StandardsUtil.IsNullOrBlank(editLinks))
        {
        	updateExternalLinks(editLinks, stdId, userId);
        }
    }
    
    /**
     * Find URL to be deleted.
     * 
     * @param urlDelLinks - list of URL IDs to be deleted
     * @param stdId - Standard Id
     * @return - List of URLs to be deleted.
     */
    public static List<Long> getDeleteUrl(final String urlDelLinks, final long stdId)
    {
        final List<Long> deleteUrl = new ArrayList<Long>();
        if (!StandardsUtil.IsNullOrBlank(urlDelLinks))
        {
            final String[] linkArray = urlDelLinks.split(StringPool.COMMA);

            for (String link : linkArray)
            {
                final Long linkId = Long.valueOf(link);
                deleteUrl.add(linkId);
            }
        }
        return deleteUrl;
    }

    /**
     * Extract New URLs.
     * 
     * @param urlLinks - list of links
     * @param stdId - Standard Id
     * @param userId - user id
     * @return - list of new links.
     */
    public static Map<ExternalLinkStandards, List<List>> getNewUrl(final String urlLinks, final long stdId, final long userId)
    {
        final Map<ExternalLinkStandards, List<List>> newUrl = new HashMap<ExternalLinkStandards, List<List>>();
        if (!StandardsUtil.IsNullOrBlank(urlLinks))
        {
            final String[] linkArray = urlLinks.split("~~~id:");
            for (String link : linkArray)
            {
                getNewSubmittedExternalUrl(link, newUrl, stdId, userId);
            }
        }
        return newUrl;
    }
    
    
    /**
     * Persist new URLs and delete URLs to be deleted.
     * 
     * @param deleteUrl - list of delete URL
     * @param newUrl - list of new URL
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void persistUrls(final List<Long> deleteUrl, final Map<ExternalLinkStandards, List<List>> newUrl) throws PortalException,
            SystemException
    {
        if (!StandardsUtil.isNullOrBlank(newUrl))
        {
            for (ExternalLinkStandards link : newUrl.keySet())
            {
            	List<ChainExternalLinkStandards> chains = new ArrayList<ChainExternalLinkStandards>();
            	List<ExternalLinkStandardsCountry> country = new ArrayList<ExternalLinkStandardsCountry>();
            	if (newUrl.get(link).size()>0)
            	{
            		 chains = newUrl.get(link).get(0);
            	}
            	if (newUrl.get(link).size()>1)
            	{
            		country = newUrl.get(link).get(1);
            	}
                addExternalUrl(link);
                if(!isNullOrBlank(chains))
                {
                    for(ChainExternalLinkStandards chain : chains)
                    {
                        chain.setExtLinkId(link.getExtLinkId());
                        ChainExternalLinkStandardsLocalServiceUtil.addChainExternalLinkStandards(chain);
                    }
                }
                
                if(!isNullOrBlank(country))
                {
                	for (ExternalLinkStandardsCountry cntr : country)
                	{
                		cntr.setExtLinkId(link.getExtLinkId());
                		ExternalLinkStandardsCountryLocalServiceUtil.addExternalLinkStandardsCountry(cntr);
                	}
                }
            }
        }

        if (!StandardsUtil.isNullOrBlank(deleteUrl))
        {
            for (Long linkPk : deleteUrl)
            {
            	List<ExternalLinkStandardsCountry> countryList = ExternalLinkStandardsCountryLocalServiceUtil.getExternalLinkStandardsCountryByextlLinkId(linkPk);
            	for(ExternalLinkStandardsCountry countryLink : countryList)
            	{
            		ExternalLinkStandardsCountryLocalServiceUtil.deleteExternalLinkStandardsCountry(countryLink);
            	}
                ExternalLinkStandardsLocalServiceUtil.deleteExternalLinkStandards(linkPk);
            }
        }
    }

    /**
     * Persist link.
     * 
     * @param link - link
     * @throws SystemException - exception
     */
    public static void addExternalUrl(final ExternalLinkStandards link) throws SystemException
    {

        final long extLinkId = CounterLocalServiceUtil.increment("ExternalLink");
        link.setExtLinkId(extLinkId);
        link.setParentExtLinkId(extLinkId);
        ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards(link);
    }
    
    /**
     * Populate data for new URLs into list.
     * 
     * @param urlLink - new URLs
     * @param newUrl - list
     * @param stdId - Standard Id
     * @param userId - User Id
     */
    public static void getNewSubmittedExternalUrl(final String urlLink, final Map<ExternalLinkStandards, List<List>> newUrl, final long stdId,
            final long userId)
    {
        if (!StandardsUtil.IsNullOrBlank(urlLink))
        {
            final String[] linkArray = urlLink.split("~~,|~~");
            if (linkArray.length == URL_TOCKENS_NUM)
            {
                final String langCode = linkArray[6];
                final Long extLinkId = Long.valueOf(linkArray[EXTERNAL_LINK_ID_INDX]);
                if (extLinkId <= 0L)
                {
                    final String url = linkArray[EXTERNAL_LINK_URL_INDX];
                    final String title = linkArray[EXTERNAL_LINK_TITLE_INDX];
                    if (!StandardsUtil.IsNullOrBlank(url) && !StandardsUtil.IsNullOrBlank(title))
                    {
                        final ExternalLinkStandards link = ExternalLinkStandardsLocalServiceUtil
                                .createExternalLinkStandards(extLinkId);
                        link.setLocaleCode(langCode);
                        link.setUrl(url);
                        link.setTitle(title);
                        link.setTranslationIndicator("Y");
                        link.setStdId(stdId);
                        link.setCreatorId(String.valueOf(userId));
                        link.setCreatedDate(new Date());
                        link.setUpdatedBy(String.valueOf(userId));
                        link.setUpdatedDate(new Date());
                        
                        List<List> chainCountryList = new ArrayList<List>();
                        // Insert Chains Links.
                        final String chains = linkArray[3];
                        if(!IsNullOrBlank(chains)) 
                        {
                        	List<ChainExternalLinkStandards> chainList = new ArrayList<ChainExternalLinkStandards>();
                        	ChainExternalLinkStandards chainExternalLinkStandards = null;
                            String[] chainsArray = chains.split(StringPool.COMMA);
                            for(String chain : chainsArray)
                            {
                                chainExternalLinkStandards = getChainExternalLinkStandardsObject(extLinkId, chain, userId) ;
                                chainList.add(chainExternalLinkStandards);
                            }
                            chainCountryList.add(chainList);
                        }
                        
                        // Insert Chains Links.
                        final String country = linkArray[5];
                        if(!IsNullOrBlank(country)) 
                        {
                        	List<ExternalLinkStandardsCountry> countryList = new ArrayList<ExternalLinkStandardsCountry>();
                        	ExternalLinkStandardsCountry countryExternalLinkStandards=null;
                            String[] countryArray = country.split(StringPool.COMMA);
                            for(String countryCode : countryArray)
                            {
                            	countryExternalLinkStandards = getExternalLinkStandardsCountryObject(extLinkId, countryCode, userId) ;
                                countryList.add(countryExternalLinkStandards);
                            }
                            chainCountryList.add(countryList);
                        }
                        
                        newUrl.put(link, chainCountryList);
                    }
                }
            }
        }
    }
    
    /**
     * Update ExternalLink data i.e. URl, Title, Brand, Country
     * @param editLinks
     * @param stdId
     * @param userId
     * @throws NumberFormatException
     * @throws PortalException
     * @throws SystemException
     */
    private static void updateExternalLinks(String editLinks, long stdId, long userId) throws NumberFormatException, PortalException, SystemException{
    	ExternalLinkStandards extLink =null;
    	
    	
    	for(String link :editLinks.split(StringPool.COMMA+StringPool.COMMA+StringPool.COMMA)) //3 Comma separated edited rows
    	{
	   		 String[] linkData = link.split(StringPool.TILDE+StringPool.TILDE); //Array element from request i.e. [0]linkId~~[1]url~~[2]title~~[3]brand~~[4]country
	   		 extLink = ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandards(Long.valueOf(linkData[EXTERNAL_LINK_ID_INDX]));
	   		 if (null != extLink)
	   		 {
	   			 if(!linkData[EXTERNAL_LINK_URL_INDX].equals("#URL#")) // #URL# if link url have no change
	   			 {
	   				 extLink.setUrl(linkData[EXTERNAL_LINK_URL_INDX]);
	   			 } 
	   			 if (!linkData[EXTERNAL_LINK_TITLE_INDX].equals("#Title#")) // #Title# if link Title have no change
	   			 {
	   				extLink.setTitle(linkData[EXTERNAL_LINK_TITLE_INDX]);
	   			 }
	   			 ExternalLinkStandardsLocalServiceUtil.updateExternalLinkStandards(extLink);
	   		 } else {
	   			 LOG.info("Update external link fail for stdId:" +stdId+", External link not found for externalLinkId :" + linkData[EXTERNAL_LINK_ID_INDX]);
	   		 }
	   		if (!linkData[3].equals("##")){ //for Brand
	   			updateLinkChain(linkData, userId);
    		}
    		if (!linkData[4].equals("##")) // for country
    		{
    			updateLinkCountry(linkData, userId);
    		}
    	}
    }
    
    /**
     * Update Link Brand
     * @param linkData
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateLinkChain(String linkData[], long userId) throws NumberFormatException, SystemException
    {
    	List<ChainExternalLinkStandards> extlChainList = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(Long.valueOf(linkData[EXTERNAL_LINK_ID_INDX]));
    	ChainExternalLinkStandards chainExtl = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsObject();
		for(ChainExternalLinkStandards stdChainExtl : extlChainList){
    			if (linkData[3].contains(stdChainExtl.getChainCode())){
    				linkData[3] = linkData[3].replace(stdChainExtl.getChainCode(), "##");
    			} else {
    				ChainExternalLinkStandardsLocalServiceUtil.deleteChainExternalLinkStandards(stdChainExtl);
    			}
		}
		
		for(String chain :  linkData[3].split(StringPool.COMMA)){
			if (!chain.equals("##")){
				chainExtl = getChainExternalLinkStandardsObject(Long.valueOf(linkData[EXTERNAL_LINK_ID_INDX]), chain, userId) ;
    			ChainExternalLinkStandardsLocalServiceUtil.addChainExternalLinkStandards(chainExtl);
			}
		}
    }
    
    /**
     * Update Link Country
     * @param linkData
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateLinkCountry(String linkData[], long userId) throws NumberFormatException, SystemException
    {
    	List<ExternalLinkStandardsCountry> countryList  = ExternalLinkStandardsCountryLocalServiceUtil.getExternalLinkStandardsCountryByextlLinkId(Long.valueOf(linkData[EXTERNAL_LINK_ID_INDX]));
    	ExternalLinkStandardsCountry countryExtl =  null;
		for(ExternalLinkStandardsCountry stdCountryExtl : countryList){
    			if (linkData[4].contains(stdCountryExtl.getCountryCode())){
    				linkData[4] = linkData[4].replace(stdCountryExtl.getCountryCode(), "##");
    			} else {
    				ExternalLinkStandardsCountryLocalServiceUtil.deleteExternalLinkStandardsCountry(stdCountryExtl);
    			}
		}
		
		for(String country :  linkData[4].split(StringPool.COMMA)){
			if (!country.equals("##")){
				countryExtl = getExternalLinkStandardsCountryObject(Long.valueOf(linkData[EXTERNAL_LINK_ID_INDX]), country, userId) ;
    			ExternalLinkStandardsCountryLocalServiceUtil.addExternalLinkStandardsCountry(countryExtl);
			}
		}
    }
    
    /**
     * Create ExternalLinkStandardsCountry Object
     * @param extLinkId
     * @param country
     * @param userId
     * @return ExternalLinkStandardsCountry
     */
    private static ExternalLinkStandardsCountry getExternalLinkStandardsCountryObject (long extLinkId, String country, long userId)
    {
    	ExternalLinkStandardsCountryPK externalLinkStandardsCountryPK = new ExternalLinkStandardsCountryPK(extLinkId, country);
    	ExternalLinkStandardsCountry countryExtl =  ExternalLinkStandardsCountryLocalServiceUtil.createExternalLinkStandardsCountry(externalLinkStandardsCountryPK);
		countryExtl.setExtLinkId(extLinkId);
		countryExtl.setCountryCode(country);
		countryExtl.setCreatorId(String.valueOf(userId));
		countryExtl.setCreatedDate(new Date());
		countryExtl.setUpdatedBy(String.valueOf(userId));
		countryExtl.setUpdatedDate(new Date());
		return countryExtl;
    }
    
    /**
     * Create ChainExternalLinkStandards Object
     * @param extLinkId
     * @param chain
     * @param userId
     * @return ChainExternalLinkStandards
     */
    private static ChainExternalLinkStandards getChainExternalLinkStandardsObject (long extLinkId, String chain, long userId)
    {
    	ChainExternalLinkStandards chainExtl = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsObject();
		chainExtl.setExtLinkId(extLinkId);
		chainExtl.setChainCode(chain);
		chainExtl.setCreatorId(String.valueOf(userId));
		chainExtl.setCreatedDate(new Date());
		chainExtl.setUpdatedBy(String.valueOf(userId));
		chainExtl.setUpdatedDate(new Date());
		return chainExtl;
    }
}
