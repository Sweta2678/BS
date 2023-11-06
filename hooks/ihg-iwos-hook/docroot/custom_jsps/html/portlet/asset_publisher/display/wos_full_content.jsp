<%--
/**
 * Copyright (c) 2000-2013 Liferay, Inc. All rights reserved.
 *
 * The contents of this file are subject to the terms of the Liferay Enterprise
 * Subscription License ("License"). You may not use this file except in
 * compliance with the License. You can obtain a copy of the License by
 * contacting Liferay, Inc. See the License for the specific language governing
 * permissions and limitations under the License, including but not limited to
 * distribution rights of the Software.
 *
 *
 *
 */
--%>

<%@page import="com.liferay.portlet.expando.service.ExpandoValueLocalServiceUtil"%>
<%@page import="com.liferay.portal.theme.ThemeDisplay"%>
<%@page import="com.liferay.portlet.expando.model.ExpandoTableConstants"%>
<%@page import="javax.portlet.PortletSession"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="javax.portlet.RenderRequest"%>
<%@page import="javax.portlet.PortletException"%>
<%@page import="java.io.IOException"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="com.ihg.me2.utils.session.MerlinSession"%>
<%@page import="com.liferay.portal.kernel.exception.SystemException"%>
<%@page import="com.liferay.portal.kernel.exception.PortalException"%>
<%@page import="com.liferay.portal.service.UserLocalServiceUtil"%>
<%@page import="com.liferay.portal.model.User"%>
<%@ include file="/html/portlet/asset_publisher/init.jsp" %>

<%
String redirect = ParamUtil.getString(request, "redirect");
		 //String PDB_ROLE="WOS_PDBROLE";
List results = (List)request.getAttribute("view.jsp-results");

if (Validator.isNull(redirect) && results.isEmpty()) {
	PortletURL portletURL = renderResponse.createRenderURL();

	portletURL.setParameter("struts_action", "/asset_publisher/view");

	redirect = portletURL.toString();
}

int assetEntryIndex = ((Integer)request.getAttribute("view.jsp-assetEntryIndex")).intValue();

AssetEntry assetEntry = (AssetEntry)request.getAttribute("view.jsp-assetEntry");
AssetRendererFactory assetRendererFactory = (AssetRendererFactory)request.getAttribute("view.jsp-assetRendererFactory");
AssetRenderer assetRenderer = (AssetRenderer)request.getAttribute("view.jsp-assetRenderer");

String languageId = LanguageUtil.getLanguageId(request);

String title = assetRenderer.getTitle(LocaleUtil.fromLanguageId(languageId));

boolean show = ((Boolean)request.getAttribute("view.jsp-show")).booleanValue();
boolean print = ((Boolean)request.getAttribute("view.jsp-print")).booleanValue();

request.setAttribute(WebKeys.LAYOUT_ASSET_ENTRY, assetEntry);

request.setAttribute("view.jsp-fullContentRedirect", currentURL);
request.setAttribute("view.jsp-showIconLabel", true);


/********************************************************************
*   TJG PERMISSION CHANGES
********************************************************************/
try
{
String targetRole = (String)request.getSession().getAttribute("targetPDRole");
if(targetRole==null||targetRole.trim().equals("")){
	targetRole=setPDBRoles(renderRequest);
}

String targetnewRegion = (String)request.getSession().getAttribute("targetnewRegion");
String pdbTargetRole = (String)request.getSession().getAttribute("WOS_USRROLE");
if(pdbTargetRole==null||pdbTargetRole.trim().equals("")){
	pdbTargetRole=saveRole(renderRequest,themeDisplay);
}
targetnewRegion = (String)request.getSession().getAttribute("targetnewRegion");

if((pdbTargetRole.equals("ARM")) || (pdbTargetRole.equals("GMM"))){
   pdbTargetRole = targetRole;
}

boolean showContents = false;
boolean flagBrk = false; 

JournalArticle wc = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());

String localeContent = wc.getContent();

com.liferay.portal.kernel.xml.Document document = com.liferay.portal.kernel.xml.SAXReaderUtil.read(localeContent);

String target_roles = document.selectSingleNode("/root/dynamic-element[@name='target_roles']/dynamic-content").getStringValue();
String regions = document.selectSingleNode("/root/dynamic-element[@name='regions']/dynamic-content").getStringValue();
String view_roles = document.selectSingleNode("/root/dynamic-element[@name='view_roles']/dynamic-content").getStringValue();

if((targetRole!= null) && (!targetRole.equals(""))){
   if(target_roles.contains(targetRole)){
		if(flagBrk == false){
			showContents = true;
            flagBrk = true;
        }
   }
   
   if((targetnewRegion!=null) && (!targetnewRegion.equals("")) && (showContents == true)){
       showContents = false;
       flagBrk = false;
       if(regions.contains(targetnewRegion)){
            if(flagBrk == false){
             	showContents = true;
                flagBrk = true;
            }
		}
   }
}

boolean checkPdRole = false;
if((pdbTargetRole != null) && (!pdbTargetRole.equals(""))){
	if(view_roles.contains(pdbTargetRole)){
       	checkPdRole = true;
    }
}

if(showContents==true && checkPdRole==false){
     showContents =false;
}

