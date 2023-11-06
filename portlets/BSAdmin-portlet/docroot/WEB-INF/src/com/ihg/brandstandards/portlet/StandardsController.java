package com.ihg.brandstandards.portlet;


import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.HashSet;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.PortletRequest;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.commons.lang.StringUtils;

import com.ihg.brandstandards.db.NoSuchFlagCategoryException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.AttachmentsStandardsCountry;
import com.ihg.brandstandards.db.model.BusImpactAssmt;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.ErrNotification;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry;
import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.model.FlagStandards;
import com.ihg.brandstandards.db.model.HistManuals;
import com.ihg.brandstandards.db.model.Publication;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsAuthors;
import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.StandardsCountryImages;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsStatus;
import com.ihg.brandstandards.db.model.TaxonomyStandards;
import com.ihg.brandstandards.db.model.StandardTag;
import com.ihg.brandstandards.db.service.StandardTagLocalServiceUtil;
import com.ihg.brandstandards.db.model.Workflow;
import com.ihg.brandstandards.db.service.AttachmentsStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.BusImpactAssmtLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ErrNotificationLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsCountryLocalServiceUtil;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;
import com.ihg.brandstandards.db.service.FlagStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.HistManualsLocalServiceUtil;
import com.ihg.brandstandards.db.service.PublicationLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsAuthorsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsChainImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCrossReferenceLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsHistoricalManualLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyLocalServiceUtil;
import com.ihg.brandstandards.db.service.TaxonomyStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.WorkflowLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.CountryStandardsPK;
import com.ihg.brandstandards.db.service.persistence.FlagStandardsPK;
import com.ihg.brandstandards.util.ActionUtil;
import com.ihg.brandstandards.util.BSCommonConstants;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.ChangeOrderUtil;
import com.ihg.brandstandards.util.ComplianceUtil;
import com.ihg.brandstandards.util.StandardsAssignedImagesUtil;
import com.ihg.brandstandards.util.StandardsAttachmentUtil;
import com.ihg.brandstandards.util.StandardsHistoricalManualReferenceUtil;
import com.ihg.brandstandards.util.StandardsLinkUtil;
import com.ihg.brandstandards.util.StandardsStatusUtil;
import com.ihg.brandstandards.util.StandardsUtil;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.bsadmin.model.StandardsView;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.messaging.Message;
import com.liferay.portal.kernel.messaging.MessageBusUtil;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.ContentTypes;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.HtmlUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StackTraceUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * This is the controller for standards and specification creation and edit operations.
 * 
 * @author Vipul_D
 * 
 */
