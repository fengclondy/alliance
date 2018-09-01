$(function(){
	page(1,8);
});



function page(n,s){
	var index = layer.load(2);
	
	$.ajax({
		url:  ctx + "/cust/findEnablerApply.ajax",
		type:"post",
		dataType:"json",
		data:{
			pageNo:n,
			pageSize:s
		},
		success:function(cr){
			$("#noData").remove();
			layer.close(index);
	       if(cr.reType) {
	    	$(".table>tbody").empty();
	    	   var list = cr.reModel.list;
		       if (list.length > 0) {
			      for(var i=0;i<list.length;i++){
				
				    var tr = $("<tr></tr>");
				    
				      tr.append("<td>"+list[i].companyName+"</td>");
				      tr.append("<td>"+list[i].hostIP+"</td>");
				    if(list[i].stateJudge == 0) {
				      tr.append("<td>"+list[i].statedesc+"</td>");
				      tr.append("<td><a class='active-btn' href=\"javascript:jkSh('"+i+"','"+list[i].applyId+"');\">审核</a></td>");
				    } else if(list[i].stateJudge == 1){
				      tr.append("<td>"+list[i].statedesc+"</td>");
				      tr.append("<td><a href=\"javascript:showPw('"+list[i].acctId+"');\" class='active-btn blue '>查看结果</a></td>");
//				      tr.append("<td><a class='active-btn unable' href='javascript:;'>审核</a></td>");
				    }else if (list[i].stateJudge == 2){
				      tr.append("<td>"+list[i].statedesc+"</td>");
				      tr.append("<td><a href=\"javascript:showPwfail('"+list[i].custId+"');\" class='active-btn blue '>查看结果</a></td>");
				    }
				
				    $(".table>tbody").append(tr);
				}
				    $(".page").html(cr.reModel.html);
				
				} else {
					$(".table").after(noTips);
					//$(".table>tbody").append("<tr><td colspan='8'>未找到任何内容</td></tr>");
				}
	       } else {
	       		$(".page").empty();
	    	   layer.alert(cr.msg);
	       }
	
		}
	});
}
//审核通过后展示密码
function showPw(acctId){
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/findLoginNameAndPass.ajax",
		type:"post",
		dataType:"json",
		data:{
			acctId:acctId
		},
		success:function(cr){
			layer.close(index);
			var loginName = cr.reModel.username;
			var password = cr.reModel.password;
			layer.open({title:'用户名:密码',content: loginName+':'+password});
		}
	});
	
}

//审核通过
function auditsuccess(applyId,content){
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/auditEnabler.ajax",
		type:"post",
		data:{
			applyId:applyId,
			content:content,
			desc:1
		},
		success:function(cr){
			layer.close(index);
			layer.alert(cr.msg);
			window.location.reload();
		}
	});
}

//审核不通过
function auditfail(applyId,content){
	var index = layer.load(2);
	$.ajax({
		url:  ctx + "/cust/auditEnabler.ajax",
		type:"post",
		data:{
			applyId:applyId,
			content:content,
			desc:2
		},
		success:function(cr){
			layer.close(index);
			layer.alert(cr.msg);
			window.location.reload();
		}
	});
}


function showPwfail( custId){
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
				title:'审核未通过回执',content: msg
			});
		}
	});
}