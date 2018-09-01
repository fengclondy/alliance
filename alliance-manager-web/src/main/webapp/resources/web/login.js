$(function(){
	$("#showChangePassWord").hide();
	
	
	var validator = $("#loginForm").validate({
        submitHandler:function(form){
//        	$("#submit").attr("href","javascript:;");
        	$("#submitBtn").text("登录中…");
        	$("#submitBtn").removeClass("btn-submit").addClass("btn-disabled");
        	form.submit();
//        	login();
        },
        errorPlacement: function(error, element) {  
            return false;
        }
    });
	$("#reset").click(function() {
        validator.resetForm();
        $("#loginForm")[0].reset();
    });
	
	var tt = Number(60);
	$("#codeBtn").click(function(){
		var flag = validator.element($("#name")) && validator.element($("#password"));
		if(flag){
			$("#codeBtn").val("(" + tt + ") 重新发送");
			//$("#codeBtn").css("background-color","gray");
			$("#codeBtn").addClass("btn-disabled");
			$("#codeBtn").attr("disabled", "disabled");
			$('body').everyTime('1s', function(){
				if(tt > 1){
					$("#codeBtn").val("(" + (tt--) + ") 重新发送");
				}else{
					$('body').stopTime();
					$("#codeBtn").removeClass("btn-disabled");
					$("#codeBtn").removeAttr("disabled");
					$("#codeBtn").val("发送验证码");
				}
			});
			
			$.ajax({
				url: ctx+'/login/getVoliCode.ajax',
				type: "POST",
				dataType:"json",
				data: {
					username : $.trim($("#name").val()),
					password: $.trim($("#password").val())
				},
				success : function (data) 
				{
					if(data.reType==1){
						$("#errors").text(data.message);
					}else {
						$("#errors").text(data.message);
//						if(data.reCode==PASSWORD_IS_INIT){
//							showUpdatePassWord();
//						}else{
//							$("#errors").text(data.reMesg);
//						}	
					}
				}
			});
		}
	});

})

//function login(){
//	$("#submit").attr("disabled","disabled");
//	$("#submit").val("登录中…");
//	$.ajax({
//		url: "login/login.ajax",
//		type: "POST",
//		dataType:"json",
//		data: $("#loginForm").serialize(),
//		success : function (cr) {
//			if(cr.code == "1"){
//				window.location.href = "system/homePage.html";
//			}else{
//				$("#img").click();
//				$("#submit").removeAttr("disabled");
//				$("#submit").val("登录");
//				$("#errors").text(cr.message);
//				$("#submit").addClass("btn-submit").removeClass("btn-disabled");
//			}
//		}
//	});
//}



function showUpdatePassWord()
{
	$('.login-pannel').slideUp(200);
	$("#showChangePassWord").show() ;
}

function closeUpdatePassWord() {
	$(".login-pannel").slideDown(200);
	$("#showChangePassWord").hide();
}

function logout(){
	window.location.href=ctx+"/sys/logout.do";
}

function changePassWord() {
	var username = $('#c_username').val();
	var smscode = $("#smscode").val();
	var newpassword = $('#c_newpassword').val();
	var newpassword_2 = $('#c_newpassword_2').val();
	if (checkPassWord()) {
//		var index = layer.load(2);
		$.ajax({
			url : ctx + "/login/findPassWord.ajax",
			type : "POST",
			dataType:"json",
			data : {
				username : username,
				smscode : smscode,
				newpassword : newpassword
			},
			success : function(data){
				if(data.code == 1) 
				{
					closeUpdatePassWord();
					layer.alert("修改密码成功!即将跳转到登录页面......");
					setTimeout("window.location.href=ctx+ '/login/login.html' ",2000);
				} else {
					layer.alert(data.msg);
				}
			},
			error: function(data) {
				layer.alert("异常");
//				layer.close(index);
//				layer.alert("修改密码成功!即将跳转到登录页面......");
//				setTimeout("window.location.href=ctx+ '/login/login.html' ",2000);
            }
		});
	}
}

function checkPassWord() {
	var c_username = $('#c_username').val();
	var smscode = $('#smscode').val();
	var c_newpassword = $('#c_newpassword').val();
	var c_newpassword_2 = $('#c_newpassword_2').val();
	
//	var pwd_regex = /^(?![0-9]+$)(?![a-zA-Z]+$)(?![\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)[0-9A-Za-z \x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]{8,16}$/;
	var pwd_regex = /^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)(?![a-z\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)(?![a-zA-Z]+$)(?![A-Z\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)[a-zA-Z0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]{8,16}$/;
	
	if(c_username == "" || c_username == null){
		$("#message").html("请输入用户名");
		return false;
	}
	if(smscode == "" || smscode == null){
		$("#message").html("请输入验证码");
		return false;
	}
	if(c_newpassword == "" || c_newpassword ==null){
		$("#message").html("请输入新密码");
		return false;
	}
	if (!pwd_regex.test(c_newpassword)) {
		$("#message").html("密码必须由8-16位数字+字母+特殊字符组合");
		return false;
	}
	if (c_newpassword != c_newpassword_2) {
		$("#message").html("密码不一致 请重新输入");
		return false;
	}
	return true;
}

function getSmsCode()
{
	var c_username = $('#c_username').val();
	if(c_username == "" || c_username == null){
		$("#message").html("请输入用户名");
	}else{
		$.ajax({
			url : ctx + "/login/getSmsCode.ajax",
			type : "POST",
			dataType:"json",
			data : {
				username : c_username
			},
			success : function(data){
				if(data.code == 1) 
				{
					layer.alert("验证码发送成功！");
				} else {
					layer.alert(data.msg);
				}
			},
			error : function(data){
				layer.alert("异常");
			}
		});
	}
}



