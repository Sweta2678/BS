<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@include file="/html/userprefs/init.jsp" %>
<%
	Map<String, String> chnCdMap = null;
	if(MerlinCache.getCacheMap("BRNDSTD_CHN") != null){
		Map<String, Object> chnFullMap = (Map<String, Object>) MerlinCache.getCacheMap("BRNDSTD_CHN");
		Map<String, String> tmpChnCdMap = (Map<String, String>) chnFullMap.get("SECURITY_VALUES");
		
		/* Need to remove below code after push new brand in Bridge and OBSM */
		chnCdMap = new LinkedHashMap<String, String>();
        for(Map.Entry<String,String> entry : tmpChnCdMap.entrySet()){
        	if(!(entry.getKey().contains("VX") || entry.getKey().contains("KI") || entry.getKey().contains("RE"))){
            	chnCdMap.put(entry.getKey(),entry.getValue());
            }
        }
        /*end CR11 - 18 */		
	} else {
		chnCdMap = new LinkedHashMap<String, String>();
		chnCdMap.put("IC", "InterContinental Hotels");
	  	chnCdMap.put("IR", "InterContinental Resorts");
	  	chnCdMap.put("HI", "Holiday Inn");
	  	chnCdMap.put("EX", "Holiday Inn Express");
	  	chnCdMap.put("RS", "Holiday Inn Resort");
	  	chnCdMap.put("CV", "Holiday Inn Club Vacations");
	  	chnCdMap.put("CP", "Crowne Plaza Hotels");
	  	chnCdMap.put("CR", "Crowne Plaza Resorts");
	  	chnCdMap.put("UL", "HUALUXE Hotels & Resorts");
	  	chnCdMap.put("IN", "Hotel Indigo");
	  	chnCdMap.put("VN", "EVEN Hotels");
	  	chnCdMap.put("SB", "Staybridge Suites");
	  	chnCdMap.put("CW", "Candlewood Suites");
	  	chnCdMap.put("VA", "avid hotels");
	}

    //Map<String, Object> ctryMap = (Map<String, Object>) MerlinCache.getCacheMap("CTRY");
    Map<String, String> ctrymap = BrandStandardsUtil.countryMap();
    long userId = 0;
    AccessAndPreferences accessUserPrefs = (AccessAndPreferences) session.getAttribute("UserPreferences");
    if (accessUserPrefs == null)
    {
        accessUserPrefs = (AccessAndPreferences) request.getAttribute("userPreferences");
    }
    List<StandardsLocale> arlLanguages = new ArrayList<StandardsLocale>();
    List<String> arlChains = new ArrayList<String>();
    List<String> arlLocations = new ArrayList<String>();
    List<String> arlCountries = new ArrayList<String>();
    List<FlagCategory> arlCategories = new ArrayList<FlagCategory>();
    String country = "";
    String userType = "";
    String selectedBrand = "";
    String selectedLanguage = "";
    String selectedManual = "";
    String selectedPaperSize = "";
    String primaryBrand = "";
    String selectedLangName = "";
    if (accessUserPrefs != null)
    {
        userId = accessUserPrefs.getUserId();
        arlLanguages = accessUserPrefs.getLanguages();
        arlChains = accessUserPrefs.getChains();
        arlLocations = accessUserPrefs.getLocations();
        arlCountries = accessUserPrefs.getCountries();
        arlCategories = accessUserPrefs.getManuals();
        country = accessUserPrefs.getCountry();
        userType = accessUserPrefs.getUserType();
        selectedBrand = accessUserPrefs.getChain();
        selectedLanguage = accessUserPrefs.getLangCode();
        primaryBrand = accessUserPrefs.getDefaultChain();
        selectedLangName = accessUserPrefs.getLangName();
    }
    int chainCodeMapSize = 0;
    int chainCountrySize = 0;
    int chainLangSize = 0;
    
    if (Validator.isNotNull(arlChains)) {
    	chainCodeMapSize = arlChains.size();
    }
    if (Validator.isNotNull(arlCountries)) {
    	chainCountrySize = arlCountries.size();
    }
    if (Validator.isNotNull(arlLanguages)) {
    	chainLangSize = arlLanguages.size();
    }
     
    /* Below if condition is only to get it run in local as we don't get merlin cache object in local system 
     * With out this we can not open OBSM Preferences popup in local/developer setup.*/
    if(Validator.isNull(userType) && permissionChecker.isOmniadmin()) {
    	userType = "C";
    }
%>

<portlet:resourceURL var="corpLang" id="showCorpLanguages"></portlet:resourceURL>

