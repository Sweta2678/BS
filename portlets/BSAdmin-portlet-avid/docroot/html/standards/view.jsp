<%@page import="com.ihg.brandstandards.db.model.ExternalLinkStandardsCountry"%>
<%@page import="com.ihg.brandstandards.db.model.AttachmentsStandardsCountry"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsCountryImages"%>
<%@page import="com.liferay.portal.kernel.log.Log"%>
<%@page import="com.liferay.portal.kernel.log.LogFactoryUtil"%>
<%@page import="com.ihg.brandstandards.util.BSAdminConstants"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsChainImages"%>
<%@page import="com.ihg.brandstandards.db.model.ChainAttachmentsStandards"%>
<%@page import="com.ihg.brandstandards.db.model.ChainExternalLinkStandards"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsRegionLocale"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsRegionLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.portlet.StandardsController"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsLocaleLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.util.UserPreferencesUtil"%>
<%@page import="com.ihg.brandstandards.db.NoSuchChainStandardsException"%>
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.ihg.brandstandards.db.service.StandardsStatusLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.service.ChainStandardsLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.liferay.portal.kernel.util.StringPool"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsAuthors"%>
<%@page import="com.liferay.portlet.documentlibrary.model.DLFileEntry"%>
<%@page import="com.liferay.portlet.documentlibrary.service.DLFileEntryLocalServiceUtil"%>
<%@page import="com.ihg.brandstandards.custom.model.Preferences"%>
<%@page import="java.util.ArrayList"%>
<%@include file="/html/standards/init.jsp" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<portlet:actionURL  name="Cancel" var="Cancel"/>
<portlet:resourceURL var="SaveStandard"  id="SaveStandard" />
<portlet:resourceURL var="crossReference"  id="CrossReference" />
<portlet:resourceURL var="searchUrl" id="searchUrl" />
<portlet:resourceURL var="changeOrder" id="changeOrder"/>

<%
long userId = PortalUtil.getUserId(renderRequest);
String allChainCode = "";
if (userId > 1)
{
	StandardsView standView = (StandardsView) request.getAttribute("StandardsView");
	Map<String, String> chnCdMap = BrandStandardsUtil.chainCodeMap();
   	boolean hasAccess = false;
   	List<String> brandListObj = (List<String>)request.getAttribute("brandListObj");
   	Preferences preferences = (Preferences)session.getAttribute("Preferences");
   	
    String prefRegionCode = "";
    String discontinuedFilter = "";
    String chainCode = "";
    if(preferences!=null)
    {
        prefRegionCode = preferences.getRegionCode();
    	discontinuedFilter = preferences.getDiscontinuedFilter();
    	chainCode = preferences.getBrand();
    }
    boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
    boolean isHotelLifeCycleAdmin = StandardsUtil.isHotelLifeCycleAdmin(user.getRoles());
    String userRgnCode = "";
    boolean isGlobal = false;
    if(isSuperAdmin == true)
    {
 	   userRgnCode = prefRegionCode;
 	   if(userRgnCode.equals("GLBL"))
 		{
 		   isGlobal = true; 
 		}
 	   if(prefRegionCode != null && !prefRegionCode.isEmpty())
 	   {
 		   hasAccess=true;
 	   }
    }
    else 
    {
 	   isGlobal =  StandardsUtil.isGlobalAuthor(user.getRoles());
    	userRgnCode = StandardsController.getRegionCodeFromUserRole(user.getRoles());
    	hasAccess =	standView.getStandard().getStdId() > 0 ? StandardsUtil.hasEditAccess(user, standView.getStandard()) : true;
    }
    
    Map<String, String> fileTypes = StandardsUtil.fileTypes();
    Map<String, String> changeMap = StandardsUtil.changeMap();
    Map<String, String> categoryMap = StandardsUtil.categoryMap();
    boolean isStd = standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_STANDARD);
    boolean isSpec = standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_SPEC);
    boolean isGdln =  standView.getStandard().getStdTyp().equals(StandardsUtil.STD_TYPE_GDLN);

    DateFormat formatter = new SimpleDateFormat("dd MMM yyyy");
  
    long regionId = StandardsRegionLocalServiceUtil.getStandardsRegionByRegionCode(userRgnCode).getRegionId();
    List<StandardsRegionLocale> regionLocales =	StandardsRegionLocaleLocalServiceUtil.getStandardsRegionLocaleByRegionId(regionId); 
%>

<script>
var stdId = <%= standView.getStandard().getStdId() %>;
var regionCode ="-1";
if(stdId>0) {
	regionCode = "<%= standView.getStandard().getRegionCode() %>";
}
var isStd = <%= isStd ? "true" : "false"%>;
var isGlobalAuthor = <%= isGlobal ? "true" : "false"%>;
<%if (isStd) { %>
    var recordType = "Standard";
<%} else if (isSpec) { %>
    var recordType = "Specification";
<%} else { %>
    var recordType = "Guideline";
<%} %>
var crossReferenceUrl = '<%=crossReference.toString()%>';
var searchStdUrl = '<%=searchUrl.toString()%>';
var stdType = '<%=standView.getStandard().getStdTyp()%>';
var changeOrder = '<%=changeOrder%>';


</script>


<!--items for jquery UI -->
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>
<link href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" rel="stylesheet" type="text/css" />
<script type="text/javascript" src="/BSTheme-theme/js/jquery.multiselect.min.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/jquery.validate.min-1.11.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.form.3.28.0.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bsstyle.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/jquery.multiselect.css"/>

<portlet:resourceURL var="imgGalleryUrl" id="getImgGalley"></portlet:resourceURL>
<!-- Tree -->
<portlet:resourceURL var="ajaxURL" id="getTreeData" escapeXml="false" />
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.jstreeStandard.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/!script.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.tablednd.min.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/standards.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/changeorder.js"></script>

<%-- <%@include file="/html/common/initmenu.jsp" %> --%>
<script type="text/javascript" src="/BSTheme-theme/js/hoverIntent.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/superfish.js"></script>
    
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/!style.css"/>
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/tree/custom/!style.css"/>

<!--ends jquery UI items -->
<%@include file="/html/common/countryregions.jsp" %>

<style>
.asing_img_td button.ui-multiselect
{
	width: 180px !important	;
}
/*Added For CR 50.3 Message to large when click on Restricted Hotle lifecycle flag*/
div.msgBoxContent {
	height: auto;
}

#Manual button.ui-multiselect {
   float: left;
}
#hotel_lifecycle.wrapper_label {
   clear: both;
}
</style>
<script type="text/javascript">
/* find selected country and set on ext link, suppoerting material, assign image */ 
var performCountryEvent = true;
jQuery(function() {
	
	if ( jQuery('ul.sf-menu').superfish() ) {
        jQuery('ul.sf-menu').superfish();
    }
    
    var nodeId = '';
    var nodeText = '';
    
    jQuery('.nyroModal').nyroModal({closeOnClick: false});
    
    jQuery('.open_tree_selection').click(function(){
        nodeId = '';
        nodeText = '';
        jQuery(".selected_tree_node").text('nothing yet'); 
        jQuery("#taxonomy_tree_details").click();
        jQuery('.modal_title_text').html("description");
        getTreeData('<%=renderResponse.encodeURL(ajaxURL.toString())%>', false);
        return false;
        
    });
    
    jQuery("#select_img_button").click(function(){
        /* check if brands assigned first. */
		var dependentValues = [];
        jQuery('input:checkbox[name="standard_brand"]:checked').each(function() {
	   		dependentValues.push(jQuery(this).val());
     	});
    	if(dependentValues.length > 0){
	        jQuery("#img_gallery_search").click();
	        jQuery(".img_modal_title_text").html("Image Search");
    	} else {
    		showPromptMessage("To assign image, Atleast one brand must be selected.");
    	}
        return false;
    });
    

});

function showFilterCount()
{
	/* DO NOT DELETE. Referenced from countryregion.js, this has to be blank here. */
	
}

</script>

<style>
span.step {
    border: 0px !important; 
    background: none !important; 
}
</style>

