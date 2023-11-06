<%@ taglib uri="http://java.sun.com/portlet_2_0" prefix="portlet" %>
<%@include file="/html/uielement/init.jsp"%>
<script type="text/javascript" src="/BSTheme-theme/js/jquery-1.9.1.min.js"></script>

<portlet:defineObjects />
<portlet:resourceURL var="getPublicationDateByBrandURL" id="getPublicationDateByBrand" />
<portlet:resourceURL var="downloadPublicationManualURL" id="downloadPublicationManual" />

<div class="rounded_container">
	<div class="rounded_container_contents">
	<h4 class="short_page_subtitle">Download Archived Manuals</h4>
	
	<div class="clear"></div>
	<div class="divider">&nbsp;</div>
	<div class="clear"></div>
	
	<div class="report_container">
		<label>Brand:</label>
		<select id="corp_choose_brand" class="corp_choose_brand" name="corp_choose_brand">
			<option value="">Select</option>
			<c:forEach items="${chainCdMap}" var="chainCode">
				<option value="${chainCode.key}">${chainCode.value}</option>
			</c:forEach>
		</select>
		
		<label>Publication Date:</label>
		<select id="publication_date" name="publication_date">
			<option value=''>Select Publication Date</option>
		</select>
		
		<label>Country</label>
		<select id="country_list" name="country_list">
			<option value="">Select</option>
			<c:forEach items="${countryMap}" var="countryCodeMap">
				<option value="${countryCodeMap.key}">${countryCodeMap.value}</option>
			</c:forEach>
		</select>
		
		<label>Published Languages:</label>
		<select id="publication_language" name="publication_language">
			<option value=''>Select Language</option>
		</select>
		
		<label>Manual Type:</label>
		<select id="publication_manual_type" name="publication_manual_type">
			<option value=''>Select Language</option>
		</select>
		
		<div class="clear"></div>
		<a href="" id="download-manual" class="btn disabled" ><i class="icon-white icon-download-alt"></i>
		Download</a>
	</div>
	</div>
	<div class="rounded_container_bottom"></div>
</div>

<script type="text/javascript">

