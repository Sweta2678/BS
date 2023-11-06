<%@page import="java.util.ArrayList" %>
<%@page import="java.util.Collections" %>
<%@page import="com.liferay.portal.kernel.util.DateUtil" %>
<%@page import="com.liferay.portal.kernel.util.OrderByComparator" %>
<%@page import="com.liferay.portal.kernel.util.Validator" %>
<%@page import="com.liferay.portlet.journal.model.JournalArticle" %>
<%@page import="java.io.StringReader" %>
<%@page import="java.util.Date" %>
<%@page import="java.util.Iterator" %>
<%@page import="org.xml.sax.InputSource" %>
<%@page import="org.dom4j.DocumentException" %>
<%@page import="org.dom4j.DocumentHelper" %>
<%@page import="java.text.ParseException" %>

<%

class ArticleStartDateComparator extends OrderByComparator {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private boolean _ascending;
	
	public ArticleStartDateComparator()
	  {
	    this(false);
	}

	public ArticleStartDateComparator(boolean ascending) {
		this._ascending = ascending;
	}

	public int compare(Object obj1, Object obj2) {
		JournalArticle article1 = (JournalArticle) obj1;
		JournalArticle article2 = (JournalArticle) obj2;

		int value = DateUtil.compareTo((new ArticleStartDateComparator()).getArticleStartDate(article1),
				(new ArticleStartDateComparator()).getArticleStartDate(article2));

		if (value == 0) {
			if (article1.getVersion() < article2.getVersion()) {
				value = -1;
			} else if (article1.getVersion() > article2.getVersion()) {
				value = 1;
			}
		}

		if (this._ascending) {
			return value;
		}

		return (-value);
	}

	public Date getArticleStartDate(JournalArticle article) {
		
		org.dom4j.Document document = DocumentHelper.createDocument();
		SAXReader reader = new SAXReader();
		Date date = null;
		
    	if (Validator.isNotNull(article.getContent())) {
			try {
				document = reader.read(new InputSource(new StringReader(article.getContent())));
			} catch (DocumentException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			for(Iterator iterator = document.getRootElement().elements().iterator(); iterator.hasNext();) {
				org.dom4j.Element element = (org.dom4j.Element)iterator.next();
				
				if(Validator.isNotNull(element.attribute("name")) && element.attribute("name").getStringValue().equalsIgnoreCase("startdate")
						&& Validator.isNotNull(element.element("dynamic-content"))) {
					
					String startdate = element.element("dynamic-content").getText();
						
					DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm"); 
				    
				    try {
				    	date = df.parse(startdate);
				    } catch (ParseException e) {
				        e.printStackTrace();
				    }
					
				} 
			}
		 
	}
	
    	return date;
	}
	
}


%>

	<div class = "awards_wrapper">
   		
			<div class = "panel_left">
<%
					List<JournalArticle> journalArticles = new ArrayList<JournalArticle>();  
					for (int assetEntryIndex = 0; assetEntryIndex < results.size(); assetEntryIndex++) {
						AssetEntry assetEntry = (AssetEntry)results.get(assetEntryIndex);
						JournalArticle journalArticle1 = JournalArticleLocalServiceUtil.getLatestArticle(assetEntry.getClassPK());
						journalArticles.add(journalArticle1);						
						
					}

					Collections.sort(journalArticles, new ArticleStartDateComparator(true));
					
					for (int assetEntryIndex = 0; assetEntryIndex < journalArticles.size(); assetEntryIndex++) {
						JournalArticle article = (JournalArticle)journalArticles.get(assetEntryIndex);
						
						long classPK = article.getResourcePrimKey();
						AssetEntry assetEntry = AssetEntryLocalServiceUtil.getEntry(JournalArticle.class.getName(), classPK);
						
						String className = PortalUtil.getClassName(assetEntry.getClassNameId());
					
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
					
					
			</div>
	</div>
