var validator;
$(function(){
	//获取url如果有crmPhone参数调用弹窗
	var searchValue =window.location.search;
	var crmPhone="";
	if(null!=searchValue&&""!=searchValue){
	 crmPhone = searchValue.split("=")[1];
		//$("#add_crmUserCode").val(crmPhone);
	 $("#add_crmUserCode").attr("value",crmPhone);
		add();
	}
	validator = $("#add_form").validate({
			rules: {
				ext1: {
					range:[0,100]
				},
				shortName : {
					rangelength : [1, 20]
				},
				userName : {
					rangelength : [1, 20]
				}
			},
			messages:{
				crmUserCode : {
					required : '请输入客户号码'
				},
				shortName : {
					required : '请输入公司简称',
					rangelength: '请输入一个长度介于{0}和{1}之间的公司简称'
				},
				userName : {
					required : '请输入联系人姓名',
					rangelength: '请输入一个长度介于{0}和{1}之间的联系人姓名'
				},
				userMobile : {
					required : '请输入联系人手机号'
				},
				ext1 : {
					required : '请输入摊分比例',
					range : '请输入一个位数介于{0} 和 {1} 之间的摊分比例'
				}
			},
	        submitHandler:function(form){
	        	saveCust();
	        },
	        errorPlacement: function(error, element) { 
	        	$("#error").html(error);
	            return false;
	        }
	});
});

function add(){
    layer.open({
          type: 1,
          title:"新增用户",
          area: ['780px', '480px'], //宽高
          btn: ['提交','取消'],
          content: $("#cust"),
          yes:function(){
        	  saveCust();
          },
          success:function(){
        	  clearCust();
        	  correct();
        	  
        	  $("#add_crmUserCode").removeAttr("disabled");
        	  $("#add_ext1").removeAttr("disabled");
			  $(".sr-btn").show();
          }
        });
}

function srUser(){
	$("#error").html();
	var crmUserCode = $("#add_crmUserCode").val();
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/findCrmInfo.ajax",
		type: "POST",
		dataType:"json",
		data:{
			crmUserCode:crmUserCode
		},
		success : function (cr) {
			layer.close(index);
			if(cr.reType) {
				correct();
				var cust = cr.reModel;
				$("#add_custName").val(cust.custName);
				$("#add_regionName").val(cust.regionName);
				$("#add_certTypeName").val(cust.certTypeName);
				$("#add_certNbr").val(cust.certNbr);
				$("#add_crmCustSn").val(cust.crmCustSn);
				$("#add_crmAcctSn").val(cust.crmAcctSn);
				$("#add_crmUserSn").val(cust.crmUserSn);
			} else {
				errorInput(cr.msg);
			}
		},
		error:function(){
			layer.close(index);
			errorInput("无法连接服务器");
		}
	});
}

var errTips = "";
function saveCust(){
	$("#error").html();
	if(!checkAdd()){
		$("#error").html("请先点击查询，获取客户CRM资料！");
	} else {
		var flag = $("#add_form").validate().form();
		if(flag) {
			var index = layer.load(2);
			$.ajax({
				url:  ctx + "/cust/addCust.ajax",
				type: "POST",
				dataType:"json",
				data:$("#add_form").serialize(),
				success : function (cr) {
					layer.close(index);
					if(cr.reType){
						layer.closeAll();
						layer.alert("保存成功");
						newQuery();
					}else{
						layer.alert(cr.msg);
					}
				}
			});
		}
	}
}

function clearCust(){
	$("#add_form")[0].reset();
	$("#add_form").validate().resetForm();
	$("#error").html("");
}

function clearAutoInput(){
	$("#add_custName").val("");
	$("#add_regionName").val("");
	$("#add_certTypeName").val("");
	$("#add_certNbr").val("");
	$("#add_crmCustSn").val("");
	$("#add_crmAcctSn").val("");
	$("#add_crmUserSn").val("");
}

function checkAdd(){
	if ($("#add_custName").val() == "") {
		return false;
	}
	if ($("#add_regionName").val() == "") {
		return false;
	}
	if ($("#add_certTypeName").val() == "") {
		return false;
	}
	if ($("#add_certNbr").val() == "") {
		return false;
	}
	if ($("#add_crmCustSn").val() == "") {
		return false;
	}
	if ($("#add_crmAcctSn").val() == "") {
		return false;
	}
	if ($("#add_crmUserSn").val() == "") {
		return false;
	}
	return true;
}

function correct() {
	//错误提示信息
	$("#fail").hide();
	//表单面板
	$("#success-sr").show();
	//提交按钮
    $(".layui-layer-btn0").show();
}

function errorInput(msg) {
	//表单面板
	$("#success-sr").hide();
	//错误提示信息
	$("#fail .fail-info").text(msg);
	//错误提示面板
    $("#fail").show();
    //提交按钮
    $(".layui-layer-btn0").hide();
}