$(function(){
	carryOverQuery();
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
function carryOverQuery(){
	obj = new Object();
	obj.custId = $("#custId").val();
	obj.custName = $("#autocomplete").val();
	if ($(".count-tab>li.on").attr("id") == "intab") {
		carryOverHis(1,8);
	} else {
		carryOverPage(1,8);
	}
}
/**
 * 结转分页
 * @param n
 * @param s
 */
var object=new Object();
function carryOverPage(n,s){
	var index = layer.load(6);
	var custId = "";
	var custName = "";
	if(obj != null) {
		custId = obj.custId;
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + "/contract/carryOverPage.ajax",
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			funcName:"carryOverPage",
			custName : custName,
			custId : custId
		},
		success : function (data) {
			$("#noData").remove();
			layer.close(index);
			if(data.reType){
				$("#carryOverBody").empty();
				var list = data.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						custId = list[i].custId;
						// orgContId = list[i].contId;
                        // amount=list[i].amount;
						var tr = $("<tr></tr>");
						/*tr.append("<td class='check-col'><a href='javascript:;' class='checkbox'></a><input type='checkbox' name='billId' value='"+list[i].contId+"'></td>");*/
						tr.append("<td>"+list[i].custName+"</td>");
						tr.append("<td>"+list[i].contId+"</td>");
						tr.append("<td>"+$.toYuanFix2(list[i].balance)+"</td>");
						tr.append("<td>"+$.toYuanFix2(list[i].amount)+"</td>");
						tr.append("<td>"+list[i].stateName+"</td>");
						if (list[i].balance <= 0|| null == list[i].balance) {
							tr.append("<td><a class='active-btn unable' href=\"javascript:void(0);\" style='background-color:#1fb5ad;'>结转</a></td>");
						} else {
							tr.append("<td><a class='active-btn' href=\"javascript:carryOver('"+custId+"','"+list[i].contId+"','"+list[i].amount+"','"+list[i].balance+"');\" style='background-color:#1fb5ad;'>结转</a></td>");
						}
						
						$("#carryOverBody").append(tr);
					}
					$(".page").html(data.reModel.html);
				} else {
					$(".page").empty();
					$("#carryOver").after(noTips);
					$(".page").html("");
				}
			}else{
				layer.alert(data.msg);
			}
		}
	});
}



/**
 * 结转历史
 * @param n
 * @param s
 */
function carryOverHis(n,s){
	var index = layer.load(6);
	var custId = "";
	var custName = "";
	if(obj != null) {
		custId = obj.custId;
		custName = obj.custName;
	}
	$.ajax({
		url: ctx + '/contract/operRecPage.ajax',
		type: "POST",
		dataType: "json",
		data: {
			pageNo:n,
			pageSize:s,
			funcName:"carryOverHis",
			custName : custName,
			custId : custId
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.reType){
				$("#operHisBody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var tr = $("<tr></tr>");
						tr.append("<td>"+list[i].operNo+"</td>");
						tr.append("<td>"+list[i].custname+"</td>");
						tr.append("<td>"+list[i].origContid+"</td>");
						tr.append("<td>"+list[i].targetContid+"</td>");
						tr.append("<td>"+$.toYuanFix2(list[i].amount)+"</td>");
						tr.append("<td>"+list[i].opName+"</td>");
						tr.append("<td>"+$.formatDateTime(list[i].opDate)+"</td>");
						$("#operHisBody").append(tr);
					}				;
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$("#operHis").after(noTips);
					$(".page").html("");
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}




/**
 * 余额结转提交
 * @param o
 * @param oo
 */
var tamount = 0;
function carryOver (custId,orgContId,amount,preBalance){
	var index = layer.load(6);
	tamount = preBalance;
	$.ajax({
			url:  ctx + "/contract/carryOverView.ajax",
			type: "POST",
			dataType:"json",
			data:{
				custId:custId
			},
			success : function (cr) {
				layer.close(index);
				if(cr.reType){
					var res=cr.reModel;
					if(null==res){
						layer.alert("该客户无生效合同");
						return;
					}
					
					$("#jz_contId").text("目标合同编码：" + res.contId);
					//客户名
					$("#jz_custName").text(res.custName);
					//目标合同余额
					$("#jz_balance").text($.toYuanFix2(res.balance));
					//可结转额度
					$("#jz_limit").text($.toYuanFix2(amount));
					$("#jz_amount").text($.toYuanFix2(res.balance));
					$("#pre_balance").text($.toYuanFix2(preBalance));
					layer.open({
						type: 1,
						title:"合同余额结转",
						area: ['520px', '320px'], //宽高
						btn: ['提交','取消'],
						content: $("#jiezhuan"),
						yes:function(){
							submit(orgContId,res.contId);
						},
						btn2 : function() {
						  layer.closeAll();
						}
					  });
                } else {
                    tamount = 0;
					layer.closeAll();
					layer.alert(cr.msg);
				}
			}
      });
}

function submit(orgContId,targetContId){
	if (!checkAmount()) {
        return false;
	}
	var index = layer.load(6);
	$.ajax({
		url:  ctx + "/contract/carryOver.ajax",
		type: "POST",
		dataType:"json",
		data:{
			orgContId:orgContId,
			contId:targetContId,
			amount:$("#jz_val").val()
		},
		success : function (cr) {
			layer.close(index);
			if(cr.reType){
				layer.alert("结转成功！");
				carryOverQuery();
				layer.closeAll();
			} else {
				layer.alert(cr.msg);
			}
		}
    });
}
function checkAmount(val){
	var amount = val | $("#jz_val").val();
	var ex = /(^[1-9]([0-9]+)?(\.[0-9]{1,2})?$)|(^(0){1}$)|(^[0-9]\.[0-9]([0-9])?$)/;
	var balance = Number($("#jz_balance").text());
	var preBalance = Number($("#pre_balance").text());
    if (!ex.test(amount) || Number(amount) <= 0) {
        $("#jz_val").val("");
        // $("#jz_limit").text(preBalance);
        $("#jz_amount").text(balance.toFixed(2));
        layer.tips("只能输入大于0的数字，保留两位小数！", "#jz_val");
        return false;
	}
	if(preBalance - Number(amount) < 0){
		$("#jz_val").val("");
		// $("#jz_limit").text(curramount);
		$("#jz_amount").text(balance.toFixed(2));
		layer.tips("输入金额超过源合同余额", "#jz_val");
		return false;
	}

	// $("#jz_limit").text(curramount - Number(val));
	$("#jz_amount").text((balance + Number(amount)).toFixed(2));

	return true;
}