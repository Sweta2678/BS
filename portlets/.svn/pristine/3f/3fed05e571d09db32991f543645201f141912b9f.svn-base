<%@include file="/html/init.jsp" %>
<%@page import="com.liferay.portal.model.User"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="java.util.List"%>
<%@page import="java.util.Map"%>
<%@page import="com.ihg.brandstandards.util.StandardsUtil"%>
<%@page import="com.ihg.brandstandards.util.StandardsStatusUtil"%>
<%@page import="com.ihg.brandstandards.db.model.StandardsStatus"%>
<%@page import="com.ihg.brandstandards.util.BSAdminConstants"%>



<portlet:resourceURL id="updatePrimaryAuthor" var="updPrimAuthor" />
<portlet:resourceURL id="updateOtherAuthor" var="updOtherAuthor" />	
<portlet:resourceURL id="deleteOtherAuthor" var="rmOtherAuthor" />
<portlet:resourceURL id="updateOwner" var="updOwner" />
<portlet:resourceURL id="updateBrandStatus" var="updBrandStatus" />

<%
long userId = PortalUtil.getUserId(renderRequest);
if (userId > 1)
{

	List<User> authors = (List<User>) request.getAttribute("authors");
	List<User> owners = (List<User>) request.getAttribute("owners");
	String chainCode = (String) request.getAttribute("preferedBrand");
	String regionCode = (String) request.getAttribute("regionCode");
	
	Map<String, String> chnCdMap = (Map<String, String>) request.getAttribute("chnCdMap");
	boolean isSuperAdmin = StandardsUtil.isSuperAdmin(user.getRoles());
	boolean isApprover = StandardsStatusUtil.hasApproverRole(user);
	
%>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-ui-1.10.1.custom.min.js"></script>

<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/treeAdmin/jquery.msgBox.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/jquery.nyroModal.custom.min.js"></script>
<script type="text/javascript" src="/BSTheme-theme/js/bulk-update.js"></script>

<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/msgBoxLight.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/other/jquery-ui-1.10.1/themes/base/jquery.ui.all.css" />
<link type="text/css" rel="stylesheet" href="/BSTheme-theme/css/bulk-update.css" />


<input type="hidden" name="updPrimAuthor" id="updPrimAuthor" value="<%=updPrimAuthor%>" />
<input type="hidden" name="updOtherAuthor" id="updOtherAuthor" value="<%=updOtherAuthor%>" />
<input type="hidden" name="rmOtherAuthor" id="rmOtherAuthor" value="<%=rmOtherAuthor%>" />
<input type="hidden" name="updOwner" id="updOwner" value="<%=updOwner%>" />
<input type="hidden" name="updBrandStatus" id="updBrandStatus" value="<%=updBrandStatus%>" />

<style>
.stdIdsText {
	width:459px !important;
}

#status_by_brand_table {
  width: 602px !important;
  margin-top: 15px;
  margin-left: 55px;
}

