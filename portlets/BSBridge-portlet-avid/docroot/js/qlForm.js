

function getChanges()
{
	var rows = $('#dg').datagrid('getChanges');
	if(updatedRows && updatedRows.length > 0)
	{
		for(i in updatedRows)
		{
			var stdId = updatedRows[i].id;
			var addRow = true;
			for (k in rows)
			{
				if(stdId == rows[k].id)
				{
					addRow = false;
					break;
				}	
			}
			if (addRow)
			{
				rows.push(updatedRows[i]);
			}
		}
	}
	return rows;
}

function addUpdatedRow(row)
{
	if (updatedRows)
	{
		var addRow = true;
		var stdId = row.id;
		
		for(n in updatedRows)
		{
			if(stdId == updatedRows[n].id)
			{
				addRow = false;
				break;
			}
		}
		if (addRow)
		{
			updatedRows.push(row);
		}
	}
	else
	{
		updatedRows = [];
		updatedRows.push(row);
	}
	
}

function fullScreen() 
{
    var curWidth = $('#dg').datagrid('options').width;
    if (curWidth == gridWidht)
    {
        $('#dg').datagrid('options').width = $(parent.window).width() - 40; 
    }
    else
    {
        $('#dg').datagrid('options').width = gridWidht;
    }
     
    $('#dg').datagrid('resize');
}

function resizeScreen(url,ismaximize) 
{
	$.ajax({
		url: updateMessurementPreferenceURL,
		type: "POST",
		data: {flagVal:ismaximize,columnName:'isMaximize'}
	}).done(function(data) {
		if (window.location != window.parent.location) {
			window.parent.location = url;
		} else {
			window.location.href = url;
		}
	}).fail( function(jqXHR) {
		$.messager.alert('Info','Failed to save changes','error');
		/*console.log("failed with error:" + jqXHR);*/
	});
	
	
	
}

function togleColumn(selector, columnNm)
{
    var isChecked = $('#' + selector).is(':checked');
    if (isChecked)
    {
        $('#dg').datagrid('showColumn', columnNm);
    }
    else
    {
        $('#dg').datagrid('hideColumn', columnNm);
    }
	if(!",stdStatus,catgyHead,seRptCatgy,crit,seSeqNo,".includes(","+columnNm+",")){
		$.ajax({
			url: updateMessurementPreferenceURL,
			type: "POST",
			data: {flagVal:isChecked,columnName:columnNm}
		}).done(function(data) {
			
		}).fail( function(jqXHR) {
			$.messager.alert('Info','Failed to save changes','error');
			/*console.log("failed with error:" + jqXHR);*/
		});
	}	
};

function endEditing(){
	
    if (editIndex == undefined){return true}
    
    if ($('#dg').datagrid('validateRow', editIndex))
    {
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'seRptCatgy'});
        if(ed != null){
        	var seRptCatgyNm = $(ed.target).combobox('getText');
            $('#dg').datagrid('getRows')[editIndex]['seRptCatgyNm'] = seRptCatgyNm;	
        }        
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'crit'});
        if(ed != null){
	        var critNm = $(ed.target).combobox('getText');
	        $('#dg').datagrid('getRows')[editIndex]['critNm'] = critNm;
        }
                
        /* This field is required */
    	var rows = $('#dg').datagrid('getRows');
   		var row = rows[editIndex];
        if ((row!= undefined || row != null) && (row.glblMust == 'Y' && (!seRptCatgyNm || seRptCatgyNm == "0" || !critNm || critNm == "0"))){
        	$.messager.alert('Info','The SE Reporting Heading and Q Criticality must be selected.', 'info');
        	return false;
        }
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'catgyHead'});
        if(ed != null){
            var catgyHeadNm = $(ed.target).combobox('getText');
            $('#dg').datagrid('getRows')[editIndex]['catgyHeadNm'] = catgyHeadNm;
        }    
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'question'});
        if(ed != null){
	        var questionNm = $(ed.target).combobox('getText');
	        $('#dg').datagrid('getRows')[editIndex]['questionNm'] = questionNm;
        }
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'complDue'});
        if(ed != null){
	        var complDueNm = $(ed.target).combobox('getText');
	        $('#dg').datagrid('getRows')[editIndex]['complDueNm'] = complDueNm;
        }
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'copyToBrand'});
        if(ed != null){
        	var copyToBrndVal = $(ed.target).combogrid('getText');
			var copyToBrandGrid = $(ed.target).combogrid('grid');	// get datagrid object
			var copyToBrandCheckedRows = copyToBrandGrid.datagrid('getChecked');	
			var copyToBrandFieldIds = "";
			$.each(copyToBrandCheckedRows, function(index, row) {
				if(copyToBrandFieldIds.length>1){
					copyToBrandFieldIds = copyToBrandFieldIds +",";
				}
				copyToBrandFieldIds = copyToBrandFieldIds + row.id ;
			});
			$('#dg').datagrid('getRows')[editIndex]['copyToBrandQLReportID'] =copyToBrandFieldIds;
			console.log("Value from datagrid="+ $('#dg').datagrid('getRows')[editIndex]['copyToBrand']);
			$('#dg').datagrid('getRows')[editIndex]['copyToBrand'] = copyToBrndVal;
        }
        
        var ed = $('#dg').datagrid('getEditor', {index:editIndex,field:'glblMust'});
        if(ed != null){
	        var checkedVal = $(ed.target).attr('checked');
			$('#dg').datagrid('getRows')[editIndex]['glblMust'] = checkedVal == "checked" ? 'Y' : 'N'; 
        }
        
        $('#dg').datagrid('endEdit', editIndex);
        editIndex = undefined;
        return true;
    } else {
        return false;
    }
}

function searchRec()
{	
	endEditing();
	
	if($('#dg').datagrid('options').filterRules != null && $('#dg').datagrid('options').filterRules != '') {
		$('#dg').datagrid('doFilter');
    	var filterRules = $('#dg').datagrid('options').filterRules;
    	$.ajax({
    	  	url:filterMessageURL,
    	  	type: "POST",
    	  	data: {filterRules:JSON.stringify(filterRules)}
        }).done(function(data) {
        	$('#filterSelection').html(data);
        }).fail( function(jqXHR) {
            $.messager.alert('Info', 'Failed to fetch Filter Message', 'error');
        });
	} else {
		$.messager.alert('Info', 'Please select atleast one filter to perform search.', 'info');
	}
}


function cancelFilter()
{
	endEditing();
	
	if($('#dg').datagrid('options').filterRules != null && $('#dg').datagrid('options').filterRules != '') {
		$('#dg').datagrid('removeFilterRule');
		$('#dg').datagrid('addFilterRule', {
            field: 'mnlType',
            op: 'equal',
            value: '258'
        });
		$('#dg').datagrid('doFilter');
		$('#filterSelection').html('Current Filter Selection: Manual Type: Operate');
	} else {
		$.messager.alert('Info', 'No Search filters selected to clear.', 'info');
	}
}

function refreshGrid()
{
	$('#dg').datagrid('reload');
}

function handleScoringResp(jsonData, opType, updateHeader)
{
    var obj = JSON.parse(jsonData);
    var status = obj.status;
    if (status == 'SUCCESS')
    {
        $.each(obj.scores, function(key, value) {
            var id = value.id;
            var val = value.val;
            $('#' + id).text(val);
        });
        
        if (updateHeader)
        {
	        var headerCounts = obj.headerCounts;
			if (headerCounts)
			{
		        var pp = $('#scoring').accordion('getPanel', 0);
		        pp.panel('setTitle', 'To Fail Audit... ' + headerCounts);
			}
        }
    }
    else
    {
        $.messager.alert('Info','Failed to ' + opType + ' scoring','error');
    }
}

function setScoringHeader(scoringHeader)
{
    var pp = $('#scoring').accordion('getPanel', 0);
    pp.panel('setTitle', 'To Fail Audit... ' + scoringHeader); 
}

