
<%@ page contentType="text/html;charset=UTF-8"%>
<%@ taglib prefix="sitemesh" uri="http://www.opensymphony.com/sitemesh/decorator"%>
<!DOCTYPE html>
<html lang="en">
<head>
	<sitemesh:head />
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta http-equiv=Content-Type>
	<title></title>
	<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
	<c:set var="ctx" value="${pageContext.request.contextPath}"/>
	<c:set var="ctxStatic" value="${pageContext.request.contextPath}/resources"/>
	<%-- <script type="text/javascript" src="${ctxStatic}/jquery/jquery-1.9.1.min.js"></script> --%>
	<link href="${ctxStatic}/css/reset.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/public.css" rel="stylesheet" />
	<link href="${ctxStatic}/css/pagination.css" rel="stylesheet" />
	<link href="${ctxStatic}/pace/pace.css" rel="stylesheet" />
	<script type="text/javascript" src="${ctxStatic}/pace/pace.js"></script>
	<!-- 以下两个插件用于在IE8以及以下版本浏览器支持HTML5元素和媒体查询，如果不需要用可以移除 -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
	<script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
	<![endif]-->
	<script type="text/javascript">
		var noTips = "<div id='noData' class='no-data'><p>未查到任何相关信息！</p></div>";
	</script>

	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-formatMoney.js"></script>
	<script type="text/javascript" src="${ctxStatic}/jquery/jquery-include.js"></script>
</head>
<body>
<!--[if lte IE 8]><div style="padding:10px 0;background-color:#fdedd7;">你使用的浏览器版本过低。为了获得更好的浏览体验，我们强烈建议您 到最新版本的IE浏览器，或者使用较新版本的 Chrome、Firefox、Safari等。</div><![endif]-->
	<div class="main">
		<div class="header">
			<div class="header-left"></div>
			<div class="fr">
				<div class="rbox" onclick="logout()" title="退出"><a class="logout-btn" href="javascript: void(0);" ></a></div>
				<div class="rbox" onclick="changePassWord()" title="修改密码"><a class="resetPw-btn" href="javascript: void(0);" ></a></div>
			</div>
		</div>
		<div id="sidebar" class="left">
			<div class="left-header">
				<img class="logo" src="${ctxStatic}/images/logo.png" alt="logo">
			</div>
			<div class="user-contain">
				<div class="user-image">
					<img class="user-img" src="${ctxStatic}/images/1.jpg" alt="用户头像">
					<div class="user-image-border"></div>
					<%-- <div class="user-group">
						<div class="user-info">
							<i class="arrow-left"></i> ${user.roleName}<!--  <i class="arrow-top"> </i>-->
						</div>
						<!-- <div class="user-logout">
							<a href="javascript: logout();"></a>
						</div> -->
					</div> --%>
				</div>
				<div class="user-name">${user.userName}（${user.regionName }）</div>
				<div class="user-name">
					<!-- <a class="user-name" href="javascript:changePassWord()">修改密码</a> -->
				</div>
			</div>
			<div class="nav-menu">
				<ul class="menu">
					<%-- <li class="active"><a href="${ctx}/login/index.html"> <span class="left-ico"></span>
							<span class="right-name">首页</span>
					</a></li> --%>
					<%-- <li><a href="${ctx}/goods/list.html"> <span class="left-ico"></span>
							<span class="right-name">商品管理</span>
					</a></li> --%>
