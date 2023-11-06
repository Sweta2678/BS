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
<%@ page import="java.util.Comparator" %>
<div id="column-2">
	<div class="column-2-header-global violet-font">
		<span class="mLeft7">FAQs</span>
	</div>
	<div class="main-middle-content-faq">
		<div class="mLeft10 mRight10 w516 mTop10">
			<%
			// String comparison for faq results : start.
			final Locale cLcl = locale;
			class AssetEntComparator implements Comparator<AssetEntry> {
			  public int compare(AssetEntry o1, AssetEntry o2) {
			    Date s1 = o1.getCreateDate();
			    Date s2 = o2.getCreateDate();
			    return s1.compareTo(s2);
			  }
			}
			Collections.sort(results, Collections.reverseOrder(new AssetEntComparator()));
			// String comparison for faq results : end.
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
		</div>
	</div>
</div>