<%
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
%>

<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>

<portlet:defineObjects />

<portlet:actionURL var="saveGroupIdsForm" name="saveGroupIdsForm" />
		
		
<form name="saveGroupIdsForm" id="saveGroupIdsForm" method="post" action="<%=saveGroupIdsForm.toString()%>">

	<%
		String inputGroupIds = "";
	
		if (request.getAttribute("communityId") != null)
		{
			inputGroupIds = request.getAttribute("communityId").toString();
		}
	%>

	Enter groupIds : <input type="text" id="communityId" name="communityId" value="<%=inputGroupIds %>"/>
	
	<input title="submit" type="submit" value="Submit" />
	
</form>

