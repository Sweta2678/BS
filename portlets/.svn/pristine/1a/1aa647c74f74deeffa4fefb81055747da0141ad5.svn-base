/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import java.util.List;

import com.ihg.brandstandards.db.model.FlagCategory;
import com.ihg.brandstandards.db.service.FlagCategoryLocalServiceUtil;

/**
 * <a href="FlagCategoryApplication.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public class FlagCategoryApplication extends ApplicationImpl
{
    //private static final Logger _log = BrandStandardsLogger.getLogger(FlagCategoryApplication.class);

    /**
     * @param flagCategoryId - Flag Category Id
     * @return List<FlagCategory>
     * @throws Exception throws Exception
     */
    public List<FlagCategory> getCategoryByParentId(long flagCategoryId) throws Exception
    {
        List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(flagCategoryId);

        return flagCategories;
    }
}
