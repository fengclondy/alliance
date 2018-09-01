$(function(){
	
});

function modify(custId){
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
			if(cr.code ==1){
				showCust(cr.reModel);
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function saveModifyCust(){
	var index = layer.load(2);
	
	$.ajax({
		url:  ctx + "/cust/modifyCust.ajax",
		type: "POST",
		dataType:"json",
		data:$("#add_form").serialize(),
		success : function (cr) {
			layer.close(index);
			if(cr.code ==1){
				layer.closeAll();
				layer.alert("保存成功");
				newQuery();
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}

function showCust(cust){
	$("#add_crmUserCode").val(cust.crmUserCode);
	$("#add_custName").val(cust.custName);
	$("#add_form input[name=shortName]").val(cust.shortName);
	$("#add_regionName").val(cust.regionName);
	$("#add_certTypeName").val(cust.certTypeName);
	$("#add_certNbr").val(cust.certNbr);
	$("#add_form input[name=userName]").val(cust.userName);
	$("#add_form input[name=userMobile]").val(cust.userMobile);
	$("#add_form input[name=userEmail]").val(cust.userEmail);
	$("#add_crmCustSn").val(cust.crmCustSn);
	$("#add_crmAcctSn").val(cust.crmAcctSn);
	$("#add_crmUserSn").val(cust.crmUserSn);
	$("#custId").val(cust.custId);
	$("#add_ext1").val(cust.ext1).attr("disabled", true);
	
	layer.open({
		  type: 1,
		  title:"修改客户",
		  area: ['780px', '480px'], //宽高
          btn: ['提交','取消'],
		  content: $("#cust"),
		  yes:function(){
			  saveModifyCust();
		  },
		  success:function(){
			  $("#add_crmUserCode").attr("disabled", "true");
			  $(".sr-btn").hide();
		  }
	});
}

function remove(custId){
	layer.confirm('您是否要删除该客户？', {
		  btn: ['确认','取消'] //按钮
	}, function(){
		var index = layer.load(2);
		$.ajax({
			url:  ctx + "/cust/removeCust.ajax",
			type: "POST",
			dataType:"json",
			data:{
				custId:custId
			},
			success : function (cr) {
				layer.close(index);
				if(cr.code ==1){
					layer.closeAll();
					layer.alert("删除成功");
					newQuery();
				}else{
					layer.alert(cr.msg);
				}
			}
		});
	}, function(){
	});
}