<%@page import="com.ihg.brandstandards.util.BrandStandardsUtil"%>
<%@page import="java.util.Map"%>
<%@page import="java.util.HashMap"%>
<%@page import="java.util.Iterator"%>

<script language="JavaScript">

var allCountriesCount = <%=BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_AMER).size() + 
                           BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_EUROPE).size() +
                           BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_AMEA).size() +
                           BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_GC).size()%>;

var amerOptions = [<% int iCountryCount = 0;
					Map<String, String> countries = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_AMER);  
                   for(String cntrCode : countries.keySet())	{
                	 iCountryCount ++;
                	%>['<%=cntrCode%>','<%=countries.get(cntrCode)%>']
                	<% if(iCountryCount != countries.size()) { %>,
					<% }
                	}	%>                	
					];
var euOptions = [<% iCountryCount = 0;
					countries = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_EUROPE);  
					for(String cntrCode : countries.keySet())	{
   						iCountryCount ++;
					%>['<%=cntrCode%>','<%=countries.get(cntrCode)%>']
					<% if(iCountryCount != countries.size()) { %>,
					<% }
					}	%>                	
				];
var ameaOptions = [<% iCountryCount = 0;
					countries = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_AMEA);  
					for(String cntrCode : countries.keySet())	{
					iCountryCount ++;
					%>['<%=cntrCode%>','<%=countries.get(cntrCode)%>']
					<% if(iCountryCount != countries.size()) { %>,
					<% }
					}	%>                	
				];				
var gcOptions = [<% iCountryCount = 0;
					countries = BrandStandardsUtil.getCountries().get(BrandStandardsUtil.REGION_GC);  
					for(String cntrCode : countries.keySet())	{
					iCountryCount ++;
					%>['<%=cntrCode%>','<%=countries.get(cntrCode)%>']
					<% if(iCountryCount != countries.size()) { %>,
					<% }
					}	%>                	
				];
/* for finding country based on region.*/				
var performCountryEvent = false;		

function regionsObj(region_name, region_code, countriesList)
{
	this.region_nm = region_name;
	this.region_cd = region_code;
	this.countries = countriesList;
}

var regions = new Array();
regions.push(new regionsObj("AMEA", "AMEA", ameaOptions));
regions.push(new regionsObj("Americas", "AMER", amerOptions));
regions.push(new regionsObj("Europe", "EURO", euOptions));
regions.push(new regionsObj("Greater China", "GC", gcOptions));
var allCountriesCnt = <%=BrandStandardsUtil.getAllCountriesCount()%>;
function getCountryByCode(cntr_cd)
{

	for (var i = 0; i < ameaOptions.length; i++) {
		if(ameaOptions[i][0]==cntr_cd)
		{
			return ameaOptions[i][1];
		}
	}
	for (var i = 0; i < amerOptions.length; i++) {
		if(amerOptions[i][0]==cntr_cd)
		{
			return amerOptions[i][1];
		}
	}
	for (var i = 0; i < euOptions.length; i++) {
		if(euOptions[i][0]==cntr_cd)
		{
			return euOptions[i][1];
		}
	}
	for (var i = 0; i < gcOptions.length; i++) {
		if(gcOptions[i][0]==cntr_cd)
		{
			return gcOptions[i][1];
		}
	}
	return "";

}

function processSelectedCountries(validCntries, isRemove)
{
	for (iReg=0;iReg<regions.length;iReg++){
		if(regions[iReg].region_cd == "AMEA") {	
    		processValidCountries(ameaOptions, validCntries, isRemove);
		} else if(regions[iReg].region_cd == "AMER") {
    		processValidCountries(amerOptions, validCntries, isRemove);
		} else if(regions[iReg].region_cd == "EURO") {
    		processValidCountries(euOptions, validCntries, isRemove);
		} else if(regions[iReg].region_cd == "GC") {
    		processValidCountries(gcOptions, validCntries, isRemove);
		}
	}
}
function processValidCountries(cntArray, validCntries, isRemove)
{
	for (var i = cntArray.length-1; i >= 0; i--) {
		bFound = false;
		for (var j = 0; j < validCntries.length; j++) {
			if(cntArray[i][0]==validCntries[j]) {
				if(!isRemove) {
	    			jQuery('#selectedcountries').append("<option value='"+ cntArray[i][0] +"' selected='selected'>"+ cntArray[i][1] +"</option>");
				}
	    		bFound = true;
	    		break;
			}
		}
		if(!bFound && isRemove)
		{
			 cntArray.splice(i, 1);
		}
	}
	return cntArray;
}

