var custId ;
var contNo = "";
$(function() {
			$(".gg-data").click(function() {
						if ($(this).hasClass("active")) {
							$(this).removeClass("active");
						} else {
							$(this).addClass("active");
						}
					});
					
$("#custId").bind("onchange",function(){
//自己写代码，这个就是给select空间添加onchange事件
	debugger;
	custId =$("#custId").val();
	debugger;
	alert(custId);
	getCustType(custId);
});
		});

function add() {
	clearListInput();
	layer.open({
				type : 1,
				title : "新增合同",
				area : ['930px', '530px'], // 宽高
				btn : ['提交', '取消'],
				content : $("#addContract"),
				yes : function() {
					submitForm();
				},
				success : function() {
					$('select').selectOrDie({
								size : 5
							});
					clearForm();
				}
			});
}


function uploadContFile() {
	$("#contFile").empty();
	$("#contCopy").val("");
	$("#file").val("");
	$("#contFile").click();
	if(!!window.ActiveXObject || "ActiveXObject" in window) // IE浏览器
	   {
		debugger;
		if($("#contFile").val()!=''){
			$("#file").val($("#contFile").val());
			
			startUploadContFile();
		}
	   }else{
		   $('#contFile').change(function() {
				// 原始文件名
		debugger;
				$("#file").val($("#contFile").val());
				
				startUploadContFile();
			});
	   }
}

