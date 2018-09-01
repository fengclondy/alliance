$(function(){
	
});

function audit(custId){
	
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
				cust = cr.reModel;
//				alert(cust);
				$("#custId").val(cust.custId);
				$("#custName").val(cust.custName);
				$("#shortName").val(cust.shortName);
				$("#custType").val(cust.custType);
				$("#regionId").val(cust.regionId);
				$("#certType").val(cust.certType);
				$("#certNbr").val(cust.certNbr);
				$("#userName").val(cust.userName);
				$("#userMobile").val(cust.userMobile);
				$("#userEmail").val(cust.userEmail);
				$("#userPhone").val(cust.userPhone);
				$("#custAddr").val(cust.custAddr);
				
				layer.open({
					  type: 1,
					  title:"审核客户",
					  area: ['760px', '380px'], //宽高
					  btn: ['通过','不通过'],
					  content: $("#addCust"),
					  yes:function(){
						  auditPassCust(custId,101);
					  },
					  btn2:function(){
						  auditPassCust(custId,202);
					  },
					  success:function(){
						  $('select').selectOrDie();
					  }
					});
				
			}else{
				layer.alert(cr.msg);
			}
		}
	});
	
}

function auditPassCust(custId,status){
	var index = layer.load(2);
	
	$.ajax({
		url:  ctx + "/cust/auditCust.ajax",
		type: "POST",
		dataType:"json",
		data:{
			custId:custId,
			status:status
		},
		success : function (cr) {
			layer.close(index);
			if(cr.code ==1){
				layer.closeAll();
				newQuery();
			}else{
				layer.alert(cr.msg);
			}
		}
	});
}