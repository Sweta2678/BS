/**
 * 
 */
package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.bsadmin.model.TranslationsView;
import com.ihg.brandstandards.db.NoSuchAttachmentsStandardsException;
import com.ihg.brandstandards.db.NoSuchStandardsRegionException;
import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainAttachmentsStandards;
import com.ihg.brandstandards.db.model.ChainExternalLinkStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.StandardsRegion;
import com.ihg.brandstandards.db.model.StandardsRegionLocale;
import com.ihg.brandstandards.db.model.StandardsTranslate;
import com.ihg.brandstandards.db.service.AttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainAttachmentsStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ChainExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.ClpSerializer;
import com.ihg.brandstandards.db.service.ExternalLinkStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsTranslateLocalServiceUtil;
import com.liferay.portal.kernel.bean.PortletBeanLocatorUtil;
import com.liferay.portal.kernel.dao.orm.DynamicQuery;
import com.liferay.portal.kernel.dao.orm.DynamicQueryFactoryUtil;
import com.liferay.portal.kernel.dao.orm.ProjectionFactoryUtil;
import com.liferay.portal.kernel.dao.orm.RestrictionsFactoryUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.StringUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portlet.documentlibrary.NoSuchFolderException;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;

/**
 * @author hitesh.methani
 * 
 */
