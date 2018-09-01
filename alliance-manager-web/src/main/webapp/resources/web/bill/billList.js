var valArrs =new Array;
var page="p1";
$(function(){
	billQuery();
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
function billQuery(){
	obj = new Object();
	obj.custId = $("#custId").val();
	obj.custName = $("#autocomplete").val();
	if ($(".count-tab>li.on").attr("id") == "intab") {
		inBill(1,8);
	} else {
		outBill(1,8);
	}
}

function outBill(n,s){
	var array=getSelect(page);
	page=n;
	var index = layer.load(2);
	var custId = "";
	var custName = "";
	if(obj != null) {
		custId = obj.custId;
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + "/bill/outBillPage.ajax",
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
				$("#outBody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						if(array.indexOf(list[i].billId.toString())>=0){
							
							tr.append("<td class='check-col'><a href=\"javascript:deletBilling('"+list[i].billId+"');\" class='checkbox p"+n+" on'></a><input checked='checked' type='checkbox' name='billId_"+n+"' value='"+list[i].billId+"'></td>");
						}else{
							tr.append("<td class='check-col'><a href=\"javascript:deletBilling('"+list[i].billId+"');\" class='checkbox p"+n+"'></a><input  type='checkbox' name='billId_"+n+"' value='"+list[i].billId+"'></td>");	
						}
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].contId+"</td>");
						tr.append("<td>"+list[i].billBatch+"</td>");
						tr.append("<td>"+onload(list[i].amount/1000)+"</td>");
						tr.append("<td>"+onload(list[i].totalFee/1000)+"</td>");
						tr.append("<td>"+list[i].dataVal+"</td>");
						tr.append("<td>"+formatDateTime(list[i].createDate)+"</td>");
						tr.append("<td>"+formatDateTime(list[i].confirmDate)+"</td>");
						$("#outBody").append(tr);
					}
					
					$("#outBody .checkbox").click(function(){
						
						if($(this).hasClass('on')){
			
							$(this).removeClass('on');
							
		                    $(this).next().removeAttr("checked");//取消全选     
			            } else {
		                    $(this).addClass('on');
		                    $(this).next().attr("checked",'true');//全选
			            }
				    });
					
					$("#outFoot").show();
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$("#outTable").after(noTips);
					$("#outFoot").hide();
					$(".page").html("");
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

/**
 * 获得所有选择的billId
 */
function getSelect(n){
		$("input[name='billId_"+n+"']:checkbox").each(function() {	
			if ("checked" == $(this).attr("checked")) {
				if(valArrs.indexOf($(this).val())<0){
					valArrs.push($(this).val());
				}
			}
		});
		return valArrs;
}
function deletBilling(billId){
	for(var i=0; i<valArrs.length; i++) {
	    if(valArrs[i] == billId) {
	    	valArrs.splice(i, 1);
	      break;
	    }
	  }

}
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}
function inBill(n,s){
	var index = layer.load(2);
	var custName = "";
	if(obj != null) {
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + "/bill/inBillPage.ajax",
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			custName:custName
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.code ==1){
				$("#inBody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].contId+"</td>");
						tr.append("<td>"+list[i].billBatch+"</td>");
						tr.append("<td>"+onload(list[i].amount/1000)+"</td>");
						tr.append("<td>"+onload(list[i].totalFee/1000)+"</td>");
						tr.append("<td>"+list[i].dataVal+"</td>");
						tr.append("<td>"+formatDateTime(list[i].createDate)+"</td>");
						tr.append("<td>"+formatDateTime(list[i].confirmDate)+"</td>");
						tr.append("<td>"+list[i].billMonth+"</td>");
						tr.append("<td>"+formatDateTime(list[i].billDate)+"</td>");
						$("#inBody").append(tr);
					}
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$("#inTable").after(noTips);
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function inCostBill() {
	//var index=layer.load(6);
	var ids = '';
	var flag = 0;
	var array=getSelect(page);
	if(array!=null&&array.length>0){
		for(var i=0;i<array.length;i++){
			ids += array[i]+',';
		}
		flag += 1;
	}
	
	if (flag == 0) {
		layer.alert("请至少选择一项");
		layer.close(index);
		return;
	}
	
	layer.confirm("本次共"+array.length+'条入账,由于数据量过大，请选择后一次性入账！', function(){
		$.ajax({
			url: ctx + "/bill/inBill.ajax",
			type: "POST",
			dataType: "json",
			data: {
				billId : ids
			},
			success : function (cr) {
				if(cr.code ==1){
					layer.closeAll();
					layer.alert("入账中，请勿再次入账！");
                    setTimeout(window.location.href = ctx + "/bill/home.html",2000);
				}else{
					layer.closeAll();
					layer.alert(cr.msg);
				}
			}
		});
	});   
	
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