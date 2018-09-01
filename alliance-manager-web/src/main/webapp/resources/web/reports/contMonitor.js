$(function(){
	contMonitor();
	$( "#autocomplete" ).autocomplete({
        source: function(request, response){
        	$.ajax({
        		url:  ctx + "/cust/listCust4Query.ajax",
        		type:"post",
        		data:{
        			custName:$("#autocomplete").val()
        		},
        		success:function(cr){
        			var list = cr.reModel;
        			response($.map(list,function(item){  
                        var name = item.custName;  
                        var id = item.custId;  
                        return {  
                            label:item.custName,//下拉框显示值  
                            value:item.custName,//选中后，填充到下拉框的值  
                            id:item.custId//选中后，填充到id里面的值  
                        }  
                    }));
        		}
        	});
        },
		delay: 500,//延迟500ms便于输入  
	    select : function(event, ui) {  
	        $("#custId").val(ui.item.id);
	    } 
    });
});



var obj = new Object();
function contMonitor(){
	obj = new Object();
	obj.custId = $("#custId").val();
	obj.custName = $("#autocomplete").val();
	page(1,8)
}

function page(n,s){
	var index = layer.load(2);
	var custId = "";
	var custName = "";
	if(obj != null) {
		custId = obj.custId;
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + "/reports/pageMonitor.ajax",
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			custName : custName,
			custId : custId
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.code ==1){
				$("#contBody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].regionName+"</td>");
						tr.append("<td>"+list[i].contId+"</td>");
						tr.append("<td>"+list[i].remainDay+"</td>");
						tr.append("<td>"+onload(list[i].currVal/1000)+"</td>");
						tr.append("<td>"+onload(list[i].balance/1000)+"</td>");
						tr.append("<td>"+onload(list[i].amount/1000)+"</td>");
						tr.append("<td>"+list[i].authorizePro+"</td>");
						tr.append("<td>"+onload(list[i].contValue/1000)+"</td>");
						tr.append("<td>"+list[i].contPro+"</td>");
						$("#contBody").append(tr);
					}
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$("#contTable").after(noTips);
					$(".page").html("");
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}



function  formatDateTime(time)  {   
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

function exportReport(ii) {
	window.location.href = ctx + "/reports/exportReports.html?index=" + ii + "&custId=" + obj.custId + "&custName=" + obj.custName;
}