public class TranslationsUtil extends BrandStandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(TranslationsUtil.class);
    public static final String FIELD_TEXT = "Text";
    public static final String FIELD_CONTEXT = "Context";
    public static final String FIELD_IMAGES = "Images";
    public static final String FIELD_ATTACH = "Attachments";
    public static final String FIELD_LINKS = "Links";
    public static final String DEFAULT_LANG = "en-UK";
    public static final String NOT_APPLICABLE = "N";
    public static final String GLBL_RGN_ID = "2,3,4,5";
    
    /**
     * Method to return list of languages from region code
     * 
     * @author hitesh.methani
     * @param regionCode
     * @return
     */
    public static List<StandardsLocale> getRegionLanguages(String regionCode)
    {
        List<StandardsLocale> languages = new ArrayList<StandardsLocale>();
        try
        {
            StandardsRegion region = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode);
            List<StandardsRegionLocale> regionLanguages = StandardsRegionLocaleLocalServiceUtil
                    .getStandardsRegionLocaleByRegionId(region.getRegionId());
            StandardsLocale locales;
            for (StandardsRegionLocale regionLanguage : regionLanguages)
            {
                if (!BrandStandardsUtil.DEFAULT_LOCALE.equals(regionLanguage.getLocaleCode()))
                {
                    locales = BrandStandardsCacheUtil.getStandardsLocaleByLocaleCd(regionLanguage.getLocaleCode());
                    languages.add(locales);
                }
            }
        }
        catch (NoSuchStandardsRegionException e)
        {
            LOG.error("No Region exists with code " + regionCode);
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getRegionLanguages() " + e.getMessage());
        }
        return languages;
    }

    /**
     * Get locale by passing region code
     * 
     * @param regionCode
     * @return
     */
    public static List<String> getLocaleByRegion(String regionCode)
    {
    	List<String> locales = new LinkedList<String>();
    	try
        {
            StandardsRegion region = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode);
            List<StandardsRegionLocale> regionLanguages = StandardsRegionLocaleLocalServiceUtil
                    .getStandardsRegionLocaleByRegionId(region.getRegionId());
            for (StandardsRegionLocale regionLanguage : regionLanguages)
            {
            	locales.add(regionLanguage.getLocaleCode());
            }
        }
        catch (NoSuchStandardsRegionException e)
        {
            LOG.error("No Region exists with code " + regionCode);
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getRegionLanguages() " + e.getMessage());
        }
    	
    	return locales;
    }
    /**
     * Method to get translations of a standard
     * 
     * @author hitesh.methani
     * @param stdId
     * @return
     */
    public static Map<String, StandardsTranslate> getTranslations(long stdId)
    {
        List<StandardsTranslate> stdTranslations = null;
        Map<String, StandardsTranslate> translationMap = new HashMap<String, StandardsTranslate>();
        try
        {
            stdTranslations = StandardsTranslateLocalServiceUtil.getStandardTranslateByStdId(stdId);
            if (Validator.isNotNull(stdTranslations))
            {
                for (StandardsTranslate translation : stdTranslations)
                {
                    translationMap.put(translation.getLocaleCode(), translation);
                }
            }
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getTranslations with id " + stdId + e.getMessage());
        }

        return translationMap;
    }

    /**
     * Method to show if translation is avaiable for particular field or not
     * 
     * @author hitesh.methani
     * @param langId
     * @param stdId
     * @param field
     * @return
     */
    public static boolean isTranslationAvailable(String langCd, long stdId, String field, TranslationsView transView)
    {
        if (Validator.isNotNull(field))
        {
            StandardsTranslate stdTranslate = null;

            stdTranslate = transView.getStdTranslates().get(langCd);
            if (Validator.isNull(stdTranslate) && field.equals(FIELD_TEXT))
            {
                return false;
            }
            if (field.equals(FIELD_TEXT) && Validator.isNotNull(stdTranslate.getTitle()) && stdTranslate.getIsValidTxt().equals("Y"))
            {
                return true;
            }
            
            else if (field.equals(FIELD_CONTEXT) &&  
                     ( IsNullOrBlank(transView.getStandard().getDescription()) ||
                       ( Validator.isNotNull(stdTranslate) && Validator.isNotNull(stdTranslate.getDescription()) && stdTranslate.getIsValidCntxt().equals("Y")) 
                       
                     )
                    )
            {
                return true;
            }
            else if (field.equals(FIELD_ATTACH))
            {
                List<AttachmentsStandards> attachStds = transView.getParentAttachmentStd();
                boolean allAttachTranslated = true;
                for (AttachmentsStandards parent : attachStds)
                {
                    AttachmentsStandards attachStd = transView.getAttacmentLocaleMapping().get(parent.getAttachmentId()).get(langCd);
                    if (Validator.isNull(attachStd))
                    {
                        allAttachTranslated = false;
                        break;
                    }
                }
                return allAttachTranslated;
            }
            else if (field.equals(FIELD_LINKS))
            {
                List<ExternalLinkStandards> externalLinkStds = transView.getParentStdLinks();
                boolean allLinksTranslated = true;
                for (ExternalLinkStandards parent : externalLinkStds)
                {
                    ExternalLinkStandards extLink = transView.getLinkLanguageMapping().get(parent.getExtLinkId()).get(langCd);
                    if (Validator.isNull(extLink))
                    {
                        allLinksTranslated = false;
                        break;
                    }
                }
                return allLinksTranslated;
            }
            else if (field.equals(FIELD_IMAGES))
            {
                List<StandardsImages> parentStdImages = transView.getParentStdImages();
                if(Validator.isNotNull(parentStdImages))
                {
                    for(StandardsImages stdImage : parentStdImages)
                    {
                        if(!transView.getStdImageMapping().get(stdImage.getStdImageId()).containsKey(langCd))
                        {
                            return false;
                        }
                    }
                }
                return true;
            }
            else
            {
                return false;
            }
        }
        else
        {
            return false;
        }
    }

    /**
     * Method to populate translationView with extLinks
     * 
     * @param transView
     * @throws PortalException 
     * @throws SystemException 
     * 
     */
    public static void setLinkTranslations(TranslationsView transView) throws PortalException, SystemException
    {
            Map<Long, Map<String, ExternalLinkStandards>> linkLanguageMapping = new LinkedHashMap<Long, Map<String, ExternalLinkStandards>>();
            
            List<ExternalLinkStandards> childrens  = ExternalLinkStandardsLocalServiceUtil.getExtLinkStandardsByStdIdAndRgnIdAndLocale(
            		transView.getStandard().getStdId(), transView.getRegionId(), getLocaleByRegion(transView.getRegionCode()));
            Collections.sort(childrens, new ParentIdsComparator());
            setExtLinksTranslation(childrens, linkLanguageMapping, transView);
            transView.setLinkLanguageMapping(linkLanguageMapping);
    }

	
    /**
     * Set External Link Translations.
     * 
	 * @param childrens of external links
	 * @param linkLanguageMapping
	 * @param transView 
	 * @throws SystemException
	 * @throws {@link PortalException}
	 */
	private static void setExtLinksTranslation(List<ExternalLinkStandards> childrens,  Map<Long, Map<String, ExternalLinkStandards>> linkLanguageMapping,
			 TranslationsView transView) throws SystemException, PortalException 
	{
		
		  Map<String, ExternalLinkStandards> langChild =  new LinkedHashMap<String, ExternalLinkStandards>();
		  List<ExternalLinkStandards> parents = new ArrayList<ExternalLinkStandards>();
		  if (Validator.isNotNull(childrens) && childrens.size() > 0)
		  {
			  for (ExternalLinkStandards extLink : childrens)
			  {
				   if (linkLanguageMapping.containsKey(extLink.getParentExtLinkId()))
				   {
				     langChild =  linkLanguageMapping.get(extLink.getParentExtLinkId());
				     langChild.put(extLink.getLocaleCode(), extLink);
				   }
				   else
				   {
				     langChild =  new LinkedHashMap<String, ExternalLinkStandards>();
				     langChild.put(extLink.getLocaleCode(), extLink);
				     
				   }
				   
				   if (BrandStandardsUtil.DEFAULT_LOCALE.equals(extLink.getLocaleCode()) && extLink.getParentExtLinkId() == extLink.getExtLinkId())
				   {
					   parents.add(extLink);
				   }
				   linkLanguageMapping.put(extLink.getParentExtLinkId(), langChild);
			  }
		  }
		transView.setParentStdLinks(parents);
	}
	
    /**
     * Populates translation View with StdImages
     * 
     * @param transView
     * @throws SystemException 
     * @throws PortalException 
     */
    public static void setStdImages(TranslationsView transView) throws PortalException, SystemException
    {
        Map<Long, Map<String, StandardsImages>> stdImageMapping = new HashMap<Long, Map<String, StandardsImages>>();
        	
        List<StandardsImages> stdImages  = StandardsImagesLocalServiceUtil.getStandardImagesByStdIdAndRgnIdAndLocale(
            	transView.getStandard().getStdId(), transView.getRegionId(), getLocaleByRegion(transView.getRegionCode()));
        
        Collections.sort(stdImages, new ParentIdsComparator());    
        setStdImagesTranslation(stdImages, stdImageMapping, transView);
        
        transView.setStdImageMapping(stdImageMapping);
    }
    
    
    /**
     * Set Standards images translations.
     * 
     * @param stdImages
     * @param stdImageMapping
     * @param transView
     * @throws PortalException
     * @throws SystemException
     */
    public static void setStdImagesTranslation(List<StandardsImages> stdImages, Map<Long, Map<String, StandardsImages>> stdImageMapping,
    		TranslationsView transView) throws PortalException, SystemException 
    {
    	Map<String, StandardsImages> langChild =  new LinkedHashMap<String, StandardsImages>();
		List<StandardsImages> parentStdImages = new ArrayList<StandardsImages>();
		  
		if (Validator.isNotNull(stdImages) && stdImages.size() > 0)
		{
		    /*for (StandardsImages child : stdImages)
		    {
		    	langChild = new HashMap<String, StandardsImages>();
		    	parentImage = StandardsImagesLocalServiceUtil.getStandardsImages(child.getParentImageId()); 
		        langChild.put(child.getLocaleCode(), child);
		        langChild.put(parentImage.getLocaleCode(), parentImage);
		        parentStdImages.add(parentImage);
		        stdImageMapping.put(parentImage.getImageId(), langChild);
		    }*/
			for (StandardsImages stdImage : stdImages)
			  {
				   if (stdImageMapping.containsKey(stdImage.getParentImageId()))
				   {
				     langChild =  stdImageMapping.get(stdImage.getParentImageId());
				     langChild.put(stdImage.getLocaleCode(), stdImage);
				   }
				   else
				   {
				     langChild =  new LinkedHashMap<String, StandardsImages>();
				     langChild.put(stdImage.getLocaleCode(), stdImage);
				   }
				   
				   if (BrandStandardsUtil.DEFAULT_LOCALE.equals(stdImage.getLocaleCode()) && stdImage.getParentImageId() == stdImage.getStdImageId())
				   {
					   parentStdImages.add(stdImage);
				   }
				   stdImageMapping.put(stdImage.getParentImageId(), langChild);
			  }
		}
        transView.setParentStdImages(parentStdImages);
    }
    
    /**
     * To set mapping between attachments and standards
     * @author hitesh.methani
     * @param transView
     * @throws SystemException
     * @throws PortalException 
     */
    public static void setAttachmentsStandards(TranslationsView transView) throws SystemException, PortalException
    {
        	Map<Long, Map<String, AttachmentsStandards>> stdAttachmentMapping = new HashMap<Long, Map<String,AttachmentsStandards>>();
        	
        	List<AttachmentsStandards> stdAttachmets  = AttachmentsStandardsLocalServiceUtil.getStandardAttachmentsByStdIdAndRgnIdAndLocale(
            		transView.getStandard().getStdId(), transView.getRegionId(), getLocaleByRegion(transView.getRegionCode()));
        	Collections.sort(stdAttachmets, new ParentIdsComparator());
			setStdAttachmentsTranslation(stdAttachmets, stdAttachmentMapping, transView);
			transView.setAttacmentLocaleMapping(stdAttachmentMapping);
    }

    
    /**
     * Set Standards images translations.
     * 
     * @param stdAttachmets
     * @param stdAttachmentMapping
     * @param transView
     * @throws PortalException
     * @throws SystemException
     */
    public static void setStdAttachmentsTranslation(List<AttachmentsStandards> stdAttachmets, Map<Long, Map<String, AttachmentsStandards>> stdAttachmentMapping,
    		TranslationsView transView) throws PortalException, SystemException 
    {
    	Map<String, AttachmentsStandards> langChild =  new LinkedHashMap<String, AttachmentsStandards>();
		List<AttachmentsStandards> parentStdAttachments = new ArrayList<AttachmentsStandards>();
		if (Validator.isNotNull(stdAttachmets) && stdAttachmets.size() > 0)
		{
			for (AttachmentsStandards stdAttach : stdAttachmets)
			  {
				   if (stdAttachmentMapping.containsKey(stdAttach.getParentAttachmentId()))
				   {
				     langChild =  stdAttachmentMapping.get(stdAttach.getParentAttachmentId());
				     langChild.put(stdAttach.getLocaleCode(), stdAttach);
				   }
				   else
				   {
				     langChild =  new LinkedHashMap<String, AttachmentsStandards>();
				     langChild.put(stdAttach.getLocaleCode(), stdAttach);
				   }
				   
				   if (BrandStandardsUtil.DEFAULT_LOCALE.equals(stdAttach.getLocaleCode()) && stdAttach.getParentAttachmentId() == stdAttach.getAttachmentId())
				   {
					   parentStdAttachments.add(stdAttach);
				   }
				   stdAttachmentMapping.put(stdAttach.getParentAttachmentId(), langChild);
			  }
		}
        transView.setParentAttachmentStd(parentStdAttachments);
    }
    
    
    /**
     * Procedure to get associated images count for particular imageId and stdType
     * 
     * @param imageId
     * @param stdType
     * @return
     * @throws SystemException
     */
    public static long getAssociatedImgCount(long imageId, String stdType)
    {
        try
        {
            // Dynamic Query for getting associtated stdIds for particular image
            ClassLoader portletClassLoader = (ClassLoader) PortletBeanLocatorUtil.locate(ClpSerializer.getServletContextName(), "portletClassLoader");
            DynamicQuery associatedStdQuery = DynamicQueryFactoryUtil.forClass(StandardsImages.class, portletClassLoader);
            associatedStdQuery.add(RestrictionsFactoryUtil.eq("imageId", imageId));
            associatedStdQuery.setProjection(ProjectionFactoryUtil.property("stdId"));
            Collection<Object> associatedStd = (Collection<Object>) StandardsImagesLocalServiceUtil.dynamicQuery(associatedStdQuery);

            // Dynamic Query to get Count of particular stdType - STD, GDLN or SPEC
            DynamicQuery resultCountQuery = DynamicQueryFactoryUtil.forClass(Standards.class, portletClassLoader);
            resultCountQuery.add(RestrictionsFactoryUtil.in("stdId", associatedStd));
            resultCountQuery.add(RestrictionsFactoryUtil.eq("stdTyp", stdType));
            resultCountQuery.setProjection(ProjectionFactoryUtil.rowCount());

            List<Long> resultCount = StandardsLocaleLocalServiceUtil.dynamicQuery(resultCountQuery);
            if (Validator.isNotNull(resultCount) && resultCount.size() > 0)
            {
                return resultCount.get(0);
            }
        }
        catch (SystemException se)
        {
            LOG.error("System Exception in getting count of associated images" + se.getMessage());
        }
        return 0;
    }

    /**
     * To get translated image in particular localeCode, if we do not have translated image, it returns null
     * 
     * @param transView
     * @param langCd
     * @param parentStdImageId
     * @return
     */
    public static StandardsImages getStandardsImageForParent(TranslationsView transView, String langCd, long parentStdImageId)
    {

        StandardsImages resultStdImage = null;
        resultStdImage = transView.getStdImageMapping().get(parentStdImageId).get(langCd);
        return resultStdImage;
    }

    /**
     * To get if parent image and child image are same
     * 
     * @param transView
     * @param langCd
     * @param parentStdImageId
     * @return
     */
    public static boolean getDefaultChecked(TranslationsView transView, String langCd, long parentStdImageId) {
        
        StandardsImages resultStdImage = null;
        StandardsImages parentStdImage = null;
        resultStdImage = transView.getStdImageMapping().get(parentStdImageId).get(langCd);
        parentStdImage = transView.getStdImageMapping().get(parentStdImageId).get(transView.getDefaultLocale().getLocaleCode());
        if(Validator.isNotNull(parentStdImage) && Validator.isNotNull(resultStdImage) && parentStdImage.getImageId() == resultStdImage.getImageId()) 
        {
            return true;
        }
        else
        {
            return false;
        }
    }
    
    /**
     * To get if the translation for particular attachment is availabe or not in particular language, it will return null if translation is not available
     * @author hitesh.methani
     * @param parentAttachStd
     * @param selectedLanguage
     * @param transView
     * @return
     */
    public static AttachmentsStandards getAttachmentTranslation(AttachmentsStandards parentAttachStd,StandardsLocale selectedLanguage,TranslationsView transView)
    {
        AttachmentsStandards attachmentStd = null;
        long parentAttachStdId = parentAttachStd.getAttachmentId();
        if(transView.getAttacmentLocaleMapping().get(parentAttachStdId)!=null) 
        {
            attachmentStd = transView.getAttacmentLocaleMapping().get(parentAttachStdId).get(selectedLanguage.getLocaleCode());
        }
        return attachmentStd;
    }
    
    /**
     * To get default locale code for particular region
     * This method has changed logic, because, English UK will be taken as default language for now
     * @author hitesh.methani
     * @param regionCode
     * @return
     */
    public static StandardsLocale getDefaultLocale(String regionCode)
    {
        StandardsLocale standardsLocale = null;
        
        // Commented code is for getting defualt language based on particular region
        /*try
        {
            StandardsRegion region = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(regionCode);
            StandardsRegionLocale standardsRegionLocale = StandardsRegionLocaleLocalServiceUtil.getDefaultRegionLocale(
                    region.getRegionId(), "Y");
            standardsLocale = StandardsLocaleLocalServiceUtil.getStandardsLocale(standardsRegionLocale.getLocaleCode());
            return standardsLocale;
        }
        catch (SystemException se)
        {
            LOG.error("SystemException in getting default language, setting " + BrandStandardsUtil.DEFAULT_LOCALE + "as default");
        }
        catch (NoSuchStandardsRegionException nsre)
        {
            LOG.error("NoSuchStandardsRegionException in getting default language, setting " + BrandStandardsUtil.DEFAULT_LOCALE
                    + "as default");
        }
        catch (NoSuchStandardsRegionLocaleException nsre)
        {
            LOG.error("NoSuchStandardsRegionLocaleException in getting default language, setting "
                    + BrandStandardsUtil.DEFAULT_LOCALE + "as default");
        }
        catch (PortalException pe)
        {
            LOG.error("PortalException in getting default language, setting " + BrandStandardsUtil.DEFAULT_LOCALE + "as default");
        } */
        try
        {
            standardsLocale = BrandStandardsCacheUtil.getStandardsLocaleByLocaleCd(BrandStandardsUtil.DEFAULT_LOCALE);
        }
        catch (SystemException e)
        {
            LOG.error("SystemException in getting default language " + e.getMessage());
        }
        return standardsLocale;
    }
    
    
    /**
     * Utility to get parent AttachmentStandard for a attachmentStandard
     * @param newAttachedFile - Format of attached file string will be parentId--localeCode--newFile
     * @return parentAttachment standard
     */
    public static AttachmentsStandards getParentAttachment(String newAttachedFile)
    {
        String splittedId[] = StringUtil.split(newAttachedFile, StringPool.DASH+StringPool.DASH);
        long parentAttachId = GetterUtil.getLong(splittedId[0], 0L);
        AttachmentsStandards parentAttachment = null;
        if(parentAttachId == 0)
        {
            return parentAttachment;
        }
        try
        {
        	LOG.info("Get parent attachment");
            parentAttachment = AttachmentsStandardsLocalServiceUtil.getAttachmentsStandardsByParentIdAttachId(parentAttachId, parentAttachId);
        }
        catch (NoSuchAttachmentsStandardsException e)
        {
           LOG.error("No Parent Attachment exists with Id" + parentAttachId + e.getMessage());
        }
        catch (SystemException e)
        {
            LOG.error("SystemException while fetching parentattachment with Id "+ parentAttachId + e.getMessage());
        }
        return parentAttachment;
    }
    
    
    /**
     * To set brands mapping for attachments and external links
     * @param transView
     * @throws SystemException 
     */
    public static void setTranslationChains(TranslationsView transView) throws SystemException
    {
        Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
        
        // set attachment brands
        List<AttachmentsStandards> parentAttachStd = transView.getParentAttachmentStd();
        Map<Long, String> attachmentsStdChainMap = new HashMap<Long, String>();
        if(Validator.isNotNull(parentAttachStd) && parentAttachStd.size() > 0)
        {
            for(AttachmentsStandards parent : parentAttachStd)
            {
                long attachmentId = parent.getAttachmentId();
                StringBuilder chainCodes = new StringBuilder();
                List<ChainAttachmentsStandards> chains = ChainAttachmentsStandardsLocalServiceUtil.getChainAttachmentsStandardsByAttachmentId(attachmentId);
                if(Validator.isNotNull(chains) && chains.size() > 0)
                {
                    for(ChainAttachmentsStandards chain: chains)
                    {
                        if(chainCodes.length() != 0)
                        {
                            chainCodes.append(StringPool.COMMA);
                        }
                        chainCodes.append(chnCdMap.get(chain.getChainCode()));
                    }
                    attachmentsStdChainMap.put(attachmentId, chainCodes.toString());
                }
                else
                {
                    attachmentsStdChainMap.put(attachmentId, "No Brands Found");
                }
                
            }
        }
        transView.setAttachmentsBrandsMapping(attachmentsStdChainMap);
        // set extlinks brands
        List<ExternalLinkStandards> extLinks = transView.getParentStdLinks();
        Map<Long, String> extLinksChain = new HashMap<Long, String>();
        if(Validator.isNotNull(extLinks) && extLinks.size() > 0)
        {
            for(ExternalLinkStandards extLink : extLinks)
            {
                long extLinkId = extLink.getExtLinkId();
                StringBuilder chainCodes = new StringBuilder();
                List<ChainExternalLinkStandards> chains = ChainExternalLinkStandardsLocalServiceUtil.getChainExternalLinkStandardsByLinkId(extLinkId);
                if(Validator.isNotNull(chains) && chains.size() > 0)
                {
                    for(ChainExternalLinkStandards chain : chains)
                    {
                        if(chainCodes.length() != 0)
                        {
                            chainCodes.append(StringPool.COMMA);
                        }
                        chainCodes.append(chnCdMap.get(chain.getChainCode()));
                    }
                    extLinksChain.put(extLinkId, chainCodes.toString());
                }
                else
                {
                    extLinksChain.put(extLinkId, "No Brands Found");
                }
            }
        }
        transView.setExtLinkBrandMapping(extLinksChain);
    }
    
    /**
     * get display text wrt stdtype
     * @param objType
     * @return
     */
    public static String getDisplayText(String objType)
    {
        String displayText = "Standard";
        if(BrandStandardsUtil.STD_TYPE_GDLN.equals(objType))
        {
            displayText = "Guideline";
        }
        else if(BrandStandardsUtil.STD_TYPE_SPEC.equals(objType))
        {
            displayText = "Specification";
        }
        return displayText;
    }
    
    /**
     * Get Document Library Folder for translation.
     * 
     * @param groupId - group id
     * @param userId - user id
     * @param std - Standard
     * @param attachmentType - attachment type
     * @param serviceContext - ServiceContext
     * @return Document Library Folder.
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static DLFolder getDLFolder(final long groupId, final long userId, final Standards std, final String attachmentType,
            final ServiceContext serviceContext, String localeCd) throws PortalException, SystemException
    {
    	
        final DLFolder stdRootFolder = DLFolderLocalServiceUtil.getFolder(groupId, StandardsUtil.STANDARD_ROOT_PARENT_FOLDER_ID,
                StandardsUtil.STANDARD_ROOT_FOLDER_NAME);
        DLFolder folder;
        LOG.info("Get Root folder  " +stdRootFolder.getName() + " ---- ---- -" +stdRootFolder.getFolderId());
        
        if (std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_STANDARD))
        {
            folder = getFolder(groupId, userId, String.valueOf(std.getStdId()), serviceContext, stdRootFolder);
            LOG.info("Standard type folder name is ..." + folder.getName()+ " ---- ---- -" +stdRootFolder.getFolderId());
        }
        else
        {
            folder = getFolder(groupId, userId, String.valueOf(std.getParentId()), serviceContext, stdRootFolder);
            LOG.info("Specification with Root folder name as parent id ..." + folder.getName()+ " ---- ---- -" +stdRootFolder.getFolderId());
            folder = getFolder(groupId, userId, String.valueOf(std.getStdId()), serviceContext, folder);
            LOG.info("Specification with folder name as ID  ..." + folder.getName()+ " ---- ---- -" +stdRootFolder.getFolderId());
            
        }
        if (!std.getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN))
        {
            folder = getFolder(groupId, userId, attachmentType, serviceContext, folder);
            LOG.info("If not standard type is not Guideline" + folder.getName()+ " ---- ---- -" +stdRootFolder.getFolderId());
        }
        folder = getFolder(groupId, userId, localeCd, serviceContext, folder);
        LOG.info("Search for Language folder-----"+ folder.getName()+ " ---- ---- -" +stdRootFolder.getFolderId());
        return folder;
    }

    /**
     * Get Document Library Folder.
     * 
     * @param groupId - group id
     * @param userId - user id
     * @param stdFolderName - folder name
     * @param serviceContext - ServiceContext
     * @param rootFolder - root folder
     * @return Document Library Folder.
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static DLFolder getFolder(final long groupId, final long userId, final String stdFolderName,
            final ServiceContext serviceContext, final DLFolder rootFolder) throws PortalException, SystemException
    {

        DLFolder folder;
        try
        {
        	
            folder = DLFolderLocalServiceUtil.getFolder(groupId, rootFolder.getFolderId(), stdFolderName);
            LOG.info("After Call of DLFolder API --->" +folder.getName());
        }
        catch (NoSuchFolderException e)
        {
        	final String stdFolderDesc = "Folder for Standard " + stdFolderName;
        	try
            {
            	
                folder = DLFolderLocalServiceUtil.getFolder(groupId, rootFolder.getFolderId(), stdFolderDesc);
                LOG.info("In the Catch - Try catch --->" +folder.getName());
            }
            catch (NoSuchFolderException e1)
            {
	            serviceContext.setAddGroupPermissions(true);
	            serviceContext.setAddGuestPermissions(false);
	            folder = DLFolderLocalServiceUtil.addFolder(userId, groupId, groupId, false, rootFolder.getFolderId(), stdFolderName, stdFolderDesc, false, serviceContext);
            }
        }
        return folder;
    }
    
    public static String getDownloadablePath(String attachmentPath, long groupId)
    {
        String fileName = attachmentPath.substring(attachmentPath.lastIndexOf("/")+1, attachmentPath.length());
        String path = attachmentPath.substring(0, attachmentPath.lastIndexOf('/'));
        long folderId = Long.valueOf(path.substring(path.lastIndexOf("/")+1, path.length()));  

        try
        {
            DLFileEntry fileEntry = null;
            fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileName);
            path = "/documents/"+ groupId + "/" + fileEntry.getUuid();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
        return path;
    }
    
    /**
     * Method for getting regionId by passing region code.
     * This method used to find country associated to region for query building.
     * @param regionCode
     * @return
     */
    public static String getRegionIdByRegionCode(String regionCode)
    {
    	String regionId = StringPool.BLANK;
        if("GLBL".equals(regionCode))
    	{
        	regionId = GLBL_RGN_ID; 
    	}
    	else
    	{
    		regionId = Long.toString(BrandStandardsUtil.getRegionId(regionCode));
    	}
        return regionId;
    }
}