if(showContents){


/********************************************************************
*   END MAIN BLOCK OF TJG PERMISSION CHANGES
********************************************************************/
%>

<c:if test="<%= showAssetTitle %>">
	<liferay-ui:header
		backURL="<%= print ? null : redirect %>"
		localizeTitle="<%= false %>"
		title="<%= title %>"
	/>
</c:if>

<div class="asset-full-content <%= defaultAssetPublisher ? "default-asset-publisher" : StringPool.BLANK %> <%= showAssetTitle ? "show-asset-title" : "no-title" %>">
	<c:if test="<%= !print %>">
		<liferay-util:include page="/html/portlet/asset_publisher/asset_actions.jsp" />
	</c:if>

	<c:if test="<%= (enableConversions && assetRenderer.isConvertible()) || (enablePrint && assetRenderer.isPrintable()) || (showAvailableLocales && assetRenderer.isLocalizable()) %>">
		<div class="asset-user-actions">
			<c:if test="<%= enablePrint %>">
				<div class="print-action">
					<%@ include file="/html/portlet/asset_publisher/asset_print.jspf" %>
				</div>
			</c:if>

			<c:if test="<%= (enableConversions && assetRenderer.isConvertible()) && !print %>">

				<%
				PortletURL exportAssetURL = assetRenderer.getURLExport(liferayPortletRequest, liferayPortletResponse);
				%>

				<div class="export-actions">
					<%@ include file="/html/portlet/asset_publisher/asset_export.jspf" %>
				</div>
			</c:if>
			<c:if test="<%= (showAvailableLocales && assetRenderer.isLocalizable()) && !print %>">

				<%
				String[] availableLanguageIds = assetRenderer.getAvailableLanguageIds();
				%>

				<c:if test="<%= availableLanguageIds.length > 1 %>">
					<c:if test="<%= enableConversions || enablePrint %>">
						<div class="locale-separator"> </div>
					</c:if>

					<div class="locale-actions">
						<liferay-ui:language displayStyle="<%= 0 %>" formAction="<%= currentURL %>" languageId="<%= languageId %>" languageIds="<%= availableLanguageIds %>" />
					</div>
				</c:if>
			</c:if>
		</div>
	</c:if>

	<%

	// Dynamically created asset entries are never persisted so incrementing the view counter breaks

	if (!assetEntry.isNew() && assetEntry.isVisible()) {
		AssetEntry incrementAssetEntry = null;

		if (assetEntryQuery.isEnablePermissions()) {
			incrementAssetEntry = AssetEntryServiceUtil.incrementViewCounter(assetEntry.getClassName(), assetEntry.getClassPK());
		}
		else {
			incrementAssetEntry = AssetEntryLocalServiceUtil.incrementViewCounter(user.getUserId(), assetEntry.getClassName(), assetEntry.getClassPK());
		}

		if (incrementAssetEntry != null) {
			assetEntry = incrementAssetEntry;
		}
	}

	if (showContextLink) {
		if (PortalUtil.getPlidFromPortletId(assetRenderer.getGroupId(), assetRendererFactory.getPortletId()) == 0) {
			showContextLink = false;
		}
	}

	PortletURL viewFullContentURL = renderResponse.createRenderURL();

	viewFullContentURL.setParameter("struts_action", "/asset_publisher/view_content");
	viewFullContentURL.setParameter("type", assetRendererFactory.getType());
	viewFullContentURL.setParameter("viewMode", print ? Constants.PRINT : Constants.VIEW);

	if (Validator.isNotNull(assetRenderer.getUrlTitle())) {
		if (assetRenderer.getGroupId() != scopeGroupId) {
			viewFullContentURL.setParameter("groupId", String.valueOf(assetRenderer.getGroupId()));
		}

		viewFullContentURL.setParameter("urlTitle", assetRenderer.getUrlTitle());
	}

	String viewFullContentURLString = viewFullContentURL.toString();

	viewFullContentURLString = HttpUtil.setParameter(viewFullContentURLString, "redirect", currentURL);
	%>

	<div class="asset-content" id="<portlet:namespace /><%= assetEntry.getEntryId() %>">
		<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("top") && !print %>'>
			<liferay-ui:social-bookmarks
				contentId="<%= String.valueOf(assetEntry.getEntryId()) %>"
				displayStyle="<%= socialBookmarksDisplayStyle %>"
				target="_blank"
				title="<%= title %>"
				url="<%= PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout) %>"
			/>
		</c:if>

		<%
		String path = assetRenderer.render(renderRequest, renderResponse, AssetRenderer.TEMPLATE_FULL_CONTENT);

		request.setAttribute(WebKeys.ASSET_RENDERER_FACTORY, assetRendererFactory);
		request.setAttribute(WebKeys.ASSET_RENDERER, assetRenderer);
		%>

		<liferay-util:include page="<%= path %>" portletId="<%= assetRendererFactory.getPortletId() %>">
			<liferay-util:param name="showHeader" value="<%= Boolean.FALSE.toString() %>" />
		</liferay-util:include>

		<c:if test="<%= enableFlags %>">
			<div class="asset-flag">
				<liferay-ui:flags
					className="<%= assetEntry.getClassName() %>"
					classPK="<%= assetEntry.getClassPK() %>"
					contentTitle="<%= title %>"
					reportedUserId="<%= assetRenderer.getUserId() %>"
				/>
			</div>
		</c:if>

		<c:if test='<%= enableSocialBookmarks && socialBookmarksDisplayPosition.equals("bottom") && !print %>'>
			<liferay-ui:social-bookmarks
				displayStyle="<%= socialBookmarksDisplayStyle %>"
				target="_blank"
				title="<%= title %>"
				url="<%= PortalUtil.getCanonicalURL(viewFullContentURL.toString(), themeDisplay, layout) %>"
			/>
		</c:if>

		<c:if test="<%= enableRatings %>">
			<div class="asset-ratings">

				<%
				String assetEntryClassName = assetEntry.getClassName();

				String ratingsType = "stars";

				if (assetEntryClassName.equals(MBDiscussion.class.getName()) || assetEntryClassName.equals(MBMessage.class.getName())) {
					ratingsType = "thumbs";
				}
				%>

				<liferay-ui:ratings
					className="<%= assetEntry.getClassName() %>"
					classPK="<%= assetEntry.getClassPK() %>"
					type="<%= ratingsType %>"
				/>
			</div>
		</c:if>

		<c:if test="<%= showContextLink && !print && assetEntry.isVisible() %>">
			<div class="asset-more">
				<a href="<%= assetRenderer.getURLViewInContext(liferayPortletRequest, liferayPortletResponse, viewFullContentURLString) %>"><liferay-ui:message key="<%= assetRenderer.getViewInContextMessage() %>" /> &raquo;</a>
			</div>
		</c:if>

		<br />

		<c:if test="<%= enableRelatedAssets %>">
			<liferay-ui:asset-links
				assetEntryId="<%= assetEntry.getEntryId() %>"
			/>
		</c:if>

		<c:if test="<%= Validator.isNotNull(assetRenderer.getDiscussionPath()) && enableComments %>">
			<br />

			<portlet:actionURL var="discussionURL">
				<portlet:param name="struts_action" value='<%= "/asset_publisher/" + assetRenderer.getDiscussionPath() %>' />
			</portlet:actionURL>

			<liferay-ui:discussion
				className="<%= assetEntry.getClassName() %>"
				classPK="<%= assetEntry.getClassPK() %>"
				formAction="<%= discussionURL %>"
				formName='<%= "fm" + assetEntry.getClassPK() %>'
				ratingsEnabled="<%= enableCommentRatings %>"
				redirect="<%= currentURL %>"
				userId="<%= assetRenderer.getUserId() %>"
			/>
		</c:if>
	</div>

	<c:if test="<%= show %>">
		<div class="asset-metadata">

			<%
			request.setAttribute("asset_metadata.jspf-filterByMetadata", true);
			%>

			<%@ include file="/html/portlet/asset_publisher/asset_metadata.jspf" %>
		</div>
	</c:if>
</div>

<c:if test="<%= !showAssetTitle && ((assetEntryIndex + 1) < results.size()) %>">
	<div class="separator"><!-- --></div>
</c:if>
<%
}
}
catch (Exception e)
{
	 System.out.println("Exception!!!!!---------->"+e.getMessage());	
	 e.printStackTrace();
}
%>


