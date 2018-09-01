<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta name="decorator" content="default">
<%@ include file="/WEB-INF/include/head.jsp"%>
<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
<link href="${ctxStatic}/css/notice.css" rel="stylesheet" />
<link rel="stylesheet" href="${ctxStatic}/css/bill.css" />
<link rel="stylesheet" href="${ctxStatic}/css/new.css">
<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
<link rel="stylesheet"
	href="${ctxStatic}/selectordie/selectordie_theme_01.css">
<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
</head>

<body>
	<div class="right">
		<div class="bread-crumb">
			<i class="bread-crumb-start"></i> <a href="javascript:;"
				class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
				class="bread-crumb-url">合同管理</a>
		</div>
		<div class="search-bar">
			<input type="hidden" id="s_custId" value=""> <input
				id="autocomplete" class="input w230" type="text" placeholder="企业名称"
				oninput="javascript: $('#s_custId').val(''); ">


			<div class='select'>

				<!-- <div class="sod_select " tabindex="0" data-cycle="false"
					data-links="false" data-links-external="false" data-filter="">
					</div> -->
					<select style="color:#ADADAD;" class='sod_select' id="s_regionId" value="${regionId}">
						<option value=''>全省</option>
						<c:forEach items="${regionList}" var="item">
							<option value='${item.regionId }'>${item.regionName }</option>
						</c:forEach>
					</select>
				</div>

				<!-- <input class="input w130" type="text" placeholder="合同编号" id="s_contId"> -->
				<a class="search-btn" href="javascript: newQuery();"></a>
			</div>
			<div id="tableList"></div>
			<div class="page">
				<ul class="pagination">
				</ul>
				<div style="clear:both;"></div>
			</div>
		</div>
		<div id="zhuancun" class="contact apply" style="display:none;">
			<div class="apply-header">
				<span class="g12 mr30" id="zc_contId">合同编码：201608180001</span>| <span
					class="f12 mr30" id="zc_custName"> 亚信科技南京有限公司</span>
			</div>
			<div class="apply-content">
				<div class="form-item">
					<label for="">保证金余额：</label><span class="bl" id="zc_deposit">16</span>
					万元
				</div>
				<div class="form-item">
					<label for="">当前透支额度：</label><span class="bl" id="zc_credit">30</span>
					万元
				</div>
				<div class="form-item">
					<label for="">当前可用余额：</label><span class="bl" id="zc_balance">30</span>
					万元
				</div>
				<div class="form-item">
					<label for="">本次转存金额：</label>
					<div class="input-box w-zc">
						<input type="hidden" id="zcContId" value=""> <input
							type="text" class="input og" value="" id="zc_val"
							oninput="return changeAmount('zc', this.value)"> 万元
					</div>
				</div>
				<div class="form-item">
					<label for="">转存后可用余额：</label><span class="bl" id="zc_amount">30</span>
					万元
				</div>
			</div>
		</div>
		<div id="touzhi" class="contact apply" style="display:none;">
			<div class="apply-header">
				<span class="g12 mr30" id="tz_contId">合同编码：201608180001</span>| <span
					class="f12 mr30" id="tz_custName"> 亚信科技南京有限公司</span>
			</div>
			<div class="apply-content">
				<div class="form-item">
					<label for="">保证金余额：</label><span class="bl" id="tz_deposit">16</span>
					万元
				</div>
				<div class="form-item">
					<label for="">当前可用余额：</label><span class="bl" id="tz_balance">30</span>
					万元
				</div>
				<div class="form-item">
					<label for="">当前透支额度：</label><span class="bl" id="tz_credit">30</span>
					万元
				</div>
				<div class="form-item">
					<label for="">本次透支金额：</label>
					<div class="input-box w-zc">
						<input type="hidden" id="tzContId" value=""> <input
							type="text" class="input og" value="" id="tz_val"
							oninput="return changeAmount('tz', this.value)"> 万元
					</div>
				</div>
				<div class="form-item">
					<label for="">透支后可用余额：</label><span class="bl" id="tz_amount">30</span>
					万元
				</div>
			</div>
		</div>

		<script type="text/javascript"
			src="${ctxStatic }/web/contract/adminList.js"></script>
		<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script>
		<link rel="stylesheet"
			href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
		<script src="${ctxStatic }/jquery/jquery-formatMoney.js"></script>
</body>
</html>
