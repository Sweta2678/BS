<%@include file="/html/init.jsp"%>

<div class="changeNetworkHeader">
	<h1>
		<liferay-ui:message key="site.search.heading"></liferay-ui:message>
	</h1>
	<form name="grsSiteSearch" id="grsSiteSearch"
		onsubmit="event.preventDefault();" title="Search Form" class="row">
		<div class="search-container srcmodify-con">

			<div class="searcmodify">
				<input type="text" id="grsSiteSearchKeywords" name="q"
					class="keyword search"
					onblur="if(this.value == '') { this.value = 'Enter Keyword(s)'; }"
					onfocus="if(this.value == 'Enter Keyword(s)') { this.value = ''; }"
					value="Enter Keyword(s)" autocomplete="off">
			</div>
			<div class="searchbtn">
				<input type="button" class="pull-right postsearch" value="Search"
					onclick="grsSiteSearchFormSubmit('searchbtn');" />
			</div>
		</div>
	</form>
	<c:set var="url"
		value="<%=ActionUtil.getFullURLByPageName(renderRequest,
					ApplicationConstants.PAGE_NAME_SITE_SEARCH_RESULTS)%>" />
	<div class="library_result">
		<div class="result_count">
			<${totalcount}>
			<liferay-ui:message key="search-sub-heading-results"></liferay-ui:message>
			' <span class="resultterm">${search_keywords}</span> '
		</div>

		<c:if test="${not empty searchList}">
			<div class="list_view">
				<select class="customSelect" name="sort" id="sort"
					onChange="grsSiteSearchFormSubmit('onChange');">
					<option value="-1">
						<liferay-ui:message key="label.sortBy"></liferay-ui:message>
					</option>
					<option value="0">
						<liferay-ui:message key="label.a-z"></liferay-ui:message>
					</option>
					<option value="1">
						<liferay-ui:message key="label.z-a"></liferay-ui:message>
					</option>
					<option value="2">
						<liferay-ui:message key="label.modified"></liferay-ui:message>
					</option>
				</select>
			</div>


			<div class="search_result">
				<ul class="search_list">
					<c:forEach var="searchPojo" items="${searchList}">
						<li>
							<div class="search_left">
								<img src="${searchPojo.imageUrl}">
							</div> <!--/.search_left-->
							<div class="search_right">
								<h3>
									<a href="${searchPojo.url}"
										<c:if test="${searchPojo.getType() != 'document'}">target="_blank"</c:if>
										title="${searchPojo.title}">${searchPojo.title}</a>
								</h3>
								<p>${searchPojo.desc}</p>
								<div class="modifydate">${searchPojo.date}</div>
							</div>

						</li>
					</c:forEach>
				</ul>
				<!--/.search_list-->
				<div class="clear"></div>
			</div>
			<%@include file="/html/common/pagination.jsp"%>
		</c:if>
	</div>
</div>
<!-- Change netwrok header end -->

<script type="text/javascript">
	$('document')
			.ready(
					function() {
						var sort = '${sort}';
						var totalcount = '${totalcount}';
						if (totalcount > 0) {
							document.getElementById('sort').value = sort;
						}
						document.getElementById('grsSiteSearchKeywords').value = '${search_keywords}';

					});

	function validateForm() {
		var keyword = document.getElementById("grsSiteSearchKeywords").value;
		if (keyword == null || keyword == "" || keyword == "Enter Keyword(s)") {
			alert("You must enter some keyword before clicking Search Button !!!");
			return false;
		} else {
			return true;
		}
	}

	$('#grsSiteSearchKeywords').keypress(
			function(e) {
				if (e.which == 13) {
					if ($('#grsSiteSearchKeywords').size() > 0
							&& $('#grsSiteSearchKeywords').val() != "") {
						grsSiteSearchFormSubmit('keypress');
					}
				}
			});
	function grsSiteSearchFormSubmit(action) {
		var searchString = document.getElementById("grsSiteSearchKeywords").value;
		var sort =  '-1';
		var totalcount = '${totalcount}';
		if (totalcount > 0) {
			sort = document.getElementById('sort').value;
		}
		if (sort == '-1' && action == 'onChange') {
			return false;
		} else {
			if (searchString != null && searchString != ""
					&& searchString != 'Enter Keyword(s)') {
				if (!/\d/.test(searchString) && !/[a-zA-Z]/.test(searchString)) {
					return false;
				} else {
					searchString = searchString.replace(/&/g, "%26amp;")
							.replace(/>/g, "%26gt;").replace(/</g, "%26lt;")
							.replace(/\'/g, "%26apos;").replace(/\"/g,
									"%26quot;");
					var url = "${url}?q=" + searchString + "&sort=" + sort;
					window.location.href = url;
				}
			} else {
				return false;
			}
		}
	}
</script>