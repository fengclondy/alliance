$(function() {
			$("#autocomplete").autocomplete({
						source : function(request, response) {
							$.ajax({
										url : ctx + "/cust/listCust4Query.ajax",
										type : "post",
										data : {
											custName : $("#autocomplete").val()
										},
										success : function(cr) {
											var list = cr.reModel;
											response($.map(list,
													function(item) {
														var name = item.custName;
														var id = item.custId;
														return {
															label : item.custName,// 下拉框显示值
															value : item.custName,// 选中后，填充到下拉框的值
															id : item.custId
															// 选中后，填充到id里面的值
														}
													}));
										}
									});
						},
						delay : 500,// 延迟500ms便于输入
						select : function(event, ui) {
							$("#s_custId").val(ui.item.id);
						}
					});

			newQuery();
			
			var newFileName = "";
			var contId = "";
	$("#activateForm").validate({
						rules : {
							ipayedFee : {
								required : true,
								isNumber : true
							},
							payConfirm : {
								required : true,
								isIamge : true
							}
						},
						messages : {
							ipayedFee : {
								required : "请输入付款金额",
								isNumber : "必需是非0开头的正整数"
							},
							payConfirm : {
								required : "请上传支付凭证",
								isIamge : "图片必须是.gif,jpeg,jpg,png中的一种"
							}
						},
	submitHandler:function(form){
			form.submit();
		},
		errorPlacement: function(error, element) { 
        	$("#error").html(error);
            return false;
        }
					});
	jQuery.validator.addMethod("isNumber", function(value, element) { 
		var reg = /(^[1-9]\d*$)/; 
		return this.optional(element) || (reg.test(value)); 
	}, "必需是非0开头的正整数");
	
	jQuery.validator.addMethod("isIamge", function(value, element) { 
		var reg = /.(gif|jpg|jpeg|png|gif|jpg|png)$/; 
		return this.optional(element) || (reg.test(value)); 
	}, "图片必须是.gif,jpeg,jpg,png中的一种");
});
var deposit = "";
var obj = new Object();
function newQuery() {
	obj = new Object();
	obj.custId = $("#s_custId").val();
	obj.contId = $("#s_contId").val();
	obj.custName = $("#autocomplete").val();

	if (obj.custName == "") {
		$("#s_custId").val("");
		obj.custId = "";
	}
	page(1, 3);
}

function page(n, s) {
	var index = layer.load(2);
	var custId = "";
	var contId = "";
	if (obj != null) {
		custId = obj.custId;
		contId = obj.contId;
		custName = obj.custName;
	}
	$.ajax({
		url : ctx + "/contract/listWaitAuditContPage.ajax",
		type : "POST",
		dataType : "json",
		data : {
			pageNo : n,
			pageSize : s,
			custId : custId,
			contId : contId,
			custName : custName
		},
		success : function(cr) {
			layer.close(index);
			if (cr.reType) {
				$("#tableList").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var tabContent = "<div class=\"table-list\">\
															<div class=\"table-desc\">\
																<span class=\"g12 mr30\">合同编码："
								+ list[i].contId
								+ "</span>|\
																<span class=\"f12 mr30\"> "
								+ list[i].custName
								+ "</span>\
																<div class=\"fr mr30\">\
																	<span class=\"gray mr30 f12\">订购时间："
								+ list[i].createDateStr
								+ "</span>\
																	<a href=\"javascript: contractDetailView('"
								+ list[i].contId
								+ "')\" class=\"desc-btn\">合同详情</a>\
																</div>\
															</div>\
															<table class=\"table-c\">\
	<thead><tr><th>商品类型</th><th>流量额度</th><th>折扣/%</th><th>金额/万元</th><th>合同有效期至</th><th>状态</th><th>操作</th></tr></thead>\
					                  <tbody>\
					                      <tr>\
					                          <td>国内流量</td>\
											  <td>"
								+ (list[i].pubGoodsModels == ""
										? "-"
										: list[i].pubGoodsModels)
								+ "</td>\
					                          <td>"
								+ (list[i].pubOffRate == null
										? "-"
										: list[i].pubOffRate)
								+ "</td>\
					                          <td rowspan=\"2\">\
					                              <div class=\"am\">合同金额：<span class=\"og\">"
								+ list[i].contValue
								/ 10000000
								+ "</span></div>\
					                              <div class=\"am\">预付款：<span class=\"bl\">"
								+ list[i].payment
								/ 10000000
								+ "</span></div>\
					                              <div class=\"am\">保证金：<span class=\"bl\">"
								+ list[i].deposit
								/ 10000000
								+ "</span></div>\
					                          </td>\
					                          <td rowspan=\"2\">"
								+ list[i].expDateStr
								+ "</td>\
					                          <td rowspan=\"2\">"
								+ list[i].stateName
								+ "</td>\
					                          <td rowspan=\"2\"><a class=\"active-btn\" href=\"javascript:audit('"
								+ list[i].contId
								+ "');\">审核</a>\
					                          </td>\
					                      </tr>\
					                      <tr>\
					                          <td>省内流量</td>\
					                          <td>"
								+ (list[i].proGoodsModels == ""
										? "-"
										: list[i].proGoodsModels)
								+ "</td>\
					                          <td>"
								+ (list[i].proOffRate == null
										? "-"
										: list[i].proOffRate)
								+ "</td>\
					                      </tr>\
					                  </tbody>\
					          </table>\
					      </div></div>";

						$("#tableList").append(tabContent);
					}
					$(".page").html(cr.reModel.html);
				} else {
					$("#tableList").append("<div>未找到任何内容</div>");
				}
			} else {
				layer.alert(cr.msg);
			}
		}
	});
}
// 显示申请弹框内容
function applyView(contId) {
	$("#activateForm")[0].reset();
	clearList();
	var index = layer.load(2);
	$.ajax({
				url : ctx + "/contract/activateApplyView.ajax",
				type : "POST",
				dataType : "json",
				data : {
					contId : contId
				},
				success : function(cr) {
					layer.close(index);
					if (cr.reType) {
						var contract = cr.reModel;
						
						deposit = (contract.deposit / 1000 == ""
								? 0
								: contract.deposit / 1000);
						// 合同号
						$("#contNo_ac").text(contract.contNo);
						// 客户名
						$("#custName_ac").text(contract.custName);
						// 保证金
						$("#deposit_ac").text(onload(contract.deposit / 1000));
						// 缴费后可用余额 （可用余额）
						$("#useFee").text(onload(contract.balance / 1000));

						layer.open({

									type : 1,
									title : "激活申请",
									area : ['550px', '530px'], // 宽高
									btn : ['提交', '取消'],
									content : $("#activeApply"),
									yes : function() {
										activateApply(contract.contId);
									},
									success : function() {
										$('select').selectOrDie();
									}
								});

					} else {
						layer.alert(cr.msg);
					}
				}
			});

}

