<%@include file="/html/changeorder/init.jsp" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<c:choose>
    <c:when test="${(hasChangeOrderAccess)}">
        <portlet:actionURL  name="save" var="save"/>
        <portlet:resourceURL var="ajaxURL" id="getTreeData" escapeXml="false" />
        <portlet:resourceURL var="getStandardsUrl" id="getStandards"></portlet:resourceURL>
        <%--<portlet:resourceURL var="getFilteredUrl" id="getFilteredStandards"></portlet:resourceURL>
         <portlet:resourceURL var="copyStandardsUrl" id="copyStandards"></portlet:resourceURL> --%>
        <%
            String taxnomyId = (String)renderRequest.getAttribute("taxonomyId");
            String successMsg = (String)renderRequest.getAttribute("successMsg");
        %>
        <script>
            var getStandardURL = '<%=getStandardsUrl%>';
          <%--   var getFilterURL = '<%=getFilteredUrl%>'; --%>  
            var originalStandardIdsOrder = '${originalStandardIdsOrder}';
            var processedMsg = '<%=successMsg%>';
            
        </script>
       <!--  <style>
            
           .aui span.wrapper_span {
                width: 102px !important;
            }
           .aui .ui-multiselect-checkboxes label {
                width: 245px !important;
            }
            .aui button.ui-multiselect {
                width: 260px !important;
            }
            
            .aui ui-multiselect-menu ui-widget ui-widget-content ui-corner-all {
 				 width: 223px important;
			}


		.aui ui-widget-header ui-corner-all ui-multiselect-header ui-helper-clearfix 
		{
			width: 218px !important;
		}

		.aui ui-multiselect-checkboxes ui-helper-reset {
	  		width: 224px !important;
		}
        </style> -->
        <script type="text/javascript" src="/BSTheme-theme/js/changeorder.js"></script>
        <script type="text/javascript" charset="utf-8">
            var usrPrefChainCode = '${selectedBrand}';
            jQuery(function() {
                checkUserBrand(usrPrefChainCode);
                loadStandardsOrdering('<%=renderResponse.encodeURL(ajaxURL.toString())%>');
                /* copyStdOrders('${copyStandardsUrl}');
                jQuery(".copyBrand").multiselect();
                 */
                var indexId = <%=taxnomyId%>
                if(indexId != null)
                {
                    //jQuery(".copyBrand").multiselect();
                    getStandards(indexId);
                }
                if(processedMsg == 'true')
                {
                	jQuery.msgBox({
        				title: "Success!",
        				content: "Standards order saved successfully.", 
        				type: "info",
        				
        			});
                }
            });
        </script>
        <c:if test="${selectedBrand!='GL'}">
        <div class="rounded_container">
            <div class="rounded_container_contents">
                <h4>Change Order</h4>
                <p class="change_order_description">
                    To change the order of Standards at a point in the Index, first select the Index Position then adjust the order of the Standards returned.
                </p>
                <form id="order_standards" method="post" action="<%=save%>" onsubmit="processIds('#ordering_table', '#std_ids');">
                    <div class="clear"></div>
                    <div class="clear"></div>
                    <div>
                        <a class="open_tree_selection_link open_tree_selection"  title="tree selection link">Select or Change Index Position</a>
                        <br/>
                        <input type="text" value="${treeSelection}" name="treeSelection" id="tree_selection" class="input_text required" readonly="readonly" title="Select Index" />
                        <input type="hidden" value="${taxonomyId}" id="taxonomyId" name="taxonomyId"  />
                    </div>
                    <div class="clear"></div>
                    <input type="hidden" name="std_ids" id="std_ids" value=""/>
                    <div id="stdOrderSaveBtn" class="wizard_navigation">                            
                        <input class="navigation_button" id="Submit" value="Save" type="submit" style="margin-bottom:10px;" disabled=""/>
                    </div>
                   <!-- Remove as CR 29.2
                   <input type="hidden" name="filterBrand" id="filterBrand" value=""/>

                    <select id="brandList" class="brandList" name="brandList" title="Filter by Brand" onchange="filterByBrand();"> 
                        <option value="GL">Filter by Brand</option>
                        <c:forEach items="${chaCdMap}" var="chnCode">
                           <option value="${chnCode.key}" <c:if test="${chnCode.key eq selectedBrand}"> selected </c:if>> ${chnCode.value}</option>
                        </c:forEach>                                                                    
                    </select>                                                                       
                    
                      <div class="copyBtnDiv" id="copy_button">
                        <input class="copyClass" id="copyBtn" value="Copy" type="button" disabled="" title="To apply a sort order to another Brand, save it, click Copy, and select a Brand from the filter list."/>
                    </div> -->
                    
                    <div id="standards_div"></div>
                </form>
                <div class="clear"></div>           
            </div>
            <!--ends rounded_container_contents -->
            <div class="rounded_container_bottom">&nbsp;</div> 
        </div>
        </c:if>
        <!-- New Dailog ------------------------------> 
        <%-- <div class="report_container">
            <div id="CopyData" class="copyPopupContainer">
                <h4>Select brand for copy standards order</h4>
                <label class="wrapper_label"><span class="wrapper_span">Select brand:</span> 
                 <select multiple="multiple" id="copyBrands" name="copyBrand" class="copyBrand">
                    <c:forEach items="${chaCdMap}" var="chnCode">
                        <option value="${chnCode.key}"> ${chnCode.value}</option>
                    </c:forEach>
                 </select>
                </label>
                <div style="margin-top: 20px;">
                    <input id="cancelBtn" type="button" value="Cancel" style="margin-right: 10px; margin-top: 20px;"/>
                    <input id="copySaveBtn" type="button" value="Save" style="margin-top: 20px;" />
                </div>
            </div>
        </div>  --%>
        <!-- -------------------------------->
        <!-- Taxonomy Tree content --> 
        <a href="#TreeData" id="taxonomy_tree_details" title="" class="nyroModal" style="display:none;">DOM Element (hidden div)</a>
         
        <div id="TreeData" class="model_content">
            <h4>Select Index Position</h4>
            <p>
                Click on the arrows to expand the tree.<br/>
                Click a heading to choose where you would like to insert the Standard.<br/>
                The Standard will be inserted under the heading that you've selected.
            </p>
            <p class="small_text">
                <strong>You've selected: <span class="selected_tree_node">nothing yet</span></strong><span class="span_space">&nbsp;</span>
            </p>
            <p>
                <a class="close_page" title="accept seelcted item">Click here to accept this selection</a>
            </p>
            <div id="Taxonomy" class=" jstree jstree-4 jstree-default jstree-focused"> </div>
            <div class="clear"></div>
        </div>
        <!-- End of Taxonomy Tree content -->
        
        <!--ends rounded_container -->
    </c:when>
    <c:otherwise>
        You do not have access to this portlet. Please contact support/technical team to get access to this portlet.
    </c:otherwise>
</c:choose>

<script type="text/javascript">
    
    //var usrPrefRegionCode = '${usrPrefChainCode}';

</script>