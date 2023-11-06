<div class="grs" id="main-content" role="main">
	#if ($browserSniffer.isIe($request) && $browserSniffer.getMajorVersion($request) < 8)
		<table class="portlet-layout">
		<tr>
			<td class="portlet-column portlet-column-first" id="column-1">
				<div class="col-70">
						$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
				</div>		
			</td>
			<td class="portlet-column portlet-column-last" id="column-2">
				<div class="col-30">
					$processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
				</div>	
			</td>
		</tr>
		</table>
	#else
		<div class="portlet-layout">
			<div class="portlet-column portlet-column-first" id="column-1">
			  <div class="col-70">
    				<div class="sub-leftcol">
						$processor.processColumn("column-1", "portlet-column-content portlet-column-content-first")
					</div>
				</div>			
			</div>

			<div class="portlet-column portlet-column-last" id="column-2">
				<div class="col-30">
					$processor.processColumn("column-2", "portlet-column-content portlet-column-content-last")
				</div>	
			</div>
		</div>
	#end
</div>