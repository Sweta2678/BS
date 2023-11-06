
<%@page import="com.liferay.portal.kernel.util.Validator"%>
<%@page import="com.liferay.util.portlet.PortletProps"%>
<%@include file="/html/init.jsp"%>
<%@page import="com.liferay.portlet.journal.model.JournalArticle"%>
<%@page import="com.liferay.portal.util.PortletKeys"%>
<%@page import="com.liferay.portal.util.PortalUtil"%>

<%@page import="javax.portlet.WindowState"%>
<script type="text/javascript">
	isCustomFnbHookCall = true;
</script>
<c:if test="${not empty article}">
<portlet:resourceURL var="commentsListUrl" id="loadMoreForComments">
	<portlet:param name="classPK" value="${article.resourcePK}" />			
</portlet:resourceURL>
<portlet:resourceURL var="sendEmail" id="shareContent">
	<liferay-portlet:param name="requestType" value="shareContent" />
</portlet:resourceURL>

<% 
	JournalArticle journalArticle = null;			
			ArticleInfoBean	articalInfo = ((ArticleInfoBean) renderRequest.getAttribute("article"));
			journalArticle = articalInfo.getArtical();
			String groupId = String.valueOf(journalArticle.getGroupId());
			String articalId = String.valueOf(journalArticle.getArticleId());
			String version = String.valueOf(journalArticle.getVersion());			
			String structureKey = journalArticle.getStructureId();						
	%>
	 <c:choose>
		<c:when test='<%=structureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
    	        <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_BLOG_DETAIL) %>"/>
		</c:when>    
    	<c:otherwise>
	    	 <c:choose>
				<c:when test='<%=structureKey.equals(ApplicationConstants.ABOUT_GRS_STRUCTURE_KEY) %>'>
    	    	    <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ABOUT_GRS_DETAIL) %>"/>
				</c:when>    
    			<c:otherwise>
        		    <c:set var="url"  value="<%= ActionUtil.getFullURLByPageName(renderRequest,ApplicationConstants.PAGE_NAME_ARTICLE_DETAIL) %>"/>
    			</c:otherwise>
			</c:choose>
    	</c:otherwise>
	</c:choose>  
	<c:if test='<%=structureKey.equals(ApplicationConstants.ROADMAP_STRUCTURE_KEY) ||  structureKey.equals(ApplicationConstants.ABOUT_GRS_STRUCTURE_KEY)%>'>
		 <c:if test="<%=!themeDisplay.getLayout().getGroup().getName().equals(ApplicationConstants.SITE_GRS_HOTEL_IMPLEMENTATION) %>">	 
			<div class="backLinkWrap"><div class="backLink"></div></div>
		</c:if>	
	</c:if>

