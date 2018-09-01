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
          <a href="javascript:;" class="bread-crumb-url">出入账管理</a>
      </div>
      <div class="search-bar p-r">
          <input type="hidden" id="custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#custId').val('');">
          <a class="search-btn" href="javascript: billQuery();"></a>
          <ul class="count-tab clear">
              <li class="on" id="outtab">未入账</li>
              |
              <li id="intab">已入账</li>
          </ul>
      </div>
      <div class="table-tab">
      	<form id="outForm">
          <table id="outTable" class="table">
              <thead>
                  <tr>
                     <th class="check-col"></th>
                      <th>客户名称</th>
                      <th>合同号</th>
                      <th>出账批次</th>
                      <th>出账金额（元）</th>
                       <th>累计已入账(元)</th>
                      <th>分销总流量</th>
                      <th>出账日期</th>
                      <th>确认时间</th>
                  </tr>
              </thead>
              
              <tbody id="outBody">
              </tbody>
              
              <tfoot id="outFoot">
                  <tr>
                      <td class="check-col">
                          <a href="javascript:;" class="checkbox all"></a>
                          <span class="ck-a">全选</span>
                      </td>
                      <td colspan="6">
                          <div class="ta-c"><a href="javascript:inCostBill();" class="btn w90">入账</a></div>
                      </td>
                  </tr>
              </tfoot>
          </table>
          </form>
          <div class="page">
             <!--  <ul class="pagination">
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
      <div class="table-tab" style="display:none;">
          <table id="inTable" class="table">
              <thead>
                  <tr>
                      <th style="width: 150px;">客户名称</th>
                      <th>合同号</th>
                      <th>出账批次</th>
                      <th>出账金额（元）</th>
                      <th>累计已入账(元)</th>
                      <th>分销总流量</th>
                      <th>出账日期</th>
                      <th>确认时间</th>
                      <th>入账账期</th>
                      <th>入账日期</th>
                  </tr>
              </thead>
              <tbody id="inBody">
                  <!-- <tr>
                      <td>亚信集团（南京）</td>
                      <td>A001</td>
                      <td>100</td>
                      <td>1000G</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
                  </tr>
                  <tr>
                      <td>亚信集团（南京）</td>
                      <td>A001</td>
                      <td>100</td>
                      <td>1000G</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
                      <td>2016-9-20</td>
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
  </div>
  <script type="text/javascript">
      $(function(){
          //tab切换事件
          $(".count-tab>li").click(function(){
              $(this).addClass('on').siblings().removeClass('on');
              $(".table>tbody").empty();
              $(".table-tab").eq($(this).index()).show().siblings('.table-tab').hide();
              billQuery();
          })

          $(".checkbox.all").click(function(){
              if($(this).hasClass('on')){
                  $(".checkbox").removeClass('on');
                  $("[name='billId']").removeAttr("checked");//取消全选     
              }else{
                  $(".checkbox").addClass('on');
                  $("[name='billId']").attr("checked",'true');//全选
              }
          }) 
          
      })
  </script>
  <script src="${ctxStatic}/web/bill/bill.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
