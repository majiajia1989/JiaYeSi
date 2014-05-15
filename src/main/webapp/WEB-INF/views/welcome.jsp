<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="welcomeImage"
	value='<%=request.getAttribute("WELCOME_IMAGE")%>' />
<!DOCTYPE html>
<html>
<head>
<title>欢迎</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta content="3;url=${ctx}/index" http-equiv="refresh" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/bootstrap/css/bootstrap.min.css'/>" />
<link type="text/css" rel="stylesheet"
	href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.min.css'/>" />
<!-- END THEME STYLES -->
</head>
<!-- BEGIN BODY -->
<body>
	<div data-role="page">
		<div data-role="content" style="padding:0em;">
			<div class="main" style="width: 100%; height: 100%">
				<c:if test="${!empty welcomeImage.imageUrl}">
					<a href="${ctx}/index"> <img
						src="<c:url value='${welcomeImage.imageUrl}'/>" width="100%"
						height="100%" alt="" /></a>
				</c:if>
				<c:if test="${empty welcomeImage.imageUrl}">
			＜jsp:forward page="${ctx}/index" /＞
		</c:if>
			</div>
		</div>
	</div>
	<script type="text/javascript"
		src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript"
		src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
</body>
</html>
