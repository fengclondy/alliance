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
	<script type="text/javascript" src="${ctxStatic}/web/goods/list.js"></script>
	
  </head>
  
  <body>
   <div class="right">
        <div class="bread-crumb">
            <i class="bread-crumb-start"></i>
            <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
            <a href="javascript:;" class="bread-crumb-url">商品管理</a>
        </div>
        <div class="search-bar bb">
			<div class="btn-group clear">
				<a class="edit-btn btn-add" href="javascript:add();" title="新增商品"></a>
			</div>
        </div>
        <table class="table g-table">
        	<thead>
            <tr>
                <th>商品编号</th>
                <th>商品类型</th>
                <th>商品规格</th>
                <th>商品价格/元</th>
                <th>状态</th>
                <th>消费品ID</th>
            </tr>
        </thead>
            <tbody>
            </tbody>
        </table>
        <div class="page"></div>
    </div>
</body>
</html>
