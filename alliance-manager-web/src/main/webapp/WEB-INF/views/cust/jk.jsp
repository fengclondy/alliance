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
	
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/localization/messages_cn.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.metadata.js"></script>
	<script src="${ctxStatic}/web/cust/checkList.js"></script>
	<script type="text/javascript">
		var showModify = false;
	</script>
  </head>
  
  <body>
   <div class="right">
		<div class="bread-crumb">
			<i class="bread-crumb-start"></i> <a href="javascript:;"
				class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
				class="bread-crumb-url">开放接口审核</a>
		</div>
		<table class="table">
               <thead>
                   <tr>
                       <th>企业名称</th>
                       <th>绑定IP</th>
                       <th>开放接口</th>
                       <th width="100">操作</th>
                   </tr>
               </thead>
               <tbody>

<!--                		<tr> -->
<!--                			<td>葫芦娃七兄弟</td> -->
<!--                			<td>192.168.0.1</td> -->
<!--                			<td>审核中</td> -->
<!--                			<td><a class="active-btn" href="javascript:jkSh();">审核</a></td> -->
<!--                		</tr> -->
<!--                		<tr> -->
<!--                			<td>葫芦娃七兄弟</td> -->
<!--                			<td>192.168.0.1</td> -->
<!--                			<td><a href="javascript:showPw();" class='active-btn blue '>查看结果</a></td> -->
<!--                			<td><a class="active-btn unable" href="javascript:;">审核</a></td> -->
<!--                		</tr> -->

               </tbody>
           </table>
           <div class="page"></div>
	</div>

    <script type="text/javascript">
//     function showPw(){
//     	layer.open({title:'密码',content:'内容'});
//     }
    
    function jkSh(row,applyId){
    var html = "<div><textarea id='textcontent' class='textarea' style='width:320px;'></textarea></div>";
    	layer.open({
    		  title:"开放接口审核",
    		  btn: ['通过','不通过'] ,//按钮
    		yes:function(){
			  var content = $("#textcontent").val();
    		  auditsuccess(applyId,content);
    		},
    		btn2:function(){
    		  var content1 = $("#textcontent").val();
    		  auditfail(applyId,content1);
    		},
    		  cancel:function(){
    		  
    		},
    		content:html
    });
    }
    </script>
</body>
</html>
