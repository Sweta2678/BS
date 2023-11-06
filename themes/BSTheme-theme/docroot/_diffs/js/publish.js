
var validator;
var publishQueueId = 0;
var publishId = 0;
var localeSelected = false;

function runReport(reportId, pubQueueId, publishId) {
    var url = jQuery("#run_report_url").val();
    var indx = url.indexOf("&_Publish_");
    if (indx > 0)
    {
        url = url.substr(0, indx);
    }
    url = url + "&pubEnv=STAGING" + "&reportId=" + reportId + "&pubQueueId=" + pubQueueId + "&publishId=" + publishId;
    getExportReport(url);
    jQuery.unblockUI();
    return false;
};

function getExportReport(url)
{
    location.href = url;
};

function loadHistoricalData(environment) {
    var url = jQuery("#hist_data_url").val();
    var theUrl = url;
    var indx = url.indexOf("&_Publish_");
    if (indx > 0)
    {
        theUrl = url.substr(0, indx);
    }
    
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    var postData = {recordCnt:25,envType:environment};

    jQuery.ajax({
        type: "POST",
        url: theUrl,
        data: postData,
        dataType: "json"
    }).done( function(data) {
        /* populate data here! */
        jQuery.unblockUI();
        
        if(data.message == "SUCCESS") {
            delete data["message"];
            var recordCnt = data.recordCnt;
            delete data["recordCnt"];
            /*clear previous values */
            var theTable = null;
            if (environment == "STAGING") {
                jQuery("table#publish_stg_hist_table tr.table_links_list").remove();
                theTable = jQuery("table#publish_stg_hist_table");
            } else {
                jQuery("table#publish_prod_hist_table tr.table_links_list").remove();
                theTable = jQuery("table#publish_prod_hist_table");
            }

            if(recordCnt > 0)
            {
                jQuery.each(data, function(id, obj) {
                    if(obj.id) {
                         var allow_prod_pub = obj.allow_prod_pub;
                         var status = "Success";
                        if (obj.stat == "COMPLETE")
                        {
                            status = "Success";
                        }
                        else if (obj.stat == "COMPLETE_REPUBLISH")
                        {
                            status = "Success";
                            allow_prod_pub = "false";
                        }
                        else if (obj.stat == "COMPLETE_PROD_SCHEDULED")
                        {
                            status = "Scheduled Production Publish";
                            allow_prod_pub = "false";
                        }
                        else
                        {
                            status = obj.stat;
                        }

                        if (environment == "STAGING") {
                            var row = '<tr class="table_links_list">' + 
                                      '<td><a class="help_icon tooltip" href="javascript:return false;">' + obj.id +  
			                               '<span class="classic">Start Date: ' + obj.start_dt + ' End Date: ' + obj.end_dt +  '</span></a></td>' + 
                                      '<td>' + obj.brand + '</td><td>' + status + '</td>' +
                                      '<td>' + obj.prod_pub_dt + '</td><td>' + obj.schedule_dt + '</td>' + 
                                      '<td><span class="pub_locale">' + obj.locale_lst + '</span></td>' + 
                                      '<td><span class="pub_email">' + obj.email + '</span></td><td>' + obj.user + '</td>';
                            if( status == "Success" && allow_prod_pub == "true") {
                                row = row + '<td><input type="button" class="create_report" name="reportButton" id="report_btn_' + obj.id + '" value="Report" title="Report button" onClick="createReport(' + obj.id + ',' + obj.pubId + ', report_btn_' + obj.id + ')" /></td>' + 
                                            '<td><input type="button" class="create_mnl" name="manualButton" id="manual_btn_' + obj.id + '" value="Manual" title="Manual button" onClick="createManual(' + obj.id + ')" /></td>' + 
                                            '<td><input type="button" class="publish_prod" name="publishProdBtn" id="pulish_prod_btn_' + obj.id + '" value="Publish" title="Publish Prod button" onClick="publishToProd(' + obj.id + ')" /></td>';
                            } else {
                                row = row + '<td></td><td></td><td></td>';
                            }
                            row = row + '</tr>';
                            theTable.append(row);
                        } else {
                            status = obj.stat == "COMPLETE" ? "Success" : (obj.stat == "DELETED" ? "Deleted" : obj.stat);
                            var row = '<tr class="table_links_list">' + 
                                      '<td><a class="help_icon tooltip" href="javascript:return false;">' + obj.id +  
			                               '<span class="classic">Start Date: ' + obj.start_dt + ' End Date: ' + obj.end_dt +  '</span></a></td>' + 
                                      '<td>' + obj.brand + '</td><td>' + status + '</td>' +
                                      '<td>' + obj.schedule_dt + '</td><td>' + obj.start_dt + '</td><td>' + obj.end_dt +  '</td>' +
                                      '<td><span class="pub_hist_locale">' + obj.locale_lst + '</span></td>' + 
                                      '<td><span class="pub_hist_email">' + obj.email + '</span></td><td>' + obj.user + '</td>';
                            if( status == "NEW") {
                                row = row + '<td><img class="delete_pub_id" title="delete" id="manual_btn_' + obj.id + '" src="/BSTheme-theme/images/delete.png" onClick="deletePublishToProd(' + obj.id + ')" alt="delete"/></td>';
                            } else {
                                row = row + '<td></td>';
                            }
                            row = row + '</tr>';
                            theTable.append(row);
                        }
                    }
                });
            } else {
                var row = '<tr class="table_links_list"><td colspan="9">No data found</td></tr>';
                theTable.append(row);
            }
        }
        else
        {
            jQuery.msgBox({
                title: "Error!",
                content: "Failed to retrieve historical data : " + data.message ,
                type: "error",
                success: function (result) {
                    ;
                }
            });
        }
    }).fail( function(jqXHR) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Error!",
            content: "Failed to retrieve historical data! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
            type: "error",
            success: function (result) {
                ;
            }
        });
    });
};

