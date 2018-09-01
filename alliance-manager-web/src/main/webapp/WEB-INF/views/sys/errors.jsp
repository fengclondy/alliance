<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<!DOCTYPE html>
<html>
  <head>
  	<meta name="decorator" content="default">
  	<%@ include file="/WEB-INF/include/head.jsp"%>
  	<link href="${ctxStatic}/css/error.css" rel="stylesheet"> 
  </head>
  
  <body>
 	<div class="error-box">
            <div class="sorry"></div>
            <div class="error-info">
                抱歉，您没有访问该页面的权限！
            </div>
        </div>
  </body>
</html>