jQuery(function() {


	function checkCountry(){
		var countryItem = jQuery("#selectedcountries").children().val();
		if(countryItem == null || countryItem == ""){
			jQuery("#selectedcountries").addClass("required");
		}else{
			jQuery("#selectedcountries").removeClass("required");
			return true;
		}

	}  

	  

     jQuery('#btn-add').click(function(){
	  elems = jQuery('#select-from option:selected');
	  var totalElemes = elems.length;
      jQuery('#select-from option:selected').each( function() {
    	  isCntrAdded = true;
    	  jQuery('#selectedcountries').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
    	  jQuery(this).remove();
    	  checkCountry();
		  totalElemes --;
		  if(totalElemes==0)
		  {
			showFilterCount();
		  }
      });


  });

  jQuery('#btn-remove').click(function(){
	  var elems = jQuery('#selectedcountries option:selected');
	  var totalElemes = elems.length;
      jQuery('#selectedcountries option:selected').each( function() {
    	 if (!isLastCountryForImgFileLink(jQuery(this).val()))
   		 {
	    	  jQuery('#select-from').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
	          jQuery(this).remove();
	          checkCountry();
			  totalElemes --;
			  if(totalElemes==0)
			  {
				showFilterCount();
			  }
			  /*Update Region and country for ext link, assign images, supporting material*/
			  if (performCountryEvent )
			  {
				  var countryCode = jQuery(this).val();
				  var countryName = jQuery(this).text();
				  updateRegionCountryFromImgFileLink(countryCode, countryName);
			  }
   		 }
    	 else
   		 {
    		 jQuery.msgBox({
                 title:"Info",
                 content:"You can't remove " +jQuery(this).text() +", this may empty one or many entry from Images/ Attachments/ Links",
                 type:"info"
             });
   		 }
      });

  });

	

	jQuery("#add_all_countries").click(function(){
		
		jQuery("#select-from option").each(function(){
			jQuery(this).attr("selected","selected");
		});
		var elems = jQuery('#select-from option:selected');
		var totalElemes = elems.length;
		jQuery('#select-from option:selected').each( function() {
			isCntrAdded = true;
			jQuery('#selectedcountries').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
			jQuery(this).remove();
			checkCountry();
			totalElemes --;
			if(totalElemes==0)
			{
				showFilterCount();
			}
		});

		return false;
	});

	

	jQuery('#remove_all_countries').click(function(){

		jQuery("#selectedcountries option").each(function(){
			jQuery(this).attr("selected","selected");
		});

      var elems = jQuery('#selectedcountries option:selected');
	  var totalElemes = elems.length;
	  jQuery('#selectedcountries option:selected').each( function() {
		  if (!isLastCountryForImgFileLink(jQuery(this).val()))
   		  {
	          jQuery('#select-from').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
	          jQuery(this).remove();
			  checkCountry();
			  totalElemes --;
			  if(totalElemes==0)
			  {
				showFilterCount();
			  }
			  
			  /*Update Region and country for ext link, assign images, supporting material*/
			  if (performCountryEvent )
			  {
				  var countryCode = jQuery(this).val();
				  var countryName = jQuery(this).text();
				  updateRegionCountryFromImgFileLink(countryCode, countryName);
			  }
   		}
	   	else
  		{
	   		 jQuery.msgBox({
	                title:"Info",
	                content:"You can't remove " +jQuery(this).text() +", this may empty one or many entry from Images/ Attachments/ Links",
	                type:"info"
	            });
	  	}
      });

		return false;

	});
	
	
	
	var totalCountries = [];

	jQuery("#standard_regions").change(function(){

		totalCountries = [];
		jQuery("#standard_regions option:selected").each(function () {

			var thisId = jQuery(this).val();
			for (iReg=0;iReg<regions.length;iReg++){
				if(thisId == regions[iReg].region_cd)
				{
					totalCountries = totalCountries.concat(regions[iReg].countries);
				}
			}

		});	

		/*first clear the box*/
		jQuery('#select-from option').remove();

		/*fill the selection box with countries associated to selected region*/
		for (var i = 0; i < totalCountries.length; i++) {
			found = false;
			jQuery("#selectedcountries option").each(function(){
				if(!found && jQuery(this).val()==totalCountries[i][0])
				{
					found = true;
				}
			});
			if(!found) {
				jQuery('#select-from').append("<option value='"+ totalCountries[i][0] +"'>"+ totalCountries[i][1] +"</option>");
			}
		}
	});

});

function selectAllToSubmit()
{
	jQuery("#selectedcountries option").each(function(){
		this.selected = true;
		if(!jQuery(this).attr("selected"))
        {
			jQuery(this).attr("selected","selected");
        }
	});
}

function getRegionByCountryCode(cntr_cd)
{
    for (iReg=0;iReg<regions.length;iReg++)
    {
       for(iCountry=0; iCountry <regions[iReg].countries.length; iCountry++)
    	{
    		if(cntr_cd==regions[iReg].countries[iCountry][0])
        	{
    			/*alert("regon" + regions[iReg].region_cd);*/
        	    return regions[iReg];
        	}
    	}
    }
    return regions[0];
}


</script>