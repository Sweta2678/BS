package com.ihg.brandstandards.portlet;

import com.ihg.brandstandards.bsadmin.model.ComplianceView;
import com.ihg.brandstandards.db.model.ChainStandards;
import com.ihg.brandstandards.db.model.CountryStandards;
import com.ihg.brandstandards.db.model.CountryStandardsExt;
import com.ihg.brandstandards.db.model.Standards;
import com.ihg.brandstandards.db.model.StandardsCompliance;
import com.ihg.brandstandards.db.model.StandardsComplianceExt;
import com.ihg.brandstandards.db.model.StandardsCountryChain;
import com.ihg.brandstandards.db.service.CountryStandardsExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.CountryStandardsLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsComplianceExtLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsComplianceLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsCountryChainLocalServiceUtil;
import com.ihg.brandstandards.db.service.StandardsLocalServiceUtil;
import com.ihg.brandstandards.util.BrandStandardsUtil;
import com.ihg.brandstandards.util.ComplianceUtil;
import com.ihg.brandstandards.util.QueryUtils;
import com.ihg.brandstandards.util.StandardsUtil;
import com.liferay.portal.kernel.exception.PortalException;
import com.liferay.portal.kernel.exception.SystemException;
import com.liferay.portal.kernel.json.JSONFactoryUtil;
import com.liferay.portal.kernel.json.JSONObject;
import com.liferay.portal.kernel.log.Log;
import com.liferay.portal.kernel.log.LogFactoryUtil;
import com.liferay.portal.kernel.util.ParamUtil;
import com.liferay.portal.kernel.util.StringPool;
import com.liferay.portal.kernel.util.Validator;
import com.liferay.portal.kernel.util.WebKeys;
import com.liferay.portal.model.User;
import com.liferay.portal.service.UserLocalServiceUtil;
import com.liferay.portal.theme.ThemeDisplay;
import com.liferay.portal.util.PortalUtil;
import com.liferay.util.bridges.mvc.MVCPortlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import javax.portlet.ActionRequest;
import javax.portlet.ActionResponse;
import javax.portlet.PortletException;
import javax.portlet.ProcessAction;
import javax.portlet.RenderRequest;
import javax.portlet.RenderResponse;
import javax.portlet.ResourceRequest;
import javax.portlet.ResourceResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * Controller for manage compliance portlet
 * 
 * @author hitesh.methani
 * 
 */
public class ManageCompliancePortlet extends MVCPortlet
{
    private static final Log LOG = LogFactoryUtil.getLog(ManageCompliancePortlet.class);

    @Override
    public void doView(RenderRequest renderRequest, RenderResponse renderResponse) throws IOException, PortletException {
        ComplianceView complianceView = null;
        List<ChainStandards> arlChainStandards = new ArrayList<ChainStandards>();
        List<ChainStandards> arlChainStds = new ArrayList<ChainStandards>();
        List<StandardsComplianceExt> arlStdCompliance = null;
        List<ComplianceView> arlComplianceByBrand = new ArrayList<ComplianceView>();
        final HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(renderRequest));
        HttpSession session = httpReq.getSession();
        long expandStdId =  ParamUtil.getLong(httpReq, BrandStandardsUtil.REQUEST_PARAM_STD_ID, ParamUtil.getLong(renderRequest, BrandStandardsUtil.REQUEST_PARAM_STD_ID, 0L));
        int pageNum = ParamUtil.getInteger(httpReq, BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM, ParamUtil.getInteger(renderRequest, BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM, 0));
        int recPerPage = ParamUtil.getInteger(httpReq, BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE, ParamUtil.getInteger(renderRequest, BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE, 0));
        long objId = 0L;
        if (Validator.isNull(renderRequest.getParameter(StandardsUtil.REQUEST_PARAM_ID))) {
            objId = ParamUtil.getLong(httpReq, StandardsUtil.REQUEST_PARAM_ID, ParamUtil.get(renderRequest, StandardsUtil.REQUEST_PARAM_ID, 0L));
        } else {
            objId = ParamUtil.getLong(renderRequest, StandardsUtil.REQUEST_PARAM_ID, 0L);
        }
       