<div <c:choose><c:when test='<%=isSuperAdmin && !prefRegionCode.equals("GLBL")%>'> class='rounded_container stagingContent'</c:when> <c:otherwise>class='rounded_container'</c:otherwise></c:choose>>

        <div class="rounded_container_contents">

            <h4>
            <% if(standView.getStandard().getStdId() < 0) { %>
            	Add New 
            <% }else { %>
            	Edit
            <% }%>
            <%
               String recType = "Standard";
            
               if(isStd) { %>
            	Standard
                <input type="hidden" name="change_type_mew_msg" id="change_type_mew_msg" value="Are you sure this is a new Standard? Changing the value to 'new' will remove all historical references for this Standard." />
            <% }else if(isSpec) { 
                recType = "Specification";
            %>
             	Specification
                <input type="hidden" name="change_type_mew_msg" id="change_type_mew_msg" value="Are you sure this is a new Specification? Changing the value to 'new' will remove all historical references for this Specification." />
            <% } else {
                recType = "Guideline";
            %>
            	Guideline
                <input type="hidden" name="change_type_mew_msg" id="change_type_mew_msg" value="Are you sure this is a new Guideline? Changing the value to 'new' will remove all historical references for this Guideline." />
            <% } %>
            </h4>

            <div>
				<label class="header_label" title="Header Standard Text"><span class="header_span_title"><%=recType%> Text: </span>
				    <%
				       if(isStd || isSpec) { 
                           String title = standView.getStandard().getTitle() == null ? "" : standView.getStandard().getTitle();   
                           if (title.length() > 80)
                           {
                               title = title.substring(0, 77) + "...";
                           }
				    %>
				        <span class="header_span" id="header_rec_title"><%=title%></span>             
				    <% } else {
				           String desc = standView.getStandard().getDescription() == null ? "" : standView.getStandard().getDescription();   
				           if (desc.length() > 80)
				           {
				               desc = desc.substring(0, 77) + "...";
				           }
				    %>
				        <span class="header_span" id="header_rec_title" style="text-align:left;"><%=desc%></span>             
				    <% } %>
				</label>
            </div>
            <%if(standView.getStandard().getStdId() > 0) {%>
            <div class="clear_header"></div>
            <div>
				<label class="header_label" title="Header Standard Id"><span class="header_span_title"><%=recType%> ID: </span>
				    <span class="header_span"><%=standView.getStandard().getStdId() < 1 ? "" : standView.getStandard().getStdId()%></span>             
				</label>            
			</div>
			<%} %>
			<div class="clear"></div>

			<form id="new_standard_form" target="native-results" method="post" name="new_standard_form" action="<%=SaveStandard%>" class="standard_form" enctype="multipart/form-data">

            <input type="hidden" name="output" id="output" value="" />

            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_LINKS%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_DEL_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_DEL_LINKS%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_EDIT_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_FILE_EDIT_LINKS%>" value="" />
            
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_LINKS%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_DEL_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_DEL_LINKS%>" value="" />
			<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_EDIT_LINKS%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_URL_EDIT_LINKS%>" value="" />

            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_IMAGES%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_IMAGES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_IMAGES%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_EDIT_IMAGES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_EDIT_IMAGES%>" value="" />
            
            <input name="save_new_spec_add_another" id="save_new_spec_add_another" type="hidden" value="0" />

            <input type="hidden" name="global_std_ind" id="global_std_ind" value='N' />

            <input type="hidden" name="historical_manual_url" id="historical_manual_url" value='<portlet:resourceURL id="getHistoricalManual"></portlet:resourceURL>' />
            
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_MANUAL_REFERENCES%>" value="" />
            <input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_MANUAL_REFERENCES%>" value="" />
			
			<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_ID%>" id="<%=StandardsUtil.REQUEST_PARAM_ID%>" value="<%=standView.getStandard().getStdId()%>" />
			<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_OBJ_TYP%>" id="<%=StandardsUtil.REQUEST_PARAM_OBJ_TYP%>" value="<%=standView.getStandard().getStdTyp()%>" />
			<%  if(!isStd) { %>
				<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_STD_ID%>" id="<%=StandardsUtil.REQUEST_PARAM_STD_ID%>" value="<%=standView.getAssociatedStandard().getStdId()%>" />
			<% } %>
			<input type="hidden" name="hidden_comments_value" id="hidden_comments_value" value="" />
			<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_BIA_REFERENCES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_BIA_REFERENCES%>" value="" />
			<input type="hidden" name="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_BIA_REFERENCES%>" id="<%=StandardsUtil.REQUEST_PARAM_HIDDEN_DEL_BIA_REFERENCES%>" value="" />
            
            <input type="hidden" name="currUserName" id="currUserName" value="<%=user.getFullName()%>" />
			<!-- Added for CR 50.2 -->
			<input type="hidden" name="HotelLifecycle" id="HotelLifecycle" value='' />
			
            <% if(isGlobal && standView.getStandard().getStdId() < 0) { %>
                 <input type="hidden" name="standard_framework" id="standard_framework" value="Y" />
            <%} else {%> 
                 <input type="hidden" name="standard_framework" id="standard_framework" value="<%=StandardsUtil.getValueOrBlank(standView.getStandard().getFramework())%>" />
            <%} %> 

            <div id="accordion">
                <h3><em class="required">* </em>General Information</h3>
                
                <div class="field_wrapper">
				<span class="step" id="step_one">

                    <p class="small_text"><strong>Enter information</strong></p>
                    
					<% if(isStd || isSpec) { %>
					
                    	<label class="wrapper_label" for="standard_name" title="standard name label"><span class="wrapper_span_char_count"><em class="required">* </em>
                    	<% if(isStd) {
                    	%> Standard<a class="help_icon tooltip" href="javascript:return false;" title="standard help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard help icon" title="standard help"/>
                    	        <span class="classic">A measurable requirement that is critical to delivering the branded hotel experience.</span></a> 
						<% } else if(isSpec) { %>Specification<a class="help_icon tooltip" href="javascript:return false;" title="specification help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="specification help icon" title="specification help"/>
                    	        <span class="classic">A detailed, measurable description of the requirements that hotels must fulfil to meet a standard.</span></a>
						<% } %>
							</span>
                        	<textarea class="input_text required" name="standard_name" id="standard_name" maxlength="1000" <%= standView.getStandard().isTextTransExist()?"onblur='showTextPromptWithOption(stdTextTranslationMessage)'":""%>><%=StandardsUtil.getValueOrBlank(standView.getStandard().getTitle())%></textarea>
                        	<textarea style="display: none" id="std_name_orig"><%=StandardsUtil.getValueOrBlank(standView.getStandard().getTitle())%></textarea>             
                    	</label>
                    <% } else { %>
     						<input type="hidden" name="standard_name" id="standard_name" value="<%=StandardsUtil.STD_TYPE_GDLN%>" />
     						<label class="wrapper_label" for="standard_rationale" title="Guideline"><span class="wrapper_span"><em class="required">* </em>Guideline<a class="help_icon tooltip" href="javascript:return false;" title="standard status help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard status help icon" title="standard status help"/>
	                            <span class="classic">A recommended or suggested approach to be applied at the hotel's discretion</span></a></span>
	                            <textarea class="message required" name="standard_rationale" id="standard_rationale" maxlength="4000" style="overflow:auto" <%= standView.getStandard().isContextTransExist()?"onblur='showContextPromptWithOption(stdTextTranslationMessage)'":""%> ><%=StandardsUtil.getValueOrBlank(standView.getStandard().getDescription())%></textarea>
	                            <textarea id="standard_rationale_orig" style="display:none;" ><%=StandardsUtil.getValueOrBlank(standView.getStandard().getDescription())%></textarea>                        
                    	 	</label>					                                                    	
                    <% } %>    
     
                        <div class="select_image_span"><span>&nbsp;</span></div>
                        <label class="wrapper_label" title="select image label"><span class="wrapper_span_no_padding_top">Assign Image<a class="help_icon tooltip" href="javascript:return false;" title="select image help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="select image help icon" title="select image help"/>
                            <span class="classic">Use Assign Images for mandatory content that is best or most succinctly expressed in image form.  Assign Images is also the suggested solution for table data.  Textual Standard or Specification text is required together with the image content.  Images can be reordered once assigned.</span></a></span>
                            <% if(hasAccess) { %>
                            	<div class="button select_image" id="select_img_button"><a href="#" class="select_image" title="Assign Images button">Assign Images</a><span></span></div>
                            <% } %>                        
                        </label>
    
                        <div class="clear"></div>

                        <table id="assign_images" summary="Data table for assigned images.">
                            <tr class="spec_links_header nodrop nodrag">
                                <td style="display:none;"></td>
                                <td><strong>Thumbnail</strong></td>
                                <td><strong>Title</strong></td>
                                <td><strong>ID</strong></td>
                                <td><strong>Upload Date</strong></td>
                                <td><strong>Author</strong></td>
                                <td><strong>Brand</strong></td>
                                <td><strong>Region</strong></td>
                                <td><strong>Country</strong></td>
                                <td><strong>Description</strong></td>
                                <td></td>
                            </tr>
                            <% Map<StandardsImages, List<List>> stdImages = standView.getAssignImages();
                            if (!StandardsUtil.isNullOrBlank(stdImages))
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
                                    <td style="display:none;" class="asing_img_td this_link"><%=stdImg.getStdImageId()%><input type="hidden" value="~~~id:<%=stdImg.getStdImageId()%>"/></td>
                                    <td style="display:none;" class="asing_img_td img_sort_order this_link"><input type="hidden" value="1"/></td>
                                    <td class="asing_img_td this_link">
                                      <a href="/image/image_gallery?uuid=<%=stdImg.getImage().getImageUuId() %>&groupId=<%=themeDisplay.getScopeGroupId() %>"  onclick="window.open (this.href, '_blank', 'height = 400, width = 650, resizable = yes'); return false;">
                                        <img src="<%=smallImageURL%>" title="image <%=stdImg.getImage().getImageId()%>" alt="image <%=stdImg.getImage().getImageId()%>" /> 
                                        <!--  width="< %=image.getWidth()% >" height="< %=image.getHeight()% >"/> -->
                                      </a>
                                      <input type="hidden" value="img_id=<%=stdImg.getImageId()%>" />
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
                                    		} catch(Exception e) {
                                    			_log.error(e.getMessage());
                                    		}
											if(userObj != null) {
												userFullName = userObj.getFullName();
                                    		}
                                    	%>
                                    	<%=userFullName%><input type="hidden" value="<%=userFullName%>"/>
                                    </td>
                                    <td class="asing_img_td this_link">
                                    	<% 
                                    	List<StandardsChainImages> chainImages = (List<StandardsChainImages>) stdImages.get(stdImg).get(0);
                                    	String selectedBrandTitle = "";
                                	    String selectedBrandCode = "";
                                    	if(!StandardsUtil.isNullOrBlank(chainImages))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(StandardsChainImages chainImage : chainImages)
                                    	    {
                                    		    imgCount++;
                                    		    selectedBrandTitle += chnCdMap.get(chainImage.getChainCode()).concat(imgCount>=chainImages.size()?"":", ");
                                    		    selectedBrandCode += chainImage.getChainCode().concat(imgCount>=chainImages.size()?"":",");
                                    	   }
                                  		}
                                    	%>
                                    	<p class="tiny_text"><%=selectedBrandTitle%></p>
	                                    <input type="hidden" id="img_selected_brand<%=stdImg.getImageId()%>" value="<%=selectedBrandCode%>"/>
	                                    <div id="btn-select-brand<%=stdImg.getImageId()%>" >
	                                    	<a href="#"><img alt="edit brands" src="/BSTheme-theme/images/edit_pencil_icon.png" title="edit brand"></a>
	                                    </div>
	                                    <script type="text/javascript">populateSelectBrandPopUp("btn-select-brand",<%=stdImg.getImageId()%>,"img");</script>
									
									</td>
									<td class="asing_img_td this_link">
										<%
										List<String> rgnImages = (List<String>) stdImages.get(stdImg).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    String selectedRgnCode = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnImages))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnImages)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnImages.size()?"":", ");
                                    	    	 selectedRgnCode += rgnImage.concat(imgCount>=rgnImages.size()?"":",");
                                    	    }
                                    	}
										%>
										<p class="tiny_text"><%=selectedRgnTitle%></p>
										<input type="hidden" id="img_selected_rgn<%=stdImg.getImageId()%>" value="<%=selectedRgnCode%>"/>
										<div id="btn-select-rgn<%=stdImg.getImageId()%>">
	                                    	<a href="#"><img alt="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" title="edit regoin"></a>
	                                    </div>
										<script type="text/javascript">populateSelectRegionPopUp("btn-select-rgn",<%=stdImg.getImageId()%>,"img"); </script> 
									</td>
									<td class="asing_img_td this_link">
										<% 
                                    	List<StandardsCountryImages> cntrImages = (List<StandardsCountryImages>) stdImages.get(stdImg).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                	    String selectedCntrCode = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrImages))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(StandardsCountryImages cntrImage : cntrImages)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrImages.size()?"":", ");
                                    		    selectedCntrCode += cntrImage.getCountryCode().concat(imgCount>=cntrImages.size()?"":",");
                                    	   }
                                  		}
                                    	%>
                                    	<p class="tiny_text"><%=selectedCntrTitle%></p>
										<input type="hidden" id="img_selected_cntr<%=stdImg.getImageId()%>" value="<%=selectedCntrCode%>"/>
										<div id="btn-select-cntr<%=stdImg.getImageId()%>">
											<a href="#"><img alt="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" title="edit country"></a>
										</div>
										<script type="text/javascript">populateSelectCountryPopUp("btn-select-cntr",<%=stdImg.getImageId()%>,"img");</script>
									</td>
                                    <td class="asing_img_td this_link"><%=stdImg.getImage().getImageDesc()%><input type="hidden" value='<%=StandardsUtil.IsNullOrBlank( stdImg.getImage().getImageDesc()) ? " " : stdImg.getImage().getImageDesc() %>'/></td>
                                    <td>
                                    <% if(hasAccess && stdImg.getIsTranslationExist()) { %>
                                        <img class="delete" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete" onclick="showPromptMessage(stdImageTranslationMessage);" />
                                    <% } else if(hasAccess) { %>
                                    	<img class="delete_this_image" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/>
                                    <% } %>
                                    </td>
                                </tr>
                            <%  } 
                            }%>
                         </table>
                         <br/>
    
                        <div class="file_uploader_advice"><em class="required">Click the Assign Images button above to add more images.</em></div>
                        <div class="clear"></div>
                        <div class="divider">&nbsp;</div>
     
					<% if(isStd || isSpec) { %>
                    		<label class="wrapper_label" for="standard_rationale" title="standard rationale label"><span class="wrapper_span_char_count">Context<font><span class="span_spacer"></span></font></span>
                    			<textarea class="message" name="standard_rationale" id="standard_rationale" maxlength="4000" style="overflow:auto" <%= standView.getStandard().isContextTransExist()?"onblur='showContextPromptWithOption(stdContextTranslationMessage)'":""%> ><%=StandardsUtil.getValueOrBlank(standView.getStandard().getDescription())%></textarea>
                    			<textarea id="standard_rationale_orig" style="display: none;" ><%=StandardsUtil.getValueOrBlank(standView.getStandard().getDescription())%></textarea>                        
                    		</label>
					<% } %>
     
                    <label class="wrapper_label" for="standard_supporting_notes" title="standard supporting notes label"><span class="wrapper_span_char_count">Notes<font><span class="span_spacer"></span></font></span>
                    		<textarea class="message" name="supporting_notes" id="standard_supporting_notes" maxlength="4000" style="overflow:auto"><%=StandardsUtil.getValueOrBlank(standView.getStandard().getNotes())%></textarea>                        
                    </label>

                    <label class="wrapper_label" for="internal_reference" title="internal reference label"><span class="wrapper_span_char_count">Internal Reference<font><span class="span_spacer"></span></font></span>
                            <input type="text" class="input_text" name="internal_reference" id="internal_reference" maxlength="50" value="<%=StandardsUtil.getValueOrBlank(standView.getStandard().getInternalReference())%>"/>                    
                    </label>
					<div class="clear"></div>
					<% 
					boolean showOtherAuthors = standView.getStandard().getStdId() > 0;
					%>
                    <label class="wrapper_label" for="standard_author" title="Author"><span class="wrapper_span"><em class="required">* </em>Primary Author<a class="help_icon tooltip" href="javascript:return false;" title="standard author help tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard author help icon" title="standard author help"/>
                            <span class="classic">The Author is the individual in the business responsible for writing the standard (also known as Content Owner, SME or Author).   The CMS automatically stores the name of the individual who creates the standard.  Any external resource used for technical writing skills is not the Author and should not be selected as such.</span></a></span>

                    	<select id="standard_author" name="standard_author" title="This field is required." class="single_select required">

                        	<option value="">Select</option>
							<%
								String defaultAuthor = standView.getStandard().getAuthor();
								if(!StandardsUtil.IsNullOrBlank(standView.getPrimaryAuthor()))
								{
									defaultAuthor = standView.getPrimaryAuthor().getAuthorName();
								} 
								List<User> authors = standView.getAuthors();
								for(User author : authors)
								{
									if(!StandardsUtil.IsNullOrBlank(defaultAuthor) && author.getFullName().equalsIgnoreCase(defaultAuthor)) {
									    showOtherAuthors = true;
							%>
                        				<option value="<%=author.getFullName()%>" selected="selected"><%=author.getFullName()%></option>
							<%		} else	{
							%>
	                        		<option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
							<%		}
								}
							%>
                        </select>

                    </label>
                    
                    <label class="wrapper_label secondary_author_cont" for="secondary_author" title="secondryauthor" <%=showOtherAuthors ? "" : "style='display:none;'" %> ><span class="wrapper_span">Other Author<a class="help_icon tooltip" href="javascript:return false;" title="standard author help tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard author help icon" title="standard author help"/>
                         <span class="classic">Standard writing expert, either internal or external, who liaises with relevant Business Owner / SME and Framework lead with responsiblity for drafting, editing and formatting standards, specifications, relevant guidelines / instructions / recommendations etc in line with the agreed writing principles.</span></a></span>

                    	<select id="secondary_author" name="secondary_author" title="Secondary Authors" class="multis combo_select_width" multiple="multiple">
							<%
								authors = standView.getAuthors();
								for(User author : authors)
								{
									boolean bFound = false;
									if(!StandardsUtil.isNullOrBlank(standView.getSecondaryAuthor()))
									{
										for(StandardsAuthors secondaryAuthor : standView.getSecondaryAuthor())
										{
											if(author.getFullName().equalsIgnoreCase(StandardsUtil.getValueOrBlank(secondaryAuthor.getAuthorName())))
											{
												bFound = true;
												break;
											}
										}
									}
									if(bFound)	{
							%>			<option value="<%=author.getFullName()%>" selected="selected"><%=author.getFullName()%></option>
							<%		}
									else	{
							%>			<option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
							<%		}
								}
							%>
                        </select>
                    </label>
                    
					<label class="wrapper_label" for="standard_bus_owner" title="standard bus owner label"><span class="wrapper_span"><em class="required">* </em>Standards Owner<a class="help_icon tooltip" href="javascript:return false;" title="standard bus owner help icon tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard bus owner help icon" title="standard bus owner help"/>
                            <span class="classic">IHG Function / Enterprise / Department that has ultimate responsibility for a standard, its testing, implementation / roll out and any reviews of / changes to it during drafting, testing and post implementation.</span></a></span>                

                        <select id="standard_bus_owner" class="single_select required" name="standard_bus_owner" title="standard bus owner select">

                        	<option value="To Be Assigned">Select</option>

                        	<%
								List<User> businessOwners = standView.getBusinessOwners();
								for(User businessOwner : businessOwners)
								{
									if(businessOwner.getFullName().equalsIgnoreCase(StandardsUtil.getValueOrBlank(standView.getStandard().getBusinessOwner())))
									{
							%>
                        				<option value="<%=businessOwner.getFullName()%>" selected="selected"><%=businessOwner.getFullName()%></option>
							<%
									}
									else
									{
							%>
										<option value="<%=businessOwner.getFullName()%>"><%=businessOwner.getFullName()%></option>
							<%
									}
								}
							%>

                        </select>        

                    </label>
                    
                    <label class="wrapper_label" for="standard_category" title="standard category label"><span class="wrapper_span"><em class="required">* </em>Category<a class="help_icon tooltip" href="javascript:return false;" title="standard category tooltip"><img src="/BSTheme-theme/images/help.png" alt="standard category icon" title="standard category"/>
                            <span class="classic">Category enables the standards database to be filtered with additional categories added when required.</span></a></span>

                    	<select id="standard_category" class="single_select required" name="standard_category" title="This field is required.">

                        	<option value="">Select</option>
							<% for(String catgy : categoryMap.keySet()) {%>                        	
                            	<option value="<%=categoryMap.get(catgy)%>" <%=StandardsUtil.getValueOrBlank(standView.getStandard().getCategory()).equalsIgnoreCase(categoryMap.get(catgy))? "selected='selected'":""%> ><%=categoryMap.get(catgy)%></option>
							<% } %>
                        </select>

                    </label>

                    <%
						// Manual
						List<FlagStandards> selectedFlagStds = standView.getFlagStandards();
                   		List<FlagStandards> childFlagStds = standView.getChildFlagStandards();
						List<FlagStandards> assocFlagStds = standView.getAssocFlagStandards();
						FlagCategory flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(30);
                    	List<FlagCategory> flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(30);
                    	String restrictedManus = StandardsUtil.restrictManual(childFlagStds, flagCategories);
					%>
                        <label id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span"><em class="required">* </em><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>                
                            <select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis required" multiple="multiple" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="This field is required.">
                                <%
	                               	for(FlagCategory flgOption : flagCategories)
	                               	{
	                               		if (isStd || (assocFlagStds != null && StandardsUtil.contains(assocFlagStds, flgOption.getFlagCatId())))
	                               		{ %>
	                                	 	<option value="<%=flgOption.getFlagCatId()%>" <% if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId())) {%>selected="selected" <%} %>><%=flgOption.getTxtValue()%></option>
	                          			<%}
	                               	}
								%>
                            </select>           
                        </label>
                        
                        <%                     
                        	// Hotel Lifecycle
							flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(91);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(91);
							String hotelLifeCycle = StandardsUtil.restrictManual(childFlagStds, flagCategories);
							if(!isStd && (standView.getStandard().getStdId() > 0 )) {
								//flagCategories = StandardsUtil.getSpecGuidelineFlags(standView.getStandard().getParentId(), flagCategories);	
							}
						%>
                        <label id ="hotel_lifecycle" class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                        <span class="wrapper_span"><em class="required">* </em><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                               <input type="hidden" id="restrictId" value="<%=hotelLifeCycle %>" />
                               <div class="ht_lifecycle">
			                     <%
				                    for(FlagCategory flgOption : flagCategories)
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
								<%
								       }
		                               else
		                               {
		                            	 // if(isStd || (isSpec && standView.getStandard().getStdId() > 0 ) || (isGdln && standView.getStandard().getStdId() > 0 )) 
		                            	 // {
		                         %>		
										<img id="<%=flgOption.getFlagCatId()%>" class="ht_inactive" src="/BSTheme-theme/images/<%=flgOption.getFlagCatId()%>_inactive.png"  title="<%=flagDesc%>"/>
								 <%     
		                            	   //}
		                         	   }	
								    }
	                             %>	
								
							  </div>
                            
                        </label>
                        
                     <%
						// Guest Journey
						flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(20);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(20);
