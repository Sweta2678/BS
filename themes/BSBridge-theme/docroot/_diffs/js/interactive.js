var searchInput = "";//sessionStorage.getItem('search');
var months = [ "Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec" ];

$(document).ready(function () {


$('a[href="#collapseSupportingOne"]').on('click', function (e) {

$('a[href="#collapseSupportingTwo"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingThree"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingFour"] img').attr("src", "img/chevron-right.png");
//code for image toggle
	var $image = $(this).children("img");	
	if (($image.attr("src") == "img/chevron-right.png")&&($('a[href="#collapseSupportingOne"]')))
	{
	   $image.attr("src", "img/chevron-down.png");
	   }
	else{
	   $image.attr("src", "img/chevron-right.png");
	  }
 });
$('a[href="#collapseSupportingTwo"]').on('click', function (e) {

$('a[href="#collapseSupportingOne"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingThree"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingFour"] img').attr("src", "img/chevron-right.png");

//code for image toggle
	var $image = $(this).children("img");	
	if ($image.attr("src") == "img/chevron-right.png")
	{
	   $image.attr("src", "img/chevron-down.png");
	   }
	else{
	   $image.attr("src", "img/chevron-right.png");
	  }
 });
 
 $('a[href="#collapseSupportingThree"]').on('click', function (e) {
$('a[href="#collapseSupportingTwo"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingOne"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingFour"] img').attr("src", "img/chevron-right.png");

//code for image toggle
	var $image = $(this).children("img");	
	if ($image.attr("src") == "img/chevron-right.png")
	{
	   $image.attr("src", "img/chevron-down.png");
	   }
	else{
	   $image.attr("src", "img/chevron-right.png");
	  }
 });
 $('a[href="#collapseSupportingFour"]').on('click', function (e) {
$('a[href="#collapseSupportingTwo"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingThree"] img').attr("src", "img/chevron-right.png");
$('a[href="#collapseSupportingOne"] img').attr("src", "img/chevron-right.png");

//code for image toggle
	var $image = $(this).children("img");	
	if ($image.attr("src") == "img/chevron-right.png")
	{
	   $image.attr("src", "img/chevron-down.png");
	   }
	else{
	   $image.attr("src", "img/chevron-right.png");
	  }
  });



  /*
  $('a[href="#collapseSupportingOne"]').on('click', function (e) {
    var $target = $(event.target);
    flipChev(1, 'down');
    flipChev(2, 'right');
    flipChev(3, 'right');
    flipChev(4, 'right');
  });
  
  $('a[href="#collapseSupportingTwo"]').on('click', function (e) {
    flipChev(1, 'right');
    flipChev(2, 'down');
    flipChev(3, 'right');
    flipChev(4, 'right');
  });

  $('a[href="#collapseSupportingThree"]').on('click', function (e) {
    flipChev(1, 'right');
    flipChev(2, 'right');
    flipChev(3, 'down');
    flipChev(4, 'right');
  });

  $('a[href="#collapseSupportingFour"]').on('click', function (e) {
    flipChev(1, 'right');
    flipChev(2, 'right');
    flipChev(3, 'right');
    flipChev(4, 'down');
  });
*/



$('body').on('click', '.imageModalTrigger', function (e) {
  console.log(e.currentTarget);
  var imgs = $(e.currentTarget).data('images');
  if (imgs.indexOf(',') != -1) {
    imgs = imgs.split(',');
  } else {
    imgs = [imgs];
  }
  var out = '';
  for(var i=0; i<imgs.length; i++) {
    out += '<img src="'+imgs[i]+'"><br>';
  }
  $('#imageHolder').html(out);
 // $('#imageModal').modal();
});


//if (!myData) return;

var output = "";

var searchData = doSearch(searchInput);


var hotelDeptNum = "";//sessionStorage.getItem('hotelDeptGroup');
var hotelLocNum = "";//sessionStorage.getItem('hotelLocationGroup');
var guestJourneyNum = "";//sessionStorage.getItem('guestJourneyGroup');
var compliance = "";//sessionStorage.getItem('complianceGroup');
var supportingMaterialNum = "";//sessionStorage.getItem('supportingMaterialGroup');

var infoBarTxt = ''; 
var bSearch = ((searchInput && searchInput != '') ? true : false);
var bDept   = ((hotelDeptNum && hotelDeptNum > 0) ? true : false);
var bLoc    = ((hotelLocNum && hotelLocNum > 0) ? true : false);
var bGJS    = ((guestJourneyNum && guestJourneyNum > 0) ? true : false);
var bComp   = ((compliance && compliance != '') ? true : false);
var bSupp   = ((supportingMaterialNum && supportingMaterialNum > 0) ? true : false);

var filters = new Array();
if (bDept) filters.push(new Filter('Hotel Department', hotelDeptNum, ''));
if (bLoc)  filters.push(new Filter('Hotel Location', hotelLocNum, ''));
if (bGJS)  filters.push(new Filter('Guest Journey Stage', guestJourneyNum, ''));
if (bSupp) filters.push(new Filter('Supporting Material', supportingMaterialNum, ''));
if (bComp) filters.push(new Filter('Compliance', 1, compliance));
/*
if (bSearch) {
  infoBarTxt = 'Your search for "'+searchInput+'"';
} else {
  infoBarTxt = 'Your search';
}

if (filters.length == 0)
  infoBarTxt += ' returned <strong>' + countItems(searchData) + '</strong> matching items';
else
  infoBarTxt += ' across ' + getFilterText(filters) + ' returned <strong>' + countItems(searchData) + '</strong> matching items';*/

if (bSearch || filters.length > 0) {
 // $('.infoBar').addClass('highlight').html(infoBarTxt);
  $('a[href="#clearSearch"]').removeClass('hide');
  $('a.pdfModalbtn').removeClass('hide');
} else {
  //$('a[href="#allSupportingModal"]').addClass('hide');
  $('a.pdfModalbtn').addClass('hide');
  // $('#showSearchHighlight').prop('disabled', true); // Don't need this anymore, enable disable taken care inline in jsp.
  $('a[href="#clearSearch"]').addClass('hide');
}

// Sections
for (var i=0; i<searchData.length; i++) {
  var section = searchData[i];
  output += '<div class="row">';
  output += "<h4>"+section.section+"</h4>";
  output += "</div>";

  output += '<div class="row"><table class="specs" border="0"><tbody>';
  if (section.standards && section.standards.length > 0) {
    for (var j=0; j<section.standards.length; j++) {
      var std = section.standards[j];
      var stdHighlight = '';
      if (itemText(std.text).indexOf('<mark>') != -1) {
        stdHighlight = 'class="matchInline" ';
      }
      output += "<tr>";
      output += '<td class="update invisible">'+updateLabel(std.update)+'</td>';
      output += '<td '+stdHighlight+' colspan="3"><strong>'+itemText(std.text)+'</strong> ';
      //output += commentsLabel(std.comments)+ " ";
      output += imageLabel(std.images) + " ";
      output += complianceLabel(std.complianceDate);
      output += '</td>';
      output += "</tr>";

      if (std.sp && std.sp.length > 0) {
        for (var k=0; k<std.sp.length; k++) {
          var sp = std.sp[k];
          var spHighlight = '';
          if (itemText(sp.text).indexOf('<mark>') != -1) {
            spHighlight = 'class="matchInline" ';
          }
          output += "<tr>";
          output += '<td class="update invisible">'+updateLabel(sp.update)+'</td>';
          output += '<td class="bull">&bull; </td>';
          output += '<td '+spHighlight+'>'+itemText(sp.text)+' ';
          //output += commentsLabel(sp.comments) + " ";
          output += imageLabel(sp.images) + " ";
          output += supportingLabel(sp.sm, sp.smupdated)+ " ";
          output += complianceLabel(sp.complianceDate);
          output += '</td>';
          output += "</tr>";
        }
      }

      if (std.guidelines && std.guidelines.length > 0) {
        output += '<tr><td class="update invisible"></td><td colspan="3" class="lg" style="padding-top:5px;"><strong>Guidelines</strong></td></tr>';
        for (var k=0; k<std.guidelines.length; k++) {
          var gl = std.guidelines[k];
          var glHighlight = '';
          if (itemText(gl.text).indexOf('<mark>') != -1) {
            glHighlight = ' matchInline';
          }
          output += "<tr>";
          output += '<td class="update invisible">'+updateLabel(gl.update)+'</td>';
          output += '<td class="bull lg">&bull; </td>';
          output += '<td class="lg '+glHighlight+'">'+itemText(gl.text)+' ';
          output += imageLabel(gl.images) + " ";
          output += complianceLabel(gl.complianceDate);
          output += '</td>';
          output += "</tr>";
        }
      }
    }
  }
  output += "</tbody></table><hr></div>";
}

//$('#standards').html(output);
});

 

