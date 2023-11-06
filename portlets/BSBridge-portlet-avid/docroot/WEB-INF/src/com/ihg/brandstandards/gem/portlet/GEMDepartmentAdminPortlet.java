package com.ihg.brandstandards.gem.portlet;

import com.ihg.brandstandards.bridge.util.BridgeConstants;
import com.ihg.brandstandards.db.model.Department;
import com.ihg.brandstandards.db.service.DepartmentLocalServiceUtil;
import com.ihg.brandstandards.db.service.GEMTemplateLocalServiceUtil;
import com.liferay.portal.kernel.dao.search.SearchContainer;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.language.LanguageUtil;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.search.SearchContext;
import com.liferay.portal.kernel.search.SearchContextFactory;
import com.liferay.portal.kernel.servlet.SessionErrors;
import com.liferay.portal.kernel.servlet.SessionMessages;
import com.liferay.portal.kernel.util.ListUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.Role;
import com.liferay.portal.model.RoleConstants;
import com.liferay.portal.service.RoleServiceUtil;
import com.liferay.portal.service.ServiceContext;
import com.liferay.portal.service.ServiceContextFactory;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.PortletURL;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;

public class GEMDepartmentAdminPortlet extends MVCPortlet {
	private static final String ACTIVE_VALUE = "Y";
	private static final String INACTIVE_VALUE = "N";
	
	@Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
		
