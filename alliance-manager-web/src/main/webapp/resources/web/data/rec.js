$(function(){
	$('select').selectOrDie({size: 10});
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
	
	//recQuery();
});

function recQuery() {
	var index = layer.load(2);
	if(ckdate()){
	page(1, 8);
	}else{
		layer.close(index);
		layer.open({
					  type: 1,
					  title:"温馨提示",
					  area: ['230px', '150px'], //宽高
					  btn: ['确定'],
					  content: $("#erro_date").text('结束日期不能小于开始日期'),
					  yes:function(){
						  layer.closeAll();
					  },
					  success:function(){
						  $('select').selectOrDie();
					  }
					});
		return;
	}
}

function load1() {
	$(".footer_page").empty();
}

function page(n, s) {

	var custId = $("#s_custId").val();;
	var custName = $("#autocomplete").val();
	var beginDate = $("#s_beginDate").val();
	var endTime = $("#s_endTime").val();
	var billState = $("#s_billState").val();
	var recharageState = $("#s_recharageState").val();
	var index = layer.load(2);

	$.ajax({

		url : ctx + '/data/recDetailPage.ajax',
		type : "POST",
		dataType : "json",
		data : {
			pageNo : n,
			pageSize : s,
			custId : custId,
			custName : custName,
			beginDate : beginDate,
			endTime : endTime,
			billState : billState,
			state : recharageState
		},
		success : function(data) {
			$("#noData").remove();
			var list = data.reModel.list;
			layer.close(index);
			if(data.reType){
			$("#listRecDetailTab>tbody").empty();
			if (list.length == 0) {
				$("#listRecDetailTab").after(noTips);
				$(".footer_page").empty();
				return;
			};
			if(list.length>0){
			for (var i = 0; i < list.length; i++) {
				var tr = $("<tr></tr>");
				var msg ="";
				
				        tr.append("<td>"+list[i].userNbr+"</td>");
						tr.append("<td>"+list[i].dataTypeName+"</td>");
						tr.append("<td>"+list[i].dataVal+"</td>");
						tr.append("<td>"+onload(list[i].billFee/1000)+"</td>");
						tr.append("<td>"+(list[i].sEndDate==null? "" : list[i].sEndDate)+"</td>");
						tr.append("<td>"+list[i].stateName+"</td>");
						if(list[i].errMesg!=""&&null!=list[i].errMesg){
							msg=list[i].errMesg;
							msg= subcontent(msg);							
							//显示详情
							tr.append("<td title="+list[i].errMesg+">"+msg+"</td>");
						}else{
							tr.append("<td>"+msg+"</td>");							
						}
						tr.append("<td>"+(list[i].billBatch==""||list[i].billBatch==null? "待出账" : list[i].billBatch)+"</td>");
						tr.append("<td>"+(list[i].billMonth==""||list[i].billMonth==null? "待入账" : list[i].billMonth)+"</td>");
						$("#listRecDetailTab>tbody").append(tr);
					}
			
					$(".footer_page").html(data.reModel.html);
					}
			}else{
				layer.alert(data.msg);
			}
		}

	});
}
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}
// 导出报表
function exportList() {
	var custId = $("#s_custId").val();
	var custName = $("#autocomplete").val();
	var beginDate = $("#s_beginDate").val();
	var endTime = $("#s_endTime").val();
	var billState = $("#s_billState").val()
	var state = $("#s_recharageState").val();
	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("target", "");
	form.attr("method", "post");
	form.attr("action", ctx + "/data/exportRecDetail.html");
	var input1 = $("<input>");
	input1.attr("type", "hidden");
	input1.attr("name", "custId");
	input1.attr("value", custId);
	var input2 = $("<input>");
	input2.attr("type", "hidden");
	input2.attr("name", "beginDate");
	input2.attr("value", beginDate);
	var input3 = $("<input>");
	input3.attr("type", "hidden");
	input3.attr("name", "endTime");
	input3.attr("value", endTime);
	var input4 = $("<input>");
	input4.attr("type", "hidden");
	input4.attr("name", "billState");
	input4.attr("value", billState);
	var input5 = $("<input>");
	input5.attr("type", "hidden");
	input5.attr("name", "state");
	input5.attr("value", state);
	var input6 = $("<input>");
	input6.attr("type", "hidden");
	input6.attr("name", "custName");
	input6.attr("value", custName);
	$("body").append(form);
	form.append(input1);
	form.append(input2);
	form.append(input3);
	form.append(input4);
	form.append(input5);
	form.append(input6);

	var index = layer.load(2);
	if(ckdate()){
	
	form.submit();// 表单提交
	 layer.closeAll();
	}else{
		layer.close(index);
		layer.open({
					  type: 1,
					  title:"温馨提示",
					  area: ['230px', '150px'], //宽高
					  btn: ['确定'],
					  content: $("#erro_date").text('结束日期必须大于开始日期'),
					  yes:function(){
						  layer.closeAll();
					  },
					  success:function(){
						  $('select').selectOrDie();
					  }
					});
		return;
	}

}
function ckdate() {
            var starttime = $('#s_beginDate').val();
            var endtime = $('#s_endTime').val();
           var start = new Date(starttime);  
           var end = new Date(endtime);  
            if (end <= start) {
                return false;
            }
            else {
                return true;
            }
		
        }

function subcontent(content){
	if(getLength(content)>6){
		return content.substring(0,6)+"...";
	}else{
		return content;
	}
}
function getLength(str){
	 var realLength = 0, len = str.length, charCode = -1;
	    for (var i = 0; i < len; i++) {
	        charCode = str.charCodeAt(i);
	        if (charCode >= 0 && charCode <= 128) realLength += 1;
	        else realLength += 2;
	    }
	 return realLength;
}
