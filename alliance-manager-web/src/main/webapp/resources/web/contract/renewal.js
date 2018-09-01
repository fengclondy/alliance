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
	var custName = "";
	if (obj != null) {
		custId = obj.custId;
		contId = obj.contId;
		custName = obj.custName;
	}
	$.ajax({
		url : ctx + "/contract/listRenewalAuditContPage.ajax",
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
			$("#noData").remove();
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
																<span class=\"f12 mr30\" style='font-weight: bold;'> "
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
	<thead><tr> <th>当前可用金额（万元）</th><th>当前透支金额(万元）</th><th>本次缴纳金额（万元）</th><th>续费后可用金额（万元）</th><th>支付凭证</th><th>状态</th><th>操作</th></tr></thead>\
					                  <tbody>\
					                      <tr>\
					                          <td>"
								+ list[i].balance
								/ 10000000
								+ "</td>\
					                          <td>"
								+ (list[i].bookCredit == null ? 0 : list[i].bookCredit
										/ 10000000)
								+ "</td>\
					                          <td><span class=\"og\">"
								+ (list[i].payFee == null
										? 0
										: list[i].payFee / 10000000)
								+ "</td>\
					                          <td>"
								+ (list[i].balance + (list[i].payFee == null
										? 0
										: list[i].payFee)-(list[i].bookCredit == null ? 0 : list[i].bookCredit))
								/ 10000000
								+ "</span></td>\
					                          <td><a  class=\"pz-btn\" href=\"javascript:showRenewalConfirm('"
								+ list[i].paymentId
								+ "');\"></a></td>\
					                          <td>"
								+ list[i].subStateName
								+ "</td>\
					                          <td><a class=\"active-btn\" href=\"javascript:renewal('"
								+ list[i].contId
								+ "');\">续费审核</a></td>\
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
			} else {
				layer.alert(cr.msg);
			}
		}
	});
}

function renewal(id) {
	$("#remark").empty();
	layer.open({
				type : 1,
				title : "续费审核",
				area : ['520px', '230px'], // 宽高
				btn : ['通过', '不通过'],
				content : $("#audit"),
				yes : function() {
					auditContract(id, 410);
				},
				btn2 : function() {
					auditContract(id, 420);
				},
				success : function() {
					$('select').selectOrDie();
				}
			});
}

function auditContract(id, subState) {
	var index = layer.load(2);
	$.ajax({
				url : ctx + "/contract/renewalAudit.ajax",
				type : "POST",
				dataType : "json",
				data : {
					contId : id,
					subState : subState,
					remark : $("#remark").val()
				},
				success : function(cr) {
					layer.close(index);
					if (cr.reType) {
						layer.closeAll();
						newQuery();
					} else {
						layer.alert(cr.msg);
					}
				}
			});
}

// 查看合同详情
function contractDetailView(contId) {

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
// 显示续费凭证
function showRenewalConfirm(paymentId) {
	               $("#renewalConfirm").empty();
					$("#renewalConfirm").append("<img src="+ ctx + '/contract/showPayConfirm.ajax?paymentId='+paymentId+" \width='100%' height='100%' >");					
						layer.open({
									type : 1,
									title : "续费凭证",
									area : ['520px', '520px'], // 宽高
									content : $("#renewalConfirm")
								});
}