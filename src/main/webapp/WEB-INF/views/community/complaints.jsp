<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>我的投诉与建议</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css'/>" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<ul data-role="listview" data-inset="true">
				<c:forEach items="${complaints}" var="complaintInfo"
					varStatus="idxStatus">
					<li><a
						href="${ctx}/community/complaintDetail/${complaintInfo.id}"
						target="_self" />
						<h2 style="margin-top: 1em;margin-right: 4em;">${complaintInfo.content}</h2>
						<p class="ui-li-aside">
							<strong>${complaintInfo.createTime}</strong>
						</p> </a></li>
				</c:forEach>
			</ul>
		</div>
		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<div data-role="navbar" data-iconpos="left">
				<ul>
					<li><a href="javascript:window.history.back();" target="_self"
						data-icon="back">后退</a></li>
					<li><a href="${ctx}/community/complaint" target="_self"
						data-icon="plus">新建</a></li>
					<c:if test="${!empty PAGE_NEXT}">
						<li><a href="${ctx}/community/complaints/${PAGE_NEXT}"
							target="_self" data-icon="more">更多</a></li>
					</c:if>
					<c:if test="${empty PAGE_NEXT}">
						<li><a href="javascript:App.toast();" data-icon="more"
							target="_self">更 多</a></li>
					</c:if>
				</ul>
			</div>
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
