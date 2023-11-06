if (typeof console == "undefined") { console = { };console.log=function(s) { return true; } };

var browser = "";
function detectBrowser() { 
	if (browser != "") { return browser; }
	if (navigator.userAgent.match(/Firefox/i)) {
		return "firefox";
	} else if (navigator.userAgent.match(/iPhone/i)) {
		return "iphone";
	} else if (navigator.userAgent.match(/iPod/i)) {
		return "ipod";
	} else if (navigator.userAgent.match(/iPad/i)) {
		return "ipad";
	} else if (/MSIE (\d+\.\d+);/.test(navigator.userAgent)) { return Number(RegExp.$1); } else { if (window.devicePixelRatio) { return "safari"; } else { return 0; } } }
/*
 * jQuery UI selectmenu
 *
 * Copyright (c) 2009 AUTHORS.txt (http://jqueryui.com/about)
 * Dual licensed under the MIT (MIT-LICENSE.txt)
 * and GPL (GPL-LICENSE.txt) licenses.
 *
 * http://docs.jquery.com/UI
 */

(function($) {$.widget("ui.selectmenu", {
	_init: function() {
		var self = this, o = this.options;
		
		//quick array of button and menu id's
		this.ids = [this.element.attr('id') + '-' + 'button', this.element.attr('id') + '-' + 'menu'];
		
		//define safe mouseup for future toggling
		this._safemouseup = true;
		
		//create menu button wrapper
		this.newelement = $('<a class="'+ this.widgetBaseClass +' ui-widget ui-state-default ui-corner-all" id="'+this.ids[0]+'" role="button" href="#" aria-haspopup="true" aria-owns="'+this.ids[1]+'"></a>')
			.insertAfter(this.element);
		
		//transfer tabindex
		var tabindex = this.element.attr('tabindex');
		if(tabindex){ this.newelement.attr('tabindex', tabindex); }
		
		//save reference to select in data for ease in calling methods
		this.newelement.data('selectelement', this.element);
		
		//menu icon
		this.selectmenuIcon = $('<span class="'+ this.widgetBaseClass +'-icon ui-icon"></span>')
			.prependTo(this.newelement)
			.addClass( (o.style == "popup")? 'ui-icon-triangle-2-n-s' : 'ui-icon-triangle-1-s' );	

			
		//make associated form label trigger focus
		$('label[for='+this.element.attr('id')+']')
			.attr('for', this.ids[0])
			.bind('click', function(){
				self.newelement[0].focus();
				return false;
			});	

		//click toggle for menu visibility
		this.newelement
			.bind('mousedown', function(event){
				self._toggle(event);
				//make sure a click won't open/close instantly
				if(o.style == "popup"){
					self._safemouseup = false;
					setTimeout(function(){self._safemouseup = true;}, 300);
				}	
				return false;
			})
			.bind('click',function(){
				return false;
			})
			.keydown(function(event){
				var ret = true;
				switch (event.keyCode) {
					case $.ui.keyCode.ENTER:
						ret = true;
						break;
					case $.ui.keyCode.SPACE:
						ret = false;
						self._toggle(event);	
						break;
					case $.ui.keyCode.UP:
					case $.ui.keyCode.LEFT:
						ret = false;
						self._moveSelection(-1);
						break;
					case $.ui.keyCode.DOWN:
					case $.ui.keyCode.RIGHT:
						ret = false;
						self._moveSelection(1);
						break;	
					case $.ui.keyCode.TAB:
						ret = true;
						break;	
					default:
						ret = false;
						self._typeAhead(event.keyCode, 'mouseup');
						break;	
				}
				return ret;
			})
			.bind('mouseover focus', function(){ 
				$(this).addClass(self.widgetBaseClass+'-focus ui-state-hover'); 
			})
			.bind('mouseout blur', function(){  
				$(this).removeClass(self.widgetBaseClass+'-focus ui-state-hover'); 
			});
		
		//document click closes menu
		$(document)
			.mousedown(function(event){
				self.close(event);
			});

		//change event on original selectmenu
		this.element
			.click(function(){ this._refreshValue(); })
			.focus(function(){ this.newelement[0].focus(); });
		
		//create menu portion, append to body
		var cornerClass = (o.style == "dropdown")? " ui-corner-bottom" : " ui-corner-all"
		this.list = $('<ul class="' + self.widgetBaseClass + '-menu ui-widget ui-widget-content'+cornerClass+'" aria-hidden="true" role="listbox" aria-labelledby="'+this.ids[0]+'" id="'+this.ids[1]+'"></ul>').appendTo('body');				
		
		//serialize selectmenu element options	
		var selectOptionData = [];
		this.element
			.find('option')
			.each(function(){
				selectOptionData.push({
					value: $(this).attr('value'),
					text: self._formatText(jQuery(this).text()),
					selected: $(this).attr('selected'),
					classes: $(this).attr('class'),
					parentOptGroup: $(this).parent('optgroup').attr('label')
				});
			});		
				
		//active state class is only used in popup style
		var activeClass = (self.options.style == "popup") ? " ui-state-active" : "";
		
		//write li's
		for(var i in selectOptionData){
			var thisLi = $('<li role="presentation"><a href="#" tabindex="-1" role="option" aria-selected="false">'+ selectOptionData[i].text +'</a></li>')
				.data('index',i)
				.addClass(selectOptionData[i].classes)
				.data('optionClasses', selectOptionData[i].classes|| '')
				.mouseup(function(event){
						if(self._safemouseup){
							var changed = $(this).data('index') != self._selectedIndex();
							self.value($(this).data('index'));
							self.select(event);
							if(changed){ self.change(event); }
							self.close(event,true);
						}
					return false;
				})
				.click(function(){
					return false;
				})
				.bind('mouseover focus', function(){ 
					self._selectedOptionLi().addClass(activeClass); 
					self._focusedOptionLi().removeClass(self.widgetBaseClass+'-item-focus ui-state-hover'); 
					$(this).removeClass('ui-state-active').addClass(self.widgetBaseClass + '-item-focus ui-state-hover'); 
				})
				.bind('mouseout blur', function(){ 
					if($(this).is( self._selectedOptionLi() )){ $(this).addClass(activeClass); }
					$(this).removeClass(self.widgetBaseClass + '-item-focus ui-state-hover'); 
				});
				
			//optgroup or not...
			if(selectOptionData[i].parentOptGroup){
				var optGroupName = self.widgetBaseClass + '-group-' + selectOptionData[i].parentOptGroup;
				if(this.list.find('li.' + optGroupName).size()){
					this.list.find('li.' + optGroupName + ':last ul').append(thisLi);
				}
				else{
					$('<li role="presentation" class="'+self.widgetBaseClass+'-group '+optGroupName+'"><span class="'+self.widgetBaseClass+'-group-label">'+selectOptionData[i].parentOptGroup+'</span><ul></ul></li>')
						.appendTo(this.list)
						.find('ul')
						.append(thisLi);
				}
			}
			else{
				thisLi.appendTo(this.list);
			}
			
			//this allows for using the scrollbar in an overflowed list
			this.list.bind('mousedown mouseup', function(){return false;});
			
			//append icon if option is specified
			if(o.icons){
				for(var j in o.icons){
					if(thisLi.is(o.icons[j].find)){
						thisLi
							.data('optionClasses', selectOptionData[i].classes + ' ' + self.widgetBaseClass + '-hasIcon')
							.addClass(self.widgetBaseClass + '-hasIcon');
						var iconClass = o.icons[j].icon || "";
						
						thisLi
							.find('a:eq(0)')
							.prepend('<span class="'+self.widgetBaseClass+'-item-icon ui-icon '+iconClass + '"></span>');
					}
				}
			}
		}	
		
		//add corners to top and bottom menu items
		this.list.find('li:last').addClass("ui-corner-bottom");
		if(o.style == 'popup'){ this.list.find('li:first').addClass("ui-corner-top"); }
		
		//transfer classes to selectmenu and list
		if(o.transferClasses){
			var transferClasses = this.element.attr('class') || ''; 
			this.newelement.add(this.list).addClass(transferClasses);
		}
		
		//original selectmenu width
		var selectWidth = this.element.width();
		
		//set menu button width
		this.newelement.width( (o.width) ? o.width : selectWidth);
		
		//set menu width to either menuWidth option value, width option value, or select width 
		if(o.style == 'dropdown'){ this.list.width( (o.menuWidth) ? o.menuWidth : ((o.width) ? o.width : selectWidth)); }
		else { this.list.width( (o.menuWidth) ? o.menuWidth : ((o.width) ? o.width - o.handleWidth : selectWidth - o.handleWidth)); }	
		
		//set max height from option 
		if(o.maxHeight && o.maxHeight < this.list.height()){ this.list.height(o.maxHeight); }	
		
		//save reference to actionable li's (not group label li's)
		this._optionLis = this.list.find('li:not(.'+ self.widgetBaseClass +'-group)');
				
		//transfer menu click to menu button
		this.list
			.keydown(function(event){
				var ret = true;
				switch (event.keyCode) {
					case $.ui.keyCode.UP:
					case $.ui.keyCode.LEFT:
						ret = false;
						self._moveFocus(-1);
						break;
					case $.ui.keyCode.DOWN:
					case $.ui.keyCode.RIGHT:
						ret = false;
						self._moveFocus(1);
						break;	
					case $.ui.keyCode.HOME:
						ret = false;
						self._moveFocus(':first');
						break;	
					case $.ui.keyCode.PAGE_UP:
						ret = false;
						self._scrollPage('up');
						break;	
					case $.ui.keyCode.PAGE_DOWN:
						ret = false;
						self._scrollPage('down');
						break;
					case $.ui.keyCode.END:
						ret = false;
						self._moveFocus(':last');
						break;			
					case $.ui.keyCode.ENTER:
					case $.ui.keyCode.SPACE:
						ret = false;
						self.close(event,true);
						$(event.target).parents('li:eq(0)').trigger('mouseup');
						break;		
					case $.ui.keyCode.TAB:
						ret = true;
						self.close(event,true);
						break;	
					case $.ui.keyCode.ESCAPE:
						ret = false;
						self.close(event,true);
						break;	
					default:
						ret = false;
						self._typeAhead(event.keyCode,'focus');
						break;		
				}
				return ret;
			});
			
		//selectmenu style
		if(o.style == 'dropdown'){
			this.newelement
				.addClass(self.widgetBaseClass+"-dropdown");
			this.list
				.addClass(self.widgetBaseClass+"-menu-dropdown");	
		}
		else {
			this.newelement
				.addClass(self.widgetBaseClass+"-popup");
			this.list
				.addClass(self.widgetBaseClass+"-menu-popup");	
		}
		
		//append status span to button
		this.newelement.prepend('<span class="'+self.widgetBaseClass+'-status">'+ selectOptionData[this._selectedIndex()].text +'</span>');
		
		//hide original selectmenu element
		this.element.hide();
		
		//transfer disabled state
		if(this.element.attr('disabled') == true){ this.disable(); }
		
		//update value
		this.value(this._selectedIndex());
	},
	destroy: function() {
		this.element.removeData(this.widgetName)
			.removeClass(this.widgetBaseClass + '-disabled' + ' ' + this.namespace + '-state-disabled')
			.removeAttr('aria-disabled');
	
		//unbind click on label, reset its for attr
		$('label[for='+this.newelement.attr('id')+']')
			.attr('for',this.element.attr('id'))
			.unbind('click');
		this.newelement.remove();
		this.list.remove();
		this.element.show();	
	},
	_typeAhead: function(code, eventType){
		var self = this;
		//define self._prevChar if needed
		if(!self._prevChar){ self._prevChar = ['',0]; }
		var C = String.fromCharCode(code);
		c = C.toLowerCase();
		var focusFound = false;
		function focusOpt(elem, ind){
			focusFound = true;
			$(elem).trigger(eventType);
			self._prevChar[1] = ind;
		};
		this.list.find('li a').each(function(i){	
			if(!focusFound){
				var thisText = $(this).text();
				if( thisText.indexOf(C) == 0 || thisText.indexOf(c) == 0){
						if(self._prevChar[0] == C){
							if(self._prevChar[1] < i){ focusOpt(this,i); }	
						}
						else{ focusOpt(this,i); }	
				}
			}
		});
		this._prevChar[0] = C;
	},
	_uiHash: function(){
		return {
			value: this.value()
		};
	},
	open: function(event){
		var self = this;
		var disabledStatus = this.newelement.attr("aria-disabled");
		if(disabledStatus != 'true'){
			this._refreshPosition();
			this._closeOthers(event);
			this.newelement
				.addClass('ui-state-active');
			
			this.list
				.appendTo('body')
				.addClass(self.widgetBaseClass + '-open')
				.attr('aria-hidden', false)
				.find('li:not(.'+ self.widgetBaseClass +'-group):eq('+ this._selectedIndex() +') a')[0].focus();	
			if(this.options.style == "dropdown"){ this.newelement.removeClass('ui-corner-all').addClass('ui-corner-top'); }	
			this._refreshPosition();
			this._trigger("open", event, this._uiHash());
		}
	},
	close: function(event, retainFocus){
		if(this.newelement.is('.ui-state-active')){
			this.newelement
				.removeClass('ui-state-active');
			this.list
				.attr('aria-hidden', true)
				.removeClass(this.widgetBaseClass+'-open');
			if(this.options.style == "dropdown"){ this.newelement.removeClass('ui-corner-top').addClass('ui-corner-all'); }
			if(retainFocus){this.newelement[0].focus();}	
			this._trigger("close", event, this._uiHash());
		}
	},
	change: function(event) {
		this.element.trigger('change');
		this._trigger("change", event, this._uiHash());
	},
	select: function(event) {
		this._trigger("select", event, this._uiHash());
	},
	_closeOthers: function(event){
		$('.'+ this.widgetBaseClass +'.ui-state-active').not(this.newelement).each(function(){
			$(this).data('selectelement').selectmenu('close',event);
		});
		$('.'+ this.widgetBaseClass +'.ui-state-hover').trigger('mouseout');
	},
	_toggle: function(event,retainFocus){
		if(this.list.is('.'+ this.widgetBaseClass +'-open')){ this.close(event,retainFocus); }
		else { this.open(event); }
	},
	_formatText: function(text){
		return this.options.format ? this.options.format(text) : text;
	},
	_selectedIndex: function(){
		return this.element[0].selectedIndex;
	},
	_selectedOptionLi: function(){
		return this._optionLis.eq(this._selectedIndex());
	},
	_focusedOptionLi: function(){
		return this.list.find('.'+ this.widgetBaseClass +'-item-focus');
	},
	_moveSelection: function(amt){
		var currIndex = parseInt(this._selectedOptionLi().data('index'), 10);
		var newIndex = currIndex + amt;
		return this._optionLis.eq(newIndex).trigger('mouseup');
	},
	_moveFocus: function(amt){
		if(!isNaN(amt)){
			var currIndex = parseInt(this._focusedOptionLi().data('index'), 10);
			var newIndex = currIndex + amt;
		}
		else { var newIndex = parseInt(this._optionLis.filter(amt).data('index'), 10); }
		
		if(newIndex < 0){ newIndex = 0; }
		if(newIndex > this._optionLis.size()-1){
			newIndex =  this._optionLis.size()-1;
		}
		var activeID = this.widgetBaseClass + '-item-' + Math.round(Math.random() * 1000);
		
		this._focusedOptionLi().find('a:eq(0)').attr('id','');
		this._optionLis.eq(newIndex).find('a:eq(0)').attr('id',activeID)[0].focus();
		this.list.attr('aria-activedescendant', activeID);
	},
	_scrollPage: function(direction){
		var numPerPage = Math.floor(this.list.outerHeight() / this.list.find('li:first').outerHeight());
		numPerPage = (direction == 'up') ? -numPerPage : numPerPage;
		this._moveFocus(numPerPage);
	},
	_setData: function(key, value) {
		this.options[key] = value;
		if (key == 'disabled') {
			this.close();
			this.element
				.add(this.newelement)
				.add(this.list)
					[value ? 'addClass' : 'removeClass'](
						this.widgetBaseClass + '-disabled' + ' ' +
						this.namespace + '-state-disabled')
					.attr("aria-disabled", value);
		}
	},
	value: function(newValue) {
		if (arguments.length) {
			this.element[0].selectedIndex = newValue;
			this._refreshValue();
			this._refreshPosition();
		}
		return this.element[0].selectedIndex;
	},
	_refreshValue: function() {
		var activeClass = (this.options.style == "popup") ? " ui-state-active" : "";
		var activeID = this.widgetBaseClass + '-item-' + Math.round(Math.random() * 1000);
		//deselect previous
		this.list
			.find('.'+ this.widgetBaseClass +'-item-selected')
			.removeClass(this.widgetBaseClass + "-item-selected" + activeClass)
			.find('a')
			.attr('aria-selected', 'false')
			.attr('id', '');
		//select new
		this._selectedOptionLi()
			.addClass(this.widgetBaseClass + "-item-selected"+activeClass)
			.find('a')
			.attr('aria-selected', 'true')
			.attr('id', activeID);
			
		//toggle any class brought in from option
		var currentOptionClasses = this.newelement.data('optionClasses') ? this.newelement.data('optionClasses') : "";
		var newOptionClasses = this._selectedOptionLi().data('optionClasses') ? this._selectedOptionLi().data('optionClasses') : "";
		this.newelement
			.removeClass(currentOptionClasses)
			.data('optionClasses', newOptionClasses)
			.addClass( newOptionClasses )
			.find('.'+this.widgetBaseClass+'-status')
			.html( 
				this._selectedOptionLi()
					.find('a:eq(0)')
					.html() 
			);
			
		this.list.attr('aria-activedescendant', activeID)
	},
	_refreshPosition: function(){	
		//set left value
		this.list.css('left', this.newelement.offset().left);
		
		//set top value
		var menuTop = this.newelement.offset().top;
		var scrolledAmt = this.list[0].scrollTop;
		this.list.find('li:lt('+this._selectedIndex()+')').each(function(){
			scrolledAmt -= $(this).outerHeight();
		});
		
		if(this.newelement.is('.'+this.widgetBaseClass+'-popup')){
			menuTop+=scrolledAmt; 
			this.list.css('top', menuTop); 
		}	
		else { 
			menuTop += this.newelement.height();
			this.list.css('top', menuTop); 
		}
	}
});

$.extend($.ui.selectmenu, {
	getter: "value",
	version: "@VERSION",
	eventPrefix: "selectmenu",
	defaults: {
		transferClasses: true,
		style: 'popup', 
		width: null, 
		menuWidth: null, 
		handleWidth: 26, 
		maxHeight: null,
		icons: null, 
		format: null
	}
});

})(jQuery);
/* 
== malihu jquery custom scrollbars plugin == 
version: 2.1 
author: malihu (http://manos.malihu.gr) 
plugin home: http://manos.malihu.gr/jquery-custom-content-scroller 
*/
(function($){
	var methods={
		init:function(options){
			var defaults={ 
				set_width:false, /*optional element width: boolean, pixels, percentage*/
				set_height:false, /*optional element height: boolean, pixels, percentage*/
				horizontalScroll:false, /*scroll horizontally: boolean*/
				scrollInertia:550, /*scrolling inertia: integer (milliseconds)*/
				scrollEasing:"easeOutCirc", /*scrolling easing: string*/
				mouseWheel:"auto", /*mousewheel support and velocity: boolean, "auto", integer*/
				autoDraggerLength:true, /*auto-adjust scrollbar dragger length: boolean*/
				scrollButtons:{ /*scroll buttons*/
					enable:false, /*scroll buttons support: boolean*/
					scrollType:"continuous", /*scroll buttons scrolling type: "continuous", "pixels"*/
					scrollSpeed:20, /*scroll buttons continuous scrolling speed: integer*/
					scrollAmount:40 /*scroll buttons pixels scroll amount: integer (pixels)*/
				},
				advanced:{
					updateOnBrowserResize:true, /*update scrollbars on browser resize (for layouts based on percentages): boolean*/
					updateOnContentResize:false, /*auto-update scrollbars on content resize (for dynamic content): boolean*/
					autoExpandHorizontalScroll:false /*auto-expand width for horizontal scrolling: boolean*/
				},
				callbacks:{
					onScroll:function(){}, /*user custom callback function on scroll event*/
					onTotalScroll:function(){}, /*user custom callback function on scroll end reached event*/
					onTotalScrollOffset:0 /*scroll end reached offset: integer (pixels)*/
				}
			},
			options=$.extend(true,defaults,options);
			/*check for touch device*/
			$(document).data("mCS-is-touch-device",false);
			if(is_touch_device()){
				$(document).data("mCS-is-touch-device",true);
			}
			function is_touch_device(){
				return !!("ontouchstart" in window) ? 1 : 0;
			}
			return this.each(function(){
				var $this=$(this);
				/*set element width/height, create markup for custom scrollbars, add classes*/
				if(options.set_width){
					$this.css("width",options.set_width);
				}
				if(options.set_height){
					$this.css("height",options.set_height);
				}
				if(!$(document).data("mCustomScrollbar-index")){
					$(document).data("mCustomScrollbar-index","1");
				}else{
					var mCustomScrollbarIndex=parseInt($(document).data("mCustomScrollbar-index"));
					$(document).data("mCustomScrollbar-index",mCustomScrollbarIndex+1);
				}
				$this.wrapInner("<div class='mCustomScrollBox' id='mCSB_"+$(document).data("mCustomScrollbar-index")+"' style='position:relative; height:100%; overflow:hidden; max-width:100%;' />").addClass("mCustomScrollbar _mCS_"+$(document).data("mCustomScrollbar-index"));
				var mCustomScrollBox=$this.children(".mCustomScrollBox");
				if(options.horizontalScroll){
					mCustomScrollBox.addClass("mCSB_horizontal").wrapInner("<div class='mCSB_h_wrapper' style='position:relative; left:0; width:999999px;' />");
					var mCSB_h_wrapper=mCustomScrollBox.children(".mCSB_h_wrapper");
					mCSB_h_wrapper.wrapInner("<div class='mCSB_container' style='position:absolute; left:0;' />").children(".mCSB_container").css({"width":mCSB_h_wrapper.children().outerWidth(),"position":"relative"}).unwrap();
				}else{
					mCustomScrollBox.wrapInner("<div class='mCSB_container' style='position:relative; top:0;' />");
				}
				var mCSB_container=mCustomScrollBox.children(".mCSB_container");
				if(!$(document).data("mCS-is-touch-device")){ /*not touch device - apply custom scrollbars functionality*/
					mCSB_container.after("<div class='mCSB_scrollTools' style='position:absolute;'><div class='mCSB_draggerContainer' style='position:relative;'><div class='mCSB_dragger' style='position:absolute;'><div class='mCSB_dragger_bar' style='position:relative;'></div></div><div class='mCSB_draggerRail'></div></div></div>");
					var mCSB_scrollTools=mCustomScrollBox.children(".mCSB_scrollTools"),
						mCSB_draggerContainer=mCSB_scrollTools.children(".mCSB_draggerContainer"),
						mCSB_dragger=mCSB_draggerContainer.children(".mCSB_dragger");
					if(options.horizontalScroll){
						mCSB_dragger.data("minDraggerWidth",mCSB_dragger.width());
					}else{
						mCSB_dragger.data("minDraggerHeight",mCSB_dragger.height());
					}
					if(options.scrollButtons.enable){
						if(options.horizontalScroll){
							mCSB_scrollTools.prepend("<a class='mCSB_buttonLeft' style='display:block; position:relative;'><span></span></a>").append("<a class='mCSB_buttonRight' style='display:block; position:relative;'><span></span></a>");
						}else{
							mCSB_scrollTools.prepend("<a class='mCSB_buttonUp' style='display:block; position:relative;'><span></span></a>").append("<a class='mCSB_buttonDown' style='display:block; position:relative;'><span></span></a>");
						}
					}
					/*mCustomScrollBox scrollTop and scrollLeft is always 0 to prevent browser focus scrolling*/
					mCustomScrollBox.bind("scroll",function(){
						mCustomScrollBox.scrollTop(0).scrollLeft(0);
					});
					/*store element options and update element*/
					$this.data({
						"horizontalScroll":options.horizontalScroll,
						"scrollInertia":options.scrollInertia,
						"scrollEasing":options.scrollEasing,
						"mouseWheel":options.mouseWheel,
						"autoDraggerLength":options.autoDraggerLength,
						"scrollButtons-enable":options.scrollButtons.enable,
						"scrollButtons-scrollType":options.scrollButtons.scrollType,
						"scrollButtons-scrollSpeed":options.scrollButtons.scrollSpeed,
						"scrollButtons-scrollAmount":options.scrollButtons.scrollAmount,
						"autoExpandHorizontalScroll":options.advanced.autoExpandHorizontalScroll,
						"onScroll-Callback":options.callbacks.onScroll,
						"onTotalScroll-Callback":options.callbacks.onTotalScroll,
						"onTotalScroll-Offset":options.callbacks.onTotalScrollOffset
					}).mCustomScrollbar("update");
					/*window resize fn (for layouts based on percentages)*/
					if(options.advanced.updateOnBrowserResize){
						var mCSB_resizeTimeout;
						$(window).resize(function(){
							if(mCSB_resizeTimeout){
								clearTimeout(mCSB_resizeTimeout);
							}
							mCSB_resizeTimeout=setTimeout(function(){
								$this.mCustomScrollbar("update");
							},150);
						});
					}
				}else{ /*is touch device*/
					/*check for mobile os/browser not supporting overflow:auto (Android 2.xx)*/
					var ua=navigator.userAgent;
					if(ua.indexOf("Android")!=-1){ 
						var androidversion=parseFloat(ua.slice(ua.indexOf("Android")+8));
						if(androidversion<3){
							touchScroll("mCSB_"+$(document).data("mCustomScrollbar-index")); /*non overflow:auto fn*/
						}else{
							mCustomScrollBox.css({"overflow":"auto","-webkit-overflow-scrolling":"touch"});
						}
					}else{
						mCustomScrollBox.css({"overflow":"auto","-webkit-overflow-scrolling":"touch"});
					}
					mCSB_container.addClass("mCS_no_scrollbar mCS_touch");
					$this.data({
						"horizontalScroll":options.horizontalScroll,
						"scrollInertia":options.scrollInertia,
						"scrollEasing":options.scrollEasing,
						"autoExpandHorizontalScroll":options.advanced.autoExpandHorizontalScroll,
						"onScroll-Callback":options.callbacks.onScroll,
						"onTotalScroll-Callback":options.callbacks.onTotalScroll,
						"onTotalScroll-Offset":options.callbacks.onTotalScrollOffset
					});
					mCustomScrollBox.scroll(function(){
						$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container); /*user custom callback functions*/
					});
					/*non overflow:auto fn 
					(source: http://chris-barr.com/index.php/entry/scrolling_a_overflowauto_element_on_a_touch_screen_device/)*/
					function touchScroll(id){
						var el=document.getElementById(id),
							scrollStartPosY=0,
							scrollStartPosX=0;
						document.getElementById(id).addEventListener("touchstart",function(event){
							scrollStartPosY=this.scrollTop+event.touches[0].pageY;
							scrollStartPosX=this.scrollLeft+event.touches[0].pageX;
							/*event.preventDefault(); // Keep this remarked so you can click on buttons and links in the div*/
						},false);
						document.getElementById(id).addEventListener("touchmove",function(event){
							/*These if statements allow the full page to scroll (not just the div) if they are
							at the top of the div scroll or the bottom of the div scroll
							The -5 and +5 below are in case they are trying to scroll the page sideways
							but their finger moves a few pixels down or up.  The event.preventDefault() function
							will not be called in that case so that the whole page can scroll.*/
							if((this.scrollTop<this.scrollHeight-this.offsetHeight && this.scrollTop+event.touches[0].pageY<scrollStartPosY-5) || (this.scrollTop!=0 && this.scrollTop+event.touches[0].pageY>scrollStartPosY+5))
								event.preventDefault();	
							if((this.scrollLeft<this.scrollWidth-this.offsetWidth && this.scrollLeft+event.touches[0].pageX < scrollStartPosX-5) || (this.scrollLeft!=0&&this.scrollLeft+event.touches[0].pageX>scrollStartPosX+5))
								event.preventDefault();	
							this.scrollTop=scrollStartPosY-event.touches[0].pageY;
							this.scrollLeft=scrollStartPosX-event.touches[0].pageX;
						},false);
					}
				}
				/*content resize fn (for dynamically generated content)*/
				if(options.advanced.updateOnContentResize){
					var mCSB_onContentResize;
					if(options.horizontalScroll){
						var mCSB_containerOldSize=mCSB_container.outerWidth();
						if(is_touch_device()){
							/*disable iOS webkit inertia for smooth scrolling*/
							mCustomScrollBox.css({"-webkit-overflow-scrolling":"auto"});
						}
					}else{
						var mCSB_containerOldSize=mCSB_container.outerHeight();
					}
					mCSB_onContentResize=setInterval(function(){
						if(options.horizontalScroll){
							if(options.advanced.autoExpandHorizontalScroll){
								mCSB_container.css({"position":"absolute","width":"auto"}).wrap("<div class='mCSB_h_wrapper' style='position:relative; left:0; width:999999px;' />").css({"width":mCSB_container.outerWidth(),"position":"relative"}).unwrap();
							}
							var mCSB_containerNewSize=mCSB_container.outerWidth();
						}else{
							var mCSB_containerNewSize=mCSB_container.outerHeight();
						}
						if(mCSB_containerNewSize!=mCSB_containerOldSize){
							$this.mCustomScrollbar("update");
							mCSB_containerOldSize=mCSB_containerNewSize;
						}
					},300);
				}
			});
		},
		update:function(){
			var $this=$(this),
				mCustomScrollBox=$this.children(".mCustomScrollBox"),
				mCSB_container=mCustomScrollBox.children(".mCSB_container");
			if(!$(document).data("mCS-is-touch-device")){
				mCSB_container.removeClass("mCS_no_scrollbar");
			}
			var mCSB_scrollTools=mCustomScrollBox.children(".mCSB_scrollTools"),
				mCSB_draggerContainer=mCSB_scrollTools.children(".mCSB_draggerContainer"),
				mCSB_dragger=mCSB_draggerContainer.children(".mCSB_dragger");
			if($this.data("horizontalScroll")){
				var mCSB_buttonLeft=mCSB_scrollTools.children(".mCSB_buttonLeft"),
					mCSB_buttonRight=mCSB_scrollTools.children(".mCSB_buttonRight"),
					mCustomScrollBoxW=mCustomScrollBox.width();
				if($this.data("autoExpandHorizontalScroll")){
					mCSB_container.css({"position":"absolute","width":"auto"}).wrap("<div class='mCSB_h_wrapper' style='position:relative; left:0; width:999999px;' />").css({"width":mCSB_container.outerWidth(),"position":"relative"}).unwrap();
				}
				var mCSB_containerW=mCSB_container.outerWidth();
			}else{
				var mCSB_buttonUp=mCSB_scrollTools.children(".mCSB_buttonUp"),
					mCSB_buttonDown=mCSB_scrollTools.children(".mCSB_buttonDown"),
					mCustomScrollBoxH=mCustomScrollBox.height(),
					mCSB_containerH=mCSB_container.outerHeight();
			}
			if(mCSB_containerH>mCustomScrollBoxH && !$this.data("horizontalScroll") && !$(document).data("mCS-is-touch-device")){ /*content needs vertical scrolling*/
				mCSB_scrollTools.css("display","block");
				var mCSB_draggerContainerH=mCSB_draggerContainer.height();
				/*auto adjust scrollbar dragger length analogous to content*/
				if($this.data("autoDraggerLength")){
					var draggerH=Math.round(mCustomScrollBoxH/mCSB_containerH*mCSB_draggerContainerH),
						minDraggerH=mCSB_dragger.data("minDraggerHeight");
					if(draggerH<=minDraggerH){ /*min dragger height*/
						mCSB_dragger.css({"height":minDraggerH});
					}else if(draggerH>=mCSB_draggerContainerH-10){ /*max dragger height*/
						var mCSB_draggerContainerMaxH=mCSB_draggerContainerH-10;
						mCSB_dragger.css({"height":mCSB_draggerContainerMaxH});
					}else{
						mCSB_dragger.css({"height":draggerH});
					}
					mCSB_dragger.children(".mCSB_dragger_bar").css({"line-height":mCSB_dragger.height()+"px"});
				}
				var mCSB_draggerH=mCSB_dragger.height(),
				/*calculate and store scroll amount*/
					scrollAmount=(mCSB_containerH-mCustomScrollBoxH)/(mCSB_draggerContainerH-mCSB_draggerH);
				$this.data("scrollAmount",scrollAmount);
				/*add scrolling*/
				$this.mCustomScrollbar("scrolling",mCustomScrollBox,mCSB_container,mCSB_draggerContainer,mCSB_dragger,mCSB_buttonUp,mCSB_buttonDown,mCSB_buttonLeft,mCSB_buttonRight);
				/*scroll*/
				var mCSB_containerP=Math.abs(Math.round(mCSB_container.position().top));
				$this.mCustomScrollbar("scrollTo",mCSB_containerP,{callback:false});
			}else if(mCSB_containerW>mCustomScrollBoxW && $this.data("horizontalScroll") && !$(document).data("mCS-is-touch-device")){ /*content needs horizontal scrolling*/
				mCSB_scrollTools.css("display","block");
				var mCSB_draggerContainerW=mCSB_draggerContainer.width();
				/*auto adjust scrollbar dragger length analogous to content*/
				if($this.data("autoDraggerLength")){
					var draggerW=Math.round(mCustomScrollBoxW/mCSB_containerW*mCSB_draggerContainerW),
						minDraggerW=mCSB_dragger.data("minDraggerWidth");
					if(draggerW<=minDraggerW){ /*min dragger height*/
						mCSB_dragger.css({"width":minDraggerW});
					}else if(draggerW>=mCSB_draggerContainerW-10){ /*max dragger height*/
						var mCSB_draggerContainerMaxW=mCSB_draggerContainerW-10;
						mCSB_dragger.css({"width":mCSB_draggerContainerMaxW});
					}else{
						mCSB_dragger.css({"width":draggerW});
					}
				}
				var mCSB_draggerW=mCSB_dragger.width(),
				/*calculate and store scroll amount*/
					scrollAmount=(mCSB_containerW-mCustomScrollBoxW)/(mCSB_draggerContainerW-mCSB_draggerW);
				$this.data("scrollAmount",scrollAmount);
				/*add scrolling*/
				$this.mCustomScrollbar("scrolling",mCustomScrollBox,mCSB_container,mCSB_draggerContainer,mCSB_dragger,mCSB_buttonUp,mCSB_buttonDown,mCSB_buttonLeft,mCSB_buttonRight);
				/*scroll*/
				var mCSB_containerP=Math.abs(Math.round(mCSB_container.position().left));
				$this.mCustomScrollbar("scrollTo",mCSB_containerP,{callback:false});
			}else{ /*content does not need scrolling*/
				/*unbind events, reset content position, hide scrollbars, remove classes*/
				mCustomScrollBox.unbind("mousewheel");
				mCustomScrollBox.unbind("focusin");
				if($this.data("horizontalScroll")){
					mCSB_dragger.add(mCSB_container).css("left",0);
				}else{
					mCSB_dragger.add(mCSB_container).css("top",0);
				}
				mCSB_scrollTools.css("display","none");
				mCSB_container.addClass("mCS_no_scrollbar");
			}
		},
		scrolling:function(mCustomScrollBox,mCSB_container,mCSB_draggerContainer,mCSB_dragger,mCSB_buttonUp,mCSB_buttonDown,mCSB_buttonLeft,mCSB_buttonRight){
			var $this=$(this);
			/*drag scrolling*/
			if(!mCSB_dragger.hasClass("ui-draggable")){ /*apply drag function once*/
				if($this.data("horizontalScroll")){
					var draggableAxis="x";
				}else{
					var draggableAxis="y";
				}
				mCSB_dragger.draggable({ 
					axis:draggableAxis,
					containment:"parent",
					drag:function(event,ui){
						$this.mCustomScrollbar("scroll");
						mCSB_dragger.addClass("mCSB_dragger_onDrag");
					},
					stop:function(event,ui){
						mCSB_dragger.removeClass("mCSB_dragger_onDrag");	
					}
				});
			}
			mCSB_draggerContainer.unbind("click").bind("click",function(e){
				if($this.data("horizontalScroll")){
					var mouseCoord=(e.pageX-mCSB_draggerContainer.offset().left);
					if(mouseCoord<mCSB_dragger.position().left || mouseCoord>(mCSB_dragger.position().left+mCSB_dragger.width())){
						var scrollToPos=mouseCoord;
						if(scrollToPos>=mCSB_draggerContainer.width()-mCSB_dragger.width()){ /*max dragger position is bottom*/
							scrollToPos=mCSB_draggerContainer.width()-mCSB_dragger.width();
						}
						mCSB_dragger.css("left",scrollToPos);
						$this.mCustomScrollbar("scroll");
					}
				}else{
					var mouseCoord=(e.pageY-mCSB_draggerContainer.offset().top);
					if(mouseCoord<mCSB_dragger.position().top || mouseCoord>(mCSB_dragger.position().top+mCSB_dragger.height())){
						var scrollToPos=mouseCoord;
						if(scrollToPos>=mCSB_draggerContainer.height()-mCSB_dragger.height()){ /*max dragger position is bottom*/
							scrollToPos=mCSB_draggerContainer.height()-mCSB_dragger.height();
						}
						mCSB_dragger.css("top",scrollToPos);
						$this.mCustomScrollbar("scroll");
					}
				}
			});
			/*mousewheel scrolling*/
			if($this.data("mouseWheel")){
				var mousewheelVel=$this.data("mouseWheel");
				if($this.data("mouseWheel")==="auto"){
					mousewheelVel=8; /*default mousewheel velocity*/
					/*check for safari browser on mac osx to lower mousewheel velocity*/
					var os=navigator.userAgent;
					if(os.indexOf("Mac")!=-1 && os.indexOf("Safari")!=-1 && os.indexOf("AppleWebKit")!=-1 && os.indexOf("Chrome")==-1){ 
						mousewheelVel=1;
					}
				}
				mCustomScrollBox.unbind("mousewheel").bind("mousewheel",function(event,delta){
					event.preventDefault();
					var vel=Math.abs(delta*mousewheelVel);
					if($this.data("horizontalScroll")){
						var posX=mCSB_dragger.position().left-(delta*vel);
						mCSB_dragger.css("left",posX);
						if(mCSB_dragger.position().left<0){
							mCSB_dragger.css("left",0);
						}
						var mCSB_draggerContainerW=mCSB_draggerContainer.width(),
							mCSB_draggerW=mCSB_dragger.width();
						if(mCSB_dragger.position().left>mCSB_draggerContainerW-mCSB_draggerW){
							mCSB_dragger.css("left",mCSB_draggerContainerW-mCSB_draggerW);
						}
					}else{
						var posY=mCSB_dragger.position().top-(delta*vel);
						mCSB_dragger.css("top",posY);
						if(mCSB_dragger.position().top<0){
							mCSB_dragger.css("top",0);
						}
						var mCSB_draggerContainerH=mCSB_draggerContainer.height(),
							mCSB_draggerH=mCSB_dragger.height();
						if(mCSB_dragger.position().top>mCSB_draggerContainerH-mCSB_draggerH){
							mCSB_dragger.css("top",mCSB_draggerContainerH-mCSB_draggerH);
						}
					}
					$this.mCustomScrollbar("scroll");
				});
			}
			/*buttons scrolling*/




			if($this.data("scrollButtons-enable")){
				if($this.data("scrollButtons-scrollType")==="pixels"){ /*scroll by pixels*/
					var pixelsScrollTo;
					if($.browser.msie && parseInt($.browser.version)<9){ /*stupid ie8*/
						$this.data("scrollInertia",0);
					}
					if($this.data("horizontalScroll")){
						mCSB_buttonRight.add(mCSB_buttonLeft).unbind("click mousedown mouseup mouseout",mCSB_buttonRight_stop,mCSB_buttonLeft_stop);
						/*scroll right*/
						mCSB_buttonRight.bind("click",function(e){
							e.preventDefault();
							if(!mCSB_container.is(":animated")){
								pixelsScrollTo=Math.abs(mCSB_container.position().left)+$this.data("scrollButtons-scrollAmount");
								$this.mCustomScrollbar("scrollTo",pixelsScrollTo);
							}
						});
						/*scroll left*/
						mCSB_buttonLeft.bind("click",function(e){
							e.preventDefault();
							if(!mCSB_container.is(":animated")){
								pixelsScrollTo=Math.abs(mCSB_container.position().left)-$this.data("scrollButtons-scrollAmount");
								if(mCSB_container.position().left>=-$this.data("scrollButtons-scrollAmount")){
									pixelsScrollTo="left";
								}
								$this.mCustomScrollbar("scrollTo",pixelsScrollTo);
							}
						});
					}else{
						mCSB_buttonDown.add(mCSB_buttonUp).unbind("click mousedown mouseup mouseout",mCSB_buttonDown_stop,mCSB_buttonUp_stop);
						/*scroll down*/
						mCSB_buttonDown.bind("click",function(e){
							e.preventDefault();
							if(!mCSB_container.is(":animated")){
								pixelsScrollTo=Math.abs(mCSB_container.position().top)+$this.data("scrollButtons-scrollAmount");
								$this.mCustomScrollbar("scrollTo",pixelsScrollTo);
							}
						});
						/*scroll up*/
						mCSB_buttonUp.bind("click",function(e){
							e.preventDefault();
							if(!mCSB_container.is(":animated")){
								pixelsScrollTo=Math.abs(mCSB_container.position().top)-$this.data("scrollButtons-scrollAmount");
								if(mCSB_container.position().top>=-$this.data("scrollButtons-scrollAmount")){
									pixelsScrollTo="top";
								}
								$this.mCustomScrollbar("scrollTo",pixelsScrollTo);
							}
						});
					}
				}else{ /*continuous scrolling*/
					if($this.data("horizontalScroll")){
						mCSB_buttonRight.add(mCSB_buttonLeft).unbind("click mousedown mouseup mouseout",mCSB_buttonRight_stop,mCSB_buttonLeft_stop);
						/*scroll right*/
						var mCSB_buttonScrollRight,
							mCSB_draggerContainerW=mCSB_draggerContainer.width(),
							mCSB_draggerW=mCSB_dragger.width();
						mCSB_buttonRight.bind("mousedown",function(e){
							e.preventDefault();
							var draggerScrollTo=mCSB_draggerContainerW-mCSB_draggerW;
							mCSB_buttonScrollRight=setInterval(function(){
								var scrollToSpeed=Math.abs(mCSB_dragger.position().left-draggerScrollTo)*(100/$this.data("scrollButtons-scrollSpeed"));
								mCSB_dragger.stop().animate({left:draggerScrollTo},scrollToSpeed,"linear");
								$this.mCustomScrollbar("scroll");
							},20);
						});
						var mCSB_buttonRight_stop=function(e){
							e.preventDefault();
							clearInterval(mCSB_buttonScrollRight);
							mCSB_dragger.stop();
						}
						mCSB_buttonRight.bind("mouseup mouseout",mCSB_buttonRight_stop);
						/*scroll left*/
						var mCSB_buttonScrollLeft;
						mCSB_buttonLeft.bind("mousedown",function(e){
							e.preventDefault();
							var draggerScrollTo=0;
							mCSB_buttonScrollLeft=setInterval(function(){
								var scrollToSpeed=Math.abs(mCSB_dragger.position().left-draggerScrollTo)*(100/$this.data("scrollButtons-scrollSpeed"));
								mCSB_dragger.stop().animate({left:draggerScrollTo},scrollToSpeed,"linear");
								$this.mCustomScrollbar("scroll");
							},20);
						});	
						var mCSB_buttonLeft_stop=function(e){
							e.preventDefault();
							clearInterval(mCSB_buttonScrollLeft);
							mCSB_dragger.stop();
						}
						mCSB_buttonLeft.bind("mouseup mouseout",mCSB_buttonLeft_stop);
					}else{
						mCSB_buttonDown.add(mCSB_buttonUp).unbind("click mousedown mouseup mouseout",mCSB_buttonDown_stop,mCSB_buttonUp_stop);
						/*scroll down*/
						var mCSB_buttonScrollDown,
							mCSB_draggerContainerH=mCSB_draggerContainer.height(),
							mCSB_draggerH=mCSB_dragger.height();
						mCSB_buttonDown.bind("mousedown",function(e){
							e.preventDefault();
							var draggerScrollTo=mCSB_draggerContainerH-mCSB_draggerH;
							mCSB_buttonScrollDown=setInterval(function(){
								var scrollToSpeed=Math.abs(mCSB_dragger.position().top-draggerScrollTo)*(100/$this.data("scrollButtons-scrollSpeed"));
								mCSB_dragger.stop().animate({top:draggerScrollTo},scrollToSpeed,"linear");
								$this.mCustomScrollbar("scroll");
							},20);
						});
						var mCSB_buttonDown_stop=function(e){
							e.preventDefault();
							clearInterval(mCSB_buttonScrollDown);
							mCSB_dragger.stop();
						}
						mCSB_buttonDown.bind("mouseup mouseout",mCSB_buttonDown_stop);
						/*scroll up*/
						var mCSB_buttonScrollUp;
						mCSB_buttonUp.bind("mousedown",function(e){
							e.preventDefault();
							var draggerScrollTo=0;
							mCSB_buttonScrollUp=setInterval(function(){
								var scrollToSpeed=Math.abs(mCSB_dragger.position().top-draggerScrollTo)*(100/$this.data("scrollButtons-scrollSpeed"));
								mCSB_dragger.stop().animate({top:draggerScrollTo},scrollToSpeed,"linear");
								$this.mCustomScrollbar("scroll");
							},20);
						});	
						var mCSB_buttonUp_stop=function(e){
							e.preventDefault();
							clearInterval(mCSB_buttonScrollUp);
							mCSB_dragger.stop();
						}
						mCSB_buttonUp.bind("mouseup mouseout",mCSB_buttonUp_stop);
					}
				}
			}
			/*scrolling on element focus (e.g. via TAB key)*/
			mCustomScrollBox.unbind("focusin").bind("focusin",function(){
				mCustomScrollBox.scrollTop(0).scrollLeft(0);
				var focusedElem=$(document.activeElement);
				if(focusedElem.is("input,textarea,select,button,a[tabindex],area,object")){
					if($this.data("horizontalScroll")){
						var mCSB_containerX=mCSB_container.position().left,
							focusedElemX=focusedElem.position().left,
							mCustomScrollBoxW=mCustomScrollBox.width(),
							focusedElemW=focusedElem.outerWidth();
						if(mCSB_containerX+focusedElemX>=0 && mCSB_containerX+focusedElemX<=mCustomScrollBoxW-focusedElemW){
							/*just focus...*/
						}else{ /*scroll, then focus*/
							var moveDragger=focusedElemX/$this.data("scrollAmount");
							if(moveDragger>=mCSB_draggerContainer.width()-mCSB_dragger.width()){ /*max dragger position is bottom*/
								moveDragger=mCSB_draggerContainer.width()-mCSB_dragger.width();
							}
							mCSB_dragger.css("left",moveDragger);
							$this.mCustomScrollbar("scroll");
						}
					}else{
						var mCSB_containerY=mCSB_container.position().top,
							focusedElemY=focusedElem.position().top,
							mCustomScrollBoxH=mCustomScrollBox.height(),
							focusedElemH=focusedElem.outerHeight();
						if(mCSB_containerY+focusedElemY>=0 && mCSB_containerY+focusedElemY<=mCustomScrollBoxH-focusedElemH){
							/*just focus...*/
						}else{ /*scroll, then focus*/
							var moveDragger=focusedElemY/$this.data("scrollAmount");
							if(moveDragger>=mCSB_draggerContainer.height()-mCSB_dragger.height()){ /*max dragger position is bottom*/
								moveDragger=mCSB_draggerContainer.height()-mCSB_dragger.height();
							}
							mCSB_dragger.css("top",moveDragger);
							$this.mCustomScrollbar("scroll");
						}
					}
				}
			});
		},
		scroll:function(updated){
			var $this=$(this),
				mCSB_dragger=$this.find(".mCSB_dragger"),
				mCSB_container=$this.find(".mCSB_container"),
				mCustomScrollBox=$this.find(".mCustomScrollBox");
			if($this.data("horizontalScroll")){
				var draggerX=mCSB_dragger.position().left,
					targX=-draggerX*$this.data("scrollAmount"),
					thisX=mCSB_container.position().left,
					posX=Math.round(thisX-targX);
			}else{
				var draggerY=mCSB_dragger.position().top,
					targY=-draggerY*$this.data("scrollAmount"),
					thisY=mCSB_container.position().top,
					posY=Math.round(thisY-targY);
			}
			if($.browser.webkit){ /*fix webkit zoom and jquery animate*/
				var screenCssPixelRatio=(window.outerWidth-8)/window.innerWidth,
					isZoomed=(screenCssPixelRatio<.98 || screenCssPixelRatio>1.02);
			}
			if($this.data("scrollInertia")===0 || isZoomed){
				if($this.data("horizontalScroll")){
					mCSB_container.css("left",targX);
				}else{
					mCSB_container.css("top",targY);
				}
				if(!updated){
					$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container); /*user custom callback functions*/
				}
			}else{
				if($this.data("horizontalScroll")){
					mCSB_container.stop().animate({left: "-="+posX},$this.data("scrollInertia"),$this.data("scrollEasing"),function(){
						if(!updated){
							$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container); /*user custom callback functions*/
						}
					});
				}else{
					mCSB_container.stop().animate({top: "-="+posY},$this.data("scrollInertia"),$this.data("scrollEasing"),function(){
						if(!updated){
							$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container); /*user custom callback functions*/
						}
					});
				}
			}
		},
		scrollTo:function(scrollTo,options){
			var defaults={
				moveDragger:false,
				callback:true
			},
				options=$.extend(defaults,options),
				$this=$(this),
				scrollToPos,
				mCustomScrollBox=$this.find(".mCustomScrollBox"),
				mCSB_container=mCustomScrollBox.children(".mCSB_container");
			if(!$(document).data("mCS-is-touch-device")){
				var mCSB_draggerContainer=$this.find(".mCSB_draggerContainer"),
					mCSB_dragger=mCSB_draggerContainer.children(".mCSB_dragger");
			}
			var targetPos;
			if(scrollTo){
				if(typeof(scrollTo)==="number"){ /*if integer, scroll by number of pixels*/
					if(options.moveDragger){ /*scroll dragger*/
						scrollToPos=scrollTo;
					}else{ /*scroll content by default*/
						targetPos=scrollTo;
						scrollToPos=Math.round(targetPos/$this.data("scrollAmount"));
					}
				}else if(typeof(scrollTo)==="string"){ /*if string, scroll by element position*/
					var target;
					if(scrollTo==="top"){ /*scroll to top*/
						target=0;
					}else if(scrollTo==="bottom" && !$this.data("horizontalScroll")){ /*scroll to bottom*/
						target=mCSB_container.outerHeight()-mCustomScrollBox.height();
					}else if(scrollTo==="left"){ /*scroll to left*/
						target=0;
					}else if(scrollTo==="right" && $this.data("horizontalScroll")){ /*scroll to right*/
						target=mCSB_container.outerWidth()-mCustomScrollBox.width();
					}else if(scrollTo==="first"){ /*scroll to first element position*/
						target=$this.find(".mCSB_container").find(":first");
					}else if(scrollTo==="last"){ /*scroll to last element position*/
						target=$this.find(".mCSB_container").find(":last");
					}else{ /*scroll to element position*/
						target=$this.find(scrollTo);
					}
					if(target.length===1){ /*if such unique element exists, scroll to it*/
						if($this.data("horizontalScroll")){
							targetPos=target.position().left;
						}else{
							targetPos=target.position().top;
						}
						if($(document).data("mCS-is-touch-device")){
							scrollToPos=targetPos;
						}else{
							scrollToPos=Math.ceil(targetPos/$this.data("scrollAmount"));
						}
					}else{
						scrollToPos=target;
					}
				}
				/*scroll to*/
				if($(document).data("mCS-is-touch-device")){ /*is touch device*/
					if($this.data("horizontalScroll")){
						mCustomScrollBox.stop().animate({scrollLeft:scrollToPos},$this.data("scrollInertia"),$this.data("scrollEasing"),function(){
							if(options.callback){
								$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container);
							}
						});
					}else{
						mCustomScrollBox.stop().animate({scrollTop:scrollToPos},$this.data("scrollInertia"),$this.data("scrollEasing"),function(){
							if(options.callback){
								$this.mCustomScrollbar("callbacks",mCustomScrollBox,mCSB_container);
							}
						});
					}
				}else{ /*not touch device*/
					if($this.data("horizontalScroll")){
						if(scrollToPos>=mCSB_draggerContainer.width()-mCSB_dragger.width()){ /*max dragger position is bottom*/
							scrollToPos=mCSB_draggerContainer.width()-mCSB_dragger.width();
						}
						mCSB_dragger.css("left",scrollToPos);
					}else{
						if(scrollToPos>=mCSB_draggerContainer.height()-mCSB_dragger.height()){ /*max dragger position is bottom*/
							scrollToPos=mCSB_draggerContainer.height()-mCSB_dragger.height();
						}
						mCSB_dragger.css("top",scrollToPos);
					}
					if(options.callback){
						$this.mCustomScrollbar("scroll");
					}else{
						$this.mCustomScrollbar("scroll",true);
					}
				}
					
			}
		},
		callbacks:function(mCustomScrollBox,mCSB_container){
			var $this=$(this);
			if(!$(document).data("mCS-is-touch-device")){ /*not touch device*/
				if($this.data("horizontalScroll")){
					var mCSB_containerX=Math.round(mCSB_container.position().left);
					if(mCSB_containerX<0 && mCSB_containerX<=mCustomScrollBox.width()-mCSB_container.outerWidth()+$this.data("onTotalScroll-Offset")){
						$this.data("onTotalScroll-Callback").call();
					}else{
						$this.data("onScroll-Callback").call();
					}
				}else{
					var mCSB_containerY=Math.round(mCSB_container.position().top);
					if(mCSB_containerY<0 && mCSB_containerY<=mCustomScrollBox.height()-mCSB_container.outerHeight()+$this.data("onTotalScroll-Offset")){
						$this.data("onTotalScroll-Callback").call();
					}else{
						$this.data("onScroll-Callback").call();
					}
				}
			}else{ /*is touch device*/
				if($this.data("horizontalScroll")){
					var mCustomScrollBoxX=Math.round(mCustomScrollBox.scrollLeft());
					if(mCustomScrollBoxX>0 && mCustomScrollBoxX>=mCSB_container.outerWidth()-$this.width()-$this.data("onTotalScroll-Offset")){
						$this.data("onTotalScroll-Callback").call();
					}else{
						$this.data("onScroll-Callback").call();
					}
				}else{
					var mCustomScrollBoxY=Math.round(mCustomScrollBox.scrollTop());
					if(mCustomScrollBoxY>0 && mCustomScrollBoxY>=mCSB_container.outerHeight()-$this.height()-$this.data("onTotalScroll-Offset")){
						$this.data("onTotalScroll-Callback").call();
					}else{
						$this.data("onScroll-Callback").call();
					}
				}
			}
		}
	}
	$.fn.mCustomScrollbar=function(method){
		if(methods[method]){
			return methods[method].apply(this,Array.prototype.slice.call(arguments,1));
		}else if(typeof method==="object" || !method){
			return methods.init.apply(this,arguments);
		}else{
			$.error("Method "+method+" does not exist");
		}
	};
})(jQuery);


