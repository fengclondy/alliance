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
           	申请详情<span class="f12 red">（${vo.stateName}）</span>
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
						<span class="small"><fmt:formatNumber type="number" value="${vo.amount/1000}" maxFractionDigits="11"/>元</span>
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
					 <div id="photoImage">
					 <img id="imgId" src="${ctxStatic}/images/img-demo.png"/>
                    </div>
						<!-- <a class="upload-yx" href="javascript:;">
							上传缴费凭证（图片2M以内）
							<input type="file">
						</a> -->
						
						<input type="file" id="applyConfirm" name="applyConfirm" style="display:none"/> 
			 <span id="uFileName"></span>
			 <input type="hidden" id="hidFileName" name = "payCert2" value="" />
              <a  id="tips0" class="upload-yx" href="javascript:void(0)" onclick="javascript:start();">上传凭证</a>
					</div>
				</div>
			</div>
		</div>  
		<div class="group-item">
			<div class="group-content">
				<div class="item3">
					<div class="item-row">
						<label>在CRM系统创建的客户号码：</label>
						<input id="crmPhone" type="input" class="input" name="crmPhone">
					</div>
				</div>
			</div>
		</div>
		<div class="yx-footer">
			<a class="active-btn blue" href="javascript:submit('${vo.registId}');">提交</a>
			<a class="active-btn org" href="javascript:give('${vo.registId}');">弃单</a>
		</div>
		</div>
	</div>
	<script type="text/javascript" src="${ctxStatic}/jquery-upload/ajaxfileupload.js"></script>
	<script src="${ctxStatic}/web/applyTip/tipList.js"></script>
	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