function publishToProd(publishQueueId)
{
    jQuery.msgBox({
        title: "Are You Sure",
        content: "Are you sure you want to publish to Production?", 
        type: "confirm",
        buttons: [{ value: "Yes" }, { value: "No" }],
        success: function (result) {
            if (result == "Yes") {

                var url = jQuery("#confirmed_url").val();
                var theUrl = url;
                var indx = url.indexOf("&_Publish_");
                if (indx > 0)
                {
                    theUrl = url.substr(0, indx);
                }
                var env = "PRODUCTION";
                var postData = {pubEnv:env,pubQueueId:publishQueueId};
                jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
                
                jQuery.ajax({
                    type: "POST",
                    url: theUrl,
                    data: postData
                }).done( function(data) {
                    jQuery.unblockUI();
                    loadHistoricalData("STAGING");

                    jQuery.msgBox({
                        title: "Success!",
                        content: "Publish request submitted successfully", 
                        type: "info",
                        success: function (result) {
                            window.location.href = "/web/brand-standards/publish";
                        }
                    });

                }).fail( function(jqXHR) {
                    jQuery.unblockUI();
                    jQuery.msgBox({
                        title: "Error!",
                        content: "Failed to submit publish request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                        type: "error",
                        success: function (result) {
                            ;
                        }
                    });
                });
            }
        }
    });
};

function createManual(publishQueueId) 
{
    jQuery.msgBox({
        title: "Are You Sure",
        content: "Are you sure you want to create Full Manuals for Staging?", 
        type: "confirm",
        buttons: [{ value: "Yes" }, { value: "No" }],
        success: function (result) {
            if (result == "Yes") {
                var url = jQuery("#create_manual_url").val();
                var theUrl = url;
                var indx = url.indexOf("&_Publish_");
                if (indx > 0)
                {
                    theUrl = url.substr(0, indx);
                }
                var env = "STAGING";
                var postData = {pubEnv:env,pubQueueId:publishQueueId};
                jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
                
                jQuery.ajax({
                    type: "POST",
                    url: theUrl,
                    data: postData
                }).done( function(data) {
                    jQuery.unblockUI();

                    jQuery.msgBox({
                        title: "Success!",
                        content: "Create Manuals request submitted successfully", 
                        type: "info",
                        success: function (result) {
                            /*window.location.href = "/web/brand-standards/publish";*/
                        }
                    });

                }).fail( function(jqXHR) {
                    jQuery.unblockUI();
                    jQuery.msgBox({
                        title: "Error!",
                        content: "Failed to submit request to create Manuals! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                        type: "error",
                        success: function (result) {
                            ;
                        }
                    });
                });
            }
        }
    });
};

function createReport(pubQueueId, pubId, btn_id) 
{
    jQuery.blockUI({ message: null });
    checkedValues = [];
    jQuery(".reports").hide();
    var theItem = jQuery(".reportsContent").children().find("input:checked");
    theItem.attr("checked", "");
    jQuery(theItem).attr("checked", false);

    publishQueueId = pubQueueId;
    publishId = pubId;
    jQuery(".reports").show();
    $(".reports").css({ top: jQuery(btn_id).position().top + jQuery(".reports").height() + jQuery(btn_id).height() + 5 + 'px' });
};

