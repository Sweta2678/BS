<%@ include file="/html/standlist/init.jsp" %>

<%boolean flag = request.isUserInRole(BrandStandardsUtil.AUTHORS_AMER_ROLE);
int standardCount = 0;
standardCount = Integer.parseInt(request.getAttribute("standardsCount").toString());
    %>
    <p class="totals_display"><strong><%=standardCount %></strong> Standards match this criteria</p>
   