 <%@include file="/html/init.jsp"%>
 <%@include file="init.jsp"%>
   <div class="span12">
        <form id="addStdRecords" name="addStdRecords">
        <table class="table table-bordered specs table-striped" border="0">
          <thead>
            <tr><th colspan="3"><h4><span class="grey">${taxonomyPath}</span></h4></th></tr>
          </thead>
          <tbody>
          	<c:set var="glblIds" value=""/>
          	<c:set var="titleText" value=""/>
            <c:forEach var="stdItem" items="${standardList}">
            	
          		<c:choose>
          			<c:when test = '${stdItem.stdType eq "STD" }'>
          						<tr><td colspan="2"><strong>${stdItem.title} [${stdItem.stdId}]</strong></td>
          						
          						<c:choose>
          							<c:when test='${stdItem.status eq "EXISTS"}'>
          								<td><span></span></td>	
          								<td class="cen" width="80px"><input type="checkbox" checked disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:when test='${stdItem.status eq "NOTRGN"}'>
	          							<td><span class="label label-warning">Not ${countryName}</span></td>
	          							<td><span></span></td>
          							</c:when>
                                    <c:when test='${stdItem.status eq "DISCONT"}'>
                                        <td><span class="label label-warning">Discontinued</span></td>
                                        <td><span></span></td>
                                    </c:when>
          							<c:when test='${stdItem.status eq "UNPUBLISH"}'>
          								<td><span class="label label-warning">Unpublished</span></td>	
          								<td class="cen" width="80px"><input type="checkbox" value="${stdItem.stdId}" name="stdCheckBox" id="parentStd" onclick="javascript:childUnCheck()"></td>	
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          							</c:when>
          							<c:when test='${stdItem.status eq "NOTBRND"}'>
          								<td><span class="label label-warning">Not ${chainCode}</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:when test='${stdItem.status eq "GLBLMST"}'>
          								<td><span class="label label-success">Global Must</span></td>
          								<td class="cen" width="80px"><input type="checkbox" checked disabled value="${stdItem.stdId}"></td>	
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          								<c:choose>
          									<c:when test="${empty glblIds}">
          										<c:set var="glblIds" value="${stdItem.stdId}"/>
          									</c:when>
          									<c:otherwise>
												<c:set var="glblIds" value="${glblIds},${stdItem.stdId}"/>          									
          									</c:otherwise>	
          								</c:choose>
          							</c:when>
          							<c:when test='${stdItem.status eq "GLBLMSTNOT"}'>
          								<td><span class="label label-important">Global Must Not</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:when test='${stdItem.status eq "GNOTINMUST"}'>
          								<td><span class="label label-important">Global Not In Must</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:otherwise>
          								<td><span></span></td>
          								<td class="cen" width="80px"><input type="checkbox"  value="${stdItem.stdId}" name="stdCheckBox" id="parentStd" onclick="javascript:childUnCheck()"></td>
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          							</c:otherwise>
          						</c:choose>
          						</tr>
          						
          			</c:when>
          			<c:otherwise>
          						<tr><td class="bull">&#149;</td><td>${stdItem.title} [${stdItem.stdId}]</td>
          						<c:choose>
          							<c:when test='${stdItem.status eq "EXISTS"}'>
          								<td><span></span></td>	
          								<td class="cen" width="80px"><input type="checkbox" checked disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:when test='${stdItem.status eq "NOTRGN"}'>
	          							<td><span class="label label-warning">Not ${countryName}</span></td>
	          							<td><span></span></td>
          							</c:when>
                                    <c:when test='${stdItem.status eq "DISCONT"}'>
                                        <td><span class="label label-warning">Discontinued</span></td>
                                        <td><span></span></td>
                                    </c:when>
          							<c:when test='${stdItem.status eq "NOTBRND"}'>
          								<td><span class="label label-warning">Not ${chainCode}</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:when test='${stdItem.status eq "GLBLMST"}'>
          								<td><span class="label label-success">Global Must</span></td>
          								<td class="cen" width="80px"><input type="checkbox" checked disabled value="${stdItem.stdId}"></td>
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          								<c:choose>
          									<c:when test="${empty glblIds}">
          										<c:set var="glblIds" value="${stdItem.stdId}"/>
          									</c:when>
          									<c:otherwise>
												<c:set var="glblIds" value="${glblIds},${stdItem.stdId}"/>          									
          									</c:otherwise>	
          								</c:choose>
          							</c:when>
          							<c:when test='${stdItem.status eq "GLBLMSTNOT"}'>
          								<td><span class="label label-important">Global Must Not</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>
          							</c:when>
          							<c:when test="${isStdValid eq false}">
          								<td><span></span></td>	
          								<td class="cen" width="80px"><input type="checkbox"  disabled value="${stdItem.stdId}"></td>
          							</c:when>
          							<c:when test='${stdItem.status eq "UNPUBLISH"}'>
          								<td><span class="label label-warning">Unpublished</span></td>
          								<td class="cen" width="80px"><input type="checkbox" value="${stdItem.stdId}" id="child_${stdItem.stdId}" name="stdCheckBox" onclick="javascript:parentCheckUnCheck()"></td>
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          							</c:when>
          							<c:when test='${stdItem.status eq "GNOTINMUST"}'>
          								<td><span class="label label-important">Global Not In Must</span></td>
          								<td class="cen" width="80px"><input type="checkbox" disabled value="${stdItem.stdId}"></td>	
          							</c:when>
          							<c:otherwise>
          								<td><span></span></td>
          								<td class="cen" width="80px"><input type="checkbox"  value="${stdItem.stdId}" id="child_${stdItem.stdId}" name="stdCheckBox" onclick="javascript:parentCheckUnCheck()"></td>
          								<input type="hidden" name="title_${stdItem.stdId}" value="${stdItem.title}"/>
          								<input type="hidden" name="type_${stdItem.stdId}" value="${stdItem.stdType}"/>
          								<input type="hidden" name="content_${stdItem.stdId}" value="${stdItem.description}"/>
          								<input type="hidden" name="parentStdId_${stdItem.stdId}" value="${stdItem.parentStdId}"/>
          								<input type="hidden" name="stdId_${stdItem.stdId}" value="${stdItem.stdId}"/>
          							</c:otherwise>
          							
          						</c:choose>
          			</c:otherwise>
          		</c:choose>
            
            </c:forEach>
            	<input type="hidden" value = "${glblIds}" name="globalMustStd" id = "globalMustStd"/>
          </tbody>
          <tfoot>
            <tr><td colspan="3"></td><td class="cen"><button class="btn btn-small btn-primary" type="button" id="addItemsToPanel">Add Items</button></td></tr>
          </tfoot>
        </table>
       </form>
      </div>
 <script type="text/javascript">
 
 	function showRequest(formData, jqForm, options) {
		return true;
	}
	function showResponse(responseText, statusText, xhr, $form)  {
		if (responseText != null) {
			/* var jsonArray = responseText;
			var resultVal = '';
			for(var i = 0; i < jsonArray.length; i++) {
			    var obj = jsonArray[i];
			  resultVal =  resultVal + "<tr><td>"+obj.stdId+"</td><td>"+obj.title+"</td><td>"+obj.type+"</td></tr>" +
			  '<td class="cen"><a href="#" role="button" class="btn btn-mini btn-primary"> Del</a></td>';
			} */
			$('#results').html(responseText);
		}
	}
	$(function() {
	    
	    var options = { 
	        url:           addItems,  // override for form's 'action' attribute 
	        target:        '#results',   // target element(s) to be updated with server response 
	        beforeSubmit:  showRequest,  // pre-submit callback 
	        success:       showResponse, // post-submit callback 
	        // other available options: 
	        type:      'post',        // 'get' or 'post', override for form's 'method' attribute 
	        dataType:  'html'        // 'xml', 'script', or 'json' (expected server response type) 
	    }; 
	 
	    // bind form using 'ajaxForm' 
	    var crForm = $("#addStdRecords").ajaxForm(options);
	      	    
	    //$("#createPublication").click(function () {
	    $("#addItemsToPanel").bind('click', function (e) {
	       // $("#createDraftForm").submit();
	       //alert(crForm);
	       jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> </h3>' });
	       e.preventDefault();
	        e.stopPropagation();
	        crForm.submit();
	        $('#itemsAdded').css('display','block');
	        $('#addRecords').css('display','block');
	        jQuery.unblockUI();
	    });
	});
	    
	function parentCheckUnCheck(){
		var isCheck = $("#parentStd:enabled:checked").length > 0;
		if(!isCheck){
			/*$("#parent"+stdid).attr("checked","checked");*/
			document.getElementById("parentStd").checked = true;
		}
	}
	
	function childUnCheck(){
		var isCheck = $("#parentStd:enabled:checked").length > 0;
		if(!isCheck){
			$('input:checkbox[id^="child_"]').removeAttr('checked');
		}
	}
	
    
 </script>     
      