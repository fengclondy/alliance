(function($){
	$.fn.ta = function(options,successfn){
		var index = layer.load(2);
		var defaults = {
			url:"",
			pageNo:1,
			pageSize:8
		}
		var options = $.extend(defaults, options);
		var $this = $(this);
		var r;
		$.ajax({
			url: options.url,
			type: "POST",
			dataType:"json",
			data:options,
			success : function (cr) {
				layer.close(index);
				if(cr.code ==1){
					$this.children("tbody").empty();
					r = cr.reModel.page.list;
					successfn(r);
					$(".footer_page").html(cr.reModel.page.html);
				}else{
					layer.alert(cr.message);
					return false;
				}
				
			}
		});
	};
})(jQuery);