<div class="article-detail">
	<div class="article_art">
		<h3>
			<c:out value="${article.title}" />
		</h3>
		<c:if test='<%=structureKey.equals(ApplicationConstants.ARTICLE_STRUCTURE_KEY) ||  structureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) ||  structureKey.equals(ApplicationConstants.VIDEO_STRUCTURE_KEY) %>'>
			<c:if test='<%=!structureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
				<div class="article-detail-date">
					<c:out value="${article.dispDate}" />
				</div>
			</c:if>
			<div class="like_subscribe">
				<liferay-ui:ratings className="<%= JournalArticle.class.getName()%>"
					classPK="${article.resourcePK}" type="thumbs" />

				<div class="coment">
					<div class="taglib-ratings thumbs thumbfloat">
						<a title="Comments Count"
							href="${url}?id=${article.articleId}#comment"><span></span> </a>
						<c:out value="${article.commentCount}" />
					</div>
				</div>
				<div class="share">
					<div class="taglib-ratings thumbs thumbfloat">
						<a title="Share Content" href="" onclick="javascript:clearFormValues()"
							data-toggle="modal" data-target="#myModal"><span class="sharecontainer">share</span></a>
					</div>
				</div>

			</div>
		</c:if>
		<div class="art-sin-con">
			<div class="vid-cont">
				<c:choose>
					<c:when test="${article.contentType == 'image'}">
						<c:if test='<%=structureKey.equals(ApplicationConstants.BLOG_STRUCTURE_KEY) %>'>
							<div class="dt-aet-sin article-img-date"> <c:out value="${article.dispDate}" /></div>
						</c:if>
						<img src="${article.imageUrl}" title="${article.title}"
							alt="${article.title}" />
					</c:when>
					<c:otherwise>
						<div id="vid-cont"></div>
					</c:otherwise>
				</c:choose>
			</div>
			 <c:choose>
				<c:when test='<%=structureKey.equals(ApplicationConstants.ROADMAP_STRUCTURE_KEY) ||  structureKey.equals(ApplicationConstants.ABOUT_GRS_STRUCTURE_KEY)%>'>
    	        	<div class="about-head">
				</c:when>    
    			<c:otherwise>
        			<div class="art-opt">
    			</c:otherwise>
			</c:choose>			
				<c:out value="${article.caption}" />
			</div>
			<p>
				<c:out value="${article.fullDescription}" escapeXml="false" />
			</p>
			<%@include file="/html/common/edit_web_content.jsp"%>
			
		</div>
	</div>
	
	
	
	<!-- Start Comments -->
	<c:if test="${isCommentVisibility}">		
		<div id="comment" class="maincoment">
			<portlet:actionURL name="addNewComment" var="addCommentURL">
				<portlet:param name="className"
					value="<%=JournalArticle.class.getName()%>" />
				<portlet:param name="classPK" value="${article.resourcePK}" />
				<portlet:param name="renderJspPage" value="${url}?id=${article.articleId}" />
			</portlet:actionURL>
			<form title="Comment Form" id="newCommentForm" method="POST"
				action="">
				<div class="addcoments">									
					<div class="row-fluid">
						<div class="addNewComment">Add new comment</div>
						<div class="span12">
							<div class="image">
								<img src="${userImageUrl}">
							</div>
							<div class="content">
								<div class=" row-fluid">
									<div class="span12">
										<div class="control">
											<h4>${userFullName}</h4>
											<textarea name="body" id="add-comment-box" placeholder="Enter your comments here"></textarea>
										</div>										
									</div>
								</div>
							</div>
						</div>
						<div class="row-fluid">
							<div class="commentBtns span12">
								<a title="Read full commenting policy" data-target="#myModalsec"
									data-toggle="modal" href="#" class="pull-left">Read full
									commenting policy</a>								
								<input type="button" class="pull-right" value="Add Comment"
									id="submit-button" name="submit-button"
									onclick="return validateNewComment(this,'<%=addCommentURL%>');">
							</div>
						</div>
					</div>
				</div>
			</form>
		</div>
		<c:if test="${not empty treeList}">
			<div class="comments">
				<div class="articleCommentList">
					<%@include file="/html/articledetail/comment-list.jsp"%>
				</div>
				<c:if test="${articleCommentCount > noOfCommentDisplay }">
					<div class="loadmore">
						<input type="button" value="Load More" id="fetchComments"
										name="load-more" >
					</div>
				</c:if>			
			</div>
		</c:if>
	</c:if>
	<!--  End Comments -->

<!-- Share Content popup start-->
  <div class="modal fade" id="myModal" role="dialog">
    <div class="modal-dialog">
    
      <!-- Modal content-->
      <div class="modal-content sharewrapper">
        <div class="modal-header">
          <button type="button" class="close" data-dismiss="modal">&times;</button>
          <h4 class="share-title">Share Content</h4>
        </div>
        <div class="modal-body">
          <p><%= PortletProps.get("article-detail-share-content-description") %></p>
          <div class="control share-field">
				<label>From</label>
				<input type="text" id="fromMailId" name="<portlet:namespace/>from" value="${themeDisplay.user.emailAddress}" class="disabled" readonly="readonly"/>
		  </div>
          <div class="control share-field">
				<span class="required">*</span><label>To</label>
				<input type="text" id="toMailIds"  />
		  </div>
          <div class="control share-field">
				<span class="required">*</span><label>Subject</label>
				<input type="text" id="mailSubject"  />
		  </div>
          <div class="control">
			<span class="required">*</span><label>Message</label>
			<textarea  id="mailBody" readonly="readonly" ></textarea>
		  </div>
          <div class="bottomLink">
							<input type="button" value="Send" class="pull-right postMsg" onclick="sendEmail();"/>
							<input type="button" value="Cancel" class="pull-right cancel" onclick="closeDialog();"/>
						</div>
        </div>
      </div>
      
    </div>
  </div>   
    <!-- Share Content popup end-->

<!-- Comment Policy popup start-->
<c:if test="${commentPolicyArticleId > 0 }">
<div class="modal fade" id="myModalsec" role="dialog">
	<div class="modal-dialog">
		<div class="modal-content sharewrapper">
			<div class="modal-header">
				<button type="button" class="close" data-dismiss="modal">&times;</button>
				<liferay-ui:journal-article articleId="${commentPolicyArticleId}"
					groupId="<%= themeDisplay.getScopeGroupId() %>"></liferay-ui:journal-article>
			</div>
			<div class="modal-body"></div>
		</div>

	</div>
</div>

<!--Comment Policy popup end-->
</c:if>
<script type="text/javascript">
	
