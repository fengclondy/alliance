var validator;
$(function(){
	validator =$("#addForm").validate({
		rules:{
			username:{
				required:true
//				rangelength:[4,10]
			},
			userName:{
				required:true
			},
			mobile:{
				required:true,
				isMobile:true
			},
			email:{
				email:true
			}
		},
		messages:{
			username:{
				required:"请输入登录名"
//				rangelength:"登录名长度必须为4-10位"
			},
			userName:{
				required:"请输入联系人姓名"
//				rangelength:"联系人姓名长度必须为4-10位"
			},
			mobile:{
				required:"请输入手机号",
				isMobile:"请输入正确的手机号"
			},
			email:{
				email:"邮箱格式不正确"
			}
		},
		
		
		submitHandler:function(form){
			alert("验证通过");
			form.submit();
		},
		errorPlacement: function(error, element) { 
        	$("#error").html(error);
            return false;
        }
	});
	
	jQuery.validator.addMethod("isMobile", function(value, element) { 
		var reg = /^1(3|4|5|7|8)\d{9}$/; 
		return this.optional(element) || (reg.test(value)); 
	}, "手机号码格式错误");
	
});


function add(){
	$("#addForm")[0].reset();
	layer.open({
		type : 1,
		title : "新增用户",
		area : [ '400px', '380px' ], // 宽高
		btn : [ '保存', '取消' ],
		content : $("#add_User"),
		yes : function() {
			addManager();
		},
		success : function() {
			$('select').selectOrDie({size:7});
		}
	});
}

// 检验登录名
//function checkUserCode() {
//	var userCode = $("#userCode").val();
//	var reg = /[\u4E00-\u9FA5]/g;
//	if (userCode == "") {
//		layer.alert("登录名不能为空");
//
//		return false;
//	}
//	if (reg.test(userCode)) {
//
//		layer.alert("不能含有中文字符");
//		return false;
//	}
//
//	$.post("${ctx}/sysUser/userCodeList.ajax", {
//		"userCode" : userCode
//	}, function(callResult) {
//		if (callResult.reModel == null) {
//			layer.alert("登录名可用");
//		} else {
//			layer.alert("登录名已经存在");
//		}
//	}
//
//	);
//}

function addManager() {
//	alert("1");
//	var username = $.trim($("#username").val());
//	var nickname = $("#nickname").val();
//	var mobile = $("#mobile").val();
//	var email = $("#email").val();
//	var phone = $("#phone").val();
//	var userQq = $("#userQq").val();
//	var areaCode = $("#areaCodeAdd").val();

//	var regex = /^1[3458]\d{9}$/;
//	var reg = /[\u4E00-\u9FA5]/g;
	//var flag=validator.element($("#add_form input[name=username]")) && validator.element($("#add_form input[name=mobile]")) 
//	if (userCode == "") {
//
//		layer.alert("登录名不能为空");
//		return false;
//	}
//	if (reg.test(userCode)) {
//		layer.alert("不能含有中文字符");
//		return false;
//	} else {
//
//		if (!regex.test(userMobile)) {
//			layer.alert("无效的手机号码");
//			return false;
//		}
//	}
	var flag=validator.form();
	if(flag){
		
		var index = layer.load(2);
		var username=$("#username").val();
		$.ajax({
			url : ctx + "/sysUser/userCodeList.ajax",
			type : "POST",
			data : {
				username:username
			},
			success : function(result) {
				layer.close(index);
				if(result.reType) {
					$.ajax({
						url : ctx + '/sysUser/addManager.ajax',
						type : "POST",
						data : $("#addForm").serialize(),
						success : function(data) {
							layer.close(index);
							if(data.reType){
								layer.closeAll();
								layer.alert('保存成功！');
								newQuery();
							} else {
								layer.alert(data.msg);
							}
						}
					});
				} else {
					$("#error").html(result.msg);
				}
			}
		});


		
		
	}
}