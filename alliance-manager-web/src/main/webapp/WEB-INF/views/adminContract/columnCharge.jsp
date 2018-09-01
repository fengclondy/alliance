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
          <a href="javascript:;" class="bread-crumb-url">合同列收</a>
      </div>
      <div class="search-bar p-r">
          <input type="hidden" id="custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#custId').val('');">
          <a class="search-btn" href="javascript: columnChargeQuery();"></a>
          <ul class="count-tab clear">
              <li class="on" id="waittab">待列收</li>
              |
              <li id="histab">列收记录</li>
          </ul>
      </div>
      <div class="table-tab" id="waitTable">
          <table class="table">
              <thead>
                  <tr>
                      <th class="check-col"></th>
                      <th>客户名称</th>
                      <th>合同号</th>
                      <th>剩余金额（元）</th>
                      <th>合同状态</th>
                      <th>到期时间</th>
                  </tr>
              </thead>
              
              <tbody>
              </tbody>
              
              <tfoot id="waitFoot">
                  <tr>
                      <td class="check-col">
                          <a href="javascript:;" class="checkbox all"></a>
                          <span class="ck-a">全选</span>
                      </td>
                      <td colspan="6">
                          <div class="ta-c"><a href="javascript:columnCharge();" class="btn w90">列收</a></div>
                      </td>
                  </tr>
              </tfoot>
          </table>
          <div class="page">
            
          </div>
      </div>
      <div class="table-tab" id="hisTable" style="display:none;">
          <table class="table">
              <thead>
                  <tr>
                      <th>客户名称</th>
                      <th>合同号</th>
                      <th>列收金额（元）</th>
                      <th>列收时间</th>
                      <th>合同到期时间</th>
                      <th>列收工号</th>
                  </tr>
              </thead>
              <tbody>
              </tbody>
          </table>
          <div class="page">
          </div>
      </div>
  </div>
  <script type="text/javascript">
      $(function(){
          //tab切换事件
          $(".count-tab>li").click(function(){
              $(this).addClass('on').siblings().removeClass('on');
              $(".table>tbody").empty();
              $(".table-tab").eq($(this).index()).show().siblings('.table-tab').hide();
              columnChargeQuery();
          })

          $(".checkbox.all").click(function(){
              if($(this).hasClass('on')){
                  $(".checkbox").removeClass('on');
                  $("[name='contId']").removeAttr("checked");//取消全选     
              }else{
                  $(".checkbox").addClass('on');
                  $("[name='contId']").attr("checked",'true');//全选
              }
          }) 
          
      })
  </script>
  <script src="${ctxStatic}/web/contract/columnCharge.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
