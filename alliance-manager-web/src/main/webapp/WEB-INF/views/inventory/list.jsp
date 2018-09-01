<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
  	<link href="${ctxStatic}/css/notice.css" rel="stylesheet" /> 
	<link rel="stylesheet" href="${ctxStatic}/css/bill.css" />
  	<link rel="stylesheet" href="${ctxStatic}/css/new.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
     <script src="${ctxStatic}/web/data/rec.js"></script>
     <script src="${ctxStatic}/web/data/dataRecDetailList.js"></script>
  </head>
  
  <body>
   <div class="right">
        <div class="bread-crumb">
            <i class="bread-crumb-start"></i>
            <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
            <a href="javascript:;" class="bread-crumb-url">清单管理</a>
        </div>
        <div class="search-bar">
        <input type="hidden" id="s_custId" name="custId" value="" >
		<input id="autocomplete" name="custName" class="input" type="text" placeholder="企业名称" oninput="javascript: $('#s_custId').val('');"> 
		  <input id="s_beginDate" name ="beginDate" class="input Wdate" type="text" placeholder="起始时间" value="" style='width:132px' onClick="WdatePicker();" readonly="readonly">
            <input id="s_endTime" name ="endTime" class="input Wdate" type="text" placeholder="结束时间" value="" style='width:132px' onClick="WdatePicker();" readonly="readonly" >
             <div style='width:132px' class='select mr5'>
                <select class="myselect" name="state" id="s_recharageState" value="${state}">
                    <option value="">充值状态</option>
                    <c:forEach items="${rechangeStateList }" var="list">
							<option value='${list.attrCode }'>${list.attrName }</option>
					</c:forEach>
                </select>
            </div>
            <div style='width:132px' class='select mr5'>
                <select class="myselect" id="s_billState" name="billState" value="${billState}">
                    <option value="">出账状态</option>
                    <c:forEach items="${billStateList}" var="list">
							<option value='${list.attrCode }'>${list.attrName }</option>
					</c:forEach>
                </select>
            </div>
             <a class="search-btn" href="javascript: recQuery();"></a>
             <a href="javascript:exportList();" class="btn download-btn fr"><i class="download-ico"></i>清单导出</a>
        </div>
        <table class="table" id="listRecDetailTab">
            <thead>
                <tr>
                    <th>手机号码</th>
                    <th>流量类型</th>
                    <th>流量规格/M</th>
                    <th>价格/元</th>
                    <th>充值时间</th>
                    <th>充值状态</th>
                    <th>失败原因</th>
                    <th>出账批次</th>
                    <th>入账账期</th> 
                     <!-- <th style="width: 70px;">充值号码</th>
                    <th style="width: 70px;">订购流水</th>
                    <th style="width: 70px;">销售品编号</th>
                    <th style="width: 70px;">销售品名称</th>
                    <th style="width: 70px;">标准价格/元</th>
                    <th style="width: 70px;">充值时间</th>
                    <th style="width: 70px;">客户编号</th>
                    <th style="width: 70px;">客户名称</th>
                    <th style="width: 70px;">销售单位</th>
                    <th style="width: 70px;">充值状态</th>
                    <th style="width: 70px;">产品模式</th>
                    <th style="width: 70px;">归属地市</th> -->
                </tr>
            </thead>
            <tbody>
                
            </tbody>
        </table>
        <div class="footer_page">
		
		</div>
		
    </div>
   
    <div id="erro_date" class="contact apply mg20" style="display:none;" >
    
      
	</div>
	 
    <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
