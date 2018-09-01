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
            <a href="javascript:;" class="bread-crumb-url">余额结转</a>
      </div>
      <div class="search-bar p-r">
          <input type="hidden" id="custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#custId').val('');">
          <a class="search-btn" href="javascript: carryOverQuery();"></a>         
          <ul class="count-tab clear">
              <li class="on" id="outtab">结转</li>
              |
              <li id="intab" style="width:60px" >历史结转</li>
          </ul>
      </div>
      <div class="table-tab">
      	<form id="outForm">
          <table id="carryOver" class="table-c">
              <thead>
                  <tr>
                 	  <!-- <th class="check-col"></th> -->
                      <th>客户名称</th>                      
                      <th>原合同号</th>
                      <th>合同余额（元）</th>
                      <th>可结转金额（元）</th>
                      <th>合同状态</th>                      
                      <th>操作</th>    
                  </tr>
              </thead>
              
              <tbody id="carryOverBody">
              </tbody>
          </table>
          </form>
          <div class="page">
             
          </div>
      </div>
      
      <div class="table-tab" style="display:none;">
      <table id="operHis" class="table-c" >
              <thead>          
                  <tr>
                  	  <th>结转记录流水</th>   
                      <th>客户名称</th>                      
                      <th>原合同号</th>
                      <th>目标合同号</th>                     
                      <th>结转金额（元）</th>
                      <th>操作人</th>
                      <th>结转时间</th>    
                  </tr>
              </thead>
              
              <tbody id="operHisBody">
              </tbody>
          </table>
      </div>
  </div>
  
  <div id="jiezhuan" class="contact apply" style="display:none;">
			<div class="apply-header">
				<span class="g12 mr30" id="jz_contId"></span>| <span
					class="f12 mr30" id="jz_custName"></span>
			</div>
			<div class="apply-content">
                <div class="form-item">
                    <label for="">源合同余额：</label><span class="bl" id="pre_balance">0</span>
                    元
                </div>
				<div class="form-item">
					<label for="">目标合同余额：</label><span class="bl" id="jz_balance">0</span>
					元
				</div>
				<div class="form-item">
					<label for="">可结转额度：</label><span class="bl" id="jz_limit">0</span>
					元
				</div>
				<div class="form-item">
					<label for="">本次结转金额：</label>
					<div class="input-box w-zc">
						<input type="hidden" id="jzContId" value=""> <input
							type="text" class="input og" value="" id="jz_val"
							onchange="return checkAmount(this.value)"> 元
					</div>
				</div>
				<div class="form-item">
					<label for="">结转后可用余额：</label><span class="bl" id="jz_amount">0</span>
					元
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
             carryOverQuery();
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
  <script type="text/javascript" src="${ctxStatic}/web/contract/carryOver.js"></script>
  <script type="text/javascript" src="${ctxStatic}/web/contract/coalition.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
