<%@ page language="java" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:set var="ctx" value="${pageContext.request.contextPath}" />
<c:set var="backUrl" value='<%=request.getAttribute("URL_BACK")%>' />
<c:set var="errMsg" value='<%=request.getAttribute("MSG_ERROR")%>' />
<!DOCTYPE html>
<html>
<head>
<title>${errMsg}</title>
<meta charset="UTF-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.css'/>" />
<link type="text/css" rel="stylesheet" href="<c:url value='/assets/css/public.css' />" />
</head>
<body>
<div role="dialog" class="ui-dialog-contain ui-overlay-shadow ui-corner-all">
		<div data-role="header" role="banner" class="ui-header ui-bar-inherit">
		<c:if test="${!empty backUrl}">
		<a href="${backUrl}" class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-right">Close</a>
		</c:if>
		<c:if test="${empty backUrl}">
		<a href="#" class="ui-btn ui-corner-all ui-icon-delete ui-btn-icon-notext ui-btn-right" data-rel="back">Close</a>
		</c:if>
		<h1 class="ui-title" role="heading" aria-level="1">失败</h1>
		</div>

		<div role="main" class="ui-content">
		<h1 class="text-center"><img src="${ctx}/assets/img/error.png" class="vertical-m m-left" />${errMsg}</h1>
			<c:if test="${!empty backUrl}">
			<a href="${backUrl}" data-rel="back" class="ui-btn ui-shadow ui-corner-all ui-btn-b">后退</a>
			</c:if>
			<c:if test="${empty backUrl}">
			<a href="#"  class="ui-btn ui-shadow ui-corner-all ui-btn-b" data-rel="back">后退</a>
			</c:if>
		</div>
	</div>
	<script type="text/javascript" src="<c:url value='/assets/scripts/jquery-1.10.2.min.js'/>"></script>
	<script type="text/javascript" src="<c:url value='/assets/scripts/app.js'/>"></script>		
	<script type="text/javascript" src="<c:url value='/assets/plugins/jquery.mobile/jquery.mobile-1.4.2.js'/>"></script>
	<script type="text/javascript">
		$(function() {
			App.init();
			App.error('${backUrl}')
		});
	</script>
</body>
<!-- END BODY -->
</html>
