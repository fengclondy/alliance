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
            <div class="sorry_404"></div>
            <div class="error-info">
                	抱歉，你访问的页面暂时没有数据! 
            </div>
        </div>
</body>
</html>
