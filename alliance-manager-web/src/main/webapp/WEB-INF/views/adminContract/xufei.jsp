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
         <a href="javascript:;" class="bread-crumb-url">续费审核</a>
     </div>
     <div class="search-bar bb">
         <input type="hidden" id="s_custId" value="" >
		 <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#s_custId').val(''); ">
         <input class="input w130" type="text" placeholder="合同编号" id="s_contId" >
         <a class="search-btn" href="javascript: newQuery();"></a>
     </div>
     <div id="tableList">

	</div>
     <div class="page">
         <ul class="pagination">
         </ul>
         <div style="clear:both;"></div>
     </div>
 </div>
         <!-- 审核弹窗 -->
	<div id="audit" class="contact apply mg20" style="display:none;">
		审核意见：
		<textarea id="remark" class="textarea sh" ></textarea>
	</div>
 <div id="renewalConfirm" class="contact apply mg20" style="display:none; width: 470px;height:450px;">
 
 </div>
 	<script src="${ctxStatic }/web/contract/renewal.js"></script> 
 	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