function commentsLabel (comments) {
if (!comments && comments != 0)
  return '';

var o = "";
o += '<span class="label showComments"><a title="Comments" href="#commentsModal" role="button" data-toggle="modal"><i class="icon-white icon-comment"></i>';
if (comments && comments > 0) {
  o += " "+comments;
} 
o += '</a></span>';
return o;
}

function supportingLabel (sm, smupdated) {
if (!sm) {
  return '';
} else {
  var o = '<span class="label"><a title="Supporting Material" href="#" class="SupportingMatModalbtn"><img alt="Supporting Material" src="./img/paperclip_white.png" style="height:14px; width:14px;">';
  if (smupdated) {
    o += ' ' +smupdated;
  }
  o += '</a></span>';
  return o;

}
}

function complianceLabel (complianceDate) {
if (!complianceDate)
  return ''

return '<span class="complianceDate hide label label-info">'+complianceDate+'</span>';
}

function imageLabel (images) {
if (!images)
  return ''
var imgDataStr = images.join(',');
return '<span class="label"><a class="imageModalTrigger" title="Images" href="#" role="button" data-images="'+imgDataStr+'"><i class="icon-camera icon-white"></i></span>';
}

function itemText (txt) {
if (searchInput && searchInput != '') {
  var rgx = new RegExp(searchInput, "gi");
  return txt.replace(rgx, '<mark>$&</mark>');
} else {
  return txt;
}
}

