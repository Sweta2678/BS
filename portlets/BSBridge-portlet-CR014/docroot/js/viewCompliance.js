var validator;
var lastSelectedFilterBy;

function validateComplianceForm()
{   
    if (validator)
    {
        return validator.form();
    }
    else
    {
        validator = getComplianceFormValidator("#formCompliance");
        return validator.form();
    }
};

function validDateRange()
{
    var from = $("#dateInputFrom").datepicker("getDate");
    var to = $("#dateInputTo").datepicker("getDate");
    if (from && to)
    {
        if (from > to)
        {
            return false;
        }
    }
    else if (from && !to || !from && to)
    {
        return false;
    }
    return true;
}

$.validator.addMethod("validateById", function(value, element) {

    var selDate = $("select#selectDate").val();
    if (selDate === "between" && !validDateRange())
    {
        return false;
    }
    
    var stdId = $("#searchById").val();
    if (!stdId && !selDate)
    {
        return false;
    }
    
    return true;
});


function getComplianceFormValidator(formSelector)
{
    var valdtr = $(formSelector).validate({
        rules: {
            searchById: {
                validateById: true
            }
        },
        messages: {
            searchById: 'Please select Filter By or specify Standard Id.'
        },
        errorPlacement: function(error, element) {
            if (element.attr("name") == "selectDate" || element.attr("name") == "searchById")
            {
                var from = $("#dateInputFrom").datepicker("getDate");
                var to = $("#dateInputTo").datepicker("getDate");
                if (from && to)
                {
                    if (from > to)
                    {
                        error.text("From Date should be less then or equal to To Date.");
                        error.html("From Date should be less then or equal to To Date.")
                    }
                }
                else
                {
                    error.text("Please select Filter By or specify Standard Id.");
                    error.html("Please select Filter By or specify Standard Id.")
                }
                
                error.insertAfter("#error-placeholder"); 
            }
        }
    });
    return valdtr;
}

function executeSearch()
{
    if (validateComplianceForm())
    {
        jQuery('#formCompliance').submit();
    }
}

$(function() {

    validator = getComplianceFormValidator("#formCompliance");

    $("#dateInputFrom").datepicker({
        changeMonth: true, 
        changeYear: true, 
        dateFormat: 'dd M yy',
        showOn: 'both',
        buttonImage: "/BSBridge-theme/images/cal-icon.png",
        buttonImageOnly: true,
        buttonText: "Select date",
        onSelect: function (selectedDate, inst) {
            var to = $("#dateInputTo").datepicker("getDate");
            if (inst && to)
            {
                executeSearch();
            }
        }
    });

    $("#dateInputTo").datepicker({
        minDate: 0,
        changeMonth: true, 
        changeYear: true, 
        dateFormat: 'dd M yy',
        showOn: 'both',
        buttonImage: "/BSBridge-theme/images/cal-icon.png",
        buttonImageOnly: true,
        buttonText: "Select date",
        onSelect: function (selectedDate, inst) {
            var from = $("#dateInputFrom").datepicker("getDate");
            if (from && inst)
            {
                executeSearch();
            }
        }
    });
    
    lastSelectedFilterBy = $("select#selectDate :selected").val();
    togleSelectDates(lastSelectedFilterBy);
    
    $("#selectDate").change(function() {
        togleSelectDates($("select#selectDate :selected").val());
    });
    
    function togleSelectDates(selected)
    {
        if (selected === "between")
        {
            //$("#selectDatesDiv").show();
            $("#selectDatesDiv").css("display", "inline-block");
        }
        else
        {
            $("#selectDatesDiv").hide();
            $("#dateInputFrom").datepicker("setDate" , null);
            $("#dateInputTo").datepicker("setDate" , null);
            if (lastSelectedFilterBy != selected)
            {
                if (!selected)
                {
                    window.location.href = location.pathname;
                }
                else
                {
                    executeSearch();
                }
            }
        }
        lastSelectedFilterBy = selected;
    };
    
    $("#clearBtn").click(function() {
        $("select#selectDate :selected").prop("selected", false);
        $("select#selectDate option[0]").prop("selected", true);
        togleSelectDates($("select#selectDate :selected").val());
        
        $("#dateInputFrom").datepicker("setDate" , null);
        $("#dateInputTo").datepicker("setDate" , null);
        $("#searchById").val("");
        
        $(".error-div > label.error").remove();
        
        if (searchPerformed)
        {
            window.location.href = location.pathname;
        }
    });
    
    $("#findBtn").click(function() {
        if (validateComplianceForm())
        {
            jQuery('#formCompliance').submit();
        }
    });
    
    jQuery("#searchById").bind('paste', function () {
        var element = this;
        setTimeout(function () {
            var newVal = jQuery(element).val().replace(/[^0-9 ]+/g, '').trim();
            newVal = newVal.replace(/\s{2,}/g, ' ').trim();
            jQuery(element).val(newVal);
            showFilterCount();
        }, 200);
    });

    jQuery("#searchById").keydown(function(event) {
        /* Allow: escape, backspace, delete, tab, */ 
        if ( event.keyCode == 27 || event.keyCode == 46 || event.keyCode == 8 || event.keyCode == 9 || 
             /* Allow: space,           enter,                        home, end, left, right                  Ctrl */
             event.keyCode == 32 || event.keyCode == 13 || (event.keyCode >= 35 && event.keyCode <= 40) || event.ctrlKey )
        {
            return;
        }
        else 
        {
            /* Ensure that it is a number and stop the keypress */
            if (event.shiftKey || (event.keyCode < 48 || event.keyCode > 57) && (event.keyCode < 96 || event.keyCode > 105 )) 
            {
                event.preventDefault(); 
            }   
        }
    });
    
    /* Perform search on enter when focus on "Find By Id" field. */
    jQuery("div.btns-div").keypress(function (e) {
        if (e.which == 13) {
            if (validateComplianceForm())
            {
                jQuery('#formCompliance').submit();
            }
            return false;
        }
    });
    
    
    /*export dialog */
    $("#exportReport").dialog({
        autoOpen: false,
        width: 560,
         modal: true,
        open: function() {
            jQuery('.ui-widget-overlay').bind('click', function() {
                jQuery('#exportReport').dialog('close');
            })
        }
    });
    
    $(".exportCancel").click(function() {
        $("#exportReport").dialog("close");
    });
    
    $(".export-report").click(function() {
        $("#exportReport").dialog("open");
        $('#reportTitle').val('');
    });
});

function createExportReport(url, reportId)
{
    var reportTitle = jQuery("#reportTitle").val();
    var postData = {reportId:reportId,reportTitle:reportTitle};
    jQuery.blockUI({ message: '<h3><img src="/BSTheme-theme/images/busy.gif" /> Please wait...</h3>' });
    
    jQuery.ajax({
        type: "POST",
        url: url,
        data: postData
    }).done( function(data) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Success!",
            content: "An email with a link to your Report will be sent to you once the Report has been generated.", 
            type: "info",
            buttons: [{ value: "OK" }],
            success: function (result) {
                $("#exportReport").dialog("close");
            }
        });
    }).fail( function(jqXHR) {
        jQuery.unblockUI();
        jQuery.msgBox({
            title: "Error!",
            content: "Failed submit request! Failure status:" + jqXHR.statusText + " status code:" + jqXHR.status ,
            type: "error",
            success: function (result) {
                ;
            }
        });
    });
};


