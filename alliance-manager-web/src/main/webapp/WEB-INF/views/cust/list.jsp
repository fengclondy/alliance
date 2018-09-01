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
	
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/localization/messages_cn.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.metadata.js"></script>
	<script type="text/javascript">
		var showModify = false;
	</script>
  </head>
  
  <body>
   <div class="right">
			<div class="bread-crumb">
				<i class="bread-crumb-start"></i> <a href="javascript:;"
					class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
					class="bread-crumb-url">客户管理</a>
			</div>
			<div class="search-bar">
				<!-- <div class="search-wrap">
					<input id="s_custId" type="hidden" name="custName" value="" >
					<input id="s_custName" class="input" type="text" placeholder="请输入客户名称" autocomplete="off" oninput="searchCusts(this.value);">
					<ul id="search-list" class=""></ul>
				</div> -->
			
				<input type="hidden" id="s_custId" value="" >
				<input id="autocomplete" class="input" type="text" placeholder="企业名称" oninput="javascript: $('#s_custId').val('');"> 
				<input class="input" type="text" placeholder="客户号码" id="s_crmUserCode">
                <input class="input" type="text" placeholder="联系人姓名" id="s_userName">
                <input class="input" type="text" placeholder="手机号码" id="s_userMobile">
                
				<a class="search-btn" href="javascript: newQuery();"></a>
				
				<div class="btn-group clear">
						<a class="edit-btn btn-add" href="javascript:add();" title="添加"></a>
				</div>
				
			</div>
			<table class="table">
                <thead>
                    <tr>
                        <th>企业名称</th>
                        <th>企业简称</th>
                        <th>客户号码</th>
                        <th>所属地区</th>
                        <th>联系人姓名</th>
                        <th>联系人手机</th>
                        <th>联系人邮箱</th>
                        <c:if test="${roleType eq 2}"><th>开放接口</th></c:if>
                        <th>操作</th>
                    </tr>
                </thead>
                <tbody>
                </tbody>
            </table>
            <div class="page"></div>
		</div>
		
	<div id="cust" style="display:none;">
        <div class='user-add'>
        	<form id="add_form">
        	<input type="hidden" name="custId" id="custId">
            <div class='form-item'>
            	<label>客户号码：</label>
            	<div class="input-box">
            		<input class='input required' type='text' name="crmUserCode" id="add_crmUserCode" placeholder="请输入客户号码" oninput="javascript: clearAutoInput();" ><a href="javascript:srUser();" class="sr-btn"></a>
            	</div>
            </div>
            
            <div class="from-item hg30"><span class="label-header">企业基本信息  </span><p class="line"></p></div>
            
            <div id="success-sr">
	            <div class='form-item'>
	            	<label>企业名称：</label><input class='input' type='text' disabled="true" id="add_custName">
	            	<label>客户所属地区：</label><input class='input' type='text' disabled="true" id="add_regionName">
	            </div>
	            <div class='form-item'>
	            	<label>证件类型：</label><input class='input' type='text' disabled="true" id="add_certTypeName">
	            	<label>证件号码：</label><input class='input' type='text' disabled="true" id="add_certNbr">
	            </div>
	            <div class='form-item'>
	            	<label>企业简称：</label><input class='input required' type='text' name="shortName">
	            	<label>联系人姓名：</label><input class='input required' type='text' name="userName">
	            </div>
	            <div class='form-item'>
	            	<label>联系人手机号：</label><input class='input required' type='text' name="userMobile">
	            	<label>联系人邮箱：</label><input class='input' type='text' name="userEmail">
	            </div>
	            <div class='form-item'>
	            	<label>摊分比例：</label>
	            	 <div class="input-box w-zc" style="background:#E3E3E3;">
                        <input type="text" class="input required" readonly="true" style="text-align: right; background:#E3E3E3;" name="ext1" id="add_ext1" value="50">%
                    </div> 
	            	<!-- <input class='input required' type='text' id="add_ext1"> % -->
	            	<label>CRM客户ID：</label><input class='input' type='text' disabled="true" id="add_crmCustSn">
	            </div>
	            <div class='form-item'>
	            	<label>CRM账户ID：</label><input class='input' type='text' disabled="true" id="add_crmAcctSn">
	            	<label>CRM用户ID：</label><input class='input' type='text' disabled="true" id="add_crmUserSn">
	            	<div id="error" style="color:red;margin: 5px 0 0 115px;font-weight: bold;"></div>
	            </div>
            </div>
            </form>
            <div id="fail" class="no-user" style="display:none;">
                <div><img src="${ctxStatic}/images/fail.jpg" alt="失败"></div>
                <span class="fail-info">没有搜索到相关企业信息呢～</span>
            </div>
        </div>
    </div>
    <div id="custDesc" style="display:none;">
        <div class='user-add'>
            <div class='form-item'>
            	<label>客户号码：</label><div class="input-box"><input class='input' type='text' readOnly="true" id="view_crmUserCode"></div>
            </div>
            <div class="from-item hg30"><span class="label-header">企业基本信息  </span><p class="line"></p></div>
            <div class='form-item'>
            	<label>企业名称：</label><input class='input' type='text' readOnly="true" id="view_custName">
            	<label>企业简称：</label><input class='input' type='text' readOnly="true" id="view_shortName">
            </div>
            <div class='form-item'>
            	<label>证件类型：</label><input class='input' type='text' readOnly="true" id="view_certTypeName">
            	<label>证件号码：</label><input class='input' type='text' readOnly="true" id="view_certNbr">
            </div>
            <div class='form-item'>
            	<label>联系人姓名：</label><input class='input' type='text' readOnly="true" id="view_userName">
            	<label>联系人手机号：</label><input class='input' type='text' readOnly="true" id="view_userMobile">
            </div>
            <div class='form-item'>
            	<label>联系人邮箱：</label><input class='input' type='text' readOnly="true" id="view_userEamil">
            	<label>客户所属地区：</label><input class='input' type='text' readOnly="true" id="view_regionName">
            </div>
            <div class='form-item'>
            	<label>摊分比例：</label><input class='input' type='text' readOnly="true" id="view_ext1">
            	<label>CRM客户ID：</label><input class='input' type='text' readOnly="true" id="view_crmCustSn">
            </div>
            <div class='form-item'>
            	<label>CRM账户ID：</label><input class='input' type='text' readOnly="true" id="view_crmAcctSn">
            	<label>CRM用户ID：</label><input class='input' type='text' readOnly="true" id="view_crmUserSn">
            </div>
        </div>
    </div>
      <div id="jk" style="display:none;">
        <div class='user-add'>
        	<form id="bindIPForm">
            <div class='form-item'>
            	<label>企业名称：</label>
            		<input class='input w3' disabled="disabled" id="jk_custName" class='input required' type='text' />
            </div>
            <div class='form-item'>
	            <label>绑定IP：</label>
	            <input placeholder="绑定多个IP以英文,分隔" class='input w3' id='hostIP' name="hostIP" type='text'>
	        </div>
            </form>
        </div>
      </div>
	<script type="text/javascript">var roleType = ${roleType}</script>
    <script src="${ctxStatic}/web/cust/list.js"></script>
	<script src="${ctxStatic}/web/cust/addCust.js"></script>
	<script src="${ctxStatic}/web/cust/modifyCust.js"></script>
	<script src="${ctxStatic}/web/cust/auditCust.js"></script>
	
	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
