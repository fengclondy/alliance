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
	<script src="${ctxStatic}/web/applyTip/tipList.js"></script>
	
  </head>
  
  <body>
   <div class="right">
			<div class="bread-crumb">
				<i class="bread-crumb-start"></i> <a href="javascript:;"
					class="bread-crumb-url">您的位置</a> / <a href="javascript:;"
					class="bread-crumb-url">意向单管理</a>
			</div>
			<div class="search-bar">
			    <input class="input" type="text" placeholder="企业名称" id="s_conpanyName"> 
                <input class="input" type="text" placeholder="联系人姓名" id="s_userName">
                <input class="input" type="text" placeholder="手机号码" id="s_userMobile">
                <div style='width:130px' class='select mr5'>
                <select class="myselect" name="state" id="s_state" value="${state}">
                    <option value="">状态</option>
                    <c:forEach items="${dealStatusList}" var="list">
							<option value='${list.attrCode }'>${list.attrName }</option>
					</c:forEach>
                </select>
            </div>
	            <script type="text/javascript">
	            $('select').selectOrDie();
	            </script>
	            <!-- <a class="search-btn" href="javascript: views(1000010);"></a> -->
				<a class="search-btn" href="javascript: newQuery();"></a>
			</div>
			<table class="table" id="table">
                <thead>
                    <tr>
                        <th class="tdcenter">企业名称</th>
                        <th class="tdcenter">所在地区</th>
                        <th class="tdcenter">预计金额（元）</th>
                        <th class="tdcenter">联系人姓名</th>
                        <th class="tdcenter">联系人手机</th>
                        <th class="tdcenter">申请时间</th>
                        <th class="tdcenter">处理时间</th>
                        <th class="tdcenter">状态</th>
                        <th class="tdcenter">详情</th>
                    </tr>
                </thead>
                <tbody>
                	
                </tbody>
            </table>
            <div class="page"></div>
		</div>
		<script type="text/javascript">
		function views(id){
	window.location.href = "${ctx}/applyTip/applyDetail.html?registId=" + id;
}
</script> 
	<script src="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.js"></script> 
    <link rel="stylesheet" href="${ctxStatic}/jquery-autocomplete/jquery-autocomplete.css">
</body>
</html>
