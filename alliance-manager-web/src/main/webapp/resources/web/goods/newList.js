
var validator;

$(function(){
	
		page(1,12);
//		$.ajax({
//			
//			url: ctx+'/goods/findGoodsType.ajax',
//			type: "POST",
//			dataType:"json",
//			data:{
//			},
//			success: function(data) {
//			  for(var i=0;i<data.length;i++){
//				  $("#goodsType").append("<option value="+data[i].attrCode+">"+data[i].attrName+"</option>");
//			  }
//			  
//			},
//			error:function(cr){
//				layer.alert("异常");
//			}
//			
//		});
		
//		$.ajax({
//			
//			url: ctx+'/goods/findDataType.ajax',
//			type: "POST",
//			dataType:"json",
//			data:{
//			},
//			success: function(data) {
//			  for(var i=0;i<data.length;i++){
//				  $("#dataType").append("<option value="+data[i].attrCode+">"+data[i].attrName+"</option>");
//			  }
//			  
//			},
//			error:function(cr){
//				layer.alert("异常");
//			}
//			
//		});
		
		$('select').selectOrDie();
		
		validator =$("#goods_form").validate({
			rules:{
				goodsModel:{
					required:true,
					rangelength:[3,10]
				},
				goodsSpecs:{
					required:true,
					isInteger:true
				},
				goodsPrice:{
					required:true,
					isInteger:true
				},
				billOfferId:{
					required:true,
					isInteger:true
				}
			},
			messages:{
				goodsModel:{
					required:"请输入商品型号",
					rangelength:"登录名长度必须为3-10位"
				},
				goodsSpecs:{
					required:"请输入商品规格",
					isInteger:"请输入整数"
				},
				goodsPrice:{
					required:"请输入商品价格",
					isInteger:"请输入整数"
				},
				billOfferId:{
					required:"请输入CRM销售品ID",
					isInteger:"请输入整数"
				}
				
			},
			
			submitHandler:function(form){
				alert("验证通过");
				form.submit();
			},
			errorPlacement: function(error, element) { 
				layer.tips($(error).text(), "#"+ $(element).attr("id"));
	            return false;
		        }
			});
		
			jQuery.validator.addMethod("isInteger", function(value, element) { 
				var reg = /^-?\d+$/; 
				return this.optional(element) || (reg.test(value)); 
			}, "数字输入错误");
		
	})
			

	
function page(n,s){
		var index = layer.load(2);
		
		$.ajax({
			
			url: ctx+'/goods/findAllsGoods.ajax',
			type: "POST",
			dataType:"json",
			data:{
				pageNo:n,
				pageSize:s
			},
			success: function(data) {
				$(".g-table>tbody").empty();
				$("#noData").empty();
				layer.close(index);
//				var list = data.reModel.list;
				var list = data;
				if(list.length==0){
					$(".g-table").after(noTips);
					return;
				};
				for(var i=0;i<list.length;i++){
					var tr = $("<tr></tr>");
					tr.append("<td>"+list[i].goodsId+"</td>");
					tr.append("<td>"+list[i].dataTypeDesc+"</td>");
					tr.append("<td>"+list[i].goodsTypeDesc+"</td>");
					tr.append("<td>"+list[i].goodsModel+"</td>");
					tr.append("<td>"+list[i].goodsPrice/1000+"</td>");
					tr.append("<td>"+list[i].stateDesc+"</td>");
					tr.append("<td>"+list[i].billOfferId+"</td>");
					if(roleType == 100){ 
					tr.append("<td><a class='modify-btn' title='修改商品' href='javascript: findGoodsById(\"" + list[i].goodsId+ "\")'></a>\
							   <a class='del-btn' title='删除商品' href='javascript: deleteconfirm(\"" +list[i].state +"\",\""+ list[i].goodsId + "\")'></a></td>");
				     }
					$(".g-table>tbody").append(tr);
				}
//				 $(".page").html(data.reModel.html);
			},
			error:function(cr){
				layer.alert("异常");
			}
			
		});
	}


