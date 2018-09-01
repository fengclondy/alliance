<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
  	<%-- <link href="${ctxStatic}/select2/css/select2.css" rel="stylesheet" />
	<script src="${ctxStatic}/select2/select2.full.min.js" type="text/javascript"></script> --%>
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
	<script type="text/javascript">
		
	</script>
  </head>
  
  <body>
   <div class="right">
			<div class="bread-crumb">
				<i class="bread-crumb-start"></i> <a href="javascript:;"
					class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
					class="bread-crumb-url">角色管理</a>
			</div>
			<div class="search-bar">
				<div class="btn-group clear">
					<a class="edit-btn btn-add" href="${ctx}/role/add.html" title="添加"></a>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th>角色名称</th>
						<th>角色类型</th>
						<th>所属子系统</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><a class="more-view up" href="javascript:;"></a></th>
						<td>系统管理员</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail">
						<td></td>
						<td class="td-detail" colspan="7">
							<div class="view-detail">角色描述：业务管理、订单管理、客户管理、账单查询、流量池</div>
						</td>
					</tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
					<tr>
						<th><a class="more-view" href="javascript:;"></a></th>
						<td>小李飞刀</td>
						<td>admin</td>
						<td>18920853698</td>
						<td>189208536@qq.com</td>
						<td>四川省</td>
						<td>0215-85639874</td>
						<td>四川电信成都分公司</td>
					</tr>
					<tr class="tr-detail"></tr>
				</tbody>
			</table>
			<div class="page">
				<ul class="pagination">
					<li><a href="">←</a></li>
					<li class="active"><a href="">1</a></li>
					<li><a href="">2</a></li>
					<li><a href="">3</a></li>
					<li><a href="">4</a></li>
					<li><a href="">39</a></li>
					<li><a href="">→</a></li>
				</ul>
				<div style="clear:both;"></div>
			</div>
		</div>
</body>
</html>