$(function () {

	$("table tr:first-child :first-child").addClass("tl");
	$("table tr:first-child :last-child").addClass("tr");
	$("table tr:last-child :first-child").addClass("bl");
	$("table tr:last-child :last-child").addClass("br");

	/* Some functional requirements for IE7 */
	if (detectBrowser() <= 8) {
		$("*").on("focus blur", function (e) {
			if (e.type == "focus") {
				$(this).addClass("focus");
			} else {
				$(this).removeClass("focus");
			}
		});
	}
	$('*:last-child').each(function (i) { $(this).addClass('last-child'); });
	/*$('*:first-child').each(function (i) { $(this).addClass('first-child'); });
	$("#header-submit").on("hover focus blur", function (e,f) {
		if (e.type == "mouseenter" || e.type == "focus") {
			$(this).attr("src", "/news-theme/images/form-images/header-search-hover.png");
		} else {
			$(this).attr("src", "/news-theme/images/form-images/header-search.png");
		}
	});*/

	/* Select Menu Transformation */
	
 	 setIe7Class();
	 selectRegion();
	 setChain();
	 selectArchiveMonthId();	
	
	$('select#city-select').selectmenu({ style:'dropdown', width:100 });
	$('select#country-select').selectmenu({ style:'dropdown', width:230 });
	$('select#filter-select').selectmenu({ style:'dropdown', width:325 });





	$("#fetchComments").click(function () {
		loadMoreComments();
		return false;
	});






	var activePolicyLink = "";
	$("a.dialog-commenting-policy").click(function () {
		activePolicyLink = $(this);
		var url = $(this).attr("href");
		$("#dialog").load(url+" article", function (r,s,x) {
			if (s=="error") {
				var data = '<h1>Sorry, there was an error</h1><p>The content you have requested cannot be found. If this problem persists please contact us and supply the following information:</p><code>'+url+' '+x.status+' '+x.statusText+'</code>';
				$("#dialog").html(data);
			}
			$("#dialog").dialog({
				height: 512,
				width: 620,
				modal: true,
				resizable: false,
				draggable: false,
				open: function () {
					$(".ui-widget-overlay").css({zIndex:700});
					$(".ui-dialog-content").mCustomScrollbar({scrollButtons:{
							enable:true,
							scrollType:"pixels",
							scrollAmount:32,
							scrollSpeed: 1000
						},
						set_height: 419,
						scrollInertia: 100
					});
				},
				zIndex:999
			});
			$("#dialog").parent(".ui-dialog").find(".ui-dialog-titlebar-close").unbind('click').show().bind('click', function () {
				$("#dialog").dialog("close");
    			$(activePolicyLink).focus();
    			activePolicyLink = "";
    			return false;
			});
		});
		return false;
	});
	$('.ui-widget-overlay').live("click", function() {
    	$("#dialog").dialog("close");
    	$(activePolicyLink).focus();
    	activePolicyLink = "";
	});

	$('.ui-dialog-titlebar-close').live("click", function() {
    	$("#dialog").dialog("close");
    	$(activePolicyLink).focus();
    	activePolicyLink = "";
	});
	$("*").on("keydown", function (e) {
		if ($(".ui-widget-overlay").is(":visible")) {
			if (e.keyCode == 38) {
				// up
				$(".mCSB_buttonUp").click();
				e.preventDefault();
			} else if (e.keyCode == 40) {
				// down
				$(".mCSB_buttonDown").click();
				e.preventDefault();
			}
		} else if (e.keyCode == 27 && typeof activePolicyLink != "") {
			// escape
			$("#dialog").dialog("close");
    		$(activePolicyLink).focus();
    		activePolicyLink = "";
    	}
	});










	$("#carousel-slider > ul li figure").css({ cursor:"pointer" }).click(function () {
		window.location = $(this).prev().children("h1").children("a").attr("href");
	});

	if ($("#carousel-slider > ul").length >= 2) {
		

		$("#carousel-right, #carousel-left").css({ "visibility":"visible" });

		var carouselSliderWidth = $("#carousel-slider > ul").length * 900;
		$("#carousel-slider").css({width:carouselSliderWidth, height:"auto"});

		$("#carousel-left, #carousel-hidden").removeClass("hidden");
		$("#carousel-left").addClass("inactive");

		$("#carousel-slider > ul").each(function (i) {
			var n = i + 1;
			$(this).attr("id", "carouselItem-"+i);
			if (i == 0) {
				$("#carousel-status").append('<a rel="'+i+'" class="active">Slide '+n+'</a>');
			} else {
				$("#carousel-status").append('<a rel="'+i+'">Slide '+n+'</a>');
			}
			
			$("#carousel-slider ul#carouselItem-"+i+" li:first-child div h1 a").addClass("first");
			$("#carousel-slider ul#carouselItem-"+i+" li:last-child div a.likes").addClass("last");
		});

		var carouselStatusWidth = $("#carousel-status a").length * 15;
		if (carouselStatusWidth > 900) { carouselStatusWidth = 900; }

		$("#carousel-status").width(carouselStatusWidth);

		$("#carousel-slider ul#carouselItem-"+parseInt($("#carousel-status a:first-child").attr("rel"))+" li:first-child div h1 a").removeClass("first");
		$("#carousel-slider ul#carouselItem-"+parseInt($("#carousel-status a:last-child").attr("rel"))+" li:last-child div a.likes").removeClass("last");

		$("div#carousel-status a").on("click", function () {
			carouselMoveTo($(this).attr("rel"));
			return false;
		});

		$("div#carousel > a").on("click", function () {
			if ($(this).attr("id") == "carousel-left") {
				carouselMoveTo(ccurrentSlide - 1);
			} else {
				carouselMoveTo(ccurrentSlide + 1);
			}
			return false;
		});



		$("#carousel-slider a").on("focus keydown", function (e) {
			if (e.keyCode == "9") {
				// So we're tabbing
				if (e.shiftKey) {
					// Shift tabbing
					if ($(this).hasClass("first")) {
						carouselMoveTo(ccurrentSlide - 1);
						e.preventDefault();
					}
				} else {
					// Normal tabbing
					if ($(this).hasClass("likes") && $(this).hasClass("last")) {
						carouselMoveTo(ccurrentSlide + 1);
						e.preventDefault();
					}
				}
			}
		});

		$("body").keydown(function(e) {
			if(e.keyCode == 37) {
				carouselMoveTo(ccurrentSlide - 1);
			} else if (e.keyCode == 39) {
				carouselMoveTo(ccurrentSlide + 1);
			}
		});

	}

	$("input[readonly]").on("focus", function () {
		$(this).blur();
	});

	$("#postCodeControl").click(function () {
		$(this).toggleClass("active");
		$("#postcodeContainer").toggle(0);
		//$("#current-city-postcode").focus();
		return false;
	});


	$("#tabbed-home a#most-liked, #tabbed-home a#most-commented").click(function () {

		$("a#most-liked, a#most-commented").removeClass("active");
		$(this).addClass("active");

		$("#tabbed-home ul").hide(0);
		$("#tabbed-home ul."+$(this).attr("id")).show(0);

		return false;

	});


	$("a#most-commented-module, a#most-liked-module").click(function () {

		$("a#most-commented-module, a#most-liked-module").removeClass("active");
		$(this).addClass("active");

		$("#most-commented-liked-module ul").hide(0);
		$("#most-commented-liked-module ul."+$(this).attr("id")).show(0);

		return false;

	});
$('select#ss-region').selectmenu({ style:'dropdown', width:207 });

	/*if (detectBrowser() == "firefox" && navigator.buildID > "20110303024726") {
		$("input[type='file']").each(function () {
			if (!$(this).hasClass("hidden")) {
				$(this).css({opacity:0.0001}).addClass("hidden").wrap($('<div class="uploader"></div>'));
				$(this).parent().append('<input type="text"><button>Browse</browse>')
				$(this).next().attr("readonly", true);
			}
		});
		$("input[type='file']").change(function () {
			$(this).next().val($(this).val());
		});
		$(".uploader button").on("click", function() {
			$(this).prev().prev().trigger("click");
			return false;
		});
	}*/
});



