$(function(){
	columnChargeQuery();
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
function columnChargeQuery(){
	obj = new Object();
	obj.custId = $("#custId").val();
	obj.custName = $("#autocomplete").val();
	page(1,8);
}

function page(n,s) {
    if ($(".count-tab>li.on").attr("id") == "waittab") {
        listWaitColumnCharge(1,8);
    } else {
        listHis(1,8);
    }
}

function listWaitColumnCharge(n,s){
	var index = layer.load(2);
	var custId = "";
	var custName = "";
	if(obj != null) {
		custId = obj.custId;
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + "/contract/columnChargePage.ajax",
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
				$("#waitTable tbody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						tr.append("<td class='check-col'><a href='javascript:;' class='checkbox'></a><input type='checkbox' name='contId' value='"+list[i].contId+"'></td>");
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].contId+"</td>");
						tr.append("<td>"+$.toYuanFix2(list[i].balance)+"</td>");
						tr.append("<td>已过期</td>");
						tr.append("<td>"+$.formatDateTime(list[i].expDate)+"</td>");
						$("#waitTable tbody").append(tr);
					}
					
					$("#waitTable .checkbox").click(function(){
						if($(this).hasClass('on')){
							$(this).removeClass('on');
		                    $(this).next().removeAttr("checked");//取消全选     
			            } else {
		                    $(this).addClass('on');
		                    $(this).next().attr("checked",'true');//全选
			            }
				    });
					
					$("#waitFoot").show();
                    $("#waitTable .page").html(cr.reModel.html);
				} else {
                    $("#waitTable .page").empty();
					$("#waitTable").after(noTips);
					$("#waitFoot").hide();
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function listHis(n,s){
	var index = layer.load(2);
    var custId = "";
    var custName = "";
    if(obj != null) {
        custId = obj.custId;
        custName = obj.custName;
    }
	$.ajax({
		url: ctx + "/contract/columnChargeHis.ajax",
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			custName:custName,
            custId : custId
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.reType){
				$("#hisTable tbody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
                        tr.append("<td>"+list[i].custName+"</td>");
                        tr.append("<td>"+list[i].contId+"</td>");
                        tr.append("<td>"+$.toYuanFix2(list[i].amount)+"</td>");
                        tr.append("<td>"+$.formatDateTime(list[i].operDate)+"</td>");
                        tr.append("<td>"+$.formatDateTime(list[i].expDate)+"</td>");
                        tr.append("<td>"+list[i].username+"</td>");
						$("#hisTable tbody").append(tr);
					}
                    $("#hisTable .page").html(cr.reModel.html);
				} else {
                    $("#hisTable .page").empty();
					$("#hisTable").after(noTips);
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function columnCharge() {
	var index = layer.load(6);
	var ids = '';
	var flag = 0;
	
	$("input[name='contId']:checkbox").each(function() {
		if ("checked" == $(this).attr("checked")) {
			ids += $(this).attr('value')+',';
			flag += 1;
		}
	});
	
	if (flag == 0) {
		layer.alert("请至少选择一项");
		layer.close(index);
		return;
	}
	
	layer.confirm('是否确定列收?', function(index){
		layer.load(index);
		$.ajax({
			url: ctx + "/contract/columnCharge.ajax",
			type: "POST",
			dataType: "json",
			data: {
				contId : ids
			},
			success : function (cr) {
				if(cr.code ==1){
					layer.close(index);
					layer.alert("列收成功！");
					columnChargeQuery();
				}else{
					layer.alert(cr.msg);
					layer.closeAll();
				}
			}
		});
	});
	layer.close(index);
}