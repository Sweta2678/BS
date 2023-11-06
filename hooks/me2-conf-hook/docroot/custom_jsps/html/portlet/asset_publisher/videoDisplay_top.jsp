<%@page import="java.io.StringReader"%>
<%@page import="org.xml.sax.InputSource"%>
<%@page import="org.dom4j.DocumentException"%>
<%@page import="org.dom4j.io.SAXReader"%>
<%@page import="org.dom4j.DocumentHelper"%>
<%@page import="com.liferay.portlet.journal.service.JournalArticleLocalServiceUtil"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<h1>Videos</h1>
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
