<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="notice" value='<%=request.getAttribute("NOTICE_INFO")%>' />
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8" />
<title>通知内容</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/public.css' />" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/css/pages/noticeDetail.css' />" />
</head>
<body>
	<div data-role="page">
		<div data-role="content" class="ui-content">
			<ul data-role="listview" data-inset="true">
				<li id="title" data-role="list-divider">${notice.notice.title}</li>
				<li id="content"><p>${notice.notice.content}</p></li>
			</ul>
		</div>

		<div data-role="footer" data-position="fixed" data-tap-toggle="false">
			<a href="#" onclick="history.back();"
				class="ui-btn  ui-icon-back ui-btn-icon-left ui-btn-inline" style="margin: 0.2em; float:left;"
				target="_self">后&nbsp;退</a> <a href="#"
				class="pull-right ui-btn ui-mini ui-icon-more ui-btn-icon-left" style="margin: 0.2em; float: right;">更多</a>
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
