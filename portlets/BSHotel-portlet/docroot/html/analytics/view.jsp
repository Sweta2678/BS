<%--
/**
 *  
 * This is the JSP to add code for Google Analytics
 *
 */
--%>
<%@include file="/html/init.jsp"%>
<script>
var hotelCode = '<%=renderRequest.getAttribute("hotelCode")%>';
var brand = '<%=renderRequest.getAttribute("brand")%>';
var userType = '<%=renderRequest.getAttribute("userType")%>';
var analyticsId = '<%=renderRequest.getAttribute("analyticsId")%>';
var countryCode = '<%=renderRequest.getAttribute("countryName")%>';
var languageCode = '<%=renderRequest.getAttribute("languageName")%>';

(function() {
	var ga = document.createElement('script');    
	   ga.type = 'text/javascript';
	   ga.async = true;
       ga.src = '/static/apps/merlin/js/ga.js';
	   var s = document.getElementsByTagName('script')[0]; s.parentNode.insertBefore(ga, s);
	})();

	var tMnemonic = (typeof(hotelCode) == 'undefined' ? '' : hotelCode);
	var tBr = (typeof(brand) == 'undefined' ? '' : brand);
	var tLang = (typeof(languageCode) == 'undefined' ? '' : languageCode);
	var tTyp = (typeof(userType) == 'undefined' ? '' : userType);
	var tCtry = (typeof(countryCode) == 'undefined' ? '' : countryCode);
	var _gaq = _gaq || [];
	var pluginUrl = 
		'//www.google-analytics.com/plugins/ga/inpage_linkid.js';
		_gaq.push(['_require', 'inpage_linkid', pluginUrl]);
		_gaq.push(['_setAccount', analyticsId]);
		_gaq.push(['_setCustomVar', 1, 'Chain', tBr, 3]);
		_gaq.push(['_setCustomVar', 2, 'Country', tCtry, 3]);
		_gaq.push(['_setCustomVar', 3, 'Language', tLang, 3]);
		_gaq.push(['_setCustomVar', 4, 'UserType', tTyp, 3]);
		_gaq.push(['_setCustomVar', 5, 'Holidex', tMnemonic, 3]);
		_gaq.push(['_trackPageview']);
</script>