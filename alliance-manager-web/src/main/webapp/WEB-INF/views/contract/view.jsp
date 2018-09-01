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
	
<script type="text/javascript"> </script>
  </head>
  
  <body >
   <div class="right c2">
       <div class="bread-crumb">
           <i class="bread-crumb-start"></i>
           <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
           <a href="javascript:;" class="bread-crumb-url">合同管理</a> /
           <a href="javascript:;" class="bread-crumb-url">合同详情</a>
       </div>
       <div class="search-bar bb clearfix ta-center">
           <a href="javascript:history.go(-1);" class="back-btn fl"><i class="back-ico"></i>返回</a>
           合同详情<span class="f12">（${contractVo.subStateName}）</span>
           <c:if test="${not empty contractVo.contCopy}">
           <a href="javascript: viewCont('${contractVo.contId}')" class="download-contract fr"><i class="contract-ico"></i>合同下载</a>
       </c:if>
       </div>
       <div class="table-list">
           <div class="table-desc">
               <span class="g12 mr30">合同编码：${contractVo.contId}</span>|
               <span class="g12 mr30">合同号：${contractVo.contNo}</span>|
               <c:if test="${contractVo.subState eq 100}">
               <span class="g12 mr30">摊分比例：${contractVo.repartition}%</span>|
               </c:if>
               <span class="f12 mr30"> ${contractVo.custName}</span>
               
               <div class="fr mr30">
                   <span class="gray f12">订购时间：${contractVo.createDateStr}</span>
               </div>
           </div>
           <table class="table-c" id="tb">
               <thead>
                   <tr>
                       <th>流量类型</th>
                       <th>流量规格</th>
                       <th>价格/元</th>
                       <th>折扣/%</th>
                       <th>金额/万元</th>
                       <th>余额/元</th>
                       <th>合同有效期至</th>
                       <th>状态</th>
                   </tr>
                </thead>   
                   <tbody>
					<c:forEach items="${contractItemOne}" var="list">
                       <tr>
					   
					   

						 <td class="hebing0">国内流量</td>
                       
                           <td>${list.goodsModel}</td>
                           <td>
						     <fmt:formatNumber type="number" value="${list.unitPrice/1000}" maxFractionDigits="11"/>
					       </td>
                           <td class="hebing">${list.offRate}</td>
                        
                 
                           <td class="hebing1">
                               <div class="am">合同金额：<span class="og">
							   <fmt:formatNumber type="number" value="${contractVo.contValue/10000000}" maxFractionDigits="11"/>
							   </span></div>
                               <div class="am">预付款：<span class="og">
							   
							   <fmt:formatNumber type="number" value="${contractVo.payment/10000000}" maxFractionDigits="11"/>
							   
							   </span></div>
                               <div class="am">保证金：<span class="og">
							   
							   <fmt:formatNumber type="number" value="${contractVo.deposit/10000000}" maxFractionDigits="11"/>
							   
							   </span></div>
                           </td>
                           <td class="hebing2">
                               <div class="am">可用余额：<span class="og">
							   <fmt:formatNumber type="number" value="${contractVo.balance/1000}" maxFractionDigits="11"/>
							   </span></div>
                               <div class="am">保证金金额：<span class="og">
							   
							   <fmt:formatNumber type="number" value="${contractVo.useDeposit/1000}" maxFractionDigits="11"/></span></div>
                           		<c:if test="${contractVo.bookCredit>0}">
                           		<div class="am">透支金额：<span class="og">
							   
							   <fmt:formatNumber type="number" value="${contractVo.bookCredit/1000}" maxFractionDigits="11"/>
							   </span></div>
							   </c:if>
                           </td>
                           <td class="hebing3"><fmt:formatDate value="${contractVo.expDate}" pattern="yyyy-MM-dd"/>
                           </td>
						   <td class="hebing4">${contractVo.subStateName}</td>
                         
                       </tr>
					</c:forEach>
					
					
					<input type="hidden" id="row" value="${contractVo.contractItems.size()}" />
					<c:forEach items="${contractItemTwo}" var="list">
					<tr>
					 
					  <td class="hebing5">省内流量</td> 
					   <td>${list.goodsModel}</td>
                      <td>
						 <fmt:formatNumber type="number" value="${list.unitPrice/1000}" maxFractionDigits="11"/>
					  </td>
                       <td class="hebing6">${list.offRate}</td>
					</tr>
				    </c:forEach>
                   </tbody>
              
           </table>
           <div class="record-list">
                <div class="record-header">缴费记录<a href="javascript:;" class="jiantou-up"></a></div>
                <c:forEach  items="${paymentList}" var="item" >
                <div class="record-data">
                    <div class="data-padding-left"></div>
                    <div class="data1">支付流水号：${item.paymentId}</div>
                    <div class="data2">
                        <c:if test="${not empty item.payDate}">
                            <fmt:formatDate value="${item.payDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>
                        <c:if test="${empty item.payDate}">
                            <fmt:formatDate value="${item.applyDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
                        </c:if>
                    </div>
                    <div class="data3">
                        支付状态：
                        <c:choose>
                            <c:when test="${item.payState eq 200}">
                                <span class="og">支付待确认</span>
                            </c:when>
                            <c:when test="${item.payState eq 300}">
                                <span class="og">支付成功</span>
                            </c:when>
                            <c:when test="${item.payState eq 500}">
                                <span class="og">支付失败</span>
                            </c:when>
                            <c:when test="${item.payState eq 600}">
                                <span class="og">转出成功</span>
                            </c:when>
                            <c:when test="${item.payState eq 700}">
                                <span class="og">转入成功</span>
                            </c:when>
                            <c:otherwise>
                                <span class="og">支付待确认</span>
                            </c:otherwise>
                        </c:choose>
					</div>
                    <div class="data4">
                        <span class="data4-1">缴费金额：</span>
                        <span class="data4-2 og">
                            <c:if test="${item.amount >= 10000000}">
                                <fmt:formatNumber type="number" value="${item.amount/10000000}" maxFractionDigits="11"/>万元
                            </c:if>
                            <c:if test="${item.amount < 10000000}">
                                <fmt:formatNumber type="number" value="${item.amount/1000}" maxFractionDigits="11"/>元
                            </c:if>
                        </span>
                    </div>
                    <div class="data5">
                        <a class="blue-btn" href="javascript: viewPay('${item.paymentId}')">缴费凭证</a>
                    </div>
                    <div class="data-padding-right"></div>
                </div>
                </c:forEach>
           </div>

           <div class="record-list">
               <div class="record-header">保证金转存记录<a href="javascript:;" class="jiantou-up"></a></div>
                <c:forEach  items="${contbookRecordList}" var="item" >
               <div class="record-data">
                   <span class="data1 mr30">支付流水号：${item.id}</span>
                   <span class="data2 mr30">
                    <fmt:formatDate value="${item.operDate}" pattern="yyyy-MM-dd HH:mm:ss"/>
				   </span>
                   <div class="data-right">
                       <div class="data3 mr30">转存金额：<span class="og">
                       <fmt:formatNumber type="number" value="${0-item.operAmount/10000000}" maxFractionDigits="11"/>
                       万</span></div>
               </div>
               </div>

               </c:forEach>
           </div>
       </div>
   </div>
   <script type="text/javascript">
       $(function(){
           $(".jiantou-up").click(function(){
               var that = $(this);
               if(that.hasClass('down')){
                   $(this).parents(".record-list").find('.record-data').show();
                   $(this).removeClass('down');
               }else{
                   $(this).parents(".record-list").find('.record-data').hide();
                   $(this).addClass('down');
               }
           })
       })
   </script>
   <script type="text/javascript" src="${ctxStatic}/web/contract/coalition.js"></script>
   <script type="text/javascript" src="${ctxStatic}/web/contract/view.js"></script>
</body>
</html>