%>
                        <label class="wrapper_label clear_both" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span"><em class="required">* </em><%=flagCategory.getTxtValue()%><a class="help_icon tooltip" href="javascript:return false;" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> tooltip"><img src="/BSTheme-theme/images/help.png" alt="<%=flagCategory.getTxtValue().replaceAll(" ","")%> icon" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> help"/>
                                <span class="classic">A set of stages tracking the guest experience before, during, and after their stay in a hotel. Guest Journey stages may include "Check in", "My room", and "Departure".</span></a></span>                
                            <c:choose>
                            
                            	<c:when test="${isCopyAllowed eq true}">
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" 
                            		title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" 
                            		title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select">
                            	</c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>
                     <%
						// outside of guest journey
						flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(21);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(21);
						boolean bFound = false;
                    	for(FlagCategory flgOption : flagCategories)
                    	{
                            if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
                            {
                            	bFound = true;
                            	break;
                            }
                    	}
                   
					%>
                          <input type="checkbox" class="input_checkbox" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" value="<%=flagCategories.get(0).getFlagCatId()%>" <%=bFound?"checked":""%> title="<%=flagCategory.getTxtValue()%>" /> <%=flagCategory.getTxtValue()%>
                    </label>

                    <label class="wrapper_label" for="standard_regions" title="standard regions label"><span class="wrapper_span">Applicable Regions<font><span class="span_spacer"></span></font></span>

                    	<select id="standard_regions" name="standard_regions" title="standard regions select" multiple="multiple" size="4"> 
                        </select>

                    </label>

                    <label class="wrapper_label" for="select-from" title="select from label"><span class="wrapper_span"><em class="required">* </em>Countries (Add at least one)<font><span class="span_spacer"></span></font></span>

                            <div class="countries_cont_left">

                                <a href="javascript: return false;" class="move_countries" id="add_all_countries" title="move countries">Click here to add all countries</a><br/>

                                <select class="multi_add sel_countries_select" name="selectfrom" id="select-from" title="add countries select" multiple size="5">
                                </select>

                            </div>

                            <div class="countries_cont_middle">

                                <div class="add_remove_icons">

                                <a class="move_item" href="JavaScript:void(0);" id="btn-add" title="add item">Add &raquo;</a>

                                <a class="move_item" href="JavaScript:void(0);" id="btn-remove" title="remove item">&laquo; Remove</a>

                                </div>

                            </div>

                            <div class="countries_cont_right">

                                <a href="javascript: return false;" class="remove_countries" id="remove_all_countries" title="remove all countries">Click here to remove all countries</a><br/>

                                <select class="multi_remove required sel_selected_countries" name="selectedcountries" id="selectedcountries" multiple size="5" title="This field is required.">
                                </select>

                            </div>

                            <div class="clear"></div>

                    </label>
                    
					<% 
				    List<ChainStandards> selectedChainStnds = standView.getChainStandards();
					if(isStd) { %>
                    <label class="wrapper_label" for="tree_selection" title="tree selection label"><span class="wrapper_span"><em class="required">* </em>Select an Index Position<font><span class="span_spacer"></span></font></span>

                        <a class="open_tree_selection_link open_tree_selection"  title="tree selection link">Select or Change Index Position</a>

                    	<input type="text" value="<%=standView.getTaxonomyTitle()!=null? standView.getTaxonomyTitle():""%>" id="tree_selection" class="input_text open_tree_selection required" readonly="readonly" title="Select Index" />
                    	
                    	<input type="hidden" value="<%=standView.getTaxonomyStandards()!=null? standView.getTaxonomyStandards().getTaxId():""%>" id="taxonomyId" name="taxonomyId"  />
                        <input type="hidden" value="true" id="taxonomyChanged" name="taxonomyChanged" />
                    </label>

					<% } %>

					<div class="clear"></div>
					</span>
					</div>

				 <h3><em class="required">* </em>Manage Status by Brand</h3>
				 
				 
						
					<div>
					 
                	<table id="status_by_brand_table">
                    	<tr class="status_brand_title">
                        	<td>Brands</td>
                            <td>Status</td>
                            <td>Last Published</td>
                        </tr>
                       
                        <% 
                        String preferedBrand = chainCode;
						for(String chncode : chnCdMap.keySet()) {
						    String standardStatus = StandardsStatusUtil.getStatusDescByCode(standView.getDefaultStatusCode());
						    if(isStd || (StandardsUtil.contains(standView.getAssocChainStandards(), chncode)))
						    {
						%>		
								<tr>
						<%
							String lstPublishDate = "";
							boolean checked = false;
							if(StandardsUtil.contains(selectedChainStnds, chncode)) 
                            { 
								for(ChainStandards currChainStd : selectedChainStnds)
								{
								    if(currChainStd.getChainCode().equals(chncode)) 
								    {
							    		standardStatus = StandardsStatusLocalServiceUtil.getStandardsStatus(currChainStd.getStatusId()).getTitle();
							    		lstPublishDate = currChainStd.getLastPublishedDate() != null ? formatter.format(currChainStd.getLastPublishedDate()) : "";
								    }
								}
								checked = true;
						%>
								<td><input type="checkbox" name="standard_brand" id="standard_brand<%=chncode%>"  class="status_brand_checkbox" checked="checked" value="<%=chncode%>" onchange="showStatusByBrand('<%=chncode%>','<%=standardStatus %>'),displayBrandStatusMessage();"/> <%=chnCdMap.get(chncode)%></td>
                      	<%  } else { %>
	                        	<td><input type="checkbox" name="standard_brand" id="standard_brand<%=chncode%>" class="status_brand_checkbox" value="<%=chncode%>" onchange="showStatusByBrand('<%=chncode%>','<%=standardStatus %>'),displayBrandStatusMessage();"/> <%=chnCdMap.get(chncode)%></td>
                    		<% 	} 
							if (isSuperAdmin || standView.isApprover())  
                            {
                                List<StandardsStatus> statuses = StandardsStatusUtil.getStatuses(user, isSuperAdmin, standView.getStandard().getStdId() > 0 ? standView.getStandard().getRegionCode() : userRgnCode);
                    %>
                                <td>
                                <select name="standard_status<%=chncode%>" id="standard_status<%=chncode%>" title="Status" <%=!checked?"style='display: none;'":""%> >
                                <% for(StandardsStatus status : statuses) 
                                    {
                                %>  
                                    <option  value="<%=status.getStatusId()%>" <%=standardStatus.equals(status.getTitle())?"selected='true'":""%>><%=status.getTitle()%></option>
                                <%  }   %>
                                </select>
                                </td>
                   <%       } else {
                   %>
                                 <td><p id="<%=chncode%>"><%=standardStatus %></p></td>
                    <%      }
                    %>
                            <td><%=lstPublishDate%></td>
                            </tr>
                    <%    }
                    %>
                    <% 
                    } %>
                   </table>
                   <div id="status_by_brand_message" style="display:none;color:red;">At least one brand must apply</div>
                   <input type="hidden" value="<%=preferedBrand %>" name="selectedBrand" id="selectedBrand"/>
                <div class="clear"></div>

                    
                <%  List<StandardsHistoricalManual> assocManuals =  standView.getAssocStandardsHistoricalManuals();
                List<StandardsHistoricalManual> manuals = standView.getStandardsHistoricalManuals();
                if(!(isGlobal && (StandardsUtil.isNullOrBlank(assocManuals) && StandardsUtil.isNullOrBlank(manuals))))
                {
            %>
            </div>                
            <h3><% if(!isGlobal){ %>
                        <em class="required">* </em>
                    <% } %>
                        Historical References</h3>
                   <div class="field_wrapper">
                	<span class="step" id="step_four">
                    <%  if(!isGlobal)
                		{ 
                	%>
                        <% if(isStd) { %>
                        	<p class="italic_text">Is this Standard new, or a change to an existing Standard?</p>
                        <% } else if(isSpec) { %>
                        	<p class="italic_text">Is this Specification new, or a change to an existing Specification?</p>
                        <% } else {%>
                        	<p class="italic_text">Is this Guideline new, or a change to an existing Guideline?</p>
                        <% } %>
                        <label class="wrapper_label" for="standard_change" title="Change label"><span class="wrapper_span"><em class="required">* </em>Change<font><span class="span_spacer"></span></font></span>
                        <select id="standard_change" name="standard_change" class="single_select" title="This field is required.">
                            <%
                            if(standView.getStandard().getStdId() < 0 || StandardsUtil.IsNullOrBlank(standView.getStandard().getChange())) 
                            { 
                            %>                       
                            <option value="NEW" <%="NEW".equals(StandardsUtil.getValueOrBlank(standView.getStandard().getChange()))? "selected='selected'":""%> >New</option>
                            <%
                            } 

                            if( standView.getStandard().getStdId() < 0 || (standView.getStandard().getStdId() > 0 && StandardsUtil.isNullOrBlank(assocManuals) && StandardsUtil.isNullOrBlank(manuals))) 
                            { 
                            %>
                            <option value="NEW" <%= (standView.getStandard().getStdId() < 0 || "NEW".equals(StandardsUtil.getValueOrBlank(standView.getStandard().getChange())))? "selected='selected'":""%> >New</option>
                            <%
                            } 
                            %>
                            <option value="NO_CHANGE" <%="NO_CHANGE".equals(StandardsUtil.getValueOrBlank(standView.getStandard().getChange()))? "selected='selected'":""%> >No change</option>
                            <option value="TEXT_CHANGE" <%="TEXT_CHANGE".equals(StandardsUtil.getValueOrBlank(standView.getStandard().getChange()))? "selected='selected'":""%> >Textual change</option>
                            <option value="MATERIAL_CHANGE" <%="MATERIAL_CHANGE".equals(StandardsUtil.getValueOrBlank(standView.getStandard().getChange()))? "selected='selected'":""%> >Material change</option>
                        </select>
                    	</label>
                    	<div class="clear"></div>
					<% } %>
                    <div class="hidden_form_contents" <%=(StandardsUtil.getValueOrBlank(standView.getStandard().getChange()).equals("NEW") && !isGlobal) ?"style='display:none;'":""%> >

                    <% 
                
                    if(!isGlobal)
                		{ 
                	%>
                    <div class="divider">&nbsp;</div>
                        <p class="italic_text">Filter Historical Sources</p>
                        <p class="file_instructions">1. Select Brand(s) > 2. Select Region(s) > 3. Select the Manual Type</p>
                    
                        <label class="wrapper_label" for="manuals_brand" title="manual brand label"><span class="wrapper_span">Applicable Brands<font><span class="span_spacer"></span></font></span>
                            <div class="brands">
                            <select id="manuals_brand" class="multis combo_select_width" name="manuals_brand" title="manual brand select" multiple="multiple">
                            
                            <%
                        
                             selectedChainStnds = standView.getChainStandards();
                             if(!isStd)
                                {
                                    for(String chncode : chnCdMap.keySet())
                                    {
                                        List<ChainStandards> assocChainStds = standView.getAssocChainStandards();
                                        for(ChainStandards chainstd : assocChainStds)
                                        {
                                            if(chainstd.getChainCode().equalsIgnoreCase(chncode))
                                            {
                             %>
                                            <option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option>
                            <%                                                  
                                            }
                                        }
                                    }
                                }
                                else
                                {
                                    for(String chncode : chnCdMap.keySet())
                                    {
                                %>
                                    <option value="<%=chncode%>"><%=chnCdMap.get(chncode)%></option>
                                <%                                                  
                                    }
                                }
                            %> 
                            </select>
                            </div>
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="manuals_regions" title="manual regions label"><span class="wrapper_span">Applicable Regions<font><span class="span_spacer"></span></font></span>
                            <select id="manuals_regions" name="manuals_regions" title="manuals regions select" multiple="multiple" size="4">
                            </select>
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="manual_type" title="Manual Type label"><span class="wrapper_span">Manual Type<font><span class="span_spacer"></span></font></span>                
                            <select id="manual_type" class="multis" name="manual_type" title="manual type select">
                                <option value="OFFCL_STND_MNL">Official Standards Manual</option>
                                <option value="RSRCS">Resources</option>
                                <option value="GDLN">Guidelines</option>
                                <option value="SPCFCTN">Specifications</option>
                                <option value="OTHER">Other</option>
                            </select>        
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" title="Historical Manual button label"><span class="wrapper_span">&nbsp;</span>  
                            <div class="button"><a href="#" class="filter_contents" title="Historical Manual filter button">Filter</a><span></span></div>
                        </label> 
                        <div class="clear"></div>
                        <div class="divider">&nbsp;</div>
                        
                        <p class="italic_text">Add Historical Reference(s)</p>
                        <p class="file_instructions">1. Select the manual > 2. Select the type of change from this manual > 3. Add a reference to the historical standard > 4. Click 'Add Reference'</p>
                        
                        <label class="wrapper_label" for="brand_manual" title="Brand Manual label"><span class="wrapper_span">Brand Manual<font><span class="span_spacer"></span></font></span>
                            <select id="brand_manual" name="brand_manual" class="single_select combo_select_width" title="Brand Manual Select">
                                <option value="">Click the filter button</option>
                            </select>
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="change_type" title="Change type from selected manual label"><span class="wrapper_span">Change type from<font><span class="span_spacer"></span></font></br/> selected manual<font><span class="span_spacer"></span></font></span>
                            <select id="change_type" name="change_type" class="single_select" title="Change type from selected manual">
                                <option value="NEW">New</option>
                                <option value="NO_CHANGE">No change</option>
                                <option value="TEXT_CHANGE">Textual change</option>
                                <option value="MATERIAL_CHANGE">Material change</option>
                            </select>
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" for="title_code_page" title="Standard Title / Code / Page / Paragraph label"><span class="wrapper_span_char_count">Standard&nbsp;Title/Code/<font><span class="span_spacer"></span></font><br/> Page &amp; Paragraph<font><span class="span_spacer"></span></font></span>              
                            <input type="text" class="input_text" name="title_code_page" id="title_code_page" title="Standard Title / Code / Page / Paragraph" maxlength="500"/>             
                        </label>
                        <div class="clear"></div>
                        
                        <label class="wrapper_label" title="Add Reference button label"><span class="wrapper_span">&nbsp;</span>  
                            <div class="button"><a href="#" class="add_reference" title="add reference to a historical manual button">Add Reference</a><span></span></div>
                        </label> 
                        <div class="clear"></div>
                    <%	} else { %>
	                    <select id="standard_change" name="standard_change" class="single_select" title="This field is required." style="display:none">
	                        <option value="NA" selected='selected'>Not Applicable</option>
	                    </select> 
                    <%	} %>                
                        <table id="references" summary="References">
                            <tr class="spec_links_header">
                                <td style="display:none;"></td>  <!-- stdManualId -->
                                <td style="display:none;"></td>  <!-- manualId -->
                                <td><strong>Brand</strong></td>
                                <td><strong>Region</strong></td>
                                <td><strong>Change Type</strong></td>
                                <td><strong>Manual</strong></td>
                                <td><strong>Title / Code</strong></td>
                                <td></td>
                            </tr>
                            
                            <%
                            if(!StandardsUtil.isNullOrBlank(assocManuals)) {
                                for(StandardsHistoricalManual manual : assocManuals)
                                {
                                	if(isGlobal || standView.getStandard().getRegionCode() == userRgnCode)
                                	{
	                               %>
	                                    <tr class="table_links_list">
	                                    	<td style="display:none;" class="standard_file_type_td this_link">0<input type="hidden" value="~~~id:0"/></td>
	                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= manual.getHistManualId()%><input type="hidden" value="<%= manual.getHistManualId()%>"/></td>
	                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeChainCode(manual.getChain())%><input type="hidden" value="<%= manual.getChain()%>"/></td>
	                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeRegionCode(manual.getRegion())%><input type="hidden" value="<%= manual.getRegion()%>"/></td>
	                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeChangeCode(manual.getChange())%><input type="hidden" value="<%= manual.getChange()%>"/></td>
	                                    	<td class="standard_file_type_td this_link"><%= manual.getHistManualTitle()%><input type="hidden" value="<%= manual.getHistManualType()%>"/></td>
	                                    	<td class="standard_file_type_td this_link"><%= manual.getTitle()%><input type="hidden" value="<%= manual.getTitle()%>"/></td>
	                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= manual.getCreatorId()%><input type="hidden" value="<%= manual.getCreatorId()%>"/></td>
	                                    	<td>
	                                    	<% if(!isGlobal){ %>
	                                    		<% if(StandardsUtil.hasEditRole(manual, user)) { %>
	                                    		<img class="delete_manual_reference" src="/BSTheme-theme/images/delete.png" alt="Delete Historical Manual img" title="Delete Historical Manual Reference"/>
	                                    		<% }} %>
	                                    	</td>
	                                    	</tr>
	                               <%
                                	}
                                } 
                            }
                            if(!StandardsUtil.isNullOrBlank(manuals)) {
                                for(StandardsHistoricalManual manual : manuals)
                                {
                                    %>
                                    <tr class="table_links_list">
                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= manual.getStdMnlId()%><input type="hidden" value="~~~id:<%= manual.getStdMnlId()%>"/></td>
                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= manual.getHistManualId()%><input type="hidden" value="<%= manual.getHistManualId()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeChainCode(manual.getChain())%><input type="hidden" value="<%= manual.getChain()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeRegionCode(manual.getRegion())%><input type="hidden" value="<%= manual.getRegion()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeChangeCode(manual.getChange())%><input type="hidden" value="<%= manual.getChange()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= manual.getHistManualTitle()%><input type="hidden" value="<%= manual.getHistManualType()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= manual.getTitle()%><input type="hidden" value="<%= manual.getTitle()%>"/></td>
                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= manual.getCreatorId()%><input type="hidden" value="<%= manual.getCreatorId()%>"/></td>
                                    	<td>
                                    		<% if(!isGlobal){ %>
                                    		<% if(StandardsUtil.hasEditRole(manual, user)) { %>
                                    		<img class="delete_manual_reference" src="/BSTheme-theme/images/delete.png" alt="Delete Historical Manual img" title="Delete Historical Manual Reference"/>
                                    		<% } }%>
                                    	</td>
                                    </tr>
                                    <%
                                } 
                            }
                            %>
                        </table>
                        <br/>
                        <% if(!isGlobal){ %>
                        <div class="file_uploader_advice"><em class="required">Click the Add Reference button above to add more historical links.</em></div>
						<%} %>
                    <div class="clear"></div>
                    </div><!--ends hidden content -->
                     
                 </span>
					
				</div>
				<% } else {%>
					<select id="standard_change" name="standard_change" class="single_select" title="This field is required." style="display:none">
                        <option value="NA" selected='selected'>Not Applicable</option>
                    </select>
                   </div>
				<% } %>
				 
				 
                <h3>IHG Supporting Links/External Links</h3>

		        <div class="field_wrapper">
				<span id="second_step" class="step">

                    <p class="italic_text">IHG Supporting Links</p>
                    <label class="wrapper_label" for="support_link_lang" title="standard file language"><span class="wrapper_span_char_count">Language<font><span class="span_spacer"></span></font></span>                
                        <select id="support_link_lang" name="support_link_lang">
                        	<% for(StandardsRegionLocale stdRgnLcl :regionLocales) { %>
                        		<option value="<%=stdRgnLcl.getLocaleCode()%>" <%=stdRgnLcl.getLocaleCode().equalsIgnoreCase(StandardsUtil.DEFAULT_LOCALE)?"selected='selected'":"" %>"><%= StandardsLocaleLocalServiceUtil.getStandardsLocale(stdRgnLcl.getLocaleCode()).getLocaleName()%></option>
                        	<% } %>
						</select>
                    </label>
                    <label class="wrapper_label" for="support_link_brand" title="standard file brands"><span class="wrapper_span_char_count">Brands<font><span class="span_spacer"></span></font></span>                
                        <div id="support_link_brand_dv"></div>
                    </label>
                    <label class="wrapper_label" for="support_link_region" title="standard file region"><span class="wrapper_span_char_count">Region<font><span class="span_spacer"></span></font></span>                
                        <div id="support_link_region_dv"></div>
                    </label>
                    <label class="wrapper_label" for="support_link_country" title="standard file country"><span class="wrapper_span_char_count">Country<font><span class="span_spacer"></span></font></span>                
                        <div id="support_link_country_dv">
                        	<select id="support_link_country" name="support_link_country" class="multis combo_select_width">
                        	</select>
                        </div>
                    </label>
                    <p class="file_instructions">
                    	<% if(isStd || isSpec) { %>
                    	1. Choose File Type > 2. Enter File Title > 3. Click 'Add Links' > 4. Upload File</p>
                    	<label class="wrapper_label" for="standard_file_type" title="standard file type label"><span class="wrapper_span">File Type<font><span class="span_spacer"></span></font></span>
                        	<select id="standard_file_type" class="single_select" name="standard_file_type" title="standard file type select">
                            	<%
                            	for (Map.Entry entry : fileTypes.entrySet()) {
                            	%>
                            	<option value="<%= entry.getKey()%>"><%= entry.getValue()%></option>
                            	<%
                            	}
                            	%>
                        	</select>
                    	</label>
                    	<% } else { %>
                    	1. Enter File Title > 2. Click 'Add Links' > 3. Upload File</p>
                    		<select id="standard_file_type" name="standard_file_type" title="standard file type select" style="display:none">
                            	<option value="<%=StandardsUtil.STD_TYPE_GDLN%>" selected="selected"><%=StandardsUtil.STD_TYPE_GDLN%></option>
                        	</select>
                    	<% } %>
                    	
                    <label class="wrapper_label" for="standard_file_title" title="standard file title label"><span class="wrapper_span_char_count">File Title <a class="help_icon tooltip" href="javascript:return false;" ><img src="/BSTheme-theme/images/help.png" alt="standard help icon"/>
                    	        					<span class="classic">Filename should not contain special characters like &@]}:,=>/<\n[{%|+#?()'\r;*~</span></a><font><span class="span_spacer"></span></font></span>                
                        <input type="text" class="input_text" name="standard_file_title" id="standard_file_title" title="File Title" maxlength="500" title="File Title" /><br/>
                        <div class="button add_link"><a href="#" class="add_standard_file" title="add file button">Add Links</a><span></span></div>             
                    </label>
                    
                    <table id="file_links" summary="Data table for supporting files.">
                        <tr class="spec_links_header">
                            <td style="display:none;"></td>
                            <td <%=standView.getStandard().getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN)?"style='display:none'" : ""%>><strong>Type</strong></td>
                            <td><strong>Title</strong></td>
                            <td><strong>File</strong></td>
                            <td><strong>Brand</strong></td>
                            <td><strong>Region</strong></td>
                            <td><strong>Country</strong></td>
                            <td><strong>Language</strong></td>
                            <td></td>
                        </tr>
						<%
                        Map<AttachmentsStandards, List<List>> attachmentsLinks = standView.getAttachmentStandards();
                        if(!StandardsUtil.isNullOrBlank(attachmentsLinks)) {
                            for(AttachmentsStandards attachment : attachmentsLinks.keySet())
                            {
                            	
                            	String fileName = attachment.getAttachmentPath().substring(attachment.getAttachmentPath().lastIndexOf("/")+1, attachment.getAttachmentPath().length());
                                String path = attachment.getAttachmentPath().substring(0, attachment.getAttachmentPath().lastIndexOf('/'));
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(attachment.getLocaleCode()).getLocaleName();
                                long groupId = themeDisplay.getScopeGroupId();
                                long folderId = Long.valueOf(path.substring(path.lastIndexOf("/")+1, path.length()));  
                                DLFileEntry fileEntry = null;
                                try{
                                	fileEntry = DLFileEntryLocalServiceUtil.getFileEntry(groupId, folderId, fileName);
                                	path = "/documents/"+ groupId + "/" + fileEntry.getUuid();
                                } catch(Exception e){
                            		_log.error("Failed to get file from liferay with file name & folder id:"+folderId + "--"+fileName);
                            	}
                            	String typeDescription = fileTypes.get(attachment.getType());
                                %>
                                <tr class="table_links_list atchment">
                                	<td style="display:none;" class="standard_file_type_td this_link"><%= attachment.getAttachmentId()%>
                                		<input type="hidden" value="~~~id:<%= attachment.getAttachmentId()%>"/></td>
                                	<td class="standard_file_type_td this_link" <%=standView.getStandard().getStdTyp().equalsIgnoreCase(StandardsUtil.STD_TYPE_GDLN)?"style='display:none'" : ""%>><%= typeDescription%>
                                		<input type="hidden" name="file_type" value="<%= attachment.getType()%>"/></td>
                                	<td class="standard_file_title_td this_link"><%= attachment.getTitle()%>
                                		<input type="hidden" value="<%= attachment.getTitle()%>"/><img class="edit_this_attachment" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url" /></td>
                                	<td class="standard_file_file_td this_link"><a href="<%=path%>" title="file path" target="_blank"><%= fileName%></a>
                                		<input type="hidden" value="<%= attachment.getAttachmentPath()%>"/></td>
                                	<td class="standard_file_file_td this_link">
                                		<% 	
                                			String selectedBrandTitle = "";
                                	    	String selectedBrandCode = "";
                                			int attachmentCount = 0;
                                			List<ChainAttachmentsStandards> chains = (List<ChainAttachmentsStandards>)attachmentsLinks.get(attachment).get(0);
                                			for (ChainAttachmentsStandards chain : chains ) 
                                			{ 
                                			   attachmentCount++;
                                			   selectedBrandTitle += chnCdMap.get(chain.getChainCode()).concat(attachmentCount >= chains.size() ? "" : ", ");
                                			   selectedBrandCode += chain.getChainCode().concat(attachmentCount >= chains.size() ? "" : ",");
                                			} %>
                                		<p class="tiny_text"><%=selectedBrandTitle%></p>
                                		<input type="hidden" id="file_selected_brand<%= attachment.getAttachmentId()%>" value="<%=selectedBrandCode%>"/>
                                		<img id="file_select_brand<%= attachment.getAttachmentId()%>" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/>
                                		<script type="text/javascript">populateSelectBrandPopUp("file_select_brand",<%= attachment.getAttachmentId()%>,"file");</script>
                                	</td>
                                	<td class="standard_file_file_td this_link">
                                		<%
										List<String> rgnAttch = (List<String>) attachmentsLinks.get(attachment).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    String selectedRgnCode = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    	 selectedRgnCode += rgnImage.concat(imgCount>=rgnAttch.size()?"":",");
                                    	    }
                                    	}
										%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                		<input type="hidden" id="file_selected_rgn<%= attachment.getAttachmentId()%>" value="<%=selectedRgnCode%>"/>
                                		<img id="file_select_region<%= attachment.getAttachmentId()%>" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/>
                                		<script type="text/javascript">populateSelectRegionPopUp("file_select_region",<%= attachment.getAttachmentId()%>,"file");</script>
                                	</td>
                                	
                                	<td class="standard_file_file_td this_link">
                                		<% 
                                    	List<AttachmentsStandardsCountry> cntrAttachList = (List<AttachmentsStandardsCountry>) attachmentsLinks.get(attachment).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                	    String selectedCntrCode = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrAttachList))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(AttachmentsStandardsCountry cntrImage : cntrAttachList)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrAttachList.size()?"":", ");
                                    		    selectedCntrCode += cntrImage.getCountryCode().concat(imgCount>=cntrAttachList.size()?"":",");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                                		<input type="hidden" id="file_selected_cntr<%= attachment.getAttachmentId()%>" value="<%=selectedCntrCode%>"/>
                                		<img id="file_select_country<%= attachment.getAttachmentId()%>" title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/>
                                		<script type="text/javascript">populateSelectCountryPopUp("file_select_country",<%= attachment.getAttachmentId()%>,"file");</script>
                                	</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%=attachment.getLocaleCode()%>"/></td>
                                	<td>
                                	<% if(attachment.isTranslationExist()) { %>
                                		<img class="delete" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete" onclick="showPromptMessage(stdAttachmentTranslationMessage);" />
                                	<% } else { %>
                                		<img class="delete_this_file" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/>
                                	<% } %>
                                	</td>
                                </tr>
                                <%
                            } 
                        }
                        %>
                    </table>
                    <br/>

                    <div class="file_uploader_advice"><em class="required">Click the Add Links button above to add more files.</em></div>

                    <div class="clear"></div>

                    <div class="divider">&nbsp;</div>

                    <p class="italic_text">External Links</p>
                    <label class="wrapper_label" for="external_link_lang" title="external_link_lang language"><span class="wrapper_span_char_count">Language<font><span class="span_spacer"></span></font></span>                
                        <select id="extl_link_lang" name="extl_link_lang">
                        	<% for(StandardsRegionLocale stdRgnLcl :regionLocales) { %>
                        		<option value="<%=stdRgnLcl.getLocaleCode()%>" <%=stdRgnLcl.getLocaleCode().equalsIgnoreCase(StandardsUtil.DEFAULT_LOCALE)?"selected='selected'":"" %> ><%= StandardsLocaleLocalServiceUtil.getStandardsLocale(stdRgnLcl.getLocaleCode()).getLocaleName()%></option>
                        	<% } %>
						</select>
                    </label>
                    <label class="wrapper_label" for="standard_url_link_title" title="standard_url link title label"><span class="wrapper_span_char_count">Brands<font><span class="span_spacer"></span></font></span>                
                        <div id="extl_link_brand_dv"></div>
                    </label>
                     <label class="wrapper_label" for="standard_url_link_title" title="standard_url link title label"><span class="wrapper_span_char_count">Region<font><span class="span_spacer"></span></font></span>                
                        <div id="extl_link_region_dv"></div>
                    </label>
                     <label class="wrapper_label" for="standard_url_link_title" title="standard_url link title label"><span class="wrapper_span_char_count">Country<font><span class="span_spacer"></span></font></span>                
                        <div id="extl_link_country_dv"></div>
                    </label>
                    <label class="wrapper_label" for="standard_url_link" title="standard url link label"><span class="wrapper_span_char_count">Link URL - http://<font><span class="span_spacer"></span></font></span>                
                        <input type="text" class="input_text url" name="standard_url_link" id="standard_url_link" title="Please enter a valid URL that begins with http://" maxlength="2000"/>            
                    </label>
                    <label class="wrapper_label" for="standard_url_link_title" title="standard_url link title label"><span class="wrapper_span_char_count">Link Title<font><span class="span_spacer"></span></font></span>                
                        <input type="text" class="input_text" name="standard_url_link_title" id="standard_url_link_title" title="Link Title" maxlength="500"/><br/>
                    	<div class="button add_url_link"><a href="#" class="add_standard_url_link" title="add URL button">Add Link</a><span></span></div>
                    </label>
                    
                	<table id="url_links" summary="Data table for external URLs.">
                    	<tr class="spec_links_header">
                           <td style="display:none;"></td>
                        	<td><strong>URL</strong></td>
                            <td><strong>Title</strong></td>
                            <td><strong>Brand</strong></td>
                             <td><strong>Regions</strong></td>
                             <td><strong>Country</strong></td>
                            <td><strong>Language</strong></td>
                            <td></td>
                        </tr>
                        <%-- <% //Comment for QC9889, ignore links inherited from std
                        Map<ExternalLinkStandards, List<List>> assocExternalLinks = standView.getAssocExtLinkStandards();
                        if(!StandardsUtil.isNullOrBlank(assocExternalLinks)) {
                            int counter = 0;
                            for(ExternalLinkStandards link : assocExternalLinks.keySet())
                            {
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(link.getLocaleCode()).getLocaleName();
                                
                                %>
                                <tr class="table_links_list externl_lnk">
                                	<td style="display:none;" class="standard_url_link_td this_link"><%= link.getExtLinkId()%>
                                		<input type="hidden" value="~~~id:<%= counter%>"/></td>
                                	<td class="standard_url_link_td this_link"><%= link.getUrl()%>
                                		<input type="hidden" value="<%= link.getUrl()%>"/><img class="edit_this_link" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url"/></td>
                                	<td class="standard_url_link_title_td this_link"><%= link.getTitle()%>
                                		<input type="hidden" value="<%= link.getTitle()%>"/><img class="edit_this_link" title="Edit title" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit title" /></td>
                                	<td class="standard_url_link_title_td this_link">
                                		<% String helperInput = StringPool.BLANK;
                                		List<ChainExternalLinkStandards> chainList = (List<ChainExternalLinkStandards>)assocExternalLinks.get(link).get(0);
                                		int assocLinkCount = 0;
                                		String chianCode = StringPool.BLANK;
                                		String chainTitle = StringPool.BLANK;
                                		for (ChainExternalLinkStandards chain : chainList ) 
                                			{
                                		    assocLinkCount++;
                                		    chainTitle +=chnCdMap.get(chain.getChainCode()).concat(assocLinkCount>=chainList.size()?"":", ");
                                		    chianCode += chain.getChainCode().concat(assocLinkCount>=chainList.size()?"":",");
                                			}
                                			%>
                                		<p class="tiny_text"><%=chainTitle%></p>
                                		<input type="hidden" id="extl_selected_brand<%= link.getExtLinkId()%>" value="<%=chianCode%>"/>
                                		<img id="extl_select_brand<%= link.getExtLinkId()%>" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/>
                                		<script type="text/javascript">populateSelectBrandPopUp("extl_select_brand",<%= link.getExtLinkId()%>,"extl");</script>
                                		</td>
                                	<td class="standard_url_link_title_td this_link">
                                		<%
										List<String> rgnAttch = (List<String>) assocExternalLinks.get(link).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    String selectedRgnCode = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    	 selectedRgnCode += rgnImage.concat(imgCount>=rgnAttch.size()?"":",");
                                    	    }
                                    	}%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                		<input type="hidden" id="extl_selected_rgn<%= link.getExtLinkId()%>" value="<%=selectedRgnCode%>"/>
                                		<img id="extl_select_region<%= link.getExtLinkId()%>" title="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit region"/>
                                		<script type="text/javascript">populateSelectRegionPopUp("extl_select_region",<%= link.getExtLinkId()%>,"extl");</script>
                                		</td>
                               		<td class="standard_url_link_title_td this_link">
                                		<%
                                		List<ExternalLinkStandardsCountry> cntrExtlLink = (List<ExternalLinkStandardsCountry>) assocExternalLinks.get(link).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                	    String selectedCntrCode = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrExtlLink))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(ExternalLinkStandardsCountry cntrImage : cntrExtlLink)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrExtlLink.size()?"":", ");
                                    		    selectedCntrCode += cntrImage.getCountryCode().concat(imgCount>=cntrExtlLink.size()?"":",");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                                		<input type="hidden" id="extl_selected_cntr<%= link.getExtLinkId()%>" value="<%=selectedCntrCode%>"/>
                                		<img id="extl_select_country<%= link.getExtLinkId()%>" title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/>
                                		<script type="text/javascript">populateSelectCountryPopUp("extl_select_country",<%= link.getExtLinkId()%>,"extl");</script>
                               			</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%= link.getLocaleCode()%>"/></td>
                                	<td><img class="delete_this_link" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete"/></td>
                                	</tr>
                                <%
                                counter--;
                            } 
                        } --%>
                        <% 
                        Map<ExternalLinkStandards, List<List>> externalLinks = standView.getExtLinkStandards();
                        if(!StandardsUtil.isNullOrBlank(externalLinks)) {
                            for(ExternalLinkStandards link : externalLinks.keySet())
                            {
                                String langName = StandardsLocaleLocalServiceUtil.getStandardsLocale(link.getLocaleCode()).getLocaleName();
                                %>
                                <tr class="table_links_list externl_lnk">
                                	<td style="display:none;" class="standard_url_link_td this_link"><%= link.getExtLinkId()%><input type="hidden" value="~~~id:<%= link.getExtLinkId()%>"/></td>
                                	<td class="standard_url_link_td this_link"><%= link.getUrl()%><input type="hidden" value="<%= link.getUrl()%>"/><img class="edit_this_link" title="Edit url" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit url" /></td>
                                	<td class="standard_url_link_title_td this_link"><%= link.getTitle()%><input type="hidden" value="<%= link.getTitle()%>"/><img class="edit_this_link" title="Edit title" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="Edit title"  /></td>
                                	<td class="standard_url_link_title_td this_link">
                                		<% String helperInput = StringPool.BLANK;
                                		List<ChainExternalLinkStandards> chainList = (List<ChainExternalLinkStandards>)externalLinks.get(link).get(0);
                                		int assocLinkCount = 0;
                                		String chianCode = StringPool.BLANK;
                                		String chainTitle = StringPool.BLANK;
                                		for (ChainExternalLinkStandards chain : chainList ) 
                               			{
	                               		    assocLinkCount++;
	                               		    chainTitle +=chnCdMap.get(chain.getChainCode()).concat(assocLinkCount>=chainList.size()?"":", ");
	                               		    chianCode += chain.getChainCode().concat(assocLinkCount>=chainList.size()?"":",");
                               			}
                               			%>
                                		<p class="tiny_text"><%=chainTitle%></p>
                                		<input type="hidden" id="extl_selected_brand<%= link.getExtLinkId()%>" value="<%=chianCode%>"/>
                                		<img id="extl_select_brand<%= link.getExtLinkId()%>" title="edit brand" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit brands"/>
                                		<script type="text/javascript">populateSelectBrandPopUp("extl_select_brand",<%= link.getExtLinkId()%>,"extl");</script>
                                		</td>
                                	<td class="standard_url_link_title_td this_link">
                                		<%
										List<String> rgnAttch = (List<String>) externalLinks.get(link).get(2);
										Map<String,String> regionMap = BrandStandardsUtil.getRegions();
										String selectedRgnTitle = "";
                                	    String selectedRgnCode = "";
                                	    if(!StandardsUtil.isNullOrBlank(rgnAttch))
                                    	{
                                    	    int imgCount = 0;
                                    	    for(String rgnImage : rgnAttch)
                                    	    {
                                    	    	 imgCount++;
                                    	    	 selectedRgnTitle += regionMap.get(rgnImage).concat(imgCount>=rgnAttch.size()?"":", ");
                                    	    	 selectedRgnCode += rgnImage.concat(imgCount>=rgnAttch.size()?"":",");
                                    	    }
                                    	}%>
                                		<p class="tiny_text"><%=selectedRgnTitle%></p>
                                		<input type="hidden" id="extl_selected_rgn<%= link.getExtLinkId()%>" value="<%=selectedRgnCode%>"/>
                                		<img id="extl_select_region<%= link.getExtLinkId()%>" title="edit region" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit region"/>
                                		<script type="text/javascript">populateSelectRegionPopUp("extl_select_region",<%= link.getExtLinkId()%>,"extl");</script>
                                		</td>
                               		<td class="standard_url_link_title_td this_link">
                                		<%
                                		List<ExternalLinkStandardsCountry> cntrExtlLink = (List<ExternalLinkStandardsCountry>) externalLinks.get(link).get(1);
										Map<String, Map<String, String>> contryMap = BrandStandardsUtil.getCountries();
										Map<String,String> cntryMap = null;
                                    	String selectedCntrTitle = "";
                                	    String selectedCntrCode = "";
                                    	if(!StandardsUtil.isNullOrBlank(cntrExtlLink))
                                    	{
                                    	    int imgCount = 0;
                                    	    
                                    		for(ExternalLinkStandardsCountry cntrImage : cntrExtlLink)
                                    	    {
                                    		    imgCount++;
											    cntryMap = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.getRegionByCountryCode(contryMap,cntrImage.getCountryCode()));
                                    		    selectedCntrTitle += cntryMap.get(cntrImage.getCountryCode()).concat(imgCount>=cntrExtlLink.size()?"":", ");
                                    		    selectedCntrCode += cntrImage.getCountryCode().concat(imgCount>=cntrExtlLink.size()?"":",");
                                    	   }
                                  		}
                                    	%>
                                		<p class="tiny_text"><%=selectedCntrTitle%></p>
                                		<input type="hidden" id="extl_selected_cntr<%= link.getExtLinkId()%>" value="<%=selectedCntrCode%>"/>
                                		<img id="extl_select_country<%= link.getExtLinkId()%>" title="edit country" src="/BSTheme-theme/images/edit_pencil_icon.png" alt="edit country"/>
                                		<script type="text/javascript">populateSelectCountryPopUp("extl_select_country",<%= link.getExtLinkId()%>,"extl");</script>
                               			</td>
                                	<td class="standard_file_file_td this_link"><%= langName%>
                                		<input type="hidden" value="<%= link.getLocaleCode()%>"/></td>
                                	<td>
                                	<% if(link.isLinkTranslationExist()) { %>
                                		<img class="delete" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete" onclick="showPromptMessage(stdExtlLinkTranslationMessage);" />
                                	<% } else { %>
                                		<img class="delete_this_link" title="delete" src="/BSTheme-theme/images/delete.png" alt="delete" />
                                	<% } %>
                                	</td>
                                </tr>
                                <%
                            } 
                        }
                        %>
                    </table>
                    <br/>
                    <div class="file_uploader_advice"><em class="required">Click the Add Links button above to add more links.</em></div>
                  <div class="clear"></div>
				 </span>
                </div>
                
                
                <h3>Assign Flags</h3>
                
                <div class="field_wrapper">
                
				<span id="third_step" class="step">
