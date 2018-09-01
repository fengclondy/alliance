$(function(){
		page(1,12);
	})
			
	function page(n,s){
		
//		var index = layer.load(2);
		
		$.ajax({
			
			url: ctx+'/goods/findAllGoods.ajax',
			type: "POST",
			dataType:"json",
			data:{
				pageNo:n,
				pageSize:s
			},
			success: function(data) {
				$(".g-table>tbody").empty();
				$("#noData").empty();
				var list = data.reModel.list;
				if(list.length==0){
					$(".g-table").after(noTips);
					return;
				};
				for(var i=0;i<list.length;i++){
					var tr = $("<tr></tr>");
					tr.append("<td>"+list[i].goodsId+"</td>");
					tr.append("<td>"+goodsType(list[i].dataType)+"</td>");
					tr.append("<td>"+list[i].goodsModel+"</td>");
					tr.append("<td>"+list[i].goodsPrice/1000+"</td>");
					tr.append("<td>"+state(list[i].state)+"</td>");
					tr.append("<td>"+list[i].billOfferId+"</td>");
					
					$(".g-table>tbody").append(tr);
				}
				 $(".page").html(data.reModel.html);
			},
			error:function(cr){
				layer.alert("异常");
			}
			
		});
	}
	
	
	function goodsType(id){
		//流量类型：100 全国通用流量；200 省内通用流量；300 本地通用流量
		if(id == 100){
			return "全国通用";
		}
		if(id == 200){
			return "省内通用";
		}
		if(id == 300){
			return "本地通用";	
		}
	}
	function state(id){
		if(id == 1){
			return "有效";
		}
		if(id == 0){
			return "无效";
		}
	}