<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="subsriber" value="${sessionScope.CONTEXT_SUBSCRIBER}" />
<c:set var="communityImages"
	value='<%=request.getAttribute("COMMUNITY_IMAGE")%>' />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<title>物业服务</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/pages/service.css' />" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content" style="padding: 0;">
			<!--幻灯片管理-->
			<div style="-webkit-transform: translate3d(0, 0, 0);">
				<div id="banner_box" class="box_swipe" style="visibility: visible;">
					<ul style="margin:0;">
						<c:forEach items="${communityImages}" var="imageInfo">
							<li style="text-align: center;"><c:if
									test="${empty imageInfo.url || imageInfo.url== ''}">
									<a href="#" onclick="return false;">
								</c:if> <c:if test="${!(empty imageInfo.url || imageInfo.url== '')}">
									<a href="${imageInfo.url}" target="_self">
								</c:if> <img style="max-height: 10em;"
								src="<c:url value='${imageInfo.imageUrl}'/>" alt="" /> </a></li>
						</c:forEach>
					</ul>
					<ol style="margin-bottom: 0;">
						<c:forEach items="${communityImages}" var="imageInfo">
							<li class=""></li>
						</c:forEach>
					</ol>
				</div>
			</div>
			<div class="weimob-page"
				style="display: block; padding-bottom: 56px;margin-top:2%;">
				<!--用户功能模块分类-->
				<div class="service">
					<div class="clr">
						<a href="${ctx}/community/unreadNotice/1"
							class="service-list f-left bg1" target="_self">社区通知栏</a> <a
							href="${ctx}/community/commissions/1"
							class="service-list f-right bg2" target="_self">代办事务请求</a>
						<div class="clr"></div>
					</div>
					<div class="clr margin-top15">
						<a href="${ctx}/community/telephone"
							class="service-list f-left bg3" target="_self">社区常用电话</a> <a
							href="${ctx}/community/complaints/1"
							class="service-list f-left bg4" target="_self">投诉与建议</a>
						<div class="clr"></div>
					</div>
				</div>
				<section>
					<c:if test="${!empty subsriber.community.telePhone}">
						<a href="tel:${subsriber.community.telePhone}" class="link_tel">一键呼叫物业(电话)</a>
					</c:if>
					<c:if test="${!empty subsriber.community.mobilePhone}">
						<a href="tel:${subsriber.community.mobilePhone}" class="link_tel">一键呼叫物业(手机)</a>
					</c:if>
				</section>
			</div>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="${ctx}/index" class="ui-btn ui-btn-inline ui-btn-icon-left ui-icon-back" style="margin: 0.2em; float:left;" target="_self">后 退</a>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/swipe.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/app.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			new Swipe(document.getElementById('banner_box'), {
				speed : 500,
				auto : 3000,
				callback : function() {
					var lis = $(this.element).next("ol").children();
					lis.removeClass("on").eq(this.index).addClass("on");
				}
			});
		});
	</script>
</body>
<!-- END BODY -->
</html>
