package com.ihg.brandstandards.portlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletMode;
import javax.portlet.PortletPreferences;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;

import com.liferay.portal.NoSuchUserException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.User;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.util.bridges.mvc.MVCPortlet;

/**
 * <a href="BrndStndRoleAssignmentPortlet.java.html"><b><i>View Source</i></b></a>.
 * 
 * Project: Brand Standards
 * 
 * @author Lakshminarayana Mummanedi
 */
public class BrndStndRoleAssignmentPortlet extends MVCPortlet {
	
	private static final Log LOG = LogFactoryUtil.getLog(BrndStndRoleAssignmentPortlet.class);
 
	@Override
	public void doView(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		List<String> roleSubTypesList = new ArrayList<String>();
		boolean hasPreferencesSet = false;
		PortletPreferences prefs= renderRequest.getPreferences();
		String roleSubTypes = prefs.getValue("roleSubTypes", "");
		if(roleSubTypes != null && !roleSubTypes.isEmpty()){
			String[] roleSubTypesArray = roleSubTypes.split(StringPool.COMMA);
			roleSubTypesList = Arrays.asList(roleSubTypesArray);
			hasPreferencesSet = true;
		}
		renderRequest.setAttribute("roleSubTypesList", roleSubTypesList);
		renderRequest.setAttribute("hasPreferencesSet", hasPreferencesSet);
		super.doView(renderRequest, renderResponse);
	}
	
	@Override
	public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse)
			throws IOException, PortletException {
		ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
		String resourceId = resourceRequest.getResourceID();
		
		if("getRolesBySubType".equals(resourceId)){
			List<Role> roles = new ArrayList<Role>();
			String roleSubType = ParamUtil.getString(resourceRequest, "roleSubType");
			try {
				roles = RoleLocalServiceUtil.getRoles(1, roleSubType);
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			StringBuilder roleOptions = new StringBuilder();
			roleOptions.append("<option value=\"\"></option>)");
			for(Role role:roles){
				roleOptions.append("<option value=\"").append(role.getRoleId()).append("\">").append(role.getName()).append("</option>)");
			}
			resourceResponse.getWriter().write(roleOptions.toString());
		} else if("assignRole".equals(resourceId)) {
			String userName = ParamUtil.getString(resourceRequest, "userName");
			Long roleId = ParamUtil.getLong(resourceRequest, "roleId");
			String responseMsg = "Not_Exists";
			try {
				User user = getUserByScreenNameOrEmail(themeDisplay.getCompanyId(), userName);
				if(user != null){
					UserLocalServiceUtil.addRoleUser(roleId, user);
					responseMsg = "Success";
				}
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			resourceResponse.getWriter().write(responseMsg);
		} else if("deleteRole".equals(resourceId)){
			String userName = ParamUtil.getString(resourceRequest, "userName");
			Long roleId = ParamUtil.getLong(resourceRequest, "roleId");
			String responseMSG = "";
			try {
				User user = getUserByScreenNameOrEmail(themeDisplay.getCompanyId(), userName);
				if(user != null){
					boolean hasRoleUserExists = UserLocalServiceUtil.hasRoleUser(roleId, user.getUserId());
					if(hasRoleUserExists){
						UserLocalServiceUtil.deleteRoleUser(roleId, user);
						responseMSG = "Deleted";
					} else {
						responseMSG = "RoleUserNotExist";
					}
				}
			} catch (NoSuchUserException e) {
				responseMSG = "Not_Exists";
				LOG.error(e.getMessage());
			} catch (Exception e) {
				LOG.error(e.getMessage());
			}
			resourceResponse.getWriter().write(responseMSG);
		}
		
		super.serveResource(resourceRequest, resourceResponse);
	}
	
	private User getUserByScreenNameOrEmail(long companyId, String screenNameOrEmail) {
		User user = null;
		try {
			if(screenNameOrEmail != null && screenNameOrEmail.contains("@")){
				user = UserLocalServiceUtil.getUserByEmailAddress(companyId, screenNameOrEmail);
			} else {
				user = UserLocalServiceUtil.getUserByScreenName(companyId, screenNameOrEmail);
			}
		} catch (Exception e) {
			LOG.error(e.getMessage());
		}
		
		return user;
	}
	
	@Override
	public void doEdit(RenderRequest renderRequest, RenderResponse renderResponse)
			throws IOException, PortletException {
		
		String roleSubTypes = renderRequest.getPreferences().getValue("roleSubTypes","");;
		renderRequest.setAttribute("roleSubTypes", roleSubTypes);
		super.doEdit(renderRequest, renderResponse);
	}

	@ProcessAction(name="saveRoleAssignmentPreferences")
	public void saveData(ActionRequest actionRequest, ActionResponse actionResponse)
			throws IOException, PortletException {
		String roleSubTypes = ParamUtil.getString(actionRequest, "roleSubTypes");
		PortletPreferences prefs = actionRequest.getPreferences();
		prefs.setValue("roleSubTypes", roleSubTypes);
		prefs.store();
	}
	
	@ProcessAction(name= "setPortletMode")
	public void setPortletMode(ActionRequest actionRequest, ActionResponse actionResponse) throws IOException, PortletException {
		actionResponse.setPortletMode(PortletMode.VIEW);
	}
	
}
