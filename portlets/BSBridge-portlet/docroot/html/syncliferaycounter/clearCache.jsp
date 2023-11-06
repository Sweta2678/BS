<%@include file="/html/init.jsp"%>

<portlet:actionURL name="clearEntityCache" var="clearEntityCacheURL" />

<form action="${clearEntityCacheURL}" method="post" name="clearCacheForm">
	<input type="text" name="clearCacheEntityName" id="clearCacheEntity" style="width:600px"
		placeholder="auto picklist... start typing hibernate entity model class full name...">
	<input type="submit" value="Submit" id="submitEntity">
</form>

<script type="text/javascript">	
	var entitiesListVar = [];
	<c:forEach items="${entitCacheList}" var="entitCachevar">
		entitiesListVar.push({label:"${entitCachevar.className}"});
	</c:forEach>
	
	jQuery("#submitEntity").click(function(){
		jQuery("#clearCacheEntity").css('border','');
		if(jQuery("#clearCacheEntity").val() == ''){
			jQuery("#clearCacheEntity").css('border','1px solid red');
			return false;
		} 
	});
	
	jQuery("#clearCacheEntity").autocomplete({
		  source: entitiesListVar,
	      autoFill: true,
	      minLength: 3,
	      select: function(event, ui) {
			event.preventDefault();
			jQuery("#clearCacheEntity").val(ui.item.value);
	      },
	 });
</script>