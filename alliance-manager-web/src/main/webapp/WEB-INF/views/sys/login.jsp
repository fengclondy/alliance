<meta http-equiv="X-UA-Compatible" content="IE=edge">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ include file="/WEB-INF/include/taglib.jsp"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML>
<html>
  <head>
    <base href="<%=basePath%>">
    <title>登录</title>
    <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.12.0.min.js"></script>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<link rel="stylesheet" type="text/css" href="${ctxStatic}/css/login.css">
	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
	<link href="${ctxStatic}/pace/pace.css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic}/pace/pace.js"></script>
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
  </head>
  
 <body>
  	<div class="banner"></div>
  	<div class="login-pannel">
  		<form id="loginForm" name="loginForm" method="post" action="${ctx}/login/login.html">
  			<div class=""><span class="errors" id="errors">${result.msg}</span></div>
	  		<div class="login-iterm">
	  			<div class="login-label"><i class="login-ico i1"></i></div>
	  			<input id="name" name="username" class="login-input input required" type="text" placeholder="请输入您的用户名" value="${username }" />
	  		</div>
	  		<div class="login-iterm">
	  			<div class="login-label"><i class="login-ico i2"></i></div>
	  			<input id="password" name="password" class="login-input input required" type="password" placeholder="请输入您的密码"  value="${password }" /> 
	  		</div>
	  		
	  		<div class="login-code clearfix">
	  			<input class="code-input input required" name="validateCode" type="text" placeholder="请输入验证码">
	  			<img id="img" src="" class="fl" style="margin:0 0 0 10px;" onclick="changeValidateCode(this)"/>
	  			<div class="refresh fl"><a class="refresh-code" href="javascript:changeValidateCode(document.getElementById('img'))">换一张</a></div>
	  			<%-- <c:choose>
                   	<c:when test="${codeType eq '0'}">
						<img id="img" src="" class="fl" style="margin:0 0 0 10px;" onclick="changeValidateCode(this)"/>
	  					<div class="refresh fl"><a class="refresh-code" href="javascript:changeValidateCode(document.getElementById('img'))">换一张</a></div>
					</c:when>
					<c:otherwise>
						<input type="button" id="codeBtn" value="发送验证码" class="btn" style="width: 150px; margin-left: 22px;"/>
					</c:otherwise>
              	</c:choose> --%>
	  			
	  		</div>
	  		
	  		<div class="btn-group clearfix">
	  			<!-- <a id="submit" href="javascript:$('#loginForm').submit();" class="btn btn-submit fl">登录</a> -->
	  			<input id="submitBtn" type="submit"  class="btn btn-submit fl" value="登录">
	  			<a id="reset" class="btn btn-refresh fr">重置</a>
	  		</div>
	  		<!-- <div class="btn-group clearfix tc">
	  			<a class="find-pwd" href="javascript:showUpdatePassWord();">忘记密码？</a>
	  		</div> -->
  		</form>
  	</div>
  	
  	<!--忘记密码-->
	<!--  <div class="login-pannel" id="showChangePassWord">
		<table border="0">
			<tr style="height: 15px">
				<td colspan="2" style="text-align:center;color: red" id="message"></td>
			</tr>
		</table>
	
		<div class="login-iterm" style="margin-left: auto;margin-right: auto;">
	  			<div class="login-label"></div>
	  			<input id="c_username" name="c_username" class="login-input input required" type="text" placeholder="请输入您的用户名" />
	  	</div>
	  	<div class="login-code clearfix">
	  			<input class="code-input input required" id= "smscode" name="validateCode" type="text" placeholder="请输入验证码" />
	  			<input type="button" id="codeBtn" value="发送验证码" onclick="getSmsCode()" class="btn" style="width: 150px; margin-left: 22px;"/>
	  	</div>
	  	<div class="login-iterm" style="margin-left: auto;margin-right: auto;">
	  			<div class="login-label"></div>
	  			<input id="c_newpassword" name="c_newpassword" class="login-input input required" type="password" placeholder="请输入您的新密码" />
	  	</div>
	  	<div class="login-iterm" style="margin-left: auto;margin-right: auto;">
	  			<div class="login-label"></div>
	  			<input id="c_newpassword_2" name="c_newpassword_2" class="login-input input required" type="password" placeholder="请再次输入您的新密码" />
	  	</div>
	  
	  	<div class="btn-group clearfix">
	  			<input type="button" class="btn btn-submit fl" onclick="changePassWord()" value="确定" />
	  			<a id="passsubmit" class="btn btn-submit fl" href="javascript:changePassWord();">确定</a>
	  			<a id="reset" class="btn btn-refresh fr" href="javascript:closeUpdatePassWord();">取消</a>
	  	</div>
	</div> --> 
	<!--忘记密码-->
  		<script type="text/javascript">
	  	function changeValidateCode(obj) {   
	  		//获取当前的时间作为参数，无具体意义     
	  	    var timenow = new Date().getTime();     
	  	       //每次请求需要一个不同的参数，否则可能会返回同样的验证码     
	  	    //这和浏览器的缓存机制有关系，也可以把页面设置为不缓存，这样就不用这个参数了。
	  	     obj.src=ctx + "/login/validCode.html?d="+timenow;
	  	}
	  	$("#img").click();
	  	</script>
   	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.validate.js"></script>
   	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/localization/messages_cn.js"></script>
   	<script type="text/javascript" src="${ctxStatic}/jquery-validation/1.14.0/dist/jquery.metadata.js"></script>
   	<script type="text/javascript" src="${ctxStatic}/jquery-timers/jquery.timers-1.1.2.js"></script>
   	<script type="text/javascript" src="${ctxStatic}/layer/layer.js"></script>
   	<script type="text/javascript" src="${ctxStatic}/web/login.js"></script>
  </body>
</html>