var ccurrentSlide = 0;	// Current slide
var cslides = 0;		// Number of slides
var cslideWidth = 0;	// Width of each slide, must be the same!
var cActive = 0;		// Is the carousel currently moving
var cDistance = 0;		// Distance in pixels the carousel has to travel
var prevFrame = 0;		// The previous frame we accessed
var cDirection = "";	// Global var for the direction the carousel is traveling in
var cLooping = false;	// Want the carousel to loop when you reach the end using arrow keys?
function carouselMoveTo(targetFrame) {
	targetFrame = parseInt(targetFrame);
	if (prevFrame > targetFrame) {
		cDirection = "backwards";
	} else {
		cDirection = "forwards";
	}
	cslideWidth = $("#carousel-slider > ul").outerWidth(true);
	cslides = parseInt($("#carousel-status a:last").attr("rel"));
	if (targetFrame < 0) {
		if (cLooping) {
			targetFrame = cslides;
		} else {
			return false;
		}
	} else if (targetFrame > cslides) {
		if (cLooping) {
			targetFrame = 0;
		} else {
			return false;
		}
	}
	cDistance = targetFrame * cslideWidth;
	if (cActive == 0) {
		cActive = 1;
		$("#carousel-slider").animate({"margin-left":"-"+cDistance+"px"}, 1000, function () {
			//$("ul#carouselItem-"+targetFrame+" li:first-child div h1 a").focus();
			$("#carousel-status a").removeClass("active");
			$("#carousel-status a[rel='"+targetFrame+"']").addClass("active");
			prevFrame = parseInt(ccurrentSlide);
			ccurrentSlide = parseInt(targetFrame);
			cActive = 0;
			if (!cLooping && ccurrentSlide == 0) {
				$("#carousel-left").addClass("inactive");
			} else if (!cLooping && ccurrentSlide == cslides) {
				$("#carousel-right").addClass("inactive");
			} else {
				$("#carousel-left, #carousel-right").removeClass("inactive");
			}
		});
	}
}


