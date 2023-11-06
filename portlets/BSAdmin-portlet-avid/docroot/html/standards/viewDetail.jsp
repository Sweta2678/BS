<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsChainImages"%>
<%@page import="com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.ChainExternalLinkStandards"%>
<%@page import="com.ihg.brandstandards.db.model.ChainAttachmentsStandards"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsAuthors"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsCountryImages"%>
<%@page import="com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"%>
<%@page import="com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry"%>
<%@include file="/html/standards/init.jsp" %>
<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{
	StandardsView standView = (StandardsView) request.getAttribute("StandardsView");
	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();

    Map<String, String> fileTypes = StandardsUtil.fileTypes();
    Map<String, String> changeMap = StandardsUtil.changeMap();
    Map<String, String> categoryMap = StandardsUtil.categoryMap();
    List<StandardsStatus> statusList = StandardsStatusUtil.getStatuses(standView.getStandard());
    DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");

    boolean isStd = standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD);
    boolean isSpec = standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_SPEC);
    boolean isGdln =  standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN);
%>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.4.2.min.js"></script>

<script type="text/javascript">
jQuery(document).ready(function () {

    jQuery('input[type="radio"]:not(:checked)').each(function(){ jQuery(this).attr('disabled', true); });
    
    jQuery(':radio,:checkbox').click(function(){
        return false;
    });
});
</script>

<%@include file="/html/common/countryregions.jsp" %>
<div>
<p><img src="/BSTheme-theme/images/print_icon.png" alt="print" title="print" width="50" class="print_icon" /> Please use your browser's print options to print this document.</p>
<div class="divider">&nbsp;</div>
<h2><img src="/BSTheme-theme/images/books.jpg" alt="View" title="Global Standards" class="book_icon" /> 
	<% if(standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD)) { %>
           Standard
    <% }else if(standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_SPEC)) { %>
             	Specification
    <% } else {%>
            	Guideline
    <% } %>
	View - <%=standView.getStandard().getStdId()%></h2>
