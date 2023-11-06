/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.application;

import com.liferay.portlet.journal.model.JournalStructure;

import java.util.List;

import javax.portlet.PortletPreferences;

/**
 * <a href="ContentApplication.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Chintan Akhani
 * 
 */
public interface ContentApplication extends Application
{
    /**
     * 
     * @param preferences PortletPreferences object
     * @param langCode langCode is long object
     * @param brandCode brandCode is long object
     * @return long
     */
	public long getArticleResourcePrimaryKey(PortletPreferences preferences, long langCode, long brandCode);
	/**
	 * 
	 * @param scopeGroupId This is a long object
	 * @return List<JournalStructure>
	 */
    public List<JournalStructure> getStructureList(long scopeGroupId);
    /**
     * 
     * @param groupId This is a long object
     * @param language This is a String object
     * @param isBrand This is a boolean object
     * @return long
     */
    public long getAssetCategoryId(long groupId, String language, boolean isBrand);
}