var vcurrentSlide = 0;	// Current slide
var vslides = 0;		// Number of slides
var vslideWidth = 160;	// Width of each slide, must be the same!
var vActive = 0;		// Is the carousel currently moving
var vDistance = 0;		// Distance in pixels the carousel has to travel
var vprevFrame = 0;		// The previous frame we accessed
var vDirection = "";	// Global var for the direction the carousel is traveling in
var vLooping = false;	// Want the carousel to loop when you reach the end using arrow keys?
function vcarouselMoveTo(targetFrame) {
	targetFrame = parseInt(targetFrame);
	if (vprevFrame > targetFrame) {
		vDirection = "backwards";
	} else {
		vDirection = "forwards";
	}
	vslideWidth = $("#carousel-slider > ul").outerWidth(true);
	vslides = parseInt($("#carousel-status a:last").attr("rel"));
	if (targetFrame < 0) {
		if (vLooping) {
			targetFrame = vslides;
		} else {
			return false;
		}
	} else if (targetFrame > vslides) {
		if (vLooping) {
			targetFrame = 0;
		} else {
			return false;
		}
	}
	vDistance = targetFrame * vslideWidth;
	if (vActive == 0) {
		vActive = 1;
		$("#carousel-slider").animate({"margin-left":"-"+vDistance+"px"}, 1000, function () {
			$("ul#carouselItem-"+targetFrame+" li:first-child div h1 a").focus();
			$("#carousel-status a").removeClass("active");
			$("#carousel-status a[rel='"+targetFrame+"']").addClass("active");
			vprevFrame = parseInt(vcurrentSlide);
			vcurrentSlide = parseInt(targetFrame);
			vActive = 0;
			if (!vLooping && vcurrentSlide == 0) {
				$("#carousel-left").addClass("inactive");
			} else if (!vLooping && vcurrentSlide == vslides) {
				$("#carousel-right").addClass("inactive");
			} else {
				$("#carousel-left, #carousel-right").removeClass("inactive");
			}
		});
	}
}