public class StandardsController extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsController.class);
    private static List<String> ASSIGN_FLAG_CATGY = null;
    private static List<Long> RESTRICTED_CATEGORIES = null;
    
    
   static {
       if (ASSIGN_FLAG_CATGY == null) {
           ASSIGN_FLAG_CATGY = new ArrayList<String>();
       }
       if (RESTRICTED_CATEGORIES == null) {
           RESTRICTED_CATEGORIES = new ArrayList<Long>();
       }
       ASSIGN_FLAG_CATGY.add("Department Applicability");
       ASSIGN_FLAG_CATGY.add("Location within Hotel");
       ASSIGN_FLAG_CATGY.add("Corporate Department");
       ASSIGN_FLAG_CATGY.add("Wheel Quadrant");
       ASSIGN_FLAG_CATGY.add("Guest Journey");
       ASSIGN_FLAG_CATGY.add("Hotel Lifecycle");
       ASSIGN_FLAG_CATGY.add("Specialist Area");
       ASSIGN_FLAG_CATGY.add("Measurement");
       ASSIGN_FLAG_CATGY.add("Digital");
       ASSIGN_FLAG_CATGY.add("Brand Safety Standards");
       ASSIGN_FLAG_CATGY.add("GEM Reporting Categories");
       ASSIGN_FLAG_CATGY.add("Area of the Hotel for Measurement");
       
       RESTRICTED_CATEGORIES.add(90l);
       RESTRICTED_CATEGORIES.add(412l);
       RESTRICTED_CATEGORIES.add(419l);
       
    }
    
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws PortletException, IOException
    {
        LOG.info("THIS IS STANDARDSCONTROLLER");
        try
        {
            final long userId = PortalUtil.getUserId(renderRequest);
            String page = viewTemplate;
            //Remove session variable
            HttpSession httpSession = PortalUtil.getHttpServletRequest(renderRequest).getSession();
            httpSession.removeAttribute("addNewAttr");
            httpSession.removeAttribute("removeAttr");
            if (userId < 1)
            {
                renderRequest.setAttribute("NotLoggedIn", true);
            }
            else
            {
                final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
                        .getHttpServletRequest(renderRequest));
                final String objId = httpReq.getParameter(StandardsUtil.REQUEST_PARAM_ID);
                if (Validator.isNotNull(objId)) {
                	//Check whether standard is of type std and if it is then does it have any specification / guideline associated or not
                	//Fix for defect #7838
                	try {
                		//List will have specification / guidelines only
                		List<Standards> stdList = StandardsLocalServiceUtil.getByParentId(GetterUtil.getLong(objId));
                		//get all brands for std
                		List<ChainStandards> chains = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(GetterUtil.getLong(objId));
                		//get all brands code
                		renderRequest.setAttribute("brandListObj", getBrandNameList(chains));
                		if (Validator.isNotNull(stdList) && !stdList.isEmpty()) {
                			renderRequest.setAttribute("isCopyAllowed", true);
                		}
                	} catch (SystemException e) {
                		LOG.error(StackTraceUtil.getStackTrace(e));
                	}
                }
                final StandardsView stdView = prepareRequest(httpReq);
                renderRequest.setAttribute("StandardsView", stdView);
                final String viewKey = httpReq.getParameter(StandardsUtil.STANDARDS_VIEW_KEY);
                if (!StandardsUtil.IsNullOrBlank(viewKey))
                {
                    page = previewTemplate;
                }
            }

            final PortletRequestDispatcher reqDisp = getPortletContext().getRequestDispatcher(page);
            reqDisp.include(renderRequest, renderResponse);
        }
        catch (Exception e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Fetch data for Standards view.
     * 
     * @param httpReq - HttpServletRequest
     * @return - StandardsView object
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public StandardsView prepareRequest(final HttpServletRequest httpReq) throws PortalException, SystemException
    {
        final StandardsView stdView = new StandardsView();
        final String objId = httpReq.getParameter(StandardsUtil.REQUEST_PARAM_ID);
        final String prntStdId = httpReq.getParameter(StandardsUtil.REQUEST_PARAM_STD_ID);
        final String objTyp = httpReq.getParameter(StandardsUtil.REQUEST_PARAM_OBJ_TYP);
        final long userId = PortalUtil.getUserId(httpReq);
        final User user = UserLocalServiceUtil.getUserById(userId);

        List<Role> roles = user.getRoles();
        boolean isSuperAdmin = StandardsUtil.isSuperAdmin(roles);
        
        final HttpSession session = httpReq.getSession();
        Preferences preferences = (Preferences)session.getAttribute("Preferences");
        String regionCode = StringPool.BLANK;
        if (preferences != null) {
            regionCode = preferences.getRegionCode();
        }
        
        if (StandardsUtil.IsNullOrBlank(objId))
        {   
            final Standards std = StandardsLocalServiceUtil.createStandards(-111);
            stdView.setStandard(std);
            std.setStdTyp(StandardsUtil.STD_TYPE_STANDARD);
            std.setAuthor(user.getFullName());
            std.setFramework("N");
            if(isSuperAdmin) {
                std.setRegionCode(regionCode);
            }  else {
               std.setRegionCode(StandardsUtil.getUserRegionFromUserRole(user.getRoles()));
            }
			stdView.getStandard().setStatus(StandardsStatusUtil.getDefaultStatus(std.getRegionCode()));
            // Load "Standards" for few specification values.
            if (!StandardsUtil.IsNullOrBlank(prntStdId))
            {   
                final Standards assocStd = StandardsLocalServiceUtil.getStandards(Long.valueOf(prntStdId));
                stdView.setAssociatedStandard(assocStd);
                std.setStdTyp(StandardsUtil.STD_TYPE_SPEC);
                if (!StandardsUtil.IsNullOrBlank(objTyp) && objTyp.equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
                {
                    std.setStdTyp(StandardsUtil.STD_TYPE_GDLN);
                }
                stdView.setAssocChainStandards(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(assocStd.getStdId()));
                stdView.setAssocCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(assocStd.getStdId()));
                stdView.setAssocFlagStandards(FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(assocStd.getStdId()));
               /*//Comment for QC9889, ignore links inherited from std
                  Map<ExternalLinkStandards, List<List>> externalLinks = new HashMap<ExternalLinkStandards, List<List>>();
                List countryRegionChain = null;
                List<ExternalLinkStandards> links = ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsParentsByStdId(assocStd.getStdId());
                if(!StandardsUtil.isNullOrBlank(links))
                {
                   for(ExternalLinkStandards link : links)
                   {	
                	   countryRegionChain = new ArrayList<Object>();
                	   //put all Brand
                	   List<ChainExternalLinkStandards> chains = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(link.getExtLinkId());
                       StandardsUtil.setLinkTranslationExist(link);
                       countryRegionChain.add(chains);
                       
                       //put all country 
                       List<ExternalLinkStandardsCountry> countryExtLink =  ExternalLinkStandardsCountryLocalServiceUtil.getExternalLinkStandardsCountryByextlLinkId(link.getExtLinkId());
                       countryRegionChain.add(countryExtLink);
                       
                       //put all regions
                       Map<String, Map<String, String>> regionCountryMap = BrandStandardsUtil.getCountries();
                       List<String> region = new ArrayList<String>();
                       for(ExternalLinkStandardsCountry countryAttch: countryExtLink){
                       	region.add(BrandStandardsUtil.getRegionByCountryCode(regionCountryMap, countryAttch.getCountryCode()));
                       }
                       
                       ListUtil.distinct(region);
                       countryRegionChain.add(region);
                       externalLinks.put(link, countryRegionChain);
                   }
                }
                stdView.setAssocExtLinkStandards(externalLinks);*/

                stdView.setFlagStandards(FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(assocStd.getStdId()));
                List<ChainStandards> chainStds = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(assocStd.getStdId());
                for (ChainStandards chainStd : chainStds)
                {
                    // chainStd.setStatusId(StandardsStatusUtil.getStatuses(StandardsUtil.getUserRegionFromUserRole(user.getRoles())).get(0).getStatusId());
					chainStd.setStatusId(StandardsStatusUtil.getStatusIdByRegionCodeAndCode(stdView.getStandard().getRegionCode(), StandardsStatusUtil.getDefaultStatus(stdView.getStandard().getRegionCode())));
                }
                stdView.setChainStandards(chainStds);
                stdView.setCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(assocStd.getStdId()));
                stdView.getStandard().setAuthor(user.getFullName());
                stdView.getStandard().setBusinessOwner(assocStd.getBusinessOwner());
                stdView.getStandard().setEffectiveDate(assocStd.getEffectiveDate());
                stdView.getStandard().setImplDate(assocStd.getImplDate());
                stdView.getStandard().setCategory(assocStd.getCategory());
                stdView.getStandard().setChange(assocStd.getChange());
                // Authors
                List<StandardsAuthors> stdAuths = StandardsAuthorsLocalServiceUtil.getStandardsAuthorsByStdId(assocStd.getStdId());
                if (!StandardsUtil.isNullOrBlank(stdAuths))
                {
                    List<StandardsAuthors> scndrAuths = new ArrayList<StandardsAuthors>();
                    for (StandardsAuthors stdAuth : stdAuths)
                    {
                        if (stdAuth.getAuthorName().equals(user.getFullName()))
                        {
                            stdView.setPrimaryAuthor(stdAuth);
                        }
                        else
                        {
                            scndrAuths.add(stdAuth);
                        }
                    }
                    stdView.setSecondaryAuthor(scndrAuths);
                }

                stdView.setAssocStandardsHistoricalManuals(StandardsHistoricalManualLocalServiceUtil
                        .findStdHistoricalManualsByStdId(assocStd.getStdId()));
            }
            std.setCreatorId(String.valueOf(userId));
            // set all authors
            if(isSuperAdmin == true)
            { 
                Role authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRoleForSuperAdmin(regionCode));
                Role busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRoleForSuperAdmin(regionCode));
                stdView.setAuthors(StandardsUtil.getRoleUsersSorted(authorRole.getRoleId()));
                stdView.setBusinessOwners(StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId()));
                LOG.info("in if author and business owner role is "+authorRole+" "+busOwnersRole);
            } else
            {   
                if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getTechnicalWriterRole(user)))
                {
                    final Role authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRole(user));
                    stdView.setAuthors(StandardsUtil.getRoleUsersSorted(authorRole.getRoleId()));
                }
                
                // set all Business Owners
                if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getBusinessOwnerRole(user)))  
                {
                    final Role busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRole(user)); 
                    stdView.setBusinessOwners(StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId()));
                }
            }
        }
        else
        {

            final long stdId = Long.valueOf(objId);
            stdView.setStandard(StandardsLocalServiceUtil.getStandards(stdId));
            StandardsUtil.setTextContextTransExist(stdView);
            if (!StandardsUtil.IsNullOrBlank(prntStdId))
            {
                final Standards assocStd = StandardsLocalServiceUtil.getStandards(Long.valueOf(prntStdId));
                stdView.setAssociatedStandard(assocStd);
                stdView.setAssocChainStandards(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(assocStd.getStdId()));
                stdView.setAssocCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(assocStd.getStdId()));
                stdView.setAssocFlagStandards(FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(assocStd.getStdId()));
            }
            else
            {
            // Vipul : CR 101 Manual Lock Down. CR 50.2 Get all child based on parent std id
                List<FlagStandards> childFlagStandards = null;
                // Get children. Spec/Gdln. Check their flag catgy for "Manual".
                List<Standards> children = StandardsLocalServiceUtil.getByParentId(stdId);
                for(Standards child : children)
                {
                    if(childFlagStandards==null)
                    {
                        childFlagStandards = new ArrayList<FlagStandards>();
                    }
                    childFlagStandards.addAll(FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(child.getStdId()));
                }
                stdView.setChildFlagStandards(childFlagStandards);
            // 101 end.
            }
            stdView.setChainStandards(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(stdId));
            stdView.setCountryStandards(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId));
            stdView.setFlagStandards(FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(stdId));

            // DO NOT REMOVE!!!!!  CACHING ISSUE
            try {
                FlagStandardsLocalServiceUtil.clearCache();
            } catch (Exception e) {
                // do nothing
            }
            // DO NOT REMOVE!!!!!  CACHING ISSUE
            
            List countryRegionChain = null;
            Map<ExternalLinkStandards, List<List>> externalLinks = new HashMap<ExternalLinkStandards, List<List>>();
            List<ExternalLinkStandards> links = ExternalLinkStandardsLocalServiceUtil.getExternalLinksStandardsParentsByStdId(stdId);
            if(!StandardsUtil.isNullOrBlank(links))
            {
               for(ExternalLinkStandards link : links)
               {
            	   countryRegionChain = new ArrayList<Object>();
            	   //Put all Brand
                   List<ChainExternalLinkStandards> chains = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(link.getExtLinkId());
                   StandardsUtil.setLinkTranslationExist(link);
                   countryRegionChain.add(chains);
                   
                   //put all country 
                   List<ExternalLinkStandardsCountry> countryExtLink =  ExternalLinkStandardsCountryLocalServiceUtil.getExternalLinkStandardsCountryByextlLinkId(link.getExtLinkId());
                   countryRegionChain.add(countryExtLink);
                   
                   //put all regions
                   Map<String, Map<String, String>> regionCountryMap = BrandStandardsUtil.getCountries();
                   List<String> region = new ArrayList<String>();
                   for(ExternalLinkStandardsCountry countryAttch: countryExtLink){
                   	region.add(BrandStandardsUtil.getRegionByCountryCode(regionCountryMap, countryAttch.getCountryCode()));
                   }
                   ListUtil.distinct(region);
                   countryRegionChain.add(region);
                   
                   externalLinks.put(link, countryRegionChain);
                   
               }
            }
            stdView.setExtLinkStandards(externalLinks);

            Map<AttachmentsStandards, List<List>> attachmentLinks = new HashMap<AttachmentsStandards, List<List>>();
          
            List<AttachmentsStandards> attachments = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsParentsByStdId(stdId);
            if(!StandardsUtil.isNullOrBlank(attachments))
            {
               for(AttachmentsStandards attachment : attachments)
               {
            	   countryRegionChain = new ArrayList<Object>();
            	   //	put all brand 
            	   List<ChainAttachmentsStandards> chains = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsByAttachmentId(attachment.getAttachmentId());
                   StandardsUtil.setAttachmentTranslationExist(attachment);
                   countryRegionChain.add(chains);
                   
                   //put all country 
                   List<AttachmentsStandardsCountry> countryAttchment =  AttachmentsStandardsCountryLocalServiceUtil.getAttachmentsStandardsCountryByAttachmentId(attachment.getAttachmentId());
                   countryRegionChain.add(countryAttchment);
                   
                   //put all regions
                   Map<String, Map<String, String>> regionCountryMap = BrandStandardsUtil.getCountries();
                   List<String> region = new ArrayList<String>();
                   for(AttachmentsStandardsCountry countryAttch: countryAttchment){
                   	region.add(BrandStandardsUtil.getRegionByCountryCode(regionCountryMap, countryAttch.getCountryCode()));
                   }
                   ListUtil.distinct(region);
                   countryRegionChain.add(region);
                   
                   attachmentLinks.put(attachment,countryRegionChain);
               }
            }
            stdView.setAttachmentStandards(attachmentLinks);
            
            // Authors
            List<StandardsAuthors> stdAuths = StandardsAuthorsLocalServiceUtil.getStandardsAuthorsByStdId(stdId);
            if (!StandardsUtil.isNullOrBlank(stdAuths))
            {
                List<StandardsAuthors> scndrAuths = new ArrayList<StandardsAuthors>();
                for (StandardsAuthors stdAuth : stdAuths)
                {
                    if ("Y".equals(stdAuth.getIsPrimary()))
                    {
                        stdView.setPrimaryAuthor(stdAuth);
                    }
                    else
                    {
                        scndrAuths.add(stdAuth);
                    }
                }
                stdView.setSecondaryAuthor(scndrAuths);
            }

            stdView.setStandardsHistoricalManuals(StandardsHistoricalManualLocalServiceUtil
                    .findStdHistoricalManualsByStdId(stdId));

            stdView.setAssignImages(StandardsAssignedImagesUtil.getStandardsImagesByStdId(stdId));

            final TaxonomyStandards taxStand = TaxonomyStandardsLocalServiceUtil.getTaxonomyStandardsByStdId(stdId);
            if (taxStand != null)
            {
                stdView.setTaxonomyStandards(taxStand);
                stdView.setTaxonomyTitle(TaxonomyLocalServiceUtil.getTaxonomy(taxStand.getTaxId()).getTitle());
            }
            if (stdView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD))
            {
                final List<BusImpactAssmt> arlBusImpactAssmt = BusImpactAssmtLocalServiceUtil.getBusImpactAssmtByStdId(stdId);
                for (BusImpactAssmt bia : arlBusImpactAssmt)
                {
                    final String biaChain = bia.getChain();
                    final String chainName = StandardsUtil.decodeChainCode(biaChain);
                    bia.setChainName(chainName);
                }
                List<BusImpactAssmt> arlBIA = new ArrayList<BusImpactAssmt>(arlBusImpactAssmt);
                Collections.sort(arlBIA, new BiaComparator());
                stdView.setBusImpactAssmts(arlBIA);
            }
            String stdRegion = stdView.getStandard().getRegionCode();
            LOG.info("value of stdRegion is  "+stdRegion);
           
            if(isSuperAdmin == true)
            {

                Role authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRoleForSuperAdmin(stdRegion));
                Role busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRoleForSuperAdmin(stdRegion));
                stdView.setAuthors(StandardsUtil.getRoleUsersSorted(authorRole.getRoleId()));
                stdView.setBusinessOwners(StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId()));
                LOG.info("in else author and business owner role is "+authorRole+" "+busOwnersRole);
            } else {
                 /* if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getTechnicalWriterRole(user)))
                {
                    final Role authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getTechnicalWriterRole(user));
                    stdView.setAuthors(StandardsUtil.getRoleUsersSorted(authorRole.getRoleId()));
                }
                
                // set all Business Owners
                if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getBusinessOwnerRole(user)))  
                {
                    final Role busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRole(user)); 
                    stdView.setBusinessOwners(StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId()));
                }*/
                if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getTechnicalWriterRole(stdView.getStandard()))) 
                {
                    final Role authorRole = RoleLocalServiceUtil.getRole(user.getCompanyId(),
                        StandardsUtil.getTechnicalWriterRole(stdView.getStandard()));
                    stdView.setAuthors(StandardsUtil.getRoleUsersSorted(authorRole.getRoleId()));
                }
                
                // set all Business Owners
                if(!StandardsUtil.IsNullOrBlank(StandardsUtil.getBusinessOwnerRole(stdView.getStandard())))  
                {
                    final Role busOwnersRole = RoleLocalServiceUtil.getRole(user.getCompanyId(), StandardsUtil.getBusinessOwnerRole(stdView.getStandard())); 
                    stdView.setBusinessOwners(StandardsUtil.getRoleUsersSorted(busOwnersRole.getRoleId()));
                }
            }
            
        }

        stdView.setApprover(StandardsStatusUtil.hasApproverRole(user, stdView.getStandard()));
        stdView.setDefaultStatusCode(StandardsStatusUtil.getDefaultStatus(stdView.getStandard().getRegionCode()));
        return stdView;
    }


    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        final String resourceID = request.getResourceID();
        String message = StandardsUtil.SUCCESS_MESSAGE;
        final String copyAttr = ParamUtil.getString(request, "copyAttr");
        final String checkAttr = ParamUtil.getString(request, "checkAttr");
        if (Validator.isNotNull(copyAttr)) {
            copyAttributes(request);
        } else if (Validator.isNotNull(checkAttr)) {
            checkAttributes(request, response);
        }   else if ("SaveStandard".equals(resourceID))
        {
            LOG.debug("--- Test Submit ---:  " + request.getParameter("standard_name"));
            try
            {
                processRequest(request);
            }
            catch (Exception e)
            {
                message = e.getLocalizedMessage() + " : " + e.getMessage();
                LOG.error(StackTraceUtil.getStackTrace(e));
            }
            final PrintWriter writer = response.getWriter();
            writer.print(message);
        }
        else if ("getTreeData".equals(resourceID))
        {
            StandardsUtil.xmlTaxonomy(request, response, LOG);
        }
        else if ("getHistoricalManual".equals(resourceID))
        {
            getHistoricalManual(request, response);
        }
        else if ("getImgGalley".equals(resourceID))
        {
            getImgGalley(request, response);
        }
        else if ("searchUrl".equalsIgnoreCase(resourceID))
        {
            getSearchStd(request, response);
        }
        else if ("CrossReference".equalsIgnoreCase(resourceID))
        {
            loadCrossReferenceSection(request, response);
        }
        else if("changeOrder".equals(resourceID))
        {
            changeOrder(request,response);
        }
        else
        {
            LOG.error("Unknown Resource ID: " + resourceID);
        }
    }
    /**
     * Change Order 
     * @param request
     * @param response
     * @throws PortletException 
     * @throws IOException 
     */
    private void changeOrder(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        long stdId = ParamUtil.getLong(request, "stdId", 0L);
        ThemeDisplay themeDisplay = (ThemeDisplay) request.getAttribute(WebKeys.THEME_DISPLAY);
        User user = themeDisplay.getUser();
        HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));
        final HttpSession session = httpReq.getSession();
        Preferences preferences = (Preferences)session.getAttribute("Preferences");
        String regionCode = StringPool.BLANK;
        if (preferences != null) {
            regionCode = preferences.getRegionCode();
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Current region code is :::"+regionCode);
        }
        //if regionCode is null or blank then it's a regional author.
        if (Validator.isNull(regionCode) || "NA".equals(regionCode)) {
	        try {
	        	regionCode = StandardsUtil.getUserRegionFromUserRole(user.getRoles());
	        	if (LOG.isDebugEnabled()) {
	            	LOG.debug("It's a regional author, current region code is :::"+regionCode);
	            }
	        	
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			}
        }
        long regionId = StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode);
        String chainCode = ParamUtil.getString(request, "chainCode", null);
        List<Standards> specList = new ArrayList<Standards>();
        List<Standards> gdlnList = new ArrayList<Standards>();
        
        specList.addAll(StandardsLocalServiceUtil.getStandardsByChainAndRegion(stdId, regionId, regionCode, chainCode, "SPEC"));
        gdlnList.addAll(StandardsLocalServiceUtil.getStandardsByChainAndRegion(stdId, regionId, regionCode, chainCode, "GDLN"));
        
        //set brand name
        request.setAttribute("brandName", BrandStandardsUtil.chainCodeMap().get(chainCode));
        //set region name
        request.setAttribute("regionName", StandardsUtil.getRegionNameFromRegionCode(regionCode));
        //Sort by display order number
        StandardsUtil.sortByOrderNumber(specList);
        StandardsUtil.sortByOrderNumber(gdlnList);
        request.setAttribute("chainCode", chainCode);
        request.setAttribute("specList", specList);
        request.setAttribute("gdlnList", gdlnList);
        include("/html/standards/changeOrder.jsp", request, response);
    }

    private void saveOrder(HttpServletRequest request, String regionCode)
    {
    	if (Validator.isNotNull(request.getParameter("chainSortOrder"))) {
    		for (String chainCode : request.getParameter("chainSortOrder").split(StringPool.COMMA)) {
    			if (LOG.isDebugEnabled()) {
    				LOG.debug("Changing spec / gdln order for chain :"+chainCode+" AND regionCode :"+regionCode);
    			}
    			ChangeOrderUtil.setOrderByChainAndRegion(request, "spec_std_ids_"+chainCode, regionCode, chainCode);
    			ChangeOrderUtil.setOrderByChainAndRegion(request, "guide_std_ids_"+chainCode, regionCode, chainCode);
    		}
    	}
    }

    private void checkAttributes (ResourceRequest request, ResourceResponse response) {
        compareAttributes(request, response);
    }

    private void loadCrossReferenceSection(ResourceRequest request, ResourceResponse response) throws IOException,
            PortletException
    {
        String regionCode = ParamUtil.get(request, "regionCode", StringPool.BLANK);
        long stdId = ParamUtil.get(request, "stdId", 0L);
        request.setAttribute("regionCode", regionCode);
        request.setAttribute("stdId", stdId);
        include("/html/standards/crossReference.jsp", request, response);
    }

    private void getSearchStd(ResourceRequest request, ResourceResponse response)
    {
        response.setContentType("json");
        long searchStdId = ParamUtil.get(request, "searchStdId", 0L);
        String[] brands = request.getParameterValues("brands[]");
        String regionCode = ParamUtil.get(request, "regionCode", StringPool.BLANK);
        List<Standards> standardList = null;
        JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
        try
        {
            standardList = StandardsLocalServiceUtil.getSTD(searchStdId, regionCode, brands);
            PrintWriter writer = response.getWriter();
            if (standardList != null && !standardList.isEmpty())
            {
                Standards std = standardList.get(0);
                String returnStdType = std.getStdTyp();
                jsonObject.put("stdType", returnStdType);
                jsonObject.put("stdTitle", BrandStandardsUtil.STD_TYPE_GDLN.equalsIgnoreCase(returnStdType) ? 
                        HtmlUtil.escape((String) std.getDescription()) : HtmlUtil.escape((String) std.getTitle()));
                writer.write(jsonObject.toString());
            }
            else
            {
                writer.write(jsonObject.toString());
            }
        }
        catch (SystemException e)
        {
            LOG.error("No STD found: " + searchStdId);
        }
        catch (IOException e)
        {
            LOG.error("Response writer error: ");
        }

    }
   
    /**
     * Persist data into database.
     * 
     * @param resourceRequest - request
     * @return - updated data from database.
     * @throws Exception - exception
     */
    public StandardsView processRequest(final ResourceRequest resourceRequest) throws Exception
    {
        final StandardsView stdView = new StandardsView();
        boolean isSuperAdmin = false;
        HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        HttpSession session = request.getSession();
        final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(request));
        if (isMultipart)
        {
            request = PortalUtil.getUploadPortletRequest(resourceRequest);
        }
        boolean copyAttributeChanges = false;
        final long userId = PortalUtil.getUserId(request);
        final User user = UserLocalServiceUtil.getUserById(userId);
        List<Role> arlRole = RoleLocalServiceUtil.getUserRoles(userId);
        isSuperAdmin = StandardsUtil.isSuperAdmin(arlRole);
        Standards std = null;
        long stdId = -100;
        long parentId = -100;
        String objTyp = StandardsUtil.STD_TYPE_STANDARD;
        final Date currDate = new Date();
        String comments = "";
        String previousTitle = null;
        boolean isCountryAdded = false;
        boolean isCountryRemoved = false;
        boolean isExistingStd = true;
        
        Preferences preferences = (Preferences)session.getAttribute("Preferences");
        if (!StandardsUtil.IsNullOrBlank(request.getParameter(StandardsUtil.REQUEST_PARAM_ID)))
        {
            stdId = Long.valueOf(request.getParameter(StandardsUtil.REQUEST_PARAM_ID));
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter(StandardsUtil.REQUEST_PARAM_STD_ID)))
        {
            parentId = Long.valueOf(request.getParameter(StandardsUtil.REQUEST_PARAM_STD_ID));
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter(StandardsUtil.REQUEST_PARAM_OBJ_TYP)))
        {
            objTyp = request.getParameter(StandardsUtil.REQUEST_PARAM_OBJ_TYP);
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("hidden_comments_value")))
        {
            comments = request.getParameter("hidden_comments_value");
        }
        
        
        //Add for Cr 50.2  hotel_lifecycle_flag