function deletePublishToProd(publishQueueId) 
{
    jQuery.msgBox({
        title: "Are You Sure",
        content: "Are you sure you want to delete scheduled publication?", 
        type: "confirm",
        buttons: [{ value: "Yes" }, { value: "No" }],
        success: function (result) {
            if (result == "Yes") {
                var url = jQuery("#del_schedule_url").val();
                var theUrl = url;
                var indx = url.indexOf("&_Publish_");
                if (indx > 0)
                {
                    theUrl = url.substr(0, indx);
                }
                var env = "PRODUCTION";
                var postData = {pubEnv:env,pubQueueId:publishQueueId};
                jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
                
                jQuery.ajax({
                    type: "POST",
                    url: theUrl,
                    data: postData
                }).done( function(data) {
                    jQuery.unblockUI();
                    loadHistoricalData("PRODUCTION");
/*
                    jQuery.msgBox({
                        title: "Success!",
                        content: "Publish request submitted successfully", 
                        type: "info",
                        success: function (result) {
                            window.location.href = "/web/brand-standards/publish";
                        }
                    });
*/
                }).fail( function(jqXHR) {
                    jQuery.unblockUI();
                    jQuery.msgBox({
                        title: "Error!",
                        content: "Failed to delete submitted publish request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                        type: "error",
                        success: function (result) {
                            ;
                        }
                    });
                });
            }
        }
    });
};

/* pre-submit callback */ 
function showRequest(formData, jqForm, options)
{
    if (validateStdForm())
    {
        jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
        return true;
    }
    return false;
};

/* post-submit callback */ 
function showResponse(responseText, statusText, xhr, $form)  
{ 
    submitted = false;
    jQuery.unblockUI();
    /*alert("responseText=" + responseText + "\n statusText=" + statusText);*/
    if(responseText.indexOf("ERROR:") === 0)
    {
        jQuery.msgBox({
            title: "Error!",
            content: "Validation failed for specified IDs in the file!" ,
            type: "error",
            success: function (result) {
                jQuery("#initial_data_div").hide();
                jQuery("#confirm_data_div").hide();
                jQuery("#displ_error").text(responseText.substring(6));
                jQuery("#errorm_data_div").show();
            }
        });
    }
    else
    {
        jQuery.msgBox({
            title: "Success!",
            content: "Validation of request is successful", /*responseText ,*/
            type: "info",
            success: function (result) {
                /*jQuery("#displ_environment").text(jQuery('input:radio[name="environment"]:checked').val());*/
                jQuery("#displ_environment").text("Staging");
                jQuery("#displ_date").text(jQuery('input:radio[name="pub_schedule"]:checked').val());
                jQuery("#displ_schedule_date").text(jQuery("#dateInput").val());
                jQuery("#displ_schedule_time").text(jQuery("#timeInput").val());
                jQuery("#displ_brand").text(jQuery("select#selectBrand :selected").text());
                var locales = "";
                var nextVal = false;
                jQuery("select#selectLocale :selected").each(function() {
                    if (nextVal)
                        locales += ", ";
                    locales += this.text;
                    nextVal = true;
                });
                jQuery("#displ_locale").text(locales);
                jQuery("#displ_email").text(jQuery("#emailField").val());
                
                if(responseText && responseText.length > 80)
                {
                    jQuery(".displ_more_ids").show();
                    jQuery("#displ_id_less").text(responseText.substring(0, 80) + "... ");
                }
                else
                {
                    jQuery(".displ_more_ids").hide();
                    jQuery("#displ_id_less").text(responseText);
                }
                jQuery("#displ_id_more").text(responseText);
                jQuery("#initial_data_div").hide();
                jQuery("#confirm_data_div").show();
            }
        });
    }
};

jQuery.validator.addMethod("multiemail", function(value, element) {
        if (this.optional(element)) /* return true on optional element*/ 
            return true;
        var emails = value.split(/[;,]+/); /* split element by , and ;*/
        valid = true;
        for (var i in emails) 
        {
            value = emails[i];
            valid = valid && jQuery.validator.methods.email.call(this, $.trim(value), element);
        }
        return valid;
    },
    jQuery.validator.messages.email
);

function validateStdForm()
{	
	if (validator)
	{
		return validator.form();
	}
	else
	{
		validator = getFormValidator();
		return validator.form();
	}
};

