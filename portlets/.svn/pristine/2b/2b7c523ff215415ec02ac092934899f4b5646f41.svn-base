package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
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

import com.ihg.brandstandards.bsadmin.model.GlossaryTranslationView;
import com.ihg.brandstandards.db.NoSuchGlossaryTranslateException;
import com.ihg.brandstandards.db.model.Glossary;
import com.ihg.brandstandards.db.model.GlossaryTranslate;
import com.ihg.brandstandards.db.model.StandardsLocale;
import com.ihg.brandstandards.db.service.GlossaryLocalServiceUtil;
import com.ihg.brandstandards.db.service.GlossaryTranslateLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.util.GlossaryUtil;
import com.liferay.counter.service.CounterLocalServiceUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class TranslationController extends MVCPortlet
{

    private static final Log LOG = LogFactoryUtil.getLog(TranslationController.class);

    /* (non-Javadoc)
     * @see com.liferay.util.bridges.mvc.MVCPortlet#doView(javax.portlet.RenderRequest, javax.portlet.RenderResponse)
     */
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        final long userId = PortalUtil.getUserId(renderRequest);
        if (userId < 1)
        {
            renderRequest.setAttribute("notLoggedIn", true);
        }
        else
        {
            try
            {
                final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil
                        .getHttpServletRequest(renderRequest));
                String visibleChar = httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR);
                GlossaryTranslationView xlaxVO = prepareRequest(httpReq);
                renderRequest.setAttribute("visibleChar", visibleChar);
                renderRequest.setAttribute(GlossaryUtil.GLOSSARY_TRANSLATION_VIEW, xlaxVO);
            }
            catch (Exception exc)
            {
                LOG.error(exc.getMessage());
                renderRequest.setAttribute("errorMessage", exc.getMessage());
            }
        }
        super.doView(renderRequest, renderResponse);
    }

    private GlossaryTranslationView prepareRequest(final HttpServletRequest httpReq) throws SystemException, PortalException
    {

        GlossaryTranslationView xlatTO = null;
        if (!GlossaryUtil.IsNullOrBlank(httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID)))
        {
            xlatTO = new GlossaryTranslationView();
            String glossaryIdStr = httpReq.getParameter(GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID);
            long glossaryId = Long.parseLong(glossaryIdStr);
            List<StandardsLocale> locales = StandardsLocaleLocalServiceUtil.getBrandStandardsLocale();
            Glossary glossary = GlossaryLocalServiceUtil.getGlossary(glossaryId);
            List<GlossaryTranslate> glossarries = GlossaryTranslateLocalServiceUtil.getGlossarriesByGlossaryId(glossaryId);
            Map<StandardsLocale, GlossaryTranslate> translations = new HashMap<StandardsLocale, GlossaryTranslate>();
            if (GlossaryUtil.isNullOrBlank(glossarries))
            {
                glossarries = new ArrayList<GlossaryTranslate>();
            }
            for (StandardsLocale locale : locales)
            {
                boolean bFound = false;
                for (GlossaryTranslate xlatObj : glossarries)
                {
                    if (xlatObj.getLangCode().equals(locale.getLocaleCode()))
                    {
                        bFound = true;
                        translations.put(locale, xlatObj);
                        break;
                    }
                }
                if (!bFound)
                {
                    translations.put(locale, null);
                }
            }
            xlatTO.setGlossary(glossary);
            xlatTO.setGlossaryTranslations(translations);
        }
        return xlatTO;
    }

    @Override
    public void serveResource(ResourceRequest request, ResourceResponse response) throws IOException, PortletException
    {
        final String resourceID = request.getResourceID();
        String message = GlossaryUtil.TRANSLATION_SUCCESS_MESSAGE;
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(request));

        if ("SaveTranslation".equals(resourceID))
        {
            final long userId = PortalUtil.getUserId(request);
            try
            {
                saveTranslation(httpRequest, userId);
            }
            catch (Exception exc)
            {
                message = exc.getMessage();
            }
            final PrintWriter writer = response.getWriter();
            writer.print(message);
        }
        else if ("RefreshTranslation".equals(resourceID))
        {
            final PrintWriter writer = response.getWriter();
            writer.print(message);
        }
    }

    public void saveTranslation(HttpServletRequest request, long userId) throws Exception
    {
        String glossaryIdStr = request.getParameter("glossaryId");
        long glossaryId = Long.valueOf(glossaryIdStr);
        String locale = request.getParameter("locale");
        if (locale == null || request.getParameter(locale + "Term") == null)
        {
            throw new Exception("Failed to Process Translation");
        }
        String term = request.getParameter(locale + "Term");
        String definition = request.getParameter(locale + "Definition");
        GlossaryTranslate glossaryTranslate = null;
        try
        {
            glossaryTranslate = GlossaryTranslateLocalServiceUtil.getByGlossaryIdLocaleCode(glossaryId, locale);
        }
        catch (NoSuchGlossaryTranslateException exc)
        {
            LOG.info("Translation Doesn't existing, adding new....: " + exc.getMessage());
        }
        if (glossaryTranslate == null)
        {
            long glossaryXlatId = CounterLocalServiceUtil.increment(GlossaryTranslate.class.getName());
            glossaryTranslate = GlossaryTranslateLocalServiceUtil.createGlossaryTranslate(glossaryXlatId);
            glossaryTranslate.setCreatorId("" + userId);
            glossaryTranslate.setCreatedDate(new Date());
        }
        glossaryTranslate.setLangCode(locale);
        glossaryTranslate.setGlossaryId(glossaryId);
        glossaryTranslate.setGlossaryTermText(term);
        glossaryTranslate.setGlossaryTermDesc(definition);
        glossaryTranslate.setIsValidTermTxt("Y");
        glossaryTranslate.setIsValidDescTxt("Y");
        glossaryTranslate.setUpdatedBy("" + userId);
        glossaryTranslate.setUpdatedDate(new Date());
        GlossaryTranslateLocalServiceUtil.updateGlossaryTranslate(glossaryTranslate);
    }
}
