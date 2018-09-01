(function(c){
	c.extend({
	    include: function(id, path, file){
	    	if (document.getElementById(id)==null){
		        var files = typeof file == "string" ? [file] : file;
		        for (var i = 0; i < files.length; i++){
		            var name = files[i].replace(/^\s|\s$/g, "");
		            var att = name.split('.');
		            var ext = att[att.length - 1].toLowerCase();
		            var isCSS = ext == "css";
		            var tag = isCSS ? "link" : "script";
		            var attr = isCSS ? " type='text/css' rel='stylesheet' " : " type='text/javascript' ";
		            var link = (isCSS ? "href" : "src") + "='" + path + name + "'";
		            document.write("<" + tag + (i==0?" id="+id:"") + attr + link + "></" + tag + ">");
		        }
	    	}
	    },
        toYuanFix2: function(value) {
	    	if (value == null || typeof(value) == "undefined") {
	    		return "0.00";
			}
			var newValue;
			newValue = $.numDiv(value, 1000).toFixed(2);
			return newValue;
		},
        formatDateTime: function(time)  {
			if (time == null)
			{
				return "";
			}
			var now=new Date(time)
			var   year=now.getFullYear();
			var   month=now.getMonth()+1;
			var   date=now.getDate();
			var	hours=	now.getHours(); //获取系统时，
			if(hours<10){
				hours = "0"+hours;
			}
			var	minutes=now.getMinutes(); //分
			if(minutes<10){
				minutes = "0"+minutes;
			}
			var	second=now.getSeconds(); //秒
			if(second<10){
				second = "0"+second;
			}
			return   year+"-"+month+"-"+date+" "+hours+":"+minutes+":"+second;
		}
	});
})(jQuery);