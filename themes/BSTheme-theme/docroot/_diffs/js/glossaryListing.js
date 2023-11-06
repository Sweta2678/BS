var goto_url = "/web/brand-standards/glossary";
function deleteGlossary(glossaryId, url) {
	
	jQuery('#glossaryId').val(glossaryId);
	jQuery.msgBox({
               title: "Attention",
               content: "Are you sure you want to delete glossary?" ,
               type:"confirm",
			   buttons: [{ value: "Yes" }, { value: "No" }],
			   success: function (result) {
							if (result == "Yes") {
								
								jQuery("#glossaryForm").attr("action",url);
								jQuery("#glossaryForm").submit();
							}else {
								return false;
							}
						}
          });

	return false; 
} 