<div class="field_wrapper">
	<span class="step" id="first_step">
	<% if(standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD)) { %>
		<label class="wrapper_label"><span class="wrapper_span">Standard</span>             
			<p class="text_not_input"><%=standView.getStandard().getTitle()%></p>
		</label>
 
		<label class="wrapper_label"><span class="wrapper_span">Rationale</span>                 
			<p class="text_not_input"><%=standView.getStandard().getDescription()%></p>
		</label>
		<div class="clear"></div>
		<% if(standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD))	{	%>
		<label class="wrapper_label"><span class="wrapper_span">Index Path</span>
			<p class="text_not_input"><%=TaxonomyExtLocalServiceUtil.getIndexPathByStandardId(standView.getStandard().getStdId()) %></p>
		</label>
	<%		}	%>
    <%  } else if(standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_SPEC)) { %>
		<label class="wrapper_label"><span class="wrapper_span">Specification</span>             
			<p class="text_not_input"><%=standView.getStandard().getTitle()%></p>
		</label>
		<label class="wrapper_label"><span class="wrapper_span">Rationale</span>                 
			<p class="text_not_input"><%=standView.getStandard().getDescription()%></p>
		</label>
		<div class="clear"></div>
    <% } else {%>
		<label class="wrapper_label"><span class="wrapper_span">Guideline</span>             
			<p class="text_not_input"><%=standView.getStandard().getDescription()%></p>
		</label>
    <% } %>
        <div class="clear"></div>
        <label class="wrapper_label"><span class="wrapper_span">Assign Image</span>
        <div class="clear"></div>
        <table id="assign_images" summary="Data table for assigned images.">
            <tr class="spec_links_header">
                <td><strong>Thumbnail</strong></td>
                <td><strong>Title</strong></td>
                <td><strong>ID</strong></td>
                <td><strong>Upload Date</strong></td>
                <td><strong>Author</strong></td>
                <td><strong>Brand</strong></td>
                <td><strong>Region</strong></td>
                <td><strong>Country</strong></td>
                <td><strong>Description</strong></td>
            </tr>
            <% Map<StandardsImages, List<List>> stdImages = standView.getAssignImages();
            if (StandardsUtil.isNullOrBlank(stdImages))
            { %>
            <tr>
                <td colspan="6">No Assign Image(s) found.</td>
            </tr>
           <%}
            else
            {
                for (StandardsImages stdImg : stdImages.keySet())
                { 
                	String smallImageURL = "";
                	try{
                    	FileEntry fileEntry = DLAppLocalServiceUtil.getFileEntry(stdImg.getImage().getImageId());
                    	smallImageURL = DLUtil.getThumbnailSrc(fileEntry, null, themeDisplay);
                	} catch(Exception e){
                		_log.error("Failed to get image from liferay with imageId:"+stdImg.getImage().getImageId());
                	}
            %>
                <tr id="<%=stdImg.getImageId()%>" class="table_links_list">
                    <td class="asing_img_td this_link">
                      <a href="/image/image_gallery?uuid=<%=stdImg.getImage().getImageUuId() %>&groupId=<%=themeDisplay.getScopeGroupId() %>"  onclick="window.open (this.href, '_blank', 'height = 400, width = 650, resizable = yes'); return false;">
                        <img src="<%=smallImageURL%>" title="image <%=stdImg.getImage().getImageId()%>" alt="image <%=stdImg.getImage().getImageId()%>" /> 
                      </a>
                      <input type="hidden" value="img_id=<%=stdImg.getImage().getImageId()%>" />
                    </td>
                    <td class="asing_img_title_td this_link"><%=stdImg.getImageTitle()%><input type="hidden" value="<%=stdImg.getImageTitle()%>"/></td>
                    <td class="asing_img_td this_link"><%=stdImg.getImageId()%><input type="hidden" var_type="imgId" value="<%=stdImg.getImageId()%>"/></td>
                    <td class="asing_img_td this_link"><%=stdImg.getImage().getCreatedDate() != null ? formatter.format(stdImg.getImage().getCreatedDate()) : "" %><input type="hidden" value="<%=stdImg.getImage().getCreatedDate()%>"/></td>
                    <td class="asing_img_td this_link">
	                    <%
	                    	String userFullName = "";
	                    	User userObj = null;
							try {
								userObj = UserLocalServiceUtil.getUser(Long.parseLong(stdImg.getCreatorId()));
	                   		} catch(Exception e){
	                   			_log.error(e.getMessage());
	                   		}
							if(userObj != null) {
								userFullName = userObj.getFullName();
	                   		}
	                   	%>
	                   	<%=userFullName%><input type="hidden" value="<%=userFullName%>"/>
                    </td>
                    <td class="asing_img_td this_link">
                    	<p class="tiny_text">
                        <% 
                        List<StandardsChainImages> chainImages =  (List<StandardsChainImages>) stdImages.get(stdImg).get(0);
                        if(!StandardsUtil.isNullOrBlank(chainImages))
                        {
                            int imgCount = 0;
                        	for (StandardsChainImages chain : chainImages ) 
                           {
                        	    imgCount++;
                           %>
                             <%=chnCdMap.get(chain.getChainCode())%><%=imgCount>=chainImages.size()?"":", " %>
                        <% }
                        }	%>
                        </p>
                    </td>
                    <td class="asing_img_td this_link">
                    	<%
							List<String> rgnImages = (List<String>) stdImages.get(stdImg).get(2);
							Map<String,String> regionMap = BrandStandardsUtil.getRegions();
							String selectedRgnTitle = "";
                            if(!StandardsUtil.isNullOrBlank(rgnImages))
                            {
                             	int imgCount = 0;
                                for(String rgnImage : rgnImages)
                                {
                                	imgCount++;
                                    selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnImages.size()?"":", ");
                              	}
                            }
						 %>
                    	<p class="tiny_text">
                    		<%=selectedRgnTitle%>
                    	</p>
                    </td>
                    <td class="asing_img_td this_link">
                    	<% 
                            List<StandardsCountryImages> cntrImages = (List<StandardsCountryImages>) stdImages.get(stdImg).get(1);
							Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
							Map<String,String> cntryMap = null;
                          	String selectedCntrTitle = "";
 							if(!StandardsUtil.isNullOrBlank(cntrImages))
                            {
                            	int imgCount = 0;
                                    	    
                                for(StandardsCountryImages cntrImage : cntrImages)
                                {
                                	imgCount++;
									cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrImages.size()?"":", ");
                                }
                            }
                         %>
                    	<p class="tiny_text">
                    		<%=selectedCntrTitle%>
                    	</p>
                    </td>
                    <td class="asing_img_td this_link"><%=stdImg.getImage().getImageDesc()%><input type="hidden" value="<%=stdImg.getImage().getImageDesc()%>"/></td>
                </tr>
            <%  } 
            }%>
            
         </table>
         </label>
         <br/>
        <div class="clear"></div>
        <div class="divider">&nbsp;</div>
    <div class="clear"></div>
    <label class="wrapper_label"><span class="wrapper_span">Notes</span>             
			<p class="text_not_input"><%=standView.getStandard().getNotes()%></p>
	</label>
	<div class="clear"></div>
    <label class="wrapper_label"><span class="wrapper_span">Internal Reference</span>             
            <p class="text_not_input"><%=standView.getStandard().getInternalReference()%></p>
    </label>
	<div class="clear"></div>
    <label class="wrapper_label"><span class="wrapper_span">Primary Author</span>
		
		<% if(!StandardsUtil.IsNullOrBlank(standView.getPrimaryAuthor())) {%>
		<p class="text_not_input"><%=standView.getPrimaryAuthor().getAuthorName()%></p>
		<%}%>
	</label>
	<div class="clear"></div>
	<label class="wrapper_label"><span class="wrapper_span">Other Author</span>
		<% if(!StandardsUtil.isNullOrBlank(standView.getSecondaryAuthor())) {
			List<StandardsAuthors> standardsAuthors = standView.getSecondaryAuthor(); 
			int authorSize = 0;
	        %>
            <p class="text_not_input">          
            <%  
			for(StandardsAuthors standardsAuthor : standardsAuthors)
			{
		%>
				<%=standardsAuthor.getAuthorName()%>			
		<% 		authorSize ++;
				if(authorSize < standardsAuthors.size())
				{
		%>
					<span>,&nbsp;&nbsp;</span>			
		<%			
				}
			}
            %>
            </p>           
            <%          
		}
		%>
	</label>
	<div class="clear"></div>
	<label class="wrapper_label"><span class="wrapper_span">Standards Owner</span>
         <p class="text_not_input"><%=standView.getStandard().getBusinessOwner()%></p> 
    </label>
	<label class="wrapper_label" for="standard_category" title="standard_category label"><span class="wrapper_span">Category</span>
	     <span class="small_text">Source Category for this standard</span><br/>	
	     <% int iCount = 0;
	         for(String catgy : categoryMap.keySet()) {
				iCount++;
	      		if((iCount-1)%3==0) {
	      			if(iCount!=1) {		%>
	      					<div class="clear"></div>
	      		 <% }%>
	  				<div class="view_items_container">
	     		<%	} %>
	           <div class="view_row_item"><input id="standard_category_<%=catgy %>" class="standard_radio" type="radio" name="standard_category" <%=standView.getStandard().getCategory().equalsIgnoreCase(catgy)? "checked='checked'":"" %> value="1" readonly="readonly" onclick="return false;" onkeydown="return false;"/> <%=categoryMap.get(catgy)%></div>
				<%  if(iCount%3==0 || iCount==categoryMap.size())  { 	%>
	        		  </div>
	        	<%	}
	  		} %>
	</label>
	<div class="clear"></div>
    <% 		// Assign Flags Categories
			List<FlagStandards> selectedFlagStds = standView.getFlagStandards();
			Map<Long, String> flgctg = new LinkedHashMap<Long, String>();
			flgctg.put(new Long(30), "");
			if(StandardsUtil.hasBuildOperateFlag(selectedFlagStds))
			{
				//Add Hotle Lifecycle flag when Build & operate or only Build has assgined to standards
				flgctg.put(new Long(91), "");	
			}
			flgctg.put(new Long(20), "A set of stages tracking the guest experience before, during and after their stay in a hotel.");
			for(Long catId : flgctg.keySet())  {
			FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(catId);
			List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(catId);
			//CR 50.3 Changes
			if(!isStd && (standView.getStandard().getStdId() > 0 ) && (catId == 91) ) {
				//flagCategories = StandardsUtil.getSpecGuidelineFlags(standView.getStandard().getParentId(), flagCategories);	
			}
%>				                    
                   <div class="clear"></div>
                   <label class="wrapper_label"><span class="wrapper_span"><%=flagCategory.getTxtValue()%></span>
                   <span class="small_text"><%=flgctg.get(catId)%></span>
                   <%
                   		if(catId == 91)
                   		{
                   %>
                		<div class="ht_lifecycle view_items_container">			
                	<%
                	}
                	%>
                   <%	iCount = 0;
                   	for(FlagCategory flgOption : flagCategories) 
                   	{
						//CR 50.2 HotelLifecycle attribute list
						if(catId == 91) 
						{	
							 String flagDesc = StringPool.BLANK;
			             	if (flgOption.getFlagCatId() == 396)
		     	       		{
		                 		flagDesc = "Applicable to New Build hotels.  Hotels must comply at the appropriate point during construction, prior to opening.";   
		                 	}
		                 	else if (flgOption.getFlagCatId() == 477)
		                 	{
		                 		flagDesc = "Applicable to properties that are being converted to IHG. Hotels must comply prior to opening.";
		                 	}
		                 	else if (flgOption.getFlagCatId() == 478)
		                 	{
		                 		flagDesc = "Applicable to existing / operating IHG properties at the event of renovation.";
		                	}
		                	else if (flgOption.getFlagCatId() == 399)
		                	{
		                		flagDesc = "Applicable to existing / operating IHG properties at the event of replacement.";
		                	}
		                	else if (flgOption.getFlagCatId() == 479)
		                	{
		               			flagDesc = "Applicable to existing / operating IHG hotels now. Hotels may have until a date based compliance deadline to comply with the standard.";
		                	}
			             	if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
	                        {
			     %>      	
			     				<img id="<%=flgOption.getFlagCatId()%>" class="ht_active" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_active.png" title="<%=flagDesc%>"/>
			     <%			}
			     			else
			     			{
			     				if(isStd || (isSpec && standView.getStandard().getStdId() > 0 ) || (isGdln && standView.getStandard().getStdId() > 0 )) 
                          	  	{
			     %>			
			     				<img id="<%=flgOption.getFlagCatId()%>" class="ht_inactive" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_inactive.png"  title="<%=flagDesc%>"/>
				 <%				
				 				}	
			     			}	
				 		
						}
						else
						{
						iCount++;
           				if((iCount-1)%3==0) {
           					if(iCount!=1) 
           					{		
           		   %>
           					<div class="clear"></div>
           				<% }%>
       						<div class="view_items_container">
       			   <%	} 
                   		if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId())) 
                   		{		
                   	%>
                            	<div class="view_row_item"><input id="standard_applicability_<%=flgOption.getFlagCatId() %>" class="standard_radio" type="checkbox" name="standard_applicability" value="<%=flgOption.getFlagCatId()%>" checked='checked' readonly="readonly" onclick="return false;" onkeydown="return false;"/><%=flgOption.getTxtValue()%></div> 
                   <%		
                   		} 
                   		else 
                   		{ 
                   %>
                   			<div class="view_row_item"><input id="standard_applicability_<%=flgOption.getFlagCatId() %>" class="standard_radio" type="checkbox" name="standard_applicability" value="<%=flgOption.getFlagCatId()%>" readonly="readonly" onclick="return false;" onkeydown="return false;"/><%=flgOption.getTxtValue()%></div>
                   <%		
                   		}
                   		if(iCount%3==0 || iCount==flagCategories.size())  
                   		{ 	
                   %>
                   		</div>
                   <% 	}
					  }
                    }		
                   %>
                   <%
                   		if(catId == 91)
                   		{
                   %>
                		</div>			
                	<%
                	}
                	%>
                   <% if(catId.longValue()==20) {%>
                   		<% 	
                   			FlagCategory flagCategoryChild = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(21).get(0);
                   		%>
                   		<input id="standard_brand" class="standard_radio" type="checkbox" name="standard_brand" value="Y" readonly="readonly" onclick="return false;" onkeydown="return false;" <%=StandardsUtil.contains(selectedFlagStds, flagCategoryChild.getFlagCatId())? "checked":""%> />&nbsp;<%=flagCategory.getTxtValue()%>
                   <% } %>
                   </label>
      <% } %>
    <div class="clear"></div>       
    <label class="wrapper_label" for="standard_brand" title="standard_brand label">
    	<span class="wrapper_span">Applicable Brands</span>
    	<table id="status_by_brand_table" class="view_items_container" style="width: 650px">
			<tr class="status_brand_title">
	   			<td>Brands</td>
	       		<td>Status</td>
	       		<td>Last Published</td>
   			</tr>
		<%	List<ChainStandards> chainStandards = standView.getChainStandards();
			for(ChainStandards chainStandard : chainStandards) {
				String lstPublishDate = "";
				lstPublishDate = chainStandard.getLastPublishedDate() != null ? formatter.format(chainStandard.getLastPublishedDate()) : "";
		%>
			<tr>
				<td>
					<input id="standard_brand_<%=chainStandard.getChainCode()%>" class="standard_radio" type="checkbox" name="standard_brand" value="<%=chainStandard.getChainCode()%>" checked='checked' readonly="readonly" onclick="return false;" onkeydown="return false;"/>
					<%=chnCdMap.get(chainStandard.getChainCode())%>
				</td>
				<td><%=StandardsStatusUtil.getStatusById(chainStandard.getStatusId()).getTitle()%></td>
				<td><%=lstPublishDate%></td>
			</tr>
		<% } %>
        </table>
    </label>
     <div class="clear"></div>
    <label class="wrapper_label" for="standard_regions" title="standard_regions label"><span class="wrapper_span">Applicable Regions</span>
    	<% for(String regionCd : StandardsUtil.getRegions().keySet())	{	%>
        	<div class="clear"></div>
        	<div  class="view_items_container"><strong><%=StandardsUtil.getRegions().get(regionCd)%></strong></div>
        	<div class="clear"></div>
        	<% Map<String, String> allCountries = StandardsUtil.getCountries().get(regionCd);
        		iCount = 0;
        		for(String countryCd : allCountries.keySet())	{
        			iCount++;
        			boolean bFound = false;
        			List<CountryStandards> countryStnds = standView.getCountryStandards();
					for(CountryStandards countryStandard : countryStnds)	{	
						if(countryStandard.getCountry().equalsIgnoreCase(countryCd))	{
							bFound = true;
						}
					}
					if((iCount-1)%3==0) {
						if(iCount!=1) {		%>
							<div class="clear"></div>
						<% }%>
						<div class="view_items_container">
					<%	} 
					if(bFound)	{	%>
						<div class="view_row_item"><input id="standard_regions_<%=countryCd%>" class="standard_radio" type="checkbox" name="standard_regions" value="1" checked="checked" readonly="readonly" onclick="return false;" onkeydown="return false;"/> <%=allCountries.get(countryCd)%></div>
					<%} else {	%>
						<div class="view_row_item"><input id="standard_regions_<%=countryCd%>" class="standard_radio" type="checkbox" name="standard_regions" value="1" readonly="readonly" onclick="return false;" onkeydown="return false;"/> <%=allCountries.get(countryCd)%></div>
					<% }
					if(iCount%3==0 || iCount==allCountries.size())  { 	%>
	            	</div>
	            	<%	}
        		} 
        	}	%>
    </label>
      <div class="clear"></div>
                    <label class="wrapper_label" ><span class="wrapper_span">Historical Reference(s)</span>
                    <div class="clear"></div>
                        	<table id="file_links">
                                <tr class="spec_links_header">
                                    <td><strong>Brand</strong></td>
                                    <td><strong>Region</strong></td>
                                    <td><strong>Change Type</strong></td>
                                    <td><strong>Manual</strong></td>
                                    <td><strong>Title / Code</strong></td>
                                </tr>
                    <% 	List<StandardsHistoricalManual> assocManuals =  standView.getAssocStandardsHistoricalManuals();
                    	List<StandardsHistoricalManual> manuals = standView.getStandardsHistoricalManuals();
                        if(!StandardsUtil.isNullOrBlank(assocManuals)) {
                            for(StandardsHistoricalManual manual : assocManuals)
                            { 		%>
                                <tr>
                                    <td><%= StandardsUtil.decodeChainCode(manual.getChain())%></td>
                                    <td><%= StandardsUtil.decodeRegionCode(manual.getRegion())%></td>
                                    <td><%= StandardsUtil.decodeChangeCode(manual.getChange())%></td>
                                    <td><%= manual.getHistManualTitle()%></td>
                                    <td><%= manual.getTitle()%></td>
                                </tr>                           		
                    <%		}
                        }
                        if(!StandardsUtil.isNullOrBlank(manuals)) {
                            for(StandardsHistoricalManual manual : manuals)
                            { 		%>
                                <tr>
                                    <td><%= StandardsUtil.decodeChainCode(manual.getChain())%></td>
                                    <td><%= StandardsUtil.decodeRegionCode(manual.getRegion())%></td>
                                    <td><%= StandardsUtil.decodeChangeCode(manual.getChange())%></td>
                                    <td><%= manual.getHistManualTitle()%></td>
                                    <td><%= manual.getTitle()%></td>
                                </tr>                           		
                    <%		}
                        }
                        if(StandardsUtil.isNullOrBlank(assocManuals) && StandardsUtil.isNullOrBlank(manuals)) {
                    %>			<tr>
                     				<td colspan="3">No Historical Reference(s) found.</td>
                        		</tr>
                     <% } %>
                    	
                        </table>
                    </label>
     </span>
	<div class="clear"></div>
				<span id="second_step" class="step">