<%
				// Department Applicability
				flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(1);
				flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(1);
%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><a class="help_icon tooltip" href="javascript:return false;" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> tooltip"><img src="/BSTheme-theme/images/help.png" alt="<%=flagCategory.getTxtValue().replaceAll(" ","")%> icon" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> help"/>
                                <span class="classic">The hotel  department(s) to which this standard will apply.</span></a></span>
                         <c:choose>
                         	<c:when test="${isCopyAllowed eq true}">
                            	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>"  
                            	title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                            </c:when>
                            <c:otherwise>
                            	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>"  
                            	title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" multiple="multiple">
                            </c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
                                		if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
                                		{
                                %>
                                			<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
                                		}
                                		else
                                		{
%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
<%                                			
                                		}
                                	}
								%>
                            </select>
                        </label>

<%
						// Location Within Hotel
						flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(25);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(25);
%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><a class="help_icon tooltip" href="javascript:return false;" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> tooltip"><img src="/BSTheme-theme/images/help.png" alt="<%=flagCategory.getTxtValue().replaceAll(" ","")%> icon" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> help"/>
                                <span class="classic">The location(s) within the hotel to which this standard applies.</span></a></span>                
                            <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
	                            	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" 
	                            	name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" onchange="javascript:changeCopyButtonAttr();">
	                            </c:when>
	                            <c:otherwise>
	                           		 <select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" 
	                           	 	name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select">
	                            </c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>           
                        </label>