<%!
public String setPDBRoles(RenderRequest renderRequest){
	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	String screenName = "";
	String usrtype = "";
	User user= null;
	final String USR_ROLE = "WOS_USRROLE";
	final String WOS_ROLE="WOS Role";
	String PDB_ROLE="WOS_PDBROLE";
	long userId = PortalUtil.getUserId(request);
	Map<String, String> userPreferences = null;

	try {
		user = UserLocalServiceUtil.getUserById(userId);
	}catch (PortalException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (SystemException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
	screenName = user.getScreenName();
	String lastName=user.getLastName();
	String lastNameInitial="";
	String jobcode;
			
	// Make sure the preferences are set
	userPreferences = MerlinSession.get(screenName);		
	if( userPreferences == null ){
	userPreferences = new HashMap<String, String>();
	MerlinSession.set(screenName, userPreferences);
	}
	
	usrtype = userPreferences.get("USRTYP");
	Integer jobCode=null;
	//String jobtitle="DOS[100659]";
	String jobtitle=user.getJobTitle();
	int index=jobtitle.indexOf("[");
	int lastindex=jobtitle.indexOf("]");
	if(index==-1){
	
	}
	else
	{
	jobcode=jobtitle.substring(index+1,lastindex);
	jobCode=Integer.parseInt(jobcode);
	}
	
	String jobCodeText="";
	
	if(jobCode!=null){
	if(isDirectorOfSales(jobCode)){
	    jobCodeText="DOS";
	}else if(isDirectorOfSalesMarketing(jobCode)){
		jobCodeText="DSOM";
	}else if(isGlobalAccountDirector(jobCode)){
		jobCodeText="GAD";
	}else if(isKeyAccountDirector(jobCode)){
		jobCodeText="KAD";
	}else if(isKeyAccountManager(jobCode)){
		jobCodeText="KAM";
	}else if(isSalesCoordinatorSalesAssociate(jobCode)){
		jobCodeText="Sales Coordinator";
	}else if(isSalesManager(jobCode)){
		jobCodeText="Sales Mgr";
	}else if(isSegmentDirector(jobCode)){
		jobCodeText="Segment Dir";
	}
	}
	
	
	if("".equals(jobCodeText)){
		if("C".equalsIgnoreCase(usrtype)){
			jobCodeText = "Segment Dir";
		}else{
			jobCodeText = "DOS";
		}
	}
	
	
	
	userPreferences.put(PDB_ROLE, jobCodeText);
	String sessionPDROLE=userPreferences.get(PDB_ROLE);
	if(sessionPDROLE!=null){
		renderRequest.getPortletSession().setAttribute("targetPDRole", sessionPDROLE.trim(), PortletSession.APPLICATION_SCOPE);
	}
	
	return sessionPDROLE;
}

/* Method to save the role selected by the user */	


public String saveRole(RenderRequest renderRequest, ThemeDisplay themeDisplay 
	) throws IOException, PortletException {
	
	final String WOS_ROLE="WOS Role";
	String screenName = "";
	User user= null;
	HttpServletRequest request = PortalUtil.getHttpServletRequest(renderRequest);
	long userId = PortalUtil.getUserId(request);
	
	
	
	try {
	user = UserLocalServiceUtil.getUserById(userId);
	}catch (PortalException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	} catch (SystemException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
	}
	screenName = user.getScreenName();
	// Make sure the preferences are set
	Map<String, String> userPreferences = null;
	userPreferences = MerlinSession.get(screenName);		
	if( userPreferences == null ){
		userPreferences = new HashMap<String, String>();
		MerlinSession.set(screenName, userPreferences);
	}
	String usrtype = userPreferences.get("USRTYP");
	String jobTitle = user.getJobTitle();
	String jobcode;
	Integer jobCode=null;
	
	
	int index=jobTitle.indexOf("[");
	int lastindex=jobTitle.indexOf("]");
	if(index==-1){
	
	}
	else
	{
	jobcode=jobTitle.substring(index+1,lastindex);
	jobCode=Integer.parseInt(jobcode);
	}
	
	String jobCodeText="";
	
	if(jobCode!=null){
	if(isDirectorOfSales(jobCode)){
	    jobCodeText="DOS";
	}else if(isDirectorOfSalesMarketing(jobCode)){
		jobCodeText="DSOM";
	}else if(isGlobalAccountDirector(jobCode)){
		jobCodeText="GAD";
	}else if(isKeyAccountDirector(jobCode)){
		jobCodeText="KAD";
	}else if(isKeyAccountManager(jobCode)){
		jobCodeText="KAM";
	}else if(isSalesCoordinatorSalesAssociate(jobCode)){
		jobCodeText="Sales Coordinator";
	}else if(isSalesManager(jobCode)){
		jobCodeText="Sales Mgr";
	}else if(isSegmentDirector(jobCode)){
		jobCodeText="Segment Dir";
	}
	}
	
	
	if("".equals(jobCodeText)){
		if("C".equalsIgnoreCase(usrtype)){
			jobCodeText = "Segment Dir";
		}else{
			jobCodeText = "DOS";
		}
	}
	
	
	String role= getExpandoValue(themeDisplay.getCompanyId(), User.class.getName(), 
	        ExpandoTableConstants.DEFAULT_TABLE_NAME,
	        WOS_ROLE, user.getUserId());
	
	screenName = user.getScreenName();
	
	userPreferences = MerlinSession.get(screenName);
	
	if( userPreferences == null ){
	userPreferences = new HashMap<String, String>();
	MerlinSession.set(screenName, userPreferences);
	}
	
	
	
	String sessionLocation=userPreferences.get("CURRREG");
	String existRegion=(String)renderRequest.getPortletSession().getAttribute("targetRegion",PortletSession.APPLICATION_SCOPE);
	if(sessionLocation!=null && existRegion==null){
	renderRequest.getPortletSession().setAttribute("targetRegion", sessionLocation, PortletSession.APPLICATION_SCOPE);
	}
	String sessionnewLocation=userPreferences.get("CURRNEWREG");
	String existnewRegion=(String)renderRequest.getPortletSession().getAttribute("targetnewRegion",PortletSession.APPLICATION_SCOPE);
	if(sessionnewLocation!=null && existnewRegion==null){
	renderRequest.getPortletSession().setAttribute("targetnewRegion", sessionnewLocation, PortletSession.APPLICATION_SCOPE);
	}
	
	/*actionRequest.getPortletSession().setAttribute("WOS_USRROLE", jobTitle);
	*/renderRequest.getPortletSession().setAttribute("WOS_USRROLE", jobTitle, PortletSession.APPLICATION_SCOPE);
	//session.setAttribute(USR_ROLE, jobTitle);
	//renderRequest.setPortletMode(PortletMode.VIEW); 
	return role;
}

public static String getExpandoValue(long companyId, String className, String expandoTableName,
		String expandoColumnName, long classPK)
{
	String data = ""; 
			
	try 
	{
		Object attributeVale = ExpandoValueLocalServiceUtil.getData(companyId, className,
				expandoTableName, expandoColumnName, classPK);
		
		if(attributeVale != null)
		{
			data = attributeVale.toString();
		}
	}
	catch (Exception e) 
	{
		e.printStackTrace();
	}
	
	
	return data;
}


%>

<%!

	public boolean isDirectorOfSales(Integer peopleDBRoleID)  {
		
		boolean isDOS;
		
        switch (peopleDBRoleID) {
			case 371:  isDOS=true; break;
			case 383:  isDOS=true; break;
			case 100196:  isDOS=true; break;
			case 100448:  isDOS=true; break;
			case 100586:  isDOS=true; break;
			case 191689:  isDOS=true; break;
			case 191693:  isDOS=true; break;
			case 191699:  isDOS=true; break;
			case 193924:  isDOS=true; break;
			case 333373:  isDOS=true; break;
			case 390331:  isDOS=true; break;
			case 390460:  isDOS=true; break;
			case 390619:  isDOS=true; break;
			case 390855:  isDOS=true; break;
			case 390923:  isDOS=true; break;
			case 390927:  isDOS=true; break;
			case 391056:  isDOS=true; break;
			case 391270:  isDOS=true; break;
			case 391472:  isDOS=true; break;
			case 392266:  isDOS=true; break;
			case 392350:  isDOS=true; break;
			case 392382:  isDOS=true; break;
			case 392521:  isDOS=true; break;
			case 392555:  isDOS=true; break;
			case 392954:  isDOS=true; break;
			case 393517:  isDOS=true; break;
			case 393535:  isDOS=true; break;
			case 393703:  isDOS=true; break;
			case 393881:  isDOS=true; break;
			case 394050:  isDOS=true; break;
			case 394171:  isDOS=true; break;
			case 394649:  isDOS=true; break;
			case 394679:  isDOS=true; break;
			case 394695:  isDOS=true; break;
			case 394833:  isDOS=true; break;
			case 395329:  isDOS=true; break;
			case 395347:  isDOS=true; break;
			case 395574:  isDOS=true; break;
			case 395740:  isDOS=true; break;
			case 395816:  isDOS=true; break;
			case 395954:  isDOS=true; break;
			case 396146:  isDOS=true; break;
			case 500015:  isDOS=true; break;
			case 500445:  isDOS=true; break;
			case 500451:  isDOS=true; break;
			case 500817:  isDOS=true; break;
			case 500828:  isDOS=true; break;
			case 501031:  isDOS=true; break;
			case 501057:  isDOS=true; break;
			case 501092:  isDOS=true; break;
			case 550018:  isDOS=true; break;
			case 590022:  isDOS=true; break;
			case 590119:  isDOS=true; break;
			case 590120:  isDOS=true; break;
			case 590121:  isDOS=true; break;
			case 590122:  isDOS=true; break;
			case 590123:  isDOS=true; break;
			case 590124:  isDOS=true; break;
			case 590125:  isDOS=true; break;
			case 590126:  isDOS=true; break;
			case 590127:  isDOS=true; break;
			case 590128:  isDOS=true; break;
			case 590129:  isDOS=true; break;
			case 590130:  isDOS=true; break;
			case 590131:  isDOS=true; break;
			case 590132:  isDOS=true; break;
			case 590133:  isDOS=true; break;
			case 590134:  isDOS=true; break;
			case 590135:  isDOS=true; break;
			case 590136:  isDOS=true; break;
			case 590137:  isDOS=true; break;
			case 590138:  isDOS=true; break;
			case 590139:  isDOS=true; break;
			case 590140:  isDOS=true; break;
			case 590167:  isDOS=true; break;
			case 590169:  isDOS=true; break;
			case 590171:  isDOS=true; break;
			case 590178:  isDOS=true; break;
			case 600035:  isDOS=true; break;
			case 600318:  isDOS=true; break;
			case 600941:  isDOS=true; break;
			case 601088:  isDOS=true; break;
			case 601222:  isDOS=true; break;
			case 601231:  isDOS=true; break;
			case 601322:  isDOS=true; break;
			case 601511:  isDOS=true; break;
			case 601631:  isDOS=true; break;
			case 601653:  isDOS=true; break;
			case 601703:  isDOS=true; break;
			case 601895:  isDOS=true; break;
			case 602037:  isDOS=true; break;
			case 602042:  isDOS=true; break;
			case 602210:  isDOS=true; break;
			case 602359:  isDOS=true; break;
			case 602513:  isDOS=true; break;
			case 602560:  isDOS=true; break;
			case 602582:  isDOS=true; break;
			case 603234:  isDOS=true; break;
			case 603337:  isDOS=true; break;
			case 603437:  isDOS=true; break;
			case 605003:  isDOS=true; break;
			case 605017:  isDOS=true; break;
			case 605079:  isDOS=true; break;
			case 605098:  isDOS=true; break;
			case 605223:  isDOS=true; break;
			case 605278:  isDOS=true; break;
			case 605342:  isDOS=true; break;
			case 605385:  isDOS=true; break;
			case 605546:  isDOS=true; break;
			case 605939:  isDOS=true; break;
			case 606161:  isDOS=true; break;
			case 650250:  isDOS=true; break;
			case 650563:  isDOS=true; break;
			case 650754:  isDOS=true; break;
			case 650865:  isDOS=true; break;
			case 651267:  isDOS=true; break;
			case 680163:  isDOS=true; break;
			case 680165:  isDOS=true; break;
			case 800031:  isDOS=true; break;

            default: isDOS=false; break;
        }

		return isDOS;
	}	

	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Director of Sales & Marketing
	 *
	 * @return boolean 
	 *
	 */
	public boolean isDirectorOfSalesMarketing(Integer peopleDBRoleID) {
		
		boolean isDOSM;
		
        switch (peopleDBRoleID) {
			case 336:  isDOSM=true; break;
			case 384:  isDOSM=true; break;
			case 100659:  isDOSM=true; break;
			case 191686:  isDOSM=true; break;
			case 192172:  isDOSM=true; break;
			case 193487:  isDOSM=true; break;
			case 390552:  isDOSM=true; break;
			case 390868:  isDOSM=true; break;
			case 390968:  isDOSM=true; break;
			case 390987:  isDOSM=true; break;
			case 391099:  isDOSM=true; break;
			case 391274:  isDOSM=true; break;
			case 391314:  isDOSM=true; break;
			case 391351:  isDOSM=true; break;
			case 391553:  isDOSM=true; break;
			case 391605:  isDOSM=true; break;
			case 391640:  isDOSM=true; break;
			case 391946:  isDOSM=true; break;
			case 391995:  isDOSM=true; break;
			case 392020:  isDOSM=true; break;
			case 392043:  isDOSM=true; break;
			case 392145:  isDOSM=true; break;
			case 392219:  isDOSM=true; break;
			case 392237:  isDOSM=true; break;
			case 392457:  isDOSM=true; break;
			case 392772:  isDOSM=true; break;
			case 392777:  isDOSM=true; break;
			case 392867:  isDOSM=true; break;
			case 392908:  isDOSM=true; break;
			case 393127:  isDOSM=true; break;
			case 393148:  isDOSM=true; break;
			case 393286:  isDOSM=true; break;
			case 393581:  isDOSM=true; break;
			case 393695:  isDOSM=true; break;
			case 393794:  isDOSM=true; break;
			case 393814:  isDOSM=true; break;
			case 393943:  isDOSM=true; break;
			case 394061:  isDOSM=true; break;
			case 394118:  isDOSM=true; break;
			case 394121:  isDOSM=true; break;
			case 394291:  isDOSM=true; break;
			case 394530:  isDOSM=true; break;
			case 394553:  isDOSM=true; break;
			case 394674:  isDOSM=true; break;
			case 394785:  isDOSM=true; break;
			case 394901:  isDOSM=true; break;
			case 395261:  isDOSM=true; break;
			case 395318:  isDOSM=true; break;
			case 395656:  isDOSM=true; break;
			case 395719:  isDOSM=true; break;
			case 396447:  isDOSM=true; break;
			case 500279:  isDOSM=true; break;
			case 600130:  isDOSM=true; break;
			case 600146:  isDOSM=true; break;
			case 600312:  isDOSM=true; break;
			case 600369:  isDOSM=true; break;
			case 600454:  isDOSM=true; break;
			case 600496:  isDOSM=true; break;
			case 600626:  isDOSM=true; break;
			case 600705:  isDOSM=true; break;
			case 600908:  isDOSM=true; break;
			case 600936:  isDOSM=true; break;
			case 600979:  isDOSM=true; break;
			case 600984:  isDOSM=true; break;
			case 601172:  isDOSM=true; break;
			case 601199:  isDOSM=true; break;
			case 601293:  isDOSM=true; break;
			case 601405:  isDOSM=true; break;
			case 601416:  isDOSM=true; break;
			case 601428:  isDOSM=true; break;
			case 601618:  isDOSM=true; break;
			case 601639:  isDOSM=true; break;
			case 601751:  isDOSM=true; break;
			case 601759:  isDOSM=true; break;
			case 602057:  isDOSM=true; break;
			case 602113:  isDOSM=true; break;
			case 602455:  isDOSM=true; break;
			case 602588:  isDOSM=true; break;
			case 603111:  isDOSM=true; break;
			case 603549:  isDOSM=true; break;
			case 605275:  isDOSM=true; break;
			case 605324:  isDOSM=true; break;
			case 605601:  isDOSM=true; break;
			case 605653:  isDOSM=true; break;
			case 605839:  isDOSM=true; break;
			case 605867:  isDOSM=true; break;
			case 605877:  isDOSM=true; break;
			case 606110:  isDOSM=true; break;
			case 606121:  isDOSM=true; break;
			case 650034:  isDOSM=true; break;
			case 650083:  isDOSM=true; break;
			case 650319:  isDOSM=true; break;
			case 650487:  isDOSM=true; break;
			case 650512:  isDOSM=true; break;
			case 650572:  isDOSM=true; break;
			case 650720:  isDOSM=true; break;
			case 650825:  isDOSM=true; break;
			case 651070:  isDOSM=true; break;
			case 651140:  isDOSM=true; break;
			case 651172:  isDOSM=true; break;
			case 651307:  isDOSM=true; break;
			case 651317:  isDOSM=true; break;
			case 651333:  isDOSM=true; break;
			case 651422:  isDOSM=true; break;
			case 680013:  isDOSM=true; break;
			case 680216:  isDOSM=true; break;

            default: isDOSM=false; break;
        }

		return isDOSM;
	}
	
	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Segment Director
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isSegmentDirector(Integer peopleDBRoleID) {
		
		boolean isSD;
		
        switch (peopleDBRoleID) {
			case 100202:  isSD=true; break;
			case 101228:  isSD=true; break;
			case 101240:  isSD=true; break;
	
            default: isSD=false; break;
        }

		return isSD;
	}
	
	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Global Account Director
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isGlobalAccountDirector(Integer peopleDBRoleID) {
		
		boolean isGAD;
		
        switch (peopleDBRoleID) {
			case 101170:  isGAD=true; break;
			case 605008:  isGAD=true; break;
			case 500621:  isGAD=true; break;
	
            default: isGAD=false; break;
        }

		return isGAD;
	}

	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Key Account Director
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isKeyAccountDirector(Integer peopleDBRoleID){
		
		boolean isKAD;
		
        switch (peopleDBRoleID) {
			case 100203:  isKAD=true; break;
			case 100458:  isKAD=true; break;
			case 500071:  isKAD=true; break;
			case 605813:  isKAD=true; break;
			case 101229:  isKAD=true; break;
			case 500669:  isKAD=true; break;
			case 650668:  isKAD=true; break;
			case 500800:  isKAD=true; break;
			case 500891:  isKAD=true; break;
			case 500801:  isKAD=true; break;
			case 391913:  isKAD=true; break;
			case 501087:  isKAD=true; break;
			case 395793:  isKAD=true; break;
	
            default: isKAD=false; break;
        }

		return isKAD;
	}
	
	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Key Account Manager
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isKeyAccountManager(Integer peopleDBRoleID) {
		
		boolean isKAM;
		
        switch (peopleDBRoleID) {
			case 100794:  isKAM=true; break;
			case 101150:  isKAM=true; break;
			case 650293:  isKAM=true; break;
			case 605813:  isKAM=true; break;
			case 650302:  isKAM=true; break;
			case 650322:  isKAM=true; break;
			case 650668:  isKAM=true; break;
			case 500904:  isKAM=true; break;
			case 390346:  isKAM=true; break;
			case 390469:  isKAM=true; break;
			case 391865:  isKAM=true; break;
			case 393036:  isKAM=true; break;
			case 101350:  isKAM=true; break;
			case 590174:  isKAM=true; break;
			case 590173:  isKAM=true; break;
			case 394286:  isKAM=true; break;
	
            default: isKAM=false; break;
        }

		return isKAM;
	}

	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Sales Coordinator/Sales Associate:
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isSalesCoordinatorSalesAssociate(Integer peopleDBRoleID){
		
		boolean isSCSA;
		
        switch (peopleDBRoleID) {
			case	3178:  isSCSA=true; break;
			case	3185:  isSCSA=true; break;
			case	300114:  isSCSA=true; break;
			case	605384:  isSCSA=true; break;
			case	605402:  isSCSA=true; break;
			case	605488:  isSCSA=true; break;
			case	680003:  isSCSA=true; break;
			case	602144:  isSCSA=true; break;
			case	605573:  isSCSA=true; break;
			case	605641:  isSCSA=true; break;
			case	602291:  isSCSA=true; break;
			case	605108:  isSCSA=true; break;
			case	605157:  isSCSA=true; break;
			case	605183:  isSCSA=true; break;
			case	605185:  isSCSA=true; break;
			case	605211:  isSCSA=true; break;
			case	602446:  isSCSA=true; break;
			case	600074:  isSCSA=true; break;
			case	605300:  isSCSA=true; break;
			case	600939:  isSCSA=true; break;
			case	600250:  isSCSA=true; break;
			case	600275:  isSCSA=true; break;
			case	600499:  isSCSA=true; break;
			case	600610:  isSCSA=true; break;
			case	600616:  isSCSA=true; break;
			case	600704:  isSCSA=true; break;
			case	600806:  isSCSA=true; break;
			case	602000:  isSCSA=true; break;
			case	601373:  isSCSA=true; break;
			case	601515:  isSCSA=true; break;
			case	601560:  isSCSA=true; break;
			case	670036:  isSCSA=true; break;
			case	670063:  isSCSA=true; break;
			case	605816:  isSCSA=true; break;
			case	606033:  isSCSA=true; break;
			case	606076:  isSCSA=true; break;
			case	602862:  isSCSA=true; break;
			case	650142:  isSCSA=true; break;
			case	650149:  isSCSA=true; break;
			case	680286:  isSCSA=true; break;
			case	333397:  isSCSA=true; break;
			case	650980:  isSCSA=true; break;
			case	651002:  isSCSA=true; break;
			case	651008:  isSCSA=true; break;
			case	651013:  isSCSA=true; break;
			case	651027:  isSCSA=true; break;
			case	651028:  isSCSA=true; break;
			case	651062:  isSCSA=true; break;
			case	650248:  isSCSA=true; break;
			case	650280:  isSCSA=true; break;
			case	650479:  isSCSA=true; break;
			case	650594:  isSCSA=true; break;
			case	650652:  isSCSA=true; break;
			case	650861:  isSCSA=true; break;
			case	650868:  isSCSA=true; break;
			case	650870:  isSCSA=true; break;
			case	650875:  isSCSA=true; break;
			case	650898:  isSCSA=true; break;
			case	651106:  isSCSA=true; break;
			case	390618:  isSCSA=true; break;
			case	651291:  isSCSA=true; break;
			case	651231:  isSCSA=true; break;
			case	390533:  isSCSA=true; break;
			case	391854:  isSCSA=true; break;
			case	391931:  isSCSA=true; break;
			case	392018:  isSCSA=true; break;
			case	651396:  isSCSA=true; break;
			case	651309:  isSCSA=true; break;
			case	391282:  isSCSA=true; break;
			case	391325:  isSCSA=true; break;
			case	391347:  isSCSA=true; break;
			case	391348:  isSCSA=true; break;
			case	391558:  isSCSA=true; break;
			case	391648:  isSCSA=true; break;
			case	651460:  isSCSA=true; break;
			case	391739:  isSCSA=true; break;
			case	391784:  isSCSA=true; break;
			case	393208:  isSCSA=true; break;
			case	393253:  isSCSA=true; break;
			case	393307:  isSCSA=true; break;
			case	393367:  isSCSA=true; break;
			case	393479:  isSCSA=true; break;
			case	392182:  isSCSA=true; break;
			case	392220:  isSCSA=true; break;
			case	651499:  isSCSA=true; break;
			case	651539:  isSCSA=true; break;
			case	651548:  isSCSA=true; break;
			case	392320:  isSCSA=true; break;
			case	392441:  isSCSA=true; break;
			case	392494:  isSCSA=true; break;
			case	392557:  isSCSA=true; break;
			case	392590:  isSCSA=true; break;
			case	392645:  isSCSA=true; break;
			case	392657:  isSCSA=true; break;
			case	392715:  isSCSA=true; break;
			case	392998:  isSCSA=true; break;
			case	393057:  isSCSA=true; break;
			case	393107:  isSCSA=true; break;
			case	393160:  isSCSA=true; break;
			case	393186:  isSCSA=true; break;
			case	603487:  isSCSA=true; break;
			case	603133:  isSCSA=true; break;
			case	603124:  isSCSA=true; break;
			case	651617:  isSCSA=true; break;
			case	394406:  isSCSA=true; break;
			case	394416:  isSCSA=true; break;
			case	394790:  isSCSA=true; break;
			case	394953:  isSCSA=true; break;
			case	395140:  isSCSA=true; break;
			case	395931:  isSCSA=true; break;
			case	395162:  isSCSA=true; break;
			case	396011:  isSCSA=true; break;
			case	395280:  isSCSA=true; break;
			case	396255:  isSCSA=true; break;
			case	393756:  isSCSA=true; break;
			case	393785:  isSCSA=true; break;
			case	393811:  isSCSA=true; break;
			case	395546:  isSCSA=true; break;
			case	393845:  isSCSA=true; break;
			case	393849:  isSCSA=true; break;
			case	395609:  isSCSA=true; break;
			case	395637:  isSCSA=true; break;
			case	395654:  isSCSA=true; break;
			case	396599:  isSCSA=true; break;
			case	550108:  isSCSA=true; break;
			case	670084:  isSCSA=true; break;
			case	670103:  isSCSA=true; break;
			case	680025:  isSCSA=true; break;
			case	101247:  isSCSA=true; break;
			case	392026:  isSCSA=true; break;
			case	500955:  isSCSA=true; break;

            default: isSCSA=false; break;
        }

		return isSCSA;
	}	
	
	/**
	 * Verify if the user falls into one of the job roles 
	 * for the Sales Manager
	 *
	 * @return boolean 
	 *
	 */	
	public boolean isSalesManager(Integer peopleDBRoleID) {
		
		boolean isSM;
		
        switch (peopleDBRoleID) {
			case	352:  isSM=true; break;
			case	3139:  isSM=true; break;
			case	3137:  isSM=true; break;
			case	3138:  isSM=true; break;
			case	3140:  isSM=true; break;
			case	3141:  isSM=true; break;
			case	3142:  isSM=true; break;
			case	3144:  isSM=true; break;
			case	3145:  isSM=true; break;
			case	3150:  isSM=true; break;
			case	3219:  isSM=true; break;
			case	100205:  isSM=true; break;
			case	100303:  isSM=true; break;
			case	100412:  isSM=true; break;
			case	100414:  isSM=true; break;
			case	100807:  isSM=true; break;
			case	100829:  isSM=true; break;
			case	500051:  isSM=true; break;
			case	603006:  isSM=true; break;
			case	603007:  isSM=true; break;
			case	605361:  isSM=true; break;
			case	602235:  isSM=true; break;
			case	602488:  isSM=true; break;
			case	605375:  isSM=true; break;
			case	605383:  isSM=true; break;
			case	605394:  isSM=true; break;
			case	605409:  isSM=true; break;
			case	602375:  isSM=true; break;
			case	605419:  isSM=true; break;
			case	605425:  isSM=true; break;
			case	605430:  isSM=true; break;
			case	605463:  isSM=true; break;
			case	605476:  isSM=true; break;
			case	605544:  isSM=true; break;
			case	602148:  isSM=true; break;
			case	605585:  isSM=true; break;
			case	602176:  isSM=true; break;
			case	602177:  isSM=true; break;
			case	605604:  isSM=true; break;
			case	605639:  isSM=true; break;
			case	605663:  isSM=true; break;
			case	605686:  isSM=true; break;
			case	605693:  isSM=true; break;
			case	605705:  isSM=true; break;
			case	605706:  isSM=true; break;
			case	605712:  isSM=true; break;
			case	602114:  isSM=true; break;
			case	800033:  isSM=true; break;
			case	605106:  isSM=true; break;
			case	605172:  isSM=true; break;
			case	605175:  isSM=true; break;
			case	602438:  isSM=true; break;
			case	605215:  isSM=true; break;
			case	605218:  isSM=true; break;
			case	605234:  isSM=true; break;
			case	600015:  isSM=true; break;
			case	600092:  isSM=true; break;
			case	602201:  isSM=true; break;
			case	602208:  isSM=true; break;
			case	602343:  isSM=true; break;
			case	602462:  isSM=true; break;
			case	602504:  isSM=true; break;
			case	605296:  isSM=true; break;
			case	605302:  isSM=true; break;
			case	605319:  isSM=true; break;
			case	605351:  isSM=true; break;
			case	600850:  isSM=true; break;
			case	600867:  isSM=true; break;
			case	600872:  isSM=true; break;
			case	600916:  isSM=true; break;
			case	600934:  isSM=true; break;
			case	600935:  isSM=true; break;
			case	600975:  isSM=true; break;
			case	601019:  isSM=true; break;
			case	601058:  isSM=true; break;
			case	600266:  isSM=true; break;
			case	600377:  isSM=true; break;
			case	600469:  isSM=true; break;
			case	600551:  isSM=true; break;
			case	600654:  isSM=true; break;
			case	600664:  isSM=true; break;
			case	600689:  isSM=true; break;
			case	600699:  isSM=true; break;
			case	600730:  isSM=true; break;
			case	600743:  isSM=true; break;
			case	600766:  isSM=true; break;
			case	601607:  isSM=true; break;
			case	601796:  isSM=true; break;
			case	601802:  isSM=true; break;
			case	601803:  isSM=true; break;
			case	601975:  isSM=true; break;
			case	601986:  isSM=true; break;
			case	601999:  isSM=true; break;
			case	601116:  isSM=true; break;
			case	601142:  isSM=true; break;
			case	601187:  isSM=true; break;
			case	601243:  isSM=true; break;
			case	601314:  isSM=true; break;
			case	601387:  isSM=true; break;
			case	601431:  isSM=true; break;
			case	601432:  isSM=true; break;
			case	601458:  isSM=true; break;
			case	680146:  isSM=true; break;
			case	680150:  isSM=true; break;
			case	680184:  isSM=true; break;
			case	680030:  isSM=true; break;
			case	680042:  isSM=true; break;
			case	680055:  isSM=true; break;
			case	680060:  isSM=true; break;
			case	680064:  isSM=true; break;
			case	605792:  isSM=true; break;
			case	605967:  isSM=true; break;
			case	606013:  isSM=true; break;
			case	606058:  isSM=true; break;
			case	606105:  isSM=true; break;
			case	606106:  isSM=true; break;
			case	606111:  isSM=true; break;
			case	606118:  isSM=true; break;
			case	606149:  isSM=true; break;
			case	606166:  isSM=true; break;
			case	606176:  isSM=true; break;
			case	602520:  isSM=true; break;
			case	602826:  isSM=true; break;
			case	101192:  isSM=true; break;
			case	602828:  isSM=true; break;
			case	333542:  isSM=true; break;
			case	650081:  isSM=true; break;
			case	650085:  isSM=true; break;
			case	650094:  isSM=true; break;
			case	650095:  isSM=true; break;
			case	650105:  isSM=true; break;
			case	680212:  isSM=true; break;
			case	680215:  isSM=true; break;
			case	680228:  isSM=true; break;
			case	680333:  isSM=true; break;
			case	602742:  isSM=true; break;
			case	650972:  isSM=true; break;
			case	650182:  isSM=true; break;
			case	650189:  isSM=true; break;
			case	650190:  isSM=true; break;
			case	650194:  isSM=true; break;
			case	650203:  isSM=true; break;
			case	650241:  isSM=true; break;
			case	650242:  isSM=true; break;
			case	650368:  isSM=true; break;
			case	650385:  isSM=true; break;
			case	650471:  isSM=true; break;
			case	650473:  isSM=true; break;
			case	650476:  isSM=true; break;
			case	650505:  isSM=true; break;
			case	650558:  isSM=true; break;
			case	650560:  isSM=true; break;
			case	650613:  isSM=true; break;
			case	650661:  isSM=true; break;
			case	650838:  isSM=true; break;
			case	650854:  isSM=true; break;
			case	650893:  isSM=true; break;
			case	650913:  isSM=true; break;
			case	651257:  isSM=true; break;
			case	651214:  isSM=true; break;
			case	651146:  isSM=true; break;
			case	651219:  isSM=true; break;
			case	670135:  isSM=true; break;
			case	670143:  isSM=true; break;
			case	651237:  isSM=true; break;
			case	651238:  isSM=true; break;
			case	602893:  isSM=true; break;
			case	390300:  isSM=true; break;
			case	391830:  isSM=true; break;
			case	391895:  isSM=true; break;
			case	391923:  isSM=true; break;
			case	391952:  isSM=true; break;
			case	391987:  isSM=true; break;
			case	602921:  isSM=true; break;
			case	651322:  isSM=true; break;
			case	651326:  isSM=true; break;
			case	651330:  isSM=true; break;
			case	390947:  isSM=true; break;
			case	390978:  isSM=true; break;
			case	390990:  isSM=true; break;
			case	391059:  isSM=true; break;
			case	391093:  isSM=true; break;
			case	391124:  isSM=true; break;
			case	391151:  isSM=true; break;
			case	391225:  isSM=true; break;
			case	391231:  isSM=true; break;
			case	391236:  isSM=true; break;
			case	391321:  isSM=true; break;
			case	391326:  isSM=true; break;
			case	391397:  isSM=true; break;
			case	391404:  isSM=true; break;
			case	391408:  isSM=true; break;
			case	391458:  isSM=true; break;
			case	391529:  isSM=true; break;
			case	391568:  isSM=true; break;
			case	391581:  isSM=true; break;
			case	391600:  isSM=true; break;
			case	391621:  isSM=true; break;
			case	651470:  isSM=true; break;
			case	391661:  isSM=true; break;
			case	391707:  isSM=true; break;
			case	391716:  isSM=true; break;
			case	391722:  isSM=true; break;
			case	391802:  isSM=true; break;
			case	393218:  isSM=true; break;
			case	393219:  isSM=true; break;
			case	393345:  isSM=true; break;
			case	393377:  isSM=true; break;
			case	651368:  isSM=true; break;
			case	393461:  isSM=true; break;
			case	392071:  isSM=true; break;
			case	392105:  isSM=true; break;
			case	392144:  isSM=true; break;
			case	392153:  isSM=true; break;
			case	392164:  isSM=true; break;
			case	602978:  isSM=true; break;
			case	602990:  isSM=true; break;
			case	392242:  isSM=true; break;
			case	392286:  isSM=true; break;
			case	392427:  isSM=true; break;
			case	392469:  isSM=true; break;
			case	392477:  isSM=true; break;
			case	392479:  isSM=true; break;
			case	392514:  isSM=true; break;
			case	651471:  isSM=true; break;
			case	392565:  isSM=true; break;
			case	392579:  isSM=true; break;
			case	392627:  isSM=true; break;
			case	392711:  isSM=true; break;
			case	392798:  isSM=true; break;
			case	392801:  isSM=true; break;
			case	392879:  isSM=true; break;
			case	392880:  isSM=true; break;
			case	392896:  isSM=true; break;
			case	392950:  isSM=true; break;
			case	392956:  isSM=true; break;
			case	393090:  isSM=true; break;
			case	393111:  isSM=true; break;
			case	393134:  isSM=true; break;
			case	396633:  isSM=true; break;
			case	396636:  isSM=true; break;
			case	396643:  isSM=true; break;
			case	396663:  isSM=true; break;
			case	603484:  isSM=true; break;
			case	603504:  isSM=true; break;
			case	651626:  isSM=true; break;
			case	603191:  isSM=true; break;
			case	603193:  isSM=true; break;
			case	651767:  isSM=true; break;
			case	603310:  isSM=true; break;
			case	603412:  isSM=true; break;
			case	603121:  isSM=true; break;
			case	603433:  isSM=true; break;
			case	603441:  isSM=true; break;
			case	603475:  isSM=true; break;
			case	603477:  isSM=true; break;
			case	603163:  isSM=true; break;
			case	394434:  isSM=true; break;
			case	603523:  isSM=true; break;
			case	651763:  isSM=true; break;
			case	394749:  isSM=true; break;
			case	394822:  isSM=true; break;
			case	394843:  isSM=true; break;
			case	394892:  isSM=true; break;
			case	394920:  isSM=true; break;
			case	394924:  isSM=true; break;
			case	394958:  isSM=true; break;
			case	394969:  isSM=true; break;
			case	394978:  isSM=true; break;
			case	394990:  isSM=true; break;
			case	395877:  isSM=true; break;
			case	395890:  isSM=true; break;
			case	395073:  isSM=true; break;
			case	395132:  isSM=true; break;
			case	395905:  isSM=true; break;
			case	395912:  isSM=true; break;
			case	395974:  isSM=true; break;
			case	395168:  isSM=true; break;
			case	395244:  isSM=true; break;
			case	395248:  isSM=true; break;
			case	396046:  isSM=true; break;
			case	393549:  isSM=true; break;
			case	393571:  isSM=true; break;
			case	101322:  isSM=true; break;
			case	395274:  isSM=true; break;
			case	395281:  isSM=true; break;
			case	651756:  isSM=true; break;
			case	396112:  isSM=true; break;
			case	396115:  isSM=true; break;
			case	396125:  isSM=true; break;
			case	396151:  isSM=true; break;
			case	396160:  isSM=true; break;
			case	396163:  isSM=true; break;
			case	396172:  isSM=true; break;
			case	396179:  isSM=true; break;
			case	393655:  isSM=true; break;
			case	393656:  isSM=true; break;
			case	393657:  isSM=true; break;
			case	393697:  isSM=true; break;
			case	393702:  isSM=true; break;
			case	396210:  isSM=true; break;
			case	396239:  isSM=true; break;
			case	396241:  isSM=true; break;
			case	396283:  isSM=true; break;
			case	393780:  isSM=true; break;
			case	393810:  isSM=true; break;
			case	393820:  isSM=true; break;
			case	395545:  isSM=true; break;
			case	396327:  isSM=true; break;
			case	396349:  isSM=true; break;
			case	396380:  isSM=true; break;
			case	393853:  isSM=true; break;
			case	393855:  isSM=true; break;
			case	395700:  isSM=true; break;
			case	393967:  isSM=true; break;
			case	393973:  isSM=true; break;
			case	393993:  isSM=true; break;
			case	394046:  isSM=true; break;
			case	394054:  isSM=true; break;
			case	394055:  isSM=true; break;
			case	395712:  isSM=true; break;
			case	395733:  isSM=true; break;
			case	603245:  isSM=true; break;
			case	603562:  isSM=true; break;
			case	603583:  isSM=true; break;
			case	394130:  isSM=true; break;
			case	394147:  isSM=true; break;
			case	603591:  isSM=true; break;
			case	603593:  isSM=true; break;
			case	394194:  isSM=true; break;
			case	394278:  isSM=true; break;
			case	394296:  isSM=true; break;
			case	394380:  isSM=true; break;

            default: isSM=false; break;
        }

		return isSM;
	}	
	

%>