<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="notices"
	value='<%=request.getAttribute("NOTICE_RECEIVERS")%>' />
<c:set var="page" value='<%=request.getAttribute("PAGE_CURRENT")%>' />
<c:set var="previousPage"
	value='<%=request.getAttribute("PAGE_PREVIOUS")%>' />
<c:set var="nextPage" value='<%=request.getAttribute("PAGE_NEXT")%>' />
<c:set var="fromPage"
	value='<%=request.getAttribute("NOTICE_RETURN_URL")%>' />
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%
	response.setHeader("Cache-Control", "no-store");
	response.setHeader("pragma", "no-cache");
	response.setDateHeader("Expires", 0);
%>
<!DOCTYPE html>
<!--[if IE 8]> <html lang="en" class="ie8 no-js"> <![endif]-->
<!--[if IE 9]> <html lang="en" class="ie9 no-js"> <![endif]-->
<!--[if !IE]><!-->
<html>
<!--<![endif]-->
<!-- BEGIN HEAD -->
<head>
<meta charset="utf-8" />
<title>未读通知</title>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content">
			<div data-role="navbar"  data-iconpos="left">
				<ul>
					<li><a href="${ctx}/community/unreadNotice/1"
						data-role="button" data-icon="mail" class="ui-btn-active ui-state-persist">未读消息</a></li>
					<li><a href="${ctx}/community/readedNotice/1"
						data-role="button" data-icon="readEmail" >已读消息</a></li>
					<li><a href="${ctx}/community/allNotice/1" data-role="button" data-icon="allEmail" >全部消息</a></li>
				</ul>
			</div>
			<ul data-role="listview" data-count-theme="b" data-inset="true"
				style="margin-top: 0;">
				<c:forEach items="${notices}" var="noticeInfo">
					<li><a href="${ctx}/community/noticeDetail/${noticeInfo.id}">
							<h2 style="margin-top:1em; margin-right: 4em;">${noticeInfo.notice.title}</h2>
							<p class="ui-li-aside">
								<strong><fmt:formatDate pattern="yyyy-M-d"
										value="${noticeInfo.sendTime}" type="both" /></strong>
							</p>
					</a></li>
				</c:forEach>
			</ul>
		</div>

		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="#" onclick="history.back();"
				class="ui-btn ui-btn-icon-left ui-icon-back" style="margin: 0.2em; float:left;">后&nbsp;退</a>
			<c:if test="${nextPage > page}">
				<a href="${ctx}/community/unreadNotice/${nextPage}"
					class="pull-right ui-btn ui-icon-more ui-btn-icon-left" style="margin: 0.2em; float: right;">更多</a>
			</c:if>
			<c:if test="${nextPage <= page}">
				<a href="javascript:App.toast();"
					class="pull-right ui-btn ui-icon-more ui-btn-icon-left" style="margin: 0.2em; float: right;">更多</a>
			</c:if>
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