.aui div.msgBoxContent{
	height:auto;
	min-height:90px;
	display:flex;
}
</style>
<div class="rounded_container">
    <div class="rounded_container_contents">
            
        <h4>Authors & Owners Bulk Update</h4>

        <!-- Primary Author -->
        <label class="wrapper_label" for="StandardsIds" title="Standard/Spec ID:"><span class="wrapper_span"><em class="required">* </em>Standard/Spec ID:</span>
            <input class="stdIdsText" type="text" name="stdIdsPrimaryAuthor" id="stdIdsPrimaryAuthor" value="" />
        </label>
       	<div style="clear: both;padding-left: 400px;">OR</div>
        <label class="wrapper_label" for="selectPrimaryAuthor" title="Current Primary Author"><span class="wrapper_span"><em class="required">* </em>Current Primary Author:</span>
            <select id="selectPrimaryAuthor" name="selectPrimaryAuthor" class="single_select required" title="This field is required." >
                <option value="">Select</option>
                <%
                if (authors != null && !authors.isEmpty())
                {
                    for (User author : authors)
                    {
                %>        
                        <option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <div class="updBottons">     
            <input type="button" name="primAuthorUpdate" id="primAuthorUpdate" value="Update" title="Update Primary Author"/> 
        </div>            

        <div class="clear"></div>

        <label class="wrapper_label" for="selectNewPrimaryAuthor" title="New Primary Author"><span class="wrapper_span"><em class="required">* </em>New Primary Author:</span>
            <select id="selectNewPrimaryAuthor" name="selectNewPrimaryAuthor" class="single_select required" title="This field is required." >
                <option value="">Select</option>
                <%
                if (authors != null && !authors.isEmpty())
                {
                    for (User author : authors)
                    {
                %>        
                        <option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <!-- END OF Primary Author -->
            
        <div class="clear"></div>
        <div class="divider">&nbsp;</div>

        <!-- Other Author -->
        <label class="wrapper_label" for="StandardsIds" title="Standard/Spec ID:"><span class="wrapper_span"><em class="required">* </em>Standard/Spec ID:</span>
            <input class="stdIdsText" type="text" name="stdIdsOtherAuthor" id="stdIdsOtherAuthor" value="" />
        </label>
        <div style="clear: both;padding-left: 400px;">OR</div>
        <label class="wrapper_label" for="selectOtherAuthor" title="Current Other Author"><span class="wrapper_span"><em class="required">* </em>Current Other Author:</span>
            <select id="selectOtherAuthor" name="selectOtherAuthor" class="single_select required" title="This field is required." >
                <option value="">Select</option>
                <%
                if (authors != null && !authors.isEmpty())
                {
                    for (User author : authors)
                    {
                %>        
                        <option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <div class="upd2Bottons">
            <input type="button" name="otherAuthorUpdate" id="otherAuthorUpdate" value="Update" title="Update Other Author"/> 
            <input type="button" name="otherAuthorRemove" id="otherAuthorRemove" value="Remove" title="Remove Other Author"/> 
        </div>
        <div class="clear"></div>

        <label class="wrapper_label" for="selectNewOtherAuthor" title="New Primary Author"><span class="wrapper_span">&nbsp;New Other Author:</span>
            <select id="selectNewOtherAuthor" name="selectNewOtherAuthor" class="single_select" title="Select Other Author." >
                <option value="">Select</option>
                <%
                if (authors != null && !authors.isEmpty())
                {
                    for (User author : authors)
                    {
                %>        
                        <option value="<%=author.getFullName()%>"><%=author.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <!-- END OF Other Author -->
            
        <div class="clear"></div>
        <div class="divider">&nbsp;</div>

        <!-- Owner -->
        <label class="wrapper_label" for="StandardsIds" title="Standard/Spec ID:"><span class="wrapper_span"><em class="required">* </em>Standard/Spec ID:</span>
            <input class="stdIdsText" type="text" name="stdIdsOwner" id="stdIdsOwner" value="" />
        </label>
        <div style="clear: both;padding-left: 400px;">OR</div>
        <label class="wrapper_label" for="selectOwner" title="Current Owner"><span class="wrapper_span"><em class="required">* </em>Current Owner:</span>
            <select id="selectOwner" name="selectOwner" class="single_select required" title="This field is required." >
                <option value="">Select</option>
                <%
                if (owners != null && !owners.isEmpty())
                {
                    for (User owner : owners)
                    {
                %>        
                        <option value="<%=owner.getFullName()%>"><%=owner.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <div class="updBottons">            
            <input type="button" name="ownerUpdate" id="ownerUpdate" value="Update" title="Update Owner"/> 
        </div>            
            
        <div class="clear"></div>

        <label class="wrapper_label" for="selectNewOwner" title="New Owner"><span class="wrapper_span"><em class="required">* </em>New Owner:</span>
            <select id="selectNewOwner" name="selectNewOwner" class="single_select required" title="This field is required." >
                <option value="">Select</option>
                <%
                if (owners != null && !owners.isEmpty())
                {
                    for (User owner : owners)
                    {
                %>        
                        <option value="<%=owner.getFullName()%>"><%=owner.getFullName()%></option>
                <%
                    }
                }
                %>
            </select>
        </label>
        <!-- END OF Owner -->
            
        <div class="clear"></div>
		<div class="divider">&nbsp;</div>
		
		<!-- Update Brand Status -->
		<label class="wrapper_label" for="StandardsIds" title="Standard/Spec ID:"><span class="wrapper_span"><em class="required">* </em>Standard/Spec ID:</span>
            <input class="stdIdsText" type="text" name="stdIdsBrandStatus" id="stdIdsBrandStatus" value="" />
        </label>
        <table>
        <tr>
        	<td>
        		<table id="status_by_brand_table">
        			
		            <tr class="status_brand_title">
		            	<td>Brands</td>
		                <td>Status</td>
		                
		            </tr>
		            <% 
		             String preferedBrand = chainCode;
						for (String chncode : chnCdMap.keySet()) 
						{
							String standardStatus = StandardsStatusUtil.getStatusDescByCode(StandardsStatusUtil.getDefaultStatus(regionCode));
							
					%>		
							<tr>
						       	<td style="width:200px;"><input type="checkbox" name="standard_brand" id="standard_brand<%=chncode%>" class="status_brand_checkbox" value="<%=chncode%>" onchange="showStatusByBrand('<%=chncode%>','<%=standardStatus %>');"/> <%=chnCdMap.get(chncode)%></td>
					        <% 
					 			if (isSuperAdmin || isApprover)
					            {
				                   List<StandardsStatus> statuses = StandardsStatusUtil.getStatuses(user, isSuperAdmin, regionCode);
				                   
							%>
								<td>
									<select name="standard_status<%=chncode%>" id="standard_status<%=chncode%>" title="Status" style="display: none;" >
				    				<% for(StandardsStatus status : statuses) 
				    				{
				    				%>  
				    					<option  value="<%=status.getStatusId()%>" <%=standardStatus.equals(status.getTitle())?"selected='true'":""%>><%=status.getTitle()%></option>
				    				<%  
				    				} 	
				    				%>
				    				<option  value="<%=BSAdminConstants.CHAIN_ATTRIBUTE%>" <%=standardStatus.equals(BSAdminConstants.CHAIN_ATTRIBUTE)?"selected='true'":""%>><%=BSAdminConstants.CHAIN_ATTRIBUTE%></option>
				    				<option  value="<%=BSAdminConstants.CHAIN_UN_ATTRIBUTE%>" <%=standardStatus.equals(BSAdminConstants.CHAIN_UN_ATTRIBUTE)?"selected='true'":""%>><%=BSAdminConstants.CHAIN_UN_ATTRIBUTE%></option>
				    				</select>
				    			</td>
				           <%	}
					 			else 
					 			{
					       %>
					       		<td><p id="<%=chncode%>"><%=standardStatus %></p></td>
						   <% 		
						   		}
					        
					       %>
					      </tr>
					<% 
						} 
					%>
		        </table>
        	</td>
        	<td style="vertical-align: middle;padding-left: 60px;">
        		<div class="updBottons">            
           			 <input type="button" name="brandStatusUpdate" id="brandStatusUpdate" value="Update" title="Update"/> 
        		</div>   
        	</td>
        </tr>
        </table>
        <input type="hidden" value="<%=chainCode %>" name="selectedBrand" id="selectedBrand"/>
		<div class="clear"></div>	
		<!-- END Update Brand Status  -->
    </div>
    <!--ends rounded_container_contents -->
    <div class="rounded_container_bottom">&nbsp;</div>
</div>
<%
    } else {
%>
    Not logged in !!
<%
    }
%>