function startUploadContFile() {
	var index = layer.load(6);
	if (cheakUpload()) {
		
		$.ajaxFileUpload({
					url : ctx + '/contract/uploadContFile.ajax',
					fileElementId : 'contFile',
					type : 'POST',
					 //dataType: "text",
					dataType : 'application/json', 
					success : function(data, status) {
						layer.close(index);
						var rs = JSON.parse(data);
						$("#contCopy").val(rs.reModel);
						$("#file").val(rs.reModel);
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

function submitForm() {
	if (cheakInput()) {
		var index = layer.load(2);
		$.ajax({
					url : ctx + '/contract/addContract.ajax',
					type : "POST",
					dataType : "json",
					data : $.param({
									 'contNo' : contNo,
								'proGoodsIds' : getProSelectGoods(),
								'pubGoodsIds' : getPubSelectGoods()
							}) + '&' + $("#addForm").serialize(),
					success : function(data) {
						layer.close(index);
						console.log(data.reModel);
						if (data.reType) {
							layer.closeAll();
							layer.alert("提交成功");
							newQuery();
						} else {
							layer.alert(data.msg);
						}
					}
				});
	} else {
		return;
	}

}

/**
 * 判断是小微代理商
 * @param {} custId
 */
function getCustType(custId) {
	clearListInput();
		var index = layer.load(2);
		if(custId != null&&custId!= ""&&custId!=undefined){
			$.ajax({
					url : ctx + '/contract/applyTipNote.ajax',
					type : "POST",
					dataType : "json",
					data : {
					 	custId:custId
							},
					success : function(data) {
						layer.close(index);
						//console.log(data.reModel);
						if (data.reType) {
							contNo =data.reModel;
							if(null!=data.reModel&&""!=data.reModel){
								$("#contNo").val(data.reModel);
								$("input[name='contNo']").hide();
								$("#contNo").show();
								$("#upload").hide();
							}else{
								$("input[name='contNo']").show();
								$("#upload").show();
								$("#contNo").hide();
							}
						} else {
							layer.alert(data.msg);
						}
					}
				});
		}else{
		layer.close(index);
		$("input[name='contNo']").show();
		$("#contNo").hide();
		$("#upload").show();
		
		}
		
	} 


function getProSelectGoods() {
	var ids = new Array();
	$("#pro .gg-data.active input").each(function() {
				ids.push($(this).val());
			});
	return ids.toString();
}

function getPubSelectGoods() {
	var ids = new Array();
	$("#pub .gg-data.active input").each(function() {
				ids.push($(this).val());
			});
	return ids.toString();
}

function clearForm() {
	$("#addForm")[0].reset();
	$(".gg-data").addClass("active");
	$('select').selectOrDie("update");
}
// 初始化输入
function clearListInput() {
	// 合同金额
	$("input[name='contValue']").val("");
	// 预付款
	$("input[name='payment']").val("");
	// 保证金
	$("input[name='deposit']").val("");
	// 省内流量
	$("input[name='proOffRate']").val("");
	// 国内流量
	$("input[name='pubOffRate']").val("");
	// 合同号
	$("input[name='contNo']").val("");
	$("#contNo").val("");
	// 合同有效期
	$("input[name='contEffDate']").val("");
	// 合同副本
	$("#contCopy").val("");
	$("#contFile").empty();
	$("#file").val("");
	$("input[name='contNo']").show();
	$("#contNo").hide();
	$("#upload").show();
}
// 上传检验
function cheakUpload() {
	
	var path = $("#contFile").val();
	name = path.substr(path.lastIndexOf("\\") + 1)
	if (!/.(doc|DOC|docx|DOCX|wps|WPS|pdf|PDF|RTF|rtf)$/.test(name)) {
		$("#contCopy").val("");
		layer.tips("文件必须是：doc,docx,wps,pdf,rtf中的一种!", "#file");
		return false;
	} else {
		return true;
	}
}
// 合同金额
function contValueCheck(val) {
	var ex = /(^[1-9]\d*$)/;
	var contValue = Number($("input[name='contValue']").val());
	if (ex.test(val)) {
		// 则为整数
		$("input[name='contValue']").val(contValue);
	} else {
		$("input[name='contValue']").val("");
		layer.tips("金额为正整数！", "input[name='contValue']");
	}
}
// 预付款
function paymentCheck(val) {
	var ex = /(^[1-9]\d*$)/;
	var payment = Number($("input[name='payment']").val());
	if (ex.test(val)) {
		// 则为整数
		$("input[name='payment']").val(payment);
	} else {
		$("input[name='payment']").val("");
		layer.tips("金额为正整数！", "input[name='payment']");
	}
}
// 保证金
function depositCheck(val) {
	var ex = /(^[0-9]\d*$)/;
	var deposit = Number($("input[name='deposit']").val());
	if (ex.test(val)) {
		// 则为整数
		$("input[name='deposit']").val(deposit);
	} else {
		$("input[name='deposit']").val("");
		layer.tips("金额为正整数！", "input[name='deposit']");
	}
}
// 省内流量
function proOffRateCheck(val) {
	var ex = /(^[1-9][0-9]$)|(^100&)|(^[1-9]$)$/;
	var proOffRate = $("input[name='proOffRate']").val();
	if (ex.test(val)) {
		// 则为整数
		$("input[name='proOffRate']").val(proOffRate);
	} else {
		$("input[name='proOffRate']").val("");
		layer.tips("折扣只能是1-100中的数！", "input[name='proOffRate']");
	}
}
// 国内流量
function pubOffRateCheck(val) {
	var ex = /(^[1-9][0-9]$)|(^100&)|(^[1-9]$)$/;
	var pubOffRate = $("input[name='pubOffRate']").val();
	if (ex.test(val)) {
		// 则为整数
		$("input[name='pubOffRate']").val(pubOffRate);
	} else {
		$("input[name='pubOffRate']").val("");
		layer.tips("折扣只能是1-100中的数！", "input[name='pubOffRate']");
	}
}
// 合同号
function contNoCheck(val) {
	var ex = /^\w+$/;
	var contNo = $("input[name='contNo']").val();
	
	if (ex.test(val)) {
		// 则为整数
		$("input[name='contNo']").val(contNo);
	} else {
		$("input[name='contNo']").val("");
		layer.tips("合同号只能是数字、字母、下划线！", "input[name='contNo']");
	}
}
// 合同有效期
function contEffDateCheck(val) {
	var ex = /(^[1-9]\d*$)/;
	var contEffDate = Number($("input[name='contEffDate']").val());
	if (ex.test(val)) {
		// 则为整数
		$("input[name='contEffDate']").val(contEffDate);
	} else {
		$("input[name='contEffDate']").val("");
		layer.tips("请输入正整数", "input[name='contEffDate']");
	}
}
// 输入提交校验
function cheakInput() {
	// 合同金额
	var contValue = $("input[name='contValue']").val();
	// 预付款
	var payment = $("input[name='payment']").val();
	// 保证金
	var deposit = $("input[name='deposit']").val();
	// 流量选择
	var goodsId = $("input[name='goodsId']").val();
	// 省内流量
	var proOffRate = $("input[name='proOffRate']").val();
	// 国内流量
	var pubOffRate = $("input[name='pubOffRate']").val();
	var contNo ="";
	// 合同号
	if(""==$("#contNo").val()||null==$("#contNo").val()){
		contNo =$("input[name='contNo']").val();
	}else{
		contNo =$("#contNo").val();
	}
	 
	// 合同有效期
	var contEffDate = $("input[name='contEffDate']").val();
	// 合同副本
	var contCopy = $("#contCopy").val();
	var custId=$("#custId").val();
	//
	// 校验客户
	if (custId == null || custId == ""||custId==undefined) {
	layer.alert("请选择客户");
		return false;
	} else {
		// 合同金额
		if (contValue == null || contValue == "") {
			layer.alert("合同金额不能为空");
			return false;
		} else {
			// 预付款
			if (payment == null || payment == "") {
				layer.alert("预付款金额不能为空");
				return false;
			} else {
				// 保证金
				if (deposit == null || deposit == "") {
					layer.alert("保证金合同金额不能为空");
					return false;
				} else {
					if (goodsId == null || goodsId == "") {
					} else {
						// 省内流量折扣
						if (proOffRate == null || proOffRate == "") {
							layer.alert("省内流量折扣不能为空");
							return false;
						} else {
							// 国内流量折扣
							if (pubOffRate == null || pubOffRate == "") {
								layer.alert("国内流量折扣不能为空");
								return false;
							} else {
								// 合同有效期
								if (contEffDate == null || contEffDate == "") {
									layer.alert("合同有效期不能为空");
									return false;
								} else {
									if (contNo == null || contNo == "") {
										layer.alert("合同号不能为空");
										return false;
									} else {
										if($("#contNo").val()==null&&$("#contNo").val()==""){
											if (contCopy == null || contCopy == "") {
										layer.alert("请上传合同副本");
											return false;
											} else{
												return true;
											}
										}else{
											
											return true;
										}
										

									}
								}

							}
						}

					}
				}
			}
		}

	}

}