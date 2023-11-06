<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>GRS - Redirect..</title>
		<link href="/me2-vanity-url-portlet/css/custom1.css" rel="stylesheet" type="text/css" />
	</head>
	<body class="redirect-bg">
		<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
		<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
		<div class="redirect-container">
			<div class="img-positioning">
				<div class="bottom-graphic">Graphics</div>
		    	<div class="logo-container">
		        	<img src="/me2-vanity-url-portlet/images/merlin-logo.png" width="308" height="75" alt="Merlin Logo" title="Merlin Logo" />
		        </div>
		   		<div class="loader-container">
		        	<img src="/me2-vanity-url-portlet/images/loader.gif" width="32" height="32" alt="Loader" title="Loader" />
		        </div>
		        <div class="text-container">
					<c:set var="vanityUrl" value="${redirectURL}" />
			    	<c:if test='${fn:contains(redirectURL,"//") == false}'>
			    		<c:set var="vanityUrl" value="//${redirectURL}" />
			    	</c:if>
					
		            <span class="bigtext">One moment please...<BR/>Your page is loading...</span>
		            <span class="smalltext">If your browser does not redirect, click <a href="${vanityUrl}">here</a> to continue</span>
			
					<script>
						window.setTimeout(function(){
							window.location = '${vanityUrl}';
						}, 1000);
					</script>
		        </div>
		    </div>
		</div><!--end of redirect-container -->
	</body>
</html>