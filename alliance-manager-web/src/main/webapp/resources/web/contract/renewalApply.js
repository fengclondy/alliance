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
			var newFileName_re = "";
			var contId = "";
			var credit = "";
			var balance_re = "";
			$("#renewalForm").validate({
						rules : {
							ipayedFee_re : {
								required : true,
								isNumber : true
							},
							uFile_re : {
								required : true,
								isIamge : true
							}
						},
						messages : {
							ipayedFee_re : {
								required : "请输入付款金额",
								isNumber : "必需是非0开头的正整数"
							},
							uFile_re : {
								required : "请上传支付凭证",
								isIamge : "图片必须是.gif,jpeg,jpg,png中的一种"
							}
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
function renewalView(contId) {
	clearListre();
	var index = layer.load(2);
	$.ajax({
				url : ctx + "/contract/renewalApplyView.ajax",
				type : "POST",
				dataType : "json",
				data : {
					contId : contId
				},
				success : function(cr) {
					layer.close(index);
					console.log(cr.reModel);
					if (cr.reType) {
						contract = cr.reModel;
						// debugger;
						$("#contNo_re").text(contract.contId);
						// debugger;
						$("#custName_re").text(contract.custName);
						// 信用额
						credit = (contract.bookCredit / 1000 == ""
								? 0
								: contract.bookCredit / 1000);
						// 账本额度
						var balance = (contract.balance / 1000 == ""
								? 0
								: contract.balance / 1000);
						// 当前余额为balance-信用额
						$("#deposit_re").text(onload(balance - credit));
						// 缴费后可用余额
						$("#balance_re").text(onload(balance - credit));

						layer.open({

									type : 1,
									title : "续费申请",
									area : ['550px', '530px'], // 宽高
									btn : ['提交', '取消'],
									content : $("#renewalView"),
									yes : function() {
										renewalApply(contract.contId);
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

function restart() {
	$("#uFile_re").empty();
	$("#photoImage_re").empty();
	$("#uFileName_re").empty();
	$("#uFile_re").click();
	if(!!window.ActiveXObject || "ActiveXObject" in window){
		if($("#uFile_re").val()!=''){
			$("#uFileName_re").val($("#uFile_re").val());
			
			upload2();
		}
	}else{
		$('#uFile_re').change(function() {
			// 原始文件名
			$("#uFileName_re").text($("#uFile_re").val());

			upload2();
		});
	}
	

}

// 上传图片
function upload2() {
	var index = layer.load(6);
	if (cheakImage()) {
		$.ajaxFileUpload({
			url : ctx + '/contract/renewalConfirm.ajax',
			fileElementId : 'uFile_re',
			type : 'POST',
			dataType : 'application/json',
			success : function(data, status) {
				layer.close(index);
				fileInfo = JSON.parse(data);
				console.log(fileInfo);
				// debugger;
				newFileName_re = $("#uFileName_re").text(fileInfo.filename);

				// 显示图片预览
				$("#photoImage_re").append("<img src=" + ctx
						+ '/contract/backPayConfirm.html?filename='
						+ fileInfo.filename + " \width='100%' height='100%' >");
				$("#hidFileName_re").val(fileInfo.filename);
			},
			error : function(data, status) {
				layer.close(index);
				layer.alert("上传失败" + data.msg);
			}
		});
	} else {
		layer.close(index);
		return;
	}

}

function cheakImage() {
var path = $("#uFile_re").val();
    name = path.substr(path.lastIndexOf("\\")+1)
if (!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(name)) {
		$("#hidFileName_re").val("");
		layer.tips("图片必须是.gif,jpeg,jpg,png中的一种！", "#tips1");
		return false;
	} else {
		return true;
	}

	
}
function cheak() {
	// 校验图片和金额是不是为
	if ($("#hidFileName_re").val() == null || $("#hidFileName_re").val() == "") {
		layer.alert("请上传凭证");
		return false;
	} else {
			if ($("#ipayedFee_re").val() == null
					|| $("#ipayedFee_re").val() == "") {
				layer.alert("金额不能为空");
				return false;
			}  else {

					return true;
				}
			}
}

function renewalAmount(val) {
	var ex = /(^[1-9]\d*$)/;
	var balance_re = Number($("#deposit_re").text());
	if (ex.test(val)) {
		// 则为整数
		$("#balance_re").text(onload(Number(val) + balance_re));
	} else {
		$("#ipayedFee_re").val("");
		$("#balance_re").text(onload(balance_re));
		layer.tips("金额为正整数！", "#ipayedFee_re");
	}
}
// 四舍五入
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}
// 提交续费申请
function renewalApply(contId) {

	if (cheak()) {

		// debugger;
		var index = layer.load(2);
		var contNo = $("#contNo_re").text();
		// 客户名
		var custName = $("#custName_re").text();
		// debugger;
		// var deposit = $("#deposit").text();
		// 续费金额
		var payedFee = $("#ipayedFee_re").val();
		// 凭证
		var payCert = $("#uFileName_re").text();
		// debugger;
		// var useFee = $("#useFee").text();
		$.ajax({
					url : ctx + "/contract/renewalApply.ajax",
					type : "POST",
					dataType : "json",
					data : {
						contId : contId,
						contNo : contNo,
						custName : custName,
						// deposit:deposit,
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
function clearListre() {
	$("#ipayedFee_re").val("");
	$("#uFile_re").empty();
	$("#photoImage_re").empty();
	$("#uFileName_re").empty();
	$("#hidFileName_re").val("");
}