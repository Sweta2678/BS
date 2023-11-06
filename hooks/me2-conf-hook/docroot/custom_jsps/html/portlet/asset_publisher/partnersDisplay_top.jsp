<%--
/**
 * Copyright (c) 2000-2011 Liferay, Inc. All rights reserved.
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
<%@page import="java.util.List"%>
<%@page import="java.util.ArrayList"%>
<%-- <div class="main-content">
	<div id="column-1" class="aui-w100  portlet-column-first ">
		<div class="portlet-main-column">
			<div class="portlet-container ">
				<h1 class="page-heading" style="border-bottom: 0px solid #E5E5E5;">Partners</h1>
				
				<!-- <div class="session-tabs" style="border-bottom: 1px solid #E5E5E5;">
					<a href="#Platinum">Platinum </a><span>|</span>
					<a href="#Gold">Gold</a><span>|</span>
					<a href="#Silver">Silver</a><span>|</span>
					<a href="#Bronze">Bronze</a>
				</div> -->
				
				Begin
				
				<%
				//Fetch Values from Property file
				String actionPartners = PropsUtil.get("ihg.amer.ga.action.partners");
				
				int  listSize = results.size();
				
				Map<String, String> Images = new HashMap<String, String>();
				/* Map<String, String> goldImages = new HashMap<String, String>();
				Map<String, String> silverImages = new HashMap<String, String>();
				Map<String, String> bronzeImages = new HashMap<String, String>(); */
				
				String partnerName = "";
				
				for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
					AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
					
					String className = PortalUtil.getClassName(assetEntry.getClassNameId());
					long classPK = assetEntry.getClassPK();
					
					AssetRendererFactory assetRendererFactory1 = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
					
					if (assetRendererFactory1 == null) {
						continue;
					}
					
					AssetRenderer assetRenderer1 = assetRendererFactory1.getAssetRenderer(classPK);
					
					partnerName = assetEntry.getTitle();
					
					String tagnames[] = assetEntry.getTagNames();
					List<String> tags = new ArrayList<String>();
					for(String tag:tagnames){
						tags.add(tag.toLowerCase());
					}
					try {
						JournalArticle journalArticle1 = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
						org.dom4j.Document document1 = DocumentHelper.createDocument();
						
						String smallImage1 = null;
						
						if (Validator.isNotNull(journalArticle1.getContent()) /* && (tags.contains("platinum") || tags.contains("gold") || tags.contains("silver") || tags.contains("bronze")) */) {
							SAXReader reader1 = new SAXReader();
							try {
								document1 = reader1.read(new InputSource(new StringReader(journalArticle1.getContent())));
								for(Iterator iterator = document1.getRootElement().elements().iterator(); iterator.hasNext();) {
									org.dom4j.Element element = (org.dom4j.Element)iterator.next();
									if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("smallImage")
											&& Validator.isNotNull(element.element("dynamic-content"))) {
										
										smallImage1 = element.element("dynamic-content").getText();
										
									}
								}
							} catch (DocumentException e) {
								e.printStackTrace();
							}
							
						}
						
						Images.put(partnerName, smallImage1);
						/* if(tags.contains("platinum")){
							platinumImages.put(partnerName, smallImage1);
						}
						if(tags.contains("gold")){
							goldImages.put(partnerName, smallImage1);
						}
						if(tags.contains("silver")){
							silverImages.put(partnerName, smallImage1);
						}
						if(tags.contains("bronze")){
							bronzeImages.put(partnerName, smallImage1);
						} */
						
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}
				
				%>
				
				
				End
				
				<% int count = 1; %>
				
				<!--portlet-content-box-->
				<div class="portlet-partner-box">
					<div class="photos-heading">
						<!-- <a name="Platinum"><h1 class="heading-platinum fLeft">Platinum</h1></a> -->
						<div class="clear"></div>
					</div>
					<div class="photos-top-cont">
						<ul>
						<%
						for (Map.Entry<String, String> entry : Images.entrySet()) {
							if(count % 8 == 0) {
						%>
							<li><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						</ul>
						<ul>
						<% 	} else { %>
							<li class="fLeft"><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						<%
							}
							count++;
						}
						%>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
				<!--portlet-content-box end-->
				
				<div class="portlet-partner-box">
					<div class="photos-heading">
						<a name="Gold"><h1 class="heading-gold fLeft">Gold</h1></a>
						<div class="clear"></div>
					</div>
					<div class="photos-top-cont">
						<ul>
						<%
						count = 1;
						for (Map.Entry<String, String> entry : goldImages.entrySet()) {
							if(count % 8 == 0) {
						%>
							<li><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						</ul>
						<ul>
						<% 	} else { %>
							<li class="fLeft"><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						<%
							}
							count++;
						}
						%>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
				<!--portlet-content-box end-->
				
				<div class="portlet-partner-box">
					<div class="photos-heading">
						<a name="Silver"><h1 class="heading-silver fLeft">Silver</h1></a>
						<div class="clear"></div>
					</div>
					<div class="photos-top-cont">
						<ul>
						<%
						count = 1;
						for (Map.Entry<String, String> entry : silverImages.entrySet()) {
							if(count % 8 == 0) {
						%>
							<li><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
							
						</ul>
						<ul>
						<% 	} else { %>
							<li class="fLeft"><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						<%
							}
							count++;
						}
						%>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
				<!--portlet-content-box end-->
				
				<div class="portlet-partner-box">
					<div class="photos-heading">
						<a name="Bronze"><h1 class="heading-bronze fLeft">Bronze</h1></a>
						<div class="clear"></div>
					</div>
					<div class="photos-top-cont">
						<ul>
						<%
						count = 1;
						for (Map.Entry<String, String> entry : bronzeImages.entrySet()) {
							if(count % 8 == 0) {
						%>
							<li><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						</ul>
						<ul>
						<% 	} else { %>
							<li class="fLeft"><a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" style="width: 100px; height: 100px; margin-right: 10px;">
							</a></li>
						<%
							}
							count++;
						}
						%>
						</ul>
						<div class="clear"></div>
					</div>
				</div>
				<!--portlet-content-box end-->
				<div class="bottomdot-bg"></div>
				<div class="portlet-sub-container ">
					
					<%
					
					for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
						AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
						
						String className = PortalUtil.getClassName(assetEntry.getClassNameId());
						long classPK = assetEntry.getClassPK();
						
						AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
						
						if (assetRendererFactory == null) {
							continue;
						}
						
						AssetRenderer assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
						
						String title = assetEntry.getTitle();
						
						boolean show = true;
						boolean print = false;
						
						request.setAttribute("view.jsp-assetEntryIndex", new Integer(assetEntryIndex));
						
						request.setAttribute("view.jsp-assetEntry", assetEntry);
						request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
						request.setAttribute("view.jsp-assetRenderer", assetRenderer);
						
						request.setAttribute("view.jsp-title", title);
						
						request.setAttribute("view.jsp-show", new Boolean(show));
						request.setAttribute("view.jsp-print", new Boolean(print));
						
						try {
					%>
							<%@ include file="/html/portlet/asset_publisher/view_display.jspf" %>
					<%
						}
						catch (Exception e) {
							_log.error(e.getMessage());
						}
					}
					%>
				</div>
			</div>
		</div>
	</div>
