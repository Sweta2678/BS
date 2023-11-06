package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequestDispatcher;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.ihg.brandstandards.db.NoSuchStandardsRegionLocaleException;
import com.ihg.brandstandards.db.model.StandardsRegionLocale;
import com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class LanguageAdminController extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(LanguageAdminController.class);

    public void doView(RenderRequest request, RenderResponse renderResponse) throws IOException, PortletException
    {
        try
        {
            List<StandardsRegionLocale> regionLocaleList = StandardsRegionLocaleLocalServiceUtil
                    .getStandardsRegionLocales(-1, -1);
            List<String> showCheckedVals = new ArrayList<String>();
            for (StandardsRegionLocale regionLocaleListItem : regionLocaleList)
            {
                String regId = String.valueOf(regionLocaleListItem.getRegionId());
                String langId = regionLocaleListItem.getLocaleCode();
                showCheckedVals.add(regId + StringPool.DASH + langId);
            }
            request.setAttribute("showCheckedVals", showCheckedVals);
        }
        catch (SystemException e)
        {
            LOG.error("System Exception in Language Assign Portlet", e);
        }
        PortletRequestDispatcher rd = getPortletContext().getRequestDispatcher(viewTemplate);
        rd.include(request, renderResponse);
    }

    @ProcessAction(name = "saveLanguages")
    public void saveLanguages(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException
    {
        if (Validator.isNotNull(actionRequest.getParameter("selectedLang")))
        {
            String selectedLangArr[] = actionRequest.getParameter("selectedLang").split(StringPool.COMMA);
            List<String> showCheckedVals = new ArrayList<String>();
            StandardsRegionLocaleLocalServiceUtil.delAllRegionLocale();
            for (int i = 0; i < selectedLangArr.length; i++)
            {
                String regLangIds[] = selectedLangArr[i].split(StringPool.DASH);
                try
                {
                    StandardsRegionLocaleLocalServiceUtil.getLocaleByRegId(regLangIds[1], Long.valueOf(regLangIds[0]));
                }
                catch (NoSuchStandardsRegionLocaleException e)
                {
                    LOG.error("No such Region exception in Language Assign Portlet", e);
                    StandardsRegionLocale regionLocale = StandardsRegionLocaleLocalServiceUtil.getStandardsRegionLocaleObject();
                    regionLocale.setRegionId(Long.valueOf(regLangIds[0]));
                    regionLocale.setLocaleCode(regLangIds[1]);
                    regionLocale.setIsDefault("Y");
                    regionLocale.setCreatorId(String.valueOf(PortalUtil.getUserId(actionRequest)));
                    regionLocale.setCreatedDate(new Date());
                    regionLocale.setUpdatedBy(String.valueOf(PortalUtil.getUserId(actionRequest)));
                    regionLocale.setUpdatedDate(new Date());
                    try
                    {
                        StandardsRegionLocaleLocalServiceUtil.addStandardsRegionLocale(regionLocale);
                        String regId = String.valueOf(Long.valueOf(regLangIds[0]));
                        String langId = regLangIds[1];
                        showCheckedVals.add(regId + StringPool.DASH + langId);
                    }
                    catch (SystemException e1)
                    {
                        LOG.error("System Exception in Language Assign Portlet", e);
                    }
                }
                catch (NumberFormatException e)
                {
                    LOG.error("Number Format Exception in Language Assign Portlet", e);
                }
                catch (SystemException e)
                {
                    LOG.error("System Exception in Language Assign Portlet", e);
                }
            }
        }
    }

}
