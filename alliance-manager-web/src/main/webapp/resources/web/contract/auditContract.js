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
							$("#hiddencustName").val(ui.item.id);
						}
					});

			recQuery();
		});

function recQuery() {
	page(1, 4);
}
function page(n, s) {
	var custId = $("#hiddencustName").val();;
	var custName = $("#autocomplete").val();
	var contId = $("#contId").val();
	var index = layer.load(2);

	$.ajax({

		url : ctx + "/contract/activateAuditQuery.ajax",
		type : "POST",
		dataType : "json",
		data : {
			pageNo : n,
			pageSize : s,
			custId : custId,
			contId : contId,
			custName:custName
		},
		success : function(data) {
			$("#noData").remove();
			layer.close(index);
			if(data.reType){
				$("#listContractTab").empty();
				var list = data.reModel.list;
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var tabContent = "<div class=\"table-desc\">\
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
	         <thead><tr> <th>缴纳金额（万元）</th><th>缴纳保证金金额(万元）</th><th>激活后金额（万元）</th><th>支付凭证</th><th>状态</th><th>操作</th></tr></thead>\
					                  <tbody>\
					                      <tr>\
					                          <td>"
								+ list[i].payFee
								/ 10000000
								+ "</td>\
					                          <td>"
								+ (list[i].deposit/ 10000000)+ "</td>\
					                          <td>"
								+ (list[i].payFee/ 10000000+list[i].balance/ 10000000-list[i].deposit/ 10000000)
								+ "</td>\
					                          <td><a  class=\"pz-btn\" href=\"javascript:showPayConfirm('"
								+ list[i].paymentId
								+ "');\"></a></td>\
					                          <td>"
								+ list[i].subStateName
								+ "</td>\
					                          <td><a class=\"active-btn\" href=\"javascript:auditView('"
								+ list[i].contId
								+ "');\">激活审核</a></td>\
					                      </tr>\
					                  </tbody>\
					          </table>\
					      </div>";

						$("#listContractTab").append(tabContent);
						// debugger;

					}
					$(".page").html(data.reModel.html);
					// debugger;
				}else{
					//$("#listContractTab").empty();
					$("#listContractTab").append(noTips);
					$(".page").empty();
					return;
				}

			} else {
				layer.alert(data.msg);
			}
		}
	});
}

function load1() {

	$(".page").empty();
}
function auditView(contId) {
	$("#remark").empty();
	layer.open({
				type : 1,
				title : "激活审核",
				area : ['520px', '230px'], // 宽高
				btn : ['通过', '不通过'],
				content : $("#activeAudict"),
				yes : function() {
					auditContract(contId, 320);
				},
				btn2 : function() {
					auditContract(contId, 330);
				},
				success : function() {
					// layer.closeAll();
					$('select').selectOrDie();
				}
			});

}

function auditContract(contId, subState) {
	var index = layer.load(2);

	$.ajax({
				url : ctx + "/contract/activateAudit.ajax",
				type : "POST",
				dataType : "json",
				data : {
					contId : contId,
					subState : subState,
					remark : $("#remark").val()
				},
				success : function(cr) {
					layer.close(index);
					if (cr.reType) {

						recQuery();
						layer.closeAll();
					} else {
						layer.alert(cr.msg);
					}
				}
			});
}
// 查看合同详情
/*
 * function contractDetailView(contId) { window.location.href = ctx +
 * "/url/contractView.html?contId=" + contId; }
 */

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
// 显示缴费凭证
function showPayConfirm(paymentId) {
	$("#payConfirmImage").empty();
	$("#payConfirmImage").append("<img src=" + ctx
			+ '/contract/showPayConfirm.ajax?paymentId=' + paymentId
			+ " \width='100%' height='100%' >");
	layer.open({
				type : 1,
				title : "缴费凭证",
				area : ['520px', '520px'], // 宽高
				content : $("#payConfirmImage")
			
			});

}