<%
						// Corporate department
						flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(35);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(35);
%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><a class="help_icon tooltip" href="javascript:return false;" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> tooltip"><img src="/BSTheme-theme/images/help.png" alt="<%=flagCategory.getTxtValue().replaceAll(" ","")%> icon" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> help"/>
                                <span class="classic">The department responsible for creating the standard.</span></a></span>                
                           <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
                           			 <select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" multiple="multiple" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select">
                            	</c:otherwise>
                            </c:choose>
                            
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
                                		if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>           
                        </label>

<%
						// Wheel Quadrant
						flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(40);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(40);
%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label"><span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>                
                            <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="single_select" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" onchange="javascript:changeCopyButtonAttr();">
                                </c:when>
                                <c:otherwise>
                                	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="single_select" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select">
                                </c:otherwise>
                            </c:choose>
                                <option value="">Select</option>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>           
                        </label>
                        <%                     
                        	// Specialist Area
							flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(92);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(92);
						%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                        <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                            <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
		                            <select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
		                            name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
		                            multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
	                            	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
	                            	name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
	                            	multiple="multiple">
                            	</c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>
                        </label>
                        
                        <%                     
                      	// Digital
	                    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(93);
						flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(93);
						%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                        <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                            <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                            		multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                            		multiple="multiple">
                            	</c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>
                        </label>
                         <%                     
                        	// Brand safety Standards
							flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(500);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(500);
						%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                        <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                            <c:choose>
	                         	<c:when test="${isCopyAllowed eq true}">
		                            <select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
		                            name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
		                            multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
	                            	<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
	                            	name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
	                            	multiple="multiple">
                            	</c:otherwise>
                            </c:choose>
                                <%
                                	for(FlagCategory flgOption : flagCategories)
                                	{
		                                if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
		                                {
		                       %>
		                                	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
								<%
		                                }
		                                else
		                                {
								%>
											<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
								<%                                			
		                                }
                                	}
								%>
                            </select>
                        </label>
                        
                        
                        
                        <% if(isStd || isSpec) { %>
                        
                        <div class="clear"></div>
                        <div class="divider">&nbsp;</div>
                        <div class="clear"></div>
                        
                        <p class="italic_text">Quality Specific Attributes</p>
                        
                        <%                     
                        // Measurement
                        flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(90);
                        flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(90);
                        %>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                        <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                        <c:choose>
	                    	<c:when test="${isCopyAllowed eq true}">
                           		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                           		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                           		multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                          	</c:when>
                          	<c:otherwise>
                          		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                           		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                           		multiple="multiple">
                          	</c:otherwise>
                        </c:choose>
                                <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {
                                        if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
                                        {
                               %>
                                            <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                <%
                                        }
                                        else
                                        {
                                %>
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                <%                                          
                                        }
                                    }
                                %>
                            </select>
                        </label>
                        
                        <%                     
                        // GEM Reporting Categories
                        flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(412);
                        flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(412);
                        %>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                            <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                            <c:choose>
	                    		<c:when test="${isCopyAllowed eq true}">
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="single_select" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="single_select" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select">
                            	</c:otherwise>
                           </c:choose>
                                <option value="">Select</option>
                                <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {
                                        if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
                                        {
                               %>
                                            <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                <%
                                        }
                                        else
                                        {
                                %>
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                <%                                          
                                        }
                                    }
                                %>
                            </select>
                        </label>
<%
                        // Area of the Hotel for Measurement
                        flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(419);
                        flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(419);
%>
                        <label class="wrapper_label" for="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> label">
                            <span class="wrapper_span_wide"><%=flagCategory.getTxtValue()%><font><span class="span_spacer"></span></font></span>
                            <c:choose>
	                    		<c:when test="${isCopyAllowed eq true}">
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                            		multiple="multiple" onchange="javascript:changeCopyButtonAttr();">
                            	</c:when>
                            	<c:otherwise>
                            		<select id="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" class="multis" 
                            		name="<%=flagCategory.getTxtValue().replaceAll(" ","")%>" title="<%=flagCategory.getTxtValue().replaceAll(" ","")%> select" 
                            		multiple="multiple">
                            	</c:otherwise>
                            </c:choose>
                                <%
                                    for(FlagCategory flgOption : flagCategories)
                                    {
                                        if(StandardsUtil.contains(selectedFlagStds, flgOption.getFlagCatId()))
                                        {
                               %>
                                            <option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
                                <%
                                        }
                                        else
                                        {
                                %>
                                            <option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
                                <%                                          
                                        }
                                    }
                                %>
                            </select>           
                        </label>
                        <% } %>
                        
                    </span>
                    </div>
 
                     <% if(isStd) { %>
                   
				    <h3>Business Impact Assessment</h3>
				    
                    <div class="field_wrapper">
  					<span id="fifth_step" class="step">

                        <p class="italic_text">Add Business Impact Assessment(s)</p>
                        <p class="file_instructions">1. Select Brand and Region > 2. Assess the P&L impact > 3. Assess the CapEx impact > </p>
                        <p class="file_instructions"> 4. Assess the Implementation timescale > 5. Click 'Add Impact Assessment'</p>
                        
                        <label class="wrapper_label" for="standard_bia_brand" title="standard bia brand label">
                        <span class="wrapper_span">Brand<font><span class="span_spacer"></span></font></span>
						<div class="bia_brands">
                        <select id="standard_bia_brand" class="single_select" name="standard_bia_brand" >
							
                        		<%	for(String chncode : chnCdMap.keySet())
								{	
								%>	
									 <option value='<%=chncode%>'><%=chnCdMap.get(chncode)%></option> 
								<%
								}%> 
							 
                        </select>
						</div>
                    </label>
                    <label class="wrapper_label" for="standard_bia_regions" title="standard bia regions label">
                    <span class="wrapper_span">Region<font><span class="span_spacer"></span></font></span>

                    	<select id="standard_bia_regions" name="standard_bia_regions" title="standard bia regions select" class="single_select"> 
                    	 </select>

                    </label>
                    <div id="changeRegional_div">
                     <%   
	                    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(75);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(75);
					%>
                     <label class="wrapper_label" for="changeRegional" title="changeRegional label">
                     <span class="wrapper_span wrapper_span_width">Change from Regional
                     <a class="help_icon tooltip" href="javascript:return false;"><img src="/BSTheme-theme/images/help.png" alt="details" title="details"/>
                        <span class="classic">For standards that existed previously: select 'Green' if the new standard is identical or a textual change or 'Amber' where the change is minor to material. Where the standard is Global: if there is no regional equivalent select 'Blue' or if the global standard does not permit an activity in the region select 'Red'.  'Not Global' should be used by the regions to show that the standard should be left to each individual region to decide.</span></a></span>
                         <select id="changeRegional" name="changeRegional" title="changeRegional select" class="single_select" >
                           
                             <%
                             	for(FlagCategory flgOption : flagCategories)
                             	{
                              
							%>
										<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
							<%                                			
		                          }
		                             	
							%>
                         </select>
                        
                     </label>
                     </div>
	                 <%   
	                    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(60);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(60);
					%>
                     <label class="wrapper_label" for="pandl" title="pandl label">
                     <span class="wrapper_span">P&L</span>
                     
                            
                         <select id="pandl" name="pandl" title="pandl select" class="single_select" >
                            
                             <%
                             	for(FlagCategory flgOption : flagCategories)
                             	{
                               if( flgOption.getTxtValue().equals("No Cost"))
                               {
		                     %>
		                              	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
							<%
	                              }
	                              else
	                              {
							%>
								<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
							<%                                			
	                              }
                           	}
							%>
                         </select>
                        
                     </label>
                      <%   
	                    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(70);
							flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(70);
					%>
                     <label class="wrapper_label" for="CapEx" title="CapEx label">
                     <span class="wrapper_span">CapEx</span>
                     
                            
                         <select id="CapEx" name="CapEx" title="capex select" class="single_select" >
                             
                             <%
                             	for(FlagCategory flgOption : flagCategories)
                             	{
                               if( flgOption.getTxtValue().equals("No Cost"))
                               {
                      %>
                               	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
					<%
                               }
                               else
                               {
					%>
								<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
					<%                                			
                               }
                             	}
					%>
                         </select>
                        </label>
                          <%   
		                    flagCategory = FlagCategoryLocalServiceUtil.getFlagCategory(65);
								flagCategories = FlagCategoryLocalServiceUtil.getFlagCategoryByParentId(65);
						%>
	                     <label class="wrapper_label" for="implementation" title="Implementation label">
	                     <span class="wrapper_span">Implementation</span>
	                     
	                            
	                         <select id="implementation" name="implementation" title="Implementation select" class="single_select" >
	                             
	                             <%
	                             	for(FlagCategory flgOption : flagCategories)
	                             	{
	                               if( flgOption.getTxtValue().equals("Immediate"))
	                               {
	                      %>
	                               	<option value="<%=flgOption.getFlagCatId()%>" selected="selected"><%=flgOption.getTxtValue()%></option>
						<%
	                               }
	                               else
	                               {
						%>
									<option value="<%=flgOption.getFlagCatId()%>"><%=flgOption.getTxtValue()%></option>
						<%                                			
	                               }
	                             	}
						%>
                         </select>
                     </label >
                     <label class="wrapper_label" for="bia_comments" title="bia_comments label"> <span class="wrapper_span_char_count">Comments</span>
                     <textarea class="bia_comments" name="bia_comments" id="bia_comments" maxlength="500" style="overflow:auto"></textarea>
                     
                     </label>
                     <div class="clear"></div>
                     <label class="wrapper_label" title="Add Impact Assessment button label"><span class="wrapper_span">&nbsp;</span>  
                            <div class="button impact_assess_div"><a href="#" class="impact_assess" title="add Impact Assessment button">Add Impact Assessment</a><span></span></div>
                        </label> 
                        <div class="clear"></div>
                                     
                        <table id="impactAssessment" summary="impactAssessment">
                            <tr class="spec_links_header">
                             <td style="display:none;"></td>  <!-- biaId -->
                                <td style="display:none;"></td> 
                                <td><strong>Brand</strong></td>
                                <td><strong>Region</strong></td>
                                <td><strong>Change from Regional</strong></td>
                                <td><strong>P&L</strong></td>
                                <td><strong>CapEx</strong></td>
                                <td><strong>Implementation</strong></td>
                                <td><strong>Comments</strong></td>
                                <td></td>
                            </tr>
                         <%
                            List<BusImpactAssmt> arlBia =  standView.getBusImpactAssmts();
                         	int trId=0;
                            if(!StandardsUtil.isNullOrBlank(arlBia)) {
                                for(BusImpactAssmt bia : arlBia)
                                {
                                	trId = trId+1;
                                	String changeReg = "";
                                	String changeRegVal = "0";
                                	if(bia.getChangeFromRegional()!=null && bia.getChangeFromRegional()!="")
                                	{
                                		changeReg = FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(bia.getChangeFromRegional())).getTxtValue();
                                		changeRegVal = bia.getChangeFromRegional();
                   
                                	}
                                	String biaComm = "0";
                                	if(bia.getBiaComments()!=null &&bia.getBiaComments()!="")
                                	{
                                		biaComm = bia.getBiaComments();
                                	}
                                    %>
                                    <tr id="<%=trId%>" class="table_links_list">
                                    	<td style="display:none;" class="standard_file_type_td this_link"><%= bia.getBusImpactAssmtId()%><input type="hidden" value="~~~id:<%= bia.getBusImpactAssmtId()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeChainCode(bia.getChain())%><input type="hidden" value="<%= bia.getChain()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= StandardsUtil.decodeRegionCode(bia.getRegion())%><input type="hidden" value="<%= bia.getRegion()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= changeReg %><input type="hidden" value="<%=changeRegVal%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(bia.getProfileLossImpact())).getTxtValue()%><input type="hidden" value="<%= bia.getProfileLossImpact()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(bia.getCapExpenseImpact())).getTxtValue()%><input type="hidden" value="<%= bia.getCapExpenseImpact()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= FlagCategoryLocalServiceUtil.getFlagCategory(Long.parseLong(bia.getImplTimeScale())).getTxtValue()%><input type="hidden" value="<%= bia.getImplTimeScale()%>"/></td>
                                    	<td class="standard_file_type_td this_link"><%= bia.getBiaComments()%><input type="hidden" value="<%= biaComm%>"/></td>
                                    	<td><img class="delete_bia_reference" src="/BSTheme-theme/images/delete.png" alt="Delete Business Impact img" title="Delete Historical Business Impact Reference"/></td></tr>
                                    <%
                                } 
                            }
                            %>
                        </table>
						<br/>
						<div class="file_uploader_advice"><em class="required">Click the Add Impact Assessment button above to add more impact assessments.</em></div>
						<div class="clear"></div>
                     </span>
				</div>
                <%} %>  
		 <%if(standView.getStandard().getStdId() > 0){ %>               
				<h3>Cross References</h3>
				<div class="field_wrapper">
					<div id="crossReferenceDiv">
						<!-- Entire cross reference section will be placed dynamically by crossReference.jsp -->
					</div>
  				</div>
  				
  				<%if(isStd && !"GLBL".equals(prefRegionCode)) { %>
  				<h3>Specification and Guideline Ordering</h3>
                
                <div class="field_wrapper">
                	<div id="accordion_brand">
                	<%
                		for (Map.Entry<String,String> entry : chnCdMap.entrySet()) {
                			if (brandListObj.contains(entry.getKey())) {
                				if (Validator.isNull(allChainCode)) {
                					allChainCode = entry.getKey();
                				} else {
                					allChainCode = allChainCode + ","+entry.getKey();
                				}
                	%>
                			<h3 id="changeOrderAccordion_<%=entry.getKey()%>"><%=entry.getValue() %></h3>
                			<div class="field_wrapper">
                				<input type="hidden" value="false" id="spec_gdln_<%=entry.getKey()%>_check"/>
                				<div id="spec_gdln_<%=entry.getKey()%>">
                				</div>
                			</div>
                	<%			
                			}
                		}
                	%>
                	
                	<input type="hidden" value="<%=allChainCode%>" id="chainSortOrder" name="chainSortOrder"/>
                	</div><!-- Entire change order section will be placed dynamically by changeOrder.jsp -->
                </div>
  				<%}
  				} %>
  				
  				
  				
  				
                </div> <!-- end of accordion -->

				<div class="form_navigation"> 							

					<%
					HttpServletRequest httpRequest = PortalUtil.getOriginalServletRequest(request);
					long expandStdId = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID) == null ? 0L : Long.parseLong(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_STD_ID));
				    int pageNum = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM) == null ? 0 : Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_PAGE_NUM));
				    int recPerPage = httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE) == null ? 0 : Integer.parseInt(httpRequest.getParameter(BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE));
				    String urlQuery = "?pageNum=" + pageNum;
				    if(recPerPage > 0)
				    {
                        urlQuery = urlQuery + "&" + BrandStandardsUtil.REQUEST_PARAM_REC_PER_PAGE + "=" + recPerPage;
				    }
				    if(!isStd) {
				        urlQuery = urlQuery + "&prntid=" + expandStdId;
				    }
				    if(standView.getStandard().getStdId() > 0 && isStd){
					%>
						<input type="button" value="Copy Attributes" name="Copy Attributes"  class="navigation_button" 
						id="copy_attributes" onclick="javascript:copyAttributes('<%=standView.getStandard().getStdId()%>')" disabled />
                    <%  
					}
				    %>
                    <input type="button" id="form_cancel" class="navigation_button ui-state-active" title="Cancel" onClick="location.href='/web/brand-standards/standards<%=urlQuery %>'" value='Cancel' />
                    <input type="submit" id="submit" name="submitButton" class="navigation_button" value="Submit" title="Submit form" />
                    <%  if(!isStd && standView.getStandard().getStdId() < 0) { %>
                    <input type="button" id="add_specification_record" class="navigation_button" value="Add Another" title="Add Another" />
                    <% } %>
				</div>
                <div class="clear"></div>           
				
			</form>
        </div><!--ends rounded_container_contents -->
        <div class="rounded_container_bottom">&nbsp;</div>
    </div><!--ends rounded_container -->
    
