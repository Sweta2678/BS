  function popitup(url) {
    newwindow=window.open(url,'name','height=465,width=700');
    if (window.focus) {newwindow.focus()}
    return false;
  }

$(document).ready(function () {
 // $('.pp').popover({});


	if(window.location.href.indexOf("/staging/") > -1) {
	       $( "#content" ).addClass( "stagingContent" );
	}
	$('#show_opts').click(function (e) {
    e.preventDefault();
    $('.displayOptions').toggle().toggleClass("show");
    if ($('.displayOptions').hasClass("show")) {
      $(e.delegateTarget).text("Hide Options");
    } else {
      $(e.delegateTarget).text("Show Options");
    }
    
  });

  /* $('.rating i').on('click', function (e) {
    // Which one was it?
    var rating = $(e.delegateTarget).data('star');
    // Get the parent
    var childList = $(e.delegateTarget).parent().children();
    for (var i=0; i<5; i++) {
      $(childList[i]).removeClass('star-empty star');
      if (i < rating) {
        $(childList[i]).addClass('star');
      } else {
        $(childList[i]).addClass('star-empty');
      }
    }
    $(e.delegateTarget).parent().find('.yourRating').text(" (You rated "+rating+")");
  });

  var curBrand = sessionStorage.getItem('brand') || "Holiday Inn Express";
  var curCountry = sessionStorage.getItem('country') || "United Kingdom";
  var curLang = sessionStorage.getItem('language') || "English";

  $('#brandLabel').text(curBrand);
  $('#countryLabel').text(curCountry);
  $('#languageLabel').text(curLang);
  $('#inputBrand').val(curBrand);
  $('#inputCountry').val(curCountry)
  $('#inputLanguage').val(curLang);

  $('#changeSettingsButton').on('click', function () {
    sessionStorage.setItem('brand', $('#inputBrand').val());
    sessionStorage.setItem('country', $('#inputCountry').val());
    sessionStorage.setItem('language', $('#inputLanguage').val());
    window.location.reload();
  });*/

});