/**
 * Comparator for maintaining order based on parentextlinkid, parentimageid, parentattachmentid
 * @param <T>
 */
class ParentIdsComparator<T> implements Comparator<T> 
{
    @Override
	public int compare(T o1, T o2) 
    {
    	if (o1 instanceof ExternalLinkStandards)
    	{
    		ExternalLinkStandards extLink = (ExternalLinkStandards) o1;
    		if (extLink.getParentExtLinkId() > extLink.getParentExtLinkId())
            {
                return 1;
            }
            else if (extLink.getParentExtLinkId() < extLink.getParentExtLinkId())
            {
                return -1;
            }
            else
            {
                return 0;
            }
    	}
    	else if(o1 instanceof StandardsImages )
    	{
    		StandardsImages stdImag = (StandardsImages) o1;
    		if (stdImag.getParentImageId() > stdImag.getParentImageId())
            {
                return 1;
            }
            else if (stdImag.getParentImageId() < stdImag.getParentImageId())
            {
                return -1;
            }
            else
            {
                return 0;
            }
    	}
    	else if(o1 instanceof AttachmentsStandards)
    	{
    		AttachmentsStandards stdAttach = (AttachmentsStandards) o1;
    		if (stdAttach.getParentAttachmentId() > stdAttach.getParentAttachmentId())
            {
                return 1;
            }
            else if (stdAttach.getParentAttachmentId() < stdAttach.getParentAttachmentId())
            {
                return -1;
            }
            else
            {
                return 0;
            }
    	}
		return 0;
	}
}