function activateAmount(val) {
	var ex = /(^[1-9]\d*$)/;
	var deposit = Number($("#deposit_ac").text());
	if (ex.test(val)) {
		// 则为整数
		$("#useFee").text(onload(Number(val) - deposit));
	} else {
		$("#ipayedFee").val("");
		$("#useFee").text(0);
		layer.tips("金额为正整数！", "#ipayedFee");
	}
}
// 四舍五入
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}

function cheakImages() {
var path = $("#payConfirm").val();
    name = path.substr(path.lastIndexOf("\\")+1)
if (!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(name)) {
		$("#hidFileName").val("");
		layer.tips("图片必须是.gif,jpeg,jpg,png中的一种！", "#tips0");
		return false;
	} else {
		return true;
	}

	
}
function cheak2() {
	// 校验图片和金额是不是为空校验保证金是否小于输入金额
	if ($("#hidFileName").val() == null || $("#hidFileName").val() == "") {
		debugger;
		layer.alert("请上传凭证");
		return false;
	} else {
			if ($("#ipayedFee").val() == null || $("#ipayedFee").val() == "") {
				debugger;
				layer.alert("金额不能为空");
				return false;
			} else {
					if (deposit > $("#ipayedFee").val()) {
						debugger;
						layer.alert("输入金额应大于保证金");
						return false;
					} else {
						return true;
					}
				}
			}
}
function start() {
	$("#payConfirm").empty();
	$("#photoImage").empty();
	$("#payConfirm").click();
	if(!!window.ActiveXObject || "ActiveXObject" in window) // IE浏览器
	   {
		
		if($("#payConfirm").val()!=''){
			$("#uFileName").val($("#payConfirm").val());
			
			upload();
		}
	   }else{
	$('#payConfirm').change(function() {
				// 原始文件名
				$("#uFileName").text($("#payConfirm").val());

				upload();
			});
	  }
}

// 上传图片
function upload() {
	var index = layer.load(6);
	if(cheakImages()){
		$.ajaxFileUpload({
				type : 'POST',
				url : ctx + '/contract/payConfirm.ajax',
				fileElementId : 'payConfirm',
				dataType : 'application/json',
				success : function(data, status) {
					layer.close(index);
					fileInfo = JSON.parse(data);
					// debugger;
					newFileName = $("#uFileName").text(fileInfo.filename);

					// 显示图片预览
					$("#photoImage").append("<img src=" + ctx
							+ '/contract/backPayConfirm.html?filename='
							+ fileInfo.filename
							+ " \width='100%' height='100%' >");

					$("#hidFileName").val(fileInfo.filename);
				},
				error : function(data, status) {
					layer.close(index);
					layer.alert("上传失败" + data.msg);
				}
			});
		}else{
		layer.close(index);
		return;
	}
	
}
// 提交激活申请
function activateApply(contId) {

	if (cheak2()) {

		var index = layer.load(2);
		var contNo = $("#contNo_ac").text();
		// debugger;
		var custName = $("#custName_ac").text();
		// debugger;
		 deposit = Number($("#deposit_ac").text());
		// debugger;
		var payedFee = $("#ipayedFee").val();
		// debugger;
		var payCert = $("#uFileName").text();
		// debugger;
		// var useFee = $("#useFee").text();
		$.ajax({
					url : ctx + "/contract/activateApply.ajax",
					type : "POST",
					dataType : "json",
					data : {
						contId : contId,
						contNo : contNo,
						custName : custName,
						deposit : deposit,
						payCert : payCert,
						payedFee : payedFee
					},

					success : function(cr) {
						layer.close(index);
						if (cr.reType) {
							layer.alert("提交成功");
							layer.closeAll();
							newQuery();
						} else {
							layer.alert(cr.msg);
						}
					}
				});
	} else {
		return;
	}
}
function clearList() {
	$("#ipayedFee").val("");
	$("#payConfirm").empty();
	$("#photoImage").empty();
	$("#uFileName").empty();
	$("#hidFileName").val("");
}