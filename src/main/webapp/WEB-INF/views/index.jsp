<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="communityImages" value='<%=request.getAttribute("COMMUNITY_IMAGE")%>' />
<!DOCTYPE html>
<html>
<head>
<title>首页</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/pages/index.css' />" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content" style="padding: 0px;">
			<!--幻灯片管理-->
			<div
				style="-webkit-transform: translate3d(0, 0, 0);">
				<div id="banner_box" class="box_swipe" style="visibility: visible;">
					<ul class="text-center" style="margin: 0px;">
						<c:forEach items="${communityImages}" var="imageInfo">
							<li style=""><c:if
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

			<div class="function-page">
				<div class="function-list">
					<div class="function-img">
						<a href="${ctx}/community/service" target="_self"> <img
							src="<c:url value='/assets/img/service.png'/>" alt="" />
						</a>
					</div>
					<div class="function-img">
						<img src="<c:url value='/assets/img/ShoppingMall.png'/>" alt="" />
					</div>
					<div class="clr"></div>
				</div>
				<div class="function-list">
					<div class="function-img">
						<a href="${ctx}/information/consume" target="_self"> <img
							src="<c:url value='/assets/img/message.png'/>" alt="" />
						</a>
					</div>
					<div class="function-img">
						<div class="function-img-top">
							<a href="${ctx}/bbs/boards" target="_self">
								<img src="<c:url value='/assets/img/bbs.png'/>" alt="" />
							</a>
						</div>
						<div class="function-img-bottom">
							<a href="${ctx}/myprofile/myprofile" target="_self"> <img
								src="<c:url value='/assets/img/owner.png'/>" alt="" />
							</a>
						</div>
					</div>
					<div class="clr"></div>
				</div>
			</div>
		</div>

		<script type="text/javascript" src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/assets/scripts/app.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
		<script type="text/javascript" src="<c:url value='/assets/scripts/swipe.js'/>"></script>
		
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
	</div>
</body>
<!-- END BODY -->
</html>
