$(function() {
			newQuery();
			var registId=$("#registId").val();
			layer.config({
				extend: 'extend/layer.ext.js'
			});
			layer.ready(function(){ 
			    // layer.msg('欢迎使用layer');
			    
			    // 使用相册
			    layer.photos({
			        photos: '#upload',
					anim: 5
			    });
			});

		});
var obj = new Object();
function newQuery() {
	obj = new Object();
	obj.conpanyName = $("#s_conpanyName").val();
	obj.userName = $("#s_userName").val();
	obj.userMobile = $("#s_userMobile").val();
	obj.state = $("#s_state").val();
	page(1, 14);
}

function page(n, s) {

	var index = layer.load(2);
	var conpanyName = "";
	var userName = "";
	var userMobile = "";
	var state = "";
	if (obj != null) {
		conpanyName = obj.conpanyName;
		userName = obj.userName;
		userMobile = obj.userMobile;
		state = obj.state;
	}
	$.ajax({
		url : ctx + '/applyTip/pageQuery.ajax',
		type : "POST",
		dataType : "json",
		data : {
			pageNo : n,
			pageSize : s,
			conpanyName : conpanyName,
			userName : userName,
			userMobile : userMobile,
			state : state
		},
		success : function(data) {
			$("#noData").remove();
			layer.close(index);

			var list = data.reModel.list;

			if (data.reType) {
				$("#table>tbody").empty();
				if (list.length == 0) {
					$("#table").after(noTips);
					$(".page").empty();
					return;
				};
				if (list.length > 0) {
					for (var i = 0; i < list.length; i++) {
						var tr = $("<tr></tr>");
						tr.append("<td class='tdcenter'>" + list[i].conpanyName + "</td>");
						tr.append("<td class='tdcenter'>" + list[i].regionName + "</td>");
						tr.append("<td class='tdcenter'>"
								+ (list[i].amount == "" ? 0 : onload(list[i].amount
										/ 1000)) + "</td>");
						tr.append("<td class='tdcenter'>" + list[i].userName + "</td>");
						tr.append("<td class='tdcenter'>" + list[i].userMobile + "</td>");
						tr.append("<td class='tdcenter'>" + list[i].createStrDate + "</td>");
						tr.append("<td class='tdcenter'>"
								+ (list[i].dealStrDate == ""
										|| list[i].dealStrDate == null
										? "--"
										: list[i].dealStrDate) + "</td>");
						tr.append("<td class='tdcenter'>" + list[i].stateName + "</td>");
						tr.append("<td class='tdcenter'><a class='detail-btn' title='意向单详情' href=\"javascript: views('"
										+ list[i].registId + "');\" ></a></td>");
						$("#table>tbody").append(tr);
					}
					$(".page").html(data.reModel.html);
				}
			} else {
				layer.alert(data.msg);
			}
		}
	});


}
function onload(value) {
	var newValue;
	newValue = value.toFixed(2);
	return newValue;
}