        User user;
        try {
            user = PortalUtil.getUser(renderRequest);
            String signedInAuthorRegion = ComplianceUtil.getRegionalAuthourRole(user.getRoles());
            arlChainStandards = ComplianceUtil.getChainStandardsForViewCompliance(objId);
            for(ChainStandards chain: arlChainStandards) {
            	complianceView = new ComplianceView();
            	arlStdCompliance = new ArrayList<StandardsComplianceExt>();
            	String query = QueryUtils.getCompliance(objId, chain.getChainCode());
            	arlStdCompliance = StandardsComplianceExtLocalServiceUtil.getComplianceByRegion(query, objId, chain.getChainCode());
            	List<StandardsComplianceExt> arlCompliance = new ArrayList<StandardsComplianceExt>(arlStdCompliance);
            	if(LOG.isDebugEnabled()) {
            		LOG.debug("arlCOmpliance list size is "+arlCompliance.size());
            	}
	            complianceView = ComplianceUtil.getBrandRegionMappingByStdIdAndBrandCode(complianceView, objId, user, chain.getChainCode());
	            complianceView.setSelectedBrand(chain.getChainCode());
	            complianceView.setLoggedInGlobal(signedInAuthorRegion.equals(BrandStandardsUtil.REGION_GLBL));
	            complianceView.setArlStdCompliance(arlCompliance);
	            
	            //Defect 5302 : Added to verify if std and brand is in publish mode (std_ctry_chain) if yes then disable all 
	            setEnableDisableParam(complianceView );
	            
	            arlComplianceByBrand.add(complianceView);
            }
            arlChainStds = new ArrayList<ChainStandards>(arlChainStandards);
        } catch (Exception e) {
            LOG.error("SystemException in doView for manage compliance portlet " + e.getMessage());
        }
        // set backURL
        String urlQuery = "?pageNum=" + pageNum;
        if(recPerPage > 0) {
            urlQuery = urlQuery + "&" + BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE + "=" + recPerPage;
        }
        if(expandStdId!=0L) {
            urlQuery = urlQuery + "&prntid=" + expandStdId;
        }
        if(Validator.isNotNull(renderRequest.getParameter("urlQuery"))) {
            urlQuery = renderRequest.getParameter("urlQuery");
        }
        renderRequest.setAttribute("arlComplianceByBrand", arlComplianceByBrand);
        session.setAttribute("arlComplianceByBrand", arlComplianceByBrand);
        renderRequest.setAttribute("urlQuery", urlQuery);
        renderRequest.setAttribute("id", objId);
        renderRequest.setAttribute("chainStandards", arlChainStds);
        super.doView(renderRequest, renderResponse);
    }

    @ProcessAction(name = "saveComplianceRule")
    public void saveComplianceRule(ActionRequest actionRequest, ActionResponse actionResponse) throws SystemException, PortalException {
    	String complianceExpiry ="";
    	String ruleDate ="";
    	Map<String, String> regionMap = new HashMap<String, String>();
    	Map<String, String> arlRegions = new HashMap<String, String>();
    	String urlQuery = ParamUtil.get(actionRequest, "urlQuery", StringPool.BLANK);
    	ThemeDisplay themeDisplay = (ThemeDisplay) actionRequest.getAttribute(WebKeys.THEME_DISPLAY);
        HttpServletRequest request = PortalUtil.getHttpServletRequest(actionRequest);
        HttpSession session = request.getSession();
        User user = themeDisplay.getUser();
        try {
	        List<ComplianceView> arlCompliance = (List<ComplianceView>)session.getAttribute("arlComplianceByBrand");//ComplianceUtil.getChainStandardsForViewCompliance(complianceView.getStdId());
	        for(ComplianceView complianceView : arlCompliance) {
	        	String dateRule = "";
	        	String complex = "";
	        	String chainCode = complianceView.getSelectedBrand();
	        	arlRegions = complianceView.getAssociatedRegions();
	        	String complianceRadio = "complianceRadio_"+chainCode;
	        	String expiryRadio = "expiryRadio_"+chainCode;
	        	String ruleRadio = "ruleRadio_"+chainCode;
	        	String dateRadio = "dateRadio_"+chainCode;
	        	if(ParamUtil.getString(request, complianceRadio) != null && !(ParamUtil.getString(request, complianceRadio)).equals("")) {
	        		complex = ParamUtil.getString(request, complianceRadio);
	        	} else if(ParamUtil.getString(request, expiryRadio) != null && !(ParamUtil.getString(request, expiryRadio)).equals("")) {
	        		complex = ParamUtil.getString(request, expiryRadio);
	        	}
	        	
	        	if(ParamUtil.getString(request, ruleRadio) != null && !(ParamUtil.getString(request, ruleRadio)).equals("")) {
	        		dateRule = ParamUtil.getString(request, ruleRadio);
	        	} else if(ParamUtil.getString(request, dateRadio) != null && !(ParamUtil.getString(request, dateRadio)).equals("")) {
	        		dateRule = ParamUtil.getString(request, dateRadio);
	        	}
	        	
	        	String globalRule = "globalrule_"+chainCode;
	        	String ameaRule = "amearule_"+chainCode;
	        	String amerRule = "amerrule_"+chainCode;
	        	String euroRule = "eurorule_"+chainCode;
	        	String gcRule = "gcrule_"+chainCode;
	        	String globalDate = "globaldate_"+chainCode;
	        	String ameaDate = "ameadate_"+chainCode;
	        	String amerDate = "amerdate_"+chainCode;
	        	String euroDate = "eurodate_"+chainCode;
	        	String gcDate = "gcdate_"+chainCode;
	        	String glblexDate = "glblexdate_"+chainCode;
	        	String ameaexDate = "ameaexdate_"+chainCode;
	        	String amerexDate = "amerexdate_"+chainCode;
	        	String euroexDate = "euroexdate_"+chainCode;
	        	String gcexDate = "gcexdate_"+chainCode;
	        	String delglblexDate = "delglblexdate_"+chainCode;
	        	String delameaexDate = "delameaexdate_"+chainCode;
	        	String delamerexDate = "delamerexdate_"+chainCode;
	        	String deleuroexDate = "deleuroexdate_"+chainCode;
	        	String delgcexDate = "delgcexdate_"+chainCode;
	        	
	        	String delglblcmpDate = "delglblcmpdate_"+chainCode;
	        	String delameacmpDate = "delameacmpdate_"+chainCode;
	        	String delamercmpDate = "delamercmpdate_"+chainCode;
	        	String deleurocmpDate = "deleurocmpdate_"+chainCode;
	        	String delgccmpDate = "delgccmpdate_"+chainCode;
	        	
	        	String expiryValue = "expiry_"+chainCode;
	        	String ruleValue = "rule_"+chainCode;
	        	String dateValue = "date_"+chainCode;
	        	String brandSelect = "complianceSelect_"+chainCode;
	        	String selectedBrand = request.getParameter(brandSelect);
	        
	        	//LOG.info("value of selected brand is "+selectedBrand );
	        	for(String str : arlRegions.keySet()) {
	        		if(str.equals(BrandStandardsUtil.REGION_GLBL) && dateRule.equals(ruleValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, globalRule));
	        			
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMEA) && dateRule.equals(ruleValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, ameaRule));
	        			
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMER) && dateRule.equals(ruleValue)) {
	        			//LOG.info("value of amer rule is "+ParamUtil.getString(actionRequest, amerRule));
	        			//LOG.info("value of amer rule is "+request.getParameter(amerRule)+" id of amer rule is "+amerRule);
	        			//regionMap.put(str, ParamUtil.getString(actionRequest, amerRule));
	        			regionMap.put(str, request.getParameter(amerRule));
	        		
	        		} else if(str.equals(BrandStandardsUtil.REGION_EUROPE) && dateRule.equals(ruleValue)) {
	        			regionMap.put(str, ParamUtil.getString(request,euroRule));
	        			
	        		} else if(str.equals(BrandStandardsUtil.REGION_GC) && dateRule.equals(ruleValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, gcRule));
	        			
	        		}
	        		
	        		if(str.equals(BrandStandardsUtil.REGION_GLBL) && dateRule.equals(dateValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, globalDate).equals("")?"0":ParamUtil.getString(request, globalDate));
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMEA) && dateRule.equals(dateValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, ameaDate));
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMER) && dateRule.equals(dateValue)) {
	        			regionMap.put(str, ParamUtil.getString(request, amerDate));
	        		} else if(str.equals(BrandStandardsUtil.REGION_EUROPE) && dateRule.equals(dateValue)) {
	        			regionMap.put(str, ParamUtil.getString(request,euroDate));
	        		} else if(str.equals(BrandStandardsUtil.REGION_GC) && dateRule.equals(dateValue)) {
	        			regionMap.put(str, ParamUtil.getString(request,gcDate));
	        		}
	        		
	        		if(str.equals(BrandStandardsUtil.REGION_GLBL) && complex.contains("expiry_")) {
	        			regionMap.put(str, ParamUtil.getString(request, glblexDate).equals("")?"0":ParamUtil.getString(request, glblexDate));
	        			regionMap.put(str+"_expriry", ParamUtil.getString(request, delglblexDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delglblexDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMEA) && complex.contains("expiry_")) {
	        			regionMap.put(str, ParamUtil.getString(request, ameaexDate));
	        			regionMap.put(str+"_expriry", ParamUtil.getString(request, delameaexDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delameaexDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMER) && complex.contains("expiry_")) {
	        			regionMap.put(str, ParamUtil.getString(request, amerexDate));
	        			regionMap.put(str+"_expriry", ParamUtil.getString(request, delamerexDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delamerexDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_EUROPE) && complex.contains("expiry_")) {
	        			regionMap.put(str, ParamUtil.getString(request, euroexDate));
	        			regionMap.put(str+"_expriry", ParamUtil.getString(request, deleuroexDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, deleuroexDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_GC) && complex.contains("expiry_")) {
	        			regionMap.put(str, ParamUtil.getString(request, gcexDate));
	        			regionMap.put(str+"_expriry", ParamUtil.getString(request, delgcexDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delgcexDate));
	        			}
	        		}
	        		
	        		if(str.equals(BrandStandardsUtil.REGION_GLBL) && complex.contains("compliance_")) {
	        			regionMap.put(str+"_compliance", ParamUtil.getString(request, delglblcmpDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delglblcmpDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMEA) && complex.contains("compliance_")) {
	        			regionMap.put(str+"_compliance", ParamUtil.getString(request, delameacmpDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delameacmpDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_AMER) && complex.contains("compliance_")) {
	        			regionMap.put(str+"_compliance", ParamUtil.getString(request, delamercmpDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delamercmpDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_EUROPE) && complex.contains("compliance_")) {
	        			regionMap.put(str+"_compliance", ParamUtil.getString(request, deleurocmpDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, deleurocmpDate));
	        			}
	        		} else if(str.equals(BrandStandardsUtil.REGION_GC) && complex.contains("compliance_")) {
	        			regionMap.put(str+"_compliance", ParamUtil.getString(request, delgccmpDate));
	        			if(LOG.isDebugEnabled()) {
	                		LOG.debug(ParamUtil.getString(request, delgccmpDate));
	        			}
	        		}
	        	}
	        	
	        	if(complex.contains("compliance_")) {
	        		complianceExpiry = "C";
	        		if(dateRule.contains("rule_")) {
	        			ruleDate = "R";
	        		} else if(dateRule.contains("date_")) {
	        			ruleDate = "D";
	        		} else {
	        			ruleDate = "R";
	        		}
	        	} else if(complex.contains("expiry_")) {
	        		complianceExpiry = "E";
	        		ruleDate = "D";
	        	}
	        	if(LOG.isDebugEnabled()) {
            		LOG.debug(" values are "+complianceExpiry+" "+ruleDate+" "+regionMap.keySet());
	        	}
	        	if(selectedBrand.equals("true")) {
	        		//LOG.info("inside selected brand true "+chainCode);
	        		saveOrUpdateCompliance(complianceView, regionMap, complianceExpiry, ruleDate, user);
	        	}
	        }
        } catch(Exception e) {
        	LOG.error(e);
        }
        actionResponse.setRenderParameter("id", ParamUtil.get(actionRequest, "id", "0"));
        actionResponse.setRenderParameter("urlQuery", urlQuery);
    }

    @Override
    public void serveResource(ResourceRequest resourceRequest, ResourceResponse resourceResponse) throws IOException,
            PortletException {
    	 HttpServletRequest httpReq = PortalUtil.getOriginalServletRequest(PortalUtil.getHttpServletRequest(resourceRequest));
         HttpSession session = httpReq.getSession();
        final String resourceID = resourceRequest.getResourceID();
        //LOG.info("inside serveResource");
        if ("searchExpireStd".equals(resourceID)) {
            resourceResponse.setContentType("json");
            long searchStdId = 0L;
            Standards std = null;
            JSONObject jsonObject = JSONFactoryUtil.createJSONObject();
            PrintWriter writer = resourceResponse.getWriter();
            try {
                searchStdId = Long.parseLong(resourceRequest.getParameter("searchStdId"));
                std = StandardsLocalServiceUtil.getStandards(searchStdId);
            } catch(Exception e) {
                LOG.error("SystemException in fetching standard: " + searchStdId);
            }
            
            if (Validator.isNotNull(std) && !std.getStdTyp().equals(BrandStandardsUtil.STD_TYPE_GDLN)) {
                String returnStdType = std.getStdTyp();
                jsonObject.put("stdType", returnStdType);
                jsonObject.put("stdTitle", std.getTitle());
                writer.write(jsonObject.toString());
            } else {
                writer.write(jsonObject.toString());
            }
        } else if("validateExpiry".equals(resourceID)) {
            long searchStdId = ParamUtil.get(resourceRequest, "searchStdId", 0L);
            long currentStdId = ParamUtil.get(resourceRequest, "id", 0L);
            String[] expireIds = resourceRequest.getParameterValues("existExpireIds[]");
            String currentBrand = ParamUtil.get(resourceRequest, "currentBrand", StringPool.BLANK);
            String validateMsg = StringPool.BLANK;
            try {
                validateMsg = ComplianceUtil.validateExpireId(searchStdId, currentStdId, expireIds, currentBrand);
            } catch (Exception e) {
                LOG.error("SystemException in validating Expiry "+e.getMessage());
                validateMsg = "SystemException in validating Expiry "+e.getMessage();
            }
            PrintWriter writer = resourceResponse.getWriter();
            if(Validator.isNotNull(validateMsg)) {
                writer.write(validateMsg);
            }
        } else if("complianceBrand".equals(resourceID)) {
        	ComplianceView complianceView = (ComplianceView) session.getAttribute("complianceView");
        	long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
        	String chainCode = resourceRequest.getParameter("chainCode");
        	//LOG.info("inside compliance Brand if loop in manage compliance portlet");
        	 List<StandardsCompliance> arlStdCompliance = new ArrayList<StandardsCompliance>();
        	try {
				User user = PortalUtil.getUser(resourceRequest);
				//ComplianceUtil.setBrandRegionMapping(complianceView, user,stdId, resourceRequest);
				 arlStdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdId(complianceView.getStdId());
				complianceView = ComplianceUtil.getBrandRegionMappingByStdIdAndBrandCode(complianceView, complianceView.getStdId(), user, chainCode);
				 include("/html/manageCompliance/editCompliance.jsp", resourceRequest, resourceResponse);
			} catch (Exception e) {
        		LOG.error("SystemException in validating Expiry "+e.getMessage(), e);
			}
        	resourceRequest.setAttribute("complianceView", complianceView);
        	resourceRequest.setAttribute("chainCode", chainCode);
        	resourceRequest.setAttribute("stdId", stdId);
            session.setAttribute("complianceView", complianceView);
        } else if("countryAttribution".equals(resourceID)) {
        	renderCountryAttribution(resourceRequest, resourceResponse);
        	include("/html/manageCompliance/countryattribution.jsp", resourceRequest, resourceResponse);
        } else if ("saveAttribution".equals(resourceID)) {
        	saveCountryAttribution(resourceRequest, resourceResponse);
            final PrintWriter writer = resourceResponse.getWriter();
            writer.print(ComplianceUtil.SUCCESS_MESSAGE);
        }

    }

    private void renderCountryAttribution(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
    	long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
    	String chainCode = resourceRequest.getParameter("chainCode");
    	String compType = resourceRequest.getParameter("compType");
    	String ruleType = resourceRequest.getParameter("ruleType");
    	String region = resourceRequest.getParameter("region");
    	String ruleDate = resourceRequest.getParameter("ruleDate");
    	String compRule = resourceRequest.getParameter("compRule");
    	
    	List<StandardsCompliance> stdComplianceList = null;    	
        Map<String, Map<String, String>> allCountries = BrandStandardsUtil.getCountries();
        Map<String, String> regionCountryMap = allCountries.get(region);
    	
		List<CountryStandards> stdCountriesList = null;
		Map<String, CountryStandards> tempStdMap = new LinkedHashMap<String, CountryStandards>();
    	try {
			stdCountriesList = new CopyOnWriteArrayList<CountryStandards>();
			stdCountriesList.addAll(CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId));
			List<String> standardCountries = new ArrayList<String>();
	        for (CountryStandards stdCountry : stdCountriesList) {
	        	standardCountries.add(stdCountry.getCountry());
	        	tempStdMap.put(stdCountry.getCountry(), stdCountry);
	            if(!regionCountryMap.containsKey(stdCountry.getCountry())) {
	            	stdCountriesList.remove(stdCountry);
	            }
    		}
        	
			stdComplianceList = new CopyOnWriteArrayList<StandardsCompliance>();
			stdComplianceList.addAll(StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdAndChainCode(stdId, chainCode));
    		if(!StandardsUtil.isNullOrBlank(stdComplianceList)) {
	            for (StandardsCompliance stdCompliance : stdComplianceList) {
	            	stdCountriesList.remove(tempStdMap.get(stdCompliance.getCountryCode()));
	            	if(!regionCountryMap.containsKey(stdCompliance.getCountryCode())) {
	            		stdComplianceList.remove(stdCompliance);
	            	}
	            	if(!standardCountries.contains(stdCompliance.getCountryCode())){
	            		stdComplianceList.remove(stdCompliance);
	            	}
	            	
	            }
    		}
		} catch (SystemException e) {
			LOG.error(e);
		}
    	resourceRequest.setAttribute("StandardsCountry", stdCountriesList);
    	resourceRequest.setAttribute("StandardsCompliance", stdComplianceList);
		resourceRequest.setAttribute("countries", regionCountryMap);
    	resourceRequest.setAttribute("ComplianceRules", ComplianceUtil.getComplianceRules());
    	resourceRequest.setAttribute("stdId", stdId);
    	resourceRequest.setAttribute("chainCode", chainCode);
    	resourceRequest.setAttribute("compType", compType);
    	resourceRequest.setAttribute("ruleType", ruleType);
    	resourceRequest.setAttribute("region", region);
    	resourceRequest.setAttribute("ruleDate", ruleDate);
    	resourceRequest.setAttribute("compRule", compRule);
    }
   
    
    private void saveCountryAttribution(ResourceRequest resourceRequest, ResourceResponse resourceResponse) {
    	long stdId = Long.parseLong(resourceRequest.getParameter("stdId"));
    	String chainCode = resourceRequest.getParameter("chainCode");
    	String compType = resourceRequest.getParameter("compType");
    	String ruleType = resourceRequest.getParameter("ruleType");
        final long userId = PortalUtil.getUserId(resourceRequest);

        final Date currDate = new Date();    	
		try  {
	        final User user = UserLocalServiceUtil.getUserById(userId);
			List<CountryStandards> stdCountriesList = CountryStandardsLocalServiceUtil.getCountryStandardsByStdId(stdId);
	        for (CountryStandards stdCountry : stdCountriesList) {
	        	StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(stdId, chainCode, stdCountry.getCountry());
	            if(resourceRequest.getParameter("country_" + stdCountry.getCountry()) != null 
	            		&& !"".equals(resourceRequest.getParameter("country_" + stdCountry.getCountry()))) {
		        	
	            	if(stdCompliance == null || stdCompliance.getStdComplianceId() <= 0) {
		        		//Using Oracle sequences
		        		stdCompliance = StandardsComplianceLocalServiceUtil.createStandardsCompliance();
		        		stdCompliance.setChainCode(chainCode);
		        		stdCompliance.setStdId(stdId);
		        		stdCompliance.setCountryCode(stdCountry.getCountry());
		        		stdCompliance.setCreatorId(String.valueOf(user.getUserId()));
		        		stdCompliance.setCreatedDate(currDate);
		        		stdCompliance.setRuleDate(ruleType);
		        	}
	            	
	        		
	        		
            		if(ruleType.equals("D")) {
            			SimpleDateFormat formatter = new SimpleDateFormat("dd-MMM-yyyy");
            			Date countryDate = null;
            			String dateInString = resourceRequest.getParameter("country_" + stdCompliance.getCountryCode());
            			
            			try {
            				countryDate = formatter.parse(dateInString);
            				if(countryDate!=stdCompliance.getComplianceExpiryDate()){
	            			stdCompliance.setComplianceExpiryDate(countryDate);
	            			stdCompliance.setRuleDate(ruleType);
	            			stdCompliance.setComplianceRuleMonths(0);
	            			stdCompliance.setComplianceExpiryRule(compType);
	                		
	    	        		stdCompliance.setUpdatedBy(String.valueOf(user.getUserId()));
	    	        		stdCompliance.setUpdatedDate(currDate);
            				}
            			} catch(Exception exc) {
            				LOG.error("Date Parsing Exception "+ exc.getMessage());
            			
            			}
            			StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
            		} else {
            			long months = Long.parseLong(resourceRequest.getParameter("country_" + stdCompliance.getCountryCode()));
            			
            			//if(months!=0&& Validator.isNotNull(ruleType)){
            				
            			//}
            			if(stdCompliance.getComplianceRuleMonths()!=months){
            				stdCompliance.setComplianceRuleMonths(months);
            				stdCompliance.setRuleDate(ruleType);
            				stdCompliance.setComplianceExpiryDate(null);
            				stdCompliance.setComplianceExpiryRule(compType);
	                		
	    	        		stdCompliance.setUpdatedBy(String.valueOf(user.getUserId()));
	    	        		stdCompliance.setUpdatedDate(currDate);
            			}
            			if(months==0){
            				StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
                		}else{
                			StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
                		}
            		}
            		
            		
	            } else {
	            	if(null != stdCompliance) {
	            		if(resourceRequest.getParameter("delDatecountry_" + stdCompliance.getCountryCode()) != null 
	            				&& !"".equals(resourceRequest.getParameter("delDatecountry_" + stdCompliance.getCountryCode())) ) {
		            		String stdComplianceCountryCode = stdCompliance.getCountryCode();
		            		String expDateString = resourceRequest.getParameter("delDatecountry_" + stdComplianceCountryCode);
		            		String countryDelExpiryKey = "delDate";
		            		if(countryDelExpiryKey.equalsIgnoreCase(expDateString)){
		            			if(null != stdCompliance){
		            				
		            	        		StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
			            		
		            			}
		            		}
		            	} else {
		            		if(resourceRequest.getParameter("del_all_countries_date") != null 
		            				&& !"".equals(resourceRequest.getParameter("del_all_countries_date"))){
		            			
		            		}
		            	}
	            	}
	            }
    		}
		} catch (Exception e) {
			LOG.error(e);
		}
    }
    
    public void saveOrUpdateCompliance(ComplianceView complianceView, Map<String, String> regionMap, 
    		String complianceExpiry, String ruleDate, User user) throws SystemException {
    	String chainCode = complianceView.getSelectedBrand();
    	List<CountryStandardsExt> assignedCountries = CountryStandardsExtLocalServiceUtil.getCountriesByStandard(complianceView.getStdId());
    	try {
    		if(regionMap.containsKey(BrandStandardsUtil.REGION_GLBL)) {
    			//set expiry date as null into DB for Global Region when user explicitly wants to delete the record from DB for standard compliance when there is record exists in the DB
    			if(BrandStandardsUtil.IsNullOrBlank(regionMap.get(BrandStandardsUtil.REGION_GLBL))) {
    				if(regionMap.containsKey(BrandStandardsUtil.REGION_GLBL+"_expriry") && !BrandStandardsUtil.IsNullOrBlank(regionMap.get(BrandStandardsUtil.REGION_GLBL+"_expriry"))) {
    					if(regionMap.get(BrandStandardsUtil.REGION_GLBL+"_expriry").equalsIgnoreCase("GLB_DelExpDate")) {
    						StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(complianceView.getStdId(), chainCode, "GLB");
    						if(null != stdCompliance) {
    							
    								StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
        							if(LOG.isDebugEnabled()) {
        			            		LOG.debug("Standard Compliance Global record expiry date is set to null for this chain code " + chainCode);
        							
    							}
    						}
    					}
    				}else if(regionMap.containsKey(BrandStandardsUtil.REGION_GLBL+"_compliance") && !BrandStandardsUtil.IsNullOrBlank(regionMap.get(BrandStandardsUtil.REGION_GLBL+"_compliance"))){
    					if(regionMap.get(BrandStandardsUtil.REGION_GLBL+"_compliance").equalsIgnoreCase(BrandStandardsUtil.REGION_GLBL+"_DelComplianceDate")) {
    						StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(complianceView.getStdId(), chainCode, "GLB");
    						if(null != stdCompliance) {
    						
    								StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
	    							if(LOG.isDebugEnabled()) {
	    			            		LOG.debug("Standard Compliance Global record compliance date is set to null for this chain code" + chainCode);
	    							
    							}
    						}
    					}
    				}
    				
    			} else {
    				StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(complianceView.getStdId(), chainCode, "GLB");
    	        	if(stdCompliance == null || stdCompliance.getStdComplianceId() <= 0) {
    	        		//Using Oracle sequences
    	        		stdCompliance = StandardsComplianceLocalServiceUtil.createStandardsCompliance();
    	        		stdCompliance.setChainCode(chainCode);
    	        		stdCompliance.setStdId(complianceView.getStdId());
    	        		stdCompliance.setCountryCode("GLB");
    	        		stdCompliance.setCreatorId(String.valueOf(user.getUserId()));
    	        		stdCompliance.setCreatedDate(new Date());
    	        	}
    				stdCompliance.setComplianceExpiryRule(complianceExpiry);
    				stdCompliance.setRuleDate(ruleDate);
    				stdCompliance.setUpdatedBy(String.valueOf(user.getUserId()));
    				stdCompliance.setUpdatedDate(new Date());
    				if((complianceExpiry.equals("C") && ruleDate.equals("D")) || complianceExpiry.equals("E")) {
    					Date date = null;
    					DateFormat format = new SimpleDateFormat("dd-MMM-yy");
    					
    					if(!regionMap.get(BrandStandardsUtil.REGION_GLBL).equals("0")){
    						date = format.parse(regionMap.get(BrandStandardsUtil.REGION_GLBL));
    					}
    					
    					stdCompliance.setComplianceExpiryDate(date);
    					stdCompliance.setComplianceRuleMonths(0);
    					
    					StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
    				} else {
    					if(!regionMap.get(BrandStandardsUtil.REGION_GLBL).equals("")){
    						stdCompliance.setComplianceRuleMonths(Long.parseLong(regionMap.get(BrandStandardsUtil.REGION_GLBL)));
    						stdCompliance.setComplianceExpiryDate(null);
    					}
    					if(Long.parseLong(regionMap.get(BrandStandardsUtil.REGION_GLBL))==0){
    						StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
    					}else{
    						StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
    					}
    				}
    			}
    		}
		
			for(CountryStandardsExt country : assignedCountries) {
				if (regionMap.containsKey(country.getRegionCode())) {
					//set expiry date as null into DB for each country when user explicitly wants to delete the record from DB for standard compliance when there is record exists in the DB
					if(BrandStandardsUtil.IsNullOrBlank(regionMap.get(country.getRegionCode()))) {
						if(regionMap.containsKey(country.getRegionCode()+"_expriry") && !BrandStandardsUtil.IsNullOrBlank(regionMap.get(country.getRegionCode()+"_expriry"))) {
	    					if(regionMap.get(country.getRegionCode()+"_expriry").equalsIgnoreCase(country.getRegionCode()+"_DelExpDate")) {
	    						StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(country.getStdId(), chainCode, country.getCountryCode());
	    						if(null != stdCompliance) {
		    							StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
		    							if(LOG.isDebugEnabled()) {
		    			            		LOG.debug("Standard Compliance Global record expiry date is set to null for this chain code " + chainCode + " and for this country "  + country.getCountryCode());
		    							}
	    							
	    						}
	    					}
	    				}else if(regionMap.containsKey(country.getRegionCode()+"_compliance") && !BrandStandardsUtil.IsNullOrBlank(regionMap.get(country.getRegionCode()+"_compliance"))){
	    					if(regionMap.get(country.getRegionCode()+"_compliance").equalsIgnoreCase(country.getRegionCode()+"_DelComplianceDate")) {
	    						StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(country.getStdId(), chainCode, country.getCountryCode());
	    						if(null != stdCompliance) {
	    							
		    							StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
		    							if(LOG.isDebugEnabled()) {
		    			            		LOG.debug("Standard Compliance regional  record compliance date is set to null for this chain code " + chainCode + " and for this country "  + country.getCountryCode());
		    							}
	    							
	    						}
	    					}
	    				}
					} else {
						StandardsCompliance stdCompliance = StandardsComplianceLocalServiceUtil.getStandardsComplianceByStdIdChainCodeCountryCode(country.getStdId(), chainCode, country.getCountryCode());
			        	if(stdCompliance == null || stdCompliance.getStdComplianceId() <= 0) {
			        		//Using Oracle sequences
			        		stdCompliance = StandardsComplianceLocalServiceUtil.createStandardsCompliance();
			        		stdCompliance.setChainCode(chainCode);
			        		stdCompliance.setStdId(country.getStdId());
			        		stdCompliance.setCountryCode(country.getCountryCode());
			        		stdCompliance.setCreatorId(String.valueOf(user.getUserId()));
			        		stdCompliance.setCreatedDate(new Date());
			        	}
						stdCompliance.setComplianceExpiryRule(complianceExpiry);
	    				stdCompliance.setRuleDate(ruleDate);
	    				if((complianceExpiry.equals("C") && ruleDate.equals("D")) || complianceExpiry.equals("E")) {
	    					DateFormat format = new SimpleDateFormat("dd-MMM-yy");
	    					Date date = format.parse(regionMap.get(country.getRegionCode()));
	    					if(date!=stdCompliance.getComplianceExpiryDate()){
	    					stdCompliance.setComplianceExpiryDate(date);
	    					stdCompliance.setComplianceRuleMonths(0);
	    					stdCompliance.setUpdatedBy(String.valueOf(user.getUserId()));
		    				stdCompliance.setUpdatedDate(new Date());
		    				StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
	    					}
	    				} else {
	    					//if(!regionMap.get(country.getRegionCode()).equals("")){
	    					if(stdCompliance.getComplianceRuleMonths()!=Long.parseLong(regionMap.get(country.getRegionCode()))){
	    						stdCompliance.setComplianceRuleMonths(Long.parseLong(regionMap.get(country.getRegionCode())));
	    						stdCompliance.setComplianceExpiryDate(null);
	    						stdCompliance.setUpdatedBy(String.valueOf(user.getUserId()));
	    	    				stdCompliance.setUpdatedDate(new Date());
	    	    				if(Long.parseLong(regionMap.get(country.getRegionCode()))==0){
	    	    					StandardsComplianceLocalServiceUtil.deleteStandardsCompliance(stdCompliance);
	    	    				}else{
	    	    					StandardsComplianceLocalServiceUtil.updateStandardsCompliance(stdCompliance);
	    	    				}
	    	    				
	    					}
	    				}
	    				
					}
				}
		    }
    	} catch(Exception e) {
    		LOG.error(e);
    	}
    }
    
    public void setEnableDisableParam(ComplianceView complianceView) throws SystemException {
    	Map<String, String> regionsAssociateds = new LinkedHashMap<String, String>(complianceView.getAssociatedRegions());
    	Map<String, String> complianceMap = new LinkedHashMap<String, String>();
        for (String regionCode : regionsAssociateds.keySet()) {
			List<StandardsCountryChain> stdCntChain = StandardsCountryChainLocalServiceUtil.getStandardsChainRegion(complianceView.getStdId(), complianceView.getSelectedBrand(), regionCode);
			if (Validator.isNotNull(stdCntChain) && stdCntChain.size() > 0 ) {
				SimpleDateFormat sd = new SimpleDateFormat("dd-MMM-yyyy");
				if(Validator.isNotNull(stdCntChain.get(0).getCompDate())) {
					String compDate = sd.format(stdCntChain.get(0).getCompDate());
					if (regionsAssociateds.get(regionCode).equals("ALL")) {
						complianceMap.put(regionCode, compDate+"_Y");
						if(LOG.isDebugEnabled()) {
		            		LOG.debug("IF region equals ALL   "+regionCode +"  Compliance Date  "+compDate);
						}
					} else{
						complianceMap.put(regionCode, compDate+"_N");
						if(LOG.isDebugEnabled()) {
		            		LOG.debug("IF region equals PARTIAL   "+regionCode +"  Compliance Date  "+compDate);
						}
					}
				}
				//complianceView.setBrandPublished(true);
			}
		}
        complianceView.setComplianceDate(complianceMap);
    }
    
    
   
}
