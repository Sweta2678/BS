
var amerOptions = [['ARG','Argentina'], ['ABW','Aruba'], ['BOL','Bolivia'], ['BRA','Brazil'], ['CAN','Canada'], ['CHL','Chile'], ['COL','Colombia'], ['CRI','Costa Rica'], ['DOM','Dominican Republic'], ['ECU','Ecuador'], ['SLV','El Salvador'], ['GTM','Guatemala'], ['HND','Honduras'], ['JAM','Jamaica'], ['MEX','Mexico'], ['NIC','Nicaragua'], ['PAN','Panama'], ['PRY','Paraguay'], ['PER','Peru'], ['PRI','Puerto Rico'], ['TTO','Trinidad And Tobago'], ['USA','United States'], ['URY','Uruguay'], ['VEN','Venezuela']];
var euOptions = [['AND','Andora'], ['AUT','Austria'], ['AZE','Azerbiajan'], ['BLR','Belarus'], ['BEL','Belgium'], ['BGR','Bulgaria'], ['CYP','Cyprus'], ['CZE','Czech Rrpublic'], ['DNK','Denmark'], ['FIN','Finland'], ['FRA','France'], ['GEO','Georgia'], ['DEU','Germany'], ['GRC','Greece'], ['HUN','Hungary'], ['IRL','Ireland'], ['ISR','Israel'], ['ITA','Italy'], ['KAZ','Kazakstan'], ['LTU','Lithuania'], ['MKD','Macedonia, Republic Of'], ['MLT','Malta'], ['MAR','Morocco'], ['NLD','Netherlands (Holland)'], ['POL','Poland'], ['PRT','Portugal'], ['ROU','Romania'], ['RUS','Russia'], ['SCG','Serbia'], ['SVK','Slovakia'], ['ESP','Spain'], ['CHE','Switzerland'], ['TUR','Turkey'], ['UKR','Ukraine'], ['GBR','United Kingdom'], ['UZB','Uzbekistan']];
var ameaOptions = [['AUS','Australia'],  ['BHR','Bahrain'],  ['KHM','Cambodia'],  ['EGY','Egypt'],  ['FJI','Fiji Islands'],  ['PYF','French Polynesia/Tahiti'],  ['GHA','Ghana'],  ['IND','India'],  ['IDN','Indonesia'],  ['JPN','Japan'],  ['JOR','Jordan'],  ['KEN','Kenya'],  ['KOR','Korea, Republic Of'],  ['KWT','Kuwait'],  ['LBN','Lebanon'],  ['LBY','Libyan Arab Jamahiriya'],  ['MYS','Malaysia'],  ['MDV','Maldives'],  ['MUS','Mauritius'],  ['NPL','Nepal'],  ['NZL','New Zealand'],  ['OMN','Oman'],  ['PSE','Palestine Authority'],  ['PNG','Papua New Guinea'],  ['PHL','Philippines'],  ['QAT','Qatar'],  ['SAU','Saudi Arabia'],  ['SGP','Singapore'],  ['ZAF','South Africa'],  ['TZA','Tanzania'],  ['THA','Thailand'],  ['ARE','United Arab Emirates'],  ['VUT','Vanuatu'],  ['VNM','Vietnam'],  ['ZMB','Zambia'],  ['ZWE','Zimbabwe']];
var gcOptions = [['CHN','China Mainland '], ['HKG','Hong Kong'], ['MAC','Macau'],['TWN', 'Taiwan']];

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

function processValidCountries(validCntries)
{
	ameaOptions = processRemoval(ameaOptions, validCntries);
	amerOptions = processRemoval(amerOptions, validCntries);
	euOptions = processRemoval(euOptions, validCntries);
	gcOptions = processRemoval(gcOptions, validCntries);
}
function processRemoval(cntArray, validCntries)
{
	for (var i = cntArray.length-1; i >= 0; i--) {
		bFound = false;
		for (var j = 0; j < validCntries.length; j++) {
			if(cntArray[i][0]==validCntries[j]) {
				bFound = true;
				break;
			}
		}
		if(!bFound) {
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
    	  jQuery('#select-from').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
          jQuery(this).remove();
          checkCountry();
		  totalElemes --;
		  if(totalElemes==0)
		  {
			showFilterCount();
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
          jQuery('#select-from').append("<option value='"+jQuery(this).val()+"'>"+jQuery(this).text()+"</option>");
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
			/* TODO Vipul, Dont populate already selected countries.*/
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
		jQuery(this).attr("selected","selected");
	});
}