jQuery(document).ready(function() {
	var providerType = '${article.contentType}';
	var videoURL = '${article.videoUrl}';
	if (videoURL != null && (videoURL.indexOf('youtube.com') > -1)) {
		providerType = '';
	}
	if (providerType == 'video') {
		jwplayer('vid-cont').setup({
			'flashplayer' : '/static/common/jwplayer/player.swf',
			'width' : 'auto',
			'height' : '380',
			'file' : videoURL,
			'provider' : providerType,
			'image' : '${article.imageUrl}',
			'plugins' : {
				'gapro-2' : {
					'trackstarts' : true,
					'trackpercentage' : true,
					'trackseconds' : true,
					'idstring' : ''
				}
			}
		});
	}

	$('.rating-label').each(function() {
		var innerData = $(this).text().split(" ");
		if (innerData.length > 0) {
			$(this).text(innerData[0].replace("+", " "));
		}
	});
	
	LoadMore.init({
		content : $('.comments .articleCommentList'),
		loadMoreButton : $('#fetchComments'),
		url : '${commentsListUrl}',
		delta : ${(not empty noOfCommentDisplay) ? noOfCommentDisplay : 0},
		total : ${(not empty articleCommentCount) ? articleCommentCount : 0}
	});

});

function validateNewComment(newCommentsForm, addCommentURL, articleTitle)
{
	var newCommentStr = jQuery.trim($('#add-comment-box').val());
    if (newCommentStr == null || newCommentStr.length == 0)
    {
    	ErrorMessage.showError("#add-comment-box","Please enter message.");
		jQuery("#add-comment-box").focus();
        return false;
    } else
    {
    	ErrorMessage.hideError("#add-comment-box");
    	window.setTimeout(function() {
    	var formObj = document.getElementById('newCommentForm');
    	formObj.action = addCommentURL;
    	formObj.submit();
    	}, 300);
    }
	return true;
}


var contentURL;
function sendEmail() {
	
	//Cancel the link behavior
	var sendEmailURL = '${sendEmail}';	
	var toAddresses = $('#toMailIds').val();
	var contentTitle = $('#mailSubject').val();
	var contentURL = $('#mailBody').val();
	var filter = /^([a-zA-Z0-9_\.\-])+\@(([a-zA-Z0-9\-])+\.)+([a-zA-Z0-9]{2,4})+$/;
	var validation=true;
	if(typeof toAddresses == 'undefined' || toAddresses == null || toAddresses == '' || toAddresses == 'null') {
		ErrorMessage.showError("#toMailIds","Please provide a valid email address.");
		jQuery("#toMailIds").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#toMailIds");
	}
	if(typeof contentTitle == 'undefined' || contentTitle == null || contentTitle == '' || contentTitle == 'null'){
		ErrorMessage.showError("#mailSubject","Please provide subject.");
		jQuery("#mailSubject").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#mailSubject");
	}if(typeof contentURL == 'undefined' || contentURL == null || contentURL == '' || contentURL == 'null'){
		ErrorMessage.showError("#mailBody","Please provide Message.");
		jQuery("#mailBody").focus();
		validation=false;
	}else{
		ErrorMessage.hideError("#mailBody");
	}
	if(toAddresses!=''){
		var result = toAddresses.split(",");
		for (var i = 0; i < result.length; i++) {
            if (result[i] != '') {
                if (!filter.test(result[i])){
                    ErrorMessage.showError("#toMailIds","Please provide a valid email address.");
                    jQuery("#toMailIds").focus();
                    validation=false;
                    return false;
                }else{
            		ErrorMessage.hideError("#toMailIds");
            	}
            }
        }
	}

	if(validation){
		contentURL = contentURL.replace(/\r?\n/g, '<br />');
		$.ajax({
		  	url :sendEmailURL,
		  	data : {"toAddresses":toAddresses,"contentTitle":contentTitle,"contentURL":contentURL},
		  	type: "POST",
		  	dataType: "text"
		}).done(function(data) {
	    	if (data != null && data != '' && typeof data != 'undefined') {
	    		
	    	}
	    	$('.close').click();
		}).fail( function(jqXHR) {
			$('.close').click();
        });
	}
	
}

function closeDialog(){
	$('.close').click();
}

function clearFormValues() {
	 $('#toMailIds').val('');
     $('#mailSubject').val('');
     contentURL='Hello, \n I thought you would find this interesting.\n${themeDisplay.getURLPortal()}${url}?id=${article.articleId}';     
     $('#mailBody').val(contentURL);     
     ErrorMessage.hideError("#toMailIds");
     ErrorMessage.hideError("#mailSubject");
     ErrorMessage.hideError("#mailBody");
}	
</script>

</c:if>