function calculateScoring()
{
    $.ajax({
        url: calcScoreURL,
        type: "POST"
    }).done(function(data) {
        handleScoringResp(data, "calculate", true);
    }).fail( function(jqXHR) {
        $.messager.alert('Info','Failed to fetch scoring','error');
        /*console.log("scoring failed with error:" + jqXHR);*/
    });
}

function isValidCategoryHeading(rows)
{
	var isValid = true;
	for (i=0; i<rows.length; i++)
	{
		if(rows[i].catgyHead == 0)
		{
			$.messager.alert('Info','Please select Category Heading','info');
			isValid = false;
			break;
		}
	}
	return isValid;
}

var exportColumn = function(title, width, index){
	this.title = title;
	this.width = width;
	this.index = index;
}

function exportStdRecords(){	
	var listOfColumns = [];
	var index = 0;     
		 
	var frozenColumns = $('#dg').datagrid('options').frozenColumns[0];		 
	$.each(frozenColumns, function(key, element) {		
		if(! element['hidden'] && element['title'].length > 0){
			listOfColumns[index] = JSON.stringify(new exportColumn(element['title'], element['width'], index));			
			index++;
			if(element['title'] == 'STD ID'){
				listOfColumns[index] = JSON.stringify(new exportColumn('PARENT STD ID', 100, index));
				index++;
			}
		}
	});	 
		
	var columns = $('#dg').datagrid('options').columns[0];			 
	$.each(columns, function(key, element) {		 
		if(! element['hidden'] && element['title'].length > 0){
			listOfColumns[index] = JSON.stringify(new exportColumn(element['title'], element['width'], index));			
			index++;
		}
	});	
	
	var exportStdRecsForm = $("form#exportStdRecordsForm");
	if($(exportStdRecsForm).length){
		$(exportStdRecsForm).children("input[type=hidden]#columnsToExport").val("["+listOfColumns+"]");
		$(exportStdRecsForm).attr("action", exportStdRecsURL);
		$(exportStdRecsForm).submit();
	}
}

function saveChanges() 
{
    if (endEditing()) 
    {
        var rows = getChanges();
    
        if (rows && rows.length > 0)
        {
        	if (!isValidCategoryHeading(rows))
        	{
        		return false;
        	}
        	
            $('#dg').datagrid('loading');
            $.ajax({
                url: saveGridURL,
                type: "POST",
                data: {changes:JSON.stringify(rows), isReSequence:reSequence}
            }).done(function(data) {
            	updatedRows = [];
                $('#dg').datagrid('loaded');
                /*if (data) {
                    console.log(data);
                }*/
                if (data == 'SUCCESS')
                {
                    $.messager.alert('Info','Changes were saved successfully','info');
                    refreshGrid();
                    calculateScoring();
                }
                else
                {
                    $.messager.alert('Info','Failed to save changes','error');
                }
            }).fail( function(jqXHR) {
                $('#dg').datagrid('loaded');
                $.messager.alert('Info','Failed to save changes','error');
                /*console.log("failed with error:" + jqXHR);*/
            });
        }
    }
}

function saveChangesOnPageChange(pageNumber, pageSize) 
{
        var rows = getChanges();

    if (rows && rows.length > 0)
    {
    	if (!isValidCategoryHeading(rows))
    	{
    		return false;
    	}

        $('#dg').datagrid('loading');
        $.ajax({
            url: saveGridURL,
            type: "POST",
            data: {changes:JSON.stringify(rows), isReSequence:reSequence}
        }).done(function(data) {
        	updatedRows = [];
            $('#dg').datagrid('loaded');
            /*if (data) {
                console.log(data);
            }*/
            if (data == 'SUCCESS')
            {
                $.messager.alert('Info','Changes were saved successfully','info', function(r){
                    $('#dg').datagrid('options').pageNumber = pageNumber || 1;
                    $('#dg').datagrid('options').pageSize = pageSize;
                    
                    var pager = $('#dg').datagrid('getPager');
                    pager.pagination('refresh', {
                        pageNumber:pageNumber,
                        pageSize:pageSize
                    });
                    $('#dg').datagrid('reload');
                    calculateScoring();
                });
            }
            else
            {
                $.messager.alert('Info','Failed to save changes','error');
            }
        }).fail( function(jqXHR) {
            $('#dg').datagrid('loaded');
            $.messager.alert('Info','Failed to save changes','error');
            /*console.log("failed with error:" + jqXHR);*/
        });
    }
}

function saveData() 
{
    var id = $('#ql_id').val();
    var stdId = $('#ql_std_id').val();
    var prntStdId = $('#ql_prnt_std_id').val();
    var publishId = $('#ql_publish_id').val();
    var stdType = $('#ql_std_type').val();
    var curIndx = $('#ql_cur_index').val();
    var glblMust = $('#ql_glblMust').is(':checked') ? 'Y' : 'N';
    var seRptCatgy = $('#seRptCatgyNm').combobox('getValue');
    var crit = $('#critNm').combobox('getValue');
    var catgyHead = $('#catgyHeadNm').combobox('getValue');
    var seSeqNo = $('#seSeqNo').numberbox('getValue');
    var question = $('#questionNm').combobox('getValue');
    var complDue = $('#complDueNm').combobox('getValue');
    
    
    if(!catgyHead || catgyHead == 0)
	{
		$.messager.alert('Info','Please select Category Heading','info');
		return false;
	}
    
    if (glblMust == 'Y' && (!seRptCatgy || seRptCatgy == 0 || !crit || crit == 0))
    {
    	$.messager.alert('Info','The SE Reporting Heading and Q Criticality must be selected.', 'info');
    	return false;
    }
    
    seRptCatgy = !seRptCatgy ? 0 : seRptCatgy;
    seSeqNo = !seSeqNo ? 0 : seSeqNo;
    crit = !crit ? 0 : crit;
  
    var rows = $('#dg').datagrid('getRows');
    var indx = parseInt(curIndx);
    
    var updatedRow = $.extend({}, rows[indx]);
    
    updatedRow.glblMust = glblMust;
    updatedRow.seRptCatgy = seRptCatgy;
    updatedRow.catgyHead = catgyHead;
    updatedRow.crit = crit;
    updatedRow.seSeqNo = seSeqNo;
    updatedRow.question = question;
    updatedRow.complDue = complDue;
        
    var updRecs = [];
    updRecs.push(updatedRow);

    if (stdType == 'STD')
    {     	
    	for (updIndex=indx+1; updIndex<rows.length; updIndex++)
    	{
    		var updRow = rows[updIndex];
    		if(prntStdId == updRow.prntStdId && updRow.stdType == 'SPEC')
    		{
    			updRow.catgyHead = catgyHead;
    			updRow.seRptCatgy = seRptCatgy;
    			updRow.seSeqNo = seSeqNo;
    			    			 
    			if (isGEMGlobalUser && updRow.glblRgn == 'Global')
    			{
    				updRow.glblMust = glblMust;
    			}
    			
				if (updRow.crit > 0)
				{
					updRow.crit = crit;
				}
				
    			updRecs.push(updRow);
    		}
    		else
    		{
    			break;
    		}
    	}
    }
    else if (isGEMGlobalUser && stdType == 'SPEC' && glblMust == 'Y')
    {	
    	
    	for (updIndex=indx-1; updIndex >=0; updIndex--)
    	{
    		var updRow = rows[updIndex];    		
    		if(prntStdId == updRow.prntStdId && updRow.stdType == 'STD')
    		{
   				updRow.glblMust = glblMust;
    			updRecs.push(updRow);
    			break;
    		}    		
    	}
    }

    $.ajax({
        url: saveGridURL,
        type: "POST",
        data: {changes:JSON.stringify(updRecs), isReSequence:reSequence}
    }).done(function(data) {
    	/*if (data) {
            console.log(data);
        }*/
        if (data == 'SUCCESS')
        {
            $.messager.alert('Info','Changes were saved successfully', 'info', function(r){
                $('#dlg').dialog('close');
            });
            refreshGrid();
            calculateScoring();
        }
        else
        {
            $.messager.alert('Info','Failed to save changes','error');
        }
    }).fail( function(jqXHR) {
        $.messager.alert('Info','Failed to save changes','error');
        /*console.log("failed with error:" + jqXHR);*/
    });
}

