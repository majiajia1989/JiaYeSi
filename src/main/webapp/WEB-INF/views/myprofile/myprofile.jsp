<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="user" value='<%=request.getAttribute("CONTEXT_USER_INFO")%>' />
<c:set var="subscriberInfo"
	value='<%=request.getAttribute("CONTEXT_SUBSCRIBER_INFO")%>' />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1" />
<title>我是业主${userInfo.nickname}</title>
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-count-theme="b" data-inset="true">
				<li data-icon="false"><a href="#"><img
						<c:if test="${empty user.headimgurl || user.headimgurl==''}">
						 src="<c:url value='/assets/img/photos.png'/>" 
						 </c:if>
						<c:if test="${!(empty user.headimgurl || user.headimgurl=='')}">
						 src="<c:url value='${user.headimgurl}'/>"
						 </c:if>
						alt="" />
						<h2>${user.nickname}</h2></a></li>
				<li data-icon="false"><a href="#">
						<div class="ui-grid-b" style="margin-bottom: 0.4em;">
							<span>小区:</span><span>${subscriberInfo.communityName}</span>
						</div>
						<div class="ui-grid-b">
							<div class="ui-block-a">
								<span>楼号:</span><span>${subscriberInfo.houseName}</span>
							</div>
							<div class="ui-block-b">
								<span>单元:</span><span>${subscriberInfo.houseUnitName}</span>
							</div>
							<div class="ui-block-c">
								<span>门牌:</span><span>${subscriberInfo.houseRoomName}</span>
							</div>
						</div>
				</a></li>
			</ul>
			<ul data-role="listview" data-count-theme="b" data-inset="true">
				<li><a href="${ctx}/community/unreadNotice/1" target="_self">通知消息</a></li>
				<li style="display: none;"><a href="#" target="_self">我的订单</a></li>
				<li style="display: none;"><a href="#" target="_self">我的购物车</a></li>
				<li><a href="${ctx}/myprofile/editMyprofile" target="_self">完善信息</a></li>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="#" onclick="history.back();"
				class="ui-btn ui-btn-icon-left ui-icon-back" style="margin: 0.2em; float: left;">后&nbsp;退</a>
		</div>
	</div>

	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
		});
	</script>

</body>

<!-- END BODY -->
</html>