function doSearch(si) {
if (!si)
  return myData;

var toReturn = [],
  regex = new RegExp(si, "gi");
for (var i=0; i<myData.length; i++) {
  var section = myData[i];
  if (section.section.match(regex)) {
    toReturn.push(section);
  } else {
    if (section.standards && section.standards.length > 0) {
      for (var j=0; j<section.standards.length; j++) {
        var std = section.standards[j];
        if (std.text.match(regex)) {
          toReturn.push(section);
          break;
        } else {
          if (std.sp && std.sp.length > 0) {
            for (var k=0; k<std.sp.length; k++) {
              var sp = std.sp[k];
              if (sp.text.match(regex)) {
                toReturn.push(section);
                break;
              }
            }
          }
          if (std.guidelines && std.guidelines.length > 0) {
            for (var k=0; k<std.guidelines.length; k++) {
              var gl = std.guidelines[k];
              if (gl.text.match(regex)) {
                toReturn.push(section);
                break;
              }
            }
          }
        }
      }
    }
  }
}
return toReturn;
}

function countItems(data) {
var count = 0;
for (var i=0; i<data.length; i++) {
  var section = data[i];
  //count++;
  if (section.standards && section.standards.length > 0) {
    for (var j=0; j<section.standards.length; j++) {
      count++;
      var std = section.standards[j];
      if (std.sp)
        count += std.sp.length;
      if (std.guidelines)
        count += std.guidelines.length;
    }
  }
}
return count;
}

function getPrettyDate(dt) {
  if (dt == null) {
      dt = new Date();
  }
  var day = dt.getDate();
  var month = dt.getMonth();
  var year = dt.getFullYear();
  return ((day < 10 ? '0' : '') + day + ' ' + months[month]  +' ' + year);
}

function getLongestDate(val) {
  var newDt = Date.today();
  switch(val) {
    case '7d':
      newDt.add({days: 7});
      break;
    case '1m':
      newDt.add({months: 1});
      break;
    case '3m':
      newDt.add({months: 3});
      break;
    case '6m':
      newDt.add({months: 6});
      break;
    case '12m':
      newDt.add({months: 12});
      break;
    case '12m+':
      newDt.add({months: 12});
      break;
   default:
  }
  return newDt;
}

function Filter( name, count, otherTxt ) {
  this.txt   = '';
  this.count = count;
  this.name  = name;

  if (name == 'Compliance') {
    this.txt = otherTxt;
  } else if (name == 'Supporting Material') {
    if (this.count == 1) {
      this.txt = 'across ' + this.count + ' type of ' + name;
    } else {
      this.txt = 'across ' + this.count + ' types of ' + name + 's';
    }
  } else {
    if (this.count == 1) {
      this.txt = this.count + ' ' + this.name;
    } else {
      this.txt = this.count + ' ' + this.name + 's';
    }
  }
}

function getFilterText(myFilters) {
  var infoTxt = '';
  switch (myFilters.length){
  case 1:
    infoTxt = myFilters[0].txt;
    break;
  case 2:
    infoTxt = myFilters[0].txt + ' and ' + myFilters[1].txt;
    break;
  case 3:
    infoTxt = myFilters[0].txt + ', ' + myFilters[1].txt + ' and ' + myFilters[2].txt;
    break;
  case 4:
    infoTxt = myFilters[0].txt + ', ' + myFilters[1].txt + ', ' + myFilters[2].txt + ' and ' + myFilters[3].txt;
    break;  
  case 5:
    infoTxt = myFilters[0].txt + ', ' + myFilters[1].txt + ', ' + myFilters[2].txt+ ', ' + myFilters[3].txt + ' and ' + myFilters[4].txt;
    break;  
  }
  return infoTxt;
}


function flipChev(id, direction) {
  $('#chev' + id).attr('src', 'img/chevron-' + direction + '.png')
}