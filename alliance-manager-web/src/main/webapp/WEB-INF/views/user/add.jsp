<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<link rel="stylesheet" href="${ctxStatic}/css/user.css">
  	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie.css">
	<link rel="stylesheet" href="${ctxStatic}/selectordie/selectordie_theme_01.css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
	
  </head>
  
  <body>
   <!-- 右侧内容开始 -->
   <div class="right">
       <div class="bread-crumb">
           <i class="bread-crumb-start"></i>
           <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
           <a href="javascript:;" class="bread-crumb-url">系统管理</a>
       </div>
       <div class='user-add'>
           <div class='form-item'>
	           <label>所属地区：</label>
	           <div style='width:200px' class='select'>
	               <select class='myselect'>
	                   <option value='1'>苏州事业部</option>
	                   <option value='2'>苏州事业部2</option>
	               </select>
	           </div>
	       </div>
	       <div class='form-item'><label>联系人姓名：</label><input class='input' type='text'></div>
	       <div class='form-item'><label>登录名：</label><input class='input' type='text'></div>
	       <div class='form-item'>
	           <label>分配角色：</label>
	           <div class="roles-container">
	               <div class="role-assigned">
	                   <ul id="select1"></ul>
	               </div>
	               <div class="role-opr">
	                   <div class="arrow-btn-group">
	                       <a id="add" href="javascript:;" class="btn arrow-btn arrow-left">&lt;</a>
	                       <a id="add_all" href="javascript:;" class="btn arrow-btn arrow-left-all">&lt;&lt;</a>
	                       <a id="remove_all" href="javascript:;" class="btn arrow-btn arrow-right-all">&gt;&gt;</a>
	                       <a id="remove" href="javascript:;" class="btn arrow-btn arrow-right">&gt;</a>
	                   </div>
	               </div>
	               <div class="role-assigned">
	                   <ul id="select2">
	                       <li>系统管理员</li>
	                       <li>市管理员</li>
	                       <li>合作伙伴</li>
	                   </ul>
	               </div>
	           </div>
	       </div>
	       <div class='form-item'><label>手机号码：</label><input class='input' type='text'></div>
	       <div class='form-item'><label>邮箱地址：</label><input class='input' type='text'></div>
	       <div class='form-item'><label>固定电话：</label><input class='input' type='text'></div>
	       <div class="btns-group">
	       		<a class="btn" href="javascript:;">保存</a>
	       		<a class="btn cancel" href="javascript:;">返回</a>
	       </div>
       </div>
       
   </div>
   <!-- 右侧内容结束 -->
<script type="text/javascript" src="${ctxStatic}/web/user.js"></script>
</body>
</html>
