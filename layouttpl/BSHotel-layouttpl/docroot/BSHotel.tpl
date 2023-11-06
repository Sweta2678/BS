<div class="columns-1-3 row" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
		<table class="portlet-layout row-fluid">
			<tr>
				<td colspan="3" class="span12 portlet-column portlet-column-first" id="column-1">
				 #set ($VOID = $velocityPortletPreferences.setValue('portlet-setup-show-borders', 'false'))
			        $processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
				</td>
			</tr>
			<tr>
				<td class="BSH-spn4 portlet-column portlet-column-first" id="column-2">
			        #set ($VOID = $velocityPortletPreferences.setValue('portlet-setup-show-borders', 'false'))
			        $processor.processColumn("column-2", "portlet-column-content portlet-column-content-first")
				</td>
				<td class="BSH-spn4 portlet-column" id="column-3">
					$processor.processColumn("column-3", "portlet-column-content")
				</td>
				<td class="BSH-spn4 portlet-column portlet-column-last" id="column-4">
					$processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")
				</td>
			</tr>
		</table>
	#else
		<div class="portlet-layout row-fluid">
			<div class="span12 portlet-column portlet-column-first" id="column-1">
			    #set ($VOID = $velocityPortletPreferences.setValue('portlet-setup-show-borders', 'false'))
				$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
			</div>
		</div>
		<div class="portlet-layout row-fluid">	
			<div class="BSH-spn4 portlet-column" id="column-2">
			    #set ($VOID = $velocityPortletPreferences.setValue('portlet-setup-show-borders', 'false'))
				$processor.processColumn("column-2", "portlet-column-content")
			</div>
			<div class="BSH-spn4 portlet-column" id="column-3">
				$processor.processColumn("column-3", "portlet-column-content")
			</div>
			<div class="BSH-spn4 portlet-column portlet-column-last" id="column-4">
				$processor.processColumn("column-4", "portlet-column-content portlet-column-content-last")
			</div>
		</div>
	#end
</div>