var elmHeight="33";jQuery.fn.extend({dgStyle:function(){$.each($(this),function(){var a=$(this).children().get(0);elmType=$(a).attr("type");$(this).data("type",elmType);$(this).data("checked",$(a).attr("checked"));$(this).dgClear()});$(this).mousedown(function(a){$(this).dgHandle()})},dgClear:function(){if($(this).data("checked")=="checked"){$(this).css("backgroundPosition","center -"+(elmHeight*2)+"px")}else{$(this).css("backgroundPosition","center 0")}},dgEffect:function(){if($(this).data("checked")=="checked"){$(this).css({backgroundPosition:"center -"+(elmHeight*3)+"px"})}else{$(this).css({backgroundPosition:"center -"+(elmHeight)+"px"})}},dgHandle:function(){var a=$(this).children().get(0);if($(this).data("checked")=="checked"){$(a).dgUncheck(this)}else{$(a).dgCheck(this)}if($(this).data("type")=="radio"){$.each($("input[name='"+$(a).attr("name")+"']"),function(){if(a!=this){$(this).dgUncheck(-1)}})}},dgCheck:function(a){$(this).attr("checked","checked");$(a).data("checked","checked").css({backgroundPosition:"center -"+(elmHeight*2)+"px"})},dgUncheck:function(a){$(this).attr("checked",false);if(a!=-1){$(a).data("checked",false).css({backgroundPosition:"center 0"})}else{$(this).parent().data("checked",false).css({backgroundPosition:"center 0"})}}});