//Video Carousel in results page


function loadVideo(video, loadVideo) {
	if (video == 0) {
		video = vSlides;
	} else if (video > vSlides) {
		video = 1;
	}

	$("#video-carousel-status a").removeClass("active");
	$("#video-carousel-status a[rel='"+video+"']").addClass("active");
	$("#video-carousel-slider div").removeClass("hover");
	if (!$("#video-carousel-slider div:nth-child("+video+")").hasClass("active")) {
		$("#video-carousel-slider div:nth-child("+prevThumb+")").removeClass("active");
		$("#video-carousel-slider div:nth-child("+video+")").addClass("hover");
		$("#video-carousel-slider div:nth-child("+video+")").addClass("active");
	}
	var videourl = $("#video-carousel-slider div.active a").attr("href");
	var imageurl = $("#video-carousel-slider div.active a img").attr("alt");
	
	var distance = (video - 3) * vSlideWidth;
	if (distance < 0) {
		distance = 0;
	}
	if (distance >= 0) {
		if (loadVideo) {
			$("#video-carousel-slider div").removeClass("active");
			$("#video-carousel-slider div:nth-child("+video+")").addClass("active");
		}
		$("#video-carousel-slider").animate({ "margin-left":"-"+distance+"px" }, 250, function () {
			if (loadVideo) {
				initPlayer(videourl, imageurl);
			}
		});
	}
	vCurrent = parseInt(video);
	prevThumb=parseInt(video);
}

