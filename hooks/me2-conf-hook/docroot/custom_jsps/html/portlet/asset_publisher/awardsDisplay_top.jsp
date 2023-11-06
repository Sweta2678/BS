<%@page import="java.io.StringReader"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.dom4j.DocumentException"%>
<%@page import="org.dom4j.io.SAXReader"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>


<!-- <div class="main-content"> -->
		<!-- <div id="column-1" class="aui-w100  portlet-column-first ">
				<div class="portlet-main-column"> 
						<div class="portlet-container ">-->
								<div class="awards_label_header">Award Winners</div>
								<!--portlet-content-box-->
								<!-- <div class="portlet-content-box"> -->
														<!--  <div class="speaker-cont-box"> --> 
															<!--content-->
															<!-- <div class="portlet-speaker-top">	 -->	
																	<%-- <ul>
								
																<%		
																int  listSize = results.size();
																for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
																	AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
																    
																	String className = PortalUtil.getClassName(assetEntry.getClassNameId());
																	long classPK = assetEntry.getClassPK();
																
																	AssetRendererFactory assetRendererFactory1 = AssetRendererFactoryRegistryUtil.getAssetRendererFactoryByClassName(className);
																
																	if (assetRendererFactory1 == null) {
																		continue;
																	}
																
																	AssetRenderer assetRenderer1 = assetRendererFactory1.getAssetRenderer(classPK);															
																	
																	try {
																		JournalArticle journalArticle1 = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
																		org.dom4j.Document document1 = DocumentHelper.createDocument();														
																		String smallImage1 = "";																		
																		
																		if (Validator.isNotNull(journalArticle1.getContent())  ) {
																			  SAXReader reader1 = new SAXReader();
																			  try {
																				document1 = reader1.read(new InputSource(new StringReader(journalArticle1.getContent())));
																				for(Iterator iterator = document1.getRootElement().elements().iterator(); iterator.hasNext();) 
																				{
																					org.dom4j.Element element = (org.dom4j.Element)iterator.next();
																					if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("smallImage")
																							&& Validator.isNotNull(element.element("dynamic-content"))) {
																						
																						smallImage1 = element.element("dynamic-content").getText();
																						/* if(smallImage1.length() == 0) {
																							smallImage1 = "/me2-conf-theme/images/no-image-available-icon.jpg";
																						} */
																					}
																				}
																			} catch (DocumentException e) {
																				e.printStackTrace();
																			}
																			
																		}

																 %>
																
																 <%
																	}
																	catch (Exception e) {
																		_log.error(e.getMessage());
																	}
																}
																%>											
															
																
															
																			
																	</ul> --%>
																	
																	<div class="clear"></div>
															<!-- </div> -->
															<!--content-->
															<!-- <div class="bottomdot-bg   "></div> -->
															<!-- <div class="portlet-sub-container " > -->
															<!-- <div id="divConatiner">
															
															</div>	 -->
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
																										
															<!-- </div> -->
								<!--		</div>
								</div>
						</div>
			   </div>
	</div>
 </div> -->
