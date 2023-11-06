var portletNmSpaceMailSupport ;
function showSupportFmPopup() {

 jQuery("#errors").css('display','none');
 AUI().use('aui-dialog','aui-base', 'aui-io','liferay-portlet-url', 'event', 'event-custom','io-form' ,function(A) {

 var urlMailPopup=Liferay.PortletURL.createRenderURL();
 urlMailPopup.setPortletId('SupportForm_WAR_BSAdminportlet');
 urlMailPopup.setParameter('COMMAND','CMD_SUPPORT_FORM_POPUP');
 urlMailPopup.setPortletMode('view');
 urlMailPopup.setWindowState('exclusive');

 
 var urlMailResourceUrl=Liferay.PortletURL.createResourceURL();
 urlMailResourceUrl.setPortletId('SupportForm_WAR_BSAdminportlet');
 
 
    var dialog = new A.Dialog({
		    on: { close: function() {  } },  
            title: 'Support Request Form',
            centered: false,
            draggable: false,
            resizable: false,
            width: 'auto',
            height: 'auto',
            xy:[250,200],
            modal: true,
            buttons: [ 
                      
              {text: 'Submit',
                handler: function() {
                    var cfg = {
                        method: 'POST',
                        enctype: 'multipart/form-data',
                       
                        form: {
                            id: '_SupportForm_WAR_BSAdminportlet_Mailfm',
                            upload: true
                            },
                        on: {
                        	complete: function(id,o,args) {
                        		if(o && o.responseText)
                          	    {
                                 response=A.JSON.parse(o.responseText);
		                        
                                 if(response.response == 'Failure')
		                      	  {
		                       	      jQuery("#errors").css('display','block');
		                      		  jQuery("#errors").html(response.response+": "+response.message);
		                      		  
		                      	  }
		                      	  else
		                      	  {
		                      		  if(response.response == 'Success')
		                          	  {
		                      			  jQuery("#errors").css('display','block');
		                          		  jQuery("#errors").html(response.response+": "+response.message);
		                          		  jQuery("#errors").slideDown('slow');
		            	      	              setTimeout(function () {
		            	      	            	  jQuery("#errors").slideUp("slow", function () {});
		            	      	            	  dialog.close();
		            	      	            	}, 2000);
		            	      	  	  }
		                      	  }
                          	    }
                        	  }
                            }
                    };
                    A.io(urlMailResourceUrl, cfg);
                   }
                },
             {text: 'Cancel',
               handler: function() {
               	this.close();
                  }
          }]
        }).plug(A.Plugin.IO, {uri: urlMailPopup.toString()}).render();
        dialog.show();
  });
}