<script type="text/javascript">
	var currentBrandName = '<%=selectedBrand%>';
	var brandErrorMsg = "${selectBrandVal}";
	var countryErrorMsg = "${selectCountryVal}";
	var langErrorMsg = "${selectLanguageVal}";
	function changeSettings()
	{
		//validate dropdowns are selected
		if(jQuery("#access_corp_choose_brand").val() == "" || jQuery("#access_corp_choose_brand").val() == null)
		{
			alert(brandErrorMsg);
			return false;
		}
		else if(jQuery("#access_corp_choose_country").val() == "" || jQuery("#access_corp_choose_country").val() == null)
		{
			alert(countryErrorMsg);
			return false;
		}
		else if( jQuery("#access_corp_choose_language").val() == "" || jQuery("#access_corp_choose_language").val() == null){
			alert(langErrorMsg);
			return false;
		} else {
			var hidBrand = document.getElementById('<portlet:namespace/>chnCd');
			var hidCtry = document.getElementById('<portlet:namespace/>ctryCd');
			var hidLang = document.getElementById('<portlet:namespace/>lclCd');
			
			hidBrand.value = jQuery("#access_corp_choose_brand").val();
			hidCtry.value =  jQuery("#access_corp_choose_country").val();
			hidLang.value = jQuery("#access_corp_choose_language").val();
			var frm  = document.getElementById('<portlet:namespace/>accessForm');
			frm.submit();
			//jQuery( "#yourviewModal" ).dialog( "close" );
		}
	}
	
	$( ".yourviewcancel" ).click(function() {
		if (currentBrandName != null && currentBrandName != '' && currentBrandName != 'null') {
			$( "#yourviewModal" ).dialog("close");
		} else {
			window.location.reload();
		}
	});
	
	function cancelYourViewModal(){
		if (currentBrandName != null && currentBrandName != '' && currentBrandName != 'null') {
			$( "#yourviewModal" ).dialog("close");
		} else {
			window.location.reload();
		}
	}
	
	function showLanguages(countryCode)
	{   
		//alert(countryCode.value);
		//var chainCodeObj = document.getElementById('<portlet:namespace/>chnCd');
		var chainCode =jQuery("#access_corp_choose_brand").val();
		var val = jQuery("#access_corp_choose_country").val();
		
		if ((chainCode != null && chainCode != '' && chainCode != 'null') && (val != null && val != '' && val != 'null')) {
			 var url = '<%=corpLang%>';
			    var theUrl = url;
			   // alert(theUrl);
			    var divname = "#lang_div";
			    var inData = {ctryCd:val,chnCd:chainCode};
			    jQuery.ajax({
			        type: "POST",
			        url: theUrl,
			        data: inData,
			        success: function(data)
			        {
			            jQuery(divname).html(data);
			        }
			    });
		}
	}
	
	function gotoMerlin()
	{	
		window.location = '<%=themeDisplay.getPortalURL()%>'+'/web/merlin/home';
	}
</script>

<portlet:actionURL var="accessPrefs" name="setAccess"></portlet:actionURL>

