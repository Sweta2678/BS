<%@page import="java.util.List"%>
<%@page import="java.util.Comparator"%>
<%@page import="com.liferay.portlet.asset.model.AssetEntry"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.TreeMap"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.io.StringReader"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.dom4j.DocumentException"%>
<%@page import="org.dom4j.io.SAXReader"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%
class ValueComparator implements Comparator<AssetEntry> {

    Map<AssetEntry,Integer> base;
    public ValueComparator(Map<AssetEntry,Integer> base) {
        this.base = base;
    }

    // Note: this comparator imposes orderings that are inconsistent with equals.    
    public int compare(AssetEntry a, AssetEntry b) {
        if (base.get(a) >= base.get(b)) {
            return 1;
        } else {
            return -1;
        } // returning 0 would merge keys
    }
}
%>
<%
Map<AssetEntry,Integer> articleMap = new TreeMap<AssetEntry,Integer>();

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
	
	try {
		JournalArticle journalArticle2 = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
		org.dom4j.Document document1 = DocumentHelper.createDocument();														
		String rank = "";
		Integer priority = 9999;
		

		
		if (Validator.isNotNull(journalArticle2.getContent())  ) {
			  SAXReader reader1 = new SAXReader();
			  try {
				document1 = reader1.read(new InputSource(new StringReader(journalArticle2.getContent())));
				for(Iterator iterator = document1.getRootElement().elements().iterator(); iterator.hasNext();) 
				{
					org.dom4j.Element element = (org.dom4j.Element)iterator.next();
					if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("rank")
							&& Validator.isNotNull(element.element("dynamic-content"))) {
						
						rank = element.element("dynamic-content").getText();		
						if(rank != null){
							priority = Integer.parseInt(rank);
						}
					}
				}
			} catch (DocumentException e) {
				e.printStackTrace();
			}
			
		}
		articleMap.put(assetEntry,priority);
	}
	catch (Exception e) {
		_log.error(e.getMessage());
	}
}

ValueComparator bvc =  new ValueComparator(articleMap);
TreeMap<AssetEntry,Integer> sorted_map = new TreeMap<AssetEntry,Integer>(bvc);
sorted_map.putAll(articleMap);
List<AssetEntry> assetList = new ArrayList<AssetEntry>(sorted_map.keySet());


%>


			
				<article class="results events-speaker-bio">	
							
					<h1 id="speaker-bio">Speaker Bio</h1>
										
					<ul class="image-container" id="speaker-bio">
								
																<%		
																int  listSize = sorted_map.size();
																for (int assetEntryIndex = 0; assetEntryIndex < assetList.size(); assetEntryIndex++) {
																	AssetEntry assetEntry = (AssetEntry)assetList.get(assetEntryIndex);
																    
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
																						if(smallImage1.length() == 0) {
																							smallImage1 = "/me2-conf-theme/images/no-image-available-icon.jpg";
																						} 
																					}
																				}
																			} catch (DocumentException e) {
																				e.printStackTrace();
																			}
																			
																		}

																 %>
																 	  <%	
																 	 	if(assetEntryIndex  != 0 && assetEntryIndex % 8 == 0){
																 	  %>
																 		</ul>
					
					<ul class="image-container" >
					 <c:if test="<%= smallImage1.length() != 0 %>">
						<li>
							<a href="#link<%=assetEntryIndex%>"><img src="<%=smallImage1%>" width="82" height="82" title="<%=HtmlUtil.escape(assetRenderer1.getTitle(locale))%>"/></a>							
						</li>
						</c:if>
						<%	
							}else{	
						%>
						<c:if test="<%= smallImage1.length() != 0 %>">
						<li>						
							<a href="#link<%=assetEntryIndex%>"><img src="<%=smallImage1%>" width="82" height="82" title="<%=HtmlUtil.escape(assetRenderer1.getTitle(locale))%>"/></a>							
						</li>
						</c:if>
						<%	
							}
						%> 
						<%
						}
						catch (Exception e) {
						_log.error(e.getMessage());
							}
						}
							%>
													
					</ul>
					
					<%
															
																for (int assetEntryIndex = 0; assetEntryIndex < assetList.size(); assetEntryIndex++) {
																	AssetEntry assetEntry = (AssetEntry)assetList.get(assetEntryIndex);																	
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
																		<%@ include file = "/html/portlet/asset_publisher/view_display.jspf" %>
																<%
																	}
																	catch (Exception e) {
																		_log.error(e.getMessage());
																	}
																}
																%>
					
				</article>
				
				




