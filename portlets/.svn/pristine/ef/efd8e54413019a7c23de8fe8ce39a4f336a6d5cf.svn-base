<% 
String servletPath = request.getServletPath();

// jQuery 1.8 and up
if(servletPath != null && (servletPath.contains("standards") || servletPath.contains("standlist") || servletPath.contains("/manuals")))
{%>
    <script type="text/javascript" src="/BSTheme-theme/js/hoverIntent.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/superfish.js"></script>
<%}
// jQuery 1.4.2
else {%>
    <script type="text/javascript" src="/BSTheme-theme/js/hoverIntent.jquery-1.4.2.js"></script>
    <script type="text/javascript" src="/BSTheme-theme/js/superfish.jquery-1.4.2.js"></script>
<%}%>
<script type="text/javascript">
	jQuery(function(){
		if ( jQuery('ul.sf-menu').superfish() ) {
			jQuery('ul.sf-menu').superfish();
		}
	});
</script>
