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
            <a href="javascript:;" class="bread-crumb-url">订单监控</a>
      </div>
      <div class="search-bar p-r">
          <%--<a href="javascript:exportReport(41);" class="btn download-btn"><i class="download-ico"></i>报表导出</a>--%>
      </div>
      <div class="table-tab">
          <table class="table-c">
              <thead>
                  <tr>
                      <th>CRM返回编码</th>
                      <c:forEach items="${title}" var="title">
                          <th>${title}</th>
                      </c:forEach>
                  </tr>
              </thead>
              <tbody>
              <c:forEach items="${model}" var="map">
                  <tr>
                      <td>${map.key}</td>
                      <c:forEach items="${map.value}" var="list">
                      <td>${list.failNum}</td>
                      </c:forEach>
                  </tr>
              </c:forEach>
              </tbody>
          </table>
          <c:if test="${model== null || fn:length(model) == 0}">
              <div id='noData' class='no-data'><p>未查到任何相关信息！</p></div>
          </c:if>
      </div>
  </div>
  <script type="text/javascript">
      function exportReport(ii) {
          window.location.href = ctx + "/reports/exportReports.html?index=" + ii + "&custId=" + obj.custId + "&custName=" + obj.custName;
      }
  </script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
