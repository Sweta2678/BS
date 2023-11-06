/**
 * Auther: Vijay Kumar Singh
 */

var Feedback = {

	init : function(config) {
		//console.log('Initializing Feedback.');
		this.config = config;
		this.config.repeatingSection = '#' + config.form.attr('id') + ' .repeatingSection';
		this.config.repeatAddButton = config.form.find('.repeatable-field-add');
		this.config.repeatDeleteButton = config.form.find('.repeatable-field-delete');
		this.bindEvents();
		this.showRepeatControlButtons();
	},

	bindEvents : function() {
		//console.log('Binding Events.')
		$('#' + this.config.namespace + 'anonymous').on('change', this.setAnonymous);
		this.config.repeatAddButton.on('click', this.createNewSection);
		this.config.repeatDeleteButton.on('click', this.removeSection);
		this.config.form.on('submit', this.submitFeedbackForm);
	},

	setAnonymous : function() {
		//console.log('Setting Anonymous.')
		var self = Feedback;
		$('#' + self.config.namespace + 'firstName').val('Anonymous');
		$('#' + self.config.namespace + 'lastName').val('Anonymous');
		$('#' + self.config.namespace + 'title').val('Anonymous');
		$('#' + self.config.namespace + 'email').val('Anonymous');

		$('input.customChk').prettyCheckable('disable');
	},

	createNewSection : function() {
		//console.log('createNewSection');
		var self = Feedback;
		var repeatingSection = $(self.config.repeatingSection);
		var currentCount = repeatingSection.length;
		//console.log("Current count:" + currentCount);
		var newCount = currentCount + 1;
		var lastRepeatingGroup = repeatingSection.last();
		var newSection = lastRepeatingGroup.clone();
		newSection.insertAfter(lastRepeatingGroup);
		newSection.find(":input").each(
				function(index, input) {
					input.id = input.id.replace("_" + currentCount, "_"
							+ newCount);
					input.name = input.name.replace("_" + currentCount, "_"
							+ newCount);

					switch (input.type) {
					case "text":
						$(input).val('');
						break;
					case "select-one":
						input.selectedIndex = 0;
						$(input).selectmenu({
							style : 'dropdown',
							width : 280,
							create : function() {
								$(input).next().remove();
							}
						});

						break;
					}

				});
		newSection.find(".help-inline").remove();
		/*
		 * newSection.find("label").each( function(index, label) { var l =
		 * $(label); l.attr('for', l.attr('for').replace( "_" + currentCount,
		 * "_" + newCount)); });
		 */

		self.showRepeatControlButtons();
	},

	removeSection : function() {
		//console.log('removeSection');
		var self = Feedback;
		var repeatingSection = $(self.config.repeatingSection);
		repeatingSection.last().remove();
		self.showRepeatControlButtons();
	},

	showRepeatControlButtons : function() {
		//console.log('showRepeatControlButtons');
		var self = Feedback;
		var repeatingSection = $(self.config.repeatingSection);
		var currentCount = repeatingSection.length;
		if (currentCount == 1) {
			self.config.repeatDeleteButton.addClass("hide");
		} else {
			self.config.repeatDeleteButton.removeClass("hide");
		}

		if (currentCount == 5) {
			self.config.repeatAddButton.addClass("hide");
		} else {
			self.config.repeatAddButton.removeClass("hide");
		}
	},

	submitFeedbackForm : function() {
		// console.log('Submit FeedbackForm')
		var self = Feedback;
		var result = self.validate();
		if (result) {
			this.submit();
		} else {
			console.log('Error in form.');
		}
	},

	validate : function() {
		//console.log('feedback form validate');
		var status = true;
		var self = Feedback;
		var repeatingSection = $(self.config.repeatingSection);
		var currentCount = repeatingSection.length;
		var totalUploadFileSize = 0;
		$.each(repeatingSection, function(index, section) {
			index += 1;
			
			var feedbackType = $(section).find( '#' + self.config.namespace + 'feedbackType_' + index); 
			var topic = $(section).find( '#' + self.config.namespace + 'topic_' + index);
			var otherTopic = $(section).find( '#' + self.config.namespace + 'otherTopic_' + index);
			var subject = $(section).find('#' + self.config.namespace + 'subject_' + index);
			var message = $(section).find('#' + self.config.namespace + 'message_' + index);
			var uploadFile = $(section).find('#' + self.config.namespace + 'file_' + index);
			//console.log("subject=" + subject + ", message=" + message + ", uploadFile=" + uploadFile);
			
			
			if (feedbackType.prop('selectedIndex') <= 0) {
				ErrorMessage.showError(feedbackType, "Please select feedback type.");
				status = false;
			} else {
				ErrorMessage.hideError(feedbackType);
			}
			

			var selectedTopicIndex = topic.prop('selectedIndex');
			if (selectedTopicIndex <= 0) {
				ErrorMessage.showError(topic, "Please select topic.");
				status = false;
			} else if (selectedTopicIndex == topic[0].options.length - 1
					&& otherTopic.val().trim() == '') {
				ErrorMessage.hideError(topic);
				ErrorMessage.showError(otherTopic, "Please enter specific topic.");
				status = false;
			} else {
				ErrorMessage.hideError(topic);
				ErrorMessage.hideError(otherTopic);
			}
			 

			if (message.val().trim() == '') {
				ErrorMessage.showError(message, "Please enter message.");
				status = false;
			} else {
				ErrorMessage.hideError(message);
			}

			if (uploadFile[0].files.length != 0
					&& uploadFile[0].files[0].size > self.config.maxFileSize) {
				ErrorMessage.showError(uploadFile,
						"File size exceeds. Maximum file size allowed "
								+ self.config.maxFileSize / (1024 * 1024)
								+ " MB.");
				status = false;
			} else {
				ErrorMessage.hideError(uploadFile);
			}
		});
		
		if(!status){
			$('.help-inline').first().prev().focus();
		}
		return status;
	}

}