<script type="text/javascript">
jQuery(function(){

<%
	/* Update Page Header Title */
	String pTitle = "Standards"; 
	if(standView.getStandard().getStdId() > 0) {
		pTitle = " - Edit ";
	} else {
		pTitle = " - Add New ";
	}
	if(isSpec) {
		pTitle = pTitle + "Specification";
	} else if(isStd) {
		pTitle = pTitle + "Standard";
	} else {
		pTitle = pTitle + "Guideline";
	}
%>
	jQuery(".grid_12 h2").text(jQuery(".grid_12 h2").text()+ '<%=pTitle%>');
});
</script>
<a href="#ImageBrandPopup" id="img_brand_popup" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="ImageBrandPopup" class="model_content">
     <div id="select-brand-list">
     
     </div>
     <div class="button"><a href="#" title="save" onclick="btnPopupSave()">Save</a><span></span></div>
     <div class="button"><a href="#" title="cancel" onclick="btnPopupCancel()">Cancel</a><span></span></div>
</div>

<!-- Image Gallery Search content --> 
<a href="#ImageGallerySearch" id="img_gallery_search" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>

<div id="ImageGallerySearch" class="model_content">
    <div id="img_model_frame"></div>
    <%
    String server = request.getServerName();
    if( server.contains("merlin") )
    {
        server = "https://" + server;
        %>
        <iframe src="<%=server%>/web/brand-standards/assign-image?COMMAND=GUEST_SEARCH_IMAGE"></iframe>
       <%    
    }
    else
    {
    %>
     <iframe src="/web/brand-standards/assign-image?COMMAND=GUEST_SEARCH_IMAGE"></iframe>
    <%    
    }
    %>