</div>


 --%>



		<div id="content">
							
				<article class="results search events-speaker-bio partner">	
					
					<h1 id="partners">Partners</h1>
					
				<%-- Begin --%>
				
				<%
				//Fetch Values from Property file
				String actionPartners = PropsUtil.get("ihg.amer.ga.action.partners");
				
				int  listSize = results.size();
				
				Map<String, String> Images = new HashMap<String, String>();
				/* Map<String, String> goldImages = new HashMap<String, String>();
				Map<String, String> silverImages = new HashMap<String, String>();
				Map<String, String> bronzeImages = new HashMap<String, String>(); */
				
				String partnerName = "";
				
				for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
					AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
					
					String className = PortalUtil.getClassName(assetEntry.getClassNameId());
					long classPK = assetEntry.getClassPK();
					
					AssetRendererFactory assetRendererFactory1 = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
					
					if (assetRendererFactory1 == null) {
						continue;
					}
					
					AssetRenderer assetRenderer1 = null;

					try {
						assetRenderer1 = assetRendererFactory1.getAssetRenderer(classPK);
					}
					catch (Exception e) {
						if (_log.isWarnEnabled()) {
							_log.warn(e, e);
						}
					}

					if ((assetRenderer1 == null) || !assetRenderer1.isDisplayable()) {
						continue;
					}
					
					partnerName = assetRenderer1.getTitle(locale);
					
					String tagnames[] = assetEntry.getTagNames();
					List<String> tags = new ArrayList<String>();
					for(String tag:tagnames){
						tags.add(tag.toLowerCase());
					}
					try {
						JournalArticle journalArticle1 = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
						org.dom4j.Document document1 = DocumentHelper.createDocument();
						
						String smallImage1 = null;
						
						if (Validator.isNotNull(journalArticle1.getContent()) /* && (tags.contains("platinum") || tags.contains("gold") || tags.contains("silver") || tags.contains("bronze")) */) {
							SAXReader reader1 = new SAXReader();
							try {
								document1 = reader1.read(new InputSource(new StringReader(journalArticle1.getContent())));
								for(Iterator iterator = document1.getRootElement().elements().iterator(); iterator.hasNext();) {
									org.dom4j.Element element = (org.dom4j.Element)iterator.next();
									if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("smallImage")
											&& Validator.isNotNull(element.element("dynamic-content"))) {
										
										smallImage1 = element.element("dynamic-content").getText();
										
									}
								}
							} catch (DocumentException e) {
								e.printStackTrace();
							}
							
						}
						
						Images.put(partnerName, smallImage1);
						/* if(tags.contains("platinum")){
							platinumImages.put(partnerName, smallImage1);
						}
						if(tags.contains("gold")){
							goldImages.put(partnerName, smallImage1);
						}
						if(tags.contains("silver")){
							silverImages.put(partnerName, smallImage1);
						}
						if(tags.contains("bronze")){
							bronzeImages.put(partnerName, smallImage1);
						} */
						
					} catch (Exception e) {
						_log.error(e.getMessage());
					}
				}
				
				%>
				
				
				<%-- End --%>
				
				<% int count = 1; %>
					
					<ul class="image-container">
					
						<%
						for (Map.Entry<String, String> entry : Images.entrySet()) {
						%>
						
						<li>
							<a onclick="ga_trackEvents_partners('<%= actionPartners%>', '<%= entry.getKey()%>');" href="#<%= entry.getKey()%>">
								<img alt="" src="<%= entry.getValue()%>" width="209" height="91"/>
							</a>							
						</li>		
						<%
							}
						%>						
					</ul>
					
					<%
					
					for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
						AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
						
						String className = PortalUtil.getClassName(assetEntry.getClassNameId());
						long classPK = assetEntry.getClassPK();
						
						AssetRendererFactory assetRendererFactory = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
						
						if (assetRendererFactory == null) {
							continue;
						}
						
						AssetRenderer assetRenderer = null;

						try {
							assetRenderer = assetRendererFactory.getAssetRenderer(classPK);
						}
						catch (Exception e) {
							if (_log.isWarnEnabled()) {
								_log.warn(e, e);
							}
						}

						if ((assetRenderer == null) || !assetRenderer.isDisplayable()) {
							continue;
						}
						
						String title = assetRenderer.getTitle(locale);
						
						boolean show = true;
						boolean print = false;
						
						request.setAttribute("view.jsp-assetEntryIndex", new Integer(assetEntryIndex));
						
						request.setAttribute("view.jsp-assetEntry", assetEntry);
						request.setAttribute("view.jsp-assetRendererFactory", assetRendererFactory);
						request.setAttribute("view.jsp-assetRenderer", assetRenderer);
						
						request.setAttribute("view.jsp-title", title);
						
						request.setAttribute("view.jsp-show", new Boolean(show));
						request.setAttribute("view.jsp-print", new Boolean(print));
						
						try {
					%>
							<%@ include file="/html/portlet/asset_publisher/view_display.jspf" %>
					<%
						}
						catch (Exception e) {
							_log.error(e.getMessage());
						}
					}
					%>
					
				</article>
			
		</div>