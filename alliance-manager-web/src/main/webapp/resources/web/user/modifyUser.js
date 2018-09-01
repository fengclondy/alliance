
function modify(userId){
	$.ajax({
		url : ctx + '/sysUser/findManager.ajax',
		type : "POST",
		data : {
			userId:userId
		},
		success : function(data) {
			//var regionId=data.reModel.regionId;
//			$("#add_regionId option").attr("selected","false");
			//$("#add_regionId option[value=regionId]").attr("selected","true");
			//$("#add_regionId").val(data.reModel.regionId);
			$("#add_regionId").html("<option >"+data.reModel.regionName+"</option>")
			$("#userId").val(userId);
		
			$("#username").val(data.reModel.username);
			$("#userName").val(data.reModel.userName);
			$("#mobile").val(data.reModel.mobile);
			$("#email").val(data.reModel.email);
			$("#phone").val(data.reModel.phone);
			$("#add_regionId").attr("disabled","disabled");
			$("#username").attr("readonly","readonly");
			layer.open({
				type : 1,
				title : "修改用户",
				area : [ '400px', '380px' ],
				btn : [ '保存', '取消' ],
				content : $("#add_User"),
				yes : function() {
					modifyManager();
				},
				success : function() {
					$('select').selectOrDie({size:7});
				}
			});
		}
	});
	
}
 

function modifyManager() {
	var flag=validator.form();
	if(flag){
		var index = layer.load(2);
		var username=$("#username").val();

		$.ajax({
			url : ctx + '/sysUser/modifyManager.ajax',
			type : "POST",
			data : $("#addForm").serialize(),
			success : function(data) {
				layer.close(index);
				if(data.reType){
					layer.closeAll();
					layer.alert('修改成功！');
					newQuery();
				} else {
					layer.alert(data.msg);
				}
			}
		});


	}
}