        HttpServletRequest httpRequest =  PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        final PortletURL portletURL = renderResponse.createRenderURL();
     try {
    	 
                List<Department> departmentList = new ArrayList<Department>();
                try {
                	departmentList.clear();
                	departmentList.addAll(DepartmentLocalServiceUtil.getDepartments(-1, -1));
                	Department intialDepartment = DepartmentLocalServiceUtil.getDepartment(0);
                	departmentList.remove(departmentList.indexOf(intialDepartment));
                } catch (Exception e) {
                    LOG.error("Failed while getting GEM Departments:", e);
                }
                setResultsToSearchContainer(renderRequest, httpRequest, departmentList, portletURL);
            
        } catch (Exception e) {
            LOG.error(e);
        }
        include(viewTemplate, renderRequest, renderResponse);
    }
	
	
	private static final Log LOG = LogFactoryUtil.getLog(GEMDepartmentAdminPortlet.class);
	
	  @ProcessAction(name = "saveDepartment")
	 public void saveDepartment(ActionRequest actionRequest, ActionResponse actionResponse){
		 ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
		 try {
			 
			 int recPerPage = ParamUtil.getInteger(actionRequest, "recPerPage");
		        int pageNum = ParamUtil.getInteger(actionRequest, "pageNum");
		        actionRequest.setAttribute("recPerPage", recPerPage);
		        actionRequest.setAttribute("pageNum", pageNum);
		        actionRequest.setAttribute("delta", recPerPage);
		        actionRequest.setAttribute("cur", pageNum);
		        actionResponse.setRenderParameter("delta", String.valueOf(recPerPage));
		        actionResponse.setRenderParameter("cur", String.valueOf(pageNum));
			 long departmentId = ParamUtil.getLong(actionRequest, "departmentId");
			 String deptName = ParamUtil.getString(actionRequest, "deptName");
			 String oldDeptName = ParamUtil.getString(actionRequest, "oldDeptName");
			 String departmentType = ParamUtil.getString(actionRequest, "departmentType");
			 String deptDescription = ParamUtil.getString(actionRequest, "deptDescription");
			 long deptId = ParamUtil.getLong(actionRequest, "deptId");
			 if(Validator.isNotNull(deptName)&&Validator.isNotNull(deptDescription)){
				 Department department;
				 if(Validator.isNotNull(departmentId)){
					 department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				 }else{
					 
					 department = DepartmentLocalServiceUtil.createDepartment(deptId);
					 //department = DepartmentLocalServiceUtil.createDepartment();
					
					 department.setCreatorId(String.valueOf(themeDisplay.getUserId()));
					 department.setCreatedDate(new Date());
				 }
				 department.setActiveInd(departmentType);
				 department.setDepartmentName(deptName);
				 department.setDescription(deptDescription);
				 department.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
				 department.setUpdatedDate(new Date());
				 department = DepartmentLocalServiceUtil.updateDepartment(department);
				 if(Validator.isNotNull(department)){
					 if( Validator.isNull(departmentId)){
						 createRolesforDepartment(deptName,actionRequest);
						 SessionMessages.add(actionRequest, "department-has-added-successfully");	 
					 }else{
						 if(!oldDeptName.equals(deptName)){
							 updateRolesforDepartment(deptName,oldDeptName,actionRequest);
						 }
						 SessionMessages.add(actionRequest, "department-has-updated-successfully");	 
					 }
				
				 }
			 }
		 } catch (Exception e) {
			 LOG.error("Error in adding updating department" + e.getMessage(), e);
			 SessionErrors.add(actionRequest, "error-in-adding-new-department");
			
		 }
		 
		
	 }

	 public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		 String cmd = ParamUtil.getString(resourceRequest, "cmd");
		 try { 
			 if(cmd.equals("validateDepartment")){
			 try {
				 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
		         PrintWriter writer = resourceResponse.getWriter();
				 String deptName = ParamUtil.getString(resourceRequest, "deptName");
				 String deptId = ParamUtil.getString(resourceRequest, "deptId");
				 Department departmentForName = null;
				 Department departmentForId = null;
				 try {
					 departmentForName = DepartmentLocalServiceUtil.getActiveDepartmentByName(deptName, ACTIVE_VALUE);
					 departmentForId = DepartmentLocalServiceUtil.getDepartment(Long.parseLong(deptId));
				 } catch(Exception e){
					LOG.warn("Department does nto exist with department id:"+deptId); 
				 }
				 if(Validator.isNotNull(departmentForName)){
					jsonObject.put("isdeptNameExist", "true");
				 } else{
					jsonObject.put("isdeptNameExist", "false");
				 }
				 if(Validator.isNotNull(departmentForId)){
					 jsonObject.put("isdeptIdExist", "true");
				 } else{
					 jsonObject.put("isdeptIdExist", "false");
				 }
				 writer.write(jsonObject.toString());
			 } catch (Exception e) {
				 LOG.error("Error in checking deparment name exist or not " + e.getMessage(), e);
			}
		 }	else if(cmd.equals("checkDeleteAssication")){
			 try {
			 JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
			 PrintWriter writer = resourceResponse.getWriter();
			 long departmentId= ParamUtil.getLong(resourceRequest, "departmentId");
			 if(Validator.isNotNull(departmentId)){
				 Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				 try { 
					 List<Object> objList = DepartmentLocalServiceUtil.getPublicationActiveDepartment(departmentId, department.getActiveInd());
					 if(((BigDecimal)objList.get(0)).intValue()>0){
						 jsonObject.put("isAssociate", "true");
					 }else{
						 jsonObject.put("isAssociate", "false"); 
					 }
					
					
				 }catch(Exception e){
					 jsonObject.put("isAssociate", "false"); 
					 LOG.error(" deparment has no asscociated with Publication  " + e.getMessage(), e);
				 }
				 jsonObject.put("isActive", department.getActiveInd());  
			 }
			 writer.write(jsonObject.toString());
			 }catch(Exception e){
				 
				 LOG.error("Error in checking deparmtne has asscociated with Publication  " + e.getMessage(), e);
			 }
		 } else if (cmd.equals("addDepartment")||cmd.equals("editDepartment")) {
			String departmentId = ParamUtil.getString(resourceRequest, "departmentId");
			resourceRequest.setAttribute("departmentId", departmentId);
			include("/html/GEM/departmentAdmin/add-new-department.jsp", resourceRequest, resourceResponse);
			
         }else if (cmd.equals("deleteDepartment")){
        	 PrintWriter writer = resourceResponse.getWriter();
        	 String returnMsg =deleteDepartment(resourceRequest,resourceResponse);
        	 writer.write(returnMsg);
         }
		 
		 } catch (Exception e) {
	            LOG.error(e);
	      }
	 }
	
	 public String deleteDepartment(ResourceRequest resourceRequest, ResourceResponse resourceResponse){
		 String returnMsg ="";
		 try {
			 
			 ThemeDisplay themeDisplay = (ThemeDisplay) resourceRequest.getAttribute(WebKeys.THEME_DISPLAY);
			 long departmentId = ParamUtil.getLong(resourceRequest, "departmentId");
			 if(Validator.isNotNull(departmentId)){
				 Department department = DepartmentLocalServiceUtil.getDepartment(departmentId);
				 
				 if(department.getActiveInd().equals(ACTIVE_VALUE)){
				 department.setActiveInd(INACTIVE_VALUE);
				 department.setUpdatedBy(String.valueOf(themeDisplay.getUserId()));
				 department.setUpdatedDate(new Date());
				 department = DepartmentLocalServiceUtil.updateDepartment(department);
				 }else if(department.getActiveInd().equals(INACTIVE_VALUE)){
					 String deptName = department.getDepartmentName();
					 if(Validator.isNotNull(department)){
						 deleteRolesforDepartment(deptName,themeDisplay);
						
					 }
					 DepartmentLocalServiceUtil.deleteDepartment(department);
				 }
				 returnMsg= "Success";
			 }
		 } catch (Exception e) {
			 LOG.error("Error in deleting  department" + e.getMessage(), e);
			 returnMsg= "Failed";
			
		 }
		 return returnMsg;
	 }
	 
	 private void deleteRolesforDepartment(String deptName,ThemeDisplay themeDisplay){
		
			
			try {
				//AMEA 
				String ameaRoleName= "BRND_STND_GEM_AMEA_"+deptName;
				Role ameaRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), ameaRoleName);
				RoleServiceUtil.deleteRole(ameaRole.getRoleId());
				
				//AMER
				String amerRoleName= "BRND_STND_GEM_AMER_"+deptName;
				Role amerRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), amerRoleName);
				RoleServiceUtil.deleteRole(amerRole.getRoleId());
				
				//EURO
				String euroRoleName= "BRND_STND_GEM_EURO_"+deptName;
				Role euroRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), euroRoleName);
				RoleServiceUtil.deleteRole(euroRole.getRoleId());
				
				//GC
				String gcRoleName= "BRND_STND_GEM_GC_"+deptName;
				Role gcRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), gcRoleName);
				RoleServiceUtil.deleteRole(gcRole.getRoleId());
				
				//GLBL
				String glblRoleName= "BRND_STND_GEM_GLBL_"+deptName;
				Role glblRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), glblRoleName);
				RoleServiceUtil.deleteRole(glblRole.getRoleId());
				
				
			} catch (Exception e) {
				LOG.error("Error in deleting  department Roles" + e.getMessage(), e);
			}
		 
	 }
	 
	 private void createRolesforDepartment(String deptName,ActionRequest actionRequest){
		
		try {
			ServiceContext serviceContext = ServiceContextFactory.getInstance(
						Role.class.getName(), actionRequest);
			
			//AMEA 
			String ameaRoleName= "BRND_STND_GEM_AMEA_"+deptName;
			Map<Locale, String> ameatitleMap = getLocalizationMap(deptName,"AMEA",true);
			Map<Locale, String> ameaDescriptionMap = getLocalizationMap(deptName,"AMEA",false);
			RoleServiceUtil.addRole(
						null, 0, ameaRoleName, ameatitleMap, ameaDescriptionMap, RoleConstants.TYPE_REGULAR, null,
						serviceContext);
			//AMER 
			String amerRoleName= "BRND_STND_GEM_AMER_"+deptName;
			Map<Locale, String> amertitleMap = getLocalizationMap(deptName,"AMER",true);
			Map<Locale, String> amerDescriptionMap = getLocalizationMap(deptName,"AMER",false);
			RoleServiceUtil.addRole(
						null, 0, amerRoleName, amertitleMap, amerDescriptionMap, RoleConstants.TYPE_REGULAR, null,
						serviceContext);
			//EURO 
			String euroRoleName= "BRND_STND_GEM_EURO_"+deptName;
			Map<Locale, String> eurotitleMap = getLocalizationMap(deptName,"EURO",true);
			Map<Locale, String> euroDescriptionMap = getLocalizationMap(deptName,"EURO",false);
			RoleServiceUtil.addRole(
						null, 0, euroRoleName, eurotitleMap, euroDescriptionMap, RoleConstants.TYPE_REGULAR, null,
						serviceContext);
			
			//GC 
			String gcRoleName= "BRND_STND_GEM_GC_"+deptName;
			Map<Locale, String> gctitleMap = getLocalizationMap(deptName,"GC",true);
			Map<Locale, String> gcDescriptionMap = getLocalizationMap(deptName,"GC",false);
			RoleServiceUtil.addRole(
						null, 0, gcRoleName, gctitleMap, gcDescriptionMap, RoleConstants.TYPE_REGULAR, null,
						serviceContext);
			//GLOBAL 
			String globalRoleName= "BRND_STND_GEM_GLBL_"+deptName;
			Map<Locale, String> globaltitleMap = getLocalizationMap(deptName,"GLBL",true);
			Map<Locale, String> globalDescriptionMap = getLocalizationMap(deptName,"GLBL",false);
			RoleServiceUtil.addRole(
						null, 0, globalRoleName, globaltitleMap, globalDescriptionMap, RoleConstants.TYPE_REGULAR, null,
						serviceContext);
			
		}catch (Exception e) {
			LOG.error("Error in creating roles for new   department" + e.getMessage(), e);
		}
		 
		 
	 }
	 private void updateRolesforDepartment(String deptName,String oldDeptName,ActionRequest actionRequest){
		 try {
				ServiceContext serviceContext = ServiceContextFactory.getInstance(
							Role.class.getName(), actionRequest);
				ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
				//AMEA 
				String ameaRoleName= "BRND_STND_GEM_AMEA_"+deptName;
				String ameaOldRoleName= "BRND_STND_GEM_AMEA_"+oldDeptName;
				Map<Locale, String> ameatitleMap = getLocalizationMap(deptName,"AMEA",true);
				Map<Locale, String> ameaDescriptionMap = getLocalizationMap(deptName,"AMEA",false);
				Role ameaRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), ameaOldRoleName);
				RoleServiceUtil.updateRole(ameaRole.getRoleId(), ameaRoleName, ameatitleMap, ameaDescriptionMap, null, serviceContext);
				//AMER 
				String amerRoleName= "BRND_STND_GEM_AMER_"+deptName;
				String amerOldRoleName= "BRND_STND_GEM_AMER_"+oldDeptName;
				Map<Locale, String> amertitleMap = getLocalizationMap(deptName,"AMER",true);
				Map<Locale, String> amerDescriptionMap = getLocalizationMap(deptName,"AMER",false);
				Role amerRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), amerOldRoleName);
				RoleServiceUtil.updateRole(amerRole.getRoleId(), amerRoleName, amertitleMap, amerDescriptionMap, null, serviceContext);
				//EURO 
				String euroRoleName= "BRND_STND_GEM_EURO_"+deptName;
				String euroOldRoleName= "BRND_STND_GEM_EURO_"+oldDeptName;
				Map<Locale, String> eurotitleMap = getLocalizationMap(deptName,"EURO",true);
				Map<Locale, String> euroDescriptionMap = getLocalizationMap(deptName,"EURO",false);
				Role euroRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), euroOldRoleName);
				RoleServiceUtil.updateRole(euroRole.getRoleId(), euroRoleName, eurotitleMap,euroDescriptionMap, null, serviceContext);
				
				//GC 
				String gcRoleName= "BRND_STND_GEM_GC_"+deptName;
				String gcOldRoleName= "BRND_STND_GEM_GC_"+oldDeptName;
				Map<Locale, String> gctitleMap = getLocalizationMap(deptName,"GC",true);
				Map<Locale, String> gcDescriptionMap = getLocalizationMap(deptName,"GC",false);
				Role gcRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), gcOldRoleName);
				RoleServiceUtil.updateRole(gcRole.getRoleId(), gcRoleName, gctitleMap,gcDescriptionMap, null, serviceContext);
				//GLOBAL 
				String globalRoleName= "BRND_STND_GEM_GLBL_"+deptName;
				String globalOldRoleName= "BRND_STND_GEM_GLBL_"+oldDeptName;
				Map<Locale, String> globaltitleMap = getLocalizationMap(deptName,"GLBL",true);
				Map<Locale, String> globalDescriptionMap = getLocalizationMap(deptName,"GLBL",false);
				Role globalRole = RoleServiceUtil.getRole(themeDisplay.getCompanyId(), globalOldRoleName);
				RoleServiceUtil.updateRole(globalRole.getRoleId(), globalRoleName, globaltitleMap,globalDescriptionMap, null, serviceContext);
			}catch (Exception e) {
				LOG.error("Error in updating roles for   department" + e.getMessage(), e);
			}
		 
	 }
	private Map<Locale, String> getLocalizationMap(String name,String region,boolean isTitle) {

				Locale[] locales = LanguageUtil.getAvailableLocales();

				Map<Locale, String> map = new HashMap<Locale, String>();

				for (Locale locale : locales) {
					String value;
					if(isTitle){
						value = "Brand Standards GEM "+region+" "+ name;
					}else{
						value = name;
					}
					
					map.put(
						locale, value);
				}

				return map;
			}
	
	 protected void setResultsToSearchContainer(RenderRequest renderRequest, HttpServletRequest httpRequest, 
	    		List<Department> resultList, PortletURL portletURL) {
	        int pageNumber = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_PAGE_NUM);
	        int recPerPage = ParamUtil.getInteger(httpRequest, BridgeConstants.REQUEST_PARAM_REC_PER_PAGE);
	        
	        if (recPerPage == 0 && renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM) != null) {
	            recPerPage = Integer.parseInt(renderRequest.getParameter(SearchContainer.DEFAULT_DELTA_PARAM));
	        } else if (recPerPage == 0) {
	            recPerPage = BridgeConstants.DEFAULT_ITEMS_PER_PAGE;
	        }
	        SearchContainer<Department> searchContainer = new SearchContainer<Department>(renderRequest, null, null, SearchContainer.DEFAULT_CUR_PARAM, pageNumber, recPerPage, portletURL, null, null);
	        final SearchContext searchContext = SearchContextFactory.getInstance(httpRequest);
	        searchContext.setStart(searchContainer.getStart());
	        searchContext.setEnd(searchContainer.getEnd());
	        searchContainer.setTotal(resultList.size());
	        
	        List<Department> departmentDisplayList = ListUtil.subList(resultList, searchContainer.getStart(), searchContainer.getEnd());
	        searchContainer.setResults(departmentDisplayList);
	        searchContainer.setEmptyResultsMessage("No Department Exist.");
	        renderRequest.setAttribute("searchContainer", searchContainer);
	        
	        renderRequest.setAttribute("curPageNum",
	        		renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNumber) : 
	        			renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
	        renderRequest.setAttribute("delta",recPerPage);
	        renderRequest.setAttribute("cur", renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM) == null ? String.valueOf(pageNumber) : 
				renderRequest.getParameter(SearchContainer.DEFAULT_CUR_PARAM));
	        
	    }

}