function add(){
	$("#goods_form")[0].reset();
	
	
	$(".myselect").selectOrDie('update');
   
	layer.open({
          type: 1,
          title:"新增商品",
          area: ['516px', '460px'], //宽高
          btn: ['提交','取消'],
          content: $("#goods"),
          yes:function(){
        	  addGoods();
          },
  		  btn2:function(){
  			$("#goods_form").validate().resetForm();
  			$("#goods_form")[0].reset();
  		  },
  		  cancel:function(){
  			$("#goods_form").validate().resetForm();
  			$("#goods_form")[0].reset();
  		  },
          success:function(){
        	  
          }
        });
}

function addGoods(){
	var flag=validator.form();
	if(flag){
		
		var index = layer.load(2);
		$.ajax({
		
		url: ctx+'/goods/addGoods.ajax',
		type: "POST",
		dataType:"json",
		data:$("#goods_form").serialize(),
		success: function(data) {
			layer.close(index);
			layer.closeAll();
			page(1,12);
			layer.msg(data.msg);
			$("#goods_form")[0].reset();
		},
		error:function(cr){
			layer.alert("异常");
		}
		
	});
  }
}

//修改商品页面展示
function findGoodsById(goodsId){
		var index = layer.load(2);
$.ajax({
		
		url: ctx+'/goods/findGoodsById.ajax',
		type: "POST",
		dataType:"json",
		data:{
			goodsId:goodsId
		},
		success: function(data) {
			layer.close(index);
			showGoods(data.reModel);
		},
		 btn2:function(){
	  		$("#goods_form").validate().resetForm();
	  		$("#goods_form")[0].reset();
		},
		 cancel:function(){
			$("#goods_form").validate().resetForm();
			$("#goods_form")[0].reset();
		},
		error:function(cr){
			layer.alert("异常");
		}
		
	});
}

function showGoods(goodsVo){
	
	$("#showId").val(goodsVo.goodsId);
	$("#goodsType").val(goodsVo.goodsType);
	$("#dataType").val(goodsVo.dataType);
	$("#state").val(goodsVo.state);
	$("#goodsModel").val(goodsVo.goodsModel);
	$("#goodsSpecs").val(goodsVo.goodsSpecs);
	$("#goodsPrice").val(goodsVo.goodsPrice/1000);
	$("#billOfferId").val(goodsVo.billOfferId);
	
	layer.open({
		  type: 1,
		  title:"修改商品",
		  area: ['780px', '480px'], //宽高
          btn: ['提交','取消'],
		  content: $("#goods"),
		  yes:function(){
			  saveModifyGoods();
		  },
		  btn2:function(){
		  		$("#goods_form").validate().resetForm();
	      },
		  cancel:function(){
				$("#goods_form").validate().resetForm();
		  },
		  success:function(){
			  $("#add_crmUserCode").attr("disabled", "true");
			  $(".sr-btn").hide();
			  
			  $(".myselect").selectOrDie('update');
		  }
	});
	
}


function saveModifyGoods(){
	var flag=validator.form();
	if(flag){
	
	var index = layer.load(2);
	$("#goodsId").val($("#showId").val());
	$.ajax({
		url: ctx+'/goods/modifyGoods.ajax',
		type: "POST",
		dataType:"json",
		data:$("#goods_form").serialize(),
		success : function (cr) {
			layer.close(index);
			if(cr.code ==1){
				layer.closeAll();
				layer.alert(cr.msg);
				page(1,12);
			}else{
				layer.alert(cr.msg);
			}
		}
	});
	}
}


//删除前的询问框
function deleteconfirm(state,goodsId){
	  if(state == 0){
		   layer.alert("商品已删除");
		   return;
	   }
	  
	  layer.confirm('确定删除吗？', {
		  btn: ['确定','取消'] //按钮
	   }, function(){
		   deleteGoods(goodsId);
	   }, function(){
		   layer.closeAll();
	   });
}


function deleteGoods(goodsId){
	var index = layer.load(2);
	$.ajax({
		
		url: ctx+'/goods/deleteGoods.ajax',
		type: "POST",
		dataType:"json",
		data:{
			goodsId:goodsId
			
		},
		success: function(data) {
			layer.close(index);
			layer.closeAll();
			page(1,12);
			layer.msg(data.msg);
		},
		error:function(cr){
			layer.alert("异常");
		}
		
	});
}

