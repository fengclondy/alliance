var validator;
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
	
	validator =$("#bindIPForm").validate({
		rules:{
			hostIP:{
				required:true,
				isHostIP:true
			}
		},
		messages:{
			hostIP:{
				required:"请输入IP",
				isHostIP:"请输入正确的IP"
			}
		},
		
		
		submitHandler:function(form){
			alert("验证通过");
		},
		errorPlacement: function(error, element) { 
        	layer.tips($(error).text(), "#"+ $(element).attr("id"));
            return false;
        }
	});
	
	jQuery.validator.addMethod("isHostIP", function(value, element) { 
	    var reg =/^\d{1,3}(\.\d{1,3}){3,3}(,\d{1,3}(\.\d{1,3}){3,3})*$/;
		return this.optional(element) || (reg.test(value)); 
	}, "IP格式填写错误");
});

var obj = new Object();
function newQuery(){
	obj = new Object();
	obj.custId = $("#s_custId").val();
	obj.custName = $("#autocomplete").val();
	obj.userName = $("#s_userName").val();
	obj.userMobile = $("#s_userMobile").val();
	obj.crmUserCode = $("#s_crmUserCode").val();
	
	if(obj.custName == "") {
		$("#s_custId").val("");
		obj.custId = "";
	}
	page(1,8);
}

