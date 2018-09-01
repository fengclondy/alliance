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
            <i class="bread-crumb-start"></i>
            <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
            <a href="javascript:;" class="bread-crumb-url">合同管理</a> /
            <a href="javascript:;" class="bread-crumb-url">激活审核</a>
        </div>
        <div class="search-bar bb">
            <input type="hidden" id="hiddencustName" name="custId" value="" >
		  	<input id="autocomplete" name="custName" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#hiddencustName').val(''); ">
            <input id ="contId" name="contId" value="" class="input w130" type="text"  placeholder="合同编号">
          
            <a class="search-btn" href="javascript: recQuery();"></a>
        </div>
        <div class="table-list" id="listContractTab">
        
        
        
		</div>
		<div class="page" >
            
            <div style="clear:both;"></div> 
        </div>
    </div>
    
     <!-- 合同审核弹窗 -->
  <div id="activeAudict" class="contact apply mg20" style="display:none;">
    
              审核意见：<textarea  id="remark" class="textarea sh"></textarea>
      
  </div>
  
  <div id="payConfirmImage" class="contact apply mg20" style="display:none; width: 470px;height:450px;">
    
 </div>
<script src="${ctxStatic }/web/contract/auditContract.js"></script>
  	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>

</html>
