

function exportexcel(){    
	var custId = $("#s_custId").val();
	var custName = $("#autocomplete").val();
	var beginDate = $("#s_beginDate").val();
	var endTime = $("#s_endTime").val();
	var billState = $("#s_billState").val()
	var state = $("#s_recharageState").val();
	var index = layer.load(6);
	   $.ajax({
	    type:"post",
	    url: ctx +"/data/extendExportTel.ajax",
	    data:{
	    	custId:custId,
	    	custName:custName,
	    	beginDate:beginDate,
	    	endTime:endTime,
	    	billState:billState,
	    	state:state
	    },
	    dataType:"json",
	    success:function(data){
	           if(data.reModel.excelFlag=="0")   
	     {
	       
	     //waiting = commentWaitTips("读取中...");
	     var o =setInterval(function(){
	      $.ajax({
	      type : "post",
	      url : ctx +"/data/extendExportFlag.ajax",
	      data:{
	      },
	      dataType : "text",
	      success : function(data) {
	       if(data.reModel=="1"){
	    	 layer.close(index); 
	        clearInterval(o);
	        var iframe = document.createElement("iframe");
	        iframe.src = ctx +"/data/extendExportDownload.ajax";
	        iframe.style.display = "none";
	        document.body.appendChild(iframe);
	       }
	      }
	      });
	     }, 2000);
	     }
	    }
	    });
	}


//导出报表
function exportList(){
	    	 var custName = $("#s_custName").val();
	    	 var beginDate = $("#s_beginDate").val();
			var endTime = $("#s_endTime").val();
			var billState = $("#s_billState").val()
			var state = $("#s_recharageState").val();
			//?custName="+custName+"&beginDate="+beginDate+"&endTime="+endTime+"&billState="+billState+"&billState="+billState+"&state="+state
			window.location.href="/manager-web/data/exportRecDetail.html";
		  }
		  
function clearList(){
	$("#search-list").hide();
	$("#search-list").empty();
}

function setSearchCust(val, txt){
	$("#s_custName").val(txt);
	
	clearList();
}