function page(n,s){
	var index = layer.load(2);
	var custId = "";
	var custName = "";
	var userName = "";
	var userMobile = "";
	var crmUserCode = "";
	if(obj != null){
		custId = obj.custId;
		custName = obj.custName;
		userName = obj.userName;
		userMobile = obj.userMobile;
		crmUserCode = obj.crmUserCode;
	}
	$.ajax({
		url:  ctx + "/cust/listCustPage.ajax",
		type: "POST",
		dataType:"json",
		data:{
			pageNo:n,
			pageSize:s,
			custId:custId,
			custName:custName,
			userName:userName,
			userMobile:userMobile,
			crmUserCode:crmUserCode
		},
		success : function (cr) {
			$("#noData").remove();
			layer.close(index);
			if(cr.reType){
				$(".table>tbody").empty();
				var list = cr.reModel.list;
				if (list.length > 0) {
					for(var i=0;i<list.length;i++){
						var color = "";
						color = list[i].state == 200 ? color = "green" : list[i].state == 400 ? color = "og" : list[i].state == 900 ? color = "gray" : "";
						
						var tr = $("<tr></tr>");
						tr.append("<td><a href=\"javascript:showDetail('" + list[i].custId+ "');\" class=\"desc\">"+list[i].custName+"</a></td>");
						tr.append("<td>"+list[i].shortName+"</td>");
						tr.append("<td>"+list[i].crmUserCode+"</td>");
						tr.append("<td>"+list[i].regionName+"</td>");
						tr.append("<td>"+list[i].userName+"</td>");
						tr.append("<td>"+list[i].userMobile+"</td>");
						tr.append("<td>"+list[i].userEmail+"</td>");
						
						/**2016.10.31新增 */
						if(roleType == 2){
							if(list[i].enablerStateDesc == 0){
							   tr.append("<td><a href=\"javascript:void(0);\" class='active-btn unable'>待审核</a></td>");//提交申请
							}else if(list[i].enablerStateDesc == 1){
						       tr.append("<td><a href=\"javascript:showPwSucc('"+list[i].enablerAcctId+"', '"+list[i].custName+"', '" + list[i].custId + "');\" class='active-btn blue '>查看结果</a></td>");//审核完的状态，查看结果
							}else if(list[i].enablerStateDesc == 2){
							   tr.append("<td><a href=\"javascript:showPwfail('"+list[i].custName+"', '"+list[i].custId+"');\" class='active-btn blue '>查看结果</a></td>");
							}else if(list[i].enablerStateDesc == 3){
							   tr.append("<td><a href=\"javascript:jk('"+list[i].custName+"','"+list[i].custId+"');\" class='active-btn'>提交申请</a></td>");
							}
						}
						
						var td = $("<td></td>");
						td.append("<a href='javascript: modify(\"" + list[i].custId+ "\")' class=\"modify-btn\" title='编辑'></a>");
						td.append("<a href=\"javascript: resetPassword('"+list[i].acctId+"');\" class='reset-btn' title='重置密码'></a>");
						tr.append(td);
						
						$(".table>tbody").append(tr);
					}
					
					$(".page").html(cr.reModel.html);
				} else {
					$(".page").empty();
					$(".table").after(noTips);
				}
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function jk(custName,custId){
	$("#jk_custName").val(custName);
	$("#hostIP").val("");//清空上一次绑定IP的缓存
	var index = layer.open({
	        type: 1,
	        title:"开放接口申请",
	        area: ['510px', '230px'], //宽高
	        btn: ["提交","取消"],
	        content: $("#jk"),
	        yes:function(){
	            bindIP(custId);
	        },
	        btn2:function(){
	        	layer.closeAll('tips');
	        	$("#bindIPForm").validate().resetForm();
	        },
	        cancel:function(){
	        	layer.closeAll('tips');
	        	$("#bindIPForm").validate().resetForm();
	        }
	      });
}

function bindIP(custId){
	var flag=$("#bindIPForm").validate().form();
	if(flag){
	var index = layer.load(2);
	var hostIP = $("#hostIP").val();
	$.ajax({
		url:  ctx + "/cust/bindIP.ajax",
		type: "POST",
		dataType:"json",
		data:{
			custId:custId,
			hostIP:hostIP
		},
		success : function (cr) {
			if(cr.reType) {
				layer.closeAll();
				newQuery();
			}else{
				layer.close(index);
				layer.alert(cr.msg);
			}
		}
	});
	}
}

function showDetail(custId) {
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/findCustById.ajax",
		type: "POST",
		dataType:"json",
		data:{
			custId:custId
		},
		success : function (cr) {
			layer.close(index);
			if(cr.reType){
				showCustDetail(cr.reModel);
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function showCustDetail(cust){
	$("#view_crmUserCode").val(cust.crmUserCode);
	$("#view_custName").val(cust.custName);
	$("#view_shortName").val(cust.shortName);
	$("#view_regionName").val(cust.regionName);
	$("#view_certTypeName").val(cust.certTypeName);
	$("#view_certNbr").val(cust.certNbr);
	$("#view_userName").val(cust.userName);
	$("#view_userMobile").val(cust.userMobile);
	$("#view_userEmail").val(cust.userEmail);
	$("#view_crmCustSn").val(cust.crmCustSn);
	$("#view_crmAcctSn").val(cust.crmAcctSn);
	$("#view_crmUserSn").val(cust.crmUserSn);
	$("#view_ext1").val(cust.ext1 + (cust.ext1== null || cust.ext1 == ""? "" : "%"));
	
	 layer.open({
         type: 1,
         title:"客户详情 ",
         area: ['780px', '480px'], //宽高
         btn: ['关闭'],
         content: $("#custDesc")
       });
}

function resetPassword(id){
	layer.confirm("确认重置该用户的密码？", {
		  		btn: ['确定','取消']
			}, function(){
			  var index = layer.load(2);
				$.ajax({
					url:  ctx + "/cust/resetPassword.ajax",
					type: "POST",
					dataType:"json",
					data:{
						acctId : id
					},
					success : function (cr) {
						layer.close(index);
						if(cr.reType){
							layer.closeAll();
							layer.alert("密码重置成功！");
						}else{
							layer.alert(cr.msg);
						}
					}
				});
		  }, function(){
			  layer.closeAll();
		  });
}

function showPwSucc(acctId, custName, custId){
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/findLoginNameAndPass.ajax",
		type:"post",
		dataType:"json",
		data:{
			acctId:acctId
		},
		success:function(cr){
			if (cr.reType) {
				layer.close(index);
				var loginName = cr.reModel.username;
				var password = cr.reModel.password;
				layer.open({
					title:'用户名:密码'
					,content: loginName+':'+password
					,btn:["重新申请","关闭"]
					,yes:function(){
						jk(custName, custId);
					}, btn2: function(){
						layer.closeAll();
					}
				});
			} else {
				layer.alert(cr.msg);
			}
		}
	});
	
}

function showPwfail(custName, custId){
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/findEnablerRemarks.ajax",
		type:"post",
		dataType:"json",
		data:{
			custId:custId
		},
		success:function(cr){
			layer.close(index);
			var msg = cr.msg;
			layer.open({
				title:'审核未通过回执',content: msg,
				btn:["重新申请","关闭"],
				yes:function(){
					layer.closeAll();
					jk(custName, custId);
				},btn2:function(){
					layer.closeAll();
				}
			});
		}
	});
}