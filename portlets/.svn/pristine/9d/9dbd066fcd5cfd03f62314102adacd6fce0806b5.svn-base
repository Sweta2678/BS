/**
 * 
 */
package com.ihg.brandstandards.bsadmin.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.ihg.brandstandards.db.model.AttachmentsStandards;
import com.ihg.brandstandards.db.model.ExternalLinkStandards;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.model.StandardsTranslate;

/**
 * @author hitesh.methani
 * 
 */
public class TranslationsView
{
    private Standards standard;
    private String regionCode;

    // Set region id based on login user region id for finding child link, attachment, images
    private String regionId;
    
   	// List of languages associated with standard
    private List<StandardsLocale> languages;
    
    // Default Locale associated with standard
    private StandardsLocale defaultLocale;
    
    // map that stores language code as key and its respective translation as Value
    private Map<String, StandardsTranslate> stdTranslates;

    // parentStdLinks contains links that are in Default Language for given standard
    private List<ExternalLinkStandards> parentStdLinks;

    // Mapping between link and language, its representation Map<ParentLinkId, Map<LangCd, TranslatedLink>>
    private Map<Long, Map<String, ExternalLinkStandards>> linkLanguageMapping;
    
    // parentStdLinks contains images that are in Default Language for given standard
    private List<StandardsImages> parentStdImages;
    
    // Mapping between image and language, its representation Map<ParentImageId, Map<LangCd, StandardsImages>>
    private Map<Long, Map<String, StandardsImages>> stdImageMapping;
    
    // parentAttachmentStd contains attachments that are in Default Language for give Standard
    private List<AttachmentsStandards> parentAttachmentStd = new ArrayList<AttachmentsStandards>();
    
    // Mapping between attachmentstd and language, its representation Map<ParentAttachmentId, Map<LangCd, AttachmentsStandards>>
    private Map<Long, Map<String, AttachmentsStandards>> attacmentLocaleMapping;
    
    // None checked parentAttachments
    private List<Long> noneCheckedParents;
    
    // Mapping betweeen parent ext link and its brands
    private Map<Long, String> extLinkBrandMapping;
    
    
    /**
     * @return the attachmentsBrandsMapping
     */
    public Map<Long, String> getAttachmentsBrandsMapping()
    {
        return attachmentsBrandsMapping;
    }

    /**
     * @param attachmentsBrandsMapping the attachmentsBrandsMapping to set
     */
    public void setAttachmentsBrandsMapping(Map<Long, String> attachmentsBrandsMapping)
    {
        this.attachmentsBrandsMapping = attachmentsBrandsMapping;
    }

    // Mapping between parent attachmentId and its brands
    private Map<Long, String> attachmentsBrandsMapping;
    
    /**
     * @return the standardId
     */
    public Standards getStandard()
    {
        return standard;
    }

    /**
     * @param standardId the standardId to set
     */
    public void setStandard(Standards standard)
    {
        this.standard = standard;
    }

    /**
     * @return the languages
     */
    public List<StandardsLocale> getLanguages()
    {
        return languages;
    }

    /**
     * @param languages the languages to set
     */
    public void setLanguages(List<StandardsLocale> languages)
    {
        this.languages = languages;
    }

    /**
     * @return the defaultLocale
     */
    public StandardsLocale getDefaultLocale()
    {
        return defaultLocale;
    }

    /**
     * @param defaultLocale the defaultLocale to set
     */
    public void setDefaultLocale(StandardsLocale defaultLocale)
    {
        this.defaultLocale = defaultLocale;
    }

    /**
     * @return the stdTranslates
     */
    public Map<String, StandardsTranslate> getStdTranslates()
    {
        return stdTranslates;
    }

    /**
     * @param stdTranslates the stdTranslates to set
     */
    public void setStdTranslates(Map<String, StandardsTranslate> stdTranslates)
    {
        this.stdTranslates = stdTranslates;
    }

    /**
     * @return the parentStdLinks
     */
    public List<ExternalLinkStandards> getParentStdLinks()
    {
        return parentStdLinks;
    }

