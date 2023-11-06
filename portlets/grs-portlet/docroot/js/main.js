/**
 * This is generic load more functionality for client side. 
 *  Usage:
 *  LoadMore.init({
		   content : $('<content selector>'),
		   loadMoreButton : $('<load more button selector>'),
		   url : '<url>',
		   delta : <delta>,
		   total : <total number of records>
		  });
 * Auther: Vijay Kumar Singh
 */
var LoadMore = {
	init : function(config) {
		// console.log('Initializing LoadMore.');
		this.config = config;
		this.config.offset = this.config.delta;
		this.bindEvents();
	},

	bindEvents : function() {
		// console.log('Binding Events.');
		this.config.loadMoreButton.on('click', this.loadMore);
	},

	loadMore : function() {
		// console.log('Load More');
		var self = LoadMore;
		var start = self.config.offset;
		var end = self.config.offset + self.config.delta;
		
		self.config.loadMoreButton.attr("disabled","true");

		$.ajax({
			type: "POST",
			url : self.config.url,
			data : {
				start : start,
				end : end
			}
		}).done(function(data) {
			self.config.content.append(data);
			self.config.offset += self.config.delta;
			if (self.config.offset >= self.config.total) {
				self.config.loadMoreButton.hide();
			}
		}).always(function() {
			self.config.loadMoreButton.removeAttr("disabled");
		});
	}
}

/**
 * Application level error message. 
 * To show the error message use ErrorMessage.showError('<Input selector>','<message>');
 * To hide the error use ErrorMessage.hideError('<Input selector>');
 * Auther: Vijay Kumar Singh
 */
var ErrorMessage = {
	showError : function(fieldId, errorMessage) {
		$(fieldId).closest(".control").addClass("error");
		$(fieldId).closest(".control").children().remove(".help-inline");
		$(fieldId).closest(".control").append(
				'<span class="help-inline">' + errorMessage + '</span>');
	},

	hideError : function(fieldId) {
		$(fieldId).closest(".control").children().remove(".help-inline");
		$(fieldId).closest(".control").removeClass("error");
	}
}