//        if (!StandardsUtil.IsNullOrBlank(request.getParameter("HotelLifecycle")))
//        {
//            String hotelLifecycle = request.getParameter("HotelLifecycle");
//        }
        
        if (stdId < 0)
        {
            isExistingStd = false;
            stdId = CounterLocalServiceUtil.increment("Standards");
            std = StandardsLocalServiceUtil.createStandards(stdId);
            std.setStdTyp(StandardsUtil.STD_TYPE_STANDARD);
            std.setParentId(stdId);
            if (parentId > 0)
            {
                parentId = Long.valueOf(request.getParameter(StandardsUtil.REQUEST_PARAM_STD_ID));
                std.setParentId(parentId);
                std.setStdTyp(StandardsUtil.STD_TYPE_SPEC);
                if (objTyp.equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
                {
                    std.setStdTyp(StandardsUtil.STD_TYPE_GDLN);
                }
            }

            if(isSuperAdmin == true)
            {
            	String regionCode = preferences.getRegionCode();
            	std.setRegionId(StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode).getRegionId());
            	std.setRegionCode(regionCode);
            }
            else
            {
            	std.setRegionCode(getRegionCodeFromUserRole(user.getRoles()));
            	std.setRegionId(StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(std.getRegionCode()).getRegionId());
            }
            std.setCreatedBy(user.getScreenName());
            std.setCreatorId(String.valueOf(user.getUserId()));
            std.setCreatedDate(currDate);
            std.setStatus(StandardsStatusUtil.getDefaultStatus(std.getRegionCode()));
        }
        else
        // Edit Mode.
        {
            std = StandardsLocalServiceUtil.getStandards(stdId);
            if(StandardsUtil.STD_TYPE_GDLN.equals(std.getStdTyp()))
            {
                previousTitle = std.getDescription();
            }
            else
            {
                previousTitle = std.getTitle();
            }
            final String addStdIds = ParamUtil.getString(request, "addStdIds");
            final String deleteStdIds = ParamUtil.getString(request, "deleteStdIds");
            final String updateOrderIds = ParamUtil.getString(request, "updateOrderStdIds");
            if (Validator.isNotNull(deleteStdIds))
            {
                StandardsCrossReferenceLocalServiceUtil.deleteCrossReferences(std.getStdId(), deleteStdIds);
            }
            if (Validator.isNotNull(addStdIds))
            {
                StandardsCrossReferenceLocalServiceUtil.addCrossReferences(userId, currDate, std.getStdId(), addStdIds);
            }
            if (Validator.isNotNull(updateOrderIds))
            {
                StandardsCrossReferenceLocalServiceUtil.updateStdOrder(std.getStdId(), updateOrderIds);
            }
            // Invalidate translations of standard
            StandardsUtil.invalidateXlat(std , request.getParameter("standard_name") ,  request.getParameter("standard_rationale"));
            copyAttributeChanges = true;
        }

        getDataFromRequest(request, userId, std, currDate);
        StandardsLocalServiceUtil.updateStandards(std);
        stdView.setStandard(std);

        // Update Countries.
        final String[] countries = request.getParameterValues("selectedcountries");
        LOG.debug(StringUtils.join(countries));
        if (!StandardsUtil.IsNullOrBlank(countries))
        {
            isCountryAdded = addCountries(userId, stdId, currDate, countries);
            isCountryRemoved = removeCountries(countries, std);
        }
        
        //process Tags
         String[] tagText = request.getParameter("tagstextIds").split(",");
         List<StandardTag>standardTags = StandardTagLocalServiceUtil.getStandardTagsBystdId(std.getStdId());
         if(standardTags.size() > 0){
        	 for(StandardTag stndTag : standardTags){
        	  StandardTagLocalServiceUtil.deleteStandardTag(stndTag);
        	 }
         }
         if(tagText.length > 0){
          Set<String> stdHashSet = new HashSet<String>();
         for (int i=0 ; i < tagText.length; i++) {
            	   if(tagText[i].length() > 0 && tagText[i] != null){
            		    stdHashSet.add(tagText[i]);
               }
         }
         if(stdHashSet.size() > 0){
        	 for(String stdHashData:stdHashSet){
                StandardTag stdTag=StandardTagLocalServiceUtil.getStandardTagObject();
				stdTag.setStdId(std.getStdId());
				stdTag.setTag(stdHashData);
				stdTag.setCreatedDate(currDate);
				stdTag.setCreatorId(String.valueOf(user.getUserId()));
				stdTag.setUpdatedBy(String.valueOf(user.getUserId()));
				stdTag.setUpdatedDate(currDate);
				StandardTagLocalServiceUtil.addStandardTag(stdTag);
        	 }
				}
         }
        
        // Process Brands
        final String[] chains = request.getParameterValues("standard_brand");
        LOG.debug(StringUtils.join(chains));
        String selectedBrand = request.getParameter("selectedBrand");
        String selectedBrandStatus = request.getParameter("standard_status");
        ArrayList<String> chainStatuses = new ArrayList<String>();
        
        for (String chain: chains)
        {
            String chainStatus = "NA";
            if(!StandardsUtil.IsNullOrBlank(request.getParameter("standard_status"+chain)))
            {
                chainStatus = request.getParameter("standard_status"+chain);
            }
            chainStatuses.add(chain+","+chainStatus);
        }
		String prevStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
    	prevStatus = updateChains(user,std,stdId,currDate, chains, chainStatuses);
        
    	
    	// Update regions for compliance rule
        if(!std.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
        {
            ComplianceUtil.updateRegions(std, userId);
        }
        //CR 29-2 Standards order  -Temp comment because tabel is not created properly
        //ChangeOrderUtil.addStandardsOrder(stdId, std.getRegionCode(), chains, userId);
        
        // Process Authors
        final String primaryAuthor = request.getParameter("standard_author");
        LOG.debug("primaryAuthor = " + primaryAuthor);
        final String[] secondaryAuthors = request.getParameterValues("secondary_author");
        LOG.debug("secondaryAuthors = " + StringUtils.join(secondaryAuthors));
        LOG.debug(StringUtils.join(secondaryAuthors));
        if (!StandardsUtil.IsNullOrBlank(primaryAuthor))
        {
            updateAuthors(user, std, currDate, primaryAuthor, secondaryAuthors);
        }

        // Process Assign Flag
        final List<String> allFieldIds = new ArrayList<String>();
        addFlags(request, userId, std, stdId, currDate, allFieldIds);
        removeFlags(allFieldIds, stdId);
        
        //copy attribute changes to standard's specifications and guidelines
        if (copyAttributeChanges && BSAdminConstants.STD_TYPE.equalsIgnoreCase(std.getStdTyp())) {
            updateAttributes(resourceRequest, stdId, userId, std.getRegionCode(), comments, selectedBrand, selectedBrandStatus);
        }
        
        
        // Update Taxonomy Link Table
        final String taxonomyChanged = request.getParameter("taxonomyChanged");
        LOG.debug("\n taxonomyChanged=" + ("true".equals(taxonomyChanged) ? "changed" : "no changes") + " \n");
        if ("true".equals(taxonomyChanged))
        {
            final String taxonomyId = request.getParameter("taxonomyId");
            updateTaxonomyLink(userId, stdId, currDate, taxonomyId);

            //updating Index Tree xml data for STD (for Standard Summary in Index Page)
            ActionUtil.insertAdminXML(1l);
        }
        if (isMultipart)
        {
            StandardsAttachmentUtil.proseccSupportingFiles(resourceRequest, (UploadPortletRequest) request, std, userId);
        }
        else
        {
            StandardsAttachmentUtil.proseccSupportingFiles(resourceRequest, std, userId);
        }
        StandardsAssignedImagesUtil.processAssignedImages(request, std.getStdId(), userId);
        // Processing and persisting Extenal Links.
        StandardsLinkUtil.processExternalLinks(request, std.getStdId(), userId);
        StandardsHistoricalManualReferenceUtil.proseccHistoricalManualReferences(request, std.getStdId(), userId);
        processBussinessImpact(request, stdId, userId);
        String regionCode = null;
        if (preferences != null) {
            regionCode = preferences.getRegionCode();
        }
        if (LOG.isDebugEnabled()) {
        	LOG.debug("Current region code is :::"+regionCode);
        }
        //if regionCode is null or blank then it's a regional author.
        if (Validator.isNull(regionCode) || "NA".equals(regionCode)) {
	        try {
	        	regionCode = StandardsUtil.getUserRegionFromUserRole(user.getRoles());
	        	if (LOG.isDebugEnabled()) {
	            	LOG.debug("It's a regional author, current region code is :::"+regionCode);
	            }
	        	
			} catch (SystemException e) {
				LOG.error(e.getMessage(), e);
			}
        }
        saveOrder(request, regionCode);
        if(isSuperAdmin)
        {
        	updateWorkflow(user, std, prevStatus, currDate, comments, chains, chainStatuses);
        }
        else
        {
        	updateWorkflow(user, std, prevStatus, currDate, comments, selectedBrand,selectedBrandStatus);
        }
        //Create an entry into err_notification table.
        if (isExistingStd)
        {
            createSyncNotification(isCountryAdded, isCountryRemoved, previousTitle, std, user);
        }
        return stdView;
    }

    /**
     * Process business impact.
     * 
     * @param request - HTTP Servlet request
     * @param stdId Standard id
     * @param userId user id
     * @throws PortalException exception
     * @throws SystemException exception
     */
    public static void processBussinessImpact(final HttpServletRequest request, final long stdId, final long userId)
            throws PortalException, SystemException
    {
        final String biaRef = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_BIA_REFERENCES);
        final String delBiaRef = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_BIA_REFERENCES);
        LOG.debug("The value of bia ref is " + biaRef);
        LOG.debug("The value of del bia ref is " + delBiaRef);

        if (!StandardsUtil.IsNullOrBlank(biaRef))
        {
            final String[] referenceArray = biaRef.split("~~~id:");
            for (int i = 0; i < referenceArray.length; i++)
            {
                getBIAReference(referenceArray[i], stdId, userId);
            }
        }
        if (!StandardsUtil.IsNullOrBlank(delBiaRef))
        {
            getDeleteBiaReference(delBiaRef);
        }

    }

    /**
     * Get Business Impact Assessment reference.
     * 
     * @param reference the "~~,|~~" separated values of Business Impact Assessment
     * @param stdId Standard Id
     * @param userId user id
     * @throws SystemException exception
     */
    private static void getBIAReference(final String reference, final long stdId, final long userId) throws SystemException
    {
        BusImpactAssmt bia = BusImpactAssmtLocalServiceUtil.getBusImpactAssmtObject();
        if (!StandardsUtil.IsNullOrBlank(reference))
        {
            final String[] referenceArray = reference.split("~~,|~~");
            final long biaId = Long.parseLong(referenceArray[0].trim());
            //long stdBiaId = Long.parseLong(referenceArray[0]);
            final String chain = referenceArray[1];
            final String region = referenceArray[2];
            String regionChange = referenceArray[3];
            final String pandl = referenceArray[4];
            final String capex = referenceArray[5];
            final String impl = referenceArray[6];
            String biaComments = referenceArray[7];
            if ("0".equals(regionChange))
            {
                regionChange = "";
            }
            if ("0".equals(biaComments))
            {
                biaComments = "";
            }
            if (biaId == 0)
            {
                final long busImpactAssmtId = CounterLocalServiceUtil.increment(BusImpactAssmt.class.getName());
                bia.setBusImpactAssmtId(busImpactAssmtId);
                bia.setChain(chain);
                bia.setRegion(region);
                bia.setCapExpenseImpact(capex);
                bia.setProfileLossImpact(pandl);
                bia.setImplTimeScale(impl);
                bia.setChangeFromRegional(regionChange);
                bia.setBiaComments(biaComments);
                bia.setStdId(stdId);
                bia.setCreatorId(String.valueOf(userId));
                bia.setCreatedDate(new Date());
                bia.setUpdatedBy(String.valueOf(userId));
                bia.setUpdatedDate(new Date());
                //arlBiaReference.add(bia);
                BusImpactAssmtLocalServiceUtil.addBusImpactAssmt(bia);
            }
            else
            {
                bia.setBusImpactAssmtId(biaId);
                bia.setChain(chain);
                bia.setRegion(region);
                bia.setCapExpenseImpact(capex);
                bia.setProfileLossImpact(pandl);
                bia.setImplTimeScale(impl);
                bia.setChangeFromRegional(regionChange);
                bia.setBiaComments(biaComments);
                bia.setStdId(stdId);
                bia.setCreatorId(String.valueOf(userId));
                bia.setCreatedDate(new Date());
                bia.setUpdatedBy(String.valueOf(userId));
                bia.setUpdatedDate(new Date());
                //arlBiaReference.add(bia);
                BusImpactAssmtLocalServiceUtil.updateBusImpactAssmt(bia);
            }

        }

    }

    /**
     * Delete Business Impact Assessment reference.
     * 
     * @param delBiaRef comma separated Business Impact Assessment references
     * @throws SystemException exception
     * @throws PortalException exception
     */
    private static void getDeleteBiaReference(final String delBiaRef) throws SystemException, PortalException
    {
        if (!StandardsUtil.IsNullOrBlank(delBiaRef))
        {
            final String[] arrBiaRef = delBiaRef.split(",");
            for (int i = 0; i < arrBiaRef.length; i++)
            {
                final Long bialId = Long.valueOf(arrBiaRef[i]);
                BusImpactAssmtLocalServiceUtil.deleteBusImpactAssmt(bialId);
            }
        }
    }

    /**
     * Populate data from request into a Standard.
     * 
     * @param request - request
     * @param userId - user id
     * @param std - record
     * @param currDate - date
     * @throws ParseException - parse long exception.
     */
    private void getDataFromRequest(final HttpServletRequest request, final long userId, final Standards std, final Date currDate)
            throws ParseException
    {
        std.setTitle(StringUtils.trim(request.getParameter("standard_name")));
        std.setDescription(StringUtils.trim(request.getParameter("standard_rationale")));
        std.setNotes(request.getParameter("supporting_notes"));
        String framework = request.getParameter("standard_framework");
        std.setFramework("N");
        if ("Y".equals(framework))
        {
            std.setFramework("Y");
        }

        String author = "";
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_author")))
        {
            author = request.getParameter("standard_author");
        }
        final String[] secondaryAuthors = request.getParameterValues("secondary_author");
        if (!StandardsUtil.IsNullOrBlank(secondaryAuthors) && secondaryAuthors.length > 0)
        {
            author = author + ",";
            int authCount = 0;
            for (String secondary : secondaryAuthors)
            {
                authCount++;
                author = author + secondary;
                if (authCount != secondaryAuthors.length)
                    author = author + ",";
            }
        }
        std.setAuthor(author);
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_bus_owner")))
        {
            std.setBusinessOwner(request.getParameter("standard_bus_owner"));
        }
        String strDate = request.getParameter("standard_effect_date");
        final DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_effect_date")))
        {
            final Date effDate = (Date) formatter.parse(strDate);
            std.setEffectiveDate(effDate);
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_days_to_imp")))
        {
            strDate = request.getParameter("standard_days_to_imp");
            final Date implDate = (Date) formatter.parse(strDate);
            std.setImplDate(implDate);
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_waiver")))
        {
            std.setWaiver(request.getParameter("standard_waiver"));
        }
        else
        {
            std.setWaiver("N");
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_category")))
        {
            std.setCategory(request.getParameter("standard_category"));
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("standard_change")))
        {
            std.setChange(request.getParameter("standard_change"));
        }
        if (!StandardsUtil.IsNullOrBlank(request.getParameter("global_std_ind")))
        {
            std.setIsGlobal(request.getParameter("global_std_ind"));
        }
        std.setUpdatedBy(String.valueOf(userId));
        std.setUpdatedDate(currDate);
        std.setInternalReference(request.getParameter("internal_reference"));
    }

    /**
     * Resolve user role to Region code.
     * 
     * @param arlRole user roles
     * @return Region Code
     */
    public static String getRegionCodeFromUserRole(List<Role> arlRole)
    {
        String regionCode = new String();
        try
        {
            if (LOG.isDebugEnabled()) {
            	LOG.debug("size of roles is " + arlRole.size());
            }

            for (Role role : arlRole)
            {
                String roleName = role.getName();
                if (LOG.isDebugEnabled()) {
                	LOG.debug("the role is " + roleName);
                }

                if (roleName.contains("GLBL") || roleName.equalsIgnoreCase(StandardsUtil.BRANDSTAND_ADMIN_ROLE))
                {
                    regionCode = "GLBL";
                    break;
                }
                else if (roleName.contains("AMER"))
                {
                    regionCode = "AMER";
                    break;
                }
                else if (roleName.contains("AMEA"))
                {
                    regionCode = "AMEA";
                    break;
                }
                else if (roleName.contains("GC"))
                {
                    regionCode = "GC";
                    break;
                }
                else if (roleName.contains("EURO"))
                {
                    regionCode = "EURO";
                    break;
                }

            }
        }
        catch (Exception e)
        {
            LOG.info(e);
        }
        return regionCode;
    }

    /**
     * Update Chains for a Standard.
     * 
     * @param user - user
     * @param std - record
     * @param stdId - record id
     * @param currDate - date
     * @param chains - array of Chains
     * @throws SystemException - exception on update
     * @throws PortalException 
     */
    private String updateChains(final User user, final Standards std, final long stdId, final Date currDate, final String[] chains,final String selectedBrand, String selectedBrandStatus)
            throws SystemException, PortalException
    {
        String prevStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
        for (String chain : chains)
        {
            ChainStandards chnStd = null;
            if (!chainExists(chain, stdId))
            {
                chnStd = ChainStandardsLocalServiceUtil.getChainStandardsObject();
                chnStd.setStatusId(StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getStatusId());
            }
            else {
                chnStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId,chain); 
            }
            chnStd.setChainCode(chain);
            chnStd.setStdId(std.getStdId());
            chnStd.setUpdatedBy(String.valueOf(user.getUserId()));
            chnStd.setUpdatedDate(currDate);
            chnStd.setCreatedDate(currDate);
            chnStd.setIsActive("Y");
            if(!(StandardsUtil.IsNullOrBlank(selectedBrandStatus)) &&  chain.equals(selectedBrand)){
                prevStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getStatusCode();
                chnStd.setStatusId(Long.valueOf(selectedBrandStatus));
            }
            chnStd.setCreatorId(String.valueOf(user.getUserId()));
            ChainStandardsLocalServiceUtil.updateChainStandards(chnStd);
            if(!std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
            {
                ComplianceUtil.addBrand(stdId, chnStd.getChainCode());
            }
            LOG.debug(chain);
        }
        removeChains(chains, stdId);
        //FinderCacheUtil.clearCache(ChainStandardsImpl.class.getName());
        ChainStandardsLocalServiceUtil.clearCache();
        return prevStatus;
    }
    
    private String updateChains(User user, Standards std, long stdId, Date currDate, String[] chains,List<String> chainStatuses)
	    throws SystemException, PortalException
	{
    	String prevStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
		String chain = "";
		String status = "";
		 
		for (String chainStatus : chainStatuses)
		{
		    ChainStandards chnStd = null;
		    String[] split = chainStatus.split(",");
    		chain = split[0];
    		status = split[1];
    		if (!chainExists(chain, stdId))
    		{
    		    chnStd = ChainStandardsLocalServiceUtil.getChainStandardsObject();
    		    chnStd.setStatusId(StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getStatusId());
    		}
    		else {
    		    chnStd = ChainStandardsLocalServiceUtil.getChainStandardsByChainCodeAll(stdId,chain); 
    		}
    		chnStd.setChainCode(chain);
    		chnStd.setStdId(std.getStdId());
    		chnStd.setUpdatedBy(String.valueOf(user.getUserId()));
    		chnStd.setUpdatedDate(currDate);
    		chnStd.setCreatedDate(currDate);
    		chnStd.setIsActive("Y");
		    prevStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(chnStd.getStatusId()).getStatusCode();
            if (!StandardsUtil.IsNullOrBlank(status.trim()) && !status.equals("NA")) {
                chnStd.setStatusId(Long.valueOf(status));
            } else {
                chnStd.setStatusId(StandardsStatusUtil.getStatuses(std.getRegionCode()).get(0).getStatusId());
            }
		    chnStd.setCreatorId(String.valueOf(user.getUserId()));
		    ChainStandardsLocalServiceUtil.updateChainStandards(chnStd);
		    if(!std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
		    {
		        ComplianceUtil.addBrand(stdId, chnStd.getChainCode());
		    }
		    if (std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_STANDARD))
    		{
		    	StandardsUtil.updateChildStatus(std, chain, Long.valueOf(status), user);
    		}
		    LOG.debug(chain);
		}
		removeChains(chains, stdId);
		ChainStandardsLocalServiceUtil.clearCache();					
		return prevStatus;
	}

    /**
     * Update Chains for a Standard.
     * 
     * @param user - user
     * @param std - record
     * @param stdId - record id
     * @param currDate - date
     * @param chains - array of Chains
     * @throws SystemException - exception on update
     */
    private void updateAuthors(final User user, final Standards std, final Date currDate, String primary,
            final String[] secondries) throws SystemException
    {
        List<StandardsAuthors> standardsAuthors = StandardsAuthorsLocalServiceUtil.getStandardsAuthorsByStdId(std.getStdId());
        if (!StandardsUtil.isNullOrBlank(standardsAuthors))
        {
            for (StandardsAuthors standardsAuthor : standardsAuthors)
                StandardsAuthorsLocalServiceUtil.deleteStandardsAuthors(standardsAuthor);
        }
        long stdAuthId = CounterLocalServiceUtil.increment(StandardsAuthors.class.getName());
        LOG.debug("Primary author stdAuthId = " + stdAuthId + " for " + StandardsAuthors.class.getName());
        StandardsAuthors primaryAuthor = StandardsAuthorsLocalServiceUtil.createStandardsAuthors(stdAuthId);
        primaryAuthor.setStdId(std.getStdId());
        primaryAuthor.setAuthorName(primary);
        primaryAuthor.setIsPrimary("Y");
        primaryAuthor.setCreatorId(String.valueOf(user.getUserId()));
        primaryAuthor.setCreatedDate(currDate);
        primaryAuthor.setUpdatedBy(String.valueOf(user.getUserId()));
        primaryAuthor.setUpdatedDate(currDate);
        StandardsAuthorsLocalServiceUtil.addStandardsAuthors(primaryAuthor);
        if (!StandardsUtil.IsNullOrBlank(secondries) && secondries.length > 0)
        {
            for (String secondary : secondries)
            {
                stdAuthId = CounterLocalServiceUtil.increment(StandardsAuthors.class.getName());
                LOG.debug("Secondary authors stdAuthId = " + stdAuthId + " for " + StandardsAuthors.class.getName());
                StandardsAuthors secondaryAuthor = StandardsAuthorsLocalServiceUtil.createStandardsAuthors(stdAuthId);
                secondaryAuthor.setStdId(std.getStdId());
                secondaryAuthor.setAuthorName(secondary);
                secondaryAuthor.setIsPrimary("N");
                secondaryAuthor.setCreatorId(String.valueOf(user.getUserId()));
                secondaryAuthor.setCreatedDate(currDate);
                secondaryAuthor.setUpdatedBy(String.valueOf(user.getUserId()));
                secondaryAuthor.setUpdatedDate(currDate);
                StandardsAuthorsLocalServiceUtil.addStandardsAuthors(secondaryAuthor);
            }
        }
    }

    /**
     * Update Taxonomy Link Table.
     * 
     * @param userId - user id
     * @param stdId - record id
     * @param currDate - date
     * @param taxonomyId - index id
     * @throws SystemException - exception on update
     */
    private void updateTaxonomyLink(final long userId, final long stdId, final Date currDate, final String taxonomyId)
            throws SystemException
    {
        if (!StandardsUtil.IsNullOrBlank(taxonomyId))
        {
            final long taxId = Long.valueOf(taxonomyId);
            TaxonomyStandards taxonomyStandard = null;
            try
            {
                taxonomyStandard = TaxonomyStandardsLocalServiceUtil.getTaxonomyStandards(stdId);
            }
            catch (Exception exc)
            {
                taxonomyStandard = TaxonomyStandardsLocalServiceUtil.getTaxonomyStandardsObject();
                taxonomyStandard.setStdId(stdId);
                taxonomyStandard.setCreatedDate(currDate);
                taxonomyStandard.setCreatorId(String.valueOf(userId));
            }
            taxonomyStandard.setTaxId(taxId);
            taxonomyStandard.setUpdatedBy(String.valueOf(userId));
            taxonomyStandard.setUpdatedDate(currDate);
            TaxonomyStandardsLocalServiceUtil.updateTaxonomyStandards(taxonomyStandard);
        }
    }

    /**
     * Update Workflow.
     * 
     * @param userId - user id
     * @param user - user
     * @param std - record
     * @param prevStatus - previous status
     * @param currDate - date
     * @param comments - comments
     * @throws SystemException - exception on addWorkflow.
     */
    private void updateWorkflow(final User user, Standards std, String prevStatus, final Date currDate, final String comments, String selectedBrand, String selectedBrandStatus)
            throws SystemException
    {
        final long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
        final Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
        LOG.debug("Update workflow: wrkflowId = " + wrkflowId + " for " + Workflow.class.getName());
        if(StandardsUtil.IsNullOrBlank(selectedBrandStatus))
        {
            selectedBrandStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
        }
        else
        {
            selectedBrandStatus = StandardsStatusUtil.getStatusById(Long.valueOf(selectedBrandStatus)).getStatusCode();
        }
        workflow.setStatus(selectedBrandStatus);
        workflow.setPrevStatus(prevStatus);
        workflow.setObjectId(std.getStdId());
        workflow.setObjectType(std.getStdTyp());
        workflow.setCreatedBy(user.getScreenName());
        workflow.setUpdatedBy(String.valueOf(user.getUserId()));
        workflow.setUpdatedDate(currDate);
        workflow.setCreatedDate(currDate);
        workflow.setCreatorId(String.valueOf(user.getUserId()));
        workflow.setComment(comments);
        if (std.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
        {
            workflow.setTitle(std.getDescription());
        }
        else
        {
            workflow.setTitle(std.getTitle());
        }
        if(selectedBrand.equalsIgnoreCase(BSAdminConstants.ALL_BRAND)){
            workflow.setChainCode(null);
        }else{
            workflow.setChainCode(selectedBrand);
        }
        // workflow.setStatus(std.getStatus());
        WorkflowLocalServiceUtil.addWorkflow(workflow);
    }
    
    /**
     * Update workflow for superadmin
     * @param user
     * @param std
     * @param prevStatus
     * @param currDate
     * @param comments
     * @param chains
     * @param chainStatuses
     * @throws SystemException
     */
    private void updateWorkflow(final User user, Standards std, String prevStatus, final Date currDate, final String comments, String[] chains, List<String> chainStatuses)
            throws SystemException
    {
    	 String chain = "";
         String status = "";
         String selectedBrandStatus = "";
    	for(String chainStatus: chainStatuses)
    	{
    		 String[] split = chainStatus.split(",");
             chain = split[0];
             status = split[1];
             long wrkflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
             LOG.debug("Update workflow for superadmin: wrkflowId = " + wrkflowId + " for " + Workflow.class.getName());
             Workflow workflow = WorkflowLocalServiceUtil.createWorkflow(wrkflowId);
             if(!StandardsUtil.IsNullOrBlank(status.trim()) && !status.equals("NA"))
             {
                 selectedBrandStatus = StandardsStatusUtil.getStatusById(Long.valueOf(status)).getStatusCode();
             }
             else
             {
                 selectedBrandStatus = StandardsStatusUtil.getDefaultStatus(std.getRegionCode());
             }
             workflow.setStatus(selectedBrandStatus);
             workflow.setPrevStatus(prevStatus);
             workflow.setObjectId(std.getStdId());
             workflow.setObjectType(std.getStdTyp());
             workflow.setCreatedBy(user.getScreenName());
             workflow.setUpdatedBy(String.valueOf(user.getUserId()));
             workflow.setUpdatedDate(currDate);
             workflow.setCreatedDate(currDate);
             workflow.setCreatorId(String.valueOf(user.getUserId()));
             workflow.setComment(comments);
             if (std.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
             {
                 workflow.setTitle(std.getDescription());
             }
             else
             {
                 workflow.setTitle(std.getTitle());
             }
             workflow.setChainCode(chain);
             
             WorkflowLocalServiceUtil.addWorkflow(workflow);
    	}
        
    }

    /**
     * Check is Country exists.
     * 
     * @param country - country code
     * @param stdId - Standard Id
     * @return - true/false
     * @throws SystemException - exception
     */
    public boolean countryExists(final String country, final long stdId) throws SystemException
    {
        boolean exists = false;
        if (stdId > 0)
        {
            try
            {
                CountryStandardsLocalServiceUtil.getCountryStandards(new CountryStandardsPK(country, stdId));
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
     * Add countries to a Standard.
     * 
     * @param userId - user id
     * @param stdId - Standard id
     * @param currDate - date
     * @param countries - array of countries
     * @throws SystemException - exception on add country.
     */
    private boolean addCountries(final long userId, final long stdId, final Date currDate, final String[] countries)
            throws SystemException
    {
    	boolean isCountryModified = false;
    	for (String country : countries)
        {
            if (!countryExists(country, stdId))
            {
                //LOG.debug(country);
                final CountryStandards countryStd = CountryStandardsLocalServiceUtil.getCountryStandardsObject();
                countryStd.setStdId(stdId);
                countryStd.setCountry(country);
                countryStd.setCreatorId(String.valueOf(userId));
                countryStd.setCreatedDate(currDate);
                countryStd.setUpdatedBy(String.valueOf(userId));
                countryStd.setUpdatedDate(currDate);
                CountryStandardsLocalServiceUtil.addCountryStandards(countryStd);
                isCountryModified = true;
            }
        }
    	return isCountryModified;
    }

    /**
     * Remove specified countries.
     * 
     * @param countries - array of countries
     * @param std - Standard
     * @throws SystemException - exception
     */
    public boolean removeCountries(final String[] countries, final Standards std) throws SystemException
    {
        if (std.getStdId() < 0) {
            return false;
        }
        final List<CountryStandards> countryStands = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(std.getStdId());
        boolean removalFlag = false;
        boolean isCountryModified = false;
        for (CountryStandards countryStand : countryStands) {
            boolean bFound = false;
            for (String country : countries) {
                if (countryStand.getCountry().equalsIgnoreCase(country)) {
                    bFound = true;
                    break;
                }
            }
            
            if (!bFound) {
            	CountryStandardsLocalServiceUtil.deleteCountryStandards(countryStand);
            	try {
            		//Deleting associated Compliance/Expiry date for the removed country
            		List<StandardsCompliance> ctryStdComplianceList = getStandardsCompliance(std.getStdId(), countryStand.getCountry());
            		if(null != ctryStdComplianceList && ctryStdComplianceList.size() > 0){
            			for(StandardsCompliance stdCompliance : ctryStdComplianceList){
            				StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
            			}
            		}
            	} catch(Exception e){
            		LOG.error("Failed to remove compliance/expiry date for stdId:"+std.getStdId()+" and the removed country:"+countryStand.getCountry());
            	}
            	
                isCountryModified = true;
                if (std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_STANDARD)) {
                    removalFlag = true;
                    final List<Standards> specs = StandardsLocalServiceUtil.getSpecifications(std.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
                    remmoveCountryFromChild(specs, countryStand);
                    final List<Standards> guidelines = StandardsLocalServiceUtil.getGuidelines(std.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
                    remmoveCountryFromChild(guidelines, countryStand);
                }
                
      
           	 
            }
        }
        if (removalFlag)
        {
            final List<Standards> specs = StandardsLocalServiceUtil.getSpecifications(std.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
            setRegionIndicator(specs);
            final List<Standards> guidelines = StandardsLocalServiceUtil.getGuidelines(std.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
            setRegionIndicator(guidelines);
        }
        return isCountryModified;
    }

    /**
     * Remove country from child record.
     * 
     * @param children - list of Standard's children
     * @param countryStand - country
     * @throws SystemException - exception
     */
    public void remmoveCountryFromChild(final List<Standards> children, final CountryStandards countryStand)
            throws SystemException {
        for (Standards child : children) {
            final List<CountryStandards> countrySpecs = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(child.getStdId());
            for (CountryStandards countryspec : countrySpecs) {
                if (countryspec.getCountry().equalsIgnoreCase(countryStand.getCountry())) {
                    CountryStandardsLocalServiceUtil.deleteCountryStandards(countryspec);
                    try {
                		//Deleting associated Compliance/Expiry date for the removed country
                		List<StandardsCompliance> ctryStdComplianceList = getStandardsCompliance(child.getStdId(), countryStand.getCountry());
                		if(null != ctryStdComplianceList && ctryStdComplianceList.size() > 0){
                			for(StandardsCompliance stdCompliance : ctryStdComplianceList){
                				StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
                			}
                		}
                		
                		
                	} catch(Exception e){
                		LOG.error("Failed to remove compliance/expiry date for stdId:"+child.getStdId()+" and the removed country:"+countryStand.getCountry());
                	}
                }
            }
            
            try {
	            List<StandardsImages> stdsImages = StandardsImagesLocalServiceUtil.getStandardsImagesByStdId(child.getStdId());
	            for(StandardsImages stdsImage : stdsImages )
	            {
	                List<StandardsCountryImages> stdctryImages = StandardsCountryImagesLocalServiceUtil.getStandardsCountryImagesByStdImageId(stdsImage.getStdImageId());
	                for(StandardsCountryImages stdCtryImage : stdctryImages)
	                {
	                    if(countryStand.getCountry().equals(stdCtryImage.getCountryCode()))
	                    {
	                   	 StandardsCountryImagesLocalServiceUtil.deleteStandardsCountryImages(stdCtryImage);
	                    }
	                }
	                
	            } 	
            } catch(Exception e){
        		LOG.error("Failed to remove StandardsImages for stdId:"+child.getStdId()+" and the removed country:"+countryStand.getCountry());
        	}
            
            try {
            List<ExternalLinkStandards> stdsLinks = ExternalLinkStandardsLocalServiceUtil.getExternalLinkStandardsByStandardId((long)(child.getStdId()));
            for(ExternalLinkStandards stdsLink : stdsLinks )
            {
                List<ExternalLinkStandardsCountry> stdctryLinks = ExternalLinkStandardsCountryLocalServiceUtil.getExternalLinkStandardsCountryByextlLinkId(stdsLink.getExtLinkId());
                for(ExternalLinkStandardsCountry stdCtryLink : stdctryLinks)
                {
                    if(countryStand.getCountry().equals(stdCtryLink.getCountryCode()))
                    {
                    	ExternalLinkStandardsCountryLocalServiceUtil.deleteExternalLinkStandardsCountry(stdCtryLink);
                    }
                }
                
            } 
            } catch(Exception e){
        		LOG.error("Failed to remove ExternalLink for stdId:"+child.getStdId()+" and the removed country:"+countryStand.getCountry());
        	}
            try {
            List<AttachmentsStandards> attachmentStdards = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByStandardId((long)(child.getStdId()));
            for(AttachmentsStandards attchStd :attachmentStdards){
            	List<AttachmentsStandardsCountry> attachmentStndCountries = AttachmentsStandardsCountryLocalServiceUtil.getAttachmentsStandardsCountryByAttachmentId(attchStd.getAttachmentId());
            	for(AttachmentsStandardsCountry attchStandCountry :attachmentStndCountries){
            		
            		if(countryStand.getCountry().equals(attchStandCountry.getCountryCode()))
                     {
            			AttachmentsStandardsCountryLocalServiceUtil.deleteAttachmentsStandardsCountry(attchStandCountry);
                     }
            	}
            }
            
            } catch(Exception e){
        		LOG.error("Failed to remove AttachmentsStandards for stdId:"+child.getStdId()+" and the removed country:"+countryStand.getCountry());
        	}
        }
    }

    public void setRegionIndicator(final List<Standards> children) throws SystemException
    {
        for (Standards child : children)
        {
            final List<CountryStandards> countrySpecs = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(child
                    .getStdId());
            Map<String, Map<String, String>> allRegions = StandardsUtil.getCountries();
            int totalSize = 0;
            String currentCode = child.getIsGlobal();
            Map<String, Map<String, String>> updatedRegions = new HashMap<String, Map<String, String>>();
            for (Entry<String, Map<String, String>> region : allRegions.entrySet())
            {
                Map<String, String> countriesMap = region.getValue();
                totalSize = totalSize + countriesMap.size();
                for (CountryStandards countryStandards : countrySpecs)
                {
                    if (countriesMap.containsKey(countryStandards.getCountry()))
                    {
                        updatedRegions.put(region.getKey(), countriesMap);
                    }
                }
            }
            if (countrySpecs.size() == totalSize)
            {
                child.setIsGlobal("G");
            }
            else if (updatedRegions.size() > 1)
            {
                child.setIsGlobal("M");
            }
            else
            {
                child.setIsGlobal("N");
            }
            if (!currentCode.equalsIgnoreCase(child.getIsGlobal()))
            {
                StandardsLocalServiceUtil.updateStandards(child);
            }

        }
    }

    /**
     * Verify if chain linked to a Standard.
     * 
     * @param chain - chain code
     * @param stdId - Standard Id
     * @return - true/false
     * @throws SystemException - exception
     */
    public boolean chainExists(final String chain, final long stdId) throws SystemException
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
     * Remove specified chains from a Standard.
     * 
     * @param chains - array of Chains
     * @param stdId - standard id
     * @throws SystemException - exception
     * @throws PortalException 
     */
    public void removeChains(final String[] chains, final long stdId) throws SystemException, PortalException
    {
        if (stdId < 0)
        {
            return;
        }
        final List<ChainStandards> chainStands = new ArrayList<ChainStandards>();
        LOG.debug("RemoveChain 1");
        final List<ChainStandards> standsChain = ChainStandardsLocalServiceUtil.getChainStandardsByStdId(stdId);
        chainStands.addAll(standsChain);
        // In order to return correct filtered result delete chain for specification too.
        final List<Standards> specs = StandardsLocalServiceUtil.getSpecifications(stdId, true, StringPool.BLANK, true, StringPool.BLANK);
        LOG.debug("RemoveChain 2");
        for (Standards standard : specs)
        {
            chainStands.addAll(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(standard.getStdId()));
        }
        LOG.debug("RemoveChain 3");
        final List<Standards> guidelines = StandardsLocalServiceUtil.getGuidelines(stdId, true, StringPool.BLANK, true, StringPool.BLANK);
        for (Standards standard : guidelines)
        {
            chainStands.addAll(ChainStandardsLocalServiceUtil.getChainStandardsByStdId(standard.getStdId()));
        }
        LOG.debug("RemoveChain 4");
        for (ChainStandards chainStand : chainStands)
        {
            boolean bFound = false;
            for (String chain : chains)
            {
                if (chainStand.getChainCode().equalsIgnoreCase(chain))
                {
                    bFound = true;
                    break;
                }
            }
            LOG.debug("RemoveChain 5");
            if (!bFound)
            {
                ChainStandardsLocalServiceUtil.deleteChainStandards(chainStand);
                // CR32 : In order to set unpublished brand compliance rule to N/A
                Standards std = StandardsLocalServiceUtil.getStandards(stdId);
                if(!std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
                {
                    ComplianceUtil.removeBrand(chainStand.getChainCode(), chainStand.getStdId());
                }
            }
        }
        LOG.debug("RemoveChain 6");
    }

    /**
     * Verify if flag exists for a Standard.
     * 
     * @param flagId - flag id
     * @param stdId - standard id
     * @return - true/false
     * @throws SystemException - exception
     */
    public boolean flagExists(final String flagId, final long stdId) throws SystemException
    {
        boolean exists = false;
        if (stdId > 0)
        {
            try
            {
                FlagStandardsLocalServiceUtil.getFlagStandards(new FlagStandardsPK(Long.valueOf(flagId), stdId));
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
     * Add Flags to a Standard.
     * 
     * @param request - request
     * @param userId - user id
     * @param std - record
     * @param stdId - record id
     * @param currDate - date
     * @param allFieldIds - fields
     * @throws SystemException - exception on add
     */
    private void addFlags(final HttpServletRequest request, final long userId, final Standards std, final long stdId,
            final Date currDate, final List<String> allFieldIds) throws SystemException
    {
        final List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil
                .getFlagCategoryByType(StandardsUtil.FLAG_CAT_TYPE_CAT);
        for (FlagCategory flagCategory : flagCategories)
        {
            try
            {
            	 String[] fieldIds = null;
                if(flagCategory.getFlagCatId() == 91){
                	fieldIds = request.getParameter(flagCategory.getTxtValue().replaceAll(" ", "")).split(",");
                }else{
                	fieldIds = request.getParameterValues(flagCategory.getTxtValue().replaceAll(" ", ""));
                }
            	
                if (fieldIds != null && fieldIds.length > 0)
                {
                    LOG.debug(flagCategory.getTxtValue());
                    for (String fieldId : fieldIds)
                    {
                        if (!StandardsUtil.IsNullOrBlank(fieldId))
                        {
                            allFieldIds.add(fieldId);
                            if (!flagExists(fieldId, stdId))
                            {
                                LOG.debug(fieldId);
                                final FlagStandards flagStandards = FlagStandardsLocalServiceUtil.getFlagStandardsObject();
                                flagStandards.setStdId(std.getStdId());
                                flagStandards.setFlagCatId(Long.valueOf(fieldId));
                                flagStandards.setCreatorId(String.valueOf(userId));
                                flagStandards.setCreatedDate(currDate);
                                flagStandards.setUpdatedBy(String.valueOf(userId));
                                flagStandards.setUpdatedDate(currDate);
                               FlagStandardsLocalServiceUtil.addFlagStandards(flagStandards);
                            }
                        }
                    }
                }
            }
            catch (Exception exc)
            {
                LOG.error(StackTraceUtil.getStackTrace(exc));
            }
        }
    }

    /**
     * Remove flags from a Standard.
     * 
     * @param flagsIds - list of flag ids
     * @param stdId - Standard id
     * @throws SystemException - exception
     */
    public void removeFlags(final List<String> flagsIds, final long stdId) throws SystemException
    {
        if (stdId < 0 || flagsIds == null || flagsIds.size() < 0)
        {
            return;
        }
        final List<FlagStandards> flagStands = FlagStandardsLocalServiceUtil.getFlagStandardsByStdId(stdId);
        for (FlagStandards flagStand : flagStands)
        {
            boolean bFound = false;
            for (String flagId : flagsIds)
            {
                if (StandardsUtil.IsNullOrBlank(flagId))
                {
                    bFound = true;
                    break;
                }
                else if (flagStand.getFlagCatId() == Long.valueOf(flagId))
                {
                    LOG.debug(flagStand.getFlagCatId() + "  == " + Long.valueOf(flagId));
                    bFound = true;
                    break;
                }
            }
            if (!bFound)
            {
                LOG.debug("Deleting : " + flagStand.getFlagCatId());
                FlagStandardsLocalServiceUtil.deleteFlagStandards(flagStand);
            }
        }
    }

    /**
     * Fetch Historical Manual from database.
     * 
     * @param resourceRequest - request
     * @param resourceResponse - response
     */
    private void getHistoricalManual(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
    {
        final HttpServletRequest request = PortalUtil
                .getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        final String manualTypes = request.getParameter("manualTypeArray");
        final List<String> manualTypeList = getFilterList(manualTypes);
        final String brands = request.getParameter("brandArray");
        final List<String> brandList = getFilterList(brands);
        final String regions = request.getParameter("regionsArray");
        final List<String> regionList = getFilterList(regions);

        String errorMsg = "Success";
        List<HistManuals> manuals = null;
        try
        {
            manuals = HistManualsLocalServiceUtil.findHistoricalManualsByFilter(brandList, regionList, manualTypeList);
            if (StandardsUtil.isNullOrBlank(manuals))
            {
                errorMsg = "No data found";
            }
        }
        catch (SystemException e)
        {
            errorMsg = "Search failed";
        }

        try
        {
            final JSONObject jsonMain = getHistoricalManualsJson(errorMsg, manuals);
            final PrintWriter writer = resourceResponse.getWriter();
            writer.write(jsonMain.toString());
            writer.flush();
        }
        catch (IOException e)
        {
            LOG.error(StackTraceUtil.getStackTrace(e));
        }
    }

    /**
     * Convert filter from string to list.
     * 
     * @param filter - comma separated filter
     * @return - list
     */
    private List<String> getFilterList(final String filter)
    {
        List<String> filterList = null;
        if (!StandardsUtil.IsNullOrBlank(filter))
        {
            filterList = Arrays.asList(filter.split(","));
        }
        return filterList;
    }

    /**
     * Populate JSON object with Historical Manuals.
     * 
     * @param errorMsg - specified error message
     * @param manuals - list of manuals.
     * @return - JSON onject.
     */
    private JSONObject getHistoricalManualsJson(final String errorMsg, final List<HistManuals> manuals)
    {
        final JSONObject jsonMain = JSONFactoryUtil.createJSONObject();
        jsonMain.put("message", errorMsg);

        if (!StandardsUtil.isNullOrBlank(manuals))
        {
            jsonMain.put("recordCnt", manuals.size());

            for (HistManuals m : manuals)
            {
                final JSONObject jsonOSM = JSONFactoryUtil.createJSONObject();
                jsonOSM.put("title", m.getTitle().length() < 63 ? m.getTitle() : m.getTitle().substring(0, 60) + "...");
                jsonOSM.put("type", m.getType());
                jsonOSM.put("region", StandardsUtil.decodeRegionCode(m.getRegion()));
                final String chain = StandardsUtil.decodeChainCode(m.getChain());
                jsonOSM.put("brand", chain);
                jsonMain.put(String.valueOf(m.getHistManualId()), jsonOSM);
            }
        }
        return jsonMain;
    }

    @ProcessAction(name = "savePrefs")
    public void savePrefs(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        PortletPreferences portletPreferences = actionRequest.getPreferences();
        if (actionRequest.getParameter(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER) != null)
        {
            portletPreferences.setValue(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER,
                    actionRequest.getParameter(BrandStandardsUtil.BS_IMG_GALLERY_FOLDER));
        }
        portletPreferences.store();
    }

    @ProcessAction(name = "cancel")
    public void cancel(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        actionResponse.setPortletMode(PortletMode.VIEW);
    }

    /**
     * Inner comparator class.
     */
    class BiaComparator implements Comparator<BusImpactAssmt>
    {
        /**
         * Compare implementation.
         * 
         * @param o1 first parameter
         * @param o2 second parameter
         * @return -1, 0 , 1
         */
        public int compare(BusImpactAssmt o1, BusImpactAssmt o2)
        {

            return o1.getChainName().compareTo(o2.getChainName());
        }
    }

    /**
     * Get Image Gallery search.
     * 
     * @param resourceRequest - request
     * @param resourceResponse - response
     * @throws IOException
     * @throws PortletException
     */
    private void getImgGalley(final ResourceRequest resourceRequest, final ResourceResponse resourceResponse)
            throws PortletException, IOException
    {
        //final HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        final PortletRequestDispatcher dispatcher = getPortletContext().getRequestDispatcher("/html/imageadmin/view.jsp");
        dispatcher.include(resourceRequest, resourceResponse);
        //        return dispatcher;
    }
    
    /**
     * 
     * @param request PortletRequest object
     * @param stdId Long object
     * @param userId Long object
     * @param regionCd String object
     * @param comments String object
     * @param selectedBrand String object
     * @param selectedBrandStatus String object
     * Update attributes
     */
     private void updateAttributes (PortletRequest request, long stdId, long userId, String regionCd, String comments, String selectedBrand,
    		  String selectedBrandStatus) {
     
         HttpSession httpSession = PortalUtil.getHttpServletRequest(request).getSession();
         try {
        	 User user = UserLocalServiceUtil.getUser(userId);
             List<Standards> specs = StandardsLocalServiceUtil.getSpecifications(stdId, false, selectedBrand, true, null);
             List<Standards> guideLines = StandardsLocalServiceUtil.getGuidelines(stdId, false, selectedBrand, true, null);
             boolean isAttrAvailable = false;
             if (httpSession.getAttribute("addNewAttr") != null) {
                 List<Long> attributes = (List<Long>)httpSession.getAttribute("addNewAttr");
                 updateFlagReferences(request, stdId, userId, attributes, specs, guideLines, true, regionCd, comments, selectedBrand
                		 , selectedBrandStatus);
                 httpSession.removeAttribute("addNewAttr");
                 isAttrAvailable = true;
            }
            
            if (httpSession.getAttribute("removeAttr") != null) {
                List<Long> attributes = (List<Long>)httpSession.getAttribute("removeAttr");
                updateFlagReferences(request, stdId, userId, attributes, specs, guideLines, false, regionCd, comments, selectedBrand, selectedBrandStatus);
                httpSession.removeAttribute("removeAttr");
                isAttrAvailable = true;
            }
            
            if (isAttrAvailable) {
	            //Create log entries for specification
            	createLogEntry(user, specs, comments, selectedBrand);
            	// Create log entries for guidelines
            	createLogEntry(user, guideLines, comments, selectedBrand);
            }
           
         } catch (SystemException e) {
             LOG.error(e.getMessage(), e);
             httpSession.removeAttribute("removeAttr");
             httpSession.removeAttribute("addNewAttr");
       } catch (PortalException e) {
    	   LOG.error(e.getMessage(), e);
           httpSession.removeAttribute("removeAttr");
           httpSession.removeAttribute("addNewAttr");
       }
     }
     
     /**
      * 
      * @param user User object
      * @param stds List<Standards> object
      * @param comment String object
      * @param brand String object
      * Create log entry for each specification and guideline
      */
     private void createLogEntry (User user, List<Standards> stds, String comment, String brand) {
    	 if (stds != null &&  !stds.isEmpty()) {
         	for (Standards standard : stds) {
         		//Create audit log entry for specification
        		 	addAuditLogEntry(user, standard, BSAdminConstants.COPY_ATTRIBUTES_COMMNET+comment, brand);
         	}
         }
     }
     
     /**
      * 
      * @param request PortletRequest object
      * @param stdId Long object
      * @param userId Long object
      * @param attributes List object
      * @param specs List object
      * @param guideLines List object
      * @param addAttr Boolean object
      * @param regionCd String object
      * @param comments String oject
      * @param selectedBrand String object
      * @param brandStatus String object
      * Update flag references for specification and guidelines
      */
     private void updateFlagReferences (PortletRequest request, long stdId, long userId, List<Long> attributes, List<Standards> specs, 
             List<Standards> guideLines, boolean addAttr, String regionCd, String comments, String selectedBrand, String brandStatus) {
         if (LOG.isDebugEnabled()) {
        	 LOG.debug("Region code :"+regionCd);
         }
       //Assign / remove flags from specifications
         updateFlagStandard(userId, attributes, specs, addAttr, regionCd, comments, selectedBrand, brandStatus, true);
       //Assign / remove flags from guidelines
         updateFlagStandard(userId, attributes, guideLines, addAttr, regionCd, comments, selectedBrand, brandStatus, false);
     }
     
     /**
      * 
      * @param userId long object
      * @param attributes List<Long> object
      * @param stds List<Standards> object
      * @param addAttr boolean object
      * @param regionCd String object
      * @param comments String object
      * @param selectedBrand String object
      * @param brandStatus String oject
      * @param isSpec boolean object
      * Update flagStandard reference
      */
     private void updateFlagStandard (long userId, List<Long> attributes, List<Standards> stds, boolean addAttr, String regionCd, String comments, 
    		 String selectedBrand, String brandStatus, boolean isSpec) {
    	 FlagStandards flagStandards = null;
         //Assign / remove flags from specification
         for (Standards standard : stds) {
        	 try {
            	 for (long attribute : attributes) {
    	             flagStandards = null;
    	             FlagCategory category = FlagCategoryLocalServiceUtil.getFlagCategory(attribute);
    				 if (isSpec || !RESTRICTED_CATEGORIES.contains(category.getParentCatId())) {
    				     if (addAttr) {
        					 flagStandards = FlagStandardsLocalServiceUtil.getFlagStandardsObject();
        					 flagStandards.setStdId(standard.getStdId());
        					 flagStandards.setFlagCatId(attribute);
        					 flagStandards.setCreatorId(StringPool.BLANK+userId);
        					 flagStandards.setCreatedDate(new Date());
        					 flagStandards.setUpdatedBy(StringPool.BLANK+userId);
        					 flagStandards.setUpdatedDate(new Date());
        					 if (getFlagStandard(standard.getStdId(), attribute) == null) {
        						 FlagStandardsLocalServiceUtil.addFlagStandards(flagStandards);
        						 if (LOG.isDebugEnabled()) {
                                     LOG.debug("Flag added for std and attributeId is ::::"+attribute);
                                 }
        					 }
        					 
        				 } else {
        					 flagStandards = getFlagStandard(standard.getStdId(), attribute);
        					 if (flagStandards != null) {
        						 FlagStandardsLocalServiceUtil.deleteFlagStandards(flagStandards);
        					 if (LOG.isDebugEnabled()) {
        						 LOG.debug("Flag deleted for std and attributeId is ::::"+attribute);
        						 }
        					 }
        				 }
    				 } else if (RESTRICTED_CATEGORIES.contains(category.getParentCatId())) {
    				     if (LOG.isDebugEnabled()) {
                             LOG.debug("category is not available :"+category.getParentCatId());
                         }
    				 }
            	 }
        	} catch (SystemException e) {
        		LOG.error(e.getMessage(), e);
        	} catch (NoSuchFlagCategoryException e) {
        		LOG.error(e.getMessage(), e);
        	}
         }
     }
     
     /**
      * 
      * @param stdId long object
      * @param attribute long object
      * @return FlagStandards FlagStandards object
      * @author Chintan Akhani
      */
     private FlagStandards getFlagStandard (long stdId, long attribute) {
         FlagStandards flagStandards = null;
         try
        {
            flagStandards = FlagStandardsLocalServiceUtil.getFlagStandardByStandardAndCategoryId(stdId, attribute);
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }
         return flagStandards;
     }
     
     /**
      * 
      * @param request ResourceRequest object
      * @param response ResourceResponse object
      * @author Chintan Akhani
      * On form submit, first check whether any attribute changes are made or not.
      */
     private void compareAttributes (ResourceRequest request, ResourceResponse response) {
         HttpSession session = PortalUtil.getHttpServletRequest(request).getSession();
         List<Long> newAttributes = new ArrayList<Long>();
         List<Long> removeAttributes = new ArrayList<Long>();
         long stdId = ParamUtil.getLong(request, "stdId");
         if (session.getAttribute("addNewAttr") != null) {
             newAttributes = (List<Long>)session.getAttribute("addNewAttr");
         }
         if (session.getAttribute("removeAttr") != null) {
             removeAttributes = (List<Long>)session.getAttribute("removeAttr");
         }
         List<Long> flagIds = new LinkedList<Long>();
         //flagIds.addAll(FlagStandardsLocalServiceUtil.getFlagIdsByStdId(stdId));
         try	{
            flagIds.addAll(FlagStandardsLocalServiceUtil.getFlagIdsByStandardAndCategoryId(stdId, ASSIGN_FLAG_CATGY));
        }	catch (SystemException e1)	{
           LOG.error(e1.getMessage(), e1);
        }
         List<String> newFlagIds = getAttributesFromRequest(request);
         List<Long> flagList = new ArrayList<Long>();
         List<Long> tempFlagList = new ArrayList<Long>();
         for (String id : newFlagIds) {
             flagList.add(Long.parseLong(id));
             tempFlagList.add(Long.parseLong(id));
         }
         flagList.removeAll(flagIds);
         flagIds.removeAll(tempFlagList);
         boolean attrChanges = true;
         if (LOG.isDebugEnabled()) {
        	 LOG.debug("Flag list :"+flagList);
        	 LOG.debug("newAttributes :"+newAttributes);
        	 LOG.debug("flagIds :"+flagIds);
        	 LOG.debug("removeAttributes :"+removeAttributes);
         }
         if (flagList.equals(newAttributes) && flagIds.equals(removeAttributes)) {
             attrChanges = false;
         } 
         if (LOG.isDebugEnabled()) {
        	 LOG.debug("-- removed --"+flagIds);
             LOG.debug("-- added --"+flagList);
         }
        response.setContentType(ContentTypes.APPLICATION_TEXT);
        try {
            if (LOG.isDebugEnabled()) {
            	LOG.debug("attrChanges ---"+attrChanges);
            }
            if (attrChanges) {
                response.getWriter().write("true");
            } else {
                response.getWriter().write("false");
            }
        } catch (IOException e) {
            LOG.error(e.getMessage(), e);
       }
     }
     
    /**
     * 
     * @param request PortletRequest object
     * Copy attribute functionality
     * @author Chintan Akhani
     */
    private void copyAttributes (PortletRequest request) {
        long stdId = 0l;
        if (request.getParameter("stdId") != null) {
            stdId = Long.parseLong(request.getParameter("stdId"));
            List<Long> flagIds = new LinkedList<Long>();
            try	{
                flagIds.addAll(FlagStandardsLocalServiceUtil.getFlagIdsByStandardAndCategoryId(stdId, ASSIGN_FLAG_CATGY));
                //Added this 2 line during 50.3 to copyAttribute working for hotel lifecycle(functionality is part of 69.2)
                List<Long> hotelFlagIds = getHoteslsFlagList();
                flagIds.removeAll(hotelFlagIds);
                /*END 50.3*/
            } catch (SystemException e)	{
            	LOG.error(e.getMessage(), e);
            }
            //flagIds.addAll(FlagStandardsLocalServiceUtil.getFlagIdsByStdId(stdId));
            List<String> newFlagIds = getAttributesFromRequest(request);
            List<Long> flagList = new ArrayList<Long>();
            List<Long> tempFlagList = new ArrayList<Long>();
            for (String id : newFlagIds) {
                flagList.add(Long.parseLong(id));
                tempFlagList.add(Long.parseLong(id));
            }
            flagList.removeAll(flagIds);
            flagIds.removeAll(tempFlagList);
            HttpSession session = PortalUtil.getHttpServletRequest(request).getSession();
            session.setAttribute("addNewAttr", flagList);
            session.setAttribute("removeAttr", flagIds);
            if (LOG.isDebugEnabled()) {
            	LOG.debug(" new flag Ids ---"+flagList);
                LOG.debug(" remove flag Ids ---"+flagIds);
            }
        }
   }
    
    /**
     * 
     * @param request PortletRequest object
     * @return List<String> object
     * @author Chintan Akhani
     * get selected flags from request object
     */
    private List<String> getAttributesFromRequest (PortletRequest request) {
        List<String> newFlagIds = new ArrayList<String>();
        if (request.getParameterValues("deptFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("deptFlags[]") ));
        }
        if (request.getParameterValues("locFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("locFlags[]") ));
        }
        if (request.getParameterValues("corpFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("corpFlags[]") ));
        }
        if (Validator.isNotNull(request.getParameter("wheelFlags"))) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("wheelFlags") ));
        }
        if (request.getParameterValues("guestJourneyFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("guestJourneyFlags[]") ));
        }
        if (request.getParameterValues("msFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("msFlags[]") ));
        }
        if (request.getParameterValues("hotelFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("hotelFlags[]") ));
        }
        if (request.getParameterValues("specFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("specFlags[]") ));
        }
        if (request.getParameterValues("dgtFlags[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("dgtFlags[]") ));
        }
        if (request.getParameterValues("grCategories") != null && request.getParameterValues("grCategories").length > 0 &&
            !request.getParameterValues("grCategories")[0].isEmpty()) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("grCategories") ));
        }
        if (request.getParameterValues("hotelMs[]") != null) {
            newFlagIds.addAll(Arrays.asList(request.getParameterValues("hotelMs[]") ));
        }
        
        return newFlagIds;
    }
    
    /**
     * 
     * @param user User object
     * @param standards Standards object
     * @param comments String object
     * @param brandCode String object
     * @return Workflow Workflow object
     * @author Chintan Akhani
     * Create log entry for specification and guideline flag changes
     */
    private static Workflow addAuditLogEntry(final User user, final Standards standards, final String comments,
            final String brandCode)
    {
        Workflow workflow = null;
        try
        {
            final long workflowId = CounterLocalServiceUtil.increment(Workflow.class.getName());
            workflow = WorkflowLocalServiceUtil.createWorkflow(workflowId);
            if (workflow != null) {
            	//workflow.setWorkflowActvtId(workflowId);
	            workflow.setObjectId(standards.getStdId());
	            workflow.setObjectType(standards.getStdTyp());
	            StandardsStatus stdStatus = StandardsStatusUtil.getStatusById(standards.getStatusId());
	            String brandStatus = null;
	            if (stdStatus != null) {
	            	brandStatus = stdStatus.getStatusCode();
	            }
	            if(StandardsUtil.IsNullOrBlank(brandStatus))
	            {
	            	brandStatus = StandardsStatusUtil.getDefaultStatus(standards.getRegionCode());
	            }
	            workflow.setStatus(brandStatus);
	            workflow.setCreatedBy(user.getScreenName());
	            workflow.setUpdatedBy(Long.toString(user.getUserId()));
	            workflow.setCreatorId(Long.toString(user.getUserId()));
	            workflow.setCreatedDate(new Date());
	            workflow.setUpdatedDate(new Date());
	            workflow.setComment(comments);
	            if (standards.getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN))
	            {
	                workflow.setTitle(standards.getDescription());
	            } else {
	                workflow.setTitle(standards.getTitle());
	            }
	            if (BSAdminConstants.ALL_BRAND.equalsIgnoreCase(brandCode)) {
	            	workflow.setChainCode(null);
	            }else if (Validator.isNotNull(brandCode))
	            {
	                workflow.setChainCode(brandCode);
	            }
	            WorkflowLocalServiceUtil.updateWorkflow(workflow);
            }
        }
        catch (SystemException e)
        {
            LOG.error(e.getMessage(), e);
        }

        return workflow;
    }
    
    /**
     * This method added for working copy attribute for hotel lifecycle during 50.3 (functionality is part of 69.2)
     * @return
     */
    private List<Long> getHoteslsFlagList()
    {
        Long[] hFlags = {396l, 477l, 478l, 399l, 479l};
        return new ArrayList<Long>(ListUtil.toList(hFlags));
    }
    
    /**
     * 
     * @param chains
     * @return List<String>
     */
    private List<String> getBrandNameList (List<ChainStandards> chains) {
    	List<String> chainCodeList = new ArrayList<String>();
		if (Validator.isNotNull(chains)) {
			for (ChainStandards chainStandards : chains) {
				chainCodeList.add(chainStandards.getChainCode());
			}
		}
		return chainCodeList;
    }
    
    /**
     * 
     * @param isCountryModified
     * @param isCountryRemoved
     * @param previousTitle
     * @param standard
     * @param user
     */
    private void createSyncNotification (boolean isCountryAdded, boolean isCountryRemoved, String previousTitle, final Standards standard, User user) {
    	boolean isTitleModified = false;
    	boolean isCountryModified = false;
    	
    	try {
			if (isCountryAdded || isCountryRemoved) {
				isCountryModified = true;
			}
			
			if(StandardsUtil.STD_TYPE_GDLN.equals(standard.getStdTyp()))
			{
			    isTitleModified = !previousTitle.equals(standard.getDescription());
			}
			else
			{
                isTitleModified = !previousTitle.equals(standard.getTitle());
			}
			    
			//Identify title for error notification
            String title = null;
			if (isTitleModified && isCountryModified) {
				title = BSCommonConstants.REQ_TYPE_UPD_COUNTRIES_AND_STATE;
			} else if (isCountryModified) {
				title = BSCommonConstants.REQ_TYPE_UPD_COUNTRIES;
			} else if (isTitleModified) {
				title = BSCommonConstants.REQ_TYPE_UPD_STATE;
			}
			
	        if (LOG.isDebugEnabled()) {
                LOG.debug("Sync with Bridge: previousTitle = " + previousTitle + " new title = " + 
                        (StandardsUtil.STD_TYPE_GDLN.equals(standard.getStdTyp()) ? standard.getDescription() : standard.getTitle())); 
                LOG.debug("Sync with Bridge: isCountryAdded = " + isCountryAdded + " isCountryRemoved = " + isCountryRemoved + 
                        " title changed = " + (!previousTitle.equals(standard.getTitle())));
    			LOG.debug("Sync with Bridge: isTitleModified = " + isTitleModified + " isCountryModified = " + isCountryModified + " title = " + title);
	        }
	        
			if (Validator.isNotNull(title)) {
                long rgnId = BrandStandardsUtil.getRegionId(standard.getRegionCode());
                createBridgeNotification(standard, user, title, rgnId);
                createBridgeNotificationForChildren(standard, user, isCountryRemoved, rgnId);
			}
		} catch (SystemException e) {
			LOG.error(e.getMessage(), e);
		}
    }

    private void createBridgeNotificationForChildren(final Standards standard, User user, boolean isCountryRemoved, long rgnId) 
            throws SystemException
    {
        if (isCountryRemoved && standard.getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD))
        {
            final List<Standards> specs = StandardsLocalServiceUtil.getSpecifications(standard.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
            for (Standards std : specs)
            {
                createBridgeNotification(std, user, BSCommonConstants.REQ_TYPE_UPD_COUNTRIES, rgnId);
            }
            final List<Standards> guidelines = StandardsLocalServiceUtil.getGuidelines(standard.getStdId(), true, StringPool.BLANK, true, StringPool.BLANK);
            for (Standards std : guidelines)
            {
                createBridgeNotification(std, user, BSCommonConstants.REQ_TYPE_UPD_COUNTRIES, rgnId);
            }
        }
    }

    private void createBridgeNotification(final Standards standard, User user, String title, long rgnId) throws SystemException
    {
        //get all active Bridge Publish Ids for the standard
        List<Long> publishIds = StandardsLocalServiceUtil.getBridgePublishIdsByStdId(standard.getStdId());
        if (LOG.isDebugEnabled()) {
            LOG.debug("System have to sync with " + publishIds.size() + " publications");
        }

        for (Long publishId : publishIds) 
        {
        	ErrNotification notification = ErrNotificationLocalServiceUtil.createErrNotificationOraSequence();
        	notification.setStatus(BSCommonConstants.ERR_NOTIFICATION_STATUS_NEW);
            notification.setRegionId(rgnId);
        	notification.setComponentName(BSCommonConstants.ERR_NOTIFICATION_COMPONENT_CMS_BRIDGE_SYNC);
        	//Standard id as a reference
        	notification.setReferenceId(standard.getStdId());
        	notification.setCreatorId(String.valueOf(user.getUserId()));
        	notification.setUpdatedBy(String.valueOf(user.getUserId()));
        	//Type of change ( It can be a title change or country change or both )
        	notification.setTitle(title);
        	//For this request, description is not required
        	notification.setDescription(StringPool.BLANK);
        	notification.setPublishId(publishId);
        	//Use 'H' severity for this type of request
        	notification.setSeverity(BSCommonConstants.REQ_SEVERITY_HIGH);
        	ErrNotificationLocalServiceUtil.updateErrNotification(notification);
        	if (LOG.isDebugEnabled()) {
        		LOG.debug(title + " - Changes are made for standard: " + standard.getStdId());
        	}
        }
        //Create a message bus request
        notifyBridge(standard.getStdId(), rgnId, title, user);
    }
    
    /**
     *
     * @param userId
     * @param regionId
     * @param requestType
     * @param user
     * Create a message bus request for standard country / title changes
     */
	private void notifyBridge (long stdId, long regionId, String notificationType, User user) {
		Message message = new Message();
		message.put("stdId", stdId);
//		message.put("user", user);
		message.put("userScreenName", user.getScreenName());
		message.put("userId", String.valueOf(user.getUserId()));
		message.put("regionId", regionId);
        message.put("requestType", BSCommonConstants.MESSAGE_REQ_TYPE_CMS_BRIDGE_SYNC);
        message.put(BSCommonConstants.REQ_TYPE_PARAM, notificationType);
		MessageBusUtil.sendMessage(BSCommonConstants.BRIDGE_MESSAGE_DESTINATION, message);
		if (LOG.isDebugEnabled()) {
			LOG.debug("Bridge has been notified of standard title / country changes for standard: " + stdId);
		}
	}


	private List<StandardsCompliance> getStandardsCompliance(long stdId, String countryCode){
		
		List<StandardsCompliance> ctryStdComplianceList = new ArrayList<StandardsCompliance>();
        try {
        	ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery stdComplianceQuery = DynamicQueryFactoryUtil.forClass(StandardsCompliance.class, portletClassLoader);
            stdComplianceQuery.add(RestrictionsFactoryUtil.eq("stdId", stdId));
            stdComplianceQuery.add(RestrictionsFactoryUtil.eq("countryCode", countryCode));
            ctryStdComplianceList = StandardsComplianceLocalServiceUtil.dynamicQuery(stdComplianceQuery);
        } catch (Exception e) {
            LOG.error("Error while fetching Standards Compliance for StdId:"+stdId+" and country: "+countryCode, e);
        }
        return ctryStdComplianceList;
	}
}