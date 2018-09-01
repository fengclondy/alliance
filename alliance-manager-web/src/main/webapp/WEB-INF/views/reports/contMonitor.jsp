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
          <a href="javascript:;" class="bread-crumb-url">报表管理</a> /
            <a href="javascript:;" class="bread-crumb-url">合同监控</a>
      </div>
      <div class="search-bar p-r">
          <input type="hidden" id="custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#custId').val('');">
          <a class="search-btn" href="javascript: contMonitor();"></a>
          <%--<a href="javascript:exportReport(31);" class="btn download-btn"><i class="download-ico"></i>报表导出</a>--%>
      </div>
      <div class="table-tab">
      	<form id="contForm">
          <table id="contTable" class="table-c">
              <thead>
                  <tr>
                      <th>客户名称</th>                      
                      <th>签约地市</th>
                      <th>合同号</th>
                      <th>合同剩余时间（天）</th>
                      <th>消费金额（元）</th>                      
                      <th>可用金额（元）</th>    
                      <th>授权金额（元）</th>    
                      <th>授权金额消耗进度</th>    
                      <th>合同金额（元）</th>    
                      <th>合同金额消耗进度</th>    
                  </tr>
              </thead>
              
              <tbody id="contBody">
              </tbody>
          </table>
          </form>
          <div class="page">
             
          </div>
      </div>
  </div>
  <script type="text/javascript" src="${ctxStatic}/web/reports/contMonitor.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
