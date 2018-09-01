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
	<link href="${ctxStatic}/treeTable/themes/vsStyle/treeTable.min.css" rel="stylesheet" type="text/css" />
	<script src="${ctxStatic}/treeTable/jquery.treeTable.min.js" type="text/javascript"></script>
	<script type="text/javascript">
		$(function(){
			console.log("${list}");
			$("#treeTable").treeTable({expandLevel : 3});
		})
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
					<a class="edit-btn btn-add" href="javascript:add();" title="添加"></a>
					<a class="edit-btn btn-delete" href="javascript:;" title="删除"></a>
				</div>
			</div>
			<table id="treeTable" class="table">
				<thead>
					<tr>
						<th>菜单名称</th>
						<th>链接</th>
						<th>排序</th>
						<th>所属子系统</th>
						<th>权限标识</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
					<c:forEach items="${list}" var="menu">
						<tr id="${menu.menuId }" pId="${menu.pmenuId }">
							<td>${menu.menuName }</td>
							<td>${menu.menuUrl }</td>
							<td>${menu.showSeq }</td>
							<td>${menu.systemCodeName }</td>
							<td>${menu.accessPerm }</td>
							<td><a class="view-detail-btn">删除</a></td>
						</tr>
					</c:forEach>
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
