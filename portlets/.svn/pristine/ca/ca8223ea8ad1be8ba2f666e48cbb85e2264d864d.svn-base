
<%@include file="/html/init.jsp"%>


<c:forEach var="message" items="${treeList}">
	<div class="postComment">
		<div class="row-fluid">
			<div class="span12">
				<div class="image">
					<img src="${ message.imapgePath}">
				</div>
				<div class="content">
					<div class="title row-fluid">
						<div class="span12">
							<h4>${message.messageUserName}</h4>
							<span>${message.messageDate}</span>
						</div>

					</div>
					<p>${message.message.body}</p>

				</div>
			</div>
		</div>
		<hr>
	</div>
</c:forEach>

