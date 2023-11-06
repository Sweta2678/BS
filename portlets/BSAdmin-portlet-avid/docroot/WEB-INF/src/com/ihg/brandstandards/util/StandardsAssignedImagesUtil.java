package com.ihg.brandstandards.util;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import com.ihg.brandstandards.db.model.StandardsChainImages;
import com.ihg.brandstandards.db.model.StandardsCountryImages;
import com.ihg.brandstandards.db.model.StandardsImages;
import com.ihg.brandstandards.db.service.StandardsChainImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsImagesLocalServiceUtil;
import com.ihg.brandstandards.db.service.persistence.StandardsCountryImagesPK;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;

/**
 * Utility class to link images to a Standard/Specification/Guideline.
 * 
 * @author kryvora
 * 
 */
public final class StandardsAssignedImagesUtil extends StandardsUtil
{
    private static final Log LOG = LogFactoryUtil.getLog(StandardsAssignedImagesUtil.class);

    /**
     * Private constructor.
     */
    private StandardsAssignedImagesUtil()
    {
    }

    /**
     * Persist Assigned Images into database.
     * 
     * @param request - request
     * @param stdId - Standard Id
     * @param userId - user Id
     * @throws PortalException - exception
     * @throws SystemException - exception
     */
    public static void processAssignedImages(final HttpServletRequest request, final long stdId, final long userId)
            throws PortalException, SystemException
    {
        final String images = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES);
        final String editImages = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_EDIT_IMAGES);
        final String delImages = request.getParameter(StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_IMAGES);
        if (!StandardsUtil.IsNullOrBlank(images) || !StandardsUtil.IsNullOrBlank(delImages))
        {
            final Map<StandardsImages, List<List>> newImages = getNewImages(images, stdId, userId);
            final List<Long> deleteImages = getDeleteImages(delImages, stdId);
            persistImages(deleteImages, newImages);
        }
        if(!editImages.equals(StringPool.BLANK))
        {
        	updateImagesCountryAndChain(editImages, userId);
        }
    }
    
    
    /**
     * Find Images to be deleted.
     * 
     * @param delImages - comma separated string of Image IDs to be deleted
     * @param stdId - Standard Id
     * @return - List of Images to be deleted.
     */
    private static List<Long> getDeleteImages(final String delImages, final long stdId)
    {
        final List<Long> deleteImg = new ArrayList<Long>();
        if (!StandardsUtil.IsNullOrBlank(delImages))
        {
            final String[] imgArray = delImages.split(StringPool.COMMA);
            for (String img : imgArray)
            {
                final Long imgId = Long.valueOf(img);
                deleteImg.add(imgId);
            }
        }
        return deleteImg;
    }

    /**
     * Extract New Images data.
     * 
     * @param images - "~~~id:" separated string of Images
     * @param stdId - Standard Id
     * @param userId - user id
     * @return - list of new images.
     */
    private static Map<StandardsImages, List<List>> getNewImages(final String images, final long stdId, final long userId)
    {
        final Map<StandardsImages, List<List>> newImg = new HashMap<StandardsImages, List<List>>();
        if (!StandardsUtil.IsNullOrBlank(images))
        {
            final String[] imgArray = images.split("~~~id:");
            for (String img : imgArray)
            {
                getNewSubmittedImage(img, newImg, stdId, userId);
            }
        }
        return newImg;
    }

    /**
     * Populate data for new Images into list.
     * 
     * @param imgStr - string with image data
     * @param newImg - list
     * @param stdId - Standard Id
     * @param userId - User Id
     */
    private static void getNewSubmittedImage(String imgStr, Map<StandardsImages, List<List>> newImg, long stdId, long userId)
    {
        if (!StandardsUtil.IsNullOrBlank(imgStr))
        {
            final String[] imgArray = imgStr.split("~~,|~~");
            if (imgArray.length >= StandardsUtil.IMAGE_TOCKENS_NUM)
            {
                final String title = imgArray[StandardsUtil.IMAGE_TITLE_INDX];
                final Long imgId = Long.valueOf(imgArray[StandardsUtil.IMAGE_ID_INDX]);
                final Long imgSortOrder = Long.valueOf(imgArray[StandardsUtil.IMAGE_SORT_ORDER_INDX]);
                if (Long.valueOf(imgArray[0]) <= 0) 
                {
	                if (LOG.isDebugEnabled()) {
	                    LOG.debug("imgId:" + imgId + " stdId:" + stdId + " imgSortOrder:" + imgSortOrder + " title=" + title);
	                }
	                StandardsImages img = null;
	                List chainCountryList = new ArrayList<List>();
	                try
	                {
	                    
	                    List<StandardsImages> existingStdImage = StandardsImagesLocalServiceUtil.getStandardsImagesByImageIdStdIdLocaleCd(imgId, stdId, BrandStandardsUtil.DEFAULT_LOCALE);
	                    if(Validator.isNotNull(existingStdImage) && existingStdImage.size() > 0)
	                    {
	                        img = existingStdImage.get(0);
	                    }
	                    else
	                    {
	                        img = StandardsImagesLocalServiceUtil.createStandardsImages(CounterLocalServiceUtil.increment(StandardsImages.class.getName()));
	                        img.setCreatorId(String.valueOf(userId));
	                        img.setCreatedDate(new Date());
	                        final String chains = imgArray[7];
	                        if(!IsNullOrBlank(chains)) 
	                        {
	                            String[] chainsArray = chains.split(StringPool.COMMA);
	                            List<StandardsChainImages> imageChain = new ArrayList<StandardsChainImages>();
	                            StandardsChainImages standardsChainImages = null;
	                            for(String chain : chainsArray)
	                            {
	                                standardsChainImages = getChainImageObject(img.getStdImageId(), userId, chain);
	                                imageChain.add(standardsChainImages);
	                            }
	                            chainCountryList.add(imageChain);
	                        }
	                        
	                        final String country = imgArray[9];
	                        if(!IsNullOrBlank(country))
	                        {
	                        	String[] countryArray = country.split(StringPool.COMMA);
	                        	List<StandardsCountryImages> imageCountry = new ArrayList<StandardsCountryImages>();
	                        	StandardsCountryImages countryImage = null;
	                            for(String cntry : countryArray)
	                            {
	                            	countryImage =  getCountryImageObject(img.getStdImageId(), userId, cntry);			 
	                    			imageCountry.add(countryImage);
	                            }
	                            chainCountryList.add(imageCountry);
	                        }
	                    }
	                }
	                catch (SystemException e)
	                {
	                    LOG.error("Systemexception in generating primary key of StdImages" + e.getMessage());
	                }
	                // Insert Chains Links.
	                img.setImageId(imgId);
	                img.setParentImageId(img.getStdImageId());
	                img.setLocaleCode(StandardsUtil.DEFAULT_LOCALE);
	                img.setStdId(stdId);
	                img.setImageTitle(title);
	                img.setImageSortOrder(imgSortOrder);
	                img.setUpdatedBy(String.valueOf(userId));
	                img.setUpdatedDate(new Date());
	                newImg.put(img, chainCountryList);
                }
            }
        }
    }

    /**
     * Update database.
     * 
     * @param deleteImages images to unlink
     * @param newImages images to link
     * @throws SystemException exception
     * @throws PortalException exception
     */
    private static void persistImages(List<Long> deleteImages, Map<StandardsImages, List<List>> newImages) throws SystemException,
            PortalException
    {
         if (!StandardsUtil.isNullOrBlank(newImages))
        {
            for (StandardsImages img : newImages.keySet())
            {
                addImage(img);
            	if (newImages.get(img).size()>0)
            	{
	                List<StandardsChainImages> chains = newImages.get(img).get(0);
	                // Save Image-Chains.
	                if(!isNullOrBlank(chains))
	                {
	                    for(StandardsChainImages chain : chains)
	                    {
	                        chain.setStdImageId(img.getStdImageId());
	                        StandardsChainImagesLocalServiceUtil.addStandardsChainImages(chain);
	                    }
	                }
            	}
            	if (newImages.get(img).size()>1)
            	{
	                List<StandardsCountryImages> country = newImages.get(img).get(1);
	                if(!isNullOrBlank(country))
	                {
	                    for(StandardsCountryImages cntry : country)
	                    {
	                    	cntry.setStdImageId(img.getStdImageId());
	                        StandardsCountryImagesLocalServiceUtil.addStandardsCountryImages(cntry);
	                    }
	                }
            	}
            }
        }

        if (!StandardsUtil.isNullOrBlank(deleteImages))
        {
            for (Long stdImgPk : deleteImages)
            {
            	List<StandardsCountryImages> countryList = StandardsCountryImagesLocalServiceUtil.getStandardsCountryImagesByStdImageId(stdImgPk);
            	for (StandardsCountryImages countryImage : countryList)
            	{
            		StandardsCountryImagesLocalServiceUtil.deleteStandardsCountryImages(countryImage);
            	}
                StandardsImagesLocalServiceUtil.deleteStandardsImages(stdImgPk);
            }
        }
    }

    /**
     * Persist Standard Images.
     * 
     * @param img - image to link
     * @throws SystemException - exception
     */
    private static void addImage(final StandardsImages img) throws SystemException
    {
        StandardsImagesLocalServiceUtil.updateStandardsImages(img);
    }

    /**
     * Find images by Std Id.
     * 
     * @param stdId Standard ID
     * @return List of Images
     * @throws SystemException exception
     */
    public static Map<StandardsImages, List<List>> getStandardsImagesByStdId(final long stdId) throws SystemException
    {
        Map<StandardsImages, List<List>> imageChains = new LinkedHashMap<StandardsImages, List<List>>();
        List countryChain = null;
        List<StandardsImages> stdImages = StandardsImagesLocalServiceUtil.getParentStdImages(stdId);
        if (!StandardsUtil.isNullOrBlank(stdImages))
        {
            for (StandardsImages stdImg : stdImages)
            {
            	countryChain = new ArrayList<Object>();
                StandardsUtil.setImageTranslationExist(stdImg);
                stdImg.setImage(stdImg.getDBImage());
                List<StandardsChainImages> chainImgs = null;
                try
                {
                    chainImgs = StandardsChainImagesLocalServiceUtil.getChainImagesByStdImageId(stdImg.getStdImageId());
                } catch (Exception exc)
                {
                  // Do nothing.  
                }
                countryChain.add(chainImgs);
               
                //put all country
                List<StandardsCountryImages> countryImgs =  StandardsCountryImagesLocalServiceUtil.getStandardsCountryImagesByStdImageId(stdImg.getStdImageId());
                countryChain.add(countryImgs);
                
                //put all regions
                Map<String, Map<String, String>> regionCountryMap = BrandStandardsUtil.getCountries();
                List<String> region = new ArrayList<String>();
                for(StandardsCountryImages countryImg: countryImgs){
                	region.add(BrandStandardsUtil.getRegionByCountryCode(regionCountryMap, countryImg.getCountryCode()));
                }
                ListUtil.distinct(region);
                countryChain.add(region);
                imageChains.put(stdImg, countryChain);
            }
        }
        return imageChains;
    }
    /**
     * Update Images Brand & Country
     * @param editImages
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateImagesCountryAndChain(String editImages, long userId) throws NumberFormatException, SystemException
    {
    	String imageArray[] = editImages.split(StringPool.COMMA+StringPool.COMMA+StringPool.COMMA);
    	
    	for(String image : imageArray){
    		String row[] = image.split("~~");
    		if (!row[1].equals("##")){ //for Brand
    			updateImageChain(row, userId);
    		}
    		if (!row[2].equals("##")) //for Country
    		{
    			updateImageCountry(row, userId);
    		}
    	}
    }
    
    /**
     * Update Images Brand
     * @param row
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateImageChain(String row[], long userId) throws NumberFormatException, SystemException
    {
    	List<StandardsChainImages> imageChainList = StandardsChainImagesLocalServiceUtil.getChainImagesByStdImageId(Long.valueOf(row[0]));
    	StandardsChainImages chainImage = StandardsChainImagesLocalServiceUtil.getStandardsChainImagesObject();
		for(StandardsChainImages stdChainImage : imageChainList){
    			if (row[1].contains(stdChainImage.getChainCode())){
    				row[1] = row[1].replace(stdChainImage.getChainCode(), "##");
    			} else {
    				StandardsChainImagesLocalServiceUtil.deleteStandardsChainImages(stdChainImage);
    			}
		}
		for(String chain :  row[1].split(StringPool.COMMA)){
			if (!chain.equals("##")){
    			chainImage = getChainImageObject(Long.valueOf(row[0]), userId, chain);   					 
    			StandardsChainImagesLocalServiceUtil.addStandardsChainImages(chainImage);
			}
		}
    
    }
    
    /**
     * Update Images Country
     * @param row
     * @param userId
     * @throws NumberFormatException
     * @throws SystemException
     */
    private static void updateImageCountry(String row[], long userId) throws NumberFormatException, SystemException
    {
    	List<StandardsCountryImages> imageCountryList =  StandardsCountryImagesLocalServiceUtil.getStandardsCountryImagesByStdImageId(Long.valueOf(row[0]));
    	StandardsCountryImages countryImage =  null;
		for(StandardsCountryImages stdCountryImage : imageCountryList){
    			if (row[2].contains(stdCountryImage.getCountryCode())){
    				row[2] = row[2].replace(stdCountryImage.getCountryCode(), "##");
    			} else {
    				StandardsCountryImagesLocalServiceUtil.deleteStandardsCountryImages(stdCountryImage);
    			}
		}
		for(String country :  row[2].split(StringPool.COMMA)){
			if (!country.equals("##")){
				countryImage =   getCountryImageObject(Long.valueOf(row[0]), userId, country);						 
    			StandardsCountryImagesLocalServiceUtil.addStandardsCountryImages(countryImage);
			}
		}
    }
    
    /**
     * Create StandardsChainImages Object 
     * @param stdImageId
     * @param userId
     * @param chain
     * @return StandardsChainImages
     */
    private static StandardsChainImages getChainImageObject(long stdImageId, long userId, String chain)
    {
    	StandardsChainImages standardsChainImages = StandardsChainImagesLocalServiceUtil.getStandardsChainImagesObject();
        standardsChainImages.setStdImageId(stdImageId);
        standardsChainImages.setChainCode(chain);
        standardsChainImages.setCreatorId(String.valueOf(userId));
        standardsChainImages.setCreatedDate(new Date());
        standardsChainImages.setUpdatedBy(String.valueOf(userId));
        standardsChainImages.setUpdatedDate(new Date());
        return standardsChainImages;
    }
    
    /**
     * Create StandardsCountryImages Object
     * @param stdImageId
     * @param userId
     * @param country
     * @return StandardsCountryImages
     */
    private static StandardsCountryImages getCountryImageObject(long stdImageId, long userId, String country)
    {
    	StandardsCountryImagesPK countryPK = new StandardsCountryImagesPK(stdImageId, country);
    	StandardsCountryImages countryImage = StandardsCountryImagesLocalServiceUtil.createStandardsCountryImages(countryPK);
		countryImage.setStdImageId(stdImageId);
		countryImage.setCountryCode(country);
		countryImage.setCreatorId(String.valueOf(userId));
		countryImage.setCreatedDate(new Date());
		countryImage.setUpdatedBy(String.valueOf(userId));
		countryImage.setUpdatedDate(new Date());
		return countryImage;
    }
}