function initPlayer(videourl, imageurl) {
	console.log(videourl);
	var providerType = 'video';
	if(videourl!=null && (videourl.indexOf('youtube.com') > -1)) {
		providerType = '';
	}
	jwplayer('mediaplayer').setup({
		'flashplayer': '/static/common/jwplayer/player.swf',
		'id': 'playerID',
		'width': '571',
		'height': '347',
		'file': videourl,
		'provider' : providerType,
		'image':imageurl,
		'stretching': 'exactfit',
		
		'plugins': {
			'gapro-2':{
			'trackstarts':true,
			'trackpercentage':true,
			'trackseconds': true,
			'idstring': '||Newsroom||-||Article - Result||-||'+ videourl+'||'
			}
		}
	});
}

var vCurrent = 0;
var vSlides = 0;
var vSlideWidth = 0;
var vLastVisible = 3;
var prevThumb=0;

$(function () {
	vSlides = $("#video-carousel-slider > div").length;
	vSlideWidth = $("#video-carousel-slider > div:first-child").outerWidth();
	if (vSlides >= 2) {
		$("#video-carousel-controls > a").css({ "visibility":"visible" });
		var vcarouselSliderWidth = $("#video-carousel-slider > div").length * parseInt(vslideWidth+5);
		$("#video-carousel-slider").css({width:vcarouselSliderWidth, height:"auto"});
		for (i=1;i<=vSlides;i++) {
			$("#video-carousel-status").append('<a rel="'+i+'">'+i+'</a>').css({width:i*15});
			if (i==1) {
				$("a", "#video-carousel-status").addClass("active");
			}
		}
		// Initial player should load
		if ($("#mediaplayer").length == 1) {
			loadVideo(1, true);
		}
		// Paddles
		$("#video-carousel-controls > a").click(function (e) {
			if ($(this).hasClass("left")) {
				loadVideo(vCurrent-1, false);
				e.preventDefault();
			} else {
				loadVideo(vCurrent+1, false);
				e.preventDefault();
			}
		});
		// Hover for the slides
		$("#video-carousel-slider > div").hover(function (e) {
			$("#video-carousel-slider div").removeClass("hover");
			$(this).addClass("hover");
			vCurrent = $(this).prevAll().length + 1;
		});
		// Thumbnail image per slide
		$("#video-carousel-slider > div a:first-child").bind("click", function (e) {
			loadVideo($(this).parent().prevAll().length + 1, true);
			e.preventDefault();
		});
		// Focus on any link
		$("#video-carousel-slider > div a").bind("focus", function (e) {
			loadVideo($(this).parent().prevAll().length + 1, false);
			e.preventDefault();
		});
		// Status nav items
		$("#video-carousel-status > a").bind("click", function (e) {
			loadVideo($(this).attr("rel"), true);
			e.preventDefault();
		});
	}
	else{
		// Initial player should load, if Video is One
		if ($("#mediaplayer").length == 1) 
		{
			var videourl = $("#video-carousel-slider div.active a").attr("href");
			var imageurl = $("#video-carousel-slider div.active a img").attr("alt");
			// Thumbnail image per slide
			$("#video-carousel-slider > div a:first-child").bind("click", function (e) {
				loadVideo($(this).parent().prevAll().length + 1, true);
				e.preventDefault();
			});
			initPlayer(videourl, imageurl);
		}
	}
});