</div>
<!-- End of Image Gallery Search content --> 
 
<!-- Taxonomy Tree content --> 
<a href="#TreeData" id="taxonomy_tree_details" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>
 
<div id="TreeData" class="model_content">
      <h4>Select Index Position</h4>
      <p>Click on the arrows to expand the tree.<br/>
           Click a heading to choose where you would like to insert the Standard.<br/>
           The Standard will be inserted under the heading that you've selected.</p>
           
      <p class="small_text"><strong>You've selected: <span class="selected_tree_node">nothing yet</span></strong><span class="span_space">&nbsp;</span></p>
      <p><a class="close_page" title="accept seelcted item">Click here to accept this selection</a></p>
      <div id="Taxonomy" class=" jstree jstree-4 jstree-default jstree-focused">
      </div>
      <div class="clear"></div>
</div>
<!-- End of Taxonomy Tree content --> 
<div id="comments_div" class="comments_modalwindow_block">
 <div style="color:#FFFFFF; font-size:13px; text-align:center; margin-top:20px">
 <div style="float:left;padding-top:25%; padding-right:20px;">Comments </div><div><textarea rows="20" cols="80" name="cmt_txt_area" id="cmt_txt_area" maxlength="2000"></textarea></div>
 
 </div>
 <div class="cmt_button">
    <input type="button" value="Cancel" name="Cancel" id="cmt_close" />
	<input type="button" value="Submit" name="Submit" id="cmt_submit"/>
 </div>

