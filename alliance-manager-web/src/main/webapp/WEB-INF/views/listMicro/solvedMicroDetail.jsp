<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
  	<link rel="stylesheet" href="${ctxStatic}/css/new.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
	<script src="${ctxStatic}/web/applyTip/tipList.js"></script>
  </head>
  
  <body>
   <div class="right">
		<div class="bread-crumb">
			<i class="bread-crumb-start"></i> <a href="javascript:;"
				class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
				class="bread-crumb-url">意向单管理</a>
		</div>
		<div class="search-bar bb clearfix ta-center">
           <a href="javascript:history.go(-1);" class="back-btn fl"><i class="back-ico"></i>返回</a>
           	申请详情<span class="f12 blue">（${vo.stateName}）</span>
           <div class="yx-info fr"><span>处理人：${vo.operator}</span><span class="ml30">处理时间：
           <fmt:formatDate value="${vo.dealDate}" pattern="yyyy-MM-dd hh:mm:ss"/>
           </span></div>
        </div>
        <div class="group-main">
		<div class="group-item">
			<div class="group-item-header">基本信息</div>
			<div class="group-content">
				<div class="item1">
					<div class="item-row">
						<label>企业名称：</label>
						<span class="large">${vo.conpanyName}</span>
					</div>
					<div class="item-row">
						<label>所在地区：</label>
						<span class="small">${vo.regionName }</span>
						<label class="ml30">购买金额：</label>
						<span class="small">
						<fmt:formatNumber type="number" value="${vo.amount/1000}" maxFractionDigits="11"/>
						元</span>
					</div>
					<div class="item-row">
						<label>购买用途：</label>
						<span class="large">${vo.purIntention}</span>
					</div>
					<div class="item-row">
						<label>联系人：</label>
						<span class="small">${vo.userName}</span>
						<label>QQ：</label>
						<span class="small">${vo.userQq}</span>
					</div>
					<div class="item-row">
						<label>手机：</label>
						<span class="small">${vo.userMobile}</span>
					</div>
				</div>
			</div>
		</div>  
		<div class="group-item">
			<div class="group-item-header bb">流程向导</div>
			<div class="group-content">
				<div class="item2 clearfix">
					<div class="steps rb">
						<span class="step-num n1"></span>
						<span class="step-ico n1"></span>
						<div class="step-cont">
							<div class="step-tl">业务洽谈</div>
							<div class="step-desc">联系客户确认购买的流量包类型 及数量，并通知客户转账缴费</div>
						</div>
					</div>
					<div class="steps rb">
						<span class="step-num n2"></span>
						<span class="step-ico n2"></span>
						<div class="step-cont">
							<div class="step-tl">缴费确认</div>
							<div class="step-desc">到财务确认客户是否已缴款，并 打印凭证盖章</div>
						</div>
					</div>
					<div class="steps">
						<span class="step-num n3"></span>
						<span class="step-ico n3"></span>
						<div class="step-cont">
							<div class="step-tl">创建客户</div>
							<div class="step-desc">到CRM系统创建客户资料</div>
						</div>
					</div>
				</div>
			</div>
		</div>   
		<div class="group-item">
			<div class="group-item-header bb">处理操作</div>
			<div class="group-content">
				<div class="item3 mt15">
					<div class="upload-cont">
					<c:if test="${vo.state eq 1 }">
					<div id="upload">
						<img layer-src="${ctx}/applyTip/showApplyConfirm.html?registId=${vo.registId}"
						 layer-pid="" src="${ctx}/applyTip/showApplyConfirm.html?registId=${vo.registId}" width='100%' height='100%' 
						alt="缴费凭证"
						>
					</div>
					<input id="registId" type="hidden" value="${vo.registId}">
					<%-- <a class="upload-yx" href="javascript:registPayConfirm('${vo.registId}');">缴费凭证</a> --%>
					<a class="upload-yx" href="javascript:;">缴费凭证</a>
					</c:if>
					
					<c:if test="${vo.state eq 2 }">
						<img src="${ctxStatic}/images/img-demo.png" >
						<a class="upload-yx" href="javascript:;">缴费凭证</a>
					</c:if>
					</div>
				</div>
			</div>
		</div>  
		<div class="group-item">
			<div class="group-content">
				<div class="item3">
					<div class="item-row">
						<label>CRM系统创建的客户号码：</label>
						<span class="small">${vo.crmPhoneNo}</span>
					</div>
				</div>
			</div>
		</div>
		</div>
	</div>
	<div id="payConfirmImage" class="contact apply mg20" style="display:none; width: auto;height:auto;">
	</div>
	 
	 
	<script type="text/javascript">
		$("#119").addClass("active");
	</script>
	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
