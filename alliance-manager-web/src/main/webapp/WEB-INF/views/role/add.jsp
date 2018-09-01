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
	<link rel="stylesheet" href="${ctxStatic}/zTree_v3/css/zTreeStyle/zTreeStyle.css" type="text/css">
	<script src="${ctxStatic}/selectordie/selectordie.min.js"></script>
	<script type="text/javascript" src="${ctxStatic}/zTree_v3/js/jquery.ztree.core-3.5.js"></script>
    <script type="text/javascript" src="${ctxStatic}/zTree_v3/js/jquery.ztree.excheck-3.5.js"></script>     
  </head>
  
  <body>
   <!-- 右侧内容开始 -->
   <div class="right">
       <div class="bread-crumb">
           <i class="bread-crumb-start"></i>
           <a href="javascript:;" class="bread-crumb-url">您的位置</a> /
           <a href="javascript:;" class="bread-crumb-url">添加角色</a>
       </div>
       <div class='user-add'>
           <div class='form-item'><label>角色名称：</label><input class='input' type='text'></div>
           <div class='form-item'>
               <label>角色类型：</label>
               <div style='width:200px' class='select'>
                   <select class='myselect'>
                       <option value='1'>苏州事业部</option>
                       <option value='2'>苏州事业部2</option>
                   </select>
               </div>
           </div>
           <div class='form-item'>
               <label>所属子系统：</label>
               <div style='width:200px' class='select'>
                   <select class='myselect'>
                       <option value='1'>苏州事业部</option>
                       <option value='2'>苏州事业部2</option>
                   </select>
               </div>
           </div>
           <div class='form-item'>
               <label>角色授权：</label>
               <div class="privilege-list">
                   <div class="zTreeDemoBackground">
                       <ul id="treeDemo" class="ztree"></ul>
                   </div>
               </div>
           </div>
           <div class='form-item'><label>角色描述：</label><input class='input' type='text'></div>
           <div class="btns-group">
	       		<a class="btn" href="javascript:;">保存</a>
	       		<a class="btn cancel" href="javascript:;">返回</a>
	       </div>
        </div>
           
       </div>
   <!-- 右侧内容结束 -->
   <script type="text/javascript">
   $(function(){
		$('select').selectOrDie();
	});
        var setting = {
            check: {
                enable: true
            },
            view: {
                showIcon: false
            },
            data: {
                simpleData: {
                    enable: true
                }
            }
        };

        var zNodes =[
            { id:1, pId:0, name:"系统管理", open:true},
            { id:11, pId:1, name:"用户管理"},
            { id:111, pId:1, name:"角色管理"},
            { id:112, pId:1, name:"权限管理"}
        ];
        
        $(document).ready(function(){
            $.fn.zTree.init($("#treeDemo"), setting, zNodes);
        });
    </script>
</body>
</html>