<aui:form  title="User Preferences Form"  action="<%= accessPrefs %>" method="post" name="accessForm" id="accessForm" class="nomargin">
<aui:input type="hidden" id="applyCorpButton" name="applyCorpButton" value="false"/>
<aui:input type="hidden" id="userId" name="userId" value="<%=userId %>"/>
<aui:input type="hidden" id="chnCd" name="chnCd" value=""/>
<aui:input type="hidden" id="ctryCd" name="ctryCd" value=""/>
<aui:input type="hidden" id="lclCd" name="lclCd" value=""/>
<aui:input type="hidden" id="pprSize" name="pprSize" value=""/>
<aui:input type="hidden" id="mnlType" name="mnlType" value=""/>


	<div class="modal_body">
		<div class="row-fluid">
			<div class="pad10">
		    <% if ("C".equals(userType) || "T".equals(userType) || "V".equals(userType)) { %>
	        	<p>${employeeNote} </p>
	        	<div class="form-horizontal">
		        <div class="control-group">
					<label class="control-label" for="access_corp_choose_brand" title="${brand}"><strong>${brand}</strong></label>
		        	<div class="controls">
					
						<select id="access_corp_choose_brand" class="access_corp_choose_brand" 
							name="access_corp_choose_brand" title="${selectBrandVal}" onchange="showLanguages()">
							<option value="">Please select</option>
							<%	for (String chncode : chnCdMap.keySet()) {
		                      		if (selectedBrand != null && selectedBrand.equals(chncode)) {
		                    %>		
										<option  value='<%=chncode%>' selected><%=chnCdMap.get(chncode)%></option> 
							<%
	 						    	} else {
	 						%>		
										<option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
							<%  	}
								}
							%> 
						</select>
					</div>
				</div>
				<div class="control-group">
					<label class="control-label" for="access_corp_choose_country" title="${country}"><strong>${country}</strong></label>
					<div class="controls">
						<select id="access_corp_choose_country" class="access_corp_choose_country" 
							name="access_corp_choose_country" title="${selectCountryVal}" onchange="showLanguages()">
							<option value="">Please select</option>
		                   	<%	for (String ctryCode : ctrymap.keySet()) {
		                   			
									if (country != null && country.equals(ctryCode)) {
		                   	%>		
										<option  value='<%=ctryCode%>' selected><%=ctrymap.get(ctryCode)%></option> 
							<% 		}
	 						        else {
	 						        	if(ctryCode.equals("AMER")||ctryCode.equals("AMEA")||ctryCode.equals("EURO")||ctryCode.equals("GC"))
			                   			{
			                   				%>		
											<option  value='<%=ctryCode%>' disabled="true"><%=ctrymap.get(ctryCode)%></option> 
										<%
			                   			}
	 						        	else
	 						        	{
	 						%>
										<option value='<%=ctryCode%>'><%=ctrymap.get(ctryCode)%></option> 
							<%			}
	 						        }
	 							}
	 						%> 
						</select>
					</div>
				</div>
				<div id = "lang_div">
					<div class="control-group">
						<label class="control-label" for="inputLanguage" title="${language}"><strong>${language}</strong></label>
		                <div class="controls">
							<select id="access_corp_choose_language" class="access_corp_choose_language" 
								name="access_corp_choose_language" title="${selectLanguageVal}">
		                    	
		                  		<%	for (StandardsLocale bsLocale : arlLanguages) {
										if (selectedLanguage != null && bsLocale.getLocaleCode().equals(selectedLanguage)) {
		                  		%>
		                  					<option value="<%=bsLocale.getLocaleCode()%>" selected><%=bsLocale.getLocaleName()%>
			            		<%		}
			            			    else 
			            			    {
						            		if(bsLocale.getLocaleCode().equals("en_GB") )
													{
										%>
													<option value="<%=bsLocale.getLocaleCode()%>" selected><%=bsLocale.getLocaleName()%>
							       		<%
											}
											else
											{
												%>
												<option value="<%=bsLocale.getLocaleCode()%>"><%=bsLocale.getLocaleName()%>
						       					<%
											}
			            				}
						       	    }
						       	%>
		                	</select>
		            	</div>
					</div>
				</div>
				</div>
          	<% }
	           else if ("H".equals(userType) || "M".equals(userType) || "O".equals(userType)) {
	        	  if (chainCodeMapSize <= 0) {
	        		
	       %>
	       <p style="color:red">${hasNoBrandMerlinMsg}</p>
	       <% 
	        	  }else{
	        %>
    			<p>${yourViewNote}</p>
    	 		<div class="form-horizontal">
    	 		<div class="control-group">
					<label class="control-label" for="access_corp_choose_brand" title="${brand}"><strong>${brand}</strong></label>
		        	<div class="controls">
                		<% if (chainCodeMapSize == 1) {
                			String chainNm = arlChains.get(0);
                		%>
							<select id="access_corp_choose_brand" class="access_corp_choose_brand" 
								name="access_corp_choose_brand" title="${selectBrandVal}" disabled="disabled">
								<%	for (String chncode : chnCdMap.keySet()) {
										if (chainNm != null && chncode.equals(chainNm)) {
		                    	%>		
										<option  value='<%=chncode%>' selected><%=chnCdMap.get(chncode)%></option>
										 
								<%		break;	
									}	
		                     		} %>
							</select>
						<%} else { %>
                		
                		<select id="access_corp_choose_brand" class="access_corp_choose_brand" 
                			name="access_corp_choose_brand" title="${selectBrandVal}">
                 			<option value="">Please select</option>
                   			<%
                       			for (String chncode : chnCdMap.keySet())
                               	{
                                   	for (String chain : arlChains)
                                   	{
                                       	if (chain != null)
                                       	{
                                           	if (chncode.equals(chain))
                                           	{
                                               	if (chncode.equals(selectedBrand))
                                               	{
                   			%>		
													<option value='<%=chncode%>' selected><%=chnCdMap.get(chncode)%></option> 
									<%
 									    		}
												else if (chncode.equals(selectedBrand))
 									            {
 									%>		
													<option value='<%=chncode%>' selected><%=chnCdMap.get(chncode)%></option> 
									<%
 											    }
												else
 											    {
 									%>		
													<option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
									<%
 										    	}
											}
										}
 									}
 								}
 							%> 
						</select>
						<%} %>
            		</div>
            	</div>
				<div class="control-group">
					<label class="control-label" for="access_corp_choose_country" title="${country}"><strong>${country}</strong></label>
					<div class="controls">
						<% if (chainCountrySize == 1 && chainCodeMapSize == 1) {
                			String countryNm = arlCountries.get(0);
                		%>
                			<select id="access_corp_choose_country" class="access_corp_choose_country" 
                				name="access_corp_choose_country" title="${selectCountryVal}"
                			 disabled="disabled">
                				<% 	for (String ctryCode : ctrymap.keySet())
                               		{
                					
                						if (countryNm != null && ctryCode.equals(countryNm)) {
                							
                							//if (ctryCode.equals(country))
                                           	//{
                								%>
                									<option value='<%=ctryCode%>' selected><%=ctrymap.get(ctryCode)%></option> 
                								<%
                								break;
                                           	//}
                						}
                             	  	}
                               	%>
                			</select>
                		<%
                			
						} else {
                		%>
						<select id="access_corp_choose_country" class="access_corp_choose_country" 
							name="access_corp_choose_country" title="${selectCountryVal}">
							<option value="">Please select</option>
                   			<% 	for (String ctryCode : ctrymap.keySet())
                               	{
									for (String userCtryCode : arlCountries)
                                   	{
                                       	if (userCtryCode != null)
                                       	{
                                           	if (ctryCode.equals(userCtryCode))
                                           	{
                                               	if (ctryCode.equals(country))
                                               	{
                   			%>
													<option value='<%=ctryCode%>' selected><%=ctrymap.get(ctryCode)%></option> 
								
							<%					}
 												else
 												{
 							%>
													<option value='<%=ctryCode%>'><%=ctrymap.get(ctryCode)%></option> 
						
							<%					}
 											}
 										}
 									}
 								}
 							%> 
                		</select>
                		<%} %>
            		</div>
            	</div>
				<div class="control-group">
					<label class="control-label" for="access_corp_choose_language" title="${language}"><strong>${language}</strong></label>
	         			<div class="controls"> 
	         			<% if (chainLangSize == 1 && chainCountrySize == 1 && chainCodeMapSize == 1) {
	         			   StandardsLocale bsLocaleVal = arlLanguages.get(0);
                		%>
							<select id="access_corp_choose_language" class="access_corp_choose_language" 
								name="access_corp_choose_language" disabled="disabled" title="${selectLanguageVal}">
										<option value="<%=bsLocaleVal.getLocaleCode()%>" selected><%=bsLocaleVal.getLocaleName()%>
							</select>
						<%} else { %>
	               		<select id="access_corp_choose_language" class="access_corp_choose_language" 
	               			name="access_corp_choose_language" title="${selectLanguageVal}">
	                    	
	                  		<%
	                  	    	for (StandardsLocale bsLocale : arlLanguages)
	                  	        {
									if (bsLocale.getLocaleCode().equals(selectedLanguage))
									{
	                  		%>
	                  					<option value="<%=bsLocale.getLocaleCode()%>" selected><%=bsLocale.getLocaleName()%>
	            			<%
									}
									else
									{
										if(bsLocale.getLocaleCode().equals("en_GB") )
										{
							%>
										<option value="<%=bsLocale.getLocaleCode()%>" selected><%=bsLocale.getLocaleName()%>
				       		<%
										}
										else
										{
											%>
											<option value="<%=bsLocale.getLocaleCode()%>"><%=bsLocale.getLocaleName()%>
					       					<%
										}
				       	    		}
								}
				       		%>
	               		</select>
	               		<%} %>
	           		</div>
	           	</div>
           	</div>
		<%
			}}
		%>
				   
			</div>
       </div> 
    </div>
	<div class="modal-footer">
		<a class="btn pull-left yourviewcancel" href="javascript:cancelYourViewModal()" title="${cancel}">${cancel}</a>
    	<!-- <button class="btn pull-left yourviewcancel">Cancel</button> -->
    	<% if ("H".equals(userType) || "M".equals(userType) || "O".equals(userType)) {
	        	  if (chainCodeMapSize <= 0) {
	        		%>
	        		<a class="btn btn-primary pull-right" 
					onclick="javascript:gotoMerlin();">${returnToMerlin}</a>
	        		<%  
	        		  
	        	  }else{
	        		  %>
	          		<button  id="changeSettingsButton" class="btn btn-primary pull-right" type="button"  title="${changeSettings}"
	          		onmousedown="javascript:_gaq.push(['_trackEvent', 'User Preferences', 'Change Preferences','Change User Preferences']);"  
	          		onclick="javascript:changeSettings()">${changeSettings}</button>
	          		<%  
	        	  }
    	}else{
    		%>
    		<button  id="changeSettingsButton" class="btn btn-primary pull-right" type="button"  title="${changeSettings}"
    		onmousedown="javascript:_gaq.push(['_trackEvent', 'User Preferences', 'Change Preferences','Change User Preferences']);"  
    		onclick="javascript:changeSettings()">${changeSettings}</button>
    		<%
    	}
	      %>
    	
	</div>
</aui:form>
