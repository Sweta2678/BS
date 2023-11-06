package com.ihg.brandstandards.bridge.portlet;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletPreferences;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;

import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.GetterUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.security.permission.ActionKeys;
import com.liferay.portal.service.ResourcePermissionServiceUtil;
import com.liferay.portal.service.RoleLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.portlet.asset.model.AssetEntry;
import com.liferay.portlet.asset.service.AssetEntryLocalServiceUtil;
import com.liferay.portlet.asset.service.persistence.AssetEntryQuery;
import com.liferay.portlet.documentlibrary.model.DLFileEntry;
import com.liferay.portlet.documentlibrary.model.DLFolder;
import com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

public class DLPermissionPortlet extends MVCPortlet {

	Log LOGGER = LogFactoryUtil.getLog(DLPermissionPortlet.class);
	private static final String ROLE_GUEST_MEMBER = "Guest";
	@Override
	public void doView(RenderRequest renderRequest,
			RenderResponse renderResponse) throws IOException, PortletException {
		super.doView(renderRequest, renderResponse);
	}

	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 * @throws IOException
	 * @throws PortletException
	 */
	public void savePermission(ActionRequest actionRequest,
			ActionResponse actionResponse) throws IOException, PortletException {
		PortletPreferences preferences = actionRequest.getPreferences();
		String communityIdVal = preferences.getValue("communityId", null);
		ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		if (Validator.isNotNull(communityIdVal)) {
			for (String val : communityIdVal.split(",")) {
				long communityId = GetterUtil.getLong(val);
				//Update Document Permission
				updateDLPermission(themeDisplay.getCompanyId(), communityId);
			}
		}
		
	}
	
	/**
	 * @param companyId
	 * @param communityId
	 */
	private void updateDLPermission (long companyId, long communityId) {
		try {
			
			LOGGER.info(" --------------- Update Document Folder and File permission process start time ----------------"+new Date());
			AssetEntryQuery assetEntryQuery = new AssetEntryQuery();
			assetEntryQuery.setGroupIds(new long[]{communityId});
			assetEntryQuery.setClassName(DLFolder.class.getName());
			List<AssetEntry> folders = AssetEntryLocalServiceUtil.getEntries(assetEntryQuery);
			long roleId = getRoleId(companyId, ROLE_GUEST_MEMBER);
			Map<Long, String[]> roleIdsToActionIds = new HashMap<Long, String[]>();
			if (LOGGER.isDebugEnabled()) {
				LOGGER.debug("Community to update permission :"+communityId);
				LOGGER.debug("Total Folder to update permission:"+folders.size());
				LOGGER.debug("Guest Role Id :"+roleId);
			}
			
			for (AssetEntry folder : folders) {
				
				if (LOGGER.isDebugEnabled()) {
					LOGGER.debug("Folder to change permission :"+folder.getClassPK());
				}
				
				roleIdsToActionIds.put(roleId, new String[] {ActionKeys.VIEW});
				ResourcePermissionServiceUtil.setIndividualResourcePermissions(communityId, companyId, DLFolder.class.getName(), String.valueOf(folder.getClassPK()), roleIdsToActionIds);
				//File Entries
				List<DLFileEntry> fileEntries = DLFileEntryLocalServiceUtil.getFileEntries(communityId, folder.getClassPK());
				for (DLFileEntry fileEntry : fileEntries) {
					if (LOGGER.isDebugEnabled()) {
						LOGGER.debug("File to change permission :"+fileEntry.getFileEntryId() +" -- name --"+fileEntry.getTitle());
					}
					roleIdsToActionIds.put(roleId, new String[] {ActionKeys.VIEW});
					ResourcePermissionServiceUtil.setIndividualResourcePermissions(communityId, companyId, DLFileEntry.class.getName(), String.valueOf(fileEntry.getFileEntryId()), 
							roleIdsToActionIds);
				}
			}
			LOGGER.info(" --------------- Update Document Folder and File permission process end time ----------------"+new Date());
		} catch (SystemException e) {
			LOGGER.error(e.getMessage(), e);
		} catch (PortalException e) {
			LOGGER.error(e.getMessage(), e);
		}
	}
	
	/**
	 * 
	 * @param companyId
	 * @param roleName
	 * @return long
	 */
	private long getRoleId(long companyId, String roleName)
	{
		Role role = null;
		long roleId = 0; 
		
		try {
			role = RoleLocalServiceUtil.getRole(companyId, roleName);
			
			if(role != null){
				roleId = role.getRoleId();
			}
		} catch (PortalException e) {
			LOGGER.error("Could not find role with name : " + roleName);
		} catch (SystemException e) {
			LOGGER.error("Could not find role with name : " + roleName);
		}
		
		return roleId;
	}
	
	@Override
	public void doEdit(RenderRequest request, RenderResponse response) throws IOException, PortletException 
	{
		PortletPreferences prefs = request.getPreferences();
		if(Validator.isNotNull(prefs))
		{
			String inputGroupIds = prefs.getValue("communityId", null);			
			request.setAttribute("communityId", inputGroupIds);
		}
		super.doEdit(request, response);
	}
	
	/**
	 * 
	 * @param actionRequest
	 * @param actionResponse
	 */
	public void saveGroupIdsForm (ActionRequest actionRequest, ActionResponse actionResponse) {
		PortletPreferences prefs = actionRequest.getPreferences();
		String groupIds = actionRequest.getParameter("communityId");
		if (Validator.isNull(groupIds)) {
			groupIds = PortalUtil.getHttpServletRequest(actionRequest).getParameter("communityId");
			if (Validator.isNull(groupIds)) {
				groupIds = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(actionRequest)).getParameter("communityId");
			}
		}
		try {
			prefs.setValue("communityId", groupIds);
			prefs.store();
		} catch (Exception e) {
			LOGGER.error(e.getMessage(), e);
		}
		
	}

	
}
