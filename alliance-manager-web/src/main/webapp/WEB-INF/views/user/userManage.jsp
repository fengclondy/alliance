<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>

<!DOCTYPE html>
<html>
	<head>
	<meta name="decorator" content="default" />
	<%@ include file="/WEB-INF/include/head.jsp"%>
	<title>用户管理</title>
	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
	<link href="${ctxStatic}/css/notice.css" rel="stylesheet" />
	<link rel="stylesheet" href="${ctxStatic}/css/new.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css" />
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css" />
	<script type="text/javascript" src="${ctxStatic}/selectordie/selectordie.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/localization/messages_cn.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.metadata.js"></script>
	</head>

<body>
	<!-- 右侧内容开始 -->
	<div class="right">
		<div class="bread-crumb">
			<i class="bread-crumb-start"></i> <a href="javascript:;" class="bread-crumb-url">您的位置</a> / <a
				href="javascript:;" class="bread-crumb-url">用户管理</a>
		</div>
		<div class="search-bar">
			<label>姓名：</label> <input id="s_userName" class="input" type="text" placeholder="请输入姓名" /> <label>地区：</label>
			<div class="select">
				<select class="myselect" id="s_regionId" value="${regionId}" >
					<option value=''>全部</option>
					<c:forEach items="${regionList}" var="item">
						<option value='${item.regionId }'>${item.regionName }(${item.regionCode })</option>
					</c:forEach>
				</select>
			</div>
			<label>用户状态：</label>
			<div class="select">
				<select class="myselect" id="s_state" value="${state }">
					<option value=''>全部</option>
					<option value="1">在用</option>
					<option value="2">锁定</option>
					<option value="0">停用</option>
				</select>
			</div>
			<a class="search-btn" href="javascript:newQuery();"></a>
			<div class="btn-group clear">
				<a id="btn_Add" class="edit-btn btn-add" href="javascript: add();" title="新增用户"></a>
			</div>
		</div>
		<table class="table" id="table">
			<thead>
				<tr>
					<th>登录名</th>
					<th>姓名</th>
					<th>手机</th>
					<th>邮箱</th>
					<th>电话</th>
					<th>地区</th>
					<th>状态</th>
					<th>操作</th>
				</tr>
			</thead>
			<tbody>
			</tbody>
		</table>
		<div class="page">
			<div style="clear:both;"></div>
		</div>
	</div>
	<!-- 右侧内容结束 -->
	<div class="user-add" style="display: none;" id="add_User">
		<form id="addForm">
			<div class="form-item">
				<input id="userId" name="userId" hidden="true" value=""/>
				<label>地区：</label>
				<div class="cust-add-select select">
					<select class="myselect" name="regionId" value="" id="add_regionId" >
						<c:forEach items="${regionList }" var="item">
							
							<option value="${item.regionId }">${item.regionName }(${item.regionCode })</option>
						</c:forEach>
					</select>
				</div>
			</div>
			
			<div class="form-item">
				<label>角色：</label>
				<div class="cust-add-select select">
					<select class="myselect" name="roleId" value="" id="add_roleId" >
						<c:forEach items="${roleList }" var="item">
							
							<option value="${item.roleId }">${item.roleName }</option>
						</c:forEach>
					</select>
				</div>
			</div>
			<div class="form-item">
				<label>登录名：</label><input class="input" type="text" id="username" name="username" >
			</div>
			<div class="form-item">
				<label>联系人姓名：</label><input class="input" type="text" id="userName" name="userName">
			</div>
			<div class="form-item">
				<label>手机：</label><input class="input" type="text" id="mobile" name="mobile">
			</div>
			<div class="form-item">
				<label>邮箱：</label><input class="input" type="text" id="email" name="email">
			</div>
			<div class="form-item">
				<label>固定电话：</label><input class="input" type="text" id="phone" name="phone">
				<div id="error" style="color:red;margin: 5px 0 0 115px;font-weight: bold;"></div>
			</div>
		</form>
	</div>

	<script src="${ctxStatic}/web/user/addUser.js" type="text/javascript"></script>
	<script src="${ctxStatic}/web/user/user.js" type="text/javascript"></script>
	<script src="${ctxStatic}/web/user/modifyUser.js" type="text/javascript"></script>
</body>
</html>

