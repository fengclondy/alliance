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
<!-- 	<script type="text/javascript" src="${ctxStatic}/web/goods/list.js"></script> -->
	<script type="text/javascript" src="${ctxStatic}/web/goods/newList.js"></script>
		<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/localization/messages_cn.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.metadata.js"></script>
	<script type="text/javascript">var roleType = ${roleType}</script>
  </head>
  
  <body>
   <div class="right">
        <div class="bread-crumb">
            <i class="bread-crumb-start"></i>
            <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
            <a href="javascript:;" class="bread-crumb-url">商品管理</a>
        </div>
        <div class="search-bar bb text-center bb-n">
        	<span class="tt">商品列表</span>
        	<c:if test="${roleType eq 100 }">
			<div class="btn-group clear">
				<a class="edit-btn btn-goods" href="javascript:add();" title="新增商品"></a>
			</div>
			</c:if>
        </div>
        <table class="table g-table">
        	<thead>
            <tr>
                <th>商品编号</th>
                <th>流量类型</th>
                <th>商品类型</th>
                <th>商品规格</th>
                <th>商品价格/元</th>
                <th>状态</th>
                <th>消费品ID</th>
                <c:if test="${roleType eq 100 }">
                <th>操作</th>
                </c:if>
            </tr>
        </thead>
            <tbody>
            </tbody>
        </table>
        <div class="page"></div>
    </div>
    <div id="goods" style="display:none;">
    	<div class='user-add'>
        	<form id="goods_form">
            <div class='form-item'>
            	<label>商品编号：</label>
            		<input id="showId"  class='input large'  disabled="disabled" class='input' type='text' />
            		<input id="goodsId" type="hidden" name="goodsId" />
            </div>
            <div class='form-item'>
	            <label>流量类型：</label>
	            <div  style='width:300px' class='select mr5'>
	            	<select id="dataType" name="dataType" class='myselect'>
						<c:forEach items="${dataTypeList }" var="item">
		            	<option value="${item.attrCode }">${item.attrName }</option>
		             	</c:forEach>
	               </select>
	           </div>
	        </div>
	        <div class='form-item'>
	            <label>商品类型：</label>
	            <div  style='width:300px' class='select mr5'>
	               <select id="goodsType" name="goodsType" class='myselect'>
		               <c:forEach items="${goodsTypeList }" var="item">
		               <option value="${item.attrCode }">${item.attrName }</option>
		               </c:forEach>
	               </select>
	           </div>
	           <div class='form-item'>
	            <label>商品状态：</label>
	            <div  style='width:300px' class='select mr5'>
	               <select id="state" name="state" class='myselect'>
		               <c:forEach items="${goodsStateList }" var="item">
		               <option value="${item.attrCode }">${item.attrName }</option>
		               </c:forEach>
	               </select>
	           </div>
	        </div>
<!-- 	        <div class='form-item'> -->
<!-- 	            <label>商品名称：</label> -->
<!-- 	            <div class="input-box gd"> -->
<!--                     <input id="goodsName" name="goodsName" type="text" class="input"> -->
<!--                 </div> -->
<!-- 	        </div> -->
	        <div class='form-item'>
	            <label>商品型号：</label>
	            <div class="input-box gd">
                    <input id="goodsModel"  name="goodsModel" type="text" class="input">
                </div>
	        </div>
	         <div class='form-item'>
	            <label>商品规格：</label>
	            <div class="input-box gd mix">
                    <input id="goodsSpecs" name="goodsSpecs" type="text" class="input">
                    M
                </div>
	        </div>
	        <div class='form-item'>
	            <label>销售价格：</label>
	            <div class="input-box gd mix">
                    <input id="goodsPrice" name="goodsPrice" type="text" class="input">
                                                 元
                </div>
	        </div>
	        <div class='form-item'>
	            <label>销售品ID：</label>
	            <input id="billOfferId" name="billOfferId" class='input large' type='text' placeholder="CRM销售品ID">
<!-- 	        	<div id="error" style="color:red;margin: 5px 0 0 115px;font-weight: bold;"></div> -->
	        </div>
            </form>
        </div>
    </div>
    </div>
</body>
</html>