function getFormValidator()
{
    var valdtr = jQuery("#publishAdminForm").validate({
        rules: {
            required: true,

            uploadFile: {
                required: true,
                extension: "xls|txt"
            },

            environment: {
                required: true
            },
            
            emailField: {
                required: true,
                multiemail: true
            }
            
        },
        messages: {
            emailField: 'Invalid email address'
        },
        errorPlacement: function(error, element) {
            if (element.attr("id") == "environment_stage" || element.attr("id") == "environment_prod")
            {
                error.insertAfter("#env_err_span"); 
            }
            else if (element.attr("name") == "dateInput")
            {
                error.insertAfter(".ui-datepicker-trigger");
            }
            else if (element.attr("name") == "timeInput")
            {
                error.insertAfter(".ui-timepicker-trigger"); 
            }
            else if (element.attr("id") == "selectLocale")
            {
                error.insertAfter("#locale_err_span"); 
            }
            else
            {
                error.insertAfter(element);
            }
        },
        ignore: ":hidden:not('#selectLocale')" /*Tells it to check the jqueryUI multi-select*/
    });
    return valdtr;
};

jQuery(function() {

    var url = jQuery("#publishAdminForm").attr("action");
    var options = { 
        url:           url,         /* override for form's 'action' attribute*/ 
        target:        '#output',   /* target element(s) to be updated with server response*/ 
        beforeSubmit:  showRequest,  /* pre-submit callback*/ 
        success:       showResponse, /* post-submit callback*/ 
 
        /* other available options:*/ 
        type:      'post',        /* 'get' or 'post', override for form's 'method' attribute*/ 
        dataType:  'html'        /* 'xml', 'script', or 'json' (expected server response type)*/ 
    }; 
 
    /* bind form using 'ajaxForm' */ 
    jQuery('#publishAdminForm').ajaxForm(options); 

	jQuery.datepicker.setDefaults({showOn: 'both', buttonImageOnly: true, buttonImage: '/BSTheme-theme/images/calendar_icon.png', buttonText: 'Select Date'});
	jQuery(".datepicker").datepicker({changeMonth: true, changeYear: true, dateFormat: 'dd-M-yy', minDate : 0});
	jQuery('#dateInput').datepicker();
	jQuery('#timeInput').timepicker({ 'step': 20 });

    jQuery(".multis").multiselect();
    
    validator = getFormValidator();
 
    jQuery(".publish_hist_table").tooltip();
 
    jQuery("#pub_tabs").tabs({
        activate: function(event ,ui) {
            var tabName = ui.newTab.text();
            var tabIndx = ui.newTab.index();
            if (event.originalEvent.type == "click" &&  tabIndx > 0)
            {
                var env = tabIndx == 1 ? "STAGING" : "PRODUCTION";
                loadHistoricalData(env);
            }
        }
    });
    
    jQuery("label.wrapper_label").bind('click', function (e) {
        var tagName = e.target.tagName.toLowerCase();
        if(tagName == 'label' || tagName == 'span')
        {
            return false;
        }
        else if(e.target.className == 'ui-timepicker-trigger')
        {
            jQuery("input.small_text_box").click();
            return false;
        }
        return true;
    });
    
    jQuery("input.small_text_box").bind('click', function (e) {
        e.preventDefault();
        e.stopPropagation();
    });
    
    jQuery("a.displ_more_ids").bind('click', function (e) {
        jQuery(".div_displ_id_more").show();
        jQuery(".div_displ_id_less").hide();
    });
    
    jQuery("a.displ_less_ids").bind('click', function (e) {
        jQuery(".div_displ_id_more").hide();
        jQuery(".div_displ_id_less").show();
    });
    
    jQuery("#release_rec_button").click(function() {
        jQuery.msgBox({
            title: "Are You Sure",
            content: "Are you sure you want release all locked records?", 
            type: "confirm",
            buttons: [{ value: "Yes" }, { value: "No" }],
            success: function (result) {
                if (result == "Yes") {
                    var url = jQuery("#release_rec_url").val();
                    var theUrl = url;
                    var indx = url.indexOf("&_Publish_");
                    if (indx > 0)
                    {
                        theUrl = url.substr(0, indx);
                    }
                    
                    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
                   
                    jQuery.ajax({
                        type: "POST",
                        url: theUrl 
                    }).done( function(data) {
                        jQuery.unblockUI();
                        jQuery(".locked_rec_cont_div span.locked_rec_note").text("There are no locked records");
                    }).fail( function(jqXHR) {
                        jQuery.unblockUI();
                        jQuery.msgBox({
                            title: "Error!",
                            content: "Failed to release locked records! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                            type: "error",
                            success: function (result) {
                                ;
                            }
                        });
                    });
                }
            }
        });
    });
    
    jQuery("#confirm").click(function() {
        var url = jQuery("#confirmed_url").val();
        var theUrl = url;
        var indx = url.indexOf("&_Publish_");
        if (indx > 0)
        {
            theUrl = url.substr(0, indx);
        }
        var env = "STAGING"; 
        var date = jQuery("#dateInput").val();
        var time = jQuery("#timeInput").val();
        var brand = jQuery("select#selectBrand :selected").val();
        var locales = jQuery("select#selectLocale").multiselect("getChecked").map(function(){
            return this.value;	
        }).get().toString();
        var email = jQuery("#emailField").val();
        var stdIds = jQuery("#displ_id_more").text();
        var pubSchedule = jQuery('input:radio[name="pub_schedule"]:checked').val();
        
        var postData = {pubEnv:env,pubDate:date,pubTime:time,pubSchedule:pubSchedule,pubBrand:brand,pubEmail:email,pubStdIds:stdIds,localeLst:locales};
       
        jQuery.ajax({
            type: "POST",
            url: theUrl,
            data: postData
        }).done( function(data) {
            jQuery.msgBox({
                title: "Success!",
                content: "Publish request submitted successfully", 
                type: "info",
                success: function (result) {
                    window.location.href = "/web/brand-standards/publish";
                }
            });
        }).fail( function(jqXHR) {
            jQuery.unblockUI();
            /*alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);*/
            jQuery.msgBox({
                title: "Error!",
                content: "Failed to submit publish request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                type: "error",
                success: function (result) {
                    ;
                }
            });
        });
    });
    
    jQuery("select#selectBrand").change(function(){
        localeSelected = false;
        var localeBox = jQuery("select#selectLocale");
        localeBox.empty();
        localeBox.multiselect('refresh');
    });

    jQuery("#selectLocale").bind("multiselectopen", function(event, ui){
    
        if(localeSelected)
        {
            return true;
        }
         
        jQuery("#selectLocale").multiselect("close");
        var url = jQuery("#get_locales_url").val();
        var theUrl = url;
        var indx = url.indexOf("&_Publish_");
        if (indx > 0)
        {
            theUrl = url.substr(0, indx);
        }
        var brand = jQuery("select#selectBrand :selected").val();
        if (!brand || brand.length < 1)
        {
            jQuery.msgBox("Please select Brand.");
            return false;
        }
        
        var postData = {selectBrand:brand};
        jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
       
        jQuery.ajax({
            type: "POST",
            url: theUrl,
            data: postData,
            dataType: "json"
        }).done( function(data) {
            
            jQuery.unblockUI();
            if(data.message === "SUCCESS") 
            {
                localeSelected = true;
                delete data["message"];
                var localeBox = jQuery("select#selectLocale");
                localeBox.empty();
                jQuery.each(data, function(id, item) {
                    var myItem = item;
                    if (item.value === 'en_GB')
                    {
                        var opt = new Option(item.text, item.value, true, true);
                        opt.disabled = true;
                        localeBox.append(opt);
                    }
                    else
                    {
                        localeBox.append( new Option(item.text, item.value) );
                    }
                });
                localeBox.multiselect('refresh');
                jQuery("#selectLocale").multiselect("open");
            }
            else 
            {
                localeSelected = false;
                jQuery.msgBox({
                    title: "Error!",
                    content: "Failed to fetch locales for Brand!",
                    type: "error",
                    success: function (result) {
                        ;
                    }
                });
            }
        }).fail( function(jqXHR) {
            localeSelected = false;
            jQuery.unblockUI();
            /*alert("AJAX request failed with status:" + jqXHR.statusText + " status code:" + jqXHR.status);*/
            jQuery.msgBox({
                title: "Error!",
                content: "Failed to fetch locales for Brand! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
                type: "error",
                success: function (result) {
                    ;
                }
            });
        });       
        return false;
    });
    
    jQuery(".run_reports").click(function(){
        var theReportId = jQuery(".reportsContent").children().find("input:checked").val();
        jQuery(".reports").hide();
        if(theReportId == "" || theReportId == null){
            jQuery.unblockUI();
            jQuery.msgBox("Please choose a report.");
            return false;
        }
        var theReport = jQuery(".reportsContent").children().find("input:checked");
        runReport(theReportId, publishQueueId, publishId);
        theReport.attr("checked", "");
        theReport.attr("checked", false);
        publishQueueId = 0;
        publishId = 0;
        return false;
    });
    
    jQuery(".cancel_reports").click(function(){
        publishQueueId = 0;
        publishId = 0;
        checkedValues = [];
        jQuery(".reports").hide();
        var theItem = jQuery(".reportsContent").children().find("input:checked");
        theItem.attr("checked", "");
        jQuery(theItem).attr("checked", false);
        jQuery.unblockUI();
    }); 


});