function updateRptCatgyNmChildRecs(newSeRptCatgy, newSeRptCatgyNm)
{
    /*var row = $('#dg').datagrid('getSelected');*/
    var rows = $('#dg').datagrid('getRows');
	var row = rows[editIndex];
    if (row.stdType == 'STD')
    {
        var prntStdId = row.prntStdId;
        /*var indx = $('#dg').datagrid('getRowIndex', row);*/
        /*var rows = $('#dg').datagrid('getRows');*/    
        var indx = editIndex;
        var updSeRptCatgy = newSeRptCatgy;
        var updSeRptCatgyNm = newSeRptCatgyNm;

        for (i=indx+1; i<rows.length; i++)
        {
            var updIndex = i;
            var updRow = rows[updIndex];
            
            if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
            {
                updRow.seRptCatgy = updSeRptCatgy;
                updRow.seRptCatgyNm = updSeRptCatgyNm;
                updRow.isChanged = 1;
                $("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-seRptCatgy").text(updSeRptCatgyNm);
                
                if (updRow.catgyHead > 0 && updRow.crit > 0 && updRow.seRptCatgy > 0) 
                {
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-stdStatus").text('Measured');
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdStatus']").css('color', '#009933');
                }
                else
                {
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-stdStatus").text('');
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdStatus']").css('color', '');
                }
                
                $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
                
                /* Keep track of changed records */
                addUpdatedRow(updRow);
            }
            else
            {
                break;
            }
        }
    }
}

function updateQCriticalityChildRecs(newCrit, newCritNm)
{                                
    /*var row = $('#dg').datagrid('getSelected');*/
    var rows = $('#dg').datagrid('getRows');
	var row = rows[editIndex];
    /* Remove values from all specifications when value on Standart was changed */
    if (row.stdType == 'STD')
    {
        var prntStdId = row.prntStdId;
        /*var indx = $('#dg').datagrid('getRowIndex', row);
        var rows = $('#dg').datagrid('getRows');*/   
        var indx = editIndex;

        for (i=indx+1; i<rows.length; i++)
        {
            var updIndex = i;
            var updRow = rows[updIndex];
            
            if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
            {
                if (updRow.crit > 0 && newCrit != updRow.crit || updRow.glblMust == 'Y')
                {
                    updRow.crit = newCrit; 
                    updRow.critNm = newCritNm; 
                    updRow.isChanged = 1;
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-crit").text(updRow.critNm);
                    $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
                    
                    if (newCrit == 0)
                    {
                        $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='crit']").css('background-color', '#FFB2CC');
                    }

                    /* Keep track of changed records */
                    addUpdatedRow(updRow);
                }
            }
            else
            {
                break;
            }
        }

    } 
}

function cancelEdit(index)
{
    if (editIndex != undefined && editIndex != index){
        endEditing();
    }
    $('#dg').datagrid('cancelEdit', index);	
}
 