<%-- 					<li><a href="${ctx}/url/contractList.html"> <span class="left-ico"></span>
							<span class="right-name">合同管理</span>
					</a></li> --%>
					<c:forEach items="${menus}" var="menu">
						<c:if test="${menu.pmenuId eq '0'}">
							<li id="${menu.menuId}">
								<a href="${not empty menu.menuUrl ? ctx : 'javascript:;'}${not empty menu.menuUrl ? menu.menuUrl : ''}">
									<span class="left-ico"><i class="ico ${menu.menuIcon}"></i><i class="menu-left-line"></i></span>
									<span class="right-name">${menu.menuName}</span>
									<i class="arrow"></i>
								</a>
								<ul class="child-menu">
								<c:forEach items="${menus}" var="menuChild">
									<c:if test="${menuChild.pmenuId eq menu.menuId}">
										<li id="${menuChild.menuId}">
			                                 <a href="${not empty menuChild.menuUrl ? ctx : 'javascript:;'}${not empty menuChild.menuUrl ? menuChild.menuUrl : ''}">
			                                     <span class="left-ico"></span>
			                                     <span class="right-name">${menuChild.menuName}</span>
			                                 </a>
			                             </li>
									</c:if>
								</c:forEach>
								</ul>
							</li>
						</c:if>
					</c:forEach>
                </ul>
			</div>
		</div>
		<!-- 右侧内容开始 -->
		<sitemesh:body />
		<!-- 右侧内容结束 -->
		
		<div id="modifyPasswd" class="user-add large-input" style="display:none;">
			<table border="0">
				<tr style="height: 15px">
					<td colspan="2" style="text-align:center;color: red" id="message"></td>
				</tr>
			</table>
			<form id="passForm" action="">
				<div class="form-row">
					<label>请输入原密码：</label>
					<input class="input" type="password" name="oldPass" id="oldPass"/>
				</div>
				<div class="form-row">
					<label>请输入新密码：</label>
					<input class="input" type="password" name="newPass" id="newPass"/>
				</div>
				<div class="form-row">
					<label>请再次输入新密码：</label>
					<input class="input" type="password" name="newPass_2" id="newPass_2"/>
				</div>
			</form>
		</div>
		
		
	</div>
	<script src="${ctxStatic}/nicescroll/jquery.nicescroll.js"></script>
	<script type="text/javascript">
            $(function(){
            	$(".menu a").click(function(){
                   var that = $(this);
                   that.parent().addClass("active").siblings().removeClass("active");
                    
                });
                $("#sidebar").niceScroll({styler:"fb",cursorcolor:"#e8403f", cursorwidth: '3', cursorborderradius: '10px', background: '#404040', cursorborder: ''});
                $(".right").niceScroll({styler:"fb",cursorcolor:"#adadb0", cursorwidth: '4', cursorborderradius: '10px', cursorborder: '', zindex: '1000'});
                $(".table>tbody>tr").click(function(){
                    $(this).next('.tr-detail').toggle('slow');
                    $(this).find(".more-view").toggleClass("up");
                });
                $(".menu li").each(function(){
                	var href = $(this).children("a").attr("href");
                	if(href == window.location.pathname){
                		$(this).addClass("active");
                		if($(this).parent(".child-menu").length >0){
                			$(this).parent(".child-menu").parent("li").addClass("active");
                		}
                		return false;
                	}
                });
                $(".menu li").each(function(){
                	if($(this).find(".child-menu>li").length >0){
                		$(this).find(".arrow").addClass("is");
                	}
                });
                
                var tips; 
                $(".user-image").hover(function(){
                	tips = layer.tips('${user.roleName}', '.user-img', {
                		  tips: [2, '#00a651'],
                		  time: 4000
                		});
                },function(){
                	layer.close(tips);
                })
            });
            function logout(){
            	layer.confirm('您确定退出？', {
            		  btn: ['确定','取消'] //按钮
            		}, function(){
            		  window.location.href = '${ctx}/sys/logout.html';
            		});
            }
            
            function changePassWord(){
            	layer.open({
          		  type: 1,
          		  title:"密码修改",
          		  area: ['480px', '299px'], //宽高
          		  btn: ['确定','取消'],
          		  content: $("#modifyPasswd"),
          		  yes:function(){
          			var oldPass = $("#oldPass").val();
                	var newPass = $("#newPass").val();
                	var newPass_2 = $("#newPass_2").val();
                	
          				if (checksysPassWord()) {
	          				$.ajax({
	          					url:  '${ctx}/login/changePassword.ajax',
	          					type: "POST",
	          					dataType:"json",
	          					data:{
	          						oldPass:oldPass,
	          						newPass:newPass
	          					},
	          					success : function (cr) {
	          						if(cr.reType){
	          							layer.msg("修改密码成功!稍候请重新登录......", {icon: 16, shade: 0.10});
	          							setTimeout("window.location.href = '${ctx}/sys/logout.html'", 3000);
	          						}else{
	          							layer.alert(cr.msg);
	          						}
	          					},
	          					error:function(cr){
	          						layer.alert("异常");
	          					}
	          				});
          				}
          		  },
          		  btn2:function(){
          			  layer.closeAll();
          		  },
          		  success:function(){
          			  $('select').selectOrDie();
          		  }
          		});
            }
            
            function checksysPassWord() {
            	var oldPass = $("#oldPass").val();
            	var newPass = $("#newPass").val();
            	var newPass_2 = $("#newPass_2").val();
				var pwd_regex = /^(?![0-9a-z]+$)(?![0-9A-Z]+$)(?![0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)(?![a-z\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)(?![a-zA-Z]+$)(?![A-Z\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]+$)[a-zA-Z0-9\x21-\x2f\x3a-\x40\x5b-\x60\x7b-\x7e]{8,16}$/;
        		if (oldPass == "" || oldPass == null) {
        			$("#message").html("请输入原密码 ");
        			return false;
        		}
        		if (!pwd_regex.test(newPass)) {
        			$("#message").html("新密码必须由8-16位数字+字母+特殊字符组合");

        			return false;
        		}
        		if (newPass != newPass_2) {
        			$("#message").html("密码不一致 请重新输入");
        			return false;
        		}
        		return true;
        	}
    </script>
    <script src="${ctxStatic}/My97DatePicker/WdatePicker.js" type="text/javascript"></script>
    <c:if test="${not empty errors }">
    	<script type="text/javascript">
	    	$(function(){
		            layer.alert('${errors.msg }', {
		            	  icon: 5
		            });
			});
    	</script>
    </c:if>
</body>
</html>
