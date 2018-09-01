$(function() {
	$('.right select').selectOrDie({size:7});

	$("#s_userName").keyup(function(event) {
		var keycode = event.which;
		if (keycode == 13) {
			newQuery();
		}
	});

	page(1, 8);
});

var obj = new Object();
function newQuery(){
	obj = new Object();
	obj.userName = $("#s_userName").val();
	obj.regionId = $("#s_regionId").val()
	obj.state = $("#s_state").val();
	
	page(1, 8);
}

function page(n,s) {
	var userName = "";
	var regionId = "";
	var state = "";
	if(obj != null){
		userName = obj.userName;
		regionId = obj.regionId;
		state = obj.state;
	}
	
	var index = layer.load(2);
	$.ajax({
		url: ctx+'/sysUser/listManagerPage.ajax',
		type: "POST",
		dataType:"json",
		data:{
			pageNo:n,
			pageSize:s,
			userName:userName,
			regionId:regionId,
			state:state
		},
		success: function(data) {
			$("#noData").remove();
			layer.close(index);
			$("#table>tbody").empty();
			var list = data.reModel.list;
			if(list.length==0)
			{
				$("#table").after(noTips);
				$(".page").empty();
				return;
			};
			for(var i=0;i<list.length;i++){
				var tr = $("<tr></tr>");
				tr.append("<td width='140'>"+list[i].username+"</td>");
				tr.append("<td width='140'>"+list[i].userName+"</td>");
				tr.append("<td width='140'>"+replaceNull(list[i].mobile)+"</td>");
				tr.append("<td width='140'>"+replaceNull(list[i].email)+"</td>");
				tr.append("<td width='140'>"+replaceNull(list[i].phone)+"</td>");
				tr.append("<td width='140'>"+list[i].regionName+"</td>");
				tr.append("<td width='140'>"+list[i].stateName+"</td>");
				tr.append("<td width='140'><a class='modify-btn' href='javascript: modify(\"" + list[i].userId+ "\")'></a>\
																	   <a class='reset-btn' href='javascript: resetPassword(\"" + list[i].acctId+ "\")'></a></td>");
				$("#table>tbody").append(tr);
			}
			$(".page").html(data.reModel.html);
		}
		
	});
}
function replaceNull(id){
	if(id == null){
		return "";
	}else{
		return id;
	}
}

function resetPassword(acctId){
	layer.confirm("确认重置该用户的密码？", {
				btn: ['确定','取消']
			}, function(){
					var index = layer.load(2);
					$.ajax({
						url:  ctx + "/sysUser/resetPassword.ajax",
						type: "POST",
						dataType:"json",
						data:{
							acctId:acctId
						}, success : function (cr) {
								layer.close(index);
								if(cr.reType){
									layer.closeAll();
									layer.alert("密码重置成功！");
									newQuery();
								} else {
									layer.alert(cr.msg);
								}
						}, error:function(cr){
							layer.alert(cr.msg);
						}
					});
			}, function(){
				layer.closeAll();
			});
}