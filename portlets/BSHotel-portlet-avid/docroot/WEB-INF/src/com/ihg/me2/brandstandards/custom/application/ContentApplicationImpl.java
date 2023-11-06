/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import javax.portlet.PortletPreferences;

import com.ihg.brandstandards.db.service.BrandArticleLocalServiceUtil;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsConstant;
import com.ihg.me2.brandstandards.custom.util.QueryUtils;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portlet.asset.model.AssetCategory;
import com.liferay.portlet.asset.service.AssetCategoryLocalServiceUtil;
import com.liferay.portlet.journal.model.JournalStructure;
import com.liferay.portlet.journal.service.JournalStructureLocalServiceUtil;

/**
 * <a href="ContentApplicationImpl.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public class ContentApplicationImpl extends ApplicationImpl implements ContentApplication
{

    private static final Log LOG = LogFactoryUtil.getLog(ContentApplicationImpl.class);
    
    /**
     * @param preferences PortletPreferences object
     * @param langCode This is a String object
     * @param brandCode This is a long object
     * @return long This is a long object
     */
    public long getArticleResourcePrimaryKey(PortletPreferences preferences, long langCode, long brandCode)
    {
        String structureId = preferences.getValue("articleType", "");
        long articleResourceId = 0l;
        List results = BrandArticleLocalServiceUtil.getJournalArticleResourcPrimKey(QueryUtils.getArticle(structureId, langCode, brandCode));
        if (Validator.isNotNull(results) && results.size() > 0)
        {
            articleResourceId = ((BigDecimal) results.get(0)).longValue();
        }
        return articleResourceId;
    }

    /**
     * @param scopeGroupId This is a long object
     * @return List<JournalStructure>
     */
    public List<JournalStructure> getStructureList(long scopeGroupId)
    {
        List<JournalStructure> structureList = new ArrayList<JournalStructure>();
        try
        {
            structureList = JournalStructureLocalServiceUtil.getStructures(scopeGroupId);
        }
        catch (SystemException e)
        {
        	LOG.error(e.getMessage(), e);
        }
        if (LOG.isDebugEnabled())
        {
        	LOG.debug("no. of structures :" + structureList.size());
        }
        return structureList;
    }

    /**
     * @param groupId This is a long object
     * @param language This is a String object
     * @param isBrand This is a boolean object
     * @return long
     */
    public long getAssetCategoryId(long groupId, String language, boolean isBrand)
    {
        long categoryId = 0l;
        try
        {
            String categoryProperty = BrandStandardsConstant.LANGUAGE_CODE;
            if (isBrand)
            {
                categoryProperty = BrandStandardsConstant.BRAND_CODE;
            }
            List<AssetCategory> categories = AssetCategoryLocalServiceUtil.search(groupId, null, new String[] { categoryProperty
                    + language }, -1, -1);
            if (Validator.isNotNull(categories) && categories.size() > 0)
            {
                categoryId = categories.get(0).getCategoryId();
            }
        }
        catch (SystemException e)
        {
        	LOG.error(e.getMessage(), e);
        }
        return categoryId;
    }
}
