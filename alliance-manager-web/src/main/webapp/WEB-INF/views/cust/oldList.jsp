<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
  </head>
  
  <body>
   <div class="right">
			<div class="bread-crumb">
				<i class="bread-crumb-start"></i> <a href="javascript:;"
					class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
					class="bread-crumb-url">客户管理</a>
			</div>
			<div class="search-bar">
				<div class="search-wrap">
					<input id="s_custId" type="hidden" name="custName" value="" >
					<input id="s_custName" class="input" type="text" placeholder="请输入公司名称" autocomplete="off" oninput="searchCusts(this.value);">
					<ul id="search-list" class=""></ul>
				</div>
				<input id="s_originCustId" class="input" type="text" placeholder="请输入客户号码" value="" >
				<input id="s_userName" class="input" type="text" placeholder="请输入联系人姓名" value="" >
				<input id="s_userMobile" class="input" type="text" placeholder="请输入联系人手机号" value="" > 
				<a class="search-btn" href="javascript: newQuery();"></a>
				<div class="btn-group clear">
					<a class="edit-btn btn-add" href="javascript:addCust();" title="添加"></a>
				</div>
			</div>
			<table id="listCustTab" class="table">
				<thead>
					<tr>
						<th>企业简称</th>
						<th>企业名称</th>
						<th>客户号码</th>
						<th>所属地市</th>
						<th>联系人姓名</th>
						<th>联系人手机号</th>
						<th>联系人邮箱</th>
						<th>状态</th>
						<th>操作</th>
					</tr>
				</thead>
				<tbody>
				</tbody>
			</table>
			<div class="page">
			</div>
		</div>
		<div id="addCust" class="user-add large-input" style="display:none;">
			<form id="custForm" action="">
				<div class="form-item">
					<label>客户名称：</label>
					<div class="input-ico">
						<input class="input" type="text" name="custName" id="custName">
					</div>
				</div>
				<div class="form-item">
					<label>客户简称：</label>
					<div class="input-ico">
						<input class="input" type="text" name="shortName" id="shortName">
						</div>
				</div>
				<div class="form-item">
					<label>客户类型：</label>
					<div style='width:220px' class='select'>
						<select id="custType" name="custType" class='myselect'>
							<c:forEach items="${custTypeList }" var="list">
							<option value='${list.attrCode }'>${list.attrName }</option>
							</c:forEach>
		               </select>
	                </div>
				</div>
				<div class="form-item">
					<label>所属区域：</label>
					<div style='width:220px' class='select'>
						<select id="regionId" name="regionId" class='myselect'>
		                   <c:forEach items="${regionList }" var="list">
							<option value='${list.regionId }'>${list.regionName }(${list.regionCode })</option>
							</c:forEach>
		               </select>
	                </div>
				</div>
				<div class="form-item">
					<label>证件类型：</label>
					<div style='width:220px' class='select'>
						<select id="certType" name="certType" class='myselect'>
		                   <c:forEach items="${custCertTypeList }" var="list">
							<option value='${list.attrCode }'>${list.attrName }</option>
							</c:forEach>
		               </select>
	                </div>
				</div>
				<div class="form-item"><label>证件号码：</label><input class="input" type="text" name="certNbr" id="certNbr"></div>
				<div class="form-item"><label>联系人姓名：</label><input class="input" type="text" name="userName" id="userName"></div>
				<div class="form-item"><label>联系人手机号：</label><input class="input" type="text" name="userMobile" id="userMobile"></div>
				<div class="form-item"><label>联系人邮箱：</label><input class="input" type="text" name="userEmail" id="userEmail"></div>
				<div class="form-item"><label>固定电话：</label><input class="input" type="text" name="userPhone" id="userPhone"></div>
				<div class="form-item large-from-item">
					<label>客户地址：</label>
					<textarea class="textarea" name="custAddr" id="custAddr"></textarea>
				</div>
			</form>
		</div>
		
		<div id="detailCust" class="user-add large-input" style="display:none;">
			<div class="form-item">
				<label>客户名称：</label>
				<div class="input-ico">
					<input class="input" type="text" id="v_custName" readOnly="readOnly">
				</div>
			</div>
			<div class="form-item">
				<label>客户简称：</label>
				<div class="input-ico">
					<input class="input" type="text" id="v_shortName" readOnly="readOnly">
				</div>
			</div>
			<div class="form-item">
				<label>客户类型：</label>
				<div class="input-ico">
					<input class="input" type="text" id="v_custType" readOnly="readOnly">
				</div>
			</div>
			<div class="form-item">
				<label>所属区域：</label>
				<div class="input-ico">
					<input class="input" type="text" id="v_regionId" readOnly="readOnly">
				</div>
			</div>
			<div class="form-item">
				<label>证件类型：</label>
				<div class="input-ico">
					<input class="input" type="text" id="v_certType" readOnly="readOnly">
				</div>
			</div>
			<div class="form-item"><label>证件号码：</label><input class="input" type="text" id="v_certNbr" readOnly="readOnly"></div>
			<div class="form-item"><label>联系人姓名：</label><input class="input" type="text" id="v_userName" readOnly="readOnly"></div>
			<div class="form-item"><label>联系人手机号：</label><input class="input" type="text" id="v_userMobile" readOnly="readOnly"></div>
			<div class="form-item"><label>联系人邮箱：</label><input class="input" type="text" id="v_userEmail" readOnly="readOnly"></div>
			<div class="form-item"><label>固定电话：</label><input class="input" type="text" id="v_userPhone" readOnly="readOnly"></div>
			<div class="form-item large-from-item">
				<label>客户地址：</label>
				<textarea class="textarea" id="v_custAddr" readOnly="readOnly"></textarea>
			</div>
		</div>
	<script type="text/javascript">
		var custTypeList = {};
		var regionList = {};
		var certTypeList = {};
	</script>
	<c:forEach items="${custTypeList }" var="list">
		<script type="text/javascript">
			custTypeList["${list.attrCode }"] = "${list.attrName }";
		</script>
	</c:forEach>
	<c:forEach items="${regionList }" var="list">
		<script type="text/javascript">
			regionList["${list.regionId }"] = "${list.regionName }(${list.regionCode })";
		</script>
	</c:forEach>
	<c:forEach items="${custCertTypeList }" var="list">
		<script type="text/javascript">
			certTypeList["${list.attrCode }"] = "${list.attrName }";
		</script>
	</c:forEach>
	
	<script src="${ctxStatic}/web/cust/list.js"></script>
	<script src="${ctxStatic}/web/cust/addCust.js"></script>
	<script src="${ctxStatic}/web/cust/modifyCust.js"></script>
	<script src="${ctxStatic}/web/cust/auditCust.js"></script>
	<script src="${ctxStatic}/web/cust/resetPassword.js"></script>
</body>
</html>