// set cookie
function setCookie(c_name,value,exsecs)
{
	var exdate=new Date();
	exdate.setTime(exdate.getTime() + (exsecs * 1000));
	var c_value=escape(value) + ((exsecs==null) ? "" : "; expires="+exdate.toUTCString());
	// if it is a secure connection than secure should get added
	if (window.location.protocol == "https:") {
		c_value = c_value +  "; secure";
	}
	//var c_value=escape(value);
	document.cookie=c_name + "=" + c_value;
}

// get cookie
function getCookie(c_name)
{
	var i,x,y,ARRcookies=document.cookie.split(";");
	for (i=0;i<ARRcookies.length;i++)
	{
		x=ARRcookies[i].substr(0,ARRcookies[i].indexOf("="));
		y=ARRcookies[i].substr(ARRcookies[i].indexOf("=")+1);
		x=x.replace(/^\s+|\s+$/g,"");
		if (x==c_name)
		{
		return unescape(y);
		}
	}
}
 /* $(function(){
	$('nav ul li').click(function(){
		$('ul', $(this)).show();	
	});
	$('body').mouseup(function (e) {
			var $targ = $(e.target);									
			if ($targ.closest('nav ul li ul li').length) return;
			$('nav ul li ul').hide();
		});
})*/
/*Header Secondary Nav*/
$(function(){
		if($('nav ul li#mainnav-news').hasClass('selected'))
		{
			$('ul.secnav-news').show();
			$(function(){
				$('nav ul li#mainnav-news a.secnav').click(function(e){
					$(this).css('cursor','default');
					e.preventDefault();
				});
			});
		} 
 })
