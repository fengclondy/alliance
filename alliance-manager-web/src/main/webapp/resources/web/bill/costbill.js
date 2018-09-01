$(function(){
	costBillQuery();
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
	        $("#s_custId").val(ui.item.id);
	    } 
    });
});
var obj = new Object();
function costBillQuery() {
	obj = new Object();
	obj.custName = $("#autocomplete").val();
	obj.custId = $("#s_custId").val();
	costBillPage(1,8);
}

function costBillPage(n, s) {
	var index = layer.load(2);
	var custName = "";
	var custId = "";
	if(obj != null) {
		custName = obj.custName;
		custId = obj.custId;
	}
	$.ajax({
		url: ctx + "/bill/costBillListPage.ajax",
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			custName:custName,
			custId:custId
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.code ==1){
				$("#costBill").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].regionName+"</td>");
						tr.append("<td>"+list[i].billMonth+"</td>");
						tr.append("<td>"+onload(list[i].billFee/1000)+"</td>");
						tr.append("<td>"+list[i].usedData+"</td>");
						tr.append("<td>"+formatDateTime(list[i].createDate)+"</td>");
						tr.append("<td><a href=\"javascript:costBillItem('"+list[i].custId+"','"+list[i].billMonth+"');\" class='tf-btn'></a></td>");
						$("#costBill").append(tr);
					}
					
					$(".page").html(cr.reModel.html);
				} else {
					/*$("#costBill").append("<tr><td colspan='8'>未找到任何内容</td></tr>");*/
					$(".page").empty();
					$("#table").after(noTips);
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
function tf(){
    layer.open({
      type: 1,
      title:"摊分用户",
      area: ['930px', '530px'], //宽高
      btn: ['导出','取消'],
      content: $("#tf"),
      yes:function(){
    	 exportExcel();
      },
      success:function(){
    	  $(".tf-content").niceScroll({styler:"fb",cursorcolor:"#adadb0", cursorwidth: '4', cursorborderradius: '10px', cursorborder: '', zindex: '1000'});
      }
    });
}

var custIdP = "";
var billMonthP = "";
function costBillItem(custId, billMonth) {
	
	custIdP = custId;
	billMonthP = billMonth;
	
	$.ajax({
		url: ctx + "/bill/costBillItemList.ajax",
		type: "POST",
		dataType: "json",
		data: {
			custId : custId,
			billMonth : billMonth
		},
		success: function(cr) {
			$("#billItem").empty();
			var list = cr.reModel;
			if (list.length > 0) {
				for(var i=0;i<list.length;i++){
					var tr = $("<tr></tr>");
					tr.append("<td>"+list[i].custName+"</td>");
					tr.append("<td>"+list[i].costRegionName+"</td>");
					tr.append("<td>"+list[i].billMonth+"</td>");
					tr.append("<td>"+onload(list[i].billFee/1000)+"</td>");
					tr.append("<td>"+list[i].income/1000+"</td>");
					tr.append("<td>"+list[i].usedData+"</td>");
					$("#billItem").append(tr);
				}
				
			} else {
				$("#billItem").append("<tr><td colspan='8'>未找到任何内容</td></tr>");
			}
			tf();
		}
	});
	
}

function exportExcel() {
	window.location.href = ctx + "/bill/exportItem.ajax?custId="+custIdP+"&billMonth="+billMonthP;
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