<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  </head>
  
  <body>
 	<div class="right">
		<div class="bread-crumb">
			<i class="bread-crumb-start"></i> <a href="javascript:;"
				class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
				class="bread-crumb-url">错误提示</a>
		</div>
		
		您的操作触发了一个错误： 错误码<c:out value="${code }" />, 错误信息（<c:out value="${msg }" />）。<br/>
  		<a href="javascript: void(0);" id="back" style="color: red;">(6s) 后自动返回</a>
	</div>
	<script type="text/javascript" src="${ctxStatic}/jquery-timers/jquery.timers-1.1.2.js"></script>
	<script type="text/javascript">
		$(function(){
			var tt = 6;
			$("body").everyTime("1s", function(){
				if(tt > 1){
					$("#back").text("(" + (tt--) + "s) 后自动返回");
				}else{
					$('body').stopTime();
					$("#back").href="javascript: history.go(-1);";
					history.go(-1);
				}
			});
		});
	</script>
  </body>
</html>
