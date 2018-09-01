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
					class="bread-crumb-url">系统管理</a>
			</div>
			<div class="search-bar">
				<input class="input" type="text" placeholder="请输入用户名"> 
				<input class="input" type="text" placeholder="请输入手机号码"> 
				<a class="search-btn" href="javascript:;"></a>
				<div class="btn-group clear">
					<a class="edit-btn btn-modify" href="javascript:;" title="修改"></a>
					<a class="edit-btn btn-add" href="${ctx}/sysUser/addUser.html" title="添加"></a>
					<a class="edit-btn btn-delete" href="javascript:;" title="删除"></a>
				</div>
			</div>
			<table class="table">
				<thead>
					<tr>
						<th></th>
						<th>用户名</th>
						<th>登录名称</th>
						<th>手机号码</th>
						<th>邮箱</th>
						<th>地区</th>
						<th>电话号码</th>
						<th>公司名称</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<th><a class="more-view up" href="javascript:;"></a></th>
						<td>小李飞刀</td>
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
							<div class="view-detail">权限分配：业务管理、订单管理、客户管理、账单查询、流量池</div>
							<div class="view-detail">合作伙伴购买固定量的流量，然后为指定用户充值。合作伙伴购买固定量的流</div>
							<div class="view-detail p10">
								业务办理:用户其他信息
								<div class="detail-time">创建时间： 2016-01-06</div>
							</div>
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
