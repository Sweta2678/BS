<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@ taglib uri="http://liferay.com/tld/aui" prefix="aui" %>
<%@ taglib uri="http://liferay.com/tld/portlet" prefix="liferay-portlet" %>
<%@ taglib uri="http://liferay.com/tld/security" prefix="liferay-security" %>
<%@ taglib uri="http://liferay.com/tld/theme" prefix="liferay-theme" %>
<%@ taglib uri="http://liferay.com/tld/ui" prefix="liferay-ui" %>
<%@ taglib uri="http://liferay.com/tld/util" prefix="liferay-util" %>

<%@page import="java.util.Map"%>
<%@page import="javax.portlet.PortletURL"%>
<%@page import="java.util.List"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>
<%@page import="com.ihg.brandstandards.db.model.BridgePublishStateEx"%>
<%@page import="com.ihg.brandstandards.bridge.model.BridgePublishAppModel"%>
<%@page import="com.liferay.portal.kernel.dao.search.SearchContainer"%>

<portlet:defineObjects />
<liferay-theme:defineObjects/>
<portlet:renderURL var="cancelURL">
<portlet:param name="selectDate" value="${selectDate }"/>
<portlet:param name="searchById" value="${searchById }"/>
<portlet:param name="dateInputFrom" value="${dateInputFrom }"/>
<portlet:param name="dateInputTo" value="${dateInputTo }"/>
<portlet:param name="pageNum" value="${pageNum }"/>
</portlet:renderURL> 

<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.blockUI.js"></script>
<script type="text/javascript" src="/BSBridge-theme/js/treeAdmin/jquery.msgBox.js"></script>

<style>
<!--
.ctry_comp_table {
    clear: both;
    width: 100%;
    display: table;
}

.comp_edit_title {
    display: table-row;
    vertical-align: inherit;
    border-color: inherit;
}

.ctry_comp_table td {
    padding: 5px;
}

.form-ctry_compl {
    margin-left: -20px;
}

.ctry-comp-dt {
    width: 300px;
}

.ctry-name {
    width: 180px;
}

.edit-std-title {
    color: black;
}
-->
</style>

<script type="text/javascript">
var pageNum = '${pageNum}';
var region = '${region}';

$(function() {
    $("#btn_cancel").click(function() 
    {
    	window.location.href = '${cancelURL}';
        /* if (region == "Global")
        {
            window.location.href = "/web/brand-standards/bridge/glb-view-compliance?pageNum=" + pageNum;
        }
        else
        {
            window.location.href = "/web/brand-standards/bridge/view-compliance?pageNum=" + pageNum;
        } */
    });
});

</script>

<c:choose>
<c:when test ="${!notLoggedIn}">
    <div class="row">
        <div class="modal-header">
            <h3 id="brandModalLabel">View Compliance Deadline<span></span></h3>
        </div>
    </div>
    <div class="clear"></div>
    <form class="form-inline form-ctry_compl" style="margin-bottom: 0;" name="formCompliance" id="formCtryComp" method="POST">
        <input type="hidden" name="stdId" id="stdId" value="<c:out value='${stdId}'/>" />
        
        <section id="standards">
            <div id="result">
            <div class="clear"></div>
            <div class="row-fluid">
                <span class="edit-std-title"><c:out value='${stdId}'/>&nbsp;&nbsp;<c:out value='${stdTitle}'/></span>
            </div>
            <c:forEach items="${subRegionCountryMap}" var="subRegion" varStatus="rgnIndex">
            
            <div class="clear"></div>
            <div class="row-fluid">
                <div class="span6">
                  <c:if test="${subRegion.key ne 'GC' }">
                    <h4>Sub Region: <c:out value="${subRegion.key}" /></h4>
                  </c:if>
                  <c:if test="${subRegion.key eq 'GC' }">
                    <h4>Region: <c:out value="${subRegion.key}" /></h4>
                  </c:if>
                </div>
            </div>
            <div class="clear"></div>
            
            <table class="ctry_comp_table" summary="Data table for all results" id="ctry_comp_table_${subRegion.key}">
                <c:forEach items="${subRegion.value}" var="country" varStatus="index">
                    <c:if test="${index.count % 3 eq 1 }">
                        <tr>
                    </c:if>
                        <td class="ctry-name"><c:out value='${countryNameMap[country]}' /></td>
                        <td class="ctry-comp-dt">
                            <div id="compDateDiv-<c:out value='${country}' />" class="checknow_date">
                                <c:if test="${not empty ctryDateMap[country]}">
                                    <span class="input-small compDate" size="16" id="compDate-<c:out value='${country}' />" 
                                    name="<c:out value='${country}' />" ><c:out value='${ctryDateMap[country]}' /></span>
                                </c:if>
                            </div>
                        </td>
                    <c:if test="${index.count % 3 eq 0 }">
                        </tr>
                    </c:if>
                </c:forEach>
            </table>
            </c:forEach>
            </div>
        </section>
        <div class="clear"></div>
        <div class="modal-footer">
            <button type="button" name="cancel" id="btn_cancel" class="btn pull-left">Cancel</button>
        </div>
        <div class="clear"></div>
    </form>
</c:when>
<c:otherwise>
    Not logged in !!
</c:otherwise>
</c:choose>


