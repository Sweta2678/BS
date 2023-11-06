/**
 * ©2014 IHG. All rights reserved.
 */
package com.ihg.brandstandards.portlet;

import java.io.File;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletRequest;
import javax.portlet.PortletSession;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.xml.bind.JAXBException;

import org.apache.commons.fileupload.portlet.PortletFileUpload;
import org.apache.commons.fileupload.servlet.ServletRequestContext;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Workbook;

import com.ihg.brandstandards.db.model.UIElement;
import com.ihg.brandstandards.db.model.UIElementTranslate;
import com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil;
import com.ihg.brandstandards.db.service.UIElementLocalServiceUtil;
import com.ihg.brandstandards.db.service.UIElementTranslateLocalServiceUtil;
import com.ihg.brandstandards.spreadsheet.UIElementProcessXLSFile;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.GlossaryUtil;
import com.ihg.brandstandards.util.UIElementPortletUtil;
import com.ihg.brandstandards.bsadmin.model.BadCell;
import com.ihg.brandstandards.bsadmin.model.Record;
import com.ihg.brandstandards.bsadmin.model.UIElementData;
import com.ihg.brandstandards.custom.model.Preferences;
import com.ihg.brandstandards.util.UserPreferencesUtil;
import com.ihg.brandstandards.util.BSAdminConstants;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONArray;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.upload.UploadPortletRequest;
import com.liferay.portal.kernel.util.FileUtil;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.MimeTypesUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.ProgressTracker;
import com.liferay.portal.kernel.util.ProgressTrackerThreadLocal;
import com.liferay.portal.kernel.util.PropertiesParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.UnicodeProperties;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLAppLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.portlet.documentlibrary.service.DLFolderLocalServiceUtil;
import com.liferay.portlet.dynamicdatamapping.storage.Fields;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

