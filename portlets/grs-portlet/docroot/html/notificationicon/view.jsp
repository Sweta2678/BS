<%@include file="/html/init.jsp"%>

<script type="text/javascript">
jQuery(document).ready(function() {
if('${isIconVisible}' == 'true'){	
 $('.notification-alrt').css('display','block');
}else{
	$('.notification-alrt').css('display','none');
}
});
</script> 