$(function(){
	
	$('#toggleDisplayOptions').click(function(e){
	    e.preventDefault();
	    $('#columnSelectionDiv').toggle().toggleClass("show");
	    if ($('#columnSelectionDiv').hasClass("show")) {
	      $(e.delegateTarget).html('<span class="l-btn-left"><span class="l-btn-text">Hide Display Options</span></span>');
	    } else {
	      $(e.delegateTarget).html('<span class="l-btn-left"><span class="l-btn-text">Show Display Options</span></span>');
	    }
	});
	var pp = $('#scoring').accordion('getPanel', 0);
	if (pp){
    	pp.panel('collapse', false);
	}
	$('#scoring-table').show();
	/* GRID */
	var dg = $('#dg').datagrid({
        url: getStdRecordsURL, 
        title: 'Measurement Selection',
        width: gridWidht,
        fitColumns: false,
        singleSelect: true,
        remoteFilter: true,       
        pagination: true, 
        pageSize: 20,
        pageList: [10,20,50,100],
        toolbar: '#tb',
        rowStyler: function(index, row){
            
            var background = '';
            if (row.stdType == 'STD')
            {
                return background + 'font-weight: bold;';
            }
            else if (row.stdType == 'GDLN')
            {
                return background + 'color:#808080;'; /* gray */
            }
        },
        
        frozenColumns:[[
            {field:'id',title:'id',hidden:true},
            {field:'publishId',title:'publishId',hidden:true},
            {field:'prntStdId',title:'prntStdId',hidden:true},
            {field:'isChanged',title:'isChanged',hidden:true},
            {field:'inPublication',title:'inPublication',hidden:true},
            {field:'edit', title:'', width:25, 
            	styler: function(value, row, index){
            		if (row.stdType == 'STD' || row.stdType == 'SPEC')
	            	{
                        return {class:'row-values-edit'};
	            	}
	            }
            },
            {field:'glblMust', title:'Must', width:35,
                formatter: function (value, row) { 
                   	if (row.glblRgn == 'Global' && (row.stdType == 'STD' || row.stdType == 'SPEC') && row.duplicateInd == 'N')
                	{
                   		/*var editRow = $('#dg').datagrid('getSelected');*/
                   		var rows = $('#dg').datagrid('getRows');
    			   		var editRow = rows[editIndex];
                   		
	                    if (value == 'Y') { 
	                    	if (editRow && row.stdType == 'SPEC')
		                    {
	                    		row.isChanged = 1;
	                       		var prntStdId = row.prntStdId;
	                       		var index = $('#dg').datagrid('getRowIndex', row);
	                       		var rows = $('#dg').datagrid('getRows');

	                       		for (updIndex=index-1; updIndex>=0; updIndex--)
		                    	{
									var updRow = rows[updIndex];
									if (updRow.prntStdId == prntStdId)
									{
										if (updRow.stdType == 'STD')
										{
											updRow.glblMust = 'Y';
											$("table").find("[datagrid-row-index='" + updIndex + "'] img").attr('src', '../img/checked.jpg');
											$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
											updRow.isChanged = 1;
											addUpdatedRow(updRow);
											break;
										}
									}
									else
									{
										break;
									}
		                    	}
		                    }
	                        return '<img src="../img/checked.jpg"/>'; 
	                    } else { 
	                    	if (editRow && row.stdType == 'STD')
		                    {
	                    		row.isChanged = 1;
	                       		var prntStdId = row.prntStdId;
	                       		var index = $('#dg').datagrid('getRowIndex', row);
	                       		var rows = $('#dg').datagrid('getRows');

	                       		for (updIndex=index+1; updIndex<rows.length; updIndex++)
		                    	{
									var updRow = rows[updIndex];
									if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
									{
										if (updRow.glblMust = 'Y')
										{
											updRow.glblMust = 'N';
											$("table").find("[datagrid-row-index='" + updIndex + "'] img").attr('src', '../img/unchecked.jpg');
											$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
											updRow.isChanged = 1;
											addUpdatedRow(updRow);
										}
									}
									else
									{
										break;
									}
		                    	}
		                    }
	                        return '<img src="../img/unchecked.jpg"/>'; 
	                    } 
                	}
                },
            	editor:{
            		type:'checkbox',
	                options:{
	                	on: 'Y',
	    				off: 'N'
	                }
            	},
                styler: function(value, row, index){
	                if (row.glblRgn == 'Global' && row.stdType == 'STD')
	                {
	                	return {class:'editglbStd'};
	                }else if (row.glblRgn == 'Global' && row.stdType != 'STD'){
	                	return {class:'editglblSpecGdln'};
	                }
	                else  if (row.stdType == 'STD')
	                {
	                	return {class:'editrgnlStd'};
	                }else if (row.stdType != 'STD'){
	                	return {class:'editrgnlSpecGdln'};
	                }
                }
            },
            {field:'glblRgn', title:'Region', width:60},
            {field:'stdId', title:'STD ID', width:60, align:'right', 
            	styler: function(value, row, index) {
	                if (row.isChanged == 1)
	                {
	                    return {class:'stdid_link', style:'background-color:#FFAA50'};
	                } else if (row.stdType == 'STD' || row.stdType == 'SPEC') {
	                	return {class:'stdid_link'};
	                }
            	}
            }
        ]],               
        columns:[[
            {field:'mnlType', title:'Manual Type', width:85,hidden:(!flagChangedColumn.includes('mnlType')),
            	formatter:function(value, row){
            		if (row.mnlType == '258') {
	                    return 'Operate';                
	                } else if (row.mnlType == '257') {
	                    return 'Build';                
	                } else if (row.mnlType == '257, 258' || row.mnlType == '258, 257') {
	                    return 'Build & Operate';                
	                }
            	}
            },
            {field:'path', title:'Path', width:110, hidden:(!flagChangedColumn.includes('path'))},
            {field:'stdStatus', title:'Status', width:95, 
            	formatter:function(value, row){
	                if (row.stdStatus == 'D_FOR_REF' || row.stdStatus == 'D_NOT_RQ' || row.stdStatus == 'D_RPLCD' || row.stdStatus == 'INST_RQ')
	                {
	                    return 'Discontinued';                
	                }
	                else if (row.inPublication == 0)
	                {
	                    return 'NOT Published'; 
	                } 
	                else if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
	                {
	                	if (row.glblMust == 'N')
	                	{
	                		return 'Measured';
	                	}
	                	else
	                	{
	                		return 'Measured Global Must';
	                	}
	                }
	                else if (row.glblMust == 'Y' && row.catgyHead > 0 && (row.crit == 0 || row.seRptCatgy == 0)) 
	                {
	                	return 'Global Must';
	                }
	            },
	            styler: function(value, row, index){
	                if (row.stdStatus == 'D_FOR_REF' || row.stdStatus == 'D_NOT_RQ' || row.stdStatus == 'D_RPLCD' || row.stdStatus == 'INST_RQ' || row.inPublication == 0)
	                {
	                    return 'background-color:#FF0000;'; /* red */
	                }
	                else if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
	                {
	                    return 'color:#009933;';  /* green */
	                }
	            }
	        },
            {field:'stdType', title:'Type', width:78, hidden:(flagChangedColumn.includes('stdType')),
            	styler: function(value, row, index){
	                if (value == 'STD')
	                {
	                    return 'color:#FF0000;'; /* red */
	                }
	                else if (value == 'SPEC')
	                {
	                    return 'color:#00008B;';  /* blue */
	                }
	            },
	            formatter: function(value,row){
	                if (value == 'STD')
	                {
	                    return 'Standard';
	                }
	                else if (value == 'SPEC')
	                {
	                    return 'Specification';
	                }
	                else if (value == 'GDLN')
	                {
	                    return 'Guideline';
	                }
	            }
	        },
            {field:'title', title:'Text', width:150,hidden:(flagChangedColumn.includes('title')),
            	formatter: function(value, row, index){
            		var temp = value + '';
            		var str = temp.replace(/\"/g,'&quot;').replace(/\n/g, " ").replace(/\r/g, "");
            		return '<span title=\"' + str + '\" class=\"easyui-tooltip\">' + value + '</span>';
            	}
            },
            {field:'catgy',title:'Category',width:65,hidden:(flagChangedColumn.includes('catgy'))},
            {field:'stdOwner', title:'Standard Owner', width:130, hidden:(!flagChangedColumn.includes('stdOwner'))},
            {field:'cmply', title:'Compliance Date', width:120, align:'center',hidden:(flagChangedColumn.includes('cmply'))}, 
            {field:'copyToBrandQLReportID', title:'Copy To Brand QLReport ID', width:120, hidden:(!flagChangedColumn.includes('copyToBrandQLReportID'))},
            {field:'copyToBrand', title:'Copy To Brand', width:120, hidden:(!flagChangedColumn.includes('copyToBrand')),
            	editor:{
	                type:'combogrid',
	                options:{
	                	panelWidth:583,
	                	style:{border:'double'},
						rownumbers:true,
						multiple: true,	                    
						idField:'chainCd',
						textField:'chainCd',	                   
	                	checkOnSelect: true, 
	                	selectOnCheck: true,
	                	url:getBrandsForStdURL, 
	                	queryParams: {stdId:function(){	                	
	                		return $('#dg').datagrid('getSelected').stdId;
	                	}},	                	
	                    labelPosition: 'top',
	                	columns: [[
	                	           {field:'chkboxBrand',checkbox:true},	                	           
	                	           {field:'id',title:'Brand ID',width:50, hidden:true},
	                	           {field:'chainCd',title:'Brand',width:50},
	                	           {field:'stdStatus',title:'Status',width:70,  
	                	            	formatter:function(value, row){
	                		                if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
	                		                {		
	                		                	return 'Measured';
	                		                }
	                		            },
	                		            styler: function(value, row, index){
	                		                if (row.catgyHead > 0 && row.crit > 0 && row.seRptCatgy > 0) 
	                		                {
	                		                    return 'color:#009933;';  /* green */
	                		                }
	                		            }
	                		        },
	                	           {field:'catgyHeadNm',title:'Category Heading',width:150},
	                	           {field:'seRptCatgyNm',title:'SE Reporting Category',width:150},
	                	           {field:'critNm',title:'Q Criticality',width:100}
	                	       ]]                	
	                }
            	}
            },
            {field:'catgyHead', title:'Category Heading', width:120,
            	formatter:function(value,row){
	                return row.catgyHeadNm;
	            },
	            styler: function(value, row, index){
	                if (row.stdType == 'SPEC')
	                {
	                    return 'background-color:#EBEBEB;'; 
	                }
	                else if (value == '0' && row.stdType != 'GDLN')
	                {
	                    return 'background-color:#FFB2CC;'; 
	                }
	 				else
	                {
	                    return 'background-color:inherit;';
	                }
	            },
	            editor:{
	                type:'combobox',
	                options:{
	                    valueField:'catgyHead',
	                    textField:'catgyHeadNm',
	                    data: categoryHeading,
	                    required:true,
	    				onSelect: function(rec){
	    				    /*var row = $('#dg').datagrid('getSelected');*/
	    				    var rows = $('#dg').datagrid('getRows');
	    			   		var row = rows[editIndex];
	    				    
	    				    if (row.stdType == 'STD')
	    				    {
		    				    var prntStdId = row.prntStdId;
		    				    var indx = $('#dg').datagrid('getRowIndex', row);
		    				    var rows = $('#dg').datagrid('getRows');    
		    				    var updCatgyHead = rec.catgyHead;
								var updCatgyHeadNm = rec.catgyHeadNm;
								
		    				    for (i=indx+1; i<rows.length ; i++)
		    				    {
			    				    var updIndex = i;
									var updRow = rows[updIndex];
									
									if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
									{
										updRow.catgyHead = updCatgyHead;
										updRow.catgyHeadNm = updCatgyHeadNm;
										updRow.isChanged = 1;
				    		            $("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-catgyHead").text(updCatgyHeadNm);
				    		            
				    		            if (updRow.catgyHead > 0 && updRow.crit > 0 && updRow.seRptCatgy > 0) 
				    		            {
				    		            	$("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-stdStatus").text('Measured');
				    		            	$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdStatus']").css('color', '#009933');
				    		            }
				    		            else
				    		            {
				    		            	$("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-stdStatus").text('');
				    		            	$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdStatus']").css('color', '');
				    		            }
				    		            
				    		            $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
				    		            
				    		            /* Keep track of changed records */
				    		            addUpdatedRow(updRow);
									}
									else
									{
										break;
									}
		    				    }
	    				    }
	    				}
	                }
	            }
	        },
            {field:'seRptCatgy', title:'SE Reporting Category', width:140,
	        		formatter:function(value,row){
                        return row.seRptCatgyNm;
                    },
                    styler: function(value, row, index){
                        if (row.stdType == 'SPEC')
	                    {
	                        return 'background-color:#EBEBEB;'; 
	                    }
                    	else if (value == '0' && row.stdType != 'GDLN')
                        {
                            return 'background-color:#FFB2CC;'; 
                        }
                        else
                        {
                            return 'background-color:inherit;';
                        }
                    },
                    editor:{
                        type:'combobox',
                        options:{
                            valueField:'seRptCatgy',
                            textField:'seRptCatgyNm',
                            data: reportingCategory,
            				onSelect: function(rec){
                                updateRptCatgyNmChildRecs(rec.seRptCatgy, rec.seRptCatgyNm);
            				},
    	    				onChange: function(newValue, oldValue){
    	    				    /*var row = $('#dg').datagrid('getSelected');*/
    	    				    var rows = $('#dg').datagrid('getRows');
    	    			   		var row = rows[editIndex];
    	    				    if (!newValue && row.stdType == 'STD')
    	    				    {
    	    				    	row.seRptCatgyNm = '';
    	    				    	row.seRptCatgy = 0;
                                    var index = $('#dg').datagrid('getRowIndex', row);
                                    $($('#dg').datagrid('getEditor', {index:index,field:'seRptCatgy'}).target).combobox('setValue', '');
                                    updateRptCatgyNmChildRecs('0', '');
    	    				    }
    	    				}
                        }
                    }
            },
            {field:'crit', title:'Q Criticality', width:90, 
                    formatter:function(value, row){
                        return row.critNm;
                    },
                    styler: function(value, row, index){
                        if (value == '0' && row.stdType != 'GDLN')
                        {
                            return 'background-color:#FFB2CC;'; 
                        }
                        else
                        {
                            return 'background-color:inherit;';
                        }
                    },
                    editor:{
                        type:'combobox',
                        options:{
                            valueField:'crit',
                            textField:'critNm',
                            data: criticality,
            				onSelect: function(rec){
                                updateQCriticalityChildRecs(rec.crit, rec.critNm);
            				},
    	    				onChange: function(newValue, oldValue){
    	    				    /*var row = $('#dg').datagrid('getSelected');*/
    	    				    var rows = $('#dg').datagrid('getRows');
    	    			   		var row = rows[editIndex];
                                if (!newValue && row.stdType == 'STD')
    	    				    {
    	    				    	row.critNm = '';
    	    				    	row.crit = 0;
                                    var index = $('#dg').datagrid('getRowIndex', row);
                                    $($('#dg').datagrid('getEditor', {index:index,field:'crit'}).target).combobox('setValue', '');
                                    updateQCriticalityChildRecs('0', '');
    	    				    }
    	    				}
                        }
                    }
            },
            {field:'seSeqNo', title:'SE Sequence No', width:115, 
	            	styler: function(value, row, index){
	                    if (row.stdType == 'SPEC')
	                    {
	                        return 'background-color:#EBEBEB;'; 
	                    }
	                },
					formatter:function(value, row){
						return parseFloat((!value ? 0 : value));
			        },
			        editor:{
                		type:'numberbox',
            	    	options:{
           	    			precision:3,
           	    			onChange: function(newVal, oldVal) {
           	    				/* user clicked on row, but no chnges on numberbox yet. */
           	    				if (!oldVal)
           	    				{
           	    					return;
           	    				}
                                
                                if (!newVal)
                                {
                                    newVal = 0;
                                }
           	    				
    				    		/*var row = $('#dg').datagrid('getSelected');*/
    				    		var rows = $('#dg').datagrid('getRows');
    	    			   		var row = rows[editIndex];
		    				    if (row.stdType == 'STD') 
		    				    {
		    				    	if(oldVal && oldVal != newVal){
										reSequence = true;
		    				    		row.isChanged = 1;
			                			/* alert('reSequence-->'+reSequence+'--oldVal->'+oldVal+'--newVal->'+newVal); */
			                		}
			    				    var prntStdId = row.prntStdId;
			    				    var indx = $('#dg').datagrid('getRowIndex', row);
                                    $($('#dg').datagrid('getEditor', {index:indx,field:'seSeqNo'}).target).numberbox('setValue', newVal);
			    				    var rows = $('#dg').datagrid('getRows');    
			    				    var updSeSeqNo = newVal;
			
			    				    for (i=indx+1; i<rows.length; i++)
			    				    {
				    				    var updIndex = i;
										var updRow = rows[updIndex];
										
										if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
										{
											if (updRow.seSeqNo != updSeSeqNo)
											{
												updRow.seSeqNo = updSeSeqNo;
												updRow.isChanged = 1;
												$("table").find("[datagrid-row-index='" + updIndex + "']").find(".datagrid-cell-c1-seSeqNo").text(parseFloat((!updSeSeqNo ? 0 : updSeSeqNo)));
						    		            
	        			    		            $("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');

						    		            /* Keep track of changed records */
	        			    		            addUpdatedRow(updRow);
											}
										}
										else
										{
											break;
										}
			    				    }
		    				    }
							}
            			}
			        }
            },
            {field:'question', title:'Trigger Question', width:250,hidden:(flagChangedColumn.includes('question')),
            		formatter:function(value,row){
                        return row.questionNm;
                    },
                    styler: function(value, row, index){
                        return 'background-color:inherit;';
                    },
                    editor:{
                        type:'combobox',
                        options:{
                            valueField:'question',
                            textField:'questionNm',
                            data: questions
                        }
                    }
            },
            {field:'complDue', title:'Due Date', width:105,hidden:(flagChangedColumn.includes('complDue')), 
            	formatter:function(value,row){
                	return row.complDueNm;
            	},
                styler: function(value, row, index){
                    /*if (!isGEMGlobalUser && row.glblMust == 'Y') {
                        return 'background-color:#EBEBEB;'; 
                	} else {
                        return 'background-color:inherit;';
                    }*/
                	return 'background-color:inherit;';
                },
	            editor:{
	                type:'combobox',
	                options:{
	                    valueField:'complDue',
	                    textField:'complDueNm',
	                    data: complDue
	                }
	            }
           },
           {field:'duplicateInd', title:'Duplicate', width:105, hidden:(flagChangedColumn.includes('duplicateInd')),
           	formatter:function(value,row){
           		if (value == 'Y') {
    	            return 'Yes';                
    	        } else{
    	            return 'No';                
    	        } 
           	}
          }
        ]], 

        onClickCell: function(index, field, value){
            
            var rows = $('#dg').datagrid('getRows');    
            var row = rows[index];
            if (row)
            {
                if (row.stdType == 'GDLN')
                {
                	cancelEdit(index);
                    return;
                }
                else if (row.stdType == 'SPEC' && (field === "seRptCatgy" || field === "catgyHead" || field === "seSeqNo"))
                {
                	cancelEdit(index);
                    return;
                }
                else if (!isGEMGlobalUser && row.glblMust == 'Y' && field === "glblMust") /*(field === "glblMust" || field === "question" || field == "complDue")*/
                {
                	cancelEdit(index);
                    return;
                }
                else if (!isGEMGlobalUser && field === "glblMust")
                {
                	cancelEdit(index);
                    return;
                }
                else if( field === "copyToBrand" && row.duplicateInd == 'Y'){
					cancelEdit(index);
					 return;
				}
            }
            if(field === "stdId" && row && (row.stdType == 'STD' || row.stdType == 'SPEC'))
            {
            	$.messager.progress({title:'Please wait....', msg:'Loading data...'});
           		/** Load Data to the model window before opening */
           		$.ajax({
           		  	url:loadStdGrpCtryDetailURL,
           		  	type: "POST",
           		  	data: {stdId:row.stdId}
           	    }).done(function(data) {
           	    	$('#stdGrpCtryDtl').html(data);
           	    	$.messager.progress('close');
           	    	/** Open Model Window */
               		var position = 50 + index * 25;
                       $('#ctrydlg').dialog({
                           title: 'Group and Countries',
                           width: 560,
                           height: 340,
                           top: position,
                           closed: false,
                           cache: false,
                           modal: true,
                           buttons: [{
                               text:'Close',
                               handler:function(){
                               	$('#stdGrpCtryDtl').html("");
                               	$('#ctrydlg').dialog('close');
                               }
                           }]
                       });
           	    }).fail( function(jqXHR) {
           	    	$.messager.progress('close');
           	        $.messager.alert('Info','Failed to fetch Standard Unique Group and Country details','error');
           	    });
            } 
            else if(field === "edit")
            {
                if (row){
                	endEditing();
                    var position = 50 + index * 25;
                    $('#dlg').dialog({
                        title: 'Edit QL Standard',
                        width: 560,
                        height: 340,
                        top: position,
                        closed: false,
                        cache: false,
                        modal: true,
                        buttons: [{
                            text:'Save',
                            handler:function(){
                            	/* Regional user should not save any changes to the Global Must Specification*/
                            	if (!isGEMGlobalUser && row.glblMust == 'Y' && row.stdType == 'SPEC')
                            	{
                            		$.messager.alert('Info','There are no changes to save', 'info', function(r){
                                        $('#dlg').dialog('close');
                                    });
                            	}
                            	else
                            	{
                            		saveData();
                            	}
                            }
                        },
                        {
                            text:'Cancel',
                            handler:function(){
                                $('#dlg').dialog('close');
                            }
                        }]
                    });
                    
                   	$('#catgyHeadNm').combobox('setValue', 0);
                   	$('#seRptCatgyNm').combobox('setValue', 0);
                   	$('#critNm').combobox('setValue', 0);
                   	$('#seSeqNo').numberbox('setValue', 0.000);
                   	$('#complDueNm').combobox('setValue', 0);
                   	$('#questionNm').combobox('setValue', 0);
                   	
                    $('#fm').form('load', row);
                    $('#ftitle').html(row.stdId + ":  " + row.title);
                    $('#ql_id').val(row.id);
                    $('#ql_publish_id').val(row.publishId);
                    $('#ql_std_id').val(row.stdId);
                    $('#ql_prnt_std_id').val(row.prntStdId);
                    $('#ql_std_type').val(row.stdType);
                    $('#ql_cur_index').val(index);
                    $('#ql_glblMust').prop('checked', (row.glblMust == 'Y' ? true : false));
                    if (row.glblRgn == 'Global' && row.duplicateInd == 'N')
                    {
                    	$('.glbl_must_div').show();
                        if (!isGEMGlobalUser)
                        {
                        	$('#ql_glblMust').prop( "disabled", true );
                        }
                    }
                    else
                    {
                    	$('.glbl_must_div').hide();
                    }
                    
                    if (row.stdType == 'SPEC')
                   	{
                    	$('#catgyHeadNm').combobox('disable');
                    	$('#seRptCatgyNm').combobox('disable');
                    	$('#seSeqNo').numberbox('disable');

                    	if (!isGEMGlobalUser && row.glblMust == 'Y')
                    	{
                        	/*$('#critNm').combobox('disable');
                        	$('#complDueNm').combobox('disable');
                        	$('#questionNm').combobox('disable');*/
                    	}

                    	var prntStdId = row.prntStdId;
    				    var updCrit = row.crit;
    					var updCritNm = row.critNm;
                    	
                    	for (stdIndex=index-1; stdIndex>=0; stdIndex--)
    					{
    						var stdRow = rows[stdIndex];
    						if (stdRow.prntStdId == prntStdId)
    						{
    							if (stdRow.stdType == 'STD')
    							{
    								if (row.catgyHead == 0 && stdRow.catgyHead > 0)
    								{
        								$('#catgyHeadNm').combobox('setValue', stdRow.catgyHead);
    								}
    								
    								if (row.seRptCatgy == 0 && stdRow.seRptCatgy > 0)
    								{
        			                   	$('#seRptCatgyNm').combobox('setValue', stdRow.seRptCatgy);
    								}

    								if (row.seSeqNo == 0)
    								{
        								$('#seSeqNo').numberbox('setValue', stdRow.seSeqNo);
    								}
    								
    								var curCrit = stdRow.crit;
    								var curCritNm = stdRow.critNm;
      								var newData = [{"crit":0, "critNm":""}, {"crit":curCrit, "critNm":curCritNm}]; 
      								$('#critNm').combobox('loadData', newData);
    								
    								if (updCrit == curCrit)
    								{
    									$('#critNm').combobox('select', updCrit);
    								}
    								else
    								{
    									$('#critNm').combobox('select', 0);
    								}
    								break;
    							}
    						}
    						else
    						{
    							break;
    						}
    				    }
                   	}
                    /* Regional user can change only sequence on Global Must Standard*/
                    else if (!isGEMGlobalUser && row.glblMust == 'Y' && row.stdType == 'STD')
                	{
                		/*$('#catgyHeadNm').combobox('disable');
                    	$('#seRptCatgyNm').combobox('disable');
                    	$('#critNm').combobox('disable');
                    	$('#complDueNm').combobox('disable');
                    	$('#questionNm').combobox('disable');*/
                    	$('#seSeqNo').numberbox('enable');
                	}
                    else
                    {
                    	$('#catgyHeadNm').combobox('enable');
                    	$('#seRptCatgyNm').combobox('enable');
                       	$('#seSeqNo').numberbox('enable');

                    	$('#critNm').combobox('loadData', criticality);
                    }
                }
            }
            else if (field === "glblMust")
        	{
            	if (editIndex != index){
                    if (endEditing()){
                        $('#dg').datagrid('selectRow', index).datagrid('beginEdit', index);
                        editIndex = index;
                    } else {
                        $('#dg').datagrid('selectRow', editIndex);
                    }
                }
            	
            	if (row.glblRgn == 'Global' && row && (row.stdType == 'STD' || row.stdType == 'SPEC') && row.duplicateInd == 'N')
            	{	
	            	var ed = $('#dg').datagrid('getEditor', {index:index,field:field});

	            	if (row.stdType == 'SPEC')
	            	{
	            		$($('#dg').datagrid('getEditor', {index:index,field:'catgyHead'}).target).combobox('readonly');
	                	$($('#dg').datagrid('getEditor', {index:index,field:'seRptCatgy'}).target).combobox('readonly');
	                	$($('#dg').datagrid('getEditor', {index:index,field:'seSeqNo'}).target).numberbox('readonly');
	            	}
	            	
	            	if (isGEMGlobalUser)
            		{
	            		$("table").find("[datagrid-row-index='" + index + "']").find("[field='stdId']").css('background-color', '#FFAA50');
	            		row.isChanged = 1;
            			var prntStdId = row.prntStdId;
            			
		            	if(ed.oldHtml=='<img src="../img/unchecked.jpg">')
		            	{
		                    $(ed.target).attr('checked', true);
		                    /* If selected specification, make sure standard selected too */
		                    if (row.stdType == 'SPEC')
		                    {
		                    	for (updIndex=index-1; updIndex>=0; updIndex--)
		                    	{
									var updRow = rows[updIndex];
									if (updRow.prntStdId == prntStdId)
									{
										if (updRow.stdType == 'STD')
										{
											updRow.glblMust = 'Y';
											$("table").find("[datagrid-row-index='" + updIndex + "'] img").attr('src', '../img/checked.jpg');
											$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
											updRow.isChanged = 1;
											addUpdatedRow(updRow);
											break;
										}
									}
									else
									{
										break;
									}
		                    	}
		                    }
		                }
		            	else if(ed.oldHtml=='<img src="../img/checked.jpg">')
		                {
		                    $(ed.target).attr('checked', false);
		                    /* If unselected standard, make sure specifications unselected too */
		                    if (row.stdType == 'STD')
		                    {
		                    	for (updIndex=index+1; updIndex<rows.length; updIndex++)
		                    	{
									var updRow = rows[updIndex];
									if (updRow.prntStdId == prntStdId && updRow.stdType == 'SPEC')
									{
										if (updRow.glblMust = 'Y')
										{
											updRow.glblMust = 'N';
											$("table").find("[datagrid-row-index='" + updIndex + "'] img").attr('src', '../img/unchecked.jpg');
											$("table").find("[datagrid-row-index='" + updIndex + "']").find("[field='stdId']").css('background-color', '#FFAA50');
											updRow.isChanged = 1;
											addUpdatedRow(updRow);
										}
									}
									else
									{
										break;
									}
		                    	}
		                    }
		                }
            		}
            		else /*if (!isGEMGlobalUser && row.glblMust == 'Y')*/
            		{
		            	if(ed.oldHtml=='<img src="../img/unchecked.jpg">')
		            	{
		                    $(ed.target).attr('checked', false);
		                }
		            	else if(ed.oldHtml=='<img src="../img/checked.jpg">')
		                {
		                    $(ed.target).attr('checked', true);
		                }
            			$(ed.target).attr("disabled", true);
            		}
            	}
            	else
            	{
            		$($('#dg').datagrid('getEditor', {index:index,field:field}).target).hide();
            	}
        	}
            else if( field === "seRptCatgy" || field === "crit" ||  field === "copyToBrand" ||
                field === "catgyHead" || field === "seSeqNo" || field === "question" || 
                field === "dlgtPrim" || field === "dlgtSec" || field == "complDue")
            {
            	
                if (editIndex != index){
                    if (endEditing()){
                        $('#dg').datagrid('selectRow', index).datagrid('beginEdit', index);
                        editIndex = index;
                    } else {
                        $('#dg').datagrid('selectRow', editIndex);
                    }
                }
                
                if (row)
               	{                	
                	
                    /* Regional user can change only sequence on Global Must Standard*/
                	if (!isGEMGlobalUser && row.glblMust == 'Y' && (row.stdType == 'SPEC' || row.stdType == 'STD'))
                	{
                		$($('#dg').datagrid('getEditor', {index:index,field:'glblMust'}).target).attr("disabled", true);
                		/*$($('#dg').datagrid('getEditor', {index:index,field:'complDue'}).target).combobox('readonly');
                		$($('#dg').datagrid('getEditor', {index:index,field:'question'}).target).combobox('readonly');*/
                	}

                	if (row.stdType == 'SPEC')
                   	{
	                	$($('#dg').datagrid('getEditor', {index:index,field:'catgyHead'}).target).combobox('readonly');
	                	$($('#dg').datagrid('getEditor', {index:index,field:'seRptCatgy'}).target).combobox('readonly');
	                	$($('#dg').datagrid('getEditor', {index:index,field:'seSeqNo'}).target).numberbox('readonly'); 
	                	
	                	var prntStdId = row.prntStdId;
					    var rows = $('#dg').datagrid('getRows');    
					    var updCrit = row.crit;
						var updCritNm = row.critNm;
						
						for (stdIndex=index-1; stdIndex>=0; stdIndex--)
						{
							var stdRow = rows[stdIndex];
							if (stdRow.prntStdId == prntStdId)
							{
								if (stdRow.stdType == 'STD')
								{
									var curCrit = stdRow.crit;
									var curCritNm = stdRow.critNm;
	  								var newData = [{"crit":0, "critNm":""}, {"crit":curCrit, "critNm":curCritNm}]; 
									$($('#dg').datagrid('getEditor', {index:index,field:'crit'}).target).combobox('loadData', newData);
									
									if (updCrit == curCrit)
									{
										$($('#dg').datagrid('getEditor', {index:index,field:'crit'}).target).combobox('select', updCrit);
									}
									else
									{
										$($('#dg').datagrid('getEditor', {index:index,field:'crit'}).target).combobox('select', 0);
									}
									break;
								}
							}
							else
							{
								break;
							}
					    }
                   	}
               	}
                
                if(row.duplicateInd == 'Y'){
                	$($('#dg').datagrid('getEditor', {index:index,field:'glblMust'}).target).hide();
            	}
            }
            else
            {
                if (editIndex != undefined && editIndex != index){
                    endEditing();
                }
            }
            
        },
        onEndEdit: function(index, row, changes){
            if (changes.seRptCatgy || changes.crit || changes.catgyHead || changes.question)
            {
                row.isChanged = 1;
            }
        }
        ,
        onHeaderContextMenu: function(e, field){
            e.preventDefault();
            if (!cmenu){
                createColumnMenu();
            }
           cmenu.menu('show', {
                left:e.pageX,
                top:e.pageY
            });
        },
        onLoadSuccess: function(data){
        	/** Setting Width for hidden column filters field --- Patch Fix */
            $('td[field=mnlType]').find('span.textbox.combo').css('width', '83px');
            $('td[field=mnlType]').find('span.textbox.combo').find('input.textbox-text').css('width', '83px');
            
            $('td[field=path]').find('span.textbox.combo').css('width', '105px');
            $('td[field=path]').find('span.textbox.combo').find('input.textbox-text').css('width', '105px');
            
            $('td[field=stdOwner]').find('span.textbox.combo').css('width', '125px');
            $('td[field=stdOwner]').find('span.textbox.combo').find('input.textbox-text').css('width', '125px');
			
        }
    });
	/* END OF GRID */
	
	/* Filter on every column */
	dg.datagrid('enableFilter', [
	    {field:'edit', type:'label'},
        {field:'stdType', type:'label'},   
        {field:'copyToBrand', type:'label'},
        {
        	field:'glblMust',
        	type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'}, {value:'Y', text:'Yes'}, {value:'N', text:'No'}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'glblMust');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'glblMust',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'glblRgn',
        	type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'}, {value:'GLBL', text:'Global'}, {value:regionCode, text:regionCode}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'glblRgn');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'glblRgn',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'stdId',
            type:'textbox',
        	width:58, 
        	height:22,
        	options: {
        		onChange:function(value) {
        			if (value == ''){
	                    dg.datagrid('removeFilterRule', 'stdId');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'stdId',
	                        op: 'equal',
	                        value: value
	                    });
	                }
        		}
        	}
        },
        {
        	field:'mnlType',
        	type:'combobox',
	        options: {
	            panelHeight:'auto',
	            panelWidth:83,
	            valueField:'mnlTypeId',
                textField:'mnlTypeNm',
	            data:manualTypes,
	            onChange:function(value) {
        			if (value == ''){
	                    dg.datagrid('removeFilterRule', 'mnlType');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'mnlType',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'path',
        	type:'combobox',
            options:{
            	panelHeight:300,
	            panelWidth:250,
	            valueField:'indexId',
                textField:'indexPath',
	            data:indexpathJsonData,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'path');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'path',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'stdStatus',
        	type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'}, {value:'MEASURED', text:'Measured'}, {value:'NOT_MEASURED', text:'Not Measured'}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'stdStatus');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'stdStatus',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'title', 
	    	type:'textbox',
            width:145,
            height:22,
        	options: {
        		width:145,
                height:22,
        		onChange:function(value){
        			if (value == ''){
	                    dg.datagrid('removeFilterRule', 'title');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'title',
	                        op: 'equal',
	                        value: value
	                    });
	                }
        		}
        	}
        },
        {
        	field:'catgy',
            type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'},{value:'Foundation Framework', text:'Foundation Framework'},{value:'Brand Framework', text:'Brand Framework'},
	                  {value:'Operations Framework', text:'Operations Framework'},{value:'Build Framework', text:'Build Framework'},{value:'Regional', text:'Regional'}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'catgy');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'catgy',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'stdOwner',
            type:'combobox',
	        options:{
	            panelHeight:300,
	            panelWidth:130,
                valueField:'stdBusOwner',
                textField:'stdBusOwnerNm',
	            data:stdBusOwner,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'stdOwner');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'stdOwner',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'cmply',
        	type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'}, {value:'EXIST', text:'Exist'}, {value:'NOT_EXIST', text:'Not Exist'}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'cmply');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'cmply',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        }, 
        {
        	field:'catgyHead',
            type:'combobox',
	        options:{
	            panelHeight:300,
                valueField:'catgyHead',
                textField:'catgyHeadNm',
	            data:categoryHeading,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'catgyHead');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'catgyHead',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'seRptCatgy',
	        type:'combobox',
	        options:{
	            panelHeight:'auto',
                valueField:'seRptCatgy',
                textField:'seRptCatgyNm',
	            data:reportingCategory,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'seRptCatgy');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'seRptCatgy',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'crit',
        	type:'combobox',
	        options:{
	            panelHeight:'auto',
                valueField:'crit',
                textField:'critNm',
	            data:criticality,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'crit');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'crit',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'seSeqNo',
	        type:'numberbox',
        	width:115,
	        options:{
	        	precision:3,
	            onChange:function(value){
        			if (value == ''){
	                    dg.datagrid('removeFilterRule', 'seSeqNo');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'seSeqNo',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
        },
        {
        	field:'question',
	        type:'combobox',
	        options:{
	            panelHeight:'auto',
                valueField:'question',
                textField:'questionNm',
	            data:questions,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'question');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'question',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
	    },
	    {
	    	field:'complDue',
	        type:'combobox',
	        options:{
	            panelHeight:'auto',
                valueField:'complDue',
                textField:'complDueNm',
	            data:complDue,
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'complDue');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'complDue',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
	    },
	    {
	    	field:'duplicateInd',
	        type:'combobox',
	        options:{
	            panelHeight:'auto',
	            data:[{value:'', text:'All'}, {value:'Y', text:'Yes'}, {value:'N', text:'No'}],
	            onChange:function(value){
	                if (value == ''){
	                    dg.datagrid('removeFilterRule', 'duplicateInd');
	                } else {
	                    dg.datagrid('addFilterRule', {
	                        field: 'duplicateInd',
	                        op: 'equal',
	                        value: value
	                    });
	                }
	            }
	        }
	    }
	]);

	/* END OF: Filter on every column */
	
    
    /* get the pager of datagrid */

    var pager = $('#dg').datagrid('getPager');    
    pager.pagination({

        onSelectPage:function(pageNumber, pageSize){
            
            if (endEditing()) 
            {
                var rows = getChanges();
                if (rows && rows.length > 0)
                {
                    $.messager.confirm('Save Changes', 'Do you want to save changes?', function(r){
                        if (r){
                            saveChangesOnPageChange(pageNumber, pageSize);
                        } else {
                        	$('#dg').datagrid('rejectChanges');
                        	$('#dg').datagrid('options').pageNumber = pageNumber || 1;
                            $('#dg').datagrid('options').pageSize = pageSize;
                            
                            pager.pagination('refresh', {
                                pageNumber:pageNumber,
                                pageSize:pageSize
                            });
                            $('#dg').datagrid('reload');
                        }
                    });
                }
                else
                {
                    $('#dg').datagrid('options').pageNumber = pageNumber || 1;
                    $('#dg').datagrid('options').pageSize = pageSize;
                    
                    pager.pagination('refresh', {
                        pageNumber:pageNumber,
                        pageSize:pageSize
                    });
                    $('#dg').datagrid('reload');
                }
            }
        }
    });

    setScoringHeader(scoringHeader);
    
    $('#std-id').textbox('textbox').bind('keydown', function(e){
    	if (e.keyCode == 13) {
    		searchRec();
		} else {
    		return e;
    	}
    });
    
    /** Prepare Filter Selection Message */
    if($('#dg').datagrid('options') != null || $('#dg').datagrid('options') != '' ||
    		$('#dg').datagrid('options').filterRules == null || $('#dg').datagrid('options').filterRules == '') {
    	var selFilters = $('#dg').datagrid('options').filterRules;
    	if(selFilters == null || selFilters == ''){
	    	$('#dg').datagrid('addFilterRule', {
                field: 'mnlType',
                op: 'equal',
                value: selManualFilterId
            });
	    	if(selManualFilterId == '258'){
	    		$('#filterSelection').html('Current Filter Selection: Manual Type: Operate');
	    	} else {
	    		$('#filterSelection').html('Current Filter Selection: Manual Type: Build');
	    	}
    	}
	}
});
    
var cmenu;
function createColumnMenu(){
    cmenu = $('<div/>').appendTo('body');
    cmenu.menu({
        onClick: function(item){
            if (item.iconCls == 'icon-ok'){
                $('#dg').datagrid('hideColumn', item.name);
                cmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-empty'
                });
            } else {
                $('#dg').datagrid('showColumn', item.name);
                cmenu.menu('setIcon', {
                    target: item.target,
                    iconCls: 'icon-ok'
                });
            }
        }
    });

/*Context Menu Search Code
    var frosenFields = $('#dg').datagrid('getColumnFields', true);
    for(var i=1; i<frosenFields.length; i++){
        var field = frosenFields[i];
        if (field == 'glblRgn' || field == 'stdStatus' || field == 'path')
        {
            var col = $('#dg').datagrid('getColumnOption', field);
            cmenu.menu('appendItem', {
                text: col.title,
                name: frosenFields,
                iconCls: 'icon-ok'
            });
        }
    }
*/    

 	var fields = $('#dg').datagrid('getColumnFields');
    for(var i=0; i<fields.length; i++){
        var field = fields[i];
        var col = $('#dg').datagrid('getColumnOption', field);
        cmenu.menu('appendItem', {
            text: col.title,
            name: field,
            iconCls: 'icon-ok'
        });
    }
};

function updateMeasurementQty(measurementId){
	var multiplierQty = $('#mgtQty_'+measurementId).val();
	var oldValue = $('#mgtQty_'+measurementId).attr('oldValue');
	if(isNaN(multiplierQty) == false && multiplierQty > 0 && multiplierQty != oldValue){
		$('#mgtQty_'+measurementId).attr('oldValue', multiplierQty);
		$.ajax({
		  	url: updateMultiplierQtyURL,
		  	type: "POST",
		  	data: {measurementId:measurementId,multiplierQty:multiplierQty}
		});
		calculateScoring();
	}
}

function calculateScorePercent(bucketId){
	var scorePctQtyId = bucketId+'_scorePctQty';
	var importantQty = parseInt($('#input_nonCmplQty_'+bucketId+'_Important').val(), 0);
	var criticalQty = parseInt($('#input_nonCmplQty_'+bucketId+'_Critical').val(), 0);
	var autoFailQty = parseInt($('#input_nonCmplQty_'+bucketId+'_AutoFail').val(), 0);
	
	var importantSeverityId = $('#input_nonCmplQty_'+bucketId+'_Important').attr('severityId');
	var criticalSeverityId = $('#input_nonCmplQty_'+bucketId+'_Critical').attr('severityId');
	var autoFailSeverityId = $('#input_nonCmplQty_'+bucketId+'_AutoFail').attr('severityId');
	
	var importantVal = $('#'+bucketId+'_'+importantSeverityId+'_netQty').text().trim();
	var criticalVal = $('#'+bucketId+'_'+criticalSeverityId+'_netQty').text().trim();
	var autoFailVal = $('#'+bucketId+'_'+autoFailSeverityId+'_netQty').text().trim();
	
	/* alert(scorePctQtyId+'--'+importantQty+'--'+criticalQty+'--'+autoFailQty
			+'<==>'+bucketId+'--'+importantSeverityId+'--'+criticalSeverityId+'--'+autoFailSeverityId
			+'<==>'+importantVal+'--'+criticalVal+'--'+autoFailVal); */
	
	if((importantQty < 0) || (importantQty > importantVal)) {
		$.messager.alert('Info', 'Value cannot be less than 0 and greater than Net QuantityValue ', 'error');
		$('#input_nonCmplQty_'+bucketId+'_Important').val(0);
	} else if((criticalQty < 0) || (criticalQty > criticalVal)) {
		$.messager.alert('Info', 'Value cannot be less than 0 and greater than Net Quantity', 'error');
		$('#input_nonCmplQty_'+bucketId+'_Critical').val(0);
	} else if((autoFailQty < 0) || (autoFailQty > autoFailVal)) {
		$.messager.alert('Info', 'Value cannot be less than 0 and greater than Net Quantity', 'error');
		$('#input_nonCmplQty_'+bucketId+'_AutoFail').val(0);
	} else {
		$.ajax({
		  	url :calcScorePercentURL,
		  	type: "POST",
		  	data: {scorePctQtyId:scorePctQtyId,bucketId:bucketId,importantQty:importantQty,criticalQty:criticalQty,autoFailQty:autoFailQty}
	    }).done(function(data) {
	        handleScoringResp(data, "calculate", false);
	    }).fail( function(jqXHR) {
	        $.messager.alert('Info','Failed to fetch scoring percentage','error');
	        /*console.log("scoring percentage failed with error:" + jqXHR);*/
	    });
	}
}