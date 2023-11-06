package com.ihg.grs.portlet;

import com.ihg.grs.bean.AssetLibraryBean;
import com.ihg.grs.util.AssetLibUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.mail.MailMessage;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;
import com.liferay.util.portlet.PortletProps;

import java.io.IOException;
import java.util.List;

import javax.mail.internet.AddressException;
import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.ReadOnlyException;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.portlet.ValidatorException;
import javax.servlet.http.HttpServletRequest;

/**
 * Portlet implementation class AssetLibraryPortlet.
 */
public class AssetLibraryPortlet extends MVCPortlet 
{
 
	private static final String KEYWORDS = "key";
	private static final Log LOGGER = LogFactoryUtil.getLog(AssetLibUtil.class);
	
	/**
	 * Rendering the Asset library page with categories and search result.
	 * @param renderRequest Render request object.
	 * @param renderResponse Render response object. 
	 */
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse) 
	{ 
		
		ThemeDisplay themeDisplay = (ThemeDisplay) renderRequest.getAttribute(WebKeys.THEME_DISPLAY);
		
		HttpServletRequest request = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
		SearchContext searchContext = SearchContextFactory.getInstance(request);
		List<AssetLibraryBean> searchList = null;
		int sortingOrder = 0;
		if (request.getParameter("sortValue") != null)
		{
			sortingOrder = Integer.parseInt(request.getParameter("sortValue"));
		}
		String keyWords = StringPool.BLANK;
		keyWords = ParamUtil.get(renderRequest, "key", StringPool.BLANK);
		
		if (Validator.isNull(keyWords) || keyWords.isEmpty())
		{					
			keyWords = request.getParameter("key");
		}
		long categoryOne = -1l;
		if (request.getParameter("catOne") != null)
		{
			categoryOne = Long.parseLong(request.getParameter("catOne"));
		}
		long categoryTwo = -1l;
		if (request.getParameter("catTwo") != null)
		{
			categoryTwo = Long.parseLong(request.getParameter("catTwo"));
		}
		long[] categoryArray = {categoryOne, categoryTwo};
		
		AssetLibUtil.getAssetCategories(themeDisplay.getScopeGroupId(), PortletProps.get("LOCAL_VOCABULARY_TEST_ONE"), renderRequest);
		 		
		if (Validator.isNotNull(keyWords) && keyWords.trim().length() > 0)
		{
			searchList = AssetLibUtil.getSearchResult(keyWords, themeDisplay, renderRequest, categoryArray, sortingOrder, searchContext);
		}
		renderRequest.setAttribute("categoryOneId", categoryOne);
		renderRequest.setAttribute("categoryTwoId", categoryTwo);
		renderRequest.setAttribute("searchList", searchList);
		renderRequest.setAttribute(KEYWORDS, keyWords);
		renderRequest.setAttribute("sortingSelected", sortingOrder);

		try
		{
			super.doView(renderRequest, renderResponse);
		}
		catch (IOException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortletException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
	}

	/**
	 * To set preferences, default number of search results to display.
	 * @param request A request object.
	 * @param response A response object.
	 */
	public void doEdit(RenderRequest request, RenderResponse response)
	{
		
		PortletPreferences preferences = request.getPreferences();
		int documentPrefs = Integer.parseInt(preferences.getValue("maxDocuments", "10"));
		request.setAttribute("documentPrefs", documentPrefs);
		
		try
		{
			super.doEdit(request, response);
		}
		catch (IOException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		catch (PortletException e)
		{
			LOGGER.error(e.getMessage(), e);
		}
		
	}
	
	/**
	 * To set preferences, default number of search results to display.
	 * @param request An action request object.
	 * @param response An action response object.
	 */
	public void setAssetLibPreferences(ActionRequest request, ActionResponse response)
	{
		
		PortletPreferences preferences = request.getPreferences();
		
		if (Validator.isNotNull(ParamUtil.getString(request, "maxDocuments")))
		{
			try
			{
				preferences.setValue("maxDocuments", ParamUtil.getString(request, "maxDocuments"));
				preferences.store();
			}
			catch (ReadOnlyException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
			catch (ValidatorException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
			catch (IOException e)
			{
				LOGGER.error(e.getMessage(), e);
			}
		}
	}
	
	/**
	 * To share the search result.
	 * @param resourceRequest A Ajax request object
	 * @param resourceResponse A Ajax response object
	 */
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
	{
		
		String requestType = resourceRequest.getParameter("requestType");
		
		if (requestType != null && "shareContent".equals(requestType))
		{
			shareContent(resourceRequest);
		}
	}
	
	/**
	 * To send mail with search result,description and download link of the document.
	 * @param resourceRequest A request object of serve resource.
	 */
	private void shareContent(ResourceRequest resourceRequest) 
	{
		try 
		{
			MailMessage mailMsg = new MailMessage();
			boolean htmlFormat = true;
			mailMsg.setHTMLFormat(htmlFormat);
			
			ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			String username=themeDisplay.getUser().getFirstName()+StringPool.SPACE+themeDisplay.getUser().getLastName();
			String useremailaddress=themeDisplay.getUser().getEmailAddress();
			
			HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
			String strAddresses = ParamUtil.getString(httpRequest, "toAddresses");
			String contentTitle = ParamUtil.getString(httpRequest, "contentTitle");
			String contentURL = ParamUtil.getString(httpRequest, "contentURL").concat("<br>" + "<br>" + "From," + "<br>" + username + "<br>" + useremailaddress + "<br>");
			String[] toAddresses = strAddresses.split(",");
			AssetLibUtil.sendMail(resourceRequest, toAddresses, contentTitle, contentURL, false);
		} 
		catch (AddressException e) 
		{
			LOGGER.error(e.getMessage(), e);
		}
	}
}
