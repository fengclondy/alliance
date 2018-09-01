<meta http-equiv="X-UA-Compatible" content="IE=Edge">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
  	<link rel="stylesheet" href="${ctxStatic}/css/new.css">
  	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
  </head>
<style>
  #file0 {
opacity: 0;
position: absolute;
z-index: 10;
}
  </style>
  <body>
   <div class="right">
      <div class="bread-crumb">
          <i class="bread-crumb-start"></i>
          <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
          <a href="javascript:;" class="bread-crumb-url">合同管理</a>
      </div>
      <div class="search-bar bb">
      	  <input type="hidden" id="s_custId" value="" >
		  <input id="autocomplete" class="input w230" type="text" placeholder="企业名称" oninput="javascript: $('#s_custId').val('');">
          <input class="input w130" type="text" placeholder="合同编号" id="s_contId">
          <a class="search-btn" href="javascript:newQuery();"></a>
          <div class="btn-group clear">
              <a class="edit-btn btn-entry" href="javascript:add();" title="录入合同"></a>
          </div>
      </div>
      <div id="tableList">
      
       </div>
       <div class="page" >
            
            <div style="clear:both;"></div> 
        </div>
  </div>
  <div id="addContract" class="contact" style="display:none;">
  	<form id="addForm" >
      <div class="form-item">
          <label for="">选择客户：</label>
          <div style='width:300px' class='select mr5'>
              <select id="custId" class="myselect" name="custId" onchange="javascript:getCustType(this.value);">
              		 <option value="">选择客户</option>
              		<c:forEach items="${custList }" var="item">
              			<option value="${item.custId}" id="${item.ext3}">${item.custName }</option>
              		</c:forEach>
              </select>
          </div>
          <label for="">合同金额：</label>
          <div class="input-box" tabindex="0">
              <input type="text" class="input"  name="contValue" style="text-align: right;" oninput="return contValueCheck(this.value)">
              元
          </div>
      </div>
      <div class="form-item">
          <label for="">预存款金额：</label>
          <div class="input-box" tabindex="0">
              <input type="text" class="input" name="payment" style="text-align: right;" oninput="return paymentCheck(this.value)">
              元
          </div>
          <label for="">保证金金额：</label>
          <div class="input-box" tabindex="0">
              <input type="text" class="input" name="deposit" style="text-align: right;" oninput="return depositCheck(this.value)">
              元
          </div>
      </div>
      
      <div class="form-item mt20" id="pro">
      	<label for="">${proGoodsName }：</label>
          <ul class="clearfix prod-ul">
              <%-- <li class="gg-label">${proGoodsName }：</li> --%>
              <c:forEach items="${proGoods }" var="item">
	              <li class="gg-data active">
	                  <i class="data-ico"></i>
	                  <input type="hidden" name="goodsId" value="${item.goodsId }">
	                  <div class="data-top">${item.goodsModel }</div>
	                  <div class="data-bottom">单价：<span class="span_data">${item.goodsPrice/1000 }元</span></div>
	              </li>
              </c:forEach>
          </ul>
      </div>
      <div class="form-item" id="pub">
      <label for="">${pubGoodsName }：</label>
          <ul class="clearfix prod-ul">
          	<%-- <li class="gg-label">${pubGoodsName }：</li> --%>
              <c:forEach items="${pubGoods }" var="item">
	              <li class="gg-data active">
	                  <i class="data-ico"></i>
	                  <input type="hidden" name="goodsId" value="${item.goodsId }">
	                  <div class="data-top">${item.goodsModel }</div>
	                  <div class="data-bottom">单价：<span class="span_data">${item.goodsPrice/1000 }元</span></div>
	              </li>
              </c:forEach>
          </ul>
      </div>
      <div class="fenge">
          <div class="line"></div>
          <div class="fenge-title">分销折扣:60%代表价格的6折</div>
      </div> 
      <div class="form-item">
          <label for="">省内流量折扣：</label>
          <div class="input-box" tabindex="0">
              <input type="text" class="input" name="proOffRate" style="text-align: right;" oninput="return proOffRateCheck(this.value)">
              %
          </div>
          <label for="">国内流量折扣：</label>
          <div class="input-box" tabindex="0">
              <input type="text" class="input" name="pubOffRate" style="text-align: right;" oninput="return pubOffRateCheck(this.value)">
              %
          </div>
      </div>
      <div class="form-item">
		  <label for="">合同号：</label> 
		   <input type="text" class="input" name="contNo" style="text-align: right;" oninput="return contNoCheck(this.value)">
		   <input id="contNo"  disabled="true" type="text" class="input" style="text-align: right; display:none" readonly="true" >
          <label for="">合同有效期：</label> 
          <div class="input-box" tabindex="0">
              <input type="text" class="input" name="contEffDate" style="text-align: right;" oninput="return contEffDateCheck(this.value)">
              月
          </div>
      </div>
      <div class="form-item" id="upload">
          <label for="">上传合同副本：</label>
          <input type="file" id="contFile" name="contFile" style="display:none;" >
          <input type="text" class="input" style="width:234px;" id="file">
          <input type="hidden" name="contCopy" id="contCopy" >
          <a href="javascript: uploadContFile();" class="desc-btn fs13">浏览</a>
      </div>
      </form>
  </div>
  <!-- 合同激活申请弹窗 start-->
  <div id="activeApply" class="contact apply" style="display:none;">
  <form id="activateForm">
      <div class="apply-header">
          <span class="g12 mr30" id="contNo_ac"></span>|
          <span class="f12 mr30" id="custName_ac"></span>
      </div>
      <div class="apply-content">
          <div class="form-item mb20">
              <label for="">缴费：</label>
              <div class="input-box w-jf">
              <input type="text" name ="payCert" class="input og" value="" id="ipayedFee" onpropertychange="return activateAmount(this.value)" oninput="return activateAmount(this.value)">
                  <!-- <input id="ipayedFee" type="text" class="input og" name ="payCert" value=""> -->
                  元
              </div>
          </div>
          <div class="form-item mb20">
              <label for="">保证金：</label>
              <span class="bl" id="deposit_ac" ></span>元
			  <input type="hidden" id="hidpayedFee" name = "payedFee" value="" />
              <div class="fr mr5">
                  <label for="" >缴费后余额：</label>
                  <span class="bl" id="useFee"></span>元
              </div>
          </div>
          <div class="form-item mb20 ta-c">
             <input type="file" id="payConfirm" name="payConfirm" style="display:none"/> 
			 <span id="uFileName"></span>
			 <input type="hidden" id="hidFileName" name = "payCert2" value="" />
              <a  id="tips0" class="upload-pz" href="javascript:void(0)" onclick="javascript:start();">上传凭证</a>
          </div>
          <div class="form-item mb20 ta-c">
              <div class="photo-box" id="photoImage">
              </div>
          </div>
      </div>
      <div id="error" style="color:red;margin: 5px 0 0 115px;font-weight: bold;"></div>
      </form>
  </div>
  <!-- 合同激活申请弹窗 end-->
  <!-- 续费弹窗start -->
  <div id="renewalView" class="contact apply" style="display:none;">
  <form id="renewalForm">
      <div class="apply-header">
          <span class="g12 mr30" id="contNo_re"></span>|
          <span class="f12 mr30" id="custName_re"></span>
      </div>
      <div class="apply-content">
          <div class="form-item mb20">
              <label for="">缴费：</label>
              <div class="input-box w-jf">
              <input type="text" name ="payCert_re" class="input og" value="" id="ipayedFee_re" onpropertychange="return renewalAmount(this.value)" oninput="return renewalAmount(this.value)">
                  <!-- <input id="ipayedFee_re" type="text" class="input og" name ="payCert_re" value=""> -->
                  元
              </div>
          </div>
          <div class="form-item mb20">
              <label for="">当前余额：</label>
              <span class="bl" id="deposit_re" ></span>元
			  <input type="hidden" id="hidpayedFee_re" name = "payedFee_re2" value="" />
              <div class="fr mr5">
                  <label for="" >缴费后余额：</label>
                  <span class="bl" id="balance_re"></span>元
              </div>
          </div>
          <div class="form-item mb20 ta-c">
              
              <input type="file" id="uFile_re" name="uFile_re"  style="display:none"/> 
			 <input type="hidden" id="hidFileName_re" name = "payCert_re" value="" />
			  <span id="uFileName_re"></span>
              <a id="tips1"class="upload-pz" href="javascript:void(0)" onclick="javascript:restart();">上传凭证</a>
          </div>
          <div class="form-item mb20 ta-c">
              <div class="photo-box" id="photoImage_re">
              </div>
          </div>
      </div>
      <div id="error_re" style="color:red;margin: 5px 0 0 115px;font-weight: bold;"></div>
     </form>
  </div>
  <!-- 续费弹窗end -->
  <script src="${ctxStatic }/web/contract/add.js"></script>
  <script src="${ctxStatic }/web/contract/applyContract.js"></script>
  <script src="${ctxStatic }/web/contract/renewalApply.js"></script>
  <script src="${ctxStatic }/web/contract/list.js"></script>
  <script type="text/javascript" src="${ctxStatic}/jquery-upload/ajaxfileupload.js"></script>
  <script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
  <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
  <script src="${ctxStatic }/jquery/jquery-formatMoney.js"></script>
</body>
</html>
