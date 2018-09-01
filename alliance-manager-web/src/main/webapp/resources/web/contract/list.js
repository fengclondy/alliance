$(function(){
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
	
	
	newQuery();
});

var obj = new Object();
function newQuery(){
	obj = new Object();
	obj.custId = $("#s_custId").val();
	obj.contId = $("#s_contId").val();
	obj.custName = $("#autocomplete").val();
	
	if(obj.custName == "") {
		$("#s_custId").val("");
		obj.custId = "";
	}
	
	page(1,3);
}

function page(n,s){
	var index = layer.load(2);
	var custId = "";
	var contId = "";
	var custName = "";
	if(obj != null){
		custId = obj.custId;
		contId = obj.contId;
		custName = obj.custName;
	}
	$.ajax({
		url:  ctx + "/contract/listContPage.ajax",
		type: "POST",
		dataType:"json",
		data:{
			pageNo:n,
			pageSize:s,
			custId:custId,
			contId:contId,
			custName:custName
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.reType){
				$("#tableList").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var btnText = "";
						var btnLink = "";
						if(list[i].viewState == 1) {//待激活
							btnText = "激活申请";
						} else {
							btnText = "续费";
						}
						if (list[i].btnState == 1) {
							btnLink = "<a class=\"active-btn\" href=\"javascript:clickBtn("+list[i].viewState+", '"+list[i].contId+"');\">"+ btnText  +"</a>";
						} else if (list[i].btnState == 2) {
							btnLink = "<a class=\"active-btn unable\" href=\"javascript:void(0);\">"+ btnText  +"</a>";
						} else {
							btnLink = "";
						}
						
						var tabContent = "<div class=\"table-list\">\
															<div class=\"table-desc\">\
																<span class=\"g12 mr30\">合同编码：" + list[i].contId + "</span>|\
																<span class=\"f12 mr30\" style='font-weight: bold;font-size:14px;'> " + list[i].custName + "</span>\
																<div class=\"fr mr30\">\
																	<span class=\"gray mr30 f12\">订购时间：" + list[i].createDateStr + "</span>\
																	<a href=\"javascript: contractDetailView('" + list[i].contId + "')\" class=\"desc-btn\">合同详情</a>\
																</div>\
															</div>\
															<table class=\"table-c\">\
	<thead><tr><th>商品类型</th><th>流量额度</th><th>折扣/%</th><th>金额/万元</th><th>可用余额/元</th><th>合同有效期至</th><th>状态</th><th>操作</th></tr></thead>\
					                  <tbody>\
					                      <tr>\
					                          <td>国内流量</td>\
					                          <td style=\"width: 369px;padding-left: 2px;padding-right: 2px; padding-bottom: 28px;\">"+(list[i].pubGoodsModels == ""||list[i].pubGoodsModels == null ? "-" : list[i].pubGoodsModels)+"</td>\
					                          <td>"+(list[i].pubOffRate == null||list[i].pubOffRate == "" ? "-" : list[i].pubOffRate)+"</td>\
					                          <td rowspan=\"2\">\
					                              <div class=\"am\" style=\"margin-left: 2px;width: 205px;\">合同金额：<span class=\"og\">"+ list[i].contValue/10000000 + "</span></div>\
					                              <div class=\"am\" style=\"margin-left: 2px;width: 205px;\">已付金额：<span class=\"og\">"+ list[i].payedFee/10000000 +"</span></div>\
					                              <div class=\"am\" style=\"margin-left: 2px;width: 205px;\">账期内消费金额：<span class=\"og\">"+ list[i].currMonthVal/10000000 + "</span></div>\
					                              <div class=\"am\" style=\"margin-left: 2px;width: 205px;\">总消费金额：<span class=\"og\">"+ list[i].currVal/10000000 + "</span></div>\
					                          </td>\
					                          <td rowspan=\"2\">\
					                              <div class=\"am\" style=\"margin-left: 0px;width: 162px;\">保证金余额：<span class=\"og\">"+ $.formatMoney(list[i].bookDeposit/1000, 0) + "</span></div>\
					                              <div class=\"am\" style=\"margin-left: 0px;width: 162px;\">可用余额：<span class=\"og\">" + $.formatMoney(list[i].balance/1000, 2) + "</span></div>\
					                              <div class=\"am\" style=\"margin-left: 0px;width: 162px;\">透支金额：<span class=\"og\">" + $.formatMoney(list[i].bookCredit/1000, 0) + "</span></div>\
					                          </td>\
					                          <td rowspan=\"2\" style=\"padding-left: 2px;padding-right: 2px;\">" + list[i].expDateStr + "</td>\
					                          <td rowspan=\"2\" style=\"padding-left: 2px;padding-right: 2px;\">" + list[i].stateName + "</td>\
					                          <td rowspan=\"2\">" + btnLink + "\
					                          </td>\
					                      </tr>\
					                      <tr>\
					                          <td>省内流量</td>\
					                          <td style=\"width: 369px;padding-left: 2px;padding-right: 2px;\">"+ (list[i].proGoodsModels == ""||list[i].proGoodsModels == null ? "-" : list[i].proGoodsModels) + "</td>\
					                          <td>"+ (list[i].proOffRate == null||list[i].proOffRate =="" ? "-" : list[i].proOffRate) + "</td>\
					                      </tr>\
					                  </tbody>\
					          </table>\
					      </div>";
						
						$("#tableList").append(tabContent);
					}
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$("#tableList").append(noTips);
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}
//下载合同
function viewCont(id) {
	window.location.href = ctx + "/contract/contractView.html?contId=" + id;
}

function clickBtn(type, id) {
	if (type == 1) {
		applyView(id);
	} else {
		renewalView(id);
	}
}



//查看合同详情
 function contractDetailView(contId){
 	
 	var form = $("<form>");// 定义一个form表单
	form.attr("style", "display:none");
	form.attr("target", "");
	form.attr("method", "post");
	form.attr("action", ctx + "/contract/detailList.html");
	var input = $("<input>");
	input.attr("type", "hidden");
	input.attr("name", "contId");
	input.attr("value", contId);
	debugger;
	$("body").append(form);// 将表单放置在web中
	form.append(input);
	
	form.submit();// 表单提交 
}