/**
 * <a href="UIElementPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class UIElementPortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(UIElementPortlet.class);

    protected String addUIElementJSP;
    protected String editUIElementJSP;
    protected String importUIElementJSP;
    protected String exportUIElementJSP;

    @Override
    public void init() throws PortletException
    {
        super.init();
        addUIElementJSP = getInitParameter("add-element-jsp");
        editUIElementJSP = getInitParameter("edit-element-jsp");
        importUIElementJSP = getInitParameter("import-element-jsp");
        exportUIElementJSP = getInitParameter("export-element-jsp");
    }

    @SuppressWarnings("unchecked")
    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException
    {
        HttpServletRequest request = getHttpServletRequest(renderRequest);
        final SearchContext searchContext = SearchContextFactory.getInstance(request);
        PortletSession session = renderRequest.getPortletSession();
        ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
        final PortletURL portletURL = renderResponse.createRenderURL();
        boolean isElementContextAdmin = false;
        boolean isElementTechAdmin = false;
        
        String selElementValue = (String) session.getAttribute("selElementValue");
        String selSearchLanguage = (String) session.getAttribute("selSearchLanguage");
        String selElementKey = (String) session.getAttribute("selElementKey");
        String selSecondLanguage = (String) session.getAttribute("selSecondLanguage");
        String displaySecondLanguage = "Second Language";
        String selModuleNames = (String) session.getAttribute("selModuleNames");
        String[] selSearchModuleNames = (String[])session.getAttribute("selSearchModuleNames");
        
        Map<String, String> activeLanguages = new LinkedHashMap<String, String>();
        Map<String, String> activeSecondLanguages = new LinkedHashMap<String, String>();
        try
        {
            isElementContextAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("uielement.content.admin.role"), false);
            isElementTechAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("uielement.tech.admin.role"), false);
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        try
        {
            renderRequest.setAttribute("isElementContextAdmin", isElementContextAdmin);
            renderRequest.setAttribute("isElementTechAdmin", isElementTechAdmin);

            if (isElementContextAdmin || isElementTechAdmin)
            {
                if (Validator.isNotNull(session.getAttribute("activeLanguagesMap")))
                {
                    activeLanguages = (Map<String, String>) session.getAttribute("activeLanguagesMap");
                }
                else
                {
                    activeLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(BSAdminConstants.ACTIVE_LANG_QUERY);
                    session.setAttribute("activeLanguagesMap", activeLanguages);
                }

                if (Validator.isNotNull(session.getAttribute("activeSecondLanguagesMap")))
                {
                    activeSecondLanguages = (Map<String, String>) session.getAttribute("activeSecondLanguagesMap");
                }
                else
                {
                    activeSecondLanguages = StandardsLocaleLocalServiceUtil
                            .getActiveLanguages(BSAdminConstants.ACTIVE_SECOND_LANG_QUERY);
                    session.setAttribute("activeSecondLanguagesMap", activeSecondLanguages);
                }
                renderRequest.setAttribute("activeLanguages", activeLanguages.entrySet());
                renderRequest.setAttribute("activeSecondLanguages", activeSecondLanguages.entrySet());

                if (Validator.isNotNull(session.getAttribute("usedInOptions")))
                {
                    renderRequest.setAttribute("usedInOptions", session.getAttribute("usedInOptions"));
                }
                else
                {
                    session.setAttribute("usedInOptions", getUsedInOptionsMap());
                    renderRequest.setAttribute("usedInOptions", getUsedInOptionsMap());
                }
                
                List<UIElementData> uiElementsData = new ArrayList<UIElementData>();
                if (renderRequest.getAttribute("searchResults") != null)
                {
                    uiElementsData = (List<UIElementData>) renderRequest.getAttribute("searchResults");
                }
                else if(Validator.isNotNull(selElementKey) || Validator.isNotNull(selElementValue) ||
                        Validator.isNotNull(selSearchModuleNames))
                {
                    try
                    {
                        uiElementsData = UIElementPortletUtil.searchUIElement(selElementValue, selSearchLanguage, selElementKey,
                                selSecondLanguage, selSearchModuleNames);
                    }
                    catch (Exception e)
                    {
                        LOG.error("Failed while UI Element search:", e);
                    }
                }
                else
                {
                    //uiElementsData = UIElementPortletUtil.getAllUIElements(selSecondLanguage);
                    try
                    {
                        uiElementsData = UIElementPortletUtil.searchUIElement(null, "en_GB", null, selSecondLanguage, null);
                    }
                    catch (Exception e)
                    {
                        LOG.error("Failed while UI Element search:", e);
                    }
                }

                try
                {
                    renderRequest.setAttribute("availableElementKeys", UIElementLocalServiceUtil
                            .loadAutoCompleteKeys(BSAdminConstants.AUTO_COMPLETE_ELEMENT_KEYS_QUERY));
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                    LOG.error(e, e);
                }
                renderRequest.setAttribute("uiElements", uiElementsData);

                SearchContainer<UIElementData> searchContainer = getSearchContainer(renderRequest, portletURL, request);
                searchContext.setStart(searchContainer.getStart());
                searchContext.setEnd(searchContainer.getEnd());
                searchContainer.setTotal(uiElementsData.size());
                uiElementsData = ListUtil.subList(uiElementsData, searchContainer.getStart(), searchContainer.getEnd());
                searchContainer.setResults(uiElementsData);
                renderRequest.setAttribute("searchContainer", searchContainer);
                String elementId = (String) renderRequest.getParameter("elementId");
                if (Validator.isNotNull(elementId))
                {
                    UIElementData uiElementData = UIElementPortletUtil.getUIElementById(Long.parseLong(elementId));
                    renderRequest.setAttribute("editUIElement", uiElementData);
                    renderRequest.setAttribute("showEditElementDialog", true);
                }
                if (Validator.isNotNull(selSecondLanguage) && !selSecondLanguage.equalsIgnoreCase(displaySecondLanguage))
                {
                    displaySecondLanguage = activeLanguages.get(selSecondLanguage);
                }
                
                renderRequest.setAttribute("elementValue", selElementValue);
                renderRequest.setAttribute("searchLanguage", selSearchLanguage);
                renderRequest.setAttribute("elementKey", selElementKey);
                renderRequest.setAttribute("secondLanguage", selSecondLanguage);
                renderRequest.setAttribute("selSecondLanguage", displaySecondLanguage);
                renderRequest.setAttribute("moduleNames", selModuleNames);
            }
            
            include(viewTemplate, renderRequest, renderResponse);
        }
        catch (Exception e)
        {
            LOG.error(e, e);
        }
    }

    /**
     * Get Search Container for pagination grid.
     * @param request request
     * @param portletURL portlet URL
     * @param httpRequest  http request
     * @return SearchContainer
     */
    private SearchContainer<UIElementData> getSearchContainer(RenderRequest request, final PortletURL portletURL,
            final HttpServletRequest httpRequest)
    {
        SearchContainer<UIElementData> searchContainer;
        final HttpSession session = httpRequest.getSession();
        int prefRecPerPage = 0;
        Preferences preferences = (Preferences) session.getAttribute("Preferences");
        if (preferences != null)
        {
            prefRecPerPage = preferences.getItemsPerPage();
        }
        int recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : 
            Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE));
        if (recPerPage == 0 && request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null)
        {
            recPerPage = Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_DELTA_PARAM));
        }
        // first time loading page
        else if (recPerPage == 0)
        {
            recPerPage = prefRecPerPage;
        }

        int pageNum = request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? 0 : 
            Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        if (pageNum == 0)
        {
            pageNum = request.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? 1 : 
                Integer.parseInt(request.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
        }

        if (prefRecPerPage != recPerPage)
        {
            UserPreferencesUtil.updateItemsPerPage(request, recPerPage);
            recPerPage = prefRecPerPage;
        }
        searchContainer = new SearchContainer<UIElementData>(request, null, null, SearchContainer.DEFAULT_CUR_PARAM,
                recPerPage, portletURL, null, "no-entries-were-found-that-matched-the-keywords-x");
        
        return searchContainer;
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @SuppressWarnings("unchecked")
    @ProcessAction(name = "processSave")
    public void processSave(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
        String elementKey = ParamUtil.getString(actionRequest, "addElementKey");
        StringBuffer moduleName = new StringBuffer();
        String moduleNames[] = actionRequest.getParameterValues("addSelectModule");
        if (moduleNames != null)
        {
            for (String module : moduleNames)
            {
                if (!moduleName.toString().isEmpty())
                {
                    moduleName.append(",");
                }
                moduleName.append(module.trim());
            }
        }
        try
        {
            UIElement uiElement = UIElementLocalServiceUtil.getUIElementObject();
            uiElement.setElementKey(elementKey);
            uiElement.setModuleName(moduleName.toString());
            uiElement.setCreatorId(String.valueOf(themeDisplay.getUserId()));
            uiElement.setCreatedDate(new Date());
            uiElement.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
            uiElement.setUpdatedDate(new Date());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("ElementId=" + uiElement.getElementId() + " ElementKey=" + uiElement.getElementKey() + " UsedIn="
                        + uiElement.getModuleName());
            }
            uiElement = UIElementLocalServiceUtil.addNewUIElementKey(uiElement);
            for (Entry<String, String[]> entry : (Set<Entry<String, String[]>>) httpRequest.getParameterMap().entrySet())
            {
                if (entry.getKey().startsWith("language_") && entry.getValue().length > 0
                        && Validator.isNotNull(entry.getValue()[0]))
                {
                    UIElementTranslate uiElementTranslate = UIElementTranslateLocalServiceUtil.getUIElementTranslateObject();
                    uiElementTranslate.setElementId(uiElement.getElementId());
                    uiElementTranslate.setLocaleCode(String.valueOf(entry.getKey()).replaceFirst("language_", ""));
                    uiElementTranslate.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                    uiElementTranslate.setCreatedDate(new Date());
                    uiElementTranslate.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                    uiElementTranslate.setUpdatedDate(new Date());
                    uiElementTranslate.setElementValue(String.valueOf(entry.getValue()[0]));
                    if (LOG.isDebugEnabled())
                    {
                        LOG.debug("ElementId=" + uiElement.getElementId() + " ElementKey=" + entry.getKey() + "---"
                                + uiElementTranslate.getElementValue());
                    }
                    UIElementTranslateLocalServiceUtil.addUIElementTranslate(uiElementTranslate);
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("Failed while Saving UI Element:", e);
            throw new PortletException("Failed to add UI Element");
        }
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @SuppressWarnings("unchecked")
    @ProcessAction(name = "processEdit")
    public void processEdit(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest));
        String elementId = ParamUtil.getString(actionRequest, "elementId");
        StringBuffer moduleName = new StringBuffer();
        String moduleNames[] = actionRequest.getParameterValues("editSelectModule");
        if (moduleNames != null)
        {
            for (String module : moduleNames)
            {
                if (!moduleName.toString().isEmpty())
                {
                    moduleName.append(",");
                }
                moduleName.append(module.trim());
            }
        }
        try
        {
            UIElement uiElement = UIElementLocalServiceUtil.getUIElement(Long.parseLong(elementId));
            if (Validator.isNotNull(moduleName.toString()))
            {
                uiElement.setModuleName(moduleName.toString());
            }
            uiElement.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
            uiElement.setUpdatedDate(new Date());
            if (LOG.isDebugEnabled())
            {
                LOG.debug("ElementId=" + uiElement.getElementId() + " ElementKey=" + uiElement.getElementKey() + " UsedIn="
                        + uiElement.getModuleName());
            }
            UIElementLocalServiceUtil.updateUIElement(uiElement);
            List<UIElementTranslate> uiElementTranslations = UIElementTranslateLocalServiceUtil.getByElementId(uiElement
                    .getElementId());
            for (Entry<String, String[]> entry : (Set<Entry<String, String[]>>) httpRequest.getParameterMap().entrySet())
            {
                if (entry.getKey().startsWith("language_"))
                {
                    boolean isNewLangauge = true;
                    for (UIElementTranslate translation : uiElementTranslations)
                    {
                        if (String.valueOf(entry.getKey()).replaceFirst("language_", "")
                                .equalsIgnoreCase(translation.getLocaleCode()))
                        {
                            if (entry.getValue().length > 0 && Validator.isNotNull(entry.getValue()[0]))
                            {
                                translation.setElementValue(entry.getValue()[0]);
                                translation.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                                translation.setUpdatedDate(new Date());
                                if (LOG.isDebugEnabled())
                                {
                                    LOG.debug("ElementId=" + uiElement.getElementId() + " ElementKey=" + entry.getKey()
                                            + " Element Value:" + translation.getElementValue());
                                }
                                UIElementTranslateLocalServiceUtil.updateUIElementTranslate(translation);
                            }
                            else
                            {
                                if (LOG.isDebugEnabled())
                                {
                                    LOG.debug("Deleting Non Translated values while edit. ElementId="
                                            + translation.getElementId() + " Locale Code=" + translation.getLocaleCode()
                                            + " Element Value:" + translation.getElementValue());
                                }
                                UIElementTranslateLocalServiceUtil.deleteUIElementTranslate(translation);
                            }

                            isNewLangauge = false;
                            break;
                        }
                    }

                    if (isNewLangauge && entry.getValue().length > 0 && Validator.isNotNull(entry.getValue()[0]))
                    {
                        UIElementTranslate uiElementTranslate = UIElementTranslateLocalServiceUtil.getUIElementTranslateObject();
                        uiElementTranslate.setElementId(uiElement.getElementId());
                        uiElementTranslate.setLocaleCode(String.valueOf(entry.getKey()).replaceFirst("language_", ""));
                        uiElementTranslate.setElementValue(entry.getValue()[0]);
                        uiElementTranslate.setCreatorId(String.valueOf(themeDisplay.getUserId()));
                        uiElementTranslate.setCreatedDate(new Date());
                        uiElementTranslate.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
                        uiElementTranslate.setUpdatedDate(new Date());
                        if (LOG.isDebugEnabled())
                        {
                            LOG.debug("ElementId=" + uiElement.getElementId() + " ElementKey=" + entry.getKey()
                                    + " Element Value:" + uiElementTranslate.getElementValue());
                        }
                        UIElementTranslateLocalServiceUtil.addUIElementTranslate(uiElementTranslate);
                    }
                }
            }
        }
        catch (Exception e)
        {
            LOG.error("Failed while Editing UI Element with element Id:" + elementId, e);
            throw new PortletException("Failed to save UI Element data while edit.");
        }
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @ProcessAction(name = "processSearch")
    public void processSearch(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {   
        PortletSession session = actionRequest.getPortletSession();
        String elementValue = ParamUtil.getString(actionRequest, "elementValue");
        String searchLanguage = ParamUtil.getString(actionRequest, "searchLanguage");
        String elementKey = ParamUtil.getString(actionRequest, "elementKey");
        String secondLanguage = ParamUtil.getString(actionRequest, "secondLanguage");
        String moduleNames[] = actionRequest.getParameterValues("usedIn");
        try
        {
            List<UIElementData> searchResults = UIElementPortletUtil.searchUIElement(elementValue, searchLanguage, elementKey,
                    secondLanguage, moduleNames);
            actionRequest.setAttribute("searchResults", searchResults);
        }
        catch (Exception e)
        {
            LOG.error("Failed while UI Element search:", e);
        }
        StringBuffer selModules = new StringBuffer();
        if (moduleNames != null)
        {
            for (String module : moduleNames)
            {
                if (!selModules.toString().isEmpty())
                {
                    selModules.append(",");
                }
                selModules.append(module.trim());
            }
        }
        session.setAttribute("selElementValue", elementValue);
        session.setAttribute("selSearchLanguage", searchLanguage);
        session.setAttribute("selElementKey", elementKey);
        session.setAttribute("selSecondLanguage", secondLanguage);
        session.setAttribute("selModuleNames", selModules.toString());
        session.setAttribute("selSearchModuleNames", moduleNames);
    }

    /**
     * @param actionRequest
     * @param actionResponse
     * @throws IOException
     * @throws PortletException
     */
    @ProcessAction(name = "clearSearch")
    public void clearSearch(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException
    {
        PortletSession session = actionRequest.getPortletSession();
        String searchLanguage = ParamUtil.getString(actionRequest, "searchLanguage");
        
        session.removeAttribute("selElementValue");
        session.setAttribute("selSearchLanguage", searchLanguage);
        session.removeAttribute("selElementKey");
        session.removeAttribute("selSecondLanguage");
        session.removeAttribute("selModuleNames");
        session.removeAttribute("selSearchModuleNames");
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException
    {
        PortletSession session = resourceRequest.getPortletSession();
        Map<String, String> activeLanguages = new LinkedHashMap<String, String>();
        ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
        String modalType = (String) resourceRequest.getParameter("modalType");
        HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
        boolean isElementContextAdmin = false;
        boolean isElementTechAdmin = false;
        try
        {
            isElementContextAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("uielement.content.admin.role"), false);
            isElementTechAdmin = RoleLocalServiceUtil.hasUserRole(themeDisplay.getUserId(), themeDisplay.getCompanyId(),
                    PortletProps.get("uielement.tech.admin.role"), false);
            if (Validator.isNotNull(session.getAttribute("activeLanguages")))
            {
                activeLanguages = (Map<String, String>) session.getAttribute("activeLanguagesMap");
            }
            else
            {
                activeLanguages = StandardsLocaleLocalServiceUtil.getActiveLanguages(BSAdminConstants.ACTIVE_LANG_QUERY);
                session.setAttribute("activeLanguagesMap", activeLanguages);
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
        resourceRequest.setAttribute("isElementContextAdmin", isElementContextAdmin);
        resourceRequest.setAttribute("isElementTechAdmin", isElementTechAdmin);

        try
        {
            resourceRequest.setAttribute("activeLanguages",
                    StandardsLocaleLocalServiceUtil.getActiveLanguages(BSAdminConstants.ACTIVE_LANG_QUERY).entrySet());
            resourceRequest.setAttribute("activeSecondLanguages",
                    StandardsLocaleLocalServiceUtil.getActiveLanguages(BSAdminConstants.ACTIVE_SECOND_LANG_QUERY).entrySet());
            if (Validator.isNotNull(session.getAttribute("usedInOptions")))
            {
                resourceRequest.setAttribute("usedInOptions", session.getAttribute("usedInOptions"));
            }
            else
            {
                session.setAttribute("usedInOptions", getUsedInOptionsMap());
                resourceRequest.setAttribute("usedInOptions", getUsedInOptionsMap());
            }

            if ("addElement".equalsIgnoreCase(modalType))
            {
                include(addUIElementJSP, resourceRequest, resourceResponse);
            }
            else if ("editElement".equalsIgnoreCase(modalType))
            {
                String elementId = (String) resourceRequest.getParameter("elementId");
                UIElementData uiElementData = UIElementPortletUtil.getUIElementById(Long.parseLong(elementId));
                resourceRequest.setAttribute("editUIElement", uiElementData);
                httpRequest.setAttribute("editUIElement", uiElementData);
                include(editUIElementJSP, resourceRequest, resourceResponse);
            }
            else if ("validateKey".equalsIgnoreCase(modalType))
            {
                String elementKey = resourceRequest.getParameter("addElementKey");
                boolean elementExist = false;
                String returnMsg = "Element Exist";
                if (Validator.isNotNull(elementKey))
                {
                    try
                    {
                        UIElement element = UIElementLocalServiceUtil.getByElementKey(elementKey);
                        if (element != null)
                        {
                            elementExist = true;
                        }
                    }
                    catch (Exception e)
                    {
                        elementExist = false;
                    }
                }
                else
                {
                    elementExist = true;
                    returnMsg = "Invalid Key";
                }

                if (elementExist)
                {
                    resourceResponse.getWriter().write(returnMsg);
                }
            }
            else if ("importElementPopup".equalsIgnoreCase(modalType))
            {
                String importIdExl = resourceRequest.getParameter("importElemProgressId");
                session.setAttribute(ProgressTracker.PERCENT + importIdExl, 0, PortletSession.APPLICATION_SCOPE);
                resourceRequest.setAttribute("importElemProgressId", importIdExl);
                include(importUIElementJSP, resourceRequest, resourceResponse);
            }
            else if ("exportElement".equalsIgnoreCase(modalType))
            {
                include(exportUIElementJSP, resourceRequest, resourceResponse);
            }
            else if ("exportElementsToXLS".equalsIgnoreCase(modalType))
            {
                try
                {
                    String secondLangCode = resourceRequest.getParameter("exportLanguage");
                    boolean exportUsedIn = Boolean.parseBoolean(resourceRequest.getParameter("exportUsedIn"));
                    String moduleNames[] = {};
                    if (resourceRequest.getParameter("exportModule") != null)
                    {
                        moduleNames = resourceRequest.getParameter("exportModule").split(",");
                    }
                    final Workbook workbook = UIElementPortletUtil.exportUIElements(secondLangCode,
                            activeLanguages.get(secondLangCode), moduleNames, exportUsedIn);

                    resourceResponse.setContentType("application/vnd.ms-excel");
                    resourceResponse.addProperty("Content-Disposition", "attachment; filename=UI_Elements_Translations_" + secondLangCode
                            + ".xls");

                    final OutputStream outputStream = resourceResponse.getPortletOutputStream();
                    workbook.write(outputStream);
                    outputStream.flush();
                    outputStream.close();
                }
                catch (Exception e)
                {
                    LOG.error(e);
                }
            }
            else if ("importElementsFromXLS".equalsIgnoreCase(modalType))
            {
                String json = "";
                String localeCode = "";
                PrintWriter out = resourceResponse.getWriter();
                JSONObject recordsjsonObject = JSONFactoryUtil.createJSONObject();
                ProgressTracker progressTracker = null;
                final boolean isMultipart = PortletFileUpload.isMultipartContent(new ServletRequestContext(httpRequest));
                UploadPortletRequest uploadRequest = null;
                try
                {
                    if (isMultipart)
                    {
                        uploadRequest = PortalUtil.getUploadPortletRequest(resourceRequest);
                        localeCode = ParamUtil.getString(uploadRequest, "importLanguage");
                        String importLanguage = "(" + localeCode + ")" + activeLanguages.get(localeCode);
                        String importElemProgressId = ParamUtil.getString(uploadRequest, "importElemProgressId");
                        progressTracker = new ProgressTracker(importElemProgressId);
                        ProgressTrackerThreadLocal.setProgressTracker(progressTracker);
                        progressTracker.start(resourceRequest);
                        recordsjsonObject = readExcelFile(uploadRequest, resourceRequest, progressTracker,
                                importLanguage);
                    }
                }
                catch (Exception e)
                {
                    LOG.error(e.getMessage(), e);
                    json = "{" + "\"response\": \"Failure\", " + "\"message\": \"Exception - :" + e.getMessage() + "\"}";
                    out.print(json);
                    out.flush();
                    out.close();
                    e.printStackTrace();
                }
                finally
                {
                    if (progressTracker != null)
                    {
                        progressTracker.finish(resourceRequest);
                    }
                }
                
                if ((recordsjsonObject != null) && (recordsjsonObject.length() > 0))
                {
                    resourceResponse.getWriter().print(recordsjsonObject.toString());
                }
                else
                {
                    storeFileToLiferayDL(uploadRequest, resourceRequest, themeDisplay);
                    json = "{" + "\"response\": \"Success\", " + "\"locale\": \"" + localeCode + "\", "
                            + "\"message\": \"Records updated successfully.\"}";
                    out.print(json);
                    out.flush();
                    out.close();
                }
            }
        }
        catch (Exception e)
        {
            LOG.error(e);
        }
    }

    /**
     * @return Set<Entry<String, String>>
     */
    public Set<Entry<String, String>> getUsedInOptionsMap()
    {
        Map<String, String> usedInOptions = new LinkedHashMap<String, String>();
        String usedInOptionLabels[] = PortletProps.get("bs.usedin.options.labels").split(StringPool.COMMA);
        String usedInOptionValues[] = PortletProps.get("bs.usedin.options.values").split(StringPool.COMMA);
        int itr = 0;
        for (String option : usedInOptionLabels)
        {
            usedInOptions.put(usedInOptionValues[itr], option);
            itr++;
        }
        return usedInOptions.entrySet();
    }
    
    /**
     * @param portletRequest The PortletRequest object
     * @return HttpServletRequest
     */
    public HttpServletRequest getHttpServletRequest(PortletRequest portletRequest)
    {
        HttpServletRequest httpServletRequest = PortalUtil.getHttpServletRequest(portletRequest);
        return PortalUtil.getOriginalServletRequest(httpServletRequest);
    }
    
    /**
     * @param uploadRequest  The upload request
     * @param resourceRequest  The resource request
     * @param progressTracker  The progressTracker
     * @param importLanguge  The import language
     * @return JSONObject
     * @throws InvalidFormatException
     * @throws JAXBException
     * @throws PortalException
     * @throws SystemException
     * @throws IOException
     */
    public JSONObject readExcelFile(UploadPortletRequest uploadRequest, PortletRequest resourceRequest, ProgressTracker progressTracker, String importLanguge) throws InvalidFormatException, JAXBException, PortalException,
            SystemException, IOException
    {
        JSONObject recordsjsonObject = null;
        String fileName = uploadRequest.getFileName("file");
        String localeCode = ParamUtil.getString(uploadRequest, "importLanguage");
        if ((fileName == null) || "".equals(fileName))
        {
            throw new IOException("No file is selected. Please browse file again!");
        }
        boolean importUsedInFromExcel = uploadRequest.getParameter("importUsedIn") != null ? true : false;
        StringBuffer moduleName = new StringBuffer();
        String moduleNames[] = uploadRequest.getParameterValues("importModule");
        if (moduleNames != null)
        {
            for (String module : moduleNames)
            {
                if (!moduleName.toString().isEmpty())
                {
                    moduleName.append(",");
                }
                moduleName.append(module.trim());
            }
        }
        File file = uploadRequest.getFile("file");
        List<String> uiElementKeys = UIElementLocalServiceUtil
                .getElementsKeyList(BSAdminConstants.AUTO_COMPLETE_ELEMENT_KEYS_QUERY);
        boolean autoCreateElements = Boolean.parseBoolean(PortletProps.get("uielement.import.create.missing.keys"));
        UIElementProcessXLSFile processXlsFile = new UIElementProcessXLSFile();
        List<Record> records = processXlsFile.processUIElementXls(file, progressTracker, uiElementKeys, importUsedInFromExcel,
                localeCode, importLanguge, autoCreateElements);
        List<Record> badRecords = processXlsFile.getBadRows(records);
        if (badRecords.size() > 0)
        {
            //return it in GUI
            recordsjsonObject = JSONFactoryUtil.createJSONObject();
            int percentage = GlossaryUtil.MAGIC_FIFTY;
            int oldPercentage = GlossaryUtil.MAGIC_FIFTY;
            JSONArray rowjsonObject = null;
            JSONObject cell = null;
            JSONArray recordsjsonArray = JSONFactoryUtil.createJSONArray();
            recordsjsonObject.put("page", "1");
            double totalPages = Math.ceil(badRecords.size() / (double) GlossaryUtil.MAGIC_TEN);
            recordsjsonObject.put("total", String.valueOf(totalPages));
            recordsjsonObject.put("records ", String.valueOf(badRecords.size()));
            if (!badRecords.isEmpty())
            {
                for (int i = 0; i < badRecords.size(); i++)
                {

                    Record record = badRecords.get(i);
                    rowjsonObject = JSONFactoryUtil.createJSONArray();
                    cell = JSONFactoryUtil.createJSONObject();
                    rowjsonObject.put(String.valueOf(record.getId()));
                    List<BadCell> cells = record.getBadCell();
                    for (BadCell cell1 : cells)
                    {
                        LOG.error("Row = " + cell1.getRow() + "' column name = '" + cell1.getColumnName() + "' worksheet = '"
                                + cell1.getWorksheet() + "' error message = '" + cell1.getErrorMessage() + "' value = '"
                                + cell1.getValue() + "'");
                        rowjsonObject.put(String.valueOf(cell1.getRow()));
                        rowjsonObject.put(String.valueOf(cell1.getColumnName()));
                        rowjsonObject.put(String.valueOf(cell1.getValue()));
                        rowjsonObject.put(String.valueOf(cell1.getErrorMessage()));
                    }

                    cell.put("id", String.valueOf(record.getId()));
                    cell.put("cell", rowjsonObject);
                    recordsjsonArray.put(cell);
                    percentage = Math.min(GlossaryUtil.MAGIC_FIFTY + (i * GlossaryUtil.MAGIC_HUNDRED) / badRecords.size(),
                            GlossaryUtil.MAGIC_HUNDRED);
                    if (oldPercentage != percentage)
                    {
                        progressTracker.setPercent(percentage);
                    }
                    oldPercentage = percentage;
                }
                recordsjsonObject.put("rows", recordsjsonArray);
            }
        }
        else
        {
            UIElementPortletUtil elementUtil = new UIElementPortletUtil();
            elementUtil.updateTranslations(resourceRequest, records, localeCode, progressTracker, importUsedInFromExcel,
                    moduleName.toString());
        }
        return recordsjsonObject;
    }
    
    /**
     * @param uploadRequest The upload request Object
     * @param portletRequest The portlet request Object
     * @param themeDisplay ThemeDisplay Object
     */
    public void storeFileToLiferayDL(UploadPortletRequest uploadRequest, PortletRequest portletRequest, ThemeDisplay themeDisplay)
    {
        DateFormat formatter = new SimpleDateFormat("MMM_dd_yy_HH-mmaaa_");
        File file = uploadRequest.getFile("file");
        String fileName = uploadRequest.getFileName("file");
        fileName = formatter.format(new Date())+fileName;
        DLFolder uiElementDLFolder = null;
        String folderName = PortletProps.get("uielement.documentlibrary.filestore.folder.name");
        try
        {
            uiElementDLFolder = DLFolderLocalServiceUtil.getFolder(themeDisplay.getScopeGroupId(), 0, folderName);
        }
        catch (Exception e)
        {
            LOG.error("No folder exist in document Library with the name:"+folderName, e);
        }
        
        if(uiElementDLFolder == null){
            try
            {
                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), portletRequest);
                uiElementDLFolder = DLFolderLocalServiceUtil.addFolder(themeDisplay.getUserId(), 
                        themeDisplay.getScopeGroupId(),themeDisplay.getScopeGroupId(),false, 0, folderName, folderName,false, serviceContext);
            }
            catch (Exception e)
            {
                LOG.error("Failed to create folder in document Library with the name:"+folderName, e);
            }
        }
        
        if(uiElementDLFolder != null){
            try
            {
                UnicodeProperties extraSettingsProperties = PropertiesParamUtil.getProperties(portletRequest, "extraSettingsProperties--");
                String extraSettings = extraSettingsProperties.toString();
                ServiceContext serviceContext = ServiceContextFactory.getInstance(DLFolder.class.getName(), portletRequest);
                String extension = FileUtil.getExtension(fileName);
                serviceContext.setAttribute("extension", extension);
                String mimeType = MimeTypesUtil.getContentType(file);

                long fileEntryTypeId = -1L;
                Map<String, Fields> fieldsMap = null;
                 /*DLFileEntryLocalServiceUtil.addFileEntry(themeDisplay.getUserId(),  themeDisplay.getScopeGroupId(),
                         themeDisplay.getScopeGroupId(), uiElementDLFolder.getFolderId(), fileName, mimeType, fileName, "", "",
                        fileEntryTypeId, fieldsMap, file,null ,file.length(), serviceContext);*/
                
                DLAppLocalServiceUtil.addFileEntry(themeDisplay.getUserId(), 
                		themeDisplay.getScopeGroupId(), uiElementDLFolder.getFolderId(), fileName, mimeType, fileName, "", "", file, serviceContext); 
                		
            }
            catch (Exception e)
            {
                LOG.error("Failed to upload UI Element Translation import file to Document Library:"+fileName, e);
            }
        } else {
            LOG.error("Failed to upload UI Element Translation import file to Document Library");
        }
    }

}
