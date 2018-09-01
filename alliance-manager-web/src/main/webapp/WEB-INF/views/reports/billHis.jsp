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
            <a href="javascript:;" class="bread-crumb-url">历史账单</a>
      </div>
      <div class="search-bar p-r">
        <input type="hidden" id="custId" value="" >
		<input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#custId').val('');">
        <input id="billMonth" name ="billMonth" class="input Wdate" type="text" placeholder="账期" value="${billMonth }" style='width:132px' onClick="WdatePicker({'dateFmt':'yyyyMM'});" readonly="readonly">
        <a class="search-btn" href="javascript: newQuery();"></a>

        <a href="javascript:exportReport(11);" class="btn download-btn"><i class="download-ico"></i>报表1导出</a>
        <a href="javascript:exportReport(12);" class="btn download-btn"><i class="download-ico"></i>报表2导出</a>
        <a href="javascript:exportReport(13);" class="btn download-btn"><i class="download-ico"></i>报表3导出</a>

        <ul class="count-tab clear">
          <li class="on" id="table1">报表一</li>
            |
          <li id="table2" style="width:60px" >报表二</li>
            |
          <li id="table3" style="width:60px" >报表三</li>
        </ul>
      </div>
      <div class="table-tab" id="billHis">
        <table class="table-c">
          <thead>
            <tr>
              <th>月份</th>
              <th>公司名称</th>
              <th>代表号码</th>
              <th>签约单位</th>
              <th>订购省内流量包个数</th>
              <th>订购国内流量包个数</th>
              <th>账期内消费金额(元)</th>
              <th>确认状态</th>
             </tr>
          </thead>
              
          <tbody>
          </tbody>
        </table>
        <div class="page">
             
        </div>
      </div>
      
       <div class="table-tab" style="display:none;" id="costRate">
            <table class="table-c">
              <thead>          
                  <tr>
                  	  <th>月份</th>   
                      <th>地市</th>                      
                      <th>订购量</th>
                      <th>分摊收入(元)</th>                     
                      <th>结算收入(元)</th>
                      <th>本账期最终收入(元)</th>  
                  </tr>
              </thead>
              
              <tbody>
              </tbody>
          </table>
           <%--<div class="page">--%>
           <%--</div>--%>
       </div>
       <div class="table-tab" style="display:none;" id="costGoods">
          <table class="table-c" >
              <thead>          
                  <tr>
                  	  <th>月份</th>   
                      <th>流量包规格</th>                      
                      <th>订购数量(个)</th>
                      <th>消费金额(元)</th>                      
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
              //newQuery();
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
  <%-- <script type="text/javascript" src="${ctxStatic}/web/contract/carryOver.js"></script> --%>
  <script type="text/javascript" src="${ctxStatic}/web/reports/billHis.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
