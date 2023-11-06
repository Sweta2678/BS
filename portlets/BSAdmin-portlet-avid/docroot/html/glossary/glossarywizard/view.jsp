<%@include file="/html/glossary/init.jsp" %>
<portlet:actionURL  name="Cancel" var="Cancel"/>
<portlet:resourceURL var="SaveGlossary" id="SaveGlossary" />

<script type="text/javascript">
	$(document).ready(function(){
	   $(".multis").multiselect();
	   $("#term_name").focus();
	});
	var successMessage = '<%=GlossaryUtil.SUCCESS_MESSAGE%>';
</script>

<c:if test ="${loggedIn}">
	<script src="/BSTheme-theme/js/glossaryAdmin.js"></script>
	<c:choose>
		<c:when test="${errorMessage ne null}">
			<c:out value="${errorMessage}"></c:out>
		</c:when>
		<c:otherwise>
			<div class="rounded_container">
		        <div class="rounded_container_contents">
		            <h4 class="short_page_subtitle">
						<c:choose>
							<c:when test="${glossaryId == '-1'}">
								Add New Entry
							</c:when>
							<c:otherwise>
								Edit Glossary
							</c:otherwise>
						</c:choose>
					</h4>
					<div class="clear"></div>
		            <div class="divider">&nbsp;</div>
		            <div class="clear"></div>
					
					<!-- Add New Glossary page content start -->
					<form id="glossaryForm"  method="post" name="glossaryForm" action="<%=SaveGlossary%>" class="glossary_form">
						<input type="hidden" name="<%=GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID%>" id="<%=GlossaryUtil.REQUEST_PARAM_GLOSSARY_ID%>" value="${glossaryView.glossary.glossaryId}"  />
						<input type="hidden" name="<%=GlossaryUtil.REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR%>" id="<%=GlossaryUtil.REQUEST_PARAM_GLOSSARY_VISIBLE_CHAR%>" value="${visibleChar}"  />
						<div class="field_wrapper">
							<span class="step" id="first_step">
			                    <label class="wrapper_label"><span class="wrapper_span"><em class="required">* </em>Term</span>              
			                        <input type="text" class="input_text required" name="term_name" id="term_name" maxlength="255" value="${glossaryView.glossary.glossaryTermText}"/>             
			                    </label>
			                    <label class="wrapper_label"><span class="wrapper_span"><em class="required">* </em>Definition</span>                 
			                        <textarea class="message" name="term_definition" id="term_definition" maxlength="4000">${glossaryView.glossary.glossaryTermDesc}</textarea>                        
			                    </label>
								<label class="wrapper_label">
									<span class="wrapper_span">Select Owner</span> 
									<select id="owner" name="owner">
										<c:forEach var="region" items="${standardRegion}">
											<c:choose>
												<c:when test="${region.regionId == glossaryView.glossary.glossaryOwner}">
													<option value="${region.regionId}" selected="selected">${region.regionName}</option>	
												</c:when>
												<c:otherwise>
													<option value="${region.regionId}">${region.regionName}</option>
												</c:otherwise>
											</c:choose>
										</c:forEach> 
				                    </select>
								</label>
								
								<div id="regionBrand">
									<c:forEach var="regionChn" items="${standardRegion}">
										   
										<c:if test="${regionChn.regionName != 'Global'}">    
											<label class="wrapper_label" id="regionLbl"><span class="wrapper_span">${regionChn.regionName}</span>              
												<select id="${fn:replace(regionChn.regionName, ' ', '' )}" class="multis required" name="${regionChn.regionName}" multiple="multiple"> 
													
													<c:forEach var="chnCode" items="${chnCdMap}">
													   <%boolean bFound = false; %>
													   <c:forEach var ="glossaryRegionNav" items="${glossaryView.glossaryRegionNav}">
														   	<c:if test="${regionChn.regionId == glossaryRegionNav.regionId  && chnCode.key ==  glossaryRegionNav.chainCode}">
															   <%bFound = true; %>
															</c:if>
													   </c:forEach>
													   
													   <c:choose>
														   <c:when test="<%=bFound%>">
														   	 <option value="${chnCode.key}" selected="selected">${chnCode.value}</option>
														   </c:when>
														   <c:otherwise>
														   	 <option value="${chnCode.key}">${chnCode.value}</option>
														   </c:otherwise>
													   </c:choose>
													
													</c:forEach> 
												</select>
					                    	</label>
				                    	</c:if>
									</c:forEach>
								</div>
			                    <label class="wrapper_label" for="publish"><span class="wrapper_span">Published</span>              
									<c:choose>
										<c:when test="${glossaryView.glossary.activeInd == 'Y' }">
											<input type="checkbox"  name="glossary_published" id="glossary_published" value="Y" checked/>
										</c:when>
										<c:otherwise>
											<input type="checkbox"  name="glossary_published" id="glossary_published" value="Y"/>
										</c:otherwise>
									</c:choose>	
			                                     
			
			                    </label>
			                    <div class="clear"></div>
			                    <div class="form_navigation glossary_form_bottom">  
			                    
			                    	<input type="submit" id="submit" name="submitButton" class="navigation_button" value="Save" title="Submit form" onclick=" return submitGlossary();">&nbsp;
			                   		<input type="button" id="form_cancel" class="navigation_button" title="Cancel"  value="Cancel" onclick="onCancel();"/>
			                    </div>
			                    <div class="clear"></div>
							</span>
						</div>
					</form> 
					 
		           <!-- Add New Glossary page content end -->
		        
		       
		    	</div><!--ends rounded_container -->
		 		<div class="rounded_container_bottom">&nbsp;</div>
			</div><!--ends grid_9 -->
		
			<div class="clear"></div>
		</c:otherwise>	
	</c:choose>
</c:if>

<c:if test="${!loggedIn}">
	Not logged in !!
</c:if>