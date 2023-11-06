<%@include file="/html/init.jsp"%>
<portlet:resourceURL id='regionRefreshURL' var="regionRefreshURL">
	<portlet:param name="requestType" value="RegionRefreshURL" />
</portlet:resourceURL>
<div id="progress">
	<div class="row">
		<div class="span12">
			<div class="row">
				<div class="span8"><h3 class="progress-title">${selectedBrand} Publication Progress</h3></div>
				<c:if test="${activePublish}">
					<c:choose>
						<c:when test="${publicationOverDue}">
							<div class="span3 pull-right alert alert-error">PUBLICATION OVERDUE</div>
						</c:when>
						<c:otherwise>
							<div class="span3 pull-right alert alert-info">${durationLeft}&nbsp;${duration} left until publication</div>
						</c:otherwise>
					</c:choose>
				</c:if>
			</div>
		</div>
	</div>
	<div class="row">
		<div class="span12">
			<p>
	            <c:choose>
	                <c:when test="${activePublish}">
						For <u id="brandLabel">${selectedBrand}</u>, the following is a summary of your progress towards the ${bridgePublishDate} publication:
	                </c:when>
	                <c:otherwise>
	                    Please create new publication.
	                </c:otherwise>
	            </c:choose>
			</p>
		</div>
	</div>
	<c:if test="${activePublish}">
		<div class="row">
			<div class="container" id="progress_Tabs">
				<ul id="myTab" class="nav nav-tabs">
                    <li><a id="globalTab" href="#global">Global</a></li>
	            	<li><a id="ameaTab" href="#amea">AMEA</a></li>
	            	<li><a id="amerTab" href="#amer">Americas</a></li>
	            	<li><a id="euroTab" href="#euro">Europe</a></li>
	            	<li><a id="gcTab" href="#gc">Greater China</a></li>
	          	</ul>
	          	<div class="tab-content">
                    <div id="global" class="tab-pane">
                        <%-- <%@include file="/html/progress/global.jsp"%> --%>
                    </div>
	          		<div id="amea" class="tab-pane">
	              		<%-- <%@include file="/html/progress/region.jsp"%> --%>
					</div>
					<div id="amer" class="tab-pane">
	              		<%-- <%@include file="/html/progress/region.jsp"%> --%>
					</div>
					<div id="euro" class="tab-pane">
	              		<%-- <%@include file="/html/progress/region.jsp"%> --%>
					</div>
					<div id="gc" class="tab-pane">
	              		<%-- <%@include file="/html/progress/region.jsp"%> --%>
					</div>
				</div>
			</div>
		</div>
	</c:if>
</div>

<script type="text/javascript">
	
	function loadProgressBar () {
		//jQuery.blockUI({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
		$('#progress').block({ message: '<h3><img src="/BSBridge-theme/images/busy.gif" /> Please wait...</h3>' });
	}
	function unLoadProgressBar () {
		$('#progress').unblock();
	}
	
	jQuery("#progress_Tabs").tabs({
        activate: function(event, ui) {
            /* var tabName = ui.newTab.text(); */
            var tabIndx = ui.newTab.index();
            if (event.originalEvent.type == "click" &&  tabIndx >= 0)
            {
				loadTabData(tabIndx);
            }
        }
    });
	
	function loadTabData(tabIndx, isHardRefreh){		var refreshURL = '${regionRefreshURL}';
	    refreshURL = refreshURL+"&tabIndx="+tabIndx;
		
		if(isHardRefreh == true){
			refreshURL = refreshURL+"&isHardRefresh="+true;
		}
		loadProgressBar();
		$.ajax({
		  	url :refreshURL,
		  	type: "POST",
		  	dataType: "text"
		}).done(function(data) {
			
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    	    if(tabIndx == 0){
                    $('#global').html(data);
                } else if(tabIndx == 1){
	    			$('#amea').html(data);
	    		} else if(tabIndx == 2){
	    			$('#amer').html(data);
	    		} else if(tabIndx == 3){
	    			$('#euro').html(data);
	    		} else if(tabIndx == 4){
	    			$('#gc').html(data);
	    		}
	    	}
			/* Un load block UI */
			//jQuery.unblockUI();
	    	unLoadProgressBar();
			
		}).fail( function(jqXHR) {
			/* Un load block UI */
            //jQuery.unblockUI();
			unLoadProgressBar();
        });
	}
	
	$(document).ready(function(){
		var selectedTab = '${selectedTab}';
		var activePublish = '${activePublish}';
		if(activePublish) {
		    if(selectedTab == 0){
                $('#globalTab').trigger('click');
                loadTabData(selectedTab);
            } else if(selectedTab == 1){
				$('#ameaTab').trigger('click');
				loadTabData(selectedTab);
			} else if(selectedTab == 2){
				$('#amerTab').trigger('click');
				loadTabData(selectedTab);
			} else if(selectedTab == 3){
				$('#euroTab').trigger('click');
				loadTabData(selectedTab);
			} else if(selectedTab == 4){
				$('#gcTab').trigger('click');
				loadTabData(selectedTab);
			}
		}
	});
</script>