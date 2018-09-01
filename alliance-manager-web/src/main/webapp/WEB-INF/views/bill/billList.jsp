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
          <a href="javascript:;" class="bread-crumb-url">账单查询</a>
      </div>
      <div class="search-bar p-r">
      	  <input type="hidden" id="s_custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#s_custId').val('');">
          <a class="search-btn" href="javascript:costBillQuery();"></a>
      </div>
      <table id="table" class="table">
         <thead>
             <tr>
                 <th>客户名称</th>
                 <th>所属地市</th>
                 <th>入账账期</th>
                 <th>入账金额</th>
                 <th>流量额度</th>
                 <th>入账日期</th>
                 <th>摊分查询</th>
             </tr>
         </thead>
         <tbody id="costBill">
             <!-- <tr>
                 <td>亚信集团（南京）</td>
                 <td>江苏南京</td>
                 <td>2016-9-20</td>
                 <td>100</td>
                 <td>1000G</td>
                 <td>2016-9-20</td>
                 <td><a href="javascript:tf();" class="tf-btn"></a></td>
             </tr>
             <tr>
                 <td>亚信集团（南京）</td>
                 <td>江苏南京</td>
                 <td>2016-9-20</td>
                 <td>100</td>
                 <td>1000G</td>
                 <td>2016-9-20</td>
                 <td><a href="javascript:tf();" class="tf-btn"></a></td>
             </tr> -->
         </tbody>
     </table>
     <div class="page">
         <!-- <ul class="pagination">
             <div class="fl"><input class="num" type="text" value="1">/12</div>
             <li><a href="">上一页</a></li>
             <li class="active"><a href="">1</a></li>
             <li><a href="">2</a></li>
             <li><a href="">3</a></li>
             <li><a href="">4</a></li>
             <li><a href="">39</a></li>
             <li><a href="">下一页</a></li>
             <li><a href="">最后一页</a></li>
         </ul>
         <div style="clear:both;"></div> -->
     </div>
  </div>
  <div id="tf" style="display:none;">
      <div class="tf-content">
          <table class="table" style="width:930px;">
              <thead>
                  <tr>
                      <th>客户名称</th>
                      <th>所属地市</th>
                      <th>入账账期</th>
                      <th>摊分前金额（元）</th>
                      <th>摊分后金额（元）</th>
                      <th>流量额度</th>
                  </tr>
              </thead>
              <tbody id="billItem"></tbody>
          </table>
      </div>
      <div class="bt-line"></div>
  </div>
  <script src="${ctxStatic}/web/bill/costbill.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