</div>   
<portlet:resourceURL var="checkAttributes" id="checkAttr">
	<portlet:param name="checkAttr" value="checkAttr"></portlet:param>
</portlet:resourceURL>
<portlet:resourceURL var="copyAttributes" id="copyAttributes">
	<portlet:param name="copyAttr" value="copyAttr"/>
</portlet:resourceURL>
<script type="text/javascript">

var flag1 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(1).getTxtValue().replaceAll(" ","")%>';
var flag20 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(20).getTxtValue().replaceAll(" ","")%>';
var flag25 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(25).getTxtValue().replaceAll(" ","")%>';
var flag35 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(35).getTxtValue().replaceAll(" ","")%>';
var flag40 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(40).getTxtValue().replaceAll(" ","")%>';
var flag90 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(90).getTxtValue().replaceAll(" ","")%>';
var flag91 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(91).getTxtValue().replaceAll(" ","")%>';
var flag92 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(92).getTxtValue().replaceAll(" ","")%>';
var flag93 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(93).getTxtValue().replaceAll(" ","")%>';
var flag412 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(412).getTxtValue().replaceAll(" ","")%>';
var flag419 = '<%=FlagCategoryLocalServiceUtil.getFlagCategory(419).getTxtValue().replaceAll(" ","")%>';
var resManual = '<%=restrictedManus%>';
var copyAttr = '<%=copyAttributes%>';
var checkAttr = '<%=checkAttributes%>';
var allChainCode = '<%=allChainCode%>';
var isHotelLifeCycleAdmin = '<%=isHotelLifeCycleAdmin%>';
	formSbmtMsg = '<%=StandardsUtil.SUCCESS_MESSAGE%>';
	goto_url = "/web/brand-standards/standards";
	allowSbmt = <%=hasAccess%>;
	regions = new Array();
<%
	if(hasAccess) {
		List<Role> roles = user.getRoles();
		if(isGlobal)
		{
%>
			regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
			regions.push(new regionsObj("Americas", "AMER", amerOptions));
			regions.push(new regionsObj("Europe", "EURO", euOptions));
			regions.push(new regionsObj("Greater China", "GC", gcOptions));
<%			
		}
		else if (isSuperAdmin && !isGlobal)
		{
		    if (standView.getStandard().getStdId() > 0)
		    {
            String stdRegionCd = standView.getStandard().getRegionCode();
		    if ("GLBL".equals(stdRegionCd))
            {
%>
	            regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
	            regions.push(new regionsObj("Americas", "AMER", amerOptions));
	            regions.push(new regionsObj("Europe", "EURO", euOptions));
	            regions.push(new regionsObj("Greater China", "GC", gcOptions));
<%          
            }
		    else
		    {
                if("AMEA".equals(stdRegionCd)) {
%>                  regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
<%              } else if("AMER".equals(stdRegionCd)) {
%>                  regions.push(new regionsObj("Americas", "AMER", amerOptions));
<%              } else if("EURO".equals(stdRegionCd)) {
%>                  regions.push(new regionsObj("Europe", "EURO", euOptions));
<%              } else if("GC".equals(stdRegionCd)) {
%>                  regions.push(new regionsObj("Greater China", "GC", gcOptions));
<%              }
            }
		    }
            else
            {
                if("AMEA".equals(prefRegionCode)) {
%>                  regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
<%              } else if("AMER".equals(prefRegionCode)) {
%>                  regions.push(new regionsObj("Americas", "AMER", amerOptions));
<%              } else if("EURO".equals(prefRegionCode)) {
%>                  regions.push(new regionsObj("Europe", "EURO", euOptions));
<%              } else if("GC".equals(prefRegionCode)) {
%>                  regions.push(new regionsObj("Greater China", "GC", gcOptions));
<%              }
            }
            
		}
		else 
		{
			for(Role role : roles)
			{
				if(role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_AMEA_ROLE)) {
	%>				regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
	<%			} else if(role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_AMER_ROLE)) {
	%>				regions.push(new regionsObj("Americas", "AMER", amerOptions));
	<%			} else if(role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_EUROPE_ROLE)) {
	%>				regions.push(new regionsObj("Europe", "EURO", euOptions));
	<%			} else if(role.getName().equalsIgnoreCase(StandardsUtil.AUTHORS_GC_ROLE)) {
	%> 				regions.push(new regionsObj("Greater China", "GC", gcOptions));
	<%			}
			}
		}
	}

	List<CountryStandards> assocCountries = new ArrayList<CountryStandards>();
	if(standView.getStandard().getStdId() > 0)
	{
		assocCountries = standView.getCountryStandards();
	} else {
		assocCountries = standView.getAssocCountryStandards();
	}
%>
	selectedCountries = new Array();
<%	
	if(!StandardsUtil.isNullOrBlank(assocCountries))
	{
		int iCount = 0;
		for(CountryStandards countryStand : assocCountries)
		{	
%>			selectedCountries[<%=iCount%>] = '<%=countryStand.getCountry()%>';
<%			iCount++;
		}
%>		processSelectedCountries(selectedCountries, false);
<%	}
	if(!isStd)
	{
		assocCountries = standView.getAssocCountryStandards();
%>
		selectedCountries = new Array();
<%		int iCount = 0;
		for(CountryStandards countryStand : assocCountries)
		{	
	%>		selectedCountries[<%=iCount%>] = '<%=countryStand.getCountry()%>';
	<%		iCount++;
		}
	%>	processSelectedCountries(selectedCountries, true);
<%
	}
%>

</script>

<!-- end tree code  -->

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