/*header secondary nav ends*/
 
$(document).ready(function() {
    $('.journal-article-header-edit').parent().parent().parent().css("background", "white");
    $('.portlet-announcements').css("background", "white");
});



String.prototype.escapeHTML = function () {
 	return (this.replace(/&/g, '%26amp;').replace(/>/g, '%26gt;').replace(/</g, '%26lt;').replace(/\'/g, '%26apos;').replace(/\"/g, '%26quot;'));
	};		
 


// Validation Functions for Search Newsroom  
function searchNewsFormSubmit(formElmt) {
	var keywords = document.getElementById("newsSearchKeywords").value;
	keywords = keywords.replace(/^\s+|\s+$/, '').toLowerCase();
	//keywords = keywords.replace(/[+#%&'<>]/g, "");
	keywords=keywords.escapeHTML();
	if (keywords == '' || keywords == 'Search Newsroom') {
		return false;
	} 
	//formElmt.submit();
	var sURL='/web/news/search?q=' + keywords+'&c=sub_news';
	window.location=sURL;
	
}


function onFocusNewsValidation(keyword) {
	
	if(keyword.value == 'Search Newsroom') { keyword.value = ''; }
}

function onBlurNewsValidation(keyword) {
	
	if(keyword.value == '') { keyword.value = 'Search Newsroom';keyword.style.color='#6d6d6d' }
}

jQuery(document).ready(function(){	
	jQuery('#newsSearchKeywords').attr('value','Search Newsroom');
})

//Adding JS sent by Dharmen

// for share
$(document).ready(function() {   

    //select all the a tag with name equal to modal
    $('a.modal').click(function(e) {
        //Cancel the link behavior
        e.preventDefault();
        //Get the A tag
        var id = $(this).attr('href');
   
        //Get the screen height and width
        var maskHeight = $(document).height();
        var maskWidth = $(window).width();
   
        //Set height and width to mask to fill up the whole screen
        $('body').append('<div id="mask"></div>');
        $('#mask').css({'width':maskWidth,'height':maskHeight});
       
        //transition effect       
        //$('#mask').fadeIn(150);   
        $('#mask').fadeTo("fast",0.3);   
   
        //Get the window height and width
        var winH = $(window).height();
        var winW = $(window).width();
             
        //Set the popup window to center
        $(id).css('top',  winH/2-$(id).height()/2);
        $(id).css('left', winW/2-$(id).width()/2);
   
        //transition effect
        $(id).fadeIn(600);
        $(id).fadeTo("slow",1);
   
    });
   
    //if close button is clicked
    $('.window .close').click(function (e) {
        //Cancel the link behavior
        e.preventDefault();
        $('.window').hide();
        $('#mask').remove();
    });       
   
    //if mask is clicked
    $('body').on('click', '#mask', function () {
        $('.window').hide();
        $(this).remove();
       
    });
   
   
});
function setChain() {
	var chainId = getCookie('chain');
	if (chainId == null || chainId == "") {
		chainId = "All";
	}
	if (document.getElementById(chainId) != null) {
		document.getElementById(chainId).setAttribute("class", "active");
		document.getElementById(chainId).setAttribute("className", "active");
	}
}
function selectChain(chainId)
{
	 setCookie('chain',chainId,900);
	 //window.location.reload();
	 var url = document.URL;
	 window.location= url;
}

function selectArchiveMonthId()
{
	var monthid = getCookie('monthid');
	if(monthid==null  ||  monthid=="")
	{
		monthid='monthid0';
	}
	if (document.getElementById(monthid) != null) 
	{
		document.getElementById(monthid).setAttribute("class", "active");
		document.getElementById(monthid).setAttribute("className", "active");
	}
}

function setdates(fromdate, todate, type)
{
	setCookie('fromdate',fromdate,900);
	setCookie('todate',todate,900);
	if(type==null)
		{
		type="ALL";
		}
	setCookie('aftype',type,900);
}
function setselectedtype(fromdate, todate, type)
{
	var element=document.getElementById('filter-select');
	if(element!=null)
	{
		type=element.value;
	}else
	{
		type="All";
	}
	setCookie('fromdate',fromdate,900);
	setCookie('todate',todate,900);
	setCookie('aftype',type,900);
	setCookie('monthid','monthid0',900);
}

function setArchivalMonthId(monthId)
{
	setCookie('monthid',monthId,900);
	//window.location.reload();
	var url = document.URL;
	window.location = url;
}
function selectRegion()
{
	$('#country-select option').filter(function() {
	   //may want to use $.trim in here
	    return $(this).val() == getCookie('region'); 
		}).attr('selected', true);
};
	
	function changeRegion()
	{
		var region=document.getElementById('country-select').value;
		_gaq.push(['_trackEvent', 'Header', 'Newsroom_RegionSelect', region]);
		 setCookie('region',region,900);
		 var url = document.URL;
		 if (document.getElementById("setregion").value != "" && document.getElementById("setregion").value != null) {
			 url = url.replace(document.getElementById("setregion").value, region);
		 }
		 document.getElementById("setregion").value = region;
		 //window.location.reload();
		 window.location = url;
	}
		
	
	function setIe7Class()
	{
		var nAgt = navigator.userAgent;
		var fullVersion  = ''+parseFloat(navigator.appVersion); 
		var verOffset;
	
		if ((verOffset=nAgt.indexOf("MSIE"))!=-1) 
		{
		 fullVersion = nAgt.substring(verOffset+5);
		}
		if (fullVersion.indexOf('Windows')!=-1 &&  fullVersion.indexOf('Trident')==-1)
		{
			jQuery('html').addClass('ltr yui3-js-enabled trident ltr js ie ie7 ie7-0 win');
		}
	}
	