<% 				// Assign Flags Categories
				flgctg = new LinkedHashMap<Long, String>();
				flgctg.put(new Long(1), "Hotel Department(s) to which this standard will apply");
				flgctg.put(new Long(25), "The location(s) within the hotel to which this standard applies.");
				flgctg.put(new Long(35), "The department responsible for creating the standard.");
				flgctg.put(new Long(40), "");
				//flgctg.put(new Long(91), "");
				flgctg.put(new Long(92), "");
				flgctg.put(new Long(93), "");
				flgctg.put(new Long(500), "");
                if (standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD) || 
                    standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_SPEC) )
                {
                    flgctg.put(new Long(90), "");
                    flgctg.put(new Long(412), "");
                    flgctg.put(new Long(419), "");
                }
				for(Long catId : flgctg.keySet())  {
				FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(catId);
				List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(catId);
%>				                    
                    <div class="clear"></div>
                    <label class="wrapper_label" for="standard_applicability" title="standard_applicability label"><span class="wrapper_span"><%=flagCategory.getTxtValue()%></span>
                    <span class="small_text"><%=flgctg.get(catId)%></span>
                    <%	iCount = 0;
                    	for(FlagCategory flgOption : flagCategories) {
                    		iCount++;
            				if((iCount-1)%3==0) {
            					if(iCount!=1) {		%>
            					<div class="clear"></div>
            				<% }%>
        						<div class="view_items_container">
        			<%		} 
                    		if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId())) {		%>
                             	<div class="view_row_item"><input id="standard_applicability" class="standard_radio" type="checkbox" name="standard_applicability" value="<%=flgOption.getFlagCatId()%>" checked='checked' readonly="readonly" onclick="return false;" onkeydown="return false;"/><%=flgOption.getTxtValue()%></div> 
                    <%		} else { %>
                    			<div class="view_row_item"><input id="standard_applicability" class="standard_radio" type="checkbox" name="standard_applicability" value="<%=flgOption.getFlagCatId()%>" readonly="readonly" onclick="return false;" onkeydown="return false;"/><%=flgOption.getTxtValue()%></div>
                    <%		}
                    		if(iCount%3==0 || iCount==flagCategories.size())  { 	%>
                    		</div>
                    <% 		}	
                        }		%>
                    </label>
                 <% } %>
                  <div class="clear"></div>
                 <label class="wrapper_label" for="standard_change" title="standard_change label"><span class="wrapper_span">Change</span>
                    <span class="small_text">Is this Standard new, or a change to an existing Standard?</span><br/>	
                        	<% iCount = 0;
                        		for(String change : changeMap.keySet()) {
								iCount++;
	            				if((iCount-1)%3==0) {
	            					if(iCount!=1) {		%>
	            					<div class="clear"></div>
	            				<% }%>
	        						<div class="view_items_container">
            				<%	} %>
                                  <div class="view_row_item"><input id="standard_change_<%=change %>" class="standard_radio" type="radio" name="standard_change" readonly="readonly" onclick="return false;" onkeydown="return false;" <%=standView.getStandard().getChange().equalsIgnoreCase(change)? "checked='checked'":"" %> value="1" /><%=changeMap.get(change)%></div>
							
							<%  
								if((iCount-1)%3==0 || iCount==categoryMap.size())  { 	%>
			            		  </div>
			            	<%	}
							  } %>
                 </label>
                 	<div class="clear"></div>
                    <label class="wrapper_label"><span class="wrapper_span">Business Impact Assessment(s)</span><br/> 
                    	<table id="table_bia">
                                <tr class="spec_links_header">
                                    <td><strong>Brand</strong></td>
                                    <td><strong>Region</strong></td>
                                    <td><strong>Change from Regional</strong></td>
                                    <td><strong>P&L</strong></td>
                                    <td><strong>CapEx</strong></td>
                                    <td><strong>Implementation</strong></td>
                                    <td><strong>Comments</strong></td>
                                </tr>
                             <%  List<BusImpactAssmt> assmts = standView.getBusImpactAssmts();
		                        if(!StandardsUtil.isNullOrBlank(assmts)) {
		                            for(BusImpactAssmt assmt : assmts)
		                            { 
	                                    String changeReg = "";
	                                    if(assmt.getChangeFromRegional() != null && assmt.getChangeFromRegional() != "")
	                                    {
	                                        changeReg = FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(assmt.getChangeFromRegional())).getTxtValue();
	                                    }
		                            %>
	                                <tr>
	                                	<td><%=StandardsUtil.decodeChainCode(assmt.getChain())%></td>
	                                	<td><%= StandardsUtil.decodeRegionCode(assmt.getRegion())%></td>
                                        <td><%= changeReg%></td>
                                        <td><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(assmt.getProfileLossImpact())).getTxtValue()%></td>
	                                	<td><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(assmt.getCapExpenseImpact())).getTxtValue()%></td>
	                                	<td><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(assmt.getImplTimeScale())).getTxtValue()%></td>
                                        <td><%= assmt.getBiaComments()%></td>
	                                </tr>                           		
                    		<%		}
                        		} else { %>
	                        		<tr>
	                                	<td colspan="3">No Business Impact Assessment(s) found.</td>
	                            	</tr>
                            	<% }	%>
                            </table>
                   </label>
                 	<div class="clear"></div>
                    <label class="wrapper_label"><span class="wrapper_span">Attachments</span>
                    <span class="small_text">Attachments should be used to store documents that are only relevant to this standard and do not exit elsewhere within IHG. For example documents that are stored and maintained on Merlin should be referenced using links below.</span><br/><br/>
                        	<table id="file_attachments">
                                <tr class="spec_links_header">
                                    <td><strong>Type</strong></td>
                                    <td><strong>Title</strong></td>
                                    <td><strong>File</strong></td>
                                    <td><strong>Brands</strong></td>
                                    <td><strong>Region</strong></td>
                					<td><strong>Country</strong></td>
                            		<td><strong>Language</strong></td>
                                </tr>
                        <%
                        Map<AttachmentsStandards, List<List>> attachmentsLinks = standView.getAttachmentStandards();
                        if(!StandardsUtil.isNullOrBlank(attachmentsLinks)) {
                            for(AttachmentsStandards attachment : attachmentsLinks.keySet())
                            {
                                String fileName = attachment.getAttachmentPath();
                                String path = fileName.substring(0, fileName.lastIndexOf('/') + 1);
                                fileName = fileName.substring(fileName.lastIndexOf('/') + 1);
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(attachment.getLocaleCode()).getLocaleName();
                                path = path + HttpUtil.encodeURL(fileName);
                                String typeDescription = fileTypes.get(attachment.getType());
						%>
                                <tr>
                                	<td><%= typeDescription%></td>
                                    <td><%=attachment.getTitle()%></td>
                                    <td><a href="<%=path%>" title="file path"><%= fileName%></a></td>
                                    <td>
                                    	<p class="tiny_text">
                                		<%	int attachCount = 0; 
											List<ChainAttachmentsStandards> attachSubList = (List<ChainAttachmentsStandards>) attachmentsLinks.get(attachment).get(0);
                                			for (ChainAttachmentsStandards chain :  attachSubList) 
                                			{
                                			    attachCount++;
                                			    %>
                                			<%=chnCdMap.get(chain.getChainCode())%><%=attachCount>=attachSubList.size()?"":", " %>
                                		<% 	} %>
                                		</p>
                                	</td>
                                	<td>
                                		<%
										List<String> rgnAttch = (List<String>) attachmentsLinks.get(attachment).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    }
                                    	}
										%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                	</td>
                                	
                                	<td>
                                		<% 
                                    	List<AttachmentsStandardsCountry> cntrAttachList = (List<AttachmentsStandardsCountry>) attachmentsLinks.get(attachment).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrAttachList))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(AttachmentsStandardsCountry cntrImage : cntrAttachList)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrAttachList.size()?"":", ");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                                	</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%= attachment.getLocaleCode()%>"/></td>
                                </tr>
                              <%
                            } 
                        } else {
                        %>	<tr>
                                	<td colspan="3">No Attachment(s) found.</td>
                            </tr>
                        <% } %>
                            </table>
                    </label>
                    <div class="clear"></div>
                    <label class="wrapper_label"><span class="wrapper_span">Links</span>
                    <span class="small_text">Links should be used to reference relevant documentation on Merlin or external websites that are relevant to this standard. Enter a user friendly title for the link and then the web address for the document itself. Note: start each URL with http://www.</span><br/><br/>
                        	<table id="table_extl_links">
                                <tr class="spec_links_header">
                                    <td><strong>Title</strong></td>
                                    <td><strong>URL</strong></td>
                                    <td><strong>Brands</strong></td>
                                    <td><strong>Region</strong></td>
                					<td><strong>Country</strong></td>
                            		<td><strong>Language</strong></td>
                                </tr>
                    <% Map<ExternalLinkStandards, List<List>> assocExternalLinks = standView.getAssocExtLinkStandards();
                        if(!StandardsUtil.isNullOrBlank(assocExternalLinks)) {
                            for(ExternalLinkStandards link : assocExternalLinks.keySet())
                            {
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(link.getLocaleCode()).getLocaleName();
                     %>
                                <tr>
                                    <td><%=link.getTitle()%></td>
                                    <td><%=link.getUrl()%></td>
                                    <td><p class="tiny_text">
                                		<% 	int assoLinkCount = 0;
											List<ChainExternalLinkStandards> extlSubList = assocExternalLinks.get(link).get(0);
                                			for (ChainExternalLinkStandards chain :  extlSubList) 
                                			{
                                			    assoLinkCount++;
                                			    %>
                                			<%=chnCdMap.get(chain.getChainCode())%><%=assoLinkCount>=extlSubList.size()?"":", " %>
                                		<% 	} %>
                                		</p>
                                	</td>
                                	<td>
                                		<%
										List<String> rgnAttch = (List<String>) assocExternalLinks.get(link).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    }
                                    	}%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                	</td>
                               		<td>
                                		<%
                                		List<ExternalLinkStandardsCountry> cntrExtlLink = (List<ExternalLinkStandardsCountry>) assocExternalLinks.get(link).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrExtlLink))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(ExternalLinkStandardsCountry cntrImage : cntrExtlLink)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrExtlLink.size()?"":", ");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                               		</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%= link.getLocaleCode()%>"/>
                                	</td>
                                </tr>                           		
                    <%		}
                        }
                    %>
                   <% Map<ExternalLinkStandards, List<List>> externalLinks = standView.getExtLinkStandards();
                        if(!StandardsUtil.isNullOrBlank(externalLinks)) {
                            for(ExternalLinkStandards link : externalLinks.keySet())
                            { 
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(link.getLocaleCode()).getLocaleName();
                   %>
                                <tr>
                                    <td><%=link.getTitle()%></td>
                                    <td><%=link.getUrl()%></td>
                                    <td><p class="tiny_text">
                                		<%
                                			int linkCount = 0;
											List<ChainExternalLinkStandards> extlSubList2 = (List<ChainExternalLinkStandards>)externalLinks.get(link).get(0);
                                			for (ChainExternalLinkStandards chain : extlSubList2 ) 
                                			{
                                			    linkCount++;
                                			%>
                                			<%=chnCdMap.get(chain.getChainCode())%><%=linkCount>=extlSubList2.size()?"":", " %>
                                		<% 	} %>
                                		</p>
                                	</td>
                                	<td>
                                		<%
										List<String> rgnAttch = (List<String>) externalLinks.get(link).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    }
                                    	}%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                	</td>
                               		<td>
                                		<%
                                		List<ExternalLinkStandardsCountry> cntrExtlLink = (List<ExternalLinkStandardsCountry>) externalLinks.get(link).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrExtlLink))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(ExternalLinkStandardsCountry cntrImage : cntrExtlLink)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrExtlLink.size()?"":", ");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                               		</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%= link.getLocaleCode()%>"/>
                                	</td>
                                </tr>                           		
                    <%		}
                        }
                        if(StandardsUtil.isNullOrBlank(assocExternalLinks) && StandardsUtil.isNullOrBlank(externalLinks)) {
                   %>			<tr>
                             		<td colspan="3">No Link(s) found.</td>
                                </tr>
                   <% } %>
                            </table>
                   </label> 
                    <div class="clear"></div>
                    </span>
</div>
</div>
<%
	} else {
%>
	Not logged in !!
<%
	}
%>
<%!
	private static Log _log = LogFactoryUtil.getLog("BSAdmin-portlet.docroot.html.standards.viewDetail_jsp");
%>