$("#119").addClass("active");
		
		function start() {
		$("#applyConfirm").empty();
		// $("#photoImage").empty();
		// $("#photoImage").append("<img
		// src="+ctxStatic+'/images/img-demo.png'+">");
		$("#applyConfirm").click();
		
		
		
		
		if(!!window.ActiveXObject || "ActiveXObject" in window) // IE浏览器
		   {
			
			if($("#applyConfirm").val()!=''){
				$("#uFileName").val($("#applyConfirm").val());
				
				upload();
			}
		   }else{
		$('#applyConfirm').change(function() {
					// 原始文件名
					$("#uFileName").text($("#applyConfirm").val());

					upload();
				});
		  }
		/*$('#applyConfirm').change(function() {
					// 原始文件名
					$("#uFileName").text($("#applyConfirm").val());

					upload();
				});*/
	}

	// 上传图片
	function upload() {
		var index = layer.load(6);
		if (cheakImages()) {
			$.ajaxFileUpload({
						type : 'POST',
						url : ctx + '/applyTip/applyConfirm.ajax',
						fileElementId : 'applyConfirm',
						dataType : 'application/json',
						success : function(data, status) {
							layer.close(index);
							fileInfo = JSON.parse(data);
							// debugger;
							// newFileName =
							// $("#uFileName").text(fileInfo.filename);
							newFileName = $("#uFileName").text(fileInfo);
							// $("#imgId").attr('src',ctx+'/applyTip/backApplyConfirm.html?filename='+
							// fileInfo.filename);
							$("#imgId").attr('src',ctx+'/applyTip/backApplyConfirm.html?filename='+ fileInfo); 
							// 显示图片预览
							 /*
								 * $("#photoImage") .append("<img src=" + ctx +
								 * '/applyTip/backApplyConfirm.html?filename=' +
								 * fileInfo.filename + " \width='100%'
								 * height='100%' >");
								 */

							$("#hidFileName").val(fileInfo);
							// $("#hidFileName").val(fileInfo.filename);
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

	// 提交申请
function submit(registId) {

		if (cheakNum()) {

			var index = layer.load(2);
			var crmPhone = $("#crmPhone").val();
			var payCert = $("#uFileName").text();
			 debugger;
			$.ajax({
						url : ctx + "/applyTip/subumit.ajax",
						type : "POST",
						dataType : "json",
						data : {
							registId : registId,
							crmPhoneNo : crmPhone,
							payCert : payCert

						},
						success : function(cr) {
							layer.close(index);
							if (cr.reType) {
					 layer.msg('提交成功',{time:800},function(){
						window.location.href = ctx + '/cust/list.html?crmPhone='+crmPhone; 
						
					}); 
							} else {
								layer.alert(cr.msg);
							}
						}
					});
		} else {
			return;
		}
	}



	// 弃单
function give(registId) {
layer.confirm('您确定弃单?', {
     		  btn: ['确定','取消'] // 按钮
     		}, function(){
     		  var index = layer.load(2);
			$.ajax({
						url : ctx + "/applyTip/giveTips.ajax",
						type : "POST",
						dataType : "json",
						data : {
							registId : registId
						},
						success : function(cr) {
							layer.close(index);
							if (cr.reType) {
								layer.alert("弃单成功");
								// layer.closeAll();
								window.location.href = ctx + '/applyTip/list.html'; 
								// newQuery();
							} else {
								layer.alert(cr.msg);
							}
						}
					});
     		});	
	}
	function cheakNum() {
	// 校验图片和手机号不是空
	if ($("#hidFileName").val() == null || $("#hidFileName").val() == "") {
		// debugger;
		// layer.alert("请上传凭证");
		layer.tips("请上传凭证！", "#tips0");
		return false;
	} else {
		// var reg = /^1(3|4|5|7|8)\d{9}$/;
		var reg = /^1\d{10}$/;
		var phone = $("#crmPhone").val();
		if (reg.test(phone)) {
			// 手机号码
			$("#crmPhone").val();
			return true;
		} else {
			$("#crmPhone").val("");
			layer.tips("请输入正确的手机号码！", "#crmPhone");
			return false;
		}
	}
	}
	function cheakImages() {
		var path = $("#applyConfirm").val();
		name = path.substr(path.lastIndexOf("\\") + 1)
		if (!/.(gif|jpg|jpeg|png|gif|jpg|png)$/.test(name)) {
			$("#hidFileName").val("");
			layer.tips("图片必须是.gif,jpeg,jpg,png中的一种！", "#tips0");
			return false;
		} else {
			var image = new Image();
		     image.src = path;
		     var height=0;
		     var width=0;
		     var filesize=0;
		     image.onload = function(){
		    	  height = image.height;
		    	 width = image.width;
		    	  alert(width,height);
		    	   filesize = image.filesize;
		     }
		     
		     if(width>80 && height>80 && filesize>102400){
		      alert('请上传80*80像素 或者大小小于100k的图片');
		      return false;
		     }else{
		    	 return true;
		     }
}
}
	// 显示缴费凭证
	function registPayConfirm(registId) {
		$("#payConfirmImage").empty();
		$("#payConfirmImage").append("<img src=" + ctx
				+ '/applyTip/showApplyConfirm.html?registId='+ registId
				+ " \width='100%' height='100%' >");
		layer.open({
					type : 1,
					title : "缴费凭证",
					area : ['520px', '520px'], // 宽高
					content : $("#payConfirmImage")
				
				});

	}
	
	
   
	/*
	 * function getJson(registId){ src : ctx+
	 * '/applyTip/showApplyConfirm.html?registId='+ registId
	 *  }
	 * 
	 * function showConfirm(data)( layer.photos({ photos: data ,shift: 5
	 * //0-6的选择，指定弹出图片动画类型，默认随机 }); }
	 */
	function clearList() {
		$("#crmPhone").val("");
		$("#applyConfirm").empty();
		$("#photoImage").empty();
		$("#uFileName").empty();
		$("#hidFileName").val("");
	}	