    /**
     * @param parentStdLinks the parentStdLinks to set
     */
    public void setParentStdLinks(List<ExternalLinkStandards> parentStdLinks)
    {
        this.parentStdLinks = parentStdLinks;
    }

    /**
     * @return the linkLanguageMapping
     */
    public Map<Long, Map<String, ExternalLinkStandards>> getLinkLanguageMapping()
    {
        return linkLanguageMapping;
    }

    /**
     * @param linkLanguageMapping the linkLanguageMapping to set
     */
    public void setLinkLanguageMapping(Map<Long, Map<String, ExternalLinkStandards>> linkLanguageMapping)
    {
        this.linkLanguageMapping = linkLanguageMapping;
    }

    /**
     * @return the stdImageMapping
     */
    public Map<Long, Map<String, StandardsImages>> getStdImageMapping()
    {
        return stdImageMapping;
    }

    /**
     * @param stdImageMapping the stdImageMapping to set
     */
    public void setStdImageMapping(Map<Long, Map<String, StandardsImages>> stdImageMapping)
    {
        this.stdImageMapping = stdImageMapping;
    }

    /**
     * @return the parentStdImages
     */
    public List<StandardsImages> getParentStdImages()
    {
        return parentStdImages;
    }

    /**
     * @param parentStdImages the parentStdImages to set
     */
    public void setParentStdImages(List<StandardsImages> parentStdImages)
    {
        this.parentStdImages = parentStdImages;
    }

    /**
     * @return the regionCode
     */
    public String getRegionCode()
    {
        return regionCode;
    }

    /**
     * @param regionCode the regionCode to set
     */
    public void setRegionCode(String regionCode)
    {
        this.regionCode = regionCode;
    }

    /**
     * @return the parentAttachmentStd
     */
    public List<AttachmentsStandards> getParentAttachmentStd()
    {
        return parentAttachmentStd;
    }

    /**
     * @param parentAttachmentStd the parentAttachmentStd to set
     */
    public void setParentAttachmentStd(List<AttachmentsStandards> parentAttachmentStd)
    {
        this.parentAttachmentStd = parentAttachmentStd;
    }

    /**
     * @return the attacmentLocaleMapping
     */
    public Map<Long, Map<String, AttachmentsStandards>> getAttacmentLocaleMapping()
    {
        return attacmentLocaleMapping;
    }

    /**
     * @param attacmentLocaleMapping the attacmentLocaleMapping to set
     */
    public void setAttacmentLocaleMapping(Map<Long, Map<String, AttachmentsStandards>> attacmentLocaleMapping)
    {
        this.attacmentLocaleMapping = attacmentLocaleMapping;
    }

    /**
     * @return the noneCheckedParents
     */
    public List<Long> getNoneCheckedParents()
    {
        if(noneCheckedParents == null)
        {
            return new ArrayList<Long>();
        }
        return noneCheckedParents;
    }

    /**
     * @param noneCheckedParents the noneCheckedParents to set
     */
    public void setNoneCheckedParents(List<Long> noneCheckedParents)
    {
        this.noneCheckedParents = noneCheckedParents;
    }
    
    /**
     * @return the extLinkBrandMapping
     */
    public Map<Long, String> getExtLinkBrandMapping()
    {
        return extLinkBrandMapping;
    }

    /**
     * @param extLinkBrandMapping the extLinkBrandMapping to set
     */
    public void setExtLinkBrandMapping(Map<Long, String> extLinkBrandMapping)
    {
        this.extLinkBrandMapping = extLinkBrandMapping;
    }

    public static void setTranslationChains(TranslationsView transView)
    {
        // TODO Auto-generated method stub
        
    }

    /**
   	 * @return the regionId
   	 */
   	public String getRegionId() {
   		return regionId;
   	}

   	/**
   	 * @param regionId the regionId to set
   	 */
   	public void setRegionId(String regionId) {
   		this.regionId = regionId;
   	}
}