/* jQuery(document).ready(function() {
	
	jQuery('#download-manual').on('click',function(e){
	
	e.preventDefault(); 
	var brandCode = jQuery('#corp_choose_brand').val();
	var publishedDate = $("#publication_date option:selected").text();
	var pdfCtryCode = jQuery('#country_list').val();
	var pdfLocaleCode = jQuery('#publication_language').val();
	
	if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined' 
		&& publishedDate != null && publishedDate != '' && typeof publishedDate != 'undefined' 
		&& pdfCtryCode != null && pdfCtryCode != '' && typeof pdfCtryCode != 'undefined' 
		&& pdfLocaleCode != null && pdfLocaleCode != '' && typeof pdfLocaleCode != 'undefined' )
		{
			jQuery.ajax({
				url: '${downloadPublicationManualURL}'+ '&brandCode='+ brandCode+'&publishedDate='+ publishedDate+'&pdfCtryCode='+ pdfCtryCode+'&pdfLocaleCode='+pdfLocaleCode,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						var res = jQuery.parseJSON(data);
						jQuery.each(obj, function(key,value) 
						{
							window.location.href = value;
						});
					}
				}
			});
		}
	});
}); */


	jQuery("#corp_choose_brand").change(function() {
	
		var brandCode = jQuery('#corp_choose_brand').val();
		var publishedDate = $("#publication_date option:selected").text();
		var pdfCtryCode = jQuery('#country_list').val();
		var pdfLocaleCode = jQuery('#publication_language').val();
		
		if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined') {
		
			jQuery.ajax({
			url: '${getPublicationDateByBrandURL}'+ '&selectedBrandCode='+ brandCode,
			type: "POST",
			dataType: "text",
	
			success: function(data) {
				if (data != null && data != '' && typeof data != 'undefined') {
	                var dateOptions="<option value=''>Select Date</option>";
	                var langOptions="<option value=''>Select Language</option>";
	                var obj = jQuery.parseJSON(data);
					jQuery.each(obj, function(key,value) 
					{
						if(typeof value =="string")
	                	{
	                		dateOptions +="<option value="+key+">"+value+"</option>";
	               		}
						else if(typeof value =='object')
						{
							var result = jQuery.parseJSON(JSON.stringify(value))
							jQuery.each(result, function(k, v) {
								langOptions +="<option value="+k+">"+v+"</option>";
							});
	               		}
					});       
	                jQuery("#publication_date").empty().append(dateOptions);
	                jQuery("#publication_language").empty().append(langOptions);
				}
			}
		});
		}
		
		if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined' 
			&& publishedDate != null && publishedDate != '' && typeof publishedDate != 'undefined' 
			&& pdfCtryCode != null && pdfCtryCode != '' && typeof pdfCtryCode != 'undefined' 
			&& pdfLocaleCode != null && pdfLocaleCode != '' && typeof pdfLocaleCode != 'undefined' )
		{
				
			jQuery.ajax({
				url: '${downloadPublicationManualURL}'+ '&brandCode='+ brandCode+'&publishedDate='+ publishedDate+'&pdfCtryCode='+ pdfCtryCode+'&pdfLocaleCode='+pdfLocaleCode,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#download-manual').attr("Enabled", "True");
						var res = jQuery.parseJSON(data);
						jQuery.each(res, function(key,value) 
						{
							jQuery('#download-manual').removeClass( "disabled" );
							jQuery('#download-manual').addClass( "btn-primary" );
							jQuery('#download-manual').attr("href", value);
						});
					}
				}
			});
		}
	});
	
	
	jQuery("#country_list").change(function() {
		
		var brandCode = jQuery('#corp_choose_brand').val();
		var publishedDate = $("#publication_date option:selected").text();
		var pdfCtryCode = jQuery('#country_list').val();
		var pdfLocaleCode = jQuery('#publication_language').val();
		
		if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined' 
			&& publishedDate != null && publishedDate != '' && typeof publishedDate != 'undefined' 
			&& pdfCtryCode != null && pdfCtryCode != '' && typeof pdfCtryCode != 'undefined' 
			&& pdfLocaleCode != null && pdfLocaleCode != '' && typeof pdfLocaleCode != 'undefined' )
		{
				
			jQuery.ajax({
				url: '${downloadPublicationManualURL}'+ '&brandCode='+ brandCode+'&publishedDate='+ publishedDate+'&pdfCtryCode='+ pdfCtryCode+'&pdfLocaleCode='+pdfLocaleCode,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#download-manual').attr("Enabled", "True");
						var res = jQuery.parseJSON(data);
						jQuery.each(res, function(key,value) 
						{
							jQuery('#download-manual').removeClass( "disabled" );
							jQuery('#download-manual').addClass( "btn-primary" );
							jQuery('#download-manual').attr("href", value);
						});
					}
				}
			});
		}
		
	});
	
	jQuery("#publication_date").change(function() {
		
		var brandCode = jQuery('#corp_choose_brand').val();
		var publishedDate = $("#publication_date option:selected").text();
		var pdfCtryCode = jQuery('#country_list').val();
		var pdfLocaleCode = jQuery('#publication_language').val();
		
		if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined' 
			&& publishedDate != null && publishedDate != '' && typeof publishedDate != 'undefined' 
			&& pdfCtryCode != null && pdfCtryCode != '' && typeof pdfCtryCode != 'undefined' 
			&& pdfLocaleCode != null && pdfLocaleCode != '' && typeof pdfLocaleCode != 'undefined' )
		{
				
			jQuery.ajax({
				url: '${downloadPublicationManualURL}'+ '&brandCode='+ brandCode+'&publishedDate='+ publishedDate+'&pdfCtryCode='+ pdfCtryCode+'&pdfLocaleCode='+pdfLocaleCode,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#download-manual').attr("Enabled", "True");
						var res = jQuery.parseJSON(data);
						jQuery.each(res, function(key,value) 
						{
							jQuery('#download-manual').removeClass( "disabled" );
							jQuery('#download-manual').addClass( "btn-primary" );
							jQuery('#download-manual').attr("href", value);
						});
					}
				}
			});
		}
		
	});
	
	jQuery("#publication_language").change(function() {
		
		var brandCode = jQuery('#corp_choose_brand').val();
		var publishedDate = $("#publication_date option:selected").text();
		var pdfCtryCode = jQuery('#country_list').val();
		var pdfLocaleCode = jQuery('#publication_language').val();
		
		if (brandCode != null && brandCode != '' && typeof brandCode != 'undefined' 
			&& publishedDate != null && publishedDate != '' && typeof publishedDate != 'undefined' 
			&& pdfCtryCode != null && pdfCtryCode != '' && typeof pdfCtryCode != 'undefined' 
			&& pdfLocaleCode != null && pdfLocaleCode != '' && typeof pdfLocaleCode != 'undefined' )
		{
				
			jQuery.ajax({
				url: '${downloadPublicationManualURL}'+ '&brandCode='+ brandCode+'&publishedDate='+ publishedDate+'&pdfCtryCode='+ pdfCtryCode+'&pdfLocaleCode='+pdfLocaleCode,
				type: "POST",
				dataType: "text",
				success: function(data) {
					if (data != null && data != '' && typeof data != 'undefined') {
						jQuery('#download-manual').attr("Enabled", "True");
						var res = jQuery.parseJSON(data);
						jQuery.each(res, function(key,value) 
						{
							jQuery('#download-manual').removeClass( "disabled" );
							jQuery('#download-manual').addClass( "btn-primary" );
							jQuery('#download-manual').attr("href", value);
						});
					}
				}
			});
		}
		
	});
</script>