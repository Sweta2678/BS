/**
 * ©2013 IHG. All rights reserved.
 */
package com.ihg.me2.brandstandards.custom.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.PortletException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryRegionNav;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryRegionNavLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil;
import com.ihg.me2.brandstandards.custom.pojo.AccessAndPreferences;
import com.ihg.me2.brandstandards.custom.util.BrandStandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * <a href="StandardsListPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * @project: Brand Standards.
 * @author Andrey Kryvor
 */
public class GlossaryListPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(GlossaryListPortlet.class);
    
    public static String DEFAULT_LOCALE = "en_GB";
    
    public static String DEFAULT_CHAR_ALL = "ALL";
    
    /**
     * @param renderRequest Portlet RenderRequest object
     * @param renderResponse Portlet RenderResponse object
     * @throws IOException throws IOException
     * @throws PortletException throws PortletException
     */
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        StringBuilder enableChars = new StringBuilder();
        List<String> staticChars = new ArrayList<String>();
        List<Glossary> glossaries = new ArrayList<Glossary>();
        List<GlossaryRegionNav> glossaryRegionNavs = null;
        Map<Long, GlossaryTranslate> xGlossaries = new HashMap<Long, GlossaryTranslate>();
        HttpServletRequest httpReq = PortalUtil.getHttpServletRequest(renderRequest);
        HttpSession session = httpReq.getSession();
        AccessAndPreferences userPreferences = (AccessAndPreferences) session.getAttribute("UserPreferences");
        String ctryCode =  Validator.isNotNull(userPreferences) ? userPreferences.getCountry() : StringPool.BLANK;
        String chainCode = Validator.isNotNull(userPreferences) ? userPreferences.getChain() : StringPool.BLANK;
        String regionCode = Validator.isNotNull(ctryCode) ? BrandStandardsUtil.getRegionByConuntryCode(ctryCode) : StringPool.BLANK;
        int rgnId = Validator.isNotNull(regionCode) ? (int) StandardsRegionLocalServiceUtil.getRegionIdByCode(regionCode) : 1;
        String langCode = Validator.isNotNull(userPreferences) ? userPreferences.getLangCode() : DEFAULT_LOCALE;
        String visibleChar = ParamUtil.get(renderRequest, "visibleChar", StringPool.BLANK);
        for (char i = 'A'; i <= 'Z'; i++)
        {
            glossaryRegionNavs = GlossaryRegionNavLocalServiceUtil.getAllRegionNavs(rgnId, chainCode, "Y", String.valueOf(i));

            if (!glossaryRegionNavs.isEmpty())
            {
                enableChars.append(i).append(StringPool.COMMA);
            }
            staticChars.add(String.valueOf(i));
        }
        if (enableChars.length() > 0)
        {
            enableChars = enableChars.deleteCharAt(enableChars.length() - 1);
        }
        if (Validator.isNull(visibleChar) && enableChars.length() > 0)
        {
            visibleChar =  DEFAULT_CHAR_ALL; //enableChars.substring(0, 1);
        }
        if (Validator.isNotNull(visibleChar))
        {
            if (DEFAULT_CHAR_ALL.equalsIgnoreCase(visibleChar))
            {
                glossaryRegionNavs = GlossaryRegionNavLocalServiceUtil.getAllRegionGlossaries(rgnId, chainCode, "Y");
            }
            else
            {
                glossaryRegionNavs = GlossaryRegionNavLocalServiceUtil.getAllRegionNavs(rgnId, chainCode, "Y", visibleChar);
            }

            if (glossaryRegionNavs.size() > 0)
            {
                Glossary glossary = null;
                GlossaryTranslate glossaryTranslate = null;
                for (GlossaryRegionNav regionNav : glossaryRegionNavs)
                {
                    if (DEFAULT_CHAR_ALL.equalsIgnoreCase(visibleChar))
                    {
                        try
                        {
                            glossary = GlossaryLocalServiceUtil.getGlossary(regionNav.getGlossaryId());
                        }
                        catch (PortalException e)
                        {
                            LOG.error(e.getMessage(), e);
                        }
                        catch (SystemException e)
                        {
                            LOG.error(e.getMessage(), e);
                        }
                    }
                    else
                    {
                        glossary = GlossaryLocalServiceUtil.getGlossaries(visibleChar, regionNav.getGlossaryId());
                        if (null == glossary)
                        {
                            glossary = GlossaryLocalServiceUtil.getGlossaries(visibleChar.toLowerCase(),
                                    regionNav.getGlossaryId());
                        }
                    }

                    if (Validator.isNotNull(glossary) && glossary.getActiveInd().equals("Y"))
                    {
                        glossaries.add(glossary);
                        if (Validator.isNotNull(langCode) && !DEFAULT_LOCALE.equalsIgnoreCase(langCode))
                        {
                            glossaryTranslate = GlossaryTranslateLocalServiceUtil.getGlossaryByLangCd(glossary.getGlossaryId(),
                                    langCode);
                            if (Validator.isNotNull(glossaryTranslate))
                            {
                                xGlossaries.put(glossary.getGlossaryId(), glossaryTranslate);
                            }
                        }
                    }
                }
            }
        }
        if (!DEFAULT_CHAR_ALL.equalsIgnoreCase(visibleChar))
        {
            sortList(glossaries);
        }
        renderRequest.setAttribute("enableChars", enableChars);
        renderRequest.setAttribute("staticChars", staticChars);
        renderRequest.setAttribute("activeChar", visibleChar);
        renderRequest.setAttribute("glossaries", glossaries);
        renderRequest.setAttribute("xGlossaries", xGlossaries);
        super.doView(renderRequest, renderResponse);
    }

    /**
     * method to sort the list.
     * 
     * @param glossaries Glossary List
     */
    private void sortList(List<Glossary> glossaries)
    {
        ListUtil.sort(glossaries, new Comparator<Glossary>()
        {
            public int compare(Glossary g1, Glossary g2)
            {
                return g1.getGlossaryTermText().compareTo(g2.getGlossaryTermText());
            }
        });
    }
}
